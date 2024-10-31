package com.nexstreaming.kinemaster.ui.share;

import android.content.Context;
import android.preference.PreferenceManager;
import com.nextreaming.nexeditorui.EditorGlobal;
import com.nextreaming.nexeditorui.NexExportProfile;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* compiled from: ShareUtil.java */
/* loaded from: classes2.dex */
public class Ja {
    public static File a(Context context, NexExportProfile nexExportProfile, com.nexstreaming.kinemaster.project.k kVar) {
        File d2 = EditorGlobal.d(context);
        String a2 = a(kVar.f());
        File file = new File(d2, String.format("%s_%s.mp4", a2, nexExportProfile.displayHeight() + "p"));
        int i = 1;
        while (file.exists()) {
            file = new File(d2, String.format(Locale.US, "%s_%s_%d.mp4", a2, nexExportProfile.displayHeight() + "p", Integer.valueOf(i)));
            i++;
        }
        return file;
    }

    public static File b(Context context, NexExportProfile nexExportProfile, com.nexstreaming.kinemaster.project.k kVar) {
        File d2 = EditorGlobal.d(context);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MMMddyyyy", Locale.US);
        int parseInt = Integer.parseInt(PreferenceManager.getDefaultSharedPreferences(context).getString("exporting_frame_rate", "30"));
        Date date = new Date();
        File file = new File(d2, String.format(Locale.US, "%d_%d_%.2f_%s_msk.mp4", Integer.valueOf(nexExportProfile.displayHeight()), Integer.valueOf(parseInt), Float.valueOf(nexExportProfile.bitrate() / 1048576.0f), simpleDateFormat.format(date)));
        int i = 1;
        while (file.exists()) {
            file = new File(d2, String.format(Locale.US, "%d_%d_%.2f_%s_msk_%02d.mp4", Integer.valueOf(nexExportProfile.displayHeight()), Integer.valueOf(parseInt), Float.valueOf(nexExportProfile.bitrate() / 1048576.0f), simpleDateFormat.format(date), Integer.valueOf(i)));
            i++;
        }
        return file;
    }

    public static String a(String str) {
        String replaceAll = str.replace("^\\.+", "").replaceAll("[\\\\/:*?\"<>|]", "");
        if (replaceAll.length() != 0) {
            return replaceAll;
        }
        throw new IllegalStateException("File Name " + str + " results in a empty fileName!");
    }
}
