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

	public User getUserById(int userId) {
		try (Session session = HibernateCF.getSessionFactory().openSession()) {
			return session.get(User.class, userId);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public User getUserByUsername(String username) {
		try (Session session = HibernateCF.getSessionFactory().openSession()) {
			return (User) session.createQuery("FROM User U WHERE U.username = :username")
					.setParameter("username", username).uniqueResult();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public User getCurrentUser(HttpSession session) {
		int currentUserId = getCurrentUserIdFromSession(session);

		try (Session hibernateSession = HibernateCF.getSessionFactory().openSession()) {
			return hibernateSession.get(User.class, currentUserId);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	private int getCurrentUserIdFromSession(HttpSession session) {
		Object userIdAttribute = session.getAttribute("userId");

		return (int) userIdAttribute;
	}

	private boolean isUserExists(Session session, String username, String email, String phoneNum) {
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<Long> criteriaQuery = builder.createQuery(Long.class);
		Root<User> root = criteriaQuery.from(User.class);

		criteriaQuery.select(builder.count(root));
		criteriaQuery.where(builder.or(builder.equal(root.get("username"), username),
				builder.equal(root.get("email"), email), builder.equal(root.get("phoneNum"), phoneNum)));

		Long count = session.createQuery(criteriaQuery).uniqueResult();

		return count != null && count > 0;
	}

}