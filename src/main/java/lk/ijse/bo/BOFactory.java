package lk.ijse.bo;

import lk.ijse.bo.custom.impl.CustomerBOImpl;
import lk.ijse.bo.custom.impl.EmployeeBOImpl;
import lk.ijse.bo.custom.impl.RentBOImpl;
import lk.ijse.bo.custom.impl.RoomBOImpl;

public class BOFactory {
    private static BOFactory boFactory;
    private BOFactory() {

    }

    public static BOFactory getBoFactory(){
        return (boFactory == null) ? boFactory = new BOFactory() : boFactory;
    }

    public enum BOTypes{
        CUSTOMER,EMPLOYEE,ROOM,RENT
    }

    public SuperBO getBO(BOTypes Type){
        switch (Type){
            case CUSTOMER:
                return new CustomerBOImpl();
                case EMPLOYEE:
                    return new EmployeeBOImpl();
                    case ROOM:
                        return new RoomBOImpl();
                        case RENT:
                            return new RentBOImpl();
            default:
                return null;
        }
    }
}
