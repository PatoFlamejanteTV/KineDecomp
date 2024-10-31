package com.nexstreaming.kinemaster.ui.projectgallery;

import android.content.DialogInterface;
import com.nexstreaming.app.general.task.Task;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DependencyChecker.java */
/* loaded from: classes.dex */
public class j implements DialogInterface.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ a f4211a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(a aVar) {
        this.f4211a = aVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        Task task;
        dialogInterface.dismiss();
        task = this.f4211a.d;
        task.signalEvent(Task.Event.CANCEL);
    }
}
