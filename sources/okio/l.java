package okio;

import java.io.IOException;
import java.io.InterruptedIOException;

/* compiled from: Timeout.java */
/* loaded from: classes.dex */
public class l {

    /* renamed from: a, reason: collision with root package name */
    public static final l f4936a = new m();
    private boolean b;
    private long c;

    public void a() throws IOException {
        if (Thread.interrupted()) {
            throw new InterruptedIOException();
        }
        if (this.b && System.nanoTime() > this.c) {
            throw new IOException("deadline reached");
        }
    }
}
