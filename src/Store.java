import java.sql.*;
import java.lang.Math;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Store {
  public static void main(String[] args) {
    Shop NewShop = new Shop();
    NewShop.Shop1();
  }

}

class Shop {
  void Shop1() {
    @SuppressWarnings("resource")
    Scanner in = new Scanner(System.in);
    Customer Customer1 = new Customer();
    Product Product1 = new Product();
    int iniciateadmin = 5656, tablecreate = 5555;
    System.out.println("\n\tWELCOME TO ABC STORE");
    //DISPLAY MOVIE LIST
    while (true) {
    	System.out.print("\n");
      Product1.ProductDisplay(0);
      System.out.print("\n\t1.Add product in list\n\t2.Remove product from list\n\t3.Display your list\n\t0.Exit");
      try {
        System.out.print("\n\nEnter your interest -");
        int optionCh = in .nextInt();
        if (optionCh == 1) {
          try {
            System.out.print("\n Enter product ID  - ");
            int pid = in .nextInt();
            System.out.print("\n Enter the quantits - ");
            int productq = in .nextInt();
            Customer1.AddToMyList(pid, productq, Product1);
          } catch (Exception e) {
            System.out.println("\n\tINVALID...");
            break;
          }
        } else if (optionCh == 2) {
          try {
            System.out.print("\n Enter product ID you want to remove  - ");
            int pid = in .nextInt();
            System.out.print("\n Enter the quantits you want to remove - ");
            int productq = in .nextInt();
            Customer1.RemoveFromList(pid, productq);
          } catch (Exception e) {
            System.out.println("\n\tINVALID...");
            break;
          }
        } else if (optionCh == 3) {
          try {
            if (Customer1.DisplayFinalList(Product1)) {
              System.out.print("\nDo you want to check out(1/0) - ");
              int checksts = in .nextInt();
              if (checksts == 1) {
                Customer1.CheckOut(Product1);
                break;
              } else {
                System.out.print("\nPlease continue...");
              }
            }
          } catch (Exception e) {
            System.out.println("\n\tINVALID...");
            break;
          }

        } else if (optionCh == 0) {
          System.out.print("\n \t Thank You for visiting. ");
          break;
        } else if (optionCh == tablecreate) {
          Table.Create();
        } else if (optionCh == iniciateadmin) {
          try {
            @SuppressWarnings("resource")
            Scanner sc = new Scanner(System.in);
            System.out.print("\nEnter your username - ");
            String adminusername = sc.nextLine();
            System.out.print("\n Enter the password- ");
            String adminpassword = sc.nextLine();
            if (Admin.AdminCheck(adminusername, adminpassword)) {
              System.out.println("\n\t WELCOME TO ADMIN PANAL (Double check before do anything this panal is sensitive)");
              while (true) {
                System.out.print("\n\tADMIN\n\t1.Add a new product \n\t2.Remove product\n\t3.Display product list\n\t4.Update product items\n\t5.Search product with id\n\t0.Exit");
                try {
                  System.out.print("\n Enter your interest -");
                  int AoptionCh = in .nextInt();
                  if (AoptionCh == 1) {
                    int randid = (int)(1000 * Math.random());
                    try {
                    System.out.print("\n Enter the type  -");
                    String type=in.next();
                    System.out.print("\n Enter the size  -");
                    String size=in.next();
                    System.out.print("\n Enter the color  -");
                    String color=in.next();
                    System.out.print("\n Enter the price  -");
                    int price=in.nextInt();
                    System.out.print("\n Enter the discount  -");
                    int dis=in.nextInt();
                    System.out.print("\n Enter the stock  -");
                    int sto=in.nextInt();
                    
                    Admin.AddProduct(randid, type,size,color,price,dis,sto);
                    }catch(Exception e) {System.out.println("\n\tINVALID INPUT...");break;}
                  } else if (AoptionCh == 2) {
                    try {
                      System.out.print("\nEnter the id of product you want to delete - ");
                      int checksts = in .nextInt();
                      if(Product1.CheckAvalability(checksts, 1)) {
                    	  Admin.DeleteProduct(checksts);
                      }
                      else {
                    	  System.out.print("\nNot found the product");  
                      }
                     
                    } catch (Exception e) {
                      System.out.println("\n\tINVALID...");
                      break;
                    }
                  } else if (AoptionCh == 3) {
                    Product1.ProductDisplay(1);
                  } else if (AoptionCh == 4) {
                    try {
                      System.out.print("\nEnter the id of product you want to update - ");
                      int checksts = in .nextInt();
                      Admin.UpdateMovieDetails(checksts);
                    } catch (Exception e) {
                      System.out.println("\n\tINVALID...");
                      break;
                    }
                  } else if (AoptionCh == 5) {
                      try {
                          System.out.print("\nEnter the id of product you want to search - ");
                          int checksts = in .nextInt();
                          Product1.ProductSearch(checksts);
                        } catch (Exception e) {
                          System.out.println("\n\tINVALID...");
                          break;
                        }
                      }
                  else if (AoptionCh == 0) {
                    System.out.print("\n \tExiting from admin panel. ");
                    break;
                  } else {
                    System.out.print("\nMaybe you enter wrong choice.");
                  }
                } catch (Exception e) {
                  System.out.println("\n\tINVALID...");
                  break;
                }

              }

            }
          } catch (Exception e) {
            System.out.println("\n\tINVALID...");
            break;
          }
        } else {
          System.out.print("\nMaybe you enter wrong choice.");
        }
      } catch (Exception e) {
        System.out.println("\n\tINVALID...");
        break;
      }
    }
  }
}

class Product {
  static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
  static final String DB_URL = "jdbc:mysql://localhost/storemanagementsystem";
  static final String USER = "root"; //USERNAME
  static final String PASS = ""; //PASSWORD
  Scanner in = new Scanner(System.in);
  Boolean CheckAvalability(int passid, int noOfProduct) { // CHEAK THE VALID PROCUST ID NO AND SEAT CAPACITY
    int instock = 0;
    Connection conn = null;
    Statement stmt = null;
    try {

      Class.forName("com.mysql.jdbc.Driver");
//      System.out.println("\n\tConnecting to database...");
      conn = DriverManager.getConnection(DB_URL, USER, PASS);
      //System.out.println("\n\tChecking avalibility of the product...");
      stmt = conn.createStatement();
      String sql;
      sql = "SELECT * FROM plist WHERE pid=" + passid;
      ResultSet rs = stmt.executeQuery(sql);
      int count = 0;

      while (rs.next()) {
        ++count;
        int pinstock = rs.getInt("pinstock");
        instock = pinstock;
      }
      if (count == 0 || instock < noOfProduct) {
        return false;
      }

//      System.out.println("\n\tChecking successfull");
      rs.close();
      stmt.close();
      conn.close();
    } catch (SQLException se) {
      System.out.println("\n\tSQL ERROR");
    } catch (Exception e) {
      System.out.println("\n\tERROR OCCERS");
    } finally {
      try {
        if (stmt != null)
          stmt.close();
      } catch (SQLException se2) {}
      try {
        if (conn != null)
          conn.close();
      } catch (SQLException se) {
        System.out.println("\n\tSQL ERROR");
      }
    }
    return true;
  }

  void ProductSearch(int passid) { // DISPLAY THE AVALABLE MOVIE LIST 
	    Connection conn = null;
	    int c=0;
	    Statement stmt = null;
	    try {

	      Class.forName("com.mysql.jdbc.Driver");

//	      System.out.println("\n\tConnecting to database...");
	      conn = DriverManager.getConnection(DB_URL, USER, PASS);
//	      System.out.println("\n\tFetching data from database...");
	      stmt = conn.createStatement();
	      String sql;
	      sql = "SELECT * FROM plist WHERE pid=" + passid;
	      ResultSet rs = stmt.executeQuery(sql);
	      System.out.println("\n\tInformation about product id "+passid+" is ,");
	      while (rs.next()) {
	    	  c=c+1;
	        int pid = rs.getInt("pid");
	        String ptype = rs.getString("ptype");
	        String psize = rs.getString("psize");
	        String pcolor = rs.getString("pcolor");
	        int pprice = rs.getInt("pprice");
	        int pdiscount = rs.getInt("pdiscount");
	        int pinstock = rs.getInt("pinstock");
	        System.out.print("ID: " + pid);
	        System.out.print(", Type: " + ptype);
	        System.out.print(", Size: " + psize);
	        System.out.print(", Color: " + pcolor);
	        System.out.print(", Price: " + pprice);
	        System.out.print(", Discount: " + pdiscount + "%");
	        if (pinstock <= 0) {
	          System.out.print(", PRODUCT OUT OF STOCK TRY LATER \n");
	        } else {
	          System.out.print("\n");
	        }
	      }
	      rs.close();
	      stmt.close();
	      conn.close();
//	      System.out.println("\n\tData fetch successfull...");
	    } catch (SQLException se) {
	      System.out.println("\n\tSQL ERROR");
	    } catch (Exception e) {
	      System.out.println("\n\tERROR OCCERS");
	    } finally {
	      try {
	        if (stmt != null)
	          stmt.close();
	      } catch (SQLException se2) {}
	      try {
	        if (conn != null)
	          conn.close();
	      } catch (SQLException se) {
	        System.out.println("\n\tSQL ERROR");
	      }
	    }
	    if (c==0) {
	    	System.out.println("Not Found In our store");
	    }
	  }//PRODUCT SEARCH
  
  
  void ProductDisplay(int forwhose) { // DISPLAY THE AVALABLE MOVIE LIST 
    Connection conn = null;
    Statement stmt = null;
    int c=0;
    try {

      Class.forName("com.mysql.jdbc.Driver");

//      System.out.println("\n\tConnecting to database...");
      conn = DriverManager.getConnection(DB_URL, USER, PASS);
//      System.out.println("\n\tFetching data from database...");
      stmt = conn.createStatement();
      String sql;
      sql = "SELECT * FROM plist";
      ResultSet rs = stmt.executeQuery(sql);
      while (rs.next()) {
    	  c=c+1;
        int pid = rs.getInt("pid");
        String ptype = rs.getString("ptype");
        String psize = rs.getString("psize");
        String pcolor = rs.getString("pcolor");
        int pprice = rs.getInt("pprice");
        int pdiscount = rs.getInt("pdiscount");
        int pinstock = rs.getInt("pinstock");
        System.out.print("ID: " + pid);
        System.out.print(", Type: " + ptype);
        System.out.print(", Size: " + psize);
        System.out.print(", Color: " + pcolor);
        System.out.print(", Price: " + pprice);
        System.out.print(", Discount: " + pdiscount + "%");
        if (forwhose == 1) {
          System.out.print(", Stock: " + pinstock);
        }
        if (pinstock <= 0) {
          System.out.print(", PRODUCT OUT OF STOCK TRY LATER \n");
        } else {
          System.out.print("\n");
        }
      }
      rs.close();
      stmt.close();
      conn.close();
//      System.out.println("\n\tData fetch successfull...");
    } catch (SQLException se) {
//      System.out.println("\n\tSQL ERROR");
    } catch (Exception e) {
      System.out.println("\n\tERROR OCCERS");
    } finally {
      try {
        if (stmt != null)
          stmt.close();
      } catch (SQLException se2) {}
      try {
        if (conn != null)
          conn.close();
      } catch (SQLException se) {
        System.out.println("\n\tSQL ERROR");
      }
    }
if(c==0) {
	System.out.println("\nNo data found ask the owner");
}
  }

  void DisplayCustomerListDetails(Integer[] myProductList, Integer[] myNoOfProducts) { // DISPLAY THE CUSTOMER MOVIE LIST THAT THEY CHOOSE
    System.out.println("\n\tConnecting to database...");
    System.out.println("\n\tFetching data from database....\nYour List \n");
    for (int i = 0; i < myProductList.length; i++) {
      if (myNoOfProducts[i] == -9999) {
        continue;
      }
      Connection conn = null;
      Statement stmt = null;
      try {

        Class.forName("com.mysql.jdbc.Driver");
        conn = DriverManager.getConnection(DB_URL, USER, PASS);
        stmt = conn.createStatement();
        String sql;
        sql = "SELECT * FROM plist WHERE pid =" + myProductList[i];
        ResultSet rs = stmt.executeQuery(sql);

        while (rs.next()) {
          int pid = rs.getInt("pid");
          String ptype = rs.getString("ptype");
          String psize = rs.getString("psize");
          String pcolor = rs.getString("pcolor");
          int pprice = rs.getInt("pprice");
          int pdiscount = rs.getInt("pdiscount");
          int pinstock = rs.getInt("pinstock");
          System.out.print("ID: " + pid);
          System.out.print(", Type: " + ptype);
          System.out.print(", Size: " + psize);
          System.out.print(", Color: " + pcolor);
          System.out.print(", Price: " + pprice);
          System.out.print(", Discount: " + pdiscount + "%");

          if (pinstock <= 0) {
            System.out.print(", PRODUCT OUT OF STOCK TRY LATER \n");
          } else {
            System.out.print(", Quantity: " + myNoOfProducts[i] + "\n");
          }
        }

        rs.close();
        stmt.close();
        conn.close();
      } catch (SQLException se) {
        System.out.println("\n\tSQL ERROR");
      } catch (Exception e) {
        System.out.println("\n\tERROR OCCERS");
      } finally {
        try {
          if (stmt != null)
            stmt.close();
        } catch (SQLException se2) {}
        try {
          if (conn != null)
            conn.close();
        } catch (SQLException se) {
          System.out.println("\n\tSQL ERROR");
        }
      }
    }
    System.out.println("\n\tData fetch successfull...");
  }

  void CustomerCheckOut(Integer[] myProductList, Integer[] myNoOfProducts) { //CHECKOUT THE CUSTOMER GENARATE BILL 
    double finalprice = 0;
    for (int i = 0; i < myProductList.length; i++) {
      if (myNoOfProducts[i] == -9999) {
        continue;
      }
      Connection conn = null;
      Statement stmt = null;
      try {
        Class.forName("com.mysql.jdbc.Driver");
//        System.out.println("\n\tConnecting to database...");
        conn = DriverManager.getConnection(DB_URL, USER, PASS);
//        System.out.println("\n\tFetching data from database....");
        stmt = conn.createStatement();
        String sql;
        sql = "SELECT * FROM plist WHERE pid =" + myProductList[i];
        ResultSet rs = stmt.executeQuery(sql);

        while (rs.next()) {
          int productprice = rs.getInt("pprice");
          int productstock = rs.getInt("pinstock");
          int productdiscount = rs.getInt("pdiscount");
          finalprice = finalprice + productprice;
          finalprice = finalprice * myNoOfProducts[i];
          finalprice = finalprice - ((finalprice * productdiscount) / 100);
          int newstockafterco = productstock - myNoOfProducts[i]; // UPDATE THE DATABASE AFTER SUCCESSFULL CHECKOUT
          stmt = conn.createStatement();
          String updatesql = "UPDATE plist SET pinstock=" + newstockafterco + " WHERE pid=" + myProductList[i];
          stmt.executeUpdate(updatesql);
          System.out.println("\n\tYour Final price is " + finalprice);
          //DISCOUNT
          while(true) {
        	  try{System.out.print("Do you have any Discount code(1/0) :- ");
        	  int disch=in.nextInt();
        	  if(disch==1) {
        		  System.out.print("Enter code here :- ");
        		  String discode=in.next();
        		if (Admin.DiscountCheck(discode)==-1) {
        			System.out.println("Discount code not valid");
        			break;
        		}
        		else {
        			int d=Admin.DiscountCheck(discode);
        			System.out.println("CONGRATULATION '"+discode+"' DISCOUNT CODE IS VALID YOU GOT ADDITIONAL "+d+"% OFF.");
        			finalprice = finalprice - ((finalprice * d) / 100);
        			break;
        		}
        	  }
        	  else {
        		  break;
        	  }
        	  }catch(Exception e) {System.out.println("INVALID INPUT");break;}
          }
        }
        rs.close();
        stmt.close();
        conn.close();
      } catch (SQLException se) {
        System.out.println("\n\tSQL ERROR");
      } catch (Exception e) {
        System.out.println("\n\tERROR OCCERS");
      } finally {
        try {
          if (stmt != null)
            stmt.close();
        } catch (SQLException se2) {}
        try {
          if (conn != null)
            conn.close();
        } catch (SQLException se) {
          System.out.println("\n\tSQL ERROR");
        }
      }
    }
    System.out.println("\n\tYour Final price is " + finalprice);
    System.out.println("\n\t THANK YOU ");
  }

}

class Customer { //CUSTOMER CLASS
  Integer myProductList[] = {}; //STORE THE CUSTOMER MOVIE IDS
  Integer myNoOfProducts[] = {}; //STORE THE CUSTOMER MOVIE IDS

  void AddToMyList(int myProductId, int noOfProduct, Product product) { // ADD THE MOVIE IN CUSTOMER LIST
    if (product.CheckAvalability(myProductId, noOfProduct)) {
        boolean found = false;
        int ind=0;
    	for (int n = 0 ;n<myProductList.length;n++) {
    	      if (myProductList[n] == myProductId) {
    	        found = true;
    	        ind=n;
    	        break;
    	      }
    	    }
    	if (found) {
    		System.out.println("\n\tProduct Id " + myProductId + " added to your list. With quantity " + noOfProduct + ".");
    		myNoOfProducts[ind]=myNoOfProducts[ind]+noOfProduct;
    	}
    	else {
      System.out.println("\n\tProduct Id " + myProductId + " added to your list. With quantity " + noOfProduct + ".");
      ArrayList < Integer > myList = new ArrayList < Integer > (Arrays.asList(myProductList));
      myList.add(myProductId);
      myProductList = myList.toArray(myProductList);

      ArrayList < Integer > myList1 = new ArrayList < Integer > (Arrays.asList(myNoOfProducts));
      myList1.add(noOfProduct);
      myNoOfProducts = myList1.toArray(myNoOfProducts);
    }
    } else {
      System.out.println("\n\tProduct ID " + myProductId + " is not avalable in our store OR It is stock out.");
    }
  }

  void RemoveFromList(int myProductId, int noOfProduct) { // REMOVE PRODUCT FROM CUSTOMER LIST
    int b = 0;
    if (myProductList.length == 0) {
      System.out.println("\n\tAdd some products in your list first");
    } else {

      for (int i = 0; i < myProductList.length; i++) {
        if (myProductList[i] == myProductId) {
          b = 1;
          if (myNoOfProducts[i] < noOfProduct) {
            b = 2;
            myProductList[i] = -9999;
            myNoOfProducts[i] = -9999;
            break;
          }
          myNoOfProducts[i] = myNoOfProducts[i] - noOfProduct;
          if (myNoOfProducts[i] <= 0) {
            myProductList[i] = -9999;
            myNoOfProducts[i] = -9999;
          }
          break;
        }
      }
      if (b == 1) {
        System.out.println("\n\t" + noOfProduct + " products of product id " + myProductId + " remove from list");
      } else if (b == 2) {
        System.out.println("\n\tAll products of product id " + myProductId + " remove from list");
      } else {
        System.out.println("\n\tProduct id " + myProductId + " No found in list");
      }
    }
  }

  boolean DisplayFinalList(Product product) {
    if (myProductList.length == 0) {
      System.out.println("\n\tYou have nothing in the list!");
      return false;
    }
    product.DisplayCustomerListDetails(myProductList, myNoOfProducts);
    return true;
  }

  void CheckOut(Product product) {
    product.CustomerCheckOut(myProductList, myNoOfProducts);
  }
}