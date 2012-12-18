package com.galaxy.malsearch;

import android.app.ListFragment;
import android.os.Bundle;
import android.widget.ArrayAdapter;

public class ResultsFragment extends ListFragment {
  
  private ArrayAdapter aa = null;
  private SearchResult[] sr = null;

  @Override
  public void onActivityCreated(Bundle savedInstanceState) {
    super.onActivityCreated(savedInstanceState);
    aa = new ArrayAdapter<SearchResult>(getActivity(), android.R.layout.simple_list_item_1, sr);
    setListAdapter(aa);
  }

  public void setSearchResults(SearchResult[] sr) {
    this.sr = sr;
  }

}
