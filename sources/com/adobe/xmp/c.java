package com.adobe.xmp;

import java.util.Calendar;
import java.util.TimeZone;

/* compiled from: XMPDateTimeFactory.java */
/* loaded from: classes.dex */
public final class c {

    /* renamed from: a */
    private static final TimeZone f7583a = TimeZone.getTimeZone("UTC");

    public static b a(Calendar calendar) {
        return new com.adobe.xmp.a.l(calendar);
    }

    public static b a() {
        return new com.adobe.xmp.a.l();
    }
}
