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

 
2022年4月以降、Play Consoleのデータセーフティセクションに、アプリが収集／共有するユーザーデータを登録する必要があります。詳しくは[Play Consoleのヘルプページ](https://support.google.com/googleplay/android-developer/answer/10787469?hl=ja)を参照してください。maio Android SDKで収集している情報は以下のとおりです。

## ユーザーデータの収集とセキュリティ

| 質問　| 回答 |
|------------------|--------------|
| ユーザーデータの収集または共有  | ○            | 
| 転送時の暗号化	              | ○            | 
| 削除のリクエスト方法	        | -            | 

## 取得する各ユーザーデータの種類

| カテゴリ                                       | 収集有無 / 用途                                                                                                                                                            | 共有有無 / 用途                                                                                                                                                            | 一時的処理 | 収集の必須or選択 |
|------------------------------------------------|----------------------------------------------------------------------------------------------------------------------------------------------------------------------------|----------------------------------------------------------------------------------------------------------------------------------------------------------------------------|------------|------------------|
| **位置情報**                                       |                                                                                                                                                                            |                                                                                                                                                                            |            |                  |
| おおよその現在地                               | -                                                                                      | -          | -             |-
| 正確な現在地                                   | -                                                                                          | -                                                                                       | -          | -             |
|                                                |                                                                                                                                                                            |                                                                                                                                                                            |            |                  |
| **個人情報**                                   |                                                                                                                                                                            |                                                                                                                                                                            |            |                  |
| 名前                                           | -                                                                                                                                                                          | -                                                                                                                                                                          | -          | -                |
| メールアドレス                                 | -                                                                                                                                                                          | -                                                                                                                                                                          | -          | -                |
| 個人識別情報                                   | -                                                                                                                                                                          | -                                                                                                                                                                          | -          | -                |
| 住所                                           | -                                                                                                                                                                          | -                                                                                                                                                                          | -          | -                |
| 電話番号                                       | -                                                                                                                                                                          | -                                                                                                                                                                          | -          | -                |
| 人種、民族                                     | -                                                                                                                                                                          | -                                                                                                                                                                          | -          | -                |
| 政治信条、宗教                                 | -                                                                                                                                                                          | -                                                                                                                                                                          | -          | -                |
| 性的指向                                       | -                                                                                                                                                                          | -                                                                                                                                                                          | -          | -                |
| その他の個人情報                               | - | - | -          | -             |
|                                                |                                                                                                                                                                            |                                                                                                                                                                            |            |                  |
| **財務情報**                                   |                                                                                                                                                                            |                                                                                                                                                                            |            |                  |
| 購入履歴                                       | -                                                                                                                                                                          | -                                                                                                                                                                          | -          | -                |
| クレジット情報                                 | -                                                                                                                                                                          | -                                                                                                                                                                          | -          | -                |
| クレジットカード、デビットカード、銀行口座番号 | -                                                                                                                                                                          | -                                                                                                                                                                          | -          | -                |
| その他の財務情報                               | -                                                                                                                                                                          | -                                                                                                                                                                          | -          | -                |
|                                                |                                                                                                                                                                            |                                                                                                                                                                            |            |                  |
| **健康、フィットネス**                         |                                                                                                                                                                            |                                                                                                                                                                            |            |                  |
| 健康に関する情報                               | -                                                                                                                                                                          | -                                                                                                                                                                          | -          | -                |
| フィットネスに関する情報                       | -                                                                                                                                                                          | -                                                                                                                                                                          | -          | -                |
|                                                |                                                                                                                                                                            |                                                                                                                                                                            |            |                  |
| **メッセージ**                                 |                                                                                                                                                                            |                                                                                                                                                                            |            |                  |
| メール                                         | -                                                                                                                                                                          | -                                                                                                                                                                          | -          | -                |
| SMS、MMSのメッセージ                           | -                                                                                                                                                                          | -                                                                                                                                                                          | -          | -                |
| その他のアプリ内メッセージ                     | -                                                                                                                                                                          | -                                                                                                                                                                          | -          | -                |
|                                                |                                                                                                                                                                            |                                                                                                                                                                            |            |                  |
| **写真と動画**                                 |                                                                                                                                                                            |                                                                                                                                                                            |            |                  |
| 写真                                           | -                                                                                                                                                                          | -                                                                                                                                                                          | -          | -                |
| 動画                                           | -                                                                                                                                                                          | -                                                                                                                                                                          | -          | -                |
|                                                |                                                                                                                                                                            |                                                                                                                                                                            |            |                  |
| **音声ファイル**                               |                                                                                                                                                                            |                                                                                                                                                                            |            |                  |
| 音声などの録音                                 | -                                                                                                                                                                          | -                                                                                                                                                                          | -          | -                |
| 音楽ファイル                                   | -                                                                                                                                                                          | -                                                                                                                                                                          | -          | -                |
| その他の音声ファイル                           | -                                                                                                                                                                          | -                                                                                                                                                                          | -          | -                |
|                                                |                                                                                                                                                                            |                                                                                                                                                                            |            |                  |
| **ファイル、ドキュメント**                     |                                                                                                                                                                            |                                                                                                                                                                            |            |                  |
| ファイル、ドキュメント                         | -                                                                                                                                                                          | -                                                                                                                                                                          | -          | -                |
|                                                |                                                                                                                                                                            |                                                                                                                                                                            |            |                  |
| **カレンダー**                                 |                                                                                                                                                                            |                                                                                                                                                                            |            |                  |
| カレンダーの予定                               | -                                                                                                                                                                          | -                                                                                                                                                                          | -          | -                |
|                                                |                                                                                                                                                                            |                                                                                                                                                                            |            |                  |
| **連絡先**                                 |                                                                                                                                                                            |                                                                                                                                                                            |            |                  |
| 連絡先	                                     | -                                                                                                                                                                          | -                                                                                                                                                                          | -          | -                |
|                                                |                                                                                                                                                                            |                                                                                                                                                                            |            |                  |
| **アプリのアクティビティ**                     |                                                                                                                                                                            |                                                                                                                                                                            |            |                  |
| ページビュー、アプリ内のタップ                 | -                                                                                                                                                                          | -                                                                                                                                                                          | -          | -                |
| アプリ内の検索履歴                             | -                                                                                                                                                                          | -                                                                                                                                                                          | -          | -                |
| インストール済みのアプリ                       | -                                                         | -                                                         | -          | -             |
| その他のユーザー作成コンテンツ                 | -                                                                                                                                                                          | -                                                                                                                                                                          | -          | -                |
| その他の操作                                   | -                                                                                                                                                                          | -                                                                                                                                                                          | -          | -                |
|                                                |                                                                                                                                                                            |                                                                                                                                                                            |            |                  |
| **ウェブ閲覧**                                 |                                                                                                                                                                            |                                                                                                                                                                            |            |                  |
| ウェブ閲覧履歴                                 | -                                                                                                                                                                          | -                                                                                                                                                                          | -          | -                |
|                                                |                                                                                                                                                                            |                                                                                                                                                                            |            |                  |
| **アプリの情報、パフォーマンス**               |                                                                                                                                                                            |                                                                                                                                                                            |            |                  |
| クラッシュログ                                 | -                                                                                                                                                                          | -                                                                                                                                                                          | -          | -                |
| 診断情報                                       | -                                                                                                                                                                          | -                                                                                                                                                                          | -          | -                |
| その他のアプリのパフォーマンスデータ           | -                                                                                                                                                                          | -                                                                                                                                                                          | -          | -                |
|                                                |                                                                                                                                                                            |                                                                                                                                                                            |            |                  |
| **デバイスまたはその他の識別子**               |                                                                                                                                                                            |                                                                                                                                                                            |            |                  |
| デバイスまたはその他の識別子                   | 収集 / 広告、マーケティング                                                                                                                                                | 共有 / 広告、マーケティング                                                                                                                                                | いいえ          | 必須             |
