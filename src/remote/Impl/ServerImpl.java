package remote.Impl;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import dao.AccountDao;
import dao.PointDao;
import dao.StudentDao;
import dao.Impl.AccountDaoImpl;
import dao.Impl.PointDaoImpl;
import dao.Impl.StudentDaoImpl;
import model.AccountModel;
import model.PointModel;
import model.StudentModel;
import remote.IServer;



public class ServerImpl extends UnicastRemoteObject implements IServer, Remote {
	
	private static final long serialVersionUID = -3329743653490415260L;
	private AccountDao accountDao;
	private StudentDao studentDao;
	private PointDao pointDao;
	public ServerImpl() throws RemoteException {
		super();
		accountDao = new AccountDaoImpl();
		studentDao = new StudentDaoImpl();
		pointDao = new PointDaoImpl();
	}

	@Override
	public AccountModel login(String username, String password) throws RemoteException {
		AccountModel account = accountDao.findByUsernameAndPassword(username, password);
		return account;
	}
	public StudentModel getStudentInfor(Long id_user) throws RemoteException{
		StudentModel student = studentDao.findById(id_user);
		return student;
	}

	@Override
	public List<PointModel> getPointsList(Long userId) throws RemoteException {
		return pointDao.findAllByUserId(userId);
	}
}
