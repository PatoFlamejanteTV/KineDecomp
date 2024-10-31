package com.nextreaming.nexvideoeditor;

import com.nexstreaming.app.general.task.Task;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: NexEditor.java */
/* loaded from: classes.dex */
public class n implements Task.OnTaskEventListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ l f4838a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(l lVar) {
        this.f4838a = lVar;
    }

    @Override // com.nexstreaming.app.general.task.Task.OnTaskEventListener
    public void onTaskEvent(Task task, Task.Event event) {
        this.f4838a.f4836a.c.prepareSurface(this.f4838a.f4836a.f4834a.getHolder().getSurface());
        this.f4838a.f4836a.c.a(new o(this));
    }
}
