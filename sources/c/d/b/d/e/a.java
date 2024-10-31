package c.d.b.d.e;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;
import android.webkit.MimeTypeMap;
import java.io.File;
import java.net.MalformedURLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.UUID;

/* compiled from: XmlUtil.java */
/* loaded from: classes.dex */
public class a {
    public static String a() {
        return UUID.randomUUID().toString();
    }

    public static String b(String str) {
        try {
            return new File(str).toURI().toURL().toString();
        } catch (MalformedURLException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static String c(String str) {
        return str.substring(str.lastIndexOf("/") + 1);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x00b7, code lost:            if (r3.equals("jpg") != false) goto L157;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String d(java.lang.String r3) {
        /*
            Method dump skipped, instructions count: 396
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: c.d.b.d.e.a.d(java.lang.String):java.lang.String");
    }

    public static String e(String str) {
        String fileExtensionFromUrl = MimeTypeMap.getFileExtensionFromUrl(str);
        String mimeTypeFromExtension = fileExtensionFromUrl != null ? MimeTypeMap.getSingleton().getMimeTypeFromExtension(fileExtensionFromUrl) : null;
        return mimeTypeFromExtension == null ? d(str) : mimeTypeFromExtension;
    }

    public static boolean f(String str) {
        return new File(str).exists();
    }

    public static int a(long j, long j2) {
        double d2 = j;
        double d3 = j2;
        Double.isNaN(d2);
        Double.isNaN(d3);
        return (int) Math.floor((d2 * d3) / 1000.0d);
    }

    public static String a(File file) {
        return Uri.fromFile(file).toString();
    }

    public static String a(Context context, String str, String str2) {
        File externalFilesDir = context.getExternalFilesDir(null);
        return String.format(Locale.US, "%s/%s_%s_%s.xml", externalFilesDir.getAbsolutePath(), str2.toLowerCase(Locale.US), str, new SimpleDateFormat("yyyyMMdd_HHmm").format(new Date()));
    }

    public static Uri a(Context context, String str) {
        Uri uri = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
        Cursor query = context.getContentResolver().query(uri, new String[]{"_id"}, "_data = ?", new String[]{str}, null);
        if (query == null) {
            return null;
        }
        try {
            if (query.moveToFirst()) {
                return Uri.withAppendedPath(uri, String.valueOf(query.getInt(0)));
            }
            return null;
        } finally {
            query.close();
        }
    }

    public static float a(int i) {
        double d2 = i;
        Double.isNaN(d2);
        return (float) (d2 / 1000.0d);
    }

    public static String a(float f2) {
        return String.format(Locale.US, "%.3fs", Float.valueOf(f2));
    }

    public static String a(String str) {
        if (!str.contains("/")) {
            return str;
        }
        String[] split = str.split("/");
        return (split.length <= 0 || split[split.length + (-1)].length() <= 0) ? str : split[split.length - 1];
    }
}
