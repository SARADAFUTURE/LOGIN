import java.sql.*;

import javax.swing.JOptionPane;

import oracle.jdbc.*;


public class BusinessLayer 
{
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String user = "system";
	String pass = "sarada";
	String query = null;
	Statement st = null;
	Connection cn = null;
	
	//yahooo !
	
	public void insert(String name, String mobile , String userID , String email ,String  password)
	{
		OracleDriver driver = new OracleDriver();
		try
		{
			cn = DriverManager.getConnection(url, user, pass);
			st = cn.createStatement();
			query = "insert into loginForm values ('"+name+"',"+mobile+",'"+userID+"','"+email+"','"+password+"')";
			
			//insert into loginForm values('sarada',9778880385,'saradafuture','sarada12ru@gmail.com','sarada...');			
			int rvalue = st.executeUpdate(query);
		
			System.out.println(rvalue);
			
			if (rvalue > 0)
			{
				JOptionPane.showMessageDialog(null, "Insertion Successfully !");
			}
			else 
			{
				JOptionPane.showMessageDialog(null,"Check Codes !");
			}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		finally 
		{
			try 
			{
				cn.close();
				st.close();
			}
			catch (SQLException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}
	
	void retrive(String userID,String password)
	{
		//System.out.println(userID);
		//System.out.println(password);
		OracleDriver driver = new OracleDriver();
		try 
		{
			cn = DriverManager.getConnection(url, user, pass);
			st = cn.createStatement();
			query = "select * from loginForm where USERID = '"+userID+"'";
			System.out.println(query);
			ResultSet rs = st.executeQuery(query);
			if (rs == null)
			{
				JOptionPane.showMessageDialog(null,"Input a valid UserID");
			}
			else
			{
				rs.next();
				{
					String RePass = rs.getString(5);
					if (password.equals(RePass))
					{
						JOptionPane.showMessageDialog(null, "Login Successful !");
					}
					else
					{
						JOptionPane.showMessageDialog(null,"Please use valid  user name & password for login! ");
					}
				}
			}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}

}
