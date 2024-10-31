package com.nexstreaming.app.general.service.download;

import com.android.volley.VolleyError;
import com.android.volley.a.m;

/* compiled from: NexDownloadService.java */
/* loaded from: classes2.dex */
class o implements m.d {

    /* renamed from: a */
    final /* synthetic */ p f19724a;

    public o(p pVar) {
        this.f19724a = pVar;
    }

    @Override // com.android.volley.m.a
    public void a(VolleyError volleyError) {
    }

    @Override // com.android.volley.a.m.d
    public void a(m.c cVar, boolean z) {
        if (cVar == null || cVar.a() == null || cVar.a().isRecycled()) {
            return;
        }
        cVar.a();
    }
}
