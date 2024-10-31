package com.adobe.xmp.a;

import java.io.IOException;
import java.io.PushbackReader;
import java.io.Reader;

/* compiled from: FixASCIIControlsReader.java */
/* loaded from: classes.dex */
public class d extends PushbackReader {

    /* renamed from: a */
    private int f7507a;

    /* renamed from: b */
    private int f7508b;

    /* renamed from: c */
    private int f7509c;

    public d(Reader reader) {
        super(reader, 8);
        this.f7507a = 0;
        this.f7508b = 0;
        this.f7509c = 0;
    }

    private char a(char c2) {
        int i;
        int i2 = this.f7507a;
        if (i2 == 0) {
            if (c2 == '&') {
                this.f7507a = 1;
            }
            return c2;
        }
        if (i2 == 1) {
            if (c2 == '#') {
                this.f7507a = 2;
            } else {
                this.f7507a = 5;
            }
            return c2;
        }
        if (i2 == 2) {
            if (c2 == 'x') {
                this.f7508b = 0;
                this.f7509c = 0;
                this.f7507a = 3;
            } else if ('0' <= c2 && c2 <= '9') {
                this.f7508b = Character.digit(c2, 10);
                this.f7509c = 1;
                this.f7507a = 4;
            } else {
                this.f7507a = 5;
            }
            return c2;
        }
        if (i2 == 3) {
            if (('0' <= c2 && c2 <= '9') || (('a' <= c2 && c2 <= 'f') || ('A' <= c2 && c2 <= 'F'))) {
                this.f7508b = (this.f7508b * 16) + Character.digit(c2, 16);
                this.f7509c++;
                if (this.f7509c <= 4) {
                    this.f7507a = 3;
                } else {
                    this.f7507a = 5;
                }
            } else if (c2 == ';' && k.a((char) this.f7508b)) {
                this.f7507a = 0;
                i = this.f7508b;
            } else {
                this.f7507a = 5;
            }
            return c2;
        }
        if (i2 != 4) {
            if (i2 != 5) {
                return c2;
            }
            this.f7507a = 0;
            return c2;
        }
        if ('0' <= c2 && c2 <= '9') {
            this.f7508b = (this.f7508b * 10) + Character.digit(c2, 10);
            this.f7509c++;
            if (this.f7509c <= 5) {
                this.f7507a = 4;
            } else {
                this.f7507a = 5;
            }
        } else if (c2 == ';' && k.a((char) this.f7508b)) {
            this.f7507a = 0;
            i = this.f7508b;
        } else {
            this.f7507a = 5;
        }
        return c2;
        return (char) i;
    }

    @Override // java.io.PushbackReader, java.io.FilterReader, java.io.Reader
    public int read(char[] cArr, int i, int i2) throws IOException {
        char[] cArr2 = new char[8];
        int i3 = i;
        boolean z = true;
        int i4 = 0;
        loop0: while (true) {
            int i5 = 0;
            while (z && i4 < i2) {
                z = super.read(cArr2, i5, 1) == 1;
                if (z) {
                    char a2 = a(cArr2[i5]);
                    int i6 = this.f7507a;
                    if (i6 == 0) {
                        if (k.a(a2)) {
                            a2 = ' ';
                        }
                        cArr[i3] = a2;
                        i4++;
                        i3++;
                    } else if (i6 == 5) {
                        unread(cArr2, 0, i5 + 1);
                    } else {
                        i5++;
                    }
                } else if (i5 > 0) {
                    unread(cArr2, 0, i5);
                    this.f7507a = 5;
                    z = true;
                }
            }
        }
        if (i4 > 0 || z) {
            return i4;
        }
        return -1;
    }
}
