package by.bsuir.diplom.service.impl;

import by.bsuir.diplom.bean.Address;
import by.bsuir.diplom.dao.DaoFactory;
import by.bsuir.diplom.dao.api.AddressDao;
import by.bsuir.diplom.dao.exception.DaoException;
import by.bsuir.diplom.dao.utilities.SessionUtil;
import by.bsuir.diplom.service.api.AddressService;
import by.bsuir.diplom.service.ServiceException;

import java.util.List;

public class AddressServiceImpl extends SessionUtil implements AddressService {
    @Override
    public List<Address> getAll() throws ServiceException {
        List<Address> list;
        AddressDao addressDao = DaoFactory.getInstance().getAddressDao();
        try {
            openTransactionSession();
            addressDao.setSession(getSession());
            list = addressDao.getAll();
            commitTransactionSession();
        } catch (DaoException e) {
            rollbackTransactionSession();
            throw new ServiceException(e);
        } finally {
            closeSession();
        }
        return list;
    }

    @Override
    public void delete(Integer ynn) throws ServiceException {
        if (ynn == null || ynn < 1) {
            throw new ServiceException("Wrong ynn for delete address");
        }
        AddressDao addressDao = DaoFactory.getInstance().getAddressDao();
        try {
            openTransactionSession();
            addressDao.setSession(getSession());
            addressDao.delete(ynn);
            commitTransactionSession();
        } catch (DaoException e) {
            rollbackTransactionSession();
            throw new ServiceException(e);
        } finally {
            closeSession();
        }
    }

    @Override
    public void edit(Address address) throws ServiceException {
        if (address == null) {
            throw new ServiceException("Address info doesn't exist");
        }
        AddressDao addressDao = DaoFactory.getInstance().getAddressDao();
        try {
            openTransactionSession();
            addressDao.setSession(getSession());
            addressDao.edit(address);
            commitTransactionSession();
        } catch (DaoException e) {
            rollbackTransactionSession();
            throw new ServiceException(e);
        } finally {
            closeSession();
        }
    }

    @Override
    public Address getAddress(Integer ynn) throws ServiceException {
        if (ynn == null || ynn < 1) {
            throw new ServiceException("Impossible to get address info!");
        }
        Address address;
        AddressDao addressDao = DaoFactory.getInstance().getAddressDao();
        try {
            openTransactionSession();
            addressDao.setSession(getSession());
            address = addressDao.getAddress(ynn);
            commitTransactionSession();
        } catch (DaoException e) {
            rollbackTransactionSession();
            throw new ServiceException(e);
        } finally {
            closeSession();
        }
        return address;
    }

    @Override
    public List<String> getAreas() throws ServiceException {
        List<String> list;
        AddressDao addressDao = DaoFactory.getInstance().getAddressDao();
        try {
            openTransactionSession();
            addressDao.setSession(getSession());
            list = addressDao.getAreas();
            commitTransactionSession();
        } catch (DaoException e) {
            rollbackTransactionSession();
            throw new ServiceException(e);
        } finally {
            closeSession();
        }
        return list;
    }

    @Override
    public List<String> getDistrict(String area) throws ServiceException {
        if (area == null || "".equals(area)) {
            throw new ServiceException("Wrong text for selecting districts");
        }
        List<String> list;
        AddressDao addressDao = DaoFactory.getInstance().getAddressDao();
        try {
            openTransactionSession();
            addressDao.setSession(getSession());
            list = addressDao.getDistrict(area);
            commitTransactionSession();
        } catch (DaoException e) {
            rollbackTransactionSession();
            throw new ServiceException(e);
        } finally {
            closeSession();
        }
        return list;
    }
}
