import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;

import remote.IServer;
import remote.Impl.ServerImpl;

public class Setup extends UnicastRemoteObject implements Remote {

	private static final long serialVersionUID = 1L;

	protected Setup() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public static void main(String[] args) throws RemoteException {
		IServer server = new ServerImpl();
		try {
			LocateRegistry.createRegistry(9999);
			Naming.bind("rmi://localhost:9999/server", server);
			System.out.println("Server is started...");
		} catch (MalformedURLException | RemoteException | AlreadyBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
