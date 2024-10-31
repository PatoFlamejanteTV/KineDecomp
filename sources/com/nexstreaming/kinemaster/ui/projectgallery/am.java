package com.nexstreaming.kinemaster.ui.projectgallery;

import android.app.Activity;
import android.view.View;
import com.nexstreaming.app.kinemasterfree.R;
import com.nextreaming.nexeditorui.EditorGlobal;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ProjectGalleryActivity.java */
/* loaded from: classes.dex */
public class am implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ ProjectGalleryActivity f4139a;

    public am(ProjectGalleryActivity projectGalleryActivity) {
        this.f4139a = projectGalleryActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean t;
        Activity D;
        t = this.f4139a.t();
        if (t) {
            D = this.f4139a.D();
            com.nexstreaming.kinemaster.ui.widget.g gVar = new com.nexstreaming.kinemaster.ui.widget.g(D, true, true);
            gVar.a(R.id.duplicate_project, R.string.project_gallery_duplicate_project, 0);
            if (EditorGlobal.n()) {
                gVar.a(R.id.report_project_issue, R.string.project_gallery_report_issue, 0);
            }
            gVar.a(this.f4139a.findViewById(R.id.projectDelete), 83);
            this.f4139a.findViewById(R.id.projectOverflow).setSelected(true);
            gVar.a(new an(this));
            gVar.a(new ao(this));
        }
    }
}
