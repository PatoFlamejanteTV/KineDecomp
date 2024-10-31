package com.nexstreaming.kinemaster.ui.a;

import android.view.View;
import com.nexstreaming.kinemaster.ui.a.k;

/* compiled from: NexDialogFragment.java */
/* loaded from: classes.dex */
class i implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ e f21337a;

    /* renamed from: b */
    final /* synthetic */ k f21338b;

    public i(k kVar, e eVar) {
        this.f21338b = kVar;
        this.f21337a = eVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        k.b bVar;
        k.b bVar2;
        k kVar;
        bVar = this.f21338b.f21344b;
        if (bVar != null) {
            bVar2 = this.f21338b.f21344b;
            e eVar = this.f21337a;
            kVar = this.f21338b.f21343a;
            bVar2.onDialogCanceled(eVar, kVar);
        }
    }
}
