package com.bumptech.glide;

import com.bumptech.glide.g.l;
import com.bumptech.glide.k;

/* compiled from: TransitionOptions.java */
/* loaded from: classes.dex */
public abstract class k<CHILD extends k<CHILD, TranscodeType>, TranscodeType> implements Cloneable {

    /* renamed from: a */
    private com.bumptech.glide.request.b.g<? super TranscodeType> f8532a = com.bumptech.glide.request.b.e.b();

    private CHILD b() {
        return this;
    }

    public final CHILD a(com.bumptech.glide.request.b.g<? super TranscodeType> gVar) {
        l.a(gVar);
        this.f8532a = gVar;
        b();
        return this;
    }

    /* renamed from: clone */
    public final CHILD m8clone() {
        try {
            return (CHILD) super.clone();
        } catch (CloneNotSupportedException e2) {
            throw new RuntimeException(e2);
        }
    }

    public final com.bumptech.glide.request.b.g<? super TranscodeType> a() {
        return this.f8532a;
    }
}
