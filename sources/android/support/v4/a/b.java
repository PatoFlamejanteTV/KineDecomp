package android.support.v4.a;

import android.content.Context;
import android.graphics.drawable.Drawable;
import java.io.File;

/* compiled from: ContextCompatApi21.java */
/* loaded from: classes2.dex */
class b {
    public static Drawable a(Context context, int i) {
        return context.getDrawable(i);
    }

    public static File a(Context context) {
        return context.getNoBackupFilesDir();
    }
}
