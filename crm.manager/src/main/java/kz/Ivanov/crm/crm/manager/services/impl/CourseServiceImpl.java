package kz.Ivanov.crm.crm.manager.services.impl;

import kz.Ivanov.crm.crm.manager.entities.Course;
import kz.Ivanov.crm.crm.manager.repositories.CourseRepository;
import kz.Ivanov.crm.crm.manager.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CourseServiceImpl implements CourseService {
    @Autowired
    private CourseRepository courseRepository;
    @Override
    public Course addCourse(Course course) {
        return courseRepository.save(course);
    }

    @Override
    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }
}
