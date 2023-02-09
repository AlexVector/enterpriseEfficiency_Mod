package by.bsuir.diplom.service;

public class OptionDataKeeper {
    String rusParameterName;
    String engParameter;
    String parameterPrefix;
    String parameterFormat;

    public OptionDataKeeper(String rusParameterName, String engParameter, String parameterPrefix, String parameterFormat) {
        this.rusParameterName = rusParameterName;
        this.engParameter = engParameter;
        this.parameterPrefix = parameterPrefix;
        this.parameterFormat = parameterFormat;
    }

    public String getParameterPrefix() {
        return parameterPrefix;
    }

    public void setParameterPrefix(String parameterPrefix) {
        this.parameterPrefix = parameterPrefix;
    }

    public String getRusParameterName() {
        return rusParameterName;
    }

    public void setRusParameterName(String rusParameterName) {
        this.rusParameterName = rusParameterName;
    }

    public String getEngParameter() {
        return engParameter;
    }

    public void setEngParameter(String engParameter) {
        this.engParameter = engParameter;
    }

    public String getParameterFormat() {
        return parameterFormat;
    }

    public void setParameterFormat(String parameterFormat) {
        this.parameterFormat = parameterFormat;
    }
}
