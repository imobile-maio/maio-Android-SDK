package jp.maio.sdk.android.sample;

import android.app.ActivityManager;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import jp.maio.sdk.android.FailNotificationReason;
import jp.maio.sdk.android.MaioAds;
import jp.maio.sdk.android.MaioAdsListener;


public class MainActivity extends AppCompatActivity {
    private final String TAG = MainActivity.class.getSimpleName();
    private final String MEDIA_EID = "DemoPublisherMediaForAndroid";
    private final String ZONE_EID1 = "DemoPublisherZoneForAndroid";
    private final String ZONE_EID2 = "DemoPublisherZoneSkippableForAndroid";

    static ArrayList<String> arrayList = new ArrayList<String>();
    static ArrayAdapter<String> adapter;

    public ArrayAdapter<String> getAdapter()
    {
        return adapter;
    }


    public ArrayList<String> getArrayList()
    {
        return arrayList;
    }

    public String statusMessage(String message)
    {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss");
        final String strDate = simpleDateFormat.format(calendar.getTime());

        return String.format("%s: %s", strDate, message);
    }

    protected void onCreate(Bundle savedInstanceState) {
        Log.d(TAG, "#onCreate");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final ListView listView = (ListView)findViewById(R.id.listView);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        if(savedInstanceState == null)
        {
            arrayList = new ArrayList<String>();
            arrayList.add(statusMessage("広告取得中"));
        }

        //ステータスを表示用の設定
        if(adapter == null)
            adapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_spinner_item, arrayList){
                @Override
                public View getView(int position, View convertView, ViewGroup parent){
                    View view = super.getView(position, convertView, parent);
                    TextView tv = (TextView) view.findViewById(android.R.id.text1);
                    tv.setTextColor(Color.BLACK);
                    tv.setSingleLine(false);
                    return view;
                }
            };

        listView.setAdapter(adapter);
        adapter.notifyDataSetChanged();


        //// 広告の配信テスト設定を行います。アプリをリリースする際にはコメントアウトして下さい。
        MaioAds.setAdTestMode(true);

        // 動画広告初期化
        MaioAds.init(this, MEDIA_EID, new MaioAdsListener() {

            @Override
            public void onInitialized() {
                getArrayList().add(statusMessage("SDK準備完了"));
                getArrayList().add(statusMessage("SDK Version " + MaioAds.getSdkVersion()));
                getAdapter().notifyDataSetChanged();
                Log.v("App 正常 コールバック", "SDKの準備ができました");
            }

            @Override
            public void onChangedCanShow(String zoneEid, boolean newValue) {
                getArrayList().add(statusMessage("zoneEid " + zoneEid + " canshow " + newValue));
                getAdapter().notifyDataSetChanged();
                Button btnZone1 = (Button) findViewById(R.id.btnZone1);
                btnZone1.setEnabled(newValue);

                Log.v("App 正常 コールバック", "zoneEidの表示可能かの通知");
            }

            @Override
            public void onOpenAd(String zoneEid) {
                getArrayList().add(statusMessage("広告が表示されました"));
                getAdapter().notifyDataSetChanged();
                Log.v("App 正常 コールバック", "広告が表示されました");
            }

            @Override
            public void onStartedAd(String zoneEid) {
                getArrayList().add(statusMessage("広告再生開始"));
                getAdapter().notifyDataSetChanged();
                Log.v("App 正常 コールバック", "広告の再生が開始されました");
            }

            @Override
            public void onFinishedAd(int playtime, boolean skipped, int duration, String zoneEid) {
                getArrayList().add(statusMessage("広告再生終了"));
                getAdapter().notifyDataSetChanged();
                Log.v("App 正常 コールバック", "広告の再生が終了しました");
            }

            @Override
            public void onClosedAd(String zoneEid) {
                getArrayList().add(statusMessage("広告クローズ"));
                getAdapter().notifyDataSetChanged();
                Log.v("App 正常 コールバック", "広告が閉じられました");
            }

            @Override
            public void onClickedAd(String zoneEid) {
                getArrayList().add(statusMessage("広告クリックされました"));
                getAdapter().notifyDataSetChanged();
                Log.v("App 正常 コールバック", "広告クリックされました");
            }

            @Override
            public void onFailed(FailNotificationReason reason, String zoneEid) {
                getArrayList().add(statusMessage("広告取得失敗 " + reason));
                getAdapter().notifyDataSetChanged();

                Log.v("App エラー コールバック", reason.toString());
            }
        });

        // 初期化できたら広告の表示
        Button btnZone1 = (Button)findViewById(R.id.btnZone1);
        btnZone1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //1ゾーン運用の場合
                if(MaioAds.canShow())
                    MaioAds.show();
            }
        });

        Button goNext = (Button) findViewById(R.id.btnNext);
        goNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //MainActivityを閉じてSecondActivityに遷移
                finish();
                startActivity(new Intent(MainActivity.this, SecondActivity.class));
            }
        });
    }

    @Override
    protected void onDestroy() {
        Log.d(TAG, "#onDestroy");
        super.onDestroy();
    }

    @Override
    protected void onStart() {
        Log.d(TAG, "#onStart");
        super.onStart();
    }
    @Override
    protected void onStop() {
        Log.d(TAG, "#onStop");
        super.onStop();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
