package com.nexstreaming.kinemaster.ui.projectgallery;

import android.content.DialogInterface;
import com.nexstreaming.app.general.task.Task;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DependencyChecker.java */
/* loaded from: classes2.dex */
public class H implements DialogInterface.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ O f22837a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public H(O o) {
        this.f22837a = o;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        Task task;
        dialogInterface.dismiss();
        task = this.f22837a.f22870e;
        task.signalEvent(Task.Event.CANCEL);
    }
}
