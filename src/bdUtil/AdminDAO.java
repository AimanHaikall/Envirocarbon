package bdUtil;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.model.Admin;

public class AdminDAO {

    public boolean validate(String username, String password) {
        Transaction transaction = null;
        Admin admin = null;

        try (Session session = HibernateCF.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // get an admin object
            admin = (Admin) session.createQuery("FROM Admin A WHERE A.username = :username")
                    .setParameter("username", username).uniqueResult();

            if (admin != null && admin.getPassword().equals(password)) {
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

    public Admin getAdminById(int adminId) {
        try (Session session = HibernateCF.getSessionFactory().openSession()) {
            return session.get(Admin.class, adminId);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public Admin getAdminByUsername(String username) {
        try (Session session = HibernateCF.getSessionFactory().openSession()) {
            return (Admin) session.createQuery("FROM Admin A WHERE A.username = :username")
                    .setParameter("username", username).uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
