package com.example.material;






import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.widget.ListView;
 
/**
 * Created by hp1 on 21-01-2015.
 */
public class Tab1 extends Fragment {
	
	private MyAdapter adapter_batting;
	public ListView list_view_batting;
	public ListView list_view_bowling;
	private MyAdapter adapter_bowling;
	
	SingleRow singleRow;
	
 
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v =inflater.inflate(R.layout.tab_1,container,false);
        
        
        list_view_batting = (ListView) v.findViewById(R.id.mList);
        adapter_batting = new MyAdapter(getActivity(),0);
        
        list_view_bowling = (ListView) v.findViewById(R.id.bowller_list);
        adapter_bowling = new MyAdapter(getActivity(),1);
        
		//View headerView = ((LayoutInflater) getActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE)).inflate(R.layout.header_vs, list_view_batting, false);
		//list_view_batting.addHeaderView(headerView, null, false);
		//headerView = ((LayoutInflater) getActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE)).inflate(R.layout.header_detail, list_view_batting, false);
		//list_view_batting.addHeaderView(headerView, null, false);
        
        
        adapter_batting.add_row(singleRow);
        adapter_batting.add_row(singleRow);
        adapter_batting.add_row(singleRow);
        adapter_batting.add_row(singleRow);
        adapter_batting.add_row(singleRow);
        
        
        
        //headerView = ((LayoutInflater) getActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE)).inflate(R.layout.header_detail, list_view_bowling, false);
		//list_view_bowling.addHeaderView(headerView, null, false);
		
		adapter_bowling.add_row(singleRow);
		adapter_bowling.add_row(singleRow);
		adapter_bowling.add_row(singleRow);
		adapter_bowling.add_row(singleRow);
		adapter_bowling.add_row(singleRow);

		list_view_batting.setAdapter(adapter_batting);
		
		ListUtils.setDynamicHeight(list_view_batting);
		
        list_view_bowling.setAdapter(adapter_bowling);
        
        
        ListUtils.setDynamicHeight(list_view_bowling);
        
        

		
        return v;
    }
    
    public static class ListUtils{
    	
    	public static void setDynamicHeight(ListView mListView) {
            MyAdapter mListAdapter = (MyAdapter) mListView.getAdapter();
            if (mListAdapter == null) {
                // when adapter is null
                return;
            }
            int height = 0;
            int desiredWidth = MeasureSpec.makeMeasureSpec(mListView.getWidth(), MeasureSpec.UNSPECIFIED);
            for (int i = 0; i < mListAdapter.getCount(); i++) {
                View listItem = mListAdapter.getView(i, null, mListView);
                listItem.measure(desiredWidth, MeasureSpec.UNSPECIFIED);
                height += listItem.getMeasuredHeight();
            }
            ViewGroup.LayoutParams params = mListView.getLayoutParams();
            params.height = height + (mListView.getDividerHeight() * (mListAdapter.getCount() - 1));
            mListView.setLayoutParams(params);
            mListView.requestLayout();
        }
    }
    	
    
	
}