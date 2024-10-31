package android.support.v7.internal.widget;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ActionBarOverlayLayout.java */
/* loaded from: classes.dex */
public class g implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ActionBarOverlayLayout f170a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(ActionBarOverlayLayout actionBarOverlayLayout) {
        this.f170a = actionBarOverlayLayout;
    }

    @Override // java.lang.Runnable
    public void run() {
        ActionBarContainer actionBarContainer;
        android.support.v4.g.ad adVar;
        ActionBarContainer actionBarContainer2;
        ActionBarContainer actionBarContainer3;
        ActionBarContainer actionBarContainer4;
        android.support.v4.g.ad adVar2;
        this.f170a.c();
        ActionBarOverlayLayout actionBarOverlayLayout = this.f170a;
        actionBarContainer = this.f170a.f;
        android.support.v4.g.y b = android.support.v4.g.p.f(actionBarContainer).b(0.0f);
        adVar = this.f170a.A;
        actionBarOverlayLayout.y = b.a(adVar);
        actionBarContainer2 = this.f170a.e;
        if (actionBarContainer2 != null) {
            actionBarContainer3 = this.f170a.e;
            if (actionBarContainer3.getVisibility() != 8) {
                ActionBarOverlayLayout actionBarOverlayLayout2 = this.f170a;
                actionBarContainer4 = this.f170a.e;
                android.support.v4.g.y b2 = android.support.v4.g.p.f(actionBarContainer4).b(0.0f);
                adVar2 = this.f170a.B;
                actionBarOverlayLayout2.z = b2.a(adVar2);
            }
        }
    }
}
