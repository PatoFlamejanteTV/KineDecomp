package com.facebook.ads.redexgen.X;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.annotation.Nullable;
import com.facebook.ads.internal.util.process.ProcessUtils;
import org.json.JSONException;

/* renamed from: com.facebook.ads.redexgen.X.Gc, reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C0413Gc {
    public static C0413Gc A01;
    public static byte[] A02;
    public final SharedPreferences A00;

    static {
        A0Q();
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0030, code lost:            return new java.lang.String(r2);     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String A0J(int r2, int r3, int r4) {
        /*
            r0 = 0
            r0 = 0
            byte[] r1 = com.facebook.ads.redexgen.X.C0413Gc.A02
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
            int r0 = r0 + (-120)
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C0413Gc.A0J(int, int, int):java.lang.String");
    }

    public static void A0Q() {
        A02 = new byte[]{88, 91, 101, 110, 86, 92, 101, 88, 89, 99, 92, 86, 96, 101, 99, 96, 101, 92, 86, 111, 86, 102, 108, 107, 86, 101, 102, 101, 86, 93, 108, 99, 99, 106, 90, 105, 92, 92, 101, 86, 102, 101, 86, 106, 91, 98, 64, 67, 77, 86, 62, 64, 66, 66, 68, 79, 83, 64, 65, 75, 68, 62, 82, 83, 64, 66, 74, 83, 81, 64, 66, 68, 62, 75, 68, 77, 70, 83, 71, 38, 41, 51, 60, 36, 58, 56, 42, 36, 40, 38, 40, 45, 42, 41, 36, 42, 61, 42, 40, 58, 57, 52, 55, 36, 43, 52, 55, 36, 51, 42, 57, 60, 52, 55, 48, 88, 91, 101, 110, 86, 88, 101, 91, 105, 102, 96, 91, 86, 100, 105, 90, 86, 96, 100, 103, 105, 92, 106, 106, 96, 102, 101, 86, 93, 102, 105, 86, 101, 88, 107, 96, 109, 92, 86, 109, 96, 91, 92, 102, 86, 88, 91, 106, 61, 63, 63, 69, 64, 65, 74, 80, 61, 72, 59, 63, 72, 69, 63, 71, 79, 59, 63, 75, 74, 66, 69, 67, 10, 80, 83, 75, 59, 79, 80, 65, 76, 59, 63, 75, 74, 66, 69, 78, 73, 61, 80, 69, 75, 74, 59, 62, 75, 64, 85, -15, -12, -2, 7, -17, 4, 2, -7, -9, -9, -11, 2, -17, -2, -15, 4, -7, 6, -11, -17, 2, -11, -9, -7, 3, 4, -11, 2, -17, 6, -7, -11, 7, -17, -11, 2, 2, -1, 2, -17, -13, -15, -4, -4, -14, -15, -13, -5, 47, 50, 60, 69, 45, 51, 60, 47, 48, 58, 51, 45, 52, 67, 60, 60, 51, 58, 68, 70, 70, 76, 71, 72, 81, 87, 68, 79, 66, 70, 79, 76, 70, 78, 86, 66, 70, 82, 81, 73, 76, 74, 17, 87, 90, 82, 66, 86, 87, 72, 83, 66, 70, 82, 81, 73, 76, 85, 80, 68, 87, 76, 82, 81, 66, 87, 76, 87, 79, 72, 57, 60, 70, 79, 55, 65, 70, 76, 61, 74, 75, 76, 65, 76, 65, 57, 68, 55, 75, 73, 77, 57, 74, 61, 55, 79, 57, 76, 59, 64, 55, 57, 70, 60, 55, 58, 74, 71, 79, 75, 61, 55, 59, 76, 57, 22, 24, 24, 30, 25, 26, 35, 41, 22, 33, 20, 24, 33, 30, 24, 32, 40, 20, 24, 36, 35, 27, 30, 28, -8, -5, 5, 14, -10, -8, 5, -5, 9, 6, 0, -5, -10, 5, -4, 11, 14, 6, 9, 2, -10, -5, -4, -3, -8, 12, 3, 11, -10, -6, 6, 5, 5, -4, -6, 11, 0, 6, 5, -10, 11, 0, 4, -4, 6, 12, 11, -10, 4, 10, 60, 63, 73, 82, 58, 60, 73, 63, 77, 74, 68, 63, 58, 73, 64, 79, 82, 74, 77, 70, 58, 63, 64, 65, 60, 80, 71, 79, 58, 77, 64, 60, 63, 58, 79, 68, 72, 64, 74, 80, 79, 58, 72, 78, 83, 86, 96, 105, 81, 100, 104, 81, 98, 94, 83, 107, 84, 83, 85, 93, 81, 85, 100, 83, 101, 90, 81, 88, 83, 94, 94, 84, 83, 85, 93, 37, 40, 50, 59, 35, 50, 37, 56, 45, 58, 41, 35, 39, 37, 54, 51, 57, 55, 41, 48, 35, 39, 51, 49, 52, 37, 39, 56, 35, 56, 44, 54, 41, 55, 44, 51, 48, 40, -21, -18, -8, 1, -23, -9, -7, -18, -1, -10, -17, -3, -23, -8, -17, -2, 1, -7, -4, -11, -13, -8, -15, -23, -17, -8, -21, -20, -10, -17, -18, -23, -16, -7, -4, -23, -21, -18, -23, -4, -17, -5, -1, -17, -3, -2, -31, -28, -18, -9, -33, -31, -18, -28, -14, -17, -23, -28, -33, -31, -20, -20, -17, -9, -33, -20, -17, -31, -28, -33, -28, -11, -14, -23, -18, -25, -33, -13, -24, -17, -9, -23, -18, -25, 26, 29, 39, 48, 24, 41, 37, 26, 50, 26, 27, 37, 30, 44, 24, 37, 40, 32, 32, 34, 39, 32, 24, 30, 39, 26, 27, 37, 30, 29, 28, 31, 41, 50, 26, 28, 41, 31, 45, 42, 36, 31, 26, 41, 32, 47, 50, 42, 45, 38, 26, 31, 32, 33, 28, 48, 39, 47, 26, 47, 36, 40, 32, 42, 48, 47, 26, 40, 46, 82, 85, 95, 104, 80, 100, 89, 96, 102, 93, 85, 80, 82, 85, 85, 80, 86, 105, 101, 86, 95, 100, 90, 96, 95, 80, 101, 96, 80, 97, 93, 82, 106, 82, 83, 93, 86, 100, -7, -20, -25, -24, -14, -30, -28, -15, -25, -30, -24, -15, -25, -26, -28, -11, -25, -30, -28, -8, -9, -14, -11, -14, -9, -28, -9, -24, 39, 42, 52, 61, 37, 40, 50, 53, 41, 49, 37, 50, 53, 41, 49, 57, 41, 56, 43, 43, 52, 80, 83, 93, 102, 78, 98, 104, 93, 82, 78, 84, 93, 83, 95, 94, 88, 93, 99, 78, 95, 97, 84, 85, 88, 103, -34, -31, -21, -12, -36, -16, -10, -21, -32, -36, -34, -29, -15, -30, -17, -36, -34, -31, -36, -23, -20, -34, -31, -17, -15, 64, 67, 77, 86, 62, 64, 77, 67, 81, 78, 72, 67, 62, 77, 68, 83, 86, 78, 81, 74, 62, 67, 68, 69, 64, 84, 75, 83, 62, 83, 71, 81, 78, 83, 83, 75, 68, 62, 83, 72, 76, 68, 78, 84, 83, 62, 76, 82, -11, -8, 2, 11, -13, 7, -4, 3, 9, 0, -8, -13, -3, -5, 2, 3, 6, -7, -13, -8, -7, 7, 8, 6, 3, 13, -13, -9, -11, 0, 0, 52, 55, 65, 74, 50, 64, 66, 55, 72, 63, 56, 70, 50, 65, 56, 71, 74, 66, 69, 62, 60, 65, 58, 50, 56, 65, 52, 53, 63, 56, 55, 50, 57, 66, 69, 50, 65, 66, 65, 50, 52, 55, 50, 69, 56, 68, 72, 56, 70, 71, 11, 14, 24, 33, 9, 29, 18, 25, 31, 22, 14, 9, 19, 24, 13, 28, 15, 
        23, 15, 24, 30, 9, 28, 15, 30, 28, 35, 9, 13, 25, 31, 24, 30, 15, 28, 9, 25, 24, 9, 15, 23, 26, 30, 35, 9, 28, 15, 29, 26, 25, 24, 29, 15, 23, 26, 36, 45, 21, 36, 27, 45, 21, 34, 23, 36, 26, 41, 25, 23, 38, 27, 21, 27, 36, 26, 25, 23, 40, 26, 86, 89, 99, 108, 84, 106, 99, 94, 102, 106, 90, 84, 89, 87, 84, 99, 86, 98, 90, 84, 101, 90, 103, 84, 101, 103, 100, 88, 90, 104, 104, 8, 11, 21, 30, 6, 27, 16, 20, 12, 6, 27, 22, 6, 30, 8, 16, 27, 6, 13, 22, 25, 6, 29, 16, 11, 12, 22, 6, 23, 19, 8, 32, 6, 20, 26, 25, 28, 38, 47, 23, 25, 38, 28, 42, 39, 33, 28, 23, 37, 42, 27, 23, 33, 37, 40, 42, 29, 43, 43, 33, 39, 38, 23, 30, 39, 42, 23, 38, 25, 44, 33, 46, 29, 23, 46, 33, 28, 29, 39, 23, 25, 28, 43, 23, 46, -22, -56, 12, 15, 25, 34, 10, 31, 20, 24, 16, 26, 32, 31, 10, 29, 16, 34, 12, 29, 15, 16, 15, 10, 33, 20, 15, 16, 26, 72, 84, 82, 19, 75, 70, 72, 74, 71, 84, 84, 80, 19, 70, 73, 88, 19, 43, 42, 38, 57, 58, 55, 42, 68, 40, 52, 51, 43, 46, 44, -23, -20, -10, -1, -25, -23, -10, -20, -6, -9, -15, -20, -25, -11, -19, -11, -9, -6, 1, -25, -9, -8, -4, -17, -14, -4, 5, -19, -17, -4, -14, 0, -3, -9, -14, -19, 3, 1, -13, -19, -15, -17, -15, -10, -13, -19, -5, -3, -14, 3, -6, -13, -19, -12, -3, 0, -19, -9, -5, -17, -11, -13, 1, 67, 70, 80, 89, 65, 69, 84, 67, 85, 74, 65, 85, 74, 75, 71, 78, 70, 65, 71, 80, 67, 68, 78, 71, 70, 54, 57, 67, 76, 52, 54, 67, 57, 71, 68, 62, 57, 52, 56, 54, 56, 61, 58, 52, 66, 68, 57, 74, 65, 58, 52, 66, 54, 77, 52, 72, 62, 79, 58, 26, 29, 39, 48, 24, 34, 39, 45, 30, 43, 44, 45, 34, 45, 34, 26, 37, 24, 39, 30, 48, 24, 34, 38, 26, 32, 30, 24, 29, 30, 44, 34, 32, 39, 87, 90, 100, 109, 85, 104, 108, 85, 88, 107, 92, 92, 91, 104, 85, 89, 94, 91, 89, 97, 85, 91, 100, 87, 88, 98, 91, 90, 88, 95, 86, 86, 51, 54, 64, 73, 49, 69, 58, 65, 71, 62, 54, 49, 59, 64, 59, 70, 49, 65, 64, 49, 53, 62, 51, 69, 69, 49, 62, 65, 51, 54, 59, 64, 57, 3, 6, 16, 25, 1, 3, 16, 6, 20, 17, 11, 6, 1, 6, 11, 21, 3, 4, 14, 7, 1, 18, 14, 3, 27, 3, 4, 14, 7, 1, 18, 20, 7, 5, 3, 5, 10, 7, 87, 90, 100, 109, 85, 107, 105, 91, 85, 89, 87, 89, 94, 91, 90, 85, 91, 110, 91, 89, 107, 106, 101, 104, 85, 95, 100, 85, 89, 87, 89, 94, 91, 85, 99, 87, 100, 87, 93, 91, 104, -15, -12, -2, 7, -17, -12, -1, -17, -2, -1, 4, -17, 2, -11, -4, -1, -15, -12, -17, -7, -2, 4, -11, 2, 3, 4, -7, 4, -7, -15, -4, -17, -15, -12, -15, 0, 4, -11, 2, -35, 9, 8, 14, 3, 8, 15, -1, 74, 77, 87, 96, 72, 92, 81, 88, 94, 85, 77, 72, 82, 87, 82, 93, 72, 79, 91, 88, 86, 72, 76, 88, 87, 93, 78, 87, 93, 72, 89, 91, 88, 95, 82, 77, 78, 91, -4, 5, 2, -4, 4, 0, 14, -6, 11, -3, -8, 13, 2, 6, -2, -8, 6, 12, 75, 95, 94, 89, 92, 89, 94, 75, 94, 79, 73, 79, 88, 75, 76, 86, 79, 78, 75, 78, 88, 97, 73, 79, 88, 75, 76, 86, 79, 73, 78, 79, 76, 95, 81, 73, 89, 96, 79, 92, 86, 75, 99, -16, -13, -3, 6, -18, -16, -3, -13, 1, -2, -8, -13, -18, -12, -3, -16, -15, -5, -12, -18, -3, -16, 3, -8, 5, -12, -18, -11, 4, -3, -3, -12, -5, -14, -18, -13, -18, -14, -6, -14, -28, -22, -15, -26, -11, -8, -22, -23, -28, -7, -18, -14, -22, -28, -26, -21, -7, -22, -9, -28, -18, -14, -11, -9, -22, -8, -8, -18, -12, -13, -16, -13, -3, 6, -18, -16, -14, -14, -12, -1, 3, -16, -15, -5, -12, -18, 2, 3, -16, -14, -6, 3, 1, -16, -14, -12, -18, -14, -2, -3, 3, -12, 7, 3, -18, -11, -8, -5, 3, -12, 1, -18, 2, -8, 9, -12, 8, 11, 21, 30, 6, 10, 27, 8, 6, 8, 21, 16, 20, 8, 27, 16, 22, 21, 6, 11, 12, 19, 8, 32, 6, 20, 26, 12, 15, 25, 34, 10, 32, 30, 16, 10, 29, 20, 27, 27, 23, 16, 10, 12, 25, 20, 24, 12, 31, 20, 26, 25, 68, 71, 81, 90, 66, 69, 68, 81, 81, 72, 85, 66, 81, 82, 87, 76, 73, 92, 66, 68, 71, 66, 79, 82, 68, 71, 72, 71, 66, 82, 81, 66, 68, 86, 86, 72, 87, 86, 66, 79, 82, 68, 71, 72, 71, -16, -16, -16, 54, 57, 67, 76, 52, 73, 62, 66, 58, 52, 73, 68, 52, 76, 54, 62, 73, 52, 59, 68, 71, 52, 75, 62, 57, 58, 68, 52, 69, 71, 58, 69, 54, 71, 58, 57, 52, 66, 72, 34, 37, 47, 56, 32, 34, 47, 37, 51, 48, 42, 37, 32, 42, 46, 34, 40, 38, 32, 36, 34, 36, 41, 38, 32, 52, 53, 48, 51, 38, 32, 35, 58, 53, 38, 32, 36, 48, 54, 47, 53, 84, 87, 97, 106, 82, 89, 92, 95, 103, 88, 101, 82, 85, 92, 87, 87, 92, 97, 90, 82, 
        103, 98, 94, 88, 97, 75, 78, 88, 97, 73, 86, 89, 81, 81, 83, 88, 81, 73, 79, 88, 78, 90, 89, 83, 88, 94, 73, 90, 92, 79, 80, 83, 98, 52, 55, 65, 74, 50, 73, 60, 56, 74, 52, 53, 60, 63, 60, 71, 76, 50, 54, 59, 56, 54, 62, 50, 52, 69, 56, 52, 50, 53, 52, 70, 56, 55, 10, 13, 23, 32, 8, 23, 10, 29, 18, 31, 14, 8, 31, 18, 14, 32, 8, 28, 23, 10, 25, 28, 17, 24, 29, 8, 21, 24, 16, 16, 18, 23, 16, 8, 14, 23, 10, 11, 21, 14, 13, 38, 41, 51, 60, 36, 42, 51, 38, 39, 49, 42, 36, 51, 42, 57, 60, 52, 55, 48, -10, -7, 3, 12, -12, 5, 10, 7, -4, -6, -12, 4, 3, -12, -55, -58, -56, -12, 7, -6, 8, 5, 4, 3, 8, -6, 81, 83, 83, 89, 84, 85, 94, 100, 81, 92, 79, 83, 92, 89, 83, 91, 99, 79, 83, 95, 94, 86, 89, 87, 30, 100, 103, 95, 79, 99, 100, 85, 96, 79, 83, 95, 94, 86, 89, 98, 93, 79, 82, 101, 100, 100, 95, 94, 79, 100, 85, 104, 100, 58, 78, 77, 72, 75, 72, 77, 58, 77, 62, 56, 61, 66, 76, 58, 59, 69, 62, 61, -4, -1, 9, 18, -6, -2, 15, -4, -6, 8, 4, 9, -6, 14, -2, -4, 7, 0, -6, -4, 9, 4, 8, -4, 15, 4, 10, 9, -6, 11, 0, 13, -2, 0, 9, 15, -4, 2, 0, 59, 62, 72, 81, 57, 63, 72, 59, 60, 70, 63, 57, 77, 83, 72, 61, -26, -24, -24, -18, -23, -22, -13, -7, -26, -15, -28, -24, -15, -18, -24, -16, -8, -28, -24, -12, -13, -21, -18, -20, -77, -7, -4, -12, -28, -8, -7, -22, -11, -28, -24, -12, -13, -21, -18, -9, -14, -26, -7, -18, -12, -13, 10, 13, 23, 32, 8, 28, 29, 10, 12, 20, 29, 27, 10, 12, 14, 8, 16, 27, 24, 30, 25, 18, 23, 16, 8, 14, 23, 10, 11, 21, 14, 13, 4, 34, 47, 36, 38, 45, 7, 10, 20, 29, 5, 7, 20, 10, 24, 21, 15, 10, 5, 20, 11, 26, 29, 21, 24, 17, 5, 10, 11, 12, 7, 27, 18, 26, 5, 24, 11, 26, 24, 15, 11, 25, 5, 20, 27, 19, 17, 18, -1, 1, 9, -3, 18, 16, -1, 1, 3, -3, 17, -1, 11, 14, 10, 3, -3, 16, -1, 18, 3, -62, -18, -19, -13, -24, -19, -12, -28, -66, -23, -20, -10, -1, -25, -22, -19, -10, -21, -16, -11, -23, -6, -13, -25, -6, -19, -8, -9, -6, -4, -25, -15, -10, -4, -19, -6, -2, -23, -12, -25, -11, -5, -38, -35, -25, -16, -40, -34, -25, -38, -37, -27, -34, -40, -23, -21, -34, -27, -24, -38, -35, 13, 16, 26, 35, 11, 17, 26, 13, 14, 24, 17, 11, 13, 33, 32, 27, 11, 16, 17, 31, 32, 30, 27, 37, 11, 24, 17, 13, 23, 31, 8, 11, 21, 30, 6, 26, 15, 22, 28, 19, 11, 6, 19, 22, 14, 6, 8, 26, 26, 12, 27, 6, 28, 25, 19, -20, -17, -7, 2, -22, -16, -7, -20, -19, -9, -16, -22, -12, -20, -19, -25, -22, -12, -3, -27, -7, -18, -11, -5, -14, -22, -27, -23, -14, -21, -25, -8, -27, -20, -21, -25, -6, -5, -8, -21, -27, -23, -11, -12, -20, -17, -19, -27, -11, -12, -27, -23, -8, -25, -7, -18, -21, -7, 16, 19, 29, 38, 14, 16, 29, 19, 33, 30, 24, 19, 14, 18, 30, 28, 31, 33, 20, 34, 34, 14, 24, 28, 16, 22, 20, 34, 14, 19, 36, 33, 24, 29, 22, 14, 19, 30, 38, 29, 27, 30, 16, 19, 63, 65, 65, 71, 66, 67, 76, 82, 63, 74, 61, 65, 74, 71, 65, 73, 81, 61, 65, 77, 76, 68, 71, 69, 12, 82, 85, 77, 61, 81, 82, 67, 78, 61, 65, 63, 76, 65, 67, 74, 61, 64, 83, 82, 82, 77, 76, 61, 82, 67, 86, 82, -3, 0, 10, 19, -5, 4, 5, 0, 1, -5, 5, 10, 16, 1, 14, 15, 16, 5, 16, 5, -3, 8, -5, 18, 5, 0, 1, 11, -5, 15, 11, -1, 5, -3, 8, -5, -1, 11, 10, 16, 1, 20, 16, 40, 62, 68, -17, 70, 56, 59, 59, -17, 49, 52, -17, 67, 48, 58, 52, 61, -17, 67, 62, -17, 48, 61, 62, 67, 55, 52, 65, -17, 51, 52, 66, 67, 56, 61, 48, 67, 56, 62, 61, -3, -18, -15, -5, 4, -20, -18, -5, -15, -1, -4, -10, -15, -20, 2, 0, -14, -20, 0, 1, -14, -18, -6, -10, -5, -12, -20, -10, -6, -18, -12, -14, -20, -15, -14, -16, -4, -15, -10, -5, -12, 72, 75, 85, 94, 70, 76, 85, 72, 73, 83, 76, 70, 89, 72, 78, 76, 70, 90, 79, 72, 82, 76, 28, 31, 41, 50, 26, 41, 32, 50, 26, 45, 32, 50, 28, 45, 31, 32, 31, 26, 49, 36, 31, 32, 42, 26, 31, 32, 46, 36, 34, 41};
    }

    public C0413Gc(Context context) {
        this.A00 = context.getApplicationContext().getSharedPreferences(ProcessUtils.getProcessSpecificName(A0J(1207, 31, 109), context), 0);
    }

    public static float A00(Context context) {
        return A0I(context).A1L(A0J(2224, 39, 35), 0.98f);
    }

    public static int A01(Context context) {
        return A0I(context).A1M(A0J(46, 33, 103), 100);
    }

    public static int A02(Context context) {
        return A0I(context).A1M(A0J(2435, 33, 16), 0);
    }

    public static int A03(Context context) {
        return A0I(context).A1M(A0J(1800, 27, 47), -1);
    }

    public static int A04(Context context) {
        return A0I(context).A1M(A0J(1623, 18, 33), 0);
    }

    public static int A05(Context context) {
        return A0I(context).A1M(A0J(401, 50, 31), 30000);
    }

    public static int A06(Context context) {
        return A0I(context).A1M(A0J(2363, 40, 46), 3);
    }

    public static int A07(Context context) {
        return A0I(context).A1M(A0J(451, 44, 99), 8000);
    }

    public static int A08(Context context) {
        return A0I(context).A1M(A0J(854, 48, 103), 100);
    }

    public static int A09(Context context) {
        return A0I(context).A1M(A0J(678, 39, 67), 60000);
    }

    public static int A0A(Context context) {
        return A0I(context).A1M(A0J(526, 38, 76), 225);
    }

    public static int A0B(Context context) {
        return A0I(context).A1M(A0J(1939, 41, 73), 3145728);
    }

    public static int A0C(Context context) {
        return A0I(context).A1M(A0J(1717, 37, 13), -1);
    }

    public static int A0D(Context context) {
        return A0I(context).A1M(A0J(1754, 46, 23), -1);
    }

    public static int A0E(Context context) {
        return A0I(context).A1M(A0J(2403, 23, 38), 0);
    }

    public static int A0F(Context context) {
        return A0I(context).A1M(A0J(1093, 35, 47), 1000);
    }

    public static int A0G(Context context) {
        return A0I(context).A1M(A0J(1900, 39, 93), 3000);
    }

    public static long A0H(Context context) {
        return A0I(context).A1N(A0J(1326, 34, 93), 67108864L);
    }

    public static synchronized C0413Gc A0I(Context context) {
        C0413Gc c0413Gc;
        synchronized (C0413Gc.class) {
            if (A01 == null) {
                A01 = new C0413Gc(context);
            }
            c0413Gc = A01;
        }
        return c0413Gc;
    }

    public static String A0K(Context context) {
        return A0I(context).A1O(A0J(2005, 28, 114), A0J(1897, 3, 1));
    }

    public static String A0L(Context context) {
        return A0I(context).A1O(A0J(804, 25, 119), A0J(1897, 3, 1));
    }

    public static String A0M(Context context) {
        return A0I(context).A1O(A0J(2644, 52, 102), A0J(2357, 6, 73));
    }

    public static String A0N(Context context) {
        return A0I(context).A1O(A0J(163, 51, 100), A0J(2739, 41, 87));
    }

    public static String A0O(Context context) {
        return A0I(context).A1O(A0J(2152, 53, 120), A0J(1577, 8, 34));
    }

    public static String A0P(Context context) {
        return A0I(context).A1O(A0J(280, 52, 107), A0J(2426, 9, 7));
    }

    public static void A0R(Context context) {
        A0I(context).A00.edit().clear().commit();
    }

    /* JADX WARN: Code restructure failed: missing block: B:68:0x00d0, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void A0S(@android.support.annotation.Nullable java.lang.String r11, @android.support.annotation.Nullable java.lang.String r12) throws org.json.JSONException {
        /*
            Method dump skipped, instructions count: 236
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C0413Gc.A0S(java.lang.String, java.lang.String):void");
    }

    public static boolean A0T(Context context) {
        return A0I(context).A1O(A0J(755, 28, 11), A0J(2205, 19, 97)).equals(A0J(1641, 18, 114));
    }

    public static boolean A0U(Context context) {
        return A0I(context).A1Q(A0J(610, 38, 8), false);
    }

    public static boolean A0V(Context context) {
        return A0I(context).A1Q(A0J(2600, 44, 55), true);
    }

    public static boolean A0W(Context context) {
        return A0I(context).A1Q(A0J(1301, 25, 106), true);
    }

    public static boolean A0X(Context context) {
        return A0I(context).A1Q(A0J(1538, 39, 24), true);
    }

    public static boolean A0Y(Context context) {
        return A0I(context).A1Q(A0J(2487, 30, 52), false);
    }

    public static boolean A0Z(Context context) {
        return A0I(context).A1Q(A0J(1684, 33, 23), true);
    }

    public static boolean A0a(Context context) {
        return A0I(context).A1Q(A0J(262, 18, 86), false);
    }

    public static boolean A0b(Context context) {
        return A0I(context).A1Q(A0J(2696, 43, 36), true);
    }

    public static boolean A0c(Context context) {
        return A0I(context).A1Q(A0J(1980, 25, 123), false);
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x002d, code lost:            return r4;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean A0d(android.content.Context r5) {
        /*
            r0 = 0
            r4 = 0
            int r1 = android.os.Build.VERSION.SDK_INT
            r0 = 18
            if (r1 < r0) goto L2b
            r0 = 2
        L9:
            switch(r0) {
                case 2: goto Ld;
                case 3: goto L28;
                case 4: goto L2d;
                default: goto Lc;
            }
        Lc:
            goto L9
        Ld:
            android.content.Context r5 = (android.content.Context) r5
            r4 = 0
            com.facebook.ads.redexgen.X.Gc r3 = A0I(r5)
            r2 = 1659(0x67b, float:2.325E-42)
            r1 = 25
            r0 = 114(0x72, float:1.6E-43)
            java.lang.String r0 = A0J(r2, r1, r0)
            boolean r0 = r3.A1Q(r0, r4)
            if (r0 == 0) goto L26
            r0 = 3
            goto L9
        L26:
            r0 = 4
            goto L9
        L28:
            r4 = 1
            r0 = 4
            goto L9
        L2b:
            r0 = 4
            goto L9
        L2d:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C0413Gc.A0d(android.content.Context):boolean");
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x002d, code lost:            return r4;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean A0e(android.content.Context r5) {
        /*
            r0 = 0
            r4 = 0
            int r1 = android.os.Build.VERSION.SDK_INT
            r0 = 19
            if (r1 < r0) goto L2b
            r0 = 2
        L9:
            switch(r0) {
                case 2: goto Ld;
                case 3: goto L28;
                case 4: goto L2d;
                default: goto Lc;
            }
        Lc:
            goto L9
        Ld:
            android.content.Context r5 = (android.content.Context) r5
            r4 = 0
            com.facebook.ads.redexgen.X.Gc r3 = A0I(r5)
            r2 = 2542(0x9ee, float:3.562E-42)
            r1 = 15
            r0 = 19
            java.lang.String r0 = A0J(r2, r1, r0)
            boolean r0 = r3.A1Q(r0, r4)
            if (r0 == 0) goto L26
            r0 = 3
            goto L9
        L26:
            r0 = 4
            goto L9
        L28:
            r4 = 1
            r0 = 4
            goto L9
        L2b:
            r0 = 4
            goto L9
        L2d:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C0413Gc.A0e(android.content.Context):boolean");
    }

    public static boolean A0f(Context context) {
        return A0I(context).A1Q(A0J(1238, 23, 16), false);
    }

    public static boolean A0g(Context context) {
        return A0I(context).A1Q(A0J(564, 46, 18), false);
    }

    public static boolean A0h(Context context) {
        return A0I(context).A1Q(A0J(933, 50, 91), false);
    }

    public static boolean A0i(Context context) {
        return A0I(context).A1Q(A0J(2066, 41, 49), false);
    }

    public static boolean A0j(Context context) {
        return A0I(context).A1Q(A0J(2820, 22, 111), false);
    }

    public static boolean A0k(Context context) {
        return A0I(context).A1Q(A0J(1394, 28, 126), true);
    }

    public static boolean A0l(Context context) {
        return A0I(context).A1Q(A0J(495, 31, 122), true);
    }

    public static boolean A0m(Context context) {
        return A0I(context).A1Q(A0J(2325, 32, 49), false);
    }

    public static boolean A0n(Context context) {
        return A0I(context).A1Q(A0J(2279, 46, 13), false);
    }

    public static boolean A0o(Context context) {
        return A0I(context).A1Q(A0J(2107, 19, 77), true);
    }

    public static boolean A0p(Context context) {
        return A0I(context).A1Q(A0J(1852, 45, 107), false);
    }

    public static boolean A0q(Context context) {
        return A0I(context).A1Q(A0J(2468, 19, 1), true);
    }

    public static boolean A0r(Context context) {
        return A0I(context).A1Q(A0J(717, 38, 121), true);
    }

    public static boolean A0s(Context context) {
        return A0I(context).A1Q(A0J(783, 21, 78), false);
    }

    public static boolean A0t(Context context) {
        return A0I(context).A1Q(A0J(2557, 43, 14), true);
    }

    public static boolean A0u(Context context) {
        return A0I(context).A1Q(A0J(1459, 38, 42), false);
    }

    public static boolean A0v(Context context) {
        return A0I(context).A1Q(A0J(648, 30, 65), true);
    }

    public static boolean A0w(Context context) {
        return A0I(context).A1Q(A0J(115, 48, 127), false);
    }

    public static boolean A0x(Context context) {
        return A0I(context).A1Q(A0J(1128, 51, 64), false);
    }

    public static boolean A0y(Context context) {
        return A0I(context).A1Q(A0J(902, 31, 28), false);
    }

    public static boolean A0z(Context context) {
        return A0I(context).A1Q(A0J(983, 53, 50), false);
    }

    public static boolean A10(Context context) {
        return A0I(context).A1Q(A0J(1585, 38, 113), true);
    }

    public static boolean A11(Context context) {
        return A0I(context).A1Q(A0J(1426, 33, 90), false);
    }

    public static boolean A12(Context context) {
        return A0I(context).A1Q(A0J(2517, 25, 47), false);
    }

    public static boolean A13(Context context) {
        return A0I(context).A1Q(A0J(2126, 26, 29), false);
    }

    public static boolean A14(Context context) {
        return A0I(context).A1Q(A0J(829, 23, 5), true);
    }

    public static boolean A15(Context context) {
        return A0I(context).A1Q(A0J(1180, 27, 51), false);
    }

    public static boolean A16(Context context) {
        return A0I(context).A1Q(A0J(2033, 33, 91), false);
    }

    public static boolean A17(Context context) {
        return A0I(context).A1Q(A0J(0, 46, 127), true);
    }

    public static boolean A18(Context context) {
        return A0I(context).A1Q(A0J(1360, 34, 65), false);
    }

    public static boolean A19(Context context) {
        return A0I(context).A1Q(A0J(1827, 25, 51), true);
    }

    public static boolean A1A(Context context) {
        return A0I(context).A1Q(A0J(332, 45, 96), false);
    }

    public static boolean A1B(Context context) {
        return A0I(context).A1Q(A0J(1062, 31, 125), false);
    }

    public static boolean A1C(Context context) {
        return A0I(context).A1Q(A0J(2263, 16, 98), true);
    }

    public static boolean A1D(Context context) {
        return A0I(context).A1Q(A0J(214, 48, 24), false);
    }

    public static boolean A1E(Context context) {
        return A0I(context).A1Q(A0J(1261, 40, 22), false);
    }

    public static boolean A1F(Context context) {
        return A0I(context).A1Q(A0J(79, 36, 77), false);
    }

    public static boolean A1G(Context context) {
        return A0I(context).A1Q(A0J(1497, 41, 126), true);
    }

    public static boolean A1H(Context context) {
        return A0I(context).A1Q(A0J(1036, 26, 62), true);
    }

    public static boolean A1I(Context context) {
        return A0I(context).A1Q(A0J(2842, 30, 67), false);
    }

    public static boolean A1J(Context context) {
        return A0I(context).A1Q(A0J(2780, 40, 21), true);
    }

    public final double A1K(String str, double d) {
        String string = this.A00.getString(str, String.valueOf(d));
        if (string != null) {
            try {
                return string.equals(A0J(1422, 4, 114)) ? d : Double.valueOf(string).doubleValue();
            } catch (NumberFormatException unused) {
                return d;
            }
        }
        return d;
    }

    public final float A1L(String str, float f) {
        String string = this.A00.getString(str, String.valueOf(f));
        if (string != null) {
            try {
                return string.equals(A0J(1422, 4, 114)) ? f : Float.valueOf(string).floatValue();
            } catch (NumberFormatException unused) {
                return f;
            }
        }
        return f;
    }

    public final int A1M(String str, int i) {
        String string = this.A00.getString(str, String.valueOf(i));
        if (string != null) {
            try {
                return string.equals(A0J(1422, 4, 114)) ? i : Integer.valueOf(string).intValue();
            } catch (NumberFormatException unused) {
                return i;
            }
        }
        return i;
    }

    public final long A1N(String str, long j) {
        String string = this.A00.getString(str, String.valueOf(j));
        if (string != null) {
            try {
                return string.equals(A0J(1422, 4, 114)) ? j : Long.valueOf(string).longValue();
            } catch (NumberFormatException unused) {
                return j;
            }
        }
        return j;
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x002e, code lost:            return r3;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.String A1O(java.lang.String r5, java.lang.String r6) {
        /*
            r4 = this;
            r0 = 0
            android.content.SharedPreferences r0 = r4.A00
            java.lang.String r3 = r0.getString(r5, r6)
            if (r3 == 0) goto L28
            r0 = 2
        La:
            switch(r0) {
                case 2: goto Le;
                case 3: goto L23;
                case 4: goto L2a;
                default: goto Ld;
            }
        Ld:
            goto La
        Le:
            java.lang.String r3 = (java.lang.String) r3
            r2 = 1422(0x58e, float:1.993E-42)
            r1 = 4
            r0 = 114(0x72, float:1.6E-43)
            java.lang.String r0 = A0J(r2, r1, r0)
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L21
            r0 = 3
            goto La
        L21:
            r0 = 4
            goto La
        L23:
            java.lang.String r6 = (java.lang.String) r6
            r3 = r6
            r0 = 4
            goto La
        L28:
            r0 = 3
            goto La
        L2a:
            java.lang.String r3 = (java.lang.String) r3
            java.lang.String r3 = (java.lang.String) r3
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C0413Gc.A1O(java.lang.String, java.lang.String):java.lang.String");
    }

    public final void A1P(@Nullable String str) throws JSONException {
        A0S(str, null);
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0035, code lost:            return r6;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean A1Q(java.lang.String r5, boolean r6) {
        /*
            r4 = this;
            r0 = 0
            android.content.SharedPreferences r1 = r4.A00
            java.lang.String r0 = java.lang.String.valueOf(r6)
            java.lang.String r3 = r1.getString(r5, r0)
            if (r3 == 0) goto L33
            r0 = 2
        Le:
            switch(r0) {
                case 2: goto L12;
                case 3: goto L35;
                case 4: goto L27;
                default: goto L11;
            }
        L11:
            goto Le
        L12:
            java.lang.String r3 = (java.lang.String) r3
            r2 = 1422(0x58e, float:1.993E-42)
            r1 = 4
            r0 = 114(0x72, float:1.6E-43)
            java.lang.String r0 = A0J(r2, r1, r0)
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L25
            r0 = 3
            goto Le
        L25:
            r0 = 4
            goto Le
        L27:
            java.lang.String r3 = (java.lang.String) r3
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r3)
            boolean r6 = r0.booleanValue()
            r0 = 3
            goto Le
        L33:
            r0 = 3
            goto Le
        L35:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C0413Gc.A1Q(java.lang.String, boolean):boolean");
    }
}
