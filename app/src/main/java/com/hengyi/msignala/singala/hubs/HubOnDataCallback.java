package com.hengyi.msignala.singala.hubs;

import org.json.JSONArray;

public abstract class HubOnDataCallback {
	public abstract void OnReceived(JSONArray args);
}
