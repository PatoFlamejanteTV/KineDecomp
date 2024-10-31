package com.facebook.internal;

import android.view.View;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: WebDialog.java */
/* loaded from: classes.dex */
public class ag implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ WebDialog f285a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ag(WebDialog webDialog) {
        this.f285a = webDialog;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f285a.cancel();
    }
}
