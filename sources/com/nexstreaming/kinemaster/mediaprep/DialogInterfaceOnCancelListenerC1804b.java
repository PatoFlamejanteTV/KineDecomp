package com.nexstreaming.kinemaster.mediaprep;

import android.content.DialogInterface;
import com.nexstreaming.app.general.task.Task;

/* compiled from: MediaPrepManager.java */
/* renamed from: com.nexstreaming.kinemaster.mediaprep.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
class DialogInterfaceOnCancelListenerC1804b implements DialogInterface.OnCancelListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ r f20788a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public DialogInterfaceOnCancelListenerC1804b(r rVar) {
        this.f20788a = rVar;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        dialogInterface.dismiss();
        this.f20788a.f20825d.signalEvent(Task.Event.CANCEL);
    }
}
