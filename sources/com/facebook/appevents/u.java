package com.facebook.appevents;

import android.content.Context;
import android.os.Bundle;
import android.webkit.JavascriptInterface;
import com.facebook.LoggingBehavior;
import com.facebook.internal.Logger;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: FacebookSDKJSInterface.java */
/* loaded from: classes.dex */
class u {

    /* renamed from: a, reason: collision with root package name */
    public static final String f9225a = "u";

    /* renamed from: b, reason: collision with root package name */
    private Context f9226b;

    public u(Context context) {
        this.f9226b = context;
    }

    private static Bundle a(JSONObject jSONObject) throws JSONException {
        Bundle bundle = new Bundle();
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            bundle.putString(next, jSONObject.getString(next));
        }
        return bundle;
    }

    @JavascriptInterface
    public String getProtocol() {
        return "fbmq-0.1";
    }

    @JavascriptInterface
    public void sendEvent(String str, String str2, String str3) {
        if (str == null) {
            Logger.log(LoggingBehavior.DEVELOPER_ERRORS, f9225a, "Can't bridge an event without a referral Pixel ID. Check your webview Pixel configuration");
            return;
        }
        AppEventsLogger newLogger = AppEventsLogger.newLogger(this.f9226b);
        Bundle a2 = a(str3);
        a2.putString("_fb_pixel_referral_id", str);
        newLogger.logEvent(str2, a2);
    }

    private static Bundle a(String str) {
        try {
            return a(new JSONObject(str));
        } catch (JSONException unused) {
            return new Bundle();
        }
    }
}
