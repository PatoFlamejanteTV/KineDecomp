package com.google.firebase.iid;

import android.os.Build;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import android.util.Log;

/* loaded from: classes2.dex */
public class zzl implements Parcelable {
    public static final Parcelable.Creator<zzl> CREATOR = new D();

    /* renamed from: a */
    private Messenger f17430a;

    /* renamed from: b */
    private M f17431b;

    /* loaded from: classes2.dex */
    public static final class zza extends ClassLoader {
        @Override // java.lang.ClassLoader
        protected final Class<?> loadClass(String str, boolean z) throws ClassNotFoundException {
            if ("com.google.android.gms.iid.MessengerCompat".equals(str)) {
                if (FirebaseInstanceId.h()) {
                    Log.d("FirebaseInstanceId", "Using renamed FirebaseIidMessengerCompat class");
                    return zzl.class;
                }
                return zzl.class;
            }
            return super.loadClass(str, z);
        }
    }

    public zzl(IBinder iBinder) {
        if (Build.VERSION.SDK_INT >= 21) {
            this.f17430a = new Messenger(iBinder);
        } else {
            this.f17431b = new zzw(iBinder);
        }
    }

    public final void a(Message message) throws RemoteException {
        Messenger messenger = this.f17430a;
        if (messenger != null) {
            messenger.send(message);
        } else {
            this.f17431b.a(message);
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        try {
            return a().equals(((zzl) obj).a());
        } catch (ClassCastException unused) {
            return false;
        }
    }

    public int hashCode() {
        return a().hashCode();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        Messenger messenger = this.f17430a;
        if (messenger != null) {
            parcel.writeStrongBinder(messenger.getBinder());
        } else {
            parcel.writeStrongBinder(this.f17431b.asBinder());
        }
    }

    private final IBinder a() {
        Messenger messenger = this.f17430a;
        return messenger != null ? messenger.getBinder() : this.f17431b.asBinder();
    }
}
