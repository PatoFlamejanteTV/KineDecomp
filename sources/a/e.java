package a;

import java.util.Locale;

/* compiled from: CancellationToken.java */
/* loaded from: classes.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    private final Object f5a;
    private boolean b;

    public boolean a() {
        boolean z;
        synchronized (this.f5a) {
            z = this.b;
        }
        return z;
    }

    public String toString() {
        return String.format(Locale.US, "%s@%s[cancellationRequested=%s]", getClass().getName(), Integer.toHexString(hashCode()), Boolean.toString(this.b));
    }
}
