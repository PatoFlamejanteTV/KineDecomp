package com.adobe.creativesdk.foundation.internal.cache;

import java.util.Observable;
import java.util.Observer;

/* compiled from: AdobeCommonCache.java */
/* loaded from: classes.dex */
public class c implements Observer {

    /* renamed from: a */
    final /* synthetic */ d f4942a;

    public c(d dVar) {
        this.f4942a = dVar;
    }

    @Override // java.util.Observer
    public void update(Observable observable, Object obj) {
        this.f4942a.a();
    }
}
