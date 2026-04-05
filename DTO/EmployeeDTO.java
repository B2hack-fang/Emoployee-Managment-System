package org.DTO;

public class EmployeeDTO {
    private String UserName ;
    private String Password ;
    private  String Fullname ;
    private String Address;
    private int Salary ;
     public EmployeeDTO(){

     }
    public EmployeeDTO(String userName, String password, String fullname, String address, int salary) {
         super();
         this.UserName = userName;
         this.Password = password;
         this.Fullname = fullname;
         this.Address = address;
         this.Salary = salary;

    }

    public String getPassword() {
        return Password;
    }
    public void setPassword( String password){
         this.Password = password;
    }

    public String getFullName() {
        return Fullname;
    }
    public void setFullname(String fullname){
         this.Fullname = fullname;
    }

    public int getSalary( ) {
     return Salary;
    }
   public  void  setSalary( int salary){
         this.Salary = salary;
   }
    public String getAddress() {
         return Address;
    }
    public void setAddress( String address){
         this.Address = address;
    }

    public String getUserName() {
         return UserName;

    }
    public void setUserName( String userName){
         this.UserName = userName;
    }
}
