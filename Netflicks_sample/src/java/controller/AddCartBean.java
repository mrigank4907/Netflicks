package controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Named(value = "addCartBean")
@SessionScoped
public class AddCartBean implements Serializable {

    private final List<String> items = new ArrayList<>();
    private final List<String> checkoutItems = new ArrayList<>();

    @PersistenceContext(unitName = "Netflicks")
    private EntityManager em;

    //Default Constructor
    public AddCartBean() {
    }

    public void addToBasket(String name) {
        // obtain current number of items in 
        if (!items.contains(name)) {
            items.add(name);
        }
        String temp = String.format("%1$-20s %2$-20s", name, "Added into the cart");
        System.out.print(temp);
    }

    public void removeFromBasket(String name) {
        if (items.contains(name)) {
            items.remove(name);
        }
    }

    public String checkout() {
        if (!items.isEmpty()) {
            checkoutItems.addAll(items);
            items.clear();
        }
        return "checkout";

    }

    public String cancel() {
        items.clear();
        return "movies";
    }

    public List<String> getItemList() {
        return items;
    }

    public List<String> getCheckoutList() {
        return checkoutItems;
    }

    public String getOrderedLink() {
        Map<String, String> order = new HashMap<>();
        MoviesBean m = new MoviesBean();
        for (String name : checkoutItems) {
            order.putAll(getCheckoutMovie(name));
        }

        return order.values().toString();
    }

    public Map<String, String> getCheckoutMovie(String mName) {
        Map<String, String> resultMap = new HashMap<>();
        Query query = em.createNativeQuery("SELECT name,Trailer FROM Movies WHERE name=?1");
        query.setParameter(1, mName);
        List<Object[]> resultList = query.getResultList();
        for (Object[] result : resultList) {
            resultMap.put((String) result[0], (String) result[1]);
        }
        return resultMap;
    }

    public String clearOrder() {
        checkoutItems.clear();
        return "movies";
    }
}
