package com.adobe.creativesdk.foundation.storage;

import android.os.Handler;
import com.adobe.creativesdk.foundation.internal.utils.logging.Level;
import org.json.JSONException;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AdobeLibraryComposite.java */
/* renamed from: com.adobe.creativesdk.foundation.storage.jb, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0571jb implements com.adobe.creativesdk.foundation.internal.storage.a.b.ua {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f7298a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ String f7299b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ c.a.a.a.b f7300c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ Handler f7301d;

    /* renamed from: e, reason: collision with root package name */
    final /* synthetic */ String f7302e;

    /* renamed from: f, reason: collision with root package name */
    final /* synthetic */ c.a.a.a.c f7303f;

    /* renamed from: g, reason: collision with root package name */
    final /* synthetic */ C0614ub f7304g;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0571jb(C0614ub c0614ub, String str, String str2, c.a.a.a.b bVar, Handler handler, String str3, c.a.a.a.c cVar) {
        this.f7304g = c0614ub;
        this.f7298a = str;
        this.f7299b = str2;
        this.f7300c = bVar;
        this.f7301d = handler;
        this.f7302e = str3;
        this.f7303f = cVar;
    }

    @Override // com.adobe.creativesdk.foundation.storage.ud
    public void a(double d2) {
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.a.b.ua
    public void a(byte[] bArr) {
        try {
            this.f7304g.b(this.f7298a).put(this.f7299b, "<cache>" + this.f7298a + "/" + this.f7299b + ".png");
        } catch (JSONException e2) {
            com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.DEBUG, C0614ub.class.getSimpleName(), null, e2);
        }
        this.f7304g.w();
        c.a.a.a.b bVar = this.f7300c;
        if (bVar != null) {
            this.f7304g.a((c.a.a.a.b<String>) bVar, this.f7301d, this.f7302e);
        }
    }

    @Override // c.a.a.a.c
    public void a(AdobeAssetException adobeAssetException) {
        c.a.a.a.c cVar = this.f7303f;
        if (cVar != null) {
            this.f7304g.a((c.a.a.a.c<AdobeLibraryException>) cVar, this.f7301d, com.adobe.creativesdk.foundation.adobeinternal.storage.library.ia.a(AdobeLibraryErrorCode.AdobeLibraryErrorDownloadingRenditionFile, adobeAssetException, this.f7302e, null));
        }
    }
}
