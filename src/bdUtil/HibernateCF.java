package bdUtil;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.model.Admin;
import com.model.Electric;
import com.model.Recycle;
import com.model.Submission;
import com.model.User;
import com.model.Water;

public class HibernateCF {
	static SessionFactory sessionFactory = null;

	public static SessionFactory getSessionFactory() {

		if (sessionFactory == null) {

			Configuration config = new Configuration();
			config.configure("hibernate.cfg.xml");
			config.addAnnotatedClass(Admin.class);
			config.addAnnotatedClass(Electric.class);
			config.addAnnotatedClass(Recycle.class);
			config.addAnnotatedClass(User.class);
			config.addAnnotatedClass(Water.class);
			config.addAnnotatedClass(Submission.class);

			sessionFactory = config.buildSessionFactory();
		}
		return sessionFactory;

	}
}