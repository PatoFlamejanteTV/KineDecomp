package com.nexstreaming.kinemaster.ui.audiobrowser;

import com.nexstreaming.app.general.task.Task;
import com.nextreaming.nexeditorui.NexIndexableListView;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AudioBrowserFragment.kt */
/* loaded from: classes.dex */
public final class m implements Task.OnTaskEventListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ a f21449a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(a aVar) {
        this.f21449a = aVar;
    }

    @Override // com.nexstreaming.app.general.task.Task.OnTaskEventListener
    public final void onTaskEvent(Task task, Task.Event event) {
        NexIndexableListView nexIndexableListView;
        x xVar;
        x xVar2;
        this.f21449a.b(false);
        nexIndexableListView = this.f21449a.f21410f;
        if (nexIndexableListView != null) {
            nexIndexableListView.setSelection(-1);
            nexIndexableListView.setItemChecked(-1, true);
            xVar = this.f21449a.o;
            if (xVar != null) {
                xVar.c(-1);
            }
            xVar2 = this.f21449a.o;
            if (xVar2 != null) {
                xVar2.b(-1);
            }
        }
    }
}
