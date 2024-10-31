package com.nextreaming.nexvideoeditor;

import com.nexstreaming.app.general.task.Task;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: NexEditor.java */
/* renamed from: com.nextreaming.nexvideoeditor.o, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C2364o implements Task.OnTaskEventListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ C2365p f24730a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2364o(C2365p c2365p) {
        this.f24730a = c2365p;
    }

    @Override // com.nexstreaming.app.general.task.Task.OnTaskEventListener
    public void onTaskEvent(Task task, Task.Event event) {
        C2366q c2366q = this.f24730a.f24731a;
        c2366q.f24734c.prepareSurface(c2366q.f24732a.getHolder().getSurface());
        this.f24730a.f24731a.f24734c.a(new C2363n(this));
    }
}
