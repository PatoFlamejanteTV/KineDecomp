package com.nexstreaming.kinemaster.ui.previewplay;

import com.nexstreaming.app.general.task.Task;

/* compiled from: PreviewPlayActivity.java */
/* loaded from: classes.dex */
class a implements Task.OnFailListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ PreviewPlayActivity f3720a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(PreviewPlayActivity previewPlayActivity) {
        this.f3720a = previewPlayActivity;
    }

    @Override // com.nexstreaming.app.general.task.Task.OnFailListener
    public void onFail(Task task, Task.Event event, Task.TaskError taskError) {
        this.f3720a.finish();
    }
}
