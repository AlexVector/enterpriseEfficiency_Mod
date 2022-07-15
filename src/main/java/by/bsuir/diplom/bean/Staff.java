package by.bsuir.diplom.bean;

import javax.persistence.*;
import java.util.Objects;

@javax.persistence.Entity
@Table(name = "staff", schema = "company_db")
public class Staff extends Entity{

    @ManyToOne
    @JoinColumn(name = "ynn", referencedColumnName = "ynn", foreignKey = @ForeignKey(name = "staff_FK"))
    private Company company;

    @Column(name = "column_index", nullable = false)
    private Integer index;

    @Column(name = "average_number", nullable = true)
    private Integer averageNumber;

    @Column(name = "salary_fund", nullable = true, precision = 2)
    private Double salaryFund;

    public Staff() {
    }

    public Staff(Integer ynn, Integer index) {
        this.company = new Company(ynn);
        this.index = index;
    }

    public Staff(Integer ynn, Integer index, Integer averageNumber, Double salaryFund) {
        this.company = new Company(ynn);
        this.index = index;
        this.averageNumber = averageNumber;
        this.salaryFund = salaryFund;
    }

    public Staff(Integer id, Integer ynn, Integer index, Integer averageNumber, Double salaryFund) {
        super(id);
        this.company = new Company(ynn);
        this.index = index;
        this.averageNumber = averageNumber;
        this.salaryFund = salaryFund;
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

    public Integer getAverageNumber() {
        return averageNumber;
    }

    public void setAverageNumber(Integer averageNumber) {
        this.averageNumber = averageNumber;
    }

    public Double getSalaryFund() {
        return salaryFund;
    }

    public void setSalaryFund(Double salaryFund) {
        this.salaryFund = salaryFund;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Staff staff = (Staff) o;
        return Objects.equals(company, staff.company) && Objects.equals(index, staff.index) && Objects.equals(averageNumber, staff.averageNumber) && Objects.equals(salaryFund, staff.salaryFund);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), company, index, averageNumber, salaryFund);
    }

    @Override
    public String toString() {
        return "Staff{" +
                "ynn=" + company.getYnn() +
                ", index=" + index +
                ", averageNumber=" + averageNumber +
                ", salaryFund=" + salaryFund +
                '}';
    }
}
