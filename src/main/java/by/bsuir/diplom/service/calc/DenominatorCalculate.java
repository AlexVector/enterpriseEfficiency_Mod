package by.bsuir.diplom.service.calc;

import java.util.List;

public class DenominatorCalculate {
    //add denominatorCalculate method
    public double calculateDenominator(List<Double> xList, List<Double> yList) {
        int size = xList.size();
        double xException = 0.0;
        double yException = 0.0;
        double temp1 = 0.0;
        double temp2 = 0.0;
        for (Double aDouble : xList) {
            temp1 += aDouble;
        }
        double xAverage = temp1 / size;

        for (int i = 0; i < size; i++) {
            temp2 += yList.get(i);
        }
        double yAverage = temp2 / size;

        for (int i = 0; i < size; i++) {
            xException += Math.pow(xList.get(i) - xAverage, 2);
            yException += Math.pow(yList.get(i) - yAverage, 2);
        }
        //calculate denominator of
        return Math.sqrt(xException * yException);
    }
}
