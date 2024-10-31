package com.nexstreaming.kinemaster.mediainfo;

import com.nexstreaming.kinemaster.mediainfo.MediaInfo;
import com.nextreaming.nexvideoeditor.NexEditor;

/* compiled from: MediaInfo.java */
/* renamed from: com.nexstreaming.kinemaster.mediainfo.n, reason: case insensitive filesystem */
/* loaded from: classes.dex */
class C1796n implements NexEditor.k {
    @Override // com.nextreaming.nexvideoeditor.NexEditor.k
    public void a(NexEditor.b bVar, int i) {
        MediaInfo.c cVar = (MediaInfo.c) MediaInfo.l.get(i);
        if (cVar != null) {
            cVar.a(bVar);
        }
    }
}
