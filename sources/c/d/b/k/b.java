package c.d.b.k;

import android.content.Context;
import com.nexstreaming.kinemaster.mediastore.MediaSupportType;
import com.nextreaming.nexeditorui.EditorGlobal;
import com.nextreaming.nexeditorui.NexEditorDeviceProfile;
import com.nextreaming.nexeditorui.NexExportProfile;
import java.io.File;
import java.util.Date;

/* compiled from: TranscodeUtil.java */
/* loaded from: classes.dex */
public class b {
    public static File a(Context context, File file, MediaSupportType mediaSupportType, int i) {
        File a2 = EditorGlobal.a(context);
        a2.mkdirs();
        String str = "T" + Integer.toHexString(file.getParentFile().getAbsolutePath().hashCode()) + io.fabric.sdk.android.a.b.c.ROLL_OVER_FILE_NAME_SEPARATOR;
        int i2 = a.f3824a[mediaSupportType.ordinal()];
        if (i2 != 1) {
            if (i2 == 2) {
                return new File(a2, file.getName() + str + "_avsync.mp4");
            }
            if (i2 == 3) {
                return new File(a2, file.getName() + str + "_30fps.mp4");
            }
            throw new UnsupportedOperationException();
        }
        NexExportProfile transcodeProfile = NexEditorDeviceProfile.getDeviceProfile().getTranscodeProfile((i * 16) / 9, i);
        if (transcodeProfile != null) {
            return new File(a2, file.getName() + io.fabric.sdk.android.a.b.c.ROLL_OVER_FILE_NAME_SEPARATOR + str + String.valueOf(transcodeProfile.displayHeight()) + "p.mp4");
        }
        return new File(a2, file.getName() + io.fabric.sdk.android.a.b.c.ROLL_OVER_FILE_NAME_SEPARATOR + str + "notp.mp4");
    }

    public static File a(Context context, File file, MediaSupportType mediaSupportType) {
        File a2 = EditorGlobal.a(context);
        a2.mkdirs();
        String str = "T" + Integer.toHexString(file.getParentFile().getAbsolutePath().hashCode()) + io.fabric.sdk.android.a.b.c.ROLL_OVER_FILE_NAME_SEPARATOR;
        int i = a.f3824a[mediaSupportType.ordinal()];
        if (i == 1) {
            return new File(a2, file.getName() + io.fabric.sdk.android.a.b.c.ROLL_OVER_FILE_NAME_SEPARATOR + str + String.valueOf(NexEditorDeviceProfile.getDeviceProfile().getTranscodeProfile(EditorGlobal.i().b()).displayHeight()) + "p.mp4");
        }
        if (i == 2) {
            return new File(a2, file.getName() + str + "_avsync.mp4");
        }
        if (i == 3) {
            return new File(a2, file.getName() + str + "_30fps.mp4");
        }
        throw new UnsupportedOperationException();
    }

    public static File a(Context context, File file, NexExportProfile nexExportProfile) {
        File a2 = EditorGlobal.a(context);
        a2.mkdirs();
        return new File(a2, file.getName() + io.fabric.sdk.android.a.b.c.ROLL_OVER_FILE_NAME_SEPARATOR + ("T" + Integer.toHexString(file.getParentFile().getAbsolutePath().hashCode()) + io.fabric.sdk.android.a.b.c.ROLL_OVER_FILE_NAME_SEPARATOR) + String.valueOf(nexExportProfile.displayHeight()) + "p.mp4");
    }

    public static File a(Context context, File file) {
        File f2 = EditorGlobal.f(context);
        f2.mkdirs();
        return new File(f2, file.getName() + ("R" + Integer.toHexString(file.getParentFile().getAbsolutePath().hashCode()) + io.fabric.sdk.android.a.b.c.ROLL_OVER_FILE_NAME_SEPARATOR) + "reverse_transcode.mp4");
    }

    public static File a(Context context, File file, int i, int i2) {
        File f2 = EditorGlobal.f(context);
        long time = new Date().getTime();
        f2.mkdirs();
        String str = "_R" + Integer.toHexString(file.getParentFile().getAbsolutePath().hashCode()) + io.fabric.sdk.android.a.b.c.ROLL_OVER_FILE_NAME_SEPARATOR;
        return new File(f2, "reverse_" + Integer.toHexString(file.getParentFile().getAbsolutePath().hashCode()) + io.fabric.sdk.android.a.b.c.ROLL_OVER_FILE_NAME_SEPARATOR + time + ".mp4");
    }
}
