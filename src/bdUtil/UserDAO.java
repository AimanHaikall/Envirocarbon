package bdUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.model.User;

public class UserDAO {

	private final HttpServletRequest request;
	
	public UserDAO(HttpServletRequest request) {
		super();
		this.request = request;
	}

	public void saveUser(User user) {
		Transaction transaction = null;
		try (Session session = HibernateCF.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			// save the student object
			session.save(user);
			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}

	public boolean validate(String userName, String password) {

		Transaction transaction = null;
		User user = null;
		try (Session session = HibernateCF.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			// get an user object
			user = (User) session.createQuery("FROM User U WHERE U.username = :userName")
					.setParameter("userName", userName).uniqueResult();

			if (user != null && user.getPassword().equals(password)) {
				return true;
			}
			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return false;
	}
	
	public User getCurrentUser() {
		int currentUserId = getCurrentUserIdFromSession();
		
		try (Session session = HibernateCF.getSessionFactory().openSession()) {
            return session.get(User.class, currentUserId);
        }
	}
	
	private int getCurrentUserIdFromSession() {
		HttpSession session = request.getSession();
		
		Object userIdAttribute = session.getAttribute("id");
		
        return (int) userIdAttribute;
        
    }

}