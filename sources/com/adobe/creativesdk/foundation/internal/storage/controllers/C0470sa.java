package com.adobe.creativesdk.foundation.internal.storage.controllers;

import com.adobe.creativesdk.foundation.storage.AdobeLibraryException;
import com.adobe.creativesdk.foundation.storage.C0582ma;
import com.adobe.creativesdk.foundation.storage.C0622wb;
import java.io.File;

/* compiled from: AdobeUXLibraryItemCollectionOneUpViewerActivity.java */
/* renamed from: com.adobe.creativesdk.foundation.internal.storage.controllers.sa */
/* loaded from: classes.dex */
public class C0470sa implements com.adobe.creativesdk.foundation.storage.sd<String, AdobeLibraryException> {

    /* renamed from: a */
    final /* synthetic */ C0622wb f6395a;

    /* renamed from: b */
    final /* synthetic */ String f6396b;

    /* renamed from: c */
    final /* synthetic */ AdobeUXLibraryItemCollectionOneUpViewerActivity f6397c;

    public C0470sa(AdobeUXLibraryItemCollectionOneUpViewerActivity adobeUXLibraryItemCollectionOneUpViewerActivity, C0622wb c0622wb, String str) {
        this.f6397c = adobeUXLibraryItemCollectionOneUpViewerActivity;
        this.f6395a = c0622wb;
        this.f6396b = str;
    }

    @Override // com.adobe.creativesdk.foundation.storage.rd
    public void a() {
    }

    @Override // com.adobe.creativesdk.foundation.storage.ud
    public void a(double d2) {
    }

    @Override // c.a.a.a.c
    public void a(AdobeLibraryException adobeLibraryException) {
    }

    @Override // c.a.a.a.b
    /* renamed from: a */
    public void b(String str) {
        com.adobe.creativesdk.foundation.internal.storage.controllers.a.f fVar;
        C0582ma c0582ma = new C0582ma(450.0f, 0.0f);
        if (!new File(str).exists() || (fVar = this.f6397c.D) == null) {
            return;
        }
        fVar.a(this.f6395a.c(), str, c0582ma, new C0461qa(this), new C0465ra(this));
    }
}
