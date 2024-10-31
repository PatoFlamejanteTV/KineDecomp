package com.adobe.creativesdk.foundation.internal.storage.controllers;

import com.adobe.creativesdk.foundation.adobeinternal.storage.library.C0288q;
import com.adobe.creativesdk.foundation.internal.storage.controllers.C0500yc;
import com.adobe.creativesdk.foundation.storage.C0622wb;
import java.util.Comparator;

/* compiled from: DesignLibraryCollectionListView.java */
/* renamed from: com.adobe.creativesdk.foundation.internal.storage.controllers.uc, reason: case insensitive filesystem */
/* loaded from: classes.dex */
class C0482uc implements Comparator {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ C0500yc.a f6434a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0482uc(C0500yc.a aVar) {
        this.f6434a = aVar;
    }

    @Override // java.util.Comparator
    public int compare(Object obj, Object obj2) {
        return C0288q.b((C0622wb) obj).compareToIgnoreCase(C0288q.b((C0622wb) obj2));
    }
}
