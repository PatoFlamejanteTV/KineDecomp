package com.fasterxml.jackson.core.b;

import com.fasterxml.jackson.core.JsonEncoding;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.format.MatchStrength;
import java.io.ByteArrayInputStream;
import java.io.CharConversionException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

/* compiled from: ByteSourceJsonBootstrapper.java */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    protected final com.fasterxml.jackson.core.io.c f421a;
    protected final InputStream b;
    protected final byte[] c;
    protected int d;
    protected boolean e;
    protected int f;
    private int g;
    private int h;
    private final boolean i;

    public a(com.fasterxml.jackson.core.io.c cVar, InputStream inputStream) {
        this.e = true;
        this.f = 0;
        this.f421a = cVar;
        this.b = inputStream;
        this.c = cVar.e();
        this.g = 0;
        this.h = 0;
        this.d = 0;
        this.i = true;
    }

    public a(com.fasterxml.jackson.core.io.c cVar, byte[] bArr, int i, int i2) {
        this.e = true;
        this.f = 0;
        this.f421a = cVar;
        this.b = null;
        this.c = bArr;
        this.g = i;
        this.h = i + i2;
        this.d = -i;
        this.i = false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x0052, code lost:            if (d(r2 >>> 16) != false) goto L6;     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0076, code lost:            if (d(((r5.c[r5.g] & 255) << 8) | (r5.c[r5.g + 1] & 255)) != false) goto L6;     */
    /* JADX WARN: Failed to find 'out' block for switch in B:11:0x007b. Please report as an issue. */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.fasterxml.jackson.core.JsonEncoding a() throws java.io.IOException, com.fasterxml.jackson.core.JsonParseException {
        /*
            r5 = this;
            r0 = 1
            r1 = 0
            r2 = 4
            boolean r2 = r5.a(r2)
            if (r2 == 0) goto L56
            byte[] r2 = r5.c
            int r3 = r5.g
            r2 = r2[r3]
            int r2 = r2 << 24
            byte[] r3 = r5.c
            int r4 = r5.g
            int r4 = r4 + 1
            r3 = r3[r4]
            r3 = r3 & 255(0xff, float:3.57E-43)
            int r3 = r3 << 16
            r2 = r2 | r3
            byte[] r3 = r5.c
            int r4 = r5.g
            int r4 = r4 + 2
            r3 = r3[r4]
            r3 = r3 & 255(0xff, float:3.57E-43)
            int r3 = r3 << 8
            r2 = r2 | r3
            byte[] r3 = r5.c
            int r4 = r5.g
            int r4 = r4 + 3
            r3 = r3[r4]
            r3 = r3 & 255(0xff, float:3.57E-43)
            r2 = r2 | r3
            boolean r3 = r5.b(r2)
            if (r3 == 0) goto L46
        L3c:
            if (r0 != 0) goto L79
            com.fasterxml.jackson.core.JsonEncoding r0 = com.fasterxml.jackson.core.JsonEncoding.UTF8
        L40:
            com.fasterxml.jackson.core.io.c r1 = r5.f421a
            r1.a(r0)
            return r0
        L46:
            boolean r3 = r5.c(r2)
            if (r3 != 0) goto L3c
            int r2 = r2 >>> 16
            boolean r2 = r5.d(r2)
            if (r2 != 0) goto L3c
        L54:
            r0 = r1
            goto L3c
        L56:
            r2 = 2
            boolean r2 = r5.a(r2)
            if (r2 == 0) goto L54
            byte[] r2 = r5.c
            int r3 = r5.g
            r2 = r2[r3]
            r2 = r2 & 255(0xff, float:3.57E-43)
            int r2 = r2 << 8
            byte[] r3 = r5.c
            int r4 = r5.g
            int r4 = r4 + 1
            r3 = r3[r4]
            r3 = r3 & 255(0xff, float:3.57E-43)
            r2 = r2 | r3
            boolean r2 = r5.d(r2)
            if (r2 == 0) goto L54
            goto L3c
        L79:
            int r0 = r5.f
            switch(r0) {
                case 1: goto L86;
                case 2: goto L89;
                case 3: goto L7e;
                case 4: goto L93;
                default: goto L7e;
            }
        L7e:
            java.lang.RuntimeException r0 = new java.lang.RuntimeException
            java.lang.String r1 = "Internal error"
            r0.<init>(r1)
            throw r0
        L86:
            com.fasterxml.jackson.core.JsonEncoding r0 = com.fasterxml.jackson.core.JsonEncoding.UTF8
            goto L40
        L89:
            boolean r0 = r5.e
            if (r0 == 0) goto L90
            com.fasterxml.jackson.core.JsonEncoding r0 = com.fasterxml.jackson.core.JsonEncoding.UTF16_BE
            goto L40
        L90:
            com.fasterxml.jackson.core.JsonEncoding r0 = com.fasterxml.jackson.core.JsonEncoding.UTF16_LE
            goto L40
        L93:
            boolean r0 = r5.e
            if (r0 == 0) goto L9a
            com.fasterxml.jackson.core.JsonEncoding r0 = com.fasterxml.jackson.core.JsonEncoding.UTF32_BE
            goto L40
        L9a:
            com.fasterxml.jackson.core.JsonEncoding r0 = com.fasterxml.jackson.core.JsonEncoding.UTF32_LE
            goto L40
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.core.b.a.a():com.fasterxml.jackson.core.JsonEncoding");
    }

    public Reader b() throws IOException {
        InputStream eVar;
        JsonEncoding b = this.f421a.b();
        switch (b) {
            case UTF32_BE:
            case UTF32_LE:
                return new com.fasterxml.jackson.core.io.h(this.f421a, this.b, this.c, this.g, this.h, this.f421a.b().isBigEndian());
            case UTF16_BE:
            case UTF16_LE:
            case UTF8:
                InputStream inputStream = this.b;
                if (inputStream == null) {
                    eVar = new ByteArrayInputStream(this.c, this.g, this.h);
                } else {
                    eVar = this.g < this.h ? new com.fasterxml.jackson.core.io.e(this.f421a, inputStream, this.c, this.g, this.h) : inputStream;
                }
                return new InputStreamReader(eVar, b.getJavaName());
            default:
                throw new RuntimeException("Internal error");
        }
    }

    public JsonParser a(int i, com.fasterxml.jackson.core.c cVar, com.fasterxml.jackson.core.c.a aVar, com.fasterxml.jackson.core.c.b bVar, boolean z, boolean z2) throws IOException, JsonParseException {
        if (a() != JsonEncoding.UTF8 || !z) {
            return new f(this.f421a, i, b(), cVar, bVar.a(z, z2));
        }
        return new h(this.f421a, i, this.b, cVar, aVar.a(z, z2), this.c, this.g, this.h, this.i);
    }

    public static MatchStrength a(com.fasterxml.jackson.core.format.a aVar) throws IOException {
        if (!aVar.a()) {
            return MatchStrength.INCONCLUSIVE;
        }
        byte b = aVar.b();
        if (b == -17) {
            if (!aVar.a()) {
                return MatchStrength.INCONCLUSIVE;
            }
            if (aVar.b() != -69) {
                return MatchStrength.NO_MATCH;
            }
            if (!aVar.a()) {
                return MatchStrength.INCONCLUSIVE;
            }
            if (aVar.b() != -65) {
                return MatchStrength.NO_MATCH;
            }
            if (!aVar.a()) {
                return MatchStrength.INCONCLUSIVE;
            }
            b = aVar.b();
        }
        int a2 = a(aVar, b);
        if (a2 < 0) {
            return MatchStrength.INCONCLUSIVE;
        }
        if (a2 == 123) {
            int b2 = b(aVar);
            if (b2 < 0) {
                return MatchStrength.INCONCLUSIVE;
            }
            if (b2 == 34 || b2 == 125) {
                return MatchStrength.SOLID_MATCH;
            }
            return MatchStrength.NO_MATCH;
        }
        if (a2 == 91) {
            int b3 = b(aVar);
            if (b3 < 0) {
                return MatchStrength.INCONCLUSIVE;
            }
            if (b3 == 93 || b3 == 91) {
                return MatchStrength.SOLID_MATCH;
            }
            return MatchStrength.SOLID_MATCH;
        }
        MatchStrength matchStrength = MatchStrength.WEAK_MATCH;
        if (a2 != 34) {
            if (a2 > 57 || a2 < 48) {
                if (a2 == 45) {
                    int b4 = b(aVar);
                    if (b4 < 0) {
                        return MatchStrength.INCONCLUSIVE;
                    }
                    return (b4 > 57 || b4 < 48) ? MatchStrength.NO_MATCH : matchStrength;
                }
                if (a2 == 110) {
                    return a(aVar, "ull", matchStrength);
                }
                if (a2 == 116) {
                    return a(aVar, "rue", matchStrength);
                }
                if (a2 == 102) {
                    return a(aVar, "alse", matchStrength);
                }
                return MatchStrength.NO_MATCH;
            }
            return matchStrength;
        }
        return matchStrength;
    }

    private static MatchStrength a(com.fasterxml.jackson.core.format.a aVar, String str, MatchStrength matchStrength) throws IOException {
        int length = str.length();
        for (int i = 0; i < length; i++) {
            if (!aVar.a()) {
                return MatchStrength.INCONCLUSIVE;
            }
            if (aVar.b() != str.charAt(i)) {
                return MatchStrength.NO_MATCH;
            }
        }
        return matchStrength;
    }

    private static int b(com.fasterxml.jackson.core.format.a aVar) throws IOException {
        if (aVar.a()) {
            return a(aVar, aVar.b());
        }
        return -1;
    }

    private static int a(com.fasterxml.jackson.core.format.a aVar, byte b) throws IOException {
        while (true) {
            int i = b & 255;
            if (i == 32 || i == 13 || i == 10 || i == 9) {
                if (!aVar.a()) {
                    return -1;
                }
                b = aVar.b();
                int i2 = b & 255;
            } else {
                return i;
            }
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:2:0x0004. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:5:0x000e  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x003a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean b(int r6) throws java.io.IOException {
        /*
            r5 = this;
            r3 = 4
            r4 = 2
            r1 = 0
            r0 = 1
            switch(r6) {
                case -16842752: goto L34;
                case -131072: goto L24;
                case 65279: goto L19;
                case 65534: goto L2f;
                default: goto L7;
            }
        L7:
            int r2 = r6 >>> 16
            r3 = 65279(0xfeff, float:9.1475E-41)
            if (r2 != r3) goto L3a
            int r1 = r5.g
            int r1 = r1 + 2
            r5.g = r1
            r5.f = r4
            r5.e = r0
        L18:
            return r0
        L19:
            r5.e = r0
            int r1 = r5.g
            int r1 = r1 + 4
            r5.g = r1
            r5.f = r3
            goto L18
        L24:
            int r2 = r5.g
            int r2 = r2 + 4
            r5.g = r2
            r5.f = r3
            r5.e = r1
            goto L18
        L2f:
            java.lang.String r2 = "2143"
            r5.a(r2)
        L34:
            java.lang.String r2 = "3412"
            r5.a(r2)
            goto L7
        L3a:
            r3 = 65534(0xfffe, float:9.1833E-41)
            if (r2 != r3) goto L4a
            int r2 = r5.g
            int r2 = r2 + 2
            r5.g = r2
            r5.f = r4
            r5.e = r1
            goto L18
        L4a:
            int r2 = r6 >>> 8
            r3 = 15711167(0xefbbbf, float:2.2016034E-38)
            if (r2 != r3) goto L5c
            int r1 = r5.g
            int r1 = r1 + 3
            r5.g = r1
            r5.f = r0
            r5.e = r0
            goto L18
        L5c:
            r0 = r1
            goto L18
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.core.b.a.b(int):boolean");
    }

    private boolean c(int i) throws IOException {
        if ((i >> 8) == 0) {
            this.e = true;
        } else if ((16777215 & i) == 0) {
            this.e = false;
        } else if (((-16711681) & i) == 0) {
            a("3412");
        } else {
            if (((-65281) & i) != 0) {
                return false;
            }
            a("2143");
        }
        this.f = 4;
        return true;
    }

    private boolean d(int i) {
        if ((65280 & i) == 0) {
            this.e = true;
        } else {
            if ((i & 255) != 0) {
                return false;
            }
            this.e = false;
        }
        this.f = 2;
        return true;
    }

    private void a(String str) throws IOException {
        throw new CharConversionException("Unsupported UCS-4 endianness (" + str + ") detected");
    }

    protected boolean a(int i) throws IOException {
        int read;
        int i2 = this.h - this.g;
        while (i2 < i) {
            if (this.b == null) {
                read = -1;
            } else {
                read = this.b.read(this.c, this.h, this.c.length - this.h);
            }
            if (read < 1) {
                return false;
            }
            this.h += read;
            i2 = read + i2;
        }
        return true;
    }
}
