package com.nexstreaming.kinemaster.ui.e;

import android.view.View;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: PermissionRationaleFragment.kt */
/* loaded from: classes.dex */
public final class f implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ c f21579a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(c cVar) {
        this.f21579a = cVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (this.f21579a.getActivity() == null) {
            return;
        }
        this.f21579a.f21576h = 0;
        this.f21579a.A();
    }
}
