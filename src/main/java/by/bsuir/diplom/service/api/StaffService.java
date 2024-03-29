package by.bsuir.diplom.service.api;

import by.bsuir.diplom.bean.Staff;
import by.bsuir.diplom.service.ServiceException;

import java.util.List;

public interface StaffService {

    List<Staff> getStaffToExport(Integer ynn) throws ServiceException;

    List<Staff> getAll() throws ServiceException;

    /**
     * Method for deleting staff
     *
     * @param com_id of staff
     * @throws ServiceException when the error occurred on the dao layer or when validate data
     */
    void delete(Integer com_id) throws ServiceException;

    /**
     * Method for validating data before edit staff in database
     *
     * @param staff new info about staff
     * @throws ServiceException when the error occurred on the dao layer or when validate data
     */
    void edit(Staff staff) throws ServiceException;

    /**
     * Method for getting staff info
     *
     * @param com_id staff com_id
     * @return object of {@code Staff} with needed info
     * @throws ServiceException when the error occurred on the dao layer or when validate data
     */
    List<Staff> getStaff(Integer com_id) throws ServiceException;
}
