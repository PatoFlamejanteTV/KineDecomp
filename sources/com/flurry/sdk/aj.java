package com.flurry.sdk;

import android.provider.Settings;
import android.text.TextUtils;
import java.io.DataInput;
import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

/* loaded from: classes.dex */
public final class aj {

    /* renamed from: a, reason: collision with root package name */
    private static final String f458a = aj.class.getSimpleName();
    private static final Set<String> b = i();
    private static String c;

    public static synchronized String a() {
        String str;
        synchronized (aj.class) {
            if (TextUtils.isEmpty(c)) {
                c = g();
            }
            str = c;
        }
        return str;
    }

    private static String g() {
        String b2 = b();
        return !TextUtils.isEmpty(b2) ? b2 : c();
    }

    static String b() {
        String string = Settings.Secure.getString(ad.a().b().getContentResolver(), "android_id");
        if (a(string)) {
            return "AND" + string;
        }
        return null;
    }

    static String c() {
        String e = e();
        if (TextUtils.isEmpty(e)) {
            e = f();
            if (TextUtils.isEmpty(e)) {
                e = d();
            }
            b(e);
        }
        return e;
    }

    static boolean a(String str) {
        return (TextUtils.isEmpty(str) || c(str.toLowerCase(Locale.US))) ? false : true;
    }

    static String d() {
        return "ID" + Long.toString(Double.doubleToLongBits(Math.random()) + (37 * (System.nanoTime() + (ag.b(ad.a().b()).hashCode() * 37))), 16);
    }

    static void b(String str) {
        if (!TextUtils.isEmpty(str)) {
            File fileStreamPath = ad.a().b().getFileStreamPath(h());
            if (ao.a(fileStreamPath)) {
                a(str, fileStreamPath);
            }
        }
    }

    static void a(String str, File file) {
        DataOutputStream dataOutputStream;
        try {
            try {
                dataOutputStream = new DataOutputStream(new FileOutputStream(file));
            } catch (Throwable th) {
                th = th;
                dataOutputStream = null;
                bb.a(dataOutputStream);
                throw th;
            }
            try {
                a(str, dataOutputStream);
                bb.a(dataOutputStream);
            } catch (Throwable th2) {
                th = th2;
                as.a(6, f458a, "Error when saving phoneId", th);
                bb.a(dataOutputStream);
            }
        } catch (Throwable th3) {
            th = th3;
            bb.a(dataOutputStream);
            throw th;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v1, types: [boolean] */
    /* JADX WARN: Type inference failed for: r2v10 */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v3, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r2v5 */
    /* JADX WARN: Type inference failed for: r2v7 */
    /* JADX WARN: Type inference failed for: r2v9 */
    static String e() {
        DataInputStream dataInputStream;
        String str = null;
        File fileStreamPath = ad.a().b().getFileStreamPath(h());
        if (fileStreamPath != null) {
            ?? exists = fileStreamPath.exists();
            try {
                if (exists != 0) {
                    try {
                        dataInputStream = new DataInputStream(new FileInputStream(fileStreamPath));
                    } catch (Throwable th) {
                        th = th;
                        dataInputStream = null;
                    }
                    try {
                        str = a(dataInputStream);
                        bb.a(dataInputStream);
                        exists = dataInputStream;
                    } catch (Throwable th2) {
                        th = th2;
                        as.a(6, f458a, "Error when loading phoneId", th);
                        bb.a(dataInputStream);
                        exists = dataInputStream;
                        return str;
                    }
                }
            } catch (Throwable th3) {
                th = th3;
            }
        }
        return str;
    }

    static String f() {
        String[] list;
        DataInputStream dataInputStream;
        Throwable th;
        String str = null;
        File filesDir = ad.a().b().getFilesDir();
        if (filesDir != null && (list = filesDir.list(new ak())) != null && list.length != 0) {
            File fileStreamPath = ad.a().b().getFileStreamPath(list[0]);
            if (fileStreamPath != null && fileStreamPath.exists()) {
                try {
                    dataInputStream = new DataInputStream(new FileInputStream(fileStreamPath));
                } catch (Throwable th2) {
                    dataInputStream = null;
                    th = th2;
                    bb.a(dataInputStream);
                    throw th;
                }
                try {
                    try {
                        str = b(dataInputStream);
                        bb.a(dataInputStream);
                    } catch (Throwable th3) {
                        th = th3;
                        bb.a(dataInputStream);
                        throw th;
                    }
                } catch (Throwable th4) {
                    th = th4;
                    as.a(6, f458a, "Error when loading phoneId", th);
                    bb.a(dataInputStream);
                    return str;
                }
            }
        }
        return str;
    }

    private static void a(String str, DataOutput dataOutput) throws IOException {
        dataOutput.writeInt(1);
        dataOutput.writeUTF(str);
    }

    private static String a(DataInput dataInput) throws IOException {
        if (1 != dataInput.readInt()) {
            return null;
        }
        return dataInput.readUTF();
    }

    private static String b(DataInput dataInput) throws IOException {
        if (46586 != dataInput.readUnsignedShort() || 2 != dataInput.readUnsignedShort()) {
            return null;
        }
        dataInput.readUTF();
        return dataInput.readUTF();
    }

    private static String h() {
        return ".flurryb.";
    }

    private static boolean c(String str) {
        return b.contains(str);
    }

    private static Set<String> i() {
        HashSet hashSet = new HashSet();
        hashSet.add("null");
        hashSet.add("9774d56d682e549c");
        hashSet.add("dead00beef");
        return Collections.unmodifiableSet(hashSet);
    }
}
