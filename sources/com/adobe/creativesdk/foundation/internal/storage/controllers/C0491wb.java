package com.adobe.creativesdk.foundation.internal.storage.controllers;

import android.graphics.Bitmap;
import com.adobe.creativesdk.foundation.internal.storage.C0330a;
import com.adobe.creativesdk.foundation.internal.storage.controllers.Db;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AssetsRecyclerView.java */
/* renamed from: com.adobe.creativesdk.foundation.internal.storage.controllers.wb, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0491wb implements Db.c {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Sa f6516a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ boolean f6517b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ boolean f6518c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ int f6519d;

    /* renamed from: e, reason: collision with root package name */
    final /* synthetic */ boolean f6520e;

    /* renamed from: f, reason: collision with root package name */
    final /* synthetic */ Db f6521f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0491wb(Db db, Sa sa, boolean z, boolean z2, int i, boolean z3) {
        this.f6521f = db;
        this.f6516a = sa;
        this.f6517b = z;
        this.f6518c = z2;
        this.f6519d = i;
        this.f6520e = z3;
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.Db.c
    public void a(C0330a c0330a, Bitmap bitmap, boolean z) {
        if (bitmap == null) {
            this.f6521f.a(this.f6516a, true, this.f6517b, this.f6518c);
        } else if (this.f6516a.f() == this.f6519d) {
            this.f6516a.a(bitmap, this.f6520e ? 0.3f : 1.0f, true);
        }
    }
}
