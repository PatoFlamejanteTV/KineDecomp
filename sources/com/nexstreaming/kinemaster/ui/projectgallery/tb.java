package com.nexstreaming.kinemaster.ui.projectgallery;

import android.app.Dialog;
import android.view.View;
import com.nextreaming.nexeditorui.EditorGlobal;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ProjectGalleryActivity.java */
/* loaded from: classes2.dex */
public class tb extends com.nexstreaming.app.general.util.A {

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ Dialog f22983b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ ProjectGalleryActivity f22984c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public tb(ProjectGalleryActivity projectGalleryActivity, Dialog dialog) {
        this.f22984c = projectGalleryActivity;
        this.f22983b = dialog;
    }

    @Override // com.nexstreaming.app.general.util.A
    public void a(View view) {
        this.f22983b.dismiss();
        EditorGlobal.a(1.7777778f);
        this.f22984c.W();
    }
}
