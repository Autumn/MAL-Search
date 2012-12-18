package com.galaxy.malsearch;

import org.json.JSONObject;
import org.json.JSONArray;
import org.json.JSONException;

public class SearchResult {

  public int id;
  public String title;
  public String type;
  public int episodes;
  public String synopsis;
  public String image_url;
  public double members_score;
  public String start_date;
  public String end_date;
  public String classification;

  public SearchResult(JSONObject o) {
    try {
    id = o.getInt("id");
    title = o.getString("title");
    type = o.getString("type");
    episodes = o.getInt("episodes");
    synopsis = o.getString("synopsis");
    image_url = o.getString("image_url");
    members_score = o.getDouble("members_score");
    start_date = o.getString("start_date");
    end_date = o.getString("end_date");
    classification = o.getString("classification");
    } catch (JSONException e) {

    }
  }

  public static SearchResult[] getSearchResultArray(JSONArray a) {
    SearchResult[] r = new SearchResult[a.length()];
    try {
       for (int i = 0; i < a.length(); i++)
         r[i] = new SearchResult(a.getJSONObject(i));
    } catch (JSONException e) {

    }
    return r;
  }

  public String toString() {
    return title;
  }
}
