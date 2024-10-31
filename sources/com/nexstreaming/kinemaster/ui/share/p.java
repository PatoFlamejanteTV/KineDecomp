package com.nexstreaming.kinemaster.ui.share;

import com.nexstreaming.app.general.task.Task;

/* compiled from: ExportManager.java */
/* loaded from: classes2.dex */
class P implements Task.OnTaskEventListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Q f23294a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public P(Q q) {
        this.f23294a = q;
    }

    @Override // com.nexstreaming.app.general.task.Task.OnTaskEventListener
    public void onTaskEvent(Task task, Task.Event event) {
        Task a2;
        S s = this.f23294a.f23295a;
        a2 = s.f23298c.a(s.f23297b, 2, 2);
        a2.onComplete(new O(this));
    }
}
