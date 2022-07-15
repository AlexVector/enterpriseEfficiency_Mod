package by.bsuir.diplom.bean;

import javax.persistence.Column;
import javax.persistence.Table;
import java.util.Objects;

@javax.persistence.Entity
@Table(name = "header", schema = "company_db")
public class Header extends Entity{

    @Column(name = "text", nullable = false, length = -1)
    private String text;

    public Header() {
    }

    public Header(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Header header = (Header) o;
        return Objects.equals(text, header.text);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), text);
    }

    @Override
    public String toString() {
        return "Header{" +
                "text='" + text + '\'' +
                '}';
    }
}
