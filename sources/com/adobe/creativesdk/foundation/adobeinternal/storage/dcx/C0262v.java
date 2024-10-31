package com.adobe.creativesdk.foundation.adobeinternal.storage.dcx;

import com.adobe.creativesdk.foundation.internal.utils.logging.Level;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AdobeDCXCompositeXfer.java */
/* renamed from: com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.v, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0262v implements com.adobe.creativesdk.foundation.internal.storage.model.util.j {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f4461a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ C0264w f4462b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ String f4463c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ C0225c f4464d;

    /* renamed from: e, reason: collision with root package name */
    final /* synthetic */ String f4465e;

    /* renamed from: f, reason: collision with root package name */
    final /* synthetic */ A f4466f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0262v(A a2, String str, C0264w c0264w, String str2, C0225c c0225c, String str3) {
        this.f4466f = a2;
        this.f4461a = str;
        this.f4462b = c0264w;
        this.f4463c = str2;
        this.f4464d = c0225c;
        this.f4465e = str3;
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.model.util.j
    public void a(String str) {
        com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.DEBUG, "AdobeDCXCompositeXfer", "AdobeStorageUtils.MD5HashOfFile-1 completed inside internalDownloadComponents");
        if (str != null && this.f4461a.equals(str)) {
            this.f4462b.a(null);
            this.f4466f.f4104e.a(null);
        } else {
            new C0270z(this.f4466f, this.f4462b, this.f4463c).a(this.f4464d, this.f4465e);
        }
    }
}
