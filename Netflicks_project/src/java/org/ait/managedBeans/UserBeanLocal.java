package org.ait.managedBeans;

import javax.ejb.Local;

@Local
public interface UserBeanLocal {

    //method to add users
    public int createUser(String username, String password, String address, String usertype, String message);

    //check is username and password validate
    public boolean validate(String user, String pwd);

}
