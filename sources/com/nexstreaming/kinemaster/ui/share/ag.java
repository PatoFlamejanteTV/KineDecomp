package com.nexstreaming.kinemaster.ui.share;

import android.content.DialogInterface;

/* compiled from: ShareBaseActivity.java */
/* loaded from: classes.dex */
class ag implements DialogInterface.OnCancelListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ af f4291a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ag(af afVar) {
        this.f4291a = afVar;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        this.f4291a.f4290a.g();
    }
}
