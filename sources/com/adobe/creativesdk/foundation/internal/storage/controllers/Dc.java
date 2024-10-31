package com.adobe.creativesdk.foundation.internal.storage.controllers;

import android.view.View;
import com.adobe.creativesdk.foundation.internal.storage.controllers.commands.AdobeAssetViewBrowserCommandName;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DesignLibraryItemsFragment.java */
/* loaded from: classes.dex */
public class Dc implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Jc f5627a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Dc(Jc jc) {
        this.f5627a = jc;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Jc jc = this.f5627a;
        jc.a(AdobeAssetViewBrowserCommandName.ACTION_LIBRARY_UPLOAD_FILES_FROM_CAMERA, jc.U);
        this.f5627a.ia.setVisibility(4);
        this.f5627a.fa.d();
    }
}
