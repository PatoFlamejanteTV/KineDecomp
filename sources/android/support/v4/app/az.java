package android.support.v4.app;

import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: TaskStackBuilder.java */
/* loaded from: classes.dex */
public class az implements Iterable<Intent> {

    /* renamed from: a, reason: collision with root package name */
    private static final a f50a;
    private final ArrayList<Intent> b = new ArrayList<>();
    private final Context c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TaskStackBuilder.java */
    /* loaded from: classes.dex */
    public interface a {
        PendingIntent a(Context context, Intent[] intentArr, int i, int i2, Bundle bundle);
    }

    /* compiled from: TaskStackBuilder.java */
    /* loaded from: classes.dex */
    static class b implements a {
        b() {
        }

        @Override // android.support.v4.app.az.a
        public PendingIntent a(Context context, Intent[] intentArr, int i, int i2, Bundle bundle) {
            Intent intent = new Intent(intentArr[intentArr.length - 1]);
            intent.addFlags(268435456);
            return PendingIntent.getActivity(context, i, intent, i2);
        }
    }

    /* compiled from: TaskStackBuilder.java */
    /* loaded from: classes.dex */
    static class c implements a {
        c() {
        }

        @Override // android.support.v4.app.az.a
        public PendingIntent a(Context context, Intent[] intentArr, int i, int i2, Bundle bundle) {
            intentArr[0] = new Intent(intentArr[0]).addFlags(268484608);
            return ba.a(context, i, intentArr, i2);
        }
    }

    static {
        if (Build.VERSION.SDK_INT >= 11) {
            f50a = new c();
        } else {
            f50a = new b();
        }
    }

    private az(Context context) {
        this.c = context;
    }

    public static az a(Context context) {
        return new az(context);
    }

    public az a(Intent intent) {
        this.b.add(intent);
        return this;
    }

    public az a(Class<?> cls) {
        return a(new ComponentName(this.c, cls));
    }

    public az a(ComponentName componentName) {
        int size = this.b.size();
        try {
            Intent a2 = ae.a(this.c, componentName);
            while (a2 != null) {
                this.b.add(size, a2);
                a2 = ae.a(this.c, a2.getComponent());
            }
            return this;
        } catch (PackageManager.NameNotFoundException e) {
            Log.e("TaskStackBuilder", "Bad ComponentName while traversing activity parent metadata");
            throw new IllegalArgumentException(e);
        }
    }

    @Override // java.lang.Iterable
    public Iterator<Intent> iterator() {
        return this.b.iterator();
    }

    public PendingIntent a(int i, int i2) {
        return a(i, i2, null);
    }

    public PendingIntent a(int i, int i2, Bundle bundle) {
        if (this.b.isEmpty()) {
            throw new IllegalStateException("No intents added to TaskStackBuilder; cannot getPendingIntent");
        }
        Intent[] intentArr = (Intent[]) this.b.toArray(new Intent[this.b.size()]);
        intentArr[0] = new Intent(intentArr[0]).addFlags(268484608);
        return f50a.a(this.c, intentArr, i, i2, bundle);
    }
}
