package com.facebook.internal;

import android.view.View;

/* compiled from: WebDialog.java */
/* loaded from: classes.dex */
public class G implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ WebDialog f9284a;

    public G(WebDialog webDialog) {
        this.f9284a = webDialog;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f9284a.cancel();
    }
}
