package com.adobe.creativesdk.foundation.adobeinternal.entitlement;

import android.content.SharedPreferences;
import com.adobe.creativesdk.foundation.internal.cache.AdobeCommonCacheHitLocation;
import com.adobe.creativesdk.foundation.internal.utils.logging.Level;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AdobeEntitlementSession.java */
/* loaded from: classes.dex */
public class a implements com.adobe.creativesdk.foundation.internal.cache.e<Object> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ReentrantLock f3963a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ b f3964b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ Condition f3965c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ h f3966d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(h hVar, ReentrantLock reentrantLock, b bVar, Condition condition) {
        this.f3966d = hVar;
        this.f3963a = reentrantLock;
        this.f3964b = bVar;
        this.f3965c = condition;
    }

    @Override // com.adobe.creativesdk.foundation.internal.cache.e
    public void a(Object obj, AdobeCommonCacheHitLocation adobeCommonCacheHitLocation) {
        JSONObject jSONObject;
        SharedPreferences sharedPreferences;
        SharedPreferences sharedPreferences2;
        try {
            jSONObject = new JSONObject((String) obj);
        } catch (JSONException e2) {
            e = e2;
            jSONObject = null;
        }
        try {
            sharedPreferences = this.f3966d.k;
            if (!sharedPreferences.contains("profile")) {
                sharedPreferences2 = this.f3966d.k;
                SharedPreferences.Editor edit = sharedPreferences2.edit();
                edit.putString("profile", (String) obj);
                edit.commit();
            }
        } catch (JSONException e3) {
            e = e3;
            com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.ERROR, h.class.getSimpleName(), null, e);
            this.f3963a.lock();
            this.f3964b.f3967a = true;
            this.f3964b.f3968b = jSONObject;
            this.f3965c.signal();
        }
        this.f3963a.lock();
        try {
            this.f3964b.f3967a = true;
            this.f3964b.f3968b = jSONObject;
            this.f3965c.signal();
        } finally {
            this.f3963a.unlock();
        }
    }

    @Override // com.adobe.creativesdk.foundation.internal.cache.e
    public void a() {
        this.f3963a.lock();
        try {
            this.f3964b.f3967a = true;
            this.f3965c.signal();
        } finally {
            this.f3963a.unlock();
        }
    }
}
