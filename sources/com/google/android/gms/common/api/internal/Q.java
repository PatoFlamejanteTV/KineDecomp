package com.google.android.gms.common.api.internal;

import android.app.Dialog;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.api.GoogleApiActivity;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class Q implements Runnable {

    /* renamed from: a */
    private final P f10789a;

    /* renamed from: b */
    final /* synthetic */ zal f10790b;

    public Q(zal zalVar, P p) {
        this.f10790b = zalVar;
        this.f10789a = p;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.f10790b.f10949b) {
            ConnectionResult a2 = this.f10789a.a();
            if (a2.Q()) {
                zal zalVar = this.f10790b;
                zalVar.f10774a.startActivityForResult(GoogleApiActivity.a(zalVar.a(), a2.P(), this.f10789a.b(), false), 1);
            } else if (this.f10790b.f10952e.c(a2.a())) {
                zal zalVar2 = this.f10790b;
                zalVar2.f10952e.a(zalVar2.a(), this.f10790b.f10774a, a2.a(), 2, this.f10790b);
            } else {
                if (a2.a() == 18) {
                    Dialog a3 = GoogleApiAvailability.a(this.f10790b.a(), this.f10790b);
                    zal zalVar3 = this.f10790b;
                    zalVar3.f10952e.a(zalVar3.a().getApplicationContext(), new S(this, a3));
                    return;
                }
                this.f10790b.a(a2, this.f10789a.b());
            }
        }
    }
}
