package com.adobe.creativesdk.foundation.internal.storage.controllers;

import android.view.View;

/* compiled from: AdobeRemoveMyselfDialogFragment.java */
/* loaded from: classes.dex */
class H implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ J f5655a;

    public H(J j) {
        this.f5655a = j;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Zc zc;
        Zc zc2;
        zc = this.f5655a.f5682g;
        if (zc != null) {
            zc2 = this.f5655a.f5682g;
            zc2.b();
        }
        this.f5655a.dismiss();
    }
}
