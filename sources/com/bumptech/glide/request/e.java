package com.bumptech.glide.request;

import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;

/* compiled from: RequestListener.java */
/* loaded from: classes.dex */
public interface e<R> {
    boolean a(GlideException glideException, Object obj, com.bumptech.glide.request.a.i<R> iVar, boolean z);

    boolean a(R r, Object obj, com.bumptech.glide.request.a.i<R> iVar, DataSource dataSource, boolean z);
}
