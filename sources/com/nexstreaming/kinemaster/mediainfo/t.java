package com.nexstreaming.kinemaster.mediainfo;

import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.kinemaster.mediainfo.MediaInfo;
import com.nextreaming.nexvideoeditor.NexEditor;
import java.util.Deque;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MediaInfo.java */
/* loaded from: classes.dex */
public class t implements MediaInfo.d<aq, MediaInfo.f> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ MediaInfo f3513a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(MediaInfo mediaInfo) {
        this.f3513a = mediaInfo;
    }

    @Override // com.nexstreaming.kinemaster.mediainfo.MediaInfo.d
    public void a(MediaInfo.c<aq, MediaInfo.f> cVar, NexEditor.b bVar) {
        Task V;
        MediaInfo.c cVar2;
        Deque deque;
        Deque deque2;
        if (bVar == NexEditor.b.f4793a) {
            MediaInfo.aa();
            V = this.f3513a.V();
            V.onComplete(new v(this)).onFailure(new u(this));
            return;
        }
        cVar.f3485a--;
        if (cVar.f3485a > 0) {
            deque = MediaInfo.z;
            deque.add(cVar);
            deque2 = MediaInfo.z;
            if (deque2.size() <= 1 && bVar != NexEditor.b.C) {
                MediaInfo.aa();
                return;
            }
            return;
        }
        cVar2 = this.f3513a.n;
        cVar2.sendFailure(bVar);
    }
}
