package by.bsuir.diplom.bean;

import javax.persistence.*;
import java.util.Objects;

@javax.persistence.Entity
@Table(name = "grounds", schema = "company_db")
public class Grounds extends Entity {

    @ManyToOne
    @JoinColumn(name = "ynn", referencedColumnName = "ynn", foreignKey = @ForeignKey(name = "grounds_FK"))
    private Company company;

    @Column(name = "products_index", nullable = false)
    private Integer productsIndex;

    @Column(name = "total_products", nullable = true, precision = 2)
    private Double totalProducts;

    @Column(name = "hectare_products", nullable = true, precision = 2)
    private Double hectareProducts;

    @Column(name = "production_cost", nullable = true, precision = 2)
    private Double productionCost;

    @Column(name = "hectare_index", nullable = false)
    private Integer hectareIndex;

    @Column(name = "hectare", nullable = false, precision = 2)
    private Double hectare;

    @Column(name = "ballogectars", nullable = true, precision = 2)
    private Double ballogectars;

    public Grounds() {
    }

    public Grounds(Integer ynn) {
        this.company = new Company(ynn);
    }

    public Grounds(Integer ynn, Integer productsIndex, Integer hectareIndex, Double hectare, Double ballogectars) {
        this.company = new Company(ynn);
        this.productsIndex = productsIndex;
        this.hectareIndex = hectareIndex;
        this.hectare = hectare;
        this.ballogectars = ballogectars;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Integer getProductsIndex() {
        return productsIndex;
    }

    public void setProductsIndex(Integer productsIndex) {
        this.productsIndex = productsIndex;
    }

    public Double getTotalProducts() {
        return totalProducts;
    }

    public void setTotalProducts(Double totalProducts) {
        this.totalProducts = totalProducts;
    }

    public Double getHectareProducts() {
        return hectareProducts;
    }

    public void setHectareProducts(Double hectareProducts) {
        this.hectareProducts = hectareProducts;
    }

    public Double getProductionCost() {
        return productionCost;
    }

    public void setProductionCost(Double productionCost) {
        this.productionCost = productionCost;
    }

    public Integer getHectareIndex() {
        return hectareIndex;
    }

    public void setHectareIndex(Integer hectareIndex) {
        this.hectareIndex = hectareIndex;
    }

    public Double getHectare() {
        return hectare;
    }

    public void setHectare(Double hectare) {
        this.hectare = hectare;
    }

    public Double getBallogectars() {
        return ballogectars;
    }

    public void setBallogectars(Double ballogectars) {
        this.ballogectars = ballogectars;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Grounds grounds = (Grounds) o;
        return Objects.equals(company, grounds.company) && Objects.equals(productsIndex, grounds.productsIndex) && Objects.equals(totalProducts, grounds.totalProducts) && Objects.equals(hectareProducts, grounds.hectareProducts) && Objects.equals(productionCost, grounds.productionCost) && Objects.equals(hectareIndex, grounds.hectareIndex) && Objects.equals(hectare, grounds.hectare) && Objects.equals(ballogectars, grounds.ballogectars);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), company, productsIndex, totalProducts, hectareProducts, productionCost, hectareIndex, hectare, ballogectars);
    }

    @Override
    public String toString() {
        return "Grounds{" +
                "ynn=" + company.getYnn() +
                ", productsIndex=" + productsIndex +
                ", totalProducts=" + totalProducts +
                ", hectareProducts=" + hectareProducts +
                ", productionCost=" + productionCost +
                ", hectareIndex=" + hectareIndex +
                ", hectare=" + hectare +
                ", ballogectars=" + ballogectars +
                '}';
    }
}
