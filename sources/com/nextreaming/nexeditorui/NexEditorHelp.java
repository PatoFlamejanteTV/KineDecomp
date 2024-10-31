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
import java.util.HashMap;
import java.util.Locale;

@SuppressLint({"SetJavaScriptEnabled"})
/* loaded from: classes.dex */
public class NexEditorHelp extends I {
    private WebView H;
    private View I;
    private View J;
    private boolean K = false;
    private a[] L;

    public void K() {
        this.K = true;
        this.H.clearHistory();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.nextreaming.nexeditorui.I, android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        a[] aVarArr;
        com.nexstreaming.kinemaster.usage.analytics.b.a(getLocalClassName());
        super.onCreate(bundle);
        setContentView(R.layout.help);
        this.I = findViewById(R.id.help_prev);
        this.J = findViewById(R.id.help_next);
        b bVar = new b(this, null);
        HashMap<String, Integer> e2 = EditorGlobal.i().e();
        bVar.f24106a = e2.get(NexEditor.EngineVersion.MAJOR.name()).intValue() + "." + e2.get(NexEditor.EngineVersion.MINOR.name()).intValue() + "." + e2.get(NexEditor.EngineVersion.PATCH.name()).intValue() + "." + e2.get(NexEditor.EngineVersion.BUILD.name()).intValue();
        try {
            bVar.f24107b = getPackageManager().getPackageInfo(getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException e3) {
            bVar.f24107b = "?";
            e3.printStackTrace();
        }
        findViewById(R.id.logolink).setOnClickListener(new ViewOnClickListenerC2323na(this));
        this.L = new a[]{new a(R.id.getting_started, KMAppUsage.KMMetric.NavigateToHelpGettingStarted, "Getting Started_page.html", "/Getting"), new a(R.id.tips_and_tricks, KMAppUsage.KMMetric.NavigateToHelpTipsAndTricks, "tips.html", "/tips"), new a(R.id.advanced_features, KMAppUsage.KMMetric.NavigateToHelpAdvancedFeatures, "advanced.html", null), new a(R.id.infolink, KMAppUsage.KMMetric.NavigateToAbout, "info.html", "/info"), new a(R.id.settings, KMAppUsage.KMMetric.NavigateToSettings, "settings.html", "/settings", R.id.settingsFragmentHolder, false), new a(R.id.settings, KMAppUsage.KMMetric.NavigateToDevSettings, "devsettings.html", "/devsettings", R.id.devSettingsFragmentHolder, true)};
        int i = 0;
        while (true) {
            aVarArr = this.L;
            if (i >= aVarArr.length) {
                break;
            }
            aVarArr[i].f24100c = findViewById(aVarArr[i].f24098a);
            a[] aVarArr2 = this.L;
            aVarArr2[i].f24101d = findViewById(aVarArr2[i].f24099b);
            a aVar = this.L[i];
            if (aVar.f24105h) {
                aVar.f24100c.setOnLongClickListener(new ViewOnLongClickListenerC2325oa(this, aVar));
            } else {
                aVar.f24100c.setOnClickListener(new ViewOnClickListenerC2327pa(this, aVar));
            }
            i++;
        }
        aVarArr[0].f24100c.setSelected(true);
        this.H = (WebView) findViewById(R.id.helpWebView);
        this.H.setVisibility(4);
        this.H.setBackgroundColor(Color.argb(255, 42, 42, 42));
        this.H.setWebViewClient(new C2334ta(this));
        this.I.setOnClickListener(new ViewOnClickListenerC2336ua(this));
        this.J.setOnClickListener(new ViewOnClickListenerC2338va(this));
        this.H.getSettings().setJavaScriptEnabled(true);
        this.H.addJavascriptInterface(bVar, "nexEditor");
        if (bundle != null) {
            this.H.restoreState(bundle);
            return;
        }
        this.H.loadUrl(d("file:///android_asset/help/" + this.L[0].f24102e));
        this.I.setVisibility(4);
        this.J.setVisibility(4);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.nextreaming.nexeditorui.I, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.nextreaming.nexeditorui.I, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.nextreaming.nexeditorui.I, android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        this.H.saveState(bundle);
        super.onSaveInstanceState(bundle);
    }

    /* loaded from: classes.dex */
    public class b {

        /* renamed from: a */
        private String f24106a;

        /* renamed from: b */
        private String f24107b;

        /* renamed from: c */
        private Handler f24108c;

        private b() {
            this.f24108c = new Handler();
        }

        @JavascriptInterface
        public String appExpires() {
            Date s = ExpiredActivity.s();
            return s == null ? "" : s.toString();
        }

        @JavascriptInterface
        public String appVersion() {
            return this.f24107b;
        }

        @JavascriptInterface
        public String engineVersion() {
            return this.f24106a;
        }

        @JavascriptInterface
        public void exitHelp() {
            this.f24108c.post(new RunnableC2340wa(this));
        }

        @JavascriptInterface
        public void guideReset() {
        }

        /* synthetic */ b(NexEditorHelp nexEditorHelp, ViewOnClickListenerC2323na viewOnClickListenerC2323na) {
            this();
        }
    }

    private boolean c(String str) {
        try {
            getAssets().open(str).close();
            return true;
        } catch (IOException unused) {
            return false;
        }
    }

    public String d(String str) {
        Locale locale = getResources().getConfiguration().locale;
        String lowerCase = locale.getLanguage().toLowerCase(Locale.US);
        for (String str2 : new String[]{"help-" + lowerCase + "-r" + locale.getCountry().toUpperCase(Locale.US), "help-" + lowerCase, "help"}) {
            String replaceFirst = str.replaceFirst("/help[^/]*/", "/" + str2 + "/");
            if (c(replaceFirst.replaceFirst("#[^#]*$", "").replaceFirst("file:///android_asset/", ""))) {
                return replaceFirst;
            }
        }
        return str;
    }

    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a */
        int f24098a;

        /* renamed from: b */
        int f24099b;

        /* renamed from: c */
        View f24100c;

        /* renamed from: d */
        View f24101d;

        /* renamed from: e */
        String f24102e;

        /* renamed from: f */
        String f24103f;

        /* renamed from: g */
        KMAppUsage.KMMetric f24104g;

        /* renamed from: h */
        boolean f24105h;

        a(int i, KMAppUsage.KMMetric kMMetric, String str, String str2) {
            this.f24098a = i;
            this.f24102e = str;
            this.f24099b = R.id.helpWebView;
            this.f24104g = kMMetric;
            this.f24105h = false;
            this.f24103f = str2;
        }

        a(int i, KMAppUsage.KMMetric kMMetric, String str, String str2, int i2, boolean z) {
            this.f24098a = i;
            this.f24102e = str;
            this.f24099b = i2;
            this.f24104g = kMMetric;
            this.f24103f = str2;
            this.f24105h = z;
        }
    }
}
