package shop;

import java.io.File;
import java.io.FileWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.sql.*;
public class Mainclass {
	 
	public static void main(String [] args)
	{
		Scanner obj = new Scanner(System.in);
		
		ArrayList<String> employee = new ArrayList<String>();
		ArrayList<String> leave = new ArrayList<String>();
		ArrayList<String> contractor = new ArrayList<String>();
		ArrayList<String> permanent = new ArrayList<String>();
		ArrayList<String> apply = new ArrayList<String>();
		
		String emp = "Employee.txt"; // creating Employee file
		try {
			File  fn = new File(emp);
			boolean b=fn.createNewFile();
		}
		catch(Exception e)
		{
		}
	    
		String lev = "Leave.txt"; // creating leave file
		try {
			File  fn = new File(lev);
			boolean b=fn.createNewFile();
		}
		catch(Exception e)
		{
		}
		
		String cont = "Contractor.txt"; // creating contractor file
		try {
			File  fn = new File(cont);
			boolean b=fn.createNewFile();
		}
		catch(Exception e)
		{
		}
		
		String aply = "apply.txt"; // creating apply file
		try {
			File  fn = new File(emp);
			boolean b=fn.createNewFile();
		}
		catch(Exception e)
		{
		}
		
		String per = "Permanent.txt"; // creating permanent file
		try {
			File  fn = new File(emp);
			boolean b=fn.createNewFile();
		}
		catch(Exception e)
		{
		}
		 
	    ArrayList<Employee> Earr =  new ArrayList<Employee>();
		for( ; ;) {
			int ch=0;
			do {
			System.out.println("1 : Insert Data of Employee");
			System.out.println("2 : Show All Employees");
			System.out.println("3 : Show Employees by ID");
			System.out.println("4 : Apply for leave");
			System.out.println("5 : Show All Employees who applied for leave");
			System.out.println("6 : Show All Employees whose leave Rejected");
			System.out.println("7 : Exit");
			ch = obj.nextInt();
			}while(ch==7);
			if(ch == 1) {
				System.out.println("Enter choice:"
						+ "\n1-For Normal Employee:"
						+ "\n2-For contractor:"
						+ "\n3-For permanent:");
				int choice=obj.nextInt();
				if(choice==1)
				{
				
				Employee e = new Employee();
				e.input(obj);
				Earr.add(e);
				String s = e.toString();
				employee.add(s);
				}
				else if(choice==2)
				{
					Employee c=new Contractor();
					c.input(obj);
					Earr.add(c);
					String s=c.toString();
					contractor.add(s);
					String s1=c.getcustomerStr();
					employee.add(s1);
				}
				else if(choice==3)
				{
					Employee p=new Permanent();
					p.input(obj);
					Earr.add(p);
					String s=p.toString();
					permanent.add(s);
					String s1=p.getcustomerStr();
					employee.add(s1);
				}

			} else if(ch == 2) {
				DBHandler db = new DBHandler();
    			ResultSet rs = db.getdata("select * from employee");
    			try {
    				while(rs.next())
    				{
    					String id = rs.getString("eid");
    					String Fname = rs.getString("fname");
    					String Lname = rs.getString("lname");
    					String des = rs.getString("designation");
    					System.out.println(id+"\t"+Fname+"\t"+Lname+"\t"+des);
    				}}
    				catch(Exception e) {}
			} else if(ch == 3) {
				int i;
    			System.out.println("Enter id:");
    			i=obj.nextInt();
    			DBHandler db = new DBHandler();
    			ResultSet rs = db.getdata("Select * from employee");
    			try {
    				while(rs.next())
    				{
    					String id = rs.getString("eid");
    					if(i==Integer.parseInt(id))
    					{
    						String fname = rs.getString("fname");
    						String lname = rs.getString("lname");
    						System.out.println(id+"\t"+fname+" "+lname);
    					}
    				}//while
    			} catch (SQLException e) {
    			}//try/catch
			} else if(ch == 4) {
				System.out.println("Enter id:");
				int i=obj.nextInt();
				Leave l = new Leave();
				l.input(obj);
				
					l.run();
				String s=l.toString();
				leave.add(s);
				System.out.println("press to continue....");
				int t=obj.nextInt();
				Apply ap = new Apply();
				ap.input(i, l.getlid());
				String s1=ap.toString();
				apply.add(s1);
			} else if(ch == 5) {
				DBHandler db = new DBHandler();
    			ResultSet rs = db.getdata("select * from employee where eid in(select eid from apply where lid in(select lid from leave))");
    			try {
    				while(rs.next())
    				{
    					String id = rs.getString("eid");
    					String Fname = rs.getString("fname");
    					String Lname = rs.getString("lname");
    					String des = rs.getString("designation");
    					System.out.println(id+"\t"+Fname+"\t"+Lname+"\t"+des);
    				}}
    				catch(Exception e) {}
			}else if(ch == 6) {
				DBHandler db = new DBHandler();
    			ResultSet rs = db.getdata("select * from employee where eid in(select eid from apply where lid in(select lid from leave where status='rejected'))");
    			try {
    				while(rs.next())
    				{
    					String id = rs.getString("eid");
    					String Fname = rs.getString("fname");
    					String Lname = rs.getString("lname");
    					String des = rs.getString("designation");
    					System.out.println(id+"\t"+Fname+"\t"+Lname+"\t"+des);
    				}}
    				catch(Exception e) {}
			}
			
			try {
				FileWriter fr=new FileWriter(emp,true);
				for(int i=0;i<employee.size();i++)
				{
					
					fr.write(employee.get(i));
					fr.write("\n\r");
				}
				fr.close();
			}catch(Exception e) {}
			
			try {
				FileWriter fr=new FileWriter(lev,true);
				for(int i=0;i<leave.size();i++)
				{
					
					fr.write(leave.get(i));
					fr.write("\n\r");
				}
				fr.close();
			}catch(Exception e) {}
			
			try {
				FileWriter fr=new FileWriter(cont,true);
				for(int i=0;i<contractor.size();i++)
				{
					
					fr.write(contractor.get(i));
					fr.write("\n\r");
				}
				fr.close();
			}catch(Exception e) {}
			
			try {
				FileWriter fr=new FileWriter(per,true);
				for(int i=0;i<permanent.size();i++)
				{
					
					fr.write(permanent.get(i));
					fr.write("\n\r");
				}
				fr.close();
			}catch(Exception e) {}
			
			try {
				FileWriter fr=new FileWriter(aply,true);
				for(int i=0;i<apply.size();i++)
				{
					
					fr.write(apply.get(i));
					fr.write("\n\r");
				}
				fr.close();
			}catch(Exception e) {}
			
			if(ch == 7) {
				break;
			}
			
		}
		
		obj.close(); // Moved the close statement outside the loop
	}//main function
}//class
