package com.nexstreaming.kinemaster.ui.audiobrowser.a;

import android.content.Context;
import android.database.Cursor;
import android.provider.MediaStore;
import com.nexstreaming.kinemaster.ui.audiobrowser.u;
import java.util.List;

/* compiled from: SongLister.java */
/* loaded from: classes.dex */
public class o extends m {
    @Override // com.nexstreaming.kinemaster.ui.audiobrowser.a.m
    public List<u> b(Context context, long j) {
        Cursor query = context.getContentResolver().query(MediaStore.Audio.Media.EXTERNAL_CONTENT_URI, u.f21467a, null, null, "title, _display_name");
        List<u> a2 = new u.a(query).a();
        query.close();
        return a2;
    }
}
