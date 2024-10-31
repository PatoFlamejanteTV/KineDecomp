package com.nexstreaming.kinemaster.ui.projectgallery;

import android.content.DialogInterface;
import android.view.View;

/* compiled from: ProjectGalleryActivity.java */
/* loaded from: classes.dex */
class bt implements DialogInterface.OnDismissListener {

    /* renamed from: a */
    final /* synthetic */ bq f4173a;

    public bt(bq bqVar) {
        this.f4173a = bqVar;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        View view;
        Runnable runnable;
        View view2;
        Runnable runnable2;
        this.f4173a.b.f4169a.J = null;
        view = this.f4173a.b.f4169a.L;
        if (view != null) {
            runnable = this.f4173a.b.f4169a.R;
            if (runnable != null) {
                view2 = this.f4173a.b.f4169a.L;
                runnable2 = this.f4173a.b.f4169a.R;
                view2.post(runnable2);
            }
        }
    }
}
