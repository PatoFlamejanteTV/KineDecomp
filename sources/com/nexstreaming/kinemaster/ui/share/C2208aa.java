package com.nexstreaming.kinemaster.ui.share;

import android.arch.persistence.room.RoomDatabase;

/* compiled from: ExportedVideoDao_Impl.java */
/* renamed from: com.nexstreaming.kinemaster.ui.share.aa, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
class C2208aa extends android.arch.persistence.room.j {

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ C2210ba f23324d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2208aa(C2210ba c2210ba, RoomDatabase roomDatabase) {
        super(roomDatabase);
        this.f23324d = c2210ba;
    }

    @Override // android.arch.persistence.room.j
    public String c() {
        return "DELETE FROM videos WHERE projectName LIKE ?";
    }
}