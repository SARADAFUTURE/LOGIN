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
	
	
	public void insert(String name, String mobile , String userID , String email ,String  password)
	{
		OracleDriver driver = new OracleDriver();
		try
		{
			cn = DriverManager.getConnection(url, user, pass);
			PreparedStatement pst = cn.prepareStatement("insert into loginForm values(?,?,?,?,?)");		
			
			//insert into loginForm values('sarada',9778880385,'saradafuture','sarada12ru@gmail.com','sarada...');			
			pst.setString(1,name);
			pst.setString(2,mobile);
			pst.setString(3,userID);
			pst.setString(4,email);
			pst.setString(5,password);
			int rvalue = pst.executeUpdate();
		
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
			PreparedStatement pst = cn.prepareStatement("select * from loginForm where userID=?");
			pst.setString(1, userID);
			ResultSet rs = pst.executeQuery();
			if(rs.next())
			{
				if(password.equals(rs.getString(5)))
				{
					JOptionPane.showMessageDialog(null," Login Successful");
				}
				else
				{
					JOptionPane.showMessageDialog(null," Failed");
				}
			}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}

}
