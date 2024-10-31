package com.adobe.creativesdk.foundation.internal.storage.controllers;

import com.adobe.creativesdk.foundation.internal.storage.controllers.C0415hc;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: CCFilesWithUploadFragment.java */
/* renamed from: com.adobe.creativesdk.foundation.internal.storage.controllers.ec, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class RunnableC0381ec implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ C0415hc f6016a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC0381ec(C0415hc c0415hc) {
        this.f6016a = c0415hc;
    }

    @Override // java.lang.Runnable
    public void run() {
        C0415hc.f fVar;
        C0415hc.f fVar2;
        C0415hc.f fVar3;
        fVar = this.f6016a.ea;
        if (fVar != null) {
            fVar2 = this.f6016a.ea;
            if (fVar2.f6131a != null) {
                fVar3 = this.f6016a.ea;
                fVar3.f6131a.setVisibility(8);
            }
        }
    }
}
