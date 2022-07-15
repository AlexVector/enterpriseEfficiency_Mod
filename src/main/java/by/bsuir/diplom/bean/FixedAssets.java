package by.bsuir.diplom.bean;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@javax.persistence.Entity
@Table(name = "fixed_assets", schema = "company_db")
public class FixedAssets implements Serializable {

    @Id
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ynn")
    private Company company;

    @Column(name = "fixed_assets", nullable = true)
    private Integer fixedAssets;

    @Column(name = "loans_borrowings", nullable = true)
    private Integer loansBorrowings;

    @Column(name = "total_4", nullable = true)
    private Integer total4;

    @Column(name = "shortterm_debt", nullable = false)
    private Integer shorttermDebt;

    @Column(name = "total_5", nullable = false)
    private Integer total5;

    @Column(name = "sales_revenue", nullable = false)
    private Integer salesRevenue;

    @Column(name = "profit", nullable = true)
    private Integer profit;

    public FixedAssets() {
    }

    public FixedAssets(Integer ynn, Integer shorttermDebt, Integer total5, Integer salesRevenue) {
        this.company = new Company(ynn);
        this.shorttermDebt = shorttermDebt;
        this.total5 = total5;
        this.salesRevenue = salesRevenue;
    }

    public FixedAssets(Integer ynn, Integer fixedAssets, Integer loansBorrowings, Integer total4, Integer shorttermDebt, Integer total5, Integer salesRevenue, Integer profit) {
        this.company = new Company(ynn);
        this.fixedAssets = fixedAssets;
        this.loansBorrowings = loansBorrowings;
        this.total4 = total4;
        this.shorttermDebt = shorttermDebt;
        this.total5 = total5;
        this.salesRevenue = salesRevenue;
        this.profit = profit;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Integer getFixedAssets() {
        return fixedAssets;
    }

    public void setFixedAssets(Integer fixedAssets) {
        this.fixedAssets = fixedAssets;
    }

    public Integer getLoansBorrowings() {
        return loansBorrowings;
    }

    public void setLoansBorrowings(Integer loansBorrowings) {
        this.loansBorrowings = loansBorrowings;
    }

    public Integer getTotal4() {
        return total4;
    }

    public void setTotal4(Integer total4) {
        this.total4 = total4;
    }

    public Integer getShorttermDebt() {
        return shorttermDebt;
    }

    public void setShorttermDebt(Integer shorttermDebt) {
        this.shorttermDebt = shorttermDebt;
    }

    public Integer getTotal5() {
        return total5;
    }

    public void setTotal5(Integer total5) {
        this.total5 = total5;
    }

    public Integer getSalesRevenue() {
        return salesRevenue;
    }

    public void setSalesRevenue(Integer salesRevenue) {
        this.salesRevenue = salesRevenue;
    }

    public Integer getProfit() {
        return profit;
    }

    public void setProfit(Integer profit) {
        this.profit = profit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FixedAssets that = (FixedAssets) o;
        return Objects.equals(company, that.company) && Objects.equals(fixedAssets, that.fixedAssets) && Objects.equals(loansBorrowings, that.loansBorrowings) && Objects.equals(total4, that.total4) && Objects.equals(shorttermDebt, that.shorttermDebt) && Objects.equals(total5, that.total5) && Objects.equals(salesRevenue, that.salesRevenue) && Objects.equals(profit, that.profit);
    }

    @Override
    public int hashCode() {
        return Objects.hash(company, fixedAssets, loansBorrowings, total4, shorttermDebt, total5, salesRevenue, profit);
    }

    @Override
    public String toString() {
        return "FixedAssets{" +
                "ynn=" + company.getYnn() +
                ", fixedAssets=" + fixedAssets +
                ", loansBorrowings=" + loansBorrowings +
                ", total4=" + total4 +
                ", shorttermDebt=" + shorttermDebt +
                ", total5=" + total5 +
                ", salesRevenue=" + salesRevenue +
                ", profit=" + profit +
                '}';
    }
}
