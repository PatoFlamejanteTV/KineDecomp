package com.adobe.creativesdk.foundation.storage;

import android.os.Handler;
import com.adobe.creativesdk.foundation.internal.utils.logging.Level;
import org.json.JSONException;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AdobeLibraryComposite.java */
/* renamed from: com.adobe.creativesdk.foundation.storage.fb, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0555fb implements c.a.a.a.b<Void> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ C0622wb f7244a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ String f7245b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ String f7246c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ c.a.a.a.b f7247d;

    /* renamed from: e, reason: collision with root package name */
    final /* synthetic */ Handler f7248e;

    /* renamed from: f, reason: collision with root package name */
    final /* synthetic */ String f7249f;

    /* renamed from: g, reason: collision with root package name */
    final /* synthetic */ C0614ub f7250g;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0555fb(C0614ub c0614ub, C0622wb c0622wb, String str, String str2, c.a.a.a.b bVar, Handler handler, String str3) {
        this.f7250g = c0614ub;
        this.f7244a = c0622wb;
        this.f7245b = str;
        this.f7246c = str2;
        this.f7247d = bVar;
        this.f7248e = handler;
        this.f7249f = str3;
    }

    @Override // c.a.a.a.b
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void b(Void r4) {
        try {
            this.f7250g.b(this.f7244a.c()).put(this.f7245b, "<cache>" + this.f7244a.c() + "/" + this.f7245b + "." + this.f7246c);
            this.f7250g.w();
            this.f7250g.a((c.a.a.a.b<String>) this.f7247d, this.f7248e, this.f7249f);
        } catch (JSONException e2) {
            com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.DEBUG, C0614ub.class.getSimpleName(), null, e2);
        }
    }
}
