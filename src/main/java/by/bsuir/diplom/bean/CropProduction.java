package by.bsuir.diplom.bean;

import javax.persistence.*;
import java.util.Objects;

@javax.persistence.Entity
@Table(name = "crop_production", schema = "company_db")
public class CropProduction extends Entity{

    @ManyToOne
    @JoinColumn(name = "ynn", referencedColumnName = "ynn", foreignKey = @ForeignKey(name = "crop_production_FK"))
    private Company company;

    @Column(name = "column_index", nullable = false)
    private Integer index;

    @Column(name = "full_cost_price", nullable = true, precision = 2)
    private Double fullCostPrice;

    @Column(name = "bailed_out", nullable = true, precision = 2)
    private Double bailedOut;

    public CropProduction() {
    }

    public CropProduction(Integer ynn, Integer index) {
        this.company = new Company(ynn);
        this.index = index;
    }

    public CropProduction(Integer ynn, Integer index, Double fullCostPrice, Double bailedOut) {
        this.company = new Company(ynn);
        this.index = index;
        this.fullCostPrice = fullCostPrice;
        this.bailedOut = bailedOut;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }

    public Double getFullCostPrice() {
        return fullCostPrice;
    }

    public void setFullCostPrice(Double fullCostPrice) {
        this.fullCostPrice = fullCostPrice;
    }

    public Double getBailedOut() {
        return bailedOut;
    }

    public void setBailedOut(Double bailedOut) {
        this.bailedOut = bailedOut;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        CropProduction that = (CropProduction) o;
        return Objects.equals(company, that.company) && Objects.equals(index, that.index) && Objects.equals(fullCostPrice, that.fullCostPrice) && Objects.equals(bailedOut, that.bailedOut);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), company, index, fullCostPrice, bailedOut);
    }

    @Override
    public String toString() {
        return "CropProduction{" +
                "ynn=" + company.getYnn() +
                ", index=" + index +
                ", fullCostPrice=" + fullCostPrice +
                ", bailedOut=" + bailedOut +
                '}';
    }
}
