import java.sql.*;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class Customer {
    public static void main(String[] args) {
        int code,phone;
        String name,address,email;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/admindb","root","");
        }
        catch (Exception e){
            System.out.println((e));
        }
        int choice;
        while(true)
        {
            System.out.println("Select the option");
            System.out.println("1.Add Customer");
            System.out.println("2.search Customer");
            System.out.println("3.Delete customer");
            System.out.println("4.Update customer");
            System.out.println("5.View all customer");
            System.out.println("6.Generate bill ");
            System.out.println("7.View all bills ");
            System.out.println("8 Top two high bill");
            System.out.println("9.Exit ");
            System.out.println("*****************");
            System.out.println("ENTER YOUR CHOICE:--");
            Scanner sc=new Scanner(System.in);
            choice=sc.nextInt();
            switch(choice)
            {
                case 1:
                    System.out.println("Add customer details...");
                    System.out.println("Enter the customer code");
                    code=sc.nextInt();
                    System.out.println("Enter the  name:--");
                    name=sc.next();
                    System.out.println("Enter the Address:--");
                    address=sc.next();
                    System.out.println("Enter the phone:--");
                    phone=sc.nextInt();
                    System.out.println("Enter the email:--");
                    email=sc.next();
                    try{
                        Class.forName("com.mysql.jdbc.Driver");
                        Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/admindb","root","");
                        String sql="INSERT INTO `customer`(`code`, `name`, `address`, `phone`, `email`) VALUES (?,?,?,?,?)";
                        PreparedStatement stmt=con.prepareStatement((sql));
                        stmt.setInt(1,code);
                        stmt.setString(2,name);
                        stmt.setString(3,address);
                        stmt.setInt(4,phone);
                        stmt.setString(5,email);
                        stmt.executeUpdate();
                        System.out.println("value inserted successfully.........!");
                    }
                    catch (Exception e){
                        System.out.println((e));
                    }
                    break;
                case 2:
                    System.out.println("1.search using name");
                    System.out.println("2.search using phone number");
                    System.out.println("3.search using code");
                    int choice1 = sc.nextInt();
                    switch (choice1)
                    {
                        case 1:
                            System.out.println("enter the name:-");
                            name = sc.next();
                            try{
                                Class.forName("com.mysql.jdbc.Driver");
                                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/admindb", "root", "");
                                String sql = "SELECT  `name`, `address`, `phone`, `email` FROM `customer` WHERE `name`='"+name+"'";
                                Statement stmt=con.createStatement();
                                ResultSet rs=stmt.executeQuery(sql);
                                while(rs.next()){
                                    name = rs.getString("name");
                                    address = rs.getString("address");
                                    phone = rs.getInt("phone");
                                    email = rs.getString("email");
                                    System.out.println("name = "+name);
                                    System.out.println("address = "+address);
                                    System.out.println("phone number = "+phone);
                                    System.out.println("Email id = "+email+'\n');
                                }
                            }
                            catch (Exception e){
                                System.out.println(e);
                            }
                            break;
                        case 2:
                            System.out.println("enter phone number for search :-");
                            phone = sc.nextInt();
                            try{
                                Class.forName("com.mysql.jdbc.Driver");
                                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/admindb", "root", "");
                                String sql = "SELECT  `name`, `address`, `phone`, `email` FROM `customer` WHERE `phone`='"+phone+"'";
                                Statement stmt=con.createStatement();
                                ResultSet rs=stmt.executeQuery(sql);
                                while(rs.next()){
                                    name = rs.getString("name");
                                    address = rs.getString("address");
                                    phone = rs.getInt("phone");
                                    email = rs.getString("email");
                                    System.out.println("name = "+name);
                                    System.out.println("address = "+address);
                                    System.out.println("phone number = "+phone);
                                    System.out.println("Email id = "+email+'\n');
                                }
                            }
                            catch (Exception e){
                                System.out.println(e);
                            }
                            break;
                        case 3:
                            System.out.println("Enter customer code for search");
                            code = sc.nextInt();
                            try{
                                Class.forName("com.mysql.jdbc.Driver");
                                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/admindb", "root", "");
                                String sql = "SELECT  `name`, `address`, `phone`, `email` FROM `customer` WHERE `code`='"+code+"'";
                                Statement stmt=con.createStatement();
                                ResultSet rs=stmt.executeQuery(sql);
                                while(rs.next()){
                                    name = rs.getString("name");
                                    address = rs.getString("address");
                                    phone = rs.getInt("phone");
                                    email = rs.getString("email");
                                    System.out.println("name = "+name);
                                    System.out.println("address = "+address);
                                    System.out.println("phone number = "+phone);
                                    System.out.println("Email id = "+email+'\n');
                                }
                            }
                            catch (Exception e){
                                System.out.println(e);
                            }
                            break;
                    }

                    break;
                case 3:
                    System.out.println("Delete customer");
                    System.out.println("enter the code ");
                    code=sc.nextInt();
                    try{
                        Class.forName("com.mysql.jdbc.Driver");
                        Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/admindb","root","");
                        String sql="DELETE FROM `customer` WHERE `code`="+String.valueOf(code);
                        Statement stmt=con.createStatement();
                        stmt.executeUpdate(sql);
                        System.out.println("deleted successfully.....");
                    }
                    catch (Exception e){
                        System.out.println((e));
                    }
                    break;
                case 4:
                    System.out.println("Update customer");
                    System.out.println("Add customer details...");
                    System.out.println("Enter the customer code");
                    code=sc.nextInt();
                    System.out.println("Enter the  name to be updated:--");
                    name=sc.next();
                    System.out.println("Enter the Address to be updated:--");
                    address=sc.next();
                    System.out.println("Enter the phone to be updated:--");
                    phone=sc.nextInt();
                    System.out.println("Enter the email to be updated:--");
                    email=sc.next();
                    try{
                        Class.forName("com.mysql.jdbc.Driver");
                        Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/admindb","root","");
                        String sql="UPDATE `customer` SET `name`='"+name+"',`address`='"+address+"',`phone`='"+String.valueOf(phone)+"',`email`='"+email+"' WHERE `code`="+String.valueOf(code);
                        Statement stmt=con.createStatement();
                        stmt.executeUpdate(sql);

                        System.out.println("Data updated  successfully.....");
                    }
                    catch (Exception e){
                        System.out.println((e));
                    }
                    break;
                case 5:
                    System.out.println("View all customer");
                    try{
                        Class.forName("com.mysql.jdbc.Driver");
                        Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/admindb","root","");
                        String sql = "SELECT `code`, `name`, `address`, `phone`, `email` FROM `customer`";
                        Statement stmt=con.createStatement();
                        ResultSet rs=stmt.executeQuery(sql);
                        while(rs.next()){
                            code = rs.getInt("code");
                            name = rs.getString("name");
                            address = rs.getString("address");
                            phone = rs.getInt("phone");
                            email = rs.getString("email");
                            System.out.println("code = "+code);
                            System.out.println("name = "+name);
                            System.out.println("address = "+address);
                            System.out.println("phone number = "+phone);
                            System.out.println("Email id = "+email+'\n');
                        }
                    }
                    catch (Exception e){
                        System.out.println((e));
                    }
                    break;
                case 6:
                    Date dt=new Date();
                    Calendar cal= Calendar.getInstance();
                    cal.setTime(dt);
                    System.out.println(dt);
                    System.out.println(cal);
                    int month=cal.get(Calendar.DAY_OF_MONTH);
                    int year=cal.get(Calendar.YEAR);
                    int status = 1;
                    try{
                        Class.forName("com.mysql.jdbc.Driver");
                        Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/admindb","root","");
                        String sql = "DELETE FROM `bill` WHERE `month`= '" + month + "'AND `year`= '" + year + "'";
                        Statement stmt = con.createStatement();
                        stmt.executeUpdate(sql);
                        String sql1 = "SELECT `id` FROM `customer` ";
                        //String sql = "SELECT `id` FROM `customer`;
                        Statement stmt1 = con.createStatement();
                        ResultSet rs = stmt1.executeQuery(sql1);
                        while(rs.next())
                        {
                            int id = rs.getInt("id");
                            String sql2 = "SELECT SUM(`unit`) FROM `usagetbl`  WHERE `userid`='" + id + "'  AND MONTH(`datetime`)='" + month + "' AND YEAR(`datetime`)='" + year + "'";
                            Statement stmt2 = con.createStatement();
                            ResultSet rs2 = stmt2.executeQuery(sql2);
                            while (rs2.next())
                            {
                                int add = rs2.getInt("SUM(`unit`)");
                                //int status = 1;
                                int totalBill = add * 5;
                                String sql3 = "INSERT INTO `bill`(`userid`, `month`, `year`, `bill`, `paidstatus`, `totalunit`,`billdate`, `duedate`) VALUES(?,?,?,?,?,?,now(),now()+interval 14 day)";
                                PreparedStatement stmt3 = con.prepareStatement(sql3);
                                //ResultSet rs3 = stmt3.executeQuery(sql3);
                                stmt3.setInt(1,id);
                                stmt3.setInt(2,month);
                                stmt3.setInt(3,year);
                                stmt3.setInt(4,totalBill);
                                stmt3.setInt(5,status);
                                stmt3.setInt(6,add);
                                stmt3.executeUpdate();
                                System.out.println("value inserted successfully.........!");

                            }
                        }
                    }
                    catch (Exception e){
                        System.out.println((e));
                    }
                case 7:
                    System.out.println("View all bills");
                    try{
                        Class.forName("com.mysql.jdbc.Driver");
                        Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/admindb","root","");
                        String sql = "SELECT c.name,c.address, b.`month`, b.`year`, b.`paidstatus`, b.`billdate`, b.`totalunit`, b.`bill` FROM `bill` b JOIN customer c ON b.userid=c.id";
                        Statement stmt = con.createStatement();
                        ResultSet rs = stmt.executeQuery(sql);
                        while(rs.next())
                        {
                            name = rs.getString("c.name");
                            address = rs.getString("c.address");
                            int month1 = rs.getInt("b.month");
                            int year1 = rs.getInt("b.year");
                            String sta = rs.getString("b.paidstatus");
                            String date1 = rs.getString("b.billdate");
                            int total = rs.getInt("b.totalunit");
                            int bill = rs.getInt("b.bill");
                            System.out.println("name ="+name);
                            System.out.println("address ="+address);
                            System.out.println("month ="+month1);
                            System.out.println("year = "+year1);
                            System.out.println("status="+sta);
                            System.out.println("bill date="+date1);
                            System.out.println("total unit ="+total);
                            System.out.println("total bill = "+bill);
                            System.out.println("\n");


                        }
                    }
                    catch (Exception e){
                        System.out.println((e));
                    }

                    break;
                case 8:
                    System.out.println("View top two bills");
                    try{
                        Class.forName("com.mysql.jdbc.Driver");
                        Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/admindb","root","");
                        String sql = "SELECT c.name,c.address,b.`bill`, b.`totalunit` FROM `bill` b JOIN customer c ON b.userid=c.id ORDER BY b.`bill`DESC LIMIT 2";
                        Statement stmt = con.createStatement();
                        ResultSet rs = stmt.executeQuery(sql);
                        while(rs.next()){
                            name = rs.getString("c.name");
                            address = rs.getString("c.address");
                            int bill = rs.getInt("bill");
                            int total = rs.getInt("totalunit");
                            System.out.println("name ="+name);
                            System.out.println("address ="+address);
                            System.out.println("total bill = "+bill);
                            System.out.println("total unit ="+total+'\n');
                        }
                    }
                    catch (Exception e){
                        System.out.println((e));
                    }

                case 9:
                    System.exit(0);

            }
        }
    }
}
