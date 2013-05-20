package uguu.gao.wafu.malsearch;

import android.app.ListFragment;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.view.View;
import android.content.Intent;

public class ResultsFragment extends ListFragment {
  
  private ArrayAdapter aa = null;
  private SearchResult[] sr = null;

  @Override
  public void onActivityCreated(Bundle savedInstanceState) {
    super.onActivityCreated(savedInstanceState);
    aa = new ArrayAdapter<SearchResult>(getActivity(), android.R.layout.simple_list_item_1, sr);
    setListAdapter(aa);
  }

  @Override
  public void onListItemClick(ListView l, View v, int position, long id) {
    Intent i = new Intent(this.getActivity(), InfoActivity.class);
    i.putExtra("info", (SearchResult) aa.getItem(position));
    startActivity(i);
  }

  public void setSearchResults(SearchResult[] sr) {
    this.sr = sr;
  }

}
