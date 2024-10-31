package com.nexstreaming.kinemaster.ui.audiobrowser.a;

import android.content.Context;
import android.database.Cursor;
import android.provider.MediaStore;
import com.nexstreaming.kinemaster.ui.audiobrowser.s;
import com.nexstreaming.kinemaster.ui.audiobrowser.u;
import com.nextreaming.nexeditorui.KineMasterApplication;
import java.util.List;

/* compiled from: GenreLister.java */
/* loaded from: classes.dex */
public class j extends m {

    /* renamed from: d, reason: collision with root package name */
    private static final String[] f21427d = {"_id", "name"};

    @Override // com.nexstreaming.kinemaster.ui.audiobrowser.a.m, com.nexstreaming.kinemaster.ui.audiobrowser.t
    public boolean a() {
        Cursor cursor = null;
        try {
            cursor = KineMasterApplication.f24056d.getContentResolver().query(MediaStore.Audio.Genres.EXTERNAL_CONTENT_URI, new String[]{"_id"}, null, null, null);
            if (cursor != null && cursor.moveToFirst()) {
                return cursor.getCount() > 0;
            }
            if (cursor != null) {
                cursor.close();
            }
            return false;
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.nexstreaming.kinemaster.ui.audiobrowser.a.m
    public List<u> b(Context context, long j) {
        Cursor query = context.getContentResolver().query(MediaStore.Audio.Genres.Members.getContentUri("external", j), u.f21467a, null, null, "_display_name");
        List<u> a2 = new u.a(query).a();
        query.close();
        return a2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.nexstreaming.kinemaster.ui.audiobrowser.a.m
    public List<s> b(Context context) {
        Cursor query = context.getContentResolver().query(MediaStore.Audio.Genres.EXTERNAL_CONTENT_URI, f21427d, null, null, "name");
        List<s> a2 = new s.a(query, "_id", "name", null, null).a();
        query.close();
        return a2;
    }
}
