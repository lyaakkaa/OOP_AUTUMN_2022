import java.lang.*;
/**
*/
public class  Manager    extends Employee{abstract} {
/**
*/
private  ManagerType managerType;
/**
 * @return 
*/
public  ManagerType getManagerType() {
    return null;
}
/**
 * @param managerType 
*/
public void setManagerType( ManagerType managerType) {
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
*/
public void infoStudents() {
}
/**
*/
public void infoTeachers() {
}
/**
 * @param news 
*/
public void addNews(News news) {
}
/**
 * @param news 
*/
public void deleteNews(News news) {
}
/**
 * @param course 
*/
public void addCourse(Course course) {
}
/**
 * @param course 
*/
public void deleteCourse(Course course) {
}
/**
 * @param student 
 * @return 
*/
public boolean approveRegistration(Student student) {
    return false;
}
/**
 * @param teacher 
 * @param course 
*/
public void assignCourseToTeachers(Teacher teacher, Course course) {
}
/**
*/
public void viewRequestsFromEmployee() {
}
/**
 * @param course 
*/
public void changeLimitOfStudents(Course course) {
}
/**
*/
public void openRegistration() {
}
/**
*/
public void closeRegistration() {
}
/**
 * @return 
*/
public Vector<Teacher> viewTeachersInAscOrder() {
    return null;
}
/**
 * @param teacher 
 * @return 
*/
public Vector<Course> viewTeachersCourse(Teacher teacher) {
    return null;
}
/**
 * @return 
*/
public Vector <Student> viewStudentsInAscOrder() {
    return null;
}
/**
 * @return 
*/
public Vector<Student> viewStudentByGpa() {
    return null;
}
/**
 * @return 
*/
public Integer getRetakeStudents() {
    return null;
}
/**
 * @return 
*/
public String statisticalReport() {
    return null;
}
}

