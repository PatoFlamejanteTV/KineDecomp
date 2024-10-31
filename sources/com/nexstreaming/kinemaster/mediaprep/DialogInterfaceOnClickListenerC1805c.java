package com.nexstreaming.kinemaster.mediaprep;

import android.content.DialogInterface;
import com.nexstreaming.app.general.task.Task;

/* compiled from: MediaPrepManager.java */
/* renamed from: com.nexstreaming.kinemaster.mediaprep.c, reason: case insensitive filesystem */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC1805c implements DialogInterface.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ r f20789a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public DialogInterfaceOnClickListenerC1805c(r rVar) {
        this.f20789a = rVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
        this.f20789a.f20825d.signalEvent(Task.Event.CANCEL);
    }
}
