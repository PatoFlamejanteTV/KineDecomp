package com.nexstreaming.kinemaster.mediainfo;

import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.kinemaster.mediainfo.MediaInfo;
import com.nextreaming.nexeditorui.ExclusionList;
import com.nextreaming.nexvideoeditor.NexEditor;
import java.util.Deque;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MediaInfo.java */
/* loaded from: classes.dex */
public class y implements MediaInfo.d<T, MediaInfo.f> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ MediaInfo f20764a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(MediaInfo mediaInfo) {
        this.f20764a = mediaInfo;
    }

    @Override // com.nexstreaming.kinemaster.mediainfo.MediaInfo.d
    public void a(MediaInfo.c<T, MediaInfo.f> cVar, NexEditor.b bVar) {
        ExclusionList exclusionList;
        Task ba;
        MediaInfo.c cVar2;
        Deque deque;
        String absolutePath = ((MediaInfo.f) cVar.a()).f20696a.getAbsolutePath();
        exclusionList = MediaInfo.f20673c;
        exclusionList.remove(absolutePath);
        if (bVar == NexEditor.b.f24591b) {
            MediaInfo.ha();
            ba = this.f20764a.ba();
            ba.onComplete(new x(this)).onFailure(new v(this));
            return;
        }
        cVar.f20691a--;
        if (cVar.f20691a <= 0) {
            cVar2 = this.f20764a.E;
            cVar2.sendFailure(bVar);
            return;
        }
        deque = MediaInfo.f20678h;
        deque.add(cVar);
        if (bVar != NexEditor.b.D) {
            MediaInfo.ha();
        }
    }
}
