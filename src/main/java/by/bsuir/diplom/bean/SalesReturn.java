package by.bsuir.diplom.bean;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@javax.persistence.Entity
@Table(name = "sales_return", schema = "company_db")
public class SalesReturn implements Serializable {

    @Id
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ynn")
    private Company company;

    @Column(name = "sales_return", nullable = true, precision = 2)
    private Double sales;

    @Column(name = "current_dividend_payments", nullable = true)
    private Integer currentDividendPayments;

    @Column(name = "prev_dividend_payments", nullable = true)
    private Integer prevDividendPayments;

    @Column(name = "total_end_debt", nullable = false)
    private Integer totalEndDebt;

    @Column(name = "overdue_end_debt", nullable = true)
    private Integer overdueEndDebt;

    @Column(name = "total_begin_debt", nullable = true)
    private Integer totalBeginDebt;

    @Column(name = "overdue_begin_debt", nullable = true)
    private Integer overdueBeginDebt;

    public SalesReturn() {
    }

    public SalesReturn(Integer ynn, Integer totalEndDebt) {
        this.company = new Company(ynn);
        this.totalEndDebt = totalEndDebt;
    }

    public SalesReturn(Integer ynn, Double sales, Integer currentDividendPayments, Integer prevDividendPayments, Integer totalEndDebt, Integer overdueEndDebt, Integer totalBeginDebt, Integer overdueBeginDebt) {
        this.company = new Company(ynn);
        this.sales = sales;
        this.currentDividendPayments = currentDividendPayments;
        this.prevDividendPayments = prevDividendPayments;
        this.totalEndDebt = totalEndDebt;
        this.overdueEndDebt = overdueEndDebt;
        this.totalBeginDebt = totalBeginDebt;
        this.overdueBeginDebt = overdueBeginDebt;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Double getSales() {
        return sales;
    }

    public void setSales(Double sales) {
        this.sales = sales;
    }

    public Integer getCurrentDividendPayments() {
        return currentDividendPayments;
    }

    public void setCurrentDividendPayments(Integer currentDividendPayments) {
        this.currentDividendPayments = currentDividendPayments;
    }

    public Integer getPrevDividendPayments() {
        return prevDividendPayments;
    }

    public void setPrevDividendPayments(Integer prevDividendPayments) {
        this.prevDividendPayments = prevDividendPayments;
    }

    public Integer getTotalEndDebt() {
        return totalEndDebt;
    }

    public void setTotalEndDebt(Integer totalEndDebt) {
        this.totalEndDebt = totalEndDebt;
    }

    public Integer getOverdueEndDebt() {
        return overdueEndDebt;
    }

    public void setOverdueEndDebt(Integer overdueEndDebt) {
        this.overdueEndDebt = overdueEndDebt;
    }

    public Integer getTotalBeginDebt() {
        return totalBeginDebt;
    }

    public void setTotalBeginDebt(Integer totalBeginDebt) {
        this.totalBeginDebt = totalBeginDebt;
    }

    public Integer getOverdueBeginDebt() {
        return overdueBeginDebt;
    }

    public void setOverdueBeginDebt(Integer overdueBeginDebt) {
        this.overdueBeginDebt = overdueBeginDebt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SalesReturn that = (SalesReturn) o;
        return Objects.equals(company, that.company) && Objects.equals(sales, that.sales) && Objects.equals(currentDividendPayments, that.currentDividendPayments) && Objects.equals(prevDividendPayments, that.prevDividendPayments) && Objects.equals(totalEndDebt, that.totalEndDebt) && Objects.equals(overdueEndDebt, that.overdueEndDebt) && Objects.equals(totalBeginDebt, that.totalBeginDebt) && Objects.equals(overdueBeginDebt, that.overdueBeginDebt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(company, sales, currentDividendPayments, prevDividendPayments, totalEndDebt, overdueEndDebt, totalBeginDebt, overdueBeginDebt);
    }

    @Override
    public String toString() {
        return "SalesReturn{" +
                "ynn=" + company.getYnn() +
                ", salesReturn=" + sales +
                ", currentDividendPayments=" + currentDividendPayments +
                ", prevDividendPayments=" + prevDividendPayments +
                ", totalEndDebt=" + totalEndDebt +
                ", overdueEndDebt=" + overdueEndDebt +
                ", totalBeginDebt=" + totalBeginDebt +
                ", overdueBeginDebt=" + overdueBeginDebt +
                '}';
    }
}
