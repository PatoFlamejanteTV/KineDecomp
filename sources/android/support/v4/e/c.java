package android.support.v4.e;

import java.util.Locale;

/* compiled from: TextUtilsCompat.java */
/* loaded from: classes.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    public static final Locale f74a = new Locale("", "");
    private static String b = "Arab";
    private static String c = "Hebr";

    public static int a(Locale locale) {
        if (locale != null && !locale.equals(f74a)) {
            String a2 = a.a(a.b(locale.toString()));
            if (a2 == null) {
                return b(locale);
            }
            if (a2.equalsIgnoreCase(b) || a2.equalsIgnoreCase(c)) {
                return 1;
            }
        }
        return 0;
    }

    private static int b(Locale locale) {
        switch (Character.getDirectionality(locale.getDisplayName(locale).charAt(0))) {
            case 1:
            case 2:
                return 1;
            default:
                return 0;
        }
    }
}
