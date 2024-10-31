package com.facebook;

import android.view.View;

/* compiled from: FacebookButtonBase.java */
/* loaded from: classes.dex */
public class k implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ FacebookButtonBase f9345a;

    public k(FacebookButtonBase facebookButtonBase) {
        this.f9345a = facebookButtonBase;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        View.OnClickListener onClickListener;
        View.OnClickListener onClickListener2;
        View.OnClickListener onClickListener3;
        View.OnClickListener onClickListener4;
        FacebookButtonBase facebookButtonBase = this.f9345a;
        facebookButtonBase.logButtonTapped(facebookButtonBase.getContext());
        onClickListener = this.f9345a.internalOnClickListener;
        if (onClickListener != null) {
            onClickListener4 = this.f9345a.internalOnClickListener;
            onClickListener4.onClick(view);
            return;
        }
        onClickListener2 = this.f9345a.externalOnClickListener;
        if (onClickListener2 != null) {
            onClickListener3 = this.f9345a.externalOnClickListener;
            onClickListener3.onClick(view);
        }
    }
}
