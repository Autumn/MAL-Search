package uguu.gao.wafu.malsearch;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.SearchView;
import android.content.Intent;
import android.app.SearchManager;
import uguu.gao.wafu.malsearch.ResultsActivity;

public class MainActivity extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        handleIntent(getIntent());
    }
    
    private void handleIntent(Intent intent) {
      if (Intent.ACTION_SEARCH.equals(intent.getAction())) {
        String query = intent.getStringExtra(SearchManager.QUERY);
        Intent i = new Intent(this, ResultsActivity.class);
        i.putExtra(ResultsActivity.EXTRA_QUERY, query);
        startActivity(i);
        finish();
      }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
      MenuInflater inflater = getMenuInflater();
      inflater.inflate(R.menu.main_activity, menu);
      SearchView searchView = (SearchView) menu.findItem(R.id.search).getActionView();
      if (searchView != null)
        searchView.setQueryHint(getString(R.string.search_hint));
      return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
      switch (item.getItemId()) {
        case R.id.search:
          onSearchRequested();
          return true;
        case R.id.settings:
          return true;
      }
      return super.onOptionsItemSelected(item);
    }
}
