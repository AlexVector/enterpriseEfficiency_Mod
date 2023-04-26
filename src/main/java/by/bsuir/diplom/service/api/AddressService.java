package by.bsuir.diplom.service.api;

import by.bsuir.diplom.bean.Address;
import by.bsuir.diplom.service.ServiceException;

import java.util.List;

public interface AddressService {

    List<Address> getAll() throws ServiceException;

    /**
     * Method for deleting address
     *
     * @param com_id of address
     * @throws ServiceException when the error occurred on the dao layer or when validate data
     */
    void delete(Integer com_id) throws ServiceException;

    /**
     * Method for validating data before edit address in database
     *
     * @param address new info about address
     * @throws ServiceException when the error occurred on the dao layer or when validate data
     */
    void edit(Address address) throws ServiceException;

    /**
     * Method for getting address info
     *
     * @param com_id address com_id
     * @return object of {@code Address} with needed info
     * @throws ServiceException when the error occurred on the dao layer or when validate data
     */
    Address getAddress(Integer com_id) throws ServiceException;

    List<String> getAreas() throws ServiceException;

    List<String> getDistrict(String area) throws ServiceException;

    List<String> getAllDistricts() throws ServiceException;
}
