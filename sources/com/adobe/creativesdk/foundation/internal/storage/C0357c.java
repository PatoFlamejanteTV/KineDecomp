package com.adobe.creativesdk.foundation.internal.storage;

import com.adobe.creativesdk.foundation.storage.Ya;
import com.adobe.creativesdk.foundation.storage.vd;
import java.util.ArrayList;

/* compiled from: AdobeAssetDataSource.java */
/* renamed from: com.adobe.creativesdk.foundation.internal.storage.c, reason: case insensitive filesystem */
/* loaded from: classes.dex */
class C0357c implements vd {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Ya f5500a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ ArrayList f5501b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ C0506e f5502c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0357c(C0506e c0506e, Ya ya, ArrayList arrayList) {
        this.f5502c = c0506e;
        this.f5500a = ya;
        this.f5501b = arrayList;
    }

    @Override // com.adobe.creativesdk.foundation.storage.vd
    public void a() {
        this.f5502c.f6568b.add(this.f5500a);
        int[] iArr = this.f5502c.f6567a;
        iArr[0] = iArr[0] + 1;
        int size = this.f5501b.size();
        C0506e c0506e = this.f5502c;
        if (size == c0506e.f6567a[0]) {
            c0506e.a();
        }
    }
}
