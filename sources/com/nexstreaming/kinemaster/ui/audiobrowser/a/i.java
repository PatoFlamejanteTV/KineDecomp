package com.nexstreaming.kinemaster.ui.audiobrowser.a;

import android.content.Context;
import android.database.Cursor;
import android.provider.MediaStore;
import android.util.SparseArray;
import com.nexstreaming.kinemaster.ui.audiobrowser.s;
import com.nexstreaming.kinemaster.ui.audiobrowser.u;
import com.nextreaming.nexeditorui.KineMasterApplication;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

/* compiled from: FolderLister.java */
/* loaded from: classes.dex */
public class i extends m {

    /* renamed from: d */
    private static int f21425d;

    /* renamed from: e */
    private static SparseArray<File> f21426e = new SparseArray<>();

    @Override // com.nexstreaming.kinemaster.ui.audiobrowser.a.m, com.nexstreaming.kinemaster.ui.audiobrowser.t
    public boolean a() {
        Cursor cursor = null;
        try {
            cursor = KineMasterApplication.f24056d.getContentResolver().query(MediaStore.Audio.Media.EXTERNAL_CONTENT_URI, new String[]{"_id"}, null, null, null);
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

    @Override // com.nexstreaming.kinemaster.ui.audiobrowser.a.m
    public List<u> b(Context context, long j) {
        ArrayList arrayList = new ArrayList();
        File file = f21426e.get((int) j);
        if (file == null) {
            return arrayList;
        }
        Cursor query = context.getContentResolver().query(MediaStore.Audio.Media.EXTERNAL_CONTENT_URI, u.f21467a, null, null, "_display_name");
        u.a aVar = new u.a(query);
        while (query.moveToNext()) {
            if (aVar.c().equals(file)) {
                arrayList.add(aVar.b());
            }
        }
        query.close();
        return arrayList;
    }

    @Override // com.nexstreaming.kinemaster.ui.audiobrowser.a.m
    public List<s> b(Context context) {
        Cursor query = context.getContentResolver().query(MediaStore.Audio.Media.EXTERNAL_CONTENT_URI, u.f21467a, null, null, "_display_name");
        u.a aVar = new u.a(query);
        HashSet<File> hashSet = new HashSet();
        while (query.moveToNext()) {
            hashSet.add(aVar.c());
        }
        ArrayList arrayList = new ArrayList(hashSet.size());
        f21426e.clear();
        for (File file : hashSet) {
            f21425d++;
            f21426e.put(f21425d, file);
            arrayList.add(new s(f21425d, file.getName(), -1, null));
        }
        Collections.sort(arrayList, new h(this));
        query.close();
        return arrayList;
    }
}
