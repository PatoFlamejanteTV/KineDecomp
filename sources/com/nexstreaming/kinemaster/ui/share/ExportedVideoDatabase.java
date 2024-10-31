package com.nexstreaming.kinemaster.ui.share;

import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

/* loaded from: classes2.dex */
public abstract class ExportedVideoDatabase extends RoomDatabase {

    /* renamed from: h */
    private static ExportedVideoDatabase f23275h;
    static final android.arch.persistence.room.a.a i = new C2212ca(1, 2);

    public static ExportedVideoDatabase a(Context context) {
        if (f23275h == null) {
            RoomDatabase.a a2 = android.arch.persistence.room.f.a(context.getApplicationContext(), ExportedVideoDatabase.class, "exported_video_database");
            a2.a(i);
            f23275h = (ExportedVideoDatabase) a2.a();
        }
        return f23275h;
    }

    public abstract W j();
}
