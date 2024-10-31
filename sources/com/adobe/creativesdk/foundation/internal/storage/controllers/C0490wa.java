package com.adobe.creativesdk.foundation.internal.storage.controllers;

import android.view.View;
import com.adobe.creativesdk.foundation.internal.storage.controllers.AdobeUXLibraryItemCollectionOneUpViewerActivity;
import com.adobe.creativesdk.foundation.internal.utils.photoview.g;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AdobeUXLibraryItemCollectionOneUpViewerActivity.java */
/* renamed from: com.adobe.creativesdk.foundation.internal.storage.controllers.wa, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0490wa implements g.e {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ AdobeUXLibraryItemCollectionOneUpViewerActivity.c f6515a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0490wa(AdobeUXLibraryItemCollectionOneUpViewerActivity.c cVar) {
        this.f6515a = cVar;
    }

    @Override // com.adobe.creativesdk.foundation.internal.utils.photoview.g.e
    public void a(View view, float f2, float f3) {
        if (this.f6515a.getActivity() != null) {
            ((AdobeUXLibraryItemCollectionOneUpViewerActivity) this.f6515a.getActivity()).e();
        }
    }
}
