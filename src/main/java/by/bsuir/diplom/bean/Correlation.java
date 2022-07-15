package by.bsuir.diplom.bean;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@javax.persistence.Entity
@Table(name = "correlation", schema = "company_db")
public class Correlation implements Serializable {

    @Id
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ynn")
    private Company company;

    @Column(name = "profit_and_net_discounted", nullable = true)
    private Double profitAndNetDiscounted;

    @Column(name = "profit_and_cost_recovery", nullable = true)
    private Double profitAndCostRecovery;

    @Column(name = "profit_and_profitability", nullable = true)
    private Double profitAndProfitability;

    @Column(name = "net_discounted_and_cost_recovery", nullable = true)
    private Double netDiscountedAndCostRecovery;

    @Column(name = "net_discounted_and_profitability", nullable = true)
    private Double netDiscountedAndProfitability;

    @Column(name = "cost_recovery_and_profitability", nullable = true)
    private Double costRecoveryAndProfitability;

    public Correlation() {
    }

    public Correlation(Integer ynn) {
        this.company = new Company(ynn);
    }

    public Correlation(Integer ynn, Double profitAndNetDiscounted, Double profitAndCostRecovery, Double profitAndProfitability, Double netDiscountedAndCostRecovery, Double netDiscountedAndProfitability, Double costRecoveryAndProfitability) {
        this.company = new Company(ynn);
        this.profitAndNetDiscounted = profitAndNetDiscounted;
        this.profitAndCostRecovery = profitAndCostRecovery;
        this.profitAndProfitability = profitAndProfitability;
        this.netDiscountedAndCostRecovery = netDiscountedAndCostRecovery;
        this.netDiscountedAndProfitability = netDiscountedAndProfitability;
        this.costRecoveryAndProfitability = costRecoveryAndProfitability;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Double getProfitAndNetDiscounted() {
        return profitAndNetDiscounted;
    }

    public void setProfitAndNetDiscounted(Double profitAndNetDiscounted) {
        this.profitAndNetDiscounted = profitAndNetDiscounted;
    }

    public Double getProfitAndCostRecovery() {
        return profitAndCostRecovery;
    }

    public void setProfitAndCostRecovery(Double profitAndCostRecovery) {
        this.profitAndCostRecovery = profitAndCostRecovery;
    }

    public Double getProfitAndProfitability() {
        return profitAndProfitability;
    }

    public void setProfitAndProfitability(Double profitAndProfitability) {
        this.profitAndProfitability = profitAndProfitability;
    }

    public Double getNetDiscountedAndCostRecovery() {
        return netDiscountedAndCostRecovery;
    }

    public void setNetDiscountedAndCostRecovery(Double netDiscountedAndCostRecovery) {
        this.netDiscountedAndCostRecovery = netDiscountedAndCostRecovery;
    }

    public Double getNetDiscountedAndProfitability() {
        return netDiscountedAndProfitability;
    }

    public void setNetDiscountedAndProfitability(Double netDiscountedAndProfitability) {
        this.netDiscountedAndProfitability = netDiscountedAndProfitability;
    }

    public Double getCostRecoveryAndProfitability() {
        return costRecoveryAndProfitability;
    }

    public void setCostRecoveryAndProfitability(Double costRecoveryAndProfitability) {
        this.costRecoveryAndProfitability = costRecoveryAndProfitability;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Correlation that = (Correlation) o;
        return Objects.equals(company, that.company) && Objects.equals(profitAndNetDiscounted, that.profitAndNetDiscounted) && Objects.equals(profitAndCostRecovery, that.profitAndCostRecovery) && Objects.equals(profitAndProfitability, that.profitAndProfitability) && Objects.equals(netDiscountedAndCostRecovery, that.netDiscountedAndCostRecovery) && Objects.equals(netDiscountedAndProfitability, that.netDiscountedAndProfitability) && Objects.equals(costRecoveryAndProfitability, that.costRecoveryAndProfitability);
    }

    @Override
    public int hashCode() {
        return Objects.hash(company, profitAndNetDiscounted, profitAndCostRecovery, profitAndProfitability, netDiscountedAndCostRecovery, netDiscountedAndProfitability, costRecoveryAndProfitability);
    }

    @Override
    public String toString() {
        return "Correlation{" +
                "ynn=" + company.getYnn() +
                ", profitAndNetDiscounted=" + profitAndNetDiscounted +
                ", profitAndCostRecovery=" + profitAndCostRecovery +
                ", profitAndProfitability=" + profitAndProfitability +
                ", netDiscountedAndCostRecovery=" + netDiscountedAndCostRecovery +
                ", netDiscountedAndProfitability=" + netDiscountedAndProfitability +
                ", costRecoveryAndProfitability=" + costRecoveryAndProfitability +
                '}';
    }
}
