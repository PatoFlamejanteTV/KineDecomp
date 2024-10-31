package com.nexstreaming.kinemaster.ui.projectgallery;

import android.content.DialogInterface;
import com.nexstreaming.app.general.task.Task;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DependencyChecker.java */
/* loaded from: classes.dex */
public class k implements DialogInterface.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ a f4212a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(a aVar) {
        this.f4212a = aVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        Task task;
        dialogInterface.dismiss();
        task = this.f4212a.d;
        task.signalEvent(Task.Event.COMPLETE);
    }
}
