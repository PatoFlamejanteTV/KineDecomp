package com.google.android.gms.common.api.internal;

import android.app.Dialog;

/* loaded from: classes.dex */
final class S extends zabr {

    /* renamed from: a */
    private final /* synthetic */ Dialog f10797a;

    /* renamed from: b */
    private final /* synthetic */ Q f10798b;

    public S(Q q, Dialog dialog) {
        this.f10798b = q;
        this.f10797a = dialog;
    }

    @Override // com.google.android.gms.common.api.internal.zabr
    public final void a() {
        this.f10798b.f10790b.g();
        if (this.f10797a.isShowing()) {
            this.f10797a.dismiss();
        }
    }
}
