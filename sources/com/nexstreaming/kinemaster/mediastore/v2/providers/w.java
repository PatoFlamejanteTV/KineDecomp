package com.nexstreaming.kinemaster.mediastore.v2.providers;

import com.nexstreaming.app.general.task.ResultTask;
import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.kinemaster.mediastore.v2.MediaStoreItem;
import com.nexstreaming.kinemaster.mediastore.v2.RemoteMediaInfo;
import com.nextreaming.nexeditorui.EditorGlobal;
import com.nextreaming.nexvideoeditor.NexEditor;

/* compiled from: GoogleDriveMediaStoreProvider.java */
/* loaded from: classes.dex */
class w implements ResultTask.OnResultAvailableListener<RemoteMediaInfo> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ com.nexstreaming.kinemaster.mediastore.v2.a f3596a;
    final /* synthetic */ ResultTask b;
    final /* synthetic */ u c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(u uVar, com.nexstreaming.kinemaster.mediastore.v2.a aVar, ResultTask resultTask) {
        this.c = uVar;
        this.f3596a = aVar;
        this.b = resultTask;
    }

    @Override // com.nexstreaming.app.general.task.ResultTask.OnResultAvailableListener
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onResultAvailable(ResultTask<RemoteMediaInfo> resultTask, Task.Event event, RemoteMediaInfo remoteMediaInfo) {
        this.f3596a.f(remoteMediaInfo.a());
        this.f3596a.c(remoteMediaInfo.f());
        this.f3596a.a(remoteMediaInfo.b(), remoteMediaInfo.c());
        this.f3596a.e((int) Math.min(2147483647L, remoteMediaInfo.d()));
        if (!remoteMediaInfo.e()) {
            this.f3596a.a(MediaStoreItem.MediaSupportType.NotSupported_VideoCodec);
        } else if (!remoteMediaInfo.g()) {
            this.f3596a.a(MediaStoreItem.MediaSupportType.NotSupported_AudioCodec);
        } else {
            NexEditor a2 = EditorGlobal.a();
            if (a2 == null) {
                this.b.sendFailure(null);
                return;
            }
            switch (a2.d().a(remoteMediaInfo.h(), remoteMediaInfo.i(), remoteMediaInfo.b(), remoteMediaInfo.c(), remoteMediaInfo.a(), 0, 0, 0)) {
                case 0:
                    this.f3596a.a(MediaStoreItem.MediaSupportType.Supported);
                    break;
                case 1:
                    this.f3596a.a(MediaStoreItem.MediaSupportType.NeedTranscodeRes);
                    break;
                case 2:
                    this.f3596a.a(MediaStoreItem.MediaSupportType.NeedTranscodeFPS);
                    break;
                case 3:
                    this.f3596a.a(MediaStoreItem.MediaSupportType.NotSupported_VideoProfile);
                    break;
                case 4:
                    this.f3596a.a(MediaStoreItem.MediaSupportType.NotSupported_ResolutionTooHigh);
                    break;
                default:
                    this.f3596a.a(MediaStoreItem.MediaSupportType.Unknown);
                    break;
            }
        }
        this.b.sendResult(this.f3596a.p());
    }
}
