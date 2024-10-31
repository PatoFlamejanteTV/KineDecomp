package com.umeng.commonsdk.statistics;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.framework.UMEnvelopeBuild;
import com.umeng.commonsdk.framework.UMFrUtils;
import com.umeng.commonsdk.internal.crash.UMCrashManager;
import com.umeng.commonsdk.proguard.ab;
import com.umeng.commonsdk.proguard.m;
import com.umeng.commonsdk.statistics.common.MLog;
import com.umeng.commonsdk.statistics.common.ReportPolicy;
import com.umeng.commonsdk.statistics.idtracking.ImprintHandler;
import com.umeng.commonsdk.statistics.idtracking.e;
import com.umeng.commonsdk.statistics.internal.PreferenceWrapper;
import com.umeng.commonsdk.statistics.internal.StatTracer;
import com.umeng.commonsdk.statistics.internal.d;
import com.umeng.commonsdk.statistics.noise.ABTest;
import com.umeng.commonsdk.statistics.noise.Defcon;
import com.umeng.commonsdk.statistics.proto.Response;
import java.io.File;

/* compiled from: NetWorkManager.java */
/* loaded from: classes3.dex */
public class c {

    /* renamed from: b, reason: collision with root package name */
    private static final int f26360b = 1;

    /* renamed from: c, reason: collision with root package name */
    private static final int f26361c = 2;

    /* renamed from: d, reason: collision with root package name */
    private static final int f26362d = 3;
    private static final String o = "thtstart";
    private static final String p = "gkvc";
    private static final String q = "ekvc";

    /* renamed from: a, reason: collision with root package name */
    String f26363a;

    /* renamed from: f, reason: collision with root package name */
    private com.umeng.commonsdk.statistics.internal.c f26365f;

    /* renamed from: g, reason: collision with root package name */
    private ImprintHandler f26366g;

    /* renamed from: h, reason: collision with root package name */
    private e f26367h;
    private ImprintHandler.a i;
    private Defcon k;
    private long l;
    private int m;
    private int n;
    private Context r;

    /* renamed from: e, reason: collision with root package name */
    private final int f26364e = 1;
    private ABTest j = null;
    private ReportPolicy.ReportStrategy s = null;

    public c(Context context) {
        this.i = null;
        this.k = null;
        this.l = 0L;
        this.m = 0;
        this.n = 0;
        this.f26363a = null;
        this.r = context;
        this.i = ImprintHandler.getImprintService(this.r).c();
        this.k = Defcon.getService(this.r);
        SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(this.r);
        this.l = sharedPreferences.getLong(o, 0L);
        this.m = sharedPreferences.getInt(p, 0);
        this.n = sharedPreferences.getInt(q, 0);
        this.f26363a = UMEnvelopeBuild.imprintProperty(this.r, "track_list", null);
        this.f26366g = ImprintHandler.getImprintService(this.r);
        this.f26366g.a(new d() { // from class: com.umeng.commonsdk.statistics.c.1
            @Override // com.umeng.commonsdk.statistics.internal.d
            public void onImprintChanged(ImprintHandler.a aVar) {
                Class<?> cls;
                c.this.k.onImprintChanged(aVar);
                c cVar = c.this;
                cVar.f26363a = UMEnvelopeBuild.imprintProperty(cVar.r, "track_list", null);
                try {
                    String a2 = com.umeng.commonsdk.framework.a.a(c.this.r, com.umeng.commonsdk.proguard.e.f26238e, (String) null);
                    if (TextUtils.isEmpty(a2) || (cls = Class.forName("com.umeng.commonsdk.internal.utils.SDStorageAgent")) == null) {
                        return;
                    }
                    cls.getMethod("updateUMTT", Context.class, String.class).invoke(cls, c.this.r, a2);
                } catch (Throwable unused) {
                }
            }
        });
        this.f26367h = e.a(this.r);
        this.f26365f = new com.umeng.commonsdk.statistics.internal.c(this.r);
        this.f26365f.a(StatTracer.getInstance(this.r));
    }

    public boolean a(File file) {
        if (file == null) {
            return false;
        }
        try {
            byte[] byteArray = UMFrUtils.toByteArray(file.getPath());
            if (byteArray == null) {
                return false;
            }
            com.umeng.commonsdk.statistics.internal.a.a(this.r).c(file.getName());
            byte[] a2 = this.f26365f.a(byteArray, com.umeng.commonsdk.statistics.internal.a.a(this.r).a(file.getName()));
            int a3 = a2 == null ? 1 : a(a2);
            if (a3 != 1) {
                if (a3 == 2) {
                    this.f26367h.d();
                    StatTracer.getInstance(this.r).saveSate();
                } else if (a3 == 3) {
                    StatTracer.getInstance(this.r).saveSate();
                }
            }
            return a3 == 2;
        } catch (Throwable th) {
            UMCrashManager.reportCrash(this.r, th);
            return false;
        }
    }

    private int a(byte[] bArr) {
        Response response = new Response();
        try {
            new m(new ab.a()).a(response, bArr);
            if (response.resp_code == 1) {
                this.f26366g.b(response.getImprint());
                this.f26366g.d();
            }
            MLog.i("send log:" + response.getMsg());
            UMRTLog.i(UMRTLog.RTLOG_TAG, "send log: " + response.getMsg());
        } catch (Throwable th) {
            UMCrashManager.reportCrash(this.r, th);
        }
        return response.resp_code == 1 ? 2 : 3;
    }
}
