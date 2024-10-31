package com.nexstreaming.kinemaster.ui.projectgallery;

import android.content.DialogInterface;
import com.nexstreaming.app.general.task.Task;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DependencyChecker.java */
/* loaded from: classes2.dex */
public class L implements DialogInterface.OnCancelListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Task.Event f22855a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ O f22856b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public L(O o, Task.Event event) {
        this.f22856b = o;
        this.f22855a = event;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        Task task;
        task = this.f22856b.f22870e;
        task.signalEvent(this.f22855a);
        this.f22856b.m = false;
        dialogInterface.dismiss();
    }
}
