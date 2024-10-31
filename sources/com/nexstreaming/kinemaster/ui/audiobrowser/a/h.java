package com.nexstreaming.kinemaster.ui.audiobrowser.a;

import com.nexstreaming.kinemaster.ui.audiobrowser.s;
import java.text.Collator;
import java.util.Comparator;

/* compiled from: FolderLister.java */
/* loaded from: classes.dex */
class h implements Comparator<s> {

    /* renamed from: a */
    final /* synthetic */ i f21424a;

    public h(i iVar) {
        this.f21424a = iVar;
    }

    @Override // java.util.Comparator
    /* renamed from: a */
    public int compare(s sVar, s sVar2) {
        return Collator.getInstance().compare(sVar.a(), sVar2.a());
    }
}
