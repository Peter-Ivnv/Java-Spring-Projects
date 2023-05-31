package kz.Ivanov.crm.crm.manager.services;

import kz.Ivanov.crm.crm.manager.entities.Course;

import java.util.List;

public interface CourseService {
    Course addCourse(Course course);
    List<Course> getAllCourses();
}
