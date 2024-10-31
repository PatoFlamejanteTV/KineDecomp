package com.google.android.gms.internal;

import android.app.Dialog;
import com.google.android.gms.internal.zzlp;

/* loaded from: classes.dex */
class fz extends fy {
    final /* synthetic */ Dialog b;
    final /* synthetic */ zzlp.b c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public fz(zzlp.b bVar, Dialog dialog) {
        this.c = bVar;
        this.b = dialog;
    }

    @Override // com.google.android.gms.internal.fy
    protected void a() {
        zzlp.this.zzok();
        this.b.dismiss();
    }
}
