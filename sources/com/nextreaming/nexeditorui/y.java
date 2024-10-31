package com.nextreaming.nexeditorui;

import android.content.DialogInterface;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: KineMasterBaseActivity.kt */
/* loaded from: classes.dex */
public final class Y implements DialogInterface.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ I f24191a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ int f24192b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Y(I i, int i2) {
        this.f24191a = i;
        this.f24192b = i2;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
        this.f24191a.c(this.f24192b);
    }
}
