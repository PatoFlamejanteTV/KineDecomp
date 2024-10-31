package com.google.android.gms.internal;

import android.view.View;

/* loaded from: classes.dex */
class cg implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ zzfc f1473a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cg(zzfc zzfcVar) {
        this.f1473a = zzfcVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f1473a.zzn(true);
    }
}
