package com.google.api.client.util;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;
import java.util.regex.Pattern;

/* loaded from: classes.dex */
public final class DateTime implements Serializable {

    /* renamed from: a, reason: collision with root package name */
    private static final TimeZone f2534a = TimeZone.getTimeZone("GMT");
    private static final Pattern b = Pattern.compile("^(\\d{4})-(\\d{2})-(\\d{2})([Tt](\\d{2}):(\\d{2}):(\\d{2})(\\.\\d+)?)?([Zz]|([+-])(\\d{2}):(\\d{2}))?");
    private static final long serialVersionUID = 1;
    private final boolean dateOnly;
    private final int tzShift;
    private final long value;

    public DateTime(Date date, TimeZone timeZone) {
        this(false, date.getTime(), timeZone == null ? null : Integer.valueOf(timeZone.getOffset(date.getTime()) / 60000));
    }

    public DateTime(long j) {
        this(false, j, null);
    }

    public DateTime(Date date) {
        this(date.getTime());
    }

    public DateTime(long j, int i) {
        this(false, j, Integer.valueOf(i));
    }

    public DateTime(boolean z, long j, Integer num) {
        int offset;
        this.dateOnly = z;
        this.value = j;
        if (z) {
            offset = 0;
        } else {
            offset = num == null ? TimeZone.getDefault().getOffset(j) / 60000 : num.intValue();
        }
        this.tzShift = offset;
    }

    public DateTime(String str) {
        DateTime parseRfc3339 = parseRfc3339(str);
        this.dateOnly = parseRfc3339.dateOnly;
        this.value = parseRfc3339.value;
        this.tzShift = parseRfc3339.tzShift;
    }

    public long getValue() {
        return this.value;
    }

    public boolean isDateOnly() {
        return this.dateOnly;
    }

    public int getTimeZoneShift() {
        return this.tzShift;
    }

    public String toStringRfc3339() {
        StringBuilder sb = new StringBuilder();
        GregorianCalendar gregorianCalendar = new GregorianCalendar(f2534a);
        gregorianCalendar.setTimeInMillis(this.value + (this.tzShift * 60000));
        a(sb, gregorianCalendar.get(1), 4);
        sb.append('-');
        a(sb, gregorianCalendar.get(2) + 1, 2);
        sb.append('-');
        a(sb, gregorianCalendar.get(5), 2);
        if (!this.dateOnly) {
            sb.append('T');
            a(sb, gregorianCalendar.get(11), 2);
            sb.append(':');
            a(sb, gregorianCalendar.get(12), 2);
            sb.append(':');
            a(sb, gregorianCalendar.get(13), 2);
            if (gregorianCalendar.isSet(14)) {
                sb.append('.');
                a(sb, gregorianCalendar.get(14), 3);
            }
            if (this.tzShift == 0) {
                sb.append('Z');
            } else {
                int i = this.tzShift;
                if (this.tzShift > 0) {
                    sb.append('+');
                } else {
                    sb.append('-');
                    i = -i;
                }
                a(sb, i / 60, 2);
                sb.append(':');
                a(sb, i % 60, 2);
            }
        }
        return sb.toString();
    }

    public String toString() {
        return toStringRfc3339();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof DateTime)) {
            return false;
        }
        DateTime dateTime = (DateTime) obj;
        return this.dateOnly == dateTime.dateOnly && this.value == dateTime.value && this.tzShift == dateTime.tzShift;
    }

    public int hashCode() {
        long[] jArr = new long[3];
        jArr[0] = this.value;
        jArr[1] = this.dateOnly ? serialVersionUID : 0L;
        jArr[2] = this.tzShift;
        return Arrays.hashCode(jArr);
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x00e9  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x011c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.google.api.client.util.DateTime parseRfc3339(java.lang.String r14) throws java.lang.NumberFormatException {
        /*
            Method dump skipped, instructions count: 290
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.api.client.util.DateTime.parseRfc3339(java.lang.String):com.google.api.client.util.DateTime");
    }

    private static void a(StringBuilder sb, int i, int i2) {
        if (i < 0) {
            sb.append('-');
            i = -i;
        }
        int i3 = i;
        while (i3 > 0) {
            i3 /= 10;
            i2--;
        }
        for (int i4 = 0; i4 < i2; i4++) {
            sb.append('0');
        }
        if (i != 0) {
            sb.append(i);
        }
    }
}
