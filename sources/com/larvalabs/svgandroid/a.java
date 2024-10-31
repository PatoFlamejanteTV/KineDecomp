package com.larvalabs.svgandroid;

/* compiled from: ParserHelper.java */
/* loaded from: classes2.dex */
public class a {

    /* renamed from: a */
    private static final double[] f19307a = new double[128];

    /* renamed from: b */
    private char f19308b;

    /* renamed from: c */
    private CharSequence f19309c;

    /* renamed from: d */
    public int f19310d;

    /* renamed from: e */
    private int f19311e;

    static {
        int i = 0;
        while (true) {
            double[] dArr = f19307a;
            if (i >= dArr.length) {
                return;
            }
            dArr[i] = Math.pow(10.0d, i);
            i++;
        }
    }

    public a(CharSequence charSequence, int i) {
        this.f19309c = charSequence;
        this.f19310d = i;
        this.f19311e = charSequence.length();
        this.f19308b = charSequence.charAt(i);
    }

    private char f() {
        int i = this.f19310d;
        if (i < this.f19311e) {
            this.f19310d = i + 1;
        }
        int i2 = this.f19310d;
        if (i2 == this.f19311e) {
            return (char) 0;
        }
        return this.f19309c.charAt(i2);
    }

    public void a() {
        this.f19308b = f();
    }

    public float b() {
        e();
        float c2 = c();
        d();
        return c2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x0077, code lost:            if (r12 == 0) goto L137;     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0079, code lost:            r17.f19308b = f();        r13 = r13 - 1;     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0083, code lost:            switch(r17.f19308b) {            case 48: goto L191;            case 49: goto L190;            case 50: goto L190;            case 51: goto L190;            case 52: goto L190;            case 53: goto L190;            case 54: goto L190;            case 55: goto L190;            case 56: goto L190;            case 57: goto L190;            default: goto L189;        };     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0086, code lost:            if (r6 != false) goto L148;     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0088, code lost:            return 0.0f;     */
    /* JADX WARN: Failed to find 'out' block for switch in B:13:0x0038. Please report as an issue. */
    /* JADX WARN: Failed to find 'out' block for switch in B:24:0x0071. Please report as an issue. */
    /* JADX WARN: Failed to find 'out' block for switch in B:40:0x009e. Please report as an issue. */
    /* JADX WARN: Failed to find 'out' block for switch in B:62:0x00de. Please report as an issue. */
    /* JADX WARN: Failed to find 'out' block for switch in B:6:0x0024. Please report as an issue. */
    /* JADX WARN: Failed to find 'out' block for switch in B:71:0x00f7. Please report as an issue. */
    /* JADX WARN: Failed to find 'out' block for switch in B:86:0x0055. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00aa A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00fd  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0101  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00d0 A[PHI: r4
  0x00d0: PHI (r4v2 boolean) = (r4v1 boolean), (r4v0 boolean) binds: [B:77:0x00c9, B:56:0x00b9] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0027 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:82:0x003c  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:89:? A[LOOP:5: B:83:0x003f->B:89:?, LOOP_END, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:90:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x002a A[LOOP:0: B:9:0x002a->B:17:?, LOOP_START] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public float c() {
        /*
            Method dump skipped, instructions count: 532
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.larvalabs.svgandroid.a.c():float");
    }

    public void d() {
        while (true) {
            int i = this.f19310d;
            if (i >= this.f19311e) {
                return;
            }
            char charAt = this.f19309c.charAt(i);
            if (charAt != '\t' && charAt != '\n' && charAt != ' ' && charAt != ',') {
                return;
            } else {
                a();
            }
        }
    }

    public void e() {
        while (true) {
            int i = this.f19310d;
            if (i >= this.f19311e || !Character.isWhitespace(this.f19309c.charAt(i))) {
                return;
            } else {
                a();
            }
        }
    }

    private void a(char c2) {
        throw new RuntimeException("Unexpected char '" + c2 + "'.");
    }

    public static float a(int i, int i2) {
        double d2;
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
        if (i2 > 0) {
            double d3 = i;
            double d4 = f19307a[i2];
            Double.isNaN(d3);
            d2 = d3 * d4;
        } else {
            double d5 = i;
            double d6 = f19307a[-i2];
            Double.isNaN(d5);
            d2 = d5 / d6;
        }
        return (float) d2;
    }
}
