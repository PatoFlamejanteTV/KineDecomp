package com.nexstreaming.kinemaster.ui.projectgallery;

import android.app.Dialog;
import android.view.View;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ProjectGalleryActivity.java */
/* loaded from: classes2.dex */
public class wb extends com.nexstreaming.app.general.util.A {

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ Dialog f22995b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ ProjectGalleryActivity f22996c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public wb(ProjectGalleryActivity projectGalleryActivity, Dialog dialog) {
        this.f22996c = projectGalleryActivity;
        this.f22995b = dialog;
    }

    @Override // com.nexstreaming.app.general.util.A
    public void a(View view) {
        this.f22995b.dismiss();
    }
}
