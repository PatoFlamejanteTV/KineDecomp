package com.nexstreaming.kinemaster.editorwrapper;

import android.content.DialogInterface;
import com.nexstreaming.app.general.task.ResultTask;
import com.nexstreaming.app.general.task.Task;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: VideoEditor.java */
/* loaded from: classes.dex */
public class bv implements DialogInterface.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ com.nexstreaming.kinemaster.g.i f3348a;
    final /* synthetic */ ResultTask b;
    final /* synthetic */ VideoEditor c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bv(VideoEditor videoEditor, com.nexstreaming.kinemaster.g.i iVar, ResultTask resultTask) {
        this.c = videoEditor;
        this.f3348a = iVar;
        this.b = resultTask;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.f3348a.cancel();
        dialogInterface.dismiss();
        this.b.signalEvent(Task.Event.FAIL);
    }
}
