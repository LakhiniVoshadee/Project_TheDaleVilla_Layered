package lk.ijse.bo;

import lk.ijse.bo.custom.impl.*;
//import lk.ijse.bo.custom.impl.RentBOImpl;
//import lk.ijse.bo.custom.impl.RoomBOImpl;

public class BOFactory {
    private static BOFactory boFactory;
    private BOFactory() {

    }

    public static BOFactory getBoFactory(){
        return (boFactory == null) ? boFactory = new BOFactory() : boFactory;
    }

    public enum BOTypes{
        CUSTOMER,EMPLOYEE,ROOM,RENT,Room_BOOKING,ROOM_DETAILS,ADMIN
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
                               case Room_BOOKING:
                                  return new RoomBookingBOImpl();
                                     case ROOM_DETAILS:
                                         return new RoomDetailsBOImpl();
                             case ADMIN:
                                  return new AdminBOImpl();
            default:
                return null;
        }
    }
}
