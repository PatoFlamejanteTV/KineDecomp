package android.support.v4.os;

import android.os.Build;
import android.support.v7.widget.ActivityChooserView;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Locale;

/* loaded from: classes.dex */
final class LocaleListHelper {

    /* renamed from: a */
    private static final Locale[] f1537a = new Locale[0];

    /* renamed from: b */
    private static final LocaleListHelper f1538b = new LocaleListHelper(new Locale[0]);

    /* renamed from: c */
    private static final Locale f1539c = new Locale("en", "XA");

    /* renamed from: d */
    private static final Locale f1540d = new Locale("ar", "XB");

    /* renamed from: e */
    private static final Locale f1541e = LocaleHelper.a("en-Latn");

    /* renamed from: f */
    private static final Object f1542f = new Object();

    /* renamed from: g */
    private static LocaleListHelper f1543g = null;

    /* renamed from: h */
    private static LocaleListHelper f1544h = null;
    private static LocaleListHelper i = null;
    private static Locale j = null;
    private final Locale[] k;
    private final String l;

    public LocaleListHelper(Locale... localeArr) {
        if (localeArr.length == 0) {
            this.k = f1537a;
            this.l = "";
            return;
        }
        Locale[] localeArr2 = new Locale[localeArr.length];
        HashSet hashSet = new HashSet();
        StringBuilder sb = new StringBuilder();
        for (int i2 = 0; i2 < localeArr.length; i2++) {
            Locale locale = localeArr[i2];
            if (locale != null) {
                if (!hashSet.contains(locale)) {
                    Locale locale2 = (Locale) locale.clone();
                    localeArr2[i2] = locale2;
                    sb.append(LocaleHelper.a(locale2));
                    if (i2 < localeArr.length - 1) {
                        sb.append(',');
                    }
                    hashSet.add(locale2);
                } else {
                    throw new IllegalArgumentException("list[" + i2 + "] is a repetition");
                }
            } else {
                throw new NullPointerException("list[" + i2 + "] is null");
            }
        }
        this.k = localeArr2;
        this.l = sb.toString();
    }

    private static boolean d(Locale locale) {
        return f1539c.equals(locale) || f1540d.equals(locale);
    }

    public Locale a(int i2) {
        if (i2 >= 0) {
            Locale[] localeArr = this.k;
            if (i2 < localeArr.length) {
                return localeArr[i2];
            }
        }
        return null;
    }

    public int b() {
        return this.k.length;
    }

    public String c() {
        return this.l;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof LocaleListHelper)) {
            return false;
        }
        Locale[] localeArr = ((LocaleListHelper) obj).k;
        if (this.k.length != localeArr.length) {
            return false;
        }
        int i2 = 0;
        while (true) {
            Locale[] localeArr2 = this.k;
            if (i2 >= localeArr2.length) {
                return true;
            }
            if (!localeArr2[i2].equals(localeArr[i2])) {
                return false;
            }
            i2++;
        }
    }

    public int hashCode() {
        int i2 = 1;
        int i3 = 0;
        while (true) {
            Locale[] localeArr = this.k;
            if (i3 >= localeArr.length) {
                return i2;
            }
            i2 = (i2 * 31) + localeArr[i3].hashCode();
            i3++;
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        int i2 = 0;
        while (true) {
            Locale[] localeArr = this.k;
            if (i2 < localeArr.length) {
                sb.append(localeArr[i2]);
                if (i2 < this.k.length - 1) {
                    sb.append(',');
                }
                i2++;
            } else {
                sb.append("]");
                return sb.toString();
            }
        }
    }

    private int b(Locale locale) {
        int i2 = 0;
        while (true) {
            Locale[] localeArr = this.k;
            if (i2 >= localeArr.length) {
                return ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
            }
            if (a(locale, localeArr[i2]) > 0) {
                return i2;
            }
            i2++;
        }
    }

    private static String c(Locale locale) {
        if (Build.VERSION.SDK_INT >= 21) {
            String script = locale.getScript();
            if (!script.isEmpty()) {
                return script;
            }
        }
        return "";
    }

    public boolean a() {
        return this.k.length == 0;
    }

    public int a(Locale locale) {
        int i2 = 0;
        while (true) {
            Locale[] localeArr = this.k;
            if (i2 >= localeArr.length) {
                return -1;
            }
            if (localeArr[i2].equals(locale)) {
                return i2;
            }
            i2++;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x001b, code lost:            if (r6 < Integer.MAX_VALUE) goto L51;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private int b(java.util.Collection<java.lang.String> r5, boolean r6) {
        /*
            r4 = this;
            java.util.Locale[] r0 = r4.k
            int r1 = r0.length
            r2 = 0
            r3 = 1
            if (r1 != r3) goto L8
            return r2
        L8:
            int r0 = r0.length
            if (r0 != 0) goto Ld
            r5 = -1
            return r5
        Ld:
            r0 = 2147483647(0x7fffffff, float:NaN)
            if (r6 == 0) goto L1e
            java.util.Locale r6 = android.support.v4.os.LocaleListHelper.f1541e
            int r6 = r4.b(r6)
            if (r6 != 0) goto L1b
            return r2
        L1b:
            if (r6 >= r0) goto L1e
            goto L21
        L1e:
            r6 = 2147483647(0x7fffffff, float:NaN)
        L21:
            java.util.Iterator r5 = r5.iterator()
        L25:
            boolean r1 = r5.hasNext()
            if (r1 == 0) goto L40
            java.lang.Object r1 = r5.next()
            java.lang.String r1 = (java.lang.String) r1
            java.util.Locale r1 = android.support.v4.os.LocaleHelper.a(r1)
            int r1 = r4.b(r1)
            if (r1 != 0) goto L3c
            return r2
        L3c:
            if (r1 >= r6) goto L25
            r6 = r1
            goto L25
        L40:
            if (r6 != r0) goto L43
            return r2
        L43:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.os.LocaleListHelper.b(java.util.Collection, boolean):int");
    }

    private static int a(Locale locale, Locale locale2) {
        if (locale.equals(locale2)) {
            return 1;
        }
        if (!locale.getLanguage().equals(locale2.getLanguage()) || d(locale) || d(locale2)) {
            return 0;
        }
        String c2 = c(locale);
        if (!c2.isEmpty()) {
            return c2.equals(c(locale2)) ? 1 : 0;
        }
        String country = locale.getCountry();
        return (country.isEmpty() || country.equals(locale2.getCountry())) ? 1 : 0;
    }

    private Locale a(Collection<String> collection, boolean z) {
        int b2 = b(collection, z);
        if (b2 == -1) {
            return null;
        }
        return this.k[b2];
    }

    public Locale a(String[] strArr) {
        return a((Collection<String>) Arrays.asList(strArr), false);
    }
}
