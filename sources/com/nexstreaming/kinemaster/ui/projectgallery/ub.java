package com.nexstreaming.kinemaster.ui.projectgallery;

import android.app.Dialog;
import android.view.View;
import com.nextreaming.nexeditorui.EditorGlobal;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ProjectGalleryActivity.java */
/* loaded from: classes2.dex */
public class ub extends com.nexstreaming.app.general.util.A {

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ Dialog f22987b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ ProjectGalleryActivity f22988c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ub(ProjectGalleryActivity projectGalleryActivity, Dialog dialog) {
        this.f22988c = projectGalleryActivity;
        this.f22987b = dialog;
    }

    @Override // com.nexstreaming.app.general.util.A
    public void a(View view) {
        this.f22987b.dismiss();
        EditorGlobal.a(0.5625f);
        this.f22988c.W();
    }
}
