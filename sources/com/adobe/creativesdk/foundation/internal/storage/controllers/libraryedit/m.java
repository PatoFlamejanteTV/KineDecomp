package com.adobe.creativesdk.foundation.internal.storage.controllers.libraryedit;

import android.os.Bundle;
import com.adobe.creativesdk.foundation.internal.storage.controllers.C0358a;
import com.adobe.creativesdk.foundation.internal.storage.controllers.commands.AdobeAssetViewBrowserCommandName;

/* compiled from: AdobeDesignLibraryMoveActivity.java */
/* loaded from: classes.dex */
class m implements x {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ AdobeDesignLibraryMoveActivity f6237a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(AdobeDesignLibraryMoveActivity adobeDesignLibraryMoveActivity) {
        this.f6237a = adobeDesignLibraryMoveActivity;
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.libraryedit.x
    public void onComplete() {
        Bundle bundle = new Bundle();
        bundle.putString("LIBRARY_ELEMENT_TYPE", n.b().a().get(0).b().j());
        C0358a.a().a(AdobeAssetViewBrowserCommandName.ACTION_LIBRARY_ITEM_EDIT_COMPLETED, bundle);
    }
}
