package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.webkit.WebSettings;
import java.util.concurrent.Callable;

/* loaded from: classes2.dex */
final class Zd implements Callable<String> {

    /* renamed from: a */
    private final /* synthetic */ Context f12006a;

    /* renamed from: b */
    private final /* synthetic */ Context f12007b;

    public Zd(zzbam zzbamVar, Context context, Context context2) {
        this.f12006a = context;
        this.f12007b = context2;
    }

    @Override // java.util.concurrent.Callable
    public final /* synthetic */ String call() throws Exception {
        SharedPreferences sharedPreferences;
        boolean z = false;
        if (this.f12006a != null) {
            zzaxz.v("Attempting to read user agent from Google Play Services.");
            sharedPreferences = this.f12006a.getSharedPreferences("admob_user_agent", 0);
        } else {
            zzaxz.v("Attempting to read user agent from local cache.");
            sharedPreferences = this.f12007b.getSharedPreferences("admob_user_agent", 0);
            z = true;
        }
        String string = sharedPreferences.getString("user_agent", "");
        if (TextUtils.isEmpty(string)) {
            zzaxz.v("Reading user agent from WebSettings");
            string = WebSettings.getDefaultUserAgent(this.f12007b);
            if (z) {
                sharedPreferences.edit().putString("user_agent", string).apply();
                zzaxz.v("Persisting user agent.");
            }
        }
        return string;
    }
}
