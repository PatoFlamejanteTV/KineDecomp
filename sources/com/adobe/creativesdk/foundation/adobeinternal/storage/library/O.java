package com.adobe.creativesdk.foundation.adobeinternal.storage.library;

import com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.vb;
import com.adobe.creativesdk.foundation.internal.utils.AdobeCSDKException;
import com.adobe.creativesdk.foundation.storage.C0614ub;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AdobeLibrarySyncManager.java */
/* loaded from: classes.dex */
public class O implements vb {

    /* renamed from: a, reason: collision with root package name */
    boolean f4531a = true;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ C0614ub f4532b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ c.a.a.a.b f4533c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ c.a.a.a.c f4534d;

    /* renamed from: e, reason: collision with root package name */
    final /* synthetic */ ha f4535e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public O(ha haVar, C0614ub c0614ub, c.a.a.a.b bVar, c.a.a.a.c cVar) {
        this.f4535e = haVar;
        this.f4532b = c0614ub;
        this.f4533c = bVar;
        this.f4534d = cVar;
    }

    @Override // com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.vb
    public void a(com.adobe.creativesdk.foundation.internal.storage.model.resources.f fVar, AdobeCSDKException adobeCSDKException) {
        if (fVar != null && adobeCSDKException == null) {
            if (fVar.f6613e.equals(((F) this.f4532b).i().p().d())) {
                this.f4531a = false;
            }
            this.f4533c.b(Boolean.valueOf(this.f4531a));
            return;
        }
        this.f4534d.a(adobeCSDKException);
    }
}
