package com.nexstreaming.kinemaster.ui.projectedit;

import android.content.DialogInterface;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MediaEditFragment.java */
/* loaded from: classes2.dex */
public class Kb implements DialogInterface.OnShowListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Mb f21919a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Kb(Mb mb) {
        this.f21919a = mb;
    }

    @Override // android.content.DialogInterface.OnShowListener
    public void onShow(DialogInterface dialogInterface) {
        this.f21919a.j(true);
        this.f21919a.l(true);
    }
}
