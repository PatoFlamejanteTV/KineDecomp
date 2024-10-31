package com.nexstreaming.kinemaster.codeccolorformat;

import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.util.Log;
import android.view.Surface;
import java.io.IOException;
import java.nio.ByteBuffer;

/* compiled from: WrapMediaDecoder.java */
/* loaded from: classes.dex */
public class e extends d {

    /* renamed from: a, reason: collision with root package name */
    private g f3290a;
    private int b;
    private MediaCodec c;
    private Surface d;
    private MediaFormat e;
    private int f;
    private int g;
    private ByteBuffer[] h;
    private ByteBuffer[] i;

    public e(MediaFormat mediaFormat, Surface surface) throws IOException {
        this.b = 1;
        String string = mediaFormat.getString("mime");
        this.c = MediaCodec.createDecoderByType(string);
        if (this.c == null) {
            Log.e("WrapMediaDecoder", "Can't create media codec!");
            return;
        }
        this.c.configure(mediaFormat, surface, (MediaCrypto) null, 0);
        if (string.startsWith("video/")) {
            this.d = surface;
            this.b = 0;
        }
        this.c.start();
        this.h = this.c.getInputBuffers();
        this.i = this.c.getOutputBuffers();
        this.f = mediaFormat.getInteger("width");
        this.g = mediaFormat.getInteger("height");
    }

    public void a() throws IOException {
        this.c.stop();
        this.c.release();
    }

    public boolean a(byte[] bArr, long j) {
        if (this.c == null || this.h == null || this.i == null || this.f3290a == null) {
            Log.e("WrapMediaDecoder", "Media codec did not initailize");
            return false;
        }
        int dequeueInputBuffer = this.c.dequeueInputBuffer(-1L);
        if (dequeueInputBuffer >= 0) {
            if (bArr == null || bArr.length <= 0) {
                this.c.queueInputBuffer(dequeueInputBuffer, 0, 0, j, 4);
            } else {
                ByteBuffer byteBuffer = this.h[dequeueInputBuffer];
                byteBuffer.clear();
                byteBuffer.put(bArr);
                this.c.queueInputBuffer(dequeueInputBuffer, 0, bArr.length, j, 0);
            }
        }
        b();
        return true;
    }

    public boolean a(ByteBuffer byteBuffer, long j) {
        if (this.c == null || this.h == null || this.i == null || this.f3290a == null) {
            Log.e("WrapMediaDecoder", "Media codec did not initailize");
            return false;
        }
        int dequeueInputBuffer = this.c.dequeueInputBuffer(10000L);
        if (dequeueInputBuffer >= 0) {
            if (byteBuffer == null) {
                this.c.queueInputBuffer(dequeueInputBuffer, 0, 0, j, 4);
            } else {
                ByteBuffer byteBuffer2 = this.h[dequeueInputBuffer];
                byteBuffer2.clear();
                byteBuffer2.put(byteBuffer);
                this.c.queueInputBuffer(dequeueInputBuffer, 0, byteBuffer.limit(), j, 0);
            }
        }
        b();
        return true;
    }

    public boolean b() {
        boolean a2;
        MediaCodec.BufferInfo bufferInfo = new MediaCodec.BufferInfo();
        int dequeueOutputBuffer = this.c.dequeueOutputBuffer(bufferInfo, 10000L);
        switch (dequeueOutputBuffer) {
            case -3:
                this.i = this.c.getOutputBuffers();
                this.f3290a.a(1);
                return true;
            case -2:
                this.e = this.c.getOutputFormat();
                if (this.e != null) {
                    this.f = this.e.getInteger("width");
                    this.g = this.e.getInteger("height");
                }
                this.f3290a.a(2);
                return true;
            case -1:
                this.f3290a.a(3);
                return true;
            default:
                int i = dequeueOutputBuffer;
                while (true) {
                    if (i >= 0) {
                        if ((bufferInfo.flags & 4) != 0) {
                            this.f3290a.a(4);
                        }
                        ByteBuffer byteBuffer = this.i[i];
                        if (byteBuffer == null) {
                            this.c.releaseOutputBuffer(i, true);
                            Log.w("WrapMediaDecoder", "OutputBuffer was not available");
                        } else if (bufferInfo.size <= 0) {
                            this.c.releaseOutputBuffer(i, true);
                            Log.w("WrapMediaDecoder", "Output was not available!");
                        } else {
                            if (this.d != null) {
                                a2 = this.f3290a.a(this.b, bufferInfo.presentationTimeUs);
                            } else {
                                byte[] bArr = new byte[bufferInfo.size];
                                byteBuffer.get(bArr);
                                byteBuffer.position(0);
                                a2 = this.f3290a.a(bArr, this.b, bArr.length, bufferInfo.presentationTimeUs);
                            }
                            this.c.releaseOutputBuffer(i, a2);
                            i = this.c.dequeueOutputBuffer(bufferInfo, 10000L);
                        }
                    }
                }
                return true;
        }
    }

    public void a(g gVar) {
        this.f3290a = gVar;
    }

    public int c() {
        return this.f;
    }

    public int d() {
        return this.g;
    }
}
