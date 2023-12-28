package jdbc1;
import java.io.*;
import java.sql.*;

public class storeimage1 {

	public static void main(String[]a)
	{
		String url="jdbc:mysql://localhost:3306/test?useSSL=false";
		String username="root";
		String passward="root";
		String filepath="c://asmita/Nora.jpg";
		try {
			Connection conn=DriverManager.getConnection(url,username,passward);
			String sql="INSERT INTO person(name,image) values(?,?)";
			PreparedStatement stmt=conn.prepareStatement(sql);
			stmt.setString(1,"asmita");
			InputStream inputStream =new FileInputStream(new File((filepath)));
			stmt.setBlob(2,inputStream);
			int row=stmt.executeUpdate();
			if(row>0)
				System.out.println("A contact was interested with photo image ");
			conn.close();
			
		}catch(Exception e)
		{
			System.out.println(e);
		}
	}
}
