package lk.ijse.dao;

import lk.ijse.dao.custom.CustomerDAO;
import lk.ijse.dao.custom.EmployeeDAO;

public class DAOFactory {
    private static DAOFactory daoFactory;

    private DAOFactory() {

    }
    public static DAOFactory getDaoFactory() {
        return (daoFactory == null) ? daoFactory = new DAOFactory() : daoFactory;
    }

    public enum DAOTypes{
        CUSTOMER,EMPLOYEE,ROOM,RENT
    }

    public SuperDAO getDAO(DAOTypes type) {
        switch (type) {
            case CUSTOMER:
                return new CustomerDAO();
                case EMPLOYEE:
                    return new EmployeeDAO();
        }
    }
}
