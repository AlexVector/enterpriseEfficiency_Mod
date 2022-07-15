package by.bsuir.diplom.bean;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

@javax.persistence.Entity
@Table(name = "company", schema = "company_db")
public class Company implements Serializable {

    @Id
    @Column(name = "ynn", unique = true, nullable = false)
    private Integer ynn;

    @Column(name = "id", unique = true, nullable = true)
    private Integer id;

    @Column(name = "okpo", unique = true, nullable = false)
    private Integer okpo;

    @Column(name = "name", nullable = false, length = 100)
    private String name;

    @Column(name = "full_name", nullable = false, length = 250)
    private String fullName;

    @Column(name = "year", nullable = false)
    private Integer year;

    @Column(name = "period", nullable = false, length = 30)
    private String period;

    @Column(name = "activity_type", nullable = false, length = 25)
    private String activityType;

    @Transient
    private Double profitFromSales;

    @Transient
    private Double netDiscountedValue;

    @Transient
    private Double costRecovery;

    @Transient
    private Double productionProfitability;

    @Transient
    private Double increasePerEmployed;

    @Transient
    private Double landGrowth;

    @OneToOne(mappedBy = "company", orphanRemoval = true, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Address address;

    @OneToOne(mappedBy = "company", orphanRemoval = true, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Cattle cattle;

    @OneToOne(mappedBy = "company", orphanRemoval = true, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Coefficients coefficients;

    @OneToOne(mappedBy = "company", orphanRemoval = true, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private CompanyInfo companyInfo;

    @OneToOne(mappedBy = "company", orphanRemoval = true, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Correlation correlation;

    @OneToOne(mappedBy = "company", orphanRemoval = true, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private DairyProducts dairyProducts;

    @OneToOne(mappedBy = "company", orphanRemoval = true, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Expenses expenses;

    @OneToOne(mappedBy = "company", orphanRemoval = true, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private FixedAssets fixedAssets;

    @OneToOne(mappedBy = "company", orphanRemoval = true, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private SalesReturn salesReturn;

    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL)
    private List<CropProduction> cropProductions = new ArrayList<>();

    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL)
    private List<EnterpriseStatistic> enterpriseStatistics = new ArrayList<>();

    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL)
    private List<Grounds> grounds;

    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL)
    private List<Staff> staff = new ArrayList<>();

    public Company() {
    }

    public Company(Integer ynn) {
        this.ynn = ynn;
    }

    public Company(Integer ynn, Integer okpo) {
        this.ynn = ynn;
        this.okpo = okpo;
    }

    public Company(Integer ynn, Integer okpo, String name, String fullName, Integer year, String period, String activityType) {
        this.ynn = ynn;
        this.okpo = okpo;
        this.name = name;
        this.fullName = fullName;
        this.year = year;
        this.period = period;
        this.activityType = activityType;
    }

    public Company(Integer ynn, Integer id, Integer okpo, String name, String fullName, Integer year, String period, String activityType) {
        this.ynn = ynn;
        this.id = id;
        this.okpo = okpo;
        this.name = name;
        this.fullName = fullName;
        this.year = year;
        this.period = period;
        this.activityType = activityType;
    }

    public Integer getYnn() {
        return ynn;
    }

    public void setYnn(Integer ynn) {
        this.ynn = ynn;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getOkpo() {
        return okpo;
    }

    public void setOkpo(Integer okpo) {
        this.okpo = okpo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    public String getActivityType() {
        return activityType;
    }

    public void setActivityType(String activityType) {
        this.activityType = activityType;
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

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Cattle getCattle() {
        return cattle;
    }

    public void setCattle(Cattle cattle) {
        this.cattle = cattle;
    }

    public Coefficients getCoefficients() {
        return coefficients;
    }

    public void setCoefficients(Coefficients coefficients) {
        this.coefficients = coefficients;
    }

    public CompanyInfo getCompanyInfo() {
        return companyInfo;
    }

    public void setCompanyInfo(CompanyInfo companyInfo) {
        this.companyInfo = companyInfo;
    }

    public Correlation getCorrelation() {
        return correlation;
    }

    public void setCorrelation(Correlation correlation) {
        this.correlation = correlation;
    }

    public DairyProducts getDairyProducts() {
        return dairyProducts;
    }

    public void setDairyProducts(DairyProducts dairyProducts) {
        this.dairyProducts = dairyProducts;
    }

    public Expenses getExpenses() {
        return expenses;
    }

    public void setExpenses(Expenses expenses) {
        this.expenses = expenses;
    }

    public FixedAssets getFixedAssets() {
        return fixedAssets;
    }

    public void setFixedAssets(FixedAssets fixedAssets) {
        this.fixedAssets = fixedAssets;
    }

    public SalesReturn getSalesReturn() {
        return salesReturn;
    }

    public void setSalesReturn(SalesReturn salesReturn) {
        this.salesReturn = salesReturn;
    }

    public List<CropProduction> getCropProductions() {
        return cropProductions;
    }

    public void setCropProductions(List<CropProduction> cropProductions) {
        this.cropProductions = cropProductions;
    }

    public List<EnterpriseStatistic> getEnterpriseStatistics() {
        return enterpriseStatistics;
    }

    public void setEnterpriseStatistics(List<EnterpriseStatistic> enterpriseStatistics) {
        this.enterpriseStatistics = enterpriseStatistics;
    }

    public List<Grounds> getGrounds() {
        return grounds;
    }

    public void setGrounds(List<Grounds> grounds) {
        this.grounds = grounds;
    }

    public List<Staff> getStaff() {
        return staff;
    }

    public void setStaff(List<Staff> staff) {
        this.staff = staff;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Company company = (Company) o;
        return Objects.equals(ynn, company.ynn) && Objects.equals(id, company.id) && Objects.equals(okpo, company.okpo) && Objects.equals(name, company.name) && Objects.equals(fullName, company.fullName) && Objects.equals(year, company.year) && Objects.equals(period, company.period) && Objects.equals(activityType, company.activityType) && Objects.equals(profitFromSales, company.profitFromSales) && Objects.equals(netDiscountedValue, company.netDiscountedValue) && Objects.equals(costRecovery, company.costRecovery) && Objects.equals(productionProfitability, company.productionProfitability) && Objects.equals(increasePerEmployed, company.increasePerEmployed) && Objects.equals(landGrowth, company.landGrowth) && Objects.equals(address, company.address) && Objects.equals(cattle, company.cattle) && Objects.equals(coefficients, company.coefficients) && Objects.equals(companyInfo, company.companyInfo) && Objects.equals(correlation, company.correlation) && Objects.equals(dairyProducts, company.dairyProducts) && Objects.equals(expenses, company.expenses) && Objects.equals(fixedAssets, company.fixedAssets) && Objects.equals(salesReturn, company.salesReturn) && Objects.equals(cropProductions, company.cropProductions) && Objects.equals(enterpriseStatistics, company.enterpriseStatistics) && Objects.equals(grounds, company.grounds) && Objects.equals(staff, company.staff);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ynn, id, okpo, name, fullName, year, period, activityType, profitFromSales, netDiscountedValue, costRecovery, productionProfitability, increasePerEmployed, landGrowth, address, cattle, coefficients, companyInfo, correlation, dairyProducts, expenses, fixedAssets, salesReturn, cropProductions, enterpriseStatistics, grounds, staff);
    }

    @Override
    public String toString() {
        return "Company{" +
                "ynn=" + ynn +
                ", id=" + id +
                ", okpo=" + okpo +
                ", name='" + name + '\'' +
                ", fullName='" + fullName + '\'' +
                ", year=" + year +
                ", period='" + period + '\'' +
                ", activityType='" + activityType + '\'' +
                ", profitFromSales=" + profitFromSales +
                ", netDiscountedValue=" + netDiscountedValue +
                ", costRecovery=" + costRecovery +
                ", productionProfitability=" + productionProfitability +
                ", increasePerEmployed=" + increasePerEmployed +
                ", landGrowth=" + landGrowth +
//                ", address=" + address +
//                ", cattle=" + cattle +
//                ", coefficients=" + coefficients +
//                ", companyInfo=" + companyInfo +
//                ", correlation=" + correlation +
//                ", dairyProducts=" + dairyProducts +
//                ", expenses=" + expenses +
//                ", fixedAssets=" + fixedAssets +
//                ", salesReturn=" + salesReturn +
//                ", cropProductions=" + cropProductions +
//                ", enterpriseStatistics=" + enterpriseStatistics +
//                ", grounds=" + grounds +
//                ", staff=" + staff +
                '}';
    }
}
