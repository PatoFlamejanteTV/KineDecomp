package com.facebook.ads.redexgen.X;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Parcel;
import android.os.RemoteException;
import android.support.annotation.Nullable;
import android.support.annotation.VisibleForTesting;
import android.text.TextUtils;
import java.lang.reflect.Method;

/* renamed from: com.facebook.ads.redexgen.X.9m, reason: invalid class name and case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C02429m {
    public static byte[] A00;
    public static final String A01;

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0030, code lost:            return new java.lang.String(r2);     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String A04(int r2, int r3, int r4) {
        /*
            r0 = 0
            r0 = 0
            byte[] r1 = com.facebook.ads.redexgen.X.C02429m.A00
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
            r0 = r0 ^ 113(0x71, float:1.58E-43)
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C02429m.A04(int, int, int):java.lang.String");
    }

    public static void A05() {
        A00 = new byte[]{112, 124, 126, 61, 116, 124, 124, 116, Byte.MAX_VALUE, 118, 61, 114, 125, 119, 97, 124, 122, 119, 61, 116, 126, 96, 61, 114, 119, 96, 61, 122, 119, 118, 125, 103, 122, 117, 122, 118, 97, 61, 82, 119, 101, 118, 97, 103, 122, 96, 122, 125, 116, 90, 119, 80, Byte.MAX_VALUE, 122, 118, 125, 103, 42, 48, 4, 44, 44, 36, 47, 38, 19, 47, 34, 58, 16, 38, 49, 53, 42, 32, 38, 48, 2, 53, 34, 42, 47, 34, 33, 47, 38, 37, 41, 43, 104, 33, 41, 41, 33, 42, 35, 104, 39, 40, 34, 52, 41, 47, 34, 104, 33, 43, 53, 27, 57, 54, 54, 55, 44, 120, 63, 61, 44, 120, 57, 60, 46, 61, 42, 44, 49, 43, 49, 54, 63, 120, 49, 54, 62, 55, 120, 55, 54, 120, 53, 57, 49, 54, 120, 44, 48, 42, 61, 57, 60, 118, 61, 39, 24, 61, 57, 61, 32, 21, 48, 0, 38, 53, 55, 63, 61, 58, 51, 17, 58, 53, 54, 56, 49, 48, 98, 96, 113, 68, 97, 115, 96, 119, 113, 108, 118, 108, 107, 98, 76, 97, 76, 107, 99, 106, 48, 50, 57, 50, 37, 62, 52, 83, 95, 93, 30, 87, 95, 95, 87, 92, 85, 30, 81, 94, 84, 66, 95, 89, 84, 30, 87, 93, 67, 30, 83, 95, 93, 93, 95, 94, 30, 119, 95, 95, 87, 92, 85, 96, 92, 81, 73, 99, 85, 66, 70, 89, 83, 85, 67, 101, 68, 89, 92, 88, 90, 75, 118, 91, 1, 13, 15, 76, 5, 13, 13, 5, 14, 7, 76, 3, 12, 6, 16, 13, 11, 6, 76, 5, 15, 17, 76, 3, 6, 17, 76, 11, 6, 7, 12, 22, 11, 4, 11, 7, 16, 76, 17, 7, 16, 20, 11, 1, 7, 76, 49, 54, 35, 48, 54};
    }

    static {
        A05();
        A01 = C02359e.class.getSimpleName();
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:5:0x000c. Please report as an issue. */
    public static C02359e A00(C0361Eb c0361Eb) {
        C02359e c02359e = null;
        char c = Looper.myLooper() == Looper.getMainLooper() ? (char) 2 : (char) 3;
        while (true) {
            switch (c) {
                case 2:
                    throw new IllegalStateException(A04(108, 43, 41));
                case 3:
                    c0361Eb = c0361Eb;
                    c02359e = A01(c0361Eb);
                    c = c02359e != null ? (char) 4 : (char) 5;
                case 4:
                    c02359e = c02359e;
                    c = TextUtils.isEmpty(c02359e.A03()) ? (char) 5 : (char) 6;
                case 5:
                    c0361Eb = c0361Eb;
                    c02359e = A02(c0361Eb);
                    c = 6;
                case 6:
                    c02359e = c02359e;
                    c = c02359e != null ? (char) 7 : '\b';
                case 7:
                    c02359e = c02359e;
                    c = TextUtils.isEmpty(c02359e.A03()) ? '\b' : '\t';
                case '\b':
                    c0361Eb = c0361Eb;
                    c02359e = A03(c0361Eb);
                    c = '\t';
                case '\t':
                    return c02359e;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0027, code lost:            return r4;     */
    @android.support.annotation.VisibleForTesting
    @android.support.annotation.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.facebook.ads.redexgen.X.C02359e A01(com.facebook.ads.redexgen.X.C0361Eb r5) {
        /*
            r4 = 0
            r0 = 0
            com.facebook.ads.internal.bridge.gms.AdvertisingId r3 = com.facebook.ads.internal.bridge.gms.AdvertisingId.getAdvertisingIdInfoDirectly(r5)
            if (r3 == 0) goto L23
            r0 = 2
        L9:
            switch(r0) {
                case 2: goto Ld;
                case 3: goto L25;
                case 4: goto L20;
                default: goto Lc;
            }
        Lc:
            goto L9
        Ld:
            com.facebook.ads.internal.bridge.gms.AdvertisingId r3 = (com.facebook.ads.internal.bridge.gms.AdvertisingId) r3
            com.facebook.ads.redexgen.X.9e r4 = new com.facebook.ads.redexgen.X.9e
            java.lang.String r2 = r3.getId()
            boolean r1 = r3.isLimitAdTracking()
            com.facebook.ads.redexgen.X.9d r0 = com.facebook.ads.redexgen.X.EnumC02349d.A02
            r4.<init>(r2, r1, r0)
            r0 = 3
            goto L9
        L20:
            r4 = 0
            r0 = 3
            goto L9
        L23:
            r0 = 4
            goto L9
        L25:
            com.facebook.ads.redexgen.X.9e r4 = (com.facebook.ads.redexgen.X.C02359e) r4
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C02429m.A01(com.facebook.ads.redexgen.X.Eb):com.facebook.ads.redexgen.X.9e");
    }

    @VisibleForTesting
    @Nullable
    public static C02359e A02(C0361Eb c0361Eb) {
        Object A002;
        Method isGooglePlayServicesAvailable;
        Object advertisingInfo;
        C02359e c02359e = null;
        Method isGooglePlayServicesAvailable2 = C02439n.A02(A04(202, 52, 65), A04(57, 29, 50), Context.class);
        if (isGooglePlayServicesAvailable2 != null && (A002 = C02439n.A00(null, isGooglePlayServicesAvailable2, c0361Eb)) != null && ((Integer) A002).intValue() == 0 && (isGooglePlayServicesAvailable = C02439n.A02(A04(0, 57, 98), A04(175, 20, 116), Context.class)) != null && (advertisingInfo = C02439n.A00(null, isGooglePlayServicesAvailable, c0361Eb)) != null) {
            Method A012 = C02439n.A01(advertisingInfo.getClass(), A04(254, 5, 78), new Class[0]);
            Method A013 = C02439n.A01(advertisingInfo.getClass(), A04(151, 24, 37), new Class[0]);
            if (A012 != null && A013 != null) {
                String str = (String) C02439n.A00(advertisingInfo, A012, new Object[0]);
                Boolean bool = (Boolean) C02439n.A00(advertisingInfo, A013, new Object[0]);
                if (str != null) {
                    c02359e = new C02359e(str, bool != null && bool.booleanValue(), EnumC02349d.A06);
                }
            }
        }
        return c02359e;
    }

    /* JADX WARN: Type inference failed for: r1v4, types: [com.facebook.ads.internal.attribution.GmsAttributionProvider$GoogleAdInfo] */
    @VisibleForTesting
    @SuppressLint({"CatchGeneralException"})
    public static C02359e A03(C0361Eb c0361Eb) {
        ServiceConnectionC02419l serviceConnectionC02419l = new ServiceConnectionC02419l();
        Intent intent = new Intent(A04(259, 51, 19));
        intent.setPackage(A04(86, 22, 55));
        try {
            if (c0361Eb.bindService(intent, serviceConnectionC02419l, 1)) {
                final IBinder A02 = serviceConnectionC02419l.A02();
                ?? r1 = new IInterface(A02) { // from class: com.facebook.ads.internal.attribution.GmsAttributionProvider$GoogleAdInfo
                    public static byte[] A01;
                    public IBinder A00;

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
                            byte[] r1 = com.facebook.ads.internal.attribution.GmsAttributionProvider$GoogleAdInfo.A01
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
                            r0 = r0 ^ 23
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
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.internal.attribution.GmsAttributionProvider$GoogleAdInfo.A00(int, int, int):java.lang.String");
                    }

                    public static void A01() {
                        A01 = new byte[]{12, 0, 2, 65, 8, 0, 0, 8, 3, 10, 65, 14, 1, 11, 29, 0, 6, 11, 65, 8, 2, 28, 65, 14, 11, 28, 65, 6, 11, 10, 1, 27, 6, 9, 6, 10, 29, 65, 6, 1, 27, 10, 29, 1, 14, 3, 65, 38, 46, 11, 25, 10, 29, 27, 6, 28, 6, 1, 8, 38, 11, 60, 10, 29, 25, 6, 12, 10};
                    }

                    {
                        this.A00 = A02;
                    }

                    public final String A02() throws RemoteException {
                        Parcel obtain = Parcel.obtain();
                        Parcel reply = Parcel.obtain();
                        try {
                            obtain.writeInterfaceToken(A00(0, 68, 120));
                            this.A00.transact(1, obtain, reply, 0);
                            reply.readException();
                            return reply.readString();
                        } finally {
                            reply.recycle();
                            obtain.recycle();
                        }
                    }

                    public final boolean A03() throws RemoteException {
                        boolean limitAdTracking = true;
                        Parcel obtain = Parcel.obtain();
                        Parcel obtain2 = Parcel.obtain();
                        char c = 2;
                        while (true) {
                            switch (c) {
                                case 2:
                                    try {
                                        obtain.writeInterfaceToken(A00(0, 68, 120));
                                        obtain.writeInt(1);
                                        this.A00.transact(2, obtain, obtain2, 0);
                                        obtain2.readException();
                                        if (obtain2.readInt() == 0) {
                                            c = '\n';
                                            break;
                                        } else {
                                            c = 11;
                                            break;
                                        }
                                    } catch (Throwable th) {
                                        obtain2.recycle();
                                        obtain.recycle();
                                        throw th;
                                    }
                                case '\n':
                                    limitAdTracking = false;
                                    c = 11;
                                    break;
                                case 11:
                                    obtain2.recycle();
                                    obtain.recycle();
                                    return limitAdTracking;
                            }
                        }
                    }

                    @Override // android.os.IInterface
                    public final IBinder asBinder() {
                        return this.A00;
                    }
                };
                return new C02359e(r1.A02(), r1.A03(), EnumC02349d.A07);
            }
        } catch (Throwable t) {
            C0511Kb.A06(c0361Eb, A04(195, 7, 38), C0512Kc.A12, new C0514Ke(t));
        } finally {
            c0361Eb.unbindService(serviceConnectionC02419l);
        }
        return null;
    }
}
