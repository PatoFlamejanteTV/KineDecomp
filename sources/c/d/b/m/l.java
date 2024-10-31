package c.d.b.m;

import android.content.Context;
import android.os.Environment;
import android.preference.PreferenceManager;
import com.nexstreaming.kinemaster.ui.projectedit.ProjectEditActivity;
import com.nextreaming.nexeditorui.EditorGlobal;
import com.nextreaming.nexeditorui.KineMasterApplication;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

/* compiled from: StorageLocationManager.java */
/* loaded from: classes2.dex */
public class l {
    private static File a(String str, String str2) {
        File externalStoragePublicDirectory;
        String str3;
        if (str.equals("savefiles_audio")) {
            externalStoragePublicDirectory = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_MUSIC);
            str3 = "Audio";
        } else if (str.equals("savefiles_video")) {
            externalStoragePublicDirectory = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_MOVIES);
            str3 = "Video";
        } else if (str.equals("savefiles_image")) {
            externalStoragePublicDirectory = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
            str3 = "Photo";
        } else if (str.equals("savefiles_capture")) {
            externalStoragePublicDirectory = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
            str3 = "Capture";
        } else {
            throw new IllegalArgumentException("Unrecognized value: " + str);
        }
        String string = PreferenceManager.getDefaultSharedPreferences(KineMasterApplication.f24056d.getApplicationContext()).getString(str, "km");
        if ((string.equals("proj") && str2 == null) || str2.trim().length() < 1) {
            string = "km";
        }
        if (string.equals("km")) {
            return new File(EditorGlobal.c(), str3);
        }
        if (string.equals("def")) {
            return externalStoragePublicDirectory;
        }
        if (string.equals("proj")) {
            return new File(new File(EditorGlobal.c(), str3), com.nexstreaming.kinemaster.project.k.d(str2));
        }
        throw new IllegalStateException("Unrecognized value: " + string);
    }

    public static File b(Context context) {
        return d(d(context));
    }

    public static File c(Context context) {
        return a("savefiles_audio", d(context));
    }

    private static String d(Context context) {
        if (context instanceof ProjectEditActivity) {
            return com.nexstreaming.kinemaster.project.k.b(((ProjectEditActivity) context).ja().t().getName());
        }
        return null;
    }

    public static File b(String str) {
        return a("savefiles_image", str, "Photo ", "jpg");
    }

    public static File c(String str) {
        return a("savefiles_video", str, "Photo ", "mp4", "tmp");
    }

    public static File d(String str) {
        return a("savefiles_audio", str, "KineMaster_Audio_", "aac");
    }

    private static File a(String str, String str2, String str3, String str4) {
        File a2 = a(str, str2);
        if (!a2.mkdirs() && !a2.isDirectory()) {
            return null;
        }
        String format = new SimpleDateFormat("yyyy-MM-dd HH.mm.ss", Locale.US).format(Calendar.getInstance().getTime());
        for (int i = 0; i < 5000; i++) {
            StringBuilder sb = new StringBuilder();
            sb.append(str3);
            sb.append(format);
            sb.append(i <= 0 ? "" : " " + i);
            sb.append(".");
            sb.append(str4);
            File file = new File(a2, sb.toString());
            if (!file.exists()) {
                return file;
            }
        }
        return null;
    }

    private static File a(String str, String str2, String str3, String str4, String str5) {
        File a2 = a(str, str2);
        if (!a2.mkdirs() && !a2.isDirectory()) {
            return null;
        }
        String format = new SimpleDateFormat("yyyy-MM-dd HH.mm.ss", Locale.US).format(Calendar.getInstance().getTime());
        for (int i = 0; i < 5000; i++) {
            StringBuilder sb = new StringBuilder();
            sb.append(str3);
            sb.append(format);
            sb.append(i <= 0 ? "" : " " + i);
            sb.append(".");
            sb.append(str4);
            if (!new File(a2, sb.toString()).exists()) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(str3);
                sb2.append(format);
                sb2.append(i > 0 ? " " + i : "");
                sb2.append(".");
                sb2.append(str4);
                sb2.append(".");
                sb2.append(str5);
                File file = new File(a2, sb2.toString());
                if (!file.exists()) {
                    return file;
                }
            }
        }
        return null;
    }

    public static File a(Context context) {
        return b(d(context));
    }

    public static File a(String str) {
        return a("savefiles_capture", str, "Capture ", "jpg");
    }
}
