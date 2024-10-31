package com.adobe.creativesdk.foundation.internal.cache;

import com.adobe.creativesdk.foundation.internal.utils.logging.Level;
import java.text.SimpleDateFormat;
import java.util.Date;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AdobeCommonCache.java */
/* loaded from: classes.dex */
public class a implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ d f4940a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(d dVar) {
        this.f4940a = dVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean z;
        int i;
        z = this.f4940a.j;
        if (z) {
            com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.INFO, d.class.getName(), "***** Async cache scrubbing event at " + SimpleDateFormat.getInstance().format(new Date()));
        }
        d dVar = this.f4940a;
        i = dVar.f4948f;
        dVar.a(i);
    }
}
