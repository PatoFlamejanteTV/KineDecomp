package com.nexstreaming.kinemaster.ui.audiobrowser.a;

import android.content.Context;
import android.database.Cursor;
import android.provider.MediaStore;
import com.nexstreaming.kinemaster.ui.audiobrowser.n;
import java.util.List;

/* compiled from: SongLister.java */
/* loaded from: classes.dex */
public class j extends f {
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.nexstreaming.kinemaster.ui.audiobrowser.a.f
    public List<n> b(Context context, long j) {
        Cursor query = context.getContentResolver().query(MediaStore.Audio.Media.EXTERNAL_CONTENT_URI, n.f3679a, null, null, "title, _display_name");
        List<n> b = new n.a(query).b();
        query.close();
        return b;
    }
}
