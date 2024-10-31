package com.adobe.xmp.a;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: ByteBuffer.java */
/* loaded from: classes.dex */
public class b {

    /* renamed from: a */
    private byte[] f7502a;

    /* renamed from: b */
    private int f7503b;

    /* renamed from: c */
    private String f7504c;

    public b(int i) {
        this.f7504c = null;
        this.f7502a = new byte[i];
        this.f7503b = 0;
    }

    public InputStream a() {
        return new ByteArrayInputStream(this.f7502a, 0, this.f7503b);
    }

    public String b() {
        if (this.f7504c == null) {
            int i = this.f7503b;
            if (i < 2) {
                this.f7504c = "UTF-8";
            } else {
                byte[] bArr = this.f7502a;
                if (bArr[0] == 0) {
                    if (i >= 4 && bArr[1] == 0) {
                        if ((bArr[2] & 255) == 254 && (bArr[3] & 255) == 255) {
                            this.f7504c = "UTF-32BE";
                        } else {
                            this.f7504c = "UTF-32";
                        }
                    } else {
                        this.f7504c = "UTF-16BE";
                    }
                } else if ((bArr[0] & 255) < 128) {
                    if (bArr[1] != 0) {
                        this.f7504c = "UTF-8";
                    } else if (i >= 4 && bArr[2] == 0) {
                        this.f7504c = "UTF-32LE";
                    } else {
                        this.f7504c = "UTF-16LE";
                    }
                } else if ((bArr[0] & 255) == 239) {
                    this.f7504c = "UTF-8";
                } else if ((bArr[0] & 255) == 254) {
                    this.f7504c = "UTF-16";
                } else if (i >= 4 && bArr[2] == 0) {
                    this.f7504c = "UTF-32";
                } else {
                    this.f7504c = "UTF-16";
                }
            }
        }
        return this.f7504c;
    }

    public int c() {
        return this.f7503b;
    }

    public int a(int i) {
        if (i < this.f7503b) {
            return this.f7502a[i] & 255;
        }
        throw new IndexOutOfBoundsException("The index exceeds the valid buffer area");
    }

    public b(byte[] bArr) {
        this.f7504c = null;
        this.f7502a = bArr;
        this.f7503b = bArr.length;
    }

    public void a(byte b2) {
        b(this.f7503b + 1);
        byte[] bArr = this.f7502a;
        int i = this.f7503b;
        this.f7503b = i + 1;
        bArr[i] = b2;
    }

    public void a(byte[] bArr, int i, int i2) {
        b(this.f7503b + i2);
        System.arraycopy(bArr, i, this.f7502a, this.f7503b, i2);
        this.f7503b += i2;
    }

    public b(InputStream inputStream) throws IOException {
        this.f7504c = null;
        this.f7503b = 0;
        this.f7502a = new byte[16384];
        while (true) {
            int read = inputStream.read(this.f7502a, this.f7503b, 16384);
            if (read <= 0) {
                return;
            }
            this.f7503b += read;
            if (read != 16384) {
                return;
            } else {
                b(this.f7503b + 16384);
            }
        }
    }

    public void a(byte[] bArr) {
        a(bArr, 0, bArr.length);
    }

    private void b(int i) {
        byte[] bArr = this.f7502a;
        if (i > bArr.length) {
            this.f7502a = new byte[bArr.length * 2];
            System.arraycopy(bArr, 0, this.f7502a, 0, bArr.length);
        }
    }
}
