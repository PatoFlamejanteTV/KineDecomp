package com.adobe.creativesdk.foundation.internal.storage.controllers;

import com.adobe.creativesdk.foundation.internal.storage.controllers.AdobeUXLibraryItemCollectionOneUpViewerActivity;
import com.adobe.creativesdk.foundation.internal.utils.photoview.PhotoView;
import com.adobe.creativesdk.foundation.storage.AdobeLibraryException;
import com.adobe.creativesdk.foundation.storage.C0582ma;
import com.adobe.creativesdk.foundation.storage.C0622wb;
import java.io.File;

/* compiled from: AdobeUXLibraryItemCollectionOneUpViewerActivity.java */
/* renamed from: com.adobe.creativesdk.foundation.internal.storage.controllers.va */
/* loaded from: classes.dex */
public class C0486va implements com.adobe.creativesdk.foundation.storage.sd<String, AdobeLibraryException> {

    /* renamed from: a */
    final /* synthetic */ AdobeUXLibraryItemCollectionOneUpViewerActivity f6502a;

    /* renamed from: b */
    final /* synthetic */ C0622wb f6503b;

    /* renamed from: c */
    final /* synthetic */ C0582ma f6504c;

    /* renamed from: d */
    final /* synthetic */ PhotoView f6505d;

    /* renamed from: e */
    final /* synthetic */ AdobeUXLibraryItemCollectionOneUpViewerActivity.c f6506e;

    public C0486va(AdobeUXLibraryItemCollectionOneUpViewerActivity.c cVar, AdobeUXLibraryItemCollectionOneUpViewerActivity adobeUXLibraryItemCollectionOneUpViewerActivity, C0622wb c0622wb, C0582ma c0582ma, PhotoView photoView) {
        this.f6506e = cVar;
        this.f6502a = adobeUXLibraryItemCollectionOneUpViewerActivity;
        this.f6503b = c0622wb;
        this.f6504c = c0582ma;
        this.f6505d = photoView;
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
        if (str == null || str.isEmpty()) {
            this.f6506e.A();
            return;
        }
        AdobeUXLibraryItemCollectionOneUpViewerActivity adobeUXLibraryItemCollectionOneUpViewerActivity = this.f6502a;
        if (adobeUXLibraryItemCollectionOneUpViewerActivity == null || adobeUXLibraryItemCollectionOneUpViewerActivity.D == null) {
            return;
        }
        if (!new File(str).exists()) {
            this.f6506e.A();
        } else {
            this.f6502a.D.a(this.f6503b.c(), str, this.f6504c, new C0475ta(this), new C0480ua(this));
        }
    }
}
