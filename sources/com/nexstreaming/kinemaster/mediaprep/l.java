package com.nexstreaming.kinemaster.mediaprep;

import com.nexstreaming.app.general.task.Task;

/* compiled from: MediaPrepManager.java */
/* loaded from: classes.dex */
class l implements Task.OnTaskEventListener {

    /* renamed from: a */
    final /* synthetic */ k f3535a;

    public l(k kVar) {
        this.f3535a = kVar;
    }

    @Override // com.nexstreaming.app.general.task.Task.OnTaskEventListener
    public void onTaskEvent(Task task, Task.Event event) {
        this.f3535a.b.f3533a.d.a(this.f3535a.b.f3533a.f3532a, this.f3535a.b.f3533a.c, this.f3535a.b.f3533a.b.getAbsolutePath());
    }
}
