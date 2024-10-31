package com.google.android.gms.appinvite;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.TabHost;
import android.widget.TabWidget;
import android.widget.TextView;
import com.google.android.gms.common.annotation.KeepForSdkWithMembers;
import java.util.ArrayList;

@KeepForSdkWithMembers
/* loaded from: classes.dex */
public class PreviewActivity extends Activity {
    private final View a(Context context, ViewGroup viewGroup, Bundle bundle) {
        char c2;
        View inflate = LayoutInflater.from(context).inflate(bundle.getInt("com.google.android.gms.appinvite.LAYOUT_RES_ID"), viewGroup, false);
        ArrayList parcelableArrayList = bundle.getParcelableArrayList("com.google.android.gms.appinvite.VIEWS");
        if (parcelableArrayList != null) {
            int size = parcelableArrayList.size();
            int i = 0;
            while (i < size) {
                Object obj = parcelableArrayList.get(i);
                i++;
                Bundle bundle2 = (Bundle) obj;
                View findViewById = inflate.findViewById(bundle2.getInt("View_id"));
                for (String str : bundle2.keySet()) {
                    char c3 = 65535;
                    switch (str.hashCode()) {
                        case -1829808865:
                            if (str.equals("View_minHeight")) {
                                c2 = 1;
                                break;
                            }
                            break;
                        case -499175494:
                            if (str.equals("TextView_text")) {
                                c2 = 3;
                                break;
                            }
                            break;
                        case -111184848:
                            if (str.equals("WebView_data")) {
                                c2 = 6;
                                break;
                            }
                            break;
                        case 573559753:
                            if (str.equals("TextView_textColor")) {
                                c2 = 4;
                                break;
                            }
                            break;
                        case 966644059:
                            if (str.equals("View_backgroundColor")) {
                                c2 = 0;
                                break;
                            }
                            break;
                        case 1729346977:
                            if (str.equals("TextView_isTitle")) {
                                c2 = 5;
                                break;
                            }
                            break;
                        case 1920443715:
                            if (str.equals("View_onClickListener")) {
                                c2 = 2;
                                break;
                            }
                            break;
                    }
                    c2 = 65535;
                    switch (c2) {
                        case 0:
                            findViewById.setBackgroundColor(bundle2.getInt(str));
                            break;
                        case 1:
                            findViewById.setMinimumHeight(bundle2.getInt(str));
                            break;
                        case 2:
                            String string = bundle2.getString(str);
                            if (string.hashCode() == 94756344 && string.equals("close")) {
                                c3 = 0;
                            }
                            if (c3 != 0) {
                                break;
                            } else {
                                findViewById.setOnClickListener(new b(this));
                                break;
                            }
                        case 3:
                            if (findViewById instanceof TextView) {
                                ((TextView) findViewById).setText(bundle2.getCharSequence(str));
                                break;
                            } else {
                                break;
                            }
                        case 4:
                            if (findViewById instanceof TextView) {
                                ((TextView) findViewById).setTextColor(bundle2.getInt(str));
                                break;
                            } else {
                                break;
                            }
                        case 5:
                            if ((findViewById instanceof TextView) && bundle2.getBoolean(str)) {
                                setTitle(((TextView) findViewById).getText());
                                break;
                            }
                            break;
                        case 6:
                            if (findViewById instanceof ViewGroup) {
                                WebView webView = new WebView(this);
                                webView.loadData(bundle2.getString(str), "text/html; charset=utf-8", "UTF-8");
                                ((ViewGroup) findViewById).addView(webView, new ViewGroup.LayoutParams(-1, -1));
                                break;
                            } else {
                                break;
                            }
                    }
                }
            }
        }
        return inflate;
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (getCallingActivity() != null && "com.google.android.gms".equals(getCallingActivity().getPackageName())) {
            int i = 0;
            try {
                Context createPackageContext = createPackageContext("com.google.android.gms", 0);
                Bundle extras = getIntent().getExtras();
                View a2 = a(createPackageContext, null, extras);
                if (a2 == null) {
                    finish();
                    return;
                }
                TabHost tabHost = (TabHost) a2.findViewById(android.R.id.tabhost);
                TabWidget tabWidget = (TabWidget) a2.findViewById(android.R.id.tabs);
                ArrayList parcelableArrayList = extras.getParcelableArrayList("com.google.android.gms.appinvite.TABS");
                if (tabHost != null && tabWidget != null && parcelableArrayList != null) {
                    tabHost.setup();
                    int size = parcelableArrayList.size();
                    while (i < size) {
                        Object obj = parcelableArrayList.get(i);
                        i++;
                        Bundle bundle2 = (Bundle) obj;
                        TabHost.TabSpec newTabSpec = tabHost.newTabSpec(bundle2.getString("tabTag"));
                        newTabSpec.setContent(bundle2.getInt("tabContentId"));
                        newTabSpec.setIndicator(a(createPackageContext, tabWidget, bundle2));
                        tabHost.addTab(newTabSpec);
                    }
                }
                setContentView(a2);
                return;
            } catch (PackageManager.NameNotFoundException unused) {
                finish();
                return;
            }
        }
        finish();
    }
}
