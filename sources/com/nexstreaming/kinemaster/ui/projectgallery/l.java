package com.nexstreaming.kinemaster.ui.projectgallery;

import android.content.DialogInterface;
import com.nexstreaming.app.general.task.Task;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DependencyChecker.java */
/* loaded from: classes.dex */
public class l implements DialogInterface.OnCancelListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ a f4213a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(a aVar) {
        this.f4213a = aVar;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        Task task;
        task = this.f4213a.d;
        task.signalEvent(Task.Event.CANCEL);
    }
}
