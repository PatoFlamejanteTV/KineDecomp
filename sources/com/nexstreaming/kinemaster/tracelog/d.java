package com.nexstreaming.kinemaster.tracelog;

import android.content.Context;
import com.nexstreaming.app.general.task.ResultTask;
import com.nexstreaming.app.general.tracelog.AppUsage;
import com.nexstreaming.app.general.tracelog.AuthPromocodeRequest;
import com.nexstreaming.app.general.tracelog.AuthPromocodeResponse;
import com.nexstreaming.app.general.tracelog.CpLoginInfoRequest;
import com.nexstreaming.app.general.tracelog.CpLoginInfoResponse;
import com.nexstreaming.app.general.tracelog.CpOrderIdRequest;
import com.nexstreaming.app.general.tracelog.CpOrderIdResponse;
import com.nexstreaming.app.general.tracelog.CpOrderListRequest;
import com.nexstreaming.app.general.tracelog.CpOrderListResponse;
import com.nexstreaming.app.general.tracelog.CpProductListRequest;
import com.nexstreaming.app.general.tracelog.CpProductListResponse;
import com.nexstreaming.app.general.tracelog.DeviceSupportRequest;
import com.nexstreaming.app.general.tracelog.DeviceSupportResponse;
import com.nexstreaming.app.general.tracelog.GoogleProductListRequest;
import com.nexstreaming.app.general.tracelog.GoogleProductListResponse;
import com.nexstreaming.app.general.tracelog.NotifyAppRequest;
import com.nexstreaming.app.general.tracelog.NotifyAppResponse;
import com.nexstreaming.app.general.tracelog.RegisterIAPRequest;
import com.nexstreaming.app.general.tracelog.RegisterIAPResponse;
import com.nexstreaming.app.general.tracelog.f;
import com.nexstreaming.app.general.tracelog.g;
import com.nexstreaming.app.general.tracelog.h;
import com.nexstreaming.app.general.tracelog.i;
import com.nexstreaming.app.general.tracelog.j;
import com.nexstreaming.app.general.tracelog.m;
import com.nexstreaming.app.general.tracelog.o;
import com.nextreaming.nexeditorui.EditorGlobal;
import com.nextreaming.nexeditorui.av;
import java.net.URI;

/* compiled from: KineMasterTraceLog.java */
/* loaded from: classes.dex */
public class d {
    private static final byte[] p = {34, 2, 41, 7, 5, 47, 29, 29, 101, 49, 49, 63, 50, 101, 41, 4, 37, 13, 101, 43, 14, 49, 41, 101, 48, 10, 16, 14, 101, 62, 122, 123, 11, 62, 5, 18, 7};
    private static final byte[] q = {112, 120, 114, 118, 66, 76, 85, 70, 12, 71, 78, 98, 68, 12, 85, 78, 64, 82, 12, 91, 72, 67, 114, 12, 103, 101, 25, 78, 12, 25, 109, 18, 21, 82, 105, 74, 75};
    private static final byte[] r = {82, 109, 121, 47, 110, 95, 111, 111, 48, 120, 78, 76, 126, 48, 113, 100, 46, 86, 48, 91, 107, 119, 95, 48, 103, 79, 109, 91, 48, 69, 92, 117, 73, 126, 120, 114, 45};
    private static final String[] s = {"https://api-tracelog.nexstreaming.com/registerapp/"};

    @Deprecated
    private static final String[] t = {"https://api-tracelog.nexstreaming.com/updateapp/"};
    private static final String[] u = {"https://api-tracelog.nexstreaming.com/usageapp/"};
    private static final String[] v = {"https://api-tracelog.nexstreaming.com/notifyapp/"};

    /* renamed from: a */
    public static final String[] f3644a = {"https://api-kinemaster.nexstreaming.com/authpromocode/"};
    public static final String[] b = {"https://api-kinemaster.nexstreaming.com/getproductlist/"};
    public static final String[] c = {"https://api-kinemaster.nexstreaming.com/updatekmdevicelist/"};
    public static final String[] d = {"https://api-kinemaster.nexstreaming.com/registeriap/"};
    public static final String[] e = {"https://api-kinemaster.nexstreaming.com/themedownload/"};
    public static final String[] f = {"https://api-kinemaster-cn.nexstreaming.com/themedownload/", "https://api-kinemaster.nexstreaming.com/themedownload/"};
    public static final String[] g = {"https://api-kinemaster-cn.nexstreaming.com/v1/%s/getproductlist/"};
    public static final String[] h = {"https://api-kinemaster-cn.nexstreaming.com/v1/%s/setlogininfo/"};
    public static final String[] i = {"https://api-kinemaster-cn.nexstreaming.com/v1/%s/getcporderid/"};
    public static final String[] j = {"https://api-kinemaster-cn.nexstreaming.com/v1/%s/getcporderlist/"};
    private static final String[] w = {"https://test-api-tracelog.nexstreaming.com/registerapp/"};
    private static final String[] x = {"https://test-api-tracelog.nexstreaming.com/updateapp/"};
    private static final String[] y = {"https://test-api-tracelog.nexstreaming.com/usageapp/"};
    private static final String[] z = {"https://test-api-tracelog.nexstreaming.com/notifyapp/"};
    private static final String[] A = {"https://test-api-kinemaster.nexstreaming.com/authpromocode/"};
    private static final String[] B = {"https://test-api-kinemaster.nexstreaming.com/getproductlist/"};
    private static final String[] C = {"https://test-api-kinemaster.nexstreaming.com/registeriap/"};
    private static final String[] D = {"https://test-api-kinemaster.nexstreaming.com/updatekmdevicelist/"};
    public static final String[] k = {"https://test-api-kinemaster.nexstreaming.com/themedownload/"};
    public static final String[] l = {"https://test-api-kinemaster-cn.nexstreaming.com/v1/%s/getproductlist/"};
    public static final String[] m = {"https://test-api-kinemaster-cn.nexstreaming.com/v1/%s/setlogininfo/"};
    public static final String[] n = {"https://test-api-kinemaster-cn.nexstreaming.com/v1/%s/getcporderid/"};
    public static final String[] o = {"https://test-api-kinemaster-cn.nexstreaming.com/v1/%s/getcporderlist/"};

    private static String f(Context context) {
        byte[] bArr;
        byte b2;
        if (context.getPackageName().equals("com.nexstreaming.app.kinemaster")) {
            bArr = p;
            b2 = 72;
        } else if (context.getPackageName().equals("com.nexstreaming.app.kinemasterfree")) {
            bArr = q;
            b2 = 33;
        } else if (context.getPackageName().equals("com.nexstreaming.app.kinemaster.beta")) {
            bArr = r;
            b2 = 29;
        } else {
            throw new InternalError("Bad package name");
        }
        StringBuilder sb = new StringBuilder(bArr.length);
        for (byte b3 : bArr) {
            sb.appendCodePoint(b3 ^ b2);
        }
        return sb.toString();
    }

    public static void a(Context context, String str) {
        String[] a2 = av.a().a(s);
        URI[] uriArr = new URI[a2.length];
        for (int i2 = 0; i2 < a2.length; i2++) {
            uriArr[i2] = URI.create(a2[i2]);
        }
        o.a(context, "kinemaster_registered_version", f(context), uriArr, str);
    }

    public static AppUsage a(Context context) {
        return AppUsage.a(context, f(context), av.a().b(u), EditorGlobal.e ? AppUsage.ReportingMode.FLURRY : AppUsage.ReportingMode.NEXSTREAMING_USAGEAPP, "JP3SX25DKCXTXY7YV6GV");
    }

    public static ResultTask<NotifyAppResponse> b(Context context) {
        String[] c2 = av.a().c(v);
        URI[] uriArr = new URI[c2.length];
        for (int i2 = 0; i2 < c2.length; i2++) {
            uriArr[i2] = URI.create(c2[i2]);
        }
        return j.a(uriArr, new NotifyAppRequest(context, f(context), EditorGlobal.b()));
    }

    public static ResultTask<RegisterIAPResponse> a(Context context, String str, String str2, String str3, String str4) {
        String[] f2 = av.a().f(d);
        URI[] uriArr = new URI[f2.length];
        for (int i2 = 0; i2 < f2.length; i2++) {
            uriArr[i2] = URI.create(f2[i2]);
        }
        return m.a(context).a(uriArr, (URI[]) new RegisterIAPRequest(context, f(context), str, str2, str3, str4));
    }

    public static ResultTask<AuthPromocodeResponse> a(Context context, String str, String str2) {
        String[] g2 = av.a().g(av.a().d() ? A : f3644a);
        URI[] uriArr = new URI[g2.length];
        for (int i2 = 0; i2 < g2.length; i2++) {
            uriArr[i2] = URI.create(g2[i2]);
        }
        return com.nexstreaming.app.general.tracelog.c.a(context).a(uriArr, (URI[]) new AuthPromocodeRequest(context, f(context), str, str2));
    }

    public static ResultTask<GoogleProductListResponse> c(Context context) {
        String[] h2 = av.a().h(av.a().d() ? B : b);
        URI[] uriArr = new URI[h2.length];
        for (int i2 = 0; i2 < h2.length; i2++) {
            uriArr[i2] = URI.create(h2[i2]);
        }
        return i.a(context).a(uriArr, (URI[]) new GoogleProductListRequest(context, f(context)));
    }

    public static ResultTask<DeviceSupportResponse> d(Context context) {
        String[] d2 = av.a().d(c);
        URI[] uriArr = new URI[d2.length];
        for (int i2 = 0; i2 < d2.length; i2++) {
            uriArr[i2] = URI.create(d2[i2]);
        }
        return h.a(context).a(uriArr, (URI[]) new DeviceSupportRequest(context, f(context)));
    }

    public static ResultTask<DeviceSupportResponse> e(Context context) {
        String[] d2 = av.a().d(c);
        URI[] uriArr = new URI[d2.length];
        for (int i2 = 0; i2 < d2.length; i2++) {
            uriArr[i2] = URI.create(d2[i2]);
        }
        return h.a(context).b(uriArr, new DeviceSupportRequest(context, f(context)));
    }

    public static ResultTask<CpProductListResponse> a(Context context, String str, long j2) {
        return b(context, str, String.valueOf(j2));
    }

    public static ResultTask<CpProductListResponse> b(Context context, String str, String str2) {
        String[] i2 = av.a().i(av.a().d() ? l : g);
        String[] strArr = new String[i2.length];
        for (int i3 = 0; i3 < i2.length; i3++) {
            strArr[i3] = String.format(i2[i3], str.toLowerCase());
        }
        URI[] uriArr = new URI[strArr.length];
        for (int i4 = 0; i4 < strArr.length; i4++) {
            uriArr[i4] = URI.create(strArr[i4]);
        }
        return g.a(context, str, str2).a(uriArr, (URI[]) new CpProductListRequest(context, f(context), str2, av.a().f()));
    }

    public static ResultTask<CpLoginInfoResponse> a(Context context, String str, long j2, String str2) {
        return a(context, str, String.valueOf(j2), str2);
    }

    public static ResultTask<CpLoginInfoResponse> a(Context context, String str, String str2, String str3) {
        String[] j2 = av.a().j(av.a().d() ? m : h);
        String[] strArr = new String[j2.length];
        for (int i2 = 0; i2 < j2.length; i2++) {
            strArr[i2] = String.format(j2[i2], str.toLowerCase());
        }
        URI[] uriArr = new URI[strArr.length];
        for (int i3 = 0; i3 < strArr.length; i3++) {
            uriArr[i3] = URI.create(strArr[i3]);
        }
        return com.nexstreaming.app.general.tracelog.d.a(context).a(uriArr, (URI[]) new CpLoginInfoRequest(context, f(context), str2, str3));
    }

    public static ResultTask<CpOrderIdResponse> a(Context context, String str, String str2, long j2, int i2) {
        return a(context, str, str2, String.valueOf(j2), i2, null);
    }

    public static ResultTask<CpOrderIdResponse> a(Context context, String str, String str2, String str3, int i2, String str4) {
        String[] k2 = av.a().k(av.a().d() ? n : i);
        String[] strArr = new String[k2.length];
        for (int i3 = 0; i3 < k2.length; i3++) {
            strArr[i3] = String.format(k2[i3], str.toLowerCase());
        }
        URI[] uriArr = new URI[strArr.length];
        for (int i4 = 0; i4 < strArr.length; i4++) {
            uriArr[i4] = URI.create(strArr[i4]);
        }
        return com.nexstreaming.app.general.tracelog.e.a(context).a(uriArr, (URI[]) new CpOrderIdRequest(context, f(context), str2, str3, i2, str4));
    }

    public static ResultTask<CpOrderListResponse> a(Context context, String str, long j2, boolean z2) {
        return a(context, str, String.valueOf(j2), z2);
    }

    public static ResultTask<CpOrderListResponse> a(Context context, String str, String str2, boolean z2) {
        String[] l2 = av.a().l(av.a().d() ? o : j);
        String[] strArr = new String[l2.length];
        for (int i2 = 0; i2 < l2.length; i2++) {
            strArr[i2] = String.format(l2[i2], str.toLowerCase());
        }
        URI[] uriArr = new URI[strArr.length];
        for (int i3 = 0; i3 < strArr.length; i3++) {
            uriArr[i3] = URI.create(strArr[i3]);
        }
        f a2 = f.a(context, str, str2);
        if (z2) {
            a2.c();
        }
        return a2.a(uriArr, (URI[]) new CpOrderListRequest(context, f(context), str2));
    }
}
