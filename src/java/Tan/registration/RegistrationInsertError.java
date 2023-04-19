/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tan.registration;

import java.io.Serializable;

/**
 *
 * @author Acer
 */
public class RegistrationInsertError implements Serializable{
    private String usernameLengthErr;
    private String passwordLengthErr;
    private String confirmNotMatch;
    private String fullnameLengthErr;
    private String usernameisExisted;

    /**
     * @return the usernameLengthErr
     */
    public String getUsernameLengthErr() {
        return usernameLengthErr;
    }

    /**
     * @param usernameLengthErr the usernameLengthErr to set
     */
    public void setUsernameLengthErr(String usernameLengthErr) {
        this.usernameLengthErr = usernameLengthErr;
    }

    /**
     * @return the passwordLengthErr
     */
    public String getPasswordLengthErr() {
        return passwordLengthErr;
    }

    /**
     * @param passwordLengthErr the passwordLengthErr to set
     */
    public void setPasswordLengthErr(String passwordLengthErr) {
        this.passwordLengthErr = passwordLengthErr;
    }

    /**
     * @return the confirmLengthErr
     */
    public String getconfirmNotMatch() {
        return confirmNotMatch;
    }

    /**
     * @param confirmLengthErr the confirmLengthErr to set
     */
    public void setconfirmNotMatch(String confirmLengthErr) {
        this.confirmNotMatch = confirmLengthErr;
    }

    /**
     * @return the fullnameLengthErr
     */
    public String getFullnameLengthErr() {
        return fullnameLengthErr;
    }

    /**
     * @param fullnameLengthErr the fullnameLengthErr to set
     */
    public void setFullnameLengthErr(String fullnameLengthErr) {
        this.fullnameLengthErr = fullnameLengthErr;
    }

    /**
     * @return the usernameisExisted
     */
    public String getUsernameisExisted() {
        return usernameisExisted;
    }

    /**
     * @param usernameisExisted the usernameisExisted to set
     */
    public void setUsernameisExisted(String usernameisExisted) {
        this.usernameisExisted = usernameisExisted;
    }
    
    
}
