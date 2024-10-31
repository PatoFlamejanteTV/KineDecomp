package com.adobe.creativesdk.foundation.internal.storage.controllers;

import com.adobe.creativesdk.foundation.storage.AdobePhotoCollection;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AssetsRecyclerView.java */
/* loaded from: classes.dex */
public class Bb implements c.a.a.a.b<Integer> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Sa f5592a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ AdobePhotoCollection f5593b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ Db f5594c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Bb(Db db, Sa sa, AdobePhotoCollection adobePhotoCollection) {
        this.f5594c = db;
        this.f5592a = sa;
        this.f5593b = adobePhotoCollection;
    }

    @Override // c.a.a.a.b
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void b(Integer num) {
        if (this.f5592a.c().equals(this.f5593b.getGUID())) {
            this.f5592a.n.setVisibility(0);
            this.f5592a.b(num.intValue());
        }
    }
}
