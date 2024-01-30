package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import com.mysql.cj.jdbc.Driver;

public class rmgproject {

	public static void main(String[] args) throws Throwable {
		Connection con=null;
		
		
		
		
		try
		{
			Random r= new Random();
			int random=r.nextInt(100);
			String proj_name="Project_HMS_001"+random;
			WebDriver driver=new ChromeDriver();
			driver.manage().window().maximize();
			driver.get("http://rmgtestingserver:8084/");
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
			driver.findElement(By.id("usernmae")).sendKeys("rmgyantra");
			driver.findElement(By.name("password")).sendKeys("rmgy@9999");
			driver.findElement(By.xpath("//button[text()='Sign in']")).click();
			Thread.sleep(2000);
			//click on projectLink
			driver.findElement(By.linkText("Projects")).click();
			//click on create project button
			driver.findElement(By.xpath("//span[text()='Create Project']")).click();
			// Enter Project details
			driver.findElement(By.name("projectName")).sendKeys(proj_name);
			driver.findElement(By.name("createdBy")).sendKeys("Deepak HR");
			WebElement status = driver.findElement(By.xpath("//option[text()='Select Value']/.."));
			
			 Select s=new Select(status);
			 s.selectByVisibleText("Created");
			 
			 driver.findElement(By.xpath("//input[@class='btn btn-success']")).click();
			 
			 
			 //validate the data
			 
			 //step 1:REGISTER THE DRIVER
				
				Driver DBdriver=new Driver();
				DriverManager.registerDriver(DBdriver);
				
				//STEP 2:GET CONNECTION FOR DATABASE
				  con = DriverManager.getConnection("jdbc:mysql://rmgtestingserver:3333/projects","root@%","root");
				 
				 //step3:Create the Statement
				 
				 Statement state=con.createStatement();
				 
				 String Query="select * from project where lower(project_name)='"+proj_name+"';";
				 
				 //step4: execute Query
				 
				 ResultSet result = state.executeQuery(Query);			
			
				 Boolean flag=false;
				 
				 while(result.next())
				 {
					 String Actual=result.getString(4);
					 System.out.println(Actual);
					 if(Actual.equalsIgnoreCase(proj_name))
						 {
						   flag=true;
						   break;
						 }
					 System.out.println("----Query Executed---");
						 }
				 if(flag==true)
				 {
					 System.out.println("Project created sucessfully");
				 }
				 else
				 {
					 System.out.println("Project not created");
				 }
		}
			catch(Exception e)
			{
				
			}
			finally
			{
				con.close();
				System.out.println("DB closed");
			}
		}
		}
	


