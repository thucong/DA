package mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import model.ClassModel;


public class ClassMapper implements RowMapper<ClassModel> {

	@Override
	public ClassModel mapRow(ResultSet resultSet) {
		try {
			ClassModel model = new ClassModel();
			model.setId_lop(resultSet.getLong("id_lop"));
			model.setLop(resultSet.getString("lop"));
			model.setId_khoa(resultSet.getLong("id_khoa"));
			return model;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		
	}
	
}
