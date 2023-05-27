import java.lang.*;
/**
*/
public class Teacher    extends Employee{abstract} {
/**
*/
private  Faculty faculty;
/**
*/
private Double rate;
/**
*/
private TeacherStatus teacherStatus;
/**
*/
private  Vector<Course> courses;
/**
 * @return 
*/
public  Faculty getFaculty() {
    return null;
}
/**
 * @param faculty 
*/
public void setFaculty( Faculty faculty) {
}
/**
 * @return 
*/
public Double getRate() {
    return null;
}
/**
 * @param rate 
*/
public void setRate(Double rate) {
}
/**
 * @return 
*/
public TeacherStatus getTeacherStatus() {
    return null;
}
/**
 * @param teacherStatus 
*/
public void setTeacherStatus(TeacherStatus teacherStatus) {
}
/**
 * @return 
*/
public  Vector<Course> getCourses() {
    return null;
}
/**
 * @param courses 
*/
public void setCourses( Vector<Course> courses) {
}
/**
 * @return 
*/
public String toString() {
    return null;
}
/**
 * @param o 
 * @return 
*/
public Boolean equals(Object o) {
    return null;
}
/**
 * @return 
*/
public Integer hashCode() {
    return null;
}
/**
 * @param o 
 * @return 
*/
public Integer compareTo(Object o) {
    return null;
}
/**
 * @param student 
 * @return 
*/
public String viewStudentInfo(Student student) {
    return null;
}
/**
 * @return 
*/
public Vector<Course> viewCourses() {
    return null;
}
/**
 * @param student 
 * @param course 
 * @param mark 
*/
public void putMarks(Student student, Course course, Double mark) {
}
/**
 * @param student 
 * @param course 
*/
public void viewMarks(Student student, Course course) {
}
/**
 * @param file 
 * @param course 
 * @return 
*/
public Boolean addCourseFile(Course course, File file) {
    return null;
}
/**
 * @param file 
 * @param course 
 * @return 
*/
public Boolean deleteCourseFile(Course course, File file) {
    return null;
}
/**
 * @param file 
 * @param course 
 * @return 
*/
public Boolean updateCourseFile(Course course, File file) {
    return null;
}
/**
 * @return 
*/
public Vector<Student> viewStudents() {
    return null;
}
/**
 * @param student 
 * @param course 
 * @param attendance 
*/
public void putAttendance(Course course, Student student, int attendance) {
}
}

