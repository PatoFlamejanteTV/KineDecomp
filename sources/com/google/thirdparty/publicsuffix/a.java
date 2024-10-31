package com.google.thirdparty.publicsuffix;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Joiner;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Lists;

/* compiled from: TrieParser.java */
@GwtCompatible
/* loaded from: classes2.dex */
final class a {

    /* renamed from: a, reason: collision with root package name */
    private static final Joiner f18904a = Joiner.a("");

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ImmutableMap<String, PublicSuffixType> a(CharSequence charSequence) {
        ImmutableMap.Builder builder = ImmutableMap.builder();
        int length = charSequence.length();
        int i = 0;
        while (i < length) {
            i += a(Lists.b(), charSequence.subSequence(i, length), builder);
        }
        return builder.a();
    }

    private static CharSequence b(CharSequence charSequence) {
        return new StringBuilder(charSequence).reverse();
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x004f, code lost:            if (r3 != ',') goto L24;     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0051, code lost:            if (r2 >= r0) goto L39;     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0053, code lost:            r2 = r2 + a(r9, r10.subSequence(r2, r0), r11);     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0060, code lost:            if (r10.charAt(r2) == '?') goto L38;     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0066, code lost:            if (r10.charAt(r2) != ',') goto L41;     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0068, code lost:            r2 = r2 + 1;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static int a(java.util.List<java.lang.CharSequence> r9, java.lang.CharSequence r10, com.google.common.collect.ImmutableMap.Builder<java.lang.String, com.google.thirdparty.publicsuffix.PublicSuffixType> r11) {
        /*
            int r0 = r10.length()
            r1 = 0
            r2 = 0
            r3 = 0
        L7:
            r4 = 58
            r5 = 33
            r6 = 44
            r7 = 63
            if (r2 >= r0) goto L25
            char r3 = r10.charAt(r2)
            r8 = 38
            if (r3 == r8) goto L25
            if (r3 == r7) goto L25
            if (r3 == r5) goto L25
            if (r3 == r4) goto L25
            if (r3 != r6) goto L22
            goto L25
        L22:
            int r2 = r2 + 1
            goto L7
        L25:
            java.lang.CharSequence r8 = r10.subSequence(r1, r2)
            java.lang.CharSequence r8 = b(r8)
            r9.add(r1, r8)
            if (r3 == r5) goto L38
            if (r3 == r7) goto L38
            if (r3 == r4) goto L38
            if (r3 != r6) goto L4b
        L38:
            com.google.common.base.Joiner r4 = com.google.thirdparty.publicsuffix.a.f18904a
            java.lang.String r4 = r4.a(r9)
            int r5 = r4.length()
            if (r5 <= 0) goto L4b
            com.google.thirdparty.publicsuffix.PublicSuffixType r5 = com.google.thirdparty.publicsuffix.PublicSuffixType.fromCode(r3)
            r11.a(r4, r5)
        L4b:
            int r2 = r2 + 1
            if (r3 == r7) goto L6a
            if (r3 == r6) goto L6a
        L51:
            if (r2 >= r0) goto L6a
            java.lang.CharSequence r3 = r10.subSequence(r2, r0)
            int r3 = a(r9, r3, r11)
            int r2 = r2 + r3
            char r3 = r10.charAt(r2)
            if (r3 == r7) goto L68
            char r3 = r10.charAt(r2)
            if (r3 != r6) goto L51
        L68:
            int r2 = r2 + 1
        L6a:
            r9.remove(r1)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.thirdparty.publicsuffix.a.a(java.util.List, java.lang.CharSequence, com.google.common.collect.ImmutableMap$Builder):int");
    }
}
