package com.nexstreaming.kinemaster.kmpackage;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.util.Enumeration;
import java.util.Locale;
import java.util.zip.ZipEntry;
import java.util.zip.ZipException;
import java.util.zip.ZipFile;

/* compiled from: KMTAdHocManifestPackageReader.java */
/* loaded from: classes.dex */
public class ac implements ak {

    /* renamed from: a */
    private final ZipFile f3429a;
    private final File b;
    private final File c;

    public ac(File file, File file2) throws ZipException, IOException {
        if (!EffectLibrary.c) {
            throw new InternalError();
        }
        this.b = file;
        this.f3429a = new ZipFile(file);
        this.c = file2;
    }

    @Override // com.nexstreaming.kinemaster.kmpackage.ak
    public ag a(String str) throws IOException {
        return e(str);
    }

    @Override // com.nexstreaming.kinemaster.kmpackage.ak
    public ag b(String str) throws IOException {
        return e(str);
    }

    @Override // com.nexstreaming.kinemaster.kmpackage.ak
    public boolean c(String str) {
        return true;
    }

    @Override // com.nexstreaming.kinemaster.kmpackage.ak
    public URI a(String str, boolean z) {
        try {
            File b = b(str, z);
            if (b == null) {
                return null;
            }
            return b.toURI();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override // com.nexstreaming.kinemaster.kmpackage.ak
    public String b() {
        return this.f3429a.getName();
    }

    @Override // com.nexstreaming.kinemaster.kmpackage.ak
    public z[] a() {
        throw new InternalError();
    }

    @Override // com.nexstreaming.kinemaster.kmpackage.ak
    public boolean c() {
        return false;
    }

    @Override // com.nexstreaming.kinemaster.kmpackage.ak
    public boolean d() {
        return false;
    }

    @Override // com.nexstreaming.kinemaster.kmpackage.ak
    public boolean e() {
        throw new IllegalAccessError();
    }

    @Override // com.nexstreaming.kinemaster.kmpackage.ak
    public int f() {
        return (int) Math.min(this.b.length(), 2147483647L);
    }

    private static String d(String str) {
        String lowerCase = str.toLowerCase(Locale.US);
        int lastIndexOf = lowerCase.lastIndexOf(47);
        if (lastIndexOf > -1) {
            return lowerCase.substring(lastIndexOf + 1);
        }
        return lowerCase;
    }

    private ag e(String str) throws IOException {
        if (str.equals("manifest.txt")) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
            dataOutputStream.writeBytes("KineMaster Manifest/0100\n");
            dataOutputStream.writeBytes("[published-effects]\n");
            Enumeration<? extends ZipEntry> entries = this.f3429a.entries();
            while (entries.hasMoreElements()) {
                String d = d(entries.nextElement().getName());
                if (!d.startsWith(".") && d.endsWith(".xml")) {
                    dataOutputStream.writeBytes(d.substring(0, d.length() - 4) + "=0\n");
                }
            }
            dataOutputStream.writeBytes("[internal-dependencies]\n");
            Enumeration<? extends ZipEntry> entries2 = this.f3429a.entries();
            while (entries2.hasMoreElements()) {
                String d2 = d(entries2.nextElement().getName());
                if (!d2.startsWith(".") && d2.length() >= 1 && !d2.endsWith(".xml")) {
                    dataOutputStream.writeBytes(d2 + "=0\n");
                }
            }
            dataOutputStream.writeBytes("[external-dependencies]\n");
            dataOutputStream.writeBytes("[opt-external-dependencies]\n");
            dataOutputStream.close();
            return new ag(new ByteArrayInputStream(byteArrayOutputStream.toByteArray()));
        }
        if (str.startsWith("res/")) {
            str = str.substring(4);
        }
        Enumeration<? extends ZipEntry> entries3 = this.f3429a.entries();
        while (entries3.hasMoreElements()) {
            ZipEntry nextElement = entries3.nextElement();
            String d3 = d(nextElement.getName());
            if (!d3.startsWith(".") && d3.equalsIgnoreCase(str)) {
                return new ag(this.f3429a.getInputStream(nextElement), nextElement.getSize());
            }
        }
        ZipEntry entry = this.f3429a.getEntry(str);
        if (entry == null) {
            throw new FileNotFoundException("Not in zip file: " + str);
        }
        return new ag(this.f3429a.getInputStream(entry), entry.getSize());
    }

    private File b(String str, boolean z) throws IOException {
        File file = new File(this.c, "adhoc_" + str.replaceAll("[^A-Za-z0-9_]", "") + str.hashCode() + "_.tmp");
        if (!file.exists()) {
            if (!z) {
                return null;
            }
            InputStream inputStream = e(str).f3434a;
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            byte[] bArr = new byte[10240];
            while (true) {
                int read = inputStream.read(bArr);
                if (read > -1) {
                    fileOutputStream.write(bArr, 0, read);
                } else {
                    fileOutputStream.close();
                    inputStream.close();
                    return file;
                }
            }
        } else {
            return file;
        }
    }
}
