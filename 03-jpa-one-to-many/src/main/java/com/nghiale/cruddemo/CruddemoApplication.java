package com.nghiale.cruddemo;

import com.nghiale.cruddemo.dao.AppDAO;
import com.nghiale.cruddemo.entity.Course;
import com.nghiale.cruddemo.entity.Instructor;
import com.nghiale.cruddemo.entity.InstructorDetail;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AppDAO appDAO) {

		return runner -> {
			// createInstructor(appDAO);

			// findInstructor(appDAO);

			// findInstructorDetail(appDAO);

			// deleteInstructor(appDAO);

			// deleteInstructorDetail(appDAO);

			// createInstructorWithCourse(appDAO);

			// findInstructorWithCourse(appDAO);

			// findCoursesForInstructor(appDAO);

			findInstructorWithCoursesJoinFetch(appDAO);
		};
	}

	private void findInstructorWithCoursesJoinFetch(AppDAO appDAO) {

		// find the instructor
		Instructor instructor = appDAO.findInstructorByJoinFetch(1);
		System.out.println(instructor);
		System.out.println(instructor.getCourses());
	}

	private void findCoursesForInstructor(AppDAO appDAO) {

		// find instructor
		Instructor instructor = appDAO.findInstructorById(1);
		System.out.println(instructor);

		// find courses for instructor
		List<Course> courses = appDAO.findCoursesByInstructorId(1);

		// associate the objects
		instructor.setCourses(courses);
		System.out.println(instructor.getCourses());
		System.out.println("Done!");
	}

	private void findInstructorWithCourse(AppDAO appDAO) {

		Instructor instructor = appDAO.findInstructorById(1);
		System.out.println(instructor);
		System.out.println(instructor.getCourses());
		System.out.println("Done!");
	}

	private void createInstructorWithCourse(AppDAO appDAO) {

		// create an Instructor
		Instructor instructor =
				new Instructor("Nghia", "Le", "nghiale@gmail.com");

		// create an Instructor Detail
		InstructorDetail instructorDetail =
				new InstructorDetail("https://www.youtube.com/@MixiGaming89","khongbiet");

		// associate the objects
		instructor.setInstructorDetail(instructorDetail);

		// create some courses
		Course course1 = new Course("Khoa hoc lam nguoi xau");
		Course course2 = new Course("Khoa hoc lam nguoi tot");

		// add courses to Instructor
		instructor.add(course1);
		instructor.add(course2);

		// save Instructor
		// This is will ALSO save the courses because CascadeType.PERSIST
		appDAO.save(instructor);

		System.out.println("Done!");
	}

	private void deleteInstructorDetail(AppDAO appDAO) {
		appDAO.deleteInstructorDetailById(5);
		System.out.println("Done!");
	}

	private void findInstructorDetail(AppDAO appDAO) {
		InstructorDetail instructorDetail = appDAO.findInstructorDetailById(4);
		System.out.println(instructorDetail);
		System.out.println(instructorDetail.getInstructor());
	}

	private void deleteInstructor(AppDAO appDAO) {
		appDAO.deleteInstructorById(2);
		System.out.println("Done!");
	}

	private void findInstructor(AppDAO appDAO) {
		Instructor instructor = appDAO.findInstructorById(1);
		System.out.println(instructor);
		System.out.println(instructor.getInstructorDetail());
	}

	private void createInstructor(AppDAO appDAO) {

		Instructor instructor =
				new Instructor("Nghia", "Le", "nghiale@gmail.com");

		InstructorDetail instructorDetail =
				new InstructorDetail("https://www.youtube.com/@MixiGaming89","khongbiet");

		instructor.setInstructorDetail(instructorDetail);

		appDAO.save(instructor);
	}

}
