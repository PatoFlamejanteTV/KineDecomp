package com.facebook.share.widget;

import android.view.View;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ShareButtonBase.java */
/* loaded from: classes.dex */
public class n implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ShareButtonBase f408a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(ShareButtonBase shareButtonBase) {
        this.f408a = shareButtonBase;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f408a.callExternalOnClickListener(view);
        this.f408a.getDialog().show(this.f408a.getShareContent());
    }
}
