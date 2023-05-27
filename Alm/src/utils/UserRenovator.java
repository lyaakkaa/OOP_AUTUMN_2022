package utils;


import database.Database;
import enums.*;
import models.*;
import java.io.IOException;
import java.util.ArrayList;

public class UserRenovator {
    private User user;

    public UserRenovator() {}

    public UserRenovator(User user) {
        this.user = user;
    }

    public void updateUser() throws IOException, InterruptedException {
        do {
            System.out.println("Which attribute do you wish to update? Enter X to cancel");
            System.out.println("|1| Name\n|2| Surname\n|3| Password");

            if(user instanceof Student) {
                System.out.println("|4| Year of study\n|5| Specialty");
            } else {
                System.out.println("|4| Salary");
                if(user instanceof Teacher) {
                    System.out.println("|5| Title");
                }
            }
            System.out.println("|X| Cancel");

        } while(updateChosenField(Util.reader.readLine()));
    }

    public boolean updateChosenField(String choice) throws IOException, InterruptedException {
        switch(choice.toLowerCase()) {
            case "1" -> updateName();
            case "2" -> updateSurname();
            case "3" -> updatePassword();
            case "x" -> {
                return false;
            }
            default -> {
                if(user instanceof Student) {
                    return updateStudentFields(choice);
                }
                return updateEmployeeFields(choice);
            }
        }
        return true;
    }

    public void updateName() throws IOException {
        System.out.println("Previous name: " + user.getName());
        System.out.print("Enter a new name: ");
        user.setName(Util.reader.readLine());
        System.out.println("Name has been updated");
    }

    public void updateSurname() throws IOException {
        System.out.println("Previous surname: " + user.getSurname());
        System.out.print("Enter a new surname: ");
        user.setSurname(Util.reader.readLine());
        System.out.println("Surname has been updated");
    }

    public void updatePassword() throws IOException {
        System.out.println("Previous password: " + user.getPassword());
        System.out.print("Enter a new password: ");
        user.setPassword(Util.reader.readLine());
        Database.getInstance().getUserLoginsAndPasswords(
                user.getClass().getSimpleName().toLowerCase()
        ).put(user.getLogin(), user.getPassword());
        System.out.println("Password has been updated");
    }

    public void updateSalary() throws InterruptedException {
        System.out.println("Previous salary: " + ((Employee) user).getSalary());
        System.out.print("Enter a new salary: ");

        try {
            ((Employee) user).setSalary(Double.parseDouble(Util.reader.readLine()));
            System.out.println("Salary has been updated");
        } catch (IOException exc) {
            System.out.println(exc.getMessage());
        } catch(NumberFormatException exc) {
            System.out.println("Enter a number!");
            Thread.sleep(500);
            updateSalary();
        }
    }

    public void updateTitle() throws IOException, InterruptedException {
        System.out.println("Previous title: " + ((Teacher) user).getTitle() + "\nEnter the new title:");
        System.out.println("|1| Tutor\n|2| Lector\n|3| Senior Lector\n|4| Professor\n|5| Associative Professor");

        switch(Util.reader.readLine()) {
            case "1" -> ((Teacher) user).setTitle(TeacherTitle.TUTOR);
            case "2" -> ((Teacher) user).setTitle(TeacherTitle.LECTOR);
            case "3" -> ((Teacher) user).setTitle(TeacherTitle.SENIOR_LECTOR);
            case "4" -> ((Teacher) user).setTitle(TeacherTitle.PROFESSOR);
            case "5" -> ((Teacher) user).setTitle(TeacherTitle.ASSOCIATIVE_PROFESSOR);
            default -> {
                System.out.println("Unexpected choice, enter from the list!");
                Thread.sleep(500);
                return;
            }
        }
        System.out.println("Title has been updated");
    }

    public void updateYearOfStudy() throws IOException {
        System.out.print("Previous year of study: " + ((Student) user).getYearOfStudy()
                + "\nEnter a new year of study: ");

        switch(Util.reader.readLine()) {
            case "1" -> ((Student) user).setYearOfStudy(YearOfStudy.FIRST);
            case "2" -> ((Student) user).setYearOfStudy(YearOfStudy.SECOND);
            case "3" -> ((Student) user).setYearOfStudy(YearOfStudy.THIRD);
            case "4" -> ((Student) user).setYearOfStudy(YearOfStudy.FOURTH);
            default -> ((Student) user).setYearOfStudy(YearOfStudy.EXTRA);
        }
        System.out.println("Year of study has been updated");
    }

    public void updateSpecialty() throws IOException, InterruptedException {
        System.out.println("Previous specialty: " + ((Student) user).getSpecialty()
                + "\nEnter the new specialty under your faculty: ");

        ArrayList<Speciality> specialties = ((Student) user).getFaculty().getSpecialties();
        for(int i = 0; i < specialties.size(); i++) {
            System.out.println("|" + (i + 1) + "| " + specialties.get(i).getName());
        }

        int choice = Util.parseChoice(Util.reader.readLine());
        if(choice < 0) {
            System.out.println("Enter a number!");
            Thread.sleep(500);
            return;
        }

        if(Util.isInRange(choice, 0, specialties.size() - 1)) {
            ((Student) user).setSpecialty(specialties.get(choice));
        } else {
            System.out.println("Unexpected input, not in range of the list!");
            return;
        }
        System.out.println("Specialty has been updated");
    }

    public boolean updateStudentFields(String choice) throws IOException, InterruptedException {
        switch(choice) {
            case "4" -> updateYearOfStudy();
            case "5" -> updateSpecialty();
            default -> System.out.println("Unexpected input");
        }
        return true;
    }

    public boolean updateEmployeeFields(String choice) throws InterruptedException, IOException {
        switch(choice) {
            case "4" -> updateSalary();
            case "5" -> {
                if(user instanceof Teacher) {
                    updateTitle();
                }
            }
            default -> System.out.println("Unexpected input");
        }
        return true;
    }
}