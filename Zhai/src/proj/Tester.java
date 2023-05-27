package proj;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Tester {

    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException, ClassNotFoundException, CreditOverFlow {
        

         Student s1 = new Student("Ernazar", "Tolegen", "23/10/2001", "8 777-777-77-77", "ernazartolegen@gmail.com", "123456", "19B030729", 1, Faculty.FIT, Degree.BACHELOR); 
         Student s2 = new Student("Zhaisan", "Sarsengaliyev", "16/08/2001", "8 771-191-23-49", "zhaisansars@gmail.com", "12345", "19B030552", 2, Faculty.FIT, Degree.BACHELOR); 
         Database.users.add(s1); 
         Database.users.add(s2); 
 
         Teacher t1 = new Teacher("Oscar", "Cardozo", "20/05/1983", "8 707-123-56-22", "oscar@gmail.com", "12345", Status.SENIOR_LECTOR, "11 years"); 
         Teacher t2 = new Teacher("Alimzhan", "Amanov", "26/03/1995", "8 701-947-65-55", "amanov.a@gmail.com", "12001", Status.LECTOR, "5 years"); 
         Database.users.add(t1); 
         Database.users.add(t2); 
 
         
         Manager m1 = new Manager("Dana", "Akhmetzhan", "21/01/1985", " 8 707-111-11-11", "dana@gmail.com", "12222", Managers.DEPARTMENTS); 
         Manager m2 = new Manager("Nazym", "Aidarkhanova", "8/03/1983", " 8 707-112-12-12", "nazym@gmail.com", "12223", Managers.OR); 
         Database.users.add(m1); 
         Database.users.add(m2); 
 
 
         Admin a1 = new Admin("Admin1", "Admin1", "22/02/1972", "8 707-222-22-22", "admin1@gmail.com", "11111"); 
         Admin a2 = new Admin("Admin2", "Admin2", "22/02/1973", "8 707-222-22-23", "admin2@gmail.com", "11112"); 
         Database.users.add(a1); 
         Database.users.add(a2); 
 
         Librarian l1 = new Librarian("Librarian1", "Librarianov1", "21/12/1960", "8 777-123-34-55", "lib1@gmai.com", "12333"); 
         Librarian l2 = new Librarian("Librarian2", "Librarianov2", "20/12/1961", "8 777-123-34-51", "lib2@gmai.com", "12333"); 
         Database.users.add(l1); 
         Database.users.add(l2); 
 
         Course c1 = new Course("Object-oriented programming", "Object-oriented programming (OOP) is a programming paradigm based on the concept of objects, which can contain data and code: data in the form of fields (often known as attributes or properties), and code, in the form of procedures (often known as methods).", 3, "CSCI2106"); 
         Course c2 = new Course("Databases", 3, "CSCI2104"); 
         Database.courses.add(c1); 
         Database.courses.add(c2);

         Book b1 = new Book("Thomas Calculus", "B1", "Thomas");
         Book b2 = new Book("Ryabushko", "B2", "Evgeniy");
         Database.books.add(b1);
         Database.books.add(b2);

         Database.studentRegistration.put("19B030729", c1);
         Database.teacherRatings.put("Oscar", 5);
         Database.teacherRatings.put("Oscar", 4);
         Database.teacherRatings.put("Oscar", 4);

         News n1 = new News("1", "Registration 2021-2022 Fall", "Registration will start 10th of July");
         News n2 = new News("2", "Books", "Here should be text");
         Database.news.add(n1);
         Database.news.add(n2);

         File f1 = new File("OOP_Project", "CSCI2106", "Here should be file info");
         File f2 = new File("OOP_Diagram", "CSCI2106", "Here should be another file info");
         File f3 = new File("DB_Lab1", "CSCI2104", "This is your labwork");
         File f4 = new File("DB_Lab2", "CSCI2104", "This is your second labwork");
         Database.files.add(f1);
         Database.files.add(f2);
         Database.files.add(f3);
         Database.files.add(f4);

         Mark ma1 = new Mark("Object-oriented programming", "19B030729", 24.0, 24.6, 40.0);
         Mark ma2 = new Mark("Databases", "19B030729", 30.0, 29.0, 37.0);
         Database.marks.add(ma1);
         Database.marks.add(ma2);

         Message me1 = new Message("Alimzhan", "o_cardozo@kbtu.kz", "Greetings", "Hello Oscar. My name is Alimzhan and Welcome to KBTU.");
         Message me2 = new Message("Oscar", "a_amanov@kbtu.kz", "Hi", "Good morning Alimzhan. Thank you!");
         Database.messages.add(me1);
         Database.messages.add(me2);

         Database.orders.put("19B030729", b1);
         Database.orders.put("19B030729", b2);

        Database.load();
        //Database.save();




        System.out.println("Press q to quit.");
        System.out.println("Enter your login: ");
        String input = reader.readLine();
        if(input.equals("q")) {
            System.exit(0);
        }
        for(User u : Database.users) {
            if(u.getLogin().equals(input)) {
                System.out.println("Enter password: ");
                String input1 = reader.readLine();
                if(u.getPassword().equals(input1)) {
                    System.out.println("Successfully authorized.");
                    System.out.println("Welcome " + u.getName() + ".");
                    if(u instanceof Student) {
                        boolean flag = true;
                        while(flag) {
                            Student st = (Student) u;
                            // System.out.println("\n\n\n\n\n\n\n\n\n\n");
                            System.out.println("/--------------------Student's mode--------------------/");
                            System.out.println("    [1]          Information about Student\n" +
                                "    [2]          View courses\n" +
                                "    [3]          View available courses\n" +
                                "    [4]          View course files\n" +
                                "    [5]          View Teacher info\n" +
                                "    [6]          View marks\n" +
                                "    [7]          View transcript\n" +
                                "    [8]          Rate teacher\n" +
                                "    [9]          Get Transcript\n" +
                                "    [10]         Order book\n" +
                                "    [11]         Register to Course\n" +
                                "    [12]         Drop Course\n" +
                                "    [13]         View news\n" +
                                "    [14]         Quit\n" +
                                "    [0]          Change password\n"
                                );

                            int chosen = Integer.parseInt(reader.readLine());

                            switch(chosen) {
                                case 1:
                                    System.out.println(st.getAllInfo()); 
                                    break;
                                case 2:
                                    System.out.println(st.viewCourses());
                                    break;
                                case 3:
                                    System.out.println(st.viewAvailableCourses());
                                    break;
                                case 4:
                                    System.out.println("Enter courseId: ");
                                    String courseId = reader.readLine();
                                    System.out.println(st.viewCourseFiles(courseId));
                                    break;
                                case 5:
                                    System.out.println("Enter Teacher's name: ");
                                    String name = reader.readLine();
                                    System.out.println(st.viewTeacherInfo(name));
                                    break;
                                case 6:
                                    System.out.println(st.viewMarks());
                                    break;
                                case 7:
                                    System.out.println(st.viewTranscript());
                                    break;
                                case 8:
                                    System.out.println("Enter Teacher's name: ");
                                    String teacherName = reader.readLine();
                                    System.out.println("Enter 1-5 stars: ");
                                    int rating = Integer.parseInt(reader.readLine());
                                    st.rateTeacher(teacherName, rating);
                                    Database.save();
                                    System.out.println("Thank you for your feedback!");
                                    break;
                                case 9:
                                    System.out.println(st.getTranscript());
                                    break;
                                case 10:
                                    System.out.println("Enter BookId: ");
                                    String bookId = reader.readLine();
                                    st.orderBook(bookId);
                                    Database.save();
                                    System.out.println("Your order has been completed.");
                                    break;
                                case 11:
                                    System.out.println("Enter courseId: ");
                                    String courseId1 = reader.readLine();
                                    st.registerToCourse(courseId1);
                                    Database.save();
                                    System.out.println("Your request is fulfilled");
                                    break;
                                case 12:
                                    System.out.println("Enter courseId: ");
                                    String courseId2 = reader.readLine();
                                    st.dropCourse(courseId2);
                                    Database.save();
                                    System.out.println("Your course has been removed.");
                                    break;
                                case 13:
                                    System.out.println(st.viewNewsTab());
                                    break;
                                case 14:
                                    System.exit(0);
                                case 0:
                                    System.out.println("Enter old password: ");
                                    String oldPassword = reader.readLine();
                                    System.out.println("Enter new password: ");
                                    String newPassword = reader.readLine();
                                    if(st.changePassword(oldPassword, newPassword)) {
                                        System.out.println("Your password has been changed.");
                                    } else System.out.println("Incorrect password.");
                                    Database.save();
                                    break;
                                }
                        
                        }


                    } else if(u instanceof Teacher) {
                        boolean flag = true;
                        while(flag) {
                            Teacher t = (Teacher) u;
                            // System.out.println("\n\n\n\n\n\n\n\n\n\n");
                            System.out.println("/--------------------Teacher's mode--------------------/");
                            System.out.println(
                                "    [1]          Information about Teacher\n" +
                                "    [2]          View courses\n" +
                                "    [3]          Add course file\n" +
                                "    [4]          Delete course file\n" +
                                "    [5]          View list of students\n" +
                                "    [6]          View info about student\n" +
                                "    [7]          Put mark\n" +
                                "    [8]          View marks\n" +
                                "    [9]          Send message\n" +
                                "    [10]         Get messages\n" +
                                "    [11]         View rating\n" +
                                "    [12]         View news\n" + 
                                "    [13]         Quit\n" + 
                                "    [0]          Change password\n");
        
                            int chosen = Integer.parseInt(reader.readLine());
                            switch(chosen){
                            case 1:
                                System.out.println("Information about teacher: ");
                                System.out.println(t.getAllInfo());
                                break;
                            case 2:
                                System.out.println(t.viewCourses());
                                break;
                            case 3:
                                System.out.println("Enter file name: ");
                                String fileName = reader.readLine();
                                System.out.println("Enter CourseID: ");
                                String courseId = reader.readLine();
                                System.out.println("Enter description: ");
                                String description = reader.readLine();
                                t.addCourseFile(fileName, courseId, description);
                                Database.save();
                                System.out.println("Course file successfully added.");
                                break;
                            case 4:
                                System.out.println("Enter File name: ");
                                String fileName1 = reader.readLine();
                                System.out.println("Enter CourseID: ");
                                String courseId1 = reader.readLine();
                                t.deleteCourseFile(fileName1, courseId1);
                                Database.save();
                                System.out.println("Course file successfully deleted.");
                                break;
                            case 5:
                                System.out.println(t.viewStudents());
                                break;
                            case 6:
                                System.out.println("Enter student's name: ");
                                String name = reader.readLine();
                                System.out.println(t.viewStudentInfo(name));
                                break;
                            case 7:
                                System.out.println("Enter name of subject: ");
                                String courseName = reader.readLine();
                                System.out.println("Enter studentId: ");
                                String studentId = reader.readLine();
                                System.out.println("Enter First Attestation Points: ");
                                Double firstAtt = Double.parseDouble(reader.readLine());
                                System.out.println("Enter Second Attestation Points: ");
                                Double secondAtt = Double.parseDouble(reader.readLine());
                                System.out.println("Enter Final grade: ");
                                Double finalGrade = Double.parseDouble(reader.readLine());
                                t.putMark(courseName, studentId, firstAtt, secondAtt, finalGrade);
                                Database.save();
                                System.out.println("Success!");
                                break;
                            case 8:
                                System.out.println("Enter course name: ");
                                String courseName1 = reader.readLine();
                                System.out.println(t.viewMarks(courseName1));
                                break;
                            case 9: 
                                System.out.println("Enter your name: ");
                                String messageFrom = reader.readLine();
                                System.out.println("Enter employee login you want to message to: ");
                                String messageTo = reader.readLine();
                                System.out.println("Enter message title: ");
                                String title = reader.readLine();
                                System.out.println("Enter text: ");
                                String text = reader.readLine();
                                t.sendMessage(messageFrom, messageTo, title, text);
                                Database.save();
                                System.out.println("Message sent");
                                break;
                            case 10: 
                                System.out.println(t.getMessages());
                                break;
                            case 11:
                                System.out.println(t.viewRating());
                                break;
                            case 12:
                                System.out.println(t.viewNewsTab());
                                break;
                            case 13:
                                System.exit(0);
                            case 0:
                                System.out.println("Enter old password: ");
                                String oldPassword = reader.readLine();
                                System.out.println("Enter new password: ");
                                String newPassword = reader.readLine();
                                if(t.changePassword(oldPassword, newPassword)) {
                                    System.out.println("Your password has been changed.");
                                } else System.out.println("Incorrect password.");
                                Database.save();
                                break;
                            }
                                
                        }

                    } else if(u instanceof Manager) {
                        boolean flag = true;
                        while (flag) {
                            Manager m = (Manager) u; 
                            // System.out.println("\n\n\n\n\n\n\n\n\n\n"); 
                            System.out.println("/--------------------Manager's mode--------------------/"); 
                            System.out.println("    [1]          Create course\n" + 
                                "    [2]          View info about students\n" + 
                                "    [3]          View info about teachers\n" + 
                                "    [4]          View requests about registration\n" + 
                                "    [5]          Approve registration\n" + 
                                "    [6]          Assign course to teachers\n" + 
                                "    [7]          Add news\n" + 
                                "    [8]          Remove news\n" + 
                                "    [9]          Update news\n" + 
                                "    [10]         Get max score of students\n" + 
                                "    [11]         Get min score of students\n" + 
                                "    [12]         Get average score of students\n" + 
                                "    [13]         Get number of retakes\n" + 
                                "    [14]         Order of students by GPA\n" + 
                                "    [15]         Order students alphabetically\n" + 
                                "    [16]         Order teachers alphabetically\n" + 
                                "    [17]         Order teachers by status\n" + 
                                "    [18]         View news\n" + 
                                "    [19]         View messages\n" + 
                                "    [20]         Send message\n" + 
                                "    [21]         Quit\n" + 
                                "    [0]          Change password"); 
    
                            int chosen = Integer.parseInt(reader.readLine()); 
    
                            switch(chosen) { 
                                case 1: 
                                    System.out.println("Enter course's name: "); 
                                    String courseName = reader.readLine(); 
                                    System.out.println("Enter course's credits: "); 
                                    int courseCredit = Integer.parseInt(reader.readLine()); 
                                    System.out.println("Enter course's id: "); 
                                    String courseId = reader.readLine(); 
                                    m.createCourse(courseName, courseCredit, courseId);
                                    Database.save();
                                    System.out.println("New course is created."); 
                                    break; 
                                case 2: 
                                    System.out.println(m.infoStudents()); 
                                    break; 
                                case 3: 
                                    System.out.println("Enter teacher's name: "); 
                                    String teacherName = reader.readLine(); 
                                    System.out.println(m.infoTeachers(teacherName)); 
                                    break; 
                                case 4: 
                                    System.out.println(m.viewRequests()); 
                                    break; 
                                case 5: 
                                    System.out.println("Enter student's ID: "); 
                                    String studentId1 = reader.readLine(); 
                                    System.out.println("Enter course's id: "); 
                                    String courseId1 = reader.readLine(); 
                                    System.out.println("Enter REJECT or ACCEPT: "); 
                                    String courseApprove = reader.readLine(); 
                                    m.approveRegistration(studentId1, courseId1, courseApprove);
                                    Database.save();
                                    break; 
                                case 6: 
                                    System.out.println("Enter course's ID: "); 
                                    String courseId2 = reader.readLine(); 
                                    System.out.println("Enter teacher's name: ");
                                    String teacherName1 = reader.readLine(); 
                                    m.assignCourseToTeachers(courseId2, teacherName1); 
                                    Database.save();
                                    System.out.println("Teacher was assigned to course"); 
                                    break; 
                                case 7: 
                                    System.out.println("Enter news's ID: "); 
                                    String newsId = reader.readLine(); 
                                    System.out.println("Enter news's title: "); 
                                    String newsTitle = reader.readLine(); 
                                    System.out.println("Enter news's content: "); 
                                    String newsText = reader.readLine(); 
                                    m.addNews(newsId, newsTitle, newsText); 
                                    Database.save();
                                    System.out.println("News are added."); 
                                    break; 
                                case 8: 
                                    System.out.println("Enter news's id you want to delete: "); 
                                    String newsId1 = reader.readLine(); 
                                    m.removeNews(newsId1); 
                                    Database.save();
                                    System.out.println("News are deleted"); 
                                    break; 
                                case 9: 
                                    System.out.println("Enter news's ID you want to update: "); 
                                    String newsOldId2 = reader.readLine(); 
                                    System.out.println("Enter new id: "); 
                                    String newId = reader.readLine(); 
                                    System.out.println("Enter news's title: "); 
                                    String newsTitle1 = reader.readLine(); 
                                    System.out.println("Enter news's content: "); 
                                    String newsText1 = reader.readLine(); 
                                    m.updateNews(newsOldId2, newId, newsTitle1, newsText1); 
                                    Database.save();
                                    System.out.println("News are updated."); 
                                    break; 
                                case 10: 
                                    System.out.println(m.getMaxScore()); 
                                    break; 
                                case 11: 
                                    System.out.println(m.getMinScore()); 
                                    break; 
                                case 12: 
                                    System.out.println(m.getAvgScore()); 
                                    break; 
                                case 13: 
                                    System.out.println(m.retakeCount()); 
                                    break; 
                                case 14: 
                                    System.out.println(m.orderStudentsByGPA()); 
                                    break; 
                                case 15: 
                                    System.out.println(m.orderStudentsAlphabetically()); 
                                    break; 
                                case 16: 
                                    System.out.println(m.orderTeachersAlphabetically()); 
                                    break; 
                                case 17: 
                                    System.out.println(m.orderTeachersStatus()); 
                                    break; 
                                case 18: 
                                    System.out.println(m.viewNewsTab());
                                    break;
                                case 19: 
                                    System.out.println("Enter your name: ");
                                    String messageFrom = reader.readLine();
                                    System.out.println("Enter employee login you want to message to: ");
                                    String messageTo = reader.readLine();
                                    System.out.println("Enter message title: ");
                                    String title = reader.readLine();
                                    System.out.println("Enter text: ");
                                    String text = reader.readLine();
                                    m.sendMessage(messageFrom, messageTo, title, text);
                                    Database.save();
                                    System.out.println("Message sent");
                                    break;
                                case 20: 
                                    System.out.println(m.getMessages());
                                    break;
                                case 21: 
                                    System.exit(0);
                                case 0:
                                    System.out.println("Enter old password: ");
                                    String oldPassword = reader.readLine();
                                    System.out.println("Enter new password: ");
                                    String newPassword = reader.readLine();
                                    if(m.changePassword(oldPassword, newPassword)) {
                                        System.out.println("Your password has been changed.");
                                    } else System.out.println("Incorrect password.");
                                    Database.save();
                                    break;
                                }
                        }
                    } else if(u instanceof Admin) {
                        boolean flag = true;
                        while(flag) {
                            Admin a = (Admin) u;
                            System.out.println("/--------------------Admin's mode--------------------/"); 
                            System.out.println("    [1]          Create Student\n" + 
                                "    [2]          Create Teacher\n" + 
                                "    [3]          Create Manager\n" +
                                "    [4]          Create Librarian\n" +
                                "    [5]          View news\n" + 
                                "    [6]          Send message\n" + 
                                "    [7]          Get messages\n" + 
                                "    [8]          Get users\n" + 
                                "    [9]          Quit\n" +
                                "    [10]         Delete user\n" +
                                "    [0]          Change password\n");

                                int chosen = Integer.parseInt(reader.readLine()); 
    
                            switch(chosen) { 
                                case 1: 
                                    System.out.println("Enter Student's Name: "); 
                                    String studentName = reader.readLine(); 
                                    System.out.println("Enter Student's Surname: "); 
                                    String studentSurname = reader.readLine(); 
                                    System.out.println("Enter birth date: "); 
                                    String birthDate = reader.readLine();
                                    System.out.println("Enter Student's phone number: "); 
                                    String phoneNumber= reader.readLine(); 
                                    System.out.println("Enter email: "); 
                                    String email = reader.readLine(); 
                                    System.out.println("Enter password: "); 
                                    String password = reader.readLine(); 
                                    System.out.println("Enter Student id: "); 
                                    String id = reader.readLine();
                                    System.out.println("Enter year of study: "); 
                                    Integer yearOfStudy = Integer.parseInt(reader.readLine()); 
                                    a.createStudent(studentName, studentSurname, birthDate, phoneNumber, email, password, id, yearOfStudy);; 
                                    Database.save();
                                    break; 
                                case 2: 
                                    System.out.println("Enter Teacher's Name: "); 
                                    String teacherName = reader.readLine(); 
                                    System.out.println("Enter Teacher's Surname: "); 
                                    String teacherSurname = reader.readLine(); 
                                    System.out.println("Enter birth date: "); 
                                    String birthDate1 = reader.readLine();
                                    System.out.println("Enter phone number: "); 
                                    String phoneNumber1= reader.readLine(); 
                                    System.out.println("Enter email: "); 
                                    String email1 = reader.readLine(); 
                                    System.out.println("Enter password: "); 
                                    String password1 = reader.readLine(); 
                                    System.out.println("Enter experience: "); 
                                    String experience = reader.readLine(); 
                                    a.createTeacher(teacherName, teacherSurname, birthDate1, phoneNumber1, email1, password1, experience);
                                    Database.save();
                                    break; 
                                case 3: 
                                    System.out.println("Enter Manager's Name: "); 
                                    String managerName = reader.readLine(); 
                                    System.out.println("Enter Manager's Surname: "); 
                                    String managerSurname = reader.readLine(); 
                                    System.out.println("Enter birth date: "); 
                                    String birthDate2 = reader.readLine();
                                    System.out.println("Enter phone number: "); 
                                    String phoneNumber2= reader.readLine(); 
                                    System.out.println("Enter email: "); 
                                    String email2 = reader.readLine(); 
                                    System.out.println("Enter password: "); 
                                    String password2 = reader.readLine(); 
                                    a.createManager(managerName, managerSurname, birthDate2, phoneNumber2, email2, password2);
                                    Database.save();
                                    break; 
                                case 4:
                                    System.out.println("Enter Librarian's Name: "); 
                                    String librarianName = reader.readLine(); 
                                    System.out.println("Enter Librarian's Surname: "); 
                                    String librarianSurname = reader.readLine(); 
                                    System.out.println("Enter birth date: "); 
                                    String birthDate3 = reader.readLine();
                                    System.out.println("Enter phone number: "); 
                                    String phoneNumber3= reader.readLine(); 
                                    System.out.println("Enter email: "); 
                                    String email3 = reader.readLine(); 
                                    System.out.println("Enter password: "); 
                                    String password3 = reader.readLine(); 
                                    a.createLibrarian(librarianName, librarianSurname, birthDate3, phoneNumber3, email3, password3);
                                    Database.save();
                                    break; 
                                case 5: 
                                    System.out.println(a.viewNewsTab());
                                    break;
                                case 6: 
                                    System.out.println("Enter your name: ");
                                    String messageFrom = reader.readLine();
                                    System.out.println("Enter employee login you want to message to: ");
                                    String messageTo = reader.readLine();
                                    System.out.println("Enter message title: ");
                                    String title = reader.readLine();
                                    System.out.println("Enter text: ");
                                    String text = reader.readLine();
                                    a.sendMessage(messageFrom, messageTo, title, text);
                                    Database.save();
                                    System.out.println("Message sent");
                                    break;
                                case 7: 
                                    System.out.println(a.getMessages());
                                    break;
                                case 8:
                                    System.out.println(a.getUsers());
                                    break;
                                case 9: 
                                    System.exit(0);
                                case 10:
                                    System.out.println("Enter login: ");
                                    String login = reader.readLine();
                                    a.deleteUser(login);
                                    Database.save();
                                    System.out.println("User has been deleted.");
                                    break;
                                case 0:
                                    System.out.println("Enter old password: ");
                                    String oldPassword = reader.readLine();
                                    System.out.println("Enter new password: ");
                                    String newPassword = reader.readLine();
                                    if(a.changePassword(oldPassword, newPassword)) {
                                        System.out.println("Your password has been changed.");
                                    } else System.out.println("Incorrect password.");
                                    Database.save();
                                    break;
                                }
                            }

                    } else if(u instanceof Librarian) {
                        boolean flag = true;
                        while(flag) {
                            Librarian l = (Librarian) u; 
                            // System.out.println("\n\n\n\n\n\n\n\n\n\n"); 
                            System.out.println("/--------------------Librarian's mode--------------------/"); 
                            System.out.println("    [1]          Add book\n" + 
                                "    [2]          Remove book\n" + 
                                "    [3]          Update order book\n" +
                                "    [4]          View news\n" + 
                                "    [5]          Send message\n" + 
                                "    [6]          Get messages\n" + 
                                "    [7]          Quit\n" + 
                                "    [8]          View books\n" +
                                "    [0]          Change password\n");
    
                            int chosen = Integer.parseInt(reader.readLine()); 
    
                            switch(chosen) { 
                                case 1: 
                                    System.out.println("Enter book's title: "); 
                                    String bookTitle = reader.readLine(); 
                                    System.out.println("Enter book's id: "); 
                                    String bookId = reader.readLine(); 
                                    System.out.println("Enter book's id: "); 
                                    String bookAuthor = reader.readLine(); 
                                    l.addBook(bookTitle, bookId, bookAuthor); 
                                    Database.save();
                                    System.out.println("Book has been added."); 
                                    break; 
                                case 2: 
                                    System.out.println("Enter book's ID you want to delete: "); 
                                    String bookId1 = reader.readLine(); 
                                    l.removeBook(bookId1); 
                                    Database.save();
                                    System.out.println("Book has beed removed."); 
                                    break; 
                                case 3: 
                                    System.out.println("Enter student's ID: "); 
                                    String studentId = reader.readLine(); 
                                    System.out.println("Enter book's id: "); 
                                    String bookId2 = reader.readLine(); 
                                    System.out.println("Enter REJECT or ACCEPT: "); 
                                    String bookRequest = reader.readLine(); 
                                    l.updateOrderBook(studentId, bookId2, bookRequest);
                                    Database.save();
                                    break;
                                case 4: 
                                    System.out.println(l.viewNewsTab());
                                    break;
                                case 5: 
                                    System.out.println("Enter your name: ");
                                    String messageFrom = reader.readLine();
                                    System.out.println("Enter employee login you want to message to: ");
                                    String messageTo = reader.readLine();
                                    System.out.println("Enter message title: ");
                                    String title = reader.readLine();
                                    System.out.println("Enter text: ");
                                    String text = reader.readLine();
                                    l.sendMessage(messageFrom, messageTo, title, text);
                                    Database.save();
                                    System.out.println("Message sent");
                                    break;
                                case 6: 
                                    System.out.println(l.getMessages());
                                    break;
                                case 7: 
                                    System.exit(0);
                                case 0:
                                    System.out.println("Enter old password: ");
                                    String oldPassword = reader.readLine();
                                    System.out.println("Enter new password: ");
                                    String newPassword = reader.readLine();
                                    if(l.changePassword(oldPassword, newPassword)) {
                                        System.out.println("Your password has been changed.");
                                    } else System.out.println("Incorrect password.");
                                    Database.save();
                                    break;
                                case 8: 
                                    System.out.println(Database.books.toString());
                            } 
                        }

                    }
                } else {
                    System.out.println("Wrong password.");
                }
            }
            
        }
        System.out.println(Database.studentRegistration.toString());

    }
}