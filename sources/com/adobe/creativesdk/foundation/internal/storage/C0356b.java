package com.adobe.creativesdk.foundation.internal.storage;

import com.adobe.creativesdk.foundation.storage.C0533a;
import com.adobe.creativesdk.foundation.storage.Ya;
import java.util.Comparator;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AdobeAssetDataSource.java */
/* renamed from: com.adobe.creativesdk.foundation.internal.storage.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0356b implements Comparator<C0533a> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ C0506e f5496a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0356b(C0506e c0506e) {
        this.f5496a = c0506e;
    }

    @Override // java.util.Comparator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compare(C0533a c0533a, C0533a c0533a2) {
        return ((Ya) c0533a2).getModificationDate().compareTo(((Ya) c0533a).getModificationDate());
    }
}
