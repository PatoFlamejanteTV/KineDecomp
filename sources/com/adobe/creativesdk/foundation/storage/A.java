package com.adobe.creativesdk.foundation.storage;

import android.os.Handler;
import com.adobe.creativesdk.foundation.internal.utils.AdobeCSDKException;
import java.net.URL;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AdobeAssetFile.java */
/* loaded from: classes.dex */
public class A implements com.adobe.creativesdk.foundation.internal.storage.a.b.va {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ URL f6917a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ String f6918b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ sd f6919c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ Handler f6920d;

    /* renamed from: e, reason: collision with root package name */
    final /* synthetic */ AdobeAssetFile f6921e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public A(AdobeAssetFile adobeAssetFile, URL url, String str, sd sdVar, Handler handler) {
        this.f6921e = adobeAssetFile;
        this.f6917a = url;
        this.f6918b = str;
        this.f6919c = sdVar;
        this.f6920d = handler;
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.a.b.va
    public void a(com.adobe.creativesdk.foundation.internal.storage.model.resources.f fVar) {
        this.f6921e.a(this.f6917a, this.f6918b, (fVar == null || fVar.f6613e == null) ? false : true, (sd<AdobeAssetFile, AdobeCSDKException>) this.f6919c, this.f6920d);
    }

    @Override // com.adobe.creativesdk.foundation.storage.ud
    public void a(double d2) {
        this.f6919c.a(d2);
    }

    @Override // c.a.a.a.c
    public void a(AdobeAssetException adobeAssetException) {
        if (adobeAssetException.getHttpStatusCode().intValue() == 404) {
            this.f6921e.a(this.f6917a, this.f6918b, false, (sd<AdobeAssetFile, AdobeCSDKException>) this.f6919c, this.f6920d);
            return;
        }
        this.f6919c.a((sd) adobeAssetException);
    }
}
