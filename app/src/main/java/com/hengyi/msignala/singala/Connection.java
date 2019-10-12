package com.hengyi.msignala.singala;

import android.content.Context;

import com.hengyi.msignala.singala.transport.ITransport;
import com.hengyi.msignala.singala.transport.StateBase;


public class Connection extends ConnectionBase {

	public Connection(String url, Context context, ITransport transport) {
		super(url, context, transport);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void OnError(Exception exception) {
		// TODO Auto-generated method stub

	}

	@Override
	public void OnMessage(String message) {
		// TODO Auto-generated method stub

	}

	@Override
	public void OnStateChanged(StateBase oldState, StateBase newState) {
		// TODO Auto-generated method stub

	}

}
