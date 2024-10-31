package com.nexstreaming.kinemaster.ui.share;

import android.content.Context;
import com.nextreaming.nexeditorui.EditorGlobal;
import com.nextreaming.nexeditorui.NexExportProfile;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* compiled from: ShareUtil.java */
/* loaded from: classes.dex */
public class cl {
    public static File a(Context context, NexExportProfile nexExportProfile, com.nexstreaming.kinemaster.project.f fVar) {
        File e = EditorGlobal.e(context);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss", Locale.US);
        Date b = fVar.c() == null ? fVar.b() : fVar.c();
        if (b == null) {
            b = new Date();
        }
        return new File(e, a(fVar.f()) + " " + nexExportProfile.width() + "x" + nexExportProfile.displayHeight() + " " + String.format("%.2f", Float.valueOf(nexExportProfile.bitrate() / 1048576.0f)) + "Mbps " + simpleDateFormat.format(b) + ".mp4");
    }

    public static String a(String str) {
        int length = str.length();
        StringBuilder sb = new StringBuilder(length * 2);
        for (int i = 0; i < length; i++) {
            char charAt = str.charAt(i);
            if ((charAt != '.' || (i != 0 && sb.length() >= 1)) && "/\\*?:;'\"|<>`".indexOf(charAt) < 0 && charAt >= ' ' && charAt != 127) {
                sb.append(charAt);
            }
        }
        return sb.toString();
    }
}
