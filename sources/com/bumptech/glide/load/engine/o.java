package com.bumptech.glide.load.engine;

import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.EncodeStrategy;

/* compiled from: DiskCacheStrategy.java */
/* loaded from: classes.dex */
class o extends q {
    @Override // com.bumptech.glide.load.engine.q
    public boolean a() {
        return false;
    }

    @Override // com.bumptech.glide.load.engine.q
    public boolean a(DataSource dataSource) {
        return false;
    }

    @Override // com.bumptech.glide.load.engine.q
    public boolean a(boolean z, DataSource dataSource, EncodeStrategy encodeStrategy) {
        return (dataSource == DataSource.RESOURCE_DISK_CACHE || dataSource == DataSource.MEMORY_CACHE) ? false : true;
    }

    @Override // com.bumptech.glide.load.engine.q
    public boolean b() {
        return true;
    }
}