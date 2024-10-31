package com.nexstreaming.kinemaster.ui.e;

import android.view.View;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: PermissionRationaleFragment.kt */
/* loaded from: classes.dex */
public final class d implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ c f21577a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar) {
        this.f21577a = cVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        int i;
        c cVar = this.f21577a;
        String[] b2 = c.b(cVar);
        i = this.f21577a.f21572d;
        b.a(cVar, b2, i);
    }
}
