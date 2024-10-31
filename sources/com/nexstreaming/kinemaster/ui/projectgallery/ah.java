package com.nexstreaming.kinemaster.ui.projectgallery;

import android.app.Activity;
import android.view.View;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.kinemaster.ui.a.a;

/* compiled from: ProjectGalleryActivity.java */
/* loaded from: classes.dex */
class ah implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ProjectGalleryActivity f4134a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ah(ProjectGalleryActivity projectGalleryActivity) {
        this.f4134a = projectGalleryActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean t;
        boolean z;
        Activity D;
        com.nexstreaming.kinemaster.project.f fVar;
        String str;
        com.nexstreaming.kinemaster.project.f fVar2;
        t = this.f4134a.t();
        if (t) {
            z = this.f4134a.C;
            if (!z) {
                this.f4134a.C = true;
                D = this.f4134a.D();
                a.C0074a a2 = new a.C0074a(D).f(R.string.project_delete_popup_title).a(this.f4134a.getResources().getString(R.string.dlg_delete_project, ""));
                fVar = this.f4134a.q;
                if (fVar != null) {
                    fVar2 = this.f4134a.q;
                    str = fVar2.f();
                } else {
                    str = null;
                }
                a2.b(str).a(true).a(R.string.button_delete, new ak(this)).a(new aj(this)).b(R.string.dlg_delete_project_button_nodelete, new ai(this)).a().show();
            }
        }
    }
}
