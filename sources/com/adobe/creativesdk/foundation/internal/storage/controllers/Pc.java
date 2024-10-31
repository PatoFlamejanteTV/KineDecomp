package com.adobe.creativesdk.foundation.internal.storage.controllers;

import com.adobe.creativesdk.foundation.internal.storage.controllers.Sc;
import com.adobe.creativesdk.foundation.internal.storage.controllers.utils.AdobeWaterFallLayoutManager;

/* compiled from: DesignLibraryItemsListView.java */
/* loaded from: classes.dex */
class Pc implements AdobeWaterFallLayoutManager.a {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ int f5785a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ Sc f5786b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Pc(Sc sc, int i) {
        this.f5786b = sc;
        this.f5785a = i;
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.utils.AdobeWaterFallLayoutManager.a
    public int a(int i) {
        return ((Sc.c) this.f5786b.f6416g).f(i);
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.utils.AdobeWaterFallLayoutManager.a
    public int a() {
        return this.f5785a;
    }
}
