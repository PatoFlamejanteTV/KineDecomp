package com.nexstreaming.kinemaster.tracelog;

import android.content.Context;
import android.util.Log;
import com.facebook.stetho.dumpapp.Framer;
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
import com.nexstreaming.app.general.tracelog.CpRestoreLoginInfoRequest;
import com.nexstreaming.app.general.tracelog.CpRestoreLoginInfoResponse;
import com.nexstreaming.app.general.tracelog.DeviceSupportRequest;
import com.nexstreaming.app.general.tracelog.DeviceSupportResponse;
import com.nexstreaming.app.general.tracelog.NotifyAppRequest;
import com.nexstreaming.app.general.tracelog.NotifyAppResponse;
import com.nexstreaming.app.general.tracelog.h;
import com.nexstreaming.app.general.tracelog.j;
import com.nexstreaming.app.general.tracelog.l;
import com.nexstreaming.app.general.tracelog.n;
import com.nexstreaming.app.general.tracelog.p;
import com.nexstreaming.app.general.tracelog.r;
import com.nextreaming.nexeditorui.E;
import com.nextreaming.nexeditorui.EditorGlobal;
import com.umeng.commonsdk.proguard.ap;
import java.net.URI;
import java.util.Locale;

/* compiled from: KineMasterTraceLog.java */
/* loaded from: classes.dex */
public class f {

    /* renamed from: a, reason: collision with root package name */
    private static final byte[] f21287a = {34, 2, 41, 7, 5, 47, 29, 29, 101, Framer.STDOUT_FRAME_PREFIX, Framer.STDOUT_FRAME_PREFIX, 63, Framer.STDERR_FRAME_PREFIX, 101, 41, 4, 37, ap.k, 101, 43, ap.l, Framer.STDOUT_FRAME_PREFIX, 41, 101, 48, 10, ap.n, ap.l, 101, 62, 122, 123, 11, 62, 5, 18, 7};

    /* renamed from: b, reason: collision with root package name */
    private static final byte[] f21288b = {112, Framer.EXIT_FRAME_PREFIX, 114, 118, 66, 76, 85, 70, 12, 71, 78, 98, 68, 12, 85, 78, 64, 82, 12, 91, 72, 67, 114, 12, 103, 101, 25, 78, 12, 25, 109, 18, 21, 82, 105, 74, 75};

    /* renamed from: c, reason: collision with root package name */
    private static final byte[] f21289c = {82, 109, 121, 47, 110, Framer.STDIN_REQUEST_FRAME_PREFIX, 111, 111, 48, Framer.EXIT_FRAME_PREFIX, 78, 76, 126, 48, 113, 100, 46, 86, 48, 91, 107, 119, Framer.STDIN_REQUEST_FRAME_PREFIX, 48, 103, 79, 109, 91, 48, 69, 92, 117, 73, 126, Framer.EXIT_FRAME_PREFIX, 114, Framer.STDIN_FRAME_PREFIX};

    /* renamed from: d, reason: collision with root package name */
    private static final byte[] f21290d = {Framer.STDIN_REQUEST_FRAME_PREFIX, ap.n, 29, 121, 29, 69, 121, 115, 4, 66, 64, 104, 30, 4, Framer.EXIT_FRAME_PREFIX, 64, 70, Byte.MAX_VALUE, 4, 94, 74, 81, 96, 4, 91, 107, 110, 74, 4, 89, 80, 64, 123, 103, 80, 25, 67};

    /* renamed from: e, reason: collision with root package name */
    private static final String[] f21291e = {"https://api-tracelog.nexstreaming.com/registerapp/"};

    /* renamed from: f, reason: collision with root package name */
    @Deprecated
    private static final String[] f21292f = {"https://api-tracelog.nexstreaming.com/updateapp/"};

    /* renamed from: g, reason: collision with root package name */
    private static final String[] f21293g = {"https://api-tracelog.nexstreaming.com/usageapp/"};

    /* renamed from: h, reason: collision with root package name */
    private static final String[] f21294h = {"https://api-tracelog.nexstreaming.com/notifyapp/"};
    public static final String[] i = {"https://api-kinemaster.nexstreaming.com/authpromocode/"};
    public static final String[] j = {"https://api-kinemaster.nexstreaming.com/getproductlist/"};
    public static final String[] k = {"https://api-kinemaster.nexstreaming.com/updatekmdevicelist/"};
    public static final String[] l = {"https://api-kinemaster.nexstreaming.com/themedownload/"};
    public static final String[] m = {"https://api-kinemaster-cn.nexstreaming.com/themedownload/", "https://api-kinemaster.nexstreaming.com/themedownload/"};
    public static final String[] n = {"https://api-kinemaster-cn.nexstreaming.com/v5/%s/getproductlist/"};
    public static final String[] o = {"https://api-kinemaster-cn.nexstreaming.com/v3/%s/setlogininfo/"};
    public static final String[] p = {"https://api-kinemaster-cn.nexstreaming.com/v3/%s/setrestorelogininfo/"};
    public static final String[] q = {"https://api-kinemaster-cn.nexstreaming.com/v5/%s/getcporderid/"};
    public static final String[] r = {"https://api-kinemaster-cn.nexstreaming.com/v3/%s/getcporderlist/"};
    private static final String[] s = {"https://test-api-tracelog.nexstreaming.com/registerapp/"};
    private static final String[] t = {"https://test-api-tracelog.nexstreaming.com/updateapp/"};
    private static final String[] u = {"https://test-api-tracelog.nexstreaming.com/usageapp/"};
    private static final String[] v = {"https://test-api-tracelog.nexstreaming.com/notifyapp/"};
    private static final String[] w = {"https://test-api-kinemaster.nexstreaming.com/authpromocode/"};
    private static final String[] x = {"https://test-api-kinemaster.nexstreaming.com/getproductlist/"};
    private static final String[] y = {"https://test-api-kinemaster.nexstreaming.com/updatekmdevicelist/"};
    public static final String[] z = {"https://test-api-kinemaster.nexstreaming.com/themedownload/"};
    public static final String[] A = {"https://test-api-kinemaster-cn.nexstreaming.com/v5/%s/getproductlist/"};
    public static final String[] B = {"https://test-api-kinemaster-cn.nexstreaming.com/v3/%s/setlogininfo/"};
    public static final String[] C = {"https://test-api-kinemaster-cn.nexstreaming.com/v3/%s/setrestorelogininfo/"};
    public static final String[] D = {"https://test-api-kinemaster-cn.nexstreaming.com/v5/%s/getcporderid/"};
    public static final String[] E = {"https://test-api-kinemaster-cn.nexstreaming.com/v3/%s/getcporderlist/"};
    public static final String[] F = {"https://api-kinemaster-assetstore.nexstreaming.com/v1/asset/getinfo"};
    public static final String[] G = {"https://api-kinemaster-assetstore.nexstreaming.com/v1/category/getlist"};

    public static ResultTask<AuthPromocodeResponse> a(Context context, String str, String str2) {
        String[] b2 = E.c().b(E.c().e() ? w : i);
        URI[] uriArr = new URI[b2.length];
        for (int i2 = 0; i2 < b2.length; i2++) {
            uriArr[i2] = URI.create(b2[i2]);
        }
        return com.nexstreaming.app.general.tracelog.d.a(context).a(uriArr, (URI[]) new AuthPromocodeRequest(context, d(context), str, str2));
    }

    public static ResultTask<NotifyAppResponse> b(Context context) {
        String[] h2 = E.c().h(f21294h);
        URI[] uriArr = new URI[h2.length];
        for (int i2 = 0; i2 < h2.length; i2++) {
            uriArr[i2] = URI.create(h2[i2]);
        }
        return r.a(uriArr, new NotifyAppRequest(context, d(context), EditorGlobal.h()));
    }

    public static AppUsage c(Context context) {
        return AppUsage.a(context, d(context), E.c().i(f21293g), EditorGlobal.o ? AppUsage.ReportingMode.FLURRY : AppUsage.ReportingMode.NEXSTREAMING_USAGEAPP, "JP3SX25DKCXTXY7YV6GV");
    }

    private static String d(Context context) {
        byte[] bArr;
        byte b2;
        if (context.getPackageName().equals("com.nexstreaming.app.kinemaster")) {
            bArr = f21287a;
            b2 = 72;
        } else if (context.getPackageName().equals("com.nexstreaming.app.kinemasterfree")) {
            bArr = f21288b;
            b2 = Framer.ENTER_FRAME_PREFIX;
        } else if (context.getPackageName().equals("com.nexstreaming.app.kinemaster.beta")) {
            bArr = f21289c;
            b2 = 29;
        } else if (context.getPackageName().equals("com.kinemaster.app.galaxyapps")) {
            bArr = f21290d;
            b2 = 41;
        } else {
            throw new InternalError("Bad package name");
        }
        StringBuilder sb = new StringBuilder(bArr.length);
        for (byte b3 : bArr) {
            sb.appendCodePoint(b3 ^ b2);
        }
        return sb.toString();
    }

    public static ResultTask<CpProductListResponse> b(Context context, String str, String str2) {
        Log.d("WxTest", "getCpProductListFromNexServer start");
        String[] a2 = E.c().a(E.c().e() ? A : n);
        String[] strArr = new String[a2.length];
        for (int i2 = 0; i2 < a2.length; i2++) {
            strArr[i2] = String.format(a2[i2], str.toLowerCase(Locale.ENGLISH));
        }
        URI[] uriArr = new URI[strArr.length];
        for (int i3 = 0; i3 < strArr.length; i3++) {
            uriArr[i3] = URI.create(strArr[i3]);
            Log.d("WxTest", "serverlist : " + strArr[i3]);
        }
        CpProductListRequest cpProductListRequest = new CpProductListRequest(context, d(context), str2, E.c().f());
        return E.c().f() ? l.a(context, str, str2).b(uriArr, cpProductListRequest) : l.a(context, str, str2).a(uriArr, (URI[]) cpProductListRequest);
    }

    public static ResultTask<DeviceSupportResponse> a(Context context) {
        String[] g2 = E.c().g(k);
        URI[] uriArr = new URI[g2.length];
        for (int i2 = 0; i2 < g2.length; i2++) {
            uriArr[i2] = URI.create(g2[i2]);
        }
        return p.a(context).a(uriArr, (URI[]) new DeviceSupportRequest(context, d(context)));
    }

    public static ResultTask<CpLoginInfoResponse> a(Context context, String str, String str2, String str3) {
        String[] e2 = E.c().e(E.c().e() ? B : o);
        String[] strArr = new String[e2.length];
        for (int i2 = 0; i2 < e2.length; i2++) {
            strArr[i2] = String.format(e2[i2], str.toLowerCase(Locale.ENGLISH));
        }
        URI[] uriArr = new URI[strArr.length];
        for (int i3 = 0; i3 < strArr.length; i3++) {
            uriArr[i3] = URI.create(strArr[i3]);
        }
        return com.nexstreaming.app.general.tracelog.f.a(context).a(uriArr, (URI[]) new CpLoginInfoRequest(context, d(context), str2, str3));
    }

    public static ResultTask<CpRestoreLoginInfoResponse> a(Context context, String str, String str2, String str3, String str4) {
        String[] f2 = E.c().f(E.c().e() ? C : p);
        String[] strArr = new String[f2.length];
        for (int i2 = 0; i2 < f2.length; i2++) {
            strArr[i2] = String.format(f2[i2], str.toLowerCase(Locale.ENGLISH));
        }
        URI[] uriArr = new URI[strArr.length];
        for (int i3 = 0; i3 < strArr.length; i3++) {
            uriArr[i3] = URI.create(strArr[i3]);
        }
        return n.a(context).a(uriArr, (URI[]) new CpRestoreLoginInfoRequest(context, d(context), str2, str3, str4));
    }

    public static ResultTask<CpOrderIdResponse> a(Context context, String str, String str2, String str3, String str4, int i2, String str5, String str6) {
        String[] c2 = E.c().c(E.c().e() ? D : q);
        String[] strArr = new String[c2.length];
        for (int i3 = 0; i3 < c2.length; i3++) {
            strArr[i3] = String.format(c2[i3], str.toLowerCase(Locale.ENGLISH));
        }
        URI[] uriArr = new URI[strArr.length];
        for (int i4 = 0; i4 < strArr.length; i4++) {
            uriArr[i4] = URI.create(strArr[i4]);
        }
        return h.a(context).a(uriArr, (URI[]) new CpOrderIdRequest(context, d(context), str2, str3, str4, i2, str5, str6));
    }

    public static ResultTask<CpOrderListResponse> a(Context context, String str, String str2, boolean z2) {
        String[] d2 = E.c().d(E.c().e() ? E : r);
        String[] strArr = new String[d2.length];
        for (int i2 = 0; i2 < d2.length; i2++) {
            strArr[i2] = String.format(d2[i2], str.toLowerCase(Locale.ENGLISH));
        }
        URI[] uriArr = new URI[strArr.length];
        for (int i3 = 0; i3 < strArr.length; i3++) {
            uriArr[i3] = URI.create(strArr[i3]);
        }
        j a2 = j.a(context, str, str2);
        if (z2) {
            a2.b();
        }
        return a2.a(uriArr, (URI[]) new CpOrderListRequest(context, d(context), str2));
    }
}
