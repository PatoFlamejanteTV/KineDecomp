package com.larvalabs.svgandroid;

/* loaded from: classes.dex */
public class a {
    private static final double[] e = new double[128];

    /* renamed from: a, reason: collision with root package name */
    public int f2981a;
    private char b;
    private CharSequence c;
    private int d;

    static {
        for (int i = 0; i < e.length; i++) {
            e[i] = Math.pow(10.0d, i);
        }
    }

    public a(CharSequence charSequence, int i) {
        this.c = charSequence;
        this.f2981a = i;
        this.d = charSequence.length();
        this.b = charSequence.charAt(i);
    }

    public static float a(int i, int i2) {
        if (i2 < -125 || i == 0) {
            return 0.0f;
        }
        if (i2 >= 128) {
            return i > 0 ? Float.POSITIVE_INFINITY : Float.NEGATIVE_INFINITY;
        }
        if (i2 == 0) {
            return i;
        }
        if (i >= 67108864) {
            i++;
        }
        return (float) (i2 > 0 ? i * e[i2] : i / e[-i2]);
    }

    private void a(char c) {
        throw new RuntimeException("Unexpected char '" + c + "'.");
    }

    private char f() {
        if (this.f2981a < this.d) {
            this.f2981a++;
        }
        if (this.f2981a == this.d) {
            return (char) 0;
        }
        return this.c.charAt(this.f2981a);
    }

    public void a() {
        while (this.f2981a < this.d && Character.isWhitespace(this.c.charAt(this.f2981a))) {
            c();
        }
    }

    public void b() {
        while (this.f2981a < this.d) {
            switch (this.c.charAt(this.f2981a)) {
                case '\t':
                case '\n':
                case ' ':
                case ',':
                    c();
                default:
                    return;
            }
        }
    }

    public void c() {
        this.b = f();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x006b, code lost:            if (r5 == 0) goto L30;     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x006d, code lost:            r11.b = f();        r3 = r3 - 1;     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0077, code lost:            switch(r11.b) {            case 48: goto L73;            case 49: goto L72;            case 50: goto L72;            case 51: goto L72;            case 52: goto L72;            case 53: goto L72;            case 54: goto L72;            case 55: goto L72;            case 56: goto L72;            case 57: goto L72;            default: goto L71;        };     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x007a, code lost:            if (r4 != false) goto L40;     */
    /* JADX WARN: Code restructure failed: missing block: B:22:?, code lost:            return 0.0f;     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x007e, code lost:            r4 = r5;        r5 = r6;     */
    /* JADX WARN: Failed to find 'out' block for switch in B:12:0x002d. Please report as an issue. */
    /* JADX WARN: Failed to find 'out' block for switch in B:29:0x0095. Please report as an issue. */
    /* JADX WARN: Failed to find 'out' block for switch in B:45:0x00b3. Please report as an issue. */
    /* JADX WARN: Failed to find 'out' block for switch in B:56:0x00e0. Please report as an issue. */
    /* JADX WARN: Failed to find 'out' block for switch in B:5:0x000d. Please report as an issue. */
    /* JADX WARN: Failed to find 'out' block for switch in B:64:0x00f9. Please report as an issue. */
    /* JADX WARN: Failed to find 'out' block for switch in B:72:0x0041. Please report as an issue. */
    /* JADX WARN: Failed to find 'out' block for switch in B:84:0x0061. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:11:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00ab  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00ca  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00d2 A[PHI: r2
  0x00d2: PHI (r2v1 boolean) = (r2v0 boolean), (r2v2 boolean) binds: [B:45:0x00b3, B:50:0x00c7] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:87:? A[LOOP:5: B:81:0x004e->B:87:?, LOOP_END, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0068  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public float d() {
        /*
            Method dump skipped, instructions count: 592
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.larvalabs.svgandroid.a.d():float");
    }

    public float e() {
        a();
        float d = d();
        b();
        return d;
    }
}
