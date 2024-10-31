package io.fabric.sdk.android.a.b;

import android.content.Context;
import io.fabric.sdk.android.services.common.CommonUtils;
import io.fabric.sdk.android.services.common.w;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* compiled from: QueueFileEventStorage.java */
/* loaded from: classes3.dex */
public class i implements d {

    /* renamed from: a */
    private final Context f26819a;

    /* renamed from: b */
    private final File f26820b;

    /* renamed from: c */
    private final String f26821c;

    /* renamed from: d */
    private final File f26822d;

    /* renamed from: e */
    private w f26823e;

    /* renamed from: f */
    private File f26824f;

    public i(Context context, File file, String str, String str2) throws IOException {
        this.f26819a = context;
        this.f26820b = file;
        this.f26821c = str2;
        this.f26822d = new File(this.f26820b, str);
        this.f26823e = new w(this.f26822d);
        e();
    }

    private void e() {
        this.f26824f = new File(this.f26820b, this.f26821c);
        if (this.f26824f.exists()) {
            return;
        }
        this.f26824f.mkdirs();
    }

    public OutputStream a(File file) throws IOException {
        throw null;
    }

    @Override // io.fabric.sdk.android.a.b.d
    public void a(byte[] bArr) throws IOException {
        this.f26823e.a(bArr);
    }

    @Override // io.fabric.sdk.android.a.b.d
    public List<File> b() {
        return Arrays.asList(this.f26824f.listFiles());
    }

    @Override // io.fabric.sdk.android.a.b.d
    public boolean c() {
        return this.f26823e.b();
    }

    @Override // io.fabric.sdk.android.a.b.d
    public void d() {
        try {
            this.f26823e.close();
        } catch (IOException unused) {
        }
        this.f26822d.delete();
    }

    @Override // io.fabric.sdk.android.a.b.d
    public int a() {
        return this.f26823e.r();
    }

    @Override // io.fabric.sdk.android.a.b.d
    public void a(String str) throws IOException {
        this.f26823e.close();
        a(this.f26822d, new File(this.f26824f, str));
        this.f26823e = new w(this.f26822d);
    }

    private void a(File file, File file2) throws IOException {
        FileInputStream fileInputStream;
        OutputStream outputStream = null;
        try {
            fileInputStream = new FileInputStream(file);
            try {
                outputStream = a(file2);
                CommonUtils.a(fileInputStream, outputStream, new byte[1024]);
                CommonUtils.a((Closeable) fileInputStream, "Failed to close file input stream");
                CommonUtils.a((Closeable) outputStream, "Failed to close output stream");
                file.delete();
            } catch (Throwable th) {
                th = th;
                CommonUtils.a((Closeable) fileInputStream, "Failed to close file input stream");
                CommonUtils.a((Closeable) outputStream, "Failed to close output stream");
                file.delete();
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            fileInputStream = null;
        }
    }

    @Override // io.fabric.sdk.android.a.b.d
    public List<File> a(int i) {
        ArrayList arrayList = new ArrayList();
        for (File file : this.f26824f.listFiles()) {
            arrayList.add(file);
            if (arrayList.size() >= i) {
                break;
            }
        }
        return arrayList;
    }

    @Override // io.fabric.sdk.android.a.b.d
    public void a(List<File> list) {
        for (File file : list) {
            CommonUtils.c(this.f26819a, String.format("deleting sent analytics file %s", file.getName()));
            file.delete();
        }
    }

    @Override // io.fabric.sdk.android.a.b.d
    public boolean a(int i, int i2) {
        return this.f26823e.a(i, i2);
    }
}
