package com.adobe.creativesdk.foundation.internal.storage.controllers.libraryedit;

import com.adobe.creativesdk.foundation.internal.storage.controllers.libraryedit.l;
import com.adobe.creativesdk.foundation.storage.AdobeLibraryException;
import com.adobe.creativesdk.foundation.storage.C0614ub;
import com.adobe.creativesdk.foundation.storage.C0622wb;
import com.adobe.creativesdk.foundation.storage.vd;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AdobeDesignLibraryEditSession.java */
/* loaded from: classes.dex */
public class j implements vd {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ boolean f6221a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ C0614ub f6222b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ C0622wb f6223c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ l f6224d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(l lVar, boolean z, C0614ub c0614ub, C0622wb c0622wb) {
        this.f6224d = lVar;
        this.f6221a = z;
        this.f6222b = c0614ub;
        this.f6223c = c0622wb;
    }

    @Override // com.adobe.creativesdk.foundation.storage.vd
    public void a() {
        l.a aVar;
        l.a aVar2;
        l.a aVar3;
        aVar = this.f6224d.k;
        aVar.a(true);
        if (!this.f6221a) {
            try {
                this.f6222b.e(this.f6223c);
                aVar3 = this.f6224d.k;
                aVar3.a(true);
            } catch (AdobeLibraryException unused) {
                aVar2 = this.f6224d.k;
                aVar2.a(false);
            }
        }
        a.a(false);
        this.f6224d.f6227b.onComplete();
    }
}
