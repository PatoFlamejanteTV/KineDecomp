package com.adobe.creativesdk.foundation.adobeinternal.imageservice;

import com.adobe.creativesdk.foundation.internal.utils.logging.Level;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;

/* compiled from: AdobeSearchInptStreamUtil.java */
/* loaded from: classes.dex */
class u {

    /* renamed from: a */
    private static String f4060a = "SearchInput";

    /* renamed from: b */
    InputStream f4061b;

    /* renamed from: c */
    byte[] f4062c;

    /* renamed from: d */
    int f4063d;

    /* renamed from: e */
    int f4064e;

    /* renamed from: f */
    final int f4065f;

    private u(InputStream inputStream, Integer num) {
        int i;
        this.f4062c = new byte[num.intValue()];
        this.f4065f = num.intValue();
        this.f4061b = inputStream;
        try {
            i = inputStream.read(this.f4062c);
        } catch (IOException e2) {
            e2.printStackTrace();
            i = 0;
        }
        i = i < 0 ? 0 : i;
        this.f4063d = 0;
        this.f4064e = i;
    }

    public static u a(InputStream inputStream, int i) {
        return new u(inputStream, Integer.valueOf(i));
    }

    public int a(byte[] bArr) {
        for (int i = this.f4063d; i < this.f4064e - bArr.length; i++) {
            boolean z = false;
            int i2 = 0;
            while (true) {
                if (i2 >= bArr.length) {
                    z = true;
                    break;
                }
                if (this.f4062c[i + i2] != bArr[i2]) {
                    break;
                }
                i2++;
            }
            if (z) {
                return i;
            }
        }
        return -1;
    }

    private int a() {
        int i = 0;
        try {
            i = this.f4061b.read(this.f4062c, this.f4064e, this.f4065f - this.f4064e);
            if (i == -1) {
                com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.DEBUG, f4060a, "End of stream.");
                this.f4061b.close();
                this.f4061b = null;
            } else {
                this.f4064e += i;
            }
        } catch (IOException e2) {
            e2.printStackTrace();
        }
        return i;
    }

    public boolean a(OutputStream outputStream, String str) {
        if (this.f4061b == null || str.length() >= this.f4065f) {
            return false;
        }
        int length = str.length();
        try {
            byte[] bytes = str.getBytes("UTF-8");
            boolean z = false;
            int i = 0;
            while (!z && i != -1) {
                int a2 = a(bytes);
                if (a2 != -1) {
                    z = true;
                    if (outputStream != null) {
                        try {
                            outputStream.write(this.f4062c, this.f4063d, a2 - this.f4063d);
                        } catch (IOException e2) {
                            e2.printStackTrace();
                        }
                    }
                    this.f4063d = a2 + length;
                    int i2 = this.f4064e;
                    int i3 = this.f4063d;
                    this.f4064e = i2 - i3;
                    int i4 = this.f4064e;
                    if (i4 > 0) {
                        byte[] bArr = this.f4062c;
                        System.arraycopy(bArr, i3, bArr, 0, i4);
                    }
                    this.f4063d = 0;
                    a();
                } else {
                    int i5 = this.f4064e;
                    if (i5 >= length) {
                        if (outputStream != null) {
                            try {
                                outputStream.write(this.f4062c, this.f4063d, i5 - length);
                            } catch (IOException e3) {
                                e3.printStackTrace();
                            }
                        }
                        byte[] bArr2 = this.f4062c;
                        System.arraycopy(bArr2, this.f4064e - length, bArr2, 0, length);
                        this.f4063d = 0;
                        this.f4064e = length;
                    } else {
                        byte[] bArr3 = this.f4062c;
                        System.arraycopy(bArr3, this.f4063d, bArr3, 0, i5);
                        this.f4063d = 0;
                    }
                    i = a();
                    if (i == -1 && outputStream != null) {
                        try {
                            outputStream.write(this.f4062c, this.f4063d, this.f4064e);
                        } catch (IOException e4) {
                            e4.printStackTrace();
                        }
                    }
                }
            }
            return z;
        } catch (UnsupportedEncodingException e5) {
            e5.printStackTrace();
            return false;
        }
    }
}
