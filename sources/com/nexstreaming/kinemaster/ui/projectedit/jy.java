package com.nexstreaming.kinemaster.ui.projectedit;

import com.nexstreaming.app.general.task.Task;
import com.nextreaming.nexeditorui.NexTimelineItem;

/* compiled from: ProjectEditActivity.java */
/* loaded from: classes.dex */
class jy implements Task.OnTaskEventListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ NexTimelineItem f4022a;
    final /* synthetic */ jw b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public jy(jw jwVar, NexTimelineItem nexTimelineItem) {
        this.b = jwVar;
        this.f4022a = nexTimelineItem;
    }

    @Override // com.nexstreaming.app.general.task.Task.OnTaskEventListener
    public void onTaskEvent(Task task, Task.Event event) {
        this.b.f4020a.p().a(this.f4022a);
        this.b.f4020a.p().l();
    }
}
