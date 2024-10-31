package com.nexstreaming.kinemaster.ui.audiobrowser;

import com.nexstreaming.app.general.task.Task;
import com.nextreaming.nexeditorui.NexIndexableListView;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AudioBrowserFragment.kt */
/* loaded from: classes.dex */
public final class o implements Task.OnTaskEventListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ a f21452a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(a aVar) {
        this.f21452a = aVar;
    }

    @Override // com.nexstreaming.app.general.task.Task.OnTaskEventListener
    public final void onTaskEvent(Task task, Task.Event event) {
        NexIndexableListView nexIndexableListView;
        x xVar;
        x xVar2;
        this.f21452a.b(false);
        nexIndexableListView = this.f21452a.f21410f;
        if (nexIndexableListView != null) {
            nexIndexableListView.setItemChecked(-1, true);
            nexIndexableListView.setSelection(-1);
            xVar = this.f21452a.o;
            if (xVar != null) {
                xVar.b(-1);
            }
            xVar2 = this.f21452a.o;
            if (xVar2 != null) {
                xVar2.c(-1);
            }
        }
    }
}
