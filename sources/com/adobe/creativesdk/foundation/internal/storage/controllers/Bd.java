package com.adobe.creativesdk.foundation.internal.storage.controllers;

import android.view.View;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: PhotosAssetsFragment.java */
/* loaded from: classes.dex */
public class Bd implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Fd f5596a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Bd(Fd fd) {
        this.f5596a = fd;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        View view2;
        view2 = this.f5596a.Z;
        view2.setVisibility(4);
        this.f5596a.W.d();
    }
}
