package main;


public class File  {
    
	public File() {}

	public File(String fileName, Course course, Teacher t, String description) {
		this.fileName = fileName;
        this.course = course;
        this.creator = t;
        this.description = description;
	}
	
    private String fileName;
    private Course course;
    private Teacher creator;
    private String description;
    
    public String getFileName() {
        return this.fileName;
    }
    
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
    
    public Course getCourse() {
        return this.course;
    }
    
    public void setCourse(Course course) {
        this.course = course;
    }
    
    public Teacher getCreator() {
        return this.creator;
    }
    
    public void setCreator(Teacher creator) {
        this.creator = creator;
    }
    
    public String getDescription() {
        return this.description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    

    //                          Operations                                  
    
    public String showFileInfo() {
//        System.out.println(getDescription());
//        System.out.println(getCreator());
//        System.out.println(getCourse());
//        System.out.println(getFileName());
        return "File name: " + this.fileName + "\nDescription: " + this.description + 
        		"\nOwner: " +  this.creator + "\nCourse: " + this.course;
    }
    
}