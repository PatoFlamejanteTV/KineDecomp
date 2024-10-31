package com.nexstreaming.kinemaster.editorwrapper;

import com.nexstreaming.app.general.task.Task;
import java.io.File;

/* compiled from: VideoEditor.java */
/* loaded from: classes.dex */
class br implements Task.OnTaskEventListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ bq f3344a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public br(bq bqVar) {
        this.f3344a = bqVar;
    }

    @Override // com.nexstreaming.app.general.task.Task.OnTaskEventListener
    public void onTaskEvent(Task task, Task.Event event) {
        this.f3344a.c.b.f3341a.b.sendResult(new File(this.f3344a.b));
    }
}
