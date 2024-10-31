package kotlin.text;

/* compiled from: StringNumberConversions.kt */
/* loaded from: classes.dex */
public class u extends t {
    public static Integer a(String str) {
        kotlin.jvm.internal.h.b(str, "$this$toIntOrNull");
        return a(str, 10);
    }

    public static Long b(String str) {
        kotlin.jvm.internal.h.b(str, "$this$toLongOrNull");
        return b(str, 10);
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0037 A[LOOP:0: B:14:0x0037->B:21:0x004f, LOOP_START, PHI: r2 r3
  0x0037: PHI (r2v2 int) = (r2v0 int), (r2v4 int) binds: [B:13:0x0035, B:21:0x004f] A[DONT_GENERATE, DONT_INLINE]
  0x0037: PHI (r3v4 int) = (r3v3 int), (r3v5 int) binds: [B:13:0x0035, B:21:0x004f] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0054  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0059  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Integer a(java.lang.String r9, int r10) {
        /*
            java.lang.String r0 = "$this$toIntOrNull"
            kotlin.jvm.internal.h.b(r9, r0)
            kotlin.text.a.a(r10)
            int r0 = r9.length()
            r1 = 0
            if (r0 != 0) goto L10
            return r1
        L10:
            r2 = 0
            char r3 = r9.charAt(r2)
            r4 = 48
            r5 = -2147483647(0xffffffff80000001, float:-1.4E-45)
            r6 = 1
            if (r3 >= r4) goto L30
            if (r0 != r6) goto L20
            return r1
        L20:
            r4 = 45
            if (r3 != r4) goto L29
            r5 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = 1
            r4 = 1
            goto L32
        L29:
            r4 = 43
            if (r3 != r4) goto L2f
            r3 = 1
            goto L31
        L2f:
            return r1
        L30:
            r3 = 0
        L31:
            r4 = 0
        L32:
            int r7 = r5 / r10
            int r0 = r0 - r6
            if (r3 > r0) goto L52
        L37:
            char r6 = r9.charAt(r3)
            int r6 = kotlin.text.a.a(r6, r10)
            if (r6 >= 0) goto L42
            return r1
        L42:
            if (r2 >= r7) goto L45
            return r1
        L45:
            int r2 = r2 * r10
            int r8 = r5 + r6
            if (r2 >= r8) goto L4c
            return r1
        L4c:
            int r2 = r2 - r6
            if (r3 == r0) goto L52
            int r3 = r3 + 1
            goto L37
        L52:
            if (r4 == 0) goto L59
            java.lang.Integer r9 = java.lang.Integer.valueOf(r2)
            goto L5e
        L59:
            int r9 = -r2
            java.lang.Integer r9 = java.lang.Integer.valueOf(r9)
        L5e:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.text.u.a(java.lang.String, int):java.lang.Integer");
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x003f A[LOOP:0: B:14:0x003f->B:22:0x0062, LOOP_START, PHI: r3 r4 r14
  0x003f: PHI (r3v1 java.lang.Long) = (r3v0 java.lang.Long), (r3v3 java.lang.Long) binds: [B:13:0x003d, B:22:0x0062] A[DONT_GENERATE, DONT_INLINE]
  0x003f: PHI (r4v3 int) = (r4v2 int), (r4v5 int) binds: [B:13:0x003d, B:22:0x0062] A[DONT_GENERATE, DONT_INLINE]
  0x003f: PHI (r14v2 long) = (r14v0 long), (r14v4 long) binds: [B:13:0x003d, B:22:0x0062] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x006d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Long b(java.lang.String r19, int r20) {
        /*
            r0 = r19
            r1 = r20
            java.lang.String r2 = "$this$toLongOrNull"
            kotlin.jvm.internal.h.b(r0, r2)
            kotlin.text.a.a(r20)
            int r2 = r19.length()
            r3 = 0
            if (r2 != 0) goto L14
            return r3
        L14:
            r4 = 0
            char r5 = r0.charAt(r4)
            r6 = 48
            r7 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r9 = 1
            if (r5 >= r6) goto L36
            if (r2 != r9) goto L26
            return r3
        L26:
            r6 = 45
            if (r5 != r6) goto L2f
            r7 = -9223372036854775808
            r4 = 1
            r5 = 1
            goto L37
        L2f:
            r6 = 43
            if (r5 != r6) goto L35
            r4 = 1
            goto L36
        L35:
            return r3
        L36:
            r5 = 0
        L37:
            long r10 = (long) r1
            long r12 = r7 / r10
            r14 = 0
            int r2 = r2 - r9
            if (r4 > r2) goto L66
        L3f:
            char r6 = r0.charAt(r4)
            int r6 = kotlin.text.a.a(r6, r1)
            if (r6 >= 0) goto L4a
            return r3
        L4a:
            int r9 = (r14 > r12 ? 1 : (r14 == r12 ? 0 : -1))
            if (r9 >= 0) goto L4f
            return r3
        L4f:
            long r14 = r14 * r10
            r16 = r4
            long r3 = (long) r6
            long r17 = r7 + r3
            int r6 = (r14 > r17 ? 1 : (r14 == r17 ? 0 : -1))
            if (r6 >= 0) goto L5c
            r6 = 0
            return r6
        L5c:
            r6 = 0
            long r14 = r14 - r3
            r4 = r16
            if (r4 == r2) goto L66
            int r4 = r4 + 1
            r3 = r6
            goto L3f
        L66:
            if (r5 == 0) goto L6d
            java.lang.Long r0 = java.lang.Long.valueOf(r14)
            goto L72
        L6d:
            long r0 = -r14
            java.lang.Long r0 = java.lang.Long.valueOf(r0)
        L72:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.text.u.b(java.lang.String, int):java.lang.Long");
    }
}
