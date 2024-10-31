package com.adobe.creativesdk.foundation.internal.storage.controllers;

import com.adobe.creativesdk.foundation.storage.AdobeAssetException;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AdobeOneUpSinglePageAssetController.java */
/* loaded from: classes.dex */
public class A implements com.adobe.creativesdk.foundation.storage.sd<byte[], AdobeAssetException> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ C f5506a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public A(C c2) {
        this.f5506a = c2;
    }

    @Override // com.adobe.creativesdk.foundation.storage.ud
    public void a(double d2) {
    }

    @Override // com.adobe.creativesdk.foundation.storage.rd
    public void a() {
        this.f5506a.a((byte[]) null);
    }

    @Override // c.a.a.a.b
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void b(byte[] bArr) {
        this.f5506a.a(bArr);
    }

    @Override // c.a.a.a.c
    public void a(AdobeAssetException adobeAssetException) {
        this.f5506a.a((byte[]) null);
    }
}
