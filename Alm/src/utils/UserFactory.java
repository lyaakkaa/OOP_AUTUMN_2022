package utils;

import database.Database;
import enums.*;
import models.*;
import java.io.IOException;
import java.util.*;

public class UserFactory {
    private String name;
    private String surname;
    private String id;
    private String login;
    private String password;
    private double salary;
    private ManagerType managerType;
    private TeacherTitle teacherTitle;
    private int experience;
    private YearOfStudy yearOfStudy;
    private Degree degree;
    private Faculty faculty;
    private Speciality specialty;

    public UserFactory() {}

    public User createUser(String userType) throws IOException {
        switch(userType) {
            case "admin" -> {
                return createAdmin();
            }
            case "manager" -> {
                return createManager();
            }
            case "teacher" -> {
                return createTeacher();
            }
            case "librarian" -> {
                return createLibrarian();
            }
            case "student" -> {
                return createStudent();
            }
        }
        return null;
    }

    public Admin createAdmin() throws IOException {
        getEmployeeData();
        return new Admin(name, surname, id, login, password, salary);
    }

    public Manager createManager() throws IOException {
        getEmployeeData();
        System.out.println("Select type of the manager (any other key will select OR manager): ");
        System.out.println("|1| OR\n|2| Departments");
        managerType = (Util.reader.readLine().equals("2")) ? ManagerType.DEPARTMENTS : ManagerType.OR;
        return new Manager(name, surname, id, login, password, salary, managerType);
    }

    public Teacher createTeacher() throws IOException {
        getEmployeeData();
        System.out.println("Select teacher title (any other key will select Professor): ");
        System.out.println("|1| Tutor\n|2| Lector\n|3| Senior Lector\n|4| Professor\n|5| Associative Professor");

        switch(Util.reader.readLine().toLowerCase()) {
            case "1" -> teacherTitle = TeacherTitle.TUTOR;
            case "2" -> teacherTitle = TeacherTitle.LECTOR;
            case "3" -> teacherTitle = TeacherTitle.SENIOR_LECTOR;
            case "5" -> teacherTitle = TeacherTitle.ASSOCIATIVE_PROFESSOR;
            default -> teacherTitle = TeacherTitle.PROFESSOR;
        }

        System.out.print("Enter teacher experience (integer year): ");
        experience = Integer.parseInt(Util.reader.readLine());
        return new Teacher(name, surname, id, login, password, salary,
                teacherTitle, experience, new ArrayList<>(), 0);
    }

    public Librarian createLibrarian() throws IOException {
        getEmployeeData();
        return new Librarian(name, surname, id, login, password, salary, new HashMap<>());
    }

    public Student createStudent() throws IOException {
        getUserData();
        boolean valid;

        do {
            System.out.print("Enter student's year of study: ");
            switch (Util.reader.readLine()) {
                case "1" -> {
                    yearOfStudy = YearOfStudy.FIRST;
                    valid = true;
                }
                case "2" -> {
                    yearOfStudy = YearOfStudy.SECOND;
                    valid = true;
                }
                case "3" -> {
                    yearOfStudy = YearOfStudy.THIRD;
                    valid = true;
                }
                case "4" -> {
                    yearOfStudy = YearOfStudy.FOURTH;
                    valid = true;
                }
                case "5", "6" -> {
                    yearOfStudy = YearOfStudy.EXTRA;
                    valid = true;
                }
                default -> {
                    System.out.println("Unexpected value, enter a proper value");
                    valid = false;
                }
            }
        } while(!valid);

        do {
            System.out.println("Enter student degree: ");
            System.out.println("|1| Bachelor\n|2| Master\n|3| PhD");
            switch(Util.reader.readLine()) {
                case "1" -> {
                    degree = Degree.BACHELOR;
                    valid = true;
                }
                case "2" -> {
                    degree = Degree.MASTER;
                    valid = true;
                }
                case "3" -> {
                    degree = Degree.PHD;
                    valid = true;
                }
                default -> {
                    System.out.println("Invalid value, enter a proper value");
                    valid = false;
                }
            }
        } while(!valid);

        do {
            System.out.println("Enter student's faculty: ");
            System.out.println("|1| FIT\n|2| SECMC\n|3| BS\n|4| FOGI\n|5| KMA");
            switch(Util.reader.readLine()) {
                case "1" -> {
                    faculty = Database.getInstance().getFaculty(FacultyName.FIT);
                    valid = true;
                }
                case "2" -> {
                    faculty = Database.getInstance().getFaculty(FacultyName.SECMC);
                    valid = true;
                }
                case "3" -> {
                    faculty = Database.getInstance().getFaculty(FacultyName.BS);
                    valid = true;
                }
                case "4" -> {
                    faculty = Database.getInstance().getFaculty(FacultyName.FOGI);
                    valid = true;
                }
                case "5" -> {
                    faculty = Database.getInstance().getFaculty(FacultyName.KMA);
                    valid = true;
                }
                default -> {
                    System.out.println("Enter a proper value");
                    valid = false;
                }
            }
        } while(!valid);

        do {
            System.out.println("Select student specialty: ");
            ArrayList<Speciality> specialties = faculty.getSpecialties();
            Util.printList(specialties);

            int choice = Util.parseChoice(Util.reader.readLine());
            if(choice < 0 || !Util.isInRange(choice, 0, specialties.size() - 1)) {
                System.out.println("Not proper value, enter a proper value");
                valid = false;
                continue;
            }
            specialty = specialties.get(choice);
            valid = true;
        } while(!valid);

        return new Student(name, surname, id, login, password, yearOfStudy,
                degree, faculty, specialty, new Transcript(), 0);
    }

    public void getUserData() throws IOException {
        System.out.print("Enter user name: ");
        name = Util.reader.readLine();
        System.out.print("Enter user surname: ");
        surname = Util.reader.readLine();
        System.out.print("Enter user ID: ");
        id = Util.reader.readLine();
        login = generateLogin(name, surname);
        System.out.print("Enter user password (leave empty for autogenerated): ");
        password = Util.reader.readLine();
        password = (password.trim().equals("")) ? generatePassword() : password;
    }

    public void getEmployeeData() throws IOException {
        getUserData();
        System.out.print("Enter employee's salary: ");
        salary = Double.parseDouble(Util.reader.readLine());
    }

    public String generateLogin(String name, String surname) {
        return name.toLowerCase().charAt(0) + "_" + surname.toLowerCase();
    }

    private String generatePassword() {
        StringBuilder password = new StringBuilder();

        int i = 0;
        while(i < 6) {
            password.append(randomChar());
            i++;
        }
        return password.toString();
    }

    private char randomChar() {
        int random = (int) (Math.random() * 62);

        if(random <= 9) {
            return (char) (random + 48);
        }
        else if(random <= 35) {
            return (char) (random + 55);
        } else {
            return (char) (random + 61);
        }
    }
}