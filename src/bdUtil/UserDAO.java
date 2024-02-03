package bdUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.model.User;

public class UserDAO {

	private final HttpServletRequest request;
	
	public UserDAO(HttpServletRequest request) {
		super();
		this.request = request;
	}
	
	public void saveUser(User user) throws RuntimeException {
	    Transaction transaction = null;
	    try (Session session = HibernateCF.getSessionFactory().openSession()) {
	        // Check if the username, email, or phone number already exists
	        if (isUserExists(session, user.getUsername(), user.getEmail(), user.getPhoneNum())) {
	            throw new RuntimeException("Username, email, or phone number already exists");
	        }

	        // Start a transaction
	        transaction = session.beginTransaction();
	        // Save the user object
	        session.save(user);
	        // Commit transaction
	        transaction.commit();
	    } catch (Exception e) {
	        if (transaction != null) {
	            transaction.rollback();
	        }
	        throw new RuntimeException("Error saving user", e);
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

	private boolean isUserExists(Session session, String username, String email, String phoneNum) {
	    CriteriaBuilder builder = session.getCriteriaBuilder();
	    CriteriaQuery<Long> criteriaQuery = builder.createQuery(Long.class);
	    Root<User> root = criteriaQuery.from(User.class);

	    criteriaQuery.select(builder.count(root));
	    criteriaQuery.where(
	        builder.or(
	            builder.equal(root.get("username"), username),
	            builder.equal(root.get("email"), email),
	            builder.equal(root.get("phoneNum"), phoneNum)
	        )
	    );

	    Long count = session.createQuery(criteriaQuery).uniqueResult();

	    return count != null && count > 0;
	}
	
	
	
}