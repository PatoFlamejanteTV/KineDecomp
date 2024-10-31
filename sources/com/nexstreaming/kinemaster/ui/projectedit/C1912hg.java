package com.nexstreaming.kinemaster.ui.projectedit;

import com.nexstreaming.app.general.task.Task;
import com.nextreaming.nexeditorui.NexTimelineItem;

/* compiled from: ProjectEditActivity.java */
/* renamed from: com.nexstreaming.kinemaster.ui.projectedit.hg, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
class C1912hg implements Task.OnTaskEventListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ NexTimelineItem f22370a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ C1947lg f22371b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C1912hg(C1947lg c1947lg, NexTimelineItem nexTimelineItem) {
        this.f22371b = c1947lg;
        this.f22370a = nexTimelineItem;
    }

    @Override // com.nexstreaming.app.general.task.Task.OnTaskEventListener
    public void onTaskEvent(Task task, Task.Event event) {
        this.f22371b.f22438a.ja().c(this.f22370a);
        this.f22371b.f22438a.ja().J();
    }
}
