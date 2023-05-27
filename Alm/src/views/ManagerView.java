package views;

import comparators.*;
import database.Database;
import enums.AttestationSeason;
import enums.LessonType;
import models.*;
import utils.Util;
import java.io.IOException;
import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class ManagerView extends UserView {
    private Manager manager;

    public ManagerView() {
        setMenu(
                "---------------------------------\n" +
                "|1| View students\n" +
                "|2| View teachers\n" +
                "|3| Approve student registration\n" +
                "|4| Add course\n" +
                "|5| Assign a course to a teacher\n" +
                "|6| Read messages\n" +
                "|7| Send message\n" +
                "|8| Create statistical report\n" +
                "|9| Manage news\n" +
                "|X| Logout\n" +
                "---------------------------------"
        );
    }

    public ManagerView(Manager manager) {
        this();
        this.manager = manager;
        greet();
    }

    @Override
    public void greet() {
        System.out.println("Welcome, " + manager.getType() + " manager " + manager.getName() + "!");
        Database.getInstance().addUserAction("User " + manager.getName() + " (Manager) logged in at " + new Date().toString());
    }

    @Override
    public boolean performAction(String choice) throws InterruptedException, IOException {
        switch(choice.toLowerCase()) {
            case "1" -> viewStudents();
            case "2" -> viewTeachers();
            case "3" -> approveRegistration();
            case "4" -> addCourse();
            case "5" -> assignCourseToTeacher();
            case "6" -> readMessages();
            case "7" -> sendMessage();
            case "8" -> createReport();
            case "9" -> manageNews();
            case "10", "x", "q", "exit", "quit" -> {
                System.out.println("Logging out.. Goodbye, " + manager.getName() + "!");
                return false;
            }
            default -> {
                System.out.println("Wrong operation was selected, please, choose the correct one");
                return true;
            }
        }
        return true;
    }

    public void viewStudents() throws IOException {
        ArrayList<Student> students = new ArrayList<>(Database.getInstance().getStudents());
        System.out.println("Choose order of displaying:\n|1| By name\n|2| By GPA\n|3| By ID");
        switch(Util.reader.readLine()) {
            case "1" -> students.sort(new NameComparator());
            case "2" -> students.sort(new GpaComparator());
            case "3" -> students.sort(new IdComparator());
        }
        System.out.println("All students:");
        Util.printList(students);
    }

    public void viewTeachers() throws IOException {
        ArrayList<Teacher> teachers = new ArrayList<>(Database.getInstance().getTeachers());
        System.out.println("Choose order of displaying:\n|1| By name\n|2| By salary");
        switch(Util.reader.readLine()) {
            case "1" -> teachers.sort(new NameComparator());
            case "2" -> teachers.sort(new SalaryComparator());
        }
        System.out.println("All teachers:");
        Util.printList(teachers);
    }

    public void approveRegistration() throws InterruptedException, IOException {
        HashMap<Student, ArrayList<Course>> requests = Database.getInstance().getCourseRegistrationRequests();

        if(!requests.isEmpty()) {
            System.out.println("Incoming requests of students: ");
            int index = 1;
            for(Map.Entry<Student, ArrayList<Course>> request : requests.entrySet()) {
               System.out.println(index + ") " + request.getKey().getName() + " " + request.getKey().getSurname());
               index++;
            }
            System.out.print("\nSelect which student's request to process: ");
            int choice = Util.parseChoice(Util.reader.readLine());

            if(Util.isInRange(choice, 0, requests.size() - 1)) {
                index = 0;
                for(Map.Entry<Student, ArrayList<Course>> request : requests.entrySet()) {
                    if(index == choice) {
                        System.out.println("Student: " + request.getKey().getName() + " " + request.getKey().getSurname() + ". " + request.getKey().getFaculty().getName());
                        processRequest(request.getKey(), request.getValue());
                        break;
                    }
                    index++;
                }
            } else {
                System.out.println("Select from the given list!");
            }
            return;
        }
        System.out.println("No incoming requests yet..");
        Thread.sleep(500);
    }

    public void addCourse() throws IOException {
        System.out.print("Enter the course data..\nCourse name: ");
        String name = Util.reader.readLine();
        System.out.print("Course description: ");
        String description = Util.reader.readLine();
        System.out.print("Course code: ");
        String code = Util.reader.readLine();
        System.out.println("Course faculty: ");
        ArrayList<Faculty> faculties = new ArrayList<>(Database.getInstance().getFaculties());
        Util.printList(faculties);
        int choice = Util.parseChoice(Util.reader.readLine());
        System.out.print("Course credits: ");
        int credits = Integer.parseInt(Util.reader.readLine());

        ArrayList<Lesson> lessons = new ArrayList<>();
        System.out.print("Enter quantity of lessons (can't be more than 4): ");
        int quantity = Integer.parseInt(Util.reader.readLine());
        LessonType type;
        DayOfWeek day;
        String[] startTime;
        String[] endTime;
        if(quantity > 4) {
            System.out.println("Invalid input");
            return;
        }
        for(int i = 0; i < quantity; i++) {
            System.out.println("Enter the lesson type:\n|1| Lecture |2| Practice |3| Laboratory");
            switch(Util.reader.readLine()) {
                case "1" -> type = LessonType.LECTURE;
                case "2" -> type = LessonType.PRACTICE;
                case "3" -> type = LessonType.LAB;
                default -> {
                    System.out.println("Invalid input");
                    return;
                }
            }
            System.out.println("Enter the day of the week:\n|1| Monday |2| Tuesday |3| Wednesday |4| Thursday |5| Friday |6| Saturday");
            switch(Util.reader.readLine()) {
                case "1" -> day = DayOfWeek.MONDAY;
                case "2" -> day = DayOfWeek.TUESDAY;
                case "3" -> day = DayOfWeek.WEDNESDAY;
                case "4" -> day = DayOfWeek.THURSDAY;
                case "5" -> day = DayOfWeek.FRIDAY;
                case "6" -> day = DayOfWeek.SATURDAY;
                default -> {
                    System.out.println("Invalid input");
                    return;
                }
            }
            System.out.print("Enter lesson's starting time (like this -> HH:MM): ");
            startTime = Util.reader.readLine().split(":");
            System.out.print("Enter lesson's ending time (like this -> HH:MM): ");
            endTime = Util.reader.readLine().split(":");
            lessons.add(new Lesson(type, day, Integer.parseInt(startTime[0]), Integer.parseInt(startTime[1]), Integer.parseInt(endTime[0]), Integer.parseInt(endTime[1])));
            System.out.println("\nLesson has been added!");
        }
        Course course = new Course(name, description, code, faculties.get(choice).getName(), credits, lessons);
        manager.addCourse(course);
        System.out.println("Course was successfully added");
    }

    public void assignCourseToTeacher() throws IOException {
        ArrayList<Course> courses = new ArrayList<>(Database.getInstance().getCourses());
        ArrayList<Teacher> teachers = new ArrayList<>(Database.getInstance().getTeachers());

        System.out.println("Select the course: ");
        Util.printList(courses);
        int courseChoice = Util.parseChoice(Util.reader.readLine());
        System.out.println("Now select the teacher to whom to assign the selected course:");
        Util.printUserList(teachers);
        int teacherChoice = Util.parseChoice(Util.reader.readLine());

        if(!teachers.get(teacherChoice).getCourses().contains(courses.get(courseChoice))) {
            teachers.get(teacherChoice).getCourses().add(courses.get(courseChoice));
            System.out.println("Course has been assigned!");
        } else {
            System.out.println("Course is already assigned!");
        }
    }

    public void sendMessage() throws IOException, InterruptedException {
        Util.sendMessage(manager);
    }

    public void readMessages() {
        ArrayList<Message> messages = Database.getInstance().getMessagesOf(manager);
        if(!messages.isEmpty()) {
            System.out.println("Incoming messages from:");
            Util.printList(messages);
            return;
        }
        System.out.println("No incoming messages yet..");
    }

    public void createReport() {
        ArrayList<Student> students = new ArrayList<>(Database.getInstance().getStudents());
        String fileName = "report.txt";
        double averageGpa = 0;
        int fitStudents = 0;
        int mcmStudents = 0;
        int bsStudents = 0;
        String performance;

        for(Student student : students) {
            averageGpa += student.getGpa();
            switch(student.getFaculty().getName()) {
                case FIT -> fitStudents++;
                case SECMC -> mcmStudents++;
                case BS -> bsStudents++;
            }
        }
        averageGpa /= students.size();
        if(averageGpa >= 4.0 && averageGpa <= 3.5) {
            performance = "Excellent";
        }
        else if(averageGpa >= 3.0) {
            performance = "Good";
        }
        else if(averageGpa >= 2.0) {
            performance = "Acceptable";
        } else {
            performance = "Poor";
        }
        manager.generateReport(fileName, students.size(), fitStudents, mcmStudents, bsStudents, averageGpa, performance);
        System.out.println("Report has been created! You can view it in the root directory");
    }

    public void manageNews() throws IOException {
        ArrayList<News> allNews = Database.getInstance().getNews();
        Util.viewNews();
        if(!allNews.isEmpty()) {
            System.out.println("\nWhich news do you wish to edit?");
            int choice = Util.parseChoice(Util.reader.readLine());
            if(choice < 0) {
                System.out.println("Operation was cancelled");
                return;
            }
            editNews(allNews.get(choice));
        }
    }

    private void editNews(News news) throws IOException {
        System.out.println("News: " + news.getTitle());
        System.out.println("What do you wish to edit?\n|1| Title |2| Content |3| Clear comments");

        switch(Util.reader.readLine()) {
            case "1" -> {
                System.out.print("Previous title: " + news.getTitle() + "\nEnter a new title: ");
                news.setTitle(Util.reader.readLine());
            }
            case "2" -> {
                System.out.print("Previous content: " + news.getTitle() + "\nEnter a new content: ");
                news.setContent(Util.reader.readLine());
            }
            case "3" -> {
                news.getComments().clear();
                System.out.println("Comments are removed!");
            }
        }
    }

    public void processRequest(Student student, ArrayList<Course> courses) throws IOException, InterruptedException {
        System.out.println("Check the request for correctness, if you find a mistake, reject the request. Courses:");

        Util.printList(courses);
        System.out.println("\nType the word:\n|V| Accept\n|X| Reject");
        String choice = Util.reader.readLine();
        Thread.sleep(500);
        if(choice.equalsIgnoreCase("accept")) {
            System.out.println("Request was accepted, we are almost there");
            acceptRequest(student, courses);
        }
        else if(choice.equalsIgnoreCase("reject")) {
            System.out.println("Request was rejected");
            Database.getInstance().getCourseRegistrationRequests().remove(student);
        } else {
            System.out.println("Unknown command");
        }
    }

    private void acceptRequest(Student student, ArrayList<Course> courses) throws IOException {
        System.out.print("Enter year: ");
        int year = Integer.parseInt(Util.reader.readLine());
        System.out.println("Enter season:\n|1| Fall\n|2| Spring");
        AttestationSeason season = (Util.reader.readLine().equals("1")) ? AttestationSeason.FALL : AttestationSeason.SPRING;
        Period period = new Period(year, season);

        student.getTranscript().getMarks().putIfAbsent(period, new HashMap<>());
        for(Course course: courses) {
            student.getTranscript().getMarks().get(period).put(course, new Mark());
        }
        Database.getInstance().getCourseRegistrationRequests().remove(student);
        System.out.println("Done!");
    }
}