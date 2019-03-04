package by.jd2.hib_ex02.main;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import by.jd2.hib_ex02.bean.Task;
import by.jd2.hib_ex02.bean.User;
import by.jd2.hib_ex02.bean.UserDetail;

public class Main {

	public static void main(String[] args) throws ParseException {
		//addUserTasks();
		//retrieveUserAndUserTasks();
		//deleteTask();
		deleteUser();
	}
	

	public static void addUserTasks() throws ParseException {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(User.class)
				.addAnnotatedClass(UserDetail.class)
				.addAnnotatedClass(Task.class)
				.buildSessionFactory();

		Session session = factory.getCurrentSession();

		try {

			session.beginTransaction();

			int userId = 9;
			User user = session.get(User.class, userId);		
			
			Task task1 = new Task();
			Task task2 = new Task();
			
			task1.setTitle("do java test 1");
			task2.setTitle("do java test 2");
			
			user.addTask(task1);
			user.addTask(task2);
			
			session.save(task1);
			session.save(task2);


			//session.save(user);

			session.getTransaction().commit();

			System.out.println("Done!");

		} finally {
			factory.close();
		}

	}

	public static void retrieveUserAndUserTasks() {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(User.class)
				.addAnnotatedClass(UserDetail.class)
				.addAnnotatedClass(Task.class)
				.buildSessionFactory();

		Session session = factory.getCurrentSession();

		session.beginTransaction();

		int userId = 9;
		User user= session.get(User.class, userId);		
		
		System.out.println("User: " + user.getUserDetail().getCity());
		
		/*List<Task> tasks = user.getTasks();
		
		for(Task task : tasks) {
			System.out.println(task.getTitle());
		}*/
		
		session.getTransaction().commit();

		session.close();
		factory.close();
	}

	public static void deleteTask() {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(User.class)
				.addAnnotatedClass(UserDetail.class)
				.addAnnotatedClass(Task.class)
				.buildSessionFactory();

		Session session = factory.getCurrentSession();

		session.beginTransaction();

		int theId = 24;
		Task tempTask = session.get(Task.class, theId);
		
		session.delete(tempTask);


		session.getTransaction().commit();

		session.close();
		factory.close();

	}
	
	public static void deleteUser() {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(User.class)
				.addAnnotatedClass(UserDetail.class)
				.addAnnotatedClass(Task.class)
				.buildSessionFactory();

		Session session = factory.getCurrentSession();

		session.beginTransaction();

		int theId = 9;
		User tempUser = session.get(User.class, theId);
		
		session.delete(tempUser);


		session.getTransaction().commit();

		session.close();
		factory.close();

	}


}
