package com.adobe.creativesdk.foundation.internal.storage.model.util;

import com.adobe.creativesdk.foundation.internal.utils.logging.Level;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: AdobeStorageUtils.java */
/* loaded from: classes.dex */
public class h implements Runnable {

    /* renamed from: a */
    final /* synthetic */ InputStream f6623a;

    /* renamed from: b */
    final /* synthetic */ boolean f6624b;

    /* renamed from: c */
    final /* synthetic */ j f6625c;

    public h(InputStream inputStream, boolean z, j jVar) {
        this.f6623a = inputStream;
        this.f6624b = z;
        this.f6625c = jVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f6625c.a(i.a(this.f6623a, this.f6624b));
        try {
            this.f6623a.close();
        } catch (IOException e2) {
            com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.ERROR, i.class.getSimpleName(), null, e2);
        }
    }
}
