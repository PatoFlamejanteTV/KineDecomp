package com.adobe.creativesdk.foundation.internal.storage.controllers.edit;

import com.adobe.creativesdk.foundation.internal.storage.a.b.wa;
import com.adobe.creativesdk.foundation.storage.AdobeAssetException;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AdobeAssetViewEditRenameDialogFragment.java */
/* renamed from: com.adobe.creativesdk.foundation.internal.storage.controllers.edit.i, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0391i implements wa {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ C0392j f6043a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0391i(C0392j c0392j) {
        this.f6043a = c0392j;
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.a.b.wa
    public void a(AdobeAssetException adobeAssetException) {
        this.f6043a.N();
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.a.b.wa
    public void onComplete() {
        this.f6043a.L();
    }
}
