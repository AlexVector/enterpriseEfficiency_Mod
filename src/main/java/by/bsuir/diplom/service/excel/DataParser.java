package by.bsuir.diplom.service.excel;

import by.bsuir.diplom.bean.*;
import by.bsuir.diplom.service.ServiceException;

import java.util.ArrayList;
import java.util.List;

public class DataParser {

    public Company parseCompany(List<Object> list) throws ServiceException {
        try {
            Integer ynn = Integer.valueOf(list.get(6).toString());
            Integer okpo = Integer.valueOf(list.get(4).toString());
            String name = String.valueOf(list.get(2));
            String fullName = String.valueOf(list.get(3));
            Integer year = Integer.valueOf(list.get(1).toString());
            String period = String.valueOf(list.get(0));
            String activityType = String.valueOf(list.get(7));
            return new Company(ynn, okpo, name, fullName, year, period, activityType);
        } catch (NumberFormatException e) {
            throw new ServiceException(e);
        }
    }

    public CompanyInfo parseCompanyInfo(List<Object> list) throws ServiceException {
        try {
            Integer ynn = Integer.valueOf(list.get(6).toString());
            Integer code = Integer.valueOf(list.get(10).toString());
            String industryName = String.valueOf(list.get(11));
            String departmentName = String.valueOf(list.get(12));
            String associationName = String.valueOf(list.get(13));
            String ownershipType = String.valueOf(list.get(14));
            return new CompanyInfo(ynn, code, industryName, departmentName, associationName, ownershipType);
        } catch (NumberFormatException e) {
            throw new ServiceException(e);
        }
    }

    public Address parseAddress(List<Object> list) throws ServiceException {
        try {
            Integer ynn = Integer.valueOf(list.get(6).toString());
            String area = String.valueOf(list.get(9));
            String district = String.valueOf(list.get(8));
            Address address = new Address(ynn, area, district);
            address.setLocation(checkStr(list.get(5)));
            return address;
        } catch (NumberFormatException e) {
            throw new ServiceException(e);
        }
    }

    public List<EnterpriseStatistic> parseStatistic(List<Object> list) throws ServiceException {
        try {
            Integer ynn = Integer.valueOf(list.get(6).toString());
            List<EnterpriseStatistic> statistics = new ArrayList<>();
            for (int i = 15; i < 87; i += 3) {
                if (list.get(i) != null) {
                    EnterpriseStatistic statistic = new EnterpriseStatistic(ynn, i);
                    statistic.setNumberOfEnterprises(Integer.valueOf(list.get(i).toString()));
                    statistic.setAmountAuthorizedCapital(checkInt(list.get(i + 1)));
                    statistic.setShareStateOwnership(checkInt(list.get(i + 2)));
                    statistics.add(statistic);
                }
            }
            return statistics;
        } catch (NumberFormatException e) {
            throw new ServiceException(e);
        }
    }

    public FixedAssets parseAssets(List<Object> list) throws ServiceException {
        try {
            Integer ynn = Integer.valueOf(list.get(6).toString());
            Integer debt = Integer.valueOf(list.get(90).toString());
            Integer total5 = Integer.valueOf(list.get(91).toString());
            Integer sales = Integer.valueOf(list.get(92).toString());
            FixedAssets fixedAssets = new FixedAssets(ynn, debt, total5, sales);
            fixedAssets.setFixedAssets(checkInt(list.get(87)));
            fixedAssets.setLoansBorrowings(checkInt(list.get(88)));
            fixedAssets.setTotal4(checkInt(list.get(89)));
            fixedAssets.setProfit(checkInt(list.get(93)));
            return fixedAssets;
        } catch (NumberFormatException e) {
            throw new ServiceException(e);
        }
    }

    public SalesReturn parseSales(List<Object> list) throws ServiceException {
        try {
            Integer ynn = Integer.valueOf(list.get(6).toString());
            Integer totalEnd = Integer.valueOf(list.get(97).toString());
            SalesReturn salesReturn = new SalesReturn(ynn, totalEnd);
            salesReturn.setSales(checkDouble(list.get(94)));
            salesReturn.setCurrentDividendPayments(checkInt(list.get(95)));
            salesReturn.setPrevDividendPayments(checkInt(list.get(96)));
            salesReturn.setOverdueEndDebt(checkInt(list.get(98)));
            salesReturn.setTotalBeginDebt(checkInt(list.get(99)));
            salesReturn.setOverdueBeginDebt(checkInt(list.get(100)));
            return salesReturn;
        } catch (NumberFormatException e) {
            throw new ServiceException(e);
        }
    }

    public Coefficients parseCoefficients(List<Object> list) throws ServiceException {
        try {
            Integer ynn = Integer.valueOf(list.get(6).toString());
            Double ownSecurity = Double.parseDouble(list.get(101).toString().replace(',', '.'));
            Double currentLiquidity = Double.parseDouble(list.get(102).toString().replace(',', '.'));
            Double financialSecurity = Double.parseDouble(list.get(103).toString().replace(',', '.'));
            Integer endNetAssets = Integer.valueOf(list.get(105).toString());
            Coefficients coefficients = new Coefficients(ynn, ownSecurity, currentLiquidity, financialSecurity,  endNetAssets);
            coefficients.setAbsoluteLiquidity(checkDouble(list.get(104)));
            coefficients.setProfitability(checkDouble(list.get(119)));
            coefficients.setProfitabilityWithoutSupport(checkDouble(list.get(120)));
            coefficients.setBeginNetAssets(checkInt(list.get(106)));
            return coefficients;
        } catch (NumberFormatException e) {
            throw new ServiceException(e);
        }
    }

    public List<Staff> parseStaff(List<Object> list) throws ServiceException {
        try {
            Integer ynn = Integer.valueOf(list.get(6).toString());
            List<Staff> staffList = new ArrayList<>();
            for (int i = 107; i < 119; i += 2) {
                if (list.get(i) != null || list.get(i + 1) != null) {
                    Staff staff = new Staff(ynn, i);
                    staff.setAverageNumber(checkInt(list.get(i)));
                    staff.setSalaryFund(checkDouble(list.get(i + 1)));
                    staffList.add(staff);
                }
            }
            return staffList;
        } catch (NumberFormatException e) {
            throw new ServiceException(e);
        }
    }

    public List<CropProduction> parseCropProduction(List<Object> list) throws ServiceException {
        try {
            Integer ynn = Integer.valueOf(list.get(6).toString());
            List<CropProduction> cropProductions = new ArrayList<>();
            for (int i = 121; i < 131; i += 2) {
                if (list.get(i) != null) {
                    CropProduction cropProduction = new CropProduction(ynn, i);
                    cropProduction.setFullCostPrice(checkDouble(list.get(i)));
                    cropProduction.setBailedOut(checkDouble(list.get(i + 1)));
                    cropProductions.add(cropProduction);
                }
            }
            return cropProductions;
        } catch (NumberFormatException e) {
            throw new ServiceException(e);
        }
    }

    public Expenses parseExpenses(List<Object> list) throws ServiceException {
        try {
            Integer ynn = Integer.valueOf(list.get(6).toString());
            Integer laborCost = Integer.valueOf(list.get(131).toString());
            Integer materialCosts = Integer.valueOf(list.get(132).toString());
            Integer totalCosts = Integer.valueOf(list.get(138).toString());
            Expenses expenses = new Expenses(ynn, laborCost, materialCosts, totalCosts);
            expenses.setFeed(checkInt(list.get(133)));
            expenses.setPurchasedFeed(checkInt(list.get(134)));
            expenses.setDeprecation(checkInt(list.get(135)));
            expenses.setInsurancePayments(checkInt(list.get(136)));
            expenses.setOtherCosts(checkInt(list.get(137)));
            expenses.setPlantingCosts(checkInt(list.get(139)));
            return expenses;
        } catch (NumberFormatException e) {
            throw new ServiceException(e);
        }
    }

    public List<Grounds> parseGrounds(List<Object> list) throws ServiceException {
        try {
            Integer ynn = Integer.valueOf(list.get(6).toString());
            List<Grounds> grounds = new ArrayList<>();
            for (int i = 140; i < 146; i += 3) {
                Grounds ground = new Grounds(ynn);
                ground.setProductsIndex(i);
                ground.setTotalProducts(checkDouble(list.get(i)));
                ground.setHectareProducts(checkDouble(list.get(i + 1)));
                ground.setProductionCost(checkDouble(list.get(i + 2)));
                grounds.add(ground);
            }
            for (int i = 146, y = 0; i < 150; i += 2, y++) {
                grounds.get(y).setHectareIndex(i);
                grounds.get(y).setHectare(Double.valueOf(list.get(i).toString()));
                grounds.get(y).setBallogectars(checkDouble(list.get(i + 1)));
            }
            return grounds;
        } catch (NumberFormatException e) {
            throw new ServiceException(e);
        }
    }

    public DairyProducts parseDairyProducts(List<Object> list) throws ServiceException {
        try {
            Integer ynn = Integer.valueOf(list.get(6).toString());
            DairyProducts dairyProducts = new DairyProducts(ynn);
            dairyProducts.setCattle(checkDouble(list.get(150)));
            dairyProducts.setOutputDairyProducts(checkDouble(list.get(151)));
            dairyProducts.setCostDairyProducts(checkInt(list.get(152)));
            dairyProducts.setProductionGrowth(checkDouble(list.get(153)));
            dairyProducts.setProductionCostGrowth(checkInt(list.get(154)));
            return dairyProducts;
        } catch (NumberFormatException e) {
            throw new ServiceException(e);
        }
    }

    public Cattle parseCattle(List<Object> list) throws ServiceException {
        try {
            Integer ynn = Integer.valueOf(list.get(6).toString());
            Integer currentEndBalance = Integer.valueOf(list.get(159).toString());
            Cattle cattle = new Cattle(ynn, currentEndBalance);
            cattle.setMilkYield(checkInt(list.get(155)));
            cattle.setAverageDailyIncrease(checkInt(list.get(156)));
            cattle.setCattleProducers(checkInt(list.get(157)));
            cattle.setCattleCultivation(checkInt(list.get(158)));
            cattle.setPrevEndBalance(checkInt(list.get(160)));
            return cattle;
        } catch (NumberFormatException e) {
            throw new ServiceException(e);
        }
    }

    private Integer checkInt(Object obj) {
        if (obj != null) {
            return Integer.valueOf(obj.toString());
        } else {
            return null;
        }
    }

    private String checkStr(Object obj) {
        if (obj != null) {
            return String.valueOf(obj.toString());
        } else {
            return null;
        }
    }

    private Double checkDouble(Object obj) {
        if (obj != null) {
            return Double.valueOf(obj.toString().replace(',', '.'));
        } else {
            return null;
        }
    }
}
