package bdUtil;

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
}
