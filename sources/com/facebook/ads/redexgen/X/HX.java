package com.facebook.ads.redexgen.X;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.facebook.ads.AdSettings;
import com.facebook.ads.ExtraHints;
import com.facebook.ads.MediaView;
import com.facebook.ads.NativeAd;
import com.facebook.ads.NativeAdBase;
import com.facebook.ads.NativeAdLayout;
import com.facebook.ads.NativeAdListener;
import com.facebook.ads.NativeBannerAd;
import com.facebook.ads.internal.api.AdNativeComponentView;
import com.facebook.ads.internal.api.NativeAdBaseApi;
import com.facebook.ads.internal.api.Repairable;
import com.facebook.ads.internal.protocol.AdErrorType;
import com.facebook.ads.internal.settings.AdInternalSettings;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.UUID;
import java.util.WeakHashMap;

/* loaded from: assets/audience_network.dex */
public final class HX implements NativeAdBaseApi, Repairable, HW {
    public static EV A0f;
    public static byte[] A0g;
    public static final String A0h;
    public static final WeakHashMap<View, WeakReference<HX>> A0i;
    public long A00;

    @Nullable
    public Drawable A01;
    public View.OnTouchListener A02;

    @Nullable
    public View A03;
    public View A04;

    @Nullable
    public View A05;

    @Nullable
    public NativeAdLayout A06;
    public AnonymousClass22 A07;

    @Nullable
    public AnonymousClass24 A08;
    public C3I A09;

    @Nullable
    public C3N A0A;

    @Nullable
    public C0360Ea A0B;

    @Nullable
    public C0403Fr A0C;
    public HI A0D;
    public HU A0E;

    @Nullable
    public HZ A0F;
    public C0444Hh A0G;
    public EnumC0445Hi A0H;
    public EnumC0458Hx A0I;
    public MP A0J;

    @Nullable
    public NQ A0K;
    public AnonymousClass29 A0L;
    public FP A0M;
    public String A0N;

    @Nullable
    public String A0O;
    public WeakReference<C02027x> A0P;
    public WeakReference<AnonymousClass29> A0Q;
    public boolean A0R;
    public boolean A0S;
    public boolean A0T;
    public boolean A0U;

    @Nullable
    public C00371i A0V;
    public final EV A0W;
    public final C0362Ec A0X;
    public final HQ A0Y;
    public final C0451Ho A0Z;
    public final K5 A0a;
    public final String A0b;
    public final String A0c;
    public final List<View> A0d;
    public volatile boolean A0e;

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0030, code lost:            return new java.lang.String(r2);     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String A0S(int r2, int r3, int r4) {
        /*
            r0 = 0
            r0 = 0
            byte[] r1 = com.facebook.ads.redexgen.X.HX.A0g
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
            r0 = r0 ^ 21
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.HX.A0S(int, int, int):java.lang.String");
    }

    public static void A0X() {
        A0g = new byte[]{16, 19, 29, 24, 61, 24, 54, 30, 31, 18, 26, 45, 18, 30, 12, 91, 18, 8, 91, 22, 18, 8, 8, 18, 21, 28, 85, 54, 25, 12, 17, 14, 29, 88, 25, 28, 88, 28, 29, 11, 12, 10, 23, 1, 29, 28, 19, 30, 26, 31, 23, 18, 21, 30, 30, 59, Byte.MAX_VALUE, 49, 48, 43, Byte.MAX_VALUE, 51, 48, 62, 59, 58, 59, 14, 12, 1, 1, 50, 25, 2, 50, 12, 14, 25, 4, 2, 3, 11, 44, 36, 33, 40, 41, 109, 57, 34, 109, 34, 47, 57, 44, 36, 35, 109, 57, 40, 32, 61, 33, 44, 57, 40, 109, 4, 9, 109, 43, 63, 34, 32, 109, 47, 36, 41, 109, 61, 44, 52, 33, 34, 44, 41, 109, 106, 104, 62, 106, 21, 48, 0, 49, 57, 36, 56, 53, 32, 49, 116, 115, 113, 39, 115, 116, 61, 39, 116, 58, 59, 32, 116, 53, 116, 58, 53, 32, 61, 34, 49, 116, 53, 48, 27, 31, 28, 40, 57, 52, 56, 51, 62, 56, 19, 56, 41, 42, 50, 47, 54, 19, 22, 17, 20, 32, 27, 26, 12, 28, 13, 22, 15, 11, 22, 16, 17, 61, 33, 44, 52, 18, 57, 63, 44, 35, 62, 33, 44, 57, 36, 34, 35, 69, 70, 72, 77, 104, 77, 111, 91, 70, 68, 107, 64, 77, 123, 106, 126, 120, 110, 84, Byte.MAX_VALUE, 121, 106, 101, 120, 103, 106, Byte.MAX_VALUE, 98, 100, 101, 117, 112, 98, 113, 102, 96, 125, 103, 113, 102, 75, 122, 117, 121, 113, 100, 75, 94, 67, 92, 79, 10, 107, 78, 10, 93, 75, 89, 10, 75, 70, 88, 79, 75, 78, 83, 10, 88, 79, 77, 67, 89, 94, 79, 88, 79, 78, 10, 93, 67, 94, 66, 10, 75, 10, 124, 67, 79, 93, 4, 10, 107, 95, 94, 69, 10, 95, 68, 88, 79, 77, 67, 89, 94, 79, 88, 67, 68, 77, 10, 75, 68, 78, 10, 90, 88, 69, 73, 79, 79, 78, 67, 68, 77, 4, 108, 99, 118, 107, 116, 103, 107, 78, 99, 73, 69, 68, 124, 67, 79, 93, 10, 67, 89, 10, 71, 67, 89, 89, 67, 68, 77, 4, 72, 111, 117, 100, 115, 111, 96, 109, 33, 100, 115, 115, 110, 115, 47, 11, 12, 43, 35, 38, 47, 46, 106, 62, 37, 106, 38, 37, 43, 46, 106, 7, 47, 46, 35, 43, 100, 18, 69, 23, 64, 64, 23, 25, 19, 109, 82, 94, 76, 27, 85, 84, 79, 27, 73, 94, 92, 82, 72, 79, 94, 73, 94, 95, 27, 76, 82, 79, 83, 27, 79, 83, 82, 72, 27, 117, 90, 79, 82, 77, 94, 122, 95, 120, 64, 70, 65, 21, 69, 71, 90, 67, 92, 81, 80, 21, 84, 21, 99, 92, 80, 66, 0, 13, 6, 27, 89, 69, 73, 67, 75, 70, 117, 73, 69, 68, 94, 79, 82, 94, 118, 117, 118, 114, 38, 38, 34, Byte.MAX_VALUE, 12, 29, 4, 72, 75, 84, 85, 72, 84, 73, 94, 95, 100, 79, 73, 90, 85, 72, 87, 90, 79, 82, 84, 85, 61, 56, 124, 49, 57, 56, 53, 61, 124, 40, 37, 44, 57, 124, 53, 47, 124, 50, 51, 40, 124, 47, 41, 44, 44, 51, 46, 40, 57, 56, 114, 101, 50, 102, 97, 109, 98, 108, 97, 25, 24, 14, 9, 15, 18, 4, 11, 14, 53, 30, 24, 11, 4, 25, 6, 11, 30, 3, 5, 4, 98, 101, 97, 98, 99, 51, 53, 100, 28, 30, 3, 1, 3, 24, 9, 8, 51, 24, 30, 13, 2, 31, 0, 13, 24, 5, 3, 2, 116, 119, 121, 124, 89, 124, 48, 49, 56, 123, 121, 116, 116, 125, 124, 56, 117, 119, 106, 125, 56, 108, 112, 121, 118, 56, 119, 118, 123, 125, 8, 47, 55, 32, 45, 40, 37, 97, 50, 36, 53, 97, 46, 39, 97, 34, 45, 40, 34, 42, 32, 35, 45, 36, 97, 55, 40, 36, 54, 50, 2, 84, 7, 6, 1, 81, 12, 13, 70, 105, 124, 97, 126, 109, 40, 105, 108, 40, 100, 103, 105, 108, 40, 122, 109, 121, 125, 109, 123, 124, 109, 108, 68, 123, 119, 101, 50, 115, 126, 96, 119, 115, 118, 107, 50, 96, 119, 117, 123, 97, 102, 119, 96, 119, 118, 50, 101, 123, 102, 122, 50, 115, 50, 92, 115, 102, 123, 100, 119, 83, 118, 60, 50, 83, 103, 102, 125, 50, 103, 124, 96, 119, 117, 123, 97, 102, 119, 96, 123, 124, 117, 50, 115, 124, 118, 50, 98, 96, 125, 113, 119, 119, 118, 123, 124, 117, 60, 115, 33, 34, 112, 118, 119, 113, 113};
    }

    static {
        A0X();
        A0h = HX.class.getSimpleName();
        A0i = new WeakHashMap<>();
    }

    public HX(Context context, String str, HQ hq, boolean z) {
        this.A0c = UUID.randomUUID().toString();
        this.A0I = EnumC0458Hx.A06;
        this.A0P = new WeakReference<>(null);
        this.A0d = new ArrayList();
        this.A0a = new K5();
        this.A0U = false;
        this.A0T = false;
        this.A0D = HI.A04;
        this.A07 = AnonymousClass22.A03;
        this.A00 = -1L;
        if (!z) {
            this.A0X = C8N.A04(context);
        } else {
            this.A0X = C8N.A02(context);
        }
        this.A0X.A0B(this);
        this.A0b = str;
        this.A0Y = hq;
        if (A0f != null) {
            this.A0W = A0f;
        } else {
            this.A0W = new EV(this.A0X);
        }
        this.A04 = new View(context);
        this.A0Z = new C0451Ho(this.A0X, this);
    }

    public HX(C0362Ec c0362Ec, C00371i c00371i, @Nullable C0403Fr c0403Fr, HQ hq) {
        this((Context) c0362Ec, (String) null, hq, true);
        this.A0V = c00371i;
        this.A0C = c0403Fr;
        this.A0e = true;
        this.A04 = new View(c0362Ec);
    }

    public HX(C0362Ec c0362Ec, C00371i c00371i, @Nullable C0403Fr c0403Fr, HQ hq, @Nullable C3N c3n) {
        this(c0362Ec, c00371i, c0403Fr, hq);
        this.A0A = c3n;
    }

    public HX(HX hx) {
        this((Context) hx.A0X, (String) null, hx.A0Y, true);
        this.A0C = hx.A0C;
        this.A0V = hx.A0V;
        this.A0A = hx.A0A;
        this.A0e = true;
        this.A04 = new View(this.A0X);
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x003e, code lost:            return r1;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private int A00() {
        /*
            r3 = this;
            r2 = r3
            r0 = 0
            r1 = 1
            com.facebook.ads.redexgen.X.Fr r0 = r2.A0C
            if (r0 == 0) goto L3c
            r0 = 2
        L8:
            switch(r0) {
                case 2: goto Lc;
                case 3: goto L3e;
                case 4: goto L16;
                case 5: goto L20;
                case 6: goto L2e;
                default: goto Lb;
            }
        Lb:
            goto L8
        Lc:
            com.facebook.ads.redexgen.X.HX r2 = (com.facebook.ads.redexgen.X.HX) r2
            com.facebook.ads.redexgen.X.Fr r0 = r2.A0C
            int r1 = r0.A04()
            r0 = 3
            goto L8
        L16:
            com.facebook.ads.redexgen.X.HX r2 = (com.facebook.ads.redexgen.X.HX) r2
            com.facebook.ads.redexgen.X.3I r0 = r2.A09
            if (r0 == 0) goto L1e
            r0 = 5
            goto L8
        L1e:
            r0 = 3
            goto L8
        L20:
            com.facebook.ads.redexgen.X.HX r2 = (com.facebook.ads.redexgen.X.HX) r2
            com.facebook.ads.redexgen.X.3I r0 = r2.A09
            com.facebook.ads.redexgen.X.Fr r0 = r0.A07()
            if (r0 == 0) goto L2c
            r0 = 6
            goto L8
        L2c:
            r0 = 3
            goto L8
        L2e:
            com.facebook.ads.redexgen.X.HX r2 = (com.facebook.ads.redexgen.X.HX) r2
            com.facebook.ads.redexgen.X.3I r0 = r2.A09
            com.facebook.ads.redexgen.X.Fr r0 = r0.A07()
            int r1 = r0.A04()
            r0 = 3
            goto L8
        L3c:
            r0 = 4
            goto L8
        L3e:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.HX.A00():int");
    }

    /* JADX WARN: Code restructure failed: missing block: B:47:0x0057, code lost:            return r1;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private int A01() {
        /*
            r3 = this;
            r2 = r3
            r1 = 0
            com.facebook.ads.redexgen.X.Fr r0 = r2.A0C
            if (r0 == 0) goto L55
            r0 = 2
        L7:
            switch(r0) {
                case 2: goto L3b;
                case 3: goto L57;
                case 4: goto L20;
                case 5: goto L16;
                case 6: goto Lb;
                case 7: goto L45;
                case 8: goto L2a;
                case 9: goto L38;
                default: goto La;
            }
        La:
            goto L7
        Lb:
            com.facebook.ads.redexgen.X.HX r2 = (com.facebook.ads.redexgen.X.HX) r2
            com.facebook.ads.redexgen.X.3I r0 = r2.A09
            if (r0 == 0) goto L13
            r0 = 7
            goto L7
        L13:
            r0 = 9
            goto L7
        L16:
            com.facebook.ads.redexgen.X.HX r2 = (com.facebook.ads.redexgen.X.HX) r2
            com.facebook.ads.redexgen.X.1i r0 = r2.A0V
            int r1 = r0.A0F()
            r0 = 3
            goto L7
        L20:
            com.facebook.ads.redexgen.X.HX r2 = (com.facebook.ads.redexgen.X.HX) r2
            com.facebook.ads.redexgen.X.1i r0 = r2.A0V
            if (r0 == 0) goto L28
            r0 = 5
            goto L7
        L28:
            r0 = 6
            goto L7
        L2a:
            com.facebook.ads.redexgen.X.HX r2 = (com.facebook.ads.redexgen.X.HX) r2
            com.facebook.ads.redexgen.X.3I r0 = r2.A09
            com.facebook.ads.redexgen.X.Fr r0 = r0.A07()
            int r1 = r0.A07()
            r0 = 3
            goto L7
        L38:
            r1 = 0
            r0 = 3
            goto L7
        L3b:
            com.facebook.ads.redexgen.X.HX r2 = (com.facebook.ads.redexgen.X.HX) r2
            com.facebook.ads.redexgen.X.Fr r0 = r2.A0C
            int r1 = r0.A07()
            r0 = 3
            goto L7
        L45:
            com.facebook.ads.redexgen.X.HX r2 = (com.facebook.ads.redexgen.X.HX) r2
            com.facebook.ads.redexgen.X.3I r0 = r2.A09
            com.facebook.ads.redexgen.X.Fr r0 = r0.A07()
            if (r0 == 0) goto L52
            r0 = 8
            goto L7
        L52:
            r0 = 9
            goto L7
        L55:
            r0 = 4
            goto L7
        L57:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.HX.A01():int");
    }

    /* JADX WARN: Code restructure failed: missing block: B:47:0x0058, code lost:            return r1;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private int A02() {
        /*
            r3 = this;
            r2 = r3
            r1 = 0
            com.facebook.ads.redexgen.X.Fr r0 = r2.A0C
            if (r0 == 0) goto L56
            r0 = 2
        L7:
            switch(r0) {
                case 2: goto L16;
                case 3: goto L58;
                case 4: goto L2a;
                case 5: goto L20;
                case 6: goto Lb;
                case 7: goto L42;
                case 8: goto L34;
                case 9: goto L52;
                default: goto La;
            }
        La:
            goto L7
        Lb:
            com.facebook.ads.redexgen.X.HX r2 = (com.facebook.ads.redexgen.X.HX) r2
            com.facebook.ads.redexgen.X.3I r0 = r2.A09
            if (r0 == 0) goto L13
            r0 = 7
            goto L7
        L13:
            r0 = 9
            goto L7
        L16:
            com.facebook.ads.redexgen.X.HX r2 = (com.facebook.ads.redexgen.X.HX) r2
            com.facebook.ads.redexgen.X.Fr r0 = r2.A0C
            int r1 = r0.A08()
            r0 = 3
            goto L7
        L20:
            com.facebook.ads.redexgen.X.HX r2 = (com.facebook.ads.redexgen.X.HX) r2
            com.facebook.ads.redexgen.X.1i r0 = r2.A0V
            int r1 = r0.A0G()
            r0 = 3
            goto L7
        L2a:
            com.facebook.ads.redexgen.X.HX r2 = (com.facebook.ads.redexgen.X.HX) r2
            com.facebook.ads.redexgen.X.1i r0 = r2.A0V
            if (r0 == 0) goto L32
            r0 = 5
            goto L7
        L32:
            r0 = 6
            goto L7
        L34:
            com.facebook.ads.redexgen.X.HX r2 = (com.facebook.ads.redexgen.X.HX) r2
            com.facebook.ads.redexgen.X.3I r0 = r2.A09
            com.facebook.ads.redexgen.X.Fr r0 = r0.A07()
            int r1 = r0.A08()
            r0 = 3
            goto L7
        L42:
            com.facebook.ads.redexgen.X.HX r2 = (com.facebook.ads.redexgen.X.HX) r2
            com.facebook.ads.redexgen.X.3I r0 = r2.A09
            com.facebook.ads.redexgen.X.Fr r0 = r0.A07()
            if (r0 == 0) goto L4f
            r0 = 8
            goto L7
        L4f:
            r0 = 9
            goto L7
        L52:
            r1 = 1000(0x3e8, float:1.401E-42)
            r0 = 3
            goto L7
        L56:
            r0 = 4
            goto L7
        L58:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.HX.A02():int");
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x003e, code lost:            return r1;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private int A03() {
        /*
            r3 = this;
            r2 = r3
            r0 = 0
            r1 = 0
            com.facebook.ads.redexgen.X.Fr r0 = r2.A0C
            if (r0 == 0) goto L3c
            r0 = 2
        L8:
            switch(r0) {
                case 2: goto Lc;
                case 3: goto L3e;
                case 4: goto L16;
                case 5: goto L20;
                case 6: goto L2e;
                default: goto Lb;
            }
        Lb:
            goto L8
        Lc:
            com.facebook.ads.redexgen.X.HX r2 = (com.facebook.ads.redexgen.X.HX) r2
            com.facebook.ads.redexgen.X.Fr r0 = r2.A0C
            int r1 = r0.A09()
            r0 = 3
            goto L8
        L16:
            com.facebook.ads.redexgen.X.HX r2 = (com.facebook.ads.redexgen.X.HX) r2
            com.facebook.ads.redexgen.X.3I r0 = r2.A09
            if (r0 == 0) goto L1e
            r0 = 5
            goto L8
        L1e:
            r0 = 3
            goto L8
        L20:
            com.facebook.ads.redexgen.X.HX r2 = (com.facebook.ads.redexgen.X.HX) r2
            com.facebook.ads.redexgen.X.3I r0 = r2.A09
            com.facebook.ads.redexgen.X.Fr r0 = r0.A07()
            if (r0 == 0) goto L2c
            r0 = 6
            goto L8
        L2c:
            r0 = 3
            goto L8
        L2e:
            com.facebook.ads.redexgen.X.HX r2 = (com.facebook.ads.redexgen.X.HX) r2
            com.facebook.ads.redexgen.X.3I r0 = r2.A09
            com.facebook.ads.redexgen.X.Fr r0 = r0.A07()
            int r1 = r0.A09()
            r0 = 3
            goto L8
        L3c:
            r0 = 4
            goto L8
        L3e:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.HX.A03():int");
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x003b, code lost:            return (android.graphics.drawable.Drawable) r3;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static android.graphics.drawable.Drawable A05(com.facebook.ads.redexgen.X.C0362Ec r5, android.graphics.Bitmap r6, boolean r7, @android.support.annotation.Nullable java.lang.String r8) {
        /*
            r4 = 0
            r0 = 0
            android.graphics.drawable.BitmapDrawable r3 = new android.graphics.drawable.BitmapDrawable
            android.content.res.Resources r0 = r5.getResources()
            r3.<init>(r0, r6)
            if (r7 == 0) goto L35
            r0 = 2
        Le:
            switch(r0) {
                case 2: goto L12;
                case 3: goto L20;
                case 4: goto L37;
                default: goto L11;
            }
        L11:
            goto Le
        L12:
            com.facebook.ads.redexgen.X.Ec r5 = (com.facebook.ads.redexgen.X.C0362Ec) r5
            java.lang.String r8 = (java.lang.String) r8
            android.graphics.drawable.BitmapDrawable r4 = com.facebook.ads.redexgen.X.PT.A00(r5, r8)
            if (r4 == 0) goto L1e
            r0 = 3
            goto Le
        L1e:
            r0 = 4
            goto Le
        L20:
            android.graphics.drawable.BitmapDrawable r3 = (android.graphics.drawable.BitmapDrawable) r3
            android.graphics.drawable.BitmapDrawable r4 = (android.graphics.drawable.BitmapDrawable) r4
            android.graphics.drawable.LayerDrawable r2 = new android.graphics.drawable.LayerDrawable
            r0 = 2
            android.graphics.drawable.Drawable[] r1 = new android.graphics.drawable.Drawable[r0]
            r0 = 0
            r1[r0] = r3
            r0 = 1
            r1[r0] = r4
            r2.<init>(r1)
            r3 = r2
            r0 = 4
            goto Le
        L35:
            r0 = 4
            goto Le
        L37:
            android.graphics.drawable.Drawable r3 = (android.graphics.drawable.Drawable) r3
            android.graphics.drawable.Drawable r3 = (android.graphics.drawable.Drawable) r3
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.HX.A05(com.facebook.ads.redexgen.X.Ec, android.graphics.Bitmap, boolean, java.lang.String):android.graphics.drawable.Drawable");
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:5:0x000d. Please report as an issue. */
    public static NativeAdBase A0A(Context context, String str, String str2) throws C0454Hs {
        NativeAd nativeAd = null;
        EnumC0458Hx A00 = I2.A00(str2);
        char c = A00 == null ? (char) 2 : (char) 3;
        while (true) {
            switch (c) {
                case 2:
                    throw new C0454Hs(AdErrorType.BID_PAYLOAD_ERROR, String.format(Locale.US, A0S(81, 50, 88), str2));
                case 3:
                    A00 = A00;
                    c = A00 == EnumC0458Hx.A05 ? (char) 4 : (char) 6;
                case 4:
                    context = context;
                    str = str;
                    nativeAd = new NativeBannerAd(context, str);
                    c = 5;
                case 5:
                    return (NativeAdBase) nativeAd;
                case 6:
                    A00 = A00;
                    c = A00 == EnumC0458Hx.A06 ? (char) 7 : '\b';
                case 7:
                    context = context;
                    str = str;
                    nativeAd = new NativeAd(context, str);
                    c = 5;
                case '\b':
                    throw new C0454Hs(AdErrorType.BID_PAYLOAD_ERROR, String.format(Locale.US, A0S(131, 34, 65), A00));
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x001d, code lost:            return r1;     */
    @android.support.annotation.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final com.facebook.ads.redexgen.X.C00371i A0C() {
        /*
            r2 = this;
            r0 = 0
            com.facebook.ads.redexgen.X.1i r1 = r2.A0V
            if (r1 == 0) goto L19
            r0 = 2
        L6:
            switch(r0) {
                case 2: goto La;
                case 3: goto L1b;
                case 4: goto L16;
                default: goto L9;
            }
        L9:
            goto L6
        La:
            com.facebook.ads.redexgen.X.1i r1 = (com.facebook.ads.redexgen.X.C00371i) r1
            boolean r0 = r1.A0e()
            if (r0 == 0) goto L14
            r0 = 3
            goto L6
        L14:
            r0 = 4
            goto L6
        L16:
            r1 = 0
            r0 = 3
            goto L6
        L19:
            r0 = 4
            goto L6
        L1b:
            com.facebook.ads.redexgen.X.1i r1 = (com.facebook.ads.redexgen.X.C00371i) r1
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.HX.A0C():com.facebook.ads.redexgen.X.1i");
    }

    public static HQ A0I() {
        return new HR();
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0027, code lost:            return r1;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.facebook.ads.redexgen.X.HX A0J(com.facebook.ads.internal.api.NativeAdBaseApi r2) {
        /*
            r1 = 0
            boolean r0 = r2 instanceof java.lang.reflect.Proxy
            if (r0 == 0) goto L21
            r0 = 2
        L6:
            switch(r0) {
                case 2: goto La;
                case 3: goto L23;
                case 4: goto L1a;
                default: goto L9;
            }
        L9:
            goto L6
        La:
            com.facebook.ads.internal.api.NativeAdBaseApi r2 = (com.facebook.ads.internal.api.NativeAdBaseApi) r2
            java.lang.reflect.InvocationHandler r0 = java.lang.reflect.Proxy.getInvocationHandler(r2)
            com.facebook.ads.redexgen.X.7m r0 = (com.facebook.ads.redexgen.X.C01927m) r0
            java.lang.Object r1 = r0.A04()
            com.facebook.ads.redexgen.X.HX r1 = (com.facebook.ads.redexgen.X.HX) r1
            r0 = 3
            goto L6
        L1a:
            com.facebook.ads.internal.api.NativeAdBaseApi r2 = (com.facebook.ads.internal.api.NativeAdBaseApi) r2
            r1 = r2
            com.facebook.ads.redexgen.X.HX r1 = (com.facebook.ads.redexgen.X.HX) r1
            r0 = 3
            goto L6
        L21:
            r0 = 4
            goto L6
        L23:
            com.facebook.ads.redexgen.X.HX r1 = (com.facebook.ads.redexgen.X.HX) r1
            com.facebook.ads.redexgen.X.HX r1 = (com.facebook.ads.redexgen.X.HX) r1
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.HX.A0J(com.facebook.ads.internal.api.NativeAdBaseApi):com.facebook.ads.redexgen.X.HX");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x001e, code lost:            return r1;     */
    @android.support.annotation.Nullable
    /* renamed from: A0L, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.facebook.ads.redexgen.X.C0443Hg getAdStarRating() {
        /*
            r3 = this;
            r2 = r3
            r1 = 0
            boolean r0 = r2.isAdLoaded()
            if (r0 != 0) goto L1a
            r0 = 2
        L9:
            switch(r0) {
                case 2: goto Ld;
                case 3: goto L1c;
                case 4: goto L10;
                default: goto Lc;
            }
        Lc:
            goto L9
        Ld:
            r1 = 0
            r0 = 3
            goto L9
        L10:
            com.facebook.ads.redexgen.X.HX r2 = (com.facebook.ads.redexgen.X.HX) r2
            com.facebook.ads.redexgen.X.1i r0 = r2.A0V
            com.facebook.ads.redexgen.X.Hg r1 = r0.A0K()
            r0 = 3
            goto L9
        L1a:
            r0 = 4
            goto L9
        L1c:
            com.facebook.ads.redexgen.X.Hg r1 = (com.facebook.ads.redexgen.X.C0443Hg) r1
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.HX.getAdStarRating():com.facebook.ads.redexgen.X.Hg");
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x001a, code lost:            return r2;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private com.facebook.ads.internal.protocol.AdPlacementType A0O() {
        /*
            r3 = this;
            r2 = 0
            com.facebook.ads.redexgen.X.Hx r1 = r3.A0I
            com.facebook.ads.redexgen.X.Hx r0 = com.facebook.ads.redexgen.X.EnumC0458Hx.A06
            if (r1 != r0) goto L14
            r0 = 2
        L8:
            switch(r0) {
                case 2: goto Lc;
                case 3: goto L16;
                case 4: goto L10;
                default: goto Lb;
            }
        Lb:
            goto L8
        Lc:
            com.facebook.ads.internal.protocol.AdPlacementType r2 = com.facebook.ads.internal.protocol.AdPlacementType.NATIVE
            r0 = 3
            goto L8
        L10:
            com.facebook.ads.internal.protocol.AdPlacementType r2 = com.facebook.ads.internal.protocol.AdPlacementType.NATIVE_BANNER
            r0 = 3
            goto L8
        L14:
            r0 = 4
            goto L8
        L16:
            com.facebook.ads.internal.protocol.AdPlacementType r2 = (com.facebook.ads.internal.protocol.AdPlacementType) r2
            com.facebook.ads.internal.protocol.AdPlacementType r2 = (com.facebook.ads.internal.protocol.AdPlacementType) r2
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.HX.A0O():com.facebook.ads.internal.protocol.AdPlacementType");
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x002d, code lost:            r3.A0d.clear();     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0035, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void A0V() {
        /*
            r3 = this;
            r0 = 0
            r0 = 0
            r2 = 0
            java.util.List<android.view.View> r0 = r3.A0d
            java.util.Iterator r1 = r0.iterator()
            r0 = 2
        La:
            switch(r0) {
                case 2: goto Le;
                case 3: goto L1a;
                case 4: goto L2d;
                default: goto Ld;
            }
        Ld:
            goto La
        Le:
            java.util.Iterator r1 = (java.util.Iterator) r1
            boolean r0 = r1.hasNext()
            if (r0 == 0) goto L18
            r0 = 3
            goto La
        L18:
            r0 = 4
            goto La
        L1a:
            java.util.Iterator r1 = (java.util.Iterator) r1
            java.lang.Object r0 = r1.next()
            android.view.View r0 = (android.view.View) r0
            r0.setOnClickListener(r2)
            r0.setOnTouchListener(r2)
            r0.setOnLongClickListener(r2)
            r0 = 2
            goto La
        L2d:
            r0 = r3
            com.facebook.ads.redexgen.X.HX r0 = (com.facebook.ads.redexgen.X.HX) r0
            java.util.List<android.view.View> r0 = r0.A0d
            r0.clear()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.HX.A0V():void");
    }

    private void A0W() {
        if (!TextUtils.isEmpty(getAdChoicesLinkUrl())) {
            JM.A08(new JM(), this.A0X, Uri.parse(getAdChoicesLinkUrl()), A13());
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x0033, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void A0Y(@android.support.annotation.Nullable android.graphics.drawable.Drawable r2, android.widget.ImageView r3) {
        /*
            r0 = 0
            r0 = 0
            android.widget.ImageView$ScaleType r0 = android.widget.ImageView.ScaleType.FIT_XY
            r3.setScaleType(r0)
            if (r2 == 0) goto L31
            r0 = 2
        La:
            switch(r0) {
                case 2: goto Le;
                case 3: goto L17;
                case 4: goto L21;
                case 5: goto L33;
                case 6: goto L29;
                default: goto Ld;
            }
        Ld:
            goto La
        Le:
            android.graphics.drawable.Drawable r2 = (android.graphics.drawable.Drawable) r2
            android.widget.ImageView r3 = (android.widget.ImageView) r3
            r3.setImageDrawable(r2)
            r0 = 3
            goto La
        L17:
            int r1 = android.os.Build.VERSION.SDK_INT
            r0 = 16
            if (r1 < r0) goto L1f
            r0 = 4
            goto La
        L1f:
            r0 = 6
            goto La
        L21:
            android.widget.ImageView r3 = (android.widget.ImageView) r3
            r0 = 0
            r3.setBackground(r0)
            r0 = 5
            goto La
        L29:
            android.widget.ImageView r3 = (android.widget.ImageView) r3
            r0 = 0
            r3.setBackgroundDrawable(r0)
            r0 = 5
            goto La
        L31:
            r0 = 3
            goto La
        L33:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.HX.A0Y(android.graphics.drawable.Drawable, android.widget.ImageView):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0038, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void A0Z(android.view.View r4) {
        /*
            r3 = this;
            r2 = r3
            java.util.List<android.view.View> r0 = r2.A0d
            r0.add(r4)
            com.facebook.ads.redexgen.X.HU r0 = r2.A0E
            r4.setOnClickListener(r0)
            com.facebook.ads.redexgen.X.HU r0 = r2.A0E
            r4.setOnTouchListener(r0)
            int r1 = android.os.Build.VERSION.SDK_INT
            r0 = 18
            if (r1 < r0) goto L36
            r0 = 2
        L17:
            switch(r0) {
                case 2: goto L1b;
                case 3: goto L2b;
                case 4: goto L38;
                default: goto L1a;
            }
        L1a:
            goto L17
        L1b:
            android.view.View r4 = (android.view.View) r4
            android.content.Context r0 = r4.getContext()
            boolean r0 = com.facebook.ads.redexgen.X.C0413Gc.A0d(r0)
            if (r0 == 0) goto L29
            r0 = 3
            goto L17
        L29:
            r0 = 4
            goto L17
        L2b:
            com.facebook.ads.redexgen.X.HX r2 = (com.facebook.ads.redexgen.X.HX) r2
            android.view.View r4 = (android.view.View) r4
            com.facebook.ads.redexgen.X.HU r0 = r2.A0E
            r4.setOnLongClickListener(r0)
            r0 = 4
            goto L17
        L36:
            r0 = 4
            goto L17
        L38:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.HX.A0Z(android.view.View):void");
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:5:0x0029. Please report as an issue. */
    private void A0a(View view, View view2, List<View> list, boolean z) {
        List<View> list2 = list;
        View view3 = view2;
        View view4 = view;
        HX hx = this;
        boolean z2 = false;
        FP fp = null;
        View view5 = null;
        Iterator it = null;
        String str = null;
        C0453Hr c0453Hr = null;
        boolean z3 = false;
        C0453Hr c0453Hr2 = null;
        int i = 0;
        String str2 = null;
        C02027x c02027x = null;
        String str3 = null;
        ArrayList arrayList = null;
        C00371i c00371i = null;
        C0453Hr c0453Hr3 = null;
        boolean z4 = false;
        char c = !hx.A0l() ? (char) 2 : (char) 3;
        while (true) {
            switch (c) {
                case 2:
                    hx = hx;
                    hx.A0X.A08().A84();
                    c = 3;
                case 3:
                    view4 = view4;
                    c = view4 == null ? (char) 4 : (char) 7;
                case 4:
                    hx = hx;
                    str = A0S(450, 19, 32);
                    c = !hx.A0l() ? (char) 5 : (char) 6;
                case 5:
                    hx = hx;
                    str = str;
                    hx.A0X.A08().A83(str);
                    c = 6;
                case 6:
                    throw new IllegalArgumentException(str);
                case 7:
                    list2 = list2;
                    c = list2 != null ? '\b' : '\t';
                case '\b':
                    list2 = list2;
                    c = list2.size() == 0 ? '\t' : '\f';
                case '\t':
                    hx = hx;
                    str3 = A0S(637, 30, 84);
                    c = !hx.A0l() ? '\n' : (char) 11;
                case '\n':
                    hx = hx;
                    str3 = str3;
                    hx.A0X.A08().A83(str3);
                    c = 11;
                case 11:
                    throw new IllegalArgumentException(str3);
                case '\f':
                    hx = hx;
                    c00371i = hx.A0C();
                    c = c00371i == null ? '\r' : (char) 19;
                case '\r':
                    hx = hx;
                    str2 = A0S(54, 13, 74);
                    c = !hx.A0l() ? (char) 14 : (char) 15;
                case 14:
                    hx = hx;
                    str2 = str2;
                    hx.A0X.A08().A83(str2);
                    c = 15;
                case 15:
                    hx = hx;
                    str2 = str2;
                    Log.e(A0h, str2);
                    c0453Hr2 = new C0453Hr(AdErrorType.NATIVE_AD_IS_NOT_LOADED, str2);
                    hx.A0v().A08().A2a(K4.A01(hx.A00), c0453Hr2.A04().getErrorCode(), c0453Hr2.A05());
                    c = C0413Gc.A1D(hx.A0X) ? (char) 16 : (char) 18;
                case 16:
                    hx = hx;
                    c = hx.A0F != null ? (char) 17 : (char) 18;
                case 17:
                    hx = hx;
                    c0453Hr2 = c0453Hr2;
                    hx.A0F.A6Y(c0453Hr2);
                    c = 18;
                case 18:
                    return;
                case 19:
                    hx = hx;
                    c = hx.A06 != null ? (char) 20 : (char) 21;
                case 20:
                    hx = hx;
                    C8J c8j = (C8J) hx.A06.getNativeAdLayoutApi();
                    c8j.A02();
                    c8j.A04(hx.A0O);
                    c = 21;
                case 21:
                    hx = hx;
                    c02027x = hx.A0P.get();
                    c = c02027x != null ? (char) 22 : (char) 24;
                case 22:
                    c00371i = c00371i;
                    c = c00371i.A0A() == 1 ? (char) 23 : (char) 24;
                case 23:
                    c02027x = c02027x;
                    c02027x.A03(KM.AN_INFO_ICON);
                    c = 24;
                case 24:
                    view3 = view3;
                    c = view3 == null ? (char) 25 : '\"';
                case 25:
                    hx = hx;
                    c = hx.A0I == EnumC0458Hx.A06 ? (char) 26 : (char) 30;
                case 26:
                    hx = hx;
                    c0453Hr = new C0453Hr(AdErrorType.NO_MEDIAVIEW_IN_NATIVEAD, A0S(6, 21, 110));
                    hx.A0v().A08().A2a(K4.A01(hx.A00), c0453Hr.A04().getErrorCode(), c0453Hr.A05());
                    c = hx.A0F != null ? (char) 27 : (char) 28;
                case 27:
                    hx = hx;
                    c0453Hr = c0453Hr;
                    hx.A0F.A6Y(c0453Hr);
                    c = 28;
                case 28:
                    c = AdInternalSettings.isDebugBuild() ? (char) 29 : (char) 18;
                case 29:
                    Log.e(A0h, A0S(6, 21, 110));
                    c = 18;
                case 30:
                    hx = hx;
                    c0453Hr3 = new C0453Hr(AdErrorType.NO_ICONVIEW_IN_NATIVEBANNERAD, A0S(345, 22, 63));
                    hx.A0v().A08().A2a(K4.A01(hx.A00), c0453Hr3.A04().getErrorCode(), c0453Hr3.A05());
                    c = hx.A0F != null ? (char) 31 : ' ';
                case 31:
                    hx = hx;
                    c0453Hr3 = c0453Hr3;
                    hx.A0F.A6Y(c0453Hr3);
                    c = ' ';
                case ' ':
                    c = AdInternalSettings.isDebugBuild() ? '!' : (char) 18;
                case '!':
                    Log.e(A0h, A0S(345, 22, 63));
                    c = 18;
                case '\"':
                    view3 = view3;
                    c = view3 instanceof AdNativeComponentView ? '#' : '-';
                case '#':
                    view3 = view3;
                    c = ((AdNativeComponentView) view3).getAdContentsView() != null ? '$' : '-';
                case '$':
                    z3 = true;
                    c = '%';
                case '%':
                    c = z ? '&' : ',';
                case '&':
                    view3 = view3;
                    c = view3 instanceof ImageView ? '\'' : ',';
                case '\'':
                    z4 = true;
                    c = '(';
                case '(':
                    c = !z3 ? ')' : '.';
                case ')':
                    c = !z4 ? '*' : '.';
                case '*':
                    hx = hx;
                    c = hx.A0F != null ? '+' : (char) 18;
                case '+':
                    hx = hx;
                    C0453Hr c0453Hr4 = new C0453Hr(AdErrorType.UNSUPPORTED_AD_ASSET_NATIVEAD, A0S(519, 31, 73));
                    hx.A0v().A08().A2a(K4.A01(hx.A00), c0453Hr4.A04().getErrorCode(), c0453Hr4.A05());
                    hx.A0F.A6Y(c0453Hr4);
                    c = 18;
                case ',':
                    z4 = false;
                    c = '(';
                case '-':
                    z3 = false;
                    c = '%';
                case '.':
                    hx = hx;
                    c = hx.A03 != null ? '/' : '0';
                case '/':
                    hx = hx;
                    Log.w(A0h, A0S(259, 80, 63));
                    hx.unregisterView();
                    c = '0';
                case '0':
                    view4 = view4;
                    c = A0i.containsKey(view4) ? '1' : '3';
                case '1':
                    view4 = view4;
                    c = A0i.get(view4).get() != null ? '2' : '3';
                case '2':
                    view4 = view4;
                    Log.w(A0h, A0S(699, 75, 7));
                    A0i.get(view4).get().unregisterView();
                    c = '3';
                case '3':
                    hx = hx;
                    view4 = view4;
                    view3 = view3;
                    hx.A0E = new HU(hx, hx.A0X, null);
                    hx.A03 = view4;
                    hx.A05 = view3;
                    c = view4 instanceof ViewGroup ? '4' : '5';
                case '4':
                    hx = hx;
                    view4 = view4;
                    hx.A0J = new MP(hx.A0X, new HO(hx));
                    ((ViewGroup) view4).addView(hx.A0J);
                    c = '5';
                case '5':
                    hx = hx;
                    list2 = list2;
                    arrayList = new ArrayList(list2);
                    c = hx.A04 != null ? '6' : '7';
                case '6':
                    hx = hx;
                    arrayList = arrayList;
                    arrayList.add(hx.A04);
                    c = '7';
                case '7':
                    arrayList = arrayList;
                    it = arrayList.iterator();
                    c = '8';
                case '8':
                    it = it;
                    c = it.hasNext() ? '9' : ':';
                case '9':
                    hx = hx;
                    it = it;
                    hx.A0Z((View) it.next());
                    c = '8';
                case ':':
                    hx = hx;
                    view3 = view3;
                    i = hx.A00();
                    z4 = z4;
                    c00371i = c00371i;
                    hx.A0L = new HP(hx, view3, z4, c00371i);
                    c = view3 instanceof AdNativeComponentView ? ';' : 'I';
                case ';':
                    view3 = view3;
                    view5 = ((AdNativeComponentView) view3).getAdContentsView();
                    c = '<';
                case '<':
                    hx = hx;
                    view5 = view5;
                    hx.A0M = new FP(view5, i, hx.A03(), true, hx.A0L, hx.A0X);
                    fp = hx.A0M;
                    c = !hx.A0l() ? '=' : 'H';
                case '=':
                    z2 = true;
                    c = '>';
                case '>':
                    hx = hx;
                    view4 = view4;
                    arrayList = arrayList;
                    fp = fp;
                    fp.A0Z(z2);
                    hx.A0M.A0X(hx.A01());
                    hx.A0M.A0Y(hx.A02());
                    hx.A08 = new AnonymousClass24(hx.A0X, new HV(hx, null), hx.A0M, hx.A0V);
                    hx.A08.A0D(arrayList);
                    A0i.put(view4, new WeakReference<>(hx));
                    c = Build.VERSION.SDK_INT >= 18 ? '?' : (char) 18;
                case '?':
                    hx = hx;
                    c = C0413Gc.A0d(hx.A0X) ? '@' : (char) 18;
                case '@':
                    hx = hx;
                    hx.A0K = new NQ();
                    hx.A0K.A0C(hx.A0b);
                    hx.A0K.A0B(hx.A0X.getPackageName());
                    hx.A0K.A0A(hx.A0M);
                    c = hx.A0V.A0B() > 0 ? 'A' : 'B';
                case 'A':
                    hx = hx;
                    hx.A0K.A08(hx.A0V.A0B(), hx.A0V.A0C());
                    c = 'B';
                case 'B':
                    hx = hx;
                    c = hx.A0C != null ? 'C' : 'E';
                case 'C':
                    hx = hx;
                    hx.A0K.A09(hx.A0C.A0C());
                    c = 'D';
                case 'D':
                    hx = hx;
                    hx.A03.getOverlay().add(hx.A0K);
                    c = 18;
                case 'E':
                    hx = hx;
                    c = hx.A09 != null ? 'F' : 'D';
                case 'F':
                    hx = hx;
                    c = hx.A09.A07() != null ? 'G' : 'D';
                case 'G':
                    hx = hx;
                    hx.A0K.A09(hx.A09.A07().A0C());
                    c = 'D';
                case 'H':
                    z2 = false;
                    c = '>';
                case 'I':
                    view3 = view3;
                    view5 = view3;
                    c = '<';
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:110:0x01c7, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void A0b(@android.support.annotation.Nullable com.facebook.ads.redexgen.X.C00371i r17, boolean r18) {
        /*
            Method dump skipped, instructions count: 494
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.HX.A0b(com.facebook.ads.redexgen.X.1i, boolean):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A0c(AnonymousClass25 anonymousClass25) {
        if (this.A0V == null) {
            return;
        }
        this.A0V.A0V(anonymousClass25);
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0031, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void A0d(com.facebook.ads.internal.api.NativeAdImageApi r3, android.widget.ImageView r4, com.facebook.ads.redexgen.X.C0362Ec r5) {
        /*
            if (r3 == 0) goto L2f
            r0 = 2
        L3:
            switch(r0) {
                case 2: goto L7;
                case 3: goto Lf;
                case 4: goto L31;
                default: goto L6;
            }
        L6:
            goto L3
        L7:
            android.widget.ImageView r4 = (android.widget.ImageView) r4
            if (r4 == 0) goto Ld
            r0 = 3
            goto L3
        Ld:
            r0 = 4
            goto L3
        Lf:
            com.facebook.ads.internal.api.NativeAdImageApi r3 = (com.facebook.ads.internal.api.NativeAdImageApi) r3
            android.widget.ImageView r4 = (android.widget.ImageView) r4
            com.facebook.ads.redexgen.X.Ec r5 = (com.facebook.ads.redexgen.X.C0362Ec) r5
            com.facebook.ads.redexgen.X.NR r2 = new com.facebook.ads.redexgen.X.NR
            r2.<init>(r4, r5)
            int r1 = r3.getHeight()
            int r0 = r3.getWidth()
            com.facebook.ads.redexgen.X.NR r1 = r2.A05(r1, r0)
            java.lang.String r0 = r3.getUrl()
            r1.A07(r0)
            r0 = 4
            goto L3
        L2f:
            r0 = 4
            goto L3
        L31:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.HX.A0d(com.facebook.ads.internal.api.NativeAdImageApi, android.widget.ImageView, com.facebook.ads.redexgen.X.Ec):void");
    }

    private final void A0e(HI hi, @Nullable String str) {
        A1L(hi, str, new C0360Ea(false, -1, -1));
    }

    private final void A0h(HZ hz) {
        this.A0F = hz;
    }

    private final void A0i(String str) {
        this.A0N = str;
    }

    /* JADX WARN: Code restructure failed: missing block: B:44:0x0057, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void A0j(java.util.List<android.view.View> r5, android.view.View r6) {
        /*
            r4 = this;
            r3 = r4
            r2 = 0
            r1 = 0
            com.facebook.ads.redexgen.X.HQ r0 = r3.A0Y
            if (r0 == 0) goto L55
            r0 = 2
        L8:
            switch(r0) {
                case 2: goto L34;
                case 3: goto L57;
                case 4: goto L29;
                case 5: goto L18;
                case 6: goto Lc;
                case 7: goto L44;
                case 8: goto L20;
                default: goto Lb;
            }
        Lb:
            goto L8
        Lc:
            android.view.ViewGroup r2 = (android.view.ViewGroup) r2
            int r0 = r2.getChildCount()
            if (r1 >= r0) goto L16
            r0 = 7
            goto L8
        L16:
            r0 = 3
            goto L8
        L18:
            android.view.View r6 = (android.view.View) r6
            r2 = r6
            android.view.ViewGroup r2 = (android.view.ViewGroup) r2
            r1 = 0
            r0 = 6
            goto L8
        L20:
            java.util.List r5 = (java.util.List) r5
            android.view.View r6 = (android.view.View) r6
            r5.add(r6)
            r0 = 3
            goto L8
        L29:
            android.view.View r6 = (android.view.View) r6
            boolean r0 = r6 instanceof android.view.ViewGroup
            if (r0 == 0) goto L31
            r0 = 5
            goto L8
        L31:
            r0 = 8
            goto L8
        L34:
            com.facebook.ads.redexgen.X.HX r3 = (com.facebook.ads.redexgen.X.HX) r3
            android.view.View r6 = (android.view.View) r6
            com.facebook.ads.redexgen.X.HQ r0 = r3.A0Y
            boolean r0 = r0.A8N(r6)
            if (r0 == 0) goto L42
            r0 = 3
            goto L8
        L42:
            r0 = 4
            goto L8
        L44:
            com.facebook.ads.redexgen.X.HX r3 = (com.facebook.ads.redexgen.X.HX) r3
            java.util.List r5 = (java.util.List) r5
            android.view.ViewGroup r2 = (android.view.ViewGroup) r2
            android.view.View r0 = r2.getChildAt(r1)
            r3.A0j(r5, r0)
            int r1 = r1 + 1
            r0 = 6
            goto L8
        L55:
            r0 = 4
            goto L8
        L57:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.HX.A0j(java.util.List, android.view.View):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0025, code lost:            return r2;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean A0k() {
        /*
            r4 = this;
            r3 = r4
            r2 = 0
            com.facebook.ads.redexgen.X.Hk r1 = r3.A12()
            com.facebook.ads.redexgen.X.Hk r0 = com.facebook.ads.redexgen.X.EnumC0447Hk.A04
            if (r1 == r0) goto L23
            r0 = 2
        Lb:
            switch(r0) {
                case 2: goto Lf;
                case 3: goto L1d;
                case 4: goto L25;
                case 5: goto L20;
                default: goto Le;
            }
        Le:
            goto Lb
        Lf:
            com.facebook.ads.redexgen.X.HX r3 = (com.facebook.ads.redexgen.X.HX) r3
            com.facebook.ads.redexgen.X.Hk r1 = r3.A12()
            com.facebook.ads.redexgen.X.Hk r0 = com.facebook.ads.redexgen.X.EnumC0447Hk.A02
            if (r1 != r0) goto L1b
            r0 = 3
            goto Lb
        L1b:
            r0 = 5
            goto Lb
        L1d:
            r2 = 1
            r0 = 4
            goto Lb
        L20:
            r2 = 0
            r0 = 4
            goto Lb
        L23:
            r0 = 3
            goto Lb
        L25:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.HX.A0k():boolean");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0021, code lost:            return r1;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean A0l() {
        /*
            r3 = this;
            r2 = r3
            r1 = 0
            com.facebook.ads.redexgen.X.1i r0 = r2.A0V
            if (r0 == 0) goto L1f
            r0 = 2
        L7:
            switch(r0) {
                case 2: goto Lb;
                case 3: goto L19;
                case 4: goto L21;
                case 5: goto L1c;
                default: goto La;
            }
        La:
            goto L7
        Lb:
            com.facebook.ads.redexgen.X.HX r2 = (com.facebook.ads.redexgen.X.HX) r2
            com.facebook.ads.redexgen.X.1i r0 = r2.A0V
            boolean r0 = r0.A0f()
            if (r0 == 0) goto L17
            r0 = 3
            goto L7
        L17:
            r0 = 5
            goto L7
        L19:
            r1 = 1
            r0 = 4
            goto L7
        L1c:
            r1 = 0
            r0 = 4
            goto L7
        L1f:
            r0 = 5
            goto L7
        L21:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.HX.A0l():boolean");
    }

    public final long A0s() {
        return this.A00;
    }

    @Nullable
    public final C00371i A0t() {
        return this.A0V;
    }

    public final EV A0u() {
        return this.A0W;
    }

    public final C0362Ec A0v() {
        return this.A0X;
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x001e, code lost:            return r1;     */
    @android.support.annotation.Nullable
    /* renamed from: A0w, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.facebook.ads.redexgen.X.HY getAdChoicesIcon() {
        /*
            r3 = this;
            r2 = r3
            r1 = 0
            boolean r0 = r2.isAdLoaded()
            if (r0 != 0) goto L1a
            r0 = 2
        L9:
            switch(r0) {
                case 2: goto Ld;
                case 3: goto L1c;
                case 4: goto L10;
                default: goto Lc;
            }
        Lc:
            goto L9
        Ld:
            r1 = 0
            r0 = 3
            goto L9
        L10:
            com.facebook.ads.redexgen.X.HX r2 = (com.facebook.ads.redexgen.X.HX) r2
            com.facebook.ads.redexgen.X.1i r0 = r2.A0V
            com.facebook.ads.redexgen.X.HY r1 = r0.A0H()
            r0 = 3
            goto L9
        L1a:
            r0 = 4
            goto L9
        L1c:
            com.facebook.ads.redexgen.X.HY r1 = (com.facebook.ads.redexgen.X.HY) r1
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.HX.getAdChoicesIcon():com.facebook.ads.redexgen.X.HY");
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x001e, code lost:            return r1;     */
    @android.support.annotation.Nullable
    /* renamed from: A0x, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.facebook.ads.redexgen.X.HY getAdCoverImage() {
        /*
            r3 = this;
            r2 = r3
            r1 = 0
            boolean r0 = r2.isAdLoaded()
            if (r0 != 0) goto L1a
            r0 = 2
        L9:
            switch(r0) {
                case 2: goto Ld;
                case 3: goto L1c;
                case 4: goto L10;
                default: goto Lc;
            }
        Lc:
            goto L9
        Ld:
            r1 = 0
            r0 = 3
            goto L9
        L10:
            com.facebook.ads.redexgen.X.HX r2 = (com.facebook.ads.redexgen.X.HX) r2
            com.facebook.ads.redexgen.X.1i r0 = r2.A0V
            com.facebook.ads.redexgen.X.HY r1 = r0.A0I()
            r0 = 3
            goto L9
        L1a:
            r0 = 4
            goto L9
        L1c:
            com.facebook.ads.redexgen.X.HY r1 = (com.facebook.ads.redexgen.X.HY) r1
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.HX.getAdCoverImage():com.facebook.ads.redexgen.X.HY");
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x001e, code lost:            return r1;     */
    @android.support.annotation.Nullable
    /* renamed from: A0y, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.facebook.ads.redexgen.X.HY getAdIcon() {
        /*
            r3 = this;
            r2 = r3
            r1 = 0
            boolean r0 = r2.isAdLoaded()
            if (r0 != 0) goto L1a
            r0 = 2
        L9:
            switch(r0) {
                case 2: goto Ld;
                case 3: goto L1c;
                case 4: goto L10;
                default: goto Lc;
            }
        Lc:
            goto L9
        Ld:
            r1 = 0
            r0 = 3
            goto L9
        L10:
            com.facebook.ads.redexgen.X.HX r2 = (com.facebook.ads.redexgen.X.HX) r2
            com.facebook.ads.redexgen.X.1i r0 = r2.A0V
            com.facebook.ads.redexgen.X.HY r1 = r0.A0J()
            r0 = 3
            goto L9
        L1a:
            r0 = 4
            goto L9
        L1c:
            com.facebook.ads.redexgen.X.HY r1 = (com.facebook.ads.redexgen.X.HY) r1
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.HX.getAdIcon():com.facebook.ads.redexgen.X.HY");
    }

    @Nullable
    public final HZ A0z() {
        return this.A0F;
    }

    public final C0444Hh A10() {
        return this.A0G;
    }

    public final EnumC0445Hi A11() {
        return this.A0H;
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0021, code lost:            return r1;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.facebook.ads.redexgen.X.EnumC0447Hk A12() {
        /*
            r3 = this;
            r2 = r3
            r1 = 0
            boolean r0 = r2.isAdLoaded()
            if (r0 != 0) goto L1b
            r0 = 2
        L9:
            switch(r0) {
                case 2: goto Ld;
                case 3: goto L1d;
                case 4: goto L11;
                default: goto Lc;
            }
        Lc:
            goto L9
        Ld:
            com.facebook.ads.redexgen.X.Hk r1 = com.facebook.ads.redexgen.X.EnumC0447Hk.A02
            r0 = 3
            goto L9
        L11:
            com.facebook.ads.redexgen.X.HX r2 = (com.facebook.ads.redexgen.X.HX) r2
            com.facebook.ads.redexgen.X.1i r0 = r2.A0V
            com.facebook.ads.redexgen.X.Hk r1 = r0.A0L()
            r0 = 3
            goto L9
        L1b:
            r0 = 4
            goto L9
        L1d:
            com.facebook.ads.redexgen.X.Hk r1 = (com.facebook.ads.redexgen.X.EnumC0447Hk) r1
            com.facebook.ads.redexgen.X.Hk r1 = (com.facebook.ads.redexgen.X.EnumC0447Hk) r1
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.HX.A12():com.facebook.ads.redexgen.X.Hk");
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x001e, code lost:            return r1;     */
    @android.support.annotation.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.String A13() {
        /*
            r3 = this;
            r2 = r3
            r1 = 0
            boolean r0 = r2.isAdLoaded()
            if (r0 != 0) goto L1a
            r0 = 2
        L9:
            switch(r0) {
                case 2: goto Ld;
                case 3: goto L1c;
                case 4: goto L10;
                default: goto Lc;
            }
        Lc:
            goto L9
        Ld:
            r1 = 0
            r0 = 3
            goto L9
        L10:
            com.facebook.ads.redexgen.X.HX r2 = (com.facebook.ads.redexgen.X.HX) r2
            com.facebook.ads.redexgen.X.1i r0 = r2.A0V
            java.lang.String r1 = r0.A4V()
            r0 = 3
            goto L9
        L1a:
            r0 = 4
            goto L9
        L1c:
            java.lang.String r1 = (java.lang.String) r1
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.HX.A13():java.lang.String");
    }

    @Nullable
    public final String A14() {
        return this.A0O;
    }

    @Nullable
    public final String A15() {
        return A19(A0S(227, 17, 30));
    }

    @Nullable
    public final String A16() {
        return A19(A0S(198, 16, 88));
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x001e, code lost:            return r1;     */
    @android.support.annotation.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.String A17() {
        /*
            r3 = this;
            r2 = r3
            r1 = 0
            boolean r0 = r2.isAdLoaded()
            if (r0 != 0) goto L1a
            r0 = 2
        L9:
            switch(r0) {
                case 2: goto Ld;
                case 3: goto L1c;
                case 4: goto L10;
                default: goto Lc;
            }
        Lc:
            goto L9
        Ld:
            r1 = 0
            r0 = 3
            goto L9
        L10:
            com.facebook.ads.redexgen.X.HX r2 = (com.facebook.ads.redexgen.X.HX) r2
            com.facebook.ads.redexgen.X.1i r0 = r2.A0V
            java.lang.String r1 = r0.A0Q()
            r0 = 3
            goto L9
        L1a:
            r0 = 4
            goto L9
        L1c:
            java.lang.String r1 = (java.lang.String) r1
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.HX.A17():java.lang.String");
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x0036, code lost:            return r1;     */
    @android.support.annotation.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.String A18() {
        /*
            r3 = this;
            r2 = r3
            r1 = 0
            boolean r0 = r2.isAdLoaded()
            if (r0 == 0) goto L32
            r0 = 2
        L9:
            switch(r0) {
                case 2: goto Ld;
                case 3: goto L1f;
                case 4: goto L34;
                case 5: goto L22;
                default: goto Lc;
            }
        Lc:
            goto L9
        Ld:
            com.facebook.ads.redexgen.X.HX r2 = (com.facebook.ads.redexgen.X.HX) r2
            com.facebook.ads.redexgen.X.1i r0 = r2.A0V
            java.lang.String r0 = r0.A0R()
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 == 0) goto L1d
            r0 = 3
            goto L9
        L1d:
            r0 = 5
            goto L9
        L1f:
            r1 = 0
            r0 = 4
            goto L9
        L22:
            com.facebook.ads.redexgen.X.HX r2 = (com.facebook.ads.redexgen.X.HX) r2
            com.facebook.ads.redexgen.X.EV r1 = r2.A0W
            com.facebook.ads.redexgen.X.1i r0 = r2.A0V
            java.lang.String r0 = r0.A0R()
            java.lang.String r1 = r1.A0L(r0)
            r0 = 4
            goto L9
        L32:
            r0 = 3
            goto L9
        L34:
            java.lang.String r1 = (java.lang.String) r1
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.HX.A18():java.lang.String");
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0020, code lost:            return r1;     */
    @android.support.annotation.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.String A19(java.lang.String r4) {
        /*
            r3 = this;
            r2 = r3
            r1 = 0
            boolean r0 = r2.isAdLoaded()
            if (r0 != 0) goto L1c
            r0 = 2
        L9:
            switch(r0) {
                case 2: goto Ld;
                case 3: goto L1e;
                case 4: goto L10;
                default: goto Lc;
            }
        Lc:
            goto L9
        Ld:
            r1 = 0
            r0 = 3
            goto L9
        L10:
            com.facebook.ads.redexgen.X.HX r2 = (com.facebook.ads.redexgen.X.HX) r2
            java.lang.String r4 = (java.lang.String) r4
            com.facebook.ads.redexgen.X.1i r0 = r2.A0V
            java.lang.String r1 = r0.A0S(r4)
            r0 = 3
            goto L9
        L1c:
            r0 = 4
            goto L9
        L1e:
            java.lang.String r1 = (java.lang.String) r1
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.HX.A19(java.lang.String):java.lang.String");
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x001e, code lost:            return r1;     */
    @android.support.annotation.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.util.List<com.facebook.ads.redexgen.X.HX> A1A() {
        /*
            r3 = this;
            r2 = r3
            r1 = 0
            boolean r0 = r2.isAdLoaded()
            if (r0 != 0) goto L1a
            r0 = 2
        L9:
            switch(r0) {
                case 2: goto Ld;
                case 3: goto L1c;
                case 4: goto L10;
                default: goto Lc;
            }
        Lc:
            goto L9
        Ld:
            r1 = 0
            r0 = 3
            goto L9
        L10:
            com.facebook.ads.redexgen.X.HX r2 = (com.facebook.ads.redexgen.X.HX) r2
            com.facebook.ads.redexgen.X.1i r0 = r2.A0V
            java.util.List r1 = r0.A0T()
            r0 = 3
            goto L9
        L1a:
            r0 = 4
            goto L9
        L1c:
            java.util.List r1 = (java.util.List) r1
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.HX.A1A():java.util.List");
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x0052, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void A1B() {
        /*
            r5 = this;
            r4 = r5
            r2 = 0
            com.facebook.ads.redexgen.X.Ec r0 = r4.A0X
            com.facebook.ads.redexgen.X.Ef r1 = r0.A00()
            r0 = 0
            boolean r0 = com.facebook.ads.redexgen.X.AnonymousClass43.A0P(r1, r0)
            if (r0 != 0) goto L50
            r0 = 2
        L10:
            switch(r0) {
                case 2: goto L14;
                case 3: goto L52;
                case 4: goto L1b;
                case 5: goto L35;
                case 6: goto L3c;
                default: goto L13;
            }
        L13:
            goto L10
        L14:
            com.facebook.ads.redexgen.X.HX r4 = (com.facebook.ads.redexgen.X.HX) r4
            r4.A0W()
            r0 = 3
            goto L10
        L1b:
            com.facebook.ads.redexgen.X.HX r4 = (com.facebook.ads.redexgen.X.HX) r4
            com.facebook.ads.redexgen.X.Ec r3 = r4.A0X
            com.facebook.ads.redexgen.X.Ec r0 = r4.A0X
            com.facebook.ads.redexgen.X.Gl r2 = r0.A05()
            java.lang.String r1 = r4.A13()
            com.facebook.ads.NativeAdLayout r0 = r4.A06
            com.facebook.ads.redexgen.X.MZ r2 = com.facebook.ads.redexgen.X.C0562Ma.A01(r3, r2, r1, r0)
            if (r2 != 0) goto L33
            r0 = 5
            goto L10
        L33:
            r0 = 6
            goto L10
        L35:
            com.facebook.ads.redexgen.X.HX r4 = (com.facebook.ads.redexgen.X.HX) r4
            r4.A0W()
            r0 = 3
            goto L10
        L3c:
            com.facebook.ads.redexgen.X.HX r4 = (com.facebook.ads.redexgen.X.HX) r4
            com.facebook.ads.redexgen.X.MZ r2 = (com.facebook.ads.redexgen.X.MZ) r2
            com.facebook.ads.NativeAdLayout r0 = r4.A06
            com.facebook.ads.internal.api.NativeAdLayoutApi r0 = r0.getNativeAdLayoutApi()
            com.facebook.ads.redexgen.X.8J r0 = (com.facebook.ads.redexgen.X.C8J) r0
            r0.A03(r2)
            r2.A0J()
            r0 = 3
            goto L10
        L50:
            r0 = 4
            goto L10
        L52:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.HX.A1B():void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0014, code lost:            A1S(r2, true);     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x001a, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void A1C(@android.support.annotation.Nullable android.graphics.drawable.Drawable r4) {
        /*
            r3 = this;
            r2 = 0
            r0 = 0
            r1 = 1
            r3.A01 = r4
            if (r4 == 0) goto L12
            r0 = 2
        L8:
            switch(r0) {
                case 2: goto Lc;
                case 3: goto L14;
                case 4: goto Lf;
                default: goto Lb;
            }
        Lb:
            goto L8
        Lc:
            r2 = r1
            r0 = 3
            goto L8
        Lf:
            r2 = 0
            r0 = 3
            goto L8
        L12:
            r0 = 4
            goto L8
        L14:
            r0 = r3
            com.facebook.ads.redexgen.X.HX r0 = (com.facebook.ads.redexgen.X.HX) r0
            r0.A1S(r2, r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.HX.A1C(android.graphics.drawable.Drawable):void");
    }

    public final void A1D(View view, ImageView imageView) {
        ArrayList arrayList = new ArrayList();
        A0j(arrayList, view);
        A0a(view, imageView, arrayList, true);
    }

    public final void A1E(View view, ImageView imageView, List<View> list) {
        A0a(view, imageView, list, true);
    }

    public final void A1F(View view, AdNativeComponentView adNativeComponentView) {
        ArrayList arrayList = new ArrayList();
        A0j(arrayList, view);
        A0a(view, adNativeComponentView, arrayList, false);
    }

    public final void A1G(View view, AdNativeComponentView adNativeComponentView, List<View> list) {
        A0a(view, adNativeComponentView, list, false);
    }

    public final void A1H(MediaView mediaView) {
        if (mediaView != null) {
            this.A0T = true;
        }
    }

    public final void A1I(MediaView mediaView) {
        if (mediaView != null) {
            this.A0U = true;
        }
    }

    public final void A1J(@Nullable NativeAdLayout nativeAdLayout) {
        this.A06 = nativeAdLayout;
    }

    public final void A1K(@Nullable C02027x c02027x) {
        this.A0P = new WeakReference<>(c02027x);
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:5:0x0010. Please report as an issue. */
    public final void A1L(HI hi, @Nullable String str, C0360Ea c0360Ea) {
        HX hx = this;
        String str2 = null;
        C0453Hr error = null;
        hx.A00 = System.currentTimeMillis();
        char c = hx.A0e ? (char) 2 : (char) 7;
        while (true) {
            switch (c) {
                case 2:
                    hx = hx;
                    AdSettings.IntegrationErrorMode A00 = C3C.A00(hx.A0X);
                    str2 = A0S(607, 30, 13);
                    c = AdSettings.IntegrationErrorMode.INTEGRATION_ERROR_CRASH_DEBUG_MODE.equals(A00) ? (char) 3 : (char) 4;
                case 3:
                    throw new C3Z(str2);
                case 4:
                    hx = hx;
                    error = new C0453Hr(AdErrorType.LOAD_AD_CALLED_MORE_THAN_ONCE, A0S(607, 30, 13));
                    hx.A0v().A08().A2a(K4.A01(hx.A00), error.A04().getErrorCode(), error.A05());
                    c = hx.A0F != null ? (char) 5 : '\n';
                case 5:
                    hx = hx;
                    error = error;
                    hx.A0F.A6Y(error);
                    c = 6;
                case 6:
                    hx = hx;
                    str2 = str2;
                    C0511Kb.A06(hx.A0v(), A0S(495, 3, 120), C0512Kc.A0Q, new C0514Ke(str2));
                    c = 7;
                case 7:
                    hx = hx;
                    hi = hi;
                    hx.A0e = true;
                    hx.A0D = hi;
                    c = hi.equals(HI.A05) ? '\b' : '\t';
                case '\b':
                    hx = hx;
                    hx.A07 = AnonymousClass22.A05;
                    c = '\t';
                case '\t':
                    HX hx2 = hx;
                    hx2.A0B = c0360Ea;
                    AnonymousClass31 anonymousClass31 = new AnonymousClass31(hx2.A0b, hx2.A0I, hx2.A0O(), null, 1);
                    anonymousClass31.A04(hi);
                    anonymousClass31.A05(hx2.A0N);
                    anonymousClass31.A06(hx2.A0O);
                    hx2.A09 = new C3I(hx2.A0X, anonymousClass31);
                    hx2.A09.A0E(new HL(hx2));
                    hx2.A09.A0G(str);
                    return;
                case '\n':
                    str2 = str2;
                    Log.e(A0S(165, 17, 72), str2);
                    c = 6;
            }
        }
    }

    public final void A1M(C0444Hh c0444Hh) {
        this.A0G = c0444Hh;
    }

    public final void A1N(EnumC0445Hi enumC0445Hi) {
        this.A0H = enumC0445Hi;
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x0042, code lost:            r2.A0I = r4;     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0048, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void A1O(com.facebook.ads.redexgen.X.EnumC0458Hx r4) {
        /*
            r3 = this;
            r2 = r3
            boolean r0 = r2.A0l()
            if (r0 != 0) goto L40
            r0 = 2
        L8:
            switch(r0) {
                case 2: goto Lc;
                case 3: goto L1a;
                case 4: goto L42;
                case 5: goto L2d;
                default: goto Lb;
            }
        Lb:
            goto L8
        Lc:
            com.facebook.ads.redexgen.X.Hx r4 = (com.facebook.ads.redexgen.X.EnumC0458Hx) r4
            com.facebook.ads.redexgen.X.Hx r0 = com.facebook.ads.redexgen.X.EnumC0458Hx.A05
            boolean r0 = r0.equals(r4)
            if (r0 == 0) goto L18
            r0 = 3
            goto L8
        L18:
            r0 = 5
            goto L8
        L1a:
            com.facebook.ads.redexgen.X.HX r2 = (com.facebook.ads.redexgen.X.HX) r2
            com.facebook.ads.redexgen.X.Ec r0 = r2.A0X
            com.facebook.ads.redexgen.X.0c r1 = r0.A08()
            com.facebook.ads.internal.protocol.AdPlacementType r0 = com.facebook.ads.internal.protocol.AdPlacementType.NATIVE_BANNER
            java.lang.String r0 = r0.toString()
            r1.A2g(r0)
            r0 = 4
            goto L8
        L2d:
            com.facebook.ads.redexgen.X.HX r2 = (com.facebook.ads.redexgen.X.HX) r2
            com.facebook.ads.redexgen.X.Ec r0 = r2.A0X
            com.facebook.ads.redexgen.X.0c r1 = r0.A08()
            com.facebook.ads.internal.protocol.AdPlacementType r0 = com.facebook.ads.internal.protocol.AdPlacementType.NATIVE
            java.lang.String r0 = r0.toString()
            r1.A2g(r0)
            r0 = 4
            goto L8
        L40:
            r0 = 4
            goto L8
        L42:
            com.facebook.ads.redexgen.X.HX r2 = (com.facebook.ads.redexgen.X.HX) r2
            com.facebook.ads.redexgen.X.Hx r4 = (com.facebook.ads.redexgen.X.EnumC0458Hx) r4
            r2.A0I = r4
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.HX.A1O(com.facebook.ads.redexgen.X.Hx):void");
    }

    public final void A1P(AnonymousClass29 anonymousClass29) {
        this.A0Q = new WeakReference<>(anonymousClass29);
    }

    public final void A1Q(boolean z) {
        this.A0R = z;
    }

    public final void A1R(boolean z) {
        this.A0S = z;
    }

    /* JADX WARN: Code restructure failed: missing block: B:97:0x00e8, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void A1S(boolean r10, boolean r11) {
        /*
            Method dump skipped, instructions count: 268
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.HX.A1S(boolean, boolean):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0012, code lost:            return r1;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean A1T() {
        /*
            r2 = this;
            r1 = 0
            com.facebook.ads.NativeAdLayout r0 = r2.A06
            if (r0 != 0) goto L10
            r0 = 2
        L6:
            switch(r0) {
                case 2: goto La;
                case 3: goto L12;
                case 4: goto Ld;
                default: goto L9;
            }
        L9:
            goto L6
        La:
            r1 = 1
            r0 = 3
            goto L6
        Ld:
            r1 = 0
            r0 = 3
            goto L6
        L10:
            r0 = 4
            goto L6
        L12:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.HX.A1T():boolean");
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x002f, code lost:            return r3;     */
    @Override // com.facebook.ads.redexgen.X.HW
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int A4W() {
        /*
            r4 = this;
            r3 = 0
            r0 = 0
            r2 = 0
            android.view.View r1 = r4.A05
            boolean r0 = r1 instanceof com.facebook.ads.internal.api.AdNativeComponentView
            if (r0 == 0) goto L2d
            r0 = 2
        La:
            switch(r0) {
                case 2: goto Le;
                case 3: goto L1f;
                case 4: goto L2f;
                case 5: goto L2a;
                default: goto Ld;
            }
        Ld:
            goto La
        Le:
            android.view.View r1 = (android.view.View) r1
            r0 = r1
            com.facebook.ads.internal.api.AdNativeComponentView r0 = (com.facebook.ads.internal.api.AdNativeComponentView) r0
            android.view.View r2 = r0.getAdContentsView()
            boolean r0 = r2 instanceof com.facebook.ads.redexgen.X.QF
            if (r0 == 0) goto L1d
            r0 = 3
            goto La
        L1d:
            r0 = 5
            goto La
        L1f:
            android.view.View r2 = (android.view.View) r2
            r0 = r2
            com.facebook.ads.redexgen.X.QF r0 = (com.facebook.ads.redexgen.X.QF) r0
            int r3 = r0.getCurrentPosition()
            r0 = 4
            goto La
        L2a:
            r3 = -1
            r0 = 4
            goto La
        L2d:
            r0 = 5
            goto La
        L2f:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.HX.A4W():int");
    }

    public final NativeAdBase.NativeAdLoadConfigBuilder buildLoadAdConfig(NativeAdBase nativeAdBase) {
        return new C0448Hl(this, nativeAdBase);
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x0052, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void destroy() {
        /*
            r6 = this;
            r4 = r6
            r2 = 558(0x22e, float:7.82E-43)
            r1 = 7
            r0 = 104(0x68, float:1.46E-43)
            java.lang.String r5 = A0S(r2, r1, r0)
            r2 = 27
            r1 = 19
            r0 = 109(0x6d, float:1.53E-43)
            java.lang.String r3 = A0S(r2, r1, r0)
            r2 = 487(0x1e7, float:6.82E-43)
            r1 = 8
            r0 = 82
            java.lang.String r0 = A0S(r2, r1, r0)
            com.facebook.ads.redexgen.X.I5.A05(r5, r3, r0)
            boolean r0 = r4.A0l()
            if (r0 != 0) goto L50
            r0 = 2
        L28:
            switch(r0) {
                case 2: goto L2c;
                case 3: goto L39;
                case 4: goto L43;
                case 5: goto L52;
                default: goto L2b;
            }
        L2b:
            goto L28
        L2c:
            com.facebook.ads.redexgen.X.HX r4 = (com.facebook.ads.redexgen.X.HX) r4
            com.facebook.ads.redexgen.X.Ec r0 = r4.A0X
            com.facebook.ads.redexgen.X.0c r0 = r0.A08()
            r0.A2h()
            r0 = 3
            goto L28
        L39:
            com.facebook.ads.redexgen.X.HX r4 = (com.facebook.ads.redexgen.X.HX) r4
            com.facebook.ads.redexgen.X.3I r0 = r4.A09
            if (r0 == 0) goto L41
            r0 = 4
            goto L28
        L41:
            r0 = 5
            goto L28
        L43:
            com.facebook.ads.redexgen.X.HX r4 = (com.facebook.ads.redexgen.X.HX) r4
            com.facebook.ads.redexgen.X.3I r1 = r4.A09
            r0 = 1
            r1.A0I(r0)
            r0 = 0
            r4.A09 = r0
            r0 = 5
            goto L28
        L50:
            r0 = 3
            goto L28
        L52:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.HX.destroy():void");
    }

    public final void downloadMedia() {
        if (this.A0D.equals(HI.A05)) {
            this.A07 = AnonymousClass22.A04;
        }
        this.A0D = HI.A04;
        A0b(this.A0V, false);
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x001e, code lost:            return r1;     */
    @android.support.annotation.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.String getAdBodyText() {
        /*
            r3 = this;
            r2 = r3
            r1 = 0
            boolean r0 = r2.isAdLoaded()
            if (r0 != 0) goto L1a
            r0 = 2
        L9:
            switch(r0) {
                case 2: goto Ld;
                case 3: goto L1c;
                case 4: goto L10;
                default: goto Lc;
            }
        Lc:
            goto L9
        Ld:
            r1 = 0
            r0 = 3
            goto L9
        L10:
            com.facebook.ads.redexgen.X.HX r2 = (com.facebook.ads.redexgen.X.HX) r2
            com.facebook.ads.redexgen.X.1i r0 = r2.A0V
            java.lang.String r1 = r0.A0M()
            r0 = 3
            goto L9
        L1a:
            r0 = 4
            goto L9
        L1c:
            java.lang.String r1 = (java.lang.String) r1
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.HX.getAdBodyText():java.lang.String");
    }

    @Nullable
    public final String getAdCallToAction() {
        return A19(A0S(67, 14, 120));
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0020, code lost:            return r1;     */
    @android.support.annotation.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.String getAdChoicesImageUrl() {
        /*
            r3 = this;
            r2 = r3
            r1 = 0
            com.facebook.ads.redexgen.X.HY r0 = r2.getAdChoicesIcon()
            if (r0 != 0) goto L1c
            r0 = 2
        L9:
            switch(r0) {
                case 2: goto Ld;
                case 3: goto L1e;
                case 4: goto L10;
                default: goto Lc;
            }
        Lc:
            goto L9
        Ld:
            r1 = 0
            r0 = 3
            goto L9
        L10:
            com.facebook.ads.redexgen.X.HX r2 = (com.facebook.ads.redexgen.X.HX) r2
            com.facebook.ads.redexgen.X.HY r0 = r2.getAdChoicesIcon()
            java.lang.String r1 = r0.getUrl()
            r0 = 3
            goto L9
        L1c:
            r0 = 4
            goto L9
        L1e:
            java.lang.String r1 = (java.lang.String) r1
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.HX.getAdChoicesImageUrl():java.lang.String");
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x001e, code lost:            return r1;     */
    @android.support.annotation.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.String getAdChoicesLinkUrl() {
        /*
            r3 = this;
            r2 = r3
            r1 = 0
            boolean r0 = r2.isAdLoaded()
            if (r0 != 0) goto L1a
            r0 = 2
        L9:
            switch(r0) {
                case 2: goto Ld;
                case 3: goto L1c;
                case 4: goto L10;
                default: goto Lc;
            }
        Lc:
            goto L9
        Ld:
            r1 = 0
            r0 = 3
            goto L9
        L10:
            com.facebook.ads.redexgen.X.HX r2 = (com.facebook.ads.redexgen.X.HX) r2
            com.facebook.ads.redexgen.X.1i r0 = r2.A0V
            java.lang.String r1 = r0.A0N()
            r0 = 3
            goto L9
        L1a:
            r0 = 4
            goto L9
        L1c:
            java.lang.String r1 = (java.lang.String) r1
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.HX.getAdChoicesLinkUrl():java.lang.String");
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x001e, code lost:            return r1;     */
    @android.support.annotation.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.String getAdChoicesText() {
        /*
            r3 = this;
            r2 = r3
            r1 = 0
            boolean r0 = r2.isAdLoaded()
            if (r0 != 0) goto L1a
            r0 = 2
        L9:
            switch(r0) {
                case 2: goto Ld;
                case 3: goto L1c;
                case 4: goto L10;
                default: goto Lc;
            }
        Lc:
            goto L9
        Ld:
            r1 = 0
            r0 = 3
            goto L9
        L10:
            com.facebook.ads.redexgen.X.HX r2 = (com.facebook.ads.redexgen.X.HX) r2
            com.facebook.ads.redexgen.X.1i r0 = r2.A0V
            java.lang.String r1 = r0.A0O()
            r0 = 3
            goto L9
        L1a:
            r0 = 4
            goto L9
        L1c:
            java.lang.String r1 = (java.lang.String) r1
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.HX.getAdChoicesText():java.lang.String");
    }

    @Nullable
    public final String getAdHeadline() {
        return A19(A0S(46, 8, 110));
    }

    @Nullable
    public final String getAdLinkDescription() {
        return A19(A0S(182, 16, 106));
    }

    @Nullable
    public final String getAdSocialContext() {
        return A19(A0S(473, 14, 63));
    }

    @Nullable
    public final String getAdTranslation() {
        return A19(A0S(565, 14, 127));
    }

    @Nullable
    public final String getAdUntrimmedBodyText() {
        return A19(A0S(469, 4, 119));
    }

    @Nullable
    public final String getAdvertiserName() {
        return A19(A0S(244, 15, 1));
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x002b, code lost:            return r1;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final float getAspectRatio() {
        /*
            r5 = this;
            r4 = r5
            r0 = 0
            r3 = 0
            r2 = 0
            r1 = 0
            com.facebook.ads.redexgen.X.1i r0 = r4.A0V
            if (r0 == 0) goto L29
            r0 = 2
        La:
            switch(r0) {
                case 2: goto Le;
                case 3: goto L24;
                case 4: goto L2b;
                default: goto Ld;
            }
        Ld:
            goto La
        Le:
            com.facebook.ads.redexgen.X.HX r4 = (com.facebook.ads.redexgen.X.HX) r4
            com.facebook.ads.redexgen.X.1i r0 = r4.A0V
            com.facebook.ads.redexgen.X.HY r0 = r0.A0I()
            int r2 = r0.getWidth()
            int r3 = r0.getHeight()
            if (r3 <= 0) goto L22
            r0 = 3
            goto La
        L22:
            r0 = 4
            goto La
        L24:
            float r1 = (float) r2
            float r0 = (float) r3
            float r1 = r1 / r0
            r0 = 4
            goto La
        L29:
            r0 = 4
            goto La
        L2b:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.HX.getAspectRatio():float");
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x001a, code lost:            return r1;     */
    @android.support.annotation.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.String getId() {
        /*
            r3 = this;
            r2 = r3
            r1 = 0
            boolean r0 = r2.isAdLoaded()
            if (r0 != 0) goto L16
            r0 = 2
        L9:
            switch(r0) {
                case 2: goto Ld;
                case 3: goto L18;
                case 4: goto L10;
                default: goto Lc;
            }
        Lc:
            goto L9
        Ld:
            r1 = 0
            r0 = 3
            goto L9
        L10:
            com.facebook.ads.redexgen.X.HX r2 = (com.facebook.ads.redexgen.X.HX) r2
            java.lang.String r1 = r2.A0c
            r0 = 3
            goto L9
        L16:
            r0 = 4
            goto L9
        L18:
            java.lang.String r1 = (java.lang.String) r1
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.HX.getId():java.lang.String");
    }

    public final String getPlacementId() {
        return this.A0b;
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x004b, code lost:            return r2;     */
    @android.support.annotation.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final android.graphics.drawable.Drawable getPreloadedIconViewDrawable() {
        /*
            r7 = this;
            r6 = r7
            r5 = 0
            r2 = 0
            r4 = 0
            r0 = 0
            com.facebook.ads.redexgen.X.1i r3 = r6.A0V
            if (r3 == 0) goto L47
            r0 = 2
        La:
            switch(r0) {
                case 2: goto Le;
                case 3: goto L30;
                case 4: goto L1a;
                case 5: goto L49;
                case 6: goto L44;
                default: goto Ld;
            }
        Ld:
            goto La
        Le:
            com.facebook.ads.redexgen.X.1i r3 = (com.facebook.ads.redexgen.X.C00371i) r3
            com.facebook.ads.redexgen.X.HY r4 = r3.A0J()
            if (r4 == 0) goto L18
            r0 = 3
            goto La
        L18:
            r0 = 6
            goto La
        L1a:
            com.facebook.ads.redexgen.X.HX r6 = (com.facebook.ads.redexgen.X.HX) r6
            android.graphics.Bitmap r5 = (android.graphics.Bitmap) r5
            com.facebook.ads.redexgen.X.Ec r2 = r6.A0v()
            boolean r1 = r6.A1T()
            java.lang.String r0 = r6.A14()
            android.graphics.drawable.Drawable r2 = A05(r2, r5, r1, r0)
            r0 = 5
            goto La
        L30:
            com.facebook.ads.redexgen.X.HX r6 = (com.facebook.ads.redexgen.X.HX) r6
            com.facebook.ads.redexgen.X.HY r4 = (com.facebook.ads.redexgen.X.HY) r4
            com.facebook.ads.redexgen.X.EV r1 = r6.A0W
            java.lang.String r0 = r4.getUrl()
            android.graphics.Bitmap r5 = r1.A0H(r0)
            if (r5 == 0) goto L42
            r0 = 4
            goto La
        L42:
            r0 = 6
            goto La
        L44:
            r2 = 0
            r0 = 5
            goto La
        L47:
            r0 = 6
            goto La
        L49:
            android.graphics.drawable.Drawable r2 = (android.graphics.drawable.Drawable) r2
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.HX.getPreloadedIconViewDrawable():android.graphics.drawable.Drawable");
    }

    @Nullable
    public final String getPromotedTranslation() {
        return A19(A0S(587, 20, 121));
    }

    @Nullable
    public final String getSponsoredTranslation() {
        return A19(A0S(498, 21, 46));
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x0021, code lost:            return r1;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean hasCallToAction() {
        /*
            r3 = this;
            r2 = r3
            r1 = 0
            com.facebook.ads.redexgen.X.1i r0 = r2.A0V
            if (r0 == 0) goto L1f
            r0 = 2
        L7:
            switch(r0) {
                case 2: goto Lb;
                case 3: goto L19;
                case 4: goto L21;
                case 5: goto L1c;
                default: goto La;
            }
        La:
            goto L7
        Lb:
            com.facebook.ads.redexgen.X.HX r2 = (com.facebook.ads.redexgen.X.HX) r2
            com.facebook.ads.redexgen.X.1i r0 = r2.A0V
            boolean r0 = r0.A0d()
            if (r0 == 0) goto L17
            r0 = 3
            goto L7
        L17:
            r0 = 5
            goto L7
        L19:
            r1 = 1
            r0 = 4
            goto L7
        L1c:
            r1 = 0
            r0 = 4
            goto L7
        L1f:
            r0 = 5
            goto L7
        L21:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.HX.hasCallToAction():boolean");
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x002e, code lost:            return r1;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean isAdInvalidated() {
        /*
            r3 = this;
            r2 = r3
            r1 = 0
            com.facebook.ads.redexgen.X.3I r0 = r2.A09
            if (r0 == 0) goto L2c
            r0 = 2
        L7:
            switch(r0) {
                case 2: goto Lb;
                case 3: goto L2e;
                case 4: goto L15;
                case 5: goto L1f;
                case 6: goto L29;
                default: goto La;
            }
        La:
            goto L7
        Lb:
            com.facebook.ads.redexgen.X.HX r2 = (com.facebook.ads.redexgen.X.HX) r2
            com.facebook.ads.redexgen.X.3I r0 = r2.A09
            boolean r1 = r0.A0J()
            r0 = 3
            goto L7
        L15:
            com.facebook.ads.redexgen.X.HX r2 = (com.facebook.ads.redexgen.X.HX) r2
            com.facebook.ads.redexgen.X.3N r0 = r2.A0A
            if (r0 == 0) goto L1d
            r0 = 5
            goto L7
        L1d:
            r0 = 6
            goto L7
        L1f:
            com.facebook.ads.redexgen.X.HX r2 = (com.facebook.ads.redexgen.X.HX) r2
            com.facebook.ads.redexgen.X.3N r0 = r2.A0A
            boolean r1 = r0.A0A()
            r0 = 3
            goto L7
        L29:
            r1 = 1
            r0 = 3
            goto L7
        L2c:
            r0 = 4
            goto L7
        L2e:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.HX.isAdInvalidated():boolean");
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x0021, code lost:            return r1;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean isAdLoaded() {
        /*
            r3 = this;
            r2 = r3
            r1 = 0
            com.facebook.ads.redexgen.X.1i r0 = r2.A0V
            if (r0 == 0) goto L1f
            r0 = 2
        L7:
            switch(r0) {
                case 2: goto Lb;
                case 3: goto L19;
                case 4: goto L21;
                case 5: goto L1c;
                default: goto La;
            }
        La:
            goto L7
        Lb:
            com.facebook.ads.redexgen.X.HX r2 = (com.facebook.ads.redexgen.X.HX) r2
            com.facebook.ads.redexgen.X.1i r0 = r2.A0V
            boolean r0 = r0.A0e()
            if (r0 == 0) goto L17
            r0 = 3
            goto L7
        L17:
            r0 = 5
            goto L7
        L19:
            r1 = 1
            r0 = 4
            goto L7
        L1c:
            r1 = 0
            r0 = 4
            goto L7
        L1f:
            r0 = 5
            goto L7
        L21:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.HX.isAdLoaded():boolean");
    }

    public final void loadAd() {
        I5.A05(A0S(0, 6, 105), A0S(675, 24, 29), A0S(774, 8, 81));
        loadAd(NativeAdBase.MediaCacheFlag.ALL);
    }

    public final void loadAd(NativeAdBase.MediaCacheFlag mediaCacheFlag) {
        I5.A05(A0S(0, 6, 105), A0S(675, 24, 29), A0S(550, 8, 65));
        A0e(HI.A00(mediaCacheFlag), null);
    }

    public final void loadAd(NativeAdBase.NativeLoadAdConfig nativeLoadAdConfig) {
        I5.A05(A0S(0, 6, 105), A0S(675, 24, 29), A0S(404, 8, 52));
        ((C0448Hl) nativeLoadAdConfig).loadAd();
    }

    public final void loadAdFromBid(String str) {
        I5.A05(A0S(214, 13, 60), A0S(675, 24, 29), A0S(579, 8, 69));
        loadAdFromBid(str, NativeAdBase.MediaCacheFlag.ALL);
    }

    public final void loadAdFromBid(String str, NativeAdBase.MediaCacheFlag mediaCacheFlag) {
        I5.A05(A0S(214, 13, 60), A0S(675, 24, 29), A0S(667, 8, 32));
        A0e(HI.A00(mediaCacheFlag), str);
    }

    public final void onCtaBroadcast() {
        this.A04.performClick();
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x006c, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void repair(java.lang.Throwable r7) {
        /*
            r6 = this;
            r4 = r6
            r3 = 0
            r5 = 0
            android.view.View r0 = r4.A03
            if (r0 == 0) goto L6a
            r0 = 2
        L8:
            switch(r0) {
                case 2: goto Lc;
                case 3: goto L1a;
                case 4: goto L5a;
                case 5: goto L6c;
                default: goto Lb;
            }
        Lb:
            goto L8
        Lc:
            com.facebook.ads.redexgen.X.HX r4 = (com.facebook.ads.redexgen.X.HX) r4
            android.view.View r1 = r4.A03
            com.facebook.ads.redexgen.X.HJ r0 = new com.facebook.ads.redexgen.X.HJ
            r0.<init>(r4)
            r1.post(r0)
            r0 = 3
            goto L8
        L1a:
            com.facebook.ads.redexgen.X.HX r4 = (com.facebook.ads.redexgen.X.HX) r4
            java.lang.Throwable r7 = (java.lang.Throwable) r7
            r3 = 2001(0x7d1, float:2.804E-42)
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            r2 = 367(0x16f, float:5.14E-43)
            r1 = 16
            r0 = 20
            java.lang.String r0 = A0S(r2, r1, r0)
            java.lang.StringBuilder r1 = r5.append(r0)
            com.facebook.ads.redexgen.X.Ec r0 = r4.A0X
            java.lang.String r0 = com.facebook.ads.redexgen.X.C0504Ju.A03(r0, r7)
            java.lang.StringBuilder r0 = r1.append(r0)
            java.lang.String r5 = r0.toString()
            com.facebook.ads.redexgen.X.Ec r0 = r4.A0v()
            com.facebook.ads.redexgen.X.0c r2 = r0.A08()
            long r0 = r4.A00
            long r0 = com.facebook.ads.redexgen.X.K4.A01(r0)
            r2.A2a(r0, r3, r5)
            com.facebook.ads.redexgen.X.HZ r0 = r4.A0F
            if (r0 == 0) goto L58
            r0 = 4
            goto L8
        L58:
            r0 = 5
            goto L8
        L5a:
            com.facebook.ads.redexgen.X.HX r4 = (com.facebook.ads.redexgen.X.HX) r4
            java.lang.String r5 = (java.lang.String) r5
            com.facebook.ads.redexgen.X.HZ r1 = r4.A0F
            com.facebook.ads.redexgen.X.Hr r0 = new com.facebook.ads.redexgen.X.Hr
            r0.<init>(r3, r5)
            r1.A6Y(r0)
            r0 = 5
            goto L8
        L6a:
            r0 = 3
            goto L8
        L6c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.HX.repair(java.lang.Throwable):void");
    }

    public final void setAdListener(NativeAdListener nativeAdListener, NativeAdBase nativeAdBase) {
        if (nativeAdListener == null) {
            return;
        }
        A0h(new C0442Hf(nativeAdListener, nativeAdBase));
    }

    public final void setExtraHints(ExtraHints extraHints) {
        if (extraHints == null) {
            return;
        }
        A0i(extraHints.getHints());
        this.A0O = extraHints.getMediationData();
    }

    public final void setOnTouchListener(View.OnTouchListener onTouchListener) {
        this.A02 = onTouchListener;
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:5:0x0008. Please report as an issue. */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [com.facebook.ads.redexgen.X.24, android.view.View, com.facebook.ads.redexgen.X.FP] */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v4 */
    public final void unregisterView() {
        HX hx = this;
        ?? r2 = 0;
        char c = hx.A03 != null ? (char) 2 : (char) 3;
        while (true) {
            switch (c) {
                case 2:
                    hx = hx;
                    c = hx.A05 == null ? (char) 3 : (char) 4;
                case 3:
                    return;
                case 4:
                    hx = hx;
                    c = !hx.A0l() ? (char) 5 : (char) 6;
                case 5:
                    hx = hx;
                    hx.A0X.A08().unregisterView();
                    c = 6;
                case 6:
                    hx = hx;
                    c = A0i.containsKey(hx.A03) ? (char) 7 : '\b';
                case 7:
                    hx = hx;
                    c = A0i.get(hx.A03).get() != hx ? '\b' : '\t';
                case '\b':
                    throw new IllegalStateException(A0S(412, 38, 46));
                case '\t':
                    hx = hx;
                    c = hx.A03 instanceof ViewGroup ? '\n' : '\f';
                case '\n':
                    hx = hx;
                    c = hx.A0J != null ? (char) 11 : '\f';
                case 11:
                    hx = hx;
                    r2 = 0;
                    ((ViewGroup) hx.A03).removeView(hx.A0J);
                    hx.A0J = null;
                    c = '\f';
                case '\f':
                    hx = hx;
                    c = hx.A0V != null ? '\r' : (char) 14;
                case '\r':
                    hx = hx;
                    hx.A0V.A0U();
                    c = 14;
                case 14:
                    c = Build.VERSION.SDK_INT >= 18 ? (char) 15 : (char) 18;
                case 15:
                    hx = hx;
                    c = hx.A0K != null ? (char) 16 : (char) 18;
                case 16:
                    hx = hx;
                    c = C0413Gc.A0d(hx.A0X) ? (char) 17 : (char) 18;
                case 17:
                    hx = hx;
                    hx.A0K.A07();
                    hx.A03.getOverlay().remove(hx.A0K);
                    c = 18;
                case 18:
                    hx = hx;
                    A0i.remove(hx.A03);
                    hx.A0V();
                    hx.A03 = r2;
                    hx.A05 = r2;
                    c = hx.A0M != null ? (char) 19 : (char) 20;
                case 19:
                    hx = hx;
                    hx.A0M.A0W();
                    hx.A0M = r2;
                    c = 20;
                case 20:
                    hx = hx;
                    hx.A08 = r2;
                    c = 3;
            }
        }
    }
}
