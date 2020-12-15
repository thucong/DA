package dao;

import model.AccountModel;

public interface AccountDao extends GenericDao<AccountModel> {
	
	AccountModel findByUsernameAndPassword(String username, String password);
}
