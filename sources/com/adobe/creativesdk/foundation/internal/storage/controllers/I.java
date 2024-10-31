package com.adobe.creativesdk.foundation.internal.storage.controllers;

import android.view.View;

/* compiled from: AdobeRemoveMyselfDialogFragment.java */
/* loaded from: classes.dex */
class I implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ J f5663a;

    public I(J j) {
        this.f5663a = j;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Zc zc;
        Zc zc2;
        zc = this.f5663a.f5682g;
        if (zc != null) {
            zc2 = this.f5663a.f5682g;
            zc2.a();
        }
        this.f5663a.dismiss();
    }
}
