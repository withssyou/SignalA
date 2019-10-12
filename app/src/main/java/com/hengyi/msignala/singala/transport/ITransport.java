package com.hengyi.msignala.singala.transport;

import com.hengyi.msignala.singala.ConnectionBase;

public interface ITransport {
	StateBase CreateInitialState(ConnectionBase connectionBase);
}
