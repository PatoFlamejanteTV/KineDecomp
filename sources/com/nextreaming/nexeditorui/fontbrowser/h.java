package com.nextreaming.nexeditorui.fontbrowser;

import android.content.DialogInterface;

/* compiled from: FontBrowserActivity.java */
/* loaded from: classes.dex */
class h implements DialogInterface.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ com.nexstreaming.kinemaster.ui.a.a f4632a;
    final /* synthetic */ e b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(e eVar, com.nexstreaming.kinemaster.ui.a.a aVar) {
        this.b = eVar;
        this.f4632a = aVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.f4632a.dismiss();
    }
}
