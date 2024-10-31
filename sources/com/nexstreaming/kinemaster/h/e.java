package com.nexstreaming.kinemaster.h;

import com.xiaomi.licensinglibrary.LicenseErrCode;

/* compiled from: TimeStringUtils.java */
/* loaded from: classes.dex */
public class e {
    public static String a(int i) {
        return String.format("%02d:%02d:%02d.%02d", Integer.valueOf(i / 3600000), Integer.valueOf((i % 3600000) / 60000), Integer.valueOf((i % 60000) / LicenseErrCode.LICENSE_STATUS_NOT_LICENSED), Integer.valueOf((i % LicenseErrCode.LICENSE_STATUS_NOT_LICENSED) / 10));
    }

    public static String b(int i) {
        return String.format("%02d:%02d:%02d.%01d", Integer.valueOf(i / 3600000), Integer.valueOf((i % 3600000) / 60000), Integer.valueOf((i % 60000) / LicenseErrCode.LICENSE_STATUS_NOT_LICENSED), Integer.valueOf((i % LicenseErrCode.LICENSE_STATUS_NOT_LICENSED) / 100));
    }

    public static String c(int i) {
        return String.format("%02d:%02d:%02d.%03d", Integer.valueOf(i / 3600000), Integer.valueOf((i % 3600000) / 60000), Integer.valueOf((i % 60000) / LicenseErrCode.LICENSE_STATUS_NOT_LICENSED), Integer.valueOf(i % LicenseErrCode.LICENSE_STATUS_NOT_LICENSED));
    }
}
