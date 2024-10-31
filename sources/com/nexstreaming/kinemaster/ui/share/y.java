package com.nexstreaming.kinemaster.ui.share;

import android.arch.persistence.room.RoomDatabase;

/* compiled from: ExportedVideoDao_Impl.java */
/* loaded from: classes2.dex */
class Y extends android.arch.persistence.room.b<V> {

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ C2210ba f23321d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Y(C2210ba c2210ba, RoomDatabase roomDatabase) {
        super(roomDatabase);
        this.f23321d = c2210ba;
    }

    @Override // android.arch.persistence.room.j
    public String c() {
        return "DELETE FROM `videos` WHERE `id` = ?";
    }

    @Override // android.arch.persistence.room.b
    public void a(b.a.b.a.f fVar, V v) {
        fVar.b(1, v.f23312a);
    }
}
