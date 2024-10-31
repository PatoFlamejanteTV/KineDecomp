package android.support.v4.a;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.Log;
import java.io.File;

/* compiled from: ContextCompat.java */
/* loaded from: classes.dex */
public class a {
    public static final Drawable a(Context context, int i) {
        return Build.VERSION.SDK_INT >= 21 ? b.a(context, i) : context.getResources().getDrawable(i);
    }

    public final File a(Context context) {
        if (Build.VERSION.SDK_INT >= 21) {
            return b.a(context);
        }
        return a(new File(context.getApplicationInfo().dataDir, "no_backup"));
    }

    private static synchronized File a(File file) {
        synchronized (a.class) {
            if (!file.exists() && !file.mkdirs() && !file.exists()) {
                Log.w("ContextCompat", "Unable to create files subdir " + file.getPath());
                file = null;
            }
        }
        return file;
    }
}
