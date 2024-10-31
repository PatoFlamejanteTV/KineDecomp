package com.nexstreaming.kinemaster.codeccolorformat;

import android.media.MediaFormat;
import java.nio.ByteBuffer;
import java.util.Vector;

/* compiled from: ColorFormatChecker.java */
/* loaded from: classes.dex */
public class b implements g {

    /* renamed from: a */
    final /* synthetic */ ColorFormatChecker f20153a;

    public b(ColorFormatChecker colorFormatChecker) {
        this.f20153a = colorFormatChecker;
    }

    @Override // com.nexstreaming.kinemaster.codeccolorformat.g
    public boolean a(int i, long j) {
        return true;
    }

    @Override // com.nexstreaming.kinemaster.codeccolorformat.g
    public boolean a(byte[] bArr, int i, int i2, long j) {
        Vector vector;
        vector = this.f20153a.f20149g;
        vector.add(bArr);
        return true;
    }

    @Override // com.nexstreaming.kinemaster.codeccolorformat.g
    public boolean a(byte[] bArr, byte[] bArr2) {
        MediaFormat mediaFormat;
        MediaFormat mediaFormat2;
        MediaFormat mediaFormat3;
        mediaFormat = this.f20153a.f20148f;
        if (mediaFormat == null) {
            this.f20153a.f20148f = MediaFormat.createVideoFormat("video/avc", 1280, 720);
        }
        ByteBuffer wrap = ByteBuffer.wrap(bArr);
        ByteBuffer wrap2 = ByteBuffer.wrap(bArr2);
        mediaFormat2 = this.f20153a.f20148f;
        mediaFormat2.setByteBuffer("csd-0", wrap);
        mediaFormat3 = this.f20153a.f20148f;
        mediaFormat3.setByteBuffer("csd-1", wrap2);
        return true;
    }

    @Override // com.nexstreaming.kinemaster.codeccolorformat.g
    public boolean a(int i) {
        if (i == 4) {
            this.f20153a.f20146d = true;
        }
        return true;
    }
}
