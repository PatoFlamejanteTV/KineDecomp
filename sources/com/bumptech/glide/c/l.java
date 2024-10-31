package com.bumptech.glide.c;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Fragment;
import android.os.Build;
import android.util.Log;
import java.util.HashSet;
import java.util.Set;

/* compiled from: RequestManagerFragment.java */
@Deprecated
/* loaded from: classes.dex */
public class l extends Fragment {

    /* renamed from: a, reason: collision with root package name */
    private final com.bumptech.glide.c.a f8425a;

    /* renamed from: b, reason: collision with root package name */
    private final o f8426b;

    /* renamed from: c, reason: collision with root package name */
    private final Set<l> f8427c;

    /* renamed from: d, reason: collision with root package name */
    private com.bumptech.glide.j f8428d;

    /* renamed from: e, reason: collision with root package name */
    private l f8429e;

    /* renamed from: f, reason: collision with root package name */
    private Fragment f8430f;

    /* compiled from: RequestManagerFragment.java */
    /* loaded from: classes.dex */
    private class a implements o {
        a() {
        }

        public String toString() {
            return super.toString() + "{fragment=" + l.this + "}";
        }
    }

    public l() {
        this(new com.bumptech.glide.c.a());
    }

    @TargetApi(17)
    private Fragment d() {
        Fragment parentFragment = Build.VERSION.SDK_INT >= 17 ? getParentFragment() : null;
        return parentFragment != null ? parentFragment : this.f8430f;
    }

    private void e() {
        l lVar = this.f8429e;
        if (lVar != null) {
            lVar.b(this);
            this.f8429e = null;
        }
    }

    public void a(com.bumptech.glide.j jVar) {
        this.f8428d = jVar;
    }

    public com.bumptech.glide.j b() {
        return this.f8428d;
    }

    public o c() {
        return this.f8426b;
    }

    @Override // android.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            a(activity);
        } catch (IllegalStateException e2) {
            if (Log.isLoggable("RMFragment", 5)) {
                Log.w("RMFragment", "Unable to register fragment with root", e2);
            }
        }
    }

    @Override // android.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.f8425a.a();
        e();
    }

    @Override // android.app.Fragment
    public void onDetach() {
        super.onDetach();
        e();
    }

    @Override // android.app.Fragment
    public void onStart() {
        super.onStart();
        this.f8425a.b();
    }

    @Override // android.app.Fragment
    public void onStop() {
        super.onStop();
        this.f8425a.c();
    }

    @Override // android.app.Fragment
    public String toString() {
        return super.toString() + "{parent=" + d() + "}";
    }

    @SuppressLint({"ValidFragment"})
    l(com.bumptech.glide.c.a aVar) {
        this.f8426b = new a();
        this.f8427c = new HashSet();
        this.f8425a = aVar;
    }

    private void b(l lVar) {
        this.f8427c.remove(lVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public com.bumptech.glide.c.a a() {
        return this.f8425a;
    }

    private void a(l lVar) {
        this.f8427c.add(lVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Fragment fragment) {
        this.f8430f = fragment;
        if (fragment == null || fragment.getActivity() == null) {
            return;
        }
        a(fragment.getActivity());
    }

    private void a(Activity activity) {
        e();
        this.f8429e = com.bumptech.glide.c.a(activity).h().b(activity);
        if (equals(this.f8429e)) {
            return;
        }
        this.f8429e.a(this);
    }
}
