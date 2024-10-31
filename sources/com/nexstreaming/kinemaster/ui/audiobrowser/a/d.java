package com.nexstreaming.kinemaster.ui.audiobrowser.a;

import java.text.Collator;
import java.util.Comparator;

/* compiled from: FolderLister.java */
/* loaded from: classes.dex */
class d implements Comparator<com.nexstreaming.kinemaster.ui.audiobrowser.l> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ c f3660a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar) {
        this.f3660a = cVar;
    }

    @Override // java.util.Comparator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compare(com.nexstreaming.kinemaster.ui.audiobrowser.l lVar, com.nexstreaming.kinemaster.ui.audiobrowser.l lVar2) {
        return Collator.getInstance().compare(lVar.a(), lVar2.a());
    }
}
