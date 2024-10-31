package com.nexstreaming.kinemaster.ui.audiobrowser.a;

import android.content.Context;
import android.database.Cursor;
import android.provider.MediaStore;
import android.util.SparseArray;
import com.nexstreaming.kinemaster.ui.audiobrowser.n;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

/* compiled from: FolderLister.java */
/* loaded from: classes.dex */
public class c extends f {

    /* renamed from: a, reason: collision with root package name */
    private static int f3659a = 0;
    private static SparseArray<File> b = new SparseArray<>();

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.nexstreaming.kinemaster.ui.audiobrowser.a.f
    public List<n> b(Context context, long j) {
        ArrayList arrayList = new ArrayList();
        File file = b.get((int) j);
        if (file == null) {
            return arrayList;
        }
        Cursor query = context.getContentResolver().query(MediaStore.Audio.Media.EXTERNAL_CONTENT_URI, n.f3679a, null, null, "_display_name");
        n.a aVar = new n.a(query);
        while (query.moveToNext()) {
            if (aVar.c().equals(file)) {
                arrayList.add(aVar.a());
            }
        }
        query.close();
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.nexstreaming.kinemaster.ui.audiobrowser.a.f
    public List<com.nexstreaming.kinemaster.ui.audiobrowser.l> b(Context context) {
        Cursor query = context.getContentResolver().query(MediaStore.Audio.Media.EXTERNAL_CONTENT_URI, n.f3679a, null, null, "_display_name");
        n.a aVar = new n.a(query);
        HashSet<File> hashSet = new HashSet();
        while (query.moveToNext()) {
            hashSet.add(aVar.c());
        }
        ArrayList arrayList = new ArrayList(hashSet.size());
        b.clear();
        for (File file : hashSet) {
            f3659a++;
            b.put(f3659a, file);
            arrayList.add(new com.nexstreaming.kinemaster.ui.audiobrowser.l(f3659a, file.getName(), -1, null));
        }
        Collections.sort(arrayList, new d(this));
        query.close();
        return arrayList;
    }

    @Override // com.nexstreaming.kinemaster.ui.audiobrowser.a.f, com.nexstreaming.kinemaster.ui.audiobrowser.m
    public boolean a() {
        return true;
    }
}
