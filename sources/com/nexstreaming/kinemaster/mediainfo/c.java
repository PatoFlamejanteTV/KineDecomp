package com.nexstreaming.kinemaster.mediainfo;

import com.nexstreaming.app.general.task.ResultTask;
import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.kinemaster.mediainfo.MediaInfo;
import com.nextreaming.nexvideoeditor.NexEditor;
import java.io.File;
import java.util.Deque;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MediaInfo.java */
/* loaded from: classes.dex */
public class c implements ResultTask.OnResultAvailableListener<aj> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ MediaInfo f3500a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(MediaInfo mediaInfo) {
        this.f3500a = mediaInfo;
    }

    @Override // com.nexstreaming.app.general.task.ResultTask.OnResultAvailableListener
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onResultAvailable(ResultTask<aj> resultTask, Task.Event event, aj ajVar) {
        NexEditor X;
        Deque deque;
        MediaInfo.c cVar;
        Deque deque2;
        File file;
        File file2;
        MediaInfo.c cVar2;
        MediaInfo.c cVar3;
        if (ajVar != null) {
            cVar3 = this.f3500a.o;
            cVar3.sendResult(ajVar);
            return;
        }
        X = MediaInfo.X();
        if (X != null) {
            deque2 = MediaInfo.B;
            if (deque2.isEmpty()) {
                file = this.f3500a.c;
                file2 = this.f3500a.j;
                cVar2 = this.f3500a.o;
                X.a(file, file2, cVar2.getTaskId());
                return;
            }
        }
        deque = MediaInfo.B;
        cVar = this.f3500a.o;
        deque.add(cVar);
    }
}
