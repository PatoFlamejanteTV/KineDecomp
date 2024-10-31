package com.nexstreaming.kinemaster.ui.projectgallery;

import android.content.DialogInterface;
import android.view.View;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.kinemaster.ui.a.e;
import com.nexstreaming.kinemaster.ui.projectgallery.ProjectGalleryActivity;
import com.nexstreaming.kinemaster.ui.share.AsyncTaskC2214da;
import com.nexstreaming.kinemaster.ui.share.ExportedVideoDatabase;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ProjectGalleryActivity.java */
/* renamed from: com.nexstreaming.kinemaster.ui.projectgallery.da, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class C2103da extends com.nexstreaming.app.general.util.A {

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ ProjectGalleryActivity f22913b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2103da(ProjectGalleryActivity projectGalleryActivity) {
        this.f22913b = projectGalleryActivity;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void a(DialogInterface dialogInterface) {
    }

    @Override // com.nexstreaming.app.general.util.A
    public void a(View view) {
        boolean L;
        com.nexstreaming.kinemaster.project.k kVar;
        String str;
        com.nexstreaming.kinemaster.project.k kVar2;
        L = this.f22913b.L();
        if (L) {
            e.a aVar = new e.a(this.f22913b);
            aVar.e(R.string.project_delete_popup_title);
            aVar.a(this.f22913b.getResources().getString(R.string.dlg_delete_project, ""));
            kVar = this.f22913b.va;
            if (kVar != null) {
                kVar2 = this.f22913b.va;
                str = kVar2.f();
            } else {
                str = null;
            }
            aVar.b(str);
            aVar.a(true);
            aVar.c(R.string.button_delete, new DialogInterface.OnClickListener() { // from class: com.nexstreaming.kinemaster.ui.projectgallery.b
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i) {
                    C2103da.this.a(dialogInterface, i);
                }
            });
            aVar.a(new DialogInterface.OnCancelListener() { // from class: com.nexstreaming.kinemaster.ui.projectgallery.a
                @Override // android.content.DialogInterface.OnCancelListener
                public final void onCancel(DialogInterface dialogInterface) {
                    C2103da.a(dialogInterface);
                }
            });
            aVar.a(R.string.dlg_delete_project_button_nodelete, new DialogInterface.OnClickListener() { // from class: com.nexstreaming.kinemaster.ui.projectgallery.c
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.dismiss();
                }
            });
            aVar.a().show();
        }
    }

    public /* synthetic */ void a(DialogInterface dialogInterface, int i) {
        com.nexstreaming.kinemaster.project.k kVar;
        com.nexstreaming.kinemaster.project.k kVar2;
        com.nexstreaming.kinemaster.project.k kVar3;
        ProjectGalleryActivity.SortingMode sortingMode;
        kVar = this.f22913b.va;
        if (kVar != null) {
            ExportedVideoDatabase a2 = ExportedVideoDatabase.a(this.f22913b);
            kVar2 = this.f22913b.va;
            new AsyncTaskC2214da(a2, kVar2.f(), null).execute(4);
            kVar3 = this.f22913b.va;
            kVar3.e().delete();
            this.f22913b.va = null;
            sortingMode = this.f22913b.ya;
            com.nexstreaming.kinemaster.project.k.a(sortingMode).onResultAvailable(new C2100ca(this));
        }
        dialogInterface.dismiss();
    }
}
