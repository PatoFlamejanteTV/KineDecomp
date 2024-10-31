package com.facebook.ads.redexgen.X;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.SystemClock;
import android.util.Log;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.annotation.Nullable;

/* loaded from: assets/audience_network.dex */
public final class CQ extends C0279Ax {
    public static byte[] A00;
    public static final String A01;

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0030, code lost:            return new java.lang.String(r2);     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String A05(int r2, int r3, int r4) {
        /*
            r0 = 0
            r0 = 0
            byte[] r1 = com.facebook.ads.redexgen.X.CQ.A00
            int r0 = r2 + r3
            byte[] r2 = java.util.Arrays.copyOfRange(r1, r2, r0)
            r1 = 0
            r0 = 2
        Lc:
            switch(r0) {
                case 2: goto L10;
                case 3: goto L19;
                case 4: goto L27;
                default: goto Lf;
            }
        Lf:
            goto Lc
        L10:
            byte[] r2 = (byte[]) r2
            int r0 = r2.length
            if (r1 >= r0) goto L17
            r0 = 3
            goto Lc
        L17:
            r0 = 4
            goto Lc
        L19:
            byte[] r2 = (byte[]) r2
            r0 = r2[r1]
            r0 = r0 ^ r4
            r0 = r0 ^ 82
            byte r0 = (byte) r0
            r2[r1] = r0
            int r1 = r1 + 1
            r0 = 2
            goto Lc
        L27:
            byte[] r2 = (byte[]) r2
            java.lang.String r0 = new java.lang.String
            r0.<init>(r2)
            java.lang.String r0 = (java.lang.String) r0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.CQ.A05(int, int, int):java.lang.String");
    }

    public static void A09() {
        A00 = new byte[]{39, 16, 16, 13, 16, 66, 0, 23, 11, 14, 6, 11, 12, 5, 66, 4, 11, 14, 7, 66, 45, 0, 8, 7, 1, 22, 112, 9, 20, 24, 19, 31, 8, 114, 63, 45, 41, 60, 95, 61, 122, 75, 88, 89, 79, 10, 111, 68, 92, 10, 124, 75, 88, 67, 75, 72, 70, 79};
    }

    static {
        A09();
        A01 = CQ.class.getSimpleName();
    }

    public CQ(Context context, AA aa) {
        super(context, aa);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"Nullable Dereference"})
    public AbstractC0351Dr A02(HashMap<String, CP> hashMap) {
        return new E2(SystemClock.elapsedRealtime(), A02(), hashMap, E8.A0C);
    }

    @Nullable
    @SuppressLint({"CatchGeneralException", "BadMethodUse-android.util.Log.e"})
    public static File A03(String str) {
        File file = null;
        try {
            String substring = str.substring(0, str.lastIndexOf(File.separator));
            String filePath = File.separator;
            file = new File(substring, str.substring(str.lastIndexOf(filePath) + 1));
            return file;
        } catch (Exception e) {
            String str2 = A01;
            String fileName = A05(0, 26, 48);
            Log.e(str2, fileName, e);
            return file;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:35:0x0049, code lost:            return r4;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String A06(java.lang.String r5) {
        /*
            r0 = 0
            r4 = 0
            r3 = -1
            int r0 = r5.hashCode()
            switch(r0) {
                case 902502675: goto L43;
                default: goto La;
            }
        La:
            r0 = 2
        Lb:
            switch(r0) {
                case 2: goto L2f;
                case 3: goto L36;
                case 4: goto L45;
                case 5: goto L25;
                case 6: goto Lf;
                case 7: goto L40;
                default: goto Le;
            }
        Le:
            goto Lb
        Lf:
            java.lang.String r5 = (java.lang.String) r5
            r2 = 26
            r1 = 8
            r0 = 30
            java.lang.String r0 = A05(r2, r1, r0)
            boolean r0 = r5.equals(r0)
            if (r0 == 0) goto L23
            r0 = 7
            goto Lb
        L23:
            r0 = 2
            goto Lb
        L25:
            java.io.File r0 = android.os.Environment.getExternalStorageDirectory()
            java.lang.String r4 = r0.toString()
            r0 = 4
            goto Lb
        L2f:
            switch(r3) {
                case 0: goto L34;
                default: goto L32;
            }
        L32:
            r0 = 3
            goto Lb
        L34:
            r0 = 5
            goto Lb
        L36:
            r2 = 0
            r1 = 0
            r0 = 41
            java.lang.String r4 = A05(r2, r1, r0)
            r0 = 4
            goto Lb
        L40:
            r3 = 0
            r0 = 2
            goto Lb
        L43:
            r0 = 6
            goto Lb
        L45:
            java.lang.String r4 = (java.lang.String) r4
            java.lang.String r4 = (java.lang.String) r4
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.CQ.A06(java.lang.String):java.lang.String");
    }

    @SuppressLint({"BadMethodUse-android.util.Log.e"})
    public static String A07(String str) {
        String regex = A05(34, 6, 81);
        StringBuffer stringBuffer = new StringBuffer();
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(str);
        while (matcher.find()) {
            matcher.appendReplacement(stringBuffer, A06(matcher.group()));
        }
        matcher.appendTail(stringBuffer);
        String stringBuffer2 = stringBuffer.toString();
        try {
            stringBuffer2 = new File(stringBuffer2).getCanonicalPath();
            return stringBuffer2;
        } catch (IOException e) {
            Log.e(A01, A05(40, 18, 120), e);
            return stringBuffer2;
        }
    }

    public final InterfaceC0267Al A0G(List<C0345Dl> list) {
        return new CO(this, list);
    }
}
