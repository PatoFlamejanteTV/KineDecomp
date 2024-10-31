package com.adobe.creativesdk.foundation.internal.storage.controllers;

import android.content.Context;
import android.widget.Toast;
import com.adobe.creativesdk.foundation.internal.collaboration.AdobeCollaborationException;
import com.adobe.creativesdk.foundation.internal.storage.controllers.commands.AdobeAssetViewBrowserCommandName;

/* compiled from: CCFilesWithUploadFragment.java */
/* loaded from: classes.dex */
class Zb implements com.adobe.creativesdk.foundation.internal.collaboration.a.c {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Context f5898a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ _b f5899b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Zb(_b _bVar, Context context) {
        this.f5899b = _bVar;
        this.f5898a = context;
    }

    @Override // com.adobe.creativesdk.foundation.internal.collaboration.a.a
    public void a(AdobeCollaborationException adobeCollaborationException) {
        Toast.makeText(this.f5898a, c.a.a.a.b.i.IDS_COLLABORATOR_LEAVE_FOLDER_FAILURE_MESSAGE, 1).show();
    }

    @Override // com.adobe.creativesdk.foundation.internal.collaboration.a.c
    public void onComplete() {
        this.f5899b.f5903c.ga();
        this.f5899b.f5903c.e(true);
        _b _bVar = this.f5899b;
        if (_bVar.f5902b) {
            _bVar.f5903c.getFragmentManager().popBackStack();
        }
        C0358a.a().a(AdobeAssetViewBrowserCommandName.ASSETVIEW_BROWSER_CCFILES_FORCE_REFRESH_LIST);
        Toast.makeText(this.f5898a, c.a.a.a.b.i.IDS_COLLABORATOR_LEAVE_FOLDER_SUCCESS_MESSAGE, 1).show();
    }
}
