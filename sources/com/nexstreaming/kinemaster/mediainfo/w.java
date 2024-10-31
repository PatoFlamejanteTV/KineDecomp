package com.nexstreaming.kinemaster.mediainfo;

import com.nexstreaming.app.general.task.ResultTask;
import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.kinemaster.mediainfo.MediaInfo;

/* compiled from: MediaInfo.java */
/* loaded from: classes.dex */
class w implements ResultTask.OnResultAvailableListener<MediaInfo.a> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ x f20762a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(x xVar) {
        this.f20762a = xVar;
    }

    @Override // com.nexstreaming.app.general.task.ResultTask.OnResultAvailableListener
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onResultAvailable(ResultTask<MediaInfo.a> resultTask, Task.Event event, MediaInfo.a aVar) {
        MediaInfo.c cVar;
        MediaInfo.c cVar2;
        if (aVar == null || aVar.f20682d == null || aVar.f20679a <= 0 || aVar.f20680b <= 0 || aVar.f20681c == null) {
            cVar = this.f20762a.f20763a.f20764a.E;
            cVar.sendFailure(null);
        } else {
            cVar2 = this.f20762a.f20763a.f20764a.E;
            cVar2.sendResult(new U(aVar.f20682d, aVar.f20679a, aVar.f20680b, aVar.f20681c));
        }
    }
}
