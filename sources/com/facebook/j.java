package com.facebook;

import android.view.View;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: FacebookButtonBase.java */
/* loaded from: classes.dex */
public class j implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ FacebookButtonBase f303a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(FacebookButtonBase facebookButtonBase) {
        this.f303a = facebookButtonBase;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        View.OnClickListener onClickListener;
        View.OnClickListener onClickListener2;
        View.OnClickListener onClickListener3;
        View.OnClickListener onClickListener4;
        this.f303a.logButtonTapped(this.f303a.getContext());
        onClickListener = this.f303a.internalOnClickListener;
        if (onClickListener != null) {
            onClickListener4 = this.f303a.internalOnClickListener;
            onClickListener4.onClick(view);
            return;
        }
        onClickListener2 = this.f303a.externalOnClickListener;
        if (onClickListener2 != null) {
            onClickListener3 = this.f303a.externalOnClickListener;
            onClickListener3.onClick(view);
        }
    }
}
