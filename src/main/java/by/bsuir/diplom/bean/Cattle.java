package by.bsuir.diplom.bean;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@javax.persistence.Entity
@Table(name = "cattle", schema = "company_db")
public class Cattle implements Serializable {

    @Id
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ynn")
    private Company company;

    @Column(name = "milk_yield", nullable = true)
    private Integer milkYield;

    @Column(name = "average_daily_increase", nullable = true)
    private Integer averageDailyIncrease;

    @Column(name = "cattle_producers", nullable = true)
    private Integer cattleProducers;

    @Column(name = "cattle_cultivation", nullable = true)
    private Integer cattleCultivation;

    @Column(name = "current_end_balance", nullable = false)
    private Integer currentEndBalance;

    @Column(name = "prev_end_balance", nullable = true)
    private Integer prevEndBalance;

    public Cattle() {
    }

    public Cattle(Integer ynn, Integer currentEndBalance) {
        this.company = new Company(ynn);
        this.currentEndBalance = currentEndBalance;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Integer getMilkYield() {
        return milkYield;
    }

    public void setMilkYield(Integer milkYield) {
        this.milkYield = milkYield;
    }

    public Integer getAverageDailyIncrease() {
        return averageDailyIncrease;
    }

    public void setAverageDailyIncrease(Integer averageDailyIncrease) {
        this.averageDailyIncrease = averageDailyIncrease;
    }

    public Integer getCattleProducers() {
        return cattleProducers;
    }

    public void setCattleProducers(Integer cattleProducers) {
        this.cattleProducers = cattleProducers;
    }

    public Integer getCattleCultivation() {
        return cattleCultivation;
    }

    public void setCattleCultivation(Integer cattleCultivation) {
        this.cattleCultivation = cattleCultivation;
    }

    public Integer getCurrentEndBalance() {
        return currentEndBalance;
    }

    public void setCurrentEndBalance(Integer currentEndBalance) {
        this.currentEndBalance = currentEndBalance;
    }

    public Integer getPrevEndBalance() {
        return prevEndBalance;
    }

    public void setPrevEndBalance(Integer prevEndBalance) {
        this.prevEndBalance = prevEndBalance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cattle cattle = (Cattle) o;
        return Objects.equals(company, cattle.company) && Objects.equals(milkYield, cattle.milkYield) && Objects.equals(averageDailyIncrease, cattle.averageDailyIncrease) && Objects.equals(cattleProducers, cattle.cattleProducers) && Objects.equals(cattleCultivation, cattle.cattleCultivation) && Objects.equals(currentEndBalance, cattle.currentEndBalance) && Objects.equals(prevEndBalance, cattle.prevEndBalance);
    }

    @Override
    public int hashCode() {
        return Objects.hash(company, milkYield, averageDailyIncrease, cattleProducers, cattleCultivation, currentEndBalance, prevEndBalance);
    }

    @Override
    public String toString() {
        return "Cattle{" +
                "ynn=" + company.getYnn() +
                ", milkYield=" + milkYield +
                ", averageDailyIncrease=" + averageDailyIncrease +
                ", cattleProducers=" + cattleProducers +
                ", cattleCultivation=" + cattleCultivation +
                ", currentEndBalance=" + currentEndBalance +
                ", prevEndBalance=" + prevEndBalance +
                '}';
    }
}
