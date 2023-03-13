package by.bsuir.diplom.service;

import by.bsuir.diplom.bean.Company;

public class GTestResultClass {
    Company company;
    String anomaly_parameter;
    String anomaly_parameter_value;
    String anomaly_type;

    public GTestResultClass(Company company, String anomaly_parameter, String anomaly_parameter_value, String anomaly_type) {
        this.company = company;
        this.anomaly_parameter = anomaly_parameter;
        this.anomaly_parameter_value = anomaly_parameter_value;
        this.anomaly_type = anomaly_type;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public String getAnomaly_parameter() {
        return anomaly_parameter;
    }

    public void setAnomaly_parameter(String anomaly_parameter) {
        this.anomaly_parameter = anomaly_parameter;
    }

    public String getAnomaly_parameter_value() {
        return anomaly_parameter_value;
    }

    public void setAnomaly_parameter_value(String anomaly_parameter_value) {
        this.anomaly_parameter_value = anomaly_parameter_value;
    }

    public String getAnomaly_type() {
        return anomaly_type;
    }

    public void setAnomaly_type(String anomaly_type) {
        this.anomaly_type = anomaly_type;
    }

    @Override
    public String toString() {
        return "GTestResultClass{" +
                "company=" + company +
                ", anomaly_parameter='" + anomaly_parameter + '\'' +
                ", anomaly_parameter_value='" + anomaly_parameter_value + '\'' +
                ", anomaly_type='" + anomaly_type + '\'' +
                '}';
    }
}
