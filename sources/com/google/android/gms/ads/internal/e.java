package com.google.android.gms.ads.internal;

import android.view.View;

/* loaded from: classes.dex */
class e implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ zze f561a;
    final /* synthetic */ c b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(c cVar, zze zzeVar) {
        this.b = cVar;
        this.f561a = zzeVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f561a.a();
    }
}
