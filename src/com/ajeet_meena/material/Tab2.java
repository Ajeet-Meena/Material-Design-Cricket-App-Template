package com.ajeet_meena.material;

import com.ajeet_meena.material.R;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
 
/**
 * Created by hp1 on 21-01-2015.
 */
public class Tab2 extends Fragment {
	
	CommentryAdapter commentryAdapter;
	ListView listView;
	SingleRowCommentry singleRowCommentry;
	
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.tab_2,container,false);
        
        listView = (ListView) v.findViewById(R.id.commentry_list);
        commentryAdapter = new CommentryAdapter(getActivity());
        
        commentryAdapter.add_commentry(singleRowCommentry);
        commentryAdapter.add_commentry(singleRowCommentry);
        commentryAdapter.add_commentry(singleRowCommentry);
        commentryAdapter.add_commentry(singleRowCommentry);
        commentryAdapter.add_commentry(singleRowCommentry);
        commentryAdapter.add_commentry(singleRowCommentry);
        commentryAdapter.add_commentry(singleRowCommentry);
        commentryAdapter.add_commentry(singleRowCommentry);
        
        listView.setAdapter(commentryAdapter);
        
        
        return v;
    }
}