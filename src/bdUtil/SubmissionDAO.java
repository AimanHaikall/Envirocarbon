package bdUtil;

import java.util.Collections;
import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import org.hibernate.Session;

import com.model.Submission;
import com.model.User;

public class SubmissionDAO {

	public Submission getSubmissionByUser(User user) {
		try (Session session = HibernateCF.getSessionFactory().openSession()) {
			// Use HQL to query submissions by user ID
			String hql = "FROM Submission s WHERE s.user = :user";
			TypedQuery<Submission> query = session.createQuery(hql, Submission.class);
			query.setParameter("user", user);

			try {
				Submission submission = query.getSingleResult();
				// If a submission is found, return it
				return submission;
			} catch (NoResultException e) {
				// If no submissions found, create a new submission
				Submission newSubmission = createNewSubmission(user);
				session.beginTransaction();
				session.save(newSubmission);
				session.getTransaction().commit();

				// Return the newly created submission
				return newSubmission;
			}
		}
	}

	private Submission createNewSubmission(User user) {
		Submission newSubmission = new Submission();
		newSubmission.setUser(user);
		return newSubmission;
	}

	public void updateResult(int type, double value, User user) {
		try (Session session = HibernateCF.getSessionFactory().openSession()) {
			Submission submission = getSubmissionByUser(user);
			if (type == 1) {
				// water
				submission.setResultWater(value);

			} else if (type == 2) {
				// electric
				submission.setResultElectric(value);

			} else if (type == 3) {
				// recycle
				submission.setResultRecycle(value);
			} else {
				return;
			}
			session.beginTransaction();
			session.update(submission);
			session.getTransaction().commit();

		}
	}
	
	public List<Submission> getAllSubmissions() {
	    try (Session session = HibernateCF.getSessionFactory().openSession()) {
	        // Use HQL to fetch all submissions
	        String hql = "FROM Submission";
	        TypedQuery<Submission> query = session.createQuery(hql, Submission.class);

	        return query.getResultList();
	    }
	}

}
