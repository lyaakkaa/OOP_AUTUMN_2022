package views;


import models.Teacher;
import database.Database;
import models.*;
import utils.Util;
import java.io.IOException;
import java.util.*;

public class TeacherView extends UserView {
    private Teacher teacher;

    public TeacherView() {
        setMenu(
                "-----------------------\n" +
                "|1| View personal data\n" +
                "|2| View courses\n" +
                "|3| Send message\n" +
                "|4| View news\n" +
                "|X| Cancel\n" +
                "-----------------------"
        );
    }

    public TeacherView(Teacher teacher) {
        this();
        this.teacher = teacher;
        greet();
    }

    @Override
    public void greet() {
        System.out.println("Welcome, " + teacher.getName() + "!");
        Database.getInstance().addUserAction("User " + teacher.getName() + " (Teacher) logged in at " + new Date().toString());
    }

    @Override
    public boolean performAction(String choice) throws IOException, InterruptedException {
        switch(choice.toLowerCase()) {
            case "1" -> viewPersonalData();
            case "2" -> viewCourses();
            case "3" -> sendMessage();
            case "4" -> viewNews();
            case "5", "x", "q", "exit", "quit" -> {
                System.out.println("Logging out.. Goodbye, " + teacher.getName() + "!");
                return false;
            }
            default -> {
                System.out.println("Wrong operation was selected, please, choose the correct one");
                return true;
            }
        }
        return true;
    }

    public void viewPersonalData() throws InterruptedException {
        System.out.println("Teacher: |" + teacher.getId() + "| " + teacher.getSurname() + " " + teacher.getName() + ". " + teacher.getTitle());
        System.out.println("Experience: " + teacher.getExperience());
        System.out.println("Rating: " + teacher.getRating());
        Thread.sleep(1000);
    }

    public void viewCourses() throws IOException, InterruptedException {
        System.out.println("\nList of my courses: ");

        ArrayList<Course> courses = new ArrayList<>(teacher.getCourses());
        Util.printList(courses);
        System.out.println("Select a course to manage, or X to cancel the request");
        int choice = Util.parseChoice(Util.reader.readLine());
        if(Util.isInRange(choice, 0, courses.size() - 1)) {
            manageCourse(courses.get(choice));
        } else {
            System.out.println("Invalid input");
        }
    }

    private void sendMessage() throws IOException, InterruptedException {
        Util.sendMessage(teacher);
    }

    private void manageCourse(Course course) throws IOException, InterruptedException {
        System.out.println("Course: " + course);
        System.out.println("|1| View students and their information\n|2| Put marks\n|3| Manage files\n|X| Cancel");
        switch(Util.reader.readLine().toLowerCase()) {
            case "1" -> viewStudents(course);
            case "2" -> putMarks(course);
            case "3" -> manageCourseFiles(course);
            default -> System.out.println("Operation cancelled");
        }
    }

    private void viewStudents(Course course) {
        if(Database.getInstance().getStudents().isEmpty()) {
            System.out.println("No students for this course yet");
            return;
        }
        int index = 1;
        for(Student student : Database.getInstance().getStudents()) {
            if(student.getTranscript().getCourses().contains(course)) {
                System.out.println(index + ") " + student.getName() + " " + student.getSurname() + ", " + student.getFaculty());
                index++;
            }
        }
    }

    private void putMarks(Course course) throws IOException, InterruptedException {
        ArrayList<Student> students = new ArrayList<>();
        System.out.println("Caution! Enter marks like this: <FA SA FE> (example: 29 28 33). Otherwise it won't work");
        System.out.println("FA stands for 'first attestation', SA for 'second attestation' and FE for 'final exam'");
        Thread.sleep(800);
        for(Student student : Database.getInstance().getStudents()) {
            if(student.getTranscript().getCourses().contains(course)) {
                students.add(student);
            }
        }
        if(!students.isEmpty()) {
            for(Student student : students) {
                for(Map.Entry<Period, HashMap<Course, Mark>> entry : student.getTranscript().getMarks().entrySet()) {
                    for(Map.Entry<Course, Mark> courseMark : entry.getValue().entrySet()) {
                        if(courseMark.getKey().equals(course)) {
                            System.out.println("Student: " + student.getName() + " " + student.getSurname());
                            System.out.println("Format:         FA   SA   FE   OD   OL   GPA");
                            System.out.println("Previous marks: " + courseMark.getValue());
                            System.out.print("Enter marks: ");
                            String[] marks = Util.reader.readLine().split(" ");
                            teacher.putMark(marks, courseMark.getValue());
                            System.out.println("Marks are delivered!\n");
                            Thread.sleep(500);
                        }
                    }
                }
            }
            return;
        }
        System.out.println("There are currently no students that are registered for this course");
    }

    private void manageCourseFiles(Course course) throws IOException, InterruptedException {
        System.out.println("|1| View files\n|2| Add file\n|3| Delete file");
        switch(Util.reader.readLine().toLowerCase()) {
            case "1" -> viewFiles(course);
            case "2" -> addFile(course);
            case "3" -> deleteFile(course);
            default -> System.out.println("Wrong input");
        }
    }

    private void viewFiles(Course course) {
        Util.printList(course.getCourseFiles());
    }

    private void addFile(Course course) throws IOException {
        System.out.print("File name: ");
        String fileName = Util.reader.readLine();
        CourseFile file = new CourseFile(fileName, new Date());
        course.addCourseFile(file);
    }

    private void deleteFile(Course course) throws IOException {
        ArrayList<CourseFile> files = course.getCourseFiles();

        if(files.size() > 0) {
            System.out.println("Select which file to remove, or X to cancel:");
            for(int i = 0; i < files.size(); i++) {
                System.out.println((i + 1) + ") " + files.get(i));
            }
            System.out.println("X) Cancel");

            int choice = Util.parseChoice(Util.reader.readLine());
            if(choice < 0 || !Util.isInRange(choice, 0, files.size() - 1)) {
                System.out.println("Operation was prevented");
                return;
            }
            files.remove(choice);
            System.out.println("File has been removed!");
            return;
        }
        System.out.println("There is currently no files to remove");
    }
}