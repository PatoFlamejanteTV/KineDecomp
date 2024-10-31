package com.adobe.xmp;

import java.util.Calendar;
import java.util.TimeZone;

/* compiled from: XMPDateTime.java */
/* loaded from: classes.dex */
public interface b extends Comparable {
    void a(int i);

    void b(int i);

    void c(int i);

    void d(int i);

    void e(int i);

    int getDay();

    int getHour();

    int getMinute();

    int getMonth();

    int getSecond();

    TimeZone getTimeZone();

    int getYear();

    Calendar r();

    boolean s();

    void setMonth(int i);

    void setTimeZone(TimeZone timeZone);

    void setYear(int i);

    boolean u();

    int x();

    boolean y();
}
