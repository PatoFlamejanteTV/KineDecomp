package com.google.android.gms.common;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.SignInButtonCreator;
import com.google.android.gms.common.internal.SignInButtonImpl;
import com.google.android.gms.dynamic.RemoteCreator;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: classes.dex */
public final class SignInButton extends FrameLayout implements View.OnClickListener {

    /* renamed from: a */
    private int f10667a;

    /* renamed from: b */
    private int f10668b;

    /* renamed from: c */
    private View f10669c;

    /* renamed from: d */
    private View.OnClickListener f10670d;

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes.dex */
    public @interface ButtonSize {
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes.dex */
    public @interface ColorScheme {
    }

    public final void a(int i, int i2) {
        this.f10667a = i;
        this.f10668b = i2;
        Context context = getContext();
        View view = this.f10669c;
        if (view != null) {
            removeView(view);
        }
        try {
            this.f10669c = SignInButtonCreator.a(context, this.f10667a, this.f10668b);
        } catch (RemoteCreator.RemoteCreatorException unused) {
            Log.w("SignInButton", "Sign in button not found, using placeholder instead");
            int i3 = this.f10667a;
            int i4 = this.f10668b;
            SignInButtonImpl signInButtonImpl = new SignInButtonImpl(context);
            signInButtonImpl.a(context.getResources(), i3, i4);
            this.f10669c = signInButtonImpl;
        }
        addView(this.f10669c);
        this.f10669c.setEnabled(isEnabled());
        this.f10669c.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        View.OnClickListener onClickListener = this.f10670d;
        if (onClickListener == null || view != this.f10669c) {
            return;
        }
        onClickListener.onClick(this);
    }

    public final void setColorScheme(int i) {
        a(this.f10667a, i);
    }

    @Override // android.view.View
    public final void setEnabled(boolean z) {
        super.setEnabled(z);
        this.f10669c.setEnabled(z);
    }

    @Override // android.view.View
    public final void setOnClickListener(View.OnClickListener onClickListener) {
        this.f10670d = onClickListener;
        View view = this.f10669c;
        if (view != null) {
            view.setOnClickListener(this);
        }
    }

    @Deprecated
    public final void setScopes(Scope[] scopeArr) {
        a(this.f10667a, this.f10668b);
    }

    public final void setSize(int i) {
        a(i, this.f10668b);
    }
}
