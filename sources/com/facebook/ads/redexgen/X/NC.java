package com.facebook.ads.redexgen.X;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.util.Log;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import java.lang.ref.WeakReference;
import java.util.Set;

/* loaded from: assets/audience_network.dex */
public class NC extends WebViewClient {
    public static byte[] A02;
    public final WeakReference<C0362Ec> A00;
    public final WeakReference<InterfaceC0528Ks> A01;

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
            byte[] r1 = com.facebook.ads.redexgen.X.NC.A02
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
            r0 = r0 ^ 5
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.NC.A00(int, int, int):java.lang.String");
    }

    public static void A01() {
        A02 = new byte[]{41, 18, 23, 18, 19, 11, 18, 92, 25, 4, 31, 25, 12, 8, 21, 19, 18, 92, 19, 31, 31, 9, 14, 14, 25, 24, 92, 11, 20, 25, 18, 92, 8, 14, 5, 21, 18, 27, 92, 8, 19, 92, 20, 29, 18, 24, 16, 25, 92, 41, 46, 53, 82, 113, 126, 116, 98, Byte.MAX_VALUE, 121, 116, 62, 121, 126, 100, 117, 126, 100, 62, 113, 115, 100, 121, Byte.MAX_VALUE, 126, 62, 70, 89, 85, 71, 26, 56, 47, 50, 45, 50, 47, 34, 123, 53, 52, 47, 123, 61, 52, 46, 53, 63, 123, 47, 52, 123, 51, 58, 53, 63, 55, 62, 123, 14, 9, 18, 117};
    }

    public NC(WeakReference<InterfaceC0528Ks> weakReference, WeakReference<C0362Ec> weakReference2) {
        this.A01 = weakReference;
        this.A00 = weakReference2;
    }

    @Override // android.webkit.WebViewClient
    public final void onPageFinished(WebView webView, String str) {
        super.onPageFinished(webView, str);
        if (this.A01.get() != null) {
            this.A01.get().A7C(str);
        }
    }

    @Override // android.webkit.WebViewClient
    public final void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        super.onPageStarted(webView, str, bitmap);
        if (this.A01.get() != null) {
            this.A01.get().A7E(str);
        }
    }

    @Override // android.webkit.WebViewClient
    public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
        Set set;
        String str2;
        String str3;
        Uri uri = Uri.parse(str);
        set = NE.A09;
        if (!set.contains(uri.getScheme()) && this.A00.get() != null) {
            try {
                this.A00.get().startActivity(new Intent(A00(53, 26, 21), uri));
                return true;
            } catch (ActivityNotFoundException e) {
                str3 = NE.A08;
                Log.w(str3, A00(79, 33, 94), e);
            } catch (Exception e2) {
                str2 = NE.A08;
                Log.e(str2, A00(0, 53, 121), e2);
            }
        }
        return false;
    }
}
