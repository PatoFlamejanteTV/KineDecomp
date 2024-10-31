package com.adobe.creativesdk.foundation.adobeinternal.storage.dcx;

import com.facebook.internal.ServerProtocol;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

/* compiled from: AdobeDCXComponent.java */
/* renamed from: com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.c */
/* loaded from: classes.dex */
public class C0225c {

    /* renamed from: a */
    protected JSONObject f4326a;

    /* renamed from: b */
    protected WeakReference<Fa> f4327b;

    /* renamed from: c */
    protected String f4328c;

    /* renamed from: d */
    protected String f4329d;

    public C0225c(JSONObject jSONObject, Fa fa, String str, String str2) {
        this.f4326a = jSONObject;
        this.f4327b = new WeakReference<>(fa);
        this.f4328c = str;
        this.f4329d = str2;
    }

    public static C0225c a(JSONObject jSONObject, Fa fa, String str, String str2) {
        return new C0225c(jSONObject, fa, str, str2);
    }

    public String b() {
        return this.f4326a.optString("id");
    }

    public final JSONObject c() {
        return this.f4326a;
    }

    public String d() {
        return this.f4326a.optString("etag", null);
    }

    public int e() {
        return this.f4326a.optInt("height");
    }

    public long f() {
        return this.f4326a.optLong("length", -1L);
    }

    public Fa g() {
        WeakReference<Fa> weakReference = this.f4327b;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    public String h() {
        return this.f4326a.optString("md5", null);
    }

    public Ka i() {
        return new Ka(com.adobe.creativesdk.foundation.internal.storage.model.util.d.a(this.f4326a), g(), this.f4328c, this.f4329d);
    }

    public String j() {
        return this.f4326a.optString("name", null);
    }

    public String k() {
        return this.f4326a.optString("path", null);
    }

    public String l() {
        return this.f4326a.optString("rel", null);
    }

    public String m() {
        return this.f4326a.optString(ServerProtocol.DIALOG_PARAM_STATE, null);
    }

    public String n() {
        return this.f4326a.optString("type", null);
    }

    public String o() {
        return this.f4326a.optString(ServerProtocol.FALLBACK_DIALOG_PARAM_VERSION, null);
    }

    public int p() {
        return this.f4326a.optInt("width");
    }

    public boolean q() {
        Fa fa;
        WeakReference<Fa> weakReference = this.f4327b;
        return (weakReference == null || (fa = weakReference.get()) == null || !fa.a(this)) ? false : true;
    }

    public String a() {
        return Za.c(this.f4328c, k());
    }

    public final Object a(String str) {
        return this.f4326a.opt(str);
    }

    public C0225c() {
    }
}
