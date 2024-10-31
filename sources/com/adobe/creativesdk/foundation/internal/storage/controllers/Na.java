package com.adobe.creativesdk.foundation.internal.storage.controllers;

import android.view.View;
import android.widget.ProgressBar;
import com.adobe.creativesdk.foundation.internal.storage.controllers.AdobeUXPhotoAssetOneUpViewerActivity;

/* compiled from: AdobeUXPhotoAssetOneUpViewerActivity.java */
/* loaded from: classes.dex */
class Na {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ View f5731a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ View f5732b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ View f5733c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ ProgressBar f5734d;

    /* renamed from: e, reason: collision with root package name */
    final /* synthetic */ AdobeUXPhotoAssetOneUpViewerActivity.c f5735e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Na(AdobeUXPhotoAssetOneUpViewerActivity.c cVar, View view, View view2, View view3, ProgressBar progressBar) {
        this.f5735e = cVar;
        this.f5731a = view;
        this.f5732b = view2;
        this.f5733c = view3;
        this.f5734d = progressBar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a() {
        this.f5731a.setVisibility(0);
        this.f5732b.setVisibility(8);
        this.f5733c.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(boolean z) {
        this.f5731a.setVisibility(8);
        if (z) {
            this.f5732b.setVisibility(0);
            this.f5733c.setVisibility(8);
        } else {
            this.f5732b.setVisibility(8);
            this.f5733c.setVisibility(0);
        }
        this.f5734d.setVisibility(8);
    }
}
