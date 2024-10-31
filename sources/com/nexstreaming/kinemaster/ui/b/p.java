package com.nexstreaming.kinemaster.ui.b;

import android.view.View;

/* compiled from: MiniFxGroupBrowserFragment.java */
/* loaded from: classes.dex */
class p implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ o f3703a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(o oVar) {
        this.f3703a = oVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f3703a.getFragmentManager().popBackStackImmediate();
    }
}
