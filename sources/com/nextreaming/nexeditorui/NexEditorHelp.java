package com.nextreaming.nexeditorui;

import android.annotation.SuppressLint;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.kinemaster.tracelog.KMAppUsage;
import com.nextreaming.nexvideoeditor.NexEditor;
import java.io.IOException;
import java.util.Date;
import java.util.Locale;

@SuppressLint({"SetJavaScriptEnabled"})
/* loaded from: classes.dex */
public class NexEditorHelp extends ba {

    /* renamed from: a, reason: collision with root package name */
    private WebView f4484a;
    private View b;
    private View c;
    private boolean e = false;
    private a[] f;

    @Override // com.nextreaming.nexeditorui.ba, android.app.Activity
    protected void onResume() {
        super.onResume();
    }

    @Override // com.nextreaming.nexeditorui.ba, android.app.Activity
    protected void onPause() {
        super.onPause();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b {
        private String b;
        private String c;
        private Handler d;

        private b() {
            this.d = new Handler();
        }

        /* synthetic */ b(NexEditorHelp nexEditorHelp, bx bxVar) {
            this();
        }

        @JavascriptInterface
        public String engineVersion() {
            return this.b;
        }

        @JavascriptInterface
        public String appVersion() {
            return this.c;
        }

        @JavascriptInterface
        public void guideReset() {
        }

        @JavascriptInterface
        public void exitHelp() {
            this.d.post(new cg(this));
        }

        @JavascriptInterface
        public String appExpires() {
            Date a2 = ExpiredActivity.a();
            return a2 == null ? "" : a2.toString();
        }
    }

    @Override // com.nextreaming.nexeditorui.ba, android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        this.f4484a.saveState(bundle);
        super.onSaveInstanceState(bundle);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        int f4485a;
        int b;
        View c;
        View d;
        String e;
        String f;
        KMAppUsage.KMMetric g;
        boolean h;

        a(int i, KMAppUsage.KMMetric kMMetric, String str, String str2) {
            this.f4485a = i;
            this.e = str;
            this.b = R.id.helpWebView;
            this.g = kMMetric;
            this.h = false;
            this.f = str2;
        }

        a(int i, KMAppUsage.KMMetric kMMetric, String str, String str2, int i2, boolean z) {
            this.f4485a = i;
            this.e = str;
            this.b = i2;
            this.g = kMMetric;
            this.f = str2;
            this.h = z;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        this.e = true;
        this.f4484a.clearHistory();
    }

    @Override // com.nextreaming.nexeditorui.ba, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.help);
        this.b = findViewById(R.id.help_prev);
        this.c = findViewById(R.id.help_next);
        b bVar = new b(this, null);
        NexEditor a2 = EditorGlobal.a();
        bVar.b = a2.getVersionNumber(1) + "." + a2.getVersionNumber(2) + "." + a2.getVersionNumber(3) + "." + a2.getVersionNumber(4);
        try {
            bVar.c = getPackageManager().getPackageInfo(getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException e) {
            bVar.c = "?";
            e.printStackTrace();
        }
        findViewById(R.id.logolink).setOnClickListener(new bx(this));
        this.f = new a[]{new a(R.id.getting_started, KMAppUsage.KMMetric.NavigateToHelpGettingStarted, "Getting Started_page.html", "/Getting"), new a(R.id.tips_and_tricks, KMAppUsage.KMMetric.NavigateToHelpTipsAndTricks, "tips.html", "/tips"), new a(R.id.advanced_features, KMAppUsage.KMMetric.NavigateToHelpAdvancedFeatures, "advanced.html", null), new a(R.id.infolink, KMAppUsage.KMMetric.NavigateToAbout, "info.html", "/info"), new a(R.id.settings, KMAppUsage.KMMetric.NavigateToSettings, "settings.html", "/settings", R.id.settingsFragmentHolder, false), new a(R.id.settings, KMAppUsage.KMMetric.NavigateToDevSettings, "devsettings.html", "/devsettings", R.id.devSettingsFragmentHolder, true)};
        for (int i = 0; i < this.f.length; i++) {
            this.f[i].c = findViewById(this.f[i].f4485a);
            this.f[i].d = findViewById(this.f[i].b);
            a aVar = this.f[i];
            if (aVar.h) {
                aVar.c.setOnLongClickListener(new by(this, aVar));
            } else {
                aVar.c.setOnClickListener(new bz(this, aVar));
            }
        }
        this.f[0].c.setSelected(true);
        this.f4484a = (WebView) findViewById(R.id.helpWebView);
        this.f4484a.setVisibility(4);
        this.f4484a.setBackgroundColor(Color.argb(255, 42, 42, 42));
        this.f4484a.setWebViewClient(new ca(this));
        this.b.setOnClickListener(new ce(this));
        this.c.setOnClickListener(new cf(this));
        this.f4484a.getSettings().setJavaScriptEnabled(true);
        this.f4484a.addJavascriptInterface(bVar, "nexEditor");
        if (bundle != null) {
            this.f4484a.restoreState(bundle);
            return;
        }
        this.f4484a.loadUrl(a("file:///android_asset/help/" + this.f[0].e));
        this.b.setVisibility(4);
        this.c.setVisibility(4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String a(String str) {
        Locale locale = getResources().getConfiguration().locale;
        String lowerCase = locale.getLanguage().toLowerCase(Locale.US);
        String[] strArr = {"help-" + lowerCase + "-r" + locale.getCountry().toUpperCase(Locale.US), "help-" + lowerCase, "help"};
        for (String str2 : strArr) {
            String replaceFirst = str.replaceFirst("/help[^/]*/", "/" + str2 + "/");
            if (b(replaceFirst.replaceFirst("#[^#]*$", "").replaceFirst("file:///android_asset/", ""))) {
                return replaceFirst;
            }
        }
        return str;
    }

    private boolean b(String str) {
        try {
            getAssets().open(str).close();
            return true;
        } catch (IOException e) {
            return false;
        }
    }
}
