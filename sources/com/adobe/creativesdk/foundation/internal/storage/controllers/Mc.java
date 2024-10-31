package com.adobe.creativesdk.foundation.internal.storage.controllers;

import android.os.Bundle;
import com.adobe.creativesdk.foundation.internal.storage.controllers.Jc;
import com.adobe.creativesdk.foundation.internal.storage.controllers.commands.AdobeAssetViewBrowserCommandName;

/* compiled from: DesignLibraryItemsFragment.java */
/* loaded from: classes.dex */
class Mc implements com.adobe.creativesdk.foundation.internal.storage.controllers.libraryedit.x {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Jc.g f5725a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Mc(Jc.g gVar) {
        this.f5725a = gVar;
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.libraryedit.x
    public void onComplete() {
        Bundle bundle = new Bundle();
        bundle.putString("LIBRARY_COMP_ID", Jc.this.T.k());
        C0358a.a().a(AdobeAssetViewBrowserCommandName.ACTION_LIBRARY_COMP_EDIT_COMPLTED, bundle);
    }
}
