package com.nexstreaming.kinemaster.ui.share;

import android.arch.persistence.room.RoomDatabase;

/* compiled from: ExportedVideoDao_Impl.java */
/* loaded from: classes2.dex */
class X extends android.arch.persistence.room.c<V> {

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ C2210ba f23320d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public X(C2210ba c2210ba, RoomDatabase roomDatabase) {
        super(roomDatabase);
        this.f23320d = c2210ba;
    }

    @Override // android.arch.persistence.room.j
    public String c() {
        return "INSERT OR ABORT INTO `videos`(`id`,`projectName`,`projectVersion`,`creationTime`,`path`,`width`,`height`,`useMuserkAudio`,`lastEditTime`) VALUES (nullif(?, 0),?,?,?,?,?,?,?,?)";
    }

    @Override // android.arch.persistence.room.c
    public void a(b.a.b.a.f fVar, V v) {
        fVar.b(1, v.f23312a);
        String str = v.f23313b;
        if (str == null) {
            fVar.f(2);
        } else {
            fVar.a(2, str);
        }
        fVar.b(3, v.f23314c);
        fVar.b(4, v.f23315d);
        String str2 = v.f23316e;
        if (str2 == null) {
            fVar.f(5);
        } else {
            fVar.a(5, str2);
        }
        fVar.b(6, v.f23317f);
        fVar.b(7, v.f23318g);
        fVar.b(8, v.f23319h ? 1L : 0L);
        fVar.b(9, v.i);
    }
}
