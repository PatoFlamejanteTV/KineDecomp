package com.adobe.xmp.a;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;

/* compiled from: XMPDateTimeImpl.java */
/* loaded from: classes.dex */
public class l implements com.adobe.xmp.b {

    /* renamed from: a */
    private int f7516a;

    /* renamed from: b */
    private int f7517b;

    /* renamed from: c */
    private int f7518c;

    /* renamed from: d */
    private int f7519d;

    /* renamed from: e */
    private int f7520e;

    /* renamed from: f */
    private int f7521f;

    /* renamed from: g */
    private TimeZone f7522g;

    /* renamed from: h */
    private int f7523h;
    private boolean i;
    private boolean j;
    private boolean k;

    public l() {
        this.f7516a = 0;
        this.f7517b = 0;
        this.f7518c = 0;
        this.f7519d = 0;
        this.f7520e = 0;
        this.f7521f = 0;
        this.f7522g = null;
        this.i = false;
        this.j = false;
        this.k = false;
    }

    @Override // com.adobe.xmp.b
    public void a(int i) {
        this.f7523h = i;
        this.j = true;
    }

    @Override // com.adobe.xmp.b
    public void b(int i) {
        this.f7519d = Math.min(Math.abs(i), 23);
        this.j = true;
    }

    @Override // com.adobe.xmp.b
    public void c(int i) {
        this.f7520e = Math.min(Math.abs(i), 59);
        this.j = true;
    }

    @Override // java.lang.Comparable
    public int compareTo(Object obj) {
        float signum;
        long timeInMillis = r().getTimeInMillis() - ((com.adobe.xmp.b) obj).r().getTimeInMillis();
        if (timeInMillis != 0) {
            signum = Math.signum((float) timeInMillis);
        } else {
            signum = Math.signum(this.f7523h - r6.x());
        }
        return (int) signum;
    }

    @Override // com.adobe.xmp.b
    public void d(int i) {
        if (i < 1) {
            this.f7518c = 1;
        } else if (i > 31) {
            this.f7518c = 31;
        } else {
            this.f7518c = i;
        }
        this.i = true;
    }

    @Override // com.adobe.xmp.b
    public void e(int i) {
        this.f7521f = Math.min(Math.abs(i), 59);
        this.j = true;
    }

    @Override // com.adobe.xmp.b
    public int getDay() {
        return this.f7518c;
    }

    @Override // com.adobe.xmp.b
    public int getHour() {
        return this.f7519d;
    }

    @Override // com.adobe.xmp.b
    public int getMinute() {
        return this.f7520e;
    }

    @Override // com.adobe.xmp.b
    public int getMonth() {
        return this.f7517b;
    }

    @Override // com.adobe.xmp.b
    public int getSecond() {
        return this.f7521f;
    }

    @Override // com.adobe.xmp.b
    public TimeZone getTimeZone() {
        return this.f7522g;
    }

    @Override // com.adobe.xmp.b
    public int getYear() {
        return this.f7516a;
    }

    @Override // com.adobe.xmp.b
    public Calendar r() {
        GregorianCalendar gregorianCalendar = (GregorianCalendar) Calendar.getInstance(Locale.US);
        gregorianCalendar.setGregorianChange(new Date(Long.MIN_VALUE));
        if (this.k) {
            gregorianCalendar.setTimeZone(this.f7522g);
        }
        gregorianCalendar.set(1, this.f7516a);
        gregorianCalendar.set(2, this.f7517b - 1);
        gregorianCalendar.set(5, this.f7518c);
        gregorianCalendar.set(11, this.f7519d);
        gregorianCalendar.set(12, this.f7520e);
        gregorianCalendar.set(13, this.f7521f);
        gregorianCalendar.set(14, this.f7523h / 1000000);
        return gregorianCalendar;
    }

    @Override // com.adobe.xmp.b
    public boolean s() {
        return this.j;
    }

    @Override // com.adobe.xmp.b
    public void setMonth(int i) {
        if (i < 1) {
            this.f7517b = 1;
        } else if (i > 12) {
            this.f7517b = 12;
        } else {
            this.f7517b = i;
        }
        this.i = true;
    }

    @Override // com.adobe.xmp.b
    public void setTimeZone(TimeZone timeZone) {
        this.f7522g = timeZone;
        this.j = true;
        this.k = true;
    }

    @Override // com.adobe.xmp.b
    public void setYear(int i) {
        this.f7516a = Math.min(Math.abs(i), 9999);
        this.i = true;
    }

    public String toString() {
        return a();
    }

    @Override // com.adobe.xmp.b
    public boolean u() {
        return this.i;
    }

    @Override // com.adobe.xmp.b
    public int x() {
        return this.f7523h;
    }

    @Override // com.adobe.xmp.b
    public boolean y() {
        return this.k;
    }

    public String a() {
        return e.a(this);
    }

    public l(Calendar calendar) {
        this.f7516a = 0;
        this.f7517b = 0;
        this.f7518c = 0;
        this.f7519d = 0;
        this.f7520e = 0;
        this.f7521f = 0;
        this.f7522g = null;
        this.i = false;
        this.j = false;
        this.k = false;
        Date time = calendar.getTime();
        TimeZone timeZone = calendar.getTimeZone();
        GregorianCalendar gregorianCalendar = (GregorianCalendar) Calendar.getInstance(Locale.US);
        gregorianCalendar.setGregorianChange(new Date(Long.MIN_VALUE));
        gregorianCalendar.setTimeZone(timeZone);
        gregorianCalendar.setTime(time);
        this.f7516a = gregorianCalendar.get(1);
        this.f7517b = gregorianCalendar.get(2) + 1;
        this.f7518c = gregorianCalendar.get(5);
        this.f7519d = gregorianCalendar.get(11);
        this.f7520e = gregorianCalendar.get(12);
        this.f7521f = gregorianCalendar.get(13);
        this.f7523h = gregorianCalendar.get(14) * 1000000;
        this.f7522g = gregorianCalendar.getTimeZone();
        this.k = true;
        this.j = true;
        this.i = true;
    }
}
