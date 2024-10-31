package com.nexstreaming.kinemaster.ui.projectgallery;

import android.content.DialogInterface;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DependencyChecker.java */
/* loaded from: classes.dex */
public class i implements DialogInterface.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ a f4210a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(a aVar) {
        this.f4210a = aVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
        this.f4210a.g();
    }
}
