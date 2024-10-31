package com.nexstreaming.kinemaster.ui.audiobrowser.a;

import com.nexstreaming.kinemaster.ui.audiobrowser.u;
import java.text.Collator;
import java.util.Comparator;

/* compiled from: AssetsLister.java */
/* loaded from: classes.dex */
class e implements Comparator<u> {

    /* renamed from: a */
    final /* synthetic */ g f21418a;

    public e(g gVar) {
        this.f21418a = gVar;
    }

    @Override // java.util.Comparator
    /* renamed from: a */
    public int compare(u uVar, u uVar2) {
        return Collator.getInstance().compare(uVar.b(), uVar2.b());
    }
}
