package com.gulup.qdfreedown.action;

import java.util.HashMap;
import java.util.Map;

import org.gulup.core.GBaseAction;
import org.json.JSONObject;

import com.android.volley.VolleyError;
import com.gulup.qdfreedown.config.DownURL;

import android.content.Context;

public class SearchAction extends GBaseAction{

	public SearchAction(Context context) {
		super(context);
	}

	@Override
	public void requestBefore() {
		
	}
	
	public void judge(String id){
		Map<String,String> body = new HashMap<String, String>();
		body.put("id", id);
		getJsonRequest(DownURL.JUDGE_ID, 0, null,body);
	}
	
	@Override
	public void jsonRequestSuccess(JSONObject response, int requestType) {
		super.jsonRequestSuccess(response, requestType);
		map.put("result", response.toString());
		changedData();
	}
	
	@Override
	public void requestFail(VolleyError error, int requestType) {
		super.requestFail(error, requestType);
		changedData();
	}

}
