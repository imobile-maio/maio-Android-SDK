package jp.maio.sdk.android.sample;

import android.app.ActivityManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.List;

import jp.maio.sdk.android.FailNotificationReason;
import jp.maio.sdk.android.MaioAds;
import jp.maio.sdk.android.MaioAdsListener;

public class SecondActivity extends AppCompatActivity {

    private final String TAG = SecondActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // 動画広告初期化
        MaioAds.setMaioAdsListener(new MaioAdsListener() {

            @Override
            public void onInitialized() {
                Log.v("App 正常 コールバック", "SDKの準備ができました");
            }

            @Override
            public void onChangedCanShow(String zoneEid, boolean newValue) {
                Button btnZone1 = (Button) findViewById(R.id.btnZone1);
                btnZone1.setEnabled(newValue);

                Log.v("App 正常 コールバック", "zoneEidの表示可能かの通知");
            }

            @Override
            public void onOpenAd(String zoneEid) {
                Log.v("App 正常 コールバック", "広告が表示されました");
            }

            @Override
            public void onStartedAd(String zoneEid) {
                Log.v("App 正常 コールバック", "広告の再生が開始されました");
            }

            @Override
            public void onFinishedAd(int playtime, boolean skipped, int duration, String zoneEid) {
                Log.v("App 正常 コールバック", "広告の再生が終了しました");
            }

            @Override
            public void onClosedAd(String zoneEid) {
                Log.v("App 正常 コールバック", "広告が閉じられました");
            }

            @Override
            public void onClickedAd(String zoneEid) {
                Log.v("App 正常 コールバック", "広告クリックされました");
            }

            @Override
            public void onFailed(FailNotificationReason reason, String zoneEid) {
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
                //SecondActivityを閉じてMainActivityに遷移
                finish();
                startActivity(new Intent(SecondActivity.this, MainActivity.class));
            }
        });

    }
}
