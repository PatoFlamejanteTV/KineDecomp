package com.nexstreaming.kinemaster.ui.projectgallery;

import android.content.DialogInterface;
import com.nexstreaming.app.general.task.Task;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DependencyChecker.java */
/* loaded from: classes2.dex */
public class J implements DialogInterface.OnCancelListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ O f22843a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public J(O o) {
        this.f22843a = o;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        Task task;
        dialogInterface.dismiss();
        task = this.f22843a.f22870e;
        task.signalEvent(Task.Event.COMPLETE);
    }
}
