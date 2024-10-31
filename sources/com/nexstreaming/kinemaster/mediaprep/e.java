package com.nexstreaming.kinemaster.mediaprep;

import android.content.DialogInterface;
import com.nexstreaming.app.general.task.Task;

/* compiled from: MediaPrepManager.java */
/* loaded from: classes.dex */
class e implements DialogInterface.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ b f3528a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(b bVar) {
        this.f3528a = bVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
        this.f3528a.d.signalEvent(Task.Event.SUCCESS, Task.Event.COMPLETE);
    }
}
