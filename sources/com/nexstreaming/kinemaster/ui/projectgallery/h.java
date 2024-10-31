package com.nexstreaming.kinemaster.ui.projectgallery;

import android.content.DialogInterface;
import com.nexstreaming.app.general.task.Task;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DependencyChecker.java */
/* loaded from: classes.dex */
public class h implements DialogInterface.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Task.Event f4209a;
    final /* synthetic */ a b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(a aVar, Task.Event event) {
        this.b = aVar;
        this.f4209a = event;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        Task task;
        task = this.b.d;
        task.signalEvent(this.f4209a);
        dialogInterface.dismiss();
    }
}
