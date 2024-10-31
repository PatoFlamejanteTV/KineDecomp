package com.nexstreaming.kinemaster.ui.a;

import android.content.DialogInterface;
import android.view.KeyEvent;
import com.nexstreaming.kinemaster.ui.a.k;

/* compiled from: NexDialogFragment.java */
/* loaded from: classes.dex */
class f implements DialogInterface.OnKeyListener {

    /* renamed from: a */
    final /* synthetic */ k f21332a;

    public f(k kVar) {
        this.f21332a = kVar;
    }

    @Override // android.content.DialogInterface.OnKeyListener
    public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
        k.b bVar;
        k.b bVar2;
        k kVar;
        if (i != 4) {
            return false;
        }
        bVar = this.f21332a.f21344b;
        if (bVar == null || !this.f21332a.isCancelable()) {
            return false;
        }
        bVar2 = this.f21332a.f21344b;
        kVar = this.f21332a.f21343a;
        bVar2.onDialogCanceled(dialogInterface, kVar);
        return true;
    }
}
