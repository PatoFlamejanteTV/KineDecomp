package com.nexstreaming.kinemaster.itemstore;

import android.annotation.TargetApi;
import android.app.FragmentManager;
import android.os.Build;
import android.os.Bundle;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import android.widget.ProgressBar;
import com.nexstreaming.app.general.util.z;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.kinemaster.ui.widget.Toolbar;
import com.nextreaming.nexeditorui.av;
import com.nextreaming.nexeditorui.ba;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class KMAssetStore extends ba implements FragmentManager.OnBackStackChangedListener {

    /* renamed from: a, reason: collision with root package name */
    private Toolbar f3405a;
    private WebView b;
    private ProgressBar c;
    private String e;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.nextreaming.nexeditorui.ba, android.app.Activity
    @TargetApi(21)
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_item_store);
        this.f3405a = (Toolbar) findViewById(R.id.toolbar_store);
        this.b = (WebView) findViewById(R.id.webView);
        this.c = (ProgressBar) findViewById(R.id.progressBar);
        this.b.setVisibility(0);
        this.f3405a.setClickListener(new com.nexstreaming.kinemaster.itemstore.a(this));
        this.f3405a.setExitButtonMode(Toolbar.ExitButtonMode.Cancel);
        this.f3405a.setRightButtonVisiblity(true);
        this.b.setWebViewClient(new b(this));
        this.b.setWebChromeClient(new c(this));
        this.b.getSettings().setJavaScriptEnabled(true);
        this.b.getSettings().setLoadWithOverviewMode(true);
        this.b.getSettings().setUseWideViewPort(true);
        this.b.getSettings().setDefaultTextEncodingName("utf-8");
        if (Build.VERSION.SDK_INT >= 21) {
            this.b.getSettings().setMixedContentMode(0);
        }
        this.b.addJavascriptInterface(new a(this, null), "KineMaster");
        if (av.a().c() != null) {
            this.b.loadUrl(av.a().c(), c());
        }
        getFragmentManager().addOnBackStackChangedListener(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Map<String, String> c() {
        HashMap hashMap = new HashMap();
        hashMap.put("user_key", "null");
        hashMap.put("app_uuid", z.a(D()));
        hashMap.put("env", "prod");
        hashMap.put("app_version", z.e(D()));
        hashMap.put("permission", e());
        hashMap.put("subscription", d());
        hashMap.put("language", "en");
        hashMap.put("edition", "Google");
        hashMap.put("application", getApplication().getPackageName());
        return hashMap;
    }

    private String d() {
        switch (C()) {
            case None:
            case Promocode:
            case SubUnknown:
                return "free";
            case SubMonthly:
            case OneTimeValid:
                return "sliver";
            case SubAnnual:
                return "gold";
            default:
                return "free";
        }
    }

    private String e() {
        switch (C()) {
            case None:
            case Promocode:
            case SubUnknown:
                return "free";
            case SubMonthly:
            case OneTimeValid:
                return "free, sliver";
            case SubAnnual:
                return "free, sliver, gold";
            default:
                return "free";
        }
    }

    @Override // com.nextreaming.nexeditorui.ba, android.app.Activity
    public void onBackPressed() {
        if (getFragmentManager() != null && getFragmentManager().getBackStackEntryCount() > 0) {
            getFragmentManager().popBackStack();
        } else if (this.b.canGoBack()) {
            this.b.goBack();
        } else {
            super.onBackPressed();
        }
    }

    @Override // android.app.FragmentManager.OnBackStackChangedListener
    public void onBackStackChanged() {
        if (getFragmentManager().getBackStackEntryCount() <= 0) {
            if (this.b != null) {
                this.b.setVisibility(0);
            }
            findViewById(R.id.fragmentHolder).setVisibility(8);
            this.f3405a.setRightButtonVisiblity(true);
            if (this.e == null) {
                this.f3405a.setLogoVisiblity(true);
                this.f3405a.setTitleMode(Toolbar.TitleMode.Title);
                this.f3405a.setTitle("");
                return;
            }
            this.f3405a.setTitle(this.e);
        }
    }

    /* loaded from: classes.dex */
    private class a {
        private Map<String, Integer> b;
        private Map<String, Integer> c;

        private a() {
            this.b = new HashMap();
            this.c = new HashMap();
        }

        /* synthetic */ a(KMAssetStore kMAssetStore, com.nexstreaming.kinemaster.itemstore.a aVar) {
            this();
        }

        @JavascriptInterface
        public int getAssetStatus(String str) {
            return 0;
        }

        @JavascriptInterface
        public int download(String str) {
            return 2;
        }

        @JavascriptInterface
        public void showPaymentView(String str) {
        }

        @JavascriptInterface
        public int getAssetProgress(String str) {
            if (!this.c.containsKey(str)) {
                return (this.b.containsKey(str) && this.b.get(str).intValue() == 1) ? 100 : -1;
            }
            int intValue = this.c.get(str).intValue();
            if (intValue < 100 && intValue >= 0) {
                intValue += 5;
                this.c.put(str, Integer.valueOf(intValue));
                this.b.put(str, 2);
            } else if (intValue < 0) {
                intValue = -1;
            }
            if (intValue >= 100) {
                this.c.remove(str);
                this.b.put(str, 1);
                return 100;
            }
            return intValue;
        }

        @JavascriptInterface
        public int uninstall(String str) {
            return 0;
        }

        @JavascriptInterface
        public void log(String str) {
        }
    }
}
