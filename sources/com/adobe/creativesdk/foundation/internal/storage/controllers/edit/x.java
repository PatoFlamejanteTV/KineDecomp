package com.adobe.creativesdk.foundation.internal.storage.controllers.edit;

import android.view.View;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: CCFilesEditFragment.java */
/* loaded from: classes.dex */
public class x implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ B f6081a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(B b2) {
        this.f6081a = b2;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f6081a.Ra.dismiss();
    }
}
