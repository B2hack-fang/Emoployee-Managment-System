package org.logic;

import org.CURD.CURD;
import org.DTO.EmployeeDTO;

import java.util.Scanner;


public class Logic {
   private final int  InstertData = 1;
   private final int UpdateData = 2;
   private final int DeleteData = 3;
   private final int ReadData = 4;
   private final int Exit = 5;
   private static int MaxAttemp = 3;
    private String fullname;
   private String UserName ;
   private String Password;
   private String Address;
   private int Salary;
   private CURD Curd;
    public Logic(){
       Curd = new CURD();
        }
        public void doStart(){
            Scanner Sc = new Scanner(System.in);
            int attemp = 0;
            while (true){
                System.out.println("\n --------MENU-------");
                System.out.println("Press 1: INSERT");
                System.out.println("Press 2: UPDATE");
                System.out.println("Press 3: DELETE");
                System.out.println("Press 4: READ");
                System.out.println("Press 5: EXIT");
                System.out.println("ENTER YOUR CHOICE");
                 int Choice ;
                 try {
                     Choice = Sc.nextInt();
                 }
                 catch (Exception e){
                     System.out.println("Enter Number between ! To 5");
                     Sc.nextLine();
                     attemp ++;
                     if (attemp > MaxAttemp){
                         System.out.println("You have reached the limit");
                         Sc.close();
                         return;
                     }
                     continue;
                     }
                if (Choice <1 || Choice > 5){
                    System.out.println("Invalid Input!Please take a value from 1 to 5.\n");
                    attemp++;
                    if (attemp > MaxAttemp){
                        System.out.println("You have reached the limit");
                        Sc.close();
                        return;
                    }


                     }
                switch (Choice){
                    case  1:
                        System.out.println("INSERT DATA");
                        System.out.println(" ENTER USERNAME");
                         UserName = Sc.next();
                        System.out.println("ENTER PASSWORD");
                        Password=Sc.next();
                        Sc.nextLine();
                        System.out.println("ENTER FULLNAME");
                        fullname=Sc.nextLine();
                        System.out.println("ENTER ADDRESS");
                        Address=Sc.nextLine();
                        System.out.println("ENTER SALARY");
                        Salary=Sc.nextInt();

                        EmployeeDTO Emp = new EmployeeDTO(UserName,Password,fullname,Address,Salary);
                          Curd.insert(Emp);
                          break;
                    case 2:
                              System.out.println("UPDATE DATA");
                        System.out.println("USERNAME");
                        UserName = Sc.next();
                        System.out.println("Salary");
                        Salary = Sc.nextInt();
                        Curd.Update(UserName,Salary);
                        break;
                    case 3:
                        System.out.println("DELETE DATA");
                        System.out.println("Enter User name");
                        UserName = Sc.next();
                         Curd.deleteData(UserName);
                         break;
                    case 4:
                        System.out.println("Create User");
                        System.out.println("Enter Salary");
                        Salary = Sc.nextInt();
                        System.out.println("Enter UserName");
                        UserName = Sc.next();
                        Curd.CreateTable();

                    case 5:
                        System.out.println("Exit");
                        Sc.close();
                        return;



                 }




            }

    }







}
