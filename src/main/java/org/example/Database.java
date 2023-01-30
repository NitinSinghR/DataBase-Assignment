package org.example;

import java.sql.*;
import java.util.*;
import java.util.logging.*;

class DataBase{
    Connection con;
    private static DataBase t2=null;
    Logger l= Logger.getLogger("com.api.jar");
    private DataBase(){
    }
    public static DataBase getInstance()
    {
        if (t2 == null)
        {
            t2 = new DataBase();
        }
        return t2;
    }
    public void connect(String url, String user, String password) throws SQLException {
        con=DriverManager.getConnection(url,user,password);
        l.info("Connection Created Successfully\n");
    }
    public void closeconnection() throws SQLException {
        con.close();
        l.info("Connection Closed Successfully\n");
    }

    public static void main(String[] args) throws SQLException {
        Logger l= Logger.getLogger("com.api.jar");
        Scanner sc=new Scanner(System.in);

        l.info("Enter the Database url");
        String url=sc.next();
        l.info("Enter the username");
        String user=sc.next();
        l.info("Enter the Password");
        String pass=sc.next();

        DataBase t1=DataBase.getInstance();

        while(true){
            l.info("1.Create Connection\n2.Close Connection\n");
            int ch=sc.nextInt();
            switch(ch)
            {
                case 1:
                {
                    t1.connect(url, user, pass);
                    break;
                }
                case 2:
                {
                    t1.closeconnection();
                    break;
                }
                default:
                {
                    l.info("Enter the correct option\n");
                    break;
                }
            }
        }
    }
}