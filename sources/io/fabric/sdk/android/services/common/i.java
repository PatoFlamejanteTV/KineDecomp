package io.fabric.sdk.android.services.common;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;

/* compiled from: ApiKey.java */
/* loaded from: classes3.dex */
public class i {
    protected String a() {
        return "Fabric could not be initialized, API key missing from AndroidManifest.xml. Add the following tag to your Application element \n\t<meta-data android:name=\"io.fabric.ApiKey\" android:value=\"YOUR_API_KEY\"/>";
    }

    protected String a(Context context) {
        return new s().a(context);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String b(Context context) {
        String str = null;
        try {
            Bundle bundle = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData;
            if (bundle == null) {
                return null;
            }
            String string = bundle.getString("io.fabric.ApiKey");
            try {
                if ("@string/twitter_consumer_secret".equals(string)) {
                    io.fabric.sdk.android.f.f().d("Fabric", "Ignoring bad default value for Fabric ApiKey set by FirebaseUI-Auth");
                } else {
                    str = string;
                }
                if (str != null) {
                    return str;
                }
                io.fabric.sdk.android.f.f().d("Fabric", "Falling back to Crashlytics key lookup from Manifest");
                return bundle.getString("com.crashlytics.ApiKey");
            } catch (Exception e2) {
                e = e2;
                str = string;
                io.fabric.sdk.android.f.f().d("Fabric", "Caught non-fatal exception while retrieving apiKey: " + e);
                return str;
            }
        } catch (Exception e3) {
            e = e3;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String c(Context context) {
        int a2 = CommonUtils.a(context, "io.fabric.ApiKey", "string");
        if (a2 == 0) {
            io.fabric.sdk.android.f.f().d("Fabric", "Falling back to Crashlytics key lookup from Strings");
            a2 = CommonUtils.a(context, "com.crashlytics.ApiKey", "string");
        }
        if (a2 != 0) {
            return context.getResources().getString(a2);
        }
        return null;
    }

    public String d(Context context) {
        String b2 = b(context);
        if (TextUtils.isEmpty(b2)) {
            b2 = c(context);
        }
        if (TextUtils.isEmpty(b2)) {
            b2 = a(context);
        }
        if (TextUtils.isEmpty(b2)) {
            e(context);
        }
        return b2;
    }

    protected void e(Context context) {
        if (!io.fabric.sdk.android.f.h() && !CommonUtils.j(context)) {
            io.fabric.sdk.android.f.f().e("Fabric", a());
            return;
        }
        throw new IllegalArgumentException(a());
    }
}
