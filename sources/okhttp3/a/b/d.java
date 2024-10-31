package okhttp3.a.b;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;

/* compiled from: HttpDate.java */
/* loaded from: classes3.dex */
class d extends ThreadLocal<DateFormat> {
    @Override // java.lang.ThreadLocal
    public DateFormat initialValue() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss 'GMT'", Locale.US);
        simpleDateFormat.setLenient(false);
        simpleDateFormat.setTimeZone(okhttp3.a.e.p);
        return simpleDateFormat;
    }
}
