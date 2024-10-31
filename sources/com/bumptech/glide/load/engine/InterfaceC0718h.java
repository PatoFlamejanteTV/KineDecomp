package com.bumptech.glide.load.engine;

import com.bumptech.glide.load.DataSource;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DataFetcherGenerator.java */
/* renamed from: com.bumptech.glide.load.engine.h */
/* loaded from: classes.dex */
public interface InterfaceC0718h {

    /* compiled from: DataFetcherGenerator.java */
    /* renamed from: com.bumptech.glide.load.engine.h$a */
    /* loaded from: classes.dex */
    public interface a {
        void a(com.bumptech.glide.load.c cVar, Exception exc, com.bumptech.glide.load.a.d<?> dVar, DataSource dataSource);

        void a(com.bumptech.glide.load.c cVar, Object obj, com.bumptech.glide.load.a.d<?> dVar, DataSource dataSource, com.bumptech.glide.load.c cVar2);

        void e();
    }

    boolean a();

    void cancel();
}
