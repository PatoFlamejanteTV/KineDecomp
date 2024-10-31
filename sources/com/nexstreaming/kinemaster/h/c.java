package com.nexstreaming.kinemaster.h;

import android.content.Context;
import android.os.Environment;
import android.preference.PreferenceManager;
import com.nexstreaming.kinemaster.project.f;
import com.nexstreaming.kinemaster.ui.projectedit.ProjectEditActivity;
import com.nextreaming.nexeditorui.EditorGlobal;
import com.nextreaming.nexeditorui.KineMasterApplication;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

/* compiled from: StorageLocationManager.java */
/* loaded from: classes.dex */
public class c {
    private static File a(String str, String str2) {
        File externalStoragePublicDirectory;
        String str3;
        String str4;
        if (str.equals("savefiles_audio")) {
            externalStoragePublicDirectory = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_MUSIC);
            str3 = "Audio";
            str4 = "km";
        } else if (str.equals("savefiles_video")) {
            externalStoragePublicDirectory = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_MOVIES);
            str3 = "Video";
            str4 = "km";
        } else if (str.equals("savefiles_image")) {
            externalStoragePublicDirectory = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
            str3 = "Photo";
            str4 = "km";
        } else if (str.equals("savefiles_capture")) {
            externalStoragePublicDirectory = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
            str3 = "Capture";
            str4 = "km";
        } else {
            throw new IllegalArgumentException("Unrecognized value: " + str);
        }
        String string = PreferenceManager.getDefaultSharedPreferences(KineMasterApplication.a().getApplicationContext()).getString(str, str4);
        if ((string.equals("proj") && str2 == null) || str2.trim().length() < 1) {
            string = "km";
        }
        if (string.equals("km")) {
            return new File(EditorGlobal.g(), str3);
        }
        if (!string.equals("def")) {
            if (string.equals("proj")) {
                return new File(new File(EditorGlobal.g(), str3), f.e(str2));
            }
            throw new IllegalStateException("Unrecognized value: " + string);
        }
        return externalStoragePublicDirectory;
    }

    private static String d(Context context) {
        if (context instanceof ProjectEditActivity) {
            return f.f(((ProjectEditActivity) context).p().g().getName());
        }
        return null;
    }

    private static File a(String str, String str2, String str3, String str4) {
        File a2 = a(str, str2);
        if (a2.mkdirs() || a2.isDirectory()) {
            String format = new SimpleDateFormat("yyyy-MM-dd HH.mm.ss", Locale.US).format(Calendar.getInstance().getTime());
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= 5000) {
                    break;
                }
                File file = new File(a2, str3 + format + (i2 <= 0 ? "" : " " + i2) + "." + str4);
                if (!file.exists()) {
                    return file;
                }
                i = i2 + 1;
            }
        }
        return null;
    }

    public static File a(Context context) {
        return a(d(context));
    }

    public static File b(Context context) {
        return a("savefiles_audio", d(context));
    }

    public static File a(String str) {
        return a("savefiles_audio", str, "KineMaster_Audio_", "aac");
    }

    public static File c(Context context) {
        return b(d(context));
    }

    public static File b(String str) {
        return a("savefiles_image", str, "Photo ", "jpg");
    }

    public static File c(String str) {
        return a("savefiles_capture", str, "Capture ", "jpg");
    }

    public static File d(String str) {
        return a("savefiles_video", str, "Photo ", "mp4");
    }
}
