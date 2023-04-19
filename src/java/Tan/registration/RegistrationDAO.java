/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tan.registration;

import Tan.db.DBUtils;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.NamingException;

/**
 *
 * @author Acer
 */
public class RegistrationDAO implements Serializable {

    public static boolean checklogin(String username, String password)
            throws SQLException {

        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            //1
            con = DBUtils.makeConnection();
            //2
            if (con != null) {
                String sql = "Select * from registration "
                        + "where username = ? and password = ?";
                //3
                stm = con.prepareStatement(sql);
                stm.setString(1, username);
                stm.setString(2, password);
                //4
                rs = stm.executeQuery();
                //5
                if (rs.next()) {
                    return true;
                }
            }
        } catch (NamingException ex) {
            ex.printStackTrace();
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }

        return false;

    }

    private List<RegistrationDTO> listAcount;

    public List<RegistrationDTO> getListAcount() {
        return listAcount;
    }

    public void searchlastname(String searchValue) throws SQLException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            //1
            con = DBUtils.makeConnection();
            //2
            if (con != null) {
                String sql = "Select * from registration "
                        + "where lastname like ?";
                //3
                stm = con.prepareStatement(sql);
                stm.setString(1, "%" + searchValue + "%");
                //4
                rs = stm.executeQuery();
                //5
                while (rs.next()) {
                    String username = rs.getString("Username");
                    String password = rs.getString("Password");
                    String lastname = rs.getString("Lastname");
                    boolean role = rs.getBoolean("isAdmin");

                    //gọi chỗ hứng dto ra và gọi list acount ra -> check null ko rồi add vào dto
                    RegistrationDTO dto = new RegistrationDTO(username, password, lastname, role);
                    if (listAcount == null) {
                        listAcount = new ArrayList<RegistrationDTO>();

                    }
                    listAcount.add(dto);
                }

            }
        } catch (NamingException ex) {
            ex.printStackTrace();
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }

    }
//Delete from registration where username = ?
    public boolean deleterecord(String pk) throws SQLException {
        Connection con = null;
        PreparedStatement stm = null;

        try {
            //1
            con = DBUtils.makeConnection();
            //2
            if (con != null) {
                String sql = "Delete from registration where username = ?";                 
                //3
                stm = con.prepareStatement(sql);
                stm.setString(1, pk);

                //4
                int row = stm.executeUpdate();
                //5
                if (row > 0) {
                    return true;
                }
            }
        } catch (NamingException ex) {
            Logger.getLogger(RegistrationDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {

            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }

        return false;

    }
    //update registration set password=?, lastname=?, isAdmin=? where username = ?
    public boolean updaterecord(String username, String lastname, String password, boolean role)
            throws SQLException {
        Connection con = null;
        PreparedStatement stm = null;

        try {
            //1
            con = DBUtils.makeConnection();
            //2
            if (con != null) {
                String sql = "update registration set password=?, lastname=?, isAdmin=? where username = ?";
                //3
                stm = con.prepareStatement(sql);
                stm.setString(1, password);
                stm.setString(2, lastname);
                stm.setBoolean(3, role);
                stm.setString(4, username);
                //4
                int row = stm.executeUpdate();
                //5
                if (row > 0) {
                    return true;
                }
            }
        } catch (NamingException ex) {
            ex.printStackTrace();
        } finally {

            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }

        return false;

    }
//"Insert into Registration"//    + "(username, password, lastname, isAdmin) "// + "Values(?, ?, ?, ?)";
    public boolean insertrecord(String username, String password, String lastname, boolean role)
            throws SQLException {
        Connection con = null;
        PreparedStatement stm = null;

        try {
            //1
            con = DBUtils.makeConnection();
            //2
            if (con != null) {
               String sql = "Insert into Registration"
                        + "(username, password, lastname, isAdmin) "
                        + "Values(?, ?, ?, ?)";
                //3
                stm = con.prepareStatement(sql);
                stm.setString(1, username);
                stm.setString(2, password);
                stm.setString(3, lastname);
                stm.setBoolean(4, role);
                //4
                int row = stm.executeUpdate();
                //5
                if (row > 0) {
                    return true;
                }
            }
        } catch (NamingException ex) {
            ex.printStackTrace();
        } finally {

            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }

        return false;

    }
}
