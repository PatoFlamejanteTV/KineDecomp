package com.nexstreaming.kinemaster.ui.projectedit;

import android.content.DialogInterface;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ProjectEditActivity.java */
/* loaded from: classes.dex */
public class kk implements DialogInterface.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ProjectEditActivity f4035a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public kk(ProjectEditActivity projectEditActivity) {
        this.f4035a = projectEditActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.f4035a.w();
    }
}
