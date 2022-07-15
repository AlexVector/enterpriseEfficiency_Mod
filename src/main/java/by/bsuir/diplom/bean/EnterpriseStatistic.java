package by.bsuir.diplom.bean;

import javax.persistence.*;
import java.util.Objects;

@javax.persistence.Entity
@Table(name = "enterprise_statistic", schema = "company_db")
public class EnterpriseStatistic extends Entity {

    @ManyToOne
    @JoinColumn(name = "ynn", referencedColumnName = "ynn", foreignKey = @ForeignKey(name = "statistic_FK"))
    private Company company;

    @Column(name = "column_index", nullable = false)
    private Integer index;

    @Column(name = "number_of_enterprises", nullable = true)
    private Integer numberOfEnterprises;

    @Column(name = "amount_authorized_capital", nullable = true)
    private Integer amountAuthorizedCapital;

    @Column(name = "share_state_ownership", nullable = true)
    private Integer shareStateOwnership;

    public EnterpriseStatistic() {
    }

    public EnterpriseStatistic(Integer ynn, Integer index) {
        this.company = new Company(ynn);
        this.index = index;
    }

    public EnterpriseStatistic(Integer ynn, Integer index, Integer numberOfEnterprises, Integer amountAuthorizedCapital, Integer shareStateOwnership) {
        this.company = new Company(ynn);
        this.index = index;
        this.numberOfEnterprises = numberOfEnterprises;
        this.amountAuthorizedCapital = amountAuthorizedCapital;
        this.shareStateOwnership = shareStateOwnership;
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

    public Integer getNumberOfEnterprises() {
        return numberOfEnterprises;
    }

    public void setNumberOfEnterprises(Integer numberOfEnterprises) {
        this.numberOfEnterprises = numberOfEnterprises;
    }

    public Integer getAmountAuthorizedCapital() {
        return amountAuthorizedCapital;
    }

    public void setAmountAuthorizedCapital(Integer amountAuthorizedCapital) {
        this.amountAuthorizedCapital = amountAuthorizedCapital;
    }

    public Integer getShareStateOwnership() {
        return shareStateOwnership;
    }

    public void setShareStateOwnership(Integer shareStateOwnership) {
        this.shareStateOwnership = shareStateOwnership;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        EnterpriseStatistic that = (EnterpriseStatistic) o;
        return Objects.equals(company, that.company) && Objects.equals(index, that.index) && Objects.equals(numberOfEnterprises, that.numberOfEnterprises) && Objects.equals(amountAuthorizedCapital, that.amountAuthorizedCapital) && Objects.equals(shareStateOwnership, that.shareStateOwnership);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), company, index, numberOfEnterprises, amountAuthorizedCapital, shareStateOwnership);
    }

    @Override
    public String toString() {
        return "EnterpriseStatistic{" +
                "ynn=" + company.getYnn() +
                ", index=" + index +
                ", numberOfEnterprises=" + numberOfEnterprises +
                ", amountAuthorizedCapital=" + amountAuthorizedCapital +
                ", shareStateOwnership=" + shareStateOwnership +
                '}';
    }
}
