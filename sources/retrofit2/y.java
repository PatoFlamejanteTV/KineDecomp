package retrofit2;

import java.io.IOException;
import java.lang.reflect.Array;
import javax.annotation.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ParameterHandler.java */
/* loaded from: classes3.dex */
public class y extends z<Object> {

    /* renamed from: a */
    final /* synthetic */ z f29536a;

    public y(z zVar) {
        this.f29536a = zVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // retrofit2.z
    public void a(B b2, @Nullable Object obj) throws IOException {
        if (obj == null) {
            return;
        }
        int length = Array.getLength(obj);
        for (int i = 0; i < length; i++) {
            this.f29536a.a(b2, Array.get(obj, i));
        }
    }
}
