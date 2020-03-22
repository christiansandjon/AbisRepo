package be.abis.casebce.session;

import javax.ejb.Remote;

import be.abis.casebce.model.Worker;

@Remote
public interface WorkerSessionRemote {
	public Worker login(String login, String password);

	public Worker getUser(int id);

}
