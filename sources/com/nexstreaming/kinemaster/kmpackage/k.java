package com.nexstreaming.kinemaster.kmpackage;

import android.graphics.Typeface;
import com.nexstreaming.kinemaster.kmpackage.Font;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: EffectLibrary.java */
/* loaded from: classes.dex */
public class k implements com.nextreaming.nexvideoeditor.a {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ EffectLibrary f3455a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(EffectLibrary effectLibrary) {
        this.f3455a = effectLibrary;
    }

    @Override // com.nextreaming.nexvideoeditor.a
    public InputStream a(String str, String str2) throws IOException {
        if (str2.startsWith("asset:")) {
            return this.f3455a.g.getAssets().open(str2.substring("asset:".length()));
        }
        am e = this.f3455a.e(str);
        if (e == null) {
            e = this.f3455a.c(str);
        }
        if (e == null) {
            throw new RuntimeException("Unable to find theme or effect: " + str);
        }
        return e.k().a(str2);
    }

    @Override // com.nextreaming.nexvideoeditor.a
    public File b(String str, String str2) throws IOException {
        File file;
        if (str2.startsWith("asset:")) {
            return c(str, str2);
        }
        am e = this.f3455a.e(str);
        if (e == null) {
            e = this.f3455a.c(str);
        }
        URI a2 = e.k().a(str2, true);
        if (a2 == null || (file = new File(a2)) == null) {
            return null;
        }
        return file;
    }

    private File c(String str, String str2) throws IOException {
        File file = new File(this.f3455a.A, "a_" + str + "_" + str.hashCode() + "_" + str2.replaceAll("[^A-Za-z0-9_]", "") + str2.hashCode() + "_.tmp");
        if (!file.exists()) {
            InputStream a2 = a(str, str2);
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            byte[] bArr = new byte[10240];
            while (true) {
                int read = a2.read(bArr);
                if (read <= -1) {
                    break;
                }
                fileOutputStream.write(bArr, 0, read);
            }
            fileOutputStream.close();
            a2.close();
        }
        return file;
    }

    @Override // com.nextreaming.nexvideoeditor.a
    public Typeface a(String str) throws Font.TypefaceLoadException {
        Font f;
        if (str == null || str.length() < 1 || (f = this.f3455a.f(str)) == null) {
            return null;
        }
        return f.b(this.f3455a.g);
    }
}
