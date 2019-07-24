package sk.matusikoval.expense;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.Reader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import org.apache.ibatis.jdbc.ScriptRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class App 
{
    public static void main( String[] args ) throws ClassNotFoundException, SQLException
    {
    	initialDb();
    	SpringApplication.run(App.class, args);
    }
   
    
    public static void initialDb() throws SQLException, ClassNotFoundException {
    	File file = new File("src/main/resources/data.sql");
    	String absolutePath = file.getAbsolutePath();
    	
		Connection con = DriverManager.getConnection(
			"jdbc:mysql://localhost:3306/expensemanagement", "root", "root");

		try {
			ScriptRunner sr = new ScriptRunner(con);
			Reader reader = new BufferedReader(new FileReader(absolutePath));

			sr.runScript(reader);

		} catch (Exception e) {
			System.err.println("Failed to Execute" + absolutePath
					+ " The error is " + e.getMessage());
		}
    }
    

}
