package shop;

import java.util.ArrayList;

public class Apply {
	int empID, LeaveID;
	 
	 public void input(int e,int l)
	 {
		 empID=e;
		 LeaveID=l;
		 insertToDB(getInQuery());
	 }
	
	 public void insertToDB(String q) //query run function
	 {
	 	
	 	DBHandler db = new DBHandler();
	 	db.dbconnection(q);
	 }//query run function

	 public String toString()
	 {
	 	String s=empID+" : "+LeaveID;
	 	return s;
	 }
	 
	 public String getInQuery()//query generator function
	 {
		String q= "insert into apply values("+empID+","+LeaveID+");"; 
		System.out.println(q);
	 	return q;
	 }//query generator function
	 
}
