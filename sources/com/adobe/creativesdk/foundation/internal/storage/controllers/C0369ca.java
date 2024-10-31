package com.adobe.creativesdk.foundation.internal.storage.controllers;

import com.adobe.creativesdk.foundation.internal.storage.controllers.AdobeUXAssetOneUpViewerActivity;
import com.adobe.creativesdk.foundation.storage.AdobeAssetException;
import com.adobe.creativesdk.foundation.storage.C0533a;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AdobeUXAssetOneUpViewerActivity.java */
/* renamed from: com.adobe.creativesdk.foundation.internal.storage.controllers.ca, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0369ca implements com.adobe.creativesdk.foundation.storage.sd<byte[], AdobeAssetException> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ int f5970a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ C0533a f5971b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ AdobeUXAssetOneUpViewerActivity f5972c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0369ca(AdobeUXAssetOneUpViewerActivity adobeUXAssetOneUpViewerActivity, int i, C0533a c0533a) {
        this.f5972c = adobeUXAssetOneUpViewerActivity;
        this.f5970a = i;
        this.f5971b = c0533a;
    }

    @Override // com.adobe.creativesdk.foundation.storage.ud
    public final void a(double d2) {
    }

    @Override // com.adobe.creativesdk.foundation.storage.rd
    public void a() {
        b();
    }

    protected void b() {
        if (this.f5972c.F.c()) {
            return;
        }
        this.f5972c.a(this.f5970a, false);
    }

    @Override // c.a.a.a.b
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void b(byte[] bArr) {
        new AdobeUXAssetOneUpViewerActivity.e(this.f5971b, this.f5970a).execute(bArr);
    }

    @Override // c.a.a.a.c
    public void a(AdobeAssetException adobeAssetException) {
        b();
    }
}
