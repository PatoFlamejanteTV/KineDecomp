package com.facebook.marketing.internal;

import android.content.Context;
import com.facebook.FacebookSdk;
import com.facebook.marketing.internal.ButtonIndexer;
import java.util.HashMap;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ButtonIndexer.java */
/* loaded from: classes.dex */
public class b implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ButtonIndexer.ViewProcessor f9443a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(ButtonIndexer.ViewProcessor viewProcessor) {
        this.f9443a = viewProcessor;
    }

    @Override // java.lang.Runnable
    public void run() {
        HashMap hashMap;
        Context applicationContext = FacebookSdk.getApplicationContext();
        String applicationId = FacebookSdk.getApplicationId();
        hashMap = this.f9443a.viewMap;
        ButtonIndexingLogger.logAllIndexing(applicationId, hashMap, applicationContext);
    }
}
