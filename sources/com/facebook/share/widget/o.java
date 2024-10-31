package com.facebook.share.widget;

import android.view.View;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ShareButtonBase.java */
/* loaded from: classes.dex */
public class o implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ShareButtonBase f9644a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(ShareButtonBase shareButtonBase) {
        this.f9644a = shareButtonBase;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f9644a.callExternalOnClickListener(view);
        this.f9644a.getDialog().show(this.f9644a.getShareContent());
    }
}
