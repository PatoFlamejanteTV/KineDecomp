package com.google.android.gms.common;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import com.google.android.gms.common.internal.zzaa;
import com.google.android.gms.common.internal.zzab;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.dynamic.zzg;

/* loaded from: classes.dex */
public final class SignInButton extends FrameLayout implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    private int f864a;
    private int b;
    private View c;
    private View.OnClickListener d;

    private static Button a(Context context, int i, int i2) {
        zzab zzabVar = new zzab(context);
        zzabVar.a(context.getResources(), i, i2);
        return zzabVar;
    }

    private void a(Context context) {
        if (this.c != null) {
            removeView(this.c);
        }
        try {
            this.c = zzaa.a(context, this.f864a, this.b);
        } catch (zzg.zza e) {
            Log.w("SignInButton", "Sign in button not found, using placeholder instead");
            this.c = a(context, this.f864a, this.b);
        }
        addView(this.c);
        this.c.setEnabled(isEnabled());
        this.c.setOnClickListener(this);
    }

    public void a(int i, int i2) {
        zzx.a(i >= 0 && i < 3, "Unknown button size %d", Integer.valueOf(i));
        zzx.a(i2 >= 0 && i2 < 2, "Unknown color scheme %s", Integer.valueOf(i2));
        this.f864a = i;
        this.b = i2;
        a(getContext());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.d == null || view != this.c) {
            return;
        }
        this.d.onClick(this);
    }

    public void setColorScheme(int i) {
        a(this.f864a, i);
    }

    @Override // android.view.View
    public void setEnabled(boolean z) {
        super.setEnabled(z);
        this.c.setEnabled(z);
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.d = onClickListener;
        if (this.c != null) {
            this.c.setOnClickListener(this);
        }
    }

    public void setSize(int i) {
        a(i, this.b);
    }
}
