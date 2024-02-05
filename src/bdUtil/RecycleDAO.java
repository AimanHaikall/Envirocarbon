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
}
