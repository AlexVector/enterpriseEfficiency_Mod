package by.bsuir.diplom.bean;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@javax.persistence.Entity
@Table(name = "expenses", schema = "company_db")
public class Expenses implements Serializable {

    @Id
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ynn")
    private Company company;

    @Column(name = "labor_cost", nullable = false)
    private Integer laborCost;

    @Column(name = "material_costs", nullable = false)
    private Integer materialCosts;

    @Column(name = "feed", nullable = true)
    private Integer feed;

    @Column(name = "purchased_feed", nullable = true)
    private Integer purchasedFeed;

    @Column(name = "deprecation", nullable = true)
    private Integer deprecation;

    @Column(name = "insurance_payments", nullable = true)
    private Integer insurancePayments;

    @Column(name = "other_costs", nullable = true)
    private Integer otherCosts;

    @Column(name = "total_costs", nullable = false)
    private Integer totalCosts;

    @Column(name = "planting_costs", nullable = true)
    private Integer plantingCosts;

    public Expenses() {
    }

    public Expenses(Integer ynn, Integer laborCost, Integer materialCosts, Integer totalCosts) {
        this.company = new Company(ynn);
        this.laborCost = laborCost;
        this.materialCosts = materialCosts;
        this.totalCosts = totalCosts;
    }

    public Expenses(Integer ynn, Integer laborCost, Integer materialCosts, Integer feed, Integer purchasedFeed, Integer deprecation, Integer insurancePayments, Integer otherCosts, Integer totalCosts, Integer plantingCosts) {
        this.company = new Company(ynn);
        this.laborCost = laborCost;
        this.materialCosts = materialCosts;
        this.feed = feed;
        this.purchasedFeed = purchasedFeed;
        this.deprecation = deprecation;
        this.insurancePayments = insurancePayments;
        this.otherCosts = otherCosts;
        this.totalCosts = totalCosts;
        this.plantingCosts = plantingCosts;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Integer getLaborCost() {
        return laborCost;
    }

    public void setLaborCost(Integer laborCost) {
        this.laborCost = laborCost;
    }

    public Integer getMaterialCosts() {
        return materialCosts;
    }

    public void setMaterialCosts(Integer materialCosts) {
        this.materialCosts = materialCosts;
    }

    public Integer getFeed() {
        return feed;
    }

    public void setFeed(Integer feed) {
        this.feed = feed;
    }

    public Integer getPurchasedFeed() {
        return purchasedFeed;
    }

    public void setPurchasedFeed(Integer purchasedFeed) {
        this.purchasedFeed = purchasedFeed;
    }

    public Integer getDeprecation() {
        return deprecation;
    }

    public void setDeprecation(Integer depreciation) {
        this.deprecation = depreciation;
    }

    public Integer getInsurancePayments() {
        return insurancePayments;
    }

    public void setInsurancePayments(Integer insurancePayments) {
        this.insurancePayments = insurancePayments;
    }

    public Integer getOtherCosts() {
        return otherCosts;
    }

    public void setOtherCosts(Integer otherCosts) {
        this.otherCosts = otherCosts;
    }

    public Integer getTotalCosts() {
        return totalCosts;
    }

    public void setTotalCosts(Integer totalCosts) {
        this.totalCosts = totalCosts;
    }

    public Integer getPlantingCosts() {
        return plantingCosts;
    }

    public void setPlantingCosts(Integer plantingCosts) {
        this.plantingCosts = plantingCosts;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Expenses expenses = (Expenses) o;
        return Objects.equals(company, expenses.company) && Objects.equals(laborCost, expenses.laborCost) && Objects.equals(materialCosts, expenses.materialCosts) && Objects.equals(feed, expenses.feed) && Objects.equals(purchasedFeed, expenses.purchasedFeed) && Objects.equals(deprecation, expenses.deprecation) && Objects.equals(insurancePayments, expenses.insurancePayments) && Objects.equals(otherCosts, expenses.otherCosts) && Objects.equals(totalCosts, expenses.totalCosts) && Objects.equals(plantingCosts, expenses.plantingCosts);
    }

    @Override
    public int hashCode() {
        return Objects.hash(company, laborCost, materialCosts, feed, purchasedFeed, deprecation, insurancePayments, otherCosts, totalCosts, plantingCosts);
    }

    @Override
    public String toString() {
        return "Expenses{" +
                "ynn=" + company.getYnn() +
                ", laborCost=" + laborCost +
                ", materialCosts=" + materialCosts +
                ", feed=" + feed +
                ", purchasedFeed=" + purchasedFeed +
                ", depreciation=" + deprecation +
                ", insurancePayments=" + insurancePayments +
                ", otherCosts=" + otherCosts +
                ", totalCosts=" + totalCosts +
                ", plantingCosts=" + plantingCosts +
                '}';
    }
}
