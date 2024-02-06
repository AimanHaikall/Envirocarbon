package bdUtil;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;

import com.model.Water;
import com.model.User;

public class WaterDAO {
	public List<Water> getWaterByUser(User user) {
		Session session = HibernateCF.getSessionFactory().openSession();
        String jpqlQuery = "SELECT w FROM Water w WHERE w.user = :user";
        TypedQuery<Water> query = session.createQuery(jpqlQuery, Water.class);
        query.setParameter("user", user);
        
        return query.getResultList();
    }
	
	public List<Water> getAllWater() {
        try (Session session = HibernateCF.getSessionFactory().openSession()) {
            String jpqlQuery = "SELECT w FROM Water w";
            TypedQuery<Water> query = session.createQuery(jpqlQuery, Water.class);

            return query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            // Handle the exception appropriately based on your application requirements
            return new ArrayList<>(); // Or throw an exception, return null, etc.
        }
    }
}
