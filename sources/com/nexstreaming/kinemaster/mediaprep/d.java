package com.nexstreaming.kinemaster.mediaprep;

import android.content.DialogInterface;
import com.nexstreaming.app.general.task.Task;

/* compiled from: MediaPrepManager.java */
/* loaded from: classes.dex */
class d implements DialogInterface.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ r f20790a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(r rVar) {
        this.f20790a = rVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
        this.f20790a.f20825d.signalEvent(Task.Event.SUCCESS, Task.Event.COMPLETE);
    }
}
