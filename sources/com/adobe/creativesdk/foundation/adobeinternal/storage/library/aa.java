package com.adobe.creativesdk.foundation.adobeinternal.storage.library;

import com.adobe.creativesdk.foundation.internal.utils.AdobeCSDKException;
import com.adobe.creativesdk.foundation.storage.C0614ub;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AdobeLibrarySyncManager.java */
/* loaded from: classes.dex */
public class aa implements c.a.a.a.b<String> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f4578a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ String f4579b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ C0614ub f4580c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ boolean f4581d;

    /* renamed from: e, reason: collision with root package name */
    final /* synthetic */ int f4582e;

    /* renamed from: f, reason: collision with root package name */
    final /* synthetic */ ha f4583f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(ha haVar, String str, String str2, C0614ub c0614ub, boolean z, int i) {
        this.f4583f = haVar;
        this.f4578a = str;
        this.f4579b = str2;
        this.f4580c = c0614ub;
        this.f4581d = z;
        this.f4582e = i;
    }

    @Override // c.a.a.a.b
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void b(String str) {
        this.f4583f.a(this.f4578a, this.f4579b, (AdobeCSDKException) null, this.f4580c, this.f4581d, this.f4582e);
    }
}
