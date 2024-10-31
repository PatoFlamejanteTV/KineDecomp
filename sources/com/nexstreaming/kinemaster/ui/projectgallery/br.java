package com.nexstreaming.kinemaster.ui.projectgallery;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;

/* compiled from: ProjectGalleryActivity.java */
/* loaded from: classes.dex */
class br implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ Intent f4171a;
    final /* synthetic */ bq b;

    public br(bq bqVar, Intent intent) {
        this.b = bqVar;
        this.f4171a = intent;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        Activity D;
        D = this.b.b.f4169a.D();
        if (com.nexstreaming.kinemaster.h.a.c(D) && this.f4171a != null) {
            this.b.b.f4169a.startActivity(this.f4171a);
            dialogInterface.dismiss();
        }
    }
}
