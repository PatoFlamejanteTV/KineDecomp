package com.adobe.creativesdk.foundation.storage;

import android.os.Handler;
import com.adobe.creativesdk.foundation.internal.utils.logging.Level;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AdobeLibraryComposite.java */
/* renamed from: com.adobe.creativesdk.foundation.storage.sb, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0606sb implements c.a.a.a.b<Void> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f7416a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ String f7417b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ String f7418c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ JSONObject f7419d;

    /* renamed from: e, reason: collision with root package name */
    final /* synthetic */ c.a.a.a.b f7420e;

    /* renamed from: f, reason: collision with root package name */
    final /* synthetic */ Handler f7421f;

    /* renamed from: g, reason: collision with root package name */
    final /* synthetic */ C0614ub f7422g;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0606sb(C0614ub c0614ub, String str, String str2, String str3, JSONObject jSONObject, c.a.a.a.b bVar, Handler handler) {
        this.f7422g = c0614ub;
        this.f7416a = str;
        this.f7417b = str2;
        this.f7418c = str3;
        this.f7419d = jSONObject;
        this.f7420e = bVar;
        this.f7421f = handler;
    }

    @Override // c.a.a.a.b
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void b(Void r4) {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f7416a);
        sb.append("/");
        sb.append(this.f7417b);
        sb.append("/");
        String str = this.f7418c;
        sb.append(str.substring(str.lastIndexOf("/") + 1));
        try {
            this.f7419d.put(this.f7417b, sb.toString());
            this.f7422g.w();
            if (this.f7420e != null) {
                this.f7422g.a((c.a.a.a.b<String>) this.f7420e, this.f7421f, this.f7418c);
            }
        } catch (JSONException e2) {
            com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.DEBUG, C0614ub.class.getSimpleName(), null, e2);
        }
    }
}
