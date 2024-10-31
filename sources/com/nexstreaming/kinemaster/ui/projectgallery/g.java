package com.nexstreaming.kinemaster.ui.projectgallery;

import android.content.DialogInterface;
import com.nexstreaming.app.general.task.Task;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DependencyChecker.java */
/* loaded from: classes2.dex */
public class G implements DialogInterface.OnCancelListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ O f22834a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public G(O o) {
        this.f22834a = o;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        Task task;
        dialogInterface.dismiss();
        task = this.f22834a.f22870e;
        task.signalEvent(Task.Event.CANCEL);
    }
}
