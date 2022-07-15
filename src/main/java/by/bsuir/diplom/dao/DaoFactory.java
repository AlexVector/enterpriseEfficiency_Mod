package by.bsuir.diplom.dao;

import by.bsuir.diplom.dao.api.*;

public class DaoFactory {
    private static final DaoFactory instance = new DaoFactory();

    private DaoFactory() {
    }

    private final AddressDao addressDao = new AddressDao();

    private final CattleDao cattleDao = new CattleDao();

    private final CoefficientsDao coefficientsDao = new CoefficientsDao();

    private final CompanyDao companyDao = new CompanyDao();

    private final CompanyInfoDao companyInfoDao = new CompanyInfoDao();

    private final CorrelationDao correlationDao = new CorrelationDao();

    private final CropProductionDao cropProductionDao = new CropProductionDao();

    private final DairyProductsDao dairyProductsDao = new DairyProductsDao();

    private final EnterpriseStatisticDao enterpriseStatisticDao = new EnterpriseStatisticDao();

    private final ExpensesDao expensesDao = new ExpensesDao();

    private final FixedAssetsDao fixedAssetsDao = new FixedAssetsDao();

    private final GroundsDao groundsDao = new GroundsDao();

    private final HeaderDao headerDao = new HeaderDao();

    private final SalesReturnDao salesReturnDao = new SalesReturnDao();

    private final StaffDao staffDao = new StaffDao();

    private final UserDao userDao = new UserDao();

    public static DaoFactory getInstance() {
        return instance;
    }

    public AddressDao getAddressDao() {
        return addressDao;
    }

    public CattleDao getCattleDao() {
        return cattleDao;
    }

    public CoefficientsDao getCoefficientsDao() {
        return coefficientsDao;
    }

    public CompanyDao getCompanyDao() {
        return companyDao;
    }

    public CompanyInfoDao getCompanyInfoDao() {
        return companyInfoDao;
    }

    public CorrelationDao getCorrelationDao() {
        return correlationDao;
    }

    public CropProductionDao getCropProductionDao() {
        return cropProductionDao;
    }

    public DairyProductsDao getDairyProductsDao() {
        return dairyProductsDao;
    }

    public EnterpriseStatisticDao getEnterpriseStatisticDao() {
        return enterpriseStatisticDao;
    }

    public ExpensesDao getExpensesDao() {
        return expensesDao;
    }

    public FixedAssetsDao getFixedAssetsDao() {
        return fixedAssetsDao;
    }

    public GroundsDao getGroundsDao() {
        return groundsDao;
    }

    public HeaderDao getHeaderDao() {
        return headerDao;
    }

    public SalesReturnDao getSalesReturnDao() {
        return salesReturnDao;
    }

    public StaffDao getStaffDao() {
        return staffDao;
    }

    public UserDao getUserDao() {
        return userDao;
    }
}
