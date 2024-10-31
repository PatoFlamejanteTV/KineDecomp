package com.nexstreaming.kinemaster.ui.projectgallery;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;

/* compiled from: ProjectGalleryActivity.java */
/* loaded from: classes.dex */
class co implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ Intent f4195a;
    final /* synthetic */ cn b;

    public co(cn cnVar, Intent intent) {
        this.b = cnVar;
        this.f4195a = intent;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        Activity D;
        D = this.b.f4194a.D();
        if (com.nexstreaming.kinemaster.h.a.c(D) && this.f4195a != null) {
            this.b.f4194a.startActivity(this.f4195a);
            dialogInterface.dismiss();
        }
    }
}
