package com.nexstreaming.kinemaster.mediastore.provider;

import java.util.Comparator;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AndroidMediaStoreProvider.java */
/* loaded from: classes.dex */
public class n implements Comparator<com.nexstreaming.kinemaster.mediastore.item.c> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ int f21001a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ AndroidMediaStoreProvider f21002b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(AndroidMediaStoreProvider androidMediaStoreProvider, int i) {
        this.f21002b = androidMediaStoreProvider;
        this.f21001a = i;
    }

    @Override // java.util.Comparator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compare(com.nexstreaming.kinemaster.mediastore.item.c cVar, com.nexstreaming.kinemaster.mediastore.item.c cVar2) {
        return this.f21001a * cVar.c().compareTo(cVar2.c());
    }
}
