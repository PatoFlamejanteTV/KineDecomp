package io.fabric.sdk.android.services.common;

import android.content.Context;
import android.text.TextUtils;

/* compiled from: FirebaseInfo.java */
/* loaded from: classes3.dex */
public class s {
    /* JADX INFO: Access modifiers changed from: protected */
    public String a(Context context) {
        int a2 = CommonUtils.a(context, "google_app_id", "string");
        if (a2 == 0) {
            return null;
        }
        io.fabric.sdk.android.f.f().d("Fabric", "Generating Crashlytics ApiKey from google_app_id in Strings");
        return a(context.getResources().getString(a2));
    }

    public boolean b(Context context) {
        if (CommonUtils.a(context, "com.crashlytics.useFirebaseAppId", false)) {
            return true;
        }
        return (CommonUtils.a(context, "google_app_id", "string") != 0) && !(!TextUtils.isEmpty(new i().b(context)) || !TextUtils.isEmpty(new i().c(context)));
    }

    protected String a(String str) {
        return CommonUtils.d(str).substring(0, 40);
    }
}
