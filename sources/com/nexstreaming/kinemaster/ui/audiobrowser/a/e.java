package com.nexstreaming.kinemaster.ui.audiobrowser.a;

import android.content.Context;
import android.database.Cursor;
import android.provider.MediaStore;
import com.nexstreaming.kinemaster.ui.audiobrowser.l;
import com.nexstreaming.kinemaster.ui.audiobrowser.n;
import java.util.List;

/* compiled from: GenreLister.java */
/* loaded from: classes.dex */
public class e extends f {

    /* renamed from: a, reason: collision with root package name */
    private static final String[] f3661a = {"_id", "name"};

    @Override // com.nexstreaming.kinemaster.ui.audiobrowser.a.f, com.nexstreaming.kinemaster.ui.audiobrowser.m
    public boolean a() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.nexstreaming.kinemaster.ui.audiobrowser.a.f
    public List<n> b(Context context, long j) {
        Cursor query = context.getContentResolver().query(MediaStore.Audio.Genres.Members.getContentUri("external", j), n.f3679a, null, null, "_display_name");
        List<n> b = new n.a(query).b();
        query.close();
        return b;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.nexstreaming.kinemaster.ui.audiobrowser.a.f
    public List<com.nexstreaming.kinemaster.ui.audiobrowser.l> b(Context context) {
        Cursor query = context.getContentResolver().query(MediaStore.Audio.Genres.EXTERNAL_CONTENT_URI, f3661a, null, null, "name");
        List<com.nexstreaming.kinemaster.ui.audiobrowser.l> b = new l.a(query, "_id", "name", null, null).b();
        query.close();
        return b;
    }
}
