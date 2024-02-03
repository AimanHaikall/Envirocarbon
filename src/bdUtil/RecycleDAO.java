//package bdUtil;
//
//import java.sql.Date;
//import java.util.ArrayList;
//import java.util.List;
//
//import org.hibernate.Session;
//
//import com.model.Recycle;
//import com.model.User;
//
//public class RecycleDAO {
//	public void save(double weightKg, double weightRm, Date month) {
//		Session session = HibernateCF.getSessionFactory().openSession();
//		
//		Recycle recycle = new Recycle();
//		recycle.setWeightKg(weightKg);
//		recycle.setWeightRm(weightRm);
//		recycle.setMonth(month);
//		
//		session.beginTransaction();
//		session.save(recycle);
//		session.getTransaction().commit();
//		session.close();
//	}
//	
//	public List<Recycle> getRecycleById(User user){
//		List<Recycle> recycleList = new ArrayList<>();
//		recycleList = user.getRecycleList();
//		
//		return recycleList;
//	}
//}
