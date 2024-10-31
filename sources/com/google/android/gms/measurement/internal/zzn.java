package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.facebook.internal.AnalyticsEvents;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzmn;
import java.io.ByteArrayInputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import javax.security.auth.x500.X500Principal;

/* loaded from: classes.dex */
public class zzn extends ac {

    /* renamed from: a */
    private static final X500Principal f2061a = new X500Principal("CN=Android Debug,O=Android,C=US");
    private String b;
    private String c;
    private String d;
    private String e;
    private long f;
    private String h;

    public zzn(zzv zzvVar) {
        super(zzvVar);
    }

    static long a(byte[] bArr) {
        int i = 0;
        zzx.a(bArr);
        zzx.a(bArr.length > 0);
        long j = 0;
        for (int length = bArr.length - 1; length >= 0 && length >= bArr.length - 8; length--) {
            j += (bArr[length] & 255) << i;
            i += 8;
        }
        return j;
    }

    @Override // com.google.android.gms.measurement.internal.ac
    protected void a() {
        String str = AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN;
        String str2 = AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN;
        PackageManager packageManager = i().getPackageManager();
        String packageName = i().getPackageName();
        String installerPackageName = packageManager.getInstallerPackageName(packageName);
        if (installerPackageName == null) {
            installerPackageName = "manual_install";
        } else if ("com.android.vending".equals(installerPackageName)) {
            installerPackageName = "";
        }
        try {
            PackageInfo packageInfo = packageManager.getPackageInfo(i().getPackageName(), 0);
            if (packageInfo != null) {
                CharSequence applicationLabel = packageManager.getApplicationLabel(packageInfo.applicationInfo);
                if (!TextUtils.isEmpty(applicationLabel)) {
                    str2 = applicationLabel.toString();
                }
                str = packageInfo.versionName;
            }
        } catch (PackageManager.NameNotFoundException e) {
            l().b().a("Error retrieving package info: appName", str2);
        }
        this.b = packageName;
        this.d = installerPackageName;
        this.c = str;
        this.e = str2;
        long j = 0;
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            if (!q()) {
                PackageInfo packageInfo2 = packageManager.getPackageInfo(i().getPackageName(), 64);
                if (messageDigest != null && packageInfo2.signatures != null && packageInfo2.signatures.length > 0) {
                    j = a(messageDigest.digest(packageInfo2.signatures[0].toByteArray()));
                }
            }
        } catch (PackageManager.NameNotFoundException e2) {
            l().b().a("Package name not found", e2);
        } catch (NoSuchAlgorithmException e3) {
            l().b().a("Could not get MD5 instance", e3);
        }
        this.f = j;
    }

    public AppMetadata b() {
        return new AppMetadata(this.b, o(), this.c, this.d, n().y(), p());
    }

    @Override // com.google.android.gms.measurement.internal.ab
    public /* bridge */ /* synthetic */ void c() {
        super.c();
    }

    @Override // com.google.android.gms.measurement.internal.ab
    public /* bridge */ /* synthetic */ void d() {
        super.d();
    }

    @Override // com.google.android.gms.measurement.internal.ab
    public /* bridge */ /* synthetic */ void e() {
        super.e();
    }

    @Override // com.google.android.gms.measurement.internal.ab
    public /* bridge */ /* synthetic */ zzn f() {
        return super.f();
    }

    @Override // com.google.android.gms.measurement.internal.ab
    public /* bridge */ /* synthetic */ zzab g() {
        return super.g();
    }

    @Override // com.google.android.gms.measurement.internal.ab
    public /* bridge */ /* synthetic */ zzmn h() {
        return super.h();
    }

    @Override // com.google.android.gms.measurement.internal.ab
    public /* bridge */ /* synthetic */ Context i() {
        return super.i();
    }

    @Override // com.google.android.gms.measurement.internal.ab
    public /* bridge */ /* synthetic */ zzag j() {
        return super.j();
    }

    @Override // com.google.android.gms.measurement.internal.ab
    public /* bridge */ /* synthetic */ zzu k() {
        return super.k();
    }

    @Override // com.google.android.gms.measurement.internal.ab
    public /* bridge */ /* synthetic */ zzp l() {
        return super.l();
    }

    @Override // com.google.android.gms.measurement.internal.ab
    public /* bridge */ /* synthetic */ zzs m() {
        return super.m();
    }

    @Override // com.google.android.gms.measurement.internal.ab
    public /* bridge */ /* synthetic */ zzc n() {
        return super.n();
    }

    public String o() {
        x();
        if (n().z()) {
            return "";
        }
        if (this.h == null) {
            Status a2 = q.a(i());
            if (a2 == null || !a2.d()) {
                this.h = "";
                l().b().a("getGoogleAppId failed with status", Integer.valueOf(a2 == null ? 0 : a2.e()));
                if (a2 != null && a2.b() != null) {
                    l().s().a(a2.b());
                }
            } else {
                try {
                    if (q.c()) {
                        String a3 = q.a();
                        if (TextUtils.isEmpty(a3)) {
                            a3 = "";
                        }
                        this.h = a3;
                    } else {
                        this.h = "";
                    }
                } catch (IllegalStateException e) {
                    this.h = "";
                    l().b().a("getGoogleAppId or isMeasurementEnabled failed with exception", e);
                }
            }
        }
        return this.h;
    }

    long p() {
        x();
        return this.f;
    }

    boolean q() {
        try {
            PackageInfo packageInfo = i().getPackageManager().getPackageInfo(i().getPackageName(), 64);
            if (packageInfo != null && packageInfo.signatures != null && packageInfo.signatures.length > 0) {
                return ((X509Certificate) CertificateFactory.getInstance("X.509").generateCertificate(new ByteArrayInputStream(packageInfo.signatures[0].toByteArray()))).getSubjectX500Principal().equals(f2061a);
            }
        } catch (PackageManager.NameNotFoundException e) {
            l().b().a("Package name not found", e);
        } catch (CertificateException e2) {
            l().b().a("Error obtaining certificate", e2);
        }
        return true;
    }
}
