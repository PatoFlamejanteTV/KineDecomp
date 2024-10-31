package com.adobe.creativesdk.foundation.adobeinternal.storage.library;

import java.util.HashMap;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AdobeLibrarySyncManager.java */
/* loaded from: classes.dex */
public class ga implements com.adobe.creativesdk.foundation.adobeinternal.imageservice.w {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ HashMap f4618a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ HashMap f4619b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ HashMap f4620c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ ha f4621d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ga(ha haVar, HashMap hashMap, HashMap hashMap2, HashMap hashMap3) {
        this.f4621d = haVar;
        this.f4618a = hashMap;
        this.f4619b = hashMap2;
        this.f4620c = hashMap3;
    }

    @Override // com.adobe.creativesdk.foundation.adobeinternal.imageservice.w
    public boolean a(String str, String str2) {
        this.f4619b.put(str, str2);
        return true;
    }

    @Override // com.adobe.creativesdk.foundation.adobeinternal.imageservice.w
    public boolean b(String str, String str2) {
        this.f4618a.put(str, str2);
        return true;
    }

    @Override // com.adobe.creativesdk.foundation.adobeinternal.imageservice.w
    public boolean c(String str, String str2) {
        this.f4620c.put(str, str2);
        return true;
    }
}
