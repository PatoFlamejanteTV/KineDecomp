package com.nexstreaming.kinemaster.ui.share;

import b.a.b.a.c;

/* loaded from: classes2.dex */
public class ExportedVideoDatabase_Impl extends ExportedVideoDatabase {
    private volatile W j;

    @Override // com.nexstreaming.kinemaster.ui.share.ExportedVideoDatabase
    public W j() {
        W w;
        if (this.j != null) {
            return this.j;
        }
        synchronized (this) {
            if (this.j == null) {
                this.j = new C2210ba(this);
            }
            w = this.j;
        }
        return w;
    }

    @Override // android.arch.persistence.room.RoomDatabase
    protected android.arch.persistence.room.e c() {
        return new android.arch.persistence.room.e(this, "videos");
    }

    @Override // android.arch.persistence.room.RoomDatabase
    protected b.a.b.a.c a(android.arch.persistence.room.a aVar) {
        android.arch.persistence.room.h hVar = new android.arch.persistence.room.h(aVar, new C2216ea(this, 2), "008835e3f338ab6a263dfcffbf15a88e", "1eef6d1e8d95d7e311bebf148fb2a13d");
        c.b.a a2 = c.b.a(aVar.f75b);
        a2.a(aVar.f76c);
        a2.a(hVar);
        return aVar.f74a.a(a2.a());
    }
}
