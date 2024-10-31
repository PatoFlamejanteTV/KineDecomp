package android.support.v4.a;

import java.io.FileDescriptor;
import java.io.PrintWriter;

/* compiled from: Loader.java */
/* loaded from: classes.dex */
public class e<D> {

    /* renamed from: a, reason: collision with root package name */
    int f20a;
    a<D> b;
    boolean c;
    boolean d;
    boolean e;
    boolean f;
    boolean g;

    /* compiled from: Loader.java */
    /* loaded from: classes.dex */
    public interface a<D> {
    }

    public void a(int i, a<D> aVar) {
        if (this.b != null) {
            throw new IllegalStateException("There is already a listener registered");
        }
        this.b = aVar;
        this.f20a = i;
    }

    public void a(a<D> aVar) {
        if (this.b == null) {
            throw new IllegalStateException("No listener register");
        }
        if (this.b != aVar) {
            throw new IllegalArgumentException("Attempting to unregister the wrong listener");
        }
        this.b = null;
    }

    public final void a() {
        this.c = true;
        this.e = false;
        this.d = false;
        b();
    }

    protected void b() {
    }

    public void c() {
        this.c = false;
        d();
    }

    protected void d() {
    }

    public void e() {
        f();
        this.e = true;
        this.c = false;
        this.d = false;
        this.f = false;
        this.g = false;
    }

    protected void f() {
    }

    public String a(D d) {
        StringBuilder sb = new StringBuilder(64);
        android.support.v4.f.d.a(d, sb);
        sb.append("}");
        return sb.toString();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(64);
        android.support.v4.f.d.a(this, sb);
        sb.append(" id=");
        sb.append(this.f20a);
        sb.append("}");
        return sb.toString();
    }

    public void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        printWriter.print(str);
        printWriter.print("mId=");
        printWriter.print(this.f20a);
        printWriter.print(" mListener=");
        printWriter.println(this.b);
        if (this.c || this.f || this.g) {
            printWriter.print(str);
            printWriter.print("mStarted=");
            printWriter.print(this.c);
            printWriter.print(" mContentChanged=");
            printWriter.print(this.f);
            printWriter.print(" mProcessingChange=");
            printWriter.println(this.g);
        }
        if (this.d || this.e) {
            printWriter.print(str);
            printWriter.print("mAbandoned=");
            printWriter.print(this.d);
            printWriter.print(" mReset=");
            printWriter.println(this.e);
        }
    }
}
