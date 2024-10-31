package com.adobe.creativesdk.foundation.internal.storage.controllers.libraryedit;

import android.os.Bundle;
import com.adobe.creativesdk.foundation.internal.storage.controllers.C0358a;
import com.adobe.creativesdk.foundation.internal.storage.controllers.commands.AdobeAssetViewBrowserCommandName;
import com.adobe.creativesdk.foundation.storage.C0614ub;

/* compiled from: AdobeLibraryDeleteAlert.java */
/* loaded from: classes.dex */
class r implements x {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ s f6243a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(s sVar) {
        this.f6243a = sVar;
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.libraryedit.x
    public void onComplete() {
        C0614ub c0614ub;
        Bundle bundle = new Bundle();
        c0614ub = this.f6243a.f6244a.f6249e;
        bundle.putString("LIBRARY_COMP_ID", c0614ub.k());
        C0358a.a().a(AdobeAssetViewBrowserCommandName.ACTION_LIBRARY_COMP_EDIT_COMPLTED, bundle);
    }
}
