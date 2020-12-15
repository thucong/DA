package mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import model.AccountModel;

public class AccountMapper implements RowMapper<AccountModel> {

	@Override
	public AccountModel mapRow(ResultSet resultSet) {  // trien khai chuc nang
		try {
			AccountModel model = new AccountModel();
			model.setId(resultSet.getLong("id_user"));
			model.setUsername(resultSet.getString("username"));
			model.setPassword(resultSet.getString("password"));
			model.setRole(resultSet.getString("role"));
			return model;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		
	}

}
