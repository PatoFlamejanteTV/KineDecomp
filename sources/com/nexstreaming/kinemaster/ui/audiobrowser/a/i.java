package com.nexstreaming.kinemaster.ui.audiobrowser.a;

import android.content.Context;
import android.database.Cursor;
import android.provider.MediaStore;
import com.nexstreaming.kinemaster.ui.audiobrowser.n;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/* compiled from: RecordingLister.java */
/* loaded from: classes.dex */
public class i extends f {
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.nexstreaming.kinemaster.ui.audiobrowser.a.f
    public List<n> b(Context context, long j) {
        String a2;
        File parentFile;
        File parentFile2;
        Cursor query = context.getContentResolver().query(MediaStore.Audio.Media.EXTERNAL_CONTENT_URI, n.f3679a, null, null, "_display_name");
        n.a aVar = new n.a(query);
        ArrayList arrayList = new ArrayList();
        while (query.moveToNext()) {
            n a3 = aVar.a();
            if (a3 != null && (a2 = a3.a()) != null && (a2.startsWith("EditorAudio_") || a2.startsWith("KineMaster_Audio_"))) {
                String c = a3.c();
                arrayList.add((c == null || (parentFile = new File(c).getParentFile()) == null || (parentFile2 = parentFile.getParentFile()) == null || !parentFile2.getName().equals("Audio")) ? a3 : new n(a2.replace("KineMaster_Audio_", com.nexstreaming.kinemaster.project.f.g(parentFile.getName()) + " "), a3.b(), a3.c(), a3.d()));
            }
        }
        query.close();
        return arrayList;
    }
}
