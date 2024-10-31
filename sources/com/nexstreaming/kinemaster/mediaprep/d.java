package com.nexstreaming.kinemaster.mediaprep;

import android.content.DialogInterface;
import com.nexstreaming.app.general.task.Task;

/* compiled from: MediaPrepManager.java */
/* loaded from: classes.dex */
class d implements DialogInterface.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ b f3527a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(b bVar) {
        this.f3527a = bVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
        this.f3527a.d.signalEvent(Task.Event.CANCEL);
    }
}
