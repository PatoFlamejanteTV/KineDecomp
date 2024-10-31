package com.adobe.creativesdk.foundation.adobeinternal.storage.library;

import com.adobe.creativesdk.foundation.internal.utils.AdobeCSDKException;
import com.adobe.creativesdk.foundation.storage.C0614ub;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AdobeLibrarySyncManager.java */
/* loaded from: classes.dex */
public class Y implements c.a.a.a.b<String> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ int f4564a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ String f4565b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ Integer f4566c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ C0614ub f4567d;

    /* renamed from: e, reason: collision with root package name */
    final /* synthetic */ boolean f4568e;

    /* renamed from: f, reason: collision with root package name */
    final /* synthetic */ ha f4569f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Y(ha haVar, int i, String str, Integer num, C0614ub c0614ub, boolean z) {
        this.f4569f = haVar;
        this.f4564a = i;
        this.f4565b = str;
        this.f4566c = num;
        this.f4567d = c0614ub;
        this.f4568e = z;
    }

    @Override // c.a.a.a.b
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void b(String str) {
        int i;
        int i2 = this.f4564a;
        i = this.f4569f.G;
        if (i2 != i) {
            return;
        }
        this.f4569f.a(this.f4565b, this.f4566c, (AdobeCSDKException) null, this.f4567d, this.f4568e, this.f4564a);
    }
}
