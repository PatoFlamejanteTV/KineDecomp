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

    /* renamed from: a */
    private g f20155a;

    /* renamed from: b */
    private int f20156b;

    /* renamed from: c */
    private MediaCodec f20157c;

    /* renamed from: d */
    private Surface f20158d;

    /* renamed from: e */
    private MediaFormat f20159e;

    /* renamed from: f */
    private int f20160f;

    /* renamed from: g */
    private int f20161g;

    /* renamed from: h */
    private ByteBuffer[] f20162h;
    private ByteBuffer[] i;

    public e(MediaFormat mediaFormat, Surface surface) throws IOException {
        this.f20156b = 1;
        String string = mediaFormat.getString("mime");
        this.f20157c = MediaCodec.createDecoderByType(string);
        MediaCodec mediaCodec = this.f20157c;
        if (mediaCodec == null) {
            Log.e("WrapMediaDecoder", "Can't create media codec!");
            return;
        }
        mediaCodec.configure(mediaFormat, surface, (MediaCrypto) null, 0);
        if (string.startsWith("video/")) {
            this.f20158d = surface;
            this.f20156b = 0;
        }
        this.f20157c.start();
        this.f20162h = this.f20157c.getInputBuffers();
        this.i = this.f20157c.getOutputBuffers();
        this.f20160f = mediaFormat.getInteger("width");
        this.f20161g = mediaFormat.getInteger("height");
    }

    public void a() throws IOException {
        this.f20157c.stop();
        this.f20157c.release();
    }

    public int b() {
        return this.f20161g;
    }

    public int c() {
        return this.f20160f;
    }

    public boolean d() {
        boolean a2;
        MediaCodec.BufferInfo bufferInfo = new MediaCodec.BufferInfo();
        int dequeueOutputBuffer = this.f20157c.dequeueOutputBuffer(bufferInfo, 10000L);
        if (dequeueOutputBuffer == -3) {
            this.i = this.f20157c.getOutputBuffers();
            this.f20155a.a(1);
        } else if (dequeueOutputBuffer == -2) {
            this.f20159e = this.f20157c.getOutputFormat();
            MediaFormat mediaFormat = this.f20159e;
            if (mediaFormat != null) {
                this.f20160f = mediaFormat.getInteger("width");
                this.f20161g = this.f20159e.getInteger("height");
            }
            this.f20155a.a(2);
        } else if (dequeueOutputBuffer != -1) {
            while (true) {
                if (dequeueOutputBuffer < 0) {
                    break;
                }
                if ((bufferInfo.flags & 4) != 0) {
                    this.f20155a.a(4);
                }
                ByteBuffer byteBuffer = this.i[dequeueOutputBuffer];
                if (byteBuffer == null) {
                    this.f20157c.releaseOutputBuffer(dequeueOutputBuffer, true);
                    Log.w("WrapMediaDecoder", "OutputBuffer was not available");
                    break;
                }
                int i = bufferInfo.size;
                if (i <= 0) {
                    this.f20157c.releaseOutputBuffer(dequeueOutputBuffer, true);
                    Log.w("WrapMediaDecoder", "Output was not available!");
                    break;
                }
                if (this.f20158d != null) {
                    a2 = this.f20155a.a(this.f20156b, bufferInfo.presentationTimeUs);
                } else {
                    byte[] bArr = new byte[i];
                    byteBuffer.get(bArr);
                    byteBuffer.position(0);
                    a2 = this.f20155a.a(bArr, this.f20156b, bArr.length, bufferInfo.presentationTimeUs);
                }
                this.f20157c.releaseOutputBuffer(dequeueOutputBuffer, a2);
                dequeueOutputBuffer = this.f20157c.dequeueOutputBuffer(bufferInfo, 10000L);
            }
        } else {
            this.f20155a.a(3);
        }
        return true;
    }

    public boolean a(byte[] bArr, long j) {
        MediaCodec mediaCodec = this.f20157c;
        if (mediaCodec != null && this.f20162h != null && this.i != null && this.f20155a != null) {
            int dequeueInputBuffer = mediaCodec.dequeueInputBuffer(-1L);
            if (dequeueInputBuffer >= 0) {
                if (bArr != null && bArr.length > 0) {
                    ByteBuffer byteBuffer = this.f20162h[dequeueInputBuffer];
                    byteBuffer.clear();
                    byteBuffer.put(bArr);
                    this.f20157c.queueInputBuffer(dequeueInputBuffer, 0, bArr.length, j, 0);
                } else {
                    this.f20157c.queueInputBuffer(dequeueInputBuffer, 0, 0, j, 4);
                }
            }
            d();
            return true;
        }
        Log.e("WrapMediaDecoder", "Media codec did not initailize");
        return false;
    }

    public boolean a(ByteBuffer byteBuffer, long j) {
        MediaCodec mediaCodec = this.f20157c;
        if (mediaCodec != null && this.f20162h != null && this.i != null && this.f20155a != null) {
            int dequeueInputBuffer = mediaCodec.dequeueInputBuffer(10000L);
            if (dequeueInputBuffer >= 0) {
                if (byteBuffer == null) {
                    this.f20157c.queueInputBuffer(dequeueInputBuffer, 0, 0, j, 4);
                } else {
                    ByteBuffer byteBuffer2 = this.f20162h[dequeueInputBuffer];
                    byteBuffer2.clear();
                    byteBuffer2.put(byteBuffer);
                    this.f20157c.queueInputBuffer(dequeueInputBuffer, 0, byteBuffer.limit(), j, 0);
                }
            }
            d();
            return true;
        }
        Log.e("WrapMediaDecoder", "Media codec did not initailize");
        return false;
    }

    public void a(g gVar) {
        this.f20155a = gVar;
    }
}
