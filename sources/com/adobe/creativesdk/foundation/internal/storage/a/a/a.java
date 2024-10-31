package com.adobe.creativesdk.foundation.internal.storage.a.a;

import c.a.a.a.c;
import com.adobe.creativesdk.foundation.internal.net.F;
import com.adobe.creativesdk.foundation.internal.net.l;
import com.adobe.creativesdk.foundation.network.AdobeNetworkException;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AdobeLibraryXferUtils.java */
/* loaded from: classes.dex */
public class a implements F {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ c.a.a.a.b f5280a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ c f5281b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ b f5282c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(b bVar, c.a.a.a.b bVar2, c cVar) {
        this.f5282c = bVar;
        this.f5280a = bVar2;
        this.f5281b = cVar;
    }

    @Override // com.adobe.creativesdk.foundation.internal.net.F
    public void a(l lVar) {
        if (lVar.g() == 200) {
            this.f5280a.b(null);
        }
    }

    @Override // com.adobe.creativesdk.foundation.internal.net.F
    public void a(AdobeNetworkException adobeNetworkException) {
        this.f5281b.a(adobeNetworkException);
    }
}
