package com.nexstreaming.kinemaster.mediaprep;

import android.content.DialogInterface;
import com.nexstreaming.app.general.task.Task;

/* compiled from: MediaPrepManager.java */
/* loaded from: classes.dex */
class c implements DialogInterface.OnCancelListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ b f3526a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar) {
        this.f3526a = bVar;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        dialogInterface.dismiss();
        this.f3526a.d.signalEvent(Task.Event.CANCEL);
    }
}
