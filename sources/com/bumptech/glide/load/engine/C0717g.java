package com.bumptech.glide.load.engine;

import com.bumptech.glide.load.engine.b.a;
import java.io.File;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DataCacheWriter.java */
/* renamed from: com.bumptech.glide.load.engine.g */
/* loaded from: classes.dex */
public class C0717g<DataType> implements a.b {

    /* renamed from: a */
    private final com.bumptech.glide.load.a<DataType> f8906a;

    /* renamed from: b */
    private final DataType f8907b;

    /* renamed from: c */
    private final com.bumptech.glide.load.g f8908c;

    public C0717g(com.bumptech.glide.load.a<DataType> aVar, DataType datatype, com.bumptech.glide.load.g gVar) {
        this.f8906a = aVar;
        this.f8907b = datatype;
        this.f8908c = gVar;
    }

    @Override // com.bumptech.glide.load.engine.b.a.b
    public boolean a(File file) {
        return this.f8906a.a(this.f8907b, file, this.f8908c);
    }
}
