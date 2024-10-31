package com.facebook.ads.redexgen.X;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageInfo;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.security.MessageDigest;
import java.util.HashMap;
import javax.annotation.Nullable;

@SuppressLint({"StringFormatUse", "SharedPreferencesUse"})
/* loaded from: assets/audience_network.dex */
public final class EF {
    public static EF A01;
    public static byte[] A02;
    public final HashMap<Integer, String> A00 = new HashMap<>();

    static {
        A03();
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0030, code lost:            return new java.lang.String(r2);     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String A01(int r2, int r3, int r4) {
        /*
            r0 = 0
            r0 = 0
            byte[] r1 = com.facebook.ads.redexgen.X.EF.A02
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
            r0 = r0 ^ 111(0x6f, float:1.56E-43)
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.EF.A01(int, int, int):java.lang.String");
    }

    public static void A03() {
        A02 = new byte[]{54, 35, 33, 107};
    }

    @SuppressLint({"CatchGeneralException"})
    public EF(Context context, EnumC0349Dp enumC0349Dp, @Nullable String str) {
        try {
            A04(context);
            if (enumC0349Dp.A04() == EnumC0349Dp.A0F.A04()) {
                A05(context, str);
            }
        } catch (Throwable th) {
            AK.A03(th);
        }
    }

    public static EF A00(Context context, EnumC0349Dp enumC0349Dp, @Nullable String str) {
        if (A01 == null) {
            A01 = new EF(context, enumC0349Dp, str);
        }
        return A01;
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0041, code lost:            return r6.toString();     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String A02(byte[] r8) {
        /*
            r0 = 0
            r0 = 0
            r0 = 0
            r0 = 0
            r7 = 0
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            int r5 = r8.length
            r4 = r7
            r0 = 2
        Ld:
            switch(r0) {
                case 2: goto L11;
                case 3: goto L17;
                case 4: goto L39;
                default: goto L10;
            }
        L10:
            goto Ld
        L11:
            if (r4 >= r5) goto L15
            r0 = 3
            goto Ld
        L15:
            r0 = 4
            goto Ld
        L17:
            byte[] r8 = (byte[]) r8
            java.lang.StringBuilder r6 = (java.lang.StringBuilder) r6
            r3 = r8[r4]
            r2 = 0
            r1 = 4
            r0 = 124(0x7c, float:1.74E-43)
            java.lang.String r2 = A01(r2, r1, r0)
            r0 = 1
            java.lang.Object[] r1 = new java.lang.Object[r0]
            java.lang.Byte r0 = java.lang.Byte.valueOf(r3)
            r1[r7] = r0
            java.lang.String r0 = java.lang.String.format(r2, r1)
            r6.append(r0)
            int r4 = r4 + 1
            r0 = 2
            goto Ld
        L39:
            java.lang.StringBuilder r6 = (java.lang.StringBuilder) r6
            java.lang.String r0 = r6.toString()
            java.lang.String r0 = (java.lang.String) r0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.EF.A02(byte[]):java.lang.String");
    }

    private void A04(Context context) throws Exception {
        int read;
        BufferedInputStream bufferedInputStream = null;
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
            BufferedInputStream bufferedInputStream2 = new BufferedInputStream(new FileInputStream(new File(packageInfo.applicationInfo.publicSourceDir)), 1024);
            try {
                MessageDigest messageDigest = MessageDigest.getInstance(EI.A03.A02());
                MessageDigest messageDigest2 = MessageDigest.getInstance(EI.A04.A02());
                MessageDigest messageDigest3 = MessageDigest.getInstance(EI.A05.A02());
                byte[] bArr = new byte[1024];
                do {
                    read = bufferedInputStream2.read(bArr);
                    if (read > 0) {
                        messageDigest.update(bArr, 0, read);
                        messageDigest2.update(bArr, 0, read);
                        messageDigest3.update(bArr, 0, read);
                    }
                } while (read != -1);
                this.A00.put(10003, A02(messageDigest.digest()));
                this.A00.put(10004, A02(messageDigest2.digest()));
                this.A00.put(10005, A02(messageDigest3.digest()));
                if (bufferedInputStream2 != null) {
                    bufferedInputStream2.close();
                }
            } catch (Throwable th) {
                th = th;
                bufferedInputStream = bufferedInputStream2;
                if (bufferedInputStream != null) {
                    bufferedInputStream.close();
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    private void A05(Context context, @Nullable String str) throws Throwable {
        EF ef = this;
        Throwable th = null;
        Throwable th2 = null;
        byte[] bArr = null;
        MessageDigest messageDigest = null;
        if (str == null || str.isEmpty()) {
            return;
        }
        BufferedInputStream bufferedInputStream = new BufferedInputStream(context.getAssets().open(str), 1024);
        Throwable th3 = null;
        char c = 5;
        while (true) {
            switch (c) {
                case 5:
                    messageDigest = MessageDigest.getInstance(EI.A03.A02());
                    bArr = new byte[1024];
                    c = '\n';
                    break;
                case '\n':
                    bufferedInputStream = bufferedInputStream;
                    bArr = bArr;
                    int read = bufferedInputStream.read(bArr);
                    if (read > 0) {
                        messageDigest.update(bArr, 0, read);
                    }
                    if (read != -1) {
                        c = '\n';
                        break;
                    } else {
                        c = 14;
                        break;
                    }
                case 14:
                    try {
                        ef = ef;
                        ef.A00.put(10010, A02(messageDigest.digest()));
                        if (bufferedInputStream != null) {
                            if (th3 == null) {
                                c = 23;
                                break;
                            } else {
                                c = 21;
                                break;
                            }
                        } else {
                            return;
                        }
                    } catch (Throwable th4) {
                        th2 = th4;
                        c = 26;
                        break;
                    }
                case 21:
                    try {
                        bufferedInputStream.close();
                        return;
                    } catch (Throwable th5) {
                        th3.addSuppressed(th5);
                        return;
                    }
                case 23:
                    bufferedInputStream.close();
                    return;
                case 26:
                    try {
                        th2 = th2;
                        throw th2;
                        break;
                    } catch (Throwable th6) {
                        th = th6;
                        th3 = th2;
                        c = 28;
                        break;
                    }
                case 28:
                    bufferedInputStream = bufferedInputStream;
                    if (bufferedInputStream == null) {
                        break;
                    } else if (th3 == null) {
                        c = ' ';
                        break;
                    } else {
                        c = 30;
                        break;
                    }
                case 30:
                    try {
                        bufferedInputStream.close();
                        break;
                    } catch (Throwable th7) {
                        th3.addSuppressed(th7);
                        break;
                    }
                case ' ':
                    bufferedInputStream.close();
                    break;
            }
        }
        throw th;
    }

    @Nullable
    public final String A06(int i) {
        String str = this.A00.get(Integer.valueOf(i));
        if (str != null) {
            return str;
        }
        return null;
    }
}
