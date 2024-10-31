package com.nexstreaming.kinemaster.mediastore.provider;

import java.util.Comparator;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AndroidMediaStoreProvider.java */
/* loaded from: classes.dex */
public class m implements Comparator<com.nexstreaming.kinemaster.mediastore.item.c> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ int f20999a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ AndroidMediaStoreProvider f21000b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(AndroidMediaStoreProvider androidMediaStoreProvider, int i) {
        this.f21000b = androidMediaStoreProvider;
        this.f20999a = i;
    }

    @Override // java.util.Comparator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compare(com.nexstreaming.kinemaster.mediastore.item.c cVar, com.nexstreaming.kinemaster.mediastore.item.c cVar2) {
        return this.f20999a * Long.valueOf(cVar.a()).compareTo(Long.valueOf(cVar2.a()));
    }
}
