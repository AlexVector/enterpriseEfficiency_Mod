package by.bsuir.diplom.service;

import by.bsuir.diplom.service.api.*;
import by.bsuir.diplom.service.impl.*;

public final class ServiceProvider {

    private static final ServiceProvider instance = new ServiceProvider();

    private ServiceProvider() {
    }

    private final AddressService addressService = new AddressServiceImpl();

    private final CattleService cattleService = new CattleServiceImpl();

    private final CoefficientsService coefficientsService = new CoefficientsServiceImpl();

    private final CompanyInfoService companyInfoService = new CompanyInfoServiceImpl();

    private final CompanyService companyService = new CompanyServiceImpl();

    private final CorrelationService correlationService = new CorrelationServiceImpl();

    private final CropProductionService cropProductionService = new CropProductionServiceImpl();

    private final DairyProductsService dairyProductsService = new DairyProductsServiceImpl();

    private final ExpensesService expensesService = new ExpensesServiceImpl();

    private final FixedAssetsService fixedAssetsService = new FixedAssetsServiceImpl();

    private final GroundsService groundsService = new GroundsServiceImpl();

    private final SalesReturnService salesReturnService = new SalesReturnsServiceImpl();

    private final StaffService staffService = new StaffServiceImpl();

    private final UserService userService = new UserServiceImpl();

    public static ServiceProvider getInstance() {
        return instance;
    }

    public AddressService getAddressService() {
        return addressService;
    }

    public CattleService getCattleService() {
        return cattleService;
    }

    public CoefficientsService getCoefficientsService() {
        return coefficientsService;
    }

    public CompanyInfoService getCompanyInfoService() {
        return companyInfoService;
    }

    public CompanyService getCompanyService() {
        return companyService;
    }

    public CorrelationService getCorrelationService() {
        return correlationService;
    }

    public CropProductionService getCropProductionService() {
        return cropProductionService;
    }

    public DairyProductsService getDairyProductsService() {
        return dairyProductsService;
    }

    public ExpensesService getExpensesService() {
        return expensesService;
    }

    public FixedAssetsService getFixedAssetsService() {
        return fixedAssetsService;
    }

    public GroundsService getGroundsService() {
        return groundsService;
    }

    public SalesReturnService getSalesReturnService() {
        return salesReturnService;
    }

    public StaffService getStaffService() {
        return staffService;
    }

    public UserService getUserService() {
        return userService;
    }
}