package com.google.android.gms.common.internal;

import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.facebook.share.internal.ShareConstants;

/* loaded from: classes.dex */
public class zzn {

    /* renamed from: a, reason: collision with root package name */
    private static final Uri f1020a = Uri.parse("http://plus.google.com/");
    private static final Uri b = f1020a.buildUpon().appendPath("circles").appendPath("find").build();

    public static Intent a() {
        Intent intent = new Intent("com.google.android.clockwork.home.UPDATE_ANDROID_WEAR_ACTION");
        intent.setPackage("com.google.android.wearable.app");
        return intent;
    }

    public static Intent a(String str) {
        Uri fromParts = Uri.fromParts("package", str, null);
        Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent.setData(fromParts);
        return intent;
    }

    public static Intent a(String str, String str2) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(b(str, str2));
        intent.setPackage("com.android.vending");
        intent.addFlags(524288);
        return intent;
    }

    private static Uri b(String str, String str2) {
        Uri.Builder appendQueryParameter = Uri.parse("market://details").buildUpon().appendQueryParameter(ShareConstants.WEB_DIALOG_PARAM_ID, str);
        if (!TextUtils.isEmpty(str2)) {
            appendQueryParameter.appendQueryParameter("pcampaignid", str2);
        }
        return appendQueryParameter.build();
    }
}
