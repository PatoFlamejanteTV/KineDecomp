package com.bumptech.glide.load.engine.d;

import android.os.Handler;
import android.os.Looper;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.engine.a.e;
import com.bumptech.glide.load.engine.b.i;

/* compiled from: BitmapPreFiller.java */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a */
    private final i f8889a;

    /* renamed from: b */
    private final e f8890b;

    /* renamed from: c */
    private final DecodeFormat f8891c;

    /* renamed from: d */
    private final Handler f8892d = new Handler(Looper.getMainLooper());

    public a(i iVar, e eVar, DecodeFormat decodeFormat) {
        this.f8889a = iVar;
        this.f8890b = eVar;
        this.f8891c = decodeFormat;
    }
}
