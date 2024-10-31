package com.nextreaming.nexeditorui;

import com.nexstreaming.app.general.task.ResultTask;
import com.nexstreaming.app.general.task.Task;

/* compiled from: NexVideoClipItem.java */
/* loaded from: classes.dex */
class dl implements ResultTask.OnResultAvailableListener<int[]> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ NexVideoClipItem f4601a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dl(NexVideoClipItem nexVideoClipItem) {
        this.f4601a = nexVideoClipItem;
    }

    @Override // com.nexstreaming.app.general.task.ResultTask.OnResultAvailableListener
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onResultAvailable(ResultTask<int[]> resultTask, Task.Event event, int[] iArr) {
        this.f4601a.l = false;
        this.f4601a.k = iArr;
    }
}
