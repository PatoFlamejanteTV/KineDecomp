package h.a.a.a;

import android.content.Context;
import android.content.ContextWrapper;
import android.view.LayoutInflater;

/* compiled from: CalligraphyContextWrapper.java */
/* loaded from: classes3.dex */
public class c extends ContextWrapper {

    /* renamed from: a */
    private f f26790a;

    /* renamed from: b */
    private final int f26791b;

    c(Context context) {
        super(context);
        this.f26791b = b.a().b();
    }

    public static ContextWrapper a(Context context) {
        return new c(context);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Object getSystemService(String str) {
        if ("layout_inflater".equals(str)) {
            if (this.f26790a == null) {
                this.f26790a = new f(LayoutInflater.from(getBaseContext()), this, this.f26791b, false);
            }
            return this.f26790a;
        }
        return super.getSystemService(str);
    }
}
