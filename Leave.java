package shop;
import java.util.Scanner;
import java.util.Date;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Leave {
	int lid;
	String status,ltype;
	LocalDate edate;
	LocalDate sdate;
	
	public Leave() {}
	public void input(Scanner s)
	{
		System.out.println("Enter leave id:");
		lid=s.nextInt();
		s.nextLine();
		System.out.println("Enter leace Type:");
		ltype=s.nextLine();
		System.out.println("Enter leave start date as d/m/y:");
		int d1,m1,y1;
		d1=s.nextInt();
		System.out.print("-");
		m1=s.nextInt();
		System.out.print("-");
		y1=s.nextInt();
		
		System.out.println("Enter leave end date:");
		int d2,m2,y2;
		d2=s.nextInt();
		System.out.print("-");
		m2=s.nextInt();
		System.out.print("-");
		y2=s.nextInt();
		sdate = LocalDate.of(y1, m1, d1);
		edate = LocalDate.of(y2, m2, d2);
		
		
	       
		System.out.println("Enter prevoius leave days:");
		int days=s.nextInt();
		
		long daysDifference = ChronoUnit.DAYS.between(sdate, edate);
	       
		long totaldays = (daysDifference + days);
		System.out.println("Total days" + totaldays);
		 
		if(totaldays >= 20) {
			System.out.println("Your Leave rejected because your leave is greater than 20");
		 status = "rejected";
		}else {
			System.out.println("pending....");	
			System.out.println("Total days" + totaldays);
			 status = "pending";			
		}
        
	}
	public void run()
	{
		insertToDB(getInQuery());
	}
    public void insertToDB(String q) //query run function
    {
    	DBHandler db = new DBHandler();
    	db.dbconnection(q);
    }//query run function

    public String toString()
    {
    	String s=lid+" : "+sdate+" : "+edate+" : "+ltype+" : "+status;
    	return s;
    }
    
    public String getInQuery()//query generator function
    {
    	 String q = "INSERT INTO leave VALUES (" + lid + ",'" + sdate.getYear() + "-" + sdate.getMonthValue() + "-" + sdate.getDayOfMonth() + "','" + edate.getYear() + "-" + edate.getMonthValue() + "-" + edate.getDayOfMonth() + "','" + ltype + "','" + status + "')";
    	    System.out.println(q);
    	    return q;
    }//query generator function
    
    public int getlid()
    {
    	return lid;
    }
}
