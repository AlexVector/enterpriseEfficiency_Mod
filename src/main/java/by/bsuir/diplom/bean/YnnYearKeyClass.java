package by.bsuir.diplom.bean;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

//@Embeddable
public class YnnYearKeyClass implements Serializable {
    private Integer ynn;
    private Integer year;

    public YnnYearKeyClass() {}

    public YnnYearKeyClass(Integer ynn, Integer year) {
        this.ynn = ynn;
        this.year = year;
    }

    public Integer getYnn() {
        return ynn;
    }

    public void setYnn(Integer ynn) {
        this.ynn = ynn;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        YnnYearKeyClass that = (YnnYearKeyClass) o;
        return Objects.equals(ynn, that.ynn) && Objects.equals(year, that.year);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ynn, year);
    }

    @Override
    public String toString() {
        return "YnnYearKeyClass{" +
                "ynn=" + ynn +
                ", year=" + year +
                '}';
    }
}
