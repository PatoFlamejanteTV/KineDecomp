package com.nexstreaming.kinemaster.ui.projectgallery;

import android.content.DialogInterface;
import com.nexstreaming.app.general.task.Task;

/* compiled from: DependencyChecker.java */
/* renamed from: com.nexstreaming.kinemaster.ui.projectgallery.n, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
class DialogInterfaceOnClickListenerC2131n implements DialogInterface.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ C2137q f22957a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public DialogInterfaceOnClickListenerC2131n(C2137q c2137q) {
        this.f22957a = c2137q;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        Task task;
        dialogInterface.dismiss();
        this.f22957a.f22969a.m = false;
        task = this.f22957a.f22969a.f22870e;
        task.signalEvent(Task.Event.CANCEL);
    }
}
