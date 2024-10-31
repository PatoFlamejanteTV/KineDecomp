package com.facebook.ads.redexgen.X;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Build;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.VisibleForTesting;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.animation.Interpolator;
import android.widget.EdgeEffect;
import com.facebook.ads.internal.androidx.support.v7.widget.RecyclerView;
import com.facebook.ads.internal.androidx.support.v7.widget.RecyclerView$SavedState;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.facebook.ads.redexgen.X.7a, reason: invalid class name and case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public class C01807a extends ViewGroup implements InterfaceC01154i {
    public static byte[] A18;
    public static final Interpolator A19;
    public static final boolean A1A;
    public static final boolean A1B;
    public static final boolean A1C;
    public static final boolean A1D;
    public static final boolean A1E;
    public static final boolean A1F;
    public static final int[] A1G;
    public static final int[] A1H;
    public static final Class<?>[] A1I;
    public C6G A00;
    public C6J A01;
    public C6Z A02;
    public RunnableC01566b A03;
    public C2E A04;
    public C6U A05;

    @VisibleForTesting
    public AbstractC01616g A06;
    public C7P A07;
    public C7Y A08;
    public C01827c A09;
    public boolean A0A;
    public boolean A0B;
    public boolean A0C;

    @VisibleForTesting
    public boolean A0D;
    public boolean A0E;
    public boolean A0F;
    public boolean A0G;
    public boolean A0H;
    public boolean A0I;
    public boolean A0J;
    public boolean A0K;
    public float A0L;
    public float A0M;
    public int A0N;
    public int A0O;
    public int A0P;
    public int A0Q;
    public int A0R;
    public int A0S;
    public int A0T;
    public int A0U;
    public int A0V;
    public int A0W;
    public int A0X;
    public VelocityTracker A0Y;
    public EdgeEffect A0Z;
    public EdgeEffect A0a;
    public EdgeEffect A0b;
    public EdgeEffect A0c;
    public C01164j A0d;
    public AnonymousClass78 A0e;
    public C7B A0f;
    public AbstractC01766w A0g;
    public C7K A0h;
    public C7L A0i;
    public RecyclerView$SavedState A0j;
    public Runnable A0k;
    public List<RecyclerView.OnChildAttachStateChangeListener> A0l;
    public List<C7L> A0m;
    public boolean A0n;
    public boolean A0o;
    public final Rect A0p;
    public final RectF A0q;
    public final C7O A0r;
    public final C7W A0s;
    public final C01907k A0t;
    public final Runnable A0u;
    public final ArrayList<C7E> A0v;

    @VisibleForTesting
    public final List<C7Z> A0w;
    public final int A0x;
    public final int A0y;
    public final Rect A0z;
    public final AccessibilityManager A10;
    public final C7Q A11;
    public final AnonymousClass72 A12;
    public final ArrayList<C7K> A13;
    public final int[] A14;
    public final int[] A15;
    public final int[] A16;
    public final int[] A17;

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0030, code lost:            return new java.lang.String(r2);     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String A08(int r2, int r3, int r4) {
        /*
            r0 = 0
            r0 = 0
            byte[] r1 = com.facebook.ads.redexgen.X.C01807a.A18
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
            r0 = r0 ^ 127(0x7f, float:1.78E-43)
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C01807a.A08(int, int, int):java.lang.String");
    }

    public static void A0M() {
        A18 = new byte[]{14, 11, 42, 101, 41, 36, 60, 42, 48, 49, 101, 40, 36, 43, 36, 34, 32, 55, 101, 36, 49, 49, 36, 38, 45, 32, 33, 126, 101, 54, 46, 44, 53, 53, 44, 43, 34, 101, 41, 36, 60, 42, 48, 49, 50, 16, 29, 29, 20, 21, 81, 3, 20, 28, 30, 7, 20, 53, 20, 5, 16, 18, 25, 20, 21, 39, 24, 20, 6, 81, 6, 24, 5, 25, 81, 16, 81, 7, 24, 20, 6, 81, 6, 25, 24, 18, 25, 81, 24, 2, 81, 31, 30, 5, 81, 23, 29, 16, 22, 22, 20, 21, 81, 16, 2, 81, 5, 28, 1, 81, 21, 20, 5, 16, 18, 25, 20, 21, 95, 113, 117, 3, 115, 66, 81, 87, 74, 66, 79, 106, 77, 85, 66, 79, 74, 71, 66, 87, 70, 47, 43, 93, 50, 19, 49, 28, 4, 18, 8, 9, 107, 37, 36, 63, 107, 45, 36, 62, 37, 47, 101, 107, 15, 34, 47, 107, 42, 37, 50, 107, 6, 36, 63, 34, 36, 37, 14, 61, 46, 37, 63, 56, 107, 44, 46, 63, 107, 56, 32, 34, 59, 59, 46, 47, 116, 54, 29, 82, 28, 29, 6, 82, 1, 23, 6, 62, 19, 11, 29, 7, 6, 52, 0, 29, 8, 23, 28, 82, 27, 28, 82, 30, 19, 11, 29, 7, 6, 82, 29, 0, 82, 1, 17, 0, 29, 30, 30, 14, 77, 79, 64, 64, 65, 90, 14, 76, 75, 14, 72, 65, 91, 64, 74, 14, 76, 91, 90, 14, 71, 90, 14, 71, 93, 14, 64, 75, 77, 75, 93, 93, 79, 92, 87, 14, 72, 65, 92, 14, 59, 45, 60, 27, 43, 58, 39, 36, 36, 33, 38, 47, 28, 39, 61, 43, 32, 27, 36, 39, 56, 96, 97, 114, 104, 42, 41, 44, 104, 41, 58, 47, 61, 37, 45, 38, 60, 104, 43, 39, 38, 59, 60, 41, 38, 60, 104, 63, 29, 18, 18, 19, 8, 92, 31, 29, 16, 16, 92, 8, 20, 21, 15, 92, 17, 25, 8, 20, 19, 24, 92, 21, 18, 92, 29, 92, 15, 31, 14, 19, 16, 16, 92, 31, 29, 16, 16, 30, 29, 31, 23, 82, 92, 47, 31, 14, 19, 16, 16, 92, 31, 29, 16, 16, 30, 29, 31, 23, 15, 92, 17, 21, 27, 20, 8, 30, 25, 92, 14, 9, 18, 92, 24, 9, 14, 21, 18, 27, 92, 29, 92, 17, 25, 29, 15, 9, 14, 25, 92, 90, 92, 16, 29, 5, 19, 9, 8, 92, 12, 29, 15, 15, 92, 11, 20, 25, 14, 25, 92, 5, 19, 9, 92, 31, 29, 18, 18, 19, 8, 92, 31, 20, 29, 18, 27, 25, 92, 8, 20, 25, 46, 25, 31, 5, 31, 16, 25, 14, 42, 21, 25, 11, 92, 24, 29, 8, 29, 82, 92, 61, 18, 5, 92, 17, 25, 8, 20, 19, 24, 92, 31, 29, 16, 16, 92, 8, 20, 29, 8, 92, 17, 21, 27, 20, 8, 92, 31, 20, 29, 18, 27, 25, 92, 8, 20, 25, 92, 15, 8, 14, 9, 31, 8, 9, 14, 25, 19, 26, 92, 8, 20, 25, 92, 46, 25, 31, 5, 31, 16, 25, 14, 42, 21, 25, 11, 92, 19, 14, 92, 8, 20, 25, 92, 29, 24, 29, 12, 8, 25, 14, 92, 31, 19, 18, 8, 25, 18, 8, 15, 92, 15, 20, 19, 9, 16, 24, 92, 30, 25, 92, 12, 19, 15, 8, 12, 19, 18, 25, 24, 92, 8, 19, 8, 20, 25, 92, 18, 25, 4, 8, 92, 26, 14, 29, 17, 25, 82, 91, 64, 21, 19, 9, 14, 7, 64, 4, 5, 6, 1, 21, 12, 20, 64, 22, 1, 12, 21, 5, 25, 52, 44, 58, 32, 33, 24, 52, 59, 52, 50, 48, 39, 117, 106, 93, 93, 64, 93, 15, 95, 93, 64, 76, 74, 92, 92, 70, 65, 72, 15, 92, 76, 93, 64, 67, 67, 20, 15, 95, 64, 70, 65, 91, 74, 93, 15, 70, 65, 75, 74, 87, 15, 73, 64, 93, 15, 70, 75, 15, 29, 42, 44, 54, 44, 35, 42, 61, 25, 38, 42, 56, 111, 43, 32, 42, 60, 111, 33, 32, 59, 111, 60, 58, 63, 63, 32, 61, 59, 111, 60, 44, 61, 32, 35, 35, 38, 33, 40, 111, 59, 32, 111, 46, 33, 111, 46, 45, 60, 32, 35, 58, 59, 42, 111, 63, 32, 60, 38, 59, 38, 32, 33, 97, 111, 26, 60, 42, 111, 60, 44, 61, 32, 35, 35, 27, 32, 31, 32, 60, 38, 59, 38, 32, 33, 111, 38, 33, 60, 59, 42, 46, 43, 26, 83, 73, 26, 91, 86, 72, 95, 91, 94, 67, 26, 91, 78, 78, 91, 89, 82, 95, 94, 26, 78, 85, 26, 91, 26, 104, 95, 89, 67, 89, 86, 95, 72, 108, 83, 95, 77, 0, 83, 114, 61, 124, 121, 124, 109, 105, 120, 111, 61, 124, 105, 105, 124, 126, 117, 120, 121, 38, 61, 110, 118, 116, 109, 109, 116, 115, 122, 61, 113, 124, 100, 114, 104, 105, 35, 28, 16, 2, 85, 93, Byte.MAX_VALUE, 112, 112, 113, 106, 62, 109, 125, 108, 113, 114, 114, 62, 105, 119, 106, 118, 113, 107, 106, 62, Byte.MAX_VALUE, 62, 82, Byte.MAX_VALUE, 103, 113, 107, 106, 83, Byte.MAX_VALUE, 112, Byte.MAX_VALUE, 121, 123, 108, 62, 109, 123, 106, 48, 62, 93, Byte.MAX_VALUE, 114, 114, 62, 109, 123, 106, 82, Byte.MAX_VALUE, 103, 113, 107, 106, 83, Byte.MAX_VALUE, 112, Byte.MAX_VALUE, 121, 123, 108, 62, 105, 119, 106, 118, 62, Byte.MAX_VALUE, 62, 112, 113, 112, 51, 112, 107, 114, 114, 62, Byte.MAX_VALUE, 108, 121, 107, 115, 123, 112, 106, 48, 24, 26, 26, 28, 10, 10, 16, 27, 16, 21, 16, 13, 0, 60, 31, 7, 72, 12, 1, 14, 14, 13, 26, 13, 6, 28, 72, 62, 1, 13, 31, 32, 7, 4, 12, 13, 26, 27, 72, 0, 9, 30, 13, 72, 28, 0, 13, 72, 27, 9, 5, 
        13, 72, 11, 0, 9, 6, 15, 13, 72, 33, 44, 70, 72, 60, 0, 1, 27, 72, 5, 1, 15, 0, 28, 72, 0, 9, 24, 24, 13, 6, 72, 12, 29, 13, 72, 28, 7, 72, 1, 6, 11, 7, 6, 27, 1, 27, 28, 13, 6, 28, 72, 41, 12, 9, 24, 28, 13, 26, 72, 29, 24, 12, 9, 28, 13, 72, 13, 30, 13, 6, 28, 27, 72, 7, 26, 72, 1, 14, 72, 28, 0, 13, 72, 36, 9, 17, 7, 29, 28, 37, 9, 6, 9, 15, 13, 26, 72, 4, 9, 17, 27, 72, 7, 29, 28, 72, 28, 0, 13, 72, 27, 9, 5, 13, 72, 62, 1, 13, 31, 72, 5, 29, 4, 28, 1, 24, 4, 13, 72, 28, 1, 5, 13, 27, 70, 98, 72, 62, 1, 13, 31, 32, 7, 4, 12, 13, 26, 72, 89, 82, 0, 34, 45, 45, 44, 55, 99, 32, 34, 47, 47, 99, 55, 43, 42, 48, 99, 46, 38, 55, 43, 44, 39, 99, 52, 43, 42, 47, 38, 99, 17, 38, 32, 58, 32, 47, 38, 49, 21, 42, 38, 52, 99, 42, 48, 99, 32, 44, 46, 51, 54, 55, 42, 45, 36, 99, 34, 99, 47, 34, 58, 44, 54, 55, 99, 44, 49, 99, 48, 32, 49, 44, 47, 47, 42, 45, 36, 112, 125, 102, 113, 119, 96, 125, 123, 122, 52, 121, 97, 103, 96, 52, 118, 113, 52, 117, 118, 103, 123, 120, 97, 96, 113, 58, 52, 102, 113, 119, 113, 125, 98, 113, 112, 46, 120, 116, 55, 59, 58, 32, 49, 44, 32, 110, 4, 39, 63, 112, 52, 57, 54, 54, 53, 34, 53, 62, 36, 112, 6, 57, 53, 39, 24, 63, 60, 52, 53, 34, 35, 112, 56, 49, 38, 53, 112, 36, 56, 53, 112, 35, 49, 61, 53, 112, 35, 36, 49, 50, 60, 53, 112, 25, 20, 126, 112, 3, 36, 49, 50, 60, 53, 112, 25, 20, 35, 112, 57, 62, 112, 41, 63, 37, 34, 112, 49, 52, 49, 32, 36, 53, 34, 112, 29, 5, 3, 4, 112, 18, 21, 112, 37, 62, 57, 33, 37, 53, 112, 49, 62, 52, 112, 3, 24, 31, 5, 28, 20, 112, 30, 31, 4, 112, 51, 56, 49, 62, 55, 53, 126, 90, 112, 6, 57, 53, 39, 24, 63, 60, 52, 53, 34, 112, 97, 106, 81, 115, 124, 124, 125, 102, 50, 97, Byte.MAX_VALUE, 125, 125, 102, 122, 50, 97, 113, 96, 125, 126, 126, 50, 101, 123, 102, 122, 125, 103, 102, 50, 115, 50, 94, 115, 107, 125, 103, 102, 95, 115, 124, 115, 117, 119, 96, 50, 97, 119, 102, 60, 50, 81, 115, 126, 126, 50, 97, 119, 102, 94, 115, 107, 125, 103, 102, 95, 115, 124, 115, 117, 119, 96, 50, 101, 123, 102, 122, 50, 115, 50, 124, 125, 124, 63, 124, 103, 126, 126, 50, 115, 96, 117, 103, Byte.MAX_VALUE, 119, 124, 102, 60, 73, 77, 59, 72, 120, 105, 116, 119, 119, 31, 61, 50, 50, 51, 40, 124, 47, 63, 46, 51, 48, 48, 124, 40, 51, 124, 44, 51, 47, 53, 40, 53, 51, 50, 124, 61, 124, 16, 61, 37, 51, 41, 40, 17, 61, 50, 61, 59, 57, 46, 124, 47, 57, 40, 114, 124, 31, 61, 48, 48, 124, 47, 57, 40, 16, 61, 37, 51, 41, 40, 17, 61, 50, 61, 59, 57, 46, 124, 43, 53, 40, 52, 124, 61, 124, 50, 51, 50, 113, 50, 41, 48, 48, 124, 61, 46, 59, 41, 49, 57, 50, 40, 114, 55, 126, 100, 55, 121, 120, 99, 55, 118, 55, 115, 126, 101, 114, 116, 99, 55, 116, Byte.MAX_VALUE, 126, 123, 115, 55, 120, 113, 55, 102, 68, 75, 75, 74, 81, 5, 67, 73, 76, 75, 66, 5, 82, 76, 81, 77, 74, 80, 81, 5, 68, 5, 105, 68, 92, 74, 80, 81, 104, 68, 75, 68, 66, 64, 87, 5, 86, 64, 81, 11, 5, 102, 68, 73, 73, 5, 86, 64, 81, 105, 68, 92, 74, 80, 81, 104, 68, 75, 68, 66, 64, 87, 5, 82, 76, 81, 77, 5, 68, 5, 75, 74, 75, 8, 75, 80, 73, 73, 5, 68, 87, 66, 80, 72, 64, 75, 81, 11, 33, 45, 97, 108, 116, 98, 120, 121, 55, 60, 48, 113, 116, 113, 96, 100, 117, 98, 42, 107, 65, 107, 29, 34, 46, 60, 107, 3, 36, 39, 47, 46, 57, 107, 121, 113, 58, 13, 11, 17, 11, 4, 13, 26, 62, 1, 13, 31, 72, 0, 9, 27, 72, 6, 7, 72, 36, 9, 17, 7, 29, 28, 37, 9, 6, 9, 15, 13, 26, 107, 92, 90, 64, 90, 85, 92, 75, 111, 80, 92, 78, 110, 106, 28, 122, 73, 80, 80, 117, 82, 74, 93, 80, 85, 88, 93, 72, 89, 3, 33, 60, 49, 63, 54, 62, 115, 36, 59, 58, 63, 54, 115, 62, 50, 39, 48, 59, 58, 61, 52, 115, 48, 59, 50, 61, 52, 54, 55, 115, 37, 58, 54, 36, 115, 59, 60, 63, 55, 54, 33, 32, 115, 36, 58, 39, 59, 115, 39, 59, 54, 115, 61, 54, 36, 60, 61, 54, 32, 125, 115, 7, 59, 54, 115, 35, 33, 54, 126, 63, 50, 42, 60, 38, 39, 115, 58, 61, 53, 60, 33, 62, 50, 39, 58, 60, 61, 115, 53, 60, 33, 115, 39, 59, 54, 115, 48, 59, 50, 61, 52, 54, 115, 59, 60, 63, 55, 54, 33, 115};
    }

    static {
        A0M();
        A1H = new int[]{R.attr.nestedScrollingEnabled};
        A1G = new int[]{R.attr.clipToPadding};
        A1B = Build.VERSION.SDK_INT == 18 || Build.VERSION.SDK_INT == 19 || Build.VERSION.SDK_INT == 20;
        A1A = Build.VERSION.SDK_INT >= 23;
        A1C = Build.VERSION.SDK_INT >= 16;
        A1D = Build.VERSION.SDK_INT >= 21;
        A1E = Build.VERSION.SDK_INT <= 15;
        A1F = Build.VERSION.SDK_INT <= 15;
        A1I = new Class[]{Context.class, AttributeSet.class, Integer.TYPE, Integer.TYPE};
        A19 = new Interpolator() { // from class: com.facebook.ads.redexgen.X.71
            @Override // android.animation.TimeInterpolator
            public final float getInterpolation(float f) {
                float f2 = f - 1.0f;
                return (f2 * f2 * f2 * f2 * f2) + 1.0f;
            }
        };
    }

    public C01807a(Context context) {
        this(context, null);
    }

    public C01807a(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.facebook.ads.redexgen.X.7Q] */
    public C01807a(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.A11 = new AnonymousClass77() { // from class: com.facebook.ads.redexgen.X.7Q
            @Override // com.facebook.ads.redexgen.X.AnonymousClass77
            public final void A00() {
                C01807a.this.A1e(null);
                C01807a.this.A0s.A0D = true;
                C01807a.this.A1F();
                if (!C01807a.this.A00.A0J()) {
                    C01807a.this.requestLayout();
                }
            }
        };
        this.A0r = new C7O(this);
        this.A0t = new C01907k();
        this.A0u = new Runnable() { // from class: com.facebook.ads.redexgen.X.6z
            /* JADX WARN: Code restructure failed: missing block: B:44:0x0050, code lost:            return;     */
            @Override // java.lang.Runnable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final void run() {
                /*
                    r3 = this;
                    r2 = r3
                    com.facebook.ads.redexgen.X.7a r0 = com.facebook.ads.redexgen.X.C01807a.this
                    boolean r0 = r0.A0D
                    if (r0 == 0) goto L4e
                    r0 = 2
                L8:
                    switch(r0) {
                        case 2: goto L22;
                        case 3: goto L50;
                        case 4: goto L30;
                        case 5: goto L19;
                        case 6: goto Lc;
                        case 7: goto L3c;
                        case 8: goto L45;
                        default: goto Lb;
                    }
                Lb:
                    goto L8
                Lc:
                    com.facebook.ads.redexgen.X.6z r2 = (com.facebook.ads.redexgen.X.RunnableC01796z) r2
                    com.facebook.ads.redexgen.X.7a r0 = com.facebook.ads.redexgen.X.C01807a.this
                    boolean r0 = r0.A0I
                    if (r0 == 0) goto L16
                    r0 = 7
                    goto L8
                L16:
                    r0 = 8
                    goto L8
                L19:
                    com.facebook.ads.redexgen.X.6z r2 = (com.facebook.ads.redexgen.X.RunnableC01796z) r2
                    com.facebook.ads.redexgen.X.7a r0 = com.facebook.ads.redexgen.X.C01807a.this
                    r0.requestLayout()
                    r0 = 3
                    goto L8
                L22:
                    com.facebook.ads.redexgen.X.6z r2 = (com.facebook.ads.redexgen.X.RunnableC01796z) r2
                    com.facebook.ads.redexgen.X.7a r0 = com.facebook.ads.redexgen.X.C01807a.this
                    boolean r0 = r0.isLayoutRequested()
                    if (r0 == 0) goto L2e
                    r0 = 3
                    goto L8
                L2e:
                    r0 = 4
                    goto L8
                L30:
                    com.facebook.ads.redexgen.X.6z r2 = (com.facebook.ads.redexgen.X.RunnableC01796z) r2
                    com.facebook.ads.redexgen.X.7a r0 = com.facebook.ads.redexgen.X.C01807a.this
                    boolean r0 = r0.A0F
                    if (r0 != 0) goto L3a
                    r0 = 5
                    goto L8
                L3a:
                    r0 = 6
                    goto L8
                L3c:
                    com.facebook.ads.redexgen.X.6z r2 = (com.facebook.ads.redexgen.X.RunnableC01796z) r2
                    com.facebook.ads.redexgen.X.7a r1 = com.facebook.ads.redexgen.X.C01807a.this
                    r0 = 1
                    r1.A0J = r0
                    r0 = 3
                    goto L8
                L45:
                    com.facebook.ads.redexgen.X.6z r2 = (com.facebook.ads.redexgen.X.RunnableC01796z) r2
                    com.facebook.ads.redexgen.X.7a r0 = com.facebook.ads.redexgen.X.C01807a.this
                    r0.A18()
                    r0 = 3
                    goto L8
                L4e:
                    r0 = 3
                    goto L8
                L50:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.RunnableC01796z.run():void");
            }
        };
        this.A0p = new Rect();
        this.A0z = new Rect();
        this.A0q = new RectF();
        this.A0v = new ArrayList<>();
        this.A13 = new ArrayList<>();
        this.A0O = 0;
        this.A0C = false;
        this.A0U = 0;
        this.A0N = 0;
        this.A05 = new C6W();
        this.A0W = 0;
        this.A0V = -1;
        this.A0L = Float.MIN_VALUE;
        this.A0M = Float.MIN_VALUE;
        this.A0o = true;
        this.A08 = new C7Y(this);
        this.A02 = A1D ? new C6Z() : null;
        this.A0s = new C7W();
        this.A0G = false;
        this.A0H = false;
        this.A0f = new C7B() { // from class: com.facebook.ads.redexgen.X.7D
            /* JADX WARN: Code restructure failed: missing block: B:50:0x0061, code lost:            return;     */
            @Override // com.facebook.ads.redexgen.X.C7B
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final void A6A(com.facebook.ads.redexgen.X.C7Z r6) {
                /*
                    r5 = this;
                    r4 = r5
                    r0 = 0
                    r3 = 0
                    r0 = 1
                    r6.A0Z(r0)
                    com.facebook.ads.redexgen.X.7Z r0 = r6.A06
                    if (r0 == 0) goto L5f
                    r0 = 2
                Lc:
                    switch(r0) {
                        case 2: goto L55;
                        case 3: goto L3f;
                        case 4: goto L30;
                        case 5: goto L1d;
                        case 6: goto L10;
                        case 7: goto L46;
                        case 8: goto L61;
                        default: goto Lf;
                    }
                Lf:
                    goto Lc
                L10:
                    com.facebook.ads.redexgen.X.7Z r6 = (com.facebook.ads.redexgen.X.C7Z) r6
                    boolean r0 = r6.A0e()
                    if (r0 == 0) goto L1a
                    r0 = 7
                    goto Lc
                L1a:
                    r0 = 8
                    goto Lc
                L1d:
                    com.facebook.ads.redexgen.X.7D r4 = (com.facebook.ads.redexgen.X.C7D) r4
                    com.facebook.ads.redexgen.X.7Z r6 = (com.facebook.ads.redexgen.X.C7Z) r6
                    com.facebook.ads.redexgen.X.7a r1 = com.facebook.ads.redexgen.X.C01807a.this
                    android.view.View r0 = r6.A0H
                    boolean r0 = r1.A1o(r0)
                    if (r0 != 0) goto L2d
                    r0 = 6
                    goto Lc
                L2d:
                    r0 = 8
                    goto Lc
                L30:
                    com.facebook.ads.redexgen.X.7Z r6 = (com.facebook.ads.redexgen.X.C7Z) r6
                    r6.A07 = r3
                    boolean r0 = com.facebook.ads.redexgen.X.C7Z.A0D(r6)
                    if (r0 != 0) goto L3c
                    r0 = 5
                    goto Lc
                L3c:
                    r0 = 8
                    goto Lc
                L3f:
                    com.facebook.ads.redexgen.X.7Z r6 = (com.facebook.ads.redexgen.X.C7Z) r6
                    r3 = 0
                    r6.A06 = r3
                    r0 = 4
                    goto Lc
                L46:
                    com.facebook.ads.redexgen.X.7D r4 = (com.facebook.ads.redexgen.X.C7D) r4
                    com.facebook.ads.redexgen.X.7Z r6 = (com.facebook.ads.redexgen.X.C7Z) r6
                    com.facebook.ads.redexgen.X.7a r2 = com.facebook.ads.redexgen.X.C01807a.this
                    android.view.View r1 = r6.A0H
                    r0 = 0
                    r2.removeDetachedView(r1, r0)
                    r0 = 8
                    goto Lc
                L55:
                    com.facebook.ads.redexgen.X.7Z r6 = (com.facebook.ads.redexgen.X.C7Z) r6
                    com.facebook.ads.redexgen.X.7Z r0 = r6.A07
                    if (r0 != 0) goto L5d
                    r0 = 3
                    goto Lc
                L5d:
                    r0 = 4
                    goto Lc
                L5f:
                    r0 = 4
                    goto Lc
                L61:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C7D.A6A(com.facebook.ads.redexgen.X.7Z):void");
            }
        };
        this.A0K = false;
        this.A14 = new int[2];
        this.A17 = new int[2];
        this.A16 = new int[2];
        this.A15 = new int[2];
        this.A0w = new ArrayList();
        this.A0k = new Runnable() { // from class: com.facebook.ads.redexgen.X.70
            @Override // java.lang.Runnable
            public final void run() {
                if (C01807a.this.A05 != null) {
                    C01807a.this.A05.A0H();
                }
                C01807a.this.A0K = false;
            }
        };
        this.A12 = new AnonymousClass72() { // from class: com.facebook.ads.redexgen.X.73
            @Override // com.facebook.ads.redexgen.X.AnonymousClass72
            public final void A7s(C7Z c7z, C7C c7c, C7C c7c2) {
                C01807a.this.A1c(c7z, c7c, c7c2);
            }

            @Override // com.facebook.ads.redexgen.X.AnonymousClass72
            public final void A7u(C7Z c7z, @NonNull C7C c7c, @Nullable C7C c7c2) {
                C01807a.this.A0r.A0c(c7z);
                C01807a.this.A1d(c7z, c7c, c7c2);
            }

            /* JADX WARN: Code restructure failed: missing block: B:32:0x0050, code lost:            return;     */
            @Override // com.facebook.ads.redexgen.X.AnonymousClass72
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final void A7w(com.facebook.ads.redexgen.X.C7Z r3, @android.support.annotation.NonNull com.facebook.ads.redexgen.X.C7C r4, @android.support.annotation.NonNull com.facebook.ads.redexgen.X.C7C r5) {
                /*
                    r2 = this;
                    r1 = r2
                    r0 = 0
                    r3.A0Z(r0)
                    com.facebook.ads.redexgen.X.7a r0 = com.facebook.ads.redexgen.X.C01807a.this
                    boolean r0 = r0.A0C
                    if (r0 == 0) goto L4e
                    r0 = 2
                Lc:
                    switch(r0) {
                        case 2: goto L10;
                        case 3: goto L26;
                        case 4: goto L50;
                        case 5: goto L2f;
                        case 6: goto L45;
                        default: goto Lf;
                    }
                Lf:
                    goto Lc
                L10:
                    com.facebook.ads.redexgen.X.73 r1 = (com.facebook.ads.redexgen.X.AnonymousClass73) r1
                    com.facebook.ads.redexgen.X.7Z r3 = (com.facebook.ads.redexgen.X.C7Z) r3
                    com.facebook.ads.redexgen.X.7C r4 = (com.facebook.ads.redexgen.X.C7C) r4
                    com.facebook.ads.redexgen.X.7C r5 = (com.facebook.ads.redexgen.X.C7C) r5
                    com.facebook.ads.redexgen.X.7a r0 = com.facebook.ads.redexgen.X.C01807a.this
                    com.facebook.ads.redexgen.X.6U r0 = r0.A05
                    boolean r0 = r0.A0F(r3, r3, r4, r5)
                    if (r0 == 0) goto L24
                    r0 = 3
                    goto Lc
                L24:
                    r0 = 4
                    goto Lc
                L26:
                    com.facebook.ads.redexgen.X.73 r1 = (com.facebook.ads.redexgen.X.AnonymousClass73) r1
                    com.facebook.ads.redexgen.X.7a r0 = com.facebook.ads.redexgen.X.C01807a.this
                    r0.A1C()
                    r0 = 4
                    goto Lc
                L2f:
                    com.facebook.ads.redexgen.X.73 r1 = (com.facebook.ads.redexgen.X.AnonymousClass73) r1
                    com.facebook.ads.redexgen.X.7Z r3 = (com.facebook.ads.redexgen.X.C7Z) r3
                    com.facebook.ads.redexgen.X.7C r4 = (com.facebook.ads.redexgen.X.C7C) r4
                    com.facebook.ads.redexgen.X.7C r5 = (com.facebook.ads.redexgen.X.C7C) r5
                    com.facebook.ads.redexgen.X.7a r0 = com.facebook.ads.redexgen.X.C01807a.this
                    com.facebook.ads.redexgen.X.6U r0 = r0.A05
                    boolean r0 = r0.A0E(r3, r4, r5)
                    if (r0 == 0) goto L43
                    r0 = 6
                    goto Lc
                L43:
                    r0 = 4
                    goto Lc
                L45:
                    com.facebook.ads.redexgen.X.73 r1 = (com.facebook.ads.redexgen.X.AnonymousClass73) r1
                    com.facebook.ads.redexgen.X.7a r0 = com.facebook.ads.redexgen.X.C01807a.this
                    r0.A1C()
                    r0 = 4
                    goto Lc
                L4e:
                    r0 = 5
                    goto Lc
                L50:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.AnonymousClass73.A7w(com.facebook.ads.redexgen.X.7Z, com.facebook.ads.redexgen.X.7C, com.facebook.ads.redexgen.X.7C):void");
            }

            @Override // com.facebook.ads.redexgen.X.AnonymousClass72
            public final void A8X(C7Z c7z) {
                C01807a.this.A06.A1D(c7z.A0H, C01807a.this.A0r);
            }
        };
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, A1G, i, 0);
            this.A0B = obtainStyledAttributes.getBoolean(0, true);
            obtainStyledAttributes.recycle();
        } else {
            this.A0B = true;
        }
        setScrollContainer(true);
        setFocusableInTouchMode(true);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.A0X = viewConfiguration.getScaledTouchSlop();
        this.A0L = C5C.A00(viewConfiguration, context);
        this.A0M = C5C.A01(viewConfiguration, context);
        this.A0y = viewConfiguration.getScaledMinimumFlingVelocity();
        this.A0x = viewConfiguration.getScaledMaximumFlingVelocity();
        setWillNotDraw(getOverScrollMode() == 2);
        this.A05.A09(this.A0f);
        A0U();
        A0E();
        if (C5B.A00(this) == 0) {
            C5B.A09(this, 1);
        }
        this.A10 = (AccessibilityManager) getContext().getSystemService(A08(949, 13, 6));
        setAccessibilityDelegateCompat(new C01827c(this));
        setDescendantFocusability(262144);
        setNestedScrollingEnabled(true);
    }

    /* JADX WARN: Code restructure failed: missing block: B:44:0x0047, code lost:            return r2;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private int A00(android.view.View r4) {
        /*
            r3 = this;
            r0 = 0
            int r2 = r4.getId()
            r0 = 2
        L6:
            switch(r0) {
                case 2: goto L3b;
                case 3: goto L12;
                case 4: goto L2f;
                case 5: goto L1c;
                case 6: goto La;
                case 7: goto L47;
                default: goto L9;
            }
        L9:
            goto L6
        La:
            android.view.View r4 = (android.view.View) r4
            int r2 = r4.getId()
            r0 = 2
            goto L6
        L12:
            android.view.View r4 = (android.view.View) r4
            boolean r0 = r4 instanceof android.view.ViewGroup
            if (r0 == 0) goto L1a
            r0 = 4
            goto L6
        L1a:
            r0 = 7
            goto L6
        L1c:
            android.view.View r4 = (android.view.View) r4
            android.view.ViewGroup r4 = (android.view.ViewGroup) r4
            android.view.View r4 = r4.getFocusedChild()
            int r1 = r4.getId()
            r0 = -1
            if (r1 == r0) goto L2d
            r0 = 6
            goto L6
        L2d:
            r0 = 2
            goto L6
        L2f:
            android.view.View r4 = (android.view.View) r4
            boolean r0 = r4.hasFocus()
            if (r0 == 0) goto L39
            r0 = 5
            goto L6
        L39:
            r0 = 7
            goto L6
        L3b:
            android.view.View r4 = (android.view.View) r4
            boolean r0 = r4.isFocused()
            if (r0 != 0) goto L45
            r0 = 3
            goto L6
        L45:
            r0 = 7
            goto L6
        L47:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C01807a.A00(android.view.View):int");
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0020, code lost:            return r1;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final long A01(com.facebook.ads.redexgen.X.C7Z r4) {
        /*
            r3 = this;
            r1 = 0
            com.facebook.ads.redexgen.X.2E r0 = r3.A04
            boolean r0 = r0.A0A()
            if (r0 == 0) goto L1e
            r0 = 2
        Lb:
            switch(r0) {
                case 2: goto Lf;
                case 3: goto L20;
                case 4: goto L17;
                default: goto Le;
            }
        Le:
            goto Lb
        Lf:
            com.facebook.ads.redexgen.X.7Z r4 = (com.facebook.ads.redexgen.X.C7Z) r4
            long r1 = r4.A0K()
            r0 = 3
            goto Lb
        L17:
            com.facebook.ads.redexgen.X.7Z r4 = (com.facebook.ads.redexgen.X.C7Z) r4
            int r0 = r4.A03
            long r1 = (long) r0
            r0 = 3
            goto Lb
        L1e:
            r0 = 4
            goto Lb
        L20:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C01807a.A01(com.facebook.ads.redexgen.X.7Z):long");
    }

    /* JADX WARN: Code restructure failed: missing block: B:85:0x0098, code lost:            return r1;     */
    @android.support.annotation.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private android.view.View A02() {
        /*
            r10 = this;
            r7 = r10
            r6 = 0
            r5 = 0
            r8 = 0
            r4 = 0
            r0 = 0
            r3 = 0
            r2 = 0
            r1 = 0
            com.facebook.ads.redexgen.X.7W r0 = r7.A0s
            int r9 = r0.A01
            r0 = -1
            if (r9 == r0) goto L92
            r0 = 2
        L11:
            switch(r0) {
                case 2: goto L4b;
                case 3: goto L38;
                case 4: goto L32;
                case 5: goto L25;
                case 6: goto L15;
                case 7: goto L1d;
                case 8: goto L53;
                case 9: goto L96;
                case 10: goto L61;
                case 11: goto L81;
                case 12: goto L47;
                case 13: goto L71;
                case 14: goto L88;
                case 15: goto L43;
                case 16: goto L8f;
                default: goto L14;
            }
        L14:
            goto L11
        L15:
            int r0 = java.lang.Math.min(r4, r8)
            int r2 = r0 + (-1)
            r0 = 7
            goto L11
        L1d:
            if (r2 < 0) goto L22
            r0 = 8
            goto L11
        L22:
            r0 = 9
            goto L11
        L25:
            com.facebook.ads.redexgen.X.7a r7 = (com.facebook.ads.redexgen.X.C01807a) r7
            com.facebook.ads.redexgen.X.7Z r6 = r7.A03(r3)
            if (r6 != 0) goto L2f
            r0 = 6
            goto L11
        L2f:
            r0 = 13
            goto L11
        L32:
            if (r3 >= r4) goto L36
            r0 = 5
            goto L11
        L36:
            r0 = 6
            goto L11
        L38:
            com.facebook.ads.redexgen.X.7a r7 = (com.facebook.ads.redexgen.X.C01807a) r7
            com.facebook.ads.redexgen.X.7W r0 = r7.A0s
            int r4 = r0.A03()
            r3 = r8
            r0 = 4
            goto L11
        L43:
            int r3 = r3 + 1
            r0 = 4
            goto L11
        L47:
            int r2 = r2 + (-1)
            r0 = 7
            goto L11
        L4b:
            com.facebook.ads.redexgen.X.7a r7 = (com.facebook.ads.redexgen.X.C01807a) r7
            com.facebook.ads.redexgen.X.7W r0 = r7.A0s
            int r8 = r0.A01
            r0 = 3
            goto L11
        L53:
            com.facebook.ads.redexgen.X.7a r7 = (com.facebook.ads.redexgen.X.C01807a) r7
            com.facebook.ads.redexgen.X.7Z r5 = r7.A03(r2)
            if (r5 != 0) goto L5e
            r0 = 9
            goto L11
        L5e:
            r0 = 10
            goto L11
        L61:
            com.facebook.ads.redexgen.X.7Z r5 = (com.facebook.ads.redexgen.X.C7Z) r5
            android.view.View r0 = r5.A0H
            boolean r0 = r0.hasFocusable()
            if (r0 == 0) goto L6e
            r0 = 11
            goto L11
        L6e:
            r0 = 12
            goto L11
        L71:
            com.facebook.ads.redexgen.X.7Z r6 = (com.facebook.ads.redexgen.X.C7Z) r6
            android.view.View r0 = r6.A0H
            boolean r0 = r0.hasFocusable()
            if (r0 == 0) goto L7e
            r0 = 14
            goto L11
        L7e:
            r0 = 15
            goto L11
        L81:
            com.facebook.ads.redexgen.X.7Z r5 = (com.facebook.ads.redexgen.X.C7Z) r5
            android.view.View r1 = r5.A0H
            r0 = 9
            goto L11
        L88:
            com.facebook.ads.redexgen.X.7Z r6 = (com.facebook.ads.redexgen.X.C7Z) r6
            android.view.View r1 = r6.A0H
            r0 = 9
            goto L11
        L8f:
            r8 = 0
            r0 = 3
            goto L11
        L92:
            r0 = 16
            goto L11
        L96:
            android.view.View r1 = (android.view.View) r1
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C01807a.A02():android.view.View");
    }

    /* JADX WARN: Code restructure failed: missing block: B:68:0x0079, code lost:            return r3;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final com.facebook.ads.redexgen.X.C7Z A03(int r8) {
        /*
            r7 = this;
            r6 = r7
            r5 = 0
            r4 = 0
            r3 = 0
            r2 = 0
            boolean r0 = r6.A0C
            if (r0 == 0) goto L75
            r0 = 2
        La:
            switch(r0) {
                case 2: goto L34;
                case 3: goto L77;
                case 4: goto L28;
                case 5: goto L21;
                case 6: goto Le;
                case 7: goto L37;
                case 8: goto L45;
                case 9: goto L55;
                case 10: goto L68;
                case 11: goto L71;
                case 12: goto L6e;
                default: goto Ld;
            }
        Ld:
            goto La
        Le:
            com.facebook.ads.redexgen.X.7a r6 = (com.facebook.ads.redexgen.X.C01807a) r6
            com.facebook.ads.redexgen.X.6J r0 = r6.A01
            android.view.View r0 = r0.A0A(r2)
            com.facebook.ads.redexgen.X.7Z r3 = A05(r0)
            if (r3 == 0) goto L1e
            r0 = 7
            goto La
        L1e:
            r0 = 11
            goto La
        L21:
            if (r2 >= r4) goto L25
            r0 = 6
            goto La
        L25:
            r0 = 12
            goto La
        L28:
            com.facebook.ads.redexgen.X.7a r6 = (com.facebook.ads.redexgen.X.C01807a) r6
            com.facebook.ads.redexgen.X.6J r0 = r6.A01
            int r4 = r0.A06()
            r5 = 0
            r2 = 0
            r0 = 5
            goto La
        L34:
            r3 = 0
            r0 = 3
            goto La
        L37:
            com.facebook.ads.redexgen.X.7Z r3 = (com.facebook.ads.redexgen.X.C7Z) r3
            boolean r0 = r3.A0c()
            if (r0 != 0) goto L42
            r0 = 8
            goto La
        L42:
            r0 = 11
            goto La
        L45:
            com.facebook.ads.redexgen.X.7a r6 = (com.facebook.ads.redexgen.X.C01807a) r6
            com.facebook.ads.redexgen.X.7Z r3 = (com.facebook.ads.redexgen.X.C7Z) r3
            int r0 = r6.A12(r3)
            if (r0 != r8) goto L52
            r0 = 9
            goto La
        L52:
            r0 = 11
            goto La
        L55:
            com.facebook.ads.redexgen.X.7a r6 = (com.facebook.ads.redexgen.X.C01807a) r6
            com.facebook.ads.redexgen.X.7Z r3 = (com.facebook.ads.redexgen.X.C7Z) r3
            com.facebook.ads.redexgen.X.6J r1 = r6.A01
            android.view.View r0 = r3.A0H
            boolean r0 = r1.A0K(r0)
            if (r0 == 0) goto L66
            r0 = 10
            goto La
        L66:
            r0 = 3
            goto La
        L68:
            com.facebook.ads.redexgen.X.7Z r3 = (com.facebook.ads.redexgen.X.C7Z) r3
            r5 = r3
            r0 = 11
            goto La
        L6e:
            r3 = r5
            r0 = 3
            goto La
        L71:
            int r2 = r2 + 1
            r0 = 5
            goto La
        L75:
            r0 = 4
            goto La
        L77:
            com.facebook.ads.redexgen.X.7Z r3 = (com.facebook.ads.redexgen.X.C7Z) r3
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C01807a.A03(int):com.facebook.ads.redexgen.X.7Z");
    }

    /* JADX WARN: Code restructure failed: missing block: B:77:0x0088, code lost:            return r6;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final com.facebook.ads.redexgen.X.C7Z A04(long r9) {
        /*
            r8 = this;
            r4 = r8
            r7 = 0
            r5 = 0
            r3 = 0
            r6 = 0
            com.facebook.ads.redexgen.X.2E r0 = r4.A04
            if (r0 == 0) goto L84
            r0 = 2
        La:
            switch(r0) {
                case 2: goto L38;
                case 3: goto L35;
                case 4: goto L86;
                case 5: goto L19;
                case 6: goto Le;
                case 7: goto L46;
                case 8: goto L5a;
                case 9: goto L25;
                case 10: goto L68;
                case 11: goto L7b;
                case 12: goto L15;
                case 13: goto L81;
                default: goto Ld;
            }
        Ld:
            goto La
        Le:
            if (r5 >= r3) goto L12
            r0 = 7
            goto La
        L12:
            r0 = 13
            goto La
        L15:
            int r5 = r5 + 1
            r0 = 6
            goto La
        L19:
            com.facebook.ads.redexgen.X.7a r4 = (com.facebook.ads.redexgen.X.C01807a) r4
            com.facebook.ads.redexgen.X.6J r0 = r4.A01
            int r3 = r0.A06()
            r7 = 0
            r5 = 0
            r0 = 6
            goto La
        L25:
            com.facebook.ads.redexgen.X.7Z r6 = (com.facebook.ads.redexgen.X.C7Z) r6
            long r1 = r6.A0K()
            int r0 = (r1 > r9 ? 1 : (r1 == r9 ? 0 : -1))
            if (r0 != 0) goto L32
            r0 = 10
            goto La
        L32:
            r0 = 12
            goto La
        L35:
            r6 = 0
            r0 = 4
            goto La
        L38:
            com.facebook.ads.redexgen.X.7a r4 = (com.facebook.ads.redexgen.X.C01807a) r4
            com.facebook.ads.redexgen.X.2E r0 = r4.A04
            boolean r0 = r0.A0A()
            if (r0 != 0) goto L44
            r0 = 3
            goto La
        L44:
            r0 = 5
            goto La
        L46:
            com.facebook.ads.redexgen.X.7a r4 = (com.facebook.ads.redexgen.X.C01807a) r4
            com.facebook.ads.redexgen.X.6J r0 = r4.A01
            android.view.View r0 = r0.A0A(r5)
            com.facebook.ads.redexgen.X.7Z r6 = A05(r0)
            if (r6 == 0) goto L57
            r0 = 8
            goto La
        L57:
            r0 = 12
            goto La
        L5a:
            com.facebook.ads.redexgen.X.7Z r6 = (com.facebook.ads.redexgen.X.C7Z) r6
            boolean r0 = r6.A0c()
            if (r0 != 0) goto L65
            r0 = 9
            goto La
        L65:
            r0 = 12
            goto La
        L68:
            com.facebook.ads.redexgen.X.7a r4 = (com.facebook.ads.redexgen.X.C01807a) r4
            com.facebook.ads.redexgen.X.7Z r6 = (com.facebook.ads.redexgen.X.C7Z) r6
            com.facebook.ads.redexgen.X.6J r1 = r4.A01
            android.view.View r0 = r6.A0H
            boolean r0 = r1.A0K(r0)
            if (r0 == 0) goto L79
            r0 = 11
            goto La
        L79:
            r0 = 4
            goto La
        L7b:
            com.facebook.ads.redexgen.X.7Z r6 = (com.facebook.ads.redexgen.X.C7Z) r6
            r7 = r6
            r0 = 12
            goto La
        L81:
            r6 = r7
            r0 = 4
            goto La
        L84:
            r0 = 3
            goto La
        L86:
            com.facebook.ads.redexgen.X.7Z r6 = (com.facebook.ads.redexgen.X.C7Z) r6
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C01807a.A04(long):com.facebook.ads.redexgen.X.7Z");
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x001b, code lost:            return r1;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.facebook.ads.redexgen.X.C7Z A05(android.view.View r2) {
        /*
            r1 = 0
            if (r2 != 0) goto L17
            r0 = 2
        L4:
            switch(r0) {
                case 2: goto L8;
                case 3: goto L19;
                case 4: goto Lb;
                default: goto L7;
            }
        L7:
            goto L4
        L8:
            r1 = 0
            r0 = 3
            goto L4
        Lb:
            android.view.View r2 = (android.view.View) r2
            android.view.ViewGroup$LayoutParams r0 = r2.getLayoutParams()
            com.facebook.ads.redexgen.X.6e r0 = (com.facebook.ads.redexgen.X.C01596e) r0
            com.facebook.ads.redexgen.X.7Z r1 = r0.A00
            r0 = 3
            goto L4
        L17:
            r0 = 4
            goto L4
        L19:
            com.facebook.ads.redexgen.X.7Z r1 = (com.facebook.ads.redexgen.X.C7Z) r1
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C01807a.A05(android.view.View):com.facebook.ads.redexgen.X.7Z");
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x001f, code lost:            return r2;     */
    @android.support.annotation.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final com.facebook.ads.redexgen.X.C7Z A06(android.view.View r5) {
        /*
            r4 = this;
            r3 = r4
            r0 = 0
            r2 = 0
            android.view.View r1 = r3.A14(r5)
            if (r1 != 0) goto L1b
            r0 = 2
        La:
            switch(r0) {
                case 2: goto Le;
                case 3: goto L1d;
                case 4: goto L11;
                default: goto Ld;
            }
        Ld:
            goto La
        Le:
            r2 = 0
            r0 = 3
            goto La
        L11:
            com.facebook.ads.redexgen.X.7a r3 = (com.facebook.ads.redexgen.X.C01807a) r3
            android.view.View r1 = (android.view.View) r1
            com.facebook.ads.redexgen.X.7Z r2 = r3.A16(r1)
            r0 = 3
            goto La
        L1b:
            r0 = 4
            goto La
        L1d:
            com.facebook.ads.redexgen.X.7Z r2 = (com.facebook.ads.redexgen.X.C7Z) r2
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C01807a.A06(android.view.View):com.facebook.ads.redexgen.X.7Z");
    }

    /* JADX WARN: Code restructure failed: missing block: B:53:0x005a, code lost:            return r4;     */
    @android.support.annotation.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.facebook.ads.redexgen.X.C01807a A07(@android.support.annotation.NonNull android.view.View r6) {
        /*
            r5 = 0
            r4 = 0
            r0 = 0
            r3 = 0
            r2 = 0
            r1 = 0
            r0 = 0
            boolean r0 = r6 instanceof android.view.ViewGroup
            if (r0 != 0) goto L56
            r0 = 2
        Lc:
            switch(r0) {
                case 2: goto L32;
                case 3: goto L58;
                case 4: goto L1c;
                case 5: goto L26;
                case 6: goto L10;
                case 7: goto L39;
                case 8: goto L41;
                case 9: goto L2d;
                case 10: goto L35;
                case 11: goto L53;
                default: goto Lf;
            }
        Lf:
            goto Lc
        L10:
            android.view.View r6 = (android.view.View) r6
            r1 = r6
            android.view.ViewGroup r1 = (android.view.ViewGroup) r1
            int r2 = r1.getChildCount()
            r3 = 0
            r0 = 7
            goto Lc
        L1c:
            android.view.View r6 = (android.view.View) r6
            boolean r0 = r6 instanceof com.facebook.ads.redexgen.X.C01807a
            if (r0 == 0) goto L24
            r0 = 5
            goto Lc
        L24:
            r0 = 6
            goto Lc
        L26:
            android.view.View r6 = (android.view.View) r6
            r4 = r6
            com.facebook.ads.redexgen.X.7a r4 = (com.facebook.ads.redexgen.X.C01807a) r4
            r0 = 3
            goto Lc
        L2d:
            com.facebook.ads.redexgen.X.7a r5 = (com.facebook.ads.redexgen.X.C01807a) r5
            r4 = r5
            r0 = 3
            goto Lc
        L32:
            r4 = 0
            r0 = 3
            goto Lc
        L35:
            int r3 = r3 + 1
            r0 = 7
            goto Lc
        L39:
            if (r3 >= r2) goto L3e
            r0 = 8
            goto Lc
        L3e:
            r0 = 11
            goto Lc
        L41:
            android.view.ViewGroup r1 = (android.view.ViewGroup) r1
            android.view.View r0 = r1.getChildAt(r3)
            com.facebook.ads.redexgen.X.7a r5 = A07(r0)
            if (r5 == 0) goto L50
            r0 = 9
            goto Lc
        L50:
            r0 = 10
            goto Lc
        L53:
            r4 = 0
            r0 = 3
            goto Lc
        L56:
            r0 = 4
            goto Lc
        L58:
            com.facebook.ads.redexgen.X.7a r4 = (com.facebook.ads.redexgen.X.C01807a) r4
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C01807a.A07(android.view.View):com.facebook.ads.redexgen.X.7a");
    }

    private void A09() {
        A0J();
        setScrollState(0);
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x002f, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void A0A() {
        /*
            r4 = this;
            r3 = r4
            r0 = 0
            int r2 = r3.A0P
            r0 = 0
            r3.A0P = r0
            if (r2 == 0) goto L2d
            r0 = 2
        La:
            switch(r0) {
                case 2: goto Le;
                case 3: goto L1a;
                case 4: goto L2f;
                default: goto Ld;
            }
        Ld:
            goto La
        Le:
            com.facebook.ads.redexgen.X.7a r3 = (com.facebook.ads.redexgen.X.C01807a) r3
            boolean r0 = r3.A1h()
            if (r0 == 0) goto L18
            r0 = 3
            goto La
        L18:
            r0 = 4
            goto La
        L1a:
            com.facebook.ads.redexgen.X.7a r3 = (com.facebook.ads.redexgen.X.C01807a) r3
            android.view.accessibility.AccessibilityEvent r1 = android.view.accessibility.AccessibilityEvent.obtain()
            r0 = 2048(0x800, float:2.87E-42)
            r1.setEventType(r0)
            com.facebook.ads.redexgen.X.C01335c.A01(r1, r2)
            r3.sendAccessibilityEventUnchecked(r1)
            r0 = 4
            goto La
        L2d:
            r0 = 4
            goto La
        L2f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C01807a.A0A():void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:196:0x021c, code lost:            r10 = r10;        r10.A1B();        r10.A1g(false);        r10.A0s.A04 = 2;     */
    /* JADX WARN: Code restructure failed: missing block: B:197:0x022a, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void A0B() {
        /*
            Method dump skipped, instructions count: 620
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C01807a.A0B():void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x0057, code lost:            r4 = r4;        r1.A0C = r5;        r4.A0s.A04 = 4;        r4.A1B();        r4.A1g(false);     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0068, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void A0C() {
        /*
            r6 = this;
            r4 = r6
            r5 = 0
            r0 = 0
            r0 = 0
            r3 = 0
            r4.A19()
            r4.A1A()
            com.facebook.ads.redexgen.X.7W r1 = r4.A0s
            r0 = 6
            r1.A04(r0)
            com.facebook.ads.redexgen.X.6G r0 = r4.A00
            r0.A0G()
            com.facebook.ads.redexgen.X.7W r1 = r4.A0s
            com.facebook.ads.redexgen.X.2E r0 = r4.A04
            int r0 = r0.A0C()
            r1.A03 = r0
            com.facebook.ads.redexgen.X.7W r0 = r4.A0s
            r0.A00 = r3
            com.facebook.ads.redexgen.X.7W r0 = r4.A0s
            r0.A09 = r3
            com.facebook.ads.redexgen.X.6g r2 = r4.A06
            com.facebook.ads.redexgen.X.7O r1 = r4.A0r
            com.facebook.ads.redexgen.X.7W r0 = r4.A0s
            r2.A1y(r1, r0)
            com.facebook.ads.redexgen.X.7W r0 = r4.A0s
            r0.A0D = r3
            r0 = 0
            r4.A0j = r0
            com.facebook.ads.redexgen.X.7W r1 = r4.A0s
            com.facebook.ads.redexgen.X.7W r0 = r4.A0s
            boolean r0 = r0.A0C
            if (r0 == 0) goto L55
            r0 = 2
        L41:
            switch(r0) {
                case 2: goto L45;
                case 3: goto L4f;
                case 4: goto L57;
                case 5: goto L52;
                default: goto L44;
            }
        L44:
            goto L41
        L45:
            com.facebook.ads.redexgen.X.7a r4 = (com.facebook.ads.redexgen.X.C01807a) r4
            com.facebook.ads.redexgen.X.6U r0 = r4.A05
            if (r0 == 0) goto L4d
            r0 = 3
            goto L41
        L4d:
            r0 = 5
            goto L41
        L4f:
            r5 = 1
            r0 = 4
            goto L41
        L52:
            r5 = r3
            r0 = 4
            goto L41
        L55:
            r0 = 5
            goto L41
        L57:
            com.facebook.ads.redexgen.X.7a r4 = (com.facebook.ads.redexgen.X.C01807a) r4
            com.facebook.ads.redexgen.X.7W r1 = (com.facebook.ads.redexgen.X.C7W) r1
            r1.A0C = r5
            com.facebook.ads.redexgen.X.7W r1 = r4.A0s
            r0 = 4
            r1.A04 = r0
            r4.A1B()
            r4.A1g(r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C01807a.A0C():void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:127:0x01ac, code lost:            r8 = r8;        r8.A0G();        r8.A0I();     */
    /* JADX WARN: Code restructure failed: missing block: B:128:0x01b4, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void A0D() {
        /*
            Method dump skipped, instructions count: 484
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C01807a.A0D():void");
    }

    private void A0E() {
        this.A01 = new C6J(new C6I() { // from class: com.facebook.ads.redexgen.X.74
            public static byte[] A01;

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
                    byte[] r1 = com.facebook.ads.redexgen.X.AnonymousClass74.A01
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
                    r0 = r0 ^ 103(0x67, float:1.44E-43)
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
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.AnonymousClass74.A00(int, int, int):java.lang.String");
            }

            public static void A01() {
                A01 = new byte[]{62, 28, 17, 17, 24, 25, 93, 28, 9, 9, 28, 30, 21, 93, 18, 19, 93, 28, 93, 30, 21, 20, 17, 25, 93, 10, 21, 20, 30, 21, 93, 20, 14, 93, 19, 18, 9, 93, 25, 24, 9, 28, 30, 21, 24, 25, 71, 93, 68, 70, 75, 75, 66, 67, 7, 67, 66, 83, 70, 68, 79, 7, 72, 73, 7, 70, 73, 7, 70, 75, 85, 66, 70, 67, 94, 7, 67, 66, 83, 70, 68, 79, 66, 67, 7, 68, 79, 78, 75, 67, 7};
            }

            /* JADX WARN: Failed to find 'out' block for switch in B:5:0x0008. Please report as an issue. */
            @Override // com.facebook.ads.redexgen.X.C6I
            public final void A3E(View view, int i, ViewGroup.LayoutParams layoutParams) {
                C7Z A05 = C01807a.A05(view);
                char c = A05 != null ? (char) 2 : (char) 6;
                while (true) {
                    switch (c) {
                        case 2:
                            A05 = A05;
                            c = !A05.A0e() ? (char) 3 : (char) 5;
                        case 3:
                            A05 = A05;
                            c = !A05.A0h() ? (char) 4 : (char) 5;
                        case 4:
                            throw new IllegalArgumentException(A00(0, 48, 26) + A05 + C01807a.this.A17());
                        case 5:
                            A05 = A05;
                            A05.A0P();
                            c = 6;
                        case 6:
                            C01807a.this.attachViewToParent(view, i, layoutParams);
                            return;
                    }
                }
            }

            /* JADX WARN: Failed to find 'out' block for switch in B:5:0x0009. Please report as an issue. */
            @Override // com.facebook.ads.redexgen.X.C6I
            public final void A3y(int i) {
                C7Z c7z = null;
                View A4P = A4P(i);
                char c = A4P != null ? (char) 2 : (char) 7;
                while (true) {
                    switch (c) {
                        case 2:
                            A4P = A4P;
                            c7z = C01807a.A05(A4P);
                            c = c7z != null ? (char) 3 : (char) 7;
                        case 3:
                            c7z = c7z;
                            c = c7z.A0e() ? (char) 4 : (char) 6;
                        case 4:
                            c7z = c7z;
                            c = !c7z.A0h() ? (char) 5 : (char) 6;
                        case 5:
                            throw new IllegalArgumentException(A00(48, 43, 64) + c7z + C01807a.this.A17());
                        case 6:
                            c7z = c7z;
                            c7z.A0T(256);
                            c = 7;
                        case 7:
                            C01807a.this.detachViewFromParent(i);
                            return;
                    }
                }
            }

            @Override // com.facebook.ads.redexgen.X.C6I
            public final View A4P(int i) {
                return C01807a.this.getChildAt(i);
            }

            @Override // com.facebook.ads.redexgen.X.C6I
            public final int A4Q() {
                return C01807a.this.getChildCount();
            }

            @Override // com.facebook.ads.redexgen.X.C6I
            public final C7Z A4T(View view) {
                return C01807a.A05(view);
            }

            @Override // com.facebook.ads.redexgen.X.C6I
            public final int A58(View view) {
                return C01807a.this.indexOfChild(view);
            }

            @Override // com.facebook.ads.redexgen.X.C6I
            public final void A6X(View view) {
                C7Z A05 = C01807a.A05(view);
                if (A05 == null) {
                    return;
                }
                A05.A07(C01807a.this);
            }

            @Override // com.facebook.ads.redexgen.X.C6I
            public final void A70(View view) {
                C7Z A05 = C01807a.A05(view);
                if (A05 == null) {
                    return;
                }
                A05.A08(C01807a.this);
            }

            /* JADX WARN: Code restructure failed: missing block: B:16:0x0025, code lost:            r4.A00.removeAllViews();     */
            /* JADX WARN: Code restructure failed: missing block: B:17:0x002c, code lost:            return;     */
            @Override // com.facebook.ads.redexgen.X.C6I
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final void A86() {
                /*
                    r5 = this;
                    r4 = r5
                    r0 = 0
                    r0 = 0
                    int r3 = r4.A4Q()
                    r2 = 0
                    r0 = 2
                L9:
                    switch(r0) {
                        case 2: goto Ld;
                        case 3: goto L13;
                        case 4: goto L25;
                        default: goto Lc;
                    }
                Lc:
                    goto L9
                Ld:
                    if (r2 >= r3) goto L11
                    r0 = 3
                    goto L9
                L11:
                    r0 = 4
                    goto L9
                L13:
                    com.facebook.ads.redexgen.X.74 r4 = (com.facebook.ads.redexgen.X.AnonymousClass74) r4
                    android.view.View r1 = r4.A4P(r2)
                    com.facebook.ads.redexgen.X.7a r0 = com.facebook.ads.redexgen.X.C01807a.this
                    r0.A1X(r1)
                    r1.clearAnimation()
                    int r2 = r2 + 1
                    r0 = 2
                    goto L9
                L25:
                    com.facebook.ads.redexgen.X.74 r4 = (com.facebook.ads.redexgen.X.AnonymousClass74) r4
                    com.facebook.ads.redexgen.X.7a r0 = com.facebook.ads.redexgen.X.C01807a.this
                    r0.removeAllViews()
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.AnonymousClass74.A86():void");
            }

            @Override // com.facebook.ads.redexgen.X.C6I
            public final void A87(int i) {
                View childAt = C01807a.this.getChildAt(i);
                if (childAt != null) {
                    C01807a.this.A1X(childAt);
                    childAt.clearAnimation();
                }
                C01807a.this.removeViewAt(i);
            }

            @Override // com.facebook.ads.redexgen.X.C6I
            public final void addView(View view, int i) {
                C01807a.this.addView(view, i);
                C01807a.this.A1W(view);
            }
        });
    }

    /* JADX WARN: Code restructure failed: missing block: B:156:0x010b, code lost:            r5.A0B = r2;     */
    /* JADX WARN: Code restructure failed: missing block: B:157:0x010f, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void A0F() {
        /*
            Method dump skipped, instructions count: 322
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C01807a.A0F():void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:214:0x018f, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void A0G() {
        /*
            Method dump skipped, instructions count: 460
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C01807a.A0G():void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:58:0x007e, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void A0H() {
        /*
            r3 = this;
            r1 = r3
            r0 = 0
            r2 = 0
            android.widget.EdgeEffect r0 = r1.A0a
            if (r0 == 0) goto L7c
            r0 = 2
        L8:
            switch(r0) {
                case 2: goto L51;
                case 3: goto L47;
                case 4: goto L37;
                case 5: goto L2d;
                case 6: goto L1d;
                case 7: goto L60;
                case 8: goto Lc;
                case 9: goto L6c;
                case 10: goto L74;
                case 11: goto L7e;
                default: goto Lb;
            }
        Lb:
            goto L8
        Lc:
            com.facebook.ads.redexgen.X.7a r1 = (com.facebook.ads.redexgen.X.C01807a) r1
            android.widget.EdgeEffect r0 = r1.A0Z
            r0.onRelease()
            android.widget.EdgeEffect r0 = r1.A0Z
            boolean r0 = r0.isFinished()
            r2 = r2 | r0
            r0 = 9
            goto L8
        L1d:
            com.facebook.ads.redexgen.X.7a r1 = (com.facebook.ads.redexgen.X.C01807a) r1
            android.widget.EdgeEffect r0 = r1.A0b
            r0.onRelease()
            android.widget.EdgeEffect r0 = r1.A0b
            boolean r0 = r0.isFinished()
            r2 = r2 | r0
            r0 = 7
            goto L8
        L2d:
            com.facebook.ads.redexgen.X.7a r1 = (com.facebook.ads.redexgen.X.C01807a) r1
            android.widget.EdgeEffect r0 = r1.A0b
            if (r0 == 0) goto L35
            r0 = 6
            goto L8
        L35:
            r0 = 7
            goto L8
        L37:
            com.facebook.ads.redexgen.X.7a r1 = (com.facebook.ads.redexgen.X.C01807a) r1
            android.widget.EdgeEffect r0 = r1.A0c
            r0.onRelease()
            android.widget.EdgeEffect r0 = r1.A0c
            boolean r0 = r0.isFinished()
            r2 = r2 | r0
            r0 = 5
            goto L8
        L47:
            com.facebook.ads.redexgen.X.7a r1 = (com.facebook.ads.redexgen.X.C01807a) r1
            android.widget.EdgeEffect r0 = r1.A0c
            if (r0 == 0) goto L4f
            r0 = 4
            goto L8
        L4f:
            r0 = 5
            goto L8
        L51:
            com.facebook.ads.redexgen.X.7a r1 = (com.facebook.ads.redexgen.X.C01807a) r1
            android.widget.EdgeEffect r0 = r1.A0a
            r0.onRelease()
            android.widget.EdgeEffect r0 = r1.A0a
            boolean r2 = r0.isFinished()
            r0 = 3
            goto L8
        L60:
            com.facebook.ads.redexgen.X.7a r1 = (com.facebook.ads.redexgen.X.C01807a) r1
            android.widget.EdgeEffect r0 = r1.A0Z
            if (r0 == 0) goto L69
            r0 = 8
            goto L8
        L69:
            r0 = 9
            goto L8
        L6c:
            if (r2 == 0) goto L71
            r0 = 10
            goto L8
        L71:
            r0 = 11
            goto L8
        L74:
            com.facebook.ads.redexgen.X.7a r1 = (com.facebook.ads.redexgen.X.C01807a) r1
            com.facebook.ads.redexgen.X.C5B.A07(r1)
            r0 = 11
            goto L8
        L7c:
            r0 = 3
            goto L8
        L7e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C01807a.A0H():void");
    }

    private void A0I() {
        this.A0s.A08 = -1L;
        this.A0s.A01 = -1;
        this.A0s.A02 = -1;
    }

    private void A0J() {
        if (this.A0Y != null) {
            this.A0Y.clear();
        }
        A1M(0);
        A0H();
    }

    /* JADX WARN: Code restructure failed: missing block: B:99:0x00bb, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void A0K() {
        /*
            Method dump skipped, instructions count: 228
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C01807a.A0K():void");
    }

    private void A0L() {
        this.A08.A08();
        if (this.A06 != null) {
            this.A06.A0x();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x0037, code lost:            r4.A0r.A0K();     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x003e, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void A0N() {
        /*
            r5 = this;
            r4 = r5
            r3 = 0
            r0 = 0
            r0 = 0
            com.facebook.ads.redexgen.X.6J r0 = r4.A01
            int r2 = r0.A06()
            r1 = 0
            r0 = 2
        Lc:
            switch(r0) {
                case 2: goto L10;
                case 3: goto L16;
                case 4: goto L2c;
                case 5: goto L33;
                case 6: goto L37;
                default: goto Lf;
            }
        Lf:
            goto Lc
        L10:
            if (r1 >= r2) goto L14
            r0 = 3
            goto Lc
        L14:
            r0 = 6
            goto Lc
        L16:
            com.facebook.ads.redexgen.X.7a r4 = (com.facebook.ads.redexgen.X.C01807a) r4
            com.facebook.ads.redexgen.X.6J r0 = r4.A01
            android.view.View r0 = r0.A0A(r1)
            com.facebook.ads.redexgen.X.7Z r3 = A05(r0)
            boolean r0 = r3.A0h()
            if (r0 != 0) goto L2a
            r0 = 4
            goto Lc
        L2a:
            r0 = 5
            goto Lc
        L2c:
            com.facebook.ads.redexgen.X.7Z r3 = (com.facebook.ads.redexgen.X.C7Z) r3
            r3.A0M()
            r0 = 5
            goto Lc
        L33:
            int r1 = r1 + 1
            r0 = 2
            goto Lc
        L37:
            com.facebook.ads.redexgen.X.7a r4 = (com.facebook.ads.redexgen.X.C01807a) r4
            com.facebook.ads.redexgen.X.7O r0 = r4.A0r
            r0.A0K()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C01807a.A0N():void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:71:0x00c8, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void A0O() {
        /*
            r5 = this;
            r2 = r5
            com.facebook.ads.redexgen.X.2E r0 = r2.A04
            if (r0 != 0) goto Lc5
            r0 = 2
        L6:
            switch(r0) {
                case 2: goto L1d;
                case 3: goto Lc8;
                case 4: goto L62;
                case 5: goto L36;
                case 6: goto La;
                case 7: goto L6c;
                case 8: goto L9d;
                case 9: goto La5;
                case 10: goto L7c;
                case 11: goto L4e;
                case 12: goto Lb7;
                case 13: goto L92;
                default: goto L9;
            }
        L9:
            goto L6
        La:
            com.facebook.ads.redexgen.X.7a r2 = (com.facebook.ads.redexgen.X.C01807a) r2
            com.facebook.ads.redexgen.X.7W r1 = r2.A0s
            r0 = 0
            r1.A0A = r0
            com.facebook.ads.redexgen.X.7W r0 = r2.A0s
            int r1 = r0.A04
            r0 = 1
            if (r1 != r0) goto L1a
            r0 = 7
            goto L6
        L1a:
            r0 = 9
            goto L6
        L1d:
            r3 = 1788(0x6fc, float:2.506E-42)
            r1 = 12
            r0 = 70
            java.lang.String r4 = A08(r3, r1, r0)
            r3 = 818(0x332, float:1.146E-42)
            r1 = 36
            r0 = 98
            java.lang.String r0 = A08(r3, r1, r0)
            android.util.Log.e(r4, r0)
            r0 = 3
            goto L6
        L36:
            r3 = 1788(0x6fc, float:2.506E-42)
            r1 = 12
            r0 = 70
            java.lang.String r4 = A08(r3, r1, r0)
            r3 = 1
            r1 = 43
            r0 = 58
            java.lang.String r0 = A08(r3, r1, r0)
            android.util.Log.e(r4, r0)
            r0 = 3
            goto L6
        L4e:
            com.facebook.ads.redexgen.X.7a r2 = (com.facebook.ads.redexgen.X.C01807a) r2
            com.facebook.ads.redexgen.X.6g r0 = r2.A06
            int r1 = r0.A0X()
            int r0 = r2.getHeight()
            if (r1 == r0) goto L5f
            r0 = 12
            goto L6
        L5f:
            r0 = 13
            goto L6
        L62:
            com.facebook.ads.redexgen.X.7a r2 = (com.facebook.ads.redexgen.X.C01807a) r2
            com.facebook.ads.redexgen.X.6g r0 = r2.A06
            if (r0 != 0) goto L6a
            r0 = 5
            goto L6
        L6a:
            r0 = 6
            goto L6
        L6c:
            com.facebook.ads.redexgen.X.7a r2 = (com.facebook.ads.redexgen.X.C01807a) r2
            r2.A0B()
            com.facebook.ads.redexgen.X.6g r0 = r2.A06
            r0.A1O(r2)
            r2.A0C()
            r0 = 8
            goto L6
        L7c:
            com.facebook.ads.redexgen.X.7a r2 = (com.facebook.ads.redexgen.X.C01807a) r2
            com.facebook.ads.redexgen.X.6g r0 = r2.A06
            int r1 = r0.A0h()
            int r0 = r2.getWidth()
            if (r1 != r0) goto L8e
            r0 = 11
            goto L6
        L8e:
            r0 = 12
            goto L6
        L92:
            com.facebook.ads.redexgen.X.7a r2 = (com.facebook.ads.redexgen.X.C01807a) r2
            com.facebook.ads.redexgen.X.6g r0 = r2.A06
            r0.A1O(r2)
            r0 = 8
            goto L6
        L9d:
            com.facebook.ads.redexgen.X.7a r2 = (com.facebook.ads.redexgen.X.C01807a) r2
            r2.A0D()
            r0 = 3
            goto L6
        La5:
            com.facebook.ads.redexgen.X.7a r2 = (com.facebook.ads.redexgen.X.C01807a) r2
            com.facebook.ads.redexgen.X.6G r0 = r2.A00
            boolean r0 = r0.A0K()
            if (r0 != 0) goto Lb3
            r0 = 10
            goto L6
        Lb3:
            r0 = 12
            goto L6
        Lb7:
            com.facebook.ads.redexgen.X.7a r2 = (com.facebook.ads.redexgen.X.C01807a) r2
            com.facebook.ads.redexgen.X.6g r0 = r2.A06
            r0.A1O(r2)
            r2.A0C()
            r0 = 8
            goto L6
        Lc5:
            r0 = 4
            goto L6
        Lc8:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C01807a.A0O():void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:46:0x0055, code lost:            r5.A0w.clear();     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x005c, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void A0P() {
        /*
            r6 = this;
            r5 = r6
            r0 = 0
            r4 = 0
            r0 = 0
            r3 = 0
            r2 = -1
            java.util.List<com.facebook.ads.redexgen.X.7Z> r0 = r5.A0w
            int r0 = r0.size()
            int r1 = r0 + (-1)
            r0 = 2
        Lf:
            switch(r0) {
                case 2: goto L43;
                case 3: goto L2d;
                case 4: goto L21;
                case 5: goto L1d;
                case 6: goto L13;
                case 7: goto L4a;
                case 8: goto L55;
                default: goto L12;
            }
        L12:
            goto Lf
        L13:
            com.facebook.ads.redexgen.X.7Z r3 = (com.facebook.ads.redexgen.X.C7Z) r3
            int r4 = r3.A02
            if (r4 == r2) goto L1b
            r0 = 7
            goto Lf
        L1b:
            r0 = 5
            goto Lf
        L1d:
            int r1 = r1 + (-1)
            r0 = 2
            goto Lf
        L21:
            com.facebook.ads.redexgen.X.7Z r3 = (com.facebook.ads.redexgen.X.C7Z) r3
            boolean r0 = r3.A0h()
            if (r0 == 0) goto L2b
            r0 = 5
            goto Lf
        L2b:
            r0 = 6
            goto Lf
        L2d:
            com.facebook.ads.redexgen.X.7a r5 = (com.facebook.ads.redexgen.X.C01807a) r5
            java.util.List<com.facebook.ads.redexgen.X.7Z> r0 = r5.A0w
            java.lang.Object r3 = r0.get(r1)
            com.facebook.ads.redexgen.X.7Z r3 = (com.facebook.ads.redexgen.X.C7Z) r3
            android.view.View r0 = r3.A0H
            android.view.ViewParent r0 = r0.getParent()
            if (r0 != r5) goto L41
            r0 = 4
            goto Lf
        L41:
            r0 = 5
            goto Lf
        L43:
            if (r1 < 0) goto L47
            r0 = 3
            goto Lf
        L47:
            r0 = 8
            goto Lf
        L4a:
            com.facebook.ads.redexgen.X.7Z r3 = (com.facebook.ads.redexgen.X.C7Z) r3
            android.view.View r0 = r3.A0H
            com.facebook.ads.redexgen.X.C5B.A09(r0, r4)
            r3.A02 = r2
            r0 = 5
            goto Lf
        L55:
            com.facebook.ads.redexgen.X.7a r5 = (com.facebook.ads.redexgen.X.C01807a) r5
            java.util.List<com.facebook.ads.redexgen.X.7Z> r0 = r5.A0w
            r0.clear()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C01807a.A0P():void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x0057, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void A0Q() {
        /*
            r5 = this;
            r4 = r5
            android.widget.EdgeEffect r0 = r4.A0Z
            if (r0 == 0) goto L55
            r0 = 2
        L6:
            switch(r0) {
                case 2: goto L57;
                case 3: goto La;
                case 4: goto L1f;
                case 5: goto L44;
                default: goto L9;
            }
        L9:
            goto L6
        La:
            com.facebook.ads.redexgen.X.7a r4 = (com.facebook.ads.redexgen.X.C01807a) r4
            android.widget.EdgeEffect r1 = new android.widget.EdgeEffect
            android.content.Context r0 = r4.getContext()
            r1.<init>(r0)
            r4.A0Z = r1
            boolean r0 = r4.A0B
            if (r0 == 0) goto L1d
            r0 = 4
            goto L6
        L1d:
            r0 = 5
            goto L6
        L1f:
            com.facebook.ads.redexgen.X.7a r4 = (com.facebook.ads.redexgen.X.C01807a) r4
            android.widget.EdgeEffect r3 = r4.A0Z
            int r2 = r4.getMeasuredWidth()
            int r0 = r4.getPaddingLeft()
            int r2 = r2 - r0
            int r0 = r4.getPaddingRight()
            int r2 = r2 - r0
            int r1 = r4.getMeasuredHeight()
            int r0 = r4.getPaddingTop()
            int r1 = r1 - r0
            int r0 = r4.getPaddingBottom()
            int r1 = r1 - r0
            r3.setSize(r2, r1)
            r0 = 2
            goto L6
        L44:
            com.facebook.ads.redexgen.X.7a r4 = (com.facebook.ads.redexgen.X.C01807a) r4
            android.widget.EdgeEffect r2 = r4.A0Z
            int r1 = r4.getMeasuredWidth()
            int r0 = r4.getMeasuredHeight()
            r2.setSize(r1, r0)
            r0 = 2
            goto L6
        L55:
            r0 = 3
            goto L6
        L57:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C01807a.A0Q():void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x0057, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void A0R() {
        /*
            r5 = this;
            r4 = r5
            android.widget.EdgeEffect r0 = r4.A0a
            if (r0 == 0) goto L55
            r0 = 2
        L6:
            switch(r0) {
                case 2: goto L57;
                case 3: goto La;
                case 4: goto L1f;
                case 5: goto L44;
                default: goto L9;
            }
        L9:
            goto L6
        La:
            com.facebook.ads.redexgen.X.7a r4 = (com.facebook.ads.redexgen.X.C01807a) r4
            android.widget.EdgeEffect r1 = new android.widget.EdgeEffect
            android.content.Context r0 = r4.getContext()
            r1.<init>(r0)
            r4.A0a = r1
            boolean r0 = r4.A0B
            if (r0 == 0) goto L1d
            r0 = 4
            goto L6
        L1d:
            r0 = 5
            goto L6
        L1f:
            com.facebook.ads.redexgen.X.7a r4 = (com.facebook.ads.redexgen.X.C01807a) r4
            android.widget.EdgeEffect r3 = r4.A0a
            int r2 = r4.getMeasuredHeight()
            int r0 = r4.getPaddingTop()
            int r2 = r2 - r0
            int r0 = r4.getPaddingBottom()
            int r2 = r2 - r0
            int r1 = r4.getMeasuredWidth()
            int r0 = r4.getPaddingLeft()
            int r1 = r1 - r0
            int r0 = r4.getPaddingRight()
            int r1 = r1 - r0
            r3.setSize(r2, r1)
            r0 = 2
            goto L6
        L44:
            com.facebook.ads.redexgen.X.7a r4 = (com.facebook.ads.redexgen.X.C01807a) r4
            android.widget.EdgeEffect r2 = r4.A0a
            int r1 = r4.getMeasuredHeight()
            int r0 = r4.getMeasuredWidth()
            r2.setSize(r1, r0)
            r0 = 2
            goto L6
        L55:
            r0 = 3
            goto L6
        L57:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C01807a.A0R():void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x0057, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void A0S() {
        /*
            r5 = this;
            r4 = r5
            android.widget.EdgeEffect r0 = r4.A0b
            if (r0 == 0) goto L55
            r0 = 2
        L6:
            switch(r0) {
                case 2: goto L57;
                case 3: goto La;
                case 4: goto L1f;
                case 5: goto L44;
                default: goto L9;
            }
        L9:
            goto L6
        La:
            com.facebook.ads.redexgen.X.7a r4 = (com.facebook.ads.redexgen.X.C01807a) r4
            android.widget.EdgeEffect r1 = new android.widget.EdgeEffect
            android.content.Context r0 = r4.getContext()
            r1.<init>(r0)
            r4.A0b = r1
            boolean r0 = r4.A0B
            if (r0 == 0) goto L1d
            r0 = 4
            goto L6
        L1d:
            r0 = 5
            goto L6
        L1f:
            com.facebook.ads.redexgen.X.7a r4 = (com.facebook.ads.redexgen.X.C01807a) r4
            android.widget.EdgeEffect r3 = r4.A0b
            int r2 = r4.getMeasuredHeight()
            int r0 = r4.getPaddingTop()
            int r2 = r2 - r0
            int r0 = r4.getPaddingBottom()
            int r2 = r2 - r0
            int r1 = r4.getMeasuredWidth()
            int r0 = r4.getPaddingLeft()
            int r1 = r1 - r0
            int r0 = r4.getPaddingRight()
            int r1 = r1 - r0
            r3.setSize(r2, r1)
            r0 = 2
            goto L6
        L44:
            com.facebook.ads.redexgen.X.7a r4 = (com.facebook.ads.redexgen.X.C01807a) r4
            android.widget.EdgeEffect r2 = r4.A0b
            int r1 = r4.getMeasuredHeight()
            int r0 = r4.getMeasuredWidth()
            r2.setSize(r1, r0)
            r0 = 2
            goto L6
        L55:
            r0 = 3
            goto L6
        L57:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C01807a.A0S():void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x0057, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void A0T() {
        /*
            r5 = this;
            r4 = r5
            android.widget.EdgeEffect r0 = r4.A0c
            if (r0 == 0) goto L55
            r0 = 2
        L6:
            switch(r0) {
                case 2: goto L57;
                case 3: goto La;
                case 4: goto L1f;
                case 5: goto L44;
                default: goto L9;
            }
        L9:
            goto L6
        La:
            com.facebook.ads.redexgen.X.7a r4 = (com.facebook.ads.redexgen.X.C01807a) r4
            android.widget.EdgeEffect r1 = new android.widget.EdgeEffect
            android.content.Context r0 = r4.getContext()
            r1.<init>(r0)
            r4.A0c = r1
            boolean r0 = r4.A0B
            if (r0 == 0) goto L1d
            r0 = 4
            goto L6
        L1d:
            r0 = 5
            goto L6
        L1f:
            com.facebook.ads.redexgen.X.7a r4 = (com.facebook.ads.redexgen.X.C01807a) r4
            android.widget.EdgeEffect r3 = r4.A0c
            int r2 = r4.getMeasuredWidth()
            int r0 = r4.getPaddingLeft()
            int r2 = r2 - r0
            int r0 = r4.getPaddingRight()
            int r2 = r2 - r0
            int r1 = r4.getMeasuredHeight()
            int r0 = r4.getPaddingTop()
            int r1 = r1 - r0
            int r0 = r4.getPaddingBottom()
            int r1 = r1 - r0
            r3.setSize(r2, r1)
            r0 = 2
            goto L6
        L44:
            com.facebook.ads.redexgen.X.7a r4 = (com.facebook.ads.redexgen.X.C01807a) r4
            android.widget.EdgeEffect r2 = r4.A0c
            int r1 = r4.getMeasuredWidth()
            int r0 = r4.getMeasuredHeight()
            r2.setSize(r1, r0)
            r0 = 2
            goto L6
        L55:
            r0 = 3
            goto L6
        L57:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C01807a.A0T():void");
    }

    private final void A0U() {
        this.A00 = new C6G(new C6D() { // from class: com.facebook.ads.redexgen.X.75
            /* JADX WARN: Code restructure failed: missing block: B:20:0x006a, code lost:            return;     */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            private final void A00(com.facebook.ads.redexgen.X.C6E r7) {
                /*
                    r6 = this;
                    r5 = r6
                    int r0 = r7.A00
                    switch(r0) {
                        case 1: goto L60;
                        case 2: goto L5e;
                        case 3: goto L68;
                        case 4: goto L5c;
                        case 5: goto L66;
                        case 6: goto L64;
                        case 7: goto L62;
                        case 8: goto L5a;
                        default: goto L6;
                    }
                L6:
                    r0 = 2
                L7:
                    switch(r0) {
                        case 2: goto L6a;
                        case 3: goto Lb;
                        case 4: goto L32;
                        case 5: goto L45;
                        case 6: goto L1e;
                        default: goto La;
                    }
                La:
                    goto L7
                Lb:
                    com.facebook.ads.redexgen.X.75 r5 = (com.facebook.ads.redexgen.X.AnonymousClass75) r5
                    com.facebook.ads.redexgen.X.6E r7 = (com.facebook.ads.redexgen.X.C6E) r7
                    com.facebook.ads.redexgen.X.7a r0 = com.facebook.ads.redexgen.X.C01807a.this
                    com.facebook.ads.redexgen.X.6g r3 = r0.A06
                    com.facebook.ads.redexgen.X.7a r2 = com.facebook.ads.redexgen.X.C01807a.this
                    int r1 = r7.A02
                    int r0 = r7.A01
                    r3.A1Q(r2, r1, r0)
                    r0 = 2
                    goto L7
                L1e:
                    com.facebook.ads.redexgen.X.75 r5 = (com.facebook.ads.redexgen.X.AnonymousClass75) r5
                    com.facebook.ads.redexgen.X.6E r7 = (com.facebook.ads.redexgen.X.C6E) r7
                    com.facebook.ads.redexgen.X.7a r0 = com.facebook.ads.redexgen.X.C01807a.this
                    com.facebook.ads.redexgen.X.6g r4 = r0.A06
                    com.facebook.ads.redexgen.X.7a r3 = com.facebook.ads.redexgen.X.C01807a.this
                    int r2 = r7.A02
                    int r1 = r7.A01
                    r0 = 1
                    r4.A1S(r3, r2, r1, r0)
                    r0 = 2
                    goto L7
                L32:
                    com.facebook.ads.redexgen.X.75 r5 = (com.facebook.ads.redexgen.X.AnonymousClass75) r5
                    com.facebook.ads.redexgen.X.6E r7 = (com.facebook.ads.redexgen.X.C6E) r7
                    com.facebook.ads.redexgen.X.7a r0 = com.facebook.ads.redexgen.X.C01807a.this
                    com.facebook.ads.redexgen.X.6g r3 = r0.A06
                    com.facebook.ads.redexgen.X.7a r2 = com.facebook.ads.redexgen.X.C01807a.this
                    int r1 = r7.A02
                    int r0 = r7.A01
                    r3.A1R(r2, r1, r0)
                    r0 = 2
                    goto L7
                L45:
                    com.facebook.ads.redexgen.X.75 r5 = (com.facebook.ads.redexgen.X.AnonymousClass75) r5
                    com.facebook.ads.redexgen.X.6E r7 = (com.facebook.ads.redexgen.X.C6E) r7
                    com.facebook.ads.redexgen.X.7a r0 = com.facebook.ads.redexgen.X.C01807a.this
                    com.facebook.ads.redexgen.X.6g r4 = r0.A06
                    com.facebook.ads.redexgen.X.7a r3 = com.facebook.ads.redexgen.X.C01807a.this
                    int r2 = r7.A02
                    int r1 = r7.A01
                    java.lang.Object r0 = r7.A03
                    r4.A1T(r3, r2, r1, r0)
                    r0 = 2
                    goto L7
                L5a:
                    r0 = 6
                    goto L7
                L5c:
                    r0 = 5
                    goto L7
                L5e:
                    r0 = 4
                    goto L7
                L60:
                    r0 = 3
                    goto L7
                L62:
                    r0 = 2
                    goto L7
                L64:
                    r0 = 2
                    goto L7
                L66:
                    r0 = 2
                    goto L7
                L68:
                    r0 = 2
                    goto L7
                L6a:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.AnonymousClass75.A00(com.facebook.ads.redexgen.X.6E):void");
            }

            /* JADX WARN: Code restructure failed: missing block: B:24:0x0030, code lost:            return r2;     */
            @Override // com.facebook.ads.redexgen.X.C6D
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final com.facebook.ads.redexgen.X.C7Z A49(int r5) {
                /*
                    r4 = this;
                    r3 = r4
                    r0 = 0
                    r0 = 0
                    r0 = 0
                    com.facebook.ads.redexgen.X.7a r1 = com.facebook.ads.redexgen.X.C01807a.this
                    r0 = 1
                    com.facebook.ads.redexgen.X.7Z r2 = r1.A15(r5, r0)
                    if (r2 != 0) goto L2c
                    r0 = 2
                Le:
                    switch(r0) {
                        case 2: goto L12;
                        case 3: goto L2e;
                        case 4: goto L18;
                        case 5: goto L15;
                        default: goto L11;
                    }
                L11:
                    goto Le
                L12:
                    r2 = 0
                    r0 = 3
                    goto Le
                L15:
                    r2 = 0
                    r0 = 3
                    goto Le
                L18:
                    com.facebook.ads.redexgen.X.75 r3 = (com.facebook.ads.redexgen.X.AnonymousClass75) r3
                    com.facebook.ads.redexgen.X.7Z r2 = (com.facebook.ads.redexgen.X.C7Z) r2
                    com.facebook.ads.redexgen.X.7a r0 = com.facebook.ads.redexgen.X.C01807a.this
                    com.facebook.ads.redexgen.X.6J r1 = r0.A01
                    android.view.View r0 = r2.A0H
                    boolean r0 = r1.A0K(r0)
                    if (r0 == 0) goto L2a
                    r0 = 5
                    goto Le
                L2a:
                    r0 = 3
                    goto Le
                L2c:
                    r0 = 4
                    goto Le
                L2e:
                    com.facebook.ads.redexgen.X.7Z r2 = (com.facebook.ads.redexgen.X.C7Z) r2
                    return r2
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.AnonymousClass75.A49(int):com.facebook.ads.redexgen.X.7Z");
            }

            @Override // com.facebook.ads.redexgen.X.C6D
            public final void A5w(int i, int i2, Object obj) {
                C01807a.this.A1U(i, i2, obj);
                C01807a.this.A0H = true;
            }

            @Override // com.facebook.ads.redexgen.X.C6D
            public final void A61(int i, int i2) {
                C01807a.this.A1R(i, i2);
                C01807a.this.A0G = true;
            }

            @Override // com.facebook.ads.redexgen.X.C6D
            public final void A62(int i, int i2) {
                C01807a.this.A1S(i, i2);
                C01807a.this.A0G = true;
            }

            @Override // com.facebook.ads.redexgen.X.C6D
            public final void A63(int i, int i2) {
                C01807a.this.A1V(i, i2, true);
                C01807a.this.A0G = true;
                C01807a.this.A0s.A00 += i2;
            }

            @Override // com.facebook.ads.redexgen.X.C6D
            public final void A64(int i, int i2) {
                C01807a.this.A1V(i, i2, false);
                C01807a.this.A0G = true;
            }

            @Override // com.facebook.ads.redexgen.X.C6D
            public final void A6T(C6E c6e) {
                A00(c6e);
            }

            @Override // com.facebook.ads.redexgen.X.C6D
            public final void A6V(C6E c6e) {
                A00(c6e);
            }
        });
    }

    private final void A0V() {
        this.A0Z = null;
        this.A0c = null;
        this.A0b = null;
        this.A0a = null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x002a, code lost:            r4.A0r.A0M();     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0031, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void A0W() {
        /*
            r5 = this;
            r4 = r5
            r0 = 0
            r0 = 0
            com.facebook.ads.redexgen.X.6J r0 = r4.A01
            int r3 = r0.A06()
            r2 = 0
            r0 = 2
        Lb:
            switch(r0) {
                case 2: goto Lf;
                case 3: goto L15;
                case 4: goto L2a;
                default: goto Le;
            }
        Le:
            goto Lb
        Lf:
            if (r2 >= r3) goto L13
            r0 = 3
            goto Lb
        L13:
            r0 = 4
            goto Lb
        L15:
            com.facebook.ads.redexgen.X.7a r4 = (com.facebook.ads.redexgen.X.C01807a) r4
            com.facebook.ads.redexgen.X.6J r0 = r4.A01
            android.view.View r0 = r0.A0A(r2)
            android.view.ViewGroup$LayoutParams r1 = r0.getLayoutParams()
            com.facebook.ads.redexgen.X.6e r1 = (com.facebook.ads.redexgen.X.C01596e) r1
            r0 = 1
            r1.A01 = r0
            int r2 = r2 + 1
            r0 = 2
            goto Lb
        L2a:
            com.facebook.ads.redexgen.X.7a r4 = (com.facebook.ads.redexgen.X.C01807a) r4
            com.facebook.ads.redexgen.X.7O r0 = r4.A0r
            r0.A0M()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C01807a.A0W():void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:37:0x0040, code lost:            r4 = r4;        r4.A0W();        r4.A0r.A0N();     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x004a, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void A0X() {
        /*
            r5 = this;
            r4 = r5
            r3 = 0
            r0 = 0
            r0 = 0
            com.facebook.ads.redexgen.X.6J r0 = r4.A01
            int r2 = r0.A06()
            r1 = 0
            r0 = 2
        Lc:
            switch(r0) {
                case 2: goto L28;
                case 3: goto L2e;
                case 4: goto L1c;
                case 5: goto L14;
                case 6: goto L10;
                case 7: goto L40;
                default: goto Lf;
            }
        Lf:
            goto Lc
        L10:
            int r1 = r1 + 1
            r0 = 2
            goto Lc
        L14:
            com.facebook.ads.redexgen.X.7Z r3 = (com.facebook.ads.redexgen.X.C7Z) r3
            r0 = 6
            r3.A0T(r0)
            r0 = 6
            goto Lc
        L1c:
            com.facebook.ads.redexgen.X.7Z r3 = (com.facebook.ads.redexgen.X.C7Z) r3
            boolean r0 = r3.A0h()
            if (r0 != 0) goto L26
            r0 = 5
            goto Lc
        L26:
            r0 = 6
            goto Lc
        L28:
            if (r1 >= r2) goto L2c
            r0 = 3
            goto Lc
        L2c:
            r0 = 7
            goto Lc
        L2e:
            com.facebook.ads.redexgen.X.7a r4 = (com.facebook.ads.redexgen.X.C01807a) r4
            com.facebook.ads.redexgen.X.6J r0 = r4.A01
            android.view.View r0 = r0.A0A(r1)
            com.facebook.ads.redexgen.X.7Z r3 = A05(r0)
            if (r3 == 0) goto L3e
            r0 = 4
            goto Lc
        L3e:
            r0 = 6
            goto Lc
        L40:
            com.facebook.ads.redexgen.X.7a r4 = (com.facebook.ads.redexgen.X.C01807a) r4
            r4.A0W()
            com.facebook.ads.redexgen.X.7O r0 = r4.A0r
            r0.A0N()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C01807a.A0X():void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x0037, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void A0Y() {
        /*
            r5 = this;
            r4 = r5
            r3 = 0
            r0 = 0
            r0 = 0
            com.facebook.ads.redexgen.X.6J r0 = r4.A01
            int r2 = r0.A06()
            r1 = 0
            r0 = 2
        Lc:
            switch(r0) {
                case 2: goto L10;
                case 3: goto L16;
                case 4: goto L2c;
                case 5: goto L33;
                case 6: goto L37;
                default: goto Lf;
            }
        Lf:
            goto Lc
        L10:
            if (r1 >= r2) goto L14
            r0 = 3
            goto Lc
        L14:
            r0 = 6
            goto Lc
        L16:
            com.facebook.ads.redexgen.X.7a r4 = (com.facebook.ads.redexgen.X.C01807a) r4
            com.facebook.ads.redexgen.X.6J r0 = r4.A01
            android.view.View r0 = r0.A0A(r1)
            com.facebook.ads.redexgen.X.7Z r3 = A05(r0)
            boolean r0 = r3.A0h()
            if (r0 != 0) goto L2a
            r0 = 4
            goto Lc
        L2a:
            r0 = 5
            goto Lc
        L2c:
            com.facebook.ads.redexgen.X.7Z r3 = (com.facebook.ads.redexgen.X.C7Z) r3
            r3.A0R()
            r0 = 5
            goto Lc
        L33:
            int r1 = r1 + 1
            r0 = 2
            goto Lc
        L37:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C01807a.A0Y():void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:76:0x00c8, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void A0Z(float r7, float r8, float r9, float r10) {
        /*
            Method dump skipped, instructions count: 230
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C01807a.A0Z(float, float, float, float):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:43:0x004f, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void A0a(int r4) {
        /*
            r3 = this;
            r2 = r3
            r1 = 0
            com.facebook.ads.redexgen.X.6g r0 = r2.A06
            if (r0 == 0) goto L4d
            r0 = 2
        L7:
            switch(r0) {
                case 2: goto L32;
                case 3: goto L29;
                case 4: goto L1e;
                case 5: goto L12;
                case 6: goto Lb;
                case 7: goto L3c;
                case 8: goto L4f;
                default: goto La;
            }
        La:
            goto L7
        Lb:
            if (r1 < 0) goto Lf
            r0 = 7
            goto L7
        Lf:
            r0 = 8
            goto L7
        L12:
            com.facebook.ads.redexgen.X.7a r2 = (com.facebook.ads.redexgen.X.C01807a) r2
            java.util.List<com.facebook.ads.redexgen.X.7L> r0 = r2.A0m
            int r0 = r0.size()
            int r1 = r0 + (-1)
            r0 = 6
            goto L7
        L1e:
            com.facebook.ads.redexgen.X.7a r2 = (com.facebook.ads.redexgen.X.C01807a) r2
            java.util.List<com.facebook.ads.redexgen.X.7L> r0 = r2.A0m
            if (r0 == 0) goto L26
            r0 = 5
            goto L7
        L26:
            r0 = 8
            goto L7
        L29:
            com.facebook.ads.redexgen.X.7a r2 = (com.facebook.ads.redexgen.X.C01807a) r2
            com.facebook.ads.redexgen.X.7L r0 = r2.A0i
            r0.A0U(r2, r4)
            r0 = 4
            goto L7
        L32:
            com.facebook.ads.redexgen.X.7a r2 = (com.facebook.ads.redexgen.X.C01807a) r2
            com.facebook.ads.redexgen.X.7L r0 = r2.A0i
            if (r0 == 0) goto L3a
            r0 = 3
            goto L7
        L3a:
            r0 = 4
            goto L7
        L3c:
            com.facebook.ads.redexgen.X.7a r2 = (com.facebook.ads.redexgen.X.C01807a) r2
            java.util.List<com.facebook.ads.redexgen.X.7L> r0 = r2.A0m
            java.lang.Object r0 = r0.get(r1)
            com.facebook.ads.redexgen.X.7L r0 = (com.facebook.ads.redexgen.X.C7L) r0
            r0.A0U(r2, r4)
            int r1 = r1 + (-1)
            r0 = 6
            goto L7
        L4d:
            r0 = 2
            goto L7
        L4f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C01807a.A0a(int):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:63:0x006e, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void A0b(int r6, int r7, android.view.animation.Interpolator r8) {
        /*
            r5 = this;
            r4 = r5
            com.facebook.ads.redexgen.X.6g r0 = r4.A06
            if (r0 != 0) goto L6c
            r0 = 2
        L6:
            switch(r0) {
                case 2: goto L2d;
                case 3: goto L6e;
                case 4: goto L1b;
                case 5: goto Ld;
                case 6: goto La;
                case 7: goto L46;
                case 8: goto L56;
                case 9: goto L25;
                case 10: goto L5a;
                case 11: goto L61;
                default: goto L9;
            }
        L9:
            goto L6
        La:
            r6 = 0
            r0 = 7
            goto L6
        Ld:
            com.facebook.ads.redexgen.X.7a r4 = (com.facebook.ads.redexgen.X.C01807a) r4
            com.facebook.ads.redexgen.X.6g r0 = r4.A06
            boolean r0 = r0.A24()
            if (r0 != 0) goto L19
            r0 = 6
            goto L6
        L19:
            r0 = 7
            goto L6
        L1b:
            com.facebook.ads.redexgen.X.7a r4 = (com.facebook.ads.redexgen.X.C01807a) r4
            boolean r0 = r4.A0I
            if (r0 != 0) goto L23
            r0 = 5
            goto L6
        L23:
            r0 = 3
            goto L6
        L25:
            if (r6 != 0) goto L2a
            r0 = 10
            goto L6
        L2a:
            r0 = 11
            goto L6
        L2d:
            r2 = 1788(0x6fc, float:2.506E-42)
            r1 = 12
            r0 = 70
            java.lang.String r3 = A08(r2, r1, r0)
            r2 = 1404(0x57c, float:1.967E-42)
            r1 = 97
            r0 = 109(0x6d, float:1.53E-43)
            java.lang.String r0 = A08(r2, r1, r0)
            android.util.Log.e(r3, r0)
            r0 = 3
            goto L6
        L46:
            com.facebook.ads.redexgen.X.7a r4 = (com.facebook.ads.redexgen.X.C01807a) r4
            com.facebook.ads.redexgen.X.6g r0 = r4.A06
            boolean r0 = r0.A25()
            if (r0 != 0) goto L53
            r0 = 8
            goto L6
        L53:
            r0 = 9
            goto L6
        L56:
            r7 = 0
            r0 = 9
            goto L6
        L5a:
            if (r7 == 0) goto L5f
            r0 = 11
            goto L6
        L5f:
            r0 = 3
            goto L6
        L61:
            com.facebook.ads.redexgen.X.7a r4 = (com.facebook.ads.redexgen.X.C01807a) r4
            android.view.animation.Interpolator r8 = (android.view.animation.Interpolator) r8
            com.facebook.ads.redexgen.X.7Y r0 = r4.A08
            r0.A0D(r6, r7, r8)
            r0 = 3
            goto L6
        L6c:
            r0 = 4
            goto L6
        L6e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C01807a.A0b(int, int, android.view.animation.Interpolator):void");
    }

    private void A0c(long j, C7Z c7z, C7Z c7z2) {
        C01807a c01807a = this;
        C7Z c7z3 = null;
        int A05 = c01807a.A01.A05();
        int i = 0;
        char c = 2;
        while (true) {
            switch (c) {
                case 2:
                    if (i >= A05) {
                        c = '\n';
                        break;
                    } else {
                        c = 3;
                        break;
                    }
                case 3:
                    c01807a = c01807a;
                    c7z = c7z;
                    c7z3 = A05(c01807a.A01.A09(i));
                    if (c7z3 != c7z) {
                        c = 5;
                        break;
                    } else {
                        c = 4;
                        break;
                    }
                case 4:
                    i++;
                    c = 2;
                    break;
                case 5:
                    c01807a = c01807a;
                    c7z3 = c7z3;
                    if (c01807a.A01(c7z3) != j) {
                        c = 4;
                        break;
                    } else {
                        c = 6;
                        break;
                    }
                case 6:
                    c01807a = c01807a;
                    if (c01807a.A04 == null) {
                        c = '\t';
                        break;
                    } else {
                        c = 7;
                        break;
                    }
                case 7:
                    c01807a = c01807a;
                    if (!c01807a.A04.A0A()) {
                        c = '\t';
                        break;
                    } else {
                        c = '\b';
                        break;
                    }
                case '\b':
                    throw new IllegalStateException(A08(1274, 130, 47) + c7z3 + A08(1738, 17, 52) + c7z + c01807a.A17());
                case '\t':
                    throw new IllegalStateException(A08(962, 188, 23) + c7z3 + A08(1738, 17, 52) + c7z + c01807a.A17());
                case '\n':
                    Log.e(A08(1788, 12, 70), A08(1817, 111, 44) + c7z2 + A08(237, 41, 81) + c7z + c01807a.A17());
                    return;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x0045, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void A0d(android.view.MotionEvent r7) {
        /*
            r6 = this;
            r5 = r6
            r4 = 0
            r0 = 0
            r0 = 0
            r3 = 1056964608(0x3f000000, float:0.5)
            int r2 = r7.getActionIndex()
            int r1 = r7.getPointerId(r2)
            int r0 = r5.A0V
            if (r1 != r0) goto L43
            r0 = 2
        L13:
            switch(r0) {
                case 2: goto L17;
                case 3: goto L1d;
                case 4: goto L20;
                case 5: goto L45;
                case 6: goto L40;
                default: goto L16;
            }
        L16:
            goto L13
        L17:
            if (r2 != 0) goto L1b
            r0 = 3
            goto L13
        L1b:
            r0 = 6
            goto L13
        L1d:
            r4 = 1
            r0 = 4
            goto L13
        L20:
            com.facebook.ads.redexgen.X.7a r5 = (com.facebook.ads.redexgen.X.C01807a) r5
            android.view.MotionEvent r7 = (android.view.MotionEvent) r7
            int r0 = r7.getPointerId(r4)
            r5.A0V = r0
            float r0 = r7.getX(r4)
            float r0 = r0 + r3
            int r0 = (int) r0
            r5.A0S = r0
            r5.A0Q = r0
            float r0 = r7.getY(r4)
            float r0 = r0 + r3
            int r0 = (int) r0
            r5.A0T = r0
            r5.A0R = r0
            r0 = 5
            goto L13
        L40:
            r4 = 0
            r0 = 4
            goto L13
        L43:
            r0 = 5
            goto L13
        L45:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C01807a.A0d(android.view.MotionEvent):void");
    }

    public static void A0e(View view, Rect rect) {
        C01596e c01596e = (C01596e) view.getLayoutParams();
        Rect rect2 = c01596e.A03;
        rect.set((view.getLeft() - rect2.left) - c01596e.leftMargin, (view.getTop() - rect2.top) - c01596e.topMargin, view.getRight() + rect2.right + c01596e.rightMargin, view.getBottom() + rect2.bottom + c01596e.bottomMargin);
    }

    /* JADX WARN: Code restructure failed: missing block: B:74:0x00c3, code lost:            r9.A1e(r10, r11, r12, r13, r14);     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x00ce, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void A0f(@android.support.annotation.NonNull android.view.View r16, @android.support.annotation.Nullable android.view.View r17) {
        /*
            Method dump skipped, instructions count: 238
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C01807a.A0f(android.view.View, android.view.View):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:51:0x0057, code lost:            r3 = r3;        r3.A0r.A0Y(r2, r3.A04, r6);        r3.A0s.A0D = true;        r3.A1F();     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x006a, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void A0g(com.facebook.ads.redexgen.X.C2E r5, boolean r6, boolean r7) {
        /*
            r4 = this;
            r3 = r4
            r2 = 0
            com.facebook.ads.redexgen.X.2E r0 = r3.A04
            if (r0 == 0) goto L55
            r0 = 2
        L7:
            switch(r0) {
                case 2: goto L32;
                case 3: goto L26;
                case 4: goto L2c;
                case 5: goto L1f;
                case 6: goto Lb;
                case 7: goto L3d;
                case 8: goto L49;
                case 9: goto L57;
                default: goto La;
            }
        La:
            goto L7
        Lb:
            com.facebook.ads.redexgen.X.7a r3 = (com.facebook.ads.redexgen.X.C01807a) r3
            com.facebook.ads.redexgen.X.2E r5 = (com.facebook.ads.redexgen.X.C2E) r5
            com.facebook.ads.redexgen.X.6G r0 = r3.A00
            r0.A0I()
            com.facebook.ads.redexgen.X.2E r2 = r3.A04
            r3.A04 = r5
            if (r5 == 0) goto L1c
            r0 = 7
            goto L7
        L1c:
            r0 = 8
            goto L7
        L1f:
            com.facebook.ads.redexgen.X.7a r3 = (com.facebook.ads.redexgen.X.C01807a) r3
            r3.A1D()
            r0 = 6
            goto L7
        L26:
            if (r6 == 0) goto L2a
            r0 = 4
            goto L7
        L2a:
            r0 = 5
            goto L7
        L2c:
            if (r7 == 0) goto L30
            r0 = 5
            goto L7
        L30:
            r0 = 6
            goto L7
        L32:
            com.facebook.ads.redexgen.X.7a r3 = (com.facebook.ads.redexgen.X.C01807a) r3
            com.facebook.ads.redexgen.X.2E r1 = r3.A04
            com.facebook.ads.redexgen.X.7Q r0 = r3.A11
            r1.A08(r0)
            r0 = 3
            goto L7
        L3d:
            com.facebook.ads.redexgen.X.7a r3 = (com.facebook.ads.redexgen.X.C01807a) r3
            com.facebook.ads.redexgen.X.2E r5 = (com.facebook.ads.redexgen.X.C2E) r5
            com.facebook.ads.redexgen.X.7Q r0 = r3.A11
            r5.A07(r0)
            r0 = 8
            goto L7
        L49:
            com.facebook.ads.redexgen.X.7a r3 = (com.facebook.ads.redexgen.X.C01807a) r3
            com.facebook.ads.redexgen.X.6g r0 = r3.A06
            if (r0 == 0) goto L52
            r0 = 9
            goto L7
        L52:
            r0 = 9
            goto L7
        L55:
            r0 = 3
            goto L7
        L57:
            com.facebook.ads.redexgen.X.7a r3 = (com.facebook.ads.redexgen.X.C01807a) r3
            com.facebook.ads.redexgen.X.2E r2 = (com.facebook.ads.redexgen.X.C2E) r2
            com.facebook.ads.redexgen.X.7O r1 = r3.A0r
            com.facebook.ads.redexgen.X.2E r0 = r3.A04
            r1.A0Y(r2, r0, r6)
            com.facebook.ads.redexgen.X.7W r1 = r3.A0s
            r0 = 1
            r1.A0D = r0
            r3.A1F()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C01807a.A0g(com.facebook.ads.redexgen.X.2E, boolean, boolean):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:40:0x0061, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void A0h(com.facebook.ads.redexgen.X.C7Z r8) {
        /*
            r7 = this;
            r5 = r7
            r6 = 0
            r0 = 0
            r0 = 0
            r4 = 1
            android.view.View r3 = r8.A0H
            android.view.ViewParent r0 = r3.getParent()
            if (r0 != r5) goto L5e
            r0 = 2
        Le:
            switch(r0) {
                case 2: goto L4d;
                case 3: goto L34;
                case 4: goto L24;
                case 5: goto L61;
                case 6: goto L12;
                case 7: goto L19;
                case 8: goto L50;
                case 9: goto L5b;
                default: goto L11;
            }
        L11:
            goto Le
        L12:
            if (r6 != 0) goto L16
            r0 = 7
            goto Le
        L16:
            r0 = 8
            goto Le
        L19:
            com.facebook.ads.redexgen.X.7a r5 = (com.facebook.ads.redexgen.X.C01807a) r5
            android.view.View r3 = (android.view.View) r3
            com.facebook.ads.redexgen.X.6J r0 = r5.A01
            r0.A0J(r3, r4)
            r0 = 5
            goto Le
        L24:
            com.facebook.ads.redexgen.X.7a r5 = (com.facebook.ads.redexgen.X.C01807a) r5
            android.view.View r3 = (android.view.View) r3
            com.facebook.ads.redexgen.X.6J r2 = r5.A01
            r1 = -1
            android.view.ViewGroup$LayoutParams r0 = r3.getLayoutParams()
            r2.A0H(r3, r1, r0, r4)
            r0 = 5
            goto Le
        L34:
            com.facebook.ads.redexgen.X.7a r5 = (com.facebook.ads.redexgen.X.C01807a) r5
            com.facebook.ads.redexgen.X.7Z r8 = (com.facebook.ads.redexgen.X.C7Z) r8
            android.view.View r3 = (android.view.View) r3
            com.facebook.ads.redexgen.X.7O r1 = r5.A0r
            com.facebook.ads.redexgen.X.7Z r0 = r5.A16(r3)
            r1.A0c(r0)
            boolean r0 = r8.A0e()
            if (r0 == 0) goto L4b
            r0 = 4
            goto Le
        L4b:
            r0 = 6
            goto Le
        L4d:
            r6 = r4
            r0 = 3
            goto Le
        L50:
            com.facebook.ads.redexgen.X.7a r5 = (com.facebook.ads.redexgen.X.C01807a) r5
            android.view.View r3 = (android.view.View) r3
            com.facebook.ads.redexgen.X.6J r0 = r5.A01
            r0.A0E(r3)
            r0 = 5
            goto Le
        L5b:
            r6 = 0
            r0 = 3
            goto Le
        L5e:
            r0 = 9
            goto Le
        L61:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C01807a.A0h(com.facebook.ads.redexgen.X.7Z):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:46:0x0048, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void A0i(@android.support.annotation.NonNull com.facebook.ads.redexgen.X.C7Z r3) {
        /*
            r2 = 0
            r1 = 0
            java.lang.ref.WeakReference<com.facebook.ads.redexgen.X.7a> r0 = r3.A09
            if (r0 == 0) goto L46
            r0 = 2
        L7:
            switch(r0) {
                case 2: goto L29;
                case 3: goto L22;
                case 4: goto L18;
                case 5: goto L48;
                case 6: goto Lb;
                case 7: goto L35;
                case 8: goto L3c;
                case 9: goto L3f;
                default: goto La;
            }
        La:
            goto L7
        Lb:
            android.view.ViewParent r2 = r1.getParent()
            boolean r0 = r2 instanceof android.view.View
            if (r0 == 0) goto L15
            r0 = 7
            goto L7
        L15:
            r0 = 8
            goto L7
        L18:
            com.facebook.ads.redexgen.X.7Z r3 = (com.facebook.ads.redexgen.X.C7Z) r3
            android.view.View r0 = r3.A0H
            if (r1 != r0) goto L20
            r0 = 5
            goto L7
        L20:
            r0 = 6
            goto L7
        L22:
            if (r1 == 0) goto L26
            r0 = 4
            goto L7
        L26:
            r0 = 9
            goto L7
        L29:
            com.facebook.ads.redexgen.X.7Z r3 = (com.facebook.ads.redexgen.X.C7Z) r3
            java.lang.ref.WeakReference<com.facebook.ads.redexgen.X.7a> r0 = r3.A09
            java.lang.Object r1 = r0.get()
            android.view.View r1 = (android.view.View) r1
            r0 = 3
            goto L7
        L35:
            android.view.ViewParent r2 = (android.view.ViewParent) r2
            r1 = r2
            android.view.View r1 = (android.view.View) r1
            r0 = 3
            goto L7
        L3c:
            r1 = 0
            r0 = 3
            goto L7
        L3f:
            com.facebook.ads.redexgen.X.7Z r3 = (com.facebook.ads.redexgen.X.C7Z) r3
            r0 = 0
            r3.A09 = r0
            r0 = 5
            goto L7
        L46:
            r0 = 5
            goto L7
        L48:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C01807a.A0i(com.facebook.ads.redexgen.X.7Z):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:46:0x0068, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void A0j(@android.support.annotation.NonNull com.facebook.ads.redexgen.X.C7Z r4, @android.support.annotation.NonNull com.facebook.ads.redexgen.X.C7Z r5, @android.support.annotation.NonNull com.facebook.ads.redexgen.X.C7C r6, @android.support.annotation.NonNull com.facebook.ads.redexgen.X.C7C r7, boolean r8, boolean r9) {
        /*
            r3 = this;
            r2 = r3
            r0 = 0
            r1 = 0
            r4.A0Z(r1)
            if (r8 == 0) goto L66
            r0 = 2
        L9:
            switch(r0) {
                case 2: goto L3b;
                case 3: goto L44;
                case 4: goto L35;
                case 5: goto L2c;
                case 6: goto Ld;
                case 7: goto L4e;
                case 8: goto L24;
                case 9: goto L68;
                default: goto Lc;
            }
        Lc:
            goto L9
        Ld:
            com.facebook.ads.redexgen.X.7a r2 = (com.facebook.ads.redexgen.X.C01807a) r2
            com.facebook.ads.redexgen.X.7Z r4 = (com.facebook.ads.redexgen.X.C7Z) r4
            com.facebook.ads.redexgen.X.7Z r5 = (com.facebook.ads.redexgen.X.C7Z) r5
            r4.A06 = r5
            r2.A0h(r4)
            com.facebook.ads.redexgen.X.7O r0 = r2.A0r
            r0.A0c(r4)
            r5.A0Z(r1)
            r5.A07 = r4
            r0 = 7
            goto L9
        L24:
            com.facebook.ads.redexgen.X.7a r2 = (com.facebook.ads.redexgen.X.C01807a) r2
            r2.A1C()
            r0 = 9
            goto L9
        L2c:
            com.facebook.ads.redexgen.X.7a r2 = (com.facebook.ads.redexgen.X.C01807a) r2
            com.facebook.ads.redexgen.X.7Z r5 = (com.facebook.ads.redexgen.X.C7Z) r5
            r2.A0h(r5)
            r0 = 6
            goto L9
        L35:
            if (r9 == 0) goto L39
            r0 = 5
            goto L9
        L39:
            r0 = 6
            goto L9
        L3b:
            com.facebook.ads.redexgen.X.7a r2 = (com.facebook.ads.redexgen.X.C01807a) r2
            com.facebook.ads.redexgen.X.7Z r4 = (com.facebook.ads.redexgen.X.C7Z) r4
            r2.A0h(r4)
            r0 = 3
            goto L9
        L44:
            com.facebook.ads.redexgen.X.7Z r4 = (com.facebook.ads.redexgen.X.C7Z) r4
            com.facebook.ads.redexgen.X.7Z r5 = (com.facebook.ads.redexgen.X.C7Z) r5
            if (r4 == r5) goto L4c
            r0 = 4
            goto L9
        L4c:
            r0 = 7
            goto L9
        L4e:
            com.facebook.ads.redexgen.X.7a r2 = (com.facebook.ads.redexgen.X.C01807a) r2
            com.facebook.ads.redexgen.X.7Z r4 = (com.facebook.ads.redexgen.X.C7Z) r4
            com.facebook.ads.redexgen.X.7Z r5 = (com.facebook.ads.redexgen.X.C7Z) r5
            com.facebook.ads.redexgen.X.7C r6 = (com.facebook.ads.redexgen.X.C7C) r6
            com.facebook.ads.redexgen.X.7C r7 = (com.facebook.ads.redexgen.X.C7C) r7
            com.facebook.ads.redexgen.X.6U r0 = r2.A05
            boolean r0 = r0.A0F(r4, r5, r6, r7)
            if (r0 == 0) goto L63
            r0 = 8
            goto L9
        L63:
            r0 = 9
            goto L9
        L66:
            r0 = 3
            goto L9
        L68:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C01807a.A0j(com.facebook.ads.redexgen.X.7Z, com.facebook.ads.redexgen.X.7Z, com.facebook.ads.redexgen.X.7C, com.facebook.ads.redexgen.X.7C, boolean, boolean):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:60:0x0074, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void A0n(int[] r11) {
        /*
            r10 = this;
            r7 = r10
            r6 = 0
            r5 = 0
            r9 = 0
            r4 = 0
            r0 = 0
            r3 = 0
            r0 = 0
            r0 = 0
            r0 = 0
            r8 = 1
            r0 = 0
            r2 = -1
            com.facebook.ads.redexgen.X.6J r0 = r7.A01
            int r1 = r0.A05()
            if (r1 != 0) goto L72
            r0 = 2
        L16:
            switch(r0) {
                case 2: goto L40;
                case 3: goto L74;
                case 4: goto L38;
                case 5: goto L31;
                case 6: goto L1a;
                case 7: goto L49;
                case 8: goto L4d;
                case 9: goto L5b;
                case 10: goto L68;
                case 11: goto L6f;
                case 12: goto L5f;
                default: goto L19;
            }
        L19:
            goto L16
        L1a:
            com.facebook.ads.redexgen.X.7a r7 = (com.facebook.ads.redexgen.X.C01807a) r7
            com.facebook.ads.redexgen.X.6J r0 = r7.A01
            android.view.View r0 = r0.A09(r3)
            com.facebook.ads.redexgen.X.7Z r9 = A05(r0)
            boolean r0 = r9.A0h()
            if (r0 == 0) goto L2e
            r0 = 7
            goto L16
        L2e:
            r0 = 8
            goto L16
        L31:
            if (r3 >= r1) goto L35
            r0 = 6
            goto L16
        L35:
            r0 = 12
            goto L16
        L38:
            r4 = 2147483647(0x7fffffff, float:NaN)
            r6 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = 0
            r0 = 5
            goto L16
        L40:
            int[] r11 = (int[]) r11
            r0 = 0
            r11[r0] = r2
            r11[r8] = r2
            r0 = 3
            goto L16
        L49:
            int r3 = r3 + 1
            r0 = 5
            goto L16
        L4d:
            com.facebook.ads.redexgen.X.7Z r9 = (com.facebook.ads.redexgen.X.C7Z) r9
            int r5 = r9.A0I()
            if (r5 >= r4) goto L58
            r0 = 9
            goto L16
        L58:
            r0 = 10
            goto L16
        L5b:
            r4 = r5
            r0 = 10
            goto L16
        L5f:
            int[] r11 = (int[]) r11
            r0 = 0
            r11[r0] = r4
            r11[r8] = r6
            r0 = 3
            goto L16
        L68:
            if (r5 <= r6) goto L6d
            r0 = 11
            goto L16
        L6d:
            r0 = 7
            goto L16
        L6f:
            r6 = r5
            r0 = 7
            goto L16
        L72:
            r0 = 4
            goto L16
        L74:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C01807a.A0n(int[]):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:49:0x004e, code lost:            return r3;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean A0o() {
        /*
            r6 = this;
            r5 = r6
            r4 = 0
            r3 = 0
            r0 = 0
            r0 = 0
            com.facebook.ads.redexgen.X.6J r0 = r5.A01
            int r2 = r0.A05()
            r1 = 0
            r0 = 2
        Ld:
            switch(r0) {
                case 2: goto L3b;
                case 3: goto L19;
                case 4: goto L2b;
                case 5: goto L11;
                case 6: goto L15;
                case 7: goto L41;
                case 8: goto L37;
                case 9: goto L4e;
                default: goto L10;
            }
        L10:
            goto Ld
        L11:
            int r1 = r1 + 1
            r0 = 2
            goto Ld
        L15:
            r3 = 0
            r0 = 9
            goto Ld
        L19:
            com.facebook.ads.redexgen.X.7a r5 = (com.facebook.ads.redexgen.X.C01807a) r5
            com.facebook.ads.redexgen.X.6J r0 = r5.A01
            android.view.View r0 = r0.A09(r1)
            com.facebook.ads.redexgen.X.7Z r4 = A05(r0)
            if (r4 == 0) goto L29
            r0 = 4
            goto Ld
        L29:
            r0 = 5
            goto Ld
        L2b:
            com.facebook.ads.redexgen.X.7Z r4 = (com.facebook.ads.redexgen.X.C7Z) r4
            boolean r0 = r4.A0h()
            if (r0 == 0) goto L35
            r0 = 5
            goto Ld
        L35:
            r0 = 7
            goto Ld
        L37:
            r3 = 1
            r0 = 9
            goto Ld
        L3b:
            if (r1 >= r2) goto L3f
            r0 = 3
            goto Ld
        L3f:
            r0 = 6
            goto Ld
        L41:
            com.facebook.ads.redexgen.X.7Z r4 = (com.facebook.ads.redexgen.X.C7Z) r4
            boolean r0 = r4.A0f()
            if (r0 == 0) goto L4c
            r0 = 8
            goto Ld
        L4c:
            r0 = 5
            goto Ld
        L4e:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C01807a.A0o():boolean");
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x0021, code lost:            return r1;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean A0p() {
        /*
            r3 = this;
            r2 = r3
            r1 = 0
            com.facebook.ads.redexgen.X.6U r0 = r2.A05
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
            com.facebook.ads.redexgen.X.7a r2 = (com.facebook.ads.redexgen.X.C01807a) r2
            com.facebook.ads.redexgen.X.6g r0 = r2.A06
            boolean r0 = r0.A26()
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C01807a.A0p():boolean");
    }

    public static /* synthetic */ boolean A0q() {
        return A1D;
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0026, code lost:            return r1;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean A0r(int r5, int r6) {
        /*
            r4 = this;
            r3 = r4
            r0 = 0
            r0 = 0
            r2 = 1
            r1 = 0
            int[] r0 = r3.A14
            r3.A0n(r0)
            int[] r0 = r3.A14
            r0 = r0[r1]
            if (r0 != r5) goto L24
            r0 = 2
        L11:
            switch(r0) {
                case 2: goto L15;
                case 3: goto L21;
                case 4: goto L26;
                default: goto L14;
            }
        L14:
            goto L11
        L15:
            com.facebook.ads.redexgen.X.7a r3 = (com.facebook.ads.redexgen.X.C01807a) r3
            int[] r0 = r3.A14
            r0 = r0[r2]
            if (r0 == r6) goto L1f
            r0 = 3
            goto L11
        L1f:
            r0 = 4
            goto L11
        L21:
            r1 = r2
            r0 = 4
            goto L11
        L24:
            r0 = 3
            goto L11
        L26:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C01807a.A0r(int, int):boolean");
    }

    /* JADX WARN: Code restructure failed: missing block: B:163:0x0134, code lost:            return r8;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final boolean A0s(int r12, int r13) {
        /*
            Method dump skipped, instructions count: 364
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C01807a.A0s(int, int):boolean");
    }

    /* JADX WARN: Code restructure failed: missing block: B:153:0x0187, code lost:            return r11;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final boolean A0t(int r13, int r14, android.view.MotionEvent r15) {
        /*
            Method dump skipped, instructions count: 446
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C01807a.A0t(int, int, android.view.MotionEvent):boolean");
    }

    /* JADX WARN: Code restructure failed: missing block: B:76:0x0081, code lost:            return r2;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean A0u(android.view.MotionEvent r8) {
        /*
            r7 = this;
            r5 = r7
            r0 = 0
            r6 = 0
            r4 = 0
            r0 = 0
            r0 = 0
            r3 = 0
            r0 = 0
            r2 = 1
            int r1 = r8.getAction()
            com.facebook.ads.redexgen.X.7K r0 = r5.A0h
            if (r0 == 0) goto L7f
            r0 = 2
        L12:
            switch(r0) {
                case 2: goto L36;
                case 3: goto L2f;
                case 4: goto L28;
                case 5: goto L1d;
                case 6: goto L16;
                case 7: goto L3d;
                case 8: goto L55;
                case 9: goto L81;
                case 10: goto L5e;
                case 11: goto L62;
                case 12: goto L66;
                case 13: goto L6f;
                case 14: goto L77;
                default: goto L15;
            }
        L15:
            goto L12
        L16:
            if (r3 >= r4) goto L1a
            r0 = 7
            goto L12
        L1a:
            r0 = 11
            goto L12
        L1d:
            com.facebook.ads.redexgen.X.7a r5 = (com.facebook.ads.redexgen.X.C01807a) r5
            java.util.ArrayList<com.facebook.ads.redexgen.X.7K> r0 = r5.A13
            int r4 = r0.size()
            r3 = 0
            r0 = 6
            goto L12
        L28:
            if (r1 == 0) goto L2c
            r0 = 5
            goto L12
        L2c:
            r0 = 11
            goto L12
        L2f:
            com.facebook.ads.redexgen.X.7a r5 = (com.facebook.ads.redexgen.X.C01807a) r5
            r0 = 0
            r5.A0h = r0
            r0 = 4
            goto L12
        L36:
            if (r1 != 0) goto L3a
            r0 = 3
            goto L12
        L3a:
            r0 = 12
            goto L12
        L3d:
            com.facebook.ads.redexgen.X.7a r5 = (com.facebook.ads.redexgen.X.C01807a) r5
            android.view.MotionEvent r8 = (android.view.MotionEvent) r8
            java.util.ArrayList<com.facebook.ads.redexgen.X.7K> r0 = r5.A13
            java.lang.Object r6 = r0.get(r3)
            com.facebook.ads.redexgen.X.7K r6 = (com.facebook.ads.redexgen.X.C7K) r6
            boolean r0 = r6.onInterceptTouchEvent(r5, r8)
            if (r0 == 0) goto L52
            r0 = 8
            goto L12
        L52:
            r0 = 10
            goto L12
        L55:
            com.facebook.ads.redexgen.X.7a r5 = (com.facebook.ads.redexgen.X.C01807a) r5
            com.facebook.ads.redexgen.X.7K r6 = (com.facebook.ads.redexgen.X.C7K) r6
            r5.A0h = r6
            r0 = 9
            goto L12
        L5e:
            int r3 = r3 + 1
            r0 = 6
            goto L12
        L62:
            r2 = 0
            r0 = 9
            goto L12
        L66:
            r0 = 3
            if (r1 == r0) goto L6c
            r0 = 13
            goto L12
        L6c:
            r0 = 14
            goto L12
        L6f:
            if (r1 != r2) goto L74
            r0 = 14
            goto L12
        L74:
            r0 = 9
            goto L12
        L77:
            com.facebook.ads.redexgen.X.7a r5 = (com.facebook.ads.redexgen.X.C01807a) r5
            r0 = 0
            r5.A0h = r0
            r0 = 9
            goto L12
        L7f:
            r0 = 4
            goto L12
        L81:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C01807a.A0u(android.view.MotionEvent):boolean");
    }

    /* JADX WARN: Code restructure failed: missing block: B:56:0x0065, code lost:            return r6;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean A0v(android.view.MotionEvent r9) {
        /*
            r8 = this;
            r7 = r8
            r6 = 0
            r5 = 0
            r4 = 0
            r0 = 0
            r3 = 0
            r0 = 0
            r2 = 3
            int r1 = r9.getAction()
            if (r1 == r2) goto L63
            r0 = 2
        Lf:
            switch(r0) {
                case 2: goto L51;
                case 3: goto L4a;
                case 4: goto L3f;
                case 5: goto L38;
                case 6: goto L13;
                case 7: goto L57;
                case 8: goto L2a;
                case 9: goto L65;
                case 10: goto L34;
                case 11: goto L5f;
                default: goto L12;
            }
        L12:
            goto Lf
        L13:
            com.facebook.ads.redexgen.X.7a r7 = (com.facebook.ads.redexgen.X.C01807a) r7
            android.view.MotionEvent r9 = (android.view.MotionEvent) r9
            java.util.ArrayList<com.facebook.ads.redexgen.X.7K> r0 = r7.A13
            java.lang.Object r5 = r0.get(r4)
            com.facebook.ads.redexgen.X.7K r5 = (com.facebook.ads.redexgen.X.C7K) r5
            boolean r0 = r5.onInterceptTouchEvent(r7, r9)
            if (r0 == 0) goto L27
            r0 = 7
            goto Lf
        L27:
            r0 = 10
            goto Lf
        L2a:
            com.facebook.ads.redexgen.X.7a r7 = (com.facebook.ads.redexgen.X.C01807a) r7
            com.facebook.ads.redexgen.X.7K r5 = (com.facebook.ads.redexgen.X.C7K) r5
            r7.A0h = r5
            r6 = 1
            r0 = 9
            goto Lf
        L34:
            int r4 = r4 + 1
            r0 = 5
            goto Lf
        L38:
            if (r4 >= r3) goto L3c
            r0 = 6
            goto Lf
        L3c:
            r0 = 11
            goto Lf
        L3f:
            com.facebook.ads.redexgen.X.7a r7 = (com.facebook.ads.redexgen.X.C01807a) r7
            java.util.ArrayList<com.facebook.ads.redexgen.X.7K> r0 = r7.A13
            int r3 = r0.size()
            r4 = 0
            r0 = 5
            goto Lf
        L4a:
            com.facebook.ads.redexgen.X.7a r7 = (com.facebook.ads.redexgen.X.C01807a) r7
            r0 = 0
            r7.A0h = r0
            r0 = 4
            goto Lf
        L51:
            if (r1 != 0) goto L55
            r0 = 3
            goto Lf
        L55:
            r0 = 4
            goto Lf
        L57:
            if (r1 == r2) goto L5c
            r0 = 8
            goto Lf
        L5c:
            r0 = 10
            goto Lf
        L5f:
            r6 = 0
            r0 = 9
            goto Lf
        L63:
            r0 = 3
            goto Lf
        L65:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C01807a.A0v(android.view.MotionEvent):boolean");
    }

    /* JADX WARN: Code restructure failed: missing block: B:112:0x00bb, code lost:            return r1;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean A0w(android.view.View r8, android.view.View r9, int r10) {
        /*
            Method dump skipped, instructions count: 230
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C01807a.A0w(android.view.View, android.view.View, int):boolean");
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:5:0x002d. Please report as an issue. */
    private boolean A0x(View view, View view2, int i) {
        char c;
        C01807a c01807a = this;
        boolean z = true;
        c01807a.A0p.set(0, 0, view.getWidth(), view.getHeight());
        c01807a.A0z.set(0, 0, view2.getWidth(), view2.getHeight());
        c01807a.offsetDescendantRectToMyCoords(view, c01807a.A0p);
        c01807a.offsetDescendantRectToMyCoords(view2, c01807a.A0z);
        switch (i) {
            case 17:
                c = 15;
                break;
            case 33:
                c = 7;
                break;
            case 66:
                c = 11;
                break;
            case 130:
                c = 3;
                break;
            default:
                c = 2;
                break;
        }
        while (true) {
            switch (c) {
                case 2:
                    throw new IllegalArgumentException(A08(1227, 37, 107) + i + c01807a.A17());
                case 3:
                    c01807a = c01807a;
                    c = c01807a.A0p.top >= c01807a.A0z.top ? (char) 4 : (char) 5;
                case 4:
                    c01807a = c01807a;
                    c = c01807a.A0p.bottom <= c01807a.A0z.top ? (char) 5 : (char) 6;
                case 5:
                    c01807a = c01807a;
                    c = c01807a.A0p.bottom >= c01807a.A0z.bottom ? (char) 6 : (char) 18;
                case 6:
                    z = false;
                    c = 18;
                case 7:
                    c01807a = c01807a;
                    c = c01807a.A0p.bottom <= c01807a.A0z.bottom ? '\b' : '\t';
                case '\b':
                    c01807a = c01807a;
                    c = c01807a.A0p.top >= c01807a.A0z.bottom ? '\t' : '\n';
                case '\t':
                    c01807a = c01807a;
                    c = c01807a.A0p.top <= c01807a.A0z.top ? '\n' : (char) 18;
                case '\n':
                    z = false;
                    c = 18;
                case 11:
                    c01807a = c01807a;
                    c = c01807a.A0p.left >= c01807a.A0z.left ? '\f' : '\r';
                case '\f':
                    c01807a = c01807a;
                    c = c01807a.A0p.right <= c01807a.A0z.left ? '\r' : (char) 14;
                case '\r':
                    c01807a = c01807a;
                    c = c01807a.A0p.right >= c01807a.A0z.right ? (char) 14 : (char) 18;
                case 14:
                    z = false;
                    c = 18;
                case 15:
                    c01807a = c01807a;
                    c = c01807a.A0p.right <= c01807a.A0z.right ? (char) 16 : (char) 17;
                case 16:
                    c01807a = c01807a;
                    c = c01807a.A0p.left >= c01807a.A0z.right ? (char) 17 : (char) 19;
                case 17:
                    c01807a = c01807a;
                    c = c01807a.A0p.left > c01807a.A0z.left ? (char) 18 : (char) 19;
                case 18:
                    return z;
                case 19:
                    z = false;
                    c = 18;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:37:0x0038, code lost:            return r2;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final boolean A0y(android.view.accessibility.AccessibilityEvent r5) {
        /*
            r4 = this;
            r3 = r4
            r2 = 0
            r1 = 0
            boolean r0 = r3.A1j()
            if (r0 == 0) goto L35
            r0 = 2
        La:
            switch(r0) {
                case 2: goto L29;
                case 3: goto L21;
                case 4: goto L1b;
                case 5: goto L18;
                case 6: goto Le;
                case 7: goto L38;
                case 8: goto L32;
                default: goto Ld;
            }
        Ld:
            goto La
        Le:
            com.facebook.ads.redexgen.X.7a r3 = (com.facebook.ads.redexgen.X.C01807a) r3
            int r0 = r3.A0P
            r0 = r0 | r1
            r3.A0P = r0
            r2 = 1
            r0 = 7
            goto La
        L18:
            r1 = 0
            r0 = 6
            goto La
        L1b:
            if (r1 != 0) goto L1f
            r0 = 5
            goto La
        L1f:
            r0 = 6
            goto La
        L21:
            android.view.accessibility.AccessibilityEvent r5 = (android.view.accessibility.AccessibilityEvent) r5
            int r1 = com.facebook.ads.redexgen.X.C01335c.A00(r5)
            r0 = 4
            goto La
        L29:
            android.view.accessibility.AccessibilityEvent r5 = (android.view.accessibility.AccessibilityEvent) r5
            r1 = 0
            if (r5 == 0) goto L30
            r0 = 3
            goto La
        L30:
            r0 = 4
            goto La
        L32:
            r2 = 0
            r0 = 7
            goto La
        L35:
            r0 = 8
            goto La
        L38:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C01807a.A0y(android.view.accessibility.AccessibilityEvent):boolean");
    }

    public static /* synthetic */ boolean A0z(C01807a c01807a) {
        return c01807a.awakenScrollBars();
    }

    public static /* synthetic */ int[] A10(C01807a c01807a) {
        return c01807a.A16;
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x001a, code lost:            return r2;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int A11(android.view.View r4) {
        /*
            r3 = this;
            r2 = 0
            r0 = 0
            com.facebook.ads.redexgen.X.7Z r1 = A05(r4)
            if (r1 == 0) goto L18
            r0 = 2
        L9:
            switch(r0) {
                case 2: goto Ld;
                case 3: goto L1a;
                case 4: goto L15;
                default: goto Lc;
            }
        Lc:
            goto L9
        Ld:
            com.facebook.ads.redexgen.X.7Z r1 = (com.facebook.ads.redexgen.X.C7Z) r1
            int r2 = r1.A0I()
            r0 = 3
            goto L9
        L15:
            r2 = -1
            r0 = 3
            goto L9
        L18:
            r0 = 4
            goto L9
        L1a:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C01807a.A11(android.view.View):int");
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x002e, code lost:            return r1;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int A12(com.facebook.ads.redexgen.X.C7Z r4) {
        /*
            r3 = this;
            r2 = r3
            r1 = 0
            r0 = 524(0x20c, float:7.34E-43)
            boolean r0 = r4.A0k(r0)
            if (r0 != 0) goto L2c
            r0 = 2
        Lb:
            switch(r0) {
                case 2: goto Lf;
                case 3: goto L1b;
                case 4: goto L2e;
                case 5: goto L1e;
                default: goto Le;
            }
        Le:
            goto Lb
        Lf:
            com.facebook.ads.redexgen.X.7Z r4 = (com.facebook.ads.redexgen.X.C7Z) r4
            boolean r0 = r4.A0a()
            if (r0 != 0) goto L19
            r0 = 3
            goto Lb
        L19:
            r0 = 5
            goto Lb
        L1b:
            r1 = -1
            r0 = 4
            goto Lb
        L1e:
            com.facebook.ads.redexgen.X.7a r2 = (com.facebook.ads.redexgen.X.C01807a) r2
            com.facebook.ads.redexgen.X.7Z r4 = (com.facebook.ads.redexgen.X.C7Z) r4
            com.facebook.ads.redexgen.X.6G r1 = r2.A00
            int r0 = r4.A03
            int r1 = r1.A0E(r0)
            r0 = 4
            goto Lb
        L2c:
            r0 = 3
            goto Lb
        L2e:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C01807a.A12(com.facebook.ads.redexgen.X.7Z):int");
    }

    /* JADX WARN: Code restructure failed: missing block: B:59:0x00b8, code lost:            return r6;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final android.graphics.Rect A13(android.view.View r10) {
        /*
            Method dump skipped, instructions count: 210
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C01807a.A13(android.view.View):android.graphics.Rect");
    }

    /* JADX WARN: Code restructure failed: missing block: B:48:0x0042, code lost:            return r4;     */
    @android.support.annotation.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final android.view.View A14(android.view.View r4) {
        /*
            r3 = this;
            r2 = r3
            r0 = 0
            android.view.ViewParent r1 = r4.getParent()
            r0 = 2
        L7:
            switch(r0) {
                case 2: goto L16;
                case 3: goto L33;
                case 4: goto L29;
                case 5: goto L1e;
                case 6: goto Lb;
                case 7: goto L40;
                case 8: goto L3d;
                default: goto La;
            }
        La:
            goto L7
        Lb:
            com.facebook.ads.redexgen.X.7a r2 = (com.facebook.ads.redexgen.X.C01807a) r2
            android.view.ViewParent r1 = (android.view.ViewParent) r1
            if (r1 != r2) goto L13
            r0 = 7
            goto L7
        L13:
            r0 = 8
            goto L7
        L16:
            android.view.ViewParent r1 = (android.view.ViewParent) r1
            if (r1 == 0) goto L1c
            r0 = 3
            goto L7
        L1c:
            r0 = 6
            goto L7
        L1e:
            android.view.ViewParent r1 = (android.view.ViewParent) r1
            r4 = r1
            android.view.View r4 = (android.view.View) r4
            android.view.ViewParent r1 = r4.getParent()
            r0 = 2
            goto L7
        L29:
            android.view.ViewParent r1 = (android.view.ViewParent) r1
            boolean r0 = r1 instanceof android.view.View
            if (r0 == 0) goto L31
            r0 = 5
            goto L7
        L31:
            r0 = 6
            goto L7
        L33:
            com.facebook.ads.redexgen.X.7a r2 = (com.facebook.ads.redexgen.X.C01807a) r2
            android.view.ViewParent r1 = (android.view.ViewParent) r1
            if (r1 == r2) goto L3b
            r0 = 4
            goto L7
        L3b:
            r0 = 6
            goto L7
        L3d:
            r4 = 0
            r0 = 7
            goto L7
        L40:
            android.view.View r4 = (android.view.View) r4
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C01807a.A14(android.view.View):android.view.View");
    }

    /* JADX WARN: Code restructure failed: missing block: B:76:0x0079, code lost:            return r6;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.facebook.ads.redexgen.X.C7Z A15(int r8, boolean r9) {
        /*
            r7 = this;
            r5 = r7
            r0 = 0
            r0 = 0
            r0 = 0
            r6 = 0
            com.facebook.ads.redexgen.X.6J r0 = r5.A01
            int r4 = r0.A06()
            r3 = 0
            r2 = 0
            r0 = 2
        Le:
            switch(r0) {
                case 2: goto L4f;
                case 3: goto L30;
                case 4: goto L1d;
                case 5: goto L29;
                case 6: goto L12;
                case 7: goto L56;
                case 8: goto L42;
                case 9: goto L5f;
                case 10: goto L5a;
                case 11: goto L73;
                case 12: goto L77;
                default: goto L11;
            }
        L11:
            goto Le
        L12:
            com.facebook.ads.redexgen.X.7Z r6 = (com.facebook.ads.redexgen.X.C7Z) r6
            int r0 = r6.A03
            if (r0 == r8) goto L1a
            r0 = 7
            goto Le
        L1a:
            r0 = 9
            goto Le
        L1d:
            com.facebook.ads.redexgen.X.7Z r6 = (com.facebook.ads.redexgen.X.C7Z) r6
            boolean r0 = r6.A0c()
            if (r0 != 0) goto L27
            r0 = 5
            goto Le
        L27:
            r0 = 7
            goto Le
        L29:
            if (r9 == 0) goto L2d
            r0 = 6
            goto Le
        L2d:
            r0 = 8
            goto Le
        L30:
            com.facebook.ads.redexgen.X.7a r5 = (com.facebook.ads.redexgen.X.C01807a) r5
            com.facebook.ads.redexgen.X.6J r0 = r5.A01
            android.view.View r0 = r0.A0A(r2)
            com.facebook.ads.redexgen.X.7Z r6 = A05(r0)
            if (r6 == 0) goto L40
            r0 = 4
            goto Le
        L40:
            r0 = 7
            goto Le
        L42:
            com.facebook.ads.redexgen.X.7Z r6 = (com.facebook.ads.redexgen.X.C7Z) r6
            int r0 = r6.A0I()
            if (r0 != r8) goto L4d
            r0 = 9
            goto Le
        L4d:
            r0 = 7
            goto Le
        L4f:
            if (r2 >= r4) goto L53
            r0 = 3
            goto Le
        L53:
            r0 = 11
            goto Le
        L56:
            int r2 = r2 + 1
            r0 = 2
            goto Le
        L5a:
            com.facebook.ads.redexgen.X.7Z r6 = (com.facebook.ads.redexgen.X.C7Z) r6
            r3 = r6
            r0 = 7
            goto Le
        L5f:
            com.facebook.ads.redexgen.X.7a r5 = (com.facebook.ads.redexgen.X.C01807a) r5
            com.facebook.ads.redexgen.X.7Z r6 = (com.facebook.ads.redexgen.X.C7Z) r6
            com.facebook.ads.redexgen.X.6J r1 = r5.A01
            android.view.View r0 = r6.A0H
            boolean r0 = r1.A0K(r0)
            if (r0 == 0) goto L70
            r0 = 10
            goto Le
        L70:
            r0 = 12
            goto Le
        L73:
            r6 = r3
            r0 = 12
            goto Le
        L77:
            com.facebook.ads.redexgen.X.7Z r6 = (com.facebook.ads.redexgen.X.C7Z) r6
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C01807a.A15(int, boolean):com.facebook.ads.redexgen.X.7Z");
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:5:0x0009. Please report as an issue. */
    public final C7Z A16(View view) {
        ViewParent parent = this;
        ViewParent parent2 = view.getParent();
        char c = parent2 != null ? (char) 2 : (char) 4;
        while (true) {
            switch (c) {
                case 2:
                    parent = (C01807a) parent;
                    parent2 = parent2;
                    c = parent2 != parent ? (char) 3 : (char) 4;
                case 3:
                    throw new IllegalArgumentException(A08(854, 5, 10) + view + A08(1604, 26, 104) + ((C01807a) parent));
                case 4:
                    return A05(view);
            }
        }
    }

    public final String A17() {
        return A08(0, 1, 81) + super.toString() + A08(1728, 10, 111) + this.A04 + A08(1719, 9, 114) + this.A06 + A08(1264, 10, 43) + getContext();
    }

    /* JADX WARN: Code restructure failed: missing block: B:86:0x00dd, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void A18() {
        /*
            Method dump skipped, instructions count: 252
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C01807a.A18():void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0024, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void A19() {
        /*
            r3 = this;
            r2 = r3
            int r0 = r2.A0O
            int r0 = r0 + 1
            r2.A0O = r0
            int r1 = r2.A0O
            r0 = 1
            if (r1 != r0) goto L22
            r0 = 2
        Ld:
            switch(r0) {
                case 2: goto L11;
                case 3: goto L1b;
                case 4: goto L24;
                default: goto L10;
            }
        L10:
            goto Ld
        L11:
            com.facebook.ads.redexgen.X.7a r2 = (com.facebook.ads.redexgen.X.C01807a) r2
            boolean r0 = r2.A0I
            if (r0 != 0) goto L19
            r0 = 3
            goto Ld
        L19:
            r0 = 4
            goto Ld
        L1b:
            com.facebook.ads.redexgen.X.7a r2 = (com.facebook.ads.redexgen.X.C01807a) r2
            r0 = 0
            r2.A0J = r0
            r0 = 4
            goto Ld
        L22:
            r0 = 4
            goto Ld
        L24:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C01807a.A19():void");
    }

    public final void A1A() {
        this.A0U++;
    }

    public final void A1B() {
        A1f(true);
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0022, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void A1C() {
        /*
            r2 = this;
            r1 = r2
            boolean r0 = r1.A0K
            if (r0 != 0) goto L20
            r0 = 2
        L6:
            switch(r0) {
                case 2: goto La;
                case 3: goto L14;
                case 4: goto L22;
                default: goto L9;
            }
        L9:
            goto L6
        La:
            com.facebook.ads.redexgen.X.7a r1 = (com.facebook.ads.redexgen.X.C01807a) r1
            boolean r0 = r1.A0F
            if (r0 == 0) goto L12
            r0 = 3
            goto L6
        L12:
            r0 = 4
            goto L6
        L14:
            com.facebook.ads.redexgen.X.7a r1 = (com.facebook.ads.redexgen.X.C01807a) r1
            java.lang.Runnable r0 = r1.A0k
            com.facebook.ads.redexgen.X.C5B.A0C(r1, r0)
            r0 = 1
            r1.A0K = r0
            r0 = 4
            goto L6
        L20:
            r0 = 4
            goto L6
        L22:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C01807a.A1C():void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x0031, code lost:            r2.A0r.A0P();     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0038, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void A1D() {
        /*
            r3 = this;
            r2 = r3
            com.facebook.ads.redexgen.X.6U r0 = r2.A05
            if (r0 == 0) goto L2f
            r0 = 2
        L6:
            switch(r0) {
                case 2: goto La;
                case 3: goto L13;
                case 4: goto L1d;
                case 5: goto L31;
                default: goto L9;
            }
        L9:
            goto L6
        La:
            com.facebook.ads.redexgen.X.7a r2 = (com.facebook.ads.redexgen.X.C01807a) r2
            com.facebook.ads.redexgen.X.6U r0 = r2.A05
            r0.A0G()
            r0 = 3
            goto L6
        L13:
            com.facebook.ads.redexgen.X.7a r2 = (com.facebook.ads.redexgen.X.C01807a) r2
            com.facebook.ads.redexgen.X.6g r0 = r2.A06
            if (r0 == 0) goto L1b
            r0 = 4
            goto L6
        L1b:
            r0 = 5
            goto L6
        L1d:
            com.facebook.ads.redexgen.X.7a r2 = (com.facebook.ads.redexgen.X.C01807a) r2
            com.facebook.ads.redexgen.X.6g r1 = r2.A06
            com.facebook.ads.redexgen.X.7O r0 = r2.A0r
            r1.A1I(r0)
            com.facebook.ads.redexgen.X.6g r1 = r2.A06
            com.facebook.ads.redexgen.X.7O r0 = r2.A0r
            r1.A1G(r0)
            r0 = 5
            goto L6
        L2f:
            r0 = 3
            goto L6
        L31:
            com.facebook.ads.redexgen.X.7a r2 = (com.facebook.ads.redexgen.X.C01807a) r2
            com.facebook.ads.redexgen.X.7O r0 = r2.A0r
            r0.A0P()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C01807a.A1D():void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:55:0x0076, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void A1E() {
        /*
            r10 = this;
            r8 = r10
            r9 = 0
            r7 = 0
            r0 = 0
            r0 = 0
            r6 = 0
            r5 = 0
            r4 = 0
            com.facebook.ads.redexgen.X.6J r0 = r8.A01
            int r3 = r0.A05()
            r2 = 0
            r0 = 2
        L10:
            switch(r0) {
                case 2: goto L6b;
                case 3: goto L58;
                case 4: goto L4d;
                case 5: goto L33;
                case 6: goto L14;
                case 7: goto L21;
                case 8: goto L72;
                case 9: goto L76;
                default: goto L13;
            }
        L13:
            goto L10
        L14:
            android.view.View r6 = (android.view.View) r6
            int r0 = r6.getTop()
            if (r7 == r0) goto L1e
            r0 = 7
            goto L10
        L1e:
            r0 = 8
            goto L10
        L21:
            android.view.View r6 = (android.view.View) r6
            int r1 = r6.getWidth()
            int r1 = r1 + r9
            int r0 = r6.getHeight()
            int r0 = r0 + r7
            r6.layout(r9, r7, r1, r0)
            r0 = 8
            goto L10
        L33:
            android.view.View r4 = (android.view.View) r4
            com.facebook.ads.redexgen.X.7Z r5 = (com.facebook.ads.redexgen.X.C7Z) r5
            com.facebook.ads.redexgen.X.7Z r0 = r5.A07
            android.view.View r6 = r0.A0H
            int r9 = r4.getLeft()
            int r7 = r4.getTop()
            int r0 = r6.getLeft()
            if (r9 != r0) goto L4b
            r0 = 6
            goto L10
        L4b:
            r0 = 7
            goto L10
        L4d:
            com.facebook.ads.redexgen.X.7Z r5 = (com.facebook.ads.redexgen.X.C7Z) r5
            com.facebook.ads.redexgen.X.7Z r0 = r5.A07
            if (r0 == 0) goto L55
            r0 = 5
            goto L10
        L55:
            r0 = 8
            goto L10
        L58:
            com.facebook.ads.redexgen.X.7a r8 = (com.facebook.ads.redexgen.X.C01807a) r8
            com.facebook.ads.redexgen.X.6J r0 = r8.A01
            android.view.View r4 = r0.A09(r2)
            com.facebook.ads.redexgen.X.7Z r5 = r8.A16(r4)
            if (r5 == 0) goto L68
            r0 = 4
            goto L10
        L68:
            r0 = 8
            goto L10
        L6b:
            if (r2 >= r3) goto L6f
            r0 = 3
            goto L10
        L6f:
            r0 = 9
            goto L10
        L72:
            int r2 = r2 + 1
            r0 = 2
            goto L10
        L76:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C01807a.A1E():void");
    }

    public final void A1F() {
        this.A0C = true;
        A0X();
    }

    public final void A1G() {
        setScrollState(0);
        A0L();
    }

    public final void A1H(int i) {
        if (this.A06 == null) {
            return;
        }
        this.A06.A1t(i);
        awakenScrollBars();
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0024, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void A1I(int r5) {
        /*
            r4 = this;
            r3 = r4
            r0 = 0
            r0 = 0
            com.facebook.ads.redexgen.X.6J r0 = r3.A01
            int r2 = r0.A05()
            r1 = 0
            r0 = 2
        Lb:
            switch(r0) {
                case 2: goto Lf;
                case 3: goto L15;
                case 4: goto L24;
                default: goto Le;
            }
        Le:
            goto Lb
        Lf:
            if (r1 >= r2) goto L13
            r0 = 3
            goto Lb
        L13:
            r0 = 4
            goto Lb
        L15:
            com.facebook.ads.redexgen.X.7a r3 = (com.facebook.ads.redexgen.X.C01807a) r3
            com.facebook.ads.redexgen.X.6J r0 = r3.A01
            android.view.View r0 = r0.A09(r1)
            r0.offsetLeftAndRight(r5)
            int r1 = r1 + 1
            r0 = 2
            goto Lb
        L24:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C01807a.A1I(int):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0024, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void A1J(int r5) {
        /*
            r4 = this;
            r3 = r4
            r0 = 0
            r0 = 0
            com.facebook.ads.redexgen.X.6J r0 = r3.A01
            int r2 = r0.A05()
            r1 = 0
            r0 = 2
        Lb:
            switch(r0) {
                case 2: goto Lf;
                case 3: goto L15;
                case 4: goto L24;
                default: goto Le;
            }
        Le:
            goto Lb
        Lf:
            if (r1 >= r2) goto L13
            r0 = 3
            goto Lb
        L13:
            r0 = 4
            goto Lb
        L15:
            com.facebook.ads.redexgen.X.7a r3 = (com.facebook.ads.redexgen.X.C01807a) r3
            com.facebook.ads.redexgen.X.6J r0 = r3.A01
            android.view.View r0 = r0.A09(r1)
            r0.offsetTopAndBottom(r5)
            int r1 = r1 + 1
            r0 = 2
            goto Lb
        L24:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C01807a.A1J(int):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x003e, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void A1K(int r6) {
        /*
            r5 = this;
            r4 = r5
            boolean r0 = r4.A0I
            if (r0 == 0) goto L3c
            r0 = 2
        L6:
            switch(r0) {
                case 2: goto L3e;
                case 3: goto La;
                case 4: goto L23;
                case 5: goto L17;
                default: goto L9;
            }
        L9:
            goto L6
        La:
            com.facebook.ads.redexgen.X.7a r4 = (com.facebook.ads.redexgen.X.C01807a) r4
            r4.A1G()
            com.facebook.ads.redexgen.X.6g r0 = r4.A06
            if (r0 != 0) goto L15
            r0 = 4
            goto L6
        L15:
            r0 = 5
            goto L6
        L17:
            com.facebook.ads.redexgen.X.7a r4 = (com.facebook.ads.redexgen.X.C01807a) r4
            com.facebook.ads.redexgen.X.6g r0 = r4.A06
            r0.A1t(r6)
            r4.awakenScrollBars()
            r0 = 2
            goto L6
        L23:
            r2 = 1788(0x6fc, float:2.506E-42)
            r1 = 12
            r0 = 70
            java.lang.String r3 = A08(r2, r1, r0)
            r2 = 1510(0x5e6, float:2.116E-42)
            r1 = 94
            r0 = 35
            java.lang.String r0 = A08(r2, r1, r0)
            android.util.Log.e(r3, r0)
            r0 = 2
            goto L6
        L3c:
            r0 = 3
            goto L6
        L3e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C01807a.A1K(int):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x003a, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void A1L(int r6) {
        /*
            r5 = this;
            r4 = r5
            boolean r0 = r4.A0I
            if (r0 == 0) goto L38
            r0 = 2
        L6:
            switch(r0) {
                case 2: goto L3a;
                case 3: goto La;
                case 4: goto L14;
                case 5: goto L2d;
                default: goto L9;
            }
        L9:
            goto L6
        La:
            com.facebook.ads.redexgen.X.7a r4 = (com.facebook.ads.redexgen.X.C01807a) r4
            com.facebook.ads.redexgen.X.6g r0 = r4.A06
            if (r0 != 0) goto L12
            r0 = 4
            goto L6
        L12:
            r0 = 5
            goto L6
        L14:
            r2 = 1788(0x6fc, float:2.506E-42)
            r1 = 12
            r0 = 70
            java.lang.String r3 = A08(r2, r1, r0)
            r2 = 1404(0x57c, float:1.967E-42)
            r1 = 97
            r0 = 109(0x6d, float:1.53E-43)
            java.lang.String r0 = A08(r2, r1, r0)
            android.util.Log.e(r3, r0)
            r0 = 2
            goto L6
        L2d:
            com.facebook.ads.redexgen.X.7a r4 = (com.facebook.ads.redexgen.X.C01807a) r4
            com.facebook.ads.redexgen.X.6g r1 = r4.A06
            com.facebook.ads.redexgen.X.7W r0 = r4.A0s
            r1.A21(r4, r0, r6)
            r0 = 2
            goto L6
        L38:
            r0 = 3
            goto L6
        L3a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C01807a.A1L(int):void");
    }

    public final void A1M(int i) {
        getScrollingChildHelper().A03(i);
    }

    /* JADX WARN: Code restructure failed: missing block: B:63:0x0067, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void A1N(int r4, int r5) {
        /*
            r3 = this;
            r2 = r3
            if (r4 >= 0) goto L64
            r0 = 2
        L4:
            switch(r0) {
                case 2: goto Lf;
                case 3: goto L36;
                case 4: goto L29;
                case 5: goto L23;
                case 6: goto L8;
                case 7: goto L3d;
                case 8: goto L67;
                case 9: goto L45;
                case 10: goto L4c;
                case 11: goto L1c;
                case 12: goto L58;
                default: goto L7;
            }
        L7:
            goto L4
        L8:
            if (r5 == 0) goto Lc
            r0 = 7
            goto L4
        Lc:
            r0 = 8
            goto L4
        Lf:
            com.facebook.ads.redexgen.X.7a r2 = (com.facebook.ads.redexgen.X.C01807a) r2
            r2.A0R()
            android.widget.EdgeEffect r1 = r2.A0a
            int r0 = -r4
            r1.onAbsorb(r0)
            r0 = 3
            goto L4
        L1c:
            if (r4 <= 0) goto L21
            r0 = 12
            goto L4
        L21:
            r0 = 3
            goto L4
        L23:
            if (r4 != 0) goto L27
            r0 = 6
            goto L4
        L27:
            r0 = 7
            goto L4
        L29:
            com.facebook.ads.redexgen.X.7a r2 = (com.facebook.ads.redexgen.X.C01807a) r2
            r2.A0T()
            android.widget.EdgeEffect r1 = r2.A0c
            int r0 = -r5
            r1.onAbsorb(r0)
            r0 = 5
            goto L4
        L36:
            if (r5 >= 0) goto L3a
            r0 = 4
            goto L4
        L3a:
            r0 = 9
            goto L4
        L3d:
            com.facebook.ads.redexgen.X.7a r2 = (com.facebook.ads.redexgen.X.C01807a) r2
            com.facebook.ads.redexgen.X.C5B.A07(r2)
            r0 = 8
            goto L4
        L45:
            if (r5 <= 0) goto L4a
            r0 = 10
            goto L4
        L4a:
            r0 = 5
            goto L4
        L4c:
            com.facebook.ads.redexgen.X.7a r2 = (com.facebook.ads.redexgen.X.C01807a) r2
            r2.A0Q()
            android.widget.EdgeEffect r0 = r2.A0Z
            r0.onAbsorb(r5)
            r0 = 5
            goto L4
        L58:
            com.facebook.ads.redexgen.X.7a r2 = (com.facebook.ads.redexgen.X.C01807a) r2
            r2.A0S()
            android.widget.EdgeEffect r0 = r2.A0b
            r0.onAbsorb(r4)
            r0 = 3
            goto L4
        L64:
            r0 = 11
            goto L4
        L67:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C01807a.A1N(int, int):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:126:0x00ed, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void A1O(int r4, int r5) {
        /*
            Method dump skipped, instructions count: 278
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C01807a.A1O(int, int):void");
    }

    public final void A1P(int i, int i2) {
        setMeasuredDimension(AbstractC01616g.A00(i, getPaddingLeft() + getPaddingRight(), C5B.A03(this)), AbstractC01616g.A00(i2, getPaddingTop() + getPaddingBottom(), C5B.A02(this)));
    }

    /* JADX WARN: Code restructure failed: missing block: B:34:0x0054, code lost:            r2 = r2;        r2.A0N--;     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x005c, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void A1Q(int r5, int r6) {
        /*
            r4 = this;
            r2 = r4
            r3 = 0
            int r0 = r2.A0N
            int r0 = r0 + 1
            r2.A0N = r0
            int r1 = r2.getScrollX()
            int r0 = r2.getScrollY()
            r2.onScrollChanged(r1, r0, r1, r0)
            com.facebook.ads.redexgen.X.7L r0 = r2.A0i
            if (r0 == 0) goto L52
            r0 = 2
        L18:
            switch(r0) {
                case 2: goto L33;
                case 3: goto L48;
                case 4: goto L3c;
                case 5: goto L2d;
                case 6: goto L1c;
                case 7: goto L54;
                default: goto L1b;
            }
        L1b:
            goto L18
        L1c:
            com.facebook.ads.redexgen.X.7a r2 = (com.facebook.ads.redexgen.X.C01807a) r2
            java.util.List<com.facebook.ads.redexgen.X.7L> r0 = r2.A0m
            java.lang.Object r0 = r0.get(r3)
            com.facebook.ads.redexgen.X.7L r0 = (com.facebook.ads.redexgen.X.C7L) r0
            r0.A0V(r2, r5, r6)
            int r3 = r3 + (-1)
            r0 = 5
            goto L18
        L2d:
            if (r3 < 0) goto L31
            r0 = 6
            goto L18
        L31:
            r0 = 7
            goto L18
        L33:
            com.facebook.ads.redexgen.X.7a r2 = (com.facebook.ads.redexgen.X.C01807a) r2
            com.facebook.ads.redexgen.X.7L r0 = r2.A0i
            r0.A0V(r2, r5, r6)
            r0 = 3
            goto L18
        L3c:
            com.facebook.ads.redexgen.X.7a r2 = (com.facebook.ads.redexgen.X.C01807a) r2
            java.util.List<com.facebook.ads.redexgen.X.7L> r0 = r2.A0m
            int r0 = r0.size()
            int r3 = r0 + (-1)
            r0 = 5
            goto L18
        L48:
            com.facebook.ads.redexgen.X.7a r2 = (com.facebook.ads.redexgen.X.C01807a) r2
            java.util.List<com.facebook.ads.redexgen.X.7L> r0 = r2.A0m
            if (r0 == 0) goto L50
            r0 = 4
            goto L18
        L50:
            r0 = 7
            goto L18
        L52:
            r0 = 3
            goto L18
        L54:
            com.facebook.ads.redexgen.X.7a r2 = (com.facebook.ads.redexgen.X.C01807a) r2
            int r0 = r2.A0N
            int r0 = r0 + (-1)
            r2.A0N = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C01807a.A1Q(int, int):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:46:0x0052, code lost:            r4 = r4;        r4.A0r.A0R(r7, r8);        r4.requestLayout();     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x005c, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void A1R(int r7, int r8) {
        /*
            r6 = this;
            r4 = r6
            r5 = 0
            r0 = 0
            r0 = 0
            com.facebook.ads.redexgen.X.6J r0 = r4.A01
            int r3 = r0.A06()
            r2 = 0
            r0 = 2
        Lc:
            switch(r0) {
                case 2: goto L31;
                case 3: goto L10;
                case 4: goto L42;
                case 5: goto L38;
                case 6: goto L22;
                case 7: goto L4e;
                case 8: goto L52;
                default: goto Lf;
            }
        Lf:
            goto Lc
        L10:
            com.facebook.ads.redexgen.X.7a r4 = (com.facebook.ads.redexgen.X.C01807a) r4
            com.facebook.ads.redexgen.X.6J r0 = r4.A01
            android.view.View r0 = r0.A0A(r2)
            com.facebook.ads.redexgen.X.7Z r5 = A05(r0)
            if (r5 == 0) goto L20
            r0 = 4
            goto Lc
        L20:
            r0 = 7
            goto Lc
        L22:
            com.facebook.ads.redexgen.X.7a r4 = (com.facebook.ads.redexgen.X.C01807a) r4
            com.facebook.ads.redexgen.X.7Z r5 = (com.facebook.ads.redexgen.X.C7Z) r5
            r0 = 0
            r5.A0W(r8, r0)
            com.facebook.ads.redexgen.X.7W r1 = r4.A0s
            r0 = 1
            r1.A0D = r0
            r0 = 7
            goto Lc
        L31:
            if (r2 >= r3) goto L35
            r0 = 3
            goto Lc
        L35:
            r0 = 8
            goto Lc
        L38:
            com.facebook.ads.redexgen.X.7Z r5 = (com.facebook.ads.redexgen.X.C7Z) r5
            int r0 = r5.A03
            if (r0 < r7) goto L40
            r0 = 6
            goto Lc
        L40:
            r0 = 7
            goto Lc
        L42:
            com.facebook.ads.redexgen.X.7Z r5 = (com.facebook.ads.redexgen.X.C7Z) r5
            boolean r0 = r5.A0h()
            if (r0 != 0) goto L4c
            r0 = 5
            goto Lc
        L4c:
            r0 = 7
            goto Lc
        L4e:
            int r2 = r2 + 1
            r0 = 2
            goto Lc
        L52:
            com.facebook.ads.redexgen.X.7a r4 = (com.facebook.ads.redexgen.X.C01807a) r4
            com.facebook.ads.redexgen.X.7O r0 = r4.A0r
            r0.A0R(r7, r8)
            r4.requestLayout()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C01807a.A1R(int, int):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:73:0x0083, code lost:            r7 = r7;        r7.A0r.A0S(r11, r12);        r7.requestLayout();     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x008d, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void A1S(int r11, int r12) {
        /*
            r10 = this;
            r7 = r10
            r8 = 0
            r0 = 0
            r6 = 0
            r9 = 0
            r5 = 0
            r0 = 0
            r4 = 0
            r3 = 0
            com.facebook.ads.redexgen.X.6J r0 = r7.A01
            int r2 = r0.A06()
            if (r11 >= r12) goto L80
            r0 = 2
        L12:
            switch(r0) {
                case 2: goto L48;
                case 3: goto L45;
                case 4: goto L3e;
                case 5: goto L2b;
                case 6: goto L16;
                case 7: goto L57;
                case 8: goto L63;
                case 9: goto L67;
                case 10: goto L21;
                case 11: goto L4d;
                case 12: goto L73;
                case 13: goto L7b;
                case 14: goto L83;
                default: goto L15;
            }
        L15:
            goto L12
        L16:
            com.facebook.ads.redexgen.X.7Z r9 = (com.facebook.ads.redexgen.X.C7Z) r9
            int r0 = r9.A03
            if (r0 < r4) goto L1e
            r0 = 7
            goto L12
        L1e:
            r0 = 8
            goto L12
        L21:
            com.facebook.ads.redexgen.X.7Z r9 = (com.facebook.ads.redexgen.X.C7Z) r9
            int r0 = r12 - r11
            r9.A0W(r0, r3)
            r0 = 11
            goto L12
        L2b:
            com.facebook.ads.redexgen.X.7a r7 = (com.facebook.ads.redexgen.X.C01807a) r7
            com.facebook.ads.redexgen.X.6J r0 = r7.A01
            android.view.View r0 = r0.A0A(r5)
            com.facebook.ads.redexgen.X.7Z r9 = A05(r0)
            if (r9 == 0) goto L3b
            r0 = 6
            goto L12
        L3b:
            r0 = 8
            goto L12
        L3e:
            if (r5 >= r2) goto L42
            r0 = 5
            goto L12
        L42:
            r0 = 14
            goto L12
        L45:
            r5 = 0
            r0 = 4
            goto L12
        L48:
            r4 = r11
            r6 = r12
            r8 = -1
            r0 = 3
            goto L12
        L4d:
            com.facebook.ads.redexgen.X.7a r7 = (com.facebook.ads.redexgen.X.C01807a) r7
            com.facebook.ads.redexgen.X.7W r1 = r7.A0s
            r0 = 1
            r1.A0D = r0
            r0 = 8
            goto L12
        L57:
            com.facebook.ads.redexgen.X.7Z r9 = (com.facebook.ads.redexgen.X.C7Z) r9
            int r0 = r9.A03
            if (r0 <= r6) goto L60
            r0 = 8
            goto L12
        L60:
            r0 = 9
            goto L12
        L63:
            int r5 = r5 + 1
            r0 = 4
            goto L12
        L67:
            com.facebook.ads.redexgen.X.7Z r9 = (com.facebook.ads.redexgen.X.C7Z) r9
            int r0 = r9.A03
            if (r0 != r11) goto L70
            r0 = 10
            goto L12
        L70:
            r0 = 12
            goto L12
        L73:
            com.facebook.ads.redexgen.X.7Z r9 = (com.facebook.ads.redexgen.X.C7Z) r9
            r9.A0W(r8, r3)
            r0 = 11
            goto L12
        L7b:
            r4 = r12
            r6 = r11
            r8 = 1
            r0 = 3
            goto L12
        L80:
            r0 = 13
            goto L12
        L83:
            com.facebook.ads.redexgen.X.7a r7 = (com.facebook.ads.redexgen.X.C01807a) r7
            com.facebook.ads.redexgen.X.7O r0 = r7.A0r
            r0.A0S(r11, r12)
            r7.requestLayout()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C01807a.A1S(int, int):void");
    }

    public final void A1T(int i, int i2) {
        A0b(i, i2, null);
    }

    /* JADX WARN: Code restructure failed: missing block: B:55:0x006a, code lost:            r6.A0r.A0T(r9, r10);     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x0071, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void A1U(int r9, int r10, java.lang.Object r11) {
        /*
            r8 = this;
            r6 = r8
            r7 = 0
            r0 = 0
            r0 = 0
            r5 = 0
            r0 = 0
            com.facebook.ads.redexgen.X.6J r0 = r6.A01
            int r4 = r0.A06()
            int r3 = r9 + r10
            r2 = 0
            r0 = 2
        L10:
            switch(r0) {
                case 2: goto L40;
                case 3: goto L2e;
                case 4: goto L22;
                case 5: goto L14;
                case 6: goto L18;
                case 7: goto L47;
                case 8: goto L52;
                case 9: goto L6a;
                default: goto L13;
            }
        L13:
            goto L10
        L14:
            int r2 = r2 + 1
            r0 = 2
            goto L10
        L18:
            com.facebook.ads.redexgen.X.7Z r5 = (com.facebook.ads.redexgen.X.C7Z) r5
            int r0 = r5.A03
            if (r0 < r9) goto L20
            r0 = 7
            goto L10
        L20:
            r0 = 5
            goto L10
        L22:
            com.facebook.ads.redexgen.X.7Z r5 = (com.facebook.ads.redexgen.X.C7Z) r5
            boolean r0 = r5.A0h()
            if (r0 == 0) goto L2c
            r0 = 5
            goto L10
        L2c:
            r0 = 6
            goto L10
        L2e:
            com.facebook.ads.redexgen.X.7a r6 = (com.facebook.ads.redexgen.X.C01807a) r6
            com.facebook.ads.redexgen.X.6J r0 = r6.A01
            android.view.View r7 = r0.A0A(r2)
            com.facebook.ads.redexgen.X.7Z r5 = A05(r7)
            if (r5 == 0) goto L3e
            r0 = 4
            goto L10
        L3e:
            r0 = 5
            goto L10
        L40:
            if (r2 >= r4) goto L44
            r0 = 3
            goto L10
        L44:
            r0 = 9
            goto L10
        L47:
            com.facebook.ads.redexgen.X.7Z r5 = (com.facebook.ads.redexgen.X.C7Z) r5
            int r0 = r5.A03
            if (r0 >= r3) goto L50
            r0 = 8
            goto L10
        L50:
            r0 = 5
            goto L10
        L52:
            java.lang.Object r11 = (java.lang.Object) r11
            android.view.View r7 = (android.view.View) r7
            com.facebook.ads.redexgen.X.7Z r5 = (com.facebook.ads.redexgen.X.C7Z) r5
            r0 = 2
            r5.A0T(r0)
            r5.A0Y(r11)
            android.view.ViewGroup$LayoutParams r1 = r7.getLayoutParams()
            com.facebook.ads.redexgen.X.6e r1 = (com.facebook.ads.redexgen.X.C01596e) r1
            r0 = 1
            r1.A01 = r0
            r0 = 5
            goto L10
        L6a:
            com.facebook.ads.redexgen.X.7a r6 = (com.facebook.ads.redexgen.X.C01807a) r6
            com.facebook.ads.redexgen.X.7O r0 = r6.A0r
            r0.A0T(r9, r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C01807a.A1U(int, int, java.lang.Object):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:58:0x0072, code lost:            r4 = r4;        r4.A0r.A0U(r9, r10, r11);        r4.requestLayout();     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x007c, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void A1V(int r9, int r10, boolean r11) {
        /*
            r8 = this;
            r4 = r8
            r0 = 0
            r0 = 0
            r0 = 0
            r6 = 0
            r0 = 0
            r5 = 1
            int r3 = r9 + r10
            com.facebook.ads.redexgen.X.6J r0 = r4.A01
            int r2 = r0.A06()
            r1 = 0
            r0 = 2
        L11:
            switch(r0) {
                case 2: goto L67;
                case 3: goto L55;
                case 4: goto L3e;
                case 5: goto L33;
                case 6: goto L25;
                case 7: goto L6e;
                case 8: goto L4a;
                case 9: goto L15;
                case 10: goto L72;
                default: goto L14;
            }
        L14:
            goto L11
        L15:
            com.facebook.ads.redexgen.X.7a r4 = (com.facebook.ads.redexgen.X.C01807a) r4
            com.facebook.ads.redexgen.X.7Z r6 = (com.facebook.ads.redexgen.X.C7Z) r6
            int r7 = r9 + (-1)
            int r0 = -r10
            r6.A0V(r7, r0, r11)
            com.facebook.ads.redexgen.X.7W r0 = r4.A0s
            r0.A0D = r5
            r0 = 7
            goto L11
        L25:
            com.facebook.ads.redexgen.X.7a r4 = (com.facebook.ads.redexgen.X.C01807a) r4
            com.facebook.ads.redexgen.X.7Z r6 = (com.facebook.ads.redexgen.X.C7Z) r6
            int r0 = -r10
            r6.A0W(r0, r11)
            com.facebook.ads.redexgen.X.7W r0 = r4.A0s
            r0.A0D = r5
            r0 = 7
            goto L11
        L33:
            com.facebook.ads.redexgen.X.7Z r6 = (com.facebook.ads.redexgen.X.C7Z) r6
            int r0 = r6.A03
            if (r0 < r3) goto L3b
            r0 = 6
            goto L11
        L3b:
            r0 = 8
            goto L11
        L3e:
            com.facebook.ads.redexgen.X.7Z r6 = (com.facebook.ads.redexgen.X.C7Z) r6
            boolean r0 = r6.A0h()
            if (r0 != 0) goto L48
            r0 = 5
            goto L11
        L48:
            r0 = 7
            goto L11
        L4a:
            com.facebook.ads.redexgen.X.7Z r6 = (com.facebook.ads.redexgen.X.C7Z) r6
            int r0 = r6.A03
            if (r0 < r9) goto L53
            r0 = 9
            goto L11
        L53:
            r0 = 7
            goto L11
        L55:
            com.facebook.ads.redexgen.X.7a r4 = (com.facebook.ads.redexgen.X.C01807a) r4
            com.facebook.ads.redexgen.X.6J r0 = r4.A01
            android.view.View r0 = r0.A0A(r1)
            com.facebook.ads.redexgen.X.7Z r6 = A05(r0)
            if (r6 == 0) goto L65
            r0 = 4
            goto L11
        L65:
            r0 = 7
            goto L11
        L67:
            if (r1 >= r2) goto L6b
            r0 = 3
            goto L11
        L6b:
            r0 = 10
            goto L11
        L6e:
            int r1 = r1 + 1
            r0 = 2
            goto L11
        L72:
            com.facebook.ads.redexgen.X.7a r4 = (com.facebook.ads.redexgen.X.C01807a) r4
            com.facebook.ads.redexgen.X.7O r0 = r4.A0r
            r0.A0U(r9, r10, r11)
            r4.requestLayout()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C01807a.A1V(int, int, boolean):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:40:0x0041, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void A1W(android.view.View r5) {
        /*
            r4 = this;
            r3 = r4
            r0 = 0
            r2 = 0
            com.facebook.ads.redexgen.X.7Z r1 = A05(r5)
            com.facebook.ads.redexgen.X.2E r0 = r3.A04
            if (r0 == 0) goto L3f
            r0 = 2
        Lc:
            switch(r0) {
                case 2: goto L37;
                case 3: goto L2d;
                case 4: goto L21;
                case 5: goto L1b;
                case 6: goto L10;
                case 7: goto L41;
                default: goto Lf;
            }
        Lf:
            goto Lc
        L10:
            com.facebook.ads.redexgen.X.7a r3 = (com.facebook.ads.redexgen.X.C01807a) r3
            java.util.List<com.facebook.ads.internal.androidx.support.v7.widget.RecyclerView$OnChildAttachStateChangeListener> r0 = r3.A0l
            r0.get(r2)
            int r2 = r2 + (-1)
            r0 = 5
            goto Lc
        L1b:
            if (r2 < 0) goto L1f
            r0 = 6
            goto Lc
        L1f:
            r0 = 7
            goto Lc
        L21:
            com.facebook.ads.redexgen.X.7a r3 = (com.facebook.ads.redexgen.X.C01807a) r3
            java.util.List<com.facebook.ads.internal.androidx.support.v7.widget.RecyclerView$OnChildAttachStateChangeListener> r0 = r3.A0l
            int r0 = r0.size()
            int r2 = r0 + (-1)
            r0 = 5
            goto Lc
        L2d:
            com.facebook.ads.redexgen.X.7a r3 = (com.facebook.ads.redexgen.X.C01807a) r3
            java.util.List<com.facebook.ads.internal.androidx.support.v7.widget.RecyclerView$OnChildAttachStateChangeListener> r0 = r3.A0l
            if (r0 == 0) goto L35
            r0 = 4
            goto Lc
        L35:
            r0 = 7
            goto Lc
        L37:
            com.facebook.ads.redexgen.X.7Z r1 = (com.facebook.ads.redexgen.X.C7Z) r1
            if (r1 == 0) goto L3d
            r0 = 3
            goto Lc
        L3d:
            r0 = 3
            goto Lc
        L3f:
            r0 = 3
            goto Lc
        L41:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C01807a.A1W(android.view.View):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:40:0x0041, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void A1X(android.view.View r5) {
        /*
            r4 = this;
            r3 = r4
            r0 = 0
            r2 = 0
            com.facebook.ads.redexgen.X.7Z r1 = A05(r5)
            com.facebook.ads.redexgen.X.2E r0 = r3.A04
            if (r0 == 0) goto L3f
            r0 = 2
        Lc:
            switch(r0) {
                case 2: goto L25;
                case 3: goto L10;
                case 4: goto L33;
                case 5: goto L2d;
                case 6: goto L1a;
                case 7: goto L41;
                default: goto Lf;
            }
        Lf:
            goto Lc
        L10:
            com.facebook.ads.redexgen.X.7a r3 = (com.facebook.ads.redexgen.X.C01807a) r3
            java.util.List<com.facebook.ads.internal.androidx.support.v7.widget.RecyclerView$OnChildAttachStateChangeListener> r0 = r3.A0l
            if (r0 == 0) goto L18
            r0 = 4
            goto Lc
        L18:
            r0 = 7
            goto Lc
        L1a:
            com.facebook.ads.redexgen.X.7a r3 = (com.facebook.ads.redexgen.X.C01807a) r3
            java.util.List<com.facebook.ads.internal.androidx.support.v7.widget.RecyclerView$OnChildAttachStateChangeListener> r0 = r3.A0l
            r0.get(r2)
            int r2 = r2 + (-1)
            r0 = 5
            goto Lc
        L25:
            com.facebook.ads.redexgen.X.7Z r1 = (com.facebook.ads.redexgen.X.C7Z) r1
            if (r1 == 0) goto L2b
            r0 = 3
            goto Lc
        L2b:
            r0 = 3
            goto Lc
        L2d:
            if (r2 < 0) goto L31
            r0 = 6
            goto Lc
        L31:
            r0 = 7
            goto Lc
        L33:
            com.facebook.ads.redexgen.X.7a r3 = (com.facebook.ads.redexgen.X.C01807a) r3
            java.util.List<com.facebook.ads.internal.androidx.support.v7.widget.RecyclerView$OnChildAttachStateChangeListener> r0 = r3.A0l
            int r0 = r0.size()
            int r2 = r0 + (-1)
            r0 = 5
            goto Lc
        L3f:
            r0 = 3
            goto Lc
        L41:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C01807a.A1X(android.view.View):void");
    }

    public final void A1Y(C7L c7l) {
        if (this.A0m == null) {
            this.A0m = new ArrayList();
        }
        this.A0m.add(c7l);
    }

    public final void A1Z(C7L c7l) {
        if (this.A0m != null) {
            this.A0m.remove(c7l);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x003a, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void A1a(com.facebook.ads.redexgen.X.C7W r5) {
        /*
            r4 = this;
            r3 = r4
            r0 = 0
            r0 = 0
            int r1 = r3.getScrollState()
            r0 = 2
            if (r1 != r0) goto L38
            r0 = 2
        Lb:
            switch(r0) {
                case 2: goto Lf;
                case 3: goto L3a;
                case 4: goto L2f;
                default: goto Le;
            }
        Le:
            goto Lb
        Lf:
            com.facebook.ads.redexgen.X.7a r3 = (com.facebook.ads.redexgen.X.C01807a) r3
            com.facebook.ads.redexgen.X.7W r5 = (com.facebook.ads.redexgen.X.C7W) r5
            com.facebook.ads.redexgen.X.7Y r0 = r3.A08
            android.widget.OverScroller r2 = r0.A01
            int r1 = r2.getFinalX()
            int r0 = r2.getCurrX()
            int r1 = r1 - r0
            r5.A06 = r1
            int r1 = r2.getFinalY()
            int r0 = r2.getCurrY()
            int r1 = r1 - r0
            r5.A07 = r1
            r0 = 3
            goto Lb
        L2f:
            com.facebook.ads.redexgen.X.7W r5 = (com.facebook.ads.redexgen.X.C7W) r5
            r0 = 0
            r5.A06 = r0
            r5.A07 = r0
            r0 = 3
            goto Lb
        L38:
            r0 = 4
            goto Lb
        L3a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C01807a.A1a(com.facebook.ads.redexgen.X.7W):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:38:0x0047, code lost:            r3.A0t.A0F(r5, r6);     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x0052, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void A1b(com.facebook.ads.redexgen.X.C7Z r5, com.facebook.ads.redexgen.X.C7C r6) {
        /*
            r4 = this;
            r3 = r4
            r1 = 0
            r0 = 8192(0x2000, float:1.148E-41)
            r5.A0U(r1, r0)
            com.facebook.ads.redexgen.X.7W r0 = r3.A0s
            boolean r0 = r0.A0E
            if (r0 == 0) goto L45
            r0 = 2
        Le:
            switch(r0) {
                case 2: goto L12;
                case 3: goto L2d;
                case 4: goto L39;
                case 5: goto L1e;
                case 6: goto L47;
                default: goto L11;
            }
        L11:
            goto Le
        L12:
            com.facebook.ads.redexgen.X.7Z r5 = (com.facebook.ads.redexgen.X.C7Z) r5
            boolean r0 = r5.A0f()
            if (r0 == 0) goto L1c
            r0 = 3
            goto Le
        L1c:
            r0 = 6
            goto Le
        L1e:
            com.facebook.ads.redexgen.X.7a r3 = (com.facebook.ads.redexgen.X.C01807a) r3
            com.facebook.ads.redexgen.X.7Z r5 = (com.facebook.ads.redexgen.X.C7Z) r5
            long r1 = r3.A01(r5)
            com.facebook.ads.redexgen.X.7k r0 = r3.A0t
            r0.A08(r1, r5)
            r0 = 6
            goto Le
        L2d:
            com.facebook.ads.redexgen.X.7Z r5 = (com.facebook.ads.redexgen.X.C7Z) r5
            boolean r0 = r5.A0c()
            if (r0 != 0) goto L37
            r0 = 4
            goto Le
        L37:
            r0 = 6
            goto Le
        L39:
            com.facebook.ads.redexgen.X.7Z r5 = (com.facebook.ads.redexgen.X.C7Z) r5
            boolean r0 = r5.A0h()
            if (r0 != 0) goto L43
            r0 = 5
            goto Le
        L43:
            r0 = 6
            goto Le
        L45:
            r0 = 6
            goto Le
        L47:
            com.facebook.ads.redexgen.X.7a r3 = (com.facebook.ads.redexgen.X.C01807a) r3
            com.facebook.ads.redexgen.X.7Z r5 = (com.facebook.ads.redexgen.X.C7Z) r5
            com.facebook.ads.redexgen.X.7C r6 = (com.facebook.ads.redexgen.X.C7C) r6
            com.facebook.ads.redexgen.X.7k r0 = r3.A0t
            r0.A0F(r5, r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C01807a.A1b(com.facebook.ads.redexgen.X.7Z, com.facebook.ads.redexgen.X.7C):void");
    }

    public final void A1c(@NonNull C7Z c7z, @Nullable C7C c7c, @NonNull C7C c7c2) {
        c7z.A0Z(false);
        if (this.A05.A0C(c7z, c7c, c7c2)) {
            A1C();
        }
    }

    public final void A1d(@NonNull C7Z c7z, @NonNull C7C c7c, @Nullable C7C c7c2) {
        A0h(c7z);
        c7z.A0Z(false);
        if (this.A05.A0D(c7z, c7c, c7c2)) {
            A1C();
        }
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:5:0x0008. Please report as an issue. */
    public final void A1e(String str) {
        C01807a c01807a = this;
        char c = c01807a.A1j() ? (char) 2 : (char) 5;
        while (true) {
            switch (c) {
                case 2:
                    str = str;
                    c = str == null ? (char) 3 : (char) 4;
                case 3:
                    throw new IllegalStateException(A08(1150, 77, 60) + c01807a.A17());
                case 4:
                    throw new IllegalStateException(str);
                case 5:
                    c01807a = c01807a;
                    c = c01807a.A0N > 0 ? (char) 6 : (char) 7;
                case 6:
                    c01807a = c01807a;
                    Log.w(A08(1788, 12, 70), A08(325, 280, 3), new IllegalStateException(A08(195, 0, 68) + c01807a.A17()));
                    c = 7;
                case 7:
                    return;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0028, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void A1f(boolean r4) {
        /*
            r3 = this;
            r2 = r3
            int r0 = r2.A0U
            int r0 = r0 + (-1)
            r2.A0U = r0
            int r1 = r2.A0U
            r0 = 1
            if (r1 >= r0) goto L26
            r0 = 2
        Ld:
            switch(r0) {
                case 2: goto L11;
                case 3: goto L1c;
                case 4: goto L28;
                default: goto L10;
            }
        L10:
            goto Ld
        L11:
            com.facebook.ads.redexgen.X.7a r2 = (com.facebook.ads.redexgen.X.C01807a) r2
            r0 = 0
            r2.A0U = r0
            if (r4 == 0) goto L1a
            r0 = 3
            goto Ld
        L1a:
            r0 = 4
            goto Ld
        L1c:
            com.facebook.ads.redexgen.X.7a r2 = (com.facebook.ads.redexgen.X.C01807a) r2
            r2.A0A()
            r2.A0P()
            r0 = 4
            goto Ld
        L26:
            r0 = 4
            goto Ld
        L28:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C01807a.A1f(boolean):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:90:0x0080, code lost:            r3 = r3;        r3.A0O--;     */
    /* JADX WARN: Code restructure failed: missing block: B:91:0x0088, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void A1g(boolean r5) {
        /*
            r4 = this;
            r3 = r4
            r0 = 0
            r0 = 0
            r2 = 0
            r1 = 1
            int r0 = r3.A0O
            if (r0 >= r1) goto L7e
            r0 = 2
        La:
            switch(r0) {
                case 2: goto L2d;
                case 3: goto L27;
                case 4: goto L19;
                case 5: goto Le;
                case 6: goto L20;
                case 7: goto L33;
                case 8: goto L3f;
                case 9: goto L4b;
                case 10: goto L5f;
                case 11: goto L57;
                case 12: goto L6b;
                case 13: goto L77;
                case 14: goto L80;
                default: goto Ld;
            }
        Ld:
            goto La
        Le:
            com.facebook.ads.redexgen.X.7a r3 = (com.facebook.ads.redexgen.X.C01807a) r3
            int r0 = r3.A0O
            if (r0 != r1) goto L16
            r0 = 6
            goto La
        L16:
            r0 = 14
            goto La
        L19:
            com.facebook.ads.redexgen.X.7a r3 = (com.facebook.ads.redexgen.X.C01807a) r3
            r2 = 0
            r3.A0J = r2
            r0 = 5
            goto La
        L20:
            if (r5 == 0) goto L24
            r0 = 7
            goto La
        L24:
            r0 = 12
            goto La
        L27:
            if (r5 != 0) goto L2b
            r0 = 4
            goto La
        L2b:
            r0 = 5
            goto La
        L2d:
            com.facebook.ads.redexgen.X.7a r3 = (com.facebook.ads.redexgen.X.C01807a) r3
            r3.A0O = r1
            r0 = 3
            goto La
        L33:
            com.facebook.ads.redexgen.X.7a r3 = (com.facebook.ads.redexgen.X.C01807a) r3
            boolean r0 = r3.A0J
            if (r0 == 0) goto L3c
            r0 = 8
            goto La
        L3c:
            r0 = 12
            goto La
        L3f:
            com.facebook.ads.redexgen.X.7a r3 = (com.facebook.ads.redexgen.X.C01807a) r3
            boolean r0 = r3.A0I
            if (r0 != 0) goto L48
            r0 = 9
            goto La
        L48:
            r0 = 12
            goto La
        L4b:
            com.facebook.ads.redexgen.X.7a r3 = (com.facebook.ads.redexgen.X.C01807a) r3
            com.facebook.ads.redexgen.X.6g r0 = r3.A06
            if (r0 == 0) goto L54
            r0 = 10
            goto La
        L54:
            r0 = 12
            goto La
        L57:
            com.facebook.ads.redexgen.X.7a r3 = (com.facebook.ads.redexgen.X.C01807a) r3
            r3.A0O()
            r0 = 12
            goto La
        L5f:
            com.facebook.ads.redexgen.X.7a r3 = (com.facebook.ads.redexgen.X.C01807a) r3
            com.facebook.ads.redexgen.X.2E r0 = r3.A04
            if (r0 == 0) goto L68
            r0 = 11
            goto La
        L68:
            r0 = 12
            goto La
        L6b:
            com.facebook.ads.redexgen.X.7a r3 = (com.facebook.ads.redexgen.X.C01807a) r3
            boolean r0 = r3.A0I
            if (r0 != 0) goto L74
            r0 = 13
            goto La
        L74:
            r0 = 14
            goto La
        L77:
            com.facebook.ads.redexgen.X.7a r3 = (com.facebook.ads.redexgen.X.C01807a) r3
            r3.A0J = r2
            r0 = 14
            goto La
        L7e:
            r0 = 3
            goto La
        L80:
            com.facebook.ads.redexgen.X.7a r3 = (com.facebook.ads.redexgen.X.C01807a) r3
            int r0 = r3.A0O
            int r0 = r0 + (-1)
            r3.A0O = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C01807a.A1g(boolean):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x0021, code lost:            return r1;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean A1h() {
        /*
            r3 = this;
            r2 = r3
            r1 = 0
            android.view.accessibility.AccessibilityManager r0 = r2.A10
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
            com.facebook.ads.redexgen.X.7a r2 = (com.facebook.ads.redexgen.X.C01807a) r2
            android.view.accessibility.AccessibilityManager r0 = r2.A10
            boolean r0 = r0.isEnabled()
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C01807a.A1h():boolean");
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x002b, code lost:            return r1;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean A1i() {
        /*
            r3 = this;
            r2 = r3
            r1 = 0
            boolean r0 = r2.A0D
            if (r0 == 0) goto L29
            r0 = 2
        L7:
            switch(r0) {
                case 2: goto Lb;
                case 3: goto L15;
                case 4: goto L23;
                case 5: goto L2b;
                case 6: goto L26;
                default: goto La;
            }
        La:
            goto L7
        Lb:
            com.facebook.ads.redexgen.X.7a r2 = (com.facebook.ads.redexgen.X.C01807a) r2
            boolean r0 = r2.A0C
            if (r0 != 0) goto L13
            r0 = 3
            goto L7
        L13:
            r0 = 4
            goto L7
        L15:
            com.facebook.ads.redexgen.X.7a r2 = (com.facebook.ads.redexgen.X.C01807a) r2
            com.facebook.ads.redexgen.X.6G r0 = r2.A00
            boolean r0 = r0.A0J()
            if (r0 == 0) goto L21
            r0 = 4
            goto L7
        L21:
            r0 = 6
            goto L7
        L23:
            r1 = 1
            r0 = 5
            goto L7
        L26:
            r1 = 0
            r0 = 5
            goto L7
        L29:
            r0 = 4
            goto L7
        L2b:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C01807a.A1i():boolean");
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0012, code lost:            return r1;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean A1j() {
        /*
            r2 = this;
            r1 = 0
            int r0 = r2.A0U
            if (r0 <= 0) goto L10
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C01807a.A1j():boolean");
    }

    public final boolean A1k(int i) {
        return getScrollingChildHelper().A09(i);
    }

    public final boolean A1l(int i, int i2) {
        return getScrollingChildHelper().A0B(i, i2);
    }

    public final boolean A1m(int i, int i2, int i3, int i4, int[] iArr, int i5) {
        return getScrollingChildHelper().A0D(i, i2, i3, i4, iArr, i5);
    }

    public final boolean A1n(int i, int i2, int[] iArr, int[] iArr2, int i3) {
        return getScrollingChildHelper().A0F(i, i2, iArr, iArr2, i3);
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x0035, code lost:            r4.A1g(r3);     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x003a, code lost:            return r2;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean A1o(android.view.View r6) {
        /*
            r5 = this;
            r4 = r5
            r0 = 0
            r3 = 0
            r4.A19()
            com.facebook.ads.redexgen.X.6J r0 = r4.A01
            boolean r2 = r0.A0L(r6)
            if (r2 == 0) goto L33
            r0 = 2
        Lf:
            switch(r0) {
                case 2: goto L13;
                case 3: goto L2d;
                case 4: goto L27;
                case 5: goto L35;
                case 6: goto L2a;
                default: goto L12;
            }
        L12:
            goto Lf
        L13:
            com.facebook.ads.redexgen.X.7a r4 = (com.facebook.ads.redexgen.X.C01807a) r4
            android.view.View r6 = (android.view.View) r6
            com.facebook.ads.redexgen.X.7Z r1 = A05(r6)
            com.facebook.ads.redexgen.X.7O r0 = r4.A0r
            r0.A0c(r1)
            com.facebook.ads.redexgen.X.7O r0 = r4.A0r
            r0.A0b(r1)
            r0 = 3
            goto Lf
        L27:
            r3 = 1
            r0 = 5
            goto Lf
        L2a:
            r3 = 0
            r0 = 5
            goto Lf
        L2d:
            if (r2 != 0) goto L31
            r0 = 4
            goto Lf
        L31:
            r0 = 6
            goto Lf
        L33:
            r0 = 3
            goto Lf
        L35:
            com.facebook.ads.redexgen.X.7a r4 = (com.facebook.ads.redexgen.X.C01807a) r4
            r4.A1g(r3)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C01807a.A1o(android.view.View):boolean");
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x0027, code lost:            return r2;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean A1p(com.facebook.ads.redexgen.X.C7Z r5) {
        /*
            r4 = this;
            r3 = r4
            r2 = 0
            com.facebook.ads.redexgen.X.6U r0 = r3.A05
            if (r0 == 0) goto L25
            r0 = 2
        L7:
            switch(r0) {
                case 2: goto Lb;
                case 3: goto L1f;
                case 4: goto L27;
                case 5: goto L22;
                default: goto La;
            }
        La:
            goto L7
        Lb:
            com.facebook.ads.redexgen.X.7a r3 = (com.facebook.ads.redexgen.X.C01807a) r3
            com.facebook.ads.redexgen.X.7Z r5 = (com.facebook.ads.redexgen.X.C7Z) r5
            com.facebook.ads.redexgen.X.6U r1 = r3.A05
            java.util.List r0 = r5.A0L()
            boolean r0 = r1.A0K(r5, r0)
            if (r0 == 0) goto L1d
            r0 = 3
            goto L7
        L1d:
            r0 = 5
            goto L7
        L1f:
            r2 = 1
            r0 = 4
            goto L7
        L22:
            r2 = 0
            r0 = 4
            goto L7
        L25:
            r0 = 3
            goto L7
        L27:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C01807a.A1p(com.facebook.ads.redexgen.X.7Z):boolean");
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0027, code lost:            return r1;     */
    @android.support.annotation.VisibleForTesting
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean A1q(com.facebook.ads.redexgen.X.C7Z r4, int r5) {
        /*
            r3 = this;
            r2 = r3
            r1 = 0
            boolean r0 = r2.A1j()
            if (r0 == 0) goto L25
            r0 = 2
        L9:
            switch(r0) {
                case 2: goto Ld;
                case 3: goto L27;
                case 4: goto L1b;
                default: goto Lc;
            }
        Lc:
            goto L9
        Ld:
            com.facebook.ads.redexgen.X.7a r2 = (com.facebook.ads.redexgen.X.C01807a) r2
            com.facebook.ads.redexgen.X.7Z r4 = (com.facebook.ads.redexgen.X.C7Z) r4
            r4.A02 = r5
            java.util.List<com.facebook.ads.redexgen.X.7Z> r0 = r2.A0w
            r0.add(r4)
            r1 = 0
            r0 = 3
            goto L9
        L1b:
            com.facebook.ads.redexgen.X.7Z r4 = (com.facebook.ads.redexgen.X.C7Z) r4
            android.view.View r0 = r4.A0H
            com.facebook.ads.redexgen.X.C5B.A09(r0, r5)
            r1 = 1
            r0 = 3
            goto L9
        L25:
            r0 = 4
            goto L9
        L27:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C01807a.A1q(com.facebook.ads.redexgen.X.7Z, int):boolean");
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0025, code lost:            return;     */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void addFocusables(java.util.ArrayList<android.view.View> r3, int r4, int r5) {
        /*
            r2 = this;
            r1 = r2
            com.facebook.ads.redexgen.X.6g r0 = r1.A06
            if (r0 == 0) goto L23
            r0 = 2
        L6:
            switch(r0) {
                case 2: goto La;
                case 3: goto L1a;
                case 4: goto L25;
                default: goto L9;
            }
        L9:
            goto L6
        La:
            com.facebook.ads.redexgen.X.7a r1 = (com.facebook.ads.redexgen.X.C01807a) r1
            java.util.ArrayList r3 = (java.util.ArrayList) r3
            com.facebook.ads.redexgen.X.6g r0 = r1.A06
            boolean r0 = r0.A1g(r1, r3, r4, r5)
            if (r0 != 0) goto L18
            r0 = 3
            goto L6
        L18:
            r0 = 4
            goto L6
        L1a:
            com.facebook.ads.redexgen.X.7a r1 = (com.facebook.ads.redexgen.X.C01807a) r1
            java.util.ArrayList r3 = (java.util.ArrayList) r3
            super.addFocusables(r3, r4, r5)
            r0 = 4
            goto L6
        L23:
            r0 = 3
            goto L6
        L25:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C01807a.addFocusables(java.util.ArrayList, int, int):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x0026, code lost:            return r2;     */
    @Override // android.view.ViewGroup
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean checkLayoutParams(android.view.ViewGroup.LayoutParams r5) {
        /*
            r4 = this;
            r3 = r4
            r2 = 0
            boolean r0 = r5 instanceof com.facebook.ads.redexgen.X.C01596e
            if (r0 == 0) goto L24
            r0 = 2
        L7:
            switch(r0) {
                case 2: goto Lb;
                case 3: goto L1e;
                case 4: goto L26;
                case 5: goto L21;
                default: goto La;
            }
        La:
            goto L7
        Lb:
            com.facebook.ads.redexgen.X.7a r3 = (com.facebook.ads.redexgen.X.C01807a) r3
            android.view.ViewGroup$LayoutParams r5 = (android.view.ViewGroup.LayoutParams) r5
            com.facebook.ads.redexgen.X.6g r1 = r3.A06
            r0 = r5
            com.facebook.ads.redexgen.X.6e r0 = (com.facebook.ads.redexgen.X.C01596e) r0
            boolean r0 = r1.A1c(r0)
            if (r0 == 0) goto L1c
            r0 = 3
            goto L7
        L1c:
            r0 = 5
            goto L7
        L1e:
            r2 = 1
            r0 = 4
            goto L7
        L21:
            r2 = 0
            r0 = 4
            goto L7
        L24:
            r0 = 5
            goto L7
        L26:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C01807a.checkLayoutParams(android.view.ViewGroup$LayoutParams):boolean");
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0028, code lost:            return r1;     */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int computeHorizontalScrollExtent() {
        /*
            r3 = this;
            r2 = r3
            r0 = 0
            r1 = 0
            com.facebook.ads.redexgen.X.6g r0 = r2.A06
            if (r0 != 0) goto L26
            r0 = 2
        L8:
            switch(r0) {
                case 2: goto L28;
                case 3: goto Lc;
                case 4: goto L1a;
                default: goto Lb;
            }
        Lb:
            goto L8
        Lc:
            com.facebook.ads.redexgen.X.7a r2 = (com.facebook.ads.redexgen.X.C01807a) r2
            com.facebook.ads.redexgen.X.6g r0 = r2.A06
            boolean r0 = r0.A24()
            if (r0 == 0) goto L18
            r0 = 4
            goto L8
        L18:
            r0 = 2
            goto L8
        L1a:
            com.facebook.ads.redexgen.X.7a r2 = (com.facebook.ads.redexgen.X.C01807a) r2
            com.facebook.ads.redexgen.X.6g r1 = r2.A06
            com.facebook.ads.redexgen.X.7W r0 = r2.A0s
            int r1 = r1.A1j(r0)
            r0 = 2
            goto L8
        L26:
            r0 = 3
            goto L8
        L28:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C01807a.computeHorizontalScrollExtent():int");
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0028, code lost:            return r1;     */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int computeHorizontalScrollOffset() {
        /*
            r3 = this;
            r2 = r3
            r0 = 0
            r1 = 0
            com.facebook.ads.redexgen.X.6g r0 = r2.A06
            if (r0 != 0) goto L26
            r0 = 2
        L8:
            switch(r0) {
                case 2: goto L28;
                case 3: goto Lc;
                case 4: goto L1a;
                default: goto Lb;
            }
        Lb:
            goto L8
        Lc:
            com.facebook.ads.redexgen.X.7a r2 = (com.facebook.ads.redexgen.X.C01807a) r2
            com.facebook.ads.redexgen.X.6g r0 = r2.A06
            boolean r0 = r0.A24()
            if (r0 == 0) goto L18
            r0 = 4
            goto L8
        L18:
            r0 = 2
            goto L8
        L1a:
            com.facebook.ads.redexgen.X.7a r2 = (com.facebook.ads.redexgen.X.C01807a) r2
            com.facebook.ads.redexgen.X.6g r1 = r2.A06
            com.facebook.ads.redexgen.X.7W r0 = r2.A0s
            int r1 = r1.A1k(r0)
            r0 = 2
            goto L8
        L26:
            r0 = 3
            goto L8
        L28:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C01807a.computeHorizontalScrollOffset():int");
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0028, code lost:            return r1;     */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int computeHorizontalScrollRange() {
        /*
            r3 = this;
            r2 = r3
            r0 = 0
            r1 = 0
            com.facebook.ads.redexgen.X.6g r0 = r2.A06
            if (r0 != 0) goto L26
            r0 = 2
        L8:
            switch(r0) {
                case 2: goto L28;
                case 3: goto Lc;
                case 4: goto L1a;
                default: goto Lb;
            }
        Lb:
            goto L8
        Lc:
            com.facebook.ads.redexgen.X.7a r2 = (com.facebook.ads.redexgen.X.C01807a) r2
            com.facebook.ads.redexgen.X.6g r0 = r2.A06
            boolean r0 = r0.A24()
            if (r0 == 0) goto L18
            r0 = 4
            goto L8
        L18:
            r0 = 2
            goto L8
        L1a:
            com.facebook.ads.redexgen.X.7a r2 = (com.facebook.ads.redexgen.X.C01807a) r2
            com.facebook.ads.redexgen.X.6g r1 = r2.A06
            com.facebook.ads.redexgen.X.7W r0 = r2.A0s
            int r1 = r1.A1l(r0)
            r0 = 2
            goto L8
        L26:
            r0 = 3
            goto L8
        L28:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C01807a.computeHorizontalScrollRange():int");
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0028, code lost:            return r1;     */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int computeVerticalScrollExtent() {
        /*
            r3 = this;
            r2 = r3
            r0 = 0
            r1 = 0
            com.facebook.ads.redexgen.X.6g r0 = r2.A06
            if (r0 != 0) goto L26
            r0 = 2
        L8:
            switch(r0) {
                case 2: goto L28;
                case 3: goto Lc;
                case 4: goto L1a;
                default: goto Lb;
            }
        Lb:
            goto L8
        Lc:
            com.facebook.ads.redexgen.X.7a r2 = (com.facebook.ads.redexgen.X.C01807a) r2
            com.facebook.ads.redexgen.X.6g r0 = r2.A06
            boolean r0 = r0.A25()
            if (r0 == 0) goto L18
            r0 = 4
            goto L8
        L18:
            r0 = 2
            goto L8
        L1a:
            com.facebook.ads.redexgen.X.7a r2 = (com.facebook.ads.redexgen.X.C01807a) r2
            com.facebook.ads.redexgen.X.6g r1 = r2.A06
            com.facebook.ads.redexgen.X.7W r0 = r2.A0s
            int r1 = r1.A1m(r0)
            r0 = 2
            goto L8
        L26:
            r0 = 3
            goto L8
        L28:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C01807a.computeVerticalScrollExtent():int");
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0028, code lost:            return r1;     */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int computeVerticalScrollOffset() {
        /*
            r3 = this;
            r2 = r3
            r0 = 0
            r1 = 0
            com.facebook.ads.redexgen.X.6g r0 = r2.A06
            if (r0 != 0) goto L26
            r0 = 2
        L8:
            switch(r0) {
                case 2: goto L28;
                case 3: goto L18;
                case 4: goto Lc;
                default: goto Lb;
            }
        Lb:
            goto L8
        Lc:
            com.facebook.ads.redexgen.X.7a r2 = (com.facebook.ads.redexgen.X.C01807a) r2
            com.facebook.ads.redexgen.X.6g r1 = r2.A06
            com.facebook.ads.redexgen.X.7W r0 = r2.A0s
            int r1 = r1.A1n(r0)
            r0 = 2
            goto L8
        L18:
            com.facebook.ads.redexgen.X.7a r2 = (com.facebook.ads.redexgen.X.C01807a) r2
            com.facebook.ads.redexgen.X.6g r0 = r2.A06
            boolean r0 = r0.A25()
            if (r0 == 0) goto L24
            r0 = 4
            goto L8
        L24:
            r0 = 2
            goto L8
        L26:
            r0 = 3
            goto L8
        L28:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C01807a.computeVerticalScrollOffset():int");
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0028, code lost:            return r1;     */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int computeVerticalScrollRange() {
        /*
            r3 = this;
            r2 = r3
            r0 = 0
            r1 = 0
            com.facebook.ads.redexgen.X.6g r0 = r2.A06
            if (r0 != 0) goto L26
            r0 = 2
        L8:
            switch(r0) {
                case 2: goto L28;
                case 3: goto L18;
                case 4: goto Lc;
                default: goto Lb;
            }
        Lb:
            goto L8
        Lc:
            com.facebook.ads.redexgen.X.7a r2 = (com.facebook.ads.redexgen.X.C01807a) r2
            com.facebook.ads.redexgen.X.6g r1 = r2.A06
            com.facebook.ads.redexgen.X.7W r0 = r2.A0s
            int r1 = r1.A1o(r0)
            r0 = 2
            goto L8
        L18:
            com.facebook.ads.redexgen.X.7a r2 = (com.facebook.ads.redexgen.X.C01807a) r2
            com.facebook.ads.redexgen.X.6g r0 = r2.A06
            boolean r0 = r0.A25()
            if (r0 == 0) goto L24
            r0 = 4
            goto L8
        L24:
            r0 = 2
            goto L8
        L26:
            r0 = 3
            goto L8
        L28:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C01807a.computeVerticalScrollRange():int");
    }

    @Override // android.view.View
    public final boolean dispatchNestedFling(float f, float f2, boolean z) {
        return getScrollingChildHelper().A08(f, f2, z);
    }

    @Override // android.view.View
    public final boolean dispatchNestedPreFling(float f, float f2) {
        return getScrollingChildHelper().A07(f, f2);
    }

    @Override // android.view.View
    public final boolean dispatchNestedPreScroll(int i, int i2, int[] iArr, int[] iArr2) {
        return getScrollingChildHelper().A0E(i, i2, iArr, iArr2);
    }

    @Override // android.view.View
    public final boolean dispatchNestedScroll(int i, int i2, int i3, int i4, int[] iArr) {
        return getScrollingChildHelper().A0C(i, i2, i3, i4, iArr);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchRestoreInstanceState(SparseArray<Parcelable> container) {
        dispatchThawSelfOnly(container);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchSaveInstanceState(SparseArray<Parcelable> container) {
        dispatchFreezeSelfOnly(container);
    }

    /* JADX WARN: Code restructure failed: missing block: B:299:0x02b9, code lost:            return;     */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void draw(android.graphics.Canvas r19) {
        /*
            Method dump skipped, instructions count: 798
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C01807a.draw(android.graphics.Canvas):void");
    }

    @Override // android.view.ViewGroup
    public final boolean drawChild(Canvas canvas, View view, long j) {
        return super.drawChild(canvas, view, j);
    }

    /* JADX WARN: Code restructure failed: missing block: B:330:0x026a, code lost:            return r9;     */
    @Override // android.view.ViewGroup, android.view.ViewParent
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final android.view.View focusSearch(android.view.View r17, int r18) {
        /*
            Method dump skipped, instructions count: 734
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C01807a.focusSearch(android.view.View, int):android.view.View");
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateDefaultLayoutParams() {
        if (this.A06 == null) {
            throw new IllegalStateException(A08(1755, 33, 23) + A17());
        }
        return this.A06.A1s();
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        if (this.A06 == null) {
            throw new IllegalStateException(A08(1755, 33, 23) + A17());
        }
        return this.A06.A0v(getContext(), attributeSet);
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (this.A06 == null) {
            throw new IllegalStateException(A08(1755, 33, 23) + A17());
        }
        return this.A06.A0w(layoutParams);
    }

    public C2E getAdapter() {
        return this.A04;
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x001f, code lost:            return r1;     */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int getBaseline() {
        /*
            r3 = this;
            r2 = r3
            r1 = 0
            com.facebook.ads.redexgen.X.6g r0 = r2.A06
            if (r0 == 0) goto L1d
            r0 = 2
        L7:
            switch(r0) {
                case 2: goto Lb;
                case 3: goto L1f;
                case 4: goto L15;
                default: goto La;
            }
        La:
            goto L7
        Lb:
            com.facebook.ads.redexgen.X.7a r2 = (com.facebook.ads.redexgen.X.C01807a) r2
            com.facebook.ads.redexgen.X.6g r0 = r2.A06
            int r1 = r0.A0V()
            r0 = 3
            goto L7
        L15:
            com.facebook.ads.redexgen.X.7a r2 = (com.facebook.ads.redexgen.X.C01807a) r2
            int r1 = super.getBaseline()
            r0 = 3
            goto L7
        L1d:
            r0 = 4
            goto L7
        L1f:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C01807a.getBaseline():int");
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x001f, code lost:            return r1;     */
    @Override // android.view.ViewGroup
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int getChildDrawingOrder(int r4, int r5) {
        /*
            r3 = this;
            r2 = r3
            r1 = 0
            com.facebook.ads.redexgen.X.78 r0 = r2.A0e
            if (r0 != 0) goto L1d
            r0 = 2
        L7:
            switch(r0) {
                case 2: goto Lb;
                case 3: goto L1f;
                case 4: goto L13;
                default: goto La;
            }
        La:
            goto L7
        Lb:
            com.facebook.ads.redexgen.X.7a r2 = (com.facebook.ads.redexgen.X.C01807a) r2
            int r1 = super.getChildDrawingOrder(r4, r5)
            r0 = 3
            goto L7
        L13:
            com.facebook.ads.redexgen.X.7a r2 = (com.facebook.ads.redexgen.X.C01807a) r2
            com.facebook.ads.redexgen.X.78 r0 = r2.A0e
            int r1 = r0.onGetChildDrawingOrder(r4, r5)
            r0 = 3
            goto L7
        L1d:
            r0 = 4
            goto L7
        L1f:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C01807a.getChildDrawingOrder(int, int):int");
    }

    @Override // android.view.ViewGroup
    public boolean getClipToPadding() {
        return this.A0B;
    }

    public C01827c getCompatAccessibilityDelegate() {
        return this.A09;
    }

    public C6U getItemAnimator() {
        return this.A05;
    }

    public AbstractC01616g getLayoutManager() {
        return this.A06;
    }

    public int getMaxFlingVelocity() {
        return this.A0x;
    }

    public int getMinFlingVelocity() {
        return this.A0y;
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0017, code lost:            return r1;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public long getNanoTime() {
        /*
            r3 = this;
            r1 = 0
            boolean r0 = com.facebook.ads.redexgen.X.C01807a.A1D
            if (r0 == 0) goto L15
            r0 = 2
        L7:
            switch(r0) {
                case 2: goto Lb;
                case 3: goto L17;
                case 4: goto L11;
                default: goto La;
            }
        La:
            goto L7
        Lb:
            long r1 = java.lang.System.nanoTime()
            r0 = 3
            goto L7
        L11:
            r1 = 0
            r0 = 3
            goto L7
        L15:
            r0 = 4
            goto L7
        L17:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C01807a.getNanoTime():long");
    }

    @Nullable
    public AbstractC01766w getOnFlingListener() {
        return this.A0g;
    }

    public boolean getPreserveFocusAfterLayout() {
        return this.A0o;
    }

    public C7N getRecycledViewPool() {
        return this.A0r.A0H();
    }

    public int getScrollState() {
        return this.A0W;
    }

    private C01164j getScrollingChildHelper() {
        if (this.A0d == null) {
            this.A0d = new C01164j(this);
        }
        return this.A0d;
    }

    @Override // android.view.View
    public final boolean hasNestedScrollingParent() {
        return getScrollingChildHelper().A05();
    }

    @Override // android.view.View
    public final boolean isAttachedToWindow() {
        return this.A0F;
    }

    @Override // android.view.View
    public final boolean isNestedScrollingEnabled() {
        return getScrollingChildHelper().A06();
    }

    /* JADX WARN: Code restructure failed: missing block: B:86:0x00c1, code lost:            return;     */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void onAttachedToWindow() {
        /*
            Method dump skipped, instructions count: 224
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C01807a.onAttachedToWindow():void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:44:0x0065, code lost:            return;     */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void onDetachedFromWindow() {
        /*
            r3 = this;
            r2 = r3
            super.onDetachedFromWindow()
            com.facebook.ads.redexgen.X.6U r0 = r2.A05
            if (r0 == 0) goto L63
            r0 = 2
        L9:
            switch(r0) {
                case 2: goto L4d;
                case 3: goto L3d;
                case 4: goto L32;
                case 5: goto L18;
                case 6: goto Ld;
                case 7: goto L56;
                case 8: goto L65;
                default: goto Lc;
            }
        Lc:
            goto L9
        Ld:
            com.facebook.ads.redexgen.X.7a r2 = (com.facebook.ads.redexgen.X.C01807a) r2
            com.facebook.ads.redexgen.X.6b r0 = r2.A03
            if (r0 == 0) goto L15
            r0 = 7
            goto L9
        L15:
            r0 = 8
            goto L9
        L18:
            com.facebook.ads.redexgen.X.7a r2 = (com.facebook.ads.redexgen.X.C01807a) r2
            java.util.List<com.facebook.ads.redexgen.X.7Z> r0 = r2.A0w
            r0.clear()
            java.lang.Runnable r0 = r2.A0k
            r2.removeCallbacks(r0)
            com.facebook.ads.redexgen.X.7k r0 = r2.A0t
            r0.A07()
            boolean r0 = com.facebook.ads.redexgen.X.C01807a.A1D
            if (r0 == 0) goto L2f
            r0 = 6
            goto L9
        L2f:
            r0 = 8
            goto L9
        L32:
            com.facebook.ads.redexgen.X.7a r2 = (com.facebook.ads.redexgen.X.C01807a) r2
            com.facebook.ads.redexgen.X.6g r1 = r2.A06
            com.facebook.ads.redexgen.X.7O r0 = r2.A0r
            r1.A1U(r2, r0)
            r0 = 5
            goto L9
        L3d:
            com.facebook.ads.redexgen.X.7a r2 = (com.facebook.ads.redexgen.X.C01807a) r2
            r2.A1G()
            r0 = 0
            r2.A0F = r0
            com.facebook.ads.redexgen.X.6g r0 = r2.A06
            if (r0 == 0) goto L4b
            r0 = 4
            goto L9
        L4b:
            r0 = 5
            goto L9
        L4d:
            com.facebook.ads.redexgen.X.7a r2 = (com.facebook.ads.redexgen.X.C01807a) r2
            com.facebook.ads.redexgen.X.6U r0 = r2.A05
            r0.A0G()
            r0 = 3
            goto L9
        L56:
            com.facebook.ads.redexgen.X.7a r2 = (com.facebook.ads.redexgen.X.C01807a) r2
            com.facebook.ads.redexgen.X.6b r0 = r2.A03
            r0.A0A(r2)
            r0 = 0
            r2.A03 = r0
            r0 = 8
            goto L9
        L63:
            r0 = 3
            goto L9
        L65:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C01807a.onDetachedFromWindow():void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0023, code lost:            return;     */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void onDraw(android.graphics.Canvas r5) {
        /*
            r4 = this;
            r3 = r4
            r0 = 0
            r0 = 0
            super.onDraw(r5)
            java.util.ArrayList<com.facebook.ads.redexgen.X.7E> r0 = r3.A0v
            int r2 = r0.size()
            r1 = 0
            r0 = 2
        Le:
            switch(r0) {
                case 2: goto L12;
                case 3: goto L18;
                case 4: goto L23;
                default: goto L11;
            }
        L11:
            goto Le
        L12:
            if (r1 >= r2) goto L16
            r0 = 3
            goto Le
        L16:
            r0 = 4
            goto Le
        L18:
            com.facebook.ads.redexgen.X.7a r3 = (com.facebook.ads.redexgen.X.C01807a) r3
            java.util.ArrayList<com.facebook.ads.redexgen.X.7E> r0 = r3.A0v
            r0.get(r1)
            int r1 = r1 + 1
            r0 = 2
            goto Le
        L23:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C01807a.onDraw(android.graphics.Canvas):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:125:0x00f9, code lost:            return false;     */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean onGenericMotionEvent(android.view.MotionEvent r8) {
        /*
            Method dump skipped, instructions count: 296
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C01807a.onGenericMotionEvent(android.view.MotionEvent):boolean");
    }

    /* JADX WARN: Code restructure failed: missing block: B:224:0x026a, code lost:            return r11;     */
    @Override // android.view.ViewGroup
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean onInterceptTouchEvent(android.view.MotionEvent r18) {
        /*
            Method dump skipped, instructions count: 714
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C01807a.onInterceptTouchEvent(android.view.MotionEvent):boolean");
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        C4H.A01(A08(139, 11, 2));
        A0O();
        C4H.A00();
        this.A0D = true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:151:0x018f, code lost:            return;     */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onMeasure(int r9, int r10) {
        /*
            Method dump skipped, instructions count: 454
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C01807a.onMeasure(int, int):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x001c, code lost:            return r1;     */
    @Override // android.view.ViewGroup
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean onRequestFocusInDescendants(int r4, android.graphics.Rect r5) {
        /*
            r3 = this;
            r2 = r3
            r1 = 0
            boolean r0 = r2.A1j()
            if (r0 == 0) goto L1a
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
            com.facebook.ads.redexgen.X.7a r2 = (com.facebook.ads.redexgen.X.C01807a) r2
            android.graphics.Rect r5 = (android.graphics.Rect) r5
            boolean r1 = super.onRequestFocusInDescendants(r4, r5)
            r0 = 3
            goto L9
        L1a:
            r0 = 4
            goto L9
        L1c:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C01807a.onRequestFocusInDescendants(int, android.graphics.Rect):boolean");
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x0048, code lost:            return;     */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void onRestoreInstanceState(android.os.Parcelable r4) {
        /*
            r3 = this;
            r2 = r3
            boolean r0 = r4 instanceof com.facebook.ads.internal.androidx.support.v7.widget.RecyclerView$SavedState
            if (r0 != 0) goto L46
            r0 = 2
        L6:
            switch(r0) {
                case 2: goto La;
                case 3: goto L48;
                case 4: goto L13;
                case 5: goto L2d;
                case 6: goto L39;
                default: goto L9;
            }
        L9:
            goto L6
        La:
            com.facebook.ads.redexgen.X.7a r2 = (com.facebook.ads.redexgen.X.C01807a) r2
            android.os.Parcelable r4 = (android.os.Parcelable) r4
            super.onRestoreInstanceState(r4)
            r0 = 3
            goto L6
        L13:
            com.facebook.ads.redexgen.X.7a r2 = (com.facebook.ads.redexgen.X.C01807a) r2
            android.os.Parcelable r4 = (android.os.Parcelable) r4
            r0 = r4
            com.facebook.ads.internal.androidx.support.v7.widget.RecyclerView$SavedState r0 = (com.facebook.ads.internal.androidx.support.v7.widget.RecyclerView$SavedState) r0
            r2.A0j = r0
            com.facebook.ads.internal.androidx.support.v7.widget.RecyclerView$SavedState r0 = r2.A0j
            android.os.Parcelable r0 = r0.A02()
            super.onRestoreInstanceState(r0)
            com.facebook.ads.redexgen.X.6g r0 = r2.A06
            if (r0 == 0) goto L2b
            r0 = 5
            goto L6
        L2b:
            r0 = 3
            goto L6
        L2d:
            com.facebook.ads.redexgen.X.7a r2 = (com.facebook.ads.redexgen.X.C01807a) r2
            com.facebook.ads.internal.androidx.support.v7.widget.RecyclerView$SavedState r0 = r2.A0j
            android.os.Parcelable r0 = r0.A00
            if (r0 == 0) goto L37
            r0 = 6
            goto L6
        L37:
            r0 = 3
            goto L6
        L39:
            com.facebook.ads.redexgen.X.7a r2 = (com.facebook.ads.redexgen.X.C01807a) r2
            com.facebook.ads.redexgen.X.6g r1 = r2.A06
            com.facebook.ads.internal.androidx.support.v7.widget.RecyclerView$SavedState r0 = r2.A0j
            android.os.Parcelable r0 = r0.A00
            r1.A1w(r0)
            r0 = 3
            goto L6
        L46:
            r0 = 4
            goto L6
        L48:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C01807a.onRestoreInstanceState(android.os.Parcelable):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x0044, code lost:            return r1;     */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final android.os.Parcelable onSaveInstanceState() {
        /*
            r3 = this;
            r2 = r3
            r0 = 0
            com.facebook.ads.internal.androidx.support.v7.widget.RecyclerView$SavedState r1 = new com.facebook.ads.internal.androidx.support.v7.widget.RecyclerView$SavedState
            android.os.Parcelable r0 = super.onSaveInstanceState()
            r1.<init>(r0)
            com.facebook.ads.internal.androidx.support.v7.widget.RecyclerView$SavedState r0 = r2.A0j
            if (r0 == 0) goto L3e
            r0 = 2
        L10:
            switch(r0) {
                case 2: goto L14;
                case 3: goto L40;
                case 4: goto L1f;
                case 5: goto L29;
                case 6: goto L37;
                default: goto L13;
            }
        L13:
            goto L10
        L14:
            com.facebook.ads.redexgen.X.7a r2 = (com.facebook.ads.redexgen.X.C01807a) r2
            com.facebook.ads.internal.androidx.support.v7.widget.RecyclerView$SavedState r1 = (com.facebook.ads.internal.androidx.support.v7.widget.RecyclerView$SavedState) r1
            com.facebook.ads.internal.androidx.support.v7.widget.RecyclerView$SavedState r0 = r2.A0j
            r1.A03(r0)
            r0 = 3
            goto L10
        L1f:
            com.facebook.ads.redexgen.X.7a r2 = (com.facebook.ads.redexgen.X.C01807a) r2
            com.facebook.ads.redexgen.X.6g r0 = r2.A06
            if (r0 == 0) goto L27
            r0 = 5
            goto L10
        L27:
            r0 = 6
            goto L10
        L29:
            com.facebook.ads.redexgen.X.7a r2 = (com.facebook.ads.redexgen.X.C01807a) r2
            com.facebook.ads.internal.androidx.support.v7.widget.RecyclerView$SavedState r1 = (com.facebook.ads.internal.androidx.support.v7.widget.RecyclerView$SavedState) r1
            com.facebook.ads.redexgen.X.6g r0 = r2.A06
            android.os.Parcelable r0 = r0.A1p()
            r1.A00 = r0
            r0 = 3
            goto L10
        L37:
            com.facebook.ads.internal.androidx.support.v7.widget.RecyclerView$SavedState r1 = (com.facebook.ads.internal.androidx.support.v7.widget.RecyclerView$SavedState) r1
            r0 = 0
            r1.A00 = r0
            r0 = 3
            goto L10
        L3e:
            r0 = 4
            goto L10
        L40:
            com.facebook.ads.internal.androidx.support.v7.widget.RecyclerView$SavedState r1 = (com.facebook.ads.internal.androidx.support.v7.widget.RecyclerView$SavedState) r1
            android.os.Parcelable r1 = (android.os.Parcelable) r1
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C01807a.onSaveInstanceState():android.os.Parcelable");
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x001a, code lost:            return;     */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void onSizeChanged(int r3, int r4, int r5, int r6) {
        /*
            r2 = this;
            r1 = r2
            super.onSizeChanged(r3, r4, r5, r6)
            if (r3 != r5) goto L18
            r0 = 2
        L7:
            switch(r0) {
                case 2: goto Lb;
                case 3: goto L11;
                case 4: goto L1a;
                default: goto La;
            }
        La:
            goto L7
        Lb:
            if (r4 == r6) goto Lf
            r0 = 3
            goto L7
        Lf:
            r0 = 4
            goto L7
        L11:
            com.facebook.ads.redexgen.X.7a r1 = (com.facebook.ads.redexgen.X.C01807a) r1
            r1.A0V()
            r0 = 4
            goto L7
        L18:
            r0 = 3
            goto L7
        L1a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C01807a.onSizeChanged(int, int, int, int):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:397:0x0428, code lost:            return r21;     */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean onTouchEvent(android.view.MotionEvent r32) {
        /*
            Method dump skipped, instructions count: 1220
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C01807a.onTouchEvent(android.view.MotionEvent):boolean");
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:5:0x0008. Please report as an issue. */
    @Override // android.view.ViewGroup
    public final void removeDetachedView(View view, boolean z) {
        C7Z A05 = A05(view);
        char c = A05 != null ? (char) 2 : (char) 4;
        while (true) {
            switch (c) {
                case 2:
                    A05 = A05;
                    c = A05.A0e() ? (char) 3 : (char) 5;
                case 3:
                    A05 = A05;
                    A05.A0P();
                    c = 4;
                case 4:
                    C01807a c01807a = this;
                    View view2 = view;
                    view2.clearAnimation();
                    c01807a.A1X(view2);
                    super.removeDetachedView(view2, z);
                    return;
                case 5:
                    A05 = A05;
                    c = !A05.A0h() ? (char) 6 : (char) 4;
                case 6:
                    throw new IllegalArgumentException(A08(44, 75, 14) + A05 + A17());
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0025, code lost:            super.requestChildFocus(r4, r5);     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x002e, code lost:            return;     */
    @Override // android.view.ViewGroup, android.view.ViewParent
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void requestChildFocus(android.view.View r4, android.view.View r5) {
        /*
            r3 = this;
            r2 = r3
            com.facebook.ads.redexgen.X.6g r1 = r2.A06
            com.facebook.ads.redexgen.X.7W r0 = r2.A0s
            boolean r0 = r1.A1f(r2, r0, r4, r5)
            if (r0 != 0) goto L23
            r0 = 2
        Lc:
            switch(r0) {
                case 2: goto L10;
                case 3: goto L18;
                case 4: goto L25;
                default: goto Lf;
            }
        Lf:
            goto Lc
        L10:
            android.view.View r5 = (android.view.View) r5
            if (r5 == 0) goto L16
            r0 = 3
            goto Lc
        L16:
            r0 = 4
            goto Lc
        L18:
            com.facebook.ads.redexgen.X.7a r2 = (com.facebook.ads.redexgen.X.C01807a) r2
            android.view.View r4 = (android.view.View) r4
            android.view.View r5 = (android.view.View) r5
            r2.A0f(r4, r5)
            r0 = 4
            goto Lc
        L23:
            r0 = 4
            goto Lc
        L25:
            com.facebook.ads.redexgen.X.7a r2 = (com.facebook.ads.redexgen.X.C01807a) r2
            android.view.View r4 = (android.view.View) r4
            android.view.View r5 = (android.view.View) r5
            super.requestChildFocus(r4, r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C01807a.requestChildFocus(android.view.View, android.view.View):void");
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z) {
        return this.A06.A1d(this, view, rect, z);
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0020, code lost:            super.requestDisallowInterceptTouchEvent(r5);     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0025, code lost:            return;     */
    @Override // android.view.ViewGroup, android.view.ViewParent
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void requestDisallowInterceptTouchEvent(boolean r5) {
        /*
            r4 = this;
            r3 = r4
            r0 = 0
            r0 = 0
            java.util.ArrayList<com.facebook.ads.redexgen.X.7K> r0 = r3.A13
            int r2 = r0.size()
            r1 = 0
            r0 = 2
        Lb:
            switch(r0) {
                case 2: goto Lf;
                case 3: goto L15;
                case 4: goto L20;
                default: goto Le;
            }
        Le:
            goto Lb
        Lf:
            if (r1 >= r2) goto L13
            r0 = 3
            goto Lb
        L13:
            r0 = 4
            goto Lb
        L15:
            com.facebook.ads.redexgen.X.7a r3 = (com.facebook.ads.redexgen.X.C01807a) r3
            java.util.ArrayList<com.facebook.ads.redexgen.X.7K> r0 = r3.A13
            r0.get(r1)
            int r1 = r1 + 1
            r0 = 2
            goto Lb
        L20:
            com.facebook.ads.redexgen.X.7a r3 = (com.facebook.ads.redexgen.X.C01807a) r3
            super.requestDisallowInterceptTouchEvent(r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C01807a.requestDisallowInterceptTouchEvent(boolean):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x0024, code lost:            return;     */
    @Override // android.view.View, android.view.ViewParent
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void requestLayout() {
        /*
            r2 = this;
            r1 = r2
            int r0 = r1.A0O
            if (r0 != 0) goto L22
            r0 = 2
        L6:
            switch(r0) {
                case 2: goto La;
                case 3: goto L14;
                case 4: goto L24;
                case 5: goto L1b;
                default: goto L9;
            }
        L9:
            goto L6
        La:
            com.facebook.ads.redexgen.X.7a r1 = (com.facebook.ads.redexgen.X.C01807a) r1
            boolean r0 = r1.A0I
            if (r0 != 0) goto L12
            r0 = 3
            goto L6
        L12:
            r0 = 5
            goto L6
        L14:
            com.facebook.ads.redexgen.X.7a r1 = (com.facebook.ads.redexgen.X.C01807a) r1
            super.requestLayout()
            r0 = 4
            goto L6
        L1b:
            com.facebook.ads.redexgen.X.7a r1 = (com.facebook.ads.redexgen.X.C01807a) r1
            r0 = 1
            r1.A0J = r0
            r0 = 4
            goto L6
        L22:
            r0 = 5
            goto L6
        L24:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C01807a.requestLayout():void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:62:0x006d, code lost:            return;     */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void scrollBy(int r8, int r9) {
        /*
            r7 = this;
            r4 = r7
            r6 = 0
            r0 = 0
            r5 = 0
            r0 = 0
            com.facebook.ads.redexgen.X.6g r0 = r4.A06
            if (r0 != 0) goto L6b
            r0 = 2
        La:
            switch(r0) {
                case 2: goto L32;
                case 3: goto L6d;
                case 4: goto L28;
                case 5: goto L14;
                case 6: goto Le;
                case 7: goto L4b;
                case 8: goto L53;
                case 9: goto L5b;
                case 10: goto L63;
                case 11: goto L67;
                default: goto Ld;
            }
        Ld:
            goto La
        Le:
            if (r5 == 0) goto L12
            r0 = 7
            goto La
        L12:
            r0 = 3
            goto La
        L14:
            com.facebook.ads.redexgen.X.7a r4 = (com.facebook.ads.redexgen.X.C01807a) r4
            com.facebook.ads.redexgen.X.6g r0 = r4.A06
            boolean r6 = r0.A24()
            com.facebook.ads.redexgen.X.6g r0 = r4.A06
            boolean r5 = r0.A25()
            if (r6 != 0) goto L26
            r0 = 6
            goto La
        L26:
            r0 = 7
            goto La
        L28:
            com.facebook.ads.redexgen.X.7a r4 = (com.facebook.ads.redexgen.X.C01807a) r4
            boolean r0 = r4.A0I
            if (r0 != 0) goto L30
            r0 = 5
            goto La
        L30:
            r0 = 3
            goto La
        L32:
            r2 = 1788(0x6fc, float:2.506E-42)
            r1 = 12
            r0 = 70
            java.lang.String r3 = A08(r2, r1, r0)
            r2 = 859(0x35b, float:1.204E-42)
            r1 = 90
            r0 = 97
            java.lang.String r0 = A08(r2, r1, r0)
            android.util.Log.e(r3, r0)
            r0 = 3
            goto La
        L4b:
            if (r6 == 0) goto L50
            r0 = 8
            goto La
        L50:
            r0 = 11
            goto La
        L53:
            if (r5 == 0) goto L58
            r0 = 9
            goto La
        L58:
            r0 = 10
            goto La
        L5b:
            com.facebook.ads.redexgen.X.7a r4 = (com.facebook.ads.redexgen.X.C01807a) r4
            r0 = 0
            r4.A0t(r8, r9, r0)
            r0 = 3
            goto La
        L63:
            r9 = 0
            r0 = 9
            goto La
        L67:
            r8 = 0
            r0 = 8
            goto La
        L6b:
            r0 = 4
            goto La
        L6d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C01807a.scrollBy(int, int):void");
    }

    @Override // android.view.View
    public final void scrollTo(int i, int i2) {
        Log.w(A08(1788, 12, 70), A08(686, 93, 48));
    }

    @Override // android.view.View, android.view.accessibility.AccessibilityEventSource
    public final void sendAccessibilityEventUnchecked(AccessibilityEvent accessibilityEvent) {
        if (A0y(accessibilityEvent)) {
            return;
        }
        super.sendAccessibilityEventUnchecked(accessibilityEvent);
    }

    public void setAccessibilityDelegateCompat(C01827c c01827c) {
        this.A09 = c01827c;
        C5B.A0A(this, this.A09);
    }

    public void setAdapter(C2E c2e) {
        setLayoutFrozen(false);
        A0g(c2e, false, true);
        requestLayout();
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x0028, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void setChildDrawingOrderCallback(com.facebook.ads.redexgen.X.AnonymousClass78 r4) {
        /*
            r3 = this;
            r2 = r3
            r1 = 0
            com.facebook.ads.redexgen.X.78 r0 = r2.A0e
            if (r4 != r0) goto L26
            r0 = 2
        L7:
            switch(r0) {
                case 2: goto L28;
                case 3: goto Le;
                case 4: goto L1c;
                case 5: goto L1f;
                case 6: goto Lb;
                default: goto La;
            }
        La:
            goto L7
        Lb:
            r1 = 0
            r0 = 5
            goto L7
        Le:
            com.facebook.ads.redexgen.X.7a r2 = (com.facebook.ads.redexgen.X.C01807a) r2
            com.facebook.ads.redexgen.X.78 r4 = (com.facebook.ads.redexgen.X.AnonymousClass78) r4
            r2.A0e = r4
            com.facebook.ads.redexgen.X.78 r0 = r2.A0e
            if (r0 == 0) goto L1a
            r0 = 4
            goto L7
        L1a:
            r0 = 6
            goto L7
        L1c:
            r1 = 1
            r0 = 5
            goto L7
        L1f:
            com.facebook.ads.redexgen.X.7a r2 = (com.facebook.ads.redexgen.X.C01807a) r2
            r2.setChildrenDrawingOrderEnabled(r1)
            r0 = 2
            goto L7
        L26:
            r0 = 3
            goto L7
        L28:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C01807a.setChildDrawingOrderCallback(com.facebook.ads.redexgen.X.78):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x0029, code lost:            return;     */
    @Override // android.view.ViewGroup
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void setClipToPadding(boolean r3) {
        /*
            r2 = this;
            r1 = r2
            boolean r0 = r1.A0B
            if (r3 == r0) goto L27
            r0 = 2
        L6:
            switch(r0) {
                case 2: goto La;
                case 3: goto L11;
                case 4: goto L20;
                case 5: goto L29;
                default: goto L9;
            }
        L9:
            goto L6
        La:
            com.facebook.ads.redexgen.X.7a r1 = (com.facebook.ads.redexgen.X.C01807a) r1
            r1.A0V()
            r0 = 3
            goto L6
        L11:
            com.facebook.ads.redexgen.X.7a r1 = (com.facebook.ads.redexgen.X.C01807a) r1
            r1.A0B = r3
            super.setClipToPadding(r3)
            boolean r0 = r1.A0D
            if (r0 == 0) goto L1e
            r0 = 4
            goto L6
        L1e:
            r0 = 5
            goto L6
        L20:
            com.facebook.ads.redexgen.X.7a r1 = (com.facebook.ads.redexgen.X.C01807a) r1
            r1.requestLayout()
            r0 = 5
            goto L6
        L27:
            r0 = 3
            goto L6
        L29:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C01807a.setClipToPadding(boolean):void");
    }

    public void setHasFixedSize(boolean z) {
        this.A0E = z;
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x0034, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void setItemAnimator(com.facebook.ads.redexgen.X.C6U r4) {
        /*
            r3 = this;
            r2 = r3
            com.facebook.ads.redexgen.X.6U r0 = r2.A05
            if (r0 == 0) goto L32
            r0 = 2
        L6:
            switch(r0) {
                case 2: goto La;
                case 3: goto L19;
                case 4: goto L27;
                case 5: goto L34;
                default: goto L9;
            }
        L9:
            goto L6
        La:
            com.facebook.ads.redexgen.X.7a r2 = (com.facebook.ads.redexgen.X.C01807a) r2
            com.facebook.ads.redexgen.X.6U r0 = r2.A05
            r0.A0G()
            com.facebook.ads.redexgen.X.6U r1 = r2.A05
            r0 = 0
            r1.A09(r0)
            r0 = 3
            goto L6
        L19:
            com.facebook.ads.redexgen.X.7a r2 = (com.facebook.ads.redexgen.X.C01807a) r2
            com.facebook.ads.redexgen.X.6U r4 = (com.facebook.ads.redexgen.X.C6U) r4
            r2.A05 = r4
            com.facebook.ads.redexgen.X.6U r0 = r2.A05
            if (r0 == 0) goto L25
            r0 = 4
            goto L6
        L25:
            r0 = 5
            goto L6
        L27:
            com.facebook.ads.redexgen.X.7a r2 = (com.facebook.ads.redexgen.X.C01807a) r2
            com.facebook.ads.redexgen.X.6U r1 = r2.A05
            com.facebook.ads.redexgen.X.7B r0 = r2.A0f
            r1.A09(r0)
            r0 = 5
            goto L6
        L32:
            r0 = 3
            goto L6
        L34:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C01807a.setItemAnimator(com.facebook.ads.redexgen.X.6U):void");
    }

    public void setItemViewCacheSize(int i) {
        this.A0r.A0Q(i);
    }

    /* JADX WARN: Code restructure failed: missing block: B:53:0x0074, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void setLayoutFrozen(boolean r14) {
        /*
            r13 = this;
            r4 = r13
            r0 = 0
            r0 = 0
            r0 = 0
            r3 = 1
            r0 = 0
            r12 = 0
            boolean r0 = r4.A0I
            if (r14 == r0) goto L71
            r0 = 2
        Lc:
            switch(r0) {
                case 2: goto L38;
                case 3: goto L2b;
                case 4: goto L21;
                case 5: goto L10;
                case 6: goto L1a;
                case 7: goto L4e;
                case 8: goto L74;
                case 9: goto L55;
                default: goto Lf;
            }
        Lf:
            goto Lc
        L10:
            com.facebook.ads.redexgen.X.7a r4 = (com.facebook.ads.redexgen.X.C01807a) r4
            com.facebook.ads.redexgen.X.2E r0 = r4.A04
            if (r0 == 0) goto L18
            r0 = 6
            goto Lc
        L18:
            r0 = 7
            goto Lc
        L1a:
            com.facebook.ads.redexgen.X.7a r4 = (com.facebook.ads.redexgen.X.C01807a) r4
            r4.requestLayout()
            r0 = 7
            goto Lc
        L21:
            com.facebook.ads.redexgen.X.7a r4 = (com.facebook.ads.redexgen.X.C01807a) r4
            com.facebook.ads.redexgen.X.6g r0 = r4.A06
            if (r0 == 0) goto L29
            r0 = 5
            goto Lc
        L29:
            r0 = 7
            goto Lc
        L2b:
            com.facebook.ads.redexgen.X.7a r4 = (com.facebook.ads.redexgen.X.C01807a) r4
            r12 = 0
            r4.A0I = r12
            boolean r0 = r4.A0J
            if (r0 == 0) goto L36
            r0 = 4
            goto Lc
        L36:
            r0 = 7
            goto Lc
        L38:
            com.facebook.ads.redexgen.X.7a r4 = (com.facebook.ads.redexgen.X.C01807a) r4
            r2 = 195(0xc3, float:2.73E-43)
            r1 = 42
            r0 = 13
            java.lang.String r0 = A08(r2, r1, r0)
            r4.A1e(r0)
            if (r14 != 0) goto L4b
            r0 = 3
            goto Lc
        L4b:
            r0 = 9
            goto Lc
        L4e:
            com.facebook.ads.redexgen.X.7a r4 = (com.facebook.ads.redexgen.X.C01807a) r4
            r4.A0J = r12
            r0 = 8
            goto Lc
        L55:
            com.facebook.ads.redexgen.X.7a r4 = (com.facebook.ads.redexgen.X.C01807a) r4
            r12 = 0
            r10 = 0
            long r5 = android.os.SystemClock.uptimeMillis()
            r9 = 3
            r7 = r5
            r11 = r10
            android.view.MotionEvent r0 = android.view.MotionEvent.obtain(r5, r7, r9, r10, r11, r12)
            r4.onTouchEvent(r0)
            r4.A0I = r3
            r4.A0n = r3
            r4.A1G()
            r0 = 8
            goto Lc
        L71:
            r0 = 8
            goto Lc
        L74:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C01807a.setLayoutFrozen(boolean):void");
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:5:0x0008. Please report as an issue. */
    public void setLayoutManager(AbstractC01616g abstractC01616g) {
        C01807a c01807a = this;
        char c = abstractC01616g == c01807a.A06 ? (char) 2 : (char) 3;
        while (true) {
            switch (c) {
                case 2:
                    return;
                case 3:
                    c01807a = c01807a;
                    c01807a.A1G();
                    c = c01807a.A06 != null ? (char) 4 : '\f';
                case 4:
                    c01807a = c01807a;
                    c = c01807a.A05 != null ? (char) 5 : (char) 6;
                case 5:
                    c01807a = c01807a;
                    c01807a.A05.A0G();
                    c = 6;
                case 6:
                    c01807a = c01807a;
                    c01807a.A06.A1I(c01807a.A0r);
                    c01807a.A06.A1G(c01807a.A0r);
                    c01807a.A0r.A0P();
                    c = c01807a.A0F ? (char) 7 : '\b';
                case 7:
                    c01807a = c01807a;
                    c01807a.A06.A1U(c01807a, c01807a.A0r);
                    c = '\b';
                case '\b':
                    c01807a = c01807a;
                    c01807a.A06.A1P(null);
                    c01807a.A06 = null;
                    c = '\t';
                case '\t':
                    c01807a = c01807a;
                    abstractC01616g = abstractC01616g;
                    c01807a.A01.A0B();
                    c01807a.A06 = abstractC01616g;
                    c = abstractC01616g != null ? '\n' : (char) 15;
                case '\n':
                    abstractC01616g = abstractC01616g;
                    c = abstractC01616g.A03 != null ? (char) 11 : '\r';
                case 11:
                    AbstractC01616g abstractC01616g2 = abstractC01616g;
                    throw new IllegalArgumentException(A08(626, 14, 42) + abstractC01616g2 + A08(779, 39, 69) + abstractC01616g2.A03.A17());
                case '\f':
                    c01807a = c01807a;
                    c01807a.A0r.A0P();
                    c = '\t';
                case '\r':
                    c01807a = c01807a;
                    c01807a.A06.A1P(c01807a);
                    c = c01807a.A0F ? (char) 14 : (char) 15;
                case 14:
                    c01807a = c01807a;
                    c01807a.A06.A1N(c01807a);
                    c = 15;
                case 15:
                    c01807a = c01807a;
                    c01807a.A0r.A0O();
                    c01807a.requestLayout();
                    c = 2;
            }
        }
    }

    @Override // android.view.View
    public void setNestedScrollingEnabled(boolean z) {
        getScrollingChildHelper().A04(z);
    }

    public void setOnFlingListener(@Nullable AbstractC01766w abstractC01766w) {
        this.A0g = abstractC01766w;
    }

    @Deprecated
    public void setOnScrollListener(C7L c7l) {
        this.A0i = c7l;
    }

    public void setPreserveFocusAfterLayout(boolean z) {
        this.A0o = z;
    }

    public void setRecycledViewPool(C7N c7n) {
        this.A0r.A0Z(c7n);
    }

    public void setRecyclerListener(C7P c7p) {
        this.A07 = c7p;
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x0025, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void setScrollState(int r3) {
        /*
            r2 = this;
            r1 = r2
            int r0 = r1.A0W
            if (r3 != r0) goto L23
            r0 = 2
        L6:
            switch(r0) {
                case 2: goto L25;
                case 3: goto La;
                case 4: goto L15;
                case 5: goto L1c;
                default: goto L9;
            }
        L9:
            goto L6
        La:
            com.facebook.ads.redexgen.X.7a r1 = (com.facebook.ads.redexgen.X.C01807a) r1
            r1.A0W = r3
            r0 = 2
            if (r3 == r0) goto L13
            r0 = 4
            goto L6
        L13:
            r0 = 5
            goto L6
        L15:
            com.facebook.ads.redexgen.X.7a r1 = (com.facebook.ads.redexgen.X.C01807a) r1
            r1.A0L()
            r0 = 5
            goto L6
        L1c:
            com.facebook.ads.redexgen.X.7a r1 = (com.facebook.ads.redexgen.X.C01807a) r1
            r1.A0a(r3)
            r0 = 2
            goto L6
        L23:
            r0 = 3
            goto L6
        L25:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C01807a.setScrollState(int):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0066, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void setScrollingTouchSlop(int r8) {
        /*
            r7 = this;
            r5 = r7
            r0 = 0
            android.content.Context r0 = r5.getContext()
            android.view.ViewConfiguration r4 = android.view.ViewConfiguration.get(r0)
            switch(r8) {
                case 0: goto L64;
                case 1: goto L62;
                default: goto Ld;
            }
        Ld:
            r0 = 2
        Le:
            switch(r0) {
                case 2: goto L12;
                case 3: goto L56;
                case 4: goto L66;
                case 5: goto L4a;
                default: goto L11;
            }
        L11:
            goto Le
        L12:
            r2 = 1788(0x6fc, float:2.506E-42)
            r1 = 12
            r0 = 70
            java.lang.String r6 = A08(r2, r1, r0)
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r2 = 278(0x116, float:3.9E-43)
            r1 = 47
            r0 = 55
            java.lang.String r0 = A08(r2, r1, r0)
            java.lang.StringBuilder r0 = r3.append(r0)
            java.lang.StringBuilder r3 = r0.append(r8)
            r2 = 605(0x25d, float:8.48E-43)
            r1 = 21
            r0 = 31
            java.lang.String r0 = A08(r2, r1, r0)
            java.lang.StringBuilder r0 = r3.append(r0)
            java.lang.String r0 = r0.toString()
            android.util.Log.w(r6, r0)
            r0 = 3
            goto Le
        L4a:
            com.facebook.ads.redexgen.X.7a r5 = (com.facebook.ads.redexgen.X.C01807a) r5
            android.view.ViewConfiguration r4 = (android.view.ViewConfiguration) r4
            int r0 = r4.getScaledPagingTouchSlop()
            r5.A0X = r0
            r0 = 4
            goto Le
        L56:
            com.facebook.ads.redexgen.X.7a r5 = (com.facebook.ads.redexgen.X.C01807a) r5
            android.view.ViewConfiguration r4 = (android.view.ViewConfiguration) r4
            int r0 = r4.getScaledTouchSlop()
            r5.A0X = r0
            r0 = 4
            goto Le
        L62:
            r0 = 5
            goto Le
        L64:
            r0 = 3
            goto Le
        L66:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C01807a.setScrollingTouchSlop(int):void");
    }

    public void setViewCacheExtension(C7X c7x) {
        this.A0r.A0a(c7x);
    }

    @Override // android.view.View
    public final boolean startNestedScroll(int i) {
        return getScrollingChildHelper().A0A(i);
    }

    @Override // android.view.View, com.facebook.ads.redexgen.X.InterfaceC01144h
    public final void stopNestedScroll() {
        getScrollingChildHelper().A02();
    }
}
