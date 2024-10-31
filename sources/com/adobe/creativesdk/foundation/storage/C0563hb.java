package com.adobe.creativesdk.foundation.storage;

import android.os.Handler;
import com.adobe.creativesdk.foundation.internal.utils.logging.Level;
import org.json.JSONException;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AdobeLibraryComposite.java */
/* renamed from: com.adobe.creativesdk.foundation.storage.hb, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0563hb implements c.a.a.a.b<String> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f7274a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ String f7275b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ c.a.a.a.b f7276c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ Handler f7277d;

    /* renamed from: e, reason: collision with root package name */
    final /* synthetic */ C0614ub f7278e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0563hb(C0614ub c0614ub, String str, String str2, c.a.a.a.b bVar, Handler handler) {
        this.f7278e = c0614ub;
        this.f7274a = str;
        this.f7275b = str2;
        this.f7276c = bVar;
        this.f7277d = handler;
    }

    @Override // c.a.a.a.b
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void b(String str) {
        try {
            this.f7278e.b(this.f7274a).put(this.f7275b, str);
            this.f7278e.w();
            if (this.f7276c != null) {
                this.f7278e.a((c.a.a.a.b<String>) this.f7276c, this.f7277d, str);
            }
        } catch (JSONException e2) {
            com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.DEBUG, C0614ub.class.getSimpleName(), null, e2);
        }
    }
}
