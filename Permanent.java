package shop;

import java.util.Scanner;

public class Permanent extends Employee{
    
	int salary;
	 public void input(Scanner s)
	 {
	 	System.out.println("Enter Employee Data:\n"
				+ "id:");
		super.eid=s.nextInt();
		System.out.println("fname:");
		super.fname=s.next();
		System.out.println("lname:");
		super.lname=s.next();
		System.out.println("Designation:");
		super.designation=s.next();
    	System.out.println("gender:");
    	super.gender=s.next();
		 System.out.println("Enter hourly salary:");
		this.salary=s.nextInt();
		 this.insertToDB(this.getInQuery());
	 }
	 
	 public String getcustomerStr()
	 {
		 String s =super.eid+" : "+super.fname+" : "+super.lname+" : "+super.designation+" : "+super.gender;
		 return s;
	 }
	 
	 public void insertToDB(String q) //query run function
	 {
	 	
	 	DBHandler db = new DBHandler();
	 	db.dbconnection(q);
	 }//query run function

	 public String toString()
	 {
	 	String s=super.eid+" : "+salary;
	 	return s;
	 }
	 
	 public String getInQuery()//query generator function
	 {
		String q= "insert into employee values("+super.eid+",'"+super.fname+"','"+super.lname+"','"+super.designation+"',"+super.gender+"'); insert into permanent values("+super.eid+","+salary+");"; 
	 	return q;
	 }//query generator function
	 
}
