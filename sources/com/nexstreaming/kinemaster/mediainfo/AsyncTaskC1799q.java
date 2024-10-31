package com.nexstreaming.kinemaster.mediainfo;

import com.nexstreaming.app.general.task.Task;
import java.io.File;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MediaInfo.java */
/* renamed from: com.nexstreaming.kinemaster.mediainfo.q, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class AsyncTaskC1799q extends Q {
    final /* synthetic */ Task j;
    final /* synthetic */ MediaInfo k;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AsyncTaskC1799q(MediaInfo mediaInfo, File file, File file2, File file3, File file4, Task task) {
        super(file, file2, file3, file4);
        this.k = mediaInfo;
        this.j = task;
    }

    @Override // com.nexstreaming.kinemaster.mediainfo.Q
    protected void a() {
        File file;
        file = this.k.z;
        file.delete();
        this.j.signalEvent(Task.Event.SUCCESS, Task.Event.COMPLETE);
    }

    @Override // com.nexstreaming.kinemaster.mediainfo.Q
    protected void a(Task.TaskError taskError) {
        File file;
        file = this.k.z;
        file.delete();
        this.j.sendFailure(taskError);
    }
}
