package com.adobe.creativesdk.foundation.internal.storage.controllers;

import com.adobe.creativesdk.foundation.internal.storage.controllers.AbstractC0414hb;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AssetViewFragment.java */
/* renamed from: com.adobe.creativesdk.foundation.internal.storage.controllers.fb, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class RunnableC0404fb implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ AbstractC0414hb f6094a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC0404fb(AbstractC0414hb abstractC0414hb) {
        this.f6094a = abstractC0414hb;
    }

    @Override // java.lang.Runnable
    public void run() {
        AbstractC0414hb.d dVar;
        AbstractC0414hb.d dVar2;
        AbstractC0414hb.d dVar3;
        dVar = this.f6094a.r;
        if (dVar != null) {
            dVar2 = this.f6094a.r;
            if (dVar2.f6124a != null) {
                dVar3 = this.f6094a.r;
                dVar3.f6124a.setVisibility(8);
            }
        }
    }
}
