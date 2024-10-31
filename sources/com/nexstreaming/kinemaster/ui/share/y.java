package com.nexstreaming.kinemaster.ui.share;

import com.nexstreaming.app.general.task.Task;

/* compiled from: ExportManager.java */
/* loaded from: classes.dex */
class y implements Task.OnProgressListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ s f4369a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(s sVar) {
        this.f4369a = sVar;
    }

    @Override // com.nexstreaming.app.general.task.Task.OnProgressListener
    public void onProgress(Task task, Task.Event event, int i, int i2) {
        this.f4369a.b.a(i, i2);
    }
}
