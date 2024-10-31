package kotlin.text;

import com.facebook.internal.FacebookRequestErrorClassification;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: StringsJVM.kt */
/* loaded from: classes.dex */
public class v extends u {
    public static /* synthetic */ String a(String str, char c2, char c3, boolean z, int i, Object obj) {
        if ((i & 4) != 0) {
            z = false;
        }
        return a(str, c2, c3, z);
    }

    public static boolean b(String str, String str2, boolean z) {
        if (str == null) {
            return str2 == null;
        }
        if (!z) {
            return str.equals(str2);
        }
        return str.equalsIgnoreCase(str2);
    }

    public static final boolean c(String str, String str2, boolean z) {
        kotlin.jvm.internal.h.b(str, "$this$startsWith");
        kotlin.jvm.internal.h.b(str2, "prefix");
        if (!z) {
            return str.startsWith(str2);
        }
        return a(str, 0, str2, 0, str2.length(), z);
    }

    public static final String a(String str, char c2, char c3, boolean z) {
        kotlin.jvm.internal.h.b(str, "$this$replace");
        if (z) {
            return kotlin.d.d.a(w.a(str, new char[]{c2}, z, 0, 4, (Object) null), String.valueOf(c3), null, null, 0, null, null, 62, null);
        }
        String replace = str.replace(c2, c3);
        kotlin.jvm.internal.h.a((Object) replace, "(this as java.lang.Strin…replace(oldChar, newChar)");
        return replace;
    }

    public static /* synthetic */ boolean b(String str, String str2, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return c(str, str2, z);
    }

    public static /* synthetic */ String a(String str, String str2, String str3, boolean z, int i, Object obj) {
        if ((i & 4) != 0) {
            z = false;
        }
        return a(str, str2, str3, z);
    }

    public static final String a(String str, String str2, String str3, boolean z) {
        kotlin.jvm.internal.h.b(str, "$this$replace");
        kotlin.jvm.internal.h.b(str2, "oldValue");
        kotlin.jvm.internal.h.b(str3, "newValue");
        return kotlin.d.d.a(w.a(str, new String[]{str2}, z, 0, 4, (Object) null), str3, null, null, 0, null, null, 62, null);
    }

    public static /* synthetic */ boolean a(String str, String str2, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return a(str, str2, z);
    }

    public static final boolean a(String str, String str2, boolean z) {
        kotlin.jvm.internal.h.b(str, "$this$endsWith");
        kotlin.jvm.internal.h.b(str2, "suffix");
        if (!z) {
            return str.endsWith(str2);
        }
        return a(str, str.length() - str2.length(), str2, 0, str2.length(), true);
    }

    public static final boolean a(String str, int i, String str2, int i2, int i3, boolean z) {
        kotlin.jvm.internal.h.b(str, "$this$regionMatches");
        kotlin.jvm.internal.h.b(str2, FacebookRequestErrorClassification.KEY_OTHER);
        if (!z) {
            return str.regionMatches(i, str2, i2, i3);
        }
        return str.regionMatches(z, i, str2, i2, i3);
    }
}
