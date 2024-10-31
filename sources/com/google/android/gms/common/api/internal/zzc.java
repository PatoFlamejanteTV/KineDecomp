package com.google.android.gms.common.api.internal;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.util.ArrayMap;
import com.google.android.gms.internal.common.zze;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public final class zzc extends Fragment implements LifecycleFragment {

    /* renamed from: a */
    private static WeakHashMap<FragmentActivity, WeakReference<zzc>> f10972a = new WeakHashMap<>();

    /* renamed from: b */
    private Map<String, LifecycleCallback> f10973b = new ArrayMap();

    /* renamed from: c */
    private int f10974c = 0;

    /* renamed from: d */
    private Bundle f10975d;

    public static zzc a(FragmentActivity fragmentActivity) {
        zzc zzcVar;
        WeakReference<zzc> weakReference = f10972a.get(fragmentActivity);
        if (weakReference != null && (zzcVar = weakReference.get()) != null) {
            return zzcVar;
        }
        try {
            zzc zzcVar2 = (zzc) fragmentActivity.getSupportFragmentManager().findFragmentByTag("SupportLifecycleFragmentImpl");
            if (zzcVar2 == null || zzcVar2.isRemoving()) {
                zzcVar2 = new zzc();
                fragmentActivity.getSupportFragmentManager().beginTransaction().add(zzcVar2, "SupportLifecycleFragmentImpl").commitAllowingStateLoss();
            }
            f10972a.put(fragmentActivity, new WeakReference<>(zzcVar2));
            return zzcVar2;
        } catch (ClassCastException e2) {
            throw new IllegalStateException("Fragment with tag SupportLifecycleFragmentImpl is not a SupportLifecycleFragmentImpl", e2);
        }
    }

    @Override // com.google.android.gms.common.api.internal.LifecycleFragment
    public final /* synthetic */ Activity d() {
        return getActivity();
    }

    @Override // android.support.v4.app.Fragment
    public final void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        super.dump(str, fileDescriptor, printWriter, strArr);
        Iterator<LifecycleCallback> it = this.f10973b.values().iterator();
        while (it.hasNext()) {
            it.next().a(str, fileDescriptor, printWriter, strArr);
        }
    }

    @Override // android.support.v4.app.Fragment
    public final void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        Iterator<LifecycleCallback> it = this.f10973b.values().iterator();
        while (it.hasNext()) {
            it.next().a(i, i2, intent);
        }
    }

    @Override // android.support.v4.app.Fragment
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f10974c = 1;
        this.f10975d = bundle;
        for (Map.Entry<String, LifecycleCallback> entry : this.f10973b.entrySet()) {
            entry.getValue().a(bundle != null ? bundle.getBundle(entry.getKey()) : null);
        }
    }

    @Override // android.support.v4.app.Fragment
    public final void onDestroy() {
        super.onDestroy();
        this.f10974c = 5;
        Iterator<LifecycleCallback> it = this.f10973b.values().iterator();
        while (it.hasNext()) {
            it.next().b();
        }
    }

    @Override // android.support.v4.app.Fragment
    public final void onResume() {
        super.onResume();
        this.f10974c = 3;
        Iterator<LifecycleCallback> it = this.f10973b.values().iterator();
        while (it.hasNext()) {
            it.next().c();
        }
    }

    @Override // android.support.v4.app.Fragment
    public final void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (bundle == null) {
            return;
        }
        for (Map.Entry<String, LifecycleCallback> entry : this.f10973b.entrySet()) {
            Bundle bundle2 = new Bundle();
            entry.getValue().b(bundle2);
            bundle.putBundle(entry.getKey(), bundle2);
        }
    }

    @Override // android.support.v4.app.Fragment
    public final void onStart() {
        super.onStart();
        this.f10974c = 2;
        Iterator<LifecycleCallback> it = this.f10973b.values().iterator();
        while (it.hasNext()) {
            it.next().d();
        }
    }

    @Override // android.support.v4.app.Fragment
    public final void onStop() {
        super.onStop();
        this.f10974c = 4;
        Iterator<LifecycleCallback> it = this.f10973b.values().iterator();
        while (it.hasNext()) {
            it.next().e();
        }
    }

    @Override // com.google.android.gms.common.api.internal.LifecycleFragment
    public final <T extends LifecycleCallback> T a(String str, Class<T> cls) {
        return cls.cast(this.f10973b.get(str));
    }

    @Override // com.google.android.gms.common.api.internal.LifecycleFragment
    public final void a(String str, LifecycleCallback lifecycleCallback) {
        if (!this.f10973b.containsKey(str)) {
            this.f10973b.put(str, lifecycleCallback);
            if (this.f10974c > 0) {
                new zze(Looper.getMainLooper()).post(new ba(this, lifecycleCallback, str));
                return;
            }
            return;
        }
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 59);
        sb.append("LifecycleCallback with tag ");
        sb.append(str);
        sb.append(" already added to this fragment.");
        throw new IllegalArgumentException(sb.toString());
    }
}
