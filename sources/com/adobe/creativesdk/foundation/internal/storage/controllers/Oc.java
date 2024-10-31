package com.adobe.creativesdk.foundation.internal.storage.controllers;

import com.adobe.creativesdk.foundation.adobeinternal.storage.library.C0288q;
import com.adobe.creativesdk.foundation.storage.C0622wb;
import java.util.Comparator;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DesignLibraryItemsListView.java */
/* loaded from: classes.dex */
public class Oc implements Comparator {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Sc f5753a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Oc(Sc sc) {
        this.f5753a = sc;
    }

    @Override // java.util.Comparator
    public int compare(Object obj, Object obj2) {
        return C0288q.b((C0622wb) obj).compareToIgnoreCase(C0288q.b((C0622wb) obj2));
    }
}
