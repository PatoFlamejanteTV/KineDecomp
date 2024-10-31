package com.google.android.gms.analytics.internal;

import com.google.android.gms.common.GoogleApiAvailability;
import com.xiaomi.licensinglibrary.LicenseErrCode;

/* loaded from: classes.dex */
public class zze {

    /* renamed from: a, reason: collision with root package name */
    public static final String f740a = String.valueOf(GoogleApiAvailability.f862a / LicenseErrCode.LICENSE_STATUS_NOT_LICENSED).replaceAll("(\\d+)(\\d)(\\d\\d)", "$1.$2.$3");
    public static final String b = "ma" + f740a;
}
