package com.adobe.creativesdk.foundation.internal.storage.controllers;

import android.graphics.Bitmap;
import com.adobe.creativesdk.foundation.internal.storage.C0330a;
import com.adobe.creativesdk.foundation.internal.storage.controllers.Db;
import com.adobe.creativesdk.foundation.internal.utils.AdobeCSDKException;
import java.util.HashMap;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AssetsRecyclerView.java */
/* renamed from: com.adobe.creativesdk.foundation.internal.storage.controllers.xb, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0495xb implements com.adobe.creativesdk.foundation.storage.sd<Bitmap, AdobeCSDKException> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ C0330a f6527a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ Db.c f6528b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ Db f6529c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0495xb(Db db, C0330a c0330a, Db.c cVar) {
        this.f6529c = db;
        this.f6527a = c0330a;
        this.f6528b = cVar;
    }

    @Override // com.adobe.creativesdk.foundation.storage.ud
    public void a(double d2) {
    }

    @Override // c.a.a.a.c
    public void a(AdobeCSDKException adobeCSDKException) {
        HashMap hashMap;
        hashMap = this.f6529c.f5610c;
        hashMap.remove(this.f6527a.f5272a);
        this.f6528b.a(this.f6527a, null, false);
    }

    @Override // com.adobe.creativesdk.foundation.storage.rd
    public void a() {
        HashMap hashMap;
        hashMap = this.f6529c.f5610c;
        hashMap.remove(this.f6527a.f5272a);
    }

    @Override // c.a.a.a.b
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void b(Bitmap bitmap) {
        HashMap hashMap;
        hashMap = this.f6529c.f5610c;
        hashMap.remove(this.f6527a.f5272a);
        this.f6528b.a(this.f6527a, bitmap, false);
    }
}
