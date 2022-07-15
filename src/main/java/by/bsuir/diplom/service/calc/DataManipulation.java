package by.bsuir.diplom.service.calc;

import by.bsuir.diplom.bean.Company;
import by.bsuir.diplom.bean.Correlation;
import by.bsuir.diplom.service.ServiceException;

import java.util.ArrayList;
import java.util.List;

public class DataManipulation {
    private static final String PROFIT = "Прибыль от реализации на 100 га";
    private static final String NET_DISCOUNTED = "ЧДС на занятого";
    private static final String COST_RECOVERY = "Окупаемость затрат выручкой";
    private static final String PROFITABILITY = "Рентабельность произв.-хоз. деятельности";

    public static List<String> getCorrelationConclusion(Company company) throws ServiceException {
        if (company.getCorrelation() == null) {
            DataCalculation dataCalculation = new DataCalculation();
            dataCalculation.calcCorrelation(company);
        }
        List<String> list = new ArrayList<>();
        Correlation correlation = company.getCorrelation();
        list.add(getConclusion(correlation.getProfitAndNetDiscounted(), PROFIT, NET_DISCOUNTED));
        list.add(getConclusion(correlation.getProfitAndCostRecovery(), PROFIT, COST_RECOVERY));
        list.add(getConclusion(correlation.getProfitAndProfitability(), PROFIT, PROFITABILITY));
        list.add(getConclusion(correlation.getNetDiscountedAndCostRecovery(), NET_DISCOUNTED, COST_RECOVERY));
        list.add(getConclusion(correlation.getNetDiscountedAndProfitability(), NET_DISCOUNTED, PROFITABILITY));
        list.add(getConclusion(correlation.getCostRecoveryAndProfitability(), COST_RECOVERY, PROFITABILITY));
        return list;
    }

    private static String getConclusion(double correlation, String str1, String str2) {
        String text = "Расчетное значение парного коэффициента корреляции Rху для переменных " + str1 + " и " + str2 + " составляет " + correlation;
        if (correlation <= 0.5 && correlation >= -0.5) {
            text += "\n" + str1 + " и " + str2 + " имеют слабую  тесноту связи, а значит слабую";
        } else if ((correlation > 0.5 && correlation <= 0.7) || (correlation < -0.5 && correlation >= -0.7)) {
            text += "\n" + str1 + " и " + str2 + " имеют умеренную тесноту связи, а значит умеренную";
        } else {
            text += "\n" + str1 + " и " + str2 + " имеют сильную тесноту связи, а значит сильную";
        }
        if (correlation < 0) {
            text += " корреляционную зависимость, тип связи – обратный";
        } else {
            text += " корреляционную зависимость, тип связи – прямой";
        }
        return text;
    }
}
