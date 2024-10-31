package com.adobe.creativesdk.foundation.adobeinternal.storage.library;

import com.adobe.creativesdk.foundation.storage.AdobeLibraryException;
import com.adobe.creativesdk.foundation.storage.C0614ub;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AdobeLibrarySyncManager.java */
/* loaded from: classes.dex */
public class ba implements c.a.a.a.c<AdobeLibraryException> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f4586a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ String f4587b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ C0614ub f4588c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ boolean f4589d;

    /* renamed from: e, reason: collision with root package name */
    final /* synthetic */ int f4590e;

    /* renamed from: f, reason: collision with root package name */
    final /* synthetic */ ha f4591f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ba(ha haVar, String str, String str2, C0614ub c0614ub, boolean z, int i) {
        this.f4591f = haVar;
        this.f4586a = str;
        this.f4587b = str2;
        this.f4588c = c0614ub;
        this.f4589d = z;
        this.f4590e = i;
    }

    @Override // c.a.a.a.c
    public void a(AdobeLibraryException adobeLibraryException) {
        this.f4591f.a(this.f4586a, this.f4587b, adobeLibraryException, this.f4588c, this.f4589d, this.f4590e);
    }
}
