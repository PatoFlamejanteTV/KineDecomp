package com.nexstreaming.kinemaster.mediastore.provider;

import java.util.Comparator;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AndroidMediaStoreProvider.java */
/* loaded from: classes.dex */
public class o implements Comparator<com.nexstreaming.kinemaster.mediastore.item.c> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ int f21003a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ AndroidMediaStoreProvider f21004b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(AndroidMediaStoreProvider androidMediaStoreProvider, int i) {
        this.f21004b = androidMediaStoreProvider;
        this.f21003a = i;
    }

    @Override // java.util.Comparator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compare(com.nexstreaming.kinemaster.mediastore.item.c cVar, com.nexstreaming.kinemaster.mediastore.item.c cVar2) {
        return this.f21003a * cVar.d().compareTo(cVar2.d());
    }
}
