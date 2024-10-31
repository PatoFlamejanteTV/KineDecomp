package com.nextreaming.nexeditorui.fontbrowser;

import android.widget.ProgressBar;
import com.nexstreaming.app.general.task.Task;

/* compiled from: FontListAdapter.java */
/* loaded from: classes.dex */
class p implements Task.OnTaskEventListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ProgressBar f4640a;
    final /* synthetic */ l b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(l lVar, ProgressBar progressBar) {
        this.b = lVar;
        this.f4640a = progressBar;
    }

    @Override // com.nexstreaming.app.general.task.Task.OnTaskEventListener
    public void onTaskEvent(Task task, Task.Event event) {
        this.f4640a.setVisibility(4);
        this.f4640a.setProgress(0);
    }
}
