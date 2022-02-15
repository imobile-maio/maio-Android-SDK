![](https://github.com/imobile-maio/maio-iOS-SDK/blob/wiki/doc/images/logo.png)

# maio Android SDK
- SDK Version: 1.1.16
    + AndroidManifest.xmlにHtmlBasedAdActivityを追加してください。
    + Please Add HtmlBasedAdActivity to AndroidManifest.xml.
- Released: 2021/11/08
- 対応 Android Version: 4.1 以降
- Supported Formats: Rewarded/Interstitial

## Quickstart

### maio SDKの取得・Getting maio SDK

- maioを導入したいプロジェクトの`build.gradle`に、以下のmavenリポジトリを追加します。
- Add maio Maven repository to your Project build.gradle:

<pre><code>allprojects {
    repositories {        
        maven{
            url "https://imobile-maio.github.io/maven"
        }
    }
}
</pre></code>

- maioSDKとGoogle Play Servicesをモジュールの`build.gradle`に追加します：
- Add the maio SDK and Google Play Services to your project by adding the following implementations inside your Module build.grade:

### jar 

<pre><code>dependencies {
  implementation 'com.google.android.gms:play-services-ads:+'
  implementation 'com.maio:android-sdk:1.1.16'
}
</pre></code>

### aar

<pre><code>dependencies {
  implementation 'com.google.android.gms:play-services-ads:+'
  implementation 'com.maio:android-sdk:1.1.16@aar'
}
</pre></code>

### maio SDK Manifest Settings

- マニフェストへ以下の要素を追加します(maio Android SDK 1.1.4以下)：
- Add the following element to your manifest(for maio Android SDK 1.1.4 and below):

```xml
<uses-library android:name="org.apache.http.legacy" android:required="false" />
```

- maioアクティビティをマニフェストに追加します (aarの場合に必要ありません）：
- Add the maio activity to your manifest (not needed when using aar):

```xml 
<activity  
          android:name="jp.maio.sdk.android.AdFullscreenActivity"  
          android:configChanges="orientation|screenLayout|screenSize"  
          android:hardwareAccelerated="true"  
          android:theme="@android:style/Theme.NoTitleBar.Fullscreen" >  
</activity>
<activity            
          android:name="jp.maio.sdk.android.HtmlBasedAdActivity"            
          android:configChanges="keyboardHidden|orientation|screenSize"            
          android:theme="@android:style/Theme.NoTitleBar.Fullscreen" >
</activity>
```

### maio SDKの準備・maio SDK setup


```java
private final String MEDIA_EID = "DemoPublisherMediaForAndroid";
protected void onCreate(Bundle savedInstanceState) {
 
   //初期化
   MaioAds.init(this, MEDIA_EID, new MaioAdsListener() {      
      @Override
      public void onFinishedAd(int playtime, boolean skipped, int duration, String zoneEid) {
      }
      @Override
      public void onClosedAd(String zoneEid) {          
      }
   });
}
```

### maioの表示・Show maio Ads

```java
//再生
if(MaioAds.canShow()){
  MaioAds.show();
}
```

maio SDKの全ての機能や詳細については、API Referenceを参照して下さい。

For more detailed samples and details on all of maio SDKs functions check out the API reference

- 日本語　https://github.com/imobile-maio/maio-Android-SDK/wiki/API-Reference
- English https://github.com/imobile-maio/maio-Android-SDK/wiki/API-Reference-(EN)

## Manual Download
[releases](https://github.com/imobile-maio/maio-Android-SDK/releases) から最新のリリースバージョンをダウンロードして下さい。

## Get Started
Android Studio (日本語） https://github.com/imobile-maio/maio-Android-SDK/wiki/Project-Setup---Android-Studio  

Android Studio (English) https://github.com/imobile-maio/maio-Android-SDK/wiki/Project-Setup-Android-Studio-(EN)  

Eclipse https://github.com/imobile-maio/maio-Android-SDK/wiki/Project-Setup---Eclipse

## API Reference
日本語　https://github.com/imobile-maio/maio-Android-SDK/wiki/API-Reference

English https://github.com/imobile-maio/maio-Android-SDK/wiki/API-Reference-(EN)

## FAQ
日本語　https://github.com/imobile-maio/maio-Android-SDK/wiki/FAQ

English https://github.com/imobile-maio/maio-Android-SDK/wiki/FAQ-(EN)


## What is maio?
[maio](https://maio.jp/) はこれまでのバナー広告に加え、新たな広告収益の機会を得ることが可能な動画広告プラットフォームです。  
バナー広告と違い、デベロッパーの設定したタイミングで、動画広告をコンテンツの一部として配信することができます。

また、動画広告再生後にアプリ内通貨やライフ等の報酬（リワード）をユーザーに還元する事で、動画広告の再生数が増加し、収益の最大化が見込めます。  
今までユーザーが離脱していたポイントに `動画広告 + リワード` を入れる事で、ユーザーのストレスを解消しアクティブ率を向上させる事も可能です。  

## Contact Us
- General
  + https://maio.jp/#contactWrap
- Technical Trouble Shooting
  + https://maio.jp/techsupport/index.html

 ## 収集しているデータについて

 <br />


|連絡先情報|収集有無|	使用目的|トラッキングでの利用|
 |--- |--- |--- |--- |
|**名前** <br /> 姓や名など| -| -| -|
|**Eメールアドレス** <br />ハッシュ化されたEメールアドレスを含むが、これに限定しない| -| -| -|
|**電話番号**  <br />ハッシュ化された電話番号を含むが、これに限定しない| -| -| -|
|**所在地**  <br />自宅住所、物理的な住所、郵送先住所など| -| -| -|
|**ユーザのその他の連絡先情報**  <br /> 自宅または所在地| -| -| -|
| | | | |

|健康とフィットネス|収集有無|	使用目的|トラッキングでの利用|
|--- |--- |--- |--- |
|**健康** <br />ヘルスケアおよび医療関連のデータ -  <br />Clinical Health Records API、<br />HealthKit API、MovementDisorderAPI、<br />ヘルスケア関連の臨床調査、<br /> またはユーザーが提供したその他の<br />ヘルスケアまたは医療のデータを含むが、これらに限定しない| -| -| -|
|**フィットネス** <br />フィットネスおよび運動データ -<br /> Motion APIおよびFitness APIを含むがこれらに限定しない | -| -| -|
| | | | |

|財務情報|収集有無|	使用目的|トラッキングでの利用|
|--- |--- |--- |--- |
|**支払い情報** <br />支払い方法、支払いカード番号、<br />銀行口座番号など。Appが支払いサービスを利用している場合は、<br />支払い情報はApp外で入力され、<br />あなた（デベロッパ）<br />は支払い情報にアクセスできません。<br />その場合、データは収集されないため、<br />申告する必要はありません。| -| -| -|
|**クレジット情報** <br />クレジットスコアなど| -| -| -|
|**その他の財務情報** <br />給与、収入、資産、負債、その他の財務情報など| -| -| -|
| | | | |

|位置情報|収集有無|	使用目的|トラッキングでの利用|
|--- |--- |--- |--- |
|**詳細な位置情報** <br /> 小数点以下3桁以上の緯度経度と同等、またはそれよりも高い詳細レベルでの、<br />ユーザーまたはデバイスの場所を示す情報 | -| -| -|
|**おおよその場所** <br /> 小数点以下3桁以上の緯度経度よりも低い<br />詳細レベルでのユーザー<br />またはデバイスの場所を示す情報<br />（おおよその位置情報サービスなど）| -| -| -|
| | | | |

|機密情報|収集有無|	使用目的|トラッキングでの利用|
|--- |--- |--- |--- |
|**機密情報** <br />人種または民族情報、性的指向、<br />妊娠または出産に関する情報、障がい、<br />宗教または哲学的信念、<br />労働組合への加入、政治的意見、遺伝情報、または生体情報など| -| -| -|
| | | | |

|連絡先|収集有無|	使用目的|トラッキングでの利用|
|--- |--- |--- |--- |
|**連絡先** <br />ユーザーの電話、アドレス帳、ソーシャルグラフ内の連絡先リストなど| -| -| -|
| | | | |

|ユーザーコンテンツ|収集有無|	使用目的|トラッキングでの利用|
|--- |--- |--- |--- |
|**Eメールまたはテキストメッセージ** <br />Eメールまたはメッセージの件名、送信者、受信者、および内容を含む| -| -| -|
|**写真またはビデオ** <br />ユーザーの写真またはビデオ| -| -| -|
|**オーディオデータ** <br />ユーザーの声またはサウンドの録音| -| -| -|
|**ゲームプレイコンテンツ** <br />ゲーム内でユーザーが生成したコンテンツなど| -| -| -|
|**カスタマーサポート** <br />カスタマーサポートの依頼中にユーザーが生成したデータ|| -| -|-|
|**その他のユーザーコンテンツ** <br />ユーザーが生成したその他のコンテンツ| -| -| -|
| | | | |

|閲覧履歴|収集有無|	使用目的|トラッキングでの利用|
|--- |--- |--- |--- |
|**閲覧履歴** <br /> ユーザーが閲覧したコンテンツに関する情報| -| -| -|
| | | | |

|検索履歴|収集有無|	使用目的|トラッキングでの利用|
|--- |--- |--- |--- |
|**検索履歴** <br />ユーザーが実行した検索に関する情報| -| -| -|
| | | | |

|ID|収集有無|	使用目的|トラッキングでの利用|
|--- |--- |--- |--- |
|**ユーザーID** <br />スクリーン名、ハンドル、アカウントID、<br />割り当てられたユーザーID、顧客番号、<br />特定のユーザーやアカウント<br />の識別に利用できるユーザーレベルやアカウント<br />レベルのその他のIDなど| -| -| -|
|**デバイスID** <br />デバイスの広告ID、またはデバイスレベルのその他のIDなど| ✓| サードパーティ広告<br />アナリティクス| あり|
| | | | |

|購入|収集有無|	使用目的|トラッキングでの利用|
|--- |--- |--- |--- |
|**購入履歴** <br />アカウントや個人による購入、または購入傾向| -| -| -|
| | | | |

|使用状況データ|収集有無|	使用目的|トラッキングでの利用|
|--- |--- |--- |--- |
|**製品の操作** <br />Appの起動、タップ、クリック、スクロール情報、<br />音楽の視聴データ、<br />ビデオの視聴数、ゲームやビデオや曲の保存場所、<br />ユーザーのApp操作に関するその他の情報など| -| -| -|
|**広告データ** <br />ユーザーが見た広告に関する情報など| ✓| サードパーティ広告<br />アナリティクス| あり|
|**その他の使用状況データ** <br />Appのユーザーアクティビティに関するその他のデータ| -| -| -|
| | | | |

|診断|収集有無|	使用目的|トラッキングでの利用|
|--- |--- |--- |--- |
|**クラッシュデータ** <br />クラッシュログなど| -| -| -|
|**パフォーマンスデータ** <br />起動時間、ハング率、エネルギー使用量など| -| -| -|
|**その他の診断データ** <br />Appに関連する技術的診断を測定する<br />目的で収集されたその他のデータ| -| -| -|
| | | | |

|その他のデータ|収集有無|	使用目的|トラッキングでの利用|
|--- |--- |--- |--- |
|**その他の種類のデータ** <br />言及されていないその他の種類のデータ| ✓| サードパーティ広告アナリティクス| あり|
| | | | |

<br />

## 収集したデータの個人情報への関連付け
収集したデータの個人情報への関連付けを行なっていない。
