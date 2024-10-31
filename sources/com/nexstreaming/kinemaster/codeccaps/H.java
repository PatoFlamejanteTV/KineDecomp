package com.nexstreaming.kinemaster.codeccaps;

import com.nexstreaming.app.general.task.Task;
import com.nextreaming.nexvideoeditor.NexEditor;

/* compiled from: CodecTestCase.java */
/* loaded from: classes.dex */
class H implements Task.OnTaskEventListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ I f20057a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public H(I i) {
        this.f20057a = i;
    }

    @Override // com.nexstreaming.app.general.task.Task.OnTaskEventListener
    public void onTaskEvent(Task task, Task.Event event) {
        boolean z;
        NexEditor d2;
        z = this.f20057a.f20060c.p;
        if (z) {
            this.f20057a.f20060c.c();
        } else {
            d2 = this.f20057a.f20060c.d();
            d2.a(0, new G(this));
        }
    }
}
