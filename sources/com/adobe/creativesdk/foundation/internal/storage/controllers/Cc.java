package com.adobe.creativesdk.foundation.internal.storage.controllers;

import android.support.v4.content.ContextCompat;
import android.view.View;
import com.adobe.creativesdk.foundation.internal.storage.controllers.commands.AdobeAssetViewBrowserCommandName;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DesignLibraryItemsFragment.java */
/* loaded from: classes.dex */
public class Cc implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Jc f5607a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Cc(Jc jc) {
        this.f5607a = jc;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z;
        if (this.f5607a.T != null && this.f5607a.U != null) {
            z = this.f5607a.X;
            if (!z) {
                if (ContextCompat.checkSelfPermission(this.f5607a.getActivity(), "android.permission.READ_EXTERNAL_STORAGE") != 0) {
                    this.f5607a.Z = true;
                    this.f5607a.getParentFragment().requestPermissions(new String[]{"android.permission.READ_EXTERNAL_STORAGE"}, 1);
                } else {
                    Jc jc = this.f5607a;
                    jc.a(AdobeAssetViewBrowserCommandName.ACTION_LIBRARY_UPLOAD_FILES, jc.U);
                }
            } else {
                Jc jc2 = this.f5607a;
                jc2.a(AdobeAssetViewBrowserCommandName.ACTION_CANCEL_LIBRARY_UPLOAD, jc2.U);
            }
        }
        this.f5607a.ia.setVisibility(4);
        this.f5607a.fa.d();
    }
}
