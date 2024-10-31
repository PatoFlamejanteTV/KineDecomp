package com.nexstreaming.app.general.service.notification;

import android.graphics.Bitmap;
import com.android.volley.VolleyError;
import com.android.volley.a.m;

/* compiled from: NotificationHelper.java */
/* loaded from: classes2.dex */
class a implements m.d {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ b f19729a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(b bVar) {
        this.f19729a = bVar;
    }

    @Override // com.android.volley.a.m.d
    public void a(m.c cVar, boolean z) {
        Bitmap a2 = (cVar == null || cVar.a() == null || cVar.a().isRecycled()) ? null : cVar.a();
        b bVar = this.f19729a;
        c.a(bVar.f19731b, bVar.f19730a, a2);
    }

    @Override // com.android.volley.m.a
    public void a(VolleyError volleyError) {
        b bVar = this.f19729a;
        c.a(bVar.f19731b, bVar.f19730a, null);
    }
}
