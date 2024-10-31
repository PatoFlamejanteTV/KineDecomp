package com.nextreaming.nexeditorui.fontbrowser;

import android.content.DialogInterface;

/* compiled from: FontListAdapter.java */
/* loaded from: classes.dex */
class x implements DialogInterface.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ com.nexstreaming.kinemaster.ui.a.a f4648a;
    final /* synthetic */ u b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(u uVar, com.nexstreaming.kinemaster.ui.a.a aVar) {
        this.b = uVar;
        this.f4648a = aVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.f4648a.dismiss();
    }
}
