package com.adobe.creativesdk.foundation.adobeinternal.entitlement;

import android.content.SharedPreferences;
import android.os.Handler;
import com.adobe.creativesdk.foundation.internal.auth.AdobeAuthIdentityManagementService;
import com.adobe.creativesdk.foundation.internal.auth.AdobeAuthKeychain;
import com.adobe.creativesdk.foundation.internal.cache.AdobeCommonCacheOptions;
import com.adobe.creativesdk.foundation.internal.net.F;
import com.adobe.creativesdk.foundation.internal.net.l;
import com.adobe.creativesdk.foundation.internal.utils.logging.Level;
import com.adobe.creativesdk.foundation.network.AdobeNetworkException;
import java.util.EnumSet;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AdobeEntitlementSession.java */
/* loaded from: classes.dex */
public class e implements F {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f3977a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ c.a.a.a.b f3978b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ Handler f3979c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ boolean f3980d;

    /* renamed from: e, reason: collision with root package name */
    final /* synthetic */ c.a.a.a.c f3981e;

    /* renamed from: f, reason: collision with root package name */
    final /* synthetic */ JSONObject f3982f;

    /* renamed from: g, reason: collision with root package name */
    final /* synthetic */ h f3983g;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(h hVar, String str, c.a.a.a.b bVar, Handler handler, boolean z, c.a.a.a.c cVar, JSONObject jSONObject) {
        this.f3983g = hVar;
        this.f3977a = str;
        this.f3978b = bVar;
        this.f3979c = handler;
        this.f3980d = z;
        this.f3981e = cVar;
        this.f3982f = jSONObject;
    }

    @Override // com.adobe.creativesdk.foundation.internal.net.F
    public void a(l lVar) {
        JSONObject jSONObject;
        SharedPreferences sharedPreferences;
        if (lVar.g() == 200) {
            try {
                jSONObject = c.a.a.a.c.b.b.a(lVar.d());
                e = null;
            } catch (AdobeEntitlementException e2) {
                e = e2;
                jSONObject = null;
            }
            if (e == null) {
                String c2 = AdobeAuthKeychain.r().c();
                if (c2 != null && jSONObject != null) {
                    com.adobe.creativesdk.foundation.internal.cache.d.b().a(jSONObject.toString(), c2, "profile", EnumSet.of(AdobeCommonCacheOptions.AdobeCommonCacheKeepInMemoryCache, AdobeCommonCacheOptions.AdobeCommonCacheKeepOnDiskCache), "com.adobe.cc.entitlements");
                    sharedPreferences = this.f3983g.k;
                    SharedPreferences.Editor edit = sharedPreferences.edit();
                    edit.putString("profile", jSONObject.toString());
                    edit.commit();
                }
                this.f3983g.a(jSONObject, this.f3977a, this.f3978b, this.f3979c);
                return;
            }
            if (this.f3980d) {
                JSONObject b2 = c.a.a.a.c.b.b.b();
                try {
                    b2.putOpt("userId", AdobeAuthIdentityManagementService.K().e());
                    this.f3983g.a(b2, this.f3977a, this.f3978b, this.f3979c);
                    return;
                } catch (JSONException e3) {
                    com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.ERROR, "getUserProfileForToken - JSON Exception", e3.getMessage());
                    this.f3983g.a(this.f3983g.a(lVar, (String) null, (String) null), this.f3981e, this.f3979c);
                    return;
                }
            }
            this.f3983g.a(this.f3983g.a(lVar, (String) null, (String) null), this.f3981e, this.f3979c);
        }
    }

    @Override // com.adobe.creativesdk.foundation.internal.net.F
    public void a(AdobeNetworkException adobeNetworkException) {
        JSONObject jSONObject;
        if ((adobeNetworkException.getStatusCode().intValue() == 404 || adobeNetworkException.getStatusCode().intValue() == 600 || adobeNetworkException.getStatusCode().intValue() == 400) && (jSONObject = this.f3982f) != null) {
            this.f3983g.a(jSONObject, this.f3977a, this.f3978b, this.f3979c);
        } else {
            this.f3983g.a(adobeNetworkException, this.f3981e, this.f3979c);
        }
    }
}
