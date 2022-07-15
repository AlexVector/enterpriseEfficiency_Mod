package by.bsuir.diplom.bean;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@javax.persistence.Entity
@Table(name = "coefficients", schema = "company_db")
public class Coefficients implements Serializable {

    @Id
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ynn")
    private Company company;

    @Column(name = "own_security", nullable = false, precision = 2)
    private Double ownSecurity;

    @Column(name = "current_liquidity", nullable = false, precision = 2)
    private Double currentLiquidity;

    @Column(name = "financial_security", nullable = false, precision = 2)
    private Double financialSecurity;

    @Column(name = "absolute_liquidity", nullable = true, precision = 2)
    private Double absoluteLiquidity;

    @Column(name = "end_net_assets", nullable = false)
    private Integer endNetAssets;

    @Column(name = "begin_net_assets", nullable = true)
    private Integer beginNetAssets;

    @Column(name = "profitability", nullable = true, precision = 2)
    private Double profitability;

    @Column(name = "profitability_without_support", nullable = true, precision = 2)
    private Double profitabilityWithoutSupport;

    public Coefficients() {
    }

    public Coefficients(Integer ynn, Double ownSecurity, Double currentLiquidity, Double financialSecurity, Integer endNetAssets) {
        this.company = new Company(ynn);
        this.ownSecurity = ownSecurity;
        this.currentLiquidity = currentLiquidity;
        this.financialSecurity = financialSecurity;
        this.endNetAssets = endNetAssets;
    }

    public Coefficients(Integer ynn, Double ownSecurity, Double currentLiquidity, Double financialSecurity, Double absoluteLiquidity, Integer endNetAssets, Integer beginNetAssets, Double profitability, Double profitabilityWithoutSupport) {
        this.company = new Company(ynn);
        this.ownSecurity = ownSecurity;
        this.currentLiquidity = currentLiquidity;
        this.financialSecurity = financialSecurity;
        this.absoluteLiquidity = absoluteLiquidity;
        this.endNetAssets = endNetAssets;
        this.beginNetAssets = beginNetAssets;
        this.profitability = profitability;
        this.profitabilityWithoutSupport = profitabilityWithoutSupport;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Double getOwnSecurity() {
        return ownSecurity;
    }

    public void setOwnSecurity(Double ownSecurity) {
        this.ownSecurity = ownSecurity;
    }

    public Double getCurrentLiquidity() {
        return currentLiquidity;
    }

    public void setCurrentLiquidity(Double currentLiquidity) {
        this.currentLiquidity = currentLiquidity;
    }

    public Double getFinancialSecurity() {
        return financialSecurity;
    }

    public void setFinancialSecurity(Double financialSecurity) {
        this.financialSecurity = financialSecurity;
    }

    public Double getAbsoluteLiquidity() {
        return absoluteLiquidity;
    }

    public void setAbsoluteLiquidity(Double absoluteLiquidity) {
        this.absoluteLiquidity = absoluteLiquidity;
    }

    public Integer getEndNetAssets() {
        return endNetAssets;
    }

    public void setEndNetAssets(Integer endNetAssets) {
        this.endNetAssets = endNetAssets;
    }

    public Integer getBeginNetAssets() {
        return beginNetAssets;
    }

    public void setBeginNetAssets(Integer beginNetAssets) {
        this.beginNetAssets = beginNetAssets;
    }

    public Double getProfitability() {
        return profitability;
    }

    public void setProfitability(Double profitability) {
        this.profitability = profitability;
    }

    public Double getProfitabilityWithoutSupport() {
        return profitabilityWithoutSupport;
    }

    public void setProfitabilityWithoutSupport(Double profitabilityWithoutSupport) {
        this.profitabilityWithoutSupport = profitabilityWithoutSupport;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coefficients that = (Coefficients) o;
        return Objects.equals(company, that.company) && Objects.equals(ownSecurity, that.ownSecurity) && Objects.equals(currentLiquidity, that.currentLiquidity) && Objects.equals(financialSecurity, that.financialSecurity) && Objects.equals(absoluteLiquidity, that.absoluteLiquidity) && Objects.equals(endNetAssets, that.endNetAssets) && Objects.equals(beginNetAssets, that.beginNetAssets) && Objects.equals(profitability, that.profitability) && Objects.equals(profitabilityWithoutSupport, that.profitabilityWithoutSupport);
    }

    @Override
    public int hashCode() {
        return Objects.hash(company, ownSecurity, currentLiquidity, financialSecurity, absoluteLiquidity, endNetAssets, beginNetAssets, profitability, profitabilityWithoutSupport);
    }

    @Override
    public String toString() {
        return "Coefficients{" +
                "ynn=" + company.getYnn() +
                ", ownSecurity=" + ownSecurity +
                ", currentLiquidity=" + currentLiquidity +
                ", financialSecurity=" + financialSecurity +
                ", absoluteLiquidity=" + absoluteLiquidity +
                ", endNetAssets=" + endNetAssets +
                ", beginNetAssets=" + beginNetAssets +
                ", profitability=" + profitability +
                ", profitabilityWithoutSupport=" + profitabilityWithoutSupport +
                '}';
    }
}
