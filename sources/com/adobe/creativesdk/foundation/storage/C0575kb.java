package com.adobe.creativesdk.foundation.storage;

import android.os.Handler;
import com.adobe.creativesdk.foundation.internal.utils.logging.Level;
import org.json.JSONException;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AdobeLibraryComposite.java */
/* renamed from: com.adobe.creativesdk.foundation.storage.kb, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0575kb implements com.adobe.creativesdk.foundation.internal.storage.a.b.ua {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ c.a.a.a.c f7316a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ Handler f7317b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ String f7318c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ String f7319d;

    /* renamed from: e, reason: collision with root package name */
    final /* synthetic */ String f7320e;

    /* renamed from: f, reason: collision with root package name */
    final /* synthetic */ c.a.a.a.b f7321f;

    /* renamed from: g, reason: collision with root package name */
    final /* synthetic */ C0614ub f7322g;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0575kb(C0614ub c0614ub, c.a.a.a.c cVar, Handler handler, String str, String str2, String str3, c.a.a.a.b bVar) {
        this.f7322g = c0614ub;
        this.f7316a = cVar;
        this.f7317b = handler;
        this.f7318c = str;
        this.f7319d = str2;
        this.f7320e = str3;
        this.f7321f = bVar;
    }

    @Override // com.adobe.creativesdk.foundation.storage.ud
    public void a(double d2) {
    }

    @Override // c.a.a.a.c
    public void a(AdobeAssetException adobeAssetException) {
        c.a.a.a.c cVar = this.f7316a;
        if (cVar != null) {
            this.f7322g.a((c.a.a.a.c<AdobeLibraryException>) cVar, this.f7317b, com.adobe.creativesdk.foundation.adobeinternal.storage.library.ia.a(AdobeLibraryErrorCode.AdobeLibraryErrorDownloadingRenditionFile, adobeAssetException, this.f7318c, null));
        }
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.a.b.ua
    public void a(byte[] bArr) {
        try {
            this.f7322g.b(this.f7319d).put(this.f7320e, "<cache>" + this.f7319d + "/" + this.f7320e + ".png");
        } catch (JSONException e2) {
            com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.DEBUG, C0614ub.class.getSimpleName(), null, e2);
        }
        this.f7322g.w();
        c.a.a.a.b bVar = this.f7321f;
        if (bVar != null) {
            this.f7322g.a((c.a.a.a.b<String>) bVar, this.f7317b, this.f7318c);
        }
    }
}
