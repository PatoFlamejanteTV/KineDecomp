package com.adobe.creativesdk.foundation.internal.storage.controllers;

import android.app.ProgressDialog;
import com.adobe.creativesdk.foundation.internal.storage.controllers.Jc;

/* compiled from: DesignLibraryItemsFragment.java */
/* loaded from: classes.dex */
class Nc implements com.adobe.creativesdk.foundation.internal.storage.controllers.edit.I {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Jc.g f5737a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Nc(Jc.g gVar) {
        this.f5737a = gVar;
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.edit.I
    public void a() {
        ProgressDialog progressDialog;
        ProgressDialog progressDialog2;
        progressDialog = Jc.this.ea;
        if (progressDialog != null) {
            progressDialog2 = Jc.this.ea;
            progressDialog2.dismiss();
        }
    }
}
