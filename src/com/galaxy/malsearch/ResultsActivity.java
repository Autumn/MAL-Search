package com.galaxy.malsearch;

import android.app.Activity;
import android.widget.TextView;
import android.content.Intent;
import android.view.View;
import android.os.Bundle;
import android.os.AsyncTask;
import java.net.URL;
import java.net.URLEncoder;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.io.IOException;
import java.lang.Exception;
import org.json.JSONArray;
import java.lang.StringBuilder;

public class ResultsActivity extends Activity {

  public static final String EXTRA_QUERY = "QUERY";
  private static final String MAL_API_ANIME_SEARCH= "http://mal-api.com/anime/search?q=";

  private String query;

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.results);
    query = getIntent().getCharSequenceExtra(EXTRA_QUERY).toString();
    new SearchApiTask().execute(query);
  }

  private class SearchApiTask extends AsyncTask<String, Void, SearchResult[]> {
    @Override
    protected SearchResult[] doInBackground(String... query) {
      String result = null;
      JSONArray a = null;
      try {
        result = getData(query[0]);
        a = new JSONArray(result);
      } catch (Exception e) {

      }
      return SearchResult.getSearchResultArray(a);
    }

    @Override
    public void onPostExecute(SearchResult[] arg0) {
      findViewById(R.id.resultProgressBar).setVisibility(View.GONE);
      findViewById(R.id.text).setVisibility(View.VISIBLE);
      // searchresult array of all results
      // build list and draw to UI
    }

    private String getData(String query) throws IOException {
      InputStream is = null;
      String content = null;
      try {
        String encodedQuery = URLEncoder.encode(query, "utf-8");
        URL url = new URL(MAL_API_ANIME_SEARCH + encodedQuery);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setReadTimeout(10000);
        con.setConnectTimeout(15000);
        con.setRequestMethod("GET");
        con.setDoInput(true);
        con.connect();
        is = con.getInputStream();
        content = readIt(is);
      } catch (IOException e) {
        
      } finally {
        if (is != null)
          is.close();
      }
      return content;
    }

    private String readIt(InputStream is) {
      StringBuilder buf = new StringBuilder();
      try {
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        String line = null;

        while ((line = reader.readLine()) != null)
          buf.append(line + "\n");

      } catch (IOException e) {

      }
      return buf.toString();
    }
  }

}
