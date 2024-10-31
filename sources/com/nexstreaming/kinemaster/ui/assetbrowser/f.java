package com.nexstreaming.kinemaster.ui.assetbrowser;

import android.content.DialogInterface;

/* compiled from: AssetBrowserBaseFragment.java */
/* loaded from: classes.dex */
class f implements DialogInterface.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ h f21378a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(h hVar) {
        this.f21378a = hVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
    }
}
