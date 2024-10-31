package com.bumptech.glide.c;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import java.util.HashSet;
import java.util.Set;

/* compiled from: SupportRequestManagerFragment.java */
/* loaded from: classes.dex */
public class q extends Fragment {

    /* renamed from: a, reason: collision with root package name */
    private final com.bumptech.glide.c.a f8443a;

    /* renamed from: b, reason: collision with root package name */
    private final o f8444b;

    /* renamed from: c, reason: collision with root package name */
    private final Set<q> f8445c;

    /* renamed from: d, reason: collision with root package name */
    private q f8446d;

    /* renamed from: e, reason: collision with root package name */
    private com.bumptech.glide.j f8447e;

    /* renamed from: f, reason: collision with root package name */
    private Fragment f8448f;

    /* compiled from: SupportRequestManagerFragment.java */
    /* loaded from: classes.dex */
    private class a implements o {
        a() {
        }

        public String toString() {
            return super.toString() + "{fragment=" + q.this + "}";
        }
    }

    public q() {
        this(new com.bumptech.glide.c.a());
    }

    private Fragment C() {
        Fragment parentFragment = getParentFragment();
        return parentFragment != null ? parentFragment : this.f8448f;
    }

    private void D() {
        q qVar = this.f8446d;
        if (qVar != null) {
            qVar.b(this);
            this.f8446d = null;
        }
    }

    private void b(q qVar) {
        this.f8445c.remove(qVar);
    }

    public com.bumptech.glide.j A() {
        return this.f8447e;
    }

    public o B() {
        return this.f8444b;
    }

    public void a(com.bumptech.glide.j jVar) {
        this.f8447e = jVar;
    }

    @Override // android.support.v4.app.Fragment
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            a(getActivity());
        } catch (IllegalStateException e2) {
            if (Log.isLoggable("SupportRMFragment", 5)) {
                Log.w("SupportRMFragment", "Unable to register fragment with root", e2);
            }
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.f8443a.a();
        D();
    }

    @Override // android.support.v4.app.Fragment
    public void onDetach() {
        super.onDetach();
        this.f8448f = null;
        D();
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        this.f8443a.b();
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        this.f8443a.c();
    }

    @Override // android.support.v4.app.Fragment
    public String toString() {
        return super.toString() + "{parent=" + C() + "}";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public com.bumptech.glide.c.a z() {
        return this.f8443a;
    }

    @SuppressLint({"ValidFragment"})
    public q(com.bumptech.glide.c.a aVar) {
        this.f8444b = new a();
        this.f8445c = new HashSet();
        this.f8443a = aVar;
    }

    private void a(q qVar) {
        this.f8445c.add(qVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Fragment fragment) {
        this.f8448f = fragment;
        if (fragment == null || fragment.getActivity() == null) {
            return;
        }
        a(fragment.getActivity());
    }

    private void a(FragmentActivity fragmentActivity) {
        D();
        this.f8446d = com.bumptech.glide.c.a((Context) fragmentActivity).h().b(fragmentActivity);
        if (equals(this.f8446d)) {
            return;
        }
        this.f8446d.a(this);
    }
}
