package org.ait.controller;

import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import org.ait.managedBeans.UserBeanLocal;

@ManagedBean
@SessionScoped
public class login implements Serializable {

    //making ejb newuserbean object
    @EJB
    private UserBeanLocal loginbean;

    //Creates a new instance of login
    public login() {
    }

    //required attributes
    private String pwd;//passwword
    private String msg;//message
    private String user;//user

    //gettter for username
    public String getUser() {
        return user;
    }

    //setter for username
    public void setUser(String user) {
        this.user = user;
    }

    //getter for password
    public String getPwd() {
        return pwd;
    }

    //setter for password
    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    //gettter for message
    public String getMsg() {
        return msg;
    }

    //setter for message
    public void setMsg(String msg) {
        this.msg = msg;
    }
    //validate login

    public String validateUsernamePassword() {
        //return true or false by validating username and password 
        boolean valid = loginbean.validate(user, pwd);

        if (valid) {
            return "landing";
        } else {//message if validate failed
            FacesContext.getCurrentInstance().addMessage(
                    null,
                    new FacesMessage(FacesMessage.SEVERITY_WARN,
                            "Incorrect Username and Password",
                            "Please enter correct username and Password"));
            return "login";
        }

    }

}
