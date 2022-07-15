package by.bsuir.diplom.bean;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@javax.persistence.Entity
@Table(name = "address", schema = "company_db")
public class Address implements Serializable {

    @Id
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ynn")
    private Company company;

    @Column(name = "address", nullable = true, length = 250)
    private String location;

    @Column(name = "area", nullable = false, length = 20)
    private String area;

    @Column(name = "district", nullable = false, length = 45)
    private String district;

    public Address() {
    }

    public Address(Integer ynn, String area, String district) {
        this.company = new Company(ynn);
        this.area = area;
        this.district = district;
    }

    public Address(Integer ynn, String location, String area, String district) {
        this.company = new Company(ynn);
        this.location = location;
        this.area = area;
        this.district = district;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String address) {
        this.location = address;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address1 = (Address) o;
        return Objects.equals(company, address1.company) && Objects.equals(location, address1.location) && Objects.equals(area, address1.area) && Objects.equals(district, address1.district);
    }

    @Override
    public int hashCode() {
        return Objects.hash(company, location, area, district);
    }

    @Override
    public String toString() {
        return "Address{" +
                "ynn=" + company.getYnn() +
                ", address='" + location + '\'' +
                ", area='" + area + '\'' +
                ", district='" + district + '\'' +
                '}';
    }
}
