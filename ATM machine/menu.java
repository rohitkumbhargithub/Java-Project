package project;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.*;

public class menu extends account{
    Scanner input = new Scanner(System.in);
    DecimalFormat moneyFormat = new DecimalFormat("'$'###, ##0.00");
    HashMap<Integer, Integer> data = new HashMap<Integer, Integer>();
    public void getLogin() throws IOException{
        int x = 1;
        do{
            try{
                data.put(123456789, 1234);
                data.put(987654321, 9876);
                System.out.println("-----WELCOME TO ATM PROJECT----\n");
                System.out.println("Enter your Customer Account Number: ");
                setCustomerAccNumber(input.nextInt());
                System.out.println("Enter your Customer Account Pin Number: ");
                setPinNumber(input.nextInt());
            }
            catch(Exception e){
                System.out.println("Invalid Number or Pin");
            }
            for(Entry<Integer, Integer> entry:data.entrySet()){
                if(entry.getKey()==getCustomerAccNumber() && entry.getValue()==getPinNumber()){
                    getAccountType();
                }
            }
            System.out.println("Wrong Customer Number Or Pin");
        }while(x==1);
    }
    int select;
    //Display Account Type Menu
    public void getAccountType(){
        System.out.println("--------MENU-------");
        System.out.println("Select the Account you want to access");
        System.out.println("Enter 1: Checking Account Balance"+"\n"+
                           "Enter 2: Saving Account Balance"+"\n"+
                           "Enter 3: Exit()");
        System.out.println("Enter Choice: ");
        select = input.nextInt();
        switch(select){
            case 1:
                getChecking();
                break;
            case 2:
                getSaving();
                break;
            case 3: 
                System.out.println("THANK YOU FOR USING ATM, VISIT AGAIN..");
            default:
                System.out.println("Invalid Input"+"\n");
                getAccountType();
        }
    }
    //Display Checking Accoutn menu with Selection
    public void getChecking(){
        System.out.println("Checking Account");
        System.out.println("Enter 1: View Balance"+"\n"+
                           "Enter 2: Withdraw Funds"+"\n"+
                           "Enter 3: Deposite Funds"+"\n"+
                           "Enter 4: Exit()");
        System.out.println("Enter Choice: ");
        select = input.nextInt();
        switch(select){
            case 1:
                System.out.println("Checking Account Balance "+moneyFormat.format(getCheckBalance()));
                getAccountType();
                break;
            case 2:
                getCheckWithdrawalInput();
                getAccountType();
                break;
            case 3:
                getCheckDepositeInput();
                getAccountType();
                break;
            case 4:
                getAccountType();
                break;
            default:
                System.out.println("Invalid Input");
                getChecking();
        }
    }
    public void getSaving(){
        System.out.println("Saving Account");
        System.out.println("Enter 1: View Balance"+"\n"+
                           "Enter 2: Withdraw Funds"+"\n"+
                           "Enter 3: Deposite Funds"+"\n"+
                           "Enter 4: Exit()");
        System.out.println("Enter Choice: ");
        select = input.nextInt();
        switch(select){
            case 1:
                System.out.println("Checking Account Balance "+moneyFormat.format(getSavingBalance()));
                getAccountType();
                break;
            case 2:
                getCheckWithdrawalInput();
                getAccountType();
                break;
            case 3:
                getCheckDepositeInput();
                getAccountType();
                break;
            case 4:
                getAccountType();
                break;
            default:
                System.out.println("Invalid Input");
                getSaving();
        }
    }
}
