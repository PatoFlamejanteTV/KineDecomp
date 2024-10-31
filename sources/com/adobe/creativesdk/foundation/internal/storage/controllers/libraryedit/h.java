package com.adobe.creativesdk.foundation.internal.storage.controllers.libraryedit;

import com.adobe.creativesdk.foundation.adobeinternal.storage.library.F;
import com.adobe.creativesdk.foundation.internal.collaboration.AdobeCollaborationException;
import com.adobe.creativesdk.foundation.internal.storage.controllers.C0358a;
import com.adobe.creativesdk.foundation.internal.storage.controllers.commands.AdobeAssetViewBrowserCommandName;
import com.adobe.creativesdk.foundation.internal.storage.controllers.libraryedit.l;
import com.adobe.creativesdk.foundation.storage.C0614ub;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AdobeDesignLibraryEditSession.java */
/* loaded from: classes.dex */
public class h implements com.adobe.creativesdk.foundation.internal.collaboration.a.c {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ C0614ub f6218a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ l f6219b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(l lVar, C0614ub c0614ub) {
        this.f6219b = lVar;
        this.f6218a = c0614ub;
    }

    @Override // com.adobe.creativesdk.foundation.internal.collaboration.a.a
    public void a(AdobeCollaborationException adobeCollaborationException) {
        l.a aVar;
        aVar = this.f6219b.k;
        aVar.a(false);
        a.a(false);
        this.f6219b.f6227b.onComplete();
    }

    @Override // com.adobe.creativesdk.foundation.internal.collaboration.a.c
    public void onComplete() {
        l.a aVar;
        ((F) this.f6218a).y();
        aVar = this.f6219b.k;
        aVar.a(true);
        a.a(false);
        this.f6219b.f6227b.onComplete();
        C0358a.a().a(AdobeAssetViewBrowserCommandName.ACTION_LIBRARY_COLLECTION_REFRESH_DUE_TO_SHARE_MODIFY, (Object) null);
    }
}
