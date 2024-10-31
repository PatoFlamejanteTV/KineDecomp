package com.adobe.creativesdk.foundation.adobeinternal.storage.library;

import java.util.HashMap;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AdobeLibrarySyncManager.java */
/* loaded from: classes.dex */
public class N implements com.adobe.creativesdk.foundation.adobeinternal.imageservice.w {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ HashMap f4527a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ HashMap f4528b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ HashMap f4529c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ ha f4530d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public N(ha haVar, HashMap hashMap, HashMap hashMap2, HashMap hashMap3) {
        this.f4530d = haVar;
        this.f4527a = hashMap;
        this.f4528b = hashMap2;
        this.f4529c = hashMap3;
    }

    @Override // com.adobe.creativesdk.foundation.adobeinternal.imageservice.w
    public boolean a(String str, String str2) {
        this.f4528b.put(str, str2);
        return true;
    }

    @Override // com.adobe.creativesdk.foundation.adobeinternal.imageservice.w
    public boolean b(String str, String str2) {
        this.f4527a.put(str, str2);
        return true;
    }

    @Override // com.adobe.creativesdk.foundation.adobeinternal.imageservice.w
    public boolean c(String str, String str2) {
        this.f4529c.put(str, str2);
        return true;
    }
}
