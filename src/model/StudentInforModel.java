package model;

import java.io.Serializable;

public class StudentInforModel implements Serializable {

	private int id;
	private String username;
	private String studentName;
	private String birthday;
	private String gender;
	private String className;
	private String subjectName;
	private double homeworkPoint;
	private double midTermPoint;
	private double endTermPoint;
	private double averagePoint;
	private Long svId;
	private Long mhId;

	public double getAveragePoint() {
		return averagePoint;
	}

	public void setAveragePoint(double averagePoint) {
		this.averagePoint = averagePoint;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public double getHomeworkPoint() {
		return homeworkPoint;
	}

	public void setHomeworkPoint(double homeworkPoint) {
		this.homeworkPoint = homeworkPoint;
	}

	public double getMidTermPoint() {
		return midTermPoint;
	}

	public void setMidTermPoint(double midTermPoint) {
		this.midTermPoint = midTermPoint;
	}

	public double getEndTermPoint() {
		return endTermPoint;
	}

	public void setEndTermPoint(double endTermPoint) {
		this.endTermPoint = endTermPoint;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Long getSvId() {
		return svId;
	}

	public void setSvId(Long svId) {
		this.svId = svId;
	}

	public Long getMhId() {
		return mhId;
	}

	public void setMhId(Long mhId) {
		this.mhId = mhId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
