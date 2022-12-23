package project;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.*;

class account {
    Scanner input = new Scanner(System.in);
    DecimalFormat moneyFromat = new DecimalFormat("'$'###, ##0.00");
    private int customerAccNumber;
    private int pinNumber;
    private double checkBalance;
    private double savingBalance;
    //Create the customerAccNum
    public int setCustomerAccNumber(int customerAccNumber){
        this.customerAccNumber = customerAccNumber;
        return customerAccNumber;
    }
    public int setPinNumber(int pinNumber){
        this.pinNumber = pinNumber;
        return pinNumber;
    }
    public int getCustomerAccNumber(){
        return customerAccNumber;
    }
    public int getPinNumber(){
        return pinNumber;
    }
    public double getCheckBalance(){
        return checkBalance;
    }
    public double getSavingBalance(){
        return savingBalance;
    }
    //Calculate checking account withdraw
    public double calcCheckWithdrawal(double amount){
        checkBalance = (checkBalance - amount);
        return checkBalance;
    }
    //Calculate Saving Balance account withdrawal
    public double calSavingWithdrawal(double amount){
        savingBalance = (savingBalance - amount);
        return savingBalance;
    }
    //Calculate checking account deposite 
    public double calCheckDeposite(double amount){
        checkBalance = (checkBalance + amount);
        return checkBalance;
    }
    //Calculate saving account deposite
    public double calSavingDeposite(double amount){
        savingBalance = (savingBalance + amount);
        return savingBalance;
    }
    //Customer checking account wiithdrawal input
    public void getCheckWithdrawalInput(){
        System.out.println("Checking Account Balance "+moneyFromat.format(checkBalance));
        System.out.println("You want Amount to withdraw from Checking Account");
        double amount = input.nextInt();
        if((checkBalance - amount)>=0){
            calcCheckWithdrawal(amount);
            System.out.println("New Checking Account Balance : "+moneyFromat.format(checkBalance));
        }
        else{
            System.out.println("Balance cannot be less than ZERO"+"\n");
        }
    }
    //customer saving account withdraw input
    public void getSavingWithdrawInput(){
        System.out.println("Saving Account Balance "+moneyFromat.format(savingBalance));
        System.out.println("You want Amount to withdraw form Saving Account");
        double amount = input.nextDouble();
        if((savingBalance - amount)>=0){
            calSavingWithdrawal(amount);
            System.out.println("New Saving Account Balance : "+moneyFromat.format(savingBalance));
        }
        else{
            System.out.println("Balance cannot be less than ZERO"+"\n");
        }
    }
    public void getCheckDepositeInput(){
        System.out.println("Checking Account Balance "+moneyFromat.format(checkBalance));
        System.out.println("You want Amount to Deposite from Checking Account");
        double amount = input.nextDouble();
        if((checkBalance - amount)>=0){
            calCheckDeposite(amount);
            System.out.println("New Checking Account Balance : "+moneyFromat.format(checkBalance));
        }
        else{
            System.out.println("Balance cannot be less than ZERO"+"\n");
        }
    }
    public void getSavingDepositeInput(){
        System.out.println("Saving Account Balance: "+moneyFromat.format(savingBalance));
        System.out.println("You want you Amount to Deposite form Saving Account");
        double amount= input.nextDouble();
        if((savingBalance - amount)>=0){
            calSavingDeposite(amount);
            System.out.println("New Saving Account Balance: "+moneyFromat.format(savingBalance));
        }
        else{
            System.out.println("Balance cannot be less than ZERO"+"\n");
        }
    }
}  


public class atm2 extends account{
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


    public static void main(String args[]){
        atm2 m = new atm2();
        m.
    }
    
}
