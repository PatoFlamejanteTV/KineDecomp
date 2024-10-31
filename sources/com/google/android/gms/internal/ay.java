package com.google.android.gms.internal;

import android.text.TextUtils;
import com.facebook.share.internal.ShareConstants;
import java.util.HashMap;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ay implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f1439a;
    final /* synthetic */ String b;
    final /* synthetic */ String c;
    final /* synthetic */ String d;
    final /* synthetic */ zzdv e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ay(zzdv zzdvVar, String str, String str2, String str3, String str4) {
        this.e = zzdvVar;
        this.f1439a = str;
        this.b = str2;
        this.c = str3;
        this.d = str4;
    }

    @Override // java.lang.Runnable
    public void run() {
        String zzad;
        HashMap hashMap = new HashMap();
        hashMap.put("event", "precacheCanceled");
        hashMap.put("src", this.f1439a);
        if (!TextUtils.isEmpty(this.b)) {
            hashMap.put("cachedSrc", this.b);
        }
        zzad = this.e.zzad(this.c);
        hashMap.put("type", zzad);
        hashMap.put("reason", this.c);
        if (!TextUtils.isEmpty(this.d)) {
            hashMap.put(ShareConstants.WEB_DIALOG_PARAM_MESSAGE, this.d);
        }
        this.e.zzoM.zzb("onPrecacheEvent", hashMap);
    }
}
