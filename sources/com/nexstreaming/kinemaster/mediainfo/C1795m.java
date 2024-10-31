package com.nexstreaming.kinemaster.mediainfo;

import com.nexstreaming.kinemaster.mediainfo.MediaInfo;
import com.nextreaming.nexvideoeditor.NexEditor;

/* compiled from: MediaInfo.java */
/* renamed from: com.nexstreaming.kinemaster.mediainfo.m, reason: case insensitive filesystem */
/* loaded from: classes.dex */
class C1795m implements NexEditor.l {
    @Override // com.nextreaming.nexvideoeditor.NexEditor.l
    public void a(int i, int i2, int i3, int i4, int i5, byte[] bArr, int i6, int i7, int i8) {
        MediaInfo.c cVar = (MediaInfo.c) MediaInfo.l.get(i8);
        if (cVar != null) {
            cVar.a(i, i2, i3, i4, i5, bArr, i6, i7);
        }
    }
}
