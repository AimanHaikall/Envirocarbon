package bdUtil;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;

import com.model.User;
import com.model.Electric;

public class ElectricDAO {
	public List<Electric> getElectricByUser(User user) {
		Session session = HibernateCF.getSessionFactory().openSession();
        String jpqlQuery = "SELECT w FROM Electric w WHERE w.user = :user";
        TypedQuery<Electric> query = session.createQuery(jpqlQuery, Electric.class);
        query.setParameter("user", user);
        
        return query.getResultList();
    }
	
	public List<Electric> getAllElectric() {
        try (Session session = HibernateCF.getSessionFactory().openSession()) {
            String jpqlQuery = "SELECT e FROM Electric e";
            TypedQuery<Electric> query = session.createQuery(jpqlQuery, Electric.class);

            return query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            // Handle the exception appropriately based on your application requirements
            return new ArrayList<>(); // Or throw an exception, return null, etc.
        }
    }
}
