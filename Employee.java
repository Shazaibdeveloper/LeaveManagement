package shop;

import java.util.Scanner;
import java.sql.*;
public class Employee {
	int eid; 
    String fname,lname,designation,gender;
    
    public void input(Scanner s)
    {
    	System.out.println("Enter Employee Data:\n"
    			+ "id:");
    	eid=s.nextInt();
    	System.out.println("fname:");
    	fname=s.next();
    	System.out.println("lname:");
    	lname=s.next();
    	System.out.println("Designation:");
    	designation=s.next();
    	System.out.println("gender:");
    	gender=s.next();
    	insertToDB(getInQuery());
    }
    
    public void insertToDB(String q) //query run function
    {
    	
    	DBHandler db = new DBHandler();
    	db.dbconnection(q);
    }//query run function

    public String toString()
    {
    	String s=eid+" : "+fname+" : "+lname+" : "+designation+" : "+gender;
    	return s;
    }
    
    public String getInQuery()//query generator function
    {
 	String q= String.format("INSERT INTO employee VALUES ('%d','%s','%s','%s','%s')",eid,fname,lname,designation,gender); 
    	return q;
    }//query generator function

public int geteid()
{
	return eid;
}

	public String getcustomerStr() {
		// TODO Auto-generated method stub
		return null;
	}

    
}//class