package project;

import java.util.*;
import java.text.DecimalFormat;

public class account {
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
