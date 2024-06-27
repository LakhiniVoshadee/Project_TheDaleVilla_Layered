package lk.ijse.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DataValidateController {

    //Employee Form

    public static boolean validateEmpName(String name) {
        String nameRegex = "^[A-z|\\\\s]{3,}$";
        Pattern pattern = Pattern.compile(nameRegex);
        Matcher matcher = pattern.matcher(name);
        return matcher.matches();
    }

    public static boolean validateEmpType(String type) {
        String typeRegex = "^[A-z|\\\\s]{3,}$";
        Pattern pattern = Pattern.compile(typeRegex);
        Matcher matcher = pattern.matcher(type);
        return matcher.matches();
    }

    public static boolean validateEmail(String email) {
        String emailRegex = "^([A-z])([A-z0-9.]){1,}[@]([A-z0-9]){1,10}[.]([A-z]){2,5}$";
        Pattern pattern = Pattern.compile(emailRegex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }



    //Customer Form
    public static boolean vaidateCusName(String name) {
        String nameRegex = "^[A-z|\\\\s]{3,}$";
        Pattern pattern = Pattern.compile(nameRegex);
        Matcher matcher = pattern.matcher(name);
        return matcher.matches();

    }

    public static boolean validateCusSex(String sex){
        String sexRegex = "^[A-z|\\\\s]{3,}$";
        Pattern pattern = Pattern.compile(sexRegex);
        Matcher matcher = pattern.matcher(sex);
        return matcher.matches();

    }

    public static boolean validateCusNIC(String nic){
        String nicRegex = "^([0-9]{9}[x|X|v|V]|[0-9]{12})$";
        Pattern pattern = Pattern.compile(nicRegex);
        Matcher matcher = pattern.matcher(nic);
        return matcher.matches();
    }

    public static boolean validateCusContact(String contact){
        String contactRegex = "^([+]94{1,3}|[0])([1-9]{2})([0-9]){7}$";
        Pattern pattern = Pattern.compile(contactRegex);
        Matcher matcher = pattern.matcher(contact);
        return matcher.matches();
    }

    public static boolean validateCusEmail1(String email){
        String emailRegex = "^([A-z])([A-z0-9.]){1,}[@]([A-z0-9]){1,10}[.]([A-z]){2,5}$";
        Pattern pattern = Pattern.compile(emailRegex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    //Food Form

    public static boolean validateDescription(String description){
        String descriptionRegex = "^[A-z|\\\\s]{3,}$";
        Pattern pattern = Pattern.compile(descriptionRegex);
        Matcher matcher = pattern.matcher(description);
        return matcher.matches();
    }

    //Room Form
    public static boolean validateRoomType(String type){
        String typeRegex = "^[A-z|\\\\s]{3,}$";
        Pattern pattern = Pattern.compile(typeRegex);
        Matcher matcher = pattern.matcher(type);
        return matcher.matches();
    }

    public static boolean validateQty(String qty){
        String qtyRegex = "^\\d+$";
        Pattern pattern = Pattern.compile(qtyRegex);
        Matcher matcher = pattern.matcher(qty);
        return matcher.matches();
    }

    public static boolean validateUp(String up){
        String upRegex = "^([0-9]){1,}[.]([0-9]){1,}$";
        Pattern pattern = Pattern.compile(upRegex);
        Matcher matcher = pattern.matcher(up);
        return matcher.matches();
    }


    //Rent Form
    public static boolean validateRentType(String rentType){
        String typeRegex = "^[A-z|\\\\s]{3,}$";
        Pattern pattern = Pattern.compile(typeRegex);
        Matcher matcher = pattern.matcher(rentType);
        return matcher.matches();
    }

    public static boolean validateRentQty(String rentQty){
        String qtyRegex = "^\\d+$";
        Pattern pattern = Pattern.compile(qtyRegex);
        Matcher matcher = pattern.matcher(rentQty);
        return matcher.matches();
    }

    public static boolean validateRentDescription(String rentDescription){
        String rentDescriptionRegex = "^[A-z|\\\\s]{3,}$";
        Pattern pattern = Pattern.compile(rentDescriptionRegex);
        Matcher matcher = pattern.matcher(rentDescription);
        return matcher.matches();

    }

    public static boolean validateRentUnitPrice(String rentUnitPrice){
        String upRegex = "^([0-9]){1,}[.]([0-9]){1,}$";
        Pattern pattern = Pattern.compile(upRegex);
        Matcher matcher = pattern.matcher(rentUnitPrice);
        return matcher.matches();
    }

}