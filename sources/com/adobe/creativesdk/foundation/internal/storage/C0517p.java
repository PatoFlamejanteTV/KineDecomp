package com.adobe.creativesdk.foundation.internal.storage;

import com.adobe.creativesdk.foundation.storage.C0533a;
import java.util.Comparator;

/* compiled from: AdobeAssetMultiRootedDataSource.java */
/* renamed from: com.adobe.creativesdk.foundation.internal.storage.p, reason: case insensitive filesystem */
/* loaded from: classes.dex */
class C0517p implements Comparator<C0533a> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ RunnableC0531y f6637a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0517p(RunnableC0531y runnableC0531y) {
        this.f6637a = runnableC0531y;
    }

    @Override // java.util.Comparator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compare(C0533a c0533a, C0533a c0533a2) {
        return c0533a2.getModificationDate().compareTo(c0533a.getModificationDate());
    }
}
