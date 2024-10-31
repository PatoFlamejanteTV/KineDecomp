package com.adobe.creativesdk.foundation.storage;

import com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.AdobeDCXException;
import com.adobe.creativesdk.foundation.internal.storage.a.b.ra;
import com.adobe.creativesdk.foundation.internal.utils.logging.Level;
import com.adobe.creativesdk.foundation.network.AdobeNetworkException;
import java.lang.ref.WeakReference;
import java.util.HashMap;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AdobeAssetPackage.java */
/* loaded from: classes.dex */
public class Xa implements ra.b {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ WeakReference f7162a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ c.a.a.a.c f7163b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ c.a.a.a.b f7164c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ Ya f7165d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Xa(Ya ya, WeakReference weakReference, c.a.a.a.c cVar, c.a.a.a.b bVar) {
        this.f7165d = ya;
        this.f7162a = weakReference;
        this.f7163b = cVar;
        this.f7164c = bVar;
    }

    @Override // com.adobe.creativesdk.foundation.storage.ud
    public void a(double d2) {
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.a.b.ra.b
    public void a(com.adobe.creativesdk.foundation.internal.net.l lVar) {
        Ya ya = (Ya) this.f7162a.get();
        if (lVar.g() == 404) {
            Object[] objArr = new Object[1];
            objArr[0] = ya != null ? ya.getDescription() : "";
            String format = String.format("The requested manifest for package %s not found. This is most likely due to an empty asset package (no manifest).", objArr);
            if (this.f7163b != null) {
                this.f7163b.a(new AdobeAssetException(AdobeAssetErrorCode.AdobeAssetErrorFileReadFailure, new HashMap()));
                return;
            } else {
                com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.ERROR, "AdobeAssetPackage.loadDCXManifest", format);
                return;
            }
        }
        try {
            com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.Fa fa = new com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.Fa(lVar.d());
            if (ya != null) {
                ya.GUID = fa.h();
                ya.name = fa.p();
            }
            if (this.f7164c != null) {
                this.f7164c.b(fa);
            }
        } catch (AdobeDCXException e2) {
            this.f7163b.a(e2);
        }
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.a.b.ra.b
    public void a(AdobeNetworkException adobeNetworkException) {
        this.f7163b.a(adobeNetworkException);
    }
}
