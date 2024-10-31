package com.nexstreaming.kinemaster.ad;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.util.Log;
import com.airbnb.lottie.C0657ka;
import com.airbnb.lottie.C0661ma;
import com.nexstreaming.kinemaster.ad.f;
import com.nextreaming.nexeditorui.KineMasterApplication;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;

/* compiled from: LottieBanner.java */
/* loaded from: classes.dex */
public class l extends f {

    /* renamed from: f */
    private static final String f19966f = "l";

    /* renamed from: g */
    private C0661ma f19967g;

    /* renamed from: h */
    private int f19968h;

    public l(BannerInfo bannerInfo) {
        super(bannerInfo);
        this.f19968h = 0;
    }

    public static void b(File file, byte[] bArr) {
        try {
            if (file.exists()) {
                file.delete();
            }
            FileOutputStream fileOutputStream = new FileOutputStream(file, true);
            fileOutputStream.write(bArr);
            fileOutputStream.close();
        } catch (FileNotFoundException e2) {
            e2.printStackTrace();
        } catch (IOException e3) {
            e3.printStackTrace();
        }
    }

    @Override // com.nexstreaming.kinemaster.ad.f
    public boolean h() {
        return this.f19967g != null;
    }

    @Override // com.nexstreaming.kinemaster.ad.f
    public boolean i() {
        return this.f19951a.getRepeat() <= 0 || this.f19968h <= this.f19951a.getRepeat();
    }

    @Override // com.nexstreaming.kinemaster.ad.f
    public void a(f.a aVar) {
        File a2 = a(this.f19951a.getUrl());
        if (a2.exists() && a(a2, aVar)) {
            return;
        }
        c.d.b.b.i.b(this.f19951a.getUrl()).a(Long.MAX_VALUE).a(new j(this, a2, aVar));
    }

    public boolean a(File file, f.a aVar) {
        String a2 = a(file);
        if (a2 == null || !a2.equals(this.f19951a.getHashCode())) {
            return false;
        }
        try {
            ZipInputStream zipInputStream = new ZipInputStream(new FileInputStream(file));
            while (true) {
                ZipEntry nextEntry = zipInputStream.getNextEntry();
                if (nextEntry != null) {
                    if (!nextEntry.isDirectory() && nextEntry.getName().toLowerCase().endsWith(".json")) {
                        C0657ka.a.a(KineMasterApplication.f24056d, new ZipFile(file).getInputStream(nextEntry), new k(this, aVar));
                        zipInputStream.closeEntry();
                        break;
                    }
                } else {
                    break;
                }
            }
            zipInputStream.close();
            return true;
        } catch (FileNotFoundException e2) {
            e2.printStackTrace();
            return true;
        } catch (IOException e3) {
            e3.printStackTrace();
            return true;
        }
    }

    @Override // com.nexstreaming.kinemaster.ad.f
    public void a(long j) {
        if (h()) {
            long c2 = this.f19967g.b().c();
            this.f19967g.a(((float) (j % c2)) / ((float) c2));
            int i = this.f19968h;
            if (j >= c2 * (i + 1)) {
                this.f19968h = i + 1;
            }
        }
    }

    @Override // com.nexstreaming.kinemaster.ad.f
    public void a(Canvas canvas) {
        float f2;
        float f3;
        if (h()) {
            int width = this.f19952b.width();
            int height = this.f19952b.height();
            int intrinsicWidth = this.f19967g.getIntrinsicWidth();
            int intrinsicHeight = this.f19967g.getIntrinsicHeight();
            if (width - intrinsicWidth < height - intrinsicHeight) {
                f2 = width;
                f3 = intrinsicWidth;
            } else {
                f2 = height;
                f3 = intrinsicHeight;
            }
            float f4 = f2 / f3;
            Rect rect = new Rect();
            Rect rect2 = this.f19952b;
            int i = (int) (intrinsicWidth * f4);
            rect.left = rect2.left + ((width - i) / 2) + this.f19953c;
            int i2 = (int) (intrinsicHeight * f4);
            rect.top = rect2.top + ((height - i2) / 2) + this.f19954d;
            rect.right = rect.left + i;
            rect.bottom = rect.top + i2;
            this.f19967g.setBounds(rect);
            this.f19967g.draw(canvas);
        }
    }

    private File a(String str) {
        File filesDir = KineMasterApplication.f24056d.getFilesDir();
        if (str.startsWith("/")) {
            str = str.substring(1);
        }
        File file = new File(filesDir, str);
        if (!file.getParentFile().exists() && !file.getParentFile().mkdirs()) {
            Log.e(f19966f, "Directory not created!");
        }
        return file;
    }

    private String a(File file) {
        String str = null;
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA1");
            FileInputStream fileInputStream = new FileInputStream(file);
            byte[] bArr = new byte[8192];
            while (true) {
                int read = fileInputStream.read(bArr);
                if (read > 0) {
                    messageDigest.update(bArr, 0, read);
                } else {
                    fileInputStream.close();
                    str = new BigInteger(1, messageDigest.digest()).toString(16);
                    return String.format("%40s", str).replace(' ', '0');
                }
            }
        } catch (IOException e2) {
            e2.printStackTrace();
            return str;
        } catch (NoSuchAlgorithmException e3) {
            e3.printStackTrace();
            return str;
        }
    }
}
