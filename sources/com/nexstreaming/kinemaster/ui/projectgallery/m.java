package com.nexstreaming.kinemaster.ui.projectgallery;

import android.content.DialogInterface;
import com.nexstreaming.app.general.task.Task;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DependencyChecker.java */
/* loaded from: classes2.dex */
public class M implements DialogInterface.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Task.Event f22861a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ O f22862b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public M(O o, Task.Event event) {
        this.f22862b = o;
        this.f22861a = event;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        Task task;
        Task task2;
        task = this.f22862b.f22870e;
        if (task != null) {
            task2 = this.f22862b.f22870e;
            task2.signalEvent(this.f22861a);
        }
        this.f22862b.m = false;
        dialogInterface.dismiss();
    }
}
