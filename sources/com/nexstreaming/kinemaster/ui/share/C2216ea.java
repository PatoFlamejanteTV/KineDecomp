package com.nexstreaming.kinemaster.ui.share;

import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.b.a;
import android.arch.persistence.room.h;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/* compiled from: ExportedVideoDatabase_Impl.java */
/* renamed from: com.nexstreaming.kinemaster.ui.share.ea, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
class C2216ea extends h.a {

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ ExportedVideoDatabase_Impl f23340b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2216ea(ExportedVideoDatabase_Impl exportedVideoDatabase_Impl, int i) {
        super(i);
        this.f23340b = exportedVideoDatabase_Impl;
    }

    @Override // android.arch.persistence.room.h.a
    public void a(b.a.b.a.b bVar) {
        bVar.b("CREATE TABLE IF NOT EXISTS `videos` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `projectName` TEXT, `projectVersion` INTEGER NOT NULL, `creationTime` INTEGER NOT NULL, `path` TEXT, `width` INTEGER NOT NULL, `height` INTEGER NOT NULL, `useMuserkAudio` INTEGER NOT NULL, `lastEditTime` INTEGER NOT NULL)");
        bVar.b("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        bVar.b("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, \"008835e3f338ab6a263dfcffbf15a88e\")");
    }

    @Override // android.arch.persistence.room.h.a
    public void b(b.a.b.a.b bVar) {
        bVar.b("DROP TABLE IF EXISTS `videos`");
    }

    @Override // android.arch.persistence.room.h.a
    protected void c(b.a.b.a.b bVar) {
        List list;
        List list2;
        List list3;
        list = ((RoomDatabase) this.f23340b).f63f;
        if (list != null) {
            list2 = ((RoomDatabase) this.f23340b).f63f;
            int size = list2.size();
            for (int i = 0; i < size; i++) {
                list3 = ((RoomDatabase) this.f23340b).f63f;
                ((RoomDatabase.b) list3.get(i)).a(bVar);
            }
        }
    }

    @Override // android.arch.persistence.room.h.a
    public void d(b.a.b.a.b bVar) {
        List list;
        List list2;
        List list3;
        ((RoomDatabase) this.f23340b).f58a = bVar;
        this.f23340b.a(bVar);
        list = ((RoomDatabase) this.f23340b).f63f;
        if (list != null) {
            list2 = ((RoomDatabase) this.f23340b).f63f;
            int size = list2.size();
            for (int i = 0; i < size; i++) {
                list3 = ((RoomDatabase) this.f23340b).f63f;
                ((RoomDatabase.b) list3.get(i)).b(bVar);
            }
        }
    }

    @Override // android.arch.persistence.room.h.a
    protected void e(b.a.b.a.b bVar) {
        HashMap hashMap = new HashMap(9);
        hashMap.put("id", new a.C0001a("id", "INTEGER", true, 1));
        hashMap.put("projectName", new a.C0001a("projectName", "TEXT", false, 0));
        hashMap.put("projectVersion", new a.C0001a("projectVersion", "INTEGER", true, 0));
        hashMap.put("creationTime", new a.C0001a("creationTime", "INTEGER", true, 0));
        hashMap.put("path", new a.C0001a("path", "TEXT", false, 0));
        hashMap.put("width", new a.C0001a("width", "INTEGER", true, 0));
        hashMap.put("height", new a.C0001a("height", "INTEGER", true, 0));
        hashMap.put("useMuserkAudio", new a.C0001a("useMuserkAudio", "INTEGER", true, 0));
        hashMap.put("lastEditTime", new a.C0001a("lastEditTime", "INTEGER", true, 0));
        android.arch.persistence.room.b.a aVar = new android.arch.persistence.room.b.a("videos", hashMap, new HashSet(0), new HashSet(0));
        android.arch.persistence.room.b.a a2 = android.arch.persistence.room.b.a.a(bVar, "videos");
        if (aVar.equals(a2)) {
            return;
        }
        throw new IllegalStateException("Migration didn't properly handle videos(com.nexstreaming.kinemaster.ui.share.ExportedVideo).\n Expected:\n" + aVar + "\n Found:\n" + a2);
    }
}
