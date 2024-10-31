package com.nexstreaming.kinemaster.ui.audiobrowser.a;

import android.content.Context;
import android.database.Cursor;
import android.provider.MediaStore;
import com.nexstreaming.kinemaster.ui.audiobrowser.u;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/* compiled from: RecordingLister.java */
/* loaded from: classes.dex */
public class n extends m {
    @Override // com.nexstreaming.kinemaster.ui.audiobrowser.a.m
    public List<u> b(Context context, long j) {
        String b2;
        File parentFile;
        File parentFile2;
        Cursor query = context.getContentResolver().query(MediaStore.Audio.Media.EXTERNAL_CONTENT_URI, u.f21467a, null, null, "_display_name");
        u.a aVar = new u.a(query);
        ArrayList arrayList = new ArrayList();
        while (query.moveToNext()) {
            u b3 = aVar.b();
            if (b3 != null && (b2 = b3.b()) != null && (b2.startsWith("EditorAudio_") || b2.startsWith("KineMaster_Audio_"))) {
                String e2 = b3.e();
                if (e2 != null && (parentFile = new File(e2).getParentFile()) != null && (parentFile2 = parentFile.getParentFile()) != null && parentFile2.getName().equals("Audio")) {
                    b3 = new u(b2.replace("KineMaster_Audio_", com.nexstreaming.kinemaster.project.k.c(parentFile.getName()) + " "), b3.c(), b3.e(), b3.f());
                }
                arrayList.add(b3);
            }
        }
        query.close();
        return arrayList;
    }
}
