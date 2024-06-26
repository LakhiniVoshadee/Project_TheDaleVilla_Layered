package lk.ijse.dao;

import lk.ijse.dao.custom.CustomerDAO;
import lk.ijse.dao.custom.EmployeeDAO;
import lk.ijse.dao.custom.RentDAO;
import lk.ijse.dao.custom.RoomDAO;
import lk.ijse.dao.custom.impl.CustomerDAOImpl;
import lk.ijse.dao.custom.impl.EmployeeDAOImpl;
import lk.ijse.dao.custom.impl.RentDAOImpl;
import lk.ijse.dao.custom.impl.RoomDAOImpl;

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
                return new CustomerDAOImpl();
                case EMPLOYEE:
                    return new EmployeeDAOImpl();
                    case ROOM:
                        return new RoomDAOImpl();
                        case RENT:
                            return new RentDAOImpl();
            default:
                return null;
        }
    }
}
