package com.main;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.entity.Student;

public class App {
	public static void main(String[] args) {

		System.out.println("Project start.......");

		Configuration cfg = new Configuration();
		cfg.configure();
		SessionFactory factory = cfg.buildSessionFactory();

		Student st = new Student();

		Scanner sc = new Scanner(System.in);
		int num, roll, marks, physics, maths, chemistry, hindi, english;
		String name;
		System.out.println("Press 1 enter the Student Data");
		System.out.println("Press 2 Get the Student Data");
		System.out.println("Press 3 Update the Student Data");
		System.out.println("Press 4 Delete the Student Data");
		num = sc.nextInt();

		if (num == 1) {
			System.out.println("Enter student roll_number");
			roll = sc.nextInt();
			System.out.println("Enter student name");
			name = sc.next();
			System.out.println("Enter student Physics marks");
			physics = sc.nextInt();
			System.out.println("Enter student Maths marks");
			maths = sc.nextInt();
			System.out.println("Enter student Chemistry marks");
			chemistry = sc.nextInt();
			System.out.println("Enter student Hindi marks");
			hindi = sc.nextInt();
			System.out.println("Enter student English marks");
			english = sc.nextInt();

			st.setRoll_number(roll);
			st.setName(name);
			st.setPhysics(physics);
			st.setMaths(maths);
			st.setChemistry(chemistry);
			st.setHindi(hindi);
			st.setEnglish(english);

			System.out.println("Data Inserted  Sucssesfully");
			Session sess = factory.openSession();
			Transaction ts = sess.beginTransaction();

			sess.save(st);
			ts.commit();

		}
		if (num == 2) {

			System.out.println("Enter Student roll_number");
			Session sess = factory.openSession();
			roll = sc.nextInt();
			int p, m, c, h, e;
			double total;
			Student std = (Student) sess.get(Student.class, roll);

			System.out.println("Student Roll number:" + std.getRoll_number());
			System.out.println("Student name:" + std.getName());
			System.out.println("Physics:" + std.getPhysics());
			System.out.println("Maths:" + std.getMaths());
			System.out.println("Chemistry:" + std.getChemistry());
			System.out.println("Hindi:" + std.getHindi());
			System.out.println("English:" + std.getChemistry());

			p = std.getPhysics();
			m = std.getMaths();
			c = std.getChemistry();
			h = std.getHindi();
			e = std.getEnglish();
			// total=p+m+c+h+e;

			// Total marks for each subject
			double totalMarksPerSubject = 100;

			// Calculate percentage
			double totalObtainedMarks = p + m + c + h + e;
			double percentage = (totalObtainedMarks / (5 * totalMarksPerSubject)) * 100;

			System.out.println("Percentage: " + percentage + "%");

			if (percentage >= 90) {
				System.out.println("A");
			} else if (percentage >= 80) {
				System.out.println("B");

			} else if (percentage >= 70) {
				System.out.println("C");

			} else if (percentage >= 60) {
				System.out.println("D");

			} else {
				System.out.println("F");

			}

			System.out.println("Process Success.........");

		}

		if (num == 3) {
		    Session sess = factory.openSession();
		    Transaction ts = sess.beginTransaction();

		    System.out.println("Enter student roll_number to update:");
		    int rollToUpdate = sc.nextInt();

		    // Consume the newline character left in the buffer
		    sc.nextLine();

		    // Retrieve the existing student object
		    Student existingStudent = sess.get(Student.class, rollToUpdate);

		    if (existingStudent != null) {
		        System.out.println("Enter new name:");
		        String newName = sc.nextLine(); // Use nextLine() to read the whole line
		        System.out.println("Enter new Physics marks:");
		        int newPhysics = sc.nextInt();
		        System.out.println("Enter new Maths marks:");
		        int newMaths = sc.nextInt();
		        System.out.println("Enter new Chemistry marks:");
		        int newChemistry = sc.nextInt();
		        System.out.println("Enter new Hindi marks:");
		        int newHindi = sc.nextInt();
		        System.out.println("Enter new English marks:");
		        int newEnglish = sc.nextInt();

		        // Update the existing student object with new values
		        existingStudent.setName(newName);
		        existingStudent.setPhysics(newPhysics);
		        existingStudent.setMaths(newMaths);
		        existingStudent.setChemistry(newChemistry);
		        existingStudent.setHindi(newHindi);
		        existingStudent.setEnglish(newEnglish);

		        System.out.println("Data updated successfully");
		    } else {
		        System.out.println("Student with roll number " + rollToUpdate + " not found");
		    }

		    ts.commit();
		}


		else {
			System.out.println("Enter student roll_number");
			Session sess = factory.openSession();
			roll = sc.nextInt();
			Transaction ts = sess.beginTransaction();

			Query q = sess.createQuery("delete from Student where roll_number=:x");
			q.setParameter("x", roll);

			int i = q.executeUpdate();
			if (i > 0) {
				System.out.println("Data deleted");
			}

			ts.commit();
		}
	}
}
