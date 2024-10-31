package com.nexstreaming.kinemaster.kmpackage;

import android.text.TextUtils;
import android.util.Xml;
import com.facebook.internal.Utility;
import com.nexstreaming.kinemaster.kmpackage.KMTManifest;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.keyczar.Crypter;
import org.keyczar.exceptions.KeyczarException;
import org.xml.sax.SAXException;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: KMTPackage.java */
/* loaded from: classes.dex */
public class ai {

    /* renamed from: a, reason: collision with root package name */
    private final ak f3435a;
    private final KMTManifest b;
    private List<String> c = new ArrayList();
    private List<Theme> d = new ArrayList();
    private List<at> e = new ArrayList();
    private List<a> f = new ArrayList();
    private boolean g = false;

    public ai(ak akVar) throws KineMasterPackageException, IOException {
        this.f3435a = akVar;
        this.b = new KMTManifest(akVar.a("manifest.txt").f3434a);
        List<String> a2 = al.a(this.b, akVar);
        if (a2.size() > 0) {
            throw new MissingDependencyException("Missing dependencies:\n  " + TextUtils.join("\n  ", a2));
        }
        if (!al.b(this.b, akVar)) {
            throw new BadPackageException("Package Validation Failure");
        }
        Iterator<String> it = this.b.e().iterator();
        while (it.hasNext()) {
            am b = b(it.next());
            if (b != null) {
                if (b instanceof Theme) {
                    this.d.add((Theme) b);
                } else if (b instanceof at) {
                    this.e.add((at) b);
                } else if (b instanceof a) {
                    this.f.add((a) b);
                }
            }
        }
    }

    public KMTManifest a() {
        return this.b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String b() {
        return this.f3435a.b();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean c() {
        return this.g;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(boolean z) {
        this.g = z;
    }

    private am b(String str) {
        String str2 = str + ".xml";
        KMTManifest.a aVar = this.b.a().get(str2);
        if (aVar == null) {
            return null;
        }
        try {
            InputStream inputStream = this.f3435a.a(str2).f3434a;
            af afVar = new af(str);
            StringBuilder sb = new StringBuilder();
            byte[] bArr = new byte[Utility.DEFAULT_STREAM_BUFFER_SIZE];
            while (true) {
                try {
                    int read = inputStream.read(bArr);
                    if (read <= -1) {
                        break;
                    }
                    sb.append(new String(bArr, 0, read));
                } catch (IOException e) {
                    this.c.add(str + ": " + e.getMessage());
                    return null;
                }
            }
            String sb2 = sb.toString();
            boolean z = true;
            if (EffectLibrary.c && (this.f3435a instanceof ac)) {
                z = false;
            }
            if (z) {
                if (aVar.b.equals("e")) {
                    try {
                        sb2 = new Crypter(new aj(this)).decrypt(sb2);
                    } catch (KeyczarException e2) {
                        e2.printStackTrace();
                    }
                } else if (aVar.b.equals("o")) {
                    int length = sb2.length();
                    StringBuilder sb3 = new StringBuilder(length);
                    for (int i = 0; i < length; i++) {
                        sb3.append((char) (((((sb2.charAt(i) - ' ') + 96) - 55) % 96) + 32));
                    }
                    sb2 = sb3.toString();
                }
            }
            try {
                Xml.parse(sb2, afVar);
            } catch (SAXException e3) {
                this.c.add(str + ": " + e3.getMessage());
            }
            am b = afVar.b();
            b.a(this);
            b.a(sb2);
            return b;
        } catch (IOException e4) {
            e4.printStackTrace();
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public InputStream a(String str) throws IOException {
        if (this.b.d().contains(str)) {
            return this.f3435a.a("res/" + str).f3434a;
        }
        if (this.b.a().keySet().contains(str)) {
            return this.f3435a.a(str).f3434a;
        }
        if (this.b.b().keySet().contains(str)) {
            return this.f3435a.b(str).f3434a;
        }
        if (this.b.c().keySet().contains(str)) {
            return this.f3435a.b(str).f3434a;
        }
        throw new FileNotFoundException(str);
    }

    public boolean d() {
        return this.f3435a.c();
    }

    public boolean e() {
        return this.f3435a.d();
    }

    public boolean f() {
        return this.f3435a.e();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public URI a(String str, boolean z) {
        return this.f3435a.a(str, z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int g() {
        return this.f3435a.f();
    }

    public List<Theme> h() {
        return Collections.unmodifiableList(this.d);
    }

    public List<at> i() {
        return Collections.unmodifiableList(this.e);
    }

    public List<a> j() {
        return Collections.unmodifiableList(this.f);
    }

    public List<String> k() {
        return Collections.unmodifiableList(this.c);
    }
}
