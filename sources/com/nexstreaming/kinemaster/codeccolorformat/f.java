package com.nexstreaming.kinemaster.codeccolorformat;

import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.util.Log;
import android.view.Surface;
import java.io.IOException;
import java.nio.ByteBuffer;

/* compiled from: WrapMediaEncoder.java */
/* loaded from: classes.dex */
public class f extends d {

    /* renamed from: a, reason: collision with root package name */
    private g f3291a;
    private MediaCodec b = MediaCodec.createEncoderByType("video/avc");
    private byte[] c;
    private byte[] d;
    private ByteBuffer[] e;
    private ByteBuffer[] f;

    public f() throws IOException {
        MediaFormat createVideoFormat = MediaFormat.createVideoFormat("video/avc", 1280, 720);
        createVideoFormat.setInteger("bitrate", 125000);
        createVideoFormat.setInteger("frame-rate", 30);
        createVideoFormat.setInteger("color-format", 21);
        createVideoFormat.setInteger("i-frame-interval", 5);
        this.b.configure(createVideoFormat, (Surface) null, (MediaCrypto) null, 1);
        this.b.start();
        this.e = this.b.getInputBuffers();
        this.f = this.b.getOutputBuffers();
    }

    public f(int i, int i2) throws IOException {
        MediaFormat createVideoFormat = MediaFormat.createVideoFormat("video/avc", i, i2);
        createVideoFormat.setInteger("bitrate", 125000);
        createVideoFormat.setInteger("frame-rate", 30);
        createVideoFormat.setInteger("color-format", 21);
        createVideoFormat.setInteger("i-frame-interval", 5);
        this.b.configure(createVideoFormat, (Surface) null, (MediaCrypto) null, 1);
        this.b.start();
        this.e = this.b.getInputBuffers();
        this.f = this.b.getOutputBuffers();
    }

    public void a() throws IOException {
        this.b.stop();
        this.b.release();
    }

    public boolean a(byte[] bArr, long j) {
        if (this.b == null || this.e == null || this.f == null || this.f3291a == null) {
            Log.w("WrapMediaEncoder", "Media codec did not initailize");
            return false;
        }
        ByteBuffer[] inputBuffers = this.b.getInputBuffers();
        ByteBuffer[] outputBuffers = this.b.getOutputBuffers();
        int dequeueInputBuffer = this.b.dequeueInputBuffer(-1L);
        if (dequeueInputBuffer >= 0) {
            ByteBuffer byteBuffer = inputBuffers[dequeueInputBuffer];
            byteBuffer.clear();
            if (bArr != null) {
                byteBuffer.put(bArr);
                this.b.queueInputBuffer(dequeueInputBuffer, 0, bArr.length, j, 0);
            } else {
                this.b.queueInputBuffer(dequeueInputBuffer, 0, 0, j, 4);
            }
        }
        MediaCodec.BufferInfo bufferInfo = new MediaCodec.BufferInfo();
        int dequeueOutputBuffer = this.b.dequeueOutputBuffer(bufferInfo, 10000L);
        switch (dequeueOutputBuffer) {
            case -3:
                this.b.getOutputBuffers();
                this.f3291a.a(1);
                return true;
            case -2:
                this.f3291a.a(2);
                return true;
            case -1:
                this.f3291a.a(3);
                return true;
            default:
                int i = dequeueOutputBuffer;
                while (true) {
                    if (i >= 0) {
                        if ((bufferInfo.flags & 4) != 0) {
                            this.f3291a.a(4);
                        }
                        ByteBuffer byteBuffer2 = outputBuffers[i];
                        if (byteBuffer2 == null) {
                            Log.w("WrapMediaEncoder", "Output buffer is null!");
                        } else if (bufferInfo.size <= 0) {
                            Log.w("WrapMediaEncoder", "Output was not available!");
                        } else {
                            byteBuffer2.position(bufferInfo.offset);
                            byteBuffer2.limit(bufferInfo.offset + bufferInfo.size);
                            if ((bufferInfo.flags & 2) != 0) {
                                byte[] bArr2 = new byte[bufferInfo.size];
                                byteBuffer2.get(bArr2);
                                ByteBuffer wrap = ByteBuffer.wrap(bArr2);
                                if (wrap.getInt() == 1) {
                                    System.out.println("parsing sps/pps");
                                } else {
                                    System.out.println("something is amiss?");
                                }
                                while (true) {
                                    if (wrap.get() == 0 && wrap.get() == 0 && wrap.get() == 0 && wrap.get() == 1) {
                                        int position = wrap.position();
                                        this.c = new byte[(position - 8) + 4];
                                        this.c[0] = 0;
                                        this.c[1] = 0;
                                        this.c[2] = 0;
                                        this.c[3] = 1;
                                        System.arraycopy(bArr2, 4, this.c, 4, this.c.length - 4);
                                        this.d = new byte[(bArr2.length - position) + 4];
                                        this.d[0] = 0;
                                        this.d[1] = 0;
                                        this.d[2] = 0;
                                        this.d[3] = 1;
                                        System.arraycopy(bArr2, position, this.d, 4, this.d.length - 4);
                                        this.f3291a.a(this.c, this.d);
                                        this.b.releaseOutputBuffer(i, false);
                                        i = this.b.dequeueOutputBuffer(bufferInfo, 10000L);
                                    }
                                }
                            } else {
                                byte[] bArr3 = new byte[bufferInfo.size];
                                byteBuffer2.get(bArr3);
                                this.f3291a.a(bArr3, 0, bArr3.length, bufferInfo.presentationTimeUs);
                                this.b.releaseOutputBuffer(i, false);
                                i = this.b.dequeueOutputBuffer(bufferInfo, 10000L);
                            }
                        }
                    }
                }
                return true;
        }
    }

    public void a(g gVar) {
        this.f3291a = gVar;
    }
}
