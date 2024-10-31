package retrofit2;

import java.io.IOException;
import java.util.Iterator;
import javax.annotation.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ParameterHandler.java */
/* loaded from: classes3.dex */
public class x<T> extends z<Iterable<T>> {

    /* renamed from: a */
    final /* synthetic */ z f29535a;

    public x(z zVar) {
        this.f29535a = zVar;
    }

    @Override // retrofit2.z
    public void a(B b2, @Nullable Iterable<T> iterable) throws IOException {
        if (iterable == null) {
            return;
        }
        Iterator<T> it = iterable.iterator();
        while (it.hasNext()) {
            this.f29535a.a(b2, it.next());
        }
    }
}
