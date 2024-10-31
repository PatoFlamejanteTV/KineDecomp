package com.nexstreaming.kinemaster.mediainfo;

import com.nexstreaming.app.general.task.Task;
import java.io.File;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MediaInfo.java */
/* loaded from: classes.dex */
public class b extends an {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Task f3499a;
    final /* synthetic */ MediaInfo b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(MediaInfo mediaInfo, File file, File file2, File file3, File file4, Task task) {
        super(file, file2, file3, file4);
        this.b = mediaInfo;
        this.f3499a = task;
    }

    @Override // com.nexstreaming.kinemaster.mediainfo.an
    protected void a() {
        File file;
        file = this.b.i;
        file.delete();
        this.f3499a.signalEvent(Task.Event.SUCCESS, Task.Event.COMPLETE);
    }

    @Override // com.nexstreaming.kinemaster.mediainfo.an
    protected void a(Task.TaskError taskError) {
        File file;
        file = this.b.i;
        file.delete();
        this.f3499a.sendFailure(taskError);
    }
}
