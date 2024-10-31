package com.nexstreaming.kinemaster.mediainfo;

import com.nexstreaming.app.general.task.ResultTask;
import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.kinemaster.mediainfo.MediaInfo;
import com.nextreaming.nexvideoeditor.NexEditor;
import java.io.File;
import java.util.Deque;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MediaInfo.java */
/* renamed from: com.nexstreaming.kinemaster.mediainfo.c, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C1785c implements ResultTask.OnResultAvailableListener<L> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ MediaInfo f20737a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C1785c(MediaInfo mediaInfo) {
        this.f20737a = mediaInfo;
    }

    @Override // com.nexstreaming.app.general.task.ResultTask.OnResultAvailableListener
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onResultAvailable(ResultTask<L> resultTask, Task.Event event, L l) {
        NexEditor da;
        Deque deque;
        MediaInfo.c cVar;
        Deque deque2;
        File file;
        File file2;
        MediaInfo.c cVar2;
        MediaInfo.c cVar3;
        if (l != null) {
            cVar3 = this.f20737a.F;
            cVar3.sendResult(l);
            return;
        }
        da = MediaInfo.da();
        if (da != null) {
            deque2 = MediaInfo.j;
            if (deque2.isEmpty()) {
                file = this.f20737a.t;
                file2 = this.f20737a.A;
                cVar2 = this.f20737a.F;
                da.a(file, file2, cVar2.getTaskId());
                return;
            }
        }
        deque = MediaInfo.j;
        cVar = this.f20737a.F;
        deque.add(cVar);
    }
}
