package com.adobe.creativesdk.foundation.internal.storage.controllers;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.MediaController;
import android.widget.ProgressBar;
import android.widget.VideoView;
import com.adobe.creativesdk.foundation.internal.notification.AdobeInternalNotificationID;
import com.adobe.creativesdk.foundation.internal.storage.AdobeAssetFileInternal;
import com.adobe.creativesdk.foundation.internal.utils.logging.Level;
import com.facebook.internal.NativeProtocol;
import java.util.HashMap;
import java.util.Observer;

/* loaded from: classes.dex */
public class AdobeUXAssetVideoActivity extends Activity {

    /* renamed from: a */
    private VideoView f5542a;

    /* renamed from: b */
    private MediaController f5543b;

    /* renamed from: c */
    private ProgressBar f5544c;

    /* renamed from: d */
    private int f5545d;

    /* renamed from: e */
    private Observer f5546e;

    /* renamed from: f */
    private View f5547f;

    /* renamed from: g */
    private int f5548g;

    /* renamed from: h */
    private boolean f5549h = false;
    C0469s i;

    /* renamed from: com.adobe.creativesdk.foundation.internal.storage.controllers.AdobeUXAssetVideoActivity$2 */
    /* loaded from: classes.dex */
    public class AnonymousClass2 extends HashMap<String, String> {
        final /* synthetic */ String val$assetGuid;
        final /* synthetic */ String val$assetName;

        AnonymousClass2(String str, String str2) {
            string = str;
            string2 = str2;
            put("area", "assets");
            put("type", "video");
            put(NativeProtocol.WEB_DIALOG_ACTION, "play");
            put("assetName", string);
            put("assetID", string2);
        }
    }

    public void e() {
        this.f5549h = false;
        this.f5547f.setVisibility(8);
        this.f5544c.setVisibility(0);
        c();
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        getWindow().setFlags(1024, 1024);
        setContentView(c.a.a.a.b.g.activity_videoview);
        this.f5542a = (VideoView) findViewById(c.a.a.a.b.e.adobe_csdk_asset_video_viewContainer);
        this.f5544c = (ProgressBar) findViewById(c.a.a.a.b.e.adobe_csdk_asset_videoInit_progressBar);
        this.f5543b = new C0403fa(this, this);
        this.f5543b.setAnchorView(this.f5542a);
        this.f5543b.setMediaPlayer(this.f5542a);
        this.f5542a.setMediaController(this.f5543b);
        this.f5547f = findViewById(c.a.a.a.b.e.adobe_csdk_video_container_no_network_notification_bar);
        b(getIntent().getExtras());
        C0469s c0469s = this.i;
        if (c0469s != null && c0469s.f()) {
            if (bundle != null) {
                this.f5545d = bundle.getInt("position");
            } else {
                this.f5545d = 0;
            }
            this.f5548g = getIntent().getExtras().getInt("current_asset_position");
            return;
        }
        finish();
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        this.f5543b.hide();
        this.f5542a.stopPlayback();
        this.f5542a.setMediaController(null);
        this.f5542a.setVisibility(4);
        super.onDestroy();
    }

    @Override // android.app.Activity
    protected void onPause() {
        this.f5545d = this.f5542a.getCurrentPosition();
        super.onPause();
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        c();
    }

    @Override // android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        bundle.putInt("position", this.f5542a.getCurrentPosition());
        super.onSaveInstanceState(bundle);
    }

    @Override // android.app.Activity
    protected void onStart() {
        super.onStart();
        a();
    }

    @Override // android.app.Activity
    protected void onStop() {
        b();
        super.onStop();
    }

    private void b(Bundle bundle) {
        com.adobe.creativesdk.foundation.internal.storage.controllers.OneUpViewConfiguration.d a2 = a(bundle);
        if (a2 != null) {
            com.adobe.creativesdk.foundation.internal.storage.controllers.OneUpViewConfiguration.f fVar = (com.adobe.creativesdk.foundation.internal.storage.controllers.OneUpViewConfiguration.f) a2.a("ADOBE_ONE_UP_VIEW_ASSET_CONFIGURATION");
            if (bundle != null) {
                com.adobe.creativesdk.foundation.internal.analytics.q.a("mobile.ccmobile.playVideo", new HashMap<String, String>() { // from class: com.adobe.creativesdk.foundation.internal.storage.controllers.AdobeUXAssetVideoActivity.2
                    final /* synthetic */ String val$assetGuid;
                    final /* synthetic */ String val$assetName;

                    AnonymousClass2(String str, String str2) {
                        string = str;
                        string2 = str2;
                        put("area", "assets");
                        put("type", "video");
                        put(NativeProtocol.WEB_DIALOG_ACTION, "play");
                        put("assetName", string);
                        put("assetID", string2);
                    }
                }, null);
            }
            this.i = C0469s.a(fVar.e(), fVar.d());
        }
    }

    private void c() {
        String hlsHref = ((AdobeAssetFileInternal) this.i.a(this.f5548g)).getHlsHref();
        Uri parse = Uri.parse(hlsHref);
        this.f5542a.setOnErrorListener(new C0408ga(this));
        com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.INFO, "VideoActivity", String.format("VideoUrl is %s", hlsHref));
        this.f5542a.setOnPreparedListener(new C0428ka(this));
        this.f5542a.setVideoURI(parse);
        this.f5542a.start();
    }

    public void d() {
        this.f5549h = true;
        this.f5547f.setVisibility(0);
    }

    private com.adobe.creativesdk.foundation.internal.storage.controllers.OneUpViewConfiguration.d a(Bundle bundle) {
        if (bundle != null) {
            return com.adobe.creativesdk.foundation.internal.storage.controllers.OneUpViewConfiguration.c.a(bundle.getInt("one_up_controller_code"));
        }
        return null;
    }

    protected void a() {
        if (this.f5546e == null) {
            this.f5546e = new C0433la(this);
        }
        com.adobe.creativesdk.foundation.internal.notification.b.a().a(AdobeInternalNotificationID.AdobeNetworkStatusChangeNotification, this.f5546e);
    }

    protected void b() {
        com.adobe.creativesdk.foundation.internal.notification.b.a().b(AdobeInternalNotificationID.AdobeNetworkStatusChangeNotification, this.f5546e);
    }
}
