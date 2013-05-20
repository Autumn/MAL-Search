package uguu.gao.wafu.malsearch;

import android.app.Activity;
import android.os.Bundle;
import android.content.Intent;
import android.widget.TextView;

public class InfoActivity extends Activity {
  
  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.info);
    handleIntent(getIntent());
  }

  private void handleIntent(Intent intent) {
    SearchResult sr = (SearchResult) intent.getParcelableExtra("info");
    TextView title = (TextView) findViewById(R.id.info_title);
    TextView type = (TextView) findViewById(R.id.info_type);
    TextView episodes = (TextView) findViewById(R.id.info_episodes);
    TextView synopsis = (TextView) findViewById(R.id.info_synopsis);
    TextView members_score = (TextView) findViewById(R.id.info_members_score);
    TextView start_date = (TextView) findViewById(R.id.info_start_date);
    TextView end_date = (TextView) findViewById(R.id.info_end_date);
    TextView classification = (TextView) findViewById(R.id.info_classification);

    setViewText(title, sr.title);
    setViewText(type, sr.type);
    setViewText(episodes, String.valueOf(sr.episodes));
    setViewText(synopsis, sr.synopsis);
    setViewText(members_score, String.valueOf(sr.members_score));
    setViewText(start_date, sr.start_date);
    setViewText(end_date, sr.end_date);
    setViewText(classification, sr.classification);
  }

  private void setViewText(TextView tv, String s) {
    tv.setText(s, TextView.BufferType.NORMAL);
  }
}
