import java.lang.*;

/**
 */
public class Course implements Serializable {
    /**
     */
    private String name;

    /**
     */
    private String code;

    /**
     */
    private String credits;

    /**
     */
    private Faculty faculty;

    /**
     */
    private Vector<Teacher> teachers;

    /**
     */
    private Integer limitOfStudents;

    /**
     */
    private HashSet<Course> prerequisities;

    /**
     */
    private HashSet<File> courseFiles;

    /**
     */
    private HashMap<Student, Double> marks;

    /**
     */
    private Vector<Student> students;

    /**
     */
    private int attribute25;

    /**
     * @return 
     */
    public String getName() {
        return null;
    }

    /**
     * @param name 
     */
    public void setName(String name) {
    }

    /**
     * @return 
     */
    public String getCode() {
        return null;
    }

    /**
     * @param code 
     */
    public void setCode(String code) {
    }

    /**
     * @return 
     */
    public String getCredits() {
        return null;
    }

    /**
     * @param credits 
     */
    public void setCredits(String credits) {
    }

    /**
     * @return 
     */
    public Faculty getFaculty() {
        return null;
    }

    /**
     * @param faculty 
     */
    public void setFaculty(Faculty faculty) {
    }

    /**
     * @return 
     */
    public Vector<Teacher> getTeachers() {
        return null;
    }

    /**
     * @return 
     */
    public Integer getLimitOfStudents() {
        return null;
    }

    /**
     * @param limitOfStudents 
     */
    public void setLimitOfStudents(Integer limitOfStudents) {
    }

    /**
     * @return 
     */
    public HashSet<Course> getPrerequisities() {
        return null;
    }

    /**
     * @return 
     */
    public HashSet<File> getCourseFiles() {
        return null;
    }

    /**
     * @return 
     */
    public HashMap<Student, Double> getMarks() {
        return null;
    }

    /**
     * @return 
     */
    public Vector<Student> getStudents() {
        return null;
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
     */
    public void addStudent(Student student) {
    }

    /**
     * @param student 
     */
    public void removeStudents(Student student) {
    }

    /**
     * @param course 
     */
    public void addPrereq(Course course) {
    }
}

