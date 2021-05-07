import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Admin {

  static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
  static final String DB_URL = "jdbc:mysql://localhost/storemanagementsystem";
  static final String USER = "root";
  static final String PASS = "";

  public static void AddProduct(int pid, String pname, String psize, String pcolor, int pprice, int pdiscount, int pinstock) {
    Connection conn = null;
    Statement stmt = null;
    try {

      Class.forName("com.mysql.jdbc.Driver");

      System.out.println("\n\tConnecting to database...");
      conn = DriverManager.getConnection(DB_URL, USER, PASS);
      System.out.println("\n\tTry to add this to database...");

      //STEP 4: Execute a query
      stmt = conn.createStatement();

      String sql = "INSERT INTO plist " +
        "VALUES (" + pid + ",'" + pname + "','" + psize + "','" + pcolor + "'," + pprice + "," + pdiscount + "," + pinstock + ")";

      stmt.executeUpdate(sql);
      System.out.println("\n\tProduct id " + pid + " inserted into the table successfull..");

    } catch (SQLException se) {

      //         System.out.println("\n\tSQL ERROR");
      System.out.println("\n\tProduct Id " + pid + " is already present or you pass wrong input please check------Insert Failed");
    } catch (Exception e) {
      //Handle errors for Class.forName
      System.out.println("\n\tERROR OCCERS");
      //         System.out.println("2");
    } finally {
      //finally block used to close resources
      try {
        if (stmt != null)
          conn.close();
      } catch (SQLException se) {} // do nothing
      try {
        if (conn != null)
          conn.close();
      } catch (SQLException se) {
        System.out.println("\n\tSQL ERROR");
      }
    }
  }

  public static void DeleteProduct(int passid) {
    Connection conn = null;
    Statement stmt = null;
    try {

      Class.forName("com.mysql.jdbc.Driver");

      System.out.println("\n\tConnecting to database...");
      conn = DriverManager.getConnection(DB_URL, USER, PASS);
      System.out.println("\n\tTry to delete this from database.....");
      stmt = conn.createStatement();
      String sql = "DELETE FROM plist " +
        "WHERE pid = " + passid;
      stmt.executeUpdate(sql);
      System.out.println("\n\tProduct ID " + passid + " delete from database successfull.....");
      // Now you can extract all the records
      // to see the remaining records
    } catch (SQLException se) {

      System.out.println("\n\tSQL ERROR");
    } catch (Exception e) {
      //Handle errors for Class.forName
      System.out.println("\n\tERROR OCCERS");
    } finally {
      //finally block used to close resources
      try {
        if (stmt != null)
          conn.close();
      } catch (SQLException se) {} // do nothing
      try {
        if (conn != null)
          conn.close();
      } catch (SQLException se) {
        System.out.println("\n\tSQL ERROR");
      }
    }
  }

  public static void UpdateMovieDetails(int passid) {
    @SuppressWarnings("resource")
    Scanner in = new Scanner(System.in);
    Connection conn = null;
    Statement stmt = null;
    try {

      Class.forName("com.mysql.jdbc.Driver");

      System.out.println("\n\tConnecting to database...");
      conn = DriverManager.getConnection(DB_URL, USER, PASS);
      System.out.println("\n\tTry to update this from database.....");
      try {
        //STEP 4: Execute a query
        System.out.print("\n\t1.Update the product type\n\t2.Update the product size" +
          "\n\t3.Update the product color\n\t4.Update the product price\n\t5.Update the product discount" +
          "\n\t6.Update the product stock\n\t0.Exit");
        System.out.print("\nUpdate records into the table...\nEnter the upate value no-");
        int ch = in .nextInt();
        if (ch == 1) {
          System.out.print("Enter the new product type-");
          String ptype = in .next();
          stmt = conn.createStatement();
          String sql = "UPDATE plist SET ptype = '" + ptype + "' WHERE pid=" + passid;
          stmt.executeUpdate(sql);
          System.out.println("\n\tproduct name for product id " + passid + " updated to " + ptype + "   Successfull...");
        } else if (ch == 2) {
          System.out.print("Enter the product new size -");
          String psize = in .next();
          stmt = conn.createStatement();
          String sql = "UPDATE plist SET psize='" + psize + "' WHERE pid=" + passid;
          stmt.executeUpdate(sql);
          System.out.println("\n\tProduct size for product id " + passid + " updated to " + psize + "   Successfull...");
        } else if (ch == 3) {
          System.out.print("Enter the new product color-");
          String pcolor = in .next();
          stmt = conn.createStatement();
          String sql = "UPDATE plist SET pcolor = '" + pcolor + "' WHERE pid=" + passid;
          stmt.executeUpdate(sql);
          System.out.println("\n\tProduct color for movie id " + passid + " updated to " + pcolor + "   Successfull...");
        } else if (ch == 4) {
          System.out.print("Enter the product new price -");
          int pprice = in .nextInt();
          stmt = conn.createStatement();
          String sql = "UPDATE plist SET pprice=" + pprice + " WHERE pid=" + passid;
          stmt.executeUpdate(sql);
          System.out.println("\n\tProduct price for product id " + passid + " updated to " + pprice + "   Successfull...");
        } else if (ch == 5) {
          System.out.print("Enter the product new discocunt - ");
          int pdiscount = in .nextInt();
          stmt = conn.createStatement();
          String sql = "UPDATE plist SET pdiscount=" + pdiscount + " WHERE pid=" + passid;
          stmt.executeUpdate(sql);
          System.out.println("\n\tProduct discocunt for product id " + passid + " updated to " + pdiscount + "   Successfull...");
        } else if (ch == 6) {
          System.out.print("Enter the product new stock -");
          int pinstock = in .nextInt();
          stmt = conn.createStatement();
          String sql = "UPDATE plist SET pinstock=" + pinstock + " WHERE pid=" + passid;
          stmt.executeUpdate(sql);
          System.out.println("\n\tProduct stock for product id " + passid + " updated to " + pinstock + "   Successfull...");
        } else {
          System.out.println("\n\tWrong Input Cheak Menu Once");
        }
      } catch (Exception e) {
        System.out.println("\n\tINVALID...");
      }
    } catch (SQLException se) {

      System.out.println("\n\tSQL ERROR");
    } catch (Exception e) {
      //Handle errors for Class.forName
      System.out.println("\n\tERROR OCCERS");
    } finally {
      //finally block used to close resources
      try {
        if (stmt != null)
          conn.close();
      } catch (SQLException se) {} // do nothing
      try {
        if (conn != null)
          conn.close();
      } catch (SQLException se) {
        System.out.println("\n\tSQL ERROR");
      }
    }
  }

  public static boolean AdminCheck(String username, String UPassword) {
    Connection conn = null;
    Statement stmt = null;
    username=username.trim();
    UPassword=UPassword.trim();
    try {

      Class.forName("com.mysql.jdbc.Driver");

      System.out.println("\n\tConnecting to database...");
      conn = DriverManager.getConnection(DB_URL, USER, PASS);
      System.out.println("\n\tCheck the admin status ...");
      //STEP 4: Execute a query
      stmt = conn.createStatement();
      String sql = "select * from productadmin where adminname='" + username + "'";
      ResultSet rs = stmt.executeQuery(sql);
      int c = 0;
      while (rs.next()) {
        c = c + 1;
      }
      if (c == 0) {
        System.out.println("\n\t ADMIN NOT FOUND");
        return false;
      } else {
        sql = "select * from productadmin where adminname='" + username + "'";
        rs = stmt.executeQuery(sql);
        while (rs.next()) {

          String adminname = rs.getString("adminname");
          String password = rs.getString("password");
          if (username.equals(adminname)) {
            if (UPassword.equals(password)) {
              System.out.println("\nSUCCESSFULL LOGIN");
              return true;
            } else {
              System.out.println("\n\t WRONG PASSWORD");
              return false;
            }
          }

        }
      }

    } catch (SQLException se) {

      System.out.println("\n\tSQL ERROR");
    } catch (Exception e) {
      //Handle errors for Class.forName
      System.out.println("\n\tERROR OCCERS");
    } finally {
      //finally block used to close resources
      try {
        if (stmt != null)
          conn.close();
      } catch (SQLException se) {} // do nothing
      try {
        if (conn != null)
          conn.close();
      } catch (SQLException se) {
        System.out.println("\n\tSQL ERROR");
      }
    }
    return false;
  }
  
  public static int DiscountCheck(String discode) {
	    Connection conn = null;
	    Statement stmt = null;
	    discode=discode.toUpperCase();
	    discode=discode.trim();
	    try {

	      Class.forName("com.mysql.jdbc.Driver");
	      conn = DriverManager.getConnection(DB_URL, USER, PASS);
	      //STEP 4: Execute a query
	      stmt = conn.createStatement();
	      String sql = "select * from productdiscount where discountcode='" + discode + "'";
	      ResultSet rs = stmt.executeQuery(sql);
	      int c = 0;
	      while (rs.next()) {
	        c = c + 1;
	      }
	      if (c == 0) {
//	    	  System.out.println("\n\t DISCOUNT CODE NOT FOUND");
	        return -1;
	      } else {
	        sql = "select * from productdiscount where discountcode='" + discode + "'";
	        rs = stmt.executeQuery(sql);
	        while (rs.next()) {
	          int dis = rs.getInt("discountnum");
	          return dis;
	        }
	      }

	    } catch (SQLException se) {

	      System.out.println("\n\tSQL ERROR");
	    } catch (Exception e) {
	      //Handle errors for Class.forName
	      System.out.println("\n\tERROR OCCERS");
	    } finally {
	      //finally block used to close resources
	      try {
	        if (stmt != null)
	          conn.close();
	      } catch (SQLException se) {} // do nothing
	      try {
	        if (conn != null)
	          conn.close();
	      } catch (SQLException se) {
	        System.out.println("\n\tSQL ERROR");
	      }
	    }
	    return -1;
	  }

}