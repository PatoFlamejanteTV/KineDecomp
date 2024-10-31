package android.support.transition;

import android.view.View;
import android.view.ViewGroup;

/* compiled from: Scene.java */
/* loaded from: classes.dex */
public class I {

    /* renamed from: a */
    private ViewGroup f532a;

    /* renamed from: b */
    private Runnable f533b;

    public void a() {
        Runnable runnable;
        if (a(this.f532a) != this || (runnable = this.f533b) == null) {
            return;
        }
        runnable.run();
    }

    public static void a(View view, I i) {
        view.setTag(G.transition_current_scene, i);
    }

    public static I a(View view) {
        return (I) view.getTag(G.transition_current_scene);
    }
}
