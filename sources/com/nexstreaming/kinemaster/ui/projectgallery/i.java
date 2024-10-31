package com.nexstreaming.kinemaster.ui.projectgallery;

import android.content.DialogInterface;
import com.nexstreaming.app.general.task.Task;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DependencyChecker.java */
/* loaded from: classes2.dex */
public class I implements DialogInterface.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ O f22840a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public I(O o) {
        this.f22840a = o;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        Task task;
        dialogInterface.dismiss();
        task = this.f22840a.f22870e;
        task.signalEvent(Task.Event.COMPLETE);
    }
}
