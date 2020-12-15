package mapper;

import java.sql.ResultSet;
import java.sql.SQLException;


import model.StudentModel;

public class StudentMapper implements RowMapper<StudentModel>{

	@Override
	public StudentModel mapRow(ResultSet resultSet) {
		try {
			StudentModel model = new StudentModel();
			model.setId_user(resultSet.getLong("id_user"));
			model.setHoten(resultSet.getString("hoten"));
			model.setGioitinh(resultSet.getString("gioitinh"));
			model.setNgaysinh(resultSet.getString("ngaysinh"));
			model.setId_lop(resultSet.getLong("id_lop"));
			model.setId_khoa(resultSet.getLong("id_khoa"));
			return model;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

}
