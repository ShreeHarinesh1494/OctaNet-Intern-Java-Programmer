import java.util.*;
import java.text.*;

class bal {
    int amt(int balance) {
        System.out.println("Your Current Balance is " + balance);
        System.out.print("------------------------------------------------------------");
        System.out.println();
        return balance;
    }
}

class cre {
    int cr(int balance, int credit, Date transactionTime) {
        System.out.println("Successfully Credited");
        balance += credit;
        System.out.println("Total Balance : " + balance);
        System.out.println("Transaction Time: " + transactionTime);
        System.out.print("------------------------------------------------------------");
        System.out.println();
        return balance;
    }
}

class wit {
    int wi(int balance, int withdraw, Date transactionTime) {
        if (withdraw > balance) {
            withdraw = 0;
            System.out.println("Insufficient Balance");
            System.out.println("Try Less than your Balance Amount : " + balance);
            System.out.print("------------------------------------------------------------");
            System.out.println();
        } else {
            System.out.println("Withdrawn Successfully");
            balance -= withdraw;
            System.out.println("Total Balance : " + balance);
            System.out.println("Transaction Time: " + transactionTime);
            System.out.print("------------------------------------------------------------");
            System.out.println();
        }
        return balance;
    }
}

class rec {
    void re(int balance, int withdraw, int credit, Date transactionTime) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println("Account History");
        System.out.println("Transaction Time: " + dateFormat.format(transactionTime));
        System.out.println("Available Balance : " + balance);
        System.out.println("Amount Deposited : " + credit);
        if(withdraw > balance){
            withdraw  = 0;
            System.out.println("Amount Withdrawn : " + withdraw);
        } else {
            System.out.println("Amount Withdrawn : " + withdraw);
        }
        System.out.println("Thank You !");
        System.out.println("Thanks for Coming");
        System.out.print("------------------------------------------------------------");
        System.out.println();
    }
}

class tra{
    int tre(int balance,int withdraw,int trans,int pin,int ac,int p, Date transactionTime)
    {
        if(pin==p)
        {
            if(trans<=balance)
                {
                    balance-=trans;
                    withdraw+=trans;
                    System.out.println("Transfer Successful");
                    System.out.println("Transaction Time: " + transactionTime);
                    System.out.print("------------------------------------------------------------");
                }
                else{
                        System.out.println("Insufficient Balance For Transfer");
                        System.out.print("------------------------------------------------------------");
                    }
        }
        else
            {
                System.out.println("Incorrect ATM Pin");
                System.out.print("------------------------------------------------------------");
            }
            return balance;
    }
}

public class intern {
    public static void main(String args[]) {
        bal b = new bal();
        cre c = new cre();
        wit w = new wit();
        rec r = new rec();
        tra t = new tra();
        Scanner sc = new Scanner(System.in);
        int pin = 1234;
        int balance = 5000;
        int credit = 0;
        int withdraw = 0;
        String name;

        System.out.println("Enter your pin no :");
        int password = sc.nextInt();
        sc.nextLine();

        if (password == pin) {
            System.out.println("Enter your Name :");
            name = sc.nextLine();
            System.out.println("Welcome " + name);
            System.out.println();

            while (true) {
                System.out.println("Press 1 to check your Balance");
                System.out.println("Press 2 to credit Money");
                System.out.println("Press 3 to Withdraw Money");
                System.out.println("Press 4 to take Receipt");
                System.out.println("Press 5 to Transfer Amount");
                System.out.println("Press 6 to change ATM Pin");
                System.out.println("Press 7 to Quit/Exit");
                int option = sc.nextInt();

                Date transactionTime = new Date(); // Get the current date and time

                switch (option) {
                    case 1:
                        balance = b.amt(balance);
                        break;

                    case 2:
                        System.out.println("How much Amount did you want to add to your Account : ");
                        credit = sc.nextInt();
                        balance = c.cr(balance, credit, transactionTime);
                        break;

                    case 3:
                        System.out.println("How much Amount do you want to Withdraw from your Account : ");
                        withdraw = sc.nextInt();
                        balance = w.wi(balance, withdraw, transactionTime);
                        break;

                    case 4:
                        r.re(balance, withdraw, credit, transactionTime);
                        break;

                    case 5 :  
                        System.out.println("Enter Account Number to Transfer Amount :");
                        int ac=sc.nextInt();
                        System.out.println("Enter the Amount To Transfer :");
                        int trans=sc.nextInt();
                        System.out.println("Enter ATM Pin to Transfer");
                        int p=sc.nextInt();
                        balance=t.tre(balance,withdraw,trans,pin,ac,p, transactionTime);
                        withdraw+=trans;
                        break;

                    case 6 :
                        System.out.println("Enter your NEW ATM Pin :");
                        int np=sc.nextInt();
                        pin=np;
                        System.out.println("ATM PIN Changed Successfully");
                        System.out.print("------------------------------------------------------------");
                        break;
                }

                if (option == 7) {
                    System.out.println("Thank You!");
                    break;
                }
            }
        } else {
            System.out.println("Password is Wrong");
            System.out.print("------------------------------------------------------------");
            System.out.println();
        }
    }
}
