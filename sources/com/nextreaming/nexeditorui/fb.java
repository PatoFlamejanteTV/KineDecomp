package com.nextreaming.nexeditorui;

import com.nexstreaming.app.general.task.ResultTask;
import com.nexstreaming.app.general.task.Task;

/* compiled from: NexVideoClipItem.java */
/* loaded from: classes.dex */
class fb implements ResultTask.OnResultAvailableListener<int[]> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ NexVideoClipItem f24250a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public fb(NexVideoClipItem nexVideoClipItem) {
        this.f24250a = nexVideoClipItem;
    }

    @Override // com.nexstreaming.app.general.task.ResultTask.OnResultAvailableListener
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onResultAvailable(ResultTask<int[]> resultTask, Task.Event event, int[] iArr) {
        this.f24250a.n = false;
        this.f24250a.m = iArr;
    }
}
