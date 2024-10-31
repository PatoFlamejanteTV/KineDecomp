package com.facebook.ads.redexgen.X;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

/* renamed from: com.facebook.ads.redexgen.X.4F, reason: invalid class name */
/* loaded from: assets/audience_network.dex */
public final class C4F {
    public static C4F A05;
    public static byte[] A06;
    public static final Object A07;
    public final Context A00;
    public final Handler A01;
    public final HashMap<BroadcastReceiver, ArrayList<C4E>> A04 = new HashMap<>();
    public final HashMap<String, ArrayList<C4E>> A03 = new HashMap<>();
    public final ArrayList<C4D> A02 = new ArrayList<>();

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0030, code lost:            return new java.lang.String(r2);     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String A01(int r2, int r3, int r4) {
        /*
            r0 = 0
            r0 = 0
            byte[] r1 = com.facebook.ads.redexgen.X.C4F.A06
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
            int r0 = r0 + (-102)
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C4F.A01(int, int, int):java.lang.String");
    }

    public static void A03() {
        A06 = new byte[]{20, 54, 71, 60, 66, 65, -13, 63, 60, 70, 71, 13, -13, 90, 83, 80, 83, 84, 92, 83, 5, 87, 74, 70, 88, 84, 83, -52, -52, -14, 21, 24, 32, 17, 30, -52, 25, 13, 32, 15, 20, 17, 16, -51, -52, -52, 25, 13, 32, 15, 20, -23, -36, 36, -23, -18, -27, -38, -14, 69, 53, 58, 55, 63, 55, -14, -54, -19, -31, -33, -22, -64, -16, -19, -33, -30, -31, -33, -15, -14, -53, -33, -20, -33, -27, -29, -16, 13, 32, 46, 42, 39, 49, 36, 41, 34, -37, 47, 52, 43, 32, -37, 27, 29, 46, 35, 41, 40, 70, 67, 86, 67, -64, -64, -26, 9, 12, 20, 5, 18, -64, 4, 9, 4, -64, 14, 15, 20, -64, 13, 1, 20, 3, 8, -38, -64, -57, -37, -18, -35, -30, -29, -24, -31, -102, -37, -31, -37, -29, -24, -19, -18, -102, -32, -29, -26, -18, -33, -20, -102, -105, -26, -35, -105, -32, -27, -21, -36, -27, -21, -105, -19, -21, -2, -17, -15, -7, -4, 3};
    }

    static {
        A03();
        A07 = new Object();
    }

    public C4F(Context context) {
        this.A00 = context;
        final Looper mainLooper = context.getMainLooper();
        this.A01 = new Handler(mainLooper) { // from class: com.facebook.ads.redexgen.X.4C
            /* JADX WARN: Code restructure failed: missing block: B:14:0x001f, code lost:            return;     */
            @Override // android.os.Handler
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final void handleMessage(android.os.Message r3) {
                /*
                    r2 = this;
                    r1 = r2
                    int r0 = r3.what
                    switch(r0) {
                        case 1: goto L1d;
                        default: goto L6;
                    }
                L6:
                    r0 = 2
                L7:
                    switch(r0) {
                        case 2: goto Lb;
                        case 3: goto L1f;
                        case 4: goto L14;
                        default: goto La;
                    }
                La:
                    goto L7
                Lb:
                    com.facebook.ads.redexgen.X.4C r1 = (com.facebook.ads.redexgen.X.C4C) r1
                    android.os.Message r3 = (android.os.Message) r3
                    super.handleMessage(r3)
                    r0 = 3
                    goto L7
                L14:
                    com.facebook.ads.redexgen.X.4C r1 = (com.facebook.ads.redexgen.X.C4C) r1
                    com.facebook.ads.redexgen.X.4F r0 = com.facebook.ads.redexgen.X.C4F.this
                    com.facebook.ads.redexgen.X.C4F.A04(r0)
                    r0 = 3
                    goto L7
                L1d:
                    r0 = 4
                    goto L7
                L1f:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C4C.handleMessage(android.os.Message):void");
            }
        };
    }

    public static C4F A00(Context context) {
        C4F c4f;
        synchronized (A07) {
            if (A05 == null) {
                A05 = new C4F(context.getApplicationContext());
            }
            c4f = A05;
        }
        return c4f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Incorrect condition in loop: B:10:0x001c */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void A02() {
        /*
            r8 = this;
        L0:
            java.util.HashMap<android.content.BroadcastReceiver, java.util.ArrayList<com.facebook.ads.redexgen.X.4E>> r1 = r8.A04
            monitor-enter(r1)
            java.util.ArrayList<com.facebook.ads.redexgen.X.4D> r0 = r8.A02     // Catch: java.lang.Throwable -> L45
            int r0 = r0.size()     // Catch: java.lang.Throwable -> L45
            if (r0 > 0) goto Ld
            monitor-exit(r1)     // Catch: java.lang.Throwable -> L45
            goto L44
        Ld:
            com.facebook.ads.redexgen.X.4D[] r7 = new com.facebook.ads.redexgen.X.C4D[r0]     // Catch: java.lang.Throwable -> L45
            java.util.ArrayList<com.facebook.ads.redexgen.X.4D> r0 = r8.A02     // Catch: java.lang.Throwable -> L45
            r0.toArray(r7)     // Catch: java.lang.Throwable -> L45
            java.util.ArrayList<com.facebook.ads.redexgen.X.4D> r0 = r8.A02     // Catch: java.lang.Throwable -> L45
            r0.clear()     // Catch: java.lang.Throwable -> L45
            monitor-exit(r1)     // Catch: java.lang.Throwable -> L45
            r6 = 0
        L1b:
            int r0 = r7.length
            if (r6 >= r0) goto L0
            r5 = r7[r6]
            java.util.ArrayList<com.facebook.ads.redexgen.X.4E> r0 = r5.A01
            int r4 = r0.size()
            r3 = 0
        L27:
            if (r3 >= r4) goto L41
            java.util.ArrayList<com.facebook.ads.redexgen.X.4E> r0 = r5.A01
            java.lang.Object r1 = r0.get(r3)
            com.facebook.ads.redexgen.X.4E r1 = (com.facebook.ads.redexgen.X.C4E) r1
            boolean r0 = r1.A01
            if (r0 != 0) goto L3e
            android.content.BroadcastReceiver r2 = r1.A02
            android.content.Context r1 = r8.A00
            android.content.Intent r0 = r5.A00
            r2.onReceive(r1, r0)
        L3e:
            int r3 = r3 + 1
            goto L27
        L41:
            int r6 = r6 + 1
            goto L1b
        L44:
            return
        L45:
            r0 = move-exception
            monitor-exit(r1)     // Catch: java.lang.Throwable -> L45
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C4F.A02():void");
    }

    /* JADX WARN: Incorrect condition in loop: B:14:0x0027 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void A05(android.content.BroadcastReceiver r11) {
        /*
            r10 = this;
            java.util.HashMap<android.content.BroadcastReceiver, java.util.ArrayList<com.facebook.ads.redexgen.X.4E>> r8 = r10.A04
            monitor-enter(r8)
            java.util.HashMap<android.content.BroadcastReceiver, java.util.ArrayList<com.facebook.ads.redexgen.X.4E>> r0 = r10.A04     // Catch: java.lang.Throwable -> L67
            java.lang.Object r9 = r0.remove(r11)     // Catch: java.lang.Throwable -> L67
            java.util.ArrayList r9 = (java.util.ArrayList) r9     // Catch: java.lang.Throwable -> L67
            if (r9 != 0) goto Lf
            monitor-exit(r8)     // Catch: java.lang.Throwable -> L67
            goto L66
        Lf:
            int r0 = r9.size()     // Catch: java.lang.Throwable -> L67
            int r7 = r0 + (-1)
        L15:
            if (r7 < 0) goto L65
            java.lang.Object r6 = r9.get(r7)     // Catch: java.lang.Throwable -> L67
            com.facebook.ads.redexgen.X.4E r6 = (com.facebook.ads.redexgen.X.C4E) r6     // Catch: java.lang.Throwable -> L67
            r0 = 1
            r6.A01 = r0     // Catch: java.lang.Throwable -> L67
            r5 = 0
        L21:
            android.content.IntentFilter r0 = r6.A03     // Catch: java.lang.Throwable -> L67
            int r0 = r0.countActions()     // Catch: java.lang.Throwable -> L67
            if (r5 >= r0) goto L62
            android.content.IntentFilter r0 = r6.A03     // Catch: java.lang.Throwable -> L67
            java.lang.String r4 = r0.getAction(r5)     // Catch: java.lang.Throwable -> L67
            java.util.HashMap<java.lang.String, java.util.ArrayList<com.facebook.ads.redexgen.X.4E>> r0 = r10.A03     // Catch: java.lang.Throwable -> L67
            java.lang.Object r3 = r0.get(r4)     // Catch: java.lang.Throwable -> L67
            java.util.ArrayList r3 = (java.util.ArrayList) r3     // Catch: java.lang.Throwable -> L67
            if (r3 == 0) goto L5f
            int r0 = r3.size()     // Catch: java.lang.Throwable -> L67
            int r2 = r0 + (-1)
        L3f:
            if (r2 < 0) goto L54
            java.lang.Object r1 = r3.get(r2)     // Catch: java.lang.Throwable -> L67
            com.facebook.ads.redexgen.X.4E r1 = (com.facebook.ads.redexgen.X.C4E) r1     // Catch: java.lang.Throwable -> L67
            android.content.BroadcastReceiver r0 = r1.A02     // Catch: java.lang.Throwable -> L67
            if (r0 != r11) goto L51
            r0 = 1
            r1.A01 = r0     // Catch: java.lang.Throwable -> L67
            r3.remove(r2)     // Catch: java.lang.Throwable -> L67
        L51:
            int r2 = r2 + (-1)
            goto L3f
        L54:
            int r0 = r3.size()     // Catch: java.lang.Throwable -> L67
            if (r0 > 0) goto L5f
            java.util.HashMap<java.lang.String, java.util.ArrayList<com.facebook.ads.redexgen.X.4E>> r0 = r10.A03     // Catch: java.lang.Throwable -> L67
            r0.remove(r4)     // Catch: java.lang.Throwable -> L67
        L5f:
            int r5 = r5 + 1
            goto L21
        L62:
            int r7 = r7 + (-1)
            goto L15
        L65:
            monitor-exit(r8)     // Catch: java.lang.Throwable -> L67
        L66:
            return
        L67:
            r0 = move-exception
            monitor-exit(r8)     // Catch: java.lang.Throwable -> L67
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C4F.A05(android.content.BroadcastReceiver):void");
    }

    public final void A06(BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
        synchronized (this.A04) {
            C4E c4e = new C4E(intentFilter, broadcastReceiver);
            ArrayList<C4E> arrayList = this.A04.get(broadcastReceiver);
            if (arrayList == null) {
                arrayList = new ArrayList<>(1);
                this.A04.put(broadcastReceiver, arrayList);
            }
            arrayList.add(c4e);
            for (int i = 0; i < intentFilter.countActions(); i++) {
                String action = intentFilter.getAction(i);
                ArrayList<C4E> arrayList2 = this.A03.get(action);
                if (arrayList2 == null) {
                    arrayList2 = new ArrayList<>(1);
                    this.A03.put(action, arrayList2);
                }
                arrayList2.add(c4e);
            }
        }
    }

    public final boolean A07(Intent intent) {
        String A01;
        synchronized (this.A04) {
            String scheme = intent.getAction();
            String resolveTypeIfNeeded = intent.resolveTypeIfNeeded(this.A00.getContentResolver());
            Uri data = intent.getData();
            String scheme2 = intent.getScheme();
            Set<String> categories = intent.getCategories();
            boolean z = (intent.getFlags() & 8) != 0;
            if (z) {
                String str = A01(87, 15, 85) + resolveTypeIfNeeded + A01(58, 8, 108) + scheme2 + A01(160, 11, 17) + intent;
            }
            ArrayList<C4E> arrayList = this.A03.get(intent.getAction());
            if (arrayList != null) {
                if (z) {
                    String str2 = A01(0, 13, 109) + arrayList;
                }
                ArrayList arrayList2 = null;
                for (int i = 0; i < arrayList.size(); i++) {
                    C4E c4e = arrayList.get(i);
                    if (z) {
                        String str3 = A01(136, 24, 20) + c4e.A03;
                    }
                    if (!c4e.A00) {
                        int match = c4e.A03.match(scheme, resolveTypeIfNeeded, scheme2, data, categories, A01(66, 21, 24));
                        if (match >= 0) {
                            if (z) {
                                String str4 = A01(27, 27, 70) + Integer.toHexString(match);
                            }
                            if (arrayList2 == null) {
                                arrayList2 = new ArrayList();
                            }
                            arrayList2.add(c4e);
                            c4e.A00 = true;
                        } else if (z) {
                            switch (match) {
                                case -4:
                                    A01 = A01(171, 8, 36);
                                    break;
                                case -3:
                                    A01 = A01(102, 6, 84);
                                    break;
                                case -2:
                                    A01 = A01(108, 4, 124);
                                    break;
                                case -1:
                                    A01 = A01(54, 4, 15);
                                    break;
                                default:
                                    A01 = A01(13, 14, 127);
                                    break;
                            }
                            String str5 = A01(112, 24, 58) + A01;
                        }
                    }
                }
                if (arrayList2 != null) {
                    for (int i2 = 0; i2 < arrayList2.size(); i2++) {
                        ((C4E) arrayList2.get(i2)).A00 = false;
                    }
                    this.A02.add(new C4D(intent, arrayList2));
                    if (!this.A01.hasMessages(1)) {
                        this.A01.sendEmptyMessage(1);
                    }
                    return true;
                }
            }
            return false;
        }
    }
}
