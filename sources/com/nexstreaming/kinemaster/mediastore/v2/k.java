package com.nexstreaming.kinemaster.mediastore.v2;

import android.content.Context;
import android.os.Bundle;
import com.nexstreaming.app.general.task.ResultTask;
import com.nexstreaming.kinemaster.mediastore.v2.MediaStoreItem;
import java.util.Date;

/* compiled from: MediaStoreItemWrapper.java */
/* loaded from: classes.dex */
public final class k implements MediaStoreItem {

    /* renamed from: a, reason: collision with root package name */
    private final MediaStoreItem f3566a;

    public k(MediaStoreItem mediaStoreItem) {
        this.f3566a = mediaStoreItem;
    }

    @Override // com.nexstreaming.kinemaster.mediastore.v2.MediaStoreItem
    public MediaItemType b() {
        return this.f3566a.b();
    }

    @Override // com.nexstreaming.kinemaster.mediastore.v2.MediaStoreItem
    public MSID c() {
        return this.f3566a.c();
    }

    @Override // com.nexstreaming.kinemaster.mediastore.v2.MediaStoreItem
    public String a(Context context) {
        return this.f3566a.a(context);
    }

    @Override // com.nexstreaming.kinemaster.mediastore.v2.MediaStoreItem
    public Date f() {
        return this.f3566a.f();
    }

    @Override // com.nexstreaming.kinemaster.mediastore.v2.MediaStoreItem
    public String h() {
        return this.f3566a.h();
    }

    @Override // com.nexstreaming.kinemaster.mediastore.v2.MediaStoreItem
    public long i() {
        return this.f3566a.i();
    }

    @Override // com.nexstreaming.kinemaster.mediastore.v2.MediaStoreItem
    public int j() {
        return this.f3566a.j();
    }

    @Override // com.nexstreaming.kinemaster.mediastore.v2.MediaStoreItem
    public int k() {
        return this.f3566a.k();
    }

    @Override // com.nexstreaming.kinemaster.mediastore.v2.MediaStoreItem
    public int l() {
        return this.f3566a.l();
    }

    @Override // com.nexstreaming.kinemaster.mediastore.v2.MediaStoreItem
    public int m() {
        return this.f3566a.m();
    }

    @Override // com.nexstreaming.kinemaster.mediastore.v2.MediaStoreItem
    public boolean n() {
        return this.f3566a.n();
    }

    @Override // com.nexstreaming.kinemaster.mediastore.v2.MediaStoreItem
    public String o() {
        return this.f3566a.o();
    }

    @Override // com.nexstreaming.kinemaster.mediastore.v2.MediaStoreItem
    public Bundle a(Class<?> cls) {
        return this.f3566a.a(cls);
    }

    @Override // com.nexstreaming.kinemaster.mediastore.v2.MediaStoreItem
    public boolean r() {
        return this.f3566a.r();
    }

    @Override // com.nexstreaming.kinemaster.mediastore.v2.MediaStoreItem
    public int s() {
        return this.f3566a.s();
    }

    @Override // com.nexstreaming.kinemaster.mediastore.v2.MediaStoreItem
    public boolean t() {
        return this.f3566a.t();
    }

    @Override // com.nexstreaming.kinemaster.mediastore.v2.MediaStoreItem
    public MediaStoreItem.MediaSupportType p() {
        return this.f3566a.p();
    }

    @Override // com.nexstreaming.kinemaster.mediastore.v2.MediaStoreItem
    public ResultTask<MediaStoreItem.MediaSupportType> q() {
        return this.f3566a.q();
    }
}
