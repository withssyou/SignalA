package com.hengyi.msignala.singala.Transport;


import com.hengyi.msignala.singala.ConnectionBase;

public interface ITransport {
	StateBase CreateInitialState(ConnectionBase connectionBase);
}
