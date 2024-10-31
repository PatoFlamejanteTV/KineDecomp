package com.nexstreaming.kinemaster.ui.projectgallery;

import android.content.DialogInterface;
import com.nexstreaming.app.general.task.Task;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DependencyChecker.java */
/* loaded from: classes2.dex */
public class r implements DialogInterface.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ O f22972a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(O o) {
        this.f22972a = o;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        Task task;
        Task task2;
        task = this.f22972a.f22870e;
        if (task != null) {
            task2 = this.f22972a.f22870e;
            task2.signalEvent(Task.Event.CANCEL);
        }
        this.f22972a.m = false;
        dialogInterface.dismiss();
    }
}
