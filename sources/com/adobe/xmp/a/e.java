package com.adobe.xmp.a;

import com.adobe.xmp.XMPException;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

/* compiled from: ISO8601Converter.java */
/* loaded from: classes.dex */
public final class e {
    public static com.adobe.xmp.b a(String str) throws XMPException {
        l lVar = new l();
        a(str, lVar);
        return lVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:106:0x021a A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:107:0x021b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.adobe.xmp.b a(java.lang.String r11, com.adobe.xmp.b r12) throws com.adobe.xmp.XMPException {
        /*
            Method dump skipped, instructions count: 558
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.adobe.xmp.a.e.a(java.lang.String, com.adobe.xmp.b):com.adobe.xmp.b");
    }

    public static String a(com.adobe.xmp.b bVar) {
        StringBuffer stringBuffer = new StringBuffer();
        if (bVar.u()) {
            DecimalFormat decimalFormat = new DecimalFormat("0000", new DecimalFormatSymbols(Locale.ENGLISH));
            stringBuffer.append(decimalFormat.format(bVar.getYear()));
            if (bVar.getMonth() == 0) {
                return stringBuffer.toString();
            }
            decimalFormat.applyPattern("'-'00");
            stringBuffer.append(decimalFormat.format(bVar.getMonth()));
            if (bVar.getDay() == 0) {
                return stringBuffer.toString();
            }
            stringBuffer.append(decimalFormat.format(bVar.getDay()));
            if (bVar.s()) {
                stringBuffer.append('T');
                decimalFormat.applyPattern("00");
                stringBuffer.append(decimalFormat.format(bVar.getHour()));
                stringBuffer.append(':');
                stringBuffer.append(decimalFormat.format(bVar.getMinute()));
                if (bVar.getSecond() != 0 || bVar.x() != 0) {
                    double second = bVar.getSecond();
                    double x = bVar.x();
                    Double.isNaN(x);
                    Double.isNaN(second);
                    decimalFormat.applyPattern(":00.#########");
                    stringBuffer.append(decimalFormat.format(second + (x / 1.0E9d)));
                }
                if (bVar.y()) {
                    int offset = bVar.getTimeZone().getOffset(bVar.r().getTimeInMillis());
                    if (offset == 0) {
                        stringBuffer.append('Z');
                    } else {
                        int i = offset / 3600000;
                        int abs = Math.abs((offset % 3600000) / 60000);
                        decimalFormat.applyPattern("+00;-00");
                        stringBuffer.append(decimalFormat.format(i));
                        decimalFormat.applyPattern(":00");
                        stringBuffer.append(decimalFormat.format(abs));
                    }
                }
            }
        }
        return stringBuffer.toString();
    }
}
