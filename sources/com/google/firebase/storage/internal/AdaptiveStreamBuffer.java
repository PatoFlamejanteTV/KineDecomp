package com.google.firebase.storage.internal;

import android.util.Log;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: com.google.firebase:firebase-storage@@16.0.5 */
/* loaded from: classes2.dex */
public class AdaptiveStreamBuffer {

    /* renamed from: a */
    private static final Runtime f18157a = Runtime.getRuntime();

    /* renamed from: b */
    private final InputStream f18158b;

    /* renamed from: c */
    private byte[] f18159c;

    /* renamed from: d */
    private int f18160d = 0;

    /* renamed from: f */
    private boolean f18162f = true;

    /* renamed from: e */
    private boolean f18161e = false;

    public AdaptiveStreamBuffer(InputStream inputStream, int i) {
        this.f18158b = inputStream;
        this.f18159c = new byte[i];
    }

    public int a() {
        return this.f18160d;
    }

    public int b(int i) throws IOException {
        if (i > this.f18159c.length) {
            i = Math.min(i, c(i));
        }
        while (true) {
            int i2 = this.f18160d;
            if (i2 >= i) {
                break;
            }
            int read = this.f18158b.read(this.f18159c, i2, i - i2);
            if (read == -1) {
                this.f18161e = true;
                break;
            }
            this.f18160d += read;
        }
        return this.f18160d;
    }

    public byte[] c() {
        return this.f18159c;
    }

    public boolean d() {
        return this.f18161e;
    }

    private int c(int i) {
        int max = Math.max(this.f18159c.length * 2, i);
        long maxMemory = f18157a.maxMemory() - (f18157a.totalMemory() - f18157a.freeMemory());
        if (this.f18162f && max < maxMemory) {
            try {
                byte[] bArr = new byte[max];
                System.arraycopy(this.f18159c, 0, bArr, 0, this.f18160d);
                this.f18159c = bArr;
            } catch (OutOfMemoryError unused) {
                Log.w("AdaptiveStreamBuffer", "Turning off adaptive buffer resizing due to low memory.");
                this.f18162f = false;
            }
        } else {
            Log.w("AdaptiveStreamBuffer", "Turning off adaptive buffer resizing to conserve memory.");
        }
        return this.f18159c.length;
    }

    public int a(int i) throws IOException {
        int i2 = this.f18160d;
        if (i <= i2) {
            this.f18160d = i2 - i;
            byte[] bArr = this.f18159c;
            System.arraycopy(bArr, i, bArr, 0, this.f18160d);
            return i;
        }
        this.f18160d = 0;
        int i3 = this.f18160d;
        while (i3 < i) {
            int skip = (int) this.f18158b.skip(i - i3);
            if (skip > 0) {
                i3 += skip;
            } else if (skip != 0) {
                continue;
            } else {
                if (this.f18158b.read() == -1) {
                    break;
                }
                i3++;
            }
        }
        return i3;
    }

    public void b() throws IOException {
        this.f18158b.close();
    }
}
