package by.bsuir.diplom.bean;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@javax.persistence.Entity
@Table(name = "dairy_products", schema = "company_db")
public class DairyProducts implements Serializable {

    @Id
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ynn")
    private Company company;

    @Column(name = "cattle", nullable = true, precision = 2)
    private Double cattle;

    @Column(name = "output_dairy_products", nullable = true, precision = 2)
    private Double outputDairyProducts;

    @Column(name = "cost_dairy_products", nullable = true)
    private Integer costDairyProducts;

    @Column(name = "production_growth", nullable = true, precision = 2)
    private Double productionGrowth;

    @Column(name = "production_cost_growth", nullable = true)
    private Integer productionCostGrowth;

    public DairyProducts() {
    }

    public DairyProducts(Integer ynn) {
        this.company = new Company(ynn);
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Double getCattle() {
        return cattle;
    }

    public void setCattle(Double cattle) {
        this.cattle = cattle;
    }

    public Double getOutputDairyProducts() {
        return outputDairyProducts;
    }

    public void setOutputDairyProducts(Double outputDairyProducts) {
        this.outputDairyProducts = outputDairyProducts;
    }

    public Integer getCostDairyProducts() {
        return costDairyProducts;
    }

    public void setCostDairyProducts(Integer costDairyProducts) {
        this.costDairyProducts = costDairyProducts;
    }

    public Double getProductionGrowth() {
        return productionGrowth;
    }

    public void setProductionGrowth(Double productionGrowth) {
        this.productionGrowth = productionGrowth;
    }

    public Integer getProductionCostGrowth() {
        return productionCostGrowth;
    }

    public void setProductionCostGrowth(Integer productionCostGrowth) {
        this.productionCostGrowth = productionCostGrowth;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DairyProducts that = (DairyProducts) o;
        return Objects.equals(company, that.company) && Objects.equals(cattle, that.cattle) && Objects.equals(outputDairyProducts, that.outputDairyProducts) && Objects.equals(costDairyProducts, that.costDairyProducts) && Objects.equals(productionGrowth, that.productionGrowth) && Objects.equals(productionCostGrowth, that.productionCostGrowth);
    }

    @Override
    public int hashCode() {
        return Objects.hash(company, cattle, outputDairyProducts, costDairyProducts, productionGrowth, productionCostGrowth);
    }

    @Override
    public String toString() {
        return "DairyProducts{" +
                "ynn=" + company.getYnn() +
                ", cattle=" + cattle +
                ", outputDairyProducts=" + outputDairyProducts +
                ", costDairyProducts=" + costDairyProducts +
                ", productionGrowth=" + productionGrowth +
                ", productionCostGrowth=" + productionCostGrowth +
                '}';
    }
}
