package com.hengyi.msignala.longpolling;

import com.hengyi.msignala.singala.ConnectionBase;
import com.hengyi.msignala.singala.ConnectionState;
import com.hengyi.msignala.singala.SendCallback;
import com.hengyi.msignala.singala.transport.StateBase;

import java.util.concurrent.atomic.AtomicBoolean;

public class DisconnectedState extends StateBase {
	private AtomicBoolean requestStart = new AtomicBoolean(false);
	
	public DisconnectedState(ConnectionBase connection) {
		super(connection);
	}

	@Override
	public ConnectionState getState() {
		return ConnectionState.Disconnected;
	}

	@Override
	public void Start() {
		requestStart.set(true);
		Run();
	}

	@Override
	public void Stop() { }

	@Override
	public void Send(CharSequence text, SendCallback callback) {
		callback.OnError(new Exception("Not connected"));
	}

	@Override
	protected void OnRun() {
		if(requestStart.get()) {
	        NegotiatingState s = new NegotiatingState(mConnection);
	        mConnection.SetNewState(s);
		}
	}

}
