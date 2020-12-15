package dao.Impl;

import java.util.List;

import dao.AccountDao;
import mapper.AccountMapper;
import model.AccountModel;

public class AccountDaoImpl extends AbstractDAOImpl<AccountModel> implements AccountDao {

	@Override
	public AccountModel findByUsernameAndPassword(String username, String password) {
		String sql = "SELECT * FROM users WHERE username = ? and password = ?";
		List<AccountModel> result = query(sql, new AccountMapper(), username, password);
		return result.isEmpty()?null : result.get(0);
	}
}
