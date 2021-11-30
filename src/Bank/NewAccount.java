/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bank;

import java.util.Scanner;

/**
 *
 * @author SE140861
 */
public class NewAccount {

    String ID;
    String username;
    String password;
    double amound;
    Scanner sc = new Scanner(System.in);

    public NewAccount() {
    }

    public NewAccount(String ID, String username, String password, double amound) {
        this.ID = ID;
        this.username = username;
        this.password = password;
        this.amound = amound;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public double getAmound() {
        return amound;
    }

    public void setAmound(double amound) {
        this.amound = amound;
    }

    @Override
    public String toString() {
        return "NewAccount{" + "ID=" + ID + ", username=" + username + ", password=" + password + ", amound=" + amound + '}';
    }
    
}
