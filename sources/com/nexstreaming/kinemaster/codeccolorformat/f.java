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

    /* renamed from: a */
    private g f20163a;

    /* renamed from: b */
    private MediaCodec f20164b = MediaCodec.createEncoderByType("video/avc");

    /* renamed from: c */
    private byte[] f20165c;

    /* renamed from: d */
    private byte[] f20166d;

    /* renamed from: e */
    private ByteBuffer[] f20167e;

    /* renamed from: f */
    private ByteBuffer[] f20168f;

    public f(int i, int i2) throws IOException {
        MediaFormat createVideoFormat = MediaFormat.createVideoFormat("video/avc", i, i2);
        createVideoFormat.setInteger("bitrate", 125000);
        createVideoFormat.setInteger("frame-rate", 30);
        createVideoFormat.setInteger("color-format", 21);
        createVideoFormat.setInteger("i-frame-interval", 5);
        this.f20164b.configure(createVideoFormat, (Surface) null, (MediaCrypto) null, 1);
        this.f20164b.start();
        this.f20167e = this.f20164b.getInputBuffers();
        this.f20168f = this.f20164b.getOutputBuffers();
    }

    public void a() throws IOException {
        this.f20164b.stop();
        this.f20164b.release();
    }

    public boolean a(byte[] bArr, long j) {
        MediaCodec mediaCodec = this.f20164b;
        if (mediaCodec != null && this.f20167e != null && this.f20168f != null && this.f20163a != null) {
            ByteBuffer[] inputBuffers = mediaCodec.getInputBuffers();
            ByteBuffer[] outputBuffers = this.f20164b.getOutputBuffers();
            int dequeueInputBuffer = this.f20164b.dequeueInputBuffer(-1L);
            if (dequeueInputBuffer >= 0) {
                ByteBuffer byteBuffer = inputBuffers[dequeueInputBuffer];
                byteBuffer.clear();
                if (bArr != null) {
                    byteBuffer.put(bArr);
                    this.f20164b.queueInputBuffer(dequeueInputBuffer, 0, bArr.length, j, 0);
                } else {
                    this.f20164b.queueInputBuffer(dequeueInputBuffer, 0, 0, j, 4);
                }
            }
            MediaCodec.BufferInfo bufferInfo = new MediaCodec.BufferInfo();
            int dequeueOutputBuffer = this.f20164b.dequeueOutputBuffer(bufferInfo, 10000L);
            byte b2 = 1;
            if (dequeueOutputBuffer == -3) {
                this.f20164b.getOutputBuffers();
                this.f20163a.a(1);
                return true;
            }
            int i = 2;
            if (dequeueOutputBuffer == -2) {
                this.f20163a.a(2);
            } else if (dequeueOutputBuffer != -1) {
                while (true) {
                    if (dequeueOutputBuffer < 0) {
                        break;
                    }
                    if ((bufferInfo.flags & 4) != 0) {
                        this.f20163a.a(4);
                    }
                    ByteBuffer byteBuffer2 = outputBuffers[dequeueOutputBuffer];
                    if (byteBuffer2 == null) {
                        Log.w("WrapMediaEncoder", "Output buffer is null!");
                        break;
                    }
                    if (bufferInfo.size <= 0) {
                        Log.w("WrapMediaEncoder", "Output was not available!");
                        break;
                    }
                    byteBuffer2.position(bufferInfo.offset);
                    byteBuffer2.limit(bufferInfo.offset + bufferInfo.size);
                    if ((bufferInfo.flags & i) != 0) {
                        byte[] bArr2 = new byte[bufferInfo.size];
                        byteBuffer2.get(bArr2);
                        ByteBuffer wrap = ByteBuffer.wrap(bArr2);
                        if (wrap.getInt() == b2) {
                            System.out.println("parsing sps/pps");
                        } else {
                            System.out.println("something is amiss?");
                        }
                        while (true) {
                            if (wrap.get() == 0 && wrap.get() == 0 && wrap.get() == 0 && wrap.get() == b2) {
                                break;
                            }
                        }
                        int position = wrap.position();
                        this.f20165c = new byte[(position - 8) + 4];
                        byte[] bArr3 = this.f20165c;
                        bArr3[0] = 0;
                        bArr3[b2] = 0;
                        bArr3[i] = 0;
                        bArr3[3] = b2;
                        System.arraycopy(bArr2, 4, bArr3, 4, bArr3.length - 4);
                        this.f20166d = new byte[(bArr2.length - position) + 4];
                        byte[] bArr4 = this.f20166d;
                        bArr4[0] = 0;
                        bArr4[b2] = 0;
                        bArr4[i] = 0;
                        bArr4[3] = b2;
                        System.arraycopy(bArr2, position, bArr4, 4, bArr4.length - 4);
                        this.f20163a.a(this.f20165c, this.f20166d);
                        this.f20164b.releaseOutputBuffer(dequeueOutputBuffer, false);
                        dequeueOutputBuffer = this.f20164b.dequeueOutputBuffer(bufferInfo, 10000L);
                    } else {
                        byte[] bArr5 = new byte[bufferInfo.size];
                        byteBuffer2.get(bArr5);
                        this.f20163a.a(bArr5, 0, bArr5.length, bufferInfo.presentationTimeUs);
                        this.f20164b.releaseOutputBuffer(dequeueOutputBuffer, false);
                        dequeueOutputBuffer = this.f20164b.dequeueOutputBuffer(bufferInfo, 10000L);
                        b2 = 1;
                        i = 2;
                    }
                }
            } else {
                this.f20163a.a(3);
            }
            return true;
        }
        Log.w("WrapMediaEncoder", "Media codec did not initailize");
        return false;
    }

    public void a(g gVar) {
        this.f20163a = gVar;
    }
}
