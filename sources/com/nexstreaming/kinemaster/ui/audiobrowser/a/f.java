package com.nexstreaming.kinemaster.ui.audiobrowser.a;

import com.nexstreaming.kinemaster.ui.audiobrowser.s;
import java.text.Collator;
import java.util.Comparator;

/* compiled from: AssetsLister.java */
/* loaded from: classes.dex */
class f implements Comparator<s> {

    /* renamed from: a */
    final /* synthetic */ g f21419a;

    public f(g gVar) {
        this.f21419a = gVar;
    }

    @Override // java.util.Comparator
    /* renamed from: a */
    public int compare(s sVar, s sVar2) {
        return Collator.getInstance().compare(sVar.a(), sVar2.a());
    }
}
