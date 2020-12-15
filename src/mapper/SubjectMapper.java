package mapper;

import java.sql.ResultSet;
import java.sql.SQLException;


import model.SubjectModel;

public class SubjectMapper implements RowMapper<SubjectModel>{

	@Override
	public SubjectModel mapRow(ResultSet resultSet) {
		try {
			SubjectModel model = new SubjectModel();
			model.setId(resultSet.getLong("id_mh"));
			model.setName(resultSet.getString("TenMH"));
			
			return model;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
}
