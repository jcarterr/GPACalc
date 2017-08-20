package gpaCalc;
import java.util.HashMap;
import java.text.DecimalFormat;

public class Student {
	
	private String name;
	private String major;
	private double totalCredHours;
	private double qualityPoints;
	private double GPA = 0.0;
	static HashMap<String, Student> studentData = new HashMap<String, Student>();
	private static DecimalFormat df = new DecimalFormat(".###");
	
	//Student constructor
	public Student(String id, String name, String major){
		this.name = name;
		this.major = major;
		totalCredHours = 0.0;
		qualityPoints = 0.0;
	}
	
	//Method used for 'Update" option
	public static void courseCompleted(double grade, double hours, Student student){
		student.totalCredHours += hours;
		student.qualityPoints += (grade * hours);
		student.GPA = student.qualityPoints / student.totalCredHours;
	}
	
	@Override
	public String toString(){
		if(GPA == 0.0){
			return "Name: " +  name + "\n" +
					"Major: " + major + "\n" + 
					"GPA: 4.0\n";
		}else{
		return "Name: " +  name + "\n" +
				"Major: " + major + "\n" + 
				"GPA: " + df.format(GPA) + "\n";
		}
	}
	
	public String getName(){
		return name;
	}
	
	public void setGPA(double gpa){
		GPA = gpa;
	}
}
