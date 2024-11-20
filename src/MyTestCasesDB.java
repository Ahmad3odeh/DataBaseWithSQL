import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MyTestCasesDB {
	WebDriver driver=new ChromeDriver();
	
	
	Connection con;

	Statement stmt;
	
	ResultSet rs;

	@BeforeTest
	public void MySetUp() throws SQLException {
	
		
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/classicmodels","root","ahmad");
		
		
	}

	@Test(priority = 1)
	public void AddDataToMYDataBase() throws SQLException {
		
		String Query = "INSERT INTO customers (customerNumber,customerName, contactLastName, contactFirstName, phone, addressLine1, city, country) \r\n"
				+ "VALUES (6186,'TechCorp', 'Doe', 'John', '+1-555-1234567', '123 Tech Ave', 'Silicon Valley', 'USA');";
		
		

		stmt=con.createStatement();
		int RowEffected = stmt.executeUpdate(Query);
		
		System.out.println(RowEffected);
		
		
		
		
	}
	@Test(priority = 2)
	public void UpdateData() throws SQLException {
		
		String Query = "update customers set contactFirstName='ahmad' where customerNumber=6186";
		
		stmt=con.createStatement();
		int RowEffected = stmt.executeUpdate(Query);
		
		System.out.println(RowEffected);
		
		
		
		
	}
	@Test(priority = 3)
	public void ReadData() throws SQLException {
		
		String Query = "select * from customers where customerNumber =6186";
		
		stmt=con.createStatement();
		rs=stmt.executeQuery(Query);
		
		while(rs.next()) {
			String CustomerFirstNameInDataBase =rs.getString("contactFirstName");
			String CustomerNumberInDataBase =rs.getString("customerNumber");
			
			System.out.println(CustomerFirstNameInDataBase);
			System.out.println(CustomerNumberInDataBase);
		}
		
		
		
		
	}
	@Test(priority = 4)
	public void DeleteData() throws SQLException {
		
		String Query = "delete from customers where customerNumber =6186";
		
		stmt=con.createStatement();
		int RowEffected = stmt.executeUpdate(Query);
		
		System.out.println(RowEffected);
		
		
		
		
	}

	
}
