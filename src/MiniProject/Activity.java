package MiniProject;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Date;
import java.util.Scanner;
import static java.lang.System.exit;


public class Activity{

    int bal = 0, dep, with;
    Scanner sc = new Scanner(System.in);
    Customer obj1 = new Customer();
    String fileBal;
    String fileAcc;
    String fileRec;
    String fileUD;

    int condition;

    void createAccount() {


        System.out.println("\t\t* * * * WELCOME TO \"JAVA\" BANK * * * * ");
        System.out.println();

        System.out.print("First Name : ");
        obj1.fname = sc.next();

        System.out.print("\nLast Name : ");
        obj1.lname = sc.next();

        System.out.print("\nDate Of Birth (dd/mm/yy) : ");
        obj1.dob = sc.next();

        System.out.print("\nNIC No : ");
        obj1.setNic(sc.next());

        System.out.print("\nTelephone No : ");
        obj1.tel = sc.next();

        System.out.print("\nENTER YOUR FIRST DEPOSIT AMOUNT : ");

        try{
            dep = sc.nextInt();
            bal = dep;
            System.out.println("\nYOUR ACCOUNT HAS CREATED SUCCESSFULLY!!!!");

            int min = 1000;
            int max = 5000;

            obj1.setAcc((int)(Math.random() * (max - min + 1) + min));

            System.out.println("Your Account Number Is " + obj1.getAcc()+ "\n");
            fileAcc= Integer.toString(obj1.getAcc());
            fileBal="Balance\\"+fileAcc+".txt"; //Balance\\1212.txt
            fileRec="Records\\"+fileAcc+".txt";
            fileUD="UserDetails\\"+fileAcc+".txt";




        }catch(Exception e){
            System.out.println("PLEASE ENTER NUMERIC VALUE");
            validate();

        }




        try{


            File filelst =new File(fileBal);
            filelst.createNewFile();
            FileWriter fileWriterlst =new FileWriter(fileBal);
            File file =new File(fileUD);
            file.createNewFile();
            FileWriter fileWriter =new FileWriter(fileUD);
            File file2 =new File(fileRec);
            file2.createNewFile();
            FileWriter fileWriter2 =new FileWriter(fileRec);
            fileWriter.write("Account Number : "+obj1.getAcc()+"\n");
            fileWriter.write("First name: "+obj1.fname+"\n");
            fileWriter.write("Last name: "+obj1.lname+"\n");
            fileWriter.write("Date of Birth: "+obj1.dob+"\n");
            fileWriter.write("NIC No: "+obj1.getNic()+"\n");
            fileWriter.write("Telephone No: "+obj1.tel+"\n");
            fileWriter2.write("You have Deposited: "+dep+" LKR \n");
            fileWriter2.write("Date and time of the transaction: "+ new Date()+"\n\n\n");
            fileWriterlst.write(dep+"\n");
            fileWriterlst.close();
            fileWriter.close();
            fileWriter2.close();

        }catch(Exception e){
            System.out.println("UNEXPECTED ERROR");
        }
        //System.out.println("\n* * * * Press any key to continue... * * * * ");
        validate();

    }

    void menu() {

        System.out.println("\t\t* * * * WELCOME TO \"JAVA\" BANK * * * * ");
        System.out.println();

        System.out.print("Activities Menu\n");

        System.out.print("\n\t1. Withdraw\n");
        System.out.print("\t2. Deposit\n");
        System.out.print("\t3. Balance Check\n");
        System.out.print("\t4. Transfer Money\n");
        System.out.print("\t5. Transaction History\n");
        System.out.print("\t6. Exit\n");

    }

    void moneyTrans() {

        int tAmount, tAcc;


        System.out.print("Enter a Account Number You Want To Transfer : ");
        tAcc = sc.nextInt();




            System.out.print("Enter The Amount To Transfer : ");
            tAmount = sc.nextInt();

            if (bal < tAmount) {

                System.out.print("YOUR BALANCE IS INSUFFICIENT\n\n");
                moneyTrans();

            } else {
                System.out.print("MONEY TRANSFERED SUCCESSFULL \n\n");

                bal -= tAmount;
            }

            try {
                FileWriter fileWriterlst =new FileWriter(fileBal);
                fileWriterlst.write(bal+"\n");
                fileWriterlst.close();
                BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileRec, true));

                bufferedWriter.write(tAmount + " LKR has transfered from this account to " + tAcc + "\n");
                bufferedWriter.write("Date and time of the transaction: " + new Date() + "\n\n\n");

                bufferedWriter.close();

            } catch (Exception e) {
                System.out.println("UNEXPECTED ERROR");
            }

        }


        void withdraw () {
            System.out.print("* * * WITHDRAW MONEY * * *\n\n");


            System.out.print("Enter The Amount You Want To Withdraw : ");
            with = sc.nextInt();

            if (bal < with) {


                System.out.println("YOUR BALANCE IS INSUFFICIENT");
            } else {

                bal -= with;

                System.out.println("\nYOU WITHDRAWED" + with + " LKR");
                System.out.println("\nBALANCE OF THE ACCOUNT IS " + bal + "LKR\n");


            }
            try {
                BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileRec, true));

                bufferedWriter.write(with + " LKR has Withrawed from this account  \n");
                bufferedWriter.write("Date and time of the transaction: " + new Date() + "\n\n\n");

                bufferedWriter.close();

                FileWriter fileWriterlst =new FileWriter(fileBal);
                fileWriterlst.write(bal+"\n");
                fileWriterlst.close();

            } catch (Exception e) {
                System.out.println("INVALID INPUT");
            }

        }


    void deposit() {

        System.out.print("\n* * * DEPOSIT MONEY * * *\n\n");

        System.out.print("Enter The Amount You Want To Deposit : ");

        dep = sc.nextInt();

        bal += dep;

        System.out.println("\nYOUR MONEY HAS DEPOSITED SUCCESSFULLY!!!");

        System.out.println("\nBALANCE OF THE ACCOUNT IS " + bal + "LKR\n");

        try{
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileRec, true));

            bufferedWriter.write(dep+" LKR has Deposited To this account \n");
            bufferedWriter.write("Date and time of the Deposit: "+ new Date()+"\n\n\n");

            bufferedWriter.close();

            FileWriter fileWriterlst =new FileWriter(fileBal);
            fileWriterlst.write(bal+"\n");
            fileWriterlst.close();

        }catch(Exception e){
            System.out.println("INVALID INPUT");
        }
    }

    void balCheck() {
        System.out.println("Your Balance : " + bal);
    }
 void history(){
     try{
         File file =new File(fileRec);
         Scanner scanner =new Scanner(file);

while(scanner.hasNextLine()){
    System.out.println(scanner.nextLine());
}


     }catch(Exception e){
         System.out.println("INVALID INPUT");
     }


    }
    void lastDetails() {
        try{
            File file =new File(fileUD);
            Scanner scanner =new Scanner(file);

            while(scanner.hasNextLine()){
                System.out.println(scanner.nextLine());
            }


        }catch(Exception e){
            System.out.println("INVALID INPUT");
        }

        System.out.print("\nBALANCE : " + bal);

    }

    void divid() {

        for (int i = 0; i < 60; i++) {
            System.out.print("-");
        }

    }

    void validate() {

        char select;
        System.out.println("Do you have an account? (Y/N)");
        select = sc.next().charAt(0);

        if (select == 'N' || select == 'n') {
            createAccount();

        } else if (select == 'Y' || select == 'y') {
            int input;
            int actNo;

            System.out.print("Account Number :  ");
            input = sc.nextInt();
            fileAcc= Integer.toString(input);
            fileBal="Balance\\"+fileAcc+".txt";
            fileRec="Records\\"+fileAcc+".txt";
            fileUD="UserDetails\\"+fileAcc+".txt";
            try{
                File filelst =new File(fileBal);
                Scanner scanner =new Scanner(filelst);
                    String temp =scanner.nextLine();
                    bal=Integer.valueOf(temp);
                 condition = 1;



            }catch(Exception e){
                System.out.println("INVALID ACCOUNT NUMBER\n");

            }



            if (condition==1) {
                label:
                while (true) {
                    menu();
                    System.out.print("\nEnter The Activity No : ");
                    actNo = sc.nextInt();

                    switch (actNo) {

                        case 1:
                            withdraw();

                            continue label;


                        case 2:
                            deposit();
                            break;

                        case 3:
                            balCheck();
                            break;

                        case 4:
                            moneyTrans();
                            break;

                        case 5:
                               history();
                             break;
                        case 6:
                            lastDetails();
                            exit(0);
                            break;

                        default:
                            System.out.print("INVALID INPUT");

                    }

                }

            }
            else {
                System.out.println("You have to create an account first");
                validate();
            }
        }
    }

}