package com.adobe.creativesdk.foundation.internal.storage.controllers;

import com.adobe.creativesdk.foundation.internal.storage.C0330a;
import com.adobe.creativesdk.foundation.storage.AdobeAssetException;
import com.adobe.creativesdk.foundation.storage.AdobeAssetFileRenditionType;
import com.adobe.creativesdk.foundation.storage.C0582ma;

/* compiled from: CCFilesListView.java */
/* loaded from: classes.dex */
public class Ob implements com.adobe.creativesdk.foundation.storage.sd<byte[], AdobeAssetException> {

    /* renamed from: a */
    final /* synthetic */ com.adobe.creativesdk.foundation.storage.sd f5748a;

    /* renamed from: b */
    final /* synthetic */ C0330a f5749b;

    /* renamed from: c */
    final /* synthetic */ AdobeAssetFileRenditionType f5750c;

    /* renamed from: d */
    final /* synthetic */ C0582ma f5751d;

    /* renamed from: e */
    final /* synthetic */ Rb f5752e;

    public Ob(Rb rb, com.adobe.creativesdk.foundation.storage.sd sdVar, C0330a c0330a, AdobeAssetFileRenditionType adobeAssetFileRenditionType, C0582ma c0582ma) {
        this.f5752e = rb;
        this.f5748a = sdVar;
        this.f5749b = c0330a;
        this.f5750c = adobeAssetFileRenditionType;
        this.f5751d = c0582ma;
    }

    @Override // com.adobe.creativesdk.foundation.storage.rd
    public void a() {
        this.f5748a.a();
    }

    @Override // c.a.a.a.b
    /* renamed from: a */
    public void b(byte[] bArr) {
        if (this.f5752e.a(bArr, this.f5749b.f5272a, this.f5750c, this.f5751d, new Lb(this), new Nb(this))) {
            return;
        }
        new Mb(this).execute(bArr);
    }

    @Override // c.a.a.a.c
    public void a(AdobeAssetException adobeAssetException) {
        this.f5748a.a((com.adobe.creativesdk.foundation.storage.sd) adobeAssetException);
    }

    @Override // com.adobe.creativesdk.foundation.storage.ud
    public void a(double d2) {
        this.f5748a.a(d2);
    }
}
