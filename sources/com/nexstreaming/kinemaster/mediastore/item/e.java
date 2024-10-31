package com.nexstreaming.kinemaster.mediastore.item;

import android.os.Bundle;
import com.nexstreaming.app.general.task.ResultTask;
import com.nexstreaming.kinemaster.mediastore.MediaSupportType;
import java.util.Date;
import kotlin.jvm.internal.h;

/* compiled from: MediaStoreItemWrapper.kt */
/* loaded from: classes.dex */
public final class e implements c {

    /* renamed from: a, reason: collision with root package name */
    private final c f20918a;

    public e(c cVar) {
        h.b(cVar, "mItem");
        this.f20918a = cVar;
    }

    @Override // com.nexstreaming.kinemaster.mediastore.item.c
    public long a() {
        return this.f20918a.a();
    }

    @Override // com.nexstreaming.kinemaster.mediastore.item.c
    public int b() {
        return this.f20918a.b();
    }

    @Override // com.nexstreaming.kinemaster.mediastore.item.c
    public String c() {
        return this.f20918a.c();
    }

    @Override // com.nexstreaming.kinemaster.mediastore.item.c
    public Date d() {
        return this.f20918a.d();
    }

    @Override // com.nexstreaming.kinemaster.mediastore.item.c
    public ResultTask<MediaSupportType> e() {
        return this.f20918a.e();
    }

    @Override // com.nexstreaming.kinemaster.mediastore.item.c
    public boolean f() {
        return this.f20918a.f();
    }

    @Override // com.nexstreaming.kinemaster.mediastore.item.c
    public MediaSupportType g() {
        return this.f20918a.g();
    }

    @Override // com.nexstreaming.kinemaster.mediastore.item.c
    public int getDuration() {
        return this.f20918a.getDuration();
    }

    @Override // com.nexstreaming.kinemaster.mediastore.item.c
    public int getHeight() {
        return this.f20918a.getHeight();
    }

    @Override // com.nexstreaming.kinemaster.mediastore.item.c
    public MediaStoreItemId getId() {
        return this.f20918a.getId();
    }

    @Override // com.nexstreaming.kinemaster.mediastore.item.c
    public String getNamespace() {
        return this.f20918a.getNamespace();
    }

    @Override // com.nexstreaming.kinemaster.mediastore.item.c
    public int getOrientation() {
        return this.f20918a.getOrientation();
    }

    @Override // com.nexstreaming.kinemaster.mediastore.item.c
    public String getPath() {
        return this.f20918a.getPath();
    }

    @Override // com.nexstreaming.kinemaster.mediastore.item.c
    public MediaItemType getType() {
        return this.f20918a.getType();
    }

    @Override // com.nexstreaming.kinemaster.mediastore.item.c
    public int getWidth() {
        return this.f20918a.getWidth();
    }

    @Override // com.nexstreaming.kinemaster.mediastore.item.c
    public boolean h() {
        return this.f20918a.h();
    }

    @Override // com.nexstreaming.kinemaster.mediastore.item.c
    public Bundle a(Class<?> cls) {
        h.b(cls, "providerClass");
        return this.f20918a.a(cls);
    }
}
