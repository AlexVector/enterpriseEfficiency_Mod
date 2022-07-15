package by.bsuir.diplom.service.calc;

import by.bsuir.diplom.bean.*;
import by.bsuir.diplom.service.api.CompanyService;
import by.bsuir.diplom.service.ServiceException;
import by.bsuir.diplom.service.impl.CompanyServiceImpl;
import org.apache.commons.math3.util.Precision;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.Stream;

public class CalcIndicators {

    public List<EnterpriseIndicators> calcIndicators(List<Company> companies) throws ServiceException {
        List<EnterpriseIndicators> list = new ArrayList<>();
        list.add(calcAvgIndicators(companies, 1, 8));
        list.add(calcAvgIndicators(companies, 9, 292));
        list.add(calcAvgIndicators(companies, 293, 870));
        list.add(calcAvgIndicators(companies, 871, 901));
        list.add(calcAvgIndicators(companies, 902, 932));
        return list;
    }

    public Double calcEnterpriseEfficiency(Company company) {
        double value = calcEnterpriseProfit(company) / calcEnterpriseExpenses(company) * 100;
        return Precision.round(value, 2);
    }

    private EnterpriseIndicators calcAvgIndicators(List<Company> list, int begin, int finish) {
        OptionalDouble profitFromSales = createStream(list, begin, finish).mapToDouble(Company::getProfitFromSales).average();
        OptionalDouble netDiscountedValue = createStream(list, begin, finish).mapToDouble(Company::getNetDiscountedValue).average();
        OptionalDouble costRecovery = createStream(list, begin, finish).mapToDouble(Company::getCostRecovery).average();
        OptionalDouble productionProfitability = createStream(list, begin, finish).mapToDouble(Company::getProductionProfitability).average();
        OptionalDouble increasePerEmployed = createStream(list, begin, finish).mapToDouble(Company::getIncreasePerEmployed).average();
        OptionalDouble landGrowth = createStream(list, begin, finish).mapToDouble(Company::getLandGrowth).average();
        if (profitFromSales.isPresent() && netDiscountedValue.isPresent() && costRecovery.isPresent() &&
                productionProfitability.isPresent() && increasePerEmployed.isPresent() && landGrowth.isPresent()) {
            return new EnterpriseIndicators(Precision.round(profitFromSales.getAsDouble(), 2),
                    Precision.round(netDiscountedValue.getAsDouble(), 2),
                    Precision.round(costRecovery.getAsDouble(), 2), Precision.round(productionProfitability.getAsDouble(), 2),
                    Precision.round(increasePerEmployed.getAsDouble(), 2), Precision.round(landGrowth.getAsDouble(), 2));
        } else {
            return null;
        }
    }

    private Stream<Company> createStream(List<Company> list, int begin, int finish) {
        return list.stream().filter(s -> s.getId() >= begin && s.getId() <= finish);
    }

    private double calcEnterpriseProfit(Company company) {
        double profit = company.getFixedAssets().getProfit() == null ? 0 : company.getFixedAssets().getProfit();
        double enterpriseProfit = (company.getFixedAssets().getSalesRevenue() + profit) * 1000;
        for (CropProduction cropProduction : company.getCropProductions()) {
            if (cropProduction.getBailedOut() != null) {
                enterpriseProfit += cropProduction.getBailedOut() * 1000;
            }
        }
        if (company.getDairyProducts().getOutputDairyProducts() != null) {
            enterpriseProfit += company.getDairyProducts().getOutputDairyProducts() * company.getDairyProducts().getCostDairyProducts();
        }
        if (company.getDairyProducts().getProductionGrowth() != null) {
            enterpriseProfit += company.getDairyProducts().getProductionGrowth() * company.getDairyProducts().getProductionCostGrowth();
        }
        for (Grounds grounds : company.getGrounds()) {
            if (grounds.getTotalProducts() != null) {
                enterpriseProfit += grounds.getTotalProducts() * grounds.getProductionCost();
            }
        }
        return enterpriseProfit;
    }

    private double calcEnterpriseExpenses(Company company) {
        double feed = company.getExpenses().getFeed() == null ? 0 : company.getExpenses().getFeed();
        double purchasedFeed = company.getExpenses().getPurchasedFeed() == null ? 0 : company.getExpenses().getPurchasedFeed();
        double depreciation = company.getExpenses().getDeprecation() == null ? 0 : company.getExpenses().getDeprecation();
        double insurancePayments = company.getExpenses().getInsurancePayments() == null ? 0 : company.getExpenses().getInsurancePayments();
        double otherCosts = company.getExpenses().getOtherCosts() == null ? 0 : company.getExpenses().getOtherCosts();
        double plantingCosts = company.getExpenses().getPlantingCosts() == null ? 0 : company.getExpenses().getPlantingCosts();
        double currentDividendPayments = company.getSalesReturn().getCurrentDividendPayments() == null ? 0 : company.getSalesReturn().getCurrentDividendPayments();
        double expenses = (company.getExpenses().getLaborCost() + company.getExpenses().getMaterialCosts() +
                feed + purchasedFeed + depreciation + insurancePayments + otherCosts +
                company.getExpenses().getTotalCosts() + plantingCosts + currentDividendPayments) * 1000;
        for (Staff staff : company.getStaff()) {
            if (staff.getSalaryFund() != null) {
                expenses += staff.getSalaryFund() * 1000;
            }
        }
        return expenses;
    }
}
