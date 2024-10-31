package com.nexstreaming.kinemaster.mediainfo;

import com.nexstreaming.app.general.task.ResultTask;
import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.kinemaster.mediainfo.MediaInfo;

/* compiled from: MediaInfo.java */
/* loaded from: classes.dex */
class w implements ResultTask.OnResultAvailableListener<MediaInfo.a> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ v f3516a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(v vVar) {
        this.f3516a = vVar;
    }

    @Override // com.nexstreaming.app.general.task.ResultTask.OnResultAvailableListener
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onResultAvailable(ResultTask<MediaInfo.a> resultTask, Task.Event event, MediaInfo.a aVar) {
        MediaInfo.c cVar;
        MediaInfo.c cVar2;
        if (aVar != null) {
            cVar2 = this.f3516a.f3515a.f3513a.n;
            cVar2.sendResult(new ar(aVar.d, aVar.f3483a, aVar.b, aVar.c));
        } else {
            cVar = this.f3516a.f3515a.f3513a.n;
            cVar.sendFailure(null);
        }
    }
}
