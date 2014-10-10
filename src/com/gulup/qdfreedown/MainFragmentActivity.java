package com.gulup.qdfreedown;

import org.gulup.annotation.GContentView;
import org.gulup.annotation.GFragment;
import org.gulup.annotation.GView;
import org.gulup.core.GData;
import org.gulup.view.GBaseView;

import com.gulup.qdfreedown.view.BookFragment;
import com.gulup.qdfreedown.view.SearchFragment;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.RadioGroup.OnCheckedChangeListener;


@GContentView(value=R.layout.activity_main)
public class MainFragmentActivity extends GBaseView {
	
	@GView(value=R.id.tab,center=RelativeLayout.ALIGN_PARENT_BOTTOM)
	private RadioGroup tab;
	@GView(R.id.item_book)
	private RadioButton book;
	@GView(value=R.id.item_search,left=40,right=40)
	private RadioButton search;
	@GView(R.id.item_other)
	private RadioButton other;
	@GFragment
	private BookFragment bookView;
	@GFragment
	private SearchFragment searchView;
	
	
	@Override
	protected void onCreate(Bundle arg0) {
		super.onCreate(arg0,false);
		addFragment(R.id.pager, bookView);
	}

	@Override
	public void init() {
		tab.setOnCheckedChangeListener(mRadioGroupListener);
	}
	
	@Override
	public void requestSuccess(GData data) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void requestFail(GData data) {
		// TODO Auto-generated method stub
		
	}
	
	private OnCheckedChangeListener mRadioGroupListener = new OnCheckedChangeListener() {
		@Override
		public void onCheckedChanged(RadioGroup group, int checkedId) {
			if (checkedId==book.getId()) {
				addFragment(R.id.pager, bookView);
			}else if(checkedId==search.getId()){
				addFragment(R.id.pager, searchView);
			}
	        
		}
	};
	
}
