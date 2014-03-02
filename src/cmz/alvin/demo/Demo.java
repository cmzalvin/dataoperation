package cmz.alvin.demo;

import java.sql.*;

public class Demo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 Connection con = null;
	        Statement stat = null;
	        ResultSet rs = null;
	        try {
	            Class.forName("com.mysql.jdbc.Driver");
	            String url = "jdbc:mysql://localhost:3306/student";
	            String user = "root";
	            String password = "870925";
	            con = DriverManager.getConnection(url, user, password);
	            stat = con.createStatement();
	            
	            //向表中插入数据
	            String sqlInsert="insert into stu(id,name,sex)"+"values('3','jerry','W')";
	            int count=stat.executeUpdate(sqlInsert);
	            System.out.println("向stu表中插入"+count+"条数据");
	            
	            //更新表中的数据
	            String sqlUpdate="update stu set id='4' where name='john'";
	            int countUPdate=stat.executeUpdate(sqlUpdate);
	            System.out.println("stu表中更新"+countUPdate+"条数据");
	            
	            String sqlDelete="delete from stu where id='3'";
	            int countDelete=stat.executeUpdate(sqlDelete);
	            System.out.println("stu表中删除"+countDelete+"条数据");
	            
	            //查询表中的数据
	            String sqlSelect = "select * from stu";
	            rs = stat.executeQuery(sqlSelect);
	            while (rs.next()) {
	            	 System.out.print("id: " + rs.getString("id"));
	                 System.out.print(" name: " + rs.getString("name"));
	                 System.out.print(" sex:"+rs.getString("sex"));
	                 System.out.println();
	            }
	            
	        } catch (Exception e) {
	            e.printStackTrace();
	        } finally {
	            try {
	                if (rs != null) {
	                    rs.close();
	                }
	                if (stat != null) {
	                    stat.close();
	                }
	                if (con != null) {
	                    con.close();
	                }
	            } catch (Exception e2) {
	                e2.printStackTrace();
	            }
	        }
	}

}
