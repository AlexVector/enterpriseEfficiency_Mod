package by.bsuir.diplom.service.excel;

import by.bsuir.diplom.bean.*;
import by.bsuir.diplom.bean.Header;
import by.bsuir.diplom.dao.DaoFactory;
import by.bsuir.diplom.dao.api.*;
import by.bsuir.diplom.dao.exception.DaoException;
import by.bsuir.diplom.dao.utilities.SessionUtil;
import by.bsuir.diplom.service.ServiceException;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Reader extends SessionUtil {
    public void read(String filename) throws ServiceException {
        Workbook workbook = loadWorkbook(filename);
        //processSheet(workbook.getSheet("160921 Ф (0_1_2_4_5_5А_6А_7 (2"));
        processSheet(workbook.getSheetAt(workbook.getActiveSheetIndex()));
    }

    private Workbook loadWorkbook(String filename) throws ServiceException {
        var extension = filename.substring(filename.lastIndexOf(".") + 1).toLowerCase();
        try (FileInputStream file = new FileInputStream(new File(filename))) {
            switch (extension) {
                case "xls":
                    // old format
                    return new HSSFWorkbook(file);
                case "xlsx":
                    // new format
                    return new XSSFWorkbook(file);
                default:
                    throw new ServiceException("Unknown Excel file extension: " + extension);
            }
        } catch (IOException e) {
            throw new ServiceException(e);
        }
    }
    //My mod
    private void processSheet(Sheet sheet) throws ServiceException {
        var data = new HashMap<Integer, List<Object>>();
        var iterator = sheet.rowIterator();

        for (var rowIndex = 0; iterator.hasNext(); rowIndex++) {
            var row = iterator.next();
            processRow(data, rowIndex, row);
        }
        /*
        DataFormatter dataFormatter = new DataFormatter();
        boolean skiprow = false;
        for (var rowIndex = 0; iterator.hasNext(); rowIndex++) {
            var row = iterator.next();
            for (int i=0; i<10; i++){
                System.out.println(dataFormatter.formatCellValue(row.getCell(i)));
                if (dataFormatter.formatCellValue(row.getCell(0)).equals("Наименование периода")){
                    skiprow = true;
                    break;
                }
                else {
                    if (!dataFormatter.formatCellValue(row.getCell(i)).equals("")) skiprow = false;
                    else skiprow = true;
                }

            }
            if (!skiprow)
                processRow(data, rowIndex, row);
        }
        */
    }
    //My mod
    private void processRow(HashMap<Integer, List<Object>> data, int rowIndex, Row row) throws ServiceException {
        data.put(rowIndex, new ArrayList<>());
        for (var cell : row) {
            processCell(cell, data.get(rowIndex));
        }
        if (rowIndex <= 2) {
            writeHeader(data.get(rowIndex));
        } else {
            writeData(data.get(rowIndex));
        }
    }

    private void processCell(Cell cell, List<Object> dataRow) {
        switch (cell.getCellType()) {
            case STRING:
                dataRow.add(cell.getStringCellValue());
                break;
            case NUMERIC:
                if (DateUtil.isCellDateFormatted(cell)) {
                    dataRow.add(cell.getLocalDateTimeCellValue());
                } else {
                    dataRow.add(NumberToTextConverter.toText(cell.getNumericCellValue()));
                }
                break;
            case BOOLEAN:
                dataRow.add(cell.getBooleanCellValue());
                break;
            case FORMULA:
                dataRow.add(cell.getCellFormula());
                break;
            default:
                dataRow.add(null);
        }
    }

    private void writeHeader(List<Object> list) throws ServiceException {
        if (list == null || list.isEmpty()) {
            throw new ServiceException("No info about document header");
        }
        HeaderDao headerDao = DaoFactory.getInstance().getHeaderDao();
        try {
            openTransactionSession();
            headerDao.setSession(getSession());
            Header header = new Header(list.toString());
            headerDao.add(header);
            commitTransactionSession();
        } catch (DaoException e) {
            rollbackTransactionSession();
            throw new ServiceException(e);
        } finally {
            closeSession();
        }
    }

    private void writeData(List<Object> list) throws ServiceException {
        if (list == null || list.isEmpty()) {
            throw new ServiceException("No info about companies");
        }
        DataParser parser = new DataParser();

        CompanyDao companyDao = DaoFactory.getInstance().getCompanyDao();
        CompanyInfoDao companyInfoDao = DaoFactory.getInstance().getCompanyInfoDao();
        AddressDao addressDao = DaoFactory.getInstance().getAddressDao();
        EnterpriseStatisticDao enterpriseStatisticDao = DaoFactory.getInstance().getEnterpriseStatisticDao();
        FixedAssetsDao fixedAssetsDao = DaoFactory.getInstance().getFixedAssetsDao();
        SalesReturnDao salesReturnDao = DaoFactory.getInstance().getSalesReturnDao();
        CoefficientsDao coefficientsDao = DaoFactory.getInstance().getCoefficientsDao();
        StaffDao staffDao = DaoFactory.getInstance().getStaffDao();
        CropProductionDao cropProductionDao = DaoFactory.getInstance().getCropProductionDao();
        ExpensesDao expensesDao = DaoFactory.getInstance().getExpensesDao();
        GroundsDao groundsDao = DaoFactory.getInstance().getGroundsDao();
        DairyProductsDao dairyProductsDao = DaoFactory.getInstance().getDairyProductsDao();
        CattleDao cattleDao = DaoFactory.getInstance().getCattleDao();
        try {
            openTransactionSession();

            companyDao.setSession(getSession());

            companyInfoDao.setSession(getSession());
            addressDao.setSession(getSession());
            enterpriseStatisticDao.setSession(getSession());
            fixedAssetsDao.setSession(getSession());
            salesReturnDao.setSession(getSession());
            coefficientsDao.setSession(getSession());
            staffDao.setSession(getSession());
            cropProductionDao.setSession(getSession());
            expensesDao.setSession(getSession());
            groundsDao.setSession(getSession());
            dairyProductsDao.setSession(getSession());
            cattleDao.setSession(getSession());

            /*
            try {
                Company company = new Company(0, 0, "0", "0", 0, "0", "0");

                companyDao.persist(company);
                System.out.println("-*-" + company.getCom_id() + "-*-");
                Integer companyId = company.getCom_id();

                company = parser.parseCompany(list);
                company.setCom_id(companyId);
                company.setCompanyInfo(parser.parseCompanyInfo(companyId, list));
                company.setAddress(parser.parseAddress(companyId, list));
                company.setEnterpriseStatistics(parser.parseStatistic(companyId, list));
                company.setFixedAssets(parser.parseAssets(companyId, list));
                company.setSalesReturn(parser.parseSales(companyId, list));
                company.setCoefficients(parser.parseCoefficients(companyId, list));
                company.setStaff(parser.parseStaff(companyId, list));
                company.setCropProductions(parser.parseCropProduction(companyId, list));
                company.setExpenses(parser.parseExpenses(companyId, list));
                company.setGrounds(parser.parseGrounds(companyId, list));
                company.setDairyProducts(parser.parseDairyProducts(companyId, list));
                company.setCattle(parser.parseCattle(companyId, list));
                companyDao.update(company);

            }catch (NullPointerException e){
                throw new ServiceException(e);
            }

             */

            Integer id = companyDao.addWithId(parser.parseCompany(list));
            companyInfoDao.add(parser.parseCompanyInfo(id,list));
            addressDao.add(parser.parseAddress(id, list));

            List<EnterpriseStatistic> enterpriseStatisticList = parser.parseStatistic(id, list);
            for (EnterpriseStatistic stat : enterpriseStatisticList) {
                enterpriseStatisticDao.add(stat);
            }
            fixedAssetsDao.add(parser.parseAssets(id, list));
            salesReturnDao.add(parser.parseSales(id, list));
            coefficientsDao.add(parser.parseCoefficients(id, list));

            List<Staff> staffList = parser.parseStaff(id, list);
            for (Staff staff : staffList) {
                staffDao.add(staff);
            }

            List<CropProduction> cropProductionList = parser.parseCropProduction(id, list);
            for (CropProduction production : cropProductionList) {
                cropProductionDao.add(production);
            }
            expensesDao.add(parser.parseExpenses(id, list));
            List<Grounds> groundsList = parser.parseGrounds(id, list);
            for (Grounds ground : groundsList) {
                groundsDao.add(ground);
            }
            dairyProductsDao.add(parser.parseDairyProducts(id, list));
            cattleDao.add(parser.parseCattle(id, list));
            commitTransactionSession();
        } catch (DaoException e) {
            rollbackTransactionSession();
            throw new ServiceException(e);
        } finally {
            closeSession();
        }
    }
}
