package retrofit2;

import java.io.IOException;

/* compiled from: Call.java */
/* renamed from: retrofit2.b */
/* loaded from: classes3.dex */
public interface InterfaceC2578b<T> extends Cloneable {
    boolean S();

    void a(InterfaceC2580d<T> interfaceC2580d);

    void cancel();

    InterfaceC2578b<T> clone();

    D<T> execute() throws IOException;
}
