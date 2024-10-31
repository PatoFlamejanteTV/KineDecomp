package com.nexstreaming.kinemaster.codeccolorformat;

import android.media.MediaFormat;
import java.nio.ByteBuffer;
import java.util.Vector;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ColorFormatChecker.java */
/* loaded from: classes.dex */
public class b implements g {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ColorFormatChecker f3288a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(ColorFormatChecker colorFormatChecker) {
        this.f3288a = colorFormatChecker;
    }

    @Override // com.nexstreaming.kinemaster.codeccolorformat.g
    public boolean a(int i, long j) {
        return true;
    }

    @Override // com.nexstreaming.kinemaster.codeccolorformat.g
    public boolean a(byte[] bArr, int i, int i2, long j) {
        Vector vector;
        vector = this.f3288a.g;
        vector.add(bArr);
        return true;
    }

    @Override // com.nexstreaming.kinemaster.codeccolorformat.g
    public boolean a(byte[] bArr, byte[] bArr2) {
        MediaFormat mediaFormat;
        MediaFormat mediaFormat2;
        MediaFormat mediaFormat3;
        mediaFormat = this.f3288a.f;
        if (mediaFormat == null) {
            this.f3288a.f = MediaFormat.createVideoFormat("video/avc", 1280, 720);
        }
        ByteBuffer wrap = ByteBuffer.wrap(bArr);
        ByteBuffer wrap2 = ByteBuffer.wrap(bArr2);
        mediaFormat2 = this.f3288a.f;
        mediaFormat2.setByteBuffer("csd-0", wrap);
        mediaFormat3 = this.f3288a.f;
        mediaFormat3.setByteBuffer("csd-1", wrap2);
        return true;
    }

    @Override // com.nexstreaming.kinemaster.codeccolorformat.g
    public boolean a(int i) {
        if (i == 4) {
            this.f3288a.d = true;
        }
        return true;
    }
}
