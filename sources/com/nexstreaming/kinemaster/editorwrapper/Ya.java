package com.nexstreaming.kinemaster.editorwrapper;

import com.nexstreaming.app.general.task.Task;
import java.io.File;

/* compiled from: VideoEditor.java */
/* loaded from: classes.dex */
class Ya implements Task.OnTaskEventListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Za f20283a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Ya(Za za) {
        this.f20283a = za;
    }

    @Override // com.nexstreaming.app.general.task.Task.OnTaskEventListener
    public void onTaskEvent(Task task, Task.Event event) {
        Za za = this.f20283a;
        za.f20287c.f20289b.f20294a.f20297b.sendResult(new File(za.f20286b));
    }
}
