package com.nexstreaming.kinemaster.ui.projectgallery;

import android.content.DialogInterface;
import com.nexstreaming.app.general.task.Task;

/* compiled from: DependencyChecker.java */
/* renamed from: com.nexstreaming.kinemaster.ui.projectgallery.p, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
class DialogInterfaceOnCancelListenerC2135p implements DialogInterface.OnCancelListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ C2137q f22965a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public DialogInterfaceOnCancelListenerC2135p(C2137q c2137q) {
        this.f22965a = c2137q;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        Task task;
        this.f22965a.f22969a.m = false;
        task = this.f22965a.f22969a.f22870e;
        task.signalEvent(Task.Event.CANCEL);
    }
}
