package com.nexstreaming.kinemaster.ui.share;

import android.arch.persistence.room.RoomDatabase;

/* compiled from: ExportedVideoDao_Impl.java */
/* loaded from: classes2.dex */
class Z extends android.arch.persistence.room.j {

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ C2210ba f23322d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Z(C2210ba c2210ba, RoomDatabase roomDatabase) {
        super(roomDatabase);
        this.f23322d = c2210ba;
    }

    @Override // android.arch.persistence.room.j
    public String c() {
        return "UPDATE videos SET projectName = ? WHERE projectName LIKE ?";
    }
}
