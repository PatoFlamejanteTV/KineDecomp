package com.facebook.ads.redexgen.X;

import android.support.annotation.Nullable;
import android.support.annotation.VisibleForTesting;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicReference;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

/* renamed from: com.facebook.ads.redexgen.X.2K, reason: invalid class name */
/* loaded from: assets/audience_network.dex */
public final class C2K implements InterfaceC01234q {
    public static byte[] A09;

    @VisibleForTesting
    public final Runnable A00;
    public final FM A01;
    public final C01264t A03;
    public final GG A04;
    public final String A05;
    public final Map<EnumC01345d, C5R> A08 = new HashMap();
    public final Map<EnumC01345d, C01244r> A07 = new HashMap();
    public final List<InterfaceC00030a> A06 = new ArrayList();
    public final C4y A02 = new C4y(this);

    static {
        A05();
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
            byte[] r1 = com.facebook.ads.redexgen.X.C2K.A09
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
            int r0 = r0 - r4
            int r0 = r0 + (-88)
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C2K.A01(int, int, int):java.lang.String");
    }

    public static void A05() {
        A09 = new byte[]{-76, -39, -31, -52, -41, -44, -49, -117, -35, -48, -47, -35, -48, -34, -45, -117, -33, -44, -40, -48, -91, -117, -112, -49, 7, -12, 5, -6, -8, 7, -14, 5, -8, -7, 5, -8, 6, -5, -14, 6, -53, -23, -10, -10, -9, -4, -88, -21, -6, -19, -23, -4, -19, -88, -5, -19, -6, -2, -19, -6, -88, -22, -3, -10, -20, -12, -19, -88, -1, -15, -4, -16, -88, -10, -9, -10, -75, -5, -19, -6, -2, -19, -6, -88, -9, -1, -10, -19, -20, -88, -22, -3, -10, -20, -12, -19, -88, -47, -52, 59, 46, 47, 59, 46, 60, 49, -31, 7, -4, -15, -10, 0, -3, -4, -9, 8, -17, 2, -9, -3, -4, -82, 0, 3, -4, -82, -12, -17, -9, -6, -13, -14, -55, -82, -12, -3, 0, -15, -9, -4, -11, -82, -9, -4, -82, -77, -14, -82, 1, -13, -15, -3, -4, -14, 1, -4, -19, 5, -8, -5, -19, -16, -55, -2, 36, 25, 14, 19, 29, 26, 25, 20, 37, 12, 31, 20, 26, 25, -53, 29, 16, 28, 32, 16, 30, 31, -53, 31, 26, -53, -48, 30, -27, -75, -48, 30, -15, -28, -16, -12, -28, -14, -13, -61, -64, -45, -64, 38, 41, 46, 39, 37, 50, 48, 50, 41, 46, 52, 24, 47, 65, -22, 61, 47, 60, 64, 47, 60, -9, 57, 65, 56, 47, 46, -22, 44, 63, 56, 46, 54, 47, -22, 45, 60, 47, 43, 62, 47, 46, 4, -22, -17, 61, 32, 70, 59, 48, 53, 63, 60, 59, 54, 71, 46, 65, 54, 60, 59, -19, 63, 50, 64, 61, 60, 59, 64, 50, 7, -41, -14, 64, 45, 64, 57, 47, 55, 48, 62, 44, 31, 45, 42, 41, 40, 45, 31, -48, -36, -37, -31, -46, -27, -31};
    }

    public C2K(FM fm, String str, GG gg, C01264t c01264t) {
        this.A01 = fm;
        this.A05 = str;
        this.A04 = gg;
        this.A03 = c01264t;
    }

    public static int A00(JSONObject jSONObject) throws JSONException {
        int time = jSONObject.getJSONObject(A01(99, 7, 113)).getInt(A01(24, 16, 59));
        if (time <= 0) {
            throw new JSONException(String.format(Locale.US, A01(0, 24, 19), Integer.valueOf(time)));
        }
        return time;
    }

    private Set<C4V> A02(JSONObject jSONObject) throws JSONException {
        C2K c2k = this;
        final C01244r c01244r = null;
        Iterator<C01244r> it = null;
        final C5R c5r = null;
        HashSet hashSet = new HashSet();
        JSONObject jSONObject2 = jSONObject.getJSONObject(A01(288, 8, 98));
        JSONObject jSONObject3 = jSONObject.getJSONObject(A01(281, 7, 115));
        Iterator<C5R> it2 = c2k.A08.values().iterator();
        char c = 2;
        while (true) {
            switch (c) {
                case 2:
                    it2 = it2;
                    if (!it2.hasNext()) {
                        c = 7;
                        break;
                    } else {
                        c = 3;
                        break;
                    }
                case 3:
                    jSONObject2 = jSONObject2;
                    it2 = it2;
                    c5r = it2.next();
                    switch (AnonymousClass06.A00(jSONObject2.getString(c5r.A4j().A03()))) {
                        case A03:
                            c = 6;
                            break;
                        case A04:
                            c = 5;
                            break;
                        default:
                            c = 4;
                            break;
                    }
                case 4:
                    throw new AssertionError();
                case 5:
                    hashSet = hashSet;
                    c5r = c5r;
                    hashSet.add(new AnonymousClass48(c5r) { // from class: com.facebook.ads.redexgen.X.3x
                        {
                            AnonymousClass06 anonymousClass06 = AnonymousClass06.A04;
                        }
                    });
                    c = 2;
                    break;
                case 6:
                    hashSet = hashSet;
                    jSONObject3 = jSONObject3;
                    c5r = c5r;
                    final JSONObject jSONObject4 = jSONObject3.getJSONObject(c5r.A4j().A03()).getJSONObject(A01(203, 4, 7));
                    final JSONObject optJSONObject = jSONObject3.getJSONObject(c5r.A4j().A03()).optJSONObject(A01(207, 11, 104));
                    hashSet.add(new AnonymousClass48(c5r, jSONObject4, optJSONObject) { // from class: com.facebook.ads.redexgen.X.47
                        public final JSONObject A00;

                        @Nullable
                        public final JSONObject A01;

                        {
                            AnonymousClass06 anonymousClass06 = AnonymousClass06.A03;
                            this.A00 = jSONObject4;
                            this.A01 = optJSONObject;
                        }

                        @Override // com.facebook.ads.redexgen.X.AnonymousClass48, com.facebook.ads.redexgen.X.C4V
                        public final void A3B(Map<InterfaceC01455p, AnonymousClass06> map, Map<InterfaceC01254s, EnumC01294w> map2) {
                            super.A00.A05(this.A00, this.A01);
                            super.A3B(map, map2);
                        }
                    });
                    c = 2;
                    break;
                case 7:
                    c2k = c2k;
                    it = c2k.A07.values().iterator();
                    c = '\b';
                    break;
                case '\b':
                    it = it;
                    if (!it.hasNext()) {
                        c = '\r';
                        break;
                    } else {
                        c = '\t';
                        break;
                    }
                case '\t':
                    jSONObject2 = jSONObject2;
                    it = it;
                    c01244r = it.next();
                    switch (EnumC01294w.A00(jSONObject2.getString(c01244r.A4j().A03()))) {
                        case A03:
                            c = '\f';
                            break;
                        case A04:
                            c = 11;
                            break;
                        default:
                            c = '\n';
                            break;
                    }
                case '\n':
                    throw new AssertionError();
                case 11:
                    hashSet = hashSet;
                    c01244r = c01244r;
                    hashSet.add(new C4A(c01244r) { // from class: com.facebook.ads.redexgen.X.2g
                        {
                            EnumC01294w enumC01294w = EnumC01294w.A04;
                        }

                        @Override // com.facebook.ads.redexgen.X.C4A, com.facebook.ads.redexgen.X.C4V
                        public final void A3B(Map<InterfaceC01455p, AnonymousClass06> map, Map<InterfaceC01254s, EnumC01294w> map2) {
                            this.A01.A06();
                            super.A3B(map, map2);
                        }
                    });
                    c = '\b';
                    break;
                case '\f':
                    hashSet = hashSet;
                    c01244r = c01244r;
                    hashSet.add(new C4A(c01244r) { // from class: com.facebook.ads.redexgen.X.49
                        {
                            EnumC01294w enumC01294w = EnumC01294w.A03;
                        }
                    });
                    c = '\b';
                    break;
                case '\r':
                    return hashSet;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:122:0x0276, code lost:            r4 = new org.json.JSONObject();        r4.put(A01(196, 7, 39), r2);        r4.put(A01(281, 7, 115), r7);        r4.put(A01(296, 7, 21), r19);     */
    /* JADX WARN: Code restructure failed: missing block: B:123:0x02ad, code lost:            return r4;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private org.json.JSONObject A03(java.util.Map<com.facebook.ads.redexgen.X.InterfaceC01455p, com.facebook.ads.redexgen.X.AnonymousClass07> r27, java.util.Map<com.facebook.ads.redexgen.X.InterfaceC01254s, com.facebook.ads.redexgen.X.C4x> r28, java.util.Map<com.facebook.ads.redexgen.X.InterfaceC01254s, org.json.JSONObject> r29, java.util.Map<com.facebook.ads.redexgen.X.InterfaceC01254s, org.json.JSONObject> r30) throws org.json.JSONException {
        /*
            Method dump skipped, instructions count: 734
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C2K.A03(java.util.Map, java.util.Map, java.util.Map, java.util.Map):org.json.JSONObject");
    }

    private void A04() throws Throwable {
        Map<InterfaceC01455p, AnonymousClass07> serverBundleRequests = new HashMap<>();
        Map<InterfaceC01254s, C4x> hashMap = new HashMap<>();
        Map<InterfaceC01254s, JSONObject> hashMap2 = new HashMap<>();
        Map<InterfaceC01254s, JSONObject> hashMap3 = new HashMap<>();
        synchronized (this) {
            for (InterfaceC01455p interfaceC01455p : this.A08.values()) {
                if (interfaceC01455p.A5G()) {
                    serverBundleRequests.put(interfaceC01455p, AnonymousClass07.A04);
                } else {
                    serverBundleRequests.put(interfaceC01455p, AnonymousClass07.A03);
                }
            }
            AtomicReference<JSONObject> atomicReference = new AtomicReference<>();
            AtomicReference<JSONObject> atomicReference2 = new AtomicReference<>();
            for (C01244r c01244r : this.A07.values()) {
                if (c01244r.A5G()) {
                    if (c01244r.A07(atomicReference, atomicReference2)) {
                        hashMap.put(c01244r, C4x.A04);
                        hashMap2.put(c01244r, atomicReference.get());
                    } else {
                        hashMap.put(c01244r, C4x.A03);
                    }
                    hashMap3.put(c01244r, atomicReference2.get());
                }
            }
            Iterator<InterfaceC00030a> it = this.A06.iterator();
            while (it.hasNext()) {
                it.next();
            }
        }
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        final AtomicReference<Throwable> failureContainer = new AtomicReference<>();
        final AtomicReference atomicReference3 = new AtomicReference();
        JSONObject A03 = A03(serverBundleRequests, hashMap, hashMap2, hashMap3);
        String.format(Locale.US, A01(163, 33, 83), this.A05, A03.toString(2));
        this.A01.A7n(this.A05, (A01(155, 8, 52) + URLEncoder.encode(A03.toString())).getBytes(), new InterfaceC0436Gz() { // from class: com.facebook.ads.redexgen.X.4f
            @Override // com.facebook.ads.redexgen.X.InterfaceC0436Gz
            public final void A6N(FN fn) {
                C2K.A06(fn.A4M(), failureContainer, atomicReference3);
                countDownLatch.countDown();
            }

            @Override // com.facebook.ads.redexgen.X.InterfaceC0436Gz
            public final void A6Z(Exception exc) {
                atomicReference3.set(exc);
                countDownLatch.countDown();
            }
        });
        while (countDownLatch.getCount() > 0) {
            try {
                countDownLatch.await();
            } catch (InterruptedException unused) {
            }
        }
        synchronized (this) {
            if (atomicReference3.get() != null) {
                throw ((Throwable) atomicReference3.get());
            }
            JSONObject syncRequest = (JSONObject) failureContainer.get();
            Set<C4V> A02 = A02(syncRequest);
            HashMap hashMap4 = new HashMap();
            HashMap hashMap5 = new HashMap();
            Iterator<C4V> it2 = A02.iterator();
            while (it2.hasNext()) {
                it2.next().A3B(hashMap4, hashMap5);
            }
            this.A02.A03(A00((JSONObject) failureContainer.get()));
            Iterator<InterfaceC00030a> it3 = this.A06.iterator();
            while (it3.hasNext()) {
                it3.next();
            }
        }
    }

    public static void A06(String str, AtomicReference<JSONObject> atomicReference, AtomicReference<Throwable> atomicReference2) {
        String.format(Locale.US, A01(253, 28, 117), str);
        try {
            atomicReference.set((JSONObject) new JSONTokener(str).nextValue());
        } catch (ClassCastException | JSONException e) {
            atomicReference2.set(e);
        }
    }

    public final void A08() {
        try {
            A04();
        } catch (Throwable unused) {
            String.format(Locale.US, A01(106, 49, 54), Integer.valueOf(this.A03.A01()));
            synchronized (this) {
                Iterator<InterfaceC00030a> it = this.A06.iterator();
                while (it.hasNext()) {
                    it.next();
                    new HashMap();
                    new HashMap();
                }
                this.A02.A03(this.A03.A01());
            }
        }
        if (this.A00 != null) {
            this.A00.run();
        }
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC01234q
    public final synchronized InterfaceC01455p A3o(EnumC01345d enumC01345d) {
        C5R c5r;
        if (enumC01345d.A02() != C5L.A03) {
            throw new IllegalArgumentException(A01(40, 59, 48));
        }
        if (this.A08.containsKey(enumC01345d)) {
            c5r = this.A08.get(enumC01345d);
        } else {
            c5r = new C5R(enumC01345d);
            this.A08.put(enumC01345d, c5r);
            Iterator<InterfaceC00030a> it = this.A06.iterator();
            while (it.hasNext()) {
                it.next();
            }
            String.format(Locale.US, A01(218, 35, 114), enumC01345d);
        }
        return c5r;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC01234q
    public final void A4A() {
        this.A02.A02();
    }
}
