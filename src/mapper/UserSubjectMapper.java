package mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import model.UserSubjectModel;

public class UserSubjectMapper implements RowMapper<UserSubjectModel> {

	@Override
	public UserSubjectModel mapRow(ResultSet resultSet) {
		
		try {
			UserSubjectModel model = new UserSubjectModel();
			model.setId_user(resultSet.getLong("id_user"));
			model.setId_mh(resultSet.getLong("id_mh"));
			return model;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
		
	}

}
