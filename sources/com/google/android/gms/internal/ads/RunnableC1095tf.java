package com.google.android.gms.internal.ads;

import android.support.v4.app.NotificationCompat;
import android.text.TextUtils;
import com.facebook.share.internal.ShareConstants;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.google.android.gms.internal.ads.tf */
/* loaded from: classes2.dex */
public final class RunnableC1095tf implements Runnable {

    /* renamed from: a */
    private final /* synthetic */ String f12551a;

    /* renamed from: b */
    private final /* synthetic */ String f12552b;

    /* renamed from: c */
    private final /* synthetic */ String f12553c;

    /* renamed from: d */
    private final /* synthetic */ String f12554d;

    /* renamed from: e */
    private final /* synthetic */ zzbfk f12555e;

    public RunnableC1095tf(zzbfk zzbfkVar, String str, String str2, String str3, String str4) {
        this.f12555e = zzbfkVar;
        this.f12551a = str;
        this.f12552b = str2;
        this.f12553c = str3;
        this.f12554d = str4;
    }

    @Override // java.lang.Runnable
    public final void run() {
        String zzez;
        HashMap hashMap = new HashMap();
        hashMap.put(NotificationCompat.CATEGORY_EVENT, "precacheCanceled");
        hashMap.put("src", this.f12551a);
        if (!TextUtils.isEmpty(this.f12552b)) {
            hashMap.put("cachedSrc", this.f12552b);
        }
        zzbfk zzbfkVar = this.f12555e;
        zzez = zzbfk.zzez(this.f12553c);
        hashMap.put("type", zzez);
        hashMap.put("reason", this.f12553c);
        if (!TextUtils.isEmpty(this.f12554d)) {
            hashMap.put(ShareConstants.WEB_DIALOG_PARAM_MESSAGE, this.f12554d);
        }
        this.f12555e.zza("onPrecacheEvent", (Map<String, String>) hashMap);
    }
}
