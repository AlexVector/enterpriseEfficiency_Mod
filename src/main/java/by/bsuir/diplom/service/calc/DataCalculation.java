package by.bsuir.diplom.service.calc;

import by.bsuir.diplom.bean.Company;
import by.bsuir.diplom.bean.Correlation;
import by.bsuir.diplom.bean.CropProduction;
import by.bsuir.diplom.dao.DaoFactory;
import by.bsuir.diplom.dao.api.CropProductionDao;
import by.bsuir.diplom.dao.exception.DaoException;
import by.bsuir.diplom.dao.utilities.SessionUtil;
import by.bsuir.diplom.service.ServiceException;
import by.bsuir.diplom.service.api.CorrelationService;
import by.bsuir.diplom.service.impl.CorrelationServiceImpl;
import org.apache.commons.math3.util.Precision;

import java.util.ArrayList;
import java.util.List;

public class DataCalculation extends SessionUtil {
    public void calcIndicators(Company company) throws ServiceException {
        CropProduction cropProduction;
        CropProductionDao cropProductionDao = DaoFactory.getInstance().getCropProductionDao();
        try {
            openTransactionSession();
            cropProductionDao.setSession(getSession());
            cropProduction = cropProductionDao.getIndicators(company.getYnn());
            commitTransactionSession();
        } catch (DaoException e) {
            rollbackTransactionSession();
            throw new ServiceException(e);
        } finally {
            closeSession();
        }

        int deprecation = (company.getExpenses().getDeprecation() == null) ? 0 : company.getExpenses().getDeprecation();
        int insurancePayments = (company.getExpenses().getInsurancePayments() == null) ? 0 : company.getExpenses().getInsurancePayments();
        int totalBeginDebt = (company.getSalesReturn().getTotalBeginDebt() == null) ? 0 : company.getSalesReturn().getTotalBeginDebt();

        double profitFromSales = (cropProduction.getBailedOut() - cropProduction.getFullCostPrice()) / company.getGrounds().get(0).getHectare() * 100;
        double netDiscountedValue = ((double) company.getFixedAssets().getSalesRevenue() +
                company.getExpenses().getLaborCost() + deprecation + insurancePayments) / company.getStaff().get(0).getAverageNumber();
        double costRecovery = cropProduction.getBailedOut() / cropProduction.getFullCostPrice() * 100;
        double increasePerEmployed = ((double) company.getSalesReturn().getTotalEndDebt() -
                totalBeginDebt) / company.getStaff().get(0).getAverageNumber();
        double landGrowth = (company.getSalesReturn().getTotalEndDebt() - totalBeginDebt)
                / company.getGrounds().get(0).getHectare() * 100;

        company.setProfitFromSales(Precision.round(profitFromSales, 6));
        company.setNetDiscountedValue(Precision.round(netDiscountedValue, 6));
        company.setCostRecovery(Precision.round(costRecovery, 6));
        company.setProductionProfitability((company.getCoefficients().getProfitability() == null) ? 0 : company.getCoefficients().getProfitability());
        company.setIncreasePerEmployed(Precision.round(increasePerEmployed, 6));
        company.setLandGrowth(Precision.round(landGrowth, 6));
    }

    public void calcCorrelation(Company company) throws ServiceException {
        if (company == null) {
            throw new ServiceException("Company doesn't exist for calculate correlation");
        }
        Correlation correlation = new Correlation(company.getYnn());
        correlation.setProfitAndNetDiscounted(calcCorrelationCoefficient(company.getProfitFromSales(), company.getNetDiscountedValue()));
        correlation.setProfitAndCostRecovery(calcCorrelationCoefficient(company.getProfitFromSales(), company.getCostRecovery()));
        correlation.setProfitAndProfitability(calcCorrelationCoefficient(company.getProfitFromSales(), company.getProductionProfitability()));
        correlation.setNetDiscountedAndCostRecovery(calcCorrelationCoefficient(company.getNetDiscountedValue(), company.getCostRecovery()));
        correlation.setNetDiscountedAndProfitability(calcCorrelationCoefficient(company.getNetDiscountedValue(), company.getProductionProfitability()));
        correlation.setCostRecoveryAndProfitability(calcCorrelationCoefficient(company.getCostRecovery(), company.getProductionProfitability()));
        CorrelationService service = new CorrelationServiceImpl();
        service.add(correlation);
        company.setCorrelation(correlation);
    }

    private double calcCorrelationCoefficient(Double value1, Double value2) {
        List<Double> xList = generateValues(value1);
        List<Double> yList = generateValues(value2);
        NumeratorCalculate nc = new NumeratorCalculate(xList, yList);
        double numerator = nc.calcuteNumerator();
        DenominatorCalculate dc = new DenominatorCalculate();
        double denominator = dc.calculateDenominator(xList, yList);
        return numerator / denominator;
    }

    private List<Double> generateValues(Double value) {
        List<Double> list = new ArrayList<>();
        int delta = (int) (value * 0.25);
        for (int i = 0; i < 20; i++) {
            list.add(Math.random() * (delta * 2) + (value - delta));
        }
        return list;
    }
}
