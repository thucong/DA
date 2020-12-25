package mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import model.StudentInforModel;

public class StudentInforMapper implements RowMapper<StudentInforModel> {

	@Override
	public StudentInforModel mapRow(ResultSet resultSet) {
		StudentInforModel model = new StudentInforModel();
		try {
			model.setStudentName(resultSet.getString("hoten"));
			model.setBirthday(resultSet.getString("ngaysinh"));
			model.setGender(resultSet.getString("gioitinh"));
			model.setClassName(resultSet.getString("lop"));
			model.setSubjectName(resultSet.getString("TenMH"));
			model.setHomeworkPoint(resultSet.getDouble("diembt"));
			model.setMidTermPoint(resultSet.getDouble("diemgk"));
			model.setEndTermPoint(resultSet.getDouble("diemck"));
			model.setAveragePoint(resultSet.getDouble("diemtb"));
			return model;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

}
