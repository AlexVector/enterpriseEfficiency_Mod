package by.bsuir.diplom.controller.command.impl;

import by.bsuir.diplom.bean.Company;
import by.bsuir.diplom.bean.CropProduction;
import by.bsuir.diplom.bean.Grounds;
import by.bsuir.diplom.bean.Staff;
import by.bsuir.diplom.dao.DaoFactory;
import by.bsuir.diplom.dao.api.CompanyDao;
import by.bsuir.diplom.dao.exception.DaoException;
import by.bsuir.diplom.dao.utilities.SessionUtil;
import by.bsuir.diplom.service.ServiceException;
import by.bsuir.diplom.service.ServiceProvider;
import by.bsuir.diplom.service.api.CompanyService;
import by.bsuir.diplom.service.api.CropProductionService;
import by.bsuir.diplom.service.api.GroundsService;
import by.bsuir.diplom.service.api.StaffService;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;

import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.List;

public class ExportTemplate extends SessionUtil {

    public void export(List<Company> toExport, HttpServletResponse response) throws IOException {
        FileInputStream fis = new FileInputStream("C:\\Users\\USER\\Desktop\\proj\\enterpriseEfficiency\\template.xls");
        Workbook wb = new HSSFWorkbook(fis);

        List<Staff> staffList = null;
        List<CropProduction> cropprodList = null;
        List<Grounds> groundsList = null;
        ServiceProvider provider = ServiceProvider.getInstance();
        StaffService staffService = provider.getStaffService();
        CropProductionService cropProductionService = provider.getCropProductionService();
        GroundsService groundsService = provider.getGroundsService();

        for (int i = 0; i<toExport.size(); i++){
            if (toExport.get(i).getPeriod()!=null)
                wb.getSheetAt(0).getRow(i+3).getCell(0).setCellValue(toExport.get(i).getPeriod());
            if (toExport.get(i).getYear()!=null)
                wb.getSheetAt(0).getRow(i+3).getCell(1).setCellValue(toExport.get(i).getYear());
            if (toExport.get(i).getName()!=null)
                wb.getSheetAt(0).getRow(i+3).getCell(2).setCellValue(toExport.get(i).getName());
            if (toExport.get(i).getFullName()!=null)
                wb.getSheetAt(0).getRow(i+3).getCell(3).setCellValue(toExport.get(i).getFullName());
            if (toExport.get(i).getOkpo()!=null)
                wb.getSheetAt(0).getRow(i+3).getCell(4).setCellValue(toExport.get(i).getOkpo());
            if (toExport.get(i).getAddress().getLocation()!=null)
                wb.getSheetAt(0).getRow(i+3).getCell(5).setCellValue(toExport.get(i).getAddress().getLocation());
            if (toExport.get(i).getYnn()!=null)
                wb.getSheetAt(0).getRow(i+3).getCell(6).setCellValue(toExport.get(i).getYnn());
            if (toExport.get(i).getActivityType()!=null)
                wb.getSheetAt(0).getRow(i+3).getCell(7).setCellValue(toExport.get(i).getActivityType());
            if (toExport.get(i).getAddress().getDistrict()!=null)
                wb.getSheetAt(0).getRow(i+3).getCell(8).setCellValue(toExport.get(i).getAddress().getDistrict());
            if (toExport.get(i).getAddress().getArea()!=null)
                wb.getSheetAt(0).getRow(i+3).getCell(9).setCellValue(toExport.get(i).getAddress().getArea());
            if (toExport.get(i).getCompanyInfo().getIndustryCode()!=null)
                wb.getSheetAt(0).getRow(i+3).getCell(10).setCellValue(toExport.get(i).getCompanyInfo().getIndustryCode());
            if (toExport.get(i).getCompanyInfo().getIndustryName()!=null)
                wb.getSheetAt(0).getRow(i+3).getCell(11).setCellValue(toExport.get(i).getCompanyInfo().getIndustryName());
            if (toExport.get(i).getCompanyInfo().getDepartmentName()!=null)
                wb.getSheetAt(0).getRow(i+3).getCell(12).setCellValue(toExport.get(i).getCompanyInfo().getDepartmentName());
            if (toExport.get(i).getCompanyInfo().getAssociationName()!=null)
                wb.getSheetAt(0).getRow(i+3).getCell(13).setCellValue(toExport.get(i).getCompanyInfo().getAssociationName());
            if (toExport.get(i).getCompanyInfo().getOwnershipType()!=null)
                wb.getSheetAt(0).getRow(i+3).getCell(14).setCellValue(toExport.get(i).getCompanyInfo().getOwnershipType());


            //if (toExport.get(i).getPeriod()!=null)
            wb.getSheetAt(0).getRow(i+3).getCell(15).setCellValue("1");
            //if (toExport.get(i).getPeriod()!=null)
            wb.getSheetAt(0).getRow(i+3).getCell(16).setCellValue("");
            //if (toExport.get(i).getPeriod()!=null)
            wb.getSheetAt(0).getRow(i+3).getCell(17).setCellValue("");
            //if (toExport.get(i).getPeriod()!=null)
            wb.getSheetAt(0).getRow(i+3).getCell(18).setCellValue("1");
            //if (toExport.get(i).getPeriod()!=null)
            wb.getSheetAt(0).getRow(i+3).getCell(19).setCellValue("");
            //20-86


            if (toExport.get(i).getFixedAssets().getFixedAssets()!=null)
                wb.getSheetAt(0).getRow(i+3).getCell(87).setCellValue(toExport.get(i).getFixedAssets().getFixedAssets());
            if (toExport.get(i).getFixedAssets().getLoansBorrowings()!=null)
                wb.getSheetAt(0).getRow(i+3).getCell(88).setCellValue(toExport.get(i).getFixedAssets().getLoansBorrowings());
            if (toExport.get(i).getFixedAssets().getTotal4()!=null)
                wb.getSheetAt(0).getRow(i+3).getCell(89).setCellValue(toExport.get(i).getFixedAssets().getTotal4());
            if (toExport.get(i).getFixedAssets().getShorttermDebt()!=null)
                wb.getSheetAt(0).getRow(i+3).getCell(90).setCellValue(toExport.get(i).getFixedAssets().getShorttermDebt());
            if (toExport.get(i).getFixedAssets().getTotal5()!=null)
                wb.getSheetAt(0).getRow(i+3).getCell(91).setCellValue(toExport.get(i).getFixedAssets().getTotal5());
            if (toExport.get(i).getFixedAssets().getSalesRevenue()!=null)
                wb.getSheetAt(0).getRow(i+3).getCell(92).setCellValue(toExport.get(i).getFixedAssets().getSalesRevenue());
            if (toExport.get(i).getFixedAssets().getProfit()!=null)
                wb.getSheetAt(0).getRow(i+3).getCell(93).setCellValue(toExport.get(i).getFixedAssets().getProfit());
            if (toExport.get(i).getSalesReturn().getSales()!=null)
                wb.getSheetAt(0).getRow(i+3).getCell(94).setCellValue(toExport.get(i).getSalesReturn().getSales());
            if (toExport.get(i).getSalesReturn().getCurrentDividendPayments()!=null)
                wb.getSheetAt(0).getRow(i+3).getCell(95).setCellValue(toExport.get(i).getSalesReturn().getCurrentDividendPayments());
            if (toExport.get(i).getSalesReturn().getPrevDividendPayments()!=null)
                wb.getSheetAt(0).getRow(i+3).getCell(96).setCellValue(toExport.get(i).getSalesReturn().getPrevDividendPayments());
            if (toExport.get(i).getSalesReturn().getTotalEndDebt()!=null)
                wb.getSheetAt(0).getRow(i+3).getCell(97).setCellValue(toExport.get(i).getSalesReturn().getTotalEndDebt());
            if (toExport.get(i).getSalesReturn().getOverdueEndDebt()!=null)
                wb.getSheetAt(0).getRow(i+3).getCell(98).setCellValue(toExport.get(i).getSalesReturn().getOverdueEndDebt());
            if (toExport.get(i).getSalesReturn().getTotalBeginDebt()!=null)
                wb.getSheetAt(0).getRow(i+3).getCell(99).setCellValue(toExport.get(i).getSalesReturn().getTotalBeginDebt());
            if (toExport.get(i).getSalesReturn().getOverdueBeginDebt()!=null)
                wb.getSheetAt(0).getRow(i+3).getCell(100).setCellValue(toExport.get(i).getSalesReturn().getOverdueBeginDebt());
            if (toExport.get(i).getCoefficients().getOwnSecurity()!=null)
                wb.getSheetAt(0).getRow(i+3).getCell(101).setCellValue(toExport.get(i).getCoefficients().getOwnSecurity());
            if (toExport.get(i).getCoefficients().getCurrentLiquidity()!=null)
                wb.getSheetAt(0).getRow(i+3).getCell(102).setCellValue(toExport.get(i).getCoefficients().getCurrentLiquidity());
            if (toExport.get(i).getCoefficients().getFinancialSecurity()!=null)
                wb.getSheetAt(0).getRow(i+3).getCell(103).setCellValue(toExport.get(i).getCoefficients().getFinancialSecurity());
            if (toExport.get(i).getCoefficients().getAbsoluteLiquidity()!=null)
                wb.getSheetAt(0).getRow(i+3).getCell(104).setCellValue(toExport.get(i).getCoefficients().getAbsoluteLiquidity());
            if (toExport.get(i).getCoefficients().getEndNetAssets()!=null)
                wb.getSheetAt(0).getRow(i+3).getCell(105).setCellValue(toExport.get(i).getCoefficients().getEndNetAssets());
            if (toExport.get(i).getCoefficients().getBeginNetAssets()!=null)
                wb.getSheetAt(0).getRow(i+3).getCell(106).setCellValue(toExport.get(i).getCoefficients().getBeginNetAssets());


            Integer staffCells = null;
            try {
                staffList = staffService.getStaffToExport(toExport.get(i).getYnn());
            } catch (ServiceException e) {e.printStackTrace();}
            staffCells = staffList.get(0).getIndex();
            if (staffCells==null)
                staffCells = 107;
            for (Staff staff: staffList){
                if (staff.getAverageNumber()!=null)
                    wb.getSheetAt(0).getRow(i+3).getCell(staffCells).setCellValue(staff.getAverageNumber());
                if (staff.getSalaryFund()!=null)
                    wb.getSheetAt(0).getRow(i+3).getCell(staffCells+1).setCellValue(staff.getSalaryFund());
                staffCells+=2;
            }

            if (toExport.get(i).getCoefficients().getProfitability()!=null)
                wb.getSheetAt(0).getRow(i+3).getCell(119).setCellValue(toExport.get(i).getCoefficients().getProfitability());
            if (toExport.get(i).getCoefficients().getProfitabilityWithoutSupport()!=null)
                wb.getSheetAt(0).getRow(i+3).getCell(120).setCellValue(toExport.get(i).getCoefficients().getProfitabilityWithoutSupport());


            try {
                cropprodList = cropProductionService.getCropProductionToExport(toExport.get(i).getYnn());
            } catch (ServiceException e) {e.printStackTrace();}
            Integer cropProdCells = cropprodList.get(0).getIndex();

            for (CropProduction cropProduction: cropprodList){
                if (cropProduction.getFullCostPrice()!=null)
                    wb.getSheetAt(0).getRow(i+3).getCell(cropProdCells).setCellValue(cropProduction.getFullCostPrice());
                if (cropProduction.getBailedOut()!=null)
                    wb.getSheetAt(0).getRow(i+3).getCell(cropProdCells+1).setCellValue(cropProduction.getBailedOut());
                cropProdCells+=2;
            }


            if (toExport.get(i).getExpenses().getLaborCost()!=null)
                wb.getSheetAt(0).getRow(i+3).getCell(131).setCellValue(toExport.get(i).getExpenses().getLaborCost());
            if (toExport.get(i).getExpenses().getMaterialCosts()!=null)
                wb.getSheetAt(0).getRow(i+3).getCell(132).setCellValue(toExport.get(i).getExpenses().getMaterialCosts());
            if (toExport.get(i).getExpenses().getFeed()!=null)
                wb.getSheetAt(0).getRow(i+3).getCell(133).setCellValue(toExport.get(i).getExpenses().getFeed());
            if (toExport.get(i).getExpenses().getPurchasedFeed()!=null)
                wb.getSheetAt(0).getRow(i+3).getCell(134).setCellValue(toExport.get(i).getExpenses().getPurchasedFeed());
            if (toExport.get(i).getExpenses().getDeprecation()!=null)
                wb.getSheetAt(0).getRow(i+3).getCell(135).setCellValue(toExport.get(i).getExpenses().getDeprecation());
            if (toExport.get(i).getExpenses().getInsurancePayments()!=null)
                wb.getSheetAt(0).getRow(i+3).getCell(136).setCellValue(toExport.get(i).getExpenses().getInsurancePayments());
            if (toExport.get(i).getExpenses().getOtherCosts()!=null)
                wb.getSheetAt(0).getRow(i+3).getCell(137).setCellValue(toExport.get(i).getExpenses().getOtherCosts());
            if (toExport.get(i).getExpenses().getTotalCosts()!=null)
                wb.getSheetAt(0).getRow(i+3).getCell(138).setCellValue(toExport.get(i).getExpenses().getTotalCosts());
            if (toExport.get(i).getExpenses().getPlantingCosts()!=null)
                wb.getSheetAt(0).getRow(i+3).getCell(139).setCellValue(toExport.get(i).getExpenses().getPlantingCosts());


            Integer groundsProdCells = null;
            Integer groundsHectareCells = null;
            try {
                groundsList = groundsService.getGroundsToExport(toExport.get(i).getYnn());
            } catch (ServiceException e) {e.printStackTrace();}
            groundsProdCells = groundsList.get(0).getProductsIndex();
            groundsHectareCells = groundsList.get(0).getHectareIndex();
            if (groundsProdCells==null)
                groundsProdCells = 140;
            if (groundsHectareCells==null)
                groundsHectareCells = 146;
            for (Grounds grounds: groundsList){
                if (grounds.getTotalProducts()!=null)
                    wb.getSheetAt(0).getRow(i+3).getCell(groundsProdCells).setCellValue(grounds.getTotalProducts());
                if (grounds.getHectareProducts()!=null)
                    wb.getSheetAt(0).getRow(i+3).getCell(groundsProdCells+1).setCellValue(grounds.getHectareProducts());
                if (grounds.getProductionCost()!=null)
                    wb.getSheetAt(0).getRow(i+3).getCell(groundsProdCells+2).setCellValue(grounds.getProductionCost());
                groundsProdCells += 3;
            }
            for (Grounds grounds: groundsList){
                if (grounds.getHectare()!=null)
                    wb.getSheetAt(0).getRow(i+3).getCell(groundsHectareCells).setCellValue(grounds.getHectare());
                if (grounds.getBallogectars()!=null)
                    wb.getSheetAt(0).getRow(i+3).getCell(groundsHectareCells+1).setCellValue(grounds.getBallogectars());
                groundsHectareCells += 2;
            }

            //wb.getSheetAt(0).getRow(i+3).getCell(140).setCellValue(toExport.get(i).getGrounds().get(0).getTotalProducts());
            /*
            wb.getSheetAt(0).getRow(i+3).getCell(140).setCellValue(toExport.get(i).get);
            wb.getSheetAt(0).getRow(i+3).getCell(141).setCellValue(toExport.get(i).get);
            wb.getSheetAt(0).getRow(i+3).getCell(142).setCellValue(toExport.get(i).get);
            wb.getSheetAt(0).getRow(i+3).getCell(143).setCellValue(toExport.get(i).get);
            wb.getSheetAt(0).getRow(i+3).getCell(144).setCellValue(toExport.get(i).get);
            wb.getSheetAt(0).getRow(i+3).getCell(145).setCellValue(toExport.get(i).get);
            wb.getSheetAt(0).getRow(i+3).getCell(146).setCellValue(toExport.get(i).get);
            wb.getSheetAt(0).getRow(i+3).getCell(147).setCellValue(toExport.get(i).get);
            wb.getSheetAt(0).getRow(i+3).getCell(148).setCellValue(toExport.get(i).get);
            wb.getSheetAt(0).getRow(i+3).getCell(149).setCellValue(toExport.get(i).get);

             */
            if (toExport.get(i).getDairyProducts().getCattle()!=null)
                wb.getSheetAt(0).getRow(i+3).getCell(150).setCellValue(toExport.get(i).getDairyProducts().getCattle());
            if (toExport.get(i).getDairyProducts().getOutputDairyProducts()!=null)
                wb.getSheetAt(0).getRow(i+3).getCell(151).setCellValue(toExport.get(i).getDairyProducts().getOutputDairyProducts());
            if (toExport.get(i).getDairyProducts().getCostDairyProducts()!=null)
                wb.getSheetAt(0).getRow(i+3).getCell(152).setCellValue(toExport.get(i).getDairyProducts().getCostDairyProducts());
            if (toExport.get(i).getDairyProducts().getProductionGrowth()!=null)
                wb.getSheetAt(0).getRow(i+3).getCell(153).setCellValue(toExport.get(i).getDairyProducts().getProductionGrowth());
            if (toExport.get(i).getDairyProducts().getProductionCostGrowth()!=null)
                wb.getSheetAt(0).getRow(i+3).getCell(154).setCellValue(toExport.get(i).getDairyProducts().getProductionCostGrowth());
            if (toExport.get(i).getCattle().getMilkYield()!=null)
                wb.getSheetAt(0).getRow(i+3).getCell(155).setCellValue(toExport.get(i).getCattle().getMilkYield());
            if (toExport.get(i).getCattle().getAverageDailyIncrease()!=null)
                wb.getSheetAt(0).getRow(i+3).getCell(156).setCellValue(toExport.get(i).getCattle().getAverageDailyIncrease());
            if (toExport.get(i).getCattle().getCattleProducers()!=null)
                wb.getSheetAt(0).getRow(i+3).getCell(157).setCellValue(toExport.get(i).getCattle().getCattleProducers());
            if (toExport.get(i).getCattle().getCattleCultivation()!=null)
                wb.getSheetAt(0).getRow(i+3).getCell(158).setCellValue(toExport.get(i).getCattle().getCattleCultivation());
            if (toExport.get(i).getCattle().getCurrentEndBalance()!=null)
                wb.getSheetAt(0).getRow(i+3).getCell(159).setCellValue(toExport.get(i).getCattle().getCurrentEndBalance());
            if (toExport.get(i).getCattle().getPrevEndBalance()!=null)
                wb.getSheetAt(0).getRow(i+3).getCell(160).setCellValue(toExport.get(i).getCattle().getPrevEndBalance());

        }

        response.setHeader("Content-Disposition", "inline;filename=\"" + URLEncoder.encode("output.xls", "UTF-8") + "\"");
        response.setContentType("application/xls");
        OutputStream outputStream = response.getOutputStream();
        wb.write(outputStream);
        outputStream.flush();
        outputStream.close();
        wb.close();
    }
}
