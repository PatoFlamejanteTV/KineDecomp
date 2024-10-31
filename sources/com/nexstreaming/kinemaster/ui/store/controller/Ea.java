package com.nexstreaming.kinemaster.ui.store.controller;

import android.view.View;

/* compiled from: AssetDetailPreviewImageListFragment.java */
/* loaded from: classes2.dex */
class Ea implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Fa f23432a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Ea(Fa fa) {
        this.f23432a = fa;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f23432a.getFragmentManager().popBackStackImmediate();
    }
}
