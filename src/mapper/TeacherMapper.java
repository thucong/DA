package mapper;

import java.sql.ResultSet;
import java.sql.SQLException;


import model.TeacherModel;

public class TeacherMapper implements RowMapper<TeacherModel> {

	@Override
	public TeacherModel mapRow(ResultSet resultSet) {
		try {
			TeacherModel model = new TeacherModel();
			model.setId_user(resultSet.getLong("id_user"));
			model.setHoten(resultSet.getString("hoten"));
			model.setGioitinh(resultSet.getString("gioitinh"));
			model.setNgaysinh(resultSet.getString("ngaysinh"));
			model.setId_khoa(resultSet.getLong("id_khoa"));
			
			return model;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

}
