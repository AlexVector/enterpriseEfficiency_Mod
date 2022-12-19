package test;


import by.bsuir.diplom.bean.Company;
import by.bsuir.diplom.service.ServiceException;
import by.bsuir.diplom.service.ServiceProvider;
import by.bsuir.diplom.service.api.CompanyService;
import org.junit.jupiter.api.Test;

import java.util.List;

public class TestClass {

    @Test
    void searchByNameTest(){

    }

    @Test
    void getFilterByAreaTest(){
        ServiceProvider provider = ServiceProvider.getInstance();
        CompanyService companyService = provider.getCompanyService();
        List<Company> companyList = null;
        try {
            companyList = companyService.getFilterByArea("МИНСКАЯ ОБЛАСТЬ");
        } catch (ServiceException e) {e.printStackTrace();}
        System.out.println(companyList.size());
        for (Company item: companyList){
            System.out.println(item);
        }
    }

    @Test
    void getFilterByDistrictTest(){
        ServiceProvider provider = ServiceProvider.getInstance();
        CompanyService companyService = provider.getCompanyService();
        List<Company> companyList = null;
        try {
            companyList = companyService.getFilterByDistrict("ЛИДСКИЙ");
        } catch (ServiceException e) {e.printStackTrace();}
        System.out.println(companyList.size());
        for (Company item: companyList){
            System.out.println(item);
        }
    }
}
