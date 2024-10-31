package com.crashlytics.android.beta;

import android.content.Context;
import android.content.pm.PackageManager;
import io.fabric.sdk.android.a.a.d;
import io.fabric.sdk.android.f;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/* loaded from: classes.dex */
public class DeviceTokenLoader implements d<String> {
    private static final String BETA_APP_PACKAGE_NAME = "io.crash.air";
    private static final String DIRFACTOR_DEVICE_TOKEN_PREFIX = "assets/com.crashlytics.android.beta/dirfactor-device-token=";

    String determineDeviceToken(ZipInputStream zipInputStream) throws IOException {
        ZipEntry nextEntry = zipInputStream.getNextEntry();
        if (nextEntry == null) {
            return "";
        }
        String name = nextEntry.getName();
        return name.startsWith(DIRFACTOR_DEVICE_TOKEN_PREFIX) ? name.substring(59, name.length() - 1) : "";
    }

    ZipInputStream getZipInputStreamOfApkFrom(Context context, String str) throws PackageManager.NameNotFoundException, FileNotFoundException {
        return new ZipInputStream(new FileInputStream(context.getPackageManager().getApplicationInfo(str, 0).sourceDir));
    }

    @Override // io.fabric.sdk.android.a.a.d
    public String load(Context context) throws Exception {
        String str;
        long nanoTime = System.nanoTime();
        ZipInputStream zipInputStream = null;
        try {
        } catch (IOException e2) {
            f.f().c(Beta.TAG, "Failed to close the APK file", e2);
        }
        try {
            try {
                try {
                    try {
                        zipInputStream = getZipInputStreamOfApkFrom(context, "io.crash.air");
                        str = determineDeviceToken(zipInputStream);
                    } catch (IOException e3) {
                        f.f().c(Beta.TAG, "Failed to read the APK file", e3);
                        if (zipInputStream != null) {
                            zipInputStream.close();
                        }
                        str = "";
                        double nanoTime2 = System.nanoTime() - nanoTime;
                        Double.isNaN(nanoTime2);
                        f.f().d(Beta.TAG, "Beta device token load took " + (nanoTime2 / 1000000.0d) + "ms");
                        return str;
                    }
                } catch (PackageManager.NameNotFoundException unused) {
                    f.f().d(Beta.TAG, "Beta by Crashlytics app is not installed");
                    if (zipInputStream != null) {
                        zipInputStream.close();
                    }
                    str = "";
                    double nanoTime22 = System.nanoTime() - nanoTime;
                    Double.isNaN(nanoTime22);
                    f.f().d(Beta.TAG, "Beta device token load took " + (nanoTime22 / 1000000.0d) + "ms");
                    return str;
                }
            } catch (FileNotFoundException e4) {
                f.f().c(Beta.TAG, "Failed to find the APK file", e4);
                if (zipInputStream != null) {
                    zipInputStream.close();
                }
                str = "";
                double nanoTime222 = System.nanoTime() - nanoTime;
                Double.isNaN(nanoTime222);
                f.f().d(Beta.TAG, "Beta device token load took " + (nanoTime222 / 1000000.0d) + "ms");
                return str;
            }
            double nanoTime2222 = System.nanoTime() - nanoTime;
            Double.isNaN(nanoTime2222);
            f.f().d(Beta.TAG, "Beta device token load took " + (nanoTime2222 / 1000000.0d) + "ms");
            return str;
        } finally {
            if (zipInputStream != null) {
                try {
                    zipInputStream.close();
                } catch (IOException e5) {
                    f.f().c(Beta.TAG, "Failed to close the APK file", e5);
                }
            }
        }
    }
}
