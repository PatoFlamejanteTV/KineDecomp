package com.nexstreaming.kinemaster.ui.projectgallery;

import android.content.DialogInterface;
import com.nexstreaming.app.general.task.Task;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DependencyChecker.java */
/* loaded from: classes.dex */
public class g implements DialogInterface.OnCancelListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Task.Event f4208a;
    final /* synthetic */ a b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(a aVar, Task.Event event) {
        this.b = aVar;
        this.f4208a = event;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        Task task;
        task = this.b.d;
        task.signalEvent(this.f4208a);
        dialogInterface.dismiss();
    }
}
