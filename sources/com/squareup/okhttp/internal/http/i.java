package com.squareup.okhttp.internal.http;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.TimeZone;

/* compiled from: HttpDate.java */
/* loaded from: classes3.dex */
class i extends ThreadLocal<DateFormat> {
    @Override // java.lang.ThreadLocal
    public DateFormat initialValue() {
        TimeZone timeZone;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss 'GMT'", Locale.US);
        simpleDateFormat.setLenient(false);
        timeZone = j.f25455a;
        simpleDateFormat.setTimeZone(timeZone);
        return simpleDateFormat;
    }
}
