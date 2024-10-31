package com.nexstreaming.kinemaster.ui.projectgallery;

import android.content.DialogInterface;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ProjectGalleryActivity.java */
/* loaded from: classes2.dex */
public class xb implements DialogInterface.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ com.nexstreaming.kinemaster.ui.a.e f22999a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ ProjectGalleryActivity f23000b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public xb(ProjectGalleryActivity projectGalleryActivity, com.nexstreaming.kinemaster.ui.a.e eVar) {
        this.f23000b = projectGalleryActivity;
        this.f22999a = eVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.f22999a.dismiss();
        this.f23000b.finish();
    }
}
