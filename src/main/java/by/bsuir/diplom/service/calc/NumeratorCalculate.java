package by.bsuir.diplom.service.calc;

import java.util.List;

public class NumeratorCalculate {
    //add global varieties
    protected List<Double> xList;

    protected List<Double> yList;

    public NumeratorCalculate(List<Double> xList, List<Double> yList) {
        this.xList = xList;
        this.yList = yList;
    }

    /**
     * add operate method
     */
    public double calcuteNumerator() {
        double result = 0.0;
        double xAverage;
        double temp = 0.0;

        int xSize = xList.size();
        for (Double aDouble : xList) {
            temp += aDouble;
        }
        xAverage = temp / xSize;

        double yAverage;
        temp = 0.0;
        int ySize = yList.size();
        for (Double aDouble : yList) {
            temp += aDouble;
        }
        yAverage = temp / ySize;

        for (int x = 0; x < xSize; x++) {
            result += (xList.get(x) - xAverage) * (yList.get(x) - yAverage);
        }
        return result;
    }
}
