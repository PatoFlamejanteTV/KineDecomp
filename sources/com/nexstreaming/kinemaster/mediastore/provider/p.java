package com.nexstreaming.kinemaster.mediastore.provider;

import java.util.Comparator;

/* compiled from: AndroidMediaStoreProvider.java */
/* loaded from: classes.dex */
class p implements Comparator<com.nexstreaming.kinemaster.mediastore.item.c> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ int f21005a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ AndroidMediaStoreProvider f21006b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(AndroidMediaStoreProvider androidMediaStoreProvider, int i) {
        this.f21006b = androidMediaStoreProvider;
        this.f21005a = i;
    }

    @Override // java.util.Comparator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compare(com.nexstreaming.kinemaster.mediastore.item.c cVar, com.nexstreaming.kinemaster.mediastore.item.c cVar2) {
        return this.f21005a * cVar.d().compareTo(cVar2.d());
    }
}
