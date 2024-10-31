package com.adobe.creativesdk.foundation.internal.storage.controllers;

import android.content.Context;
import android.widget.Toast;
import com.adobe.creativesdk.foundation.internal.collaboration.AdobeCollaborationException;

/* compiled from: CCFilesWithUploadFragment.java */
/* loaded from: classes.dex */
class Wb implements com.adobe.creativesdk.foundation.internal.collaboration.a.c {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Context f5882a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ Yb f5883b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Wb(Yb yb, Context context) {
        this.f5883b = yb;
        this.f5882a = context;
    }

    @Override // com.adobe.creativesdk.foundation.internal.collaboration.a.a
    public void a(AdobeCollaborationException adobeCollaborationException) {
        Toast.makeText(this.f5882a, c.a.a.a.b.i.IDS_COLLABORATOR_LEAVE_FOLDER_FAILURE_MESSAGE, 1).show();
    }

    @Override // com.adobe.creativesdk.foundation.internal.collaboration.a.c
    public void onComplete() {
        this.f5883b.f5895b.ga();
        this.f5883b.f5895b.e(true);
        Yb yb = this.f5883b;
        if (yb.f5894a) {
            yb.f5895b.getFragmentManager().popBackStack();
        }
        Toast.makeText(this.f5882a, c.a.a.a.b.i.IDS_COLLABORATOR_LEAVE_FOLDER_SUCCESS_MESSAGE, 1).show();
    }
}
