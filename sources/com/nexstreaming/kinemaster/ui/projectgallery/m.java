package com.nexstreaming.kinemaster.ui.projectgallery;

import android.content.DialogInterface;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DependencyChecker.java */
/* loaded from: classes.dex */
public class m implements DialogInterface.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ a f4214a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(a aVar) {
        this.f4214a = aVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.f4214a.c();
    }
}
