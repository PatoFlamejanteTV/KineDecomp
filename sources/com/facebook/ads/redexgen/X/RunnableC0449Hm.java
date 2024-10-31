package com.facebook.ads.redexgen.X;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.facebook.ads.redexgen.X.Hm, reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public class RunnableC0449Hm implements Runnable {
    public static byte[] A03;
    public final /* synthetic */ C0361Eb A00;
    public final /* synthetic */ C0451Ho A01;
    public final /* synthetic */ String A02;

    static {
        A01();
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0030, code lost:            return new java.lang.String(r2);     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String A00(int r2, int r3, int r4) {
        /*
            r0 = 0
            r0 = 0
            byte[] r1 = com.facebook.ads.redexgen.X.RunnableC0449Hm.A03
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
            r0 = r0 ^ 19
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.RunnableC0449Hm.A00(int, int, int):java.lang.String");
    }

    public static void A01() {
        A03 = new byte[]{119, 96, 117, 106, 119, 113, 108, 107, 98, 41, 49, 47, 8, 31, 11, 15, 31, 9, 14, 37, 19, 30, 8, 9, 19, 20, 15, 18, 25};
    }

    public RunnableC0449Hm(C0451Ho c0451Ho, String str, C0361Eb c0361Eb) {
        this.A01 = c0451Ho;
        this.A02 = str;
        this.A00 = c0361Eb;
    }

    @Override // java.lang.Runnable
    public final void run() {
        List list;
        ArrayList arrayList;
        List list2;
        List list3;
        int i;
        int i2;
        int i3;
        if (C0466Ig.A02(this)) {
            return;
        }
        try {
            C0514Ke c0514Ke = new C0514Ke(A00(9, 3, 116));
            JSONObject jSONObject = new JSONObject();
            JSONArray jSONArray = new JSONArray();
            jSONObject.put(A00(22, 7, 115), jSONArray);
            jSONObject.put(A00(12, 10, 105), this.A02);
            list = this.A01.A0D;
            synchronized (list) {
                list2 = this.A01.A0D;
                arrayList = new ArrayList(list2);
                list3 = this.A01.A0D;
                list3.clear();
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                C0450Hn c0450Hn = (C0450Hn) it.next();
                StringBuilder append = new StringBuilder().append(A00(0, 0, 120));
                i = c0450Hn.A00;
                StringBuilder append2 = append.append(i).append(';');
                i2 = c0450Hn.A02;
                StringBuilder append3 = append2.append(i2).append(';');
                i3 = c0450Hn.A01;
                jSONArray.put(append3.append(i3).toString());
            }
            c0514Ke.A05(jSONObject);
            c0514Ke.A03(1);
            this.A00.A06().A5X(A00(0, 9, 22), C0512Kc.A1d, c0514Ke);
        } catch (JSONException unused) {
        } catch (Throwable th) {
            C0466Ig.A00(th, this);
        }
    }
}
