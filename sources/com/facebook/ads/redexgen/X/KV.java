package com.facebook.ads.redexgen.X;

import android.app.Activity;
import android.app.AlertDialog;
import android.widget.EditText;
import java.util.Map;
import java.util.concurrent.Executor;

/* loaded from: assets/audience_network.dex */
public class KV implements KU {
    public static byte[] A04;
    public C0402Fq A00;
    public C0483Iy A01;
    public FM A02;
    public final Executor A03;

    static {
        A06();
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0030, code lost:            return new java.lang.String(r2);     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String A02(int r2, int r3, int r4) {
        /*
            r0 = 0
            r0 = 0
            byte[] r1 = com.facebook.ads.redexgen.X.KV.A04
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
            r0 = r0 ^ 52
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.KV.A02(int, int, int):java.lang.String");
    }

    public static void A06() {
        A04 = new byte[]{35, 43, 58, 47, 42, 47, 58, 47, 14, 34, 58, 99, 44, 55, 43, 38, 49, 48, 99, 47, 44, 36, 42, 45, 99, 34, 48, 99, 58, 44, 54, 99, 55, 44, 99, 39, 38, 33, 54, 36, 124, 99, 11, 44, 52, 99, 39, 44, 99, 58, 44, 54, 99, 49, 38, 51, 49, 44, 39, 54, 32, 38, 99, 55, 43, 38, 99, 42, 48, 48, 54, 38, 124, 92, 87, 89, 94, 93, 91, 90, 92, 94, 86, 86, 91, 90, 93, 90, 71, 69, 80, 65, 67, 75, 86, 93, 123, 77, 64, 120, 119, 125, 119, 123, 125, 119, 122, 126, 119, 119, 121, 119, 126, Byte.MAX_VALUE, 50, 119, 44, 40, 124, 119, 47, Byte.MAX_VALUE, 40, 124, 121, 122, 123, 121, 122, 120, 47, 120, 45, 120, 126, 42, 121, 126, 121, 40, 123, 44, 45, 124, 125, 45, 124, 12, 0, 1, 9, 6, 8, 48, 6, 11, 8, 62, 53, 63, 123, 9, 62, 43, 52, 41, 47, 115, 113, 113, 119, 97, 97, 77, 102, 125, 121, 119, 124, 26, 30, 4, 20, 40, 30, 25, 17, 24, 15, 10, 10, 12, 9, 4, 12, 14, 11, 15, 14, 13, 10, 12, 15, 4, 38, 41, 36, 34, 43, 18, 29, 24, 20, 31, 5, 46, 5, 24, 28, 20, 113, 112, 102, 118, 103, 124, 101, 97, 124, 122, 123, 52, 50, 36, 51, 30, 40, 37, 36, 47, 53, 40, 39, 40, 36, 51, 46, 17, 24, 13, 89, 49, 24, 9, 9, 28, 23, 28, 29, 70, 115, 124, 121, 117, 126, 100, 79, 100, Byte.MAX_VALUE, 123, 117, 126};
    }

    public KV(Executor executor, C0402Fq c0402Fq, C0362Ec c0362Ec) {
        if (C0413Gc.A0h(c0362Ec)) {
            this.A02 = C7A.A05(c0362Ec.A00());
        } else {
            this.A01 = C7A.A01(c0362Ec.A00());
        }
        this.A03 = executor;
        this.A00 = c0402Fq;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Map<String, String> A04(String str) {
        JC miscInfo = new JC();
        JC requestParameters = new JC();
        JC jc = new JC();
        miscInfo.put(A02(231, 15, 117), C02379g.A00().A03());
        miscInfo.put(A02(147, 9, 91), A02(73, 15, 90));
        miscInfo.put(A02(88, 11, 16), A02(188, 15, 9));
        miscInfo.put(A02(167, 12, 38), A02(99, 48, 122));
        miscInfo.put(A02(209, 11, 69), (System.currentTimeMillis() / 1000) + A02(73, 0, 62));
        String A07 = this.A00.A07();
        if (A07 != null) {
            jc.put(A02(260, 12, 36), A07);
        }
        requestParameters.put(A02(220, 11, 33), str);
        requestParameters.put(A02(179, 9, 67), C0490Jf.A01(jc));
        miscInfo.A04(A02(0, 8, 122), C0490Jf.A01(requestParameters));
        return miscInfo;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A07(C0402Fq c0402Fq) {
        this.A00 = c0402Fq;
    }

    @Override // com.facebook.ads.redexgen.X.KU
    public final void A7X() {
        Activity context = JJ.A00();
        if (context == null) {
            return;
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle(A02(246, 14, 77));
        EditText editText = new EditText(context);
        editText.setSingleLine(false);
        editText.setImeOptions(1073741824);
        editText.setHint(A02(8, 65, 119));
        editText.setMaxLines(2);
        editText.setMinLines(2);
        builder.setView(editText);
        builder.setNegativeButton(A02(203, 6, 115), new KR(this));
        builder.setPositiveButton(A02(156, 11, 111), new KT(this, editText));
        builder.create().show();
    }
}
