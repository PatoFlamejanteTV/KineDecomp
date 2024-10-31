package com.nexstreaming.kinemaster.mediainfo;

import com.nexstreaming.kinemaster.mediainfo.MediaInfo;
import com.nextreaming.nexvideoeditor.NexEditor;

/* compiled from: MediaInfo.java */
/* loaded from: classes.dex */
final class l implements NexEditor.k {
    @Override // com.nextreaming.nexvideoeditor.NexEditor.k
    public void a(int i, int i2, int i3, int i4, int i5, byte[] bArr, int i6, int i7, int i8) {
        MediaInfo.c cVar = (MediaInfo.c) MediaInfo.D.get(i8);
        if (cVar != null) {
            cVar.a(i, i2, i3, i4, i5, bArr, i6, i7);
        }
    }
}
