package com.gulup.qdfreedown.view;

import org.gulup.annotation.GAction;
import org.gulup.annotation.GContentView;
import org.gulup.annotation.GView;
import org.gulup.core.GData;
import org.gulup.view.GBaseFragment;

import com.gulup.qdfreedown.R;
import com.gulup.qdfreedown.action.SearchAction;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.TextView.OnEditorActionListener;

@GContentView(value=R.layout.search_activity)
public class SearchFragment extends GBaseFragment {
	
	@GAction
	private SearchAction action;
	
	@GView(name="search_edit",width=620,center=RelativeLayout.CENTER_IN_PARENT)
	private EditText searchEdit;
	
	@Override
	public void init() {
		searchEdit.setImeOptions(EditorInfo.IME_ACTION_GO);
		searchEdit.setOnEditorActionListener(new OnEditorActionListener() {
			
			@Override
			public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
				action.judge(searchEdit.getText().toString());
				return false;
			}
		});
	}

	@Override
	public void requestSuccess(GData data) {
		String result = (String) data.getData().get("result");
		Toast.makeText(getActivity(), result, Toast.LENGTH_SHORT).show();
	}

	@Override
	public void requestFail(GData data) {
		
	}
	
}
