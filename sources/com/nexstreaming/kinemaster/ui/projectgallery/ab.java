package com.nexstreaming.kinemaster.ui.projectgallery;

import android.view.View;
import com.nextreaming.nexeditorui.EditorGlobal;
import com.nextreaming.nexvideoeditor.NexEditor;

/* compiled from: ProjectGalleryActivity.java */
/* loaded from: classes2.dex */
class Ab extends com.nexstreaming.app.general.util.A {

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ ProjectGalleryActivity f22813b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Ab(ProjectGalleryActivity projectGalleryActivity) {
        this.f22813b = projectGalleryActivity;
    }

    @Override // com.nexstreaming.app.general.util.A
    public void a(View view) {
        NexEditor z;
        String a2;
        z = this.f22813b.z();
        if (z == null || (a2 = NexEditor.a("ro.board.platform")) == null || !a2.startsWith("rk")) {
            this.f22813b.da();
        } else {
            EditorGlobal.a(1.7777778f);
            this.f22813b.W();
        }
    }
}
