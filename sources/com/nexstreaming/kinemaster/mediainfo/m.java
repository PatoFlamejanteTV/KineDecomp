package com.nexstreaming.kinemaster.mediainfo;

import com.nexstreaming.kinemaster.mediainfo.MediaInfo;
import com.nextreaming.nexvideoeditor.NexEditor;

/* compiled from: MediaInfo.java */
/* loaded from: classes.dex */
final class m implements NexEditor.j {
    @Override // com.nextreaming.nexvideoeditor.NexEditor.j
    public void a(NexEditor.b bVar, int i) {
        MediaInfo.c cVar = (MediaInfo.c) MediaInfo.D.get(i);
        if (cVar != null) {
            cVar.a(bVar);
        }
    }
}
