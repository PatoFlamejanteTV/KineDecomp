package b.a.b.a;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Build;
import android.util.Log;
import android.util.Pair;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

/* compiled from: SupportSQLiteOpenHelper.java */
/* loaded from: classes.dex */
public interface c {

    /* compiled from: SupportSQLiteOpenHelper.java */
    /* loaded from: classes.dex */
    public static abstract class a {

        /* renamed from: a */
        public final int f3252a;

        public a(int i) {
            this.f3252a = i;
        }

        private void a(String str) {
            if (str.equalsIgnoreCase(":memory:") || str.trim().length() == 0) {
                return;
            }
            Log.w("SupportSQLite", "deleting the database file: " + str);
            try {
                if (Build.VERSION.SDK_INT >= 16) {
                    SQLiteDatabase.deleteDatabase(new File(str));
                } else {
                    try {
                        if (!new File(str).delete()) {
                            Log.e("SupportSQLite", "Could not delete the database file " + str);
                        }
                    } catch (Exception e2) {
                        Log.e("SupportSQLite", "error while deleting corrupted database file", e2);
                    }
                }
            } catch (Exception e3) {
                Log.w("SupportSQLite", "delete failed: ", e3);
            }
        }

        public void a(b.a.b.a.b bVar) {
        }

        public abstract void a(b.a.b.a.b bVar, int i, int i2);

        public void b(b.a.b.a.b bVar) {
            Log.e("SupportSQLite", "Corruption reported by sqlite on database: " + bVar.getPath());
            if (!bVar.isOpen()) {
                a(bVar.getPath());
                return;
            }
            List<Pair<String, String>> list = null;
            try {
                try {
                    list = bVar.J();
                } finally {
                    if (list != null) {
                        Iterator<Pair<String, String>> it = list.iterator();
                        while (it.hasNext()) {
                            a((String) it.next().second);
                        }
                    } else {
                        a(bVar.getPath());
                    }
                }
            } catch (SQLiteException unused) {
            }
            try {
                bVar.close();
            } catch (IOException unused2) {
            }
        }

        public abstract void b(b.a.b.a.b bVar, int i, int i2);

        public abstract void c(b.a.b.a.b bVar);

        public void d(b.a.b.a.b bVar) {
        }
    }

    /* compiled from: SupportSQLiteOpenHelper.java */
    /* renamed from: b.a.b.a.c$c */
    /* loaded from: classes.dex */
    public interface InterfaceC0008c {
        c a(b bVar);
    }

    b.a.b.a.b a();

    void a(boolean z);

    /* compiled from: SupportSQLiteOpenHelper.java */
    /* loaded from: classes.dex */
    public static class b {

        /* renamed from: a */
        public final Context f3253a;

        /* renamed from: b */
        public final String f3254b;

        /* renamed from: c */
        public final a f3255c;

        b(Context context, String str, a aVar) {
            this.f3253a = context;
            this.f3254b = str;
            this.f3255c = aVar;
        }

        public static a a(Context context) {
            return new a(context);
        }

        /* compiled from: SupportSQLiteOpenHelper.java */
        /* loaded from: classes.dex */
        public static class a {

            /* renamed from: a */
            Context f3256a;

            /* renamed from: b */
            String f3257b;

            /* renamed from: c */
            a f3258c;

            a(Context context) {
                this.f3256a = context;
            }

            public b a() {
                a aVar = this.f3258c;
                if (aVar != null) {
                    Context context = this.f3256a;
                    if (context != null) {
                        return new b(context, this.f3257b, aVar);
                    }
                    throw new IllegalArgumentException("Must set a non-null context to create the configuration.");
                }
                throw new IllegalArgumentException("Must set a callback to create the configuration.");
            }

            public a a(String str) {
                this.f3257b = str;
                return this;
            }

            public a a(a aVar) {
                this.f3258c = aVar;
                return this;
            }
        }
    }
}
