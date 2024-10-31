package com.nexstreaming.kinemaster.mediastore.v2.providers;

import com.nexstreaming.app.general.task.ResultTask;
import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.kinemaster.mediastore.v2.MediaStoreItem;
import com.nexstreaming.kinemaster.mediastore.v2.RemoteMediaInfo;

/* compiled from: GoogleDriveMediaStoreProvider.java */
/* loaded from: classes.dex */
class v implements Task.OnFailListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ com.nexstreaming.kinemaster.mediastore.v2.a f3595a;
    final /* synthetic */ ResultTask b;
    final /* synthetic */ u c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(u uVar, com.nexstreaming.kinemaster.mediastore.v2.a aVar, ResultTask resultTask) {
        this.c = uVar;
        this.f3595a = aVar;
        this.b = resultTask;
    }

    @Override // com.nexstreaming.app.general.task.Task.OnFailListener
    public void onFail(Task task, Task.Event event, Task.TaskError taskError) {
        if (taskError.equals(RemoteMediaInfo.ErrorCode.NO_TRACKS) || taskError.equals(RemoteMediaInfo.ErrorCode.BAD_MIME_TYPE)) {
            this.f3595a.a(MediaStoreItem.MediaSupportType.NotSupported_Container);
            this.b.sendResult(this.f3595a.p());
        } else {
            this.b.sendFailure(taskError);
        }
    }
}
