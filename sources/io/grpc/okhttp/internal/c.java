package io.grpc.okhttp.internal;

import javax.security.auth.x500.X500Principal;

/* compiled from: DistinguishedNameParser.java */
/* loaded from: classes3.dex */
final class c {

    /* renamed from: a */
    private final String f27896a;

    /* renamed from: b */
    private final int f27897b;

    /* renamed from: c */
    private int f27898c;

    /* renamed from: d */
    private int f27899d;

    /* renamed from: e */
    private int f27900e;

    /* renamed from: f */
    private int f27901f;

    /* renamed from: g */
    private char[] f27902g;

    public c(X500Principal x500Principal) {
        this.f27896a = x500Principal.getName("RFC2253");
        this.f27897b = this.f27896a.length();
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x00a7, code lost:            return new java.lang.String(r1, r2, r8.f27901f - r2);     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.lang.String a() {
        /*
            r8 = this;
            int r0 = r8.f27898c
            r8.f27899d = r0
            r8.f27900e = r0
        L6:
            int r0 = r8.f27898c
            int r1 = r8.f27897b
            if (r0 < r1) goto L19
            java.lang.String r0 = new java.lang.String
            char[] r1 = r8.f27902g
            int r2 = r8.f27899d
            int r3 = r8.f27900e
            int r3 = r3 - r2
            r0.<init>(r1, r2, r3)
            return r0
        L19:
            char[] r1 = r8.f27902g
            char r2 = r1[r0]
            r3 = 44
            r4 = 43
            r5 = 59
            r6 = 32
            if (r2 == r6) goto L60
            if (r2 == r5) goto L53
            r5 = 92
            if (r2 == r5) goto L40
            if (r2 == r4) goto L53
            if (r2 == r3) goto L53
            int r2 = r8.f27900e
            int r3 = r2 + 1
            r8.f27900e = r3
            char r3 = r1[r0]
            r1[r2] = r3
            int r0 = r0 + 1
            r8.f27898c = r0
            goto L6
        L40:
            int r0 = r8.f27900e
            int r2 = r0 + 1
            r8.f27900e = r2
            char r2 = r8.b()
            r1[r0] = r2
            int r0 = r8.f27898c
            int r0 = r0 + 1
            r8.f27898c = r0
            goto L6
        L53:
            java.lang.String r0 = new java.lang.String
            char[] r1 = r8.f27902g
            int r2 = r8.f27899d
            int r3 = r8.f27900e
            int r3 = r3 - r2
            r0.<init>(r1, r2, r3)
            return r0
        L60:
            int r2 = r8.f27900e
            r8.f27901f = r2
            int r0 = r0 + 1
            r8.f27898c = r0
            int r0 = r2 + 1
            r8.f27900e = r0
            r1[r2] = r6
        L6e:
            int r0 = r8.f27898c
            int r1 = r8.f27897b
            if (r0 >= r1) goto L87
            char[] r1 = r8.f27902g
            char r2 = r1[r0]
            if (r2 != r6) goto L87
            int r2 = r8.f27900e
            int r7 = r2 + 1
            r8.f27900e = r7
            r1[r2] = r6
            int r0 = r0 + 1
            r8.f27898c = r0
            goto L6e
        L87:
            int r0 = r8.f27898c
            int r1 = r8.f27897b
            if (r0 == r1) goto L9b
            char[] r1 = r8.f27902g
            char r2 = r1[r0]
            if (r2 == r3) goto L9b
            char r2 = r1[r0]
            if (r2 == r4) goto L9b
            char r0 = r1[r0]
            if (r0 != r5) goto L6
        L9b:
            java.lang.String r0 = new java.lang.String
            char[] r1 = r8.f27902g
            int r2 = r8.f27899d
            int r3 = r8.f27901f
            int r3 = r3 - r2
            r0.<init>(r1, r2, r3)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: io.grpc.okhttp.internal.c.a():java.lang.String");
    }

    private char b() {
        this.f27898c++;
        int i = this.f27898c;
        if (i != this.f27897b) {
            char c2 = this.f27902g[i];
            if (c2 != ' ' && c2 != '%' && c2 != '\\' && c2 != '_' && c2 != '\"' && c2 != '#') {
                switch (c2) {
                    case '*':
                    case '+':
                    case ',':
                        break;
                    default:
                        switch (c2) {
                            case ';':
                            case '<':
                            case '=':
                            case '>':
                                break;
                            default:
                                return c();
                        }
                }
            }
            return this.f27902g[this.f27898c];
        }
        throw new IllegalStateException("Unexpected end of DN: " + this.f27896a);
    }

    private char c() {
        int i;
        int i2;
        int a2 = a(this.f27898c);
        this.f27898c++;
        if (a2 < 128) {
            return (char) a2;
        }
        if (a2 < 192 || a2 > 247) {
            return '?';
        }
        if (a2 <= 223) {
            i2 = a2 & 31;
            i = 1;
        } else if (a2 <= 239) {
            i = 2;
            i2 = a2 & 15;
        } else {
            i = 3;
            i2 = a2 & 7;
        }
        for (int i3 = 0; i3 < i; i3++) {
            this.f27898c++;
            int i4 = this.f27898c;
            if (i4 == this.f27897b || this.f27902g[i4] != '\\') {
                return '?';
            }
            this.f27898c = i4 + 1;
            int a3 = a(this.f27898c);
            this.f27898c++;
            if ((a3 & 192) != 128) {
                return '?';
            }
            i2 = (i2 << 6) + (a3 & 63);
        }
        return (char) i2;
    }

    private String d() {
        int i = this.f27898c;
        if (i + 4 < this.f27897b) {
            this.f27899d = i;
            this.f27898c = i + 1;
            while (true) {
                int i2 = this.f27898c;
                if (i2 == this.f27897b) {
                    break;
                }
                char[] cArr = this.f27902g;
                if (cArr[i2] == '+' || cArr[i2] == ',' || cArr[i2] == ';') {
                    break;
                }
                if (cArr[i2] == ' ') {
                    this.f27900e = i2;
                    this.f27898c = i2 + 1;
                    while (true) {
                        int i3 = this.f27898c;
                        if (i3 >= this.f27897b || this.f27902g[i3] != ' ') {
                            break;
                        }
                        this.f27898c = i3 + 1;
                    }
                } else {
                    if (cArr[i2] >= 'A' && cArr[i2] <= 'F') {
                        cArr[i2] = (char) (cArr[i2] + ' ');
                    }
                    this.f27898c++;
                }
            }
            this.f27900e = this.f27898c;
            int i4 = this.f27900e;
            int i5 = this.f27899d;
            int i6 = i4 - i5;
            if (i6 >= 5 && (i6 & 1) != 0) {
                byte[] bArr = new byte[i6 / 2];
                int i7 = i5 + 1;
                for (int i8 = 0; i8 < bArr.length; i8++) {
                    bArr[i8] = (byte) a(i7);
                    i7 += 2;
                }
                return new String(this.f27902g, this.f27899d, i6);
            }
            throw new IllegalStateException("Unexpected end of DN: " + this.f27896a);
        }
        throw new IllegalStateException("Unexpected end of DN: " + this.f27896a);
    }

    private String e() {
        while (true) {
            int i = this.f27898c;
            if (i >= this.f27897b || this.f27902g[i] != ' ') {
                break;
            }
            this.f27898c = i + 1;
        }
        int i2 = this.f27898c;
        if (i2 == this.f27897b) {
            return null;
        }
        this.f27899d = i2;
        this.f27898c = i2 + 1;
        while (true) {
            int i3 = this.f27898c;
            if (i3 >= this.f27897b) {
                break;
            }
            char[] cArr = this.f27902g;
            if (cArr[i3] == '=' || cArr[i3] == ' ') {
                break;
            }
            this.f27898c = i3 + 1;
        }
        int i4 = this.f27898c;
        if (i4 < this.f27897b) {
            this.f27900e = i4;
            if (this.f27902g[i4] == ' ') {
                while (true) {
                    int i5 = this.f27898c;
                    if (i5 >= this.f27897b) {
                        break;
                    }
                    char[] cArr2 = this.f27902g;
                    if (cArr2[i5] == '=' || cArr2[i5] != ' ') {
                        break;
                    }
                    this.f27898c = i5 + 1;
                }
                char[] cArr3 = this.f27902g;
                int i6 = this.f27898c;
                if (cArr3[i6] != '=' || i6 == this.f27897b) {
                    throw new IllegalStateException("Unexpected end of DN: " + this.f27896a);
                }
            }
            this.f27898c++;
            while (true) {
                int i7 = this.f27898c;
                if (i7 >= this.f27897b || this.f27902g[i7] != ' ') {
                    break;
                }
                this.f27898c = i7 + 1;
            }
            int i8 = this.f27900e;
            int i9 = this.f27899d;
            if (i8 - i9 > 4) {
                char[] cArr4 = this.f27902g;
                if (cArr4[i9 + 3] == '.' && (cArr4[i9] == 'O' || cArr4[i9] == 'o')) {
                    char[] cArr5 = this.f27902g;
                    int i10 = this.f27899d;
                    if (cArr5[i10 + 1] == 'I' || cArr5[i10 + 1] == 'i') {
                        char[] cArr6 = this.f27902g;
                        int i11 = this.f27899d;
                        if (cArr6[i11 + 2] == 'D' || cArr6[i11 + 2] == 'd') {
                            this.f27899d += 4;
                        }
                    }
                }
            }
            char[] cArr7 = this.f27902g;
            int i12 = this.f27899d;
            return new String(cArr7, i12, this.f27900e - i12);
        }
        throw new IllegalStateException("Unexpected end of DN: " + this.f27896a);
    }

    private String f() {
        this.f27898c++;
        this.f27899d = this.f27898c;
        this.f27900e = this.f27899d;
        while (true) {
            int i = this.f27898c;
            if (i != this.f27897b) {
                char[] cArr = this.f27902g;
                if (cArr[i] == '\"') {
                    this.f27898c = i + 1;
                    while (true) {
                        int i2 = this.f27898c;
                        if (i2 >= this.f27897b || this.f27902g[i2] != ' ') {
                            break;
                        }
                        this.f27898c = i2 + 1;
                    }
                    char[] cArr2 = this.f27902g;
                    int i3 = this.f27899d;
                    return new String(cArr2, i3, this.f27900e - i3);
                }
                if (cArr[i] == '\\') {
                    cArr[this.f27900e] = b();
                } else {
                    cArr[this.f27900e] = cArr[i];
                }
                this.f27898c++;
                this.f27900e++;
            } else {
                throw new IllegalStateException("Unexpected end of DN: " + this.f27896a);
            }
        }
    }

    private int a(int i) {
        int i2;
        int i3;
        int i4 = i + 1;
        if (i4 < this.f27897b) {
            char c2 = this.f27902g[i];
            if (c2 >= '0' && c2 <= '9') {
                i2 = c2 - '0';
            } else if (c2 >= 'a' && c2 <= 'f') {
                i2 = c2 - 'W';
            } else {
                if (c2 < 'A' || c2 > 'F') {
                    throw new IllegalStateException("Malformed DN: " + this.f27896a);
                }
                i2 = c2 - '7';
            }
            char c3 = this.f27902g[i4];
            if (c3 >= '0' && c3 <= '9') {
                i3 = c3 - '0';
            } else if (c3 >= 'a' && c3 <= 'f') {
                i3 = c3 - 'W';
            } else {
                if (c3 < 'A' || c3 > 'F') {
                    throw new IllegalStateException("Malformed DN: " + this.f27896a);
                }
                i3 = c3 - '7';
            }
            return (i2 << 4) + i3;
        }
        throw new IllegalStateException("Malformed DN: " + this.f27896a);
    }

    public String a(String str) {
        String f2;
        this.f27898c = 0;
        this.f27899d = 0;
        this.f27900e = 0;
        this.f27901f = 0;
        this.f27902g = this.f27896a.toCharArray();
        String e2 = e();
        if (e2 == null) {
            return null;
        }
        do {
            int i = this.f27898c;
            if (i == this.f27897b) {
                return null;
            }
            char c2 = this.f27902g[i];
            if (c2 == '\"') {
                f2 = f();
            } else if (c2 != '#') {
                f2 = (c2 == '+' || c2 == ',' || c2 == ';') ? "" : a();
            } else {
                f2 = d();
            }
            if (str.equalsIgnoreCase(e2)) {
                return f2;
            }
            int i2 = this.f27898c;
            if (i2 >= this.f27897b) {
                return null;
            }
            char[] cArr = this.f27902g;
            if (cArr[i2] != ',' && cArr[i2] != ';' && cArr[i2] != '+') {
                throw new IllegalStateException("Malformed DN: " + this.f27896a);
            }
            this.f27898c++;
            e2 = e();
        } while (e2 != null);
        throw new IllegalStateException("Malformed DN: " + this.f27896a);
    }
}
