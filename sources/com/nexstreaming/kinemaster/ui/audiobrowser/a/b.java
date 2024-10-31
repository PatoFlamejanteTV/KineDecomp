package com.nexstreaming.kinemaster.ui.audiobrowser.a;

import android.content.Context;
import android.database.Cursor;
import android.provider.MediaStore;
import com.nexstreaming.kinemaster.ui.audiobrowser.s;
import com.nexstreaming.kinemaster.ui.audiobrowser.u;
import com.nextreaming.nexeditorui.KineMasterApplication;
import java.util.List;

/* compiled from: ArtistsLister.java */
/* loaded from: classes.dex */
public class b extends m {

    /* renamed from: d, reason: collision with root package name */
    private static final String[] f21414d = {"_id", "artist", "number_of_tracks"};

    @Override // com.nexstreaming.kinemaster.ui.audiobrowser.a.m, com.nexstreaming.kinemaster.ui.audiobrowser.t
    public boolean a() {
        Cursor cursor = null;
        try {
            cursor = KineMasterApplication.f24056d.getContentResolver().query(MediaStore.Audio.Artists.EXTERNAL_CONTENT_URI, new String[]{"_id"}, null, null, null);
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
        Cursor query = context.getContentResolver().query(MediaStore.Audio.Media.EXTERNAL_CONTENT_URI, u.f21467a, "artist_id=?", new String[]{String.valueOf(j)}, "_display_name");
        List<u> a2 = new u.a(query).a();
        query.close();
        return a2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.nexstreaming.kinemaster.ui.audiobrowser.a.m
    public List<s> b(Context context) {
        Cursor query = context.getContentResolver().query(MediaStore.Audio.Artists.EXTERNAL_CONTENT_URI, f21414d, null, null, "artist_key");
        List<s> a2 = new s.a(query, "_id", "artist", "number_of_tracks", null).a();
        query.close();
        return a2;
    }
}
