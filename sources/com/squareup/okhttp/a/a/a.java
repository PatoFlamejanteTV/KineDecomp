package com.squareup.okhttp.a.a;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import okio.s;
import okio.y;
import okio.z;

/* compiled from: FileSystem.java */
/* loaded from: classes3.dex */
class a implements b {
    @Override // com.squareup.okhttp.a.a.b
    public void a(File file, File file2) throws IOException {
        g(file2);
        if (file.renameTo(file2)) {
            return;
        }
        throw new IOException("failed to rename " + file + " to " + file2);
    }

    @Override // com.squareup.okhttp.a.a.b
    public boolean b(File file) throws IOException {
        return file.exists();
    }

    @Override // com.squareup.okhttp.a.a.b
    public y c(File file) throws FileNotFoundException {
        try {
            return s.a(file);
        } catch (FileNotFoundException unused) {
            file.getParentFile().mkdirs();
            return s.a(file);
        }
    }

    @Override // com.squareup.okhttp.a.a.b
    public long d(File file) {
        return file.length();
    }

    @Override // com.squareup.okhttp.a.a.b
    public z e(File file) throws FileNotFoundException {
        return s.c(file);
    }

    @Override // com.squareup.okhttp.a.a.b
    public y f(File file) throws FileNotFoundException {
        try {
            return s.b(file);
        } catch (FileNotFoundException unused) {
            file.getParentFile().mkdirs();
            return s.b(file);
        }
    }

    @Override // com.squareup.okhttp.a.a.b
    public void g(File file) throws IOException {
        if (file.delete() || !file.exists()) {
            return;
        }
        throw new IOException("failed to delete " + file);
    }

    @Override // com.squareup.okhttp.a.a.b
    public void a(File file) throws IOException {
        File[] listFiles = file.listFiles();
        if (listFiles != null) {
            for (File file2 : listFiles) {
                if (file2.isDirectory()) {
                    a(file2);
                }
                if (!file2.delete()) {
                    throw new IOException("failed to delete " + file2);
                }
            }
            return;
        }
        throw new IOException("not a readable directory: " + file);
    }
}
