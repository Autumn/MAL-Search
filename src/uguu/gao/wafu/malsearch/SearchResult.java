package uguu.gao.wafu.malsearch;

import org.json.JSONObject;
import org.json.JSONArray;
import org.json.JSONException;
import android.os.Parcelable;
import android.os.Parcel; 

public class SearchResult implements Parcelable {

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

  // parcelable methods
  
  public int describeContents() {
    return 0;
  }

  public void writeToParcel(Parcel dst, int flags) {
    dst.writeInt(id);
    dst.writeString(title);
    dst.writeString(type);
    dst.writeInt(episodes);
    dst.writeString(synopsis);
    dst.writeString(image_url);
    dst.writeDouble(members_score);
    dst.writeString(start_date);
    dst.writeString(end_date);
    dst.writeString(classification);
  }

  public static final Parcelable.Creator<SearchResult> CREATOR = new Parcelable.Creator<SearchResult>() {
    public SearchResult createFromParcel(Parcel in) {
      return new SearchResult(in);
    }
    public SearchResult[] newArray(int size) {
      return new SearchResult[size];
    }
  };

  private SearchResult(Parcel in) {
    id = in.readInt();
    title = in.readString();
    type = in.readString();
    episodes = in.readInt();
    synopsis = in.readString();
    image_url = in.readString();
    members_score = in.readDouble();
    start_date = in.readString();
    end_date = in.readString();
    classification = in.readString();
  }
}
