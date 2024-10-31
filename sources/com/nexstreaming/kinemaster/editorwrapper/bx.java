package com.nexstreaming.kinemaster.editorwrapper;

import android.content.Context;
import android.media.MediaScannerConnection;
import com.nexstreaming.app.general.task.ResultTask;
import com.nexstreaming.app.general.task.Task;
import java.io.File;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: VideoEditor.java */
/* loaded from: classes.dex */
public class bx implements Task.OnTaskEventListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ com.nexstreaming.kinemaster.ui.a.e f3350a;
    final /* synthetic */ Context b;
    final /* synthetic */ File c;
    final /* synthetic */ ResultTask d;
    final /* synthetic */ VideoEditor e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bx(VideoEditor videoEditor, com.nexstreaming.kinemaster.ui.a.e eVar, Context context, File file, ResultTask resultTask) {
        this.e = videoEditor;
        this.f3350a = eVar;
        this.b = context;
        this.c = file;
        this.d = resultTask;
    }

    @Override // com.nexstreaming.app.general.task.Task.OnTaskEventListener
    public void onTaskEvent(Task task, Task.Event event) {
        this.f3350a.dismiss();
        MediaScannerConnection.scanFile(this.b, new String[]{this.c.getAbsolutePath()}, null, new by(this));
        this.d.signalEvent(Task.Event.COMPLETE);
    }
}
