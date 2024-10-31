package com.nexstreaming.kinemaster.mediastore.provider;

import com.nexstreaming.app.general.task.ResultTask;
import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.kinemaster.mediainfo.CodecType;
import com.nexstreaming.kinemaster.mediastore.MediaSupportType;
import com.nexstreaming.kinemaster.mediastore.RemoteMediaInfo;
import com.nextreaming.nexeditorui.EditorGlobal;
import com.nextreaming.nexvideoeditor.NexEditor;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: GoogleDriveProvider.java */
/* loaded from: classes.dex */
public class A implements ResultTask.OnResultAvailableListener<RemoteMediaInfo> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ com.nexstreaming.kinemaster.mediastore.item.b f20927a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ ResultTask f20928b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ GoogleDriveProvider f20929c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public A(GoogleDriveProvider googleDriveProvider, com.nexstreaming.kinemaster.mediastore.item.b bVar, ResultTask resultTask) {
        this.f20929c = googleDriveProvider;
        this.f20927a = bVar;
        this.f20928b = resultTask;
    }

    @Override // com.nexstreaming.app.general.task.ResultTask.OnResultAvailableListener
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onResultAvailable(ResultTask<RemoteMediaInfo> resultTask, Task.Event event, RemoteMediaInfo remoteMediaInfo) {
        this.f20927a.d(remoteMediaInfo.b());
        this.f20927a.b(remoteMediaInfo.i());
        this.f20927a.a(remoteMediaInfo.h(), remoteMediaInfo.d());
        this.f20927a.c((int) Math.min(2147483647L, remoteMediaInfo.a()));
        if (!remoteMediaInfo.k()) {
            this.f20927a.a(MediaSupportType.NotSupported_VideoCodec);
        } else if (!remoteMediaInfo.j()) {
            this.f20927a.a(MediaSupportType.NotSupported_AudioCodec);
        } else {
            NexEditor i = EditorGlobal.i();
            if (i == null) {
                this.f20928b.sendFailure(null);
                return;
            }
            int a2 = i.i().a(remoteMediaInfo.f(), remoteMediaInfo.e(), remoteMediaInfo.h(), remoteMediaInfo.d(), remoteMediaInfo.b(), 0, 0, 0, remoteMediaInfo.g().equals("video/hevc") ? CodecType.f20660g : null, remoteMediaInfo.c());
            if (a2 == 0) {
                this.f20927a.a(MediaSupportType.Supported);
            } else if (a2 == 1) {
                this.f20927a.a(MediaSupportType.NeedTranscodeRes);
            } else if (a2 == 2) {
                this.f20927a.a(MediaSupportType.NeedTranscodeFPS);
            } else if (a2 == 3) {
                this.f20927a.a(MediaSupportType.NotSupported_VideoProfile);
            } else if (a2 != 4) {
                this.f20927a.a(MediaSupportType.Unknown);
            } else {
                this.f20927a.a(MediaSupportType.NotSupported_ResolutionTooHigh);
            }
        }
        this.f20928b.sendResult(this.f20927a.g());
    }
}
