package kotlin.text;

/* compiled from: CharJVM.kt */
/* loaded from: classes3.dex */
class a {
    public static final boolean a(char c2) {
        return Character.isWhitespace(c2) || Character.isSpaceChar(c2);
    }

    public static final int a(char c2, int i) {
        return Character.digit((int) c2, i);
    }

    public static final int a(int i) {
        if (2 <= i && 36 >= i) {
            return i;
        }
        throw new IllegalArgumentException("radix " + i + " was not in valid range " + new kotlin.c.d(2, 36));
    }
}
