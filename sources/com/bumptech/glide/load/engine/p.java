package com.bumptech.glide.load.engine;

import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.EncodeStrategy;

/* compiled from: DiskCacheStrategy.java */
/* loaded from: classes.dex */
class p extends q {
    @Override // com.bumptech.glide.load.engine.q
    public boolean a() {
        return true;
    }

    @Override // com.bumptech.glide.load.engine.q
    public boolean a(DataSource dataSource) {
        return dataSource == DataSource.REMOTE;
    }

    @Override // com.bumptech.glide.load.engine.q
    public boolean b() {
        return true;
    }

    @Override // com.bumptech.glide.load.engine.q
    public boolean a(boolean z, DataSource dataSource, EncodeStrategy encodeStrategy) {
        return ((z && dataSource == DataSource.DATA_DISK_CACHE) || dataSource == DataSource.LOCAL) && encodeStrategy == EncodeStrategy.TRANSFORMED;
    }
}
