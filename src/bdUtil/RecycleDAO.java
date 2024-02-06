package bdUtil;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;

import com.model.Recycle;

import com.model.User;

public class RecycleDAO {
	public List<Recycle> getRecycleByUser(User user) {
		Session session = HibernateCF.getSessionFactory().openSession();
        String jpqlQuery = "SELECT w FROM Recycle w WHERE w.user = :user";
        TypedQuery<Recycle> query = session.createQuery(jpqlQuery, Recycle.class);
        query.setParameter("user", user);
        
        return query.getResultList();
    }
	public List<Recycle> getAllRecycle() {
        try (Session session = HibernateCF.getSessionFactory().openSession()) {
            String jpqlQuery = "SELECT r FROM Recycle r";
            TypedQuery<Recycle> query = session.createQuery(jpqlQuery, Recycle.class);

            return query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            // Handle the exception appropriately based on your application requirements
            return new ArrayList<>(); // Or throw an exception, return null, etc.
        }
    }
}
