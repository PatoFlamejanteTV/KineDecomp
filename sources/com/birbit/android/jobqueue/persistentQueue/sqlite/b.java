package com.birbit.android.jobqueue.persistentQueue.sqlite;

import android.content.Context;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.util.Set;
import okio.h;
import okio.i;
import okio.s;

/* compiled from: FileStorage.java */
/* loaded from: classes.dex */
class b {

    /* renamed from: a, reason: collision with root package name */
    private final File f8290a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(Context context, String str) {
        this.f8290a = new File(context.getDir("com_birbit_jobqueue_jobs", 0), "files_" + str);
        this.f8290a.mkdirs();
    }

    private static String c(String str) {
        return str + ".jobs";
    }

    private static String d(String str) {
        if (str.length() < 6) {
            return null;
        }
        return str.substring(0, str.length() - 5);
    }

    private File e(String str) {
        return new File(this.f8290a, c(str));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(String str) {
        File e2 = e(str);
        if (e2.exists()) {
            e2.delete();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public byte[] b(String str) throws IOException {
        File e2 = e(str);
        if (!e2.exists() || !e2.canRead()) {
            return null;
        }
        i a2 = s.a(s.c(e2));
        try {
            return a2.k();
        } finally {
            a(a2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(String str, byte[] bArr) throws IOException {
        h a2 = s.a(s.b(e(str)));
        try {
            a2.write(bArr).flush();
        } finally {
            a(a2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Set<String> set) {
        for (String str : this.f8290a.list()) {
            if (str.endsWith(".jobs") && !set.contains(d(str))) {
                File file = new File(this.f8290a, str);
                if (!file.delete()) {
                    com.birbit.android.jobqueue.f.c.a("cannot delete unused job toFile " + file.getAbsolutePath(), new Object[0]);
                }
            }
        }
    }

    private static void a(Closeable closeable) {
        try {
            closeable.close();
        } catch (IOException unused) {
        }
    }
}
