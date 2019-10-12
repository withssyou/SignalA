package com.hengyi.msignala.singala.hubs;

import org.json.JSONObject;

public abstract class Subscription {

	public abstract void OnReceived(JSONObject args);

}
