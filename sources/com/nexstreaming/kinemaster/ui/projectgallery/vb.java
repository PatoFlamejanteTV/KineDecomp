package com.nexstreaming.kinemaster.ui.projectgallery;

import android.app.Dialog;
import android.view.View;
import com.nextreaming.nexeditorui.EditorGlobal;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ProjectGalleryActivity.java */
/* loaded from: classes2.dex */
public class vb extends com.nexstreaming.app.general.util.A {

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ Dialog f22991b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ ProjectGalleryActivity f22992c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public vb(ProjectGalleryActivity projectGalleryActivity, Dialog dialog) {
        this.f22992c = projectGalleryActivity;
        this.f22991b = dialog;
    }

    @Override // com.nexstreaming.app.general.util.A
    public void a(View view) {
        this.f22991b.dismiss();
        EditorGlobal.a(1.0f);
        this.f22992c.W();
    }
}
