package com.nexstreaming.kinemaster.mediainfo;

import com.nexstreaming.app.general.task.ResultTask;
import com.nexstreaming.kinemaster.mediainfo.MediaInfo;
import com.nextreaming.nexvideoeditor.NexEditor;
import java.util.Deque;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MediaInfo.java */
/* loaded from: classes.dex */
public class E implements MediaInfo.d<L, Void> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ MediaInfo f20664a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public E(MediaInfo mediaInfo) {
        this.f20664a = mediaInfo;
    }

    @Override // com.nexstreaming.kinemaster.mediainfo.MediaInfo.d
    public void a(MediaInfo.c<L, Void> cVar, NexEditor.b bVar) {
        ResultTask fa;
        Deque deque;
        if (bVar == NexEditor.b.f24596g) {
            deque = MediaInfo.j;
            deque.add(cVar);
        } else {
            MediaInfo.ga();
            fa = ((MediaInfo.c) cVar).f20692b.fa();
            fa.onResultAvailable(new D(this, cVar));
        }
    }
}
