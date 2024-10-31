package com.nexstreaming.kinemaster.ui.share;

/* compiled from: ExportedVideoDatabase.java */
/* renamed from: com.nexstreaming.kinemaster.ui.share.ca */
/* loaded from: classes2.dex */
class C2212ca extends android.arch.persistence.room.a.a {
    public C2212ca(int i, int i2) {
        super(i, i2);
    }

    @Override // android.arch.persistence.room.a.a
    public void a(b.a.b.a.b bVar) {
        bVar.b("ALTER TABLE videos ADD COLUMN lastEditTime INTEGER NOT NULL DEFAULT '0'");
    }
}
