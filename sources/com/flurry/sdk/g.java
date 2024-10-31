package com.flurry.sdk;

import com.flurry.sdk.af;
import com.flurry.sdk.l;

/* loaded from: classes.dex */
public class g extends l implements af.a {

    /* renamed from: a, reason: collision with root package name */
    static String f482a;
    static String b = "http://data.flurry.com/aap.do";
    static String c = "https://data.flurry.com/aap.do";
    private boolean j;

    public g() {
        this(null);
    }

    g(l.a aVar) {
        super("Analytics", g.class.getSimpleName());
        this.i = "AnalyticsData_";
        g();
        a(aVar);
    }

    private void g() {
        af a2 = ae.a();
        this.j = ((Boolean) a2.a("UseHttps")).booleanValue();
        a2.a("UseHttps", (af.a) this);
        as.a(4, d, "initSettings, UseHttps = " + this.j);
        String str = (String) a2.a("ReportUrl");
        a2.a("ReportUrl", (af.a) this);
        b(str);
        as.a(4, d, "initSettings, ReportUrl = " + str);
    }

    @Override // com.flurry.sdk.af.a
    public void a(String str, Object obj) {
        if (str.equals("UseHttps")) {
            this.j = ((Boolean) obj).booleanValue();
            as.a(4, d, "onSettingUpdate, UseHttps = " + this.j);
        } else {
            if (str.equals("ReportUrl")) {
                String str2 = (String) obj;
                b(str2);
                as.a(4, d, "onSettingUpdate, ReportUrl = " + str2);
                return;
            }
            as.a(6, d, "onSettingUpdate internal error!");
        }
    }

    private void b(String str) {
        if (str != null && !str.endsWith(".do")) {
            as.a(5, d, "overriding analytics agent report URL without an endpoint, are you sure?");
        }
        f482a = str;
    }

    String a() {
        if (f482a != null) {
            return f482a;
        }
        if (this.j) {
            return c;
        }
        return b;
    }

    @Override // com.flurry.sdk.l
    protected void a(byte[] bArr, String str, String str2) {
        String a2 = a();
        as.a(4, d, "FlurryDataSender: start upload data " + bArr + " with id = " + str + " to " + a2);
        this.g.submit(new k(a2, str, str2, bArr, new h(this)));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.flurry.sdk.l
    public void a(String str, String str2, int i) {
        this.f.submit(new j(this, i));
        super.a(str, str2, i);
    }
}
