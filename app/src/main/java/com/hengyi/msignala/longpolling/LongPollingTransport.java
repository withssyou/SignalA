package com.hengyi.msignala.longpolling;

import com.hengyi.msignala.singala.ConnectionBase;
import com.hengyi.msignala.singala.Transport.ITransport;
import com.hengyi.msignala.singala.Transport.StateBase;

public class LongPollingTransport implements ITransport {

	@Override
	public StateBase CreateInitialState(ConnectionBase connection) {
		return new DisconnectedState(connection);
	}

}
