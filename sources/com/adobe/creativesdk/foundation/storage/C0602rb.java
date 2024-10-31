package com.adobe.creativesdk.foundation.storage;

import android.os.Handler;
import com.adobe.creativesdk.foundation.internal.utils.AdobeCSDKException;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AdobeLibraryComposite.java */
/* renamed from: com.adobe.creativesdk.foundation.storage.rb, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0602rb implements sd<String, AdobeCSDKException> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ c.a.a.a.b f7400a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ Handler f7401b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ c.a.a.a.c f7402c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ C0614ub f7403d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0602rb(C0614ub c0614ub, c.a.a.a.b bVar, Handler handler, c.a.a.a.c cVar) {
        this.f7403d = c0614ub;
        this.f7400a = bVar;
        this.f7401b = handler;
        this.f7402c = cVar;
    }

    @Override // com.adobe.creativesdk.foundation.storage.rd
    public void a() {
    }

    @Override // com.adobe.creativesdk.foundation.storage.ud
    public void a(double d2) {
    }

    @Override // c.a.a.a.b
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void b(String str) {
        c.a.a.a.b bVar = this.f7400a;
        if (bVar != null) {
            this.f7403d.a((c.a.a.a.b<String>) bVar, this.f7401b, str);
        }
    }

    @Override // c.a.a.a.c
    public void a(AdobeCSDKException adobeCSDKException) {
        if (this.f7402c != null) {
            AdobeLibraryException a2 = com.adobe.creativesdk.foundation.adobeinternal.storage.library.ia.a(AdobeLibraryErrorCode.AdobeLibraryErrorDownloadingRepresentationAsset, adobeCSDKException, null, null);
            this.f7403d.a((c.a.a.a.c<AdobeLibraryException>) this.f7402c, this.f7401b, a2);
        }
    }
}
