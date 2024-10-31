package com.mixpanel.android.mpmetrics;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.keyczar.Keyczar;

/* loaded from: classes.dex */
public class InstallReferrerReceiver extends BroadcastReceiver {

    /* renamed from: a, reason: collision with root package name */
    private final Pattern f3003a = Pattern.compile("(^|&)utm_source=([^&#=]*)([#&]|$)");
    private final Pattern b = Pattern.compile("(^|&)utm_medium=([^&#=]*)([#&]|$)");
    private final Pattern c = Pattern.compile("(^|&)utm_campaign=([^&#=]*)([#&]|$)");
    private final Pattern d = Pattern.compile("(^|&)utm_content=([^&#=]*)([#&]|$)");
    private final Pattern e = Pattern.compile("(^|&)utm_term=([^&#=]*)([#&]|$)");

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        String string;
        Bundle extras = intent.getExtras();
        if (extras != null && (string = extras.getString("referrer")) != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("referrer", string);
            String a2 = a(this.f3003a.matcher(string));
            if (a2 != null) {
                hashMap.put("utm_source", a2);
            }
            String a3 = a(this.b.matcher(string));
            if (a3 != null) {
                hashMap.put("utm_medium", a3);
            }
            String a4 = a(this.c.matcher(string));
            if (a4 != null) {
                hashMap.put("utm_campaign", a4);
            }
            String a5 = a(this.d.matcher(string));
            if (a5 != null) {
                hashMap.put("utm_content", a5);
            }
            String a6 = a(this.e.matcher(string));
            if (a6 != null) {
                hashMap.put("utm_term", a6);
            }
            w.a(context, "com.mixpanel.android.mpmetrics.ReferralInfo", hashMap);
        }
    }

    private String a(Matcher matcher) {
        String group;
        if (matcher.find() && (group = matcher.group(2)) != null) {
            try {
                return URLDecoder.decode(group, Keyczar.DEFAULT_ENCODING);
            } catch (UnsupportedEncodingException e) {
                Log.e("MixpanelAPI.InstRfrRcvr", "Could not decode a parameter into UTF-8");
            }
        }
        return null;
    }
}
