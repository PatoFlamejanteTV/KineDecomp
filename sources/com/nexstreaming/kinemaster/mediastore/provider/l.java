package com.nexstreaming.kinemaster.mediastore.provider;

import java.util.Comparator;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AndroidMediaStoreProvider.java */
/* loaded from: classes.dex */
public class l implements Comparator<com.nexstreaming.kinemaster.mediastore.item.c> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ int f20997a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ AndroidMediaStoreProvider f20998b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(AndroidMediaStoreProvider androidMediaStoreProvider, int i) {
        this.f20998b = androidMediaStoreProvider;
        this.f20997a = i;
    }

    @Override // java.util.Comparator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compare(com.nexstreaming.kinemaster.mediastore.item.c cVar, com.nexstreaming.kinemaster.mediastore.item.c cVar2) {
        return this.f20997a * cVar.c().compareTo(cVar2.c());
    }
}
