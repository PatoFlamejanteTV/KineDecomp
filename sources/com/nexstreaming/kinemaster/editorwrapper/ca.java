package com.nexstreaming.kinemaster.editorwrapper;

import android.content.Context;
import com.nexstreaming.app.general.task.ResultTask;
import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.kinemaster.ui.a.a;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: VideoEditor.java */
/* loaded from: classes.dex */
public class ca implements Task.OnFailListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ com.nexstreaming.kinemaster.ui.a.e f3354a;
    final /* synthetic */ Context b;
    final /* synthetic */ ResultTask c;
    final /* synthetic */ VideoEditor d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ca(VideoEditor videoEditor, com.nexstreaming.kinemaster.ui.a.e eVar, Context context, ResultTask resultTask) {
        this.d = videoEditor;
        this.f3354a = eVar;
        this.b = context;
        this.c = resultTask;
    }

    @Override // com.nexstreaming.app.general.task.Task.OnFailListener
    public void onFail(Task task, Task.Event event, Task.TaskError taskError) {
        this.f3354a.dismiss();
        new a.C0074a(this.b).d("Transcoding Failed").a(taskError.getMessage()).b("OK", new cb(this)).a().show();
        this.c.sendFailure(Task.makeTaskError(taskError.getMessage()));
    }
}
