import java.sql.*;

public class Table {
  // JDBC driver name and database URL
  static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
  static final String DB_URL = "jdbc:mysql://localhost/storemanagementsystem";

  //  Database credentials
  static final String USER = "root";
  static final String PASS = "";

  public static void Create() {
    Connection conn = null;
    Statement stmt = null;
    try {
      //STEP 2: Register JDBC driver
      Class.forName("com.mysql.jdbc.Driver");

      //STEP 3: Open a connection
      System.out.println("Connecting to a selected database...");
      conn = DriverManager.getConnection(DB_URL, USER, PASS);
      System.out.println("Connected database successfully...");

      //STEP 4: Execute a query
      System.out.println("Creating table in given database...");
      stmt = conn.createStatement();

      String sql = "CREATE TABLE  plist" +
        "(pid  INTEGER(100) not NULL, " +
        " ptype VARCHAR(100), " +
        " psize VARCHAR(2000), " +
        " pcolor VARCHAR(10), " +
        " pprice INTEGER(200), " +
        " pdiscount INTEGER(10), " +
        " pinstock INTEGER(100), " +
        " PRIMARY KEY ( pid ))";

      stmt.executeUpdate(sql);
      System.out.println("Created table in given database...");

      System.out.println("Product table creation successfull...");
    } catch (SQLException se) {
      //Handle errors for JDBC
      System.out.println("Product table already have in database... OR SOMETHING WRONG");
    } catch (Exception e) {
      //Handle errors for Class.forName
      e.printStackTrace();
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
        se.printStackTrace();
      } //end finally try
    } //end try

    try {
      //STEP 2: Register JDBC driver
      Class.forName("com.mysql.jdbc.Driver");
      conn = DriverManager.getConnection(DB_URL, USER, PASS);

      stmt = conn.createStatement();

      String adminsql = "CREATE TABLE  productadmin " +
    	        "(adminname  VARCHAR(100) not NULL, " +
    	        " password VARCHAR(100), " +
    	        " PRIMARY KEY ( adminname ))";

      stmt.executeUpdate(adminsql);
      System.out.println("Admin table creation successfull...");
    } catch (SQLException se) {
      //Handle errors for JDBC
      System.out.println("ADMIN TABLE IS ALREAY PRESENT OR SOMETHING WRONG");
    } catch (Exception e) {
      //Handle errors for Class.forName
      e.printStackTrace();
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
        se.printStackTrace();
      } //end finally try
    } //end try

    try {
      //STEP 2: Register JDBC driver
      Class.forName("com.mysql.jdbc.Driver");

      //STEP 3: Open a connection
      conn = DriverManager.getConnection(DB_URL, USER, PASS);

      //STEP 4: Execute a query
      System.out.println("Inserting records into the table...");
      stmt = conn.createStatement();

      String sql = "INSERT INTO productadmin VALUES ('root', 'admin')";
      stmt.executeUpdate(sql);
      System.out.println("Username records into the table... Successfull");

    } catch (SQLException se) {
      //Handle errors for JDBC
    	System.out.println("Username already have in database TRY ANOTHER");
    } catch (Exception e) {
      //Handle errors for Class.forName
    	System.out.println(" SOMETHING WRONG");
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
        se.printStackTrace();
      } //end finally try
    } //end try
    
    
    
    try {
        Class.forName("com.mysql.jdbc.Driver");
        conn = DriverManager.getConnection(DB_URL, USER, PASS);

        stmt = conn.createStatement();

        String adminsql = "CREATE TABLE  productdiscount " +
      	        "(discountcode  VARCHAR(100) not NULL, " +
      	        " discountnum INT(10), " +
      	        " PRIMARY KEY ( discountcode ))";

        stmt.executeUpdate(adminsql);
        System.out.println("Discount table creation successfull...");
      } catch (SQLException se) {
        //Handle errors for JDBC
        System.out.println("DISCOUNT TABLE IS ALREAY PRESENT OR SOMETHING WRONG");
      } catch (Exception e) {
        //Handle errors for Class.forName
        e.printStackTrace();
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
          se.printStackTrace();
        } //end finally try
      } //end try
    
    
    
    
    
    
    try {
        //STEP 2: Register JDBC driver
        Class.forName("com.mysql.jdbc.Driver");

        //STEP 3: Open a connection
        conn = DriverManager.getConnection(DB_URL, USER, PASS);

        //STEP 4: Execute a query
        System.out.println("Inserting records into the table...");
        stmt = conn.createStatement();

        String sql = "INSERT INTO productdiscount VALUES ('CODE', 50)";
        stmt.executeUpdate(sql);
        System.out.println("Discount code records into the table... Successfull");

      } catch (SQLException se) {
        //Handle errors for JDBC
      	System.out.println("Discount code already have in database TRY ANOTHER");
      } catch (Exception e) {
        //Handle errors for Class.forName
      	System.out.println(" SOMETHING WRONG");
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
          se.printStackTrace();
        } //end finally try
      } //end try
  } //end main
} 