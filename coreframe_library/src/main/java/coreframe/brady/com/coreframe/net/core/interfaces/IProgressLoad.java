package coreframe.brady.com.coreframe.net.core.interfaces;



public interface IProgressLoad {

	void startRequest(ITag tag);

	void stopRequest(ITag tag);

	void destroy();
}
