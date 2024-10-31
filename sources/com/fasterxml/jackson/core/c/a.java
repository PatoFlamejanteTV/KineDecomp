package com.fasterxml.jackson.core.c;

import com.fasterxml.jackson.core.JsonEncoding;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.format.MatchStrength;
import java.io.ByteArrayInputStream;
import java.io.CharConversionException;
import java.io.DataInput;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

/* compiled from: ByteSourceJsonBootstrapper.java */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    private final com.fasterxml.jackson.core.io.c f9689a;

    /* renamed from: b, reason: collision with root package name */
    private final InputStream f9690b;

    /* renamed from: c, reason: collision with root package name */
    private final byte[] f9691c;

    /* renamed from: d, reason: collision with root package name */
    private int f9692d;

    /* renamed from: e, reason: collision with root package name */
    private int f9693e;

    /* renamed from: f, reason: collision with root package name */
    private final boolean f9694f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f9695g;

    /* renamed from: h, reason: collision with root package name */
    private int f9696h;

    public a(com.fasterxml.jackson.core.io.c cVar, InputStream inputStream) {
        this.f9695g = true;
        this.f9689a = cVar;
        this.f9690b = inputStream;
        this.f9691c = cVar.b();
        this.f9692d = 0;
        this.f9693e = 0;
        this.f9694f = true;
    }

    public static int a(DataInput dataInput) throws IOException {
        int readUnsignedByte = dataInput.readUnsignedByte();
        if (readUnsignedByte != 239) {
            return readUnsignedByte;
        }
        int readUnsignedByte2 = dataInput.readUnsignedByte();
        if (readUnsignedByte2 == 187) {
            int readUnsignedByte3 = dataInput.readUnsignedByte();
            if (readUnsignedByte3 == 191) {
                return dataInput.readUnsignedByte();
            }
            throw new IOException("Unexpected byte 0x" + Integer.toHexString(readUnsignedByte3) + " following 0xEF 0xBB; should get 0xBF as part of UTF-8 BOM");
        }
        throw new IOException("Unexpected byte 0x" + Integer.toHexString(readUnsignedByte2) + " following 0xEF; should get 0xBB as part of UTF-8 BOM");
    }

    private boolean c(int i) throws IOException {
        if ((i >> 8) == 0) {
            this.f9695g = true;
        } else {
            if ((16777215 & i) != 0) {
                if (((-16711681) & i) == 0) {
                    a("3412");
                    throw null;
                }
                if ((i & (-65281)) != 0) {
                    return false;
                }
                a("2143");
                throw null;
            }
            this.f9695g = false;
        }
        this.f9696h = 4;
        return true;
    }

    private boolean d(int i) throws IOException {
        if (i == -16842752) {
            a("3412");
            throw null;
        }
        if (i == -131072) {
            this.f9692d += 4;
            this.f9696h = 4;
            this.f9695g = false;
            return true;
        }
        if (i == 65279) {
            this.f9695g = true;
            this.f9692d += 4;
            this.f9696h = 4;
            return true;
        }
        if (i == 65534) {
            a("2143");
            throw null;
        }
        int i2 = i >>> 16;
        if (i2 == 65279) {
            this.f9692d += 2;
            this.f9696h = 2;
            this.f9695g = true;
            return true;
        }
        if (i2 == 65534) {
            this.f9692d += 2;
            this.f9696h = 2;
            this.f9695g = false;
            return true;
        }
        if ((i >>> 8) != 15711167) {
            return false;
        }
        this.f9692d += 3;
        this.f9696h = 1;
        this.f9695g = true;
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x005c, code lost:            if (b((r1[r5 + 1] & 255) | ((r1[r5] & 255) << 8)) != false) goto L17;     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x003f, code lost:            if (b(r1 >>> 16) != false) goto L17;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.fasterxml.jackson.core.JsonEncoding b() throws java.io.IOException {
        /*
            r8 = this;
            r0 = 4
            boolean r1 = r8.a(r0)
            r2 = 2
            r3 = 1
            r4 = 0
            if (r1 == 0) goto L42
            byte[] r1 = r8.f9691c
            int r5 = r8.f9692d
            r6 = r1[r5]
            int r6 = r6 << 24
            int r7 = r5 + 1
            r7 = r1[r7]
            r7 = r7 & 255(0xff, float:3.57E-43)
            int r7 = r7 << 16
            r6 = r6 | r7
            int r7 = r5 + 2
            r7 = r1[r7]
            r7 = r7 & 255(0xff, float:3.57E-43)
            int r7 = r7 << 8
            r6 = r6 | r7
            int r5 = r5 + 3
            r1 = r1[r5]
            r1 = r1 & 255(0xff, float:3.57E-43)
            r1 = r1 | r6
            boolean r5 = r8.d(r1)
            if (r5 == 0) goto L32
            goto L5e
        L32:
            boolean r5 = r8.c(r1)
            if (r5 == 0) goto L39
            goto L5e
        L39:
            int r1 = r1 >>> 16
            boolean r1 = r8.b(r1)
            if (r1 == 0) goto L5f
            goto L5e
        L42:
            boolean r1 = r8.a(r2)
            if (r1 == 0) goto L5f
            byte[] r1 = r8.f9691c
            int r5 = r8.f9692d
            r6 = r1[r5]
            r6 = r6 & 255(0xff, float:3.57E-43)
            int r6 = r6 << 8
            int r5 = r5 + r3
            r1 = r1[r5]
            r1 = r1 & 255(0xff, float:3.57E-43)
            r1 = r1 | r6
            boolean r1 = r8.b(r1)
            if (r1 == 0) goto L5f
        L5e:
            r4 = 1
        L5f:
            if (r4 != 0) goto L64
            com.fasterxml.jackson.core.JsonEncoding r0 = com.fasterxml.jackson.core.JsonEncoding.UTF8
            goto L8a
        L64:
            int r1 = r8.f9696h
            if (r1 == r3) goto L88
            if (r1 == r2) goto L7e
            if (r1 != r0) goto L76
            boolean r0 = r8.f9695g
            if (r0 == 0) goto L73
            com.fasterxml.jackson.core.JsonEncoding r0 = com.fasterxml.jackson.core.JsonEncoding.UTF32_BE
            goto L8a
        L73:
            com.fasterxml.jackson.core.JsonEncoding r0 = com.fasterxml.jackson.core.JsonEncoding.UTF32_LE
            goto L8a
        L76:
            java.lang.RuntimeException r0 = new java.lang.RuntimeException
            java.lang.String r1 = "Internal error"
            r0.<init>(r1)
            throw r0
        L7e:
            boolean r0 = r8.f9695g
            if (r0 == 0) goto L85
            com.fasterxml.jackson.core.JsonEncoding r0 = com.fasterxml.jackson.core.JsonEncoding.UTF16_BE
            goto L8a
        L85:
            com.fasterxml.jackson.core.JsonEncoding r0 = com.fasterxml.jackson.core.JsonEncoding.UTF16_LE
            goto L8a
        L88:
            com.fasterxml.jackson.core.JsonEncoding r0 = com.fasterxml.jackson.core.JsonEncoding.UTF8
        L8a:
            com.fasterxml.jackson.core.io.c r1 = r8.f9689a
            r1.a(r0)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.core.c.a.b():com.fasterxml.jackson.core.JsonEncoding");
    }

    public Reader a() throws IOException {
        JsonEncoding f2 = this.f9689a.f();
        int bits = f2.bits();
        if (bits != 8 && bits != 16) {
            if (bits == 32) {
                com.fasterxml.jackson.core.io.c cVar = this.f9689a;
                return new com.fasterxml.jackson.core.io.h(cVar, this.f9690b, this.f9691c, this.f9692d, this.f9693e, cVar.f().isBigEndian());
            }
            throw new RuntimeException("Internal error");
        }
        InputStream inputStream = this.f9690b;
        if (inputStream == null) {
            inputStream = new ByteArrayInputStream(this.f9691c, this.f9692d, this.f9693e);
        } else {
            int i = this.f9692d;
            int i2 = this.f9693e;
            if (i < i2) {
                inputStream = new com.fasterxml.jackson.core.io.e(this.f9689a, inputStream, this.f9691c, i, i2);
            }
        }
        return new InputStreamReader(inputStream, f2.getJavaName());
    }

    public a(com.fasterxml.jackson.core.io.c cVar, byte[] bArr, int i, int i2) {
        this.f9695g = true;
        this.f9689a = cVar;
        this.f9690b = null;
        this.f9691c = bArr;
        this.f9692d = i;
        this.f9693e = i + i2;
        this.f9694f = false;
    }

    private static int b(com.fasterxml.jackson.core.format.a aVar) throws IOException {
        if (aVar.a()) {
            return a(aVar, aVar.nextByte());
        }
        return -1;
    }

    public JsonParser a(int i, com.fasterxml.jackson.core.c cVar, com.fasterxml.jackson.core.d.a aVar, com.fasterxml.jackson.core.d.b bVar, int i2) throws IOException {
        if (b() == JsonEncoding.UTF8 && JsonFactory.Feature.CANONICALIZE_FIELD_NAMES.enabledIn(i2)) {
            return new j(this.f9689a, i, this.f9690b, cVar, aVar.e(i2), this.f9691c, this.f9692d, this.f9693e, this.f9694f);
        }
        return new g(this.f9689a, i, a(), cVar, bVar.c(i2));
    }

    private boolean b(int i) {
        if ((65280 & i) == 0) {
            this.f9695g = true;
        } else {
            if ((i & 255) != 0) {
                return false;
            }
            this.f9695g = false;
        }
        this.f9696h = 2;
        return true;
    }

    public static MatchStrength a(com.fasterxml.jackson.core.format.a aVar) throws IOException {
        if (!aVar.a()) {
            return MatchStrength.INCONCLUSIVE;
        }
        byte nextByte = aVar.nextByte();
        if (nextByte == -17) {
            if (!aVar.a()) {
                return MatchStrength.INCONCLUSIVE;
            }
            if (aVar.nextByte() != -69) {
                return MatchStrength.NO_MATCH;
            }
            if (!aVar.a()) {
                return MatchStrength.INCONCLUSIVE;
            }
            if (aVar.nextByte() != -65) {
                return MatchStrength.NO_MATCH;
            }
            if (!aVar.a()) {
                return MatchStrength.INCONCLUSIVE;
            }
            nextByte = aVar.nextByte();
        }
        int a2 = a(aVar, nextByte);
        if (a2 < 0) {
            return MatchStrength.INCONCLUSIVE;
        }
        if (a2 == 123) {
            int b2 = b(aVar);
            if (b2 < 0) {
                return MatchStrength.INCONCLUSIVE;
            }
            if (b2 != 34 && b2 != 125) {
                return MatchStrength.NO_MATCH;
            }
            return MatchStrength.SOLID_MATCH;
        }
        if (a2 == 91) {
            int b3 = b(aVar);
            if (b3 < 0) {
                return MatchStrength.INCONCLUSIVE;
            }
            if (b3 != 93 && b3 != 91) {
                return MatchStrength.SOLID_MATCH;
            }
            return MatchStrength.SOLID_MATCH;
        }
        MatchStrength matchStrength = MatchStrength.WEAK_MATCH;
        if (a2 == 34) {
            return matchStrength;
        }
        if (a2 <= 57 && a2 >= 48) {
            return matchStrength;
        }
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

    private static MatchStrength a(com.fasterxml.jackson.core.format.a aVar, String str, MatchStrength matchStrength) throws IOException {
        int length = str.length();
        for (int i = 0; i < length; i++) {
            if (!aVar.a()) {
                return MatchStrength.INCONCLUSIVE;
            }
            if (aVar.nextByte() != str.charAt(i)) {
                return MatchStrength.NO_MATCH;
            }
        }
        return matchStrength;
    }

    private static int a(com.fasterxml.jackson.core.format.a aVar, byte b2) throws IOException {
        while (true) {
            int i = b2 & 255;
            if (i != 32 && i != 13 && i != 10 && i != 9) {
                return i;
            }
            if (!aVar.a()) {
                return -1;
            }
            b2 = aVar.nextByte();
        }
    }

    private void a(String str) throws IOException {
        throw new CharConversionException("Unsupported UCS-4 endianness (" + str + ") detected");
    }

    protected boolean a(int i) throws IOException {
        int read;
        int i2 = this.f9693e - this.f9692d;
        while (i2 < i) {
            InputStream inputStream = this.f9690b;
            if (inputStream == null) {
                read = -1;
            } else {
                byte[] bArr = this.f9691c;
                int i3 = this.f9693e;
                read = inputStream.read(bArr, i3, bArr.length - i3);
            }
            if (read < 1) {
                return false;
            }
            this.f9693e += read;
            i2 += read;
        }
        return true;
    }
}
