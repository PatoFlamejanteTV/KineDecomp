package e.a.c;

/* compiled from: StringUtil.java */
/* loaded from: classes3.dex */
public final class b {
    private static boolean a(char c2) {
        return c2 >= ' ' && c2 <= '~';
    }

    public static boolean a(String str) {
        for (int i = 0; i < str.length(); i++) {
            if (!a(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }
}
