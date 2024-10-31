package com.google.zxing.client.result;

import java.text.DateFormat;
import java.util.Date;
import java.util.regex.Pattern;

/* loaded from: classes2.dex */
public final class CalendarParsedResult extends ParsedResult {

    /* renamed from: a */
    private static final Pattern f19003a = Pattern.compile("P(?:(\\d+)W)?(?:(\\d+)D)?(?:T(?:(\\d+)H)?(?:(\\d+)M)?(?:(\\d+)S)?)?");

    /* renamed from: b */
    private static final long[] f19004b = {604800000, 86400000, 3600000, 60000, 1000};

    /* renamed from: c */
    private static final Pattern f19005c = Pattern.compile("[0-9]{8}(T[0-9]{6}Z?)?");

    /* renamed from: d */
    private final String f19006d;

    /* renamed from: e */
    private final Date f19007e;

    /* renamed from: f */
    private final boolean f19008f;

    /* renamed from: g */
    private final Date f19009g;

    /* renamed from: h */
    private final boolean f19010h;
    private final String i;
    private final String j;
    private final String[] k;
    private final String l;

    @Override // com.google.zxing.client.result.ParsedResult
    public String a() {
        StringBuilder sb = new StringBuilder(100);
        ParsedResult.a(this.f19006d, sb);
        ParsedResult.a(a(this.f19008f, this.f19007e), sb);
        ParsedResult.a(a(this.f19010h, this.f19009g), sb);
        ParsedResult.a(this.i, sb);
        ParsedResult.a(this.j, sb);
        ParsedResult.a(this.k, sb);
        ParsedResult.a(this.l, sb);
        return sb.toString();
    }

    private static String a(boolean z, Date date) {
        DateFormat dateTimeInstance;
        if (date == null) {
            return null;
        }
        if (z) {
            dateTimeInstance = DateFormat.getDateInstance(2);
        } else {
            dateTimeInstance = DateFormat.getDateTimeInstance(2, 2);
        }
        return dateTimeInstance.format(date);
    }
}
