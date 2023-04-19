/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tan.db;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sql.DataSource;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author Acer
 */
public class DBUtils implements Serializable {

    public static Connection makeConnection() throws NamingException, SQLException {

//            //1.load driver
//            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
//            //2.connect String
//            String url = "jdbc:sqlserver://localhost:1433;databasename=Tan_SP23";
//            //3.return connection
//            Connection con = DriverManager.getConnection(url, "sa", "12345");
//            return con;
        Context ctx = new InitialContext();
        Context envCtx = (Context) ctx.lookup("java:comp/env");
        DataSource ds = (DataSource) envCtx.lookup("Tan");
        Connection con = ds.getConnection();
        return con;
    }

}
