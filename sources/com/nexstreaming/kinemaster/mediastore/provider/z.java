package com.nexstreaming.kinemaster.mediastore.provider;

import com.nexstreaming.app.general.task.ResultTask;
import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.kinemaster.mediastore.MediaSupportType;
import com.nexstreaming.kinemaster.mediastore.RemoteMediaInfo;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: GoogleDriveProvider.java */
/* loaded from: classes.dex */
public class z implements Task.OnFailListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ com.nexstreaming.kinemaster.mediastore.item.b f21037a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ ResultTask f21038b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ GoogleDriveProvider f21039c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(GoogleDriveProvider googleDriveProvider, com.nexstreaming.kinemaster.mediastore.item.b bVar, ResultTask resultTask) {
        this.f21039c = googleDriveProvider;
        this.f21037a = bVar;
        this.f21038b = resultTask;
    }

    @Override // com.nexstreaming.app.general.task.Task.OnFailListener
    public void onFail(Task task, Task.Event event, Task.TaskError taskError) {
        if (!taskError.equals(RemoteMediaInfo.ErrorCode.NO_TRACKS) && !taskError.equals(RemoteMediaInfo.ErrorCode.BAD_MIME_TYPE)) {
            this.f21038b.sendFailure(taskError);
        } else {
            this.f21037a.a(MediaSupportType.NotSupported_Container);
            this.f21038b.sendResult(this.f21037a.g());
        }
    }
}
