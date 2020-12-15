package remote.Impl;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import dao.AccountDao;
import dao.StudentDao;
import dao.Impl.AccountDaoImpl;
import dao.Impl.StudentDaoImpl;
import model.AccountModel;
import model.StudentModel;
import remote.IServer;



public class ServerImpl extends UnicastRemoteObject implements IServer, Remote {
	
	private static final long serialVersionUID = -3329743653490415260L;
	private AccountDao accountDao;
	private StudentDao studentDao;
	public ServerImpl() throws RemoteException {
		super();
		accountDao = new AccountDaoImpl();
		studentDao = new StudentDaoImpl();
	}

	@Override
	public AccountModel login(String username, String password) throws RemoteException {
		AccountModel account = accountDao.findByUsernameAndPassword(username, password);
		return account;
	}
	public StudentModel list(Long id_user) throws RemoteException{
		StudentModel student = studentDao.student(id_user);
		return student;
	}
}
