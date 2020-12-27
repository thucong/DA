package mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import model.StudentInforModel;

public class StudentInforMapper implements RowMapper<StudentInforModel> {

	@Override
	public StudentInforModel mapRow(ResultSet resultSet) {
		StudentInforModel model = new StudentInforModel();
		try {
			model.setId(resultSet.getInt("id"));
			model.setStudentName(resultSet.getString("hoten"));
			model.setBirthday(resultSet.getString("ngaysinh"));
			model.setGender(resultSet.getString("gioitinh"));
			model.setClassName(resultSet.getString("lop"));
			model.setSubjectName(resultSet.getString("TenMH"));
			model.setHomeworkPoint(resultSet.getDouble("diembt"));
			model.setMidTermPoint(resultSet.getDouble("diemgk"));
			model.setEndTermPoint(resultSet.getDouble("diemck"));
			model.setAveragePoint(resultSet.getDouble("diemtb"));
			model.setUsername(resultSet.getString("username"));
			model.setSvId(resultSet.getLong("diem.id_user"));
			model.setMhId(resultSet.getLong("diem.id_gv"));
			return model;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

}
