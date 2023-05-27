package other;

import java.util.Objects;

import users.Course;

public class File implements Comparable <File>{
  private String title;
  private String content;
  private Course course;
  
  
  public File() {}
  
  public File(String title, String content, Course course) {
	  this.title = title;
	  this.content = content;
	  this.course = course;
  }
  
  
  public String getTitle() {
    return title;
  }
  public void setTitle(String title) {
    this.title = title;
  }
  public String getContent() {
    return content;
  }
  public void setContent(String content) {
    this.content = content;
  }
  public Course getCourse() {
    return course;
  }
  public void setCourse(Course course) {
    this.course = course;
  }
  
  @Override
  public String toString() {
    return super.toString() + "File [name = " + title +
        ", content = " + content + ", course = " + course;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = super.hashCode();
    result = prime * result + Objects.hash(title, content, course);
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (!super.equals(obj))
      return false;
    if (getClass() != obj.getClass())
      return false;
    File other = (File) obj;
    return Objects.equals(course, other.course) && title == other.title 
        && content == other.content;
  }
  
  
  @Override
  public int compareTo(File f) {
    return title.compareTo(f.title);
  }

}