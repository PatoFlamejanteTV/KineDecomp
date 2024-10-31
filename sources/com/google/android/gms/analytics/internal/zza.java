package com.google.android.gms.analytics.internal;

import android.text.TextUtils;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.Locale;

/* loaded from: classes.dex */
public class zza extends zzd {

    /* renamed from: a */
    public static boolean f725a;
    private AdvertisingIdClient.Info b;
    private final d c;
    private String d;
    private boolean e;
    private Object f;

    public zza(zzf zzfVar) {
        super(zzfVar);
        this.e = false;
        this.f = new Object();
        this.c = new d(zzfVar.d());
    }

    private static String a(String str) {
        MessageDigest b = zzam.b("MD5");
        if (b == null) {
            return null;
        }
        return String.format(Locale.US, "%032X", new BigInteger(1, b.digest(str.getBytes())));
    }

    private boolean a(AdvertisingIdClient.Info info, AdvertisingIdClient.Info info2) {
        String str;
        String a2 = info2 == null ? null : info2.a();
        if (TextUtils.isEmpty(a2)) {
            return true;
        }
        String b = x().b();
        synchronized (this.f) {
            if (!this.e) {
                this.d = e();
                this.e = true;
            } else if (TextUtils.isEmpty(this.d)) {
                String a3 = info != null ? info.a() : null;
                if (a3 == null) {
                    return g(a2 + b);
                }
                this.d = a(a3 + b);
            }
            String a4 = a(a2 + b);
            if (TextUtils.isEmpty(a4)) {
                return false;
            }
            if (a4.equals(this.d)) {
                return true;
            }
            if (TextUtils.isEmpty(this.d)) {
                str = b;
            } else {
                b("Resetting the client id because Advertising Id changed.");
                str = x().c();
                a("New client Id", str);
            }
            return g(a2 + str);
        }
    }

    private synchronized AdvertisingIdClient.Info f() {
        if (this.c.a(1000L)) {
            this.c.a();
            AdvertisingIdClient.Info d = d();
            if (a(this.b, d)) {
                this.b = d;
            } else {
                f("Failed to reset client id on adid change. Not using adid");
                this.b = new AdvertisingIdClient.Info("", false);
            }
        }
        return this.b;
    }

    private boolean g(String str) {
        try {
            String a2 = a(str);
            b("Storing hashed adid.");
            FileOutputStream openFileOutput = o().openFileOutput("gaClientIdData", 0);
            openFileOutput.write(a2.getBytes());
            openFileOutput.close();
            this.d = a2;
            return true;
        } catch (IOException e) {
            e("Error creating hash file", e);
            return false;
        }
    }

    @Override // com.google.android.gms.analytics.internal.zzd
    protected void a() {
    }

    public boolean b() {
        D();
        AdvertisingIdClient.Info f = f();
        return (f == null || f.b()) ? false : true;
    }

    public String c() {
        D();
        AdvertisingIdClient.Info f = f();
        String a2 = f != null ? f.a() : null;
        if (TextUtils.isEmpty(a2)) {
            return null;
        }
        return a2;
    }

    protected AdvertisingIdClient.Info d() {
        try {
            return AdvertisingIdClient.b(o());
        } catch (IllegalStateException e) {
            e("IllegalStateException getting Ad Id Info. If you would like to see Audience reports, please ensure that you have added '<meta-data android:name=\"com.google.android.gms.version\" android:value=\"@integer/google_play_services_version\" />' to your application manifest file. See http://goo.gl/naFqQk for details.");
            return null;
        } catch (Throwable th) {
            if (f725a) {
                return null;
            }
            f725a = true;
            d("Error getting advertiser id", th);
            return null;
        }
    }

    protected String e() {
        String str = null;
        try {
            FileInputStream openFileInput = o().openFileInput("gaClientIdData");
            byte[] bArr = new byte[128];
            int read = openFileInput.read(bArr, 0, 128);
            if (openFileInput.available() > 0) {
                e("Hash file seems corrupted, deleting it.");
                openFileInput.close();
                o().deleteFile("gaClientIdData");
            } else if (read <= 0) {
                b("Hash file is empty.");
                openFileInput.close();
            } else {
                String str2 = new String(bArr, 0, read);
                try {
                    openFileInput.close();
                    str = str2;
                } catch (FileNotFoundException e) {
                    str = str2;
                } catch (IOException e2) {
                    str = str2;
                    e = e2;
                    d("Error reading Hash file, deleting it", e);
                    o().deleteFile("gaClientIdData");
                    return str;
                }
            }
        } catch (FileNotFoundException e3) {
        } catch (IOException e4) {
            e = e4;
        }
        return str;
    }
}
