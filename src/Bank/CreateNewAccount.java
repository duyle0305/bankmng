/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bank;

import java.util.ArrayList;
import java.util.Scanner;
import jdk.nashorn.internal.ir.BreakNode;

/**
 *
 * @author SE140861
 */
public class CreateNewAccount extends ArrayList<NewAccount> {

    Scanner sc = new Scanner(System.in);

    public int searchID(String ID) {
        ID = ID.trim().toUpperCase();
        for (int i = 0; i < this.size(); i++) {
            if (this.get(i).ID.equals(ID)) {
                return i;
            }
        }
        return -1;
    }

    public int searchAccound(String id, String pass) {
        id = id.trim().toUpperCase();
        pass = pass.trim();
        String checkPass;

        for (int i = 0; i < this.size(); i++) {
            checkPass = MyScanner.ceasarDecode(this.get(i).password);
            if (id.equals(this.get(i).ID) && pass.equals(checkPass)) {
                return i;
            }
        }
        return -1;
    }

    public int searchPWD(String pass) {
        pass = pass.trim();
        for (int i = 0; i < this.size(); i++) {
            if (this.get(i).password.equals(pass)) {
                return i;
            }
        }
        return -1;
    }

    public void addNewAccount() {
        String ID;
        String username;
        String password;
        String cpassword;
        double amound = 0;
        boolean chekID;
        do {
            ID = MyScanner.getNonBlankStr("Input ID");
            ID = ID.trim().toUpperCase();
            chekID = (this.searchID(ID) >= 0);
            if (chekID) {
                System.out.println("ID is duplicated!");
            }
        } while (chekID);
        username = MyScanner.getNonBlankStr("Input user name");
        boolean checkpassword;
        do {
            password = MyScanner.getNonBlankStr("Input password");
            checkpassword = MyScanner.password(password);
        } while (checkpassword == false);
        do {
            cpassword = MyScanner.getNonBlankStr("Input confirm password");
        } while (!cpassword.equals(password));
        password = MyScanner.ceasarCode(password);
        NewAccount Account = new NewAccount(ID, username, password, amound);
        this.add(Account);
    }

    public int Login() {
        String id;
        String pwd;
        id = MyScanner.getNonBlankStr("ID ");
        pwd = MyScanner.getNonBlankStr("Password ");
        int ok = this.searchAccound(id, pwd);
        if (ok < 0) {
            System.out.println(ok);
            System.out.println("You have entered your id or password incorrecly!");
            return -1;
        }
        System.out.println("Login successfuly");
        return ok;

    }

    public void Withdraw(int i) {
//        int i = Login();
        double addmoney;
        System.out.println("Enter ammounts you want to withdraw: ");
        addmoney = sc.nextDouble();
        if (addmoney > this.get(i).amound) {
            System.out.println("ERROR: ");
        } else {
            this.get(i).amound -= addmoney;
            System.out.println("Withdraw successfuly!");
        }
    }

    public void Deposit(int i) {
//        int i = Login();
        double addmoney;
        System.out.print("Enter amounts you want to deposit: ");
        addmoney = sc.nextDouble();
        boolean ok;
        ok = MyScanner.getBoolean("Are you sure you want to deposit " + addmoney + " $ ");
        if (ok == true) {
            this.get(i).amound += addmoney;
            System.out.println("Deposit successfuly!");
        }
    }

    public void TransferMoney(CreateNewAccount newAccount, int i) {
//        int i = Login();
        String recipientID;
        int check;
        System.out.println("Enter the account you wan to transfer money.");
        do {
            recipientID = MyScanner.getNonBlankStr("Input ID");
            check = newAccount.searchID(recipientID);
            if (check < 0) {
                System.out.println("The account doesn't exist!");
            }
        } while (check < 0);
        System.out.println(newAccount.get(check).username);
        double addmoney;
        System.out.print("Enter ammounts you want to transfer money:");
        addmoney = sc.nextDouble();
        if (addmoney > this.get(i).amound) {
            System.out.println("ERROR: ");
        } else {
            boolean ok;
            ok = MyScanner.getBoolean("Are you sure you want to transfer money " + addmoney + " $ ");
            if (ok == true) {
                this.get(i).amound -= addmoney;
                newAccount.get(check).amound += addmoney;
                System.out.println("Transfer money successfuly!");
            }
        }
    }

    public void deleteAccount(int i) {
//        int i=Login();
        boolean ok;
        ok = MyScanner.getBoolean("Are you sure you want to delete yourAccount? ");
        if (ok == true) {
            this.remove(i);
            System.out.println("Remove successfuly!");
        }
    }

    public void show() {
        for (NewAccount a : this) {
            System.out.println(a);
        }
    }

}
