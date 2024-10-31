package com.nexstreaming.app.general.receiver;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.analytics.CampaignTrackingReceiver;
import com.nexstreaming.app.general.util.C1704h;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes2.dex */
public class KMInstallReferrerReceiver extends CampaignTrackingReceiver {

    /* renamed from: b */
    private final Pattern f19668b = Pattern.compile("(^|&)utm_source=([^&#=]*)([#&]|$)");

    /* renamed from: c */
    private final Pattern f19669c = Pattern.compile("(^|&)utm_medium=([^&#=]*)([#&]|$)");

    /* renamed from: d */
    private final Pattern f19670d = Pattern.compile("(^|&)utm_campaign=([^&#=]*)([#&]|$)");

    /* renamed from: e */
    private final Pattern f19671e = Pattern.compile("(^|&)utm_content=([^&#=]*)([#&]|$)");

    /* renamed from: f */
    private final Pattern f19672f = Pattern.compile("(^|&)utm_term=([^&#=]*)([#&]|$)");

    /* renamed from: g */
    private final Pattern f19673g = Pattern.compile("(^|&)deeplink=([^&#=]*)([#&]|$)");

    private String a(Matcher matcher) {
        String group;
        if (!matcher.find() || (group = matcher.group(2)) == null) {
            return null;
        }
        try {
            return URLDecoder.decode(group, "UTF-8");
        } catch (UnsupportedEncodingException e2) {
            Log.w("ReferrerReceiver", "find: ", e2);
            return null;
        }
    }

    @Override // com.google.android.gms.analytics.CampaignTrackingReceiver, android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        Bundle extras;
        super.onReceive(context, intent);
        String action = intent.getAction();
        if (action == null || !action.equals("com.android.vending.INSTALL_REFERRER") || (extras = intent.getExtras()) == null) {
            return;
        }
        String string = extras.getString("referrer");
        if (TextUtils.isEmpty(string)) {
            return;
        }
        Matcher matcher = this.f19668b.matcher(string);
        Matcher matcher2 = this.f19669c.matcher(string);
        Matcher matcher3 = this.f19671e.matcher(string);
        Matcher matcher4 = this.f19672f.matcher(string);
        Matcher matcher5 = this.f19670d.matcher(string);
        Matcher matcher6 = this.f19673g.matcher(string);
        a(matcher);
        a(matcher2);
        a(matcher4);
        a(matcher5);
        a(matcher3);
        String a2 = a(matcher6);
        if (TextUtils.isEmpty(a2) || !C1704h.b(Uri.parse(a2))) {
            return;
        }
        Intent intent2 = new Intent("android.intent.action.VIEW");
        intent2.setData(Uri.parse(a2));
        intent2.setFlags(268435456);
        context.startActivity(intent2);
    }
}
