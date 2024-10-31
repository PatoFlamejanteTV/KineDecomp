package com.nexstreaming.kinemaster.ui.a;

import android.view.View;
import com.nexstreaming.kinemaster.ui.a.k;

/* compiled from: NexDialogFragment.java */
/* loaded from: classes.dex */
class h implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ e f21335a;

    /* renamed from: b */
    final /* synthetic */ k f21336b;

    public h(k kVar, e eVar) {
        this.f21336b = kVar;
        this.f21335a = eVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        k.b bVar;
        k.b bVar2;
        k kVar;
        bVar = this.f21336b.f21344b;
        if (bVar != null) {
            bVar2 = this.f21336b.f21344b;
            e eVar = this.f21335a;
            kVar = this.f21336b.f21343a;
            bVar2.onDialogOk(eVar, kVar);
        }
    }
}
