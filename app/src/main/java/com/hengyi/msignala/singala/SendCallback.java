package com.hengyi.msignala.singala;

public abstract class SendCallback {
	public abstract void OnSent(CharSequence messageSent);
	public abstract void OnError(Exception ex);
}
