package com.nexstreaming.kinemaster.ui.projectedit;

import android.content.DialogInterface;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MediaEditFragment.java */
/* loaded from: classes2.dex */
public class Jb implements DialogInterface.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ boolean f21909a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ c.d.b.k.j f21910b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ Mb f21911c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Jb(Mb mb, boolean z, c.d.b.k.j jVar) {
        this.f21911c = mb;
        this.f21909a = z;
        this.f21910b = jVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        if (!this.f21909a) {
            this.f21910b.cancel();
        }
        dialogInterface.dismiss();
    }
}
