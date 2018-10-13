package org.ait.managedBeans;

import org.ait.entity.Usertable;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
public class UserBeanImpl implements UserBeanLocal {

    @PersistenceContext(unitName = "netflicksProject")
    private EntityManager em;
    //User name 
    private String userName;
    //user ID
    private long id;

    //Getter for id
    public long getId() {
        return this.id;
    }

    //validate user exists
    @Override
    public boolean validate(String user, String pwd) {
        // creating named query and set parameter used for username and password
        Query query = em.createNamedQuery("Usertable.loginValidate");
        query.setParameter("username", user);
        query.setParameter("password", pwd);
        if ((long) query.getSingleResult() > 0) {
            return true;
        }
        return false;
    }

    //Adds a new customer to the database with given name, password, address, usertype, message
    @Override
    public int createUser(String username, String password, String address, String usertype, String message) {
        //user table object
        Usertable usr = new Usertable();

        //making it persistence to autogenerate id before adding details
        persist(usr);
        // setting username, password, address, usertype, message
        usr.setUsername(username);
        usr.setPassword(password);
        usr.setAddress(address);
        usr.setUsertype(usertype);

        // return id of new customer
        return 1;
    }

    //used to persist objects
    public void persist(Object object) {
        em.persist(object);
    }
}
