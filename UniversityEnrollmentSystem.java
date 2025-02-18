import java.util.*;
class CourseFullException extends Exception {
    public CourseFullException(String message) {
        super(message);
    }
}
class PrerequisiteNotMetException extends Exception {
    public PrerequisiteNotMetException(String message) {
        super(message);
    }
}
class Course {
    private String courseName;
    private int maxEnrollment;
    private List<Student> enrolledStudents;
    private String prerequisite;
    public Course(String courseName, int maxEnrollment, String prerequisite) {
        this.courseName = courseName;
        this.maxEnrollment = maxEnrollment;
        this.prerequisite = prerequisite;
        this.enrolledStudents = new ArrayList<>();
    }
    public String getCourseName() {
        return courseName;
    }
    public String getPrerequisite() {
        return prerequisite;
    }
    public boolean isCourseFull() {
        return enrolledStudents.size() >= maxEnrollment;
    }
    public void enrollStudent(Student student) throws CourseFullException, PrerequisiteNotMetException {
        if (isCourseFull()) {
            throw new CourseFullException("Error: The course " + courseName + " is full.");
        }
        if (!student.hasCompletedPrerequisite(prerequisite)) {
            throw new PrerequisiteNotMetException("Error: " + student.getName() + " has not completed the prerequisite " + prerequisite + " for " + courseName + ".");
        }
        enrolledStudents.add(student);
        student.addCourse(courseName);
        System.out.println(student.getName() + " successfully enrolled in " + courseName + ".");
    }
}
class Student {
    private String name;
    private Set<String> completedCourses;
    private Set<String> enrolledCourses;
    public Student(String name) {
        this.name = name;
        this.completedCourses = new HashSet<>();
        this.enrolledCourses = new HashSet<>();
    }
    public String getName() {
        return name;
    }
    public void completeCourse(String courseName) {
        completedCourses.add(courseName);
    }
    public boolean hasCompletedPrerequisite(String prerequisite) {
        return completedCourses.contains(prerequisite);
    }

    public void addCourse(String courseName) {
        enrolledCourses.add(courseName);
    }

    public Set<String> getEnrolledCourses() {
        return enrolledCourses;
    }
}

public class UniversityEnrollmentSystem {
    public static void main(String[] args) {
        Student student1 = new Student("John Robert");
        Student student2 = new Student("Jane Smith");
        student1.completeCourse("Core Java");
        student2.completeCourse("Basic Programming");
        Course course1 = new Course("Advanced Java", 2, "Core Java");
        Course course2 = new Course("Data Structures", 2, "Core Java");

        try {
            course1.enrollStudent(student1);
            course1.enrollStudent(student2);
        } catch (CourseFullException | PrerequisiteNotMetException e) {
            System.out.println(e.getMessage());
        }
        try {
            course2.enrollStudent(student1);
            course2.enrollStudent(student2);
        } catch (CourseFullException | PrerequisiteNotMetException e) {
            System.out.println(e.getMessage());
        }
    }
}
