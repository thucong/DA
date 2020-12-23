package model;

import java.io.Serializable;

public class PointModel implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private Long userId;
	private Long subjectId;
	private double homeworkPoint;
	private double midTermPoint;
	private double endTermPoint;
	private String subjectName;
	private double averagePoint;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(Long subjectId) {
		this.subjectId = subjectId;
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

	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	public double getAveragePoint() {
		return averagePoint;
	}

	public void setAveragePoint() {
		this.averagePoint = (this.homeworkPoint*2 + this.midTermPoint*2 + this.endTermPoint * 6)/10;
	}

	public void setAveragePoint(double averagePoint) {
		this.averagePoint = averagePoint;
	}
}
