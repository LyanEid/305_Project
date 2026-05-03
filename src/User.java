package org.example;

import java.io.Serializable;
import java.sql.SQLException;

public class User implements Serializable {

    private String F_name;
    private String L_name;
    private String email;
    private String passportNumber;
    private int userID;
    private static int count = 0;
    DB db = DB.getInstance();
    public User(String F_name, String L_name, String email, String passportNumber) {
        this.F_name = F_name;
        this.L_name = L_name;
        this.email = email;
        this.passportNumber = passportNumber;
        userID = count;
        count++;
    }

    public String getF_name() {
        return F_name;
    }

    public void setF_name(String f_name) throws SQLException {
        F_name = f_name;
        db.update("Update User set L_name ="+f_name+", where user_id ="+userID);

    }

    public String getL_name() {
        return L_name;
    }

    public void setL_name(String l_name) throws SQLException {
        L_name = l_name;

        db.update("Update User set L_name ="+l_name+", where user_id ="+userID);


    }

    public String getEmail() {
        return email;


    }

    public void setEmail(String email) throws SQLException {
        this.email = email;
        db.update("Update User set email ="+email+", where user_id ="+userID);
    }

    public String getPassportNumber() {
        return passportNumber;
    }

    public int getUserID() {
        return userID;
    }

    public void setPassportNumber(String passportNumber) throws SQLException {
        this.passportNumber = passportNumber;
        db.update("Update User set passport_number ="+passportNumber+", where user_id ="+userID);

    }
}
