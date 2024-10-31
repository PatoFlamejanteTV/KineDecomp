package com.nexstreaming.kinemaster.ui.audiobrowser.a;

import android.content.Context;
import android.database.Cursor;
import android.provider.MediaStore;
import com.nexstreaming.kinemaster.ui.audiobrowser.l;
import com.nexstreaming.kinemaster.ui.audiobrowser.n;
import java.util.List;

/* compiled from: AlbumLister.java */
/* loaded from: classes.dex */
public class a extends f {

    /* renamed from: a, reason: collision with root package name */
    private static final String[] f3657a = {"_id", "album", "numsongs", "album_art"};

    @Override // com.nexstreaming.kinemaster.ui.audiobrowser.a.f, com.nexstreaming.kinemaster.ui.audiobrowser.m
    public boolean a() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.nexstreaming.kinemaster.ui.audiobrowser.a.f
    public List<n> b(Context context, long j) {
        Cursor query = context.getContentResolver().query(MediaStore.Audio.Media.EXTERNAL_CONTENT_URI, n.f3679a, "album_id=?", new String[]{String.valueOf(j)}, "_display_name");
        List<n> b = new n.a(query).b();
        query.close();
        return b;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.nexstreaming.kinemaster.ui.audiobrowser.a.f
    public List<com.nexstreaming.kinemaster.ui.audiobrowser.l> b(Context context) {
        Cursor query = context.getContentResolver().query(MediaStore.Audio.Albums.EXTERNAL_CONTENT_URI, f3657a, null, null, "album_key");
        List<com.nexstreaming.kinemaster.ui.audiobrowser.l> b = new l.a(query, "_id", "album", "numsongs", "album_art").b();
        query.close();
        return b;
    }
}
