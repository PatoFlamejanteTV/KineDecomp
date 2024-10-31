package com.nexstreaming.kinemaster.kmpackage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URI;
import java.util.zip.ZipEntry;
import java.util.zip.ZipException;
import java.util.zip.ZipFile;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: KMTZipPackageReader.java */
/* loaded from: classes.dex */
public class ao implements ak {

    /* renamed from: a, reason: collision with root package name */
    private final ZipFile f3439a;
    private final File b;
    private final File c;
    private final z[] d;
    private final boolean e;

    public ao(File file, File file2, z[] zVarArr, boolean z) throws ZipException, IOException {
        this.b = file;
        this.f3439a = new ZipFile(file);
        this.c = file2;
        this.d = zVarArr;
        this.e = z;
    }

    @Override // com.nexstreaming.kinemaster.kmpackage.ak
    public ag a(String str) throws IOException {
        ZipEntry entry = this.f3439a.getEntry(str);
        if (entry == null) {
            throw new FileNotFoundException("Not in zip file: " + str);
        }
        return new ag(this.f3439a.getInputStream(entry), entry.getSize());
    }

    @Override // com.nexstreaming.kinemaster.kmpackage.ak
    public ag b(String str) throws IOException {
        File file = new File(this.c, str);
        return new ag(new FileInputStream(file), file.length());
    }

    @Override // com.nexstreaming.kinemaster.kmpackage.ak
    public boolean c(String str) {
        return new File(this.c, str).exists();
    }

    @Override // com.nexstreaming.kinemaster.kmpackage.ak
    public z[] a() {
        return this.d;
    }

    @Override // com.nexstreaming.kinemaster.kmpackage.ak
    public URI a(String str, boolean z) {
        if (str == null) {
            return null;
        }
        return new File(this.c, str).toURI();
    }

    @Override // com.nexstreaming.kinemaster.kmpackage.ak
    public String b() {
        return this.f3439a.getName();
    }

    @Override // com.nexstreaming.kinemaster.kmpackage.ak
    public boolean c() {
        return false;
    }

    @Override // com.nexstreaming.kinemaster.kmpackage.ak
    public boolean d() {
        return this.e;
    }

    @Override // com.nexstreaming.kinemaster.kmpackage.ak
    public boolean e() {
        if (!this.e) {
            throw new IllegalAccessError();
        }
        try {
            this.f3439a.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return this.b.delete();
    }

    @Override // com.nexstreaming.kinemaster.kmpackage.ak
    public int f() {
        return (int) Math.min(this.b.length(), 2147483647L);
    }
}
