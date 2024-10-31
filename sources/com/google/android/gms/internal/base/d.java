package com.google.android.gms.internal.base;

import android.graphics.drawable.Drawable;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class d extends Drawable.ConstantState {

    /* renamed from: a */
    int f12760a;

    /* renamed from: b */
    int f12761b;

    public d(d dVar) {
        if (dVar != null) {
            this.f12760a = dVar.f12760a;
            this.f12761b = dVar.f12761b;
        }
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public final int getChangingConfigurations() {
        return this.f12760a;
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public final Drawable newDrawable() {
        return new zae(this);
    }
}
