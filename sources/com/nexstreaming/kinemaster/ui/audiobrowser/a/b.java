package com.nexstreaming.kinemaster.ui.audiobrowser.a;

import android.content.Context;
import android.database.Cursor;
import android.provider.MediaStore;
import com.nexstreaming.kinemaster.ui.audiobrowser.l;
import com.nexstreaming.kinemaster.ui.audiobrowser.n;
import java.util.List;

/* compiled from: ArtistsLister.java */
/* loaded from: classes.dex */
public class b extends f {

    /* renamed from: a, reason: collision with root package name */
    private static final String[] f3658a = {"_id", "artist", "number_of_tracks"};

    @Override // com.nexstreaming.kinemaster.ui.audiobrowser.a.f, com.nexstreaming.kinemaster.ui.audiobrowser.m
    public boolean a() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.nexstreaming.kinemaster.ui.audiobrowser.a.f
    public List<n> b(Context context, long j) {
        Cursor query = context.getContentResolver().query(MediaStore.Audio.Media.EXTERNAL_CONTENT_URI, n.f3679a, "artist_id=?", new String[]{String.valueOf(j)}, "_display_name");
        List<n> b = new n.a(query).b();
        query.close();
        return b;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.nexstreaming.kinemaster.ui.audiobrowser.a.f
    public List<com.nexstreaming.kinemaster.ui.audiobrowser.l> b(Context context) {
        Cursor query = context.getContentResolver().query(MediaStore.Audio.Artists.EXTERNAL_CONTENT_URI, f3658a, null, null, "artist_key");
        List<com.nexstreaming.kinemaster.ui.audiobrowser.l> b = new l.a(query, "_id", "artist", "number_of_tracks", null).b();
        query.close();
        return b;
    }
}
