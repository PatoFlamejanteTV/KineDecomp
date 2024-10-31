package com.umeng.commonsdk.statistics.common;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.umeng.commonsdk.framework.UMFrUtils;
import com.umeng.commonsdk.statistics.internal.PreferenceWrapper;
import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.Locale;

/* compiled from: StoreHelper.java */
/* loaded from: classes3.dex */
public final class d {

    /* renamed from: a */
    private static d f26375a = null;

    /* renamed from: b */
    private static Context f26376b = null;

    /* renamed from: c */
    private static String f26377c = null;

    /* renamed from: e */
    private static final String f26378e = "mobclick_agent_user_";

    /* renamed from: f */
    private static final String f26379f = "mobclick_agent_header_";

    /* renamed from: g */
    private static final String f26380g = "mobclick_agent_cached_";

    /* renamed from: d */
    private a f26381d;

    /* compiled from: StoreHelper.java */
    /* loaded from: classes3.dex */
    public static class a {

        /* renamed from: a */
        private final int f26382a;

        /* renamed from: b */
        private File f26383b;

        /* renamed from: c */
        private FilenameFilter f26384c;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: StoreHelper.java */
        /* renamed from: com.umeng.commonsdk.statistics.common.d$a$1 */
        /* loaded from: classes3.dex */
        public class AnonymousClass1 implements FilenameFilter {
            AnonymousClass1() {
            }

            @Override // java.io.FilenameFilter
            public boolean accept(File file, String str) {
                return str.startsWith("um");
            }
        }

        public a(Context context) {
            this(context, ".um");
        }

        public boolean a() {
            File[] listFiles = this.f26383b.listFiles();
            return listFiles != null && listFiles.length > 0;
        }

        public void b() {
            File[] listFiles = this.f26383b.listFiles(this.f26384c);
            if (listFiles == null || listFiles.length <= 0) {
                return;
            }
            for (File file : listFiles) {
                file.delete();
            }
        }

        public int c() {
            File[] listFiles = this.f26383b.listFiles(this.f26384c);
            if (listFiles == null || listFiles.length <= 0) {
                return 0;
            }
            return listFiles.length;
        }

        public a(Context context, String str) {
            this.f26382a = 10;
            this.f26384c = new FilenameFilter() { // from class: com.umeng.commonsdk.statistics.common.d.a.1
                AnonymousClass1() {
                }

                @Override // java.io.FilenameFilter
                public boolean accept(File file, String str2) {
                    return str2.startsWith("um");
                }
            };
            this.f26383b = new File(context.getFilesDir(), str);
            if (this.f26383b.exists() && this.f26383b.isDirectory()) {
                return;
            }
            this.f26383b.mkdir();
        }

        public void a(b bVar) {
            File file;
            File[] listFiles = this.f26383b.listFiles(this.f26384c);
            if (listFiles != null && listFiles.length >= 10) {
                Arrays.sort(listFiles);
                int length = listFiles.length - 10;
                for (int i = 0; i < length; i++) {
                    listFiles[i].delete();
                }
            }
            if (listFiles == null || listFiles.length <= 0) {
                return;
            }
            bVar.a(this.f26383b);
            int length2 = listFiles.length;
            for (int i2 = 0; i2 < length2; i2++) {
                try {
                } catch (Throwable unused) {
                    file = listFiles[i2];
                }
                if (bVar.b(listFiles[i2])) {
                    file = listFiles[i2];
                    file.delete();
                }
            }
            bVar.c(this.f26383b);
        }

        public void a(byte[] bArr) {
            if (bArr == null || bArr.length == 0) {
                return;
            }
            try {
                HelperUtils.writeFile(new File(this.f26383b, String.format(Locale.US, "um_cache_%d.env", Long.valueOf(System.currentTimeMillis()))), bArr);
            } catch (Exception unused) {
            }
        }
    }

    /* compiled from: StoreHelper.java */
    /* loaded from: classes3.dex */
    public interface b {
        void a(File file);

        boolean b(File file);

        void c(File file);
    }

    public d(Context context) {
        this.f26381d = new a(context);
    }

    public static synchronized d a(Context context) {
        d dVar;
        synchronized (d.class) {
            f26376b = context.getApplicationContext();
            f26377c = context.getPackageName();
            if (f26375a == null) {
                f26375a = new d(context);
            }
            dVar = f26375a;
        }
        return dVar;
    }

    private SharedPreferences f() {
        return f26376b.getSharedPreferences(f26378e + f26377c, 0);
    }

    public String b() {
        SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(f26376b);
        if (sharedPreferences != null) {
            return sharedPreferences.getString("st", null);
        }
        return null;
    }

    public boolean c() {
        return UMFrUtils.envelopeFileNumber(f26376b) > 0;
    }

    public String[] d() {
        try {
            SharedPreferences f2 = f();
            String string = f2.getString("au_p", null);
            String string2 = f2.getString("au_u", null);
            if (string != null && string2 != null) {
                return new String[]{string, string2};
            }
        } catch (Exception unused) {
        }
        return null;
    }

    public void e() {
        f().edit().remove("au_p").remove("au_u").commit();
    }

    public void a(int i) {
        SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(f26376b);
        if (sharedPreferences != null) {
            sharedPreferences.edit().putInt("vt", i).commit();
        }
    }

    public int a() {
        SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(f26376b);
        if (sharedPreferences != null) {
            return sharedPreferences.getInt("vt", 0);
        }
        return 0;
    }

    public void a(String str) {
        SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(f26376b);
        if (sharedPreferences != null) {
            sharedPreferences.edit().putString("st", str).commit();
        }
    }

    public void a(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        SharedPreferences.Editor edit = f().edit();
        edit.putString("au_p", str);
        edit.putString("au_u", str2);
        edit.commit();
    }
}
