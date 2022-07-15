package by.bsuir.diplom.bean;

import java.io.Serializable;
import java.util.Objects;

public class EnterpriseIndicators implements Serializable {

    private Double profitFromSales;

    private Double netDiscountedValue;

    private Double costRecovery;

    private Double productionProfitability;

    private Double increasePerEmployed;

    private Double landGrowth;

    public EnterpriseIndicators() {
    }

    public EnterpriseIndicators(Double profitFromSales, Double netDiscountedValue, Double costRecovery, Double productionProfitability, Double increasePerEmployed, Double landGrowth) {
        this.profitFromSales = profitFromSales;
        this.netDiscountedValue = netDiscountedValue;
        this.costRecovery = costRecovery;
        this.productionProfitability = productionProfitability;
        this.increasePerEmployed = increasePerEmployed;
        this.landGrowth = landGrowth;
    }

    public Double getProfitFromSales() {
        return profitFromSales;
    }

    public void setProfitFromSales(Double profitFromSales) {
        this.profitFromSales = profitFromSales;
    }

    public Double getNetDiscountedValue() {
        return netDiscountedValue;
    }

    public void setNetDiscountedValue(Double netDiscountedValue) {
        this.netDiscountedValue = netDiscountedValue;
    }

    public Double getCostRecovery() {
        return costRecovery;
    }

    public void setCostRecovery(Double costRecovery) {
        this.costRecovery = costRecovery;
    }

    public Double getProductionProfitability() {
        return productionProfitability;
    }

    public void setProductionProfitability(Double productionProfitability) {
        this.productionProfitability = productionProfitability;
    }

    public Double getIncreasePerEmployed() {
        return increasePerEmployed;
    }

    public void setIncreasePerEmployed(Double increasePerEmployed) {
        this.increasePerEmployed = increasePerEmployed;
    }

    public Double getLandGrowth() {
        return landGrowth;
    }

    public void setLandGrowth(Double landGrowth) {
        this.landGrowth = landGrowth;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EnterpriseIndicators that = (EnterpriseIndicators) o;
        return Objects.equals(profitFromSales, that.profitFromSales) && Objects.equals(netDiscountedValue, that.netDiscountedValue) && Objects.equals(costRecovery, that.costRecovery) && Objects.equals(productionProfitability, that.productionProfitability) && Objects.equals(increasePerEmployed, that.increasePerEmployed) && Objects.equals(landGrowth, that.landGrowth);
    }

    @Override
    public int hashCode() {
        return Objects.hash(profitFromSales, netDiscountedValue, costRecovery, productionProfitability, increasePerEmployed, landGrowth);
    }

    @Override
    public String toString() {
        return "EnterpriseIndicators{" +
                "profitFromSales=" + profitFromSales +
                ", netDiscountedValue=" + netDiscountedValue +
                ", costRecovery=" + costRecovery +
                ", productionProfitability=" + productionProfitability +
                ", increasePerEmployed=" + increasePerEmployed +
                ", landGrowth=" + landGrowth +
                '}';
    }
}
