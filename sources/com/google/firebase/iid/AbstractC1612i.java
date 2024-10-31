package com.google.firebase.iid;

import android.os.Bundle;
import android.util.Log;
import com.google.android.gms.tasks.TaskCompletionSource;

/* renamed from: com.google.firebase.iid.i */
/* loaded from: classes2.dex */
abstract class AbstractC1612i<T> {

    /* renamed from: a */
    final int f17356a;

    /* renamed from: b */
    final TaskCompletionSource<T> f17357b = new TaskCompletionSource<>();

    /* renamed from: c */
    final int f17358c;

    /* renamed from: d */
    final Bundle f17359d;

    public AbstractC1612i(int i, int i2, Bundle bundle) {
        this.f17356a = i;
        this.f17358c = i2;
        this.f17359d = bundle;
    }

    public abstract void a(Bundle bundle);

    public final void a(T t) {
        if (Log.isLoggable("MessengerIpcClient", 3)) {
            String valueOf = String.valueOf(this);
            String valueOf2 = String.valueOf(t);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 16 + String.valueOf(valueOf2).length());
            sb.append("Finishing ");
            sb.append(valueOf);
            sb.append(" with ");
            sb.append(valueOf2);
            Log.d("MessengerIpcClient", sb.toString());
        }
        this.f17357b.a((TaskCompletionSource<T>) t);
    }

    public abstract boolean a();

    public String toString() {
        int i = this.f17358c;
        int i2 = this.f17356a;
        boolean a2 = a();
        StringBuilder sb = new StringBuilder(55);
        sb.append("Request { what=");
        sb.append(i);
        sb.append(" id=");
        sb.append(i2);
        sb.append(" oneWay=");
        sb.append(a2);
        sb.append("}");
        return sb.toString();
    }

    public final void a(zzal zzalVar) {
        if (Log.isLoggable("MessengerIpcClient", 3)) {
            String valueOf = String.valueOf(this);
            String valueOf2 = String.valueOf(zzalVar);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 14 + String.valueOf(valueOf2).length());
            sb.append("Failing ");
            sb.append(valueOf);
            sb.append(" with ");
            sb.append(valueOf2);
            Log.d("MessengerIpcClient", sb.toString());
        }
        this.f17357b.a(zzalVar);
    }
}
