package by.bsuir.diplom.bean;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@javax.persistence.Entity
@Table(name = "company_info", schema = "company_db")
public class CompanyInfo implements Serializable {

    @Id
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ynn")
    private Company company;

    @Column(name = "industry_code", nullable = false)
    private Integer industryCode;

    @Column(name = "industry_name", nullable = false, length = 70)
    private String industryName;

    @Column(name = "department_name", nullable = false, length = 55)
    private String departmentName;

    @Column(name = "association_name", nullable = false, length = 40)
    private String associationName;

    @Column(name = "ownership_type", nullable = false, length = 25)
    private String ownershipType;

    public CompanyInfo() {
    }

    public CompanyInfo(Integer ynn, Integer industryCode, String industryName, String departmentName, String associationName, String ownershipType) {
        this.company = new Company(ynn);
        this.industryCode = industryCode;
        this.industryName = industryName;
        this.departmentName = departmentName;
        this.associationName = associationName;
        this.ownershipType = ownershipType;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Integer getIndustryCode() {
        return industryCode;
    }

    public void setIndustryCode(Integer industryCode) {
        this.industryCode = industryCode;
    }

    public String getIndustryName() {
        return industryName;
    }

    public void setIndustryName(String industryName) {
        this.industryName = industryName;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getAssociationName() {
        return associationName;
    }

    public void setAssociationName(String associationName) {
        this.associationName = associationName;
    }

    public String getOwnershipType() {
        return ownershipType;
    }

    public void setOwnershipType(String ownershipType) {
        this.ownershipType = ownershipType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CompanyInfo that = (CompanyInfo) o;
        return Objects.equals(company, that.company) && Objects.equals(industryCode, that.industryCode) && Objects.equals(industryName, that.industryName) && Objects.equals(departmentName, that.departmentName) && Objects.equals(associationName, that.associationName) && Objects.equals(ownershipType, that.ownershipType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(company, industryCode, industryName, departmentName, associationName, ownershipType);
    }

    @Override
    public String toString() {
        return "CompanyInfo{" +
                "ynn=" + company.getYnn() +
                ", industryCode=" + industryCode +
                ", industryName='" + industryName + '\'' +
                ", departmentName='" + departmentName + '\'' +
                ", associationName='" + associationName + '\'' +
                ", ownershipType='" + ownershipType + '\'' +
                '}';
    }
}
