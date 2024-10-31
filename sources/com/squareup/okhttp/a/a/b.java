package com.squareup.okhttp.a.a;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import okio.y;
import okio.z;

/* compiled from: FileSystem.java */
/* loaded from: classes3.dex */
public interface b {

    /* renamed from: a */
    public static final b f25139a = new a();

    void a(File file) throws IOException;

    void a(File file, File file2) throws IOException;

    boolean b(File file) throws IOException;

    y c(File file) throws FileNotFoundException;

    long d(File file);

    z e(File file) throws FileNotFoundException;

    y f(File file) throws FileNotFoundException;

    void g(File file) throws IOException;
}
