package com.adobe.creativesdk.foundation.internal.storage.controllers;

import android.view.View;

/* compiled from: DesignLibraryItemsFragment.java */
/* loaded from: classes.dex */
class Bc implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Jc f5595a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Bc(Jc jc) {
        this.f5595a = jc;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f5595a.ia.setVisibility(4);
        this.f5595a.fa.d();
    }
}
