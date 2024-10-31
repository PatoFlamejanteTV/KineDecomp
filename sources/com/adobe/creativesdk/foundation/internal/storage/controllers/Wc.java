package com.adobe.creativesdk.foundation.internal.storage.controllers;

import com.adobe.creativesdk.foundation.internal.storage.controllers.Sc;
import java.util.Comparator;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DesignLibraryItemsListView.java */
/* loaded from: classes.dex */
public class Wc implements Comparator<Sc.d.b> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Sc.d f5884a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Wc(Sc.d dVar) {
        this.f5884a = dVar;
    }

    @Override // java.util.Comparator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compare(Sc.d.b bVar, Sc.d.b bVar2) {
        int i = bVar.f5842a;
        int i2 = bVar2.f5842a;
        if (i == i2) {
            return 0;
        }
        return i < i2 ? -1 : 1;
    }
}
