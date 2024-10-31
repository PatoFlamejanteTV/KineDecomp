package kotlin.io;

import java.io.File;
import kotlin.jvm.internal.h;

/* compiled from: Exceptions.kt */
/* loaded from: classes3.dex */
public final class a {
    public static final String b(File file, File file2, String str) {
        StringBuilder sb = new StringBuilder(file.toString());
        if (file2 != null) {
            sb.append(" -> " + file2);
        }
        if (str != null) {
            sb.append(": " + str);
        }
        String sb2 = sb.toString();
        h.a((Object) sb2, "sb.toString()");
        return sb2;
    }
}
