package com.adobe.creativesdk.foundation.internal.storage;

import com.adobe.creativesdk.foundation.internal.storage.a.b.ua;
import com.adobe.creativesdk.foundation.storage.AdobeAssetException;
import com.adobe.creativesdk.foundation.storage.sd;
import java.io.UnsupportedEncodingException;

/* compiled from: AdobeAssetFileInternal.java */
/* renamed from: com.adobe.creativesdk.foundation.internal.storage.g, reason: case insensitive filesystem */
/* loaded from: classes.dex */
class C0508g implements ua {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ sd f6582a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ com.adobe.creativesdk.foundation.internal.storage.model.resources.f f6583b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ com.adobe.creativesdk.foundation.internal.storage.model.resources.e f6584c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0508g(sd sdVar, com.adobe.creativesdk.foundation.internal.storage.model.resources.f fVar, com.adobe.creativesdk.foundation.internal.storage.model.resources.e eVar) {
        this.f6582a = sdVar;
        this.f6583b = fVar;
        this.f6584c = eVar;
    }

    @Override // com.adobe.creativesdk.foundation.storage.ud
    public void a(double d2) {
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.a.b.ua
    public void a(byte[] bArr) {
        try {
            try {
                this.f6583b.b(com.adobe.creativesdk.foundation.internal.storage.model.util.i.a(new String(bArr, "UTF-8")));
                this.f6582a.b(new AdobeAssetFileInternal(this.f6583b, this.f6584c));
            } catch (Exception unused) {
                this.f6582a.b(null);
            }
        } catch (UnsupportedEncodingException unused2) {
            this.f6582a.b(null);
        }
    }

    @Override // c.a.a.a.c
    public void a(AdobeAssetException adobeAssetException) {
        this.f6582a.a((sd) adobeAssetException);
    }
}
