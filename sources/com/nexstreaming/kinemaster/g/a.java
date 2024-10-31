package com.nexstreaming.kinemaster.g;

import android.content.Context;
import com.nexstreaming.kinemaster.mediastore.v2.MediaStoreItem;
import com.nextreaming.nexeditorui.EditorGlobal;
import com.nextreaming.nexeditorui.NexEditorDeviceProfile;
import com.nextreaming.nexeditorui.NexExportProfile;
import java.io.File;

/* compiled from: TranscodeUtil.java */
/* loaded from: classes.dex */
public class a {
    public static File a(Context context, File file, MediaStoreItem.MediaSupportType mediaSupportType) {
        File b = EditorGlobal.b(context);
        b.mkdirs();
        String str = "T" + Integer.toHexString(file.getParentFile().getAbsolutePath().hashCode()) + "_";
        switch (mediaSupportType) {
            case NeedTranscodeRes:
                return new File(b, file.getName() + "_" + str + String.valueOf(NexEditorDeviceProfile.getDeviceProfile().getTranscodeProfile(EditorGlobal.a().i()).displayHeight()) + "p.mp4");
            case NeedTranscodeFPS:
                return new File(b, file.getName() + str + "_30fps.mp4");
            default:
                throw new UnsupportedOperationException();
        }
    }

    public static File a(Context context, File file, NexExportProfile nexExportProfile) {
        File b = EditorGlobal.b(context);
        b.mkdirs();
        return new File(b, file.getName() + "_" + ("T" + Integer.toHexString(file.getParentFile().getAbsolutePath().hashCode()) + "_") + String.valueOf(nexExportProfile.displayHeight()) + "p.mp4");
    }

    public static File a(Context context, File file) {
        File c = EditorGlobal.c(context);
        c.mkdirs();
        return new File(c, file.getName() + ("T" + Integer.toHexString(file.getParentFile().getAbsolutePath().hashCode()) + "_") + "reverse_transcode.mp4");
    }
}
