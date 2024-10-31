package kotlin.text;

/* compiled from: StringBuilder.kt */
/* loaded from: classes.dex */
public class s extends r {
    /* JADX WARN: Multi-variable type inference failed */
    public static <T> void a(Appendable appendable, T t, kotlin.jvm.a.b<? super T, ? extends CharSequence> bVar) {
        kotlin.jvm.internal.h.b(appendable, "$this$appendElement");
        if (bVar != null) {
            appendable.append(bVar.invoke(t));
            return;
        }
        if (t != 0 ? t instanceof CharSequence : true) {
            appendable.append((CharSequence) t);
        } else if (t instanceof Character) {
            appendable.append(((Character) t).charValue());
        } else {
            appendable.append(String.valueOf(t));
        }
    }
}
