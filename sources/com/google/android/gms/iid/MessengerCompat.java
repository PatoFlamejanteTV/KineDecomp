package com.google.android.gms.iid;

import android.os.Binder;
import android.os.Build;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.google.android.gms.iid.zzb;

/* loaded from: classes.dex */
public class MessengerCompat implements Parcelable {
    public static final Parcelable.Creator<MessengerCompat> CREATOR = new c();

    /* renamed from: a, reason: collision with root package name */
    Messenger f1424a;
    zzb b;

    /* loaded from: classes.dex */
    private final class a extends zzb.zza {

        /* renamed from: a, reason: collision with root package name */
        Handler f1425a;

        a(Handler handler) {
            this.f1425a = handler;
        }

        @Override // com.google.android.gms.iid.zzb
        public void a(Message message) throws RemoteException {
            message.arg2 = Binder.getCallingUid();
            this.f1425a.dispatchMessage(message);
        }
    }

    public MessengerCompat(Handler handler) {
        if (Build.VERSION.SDK_INT >= 21) {
            this.f1424a = new Messenger(handler);
        } else {
            this.b = new a(handler);
        }
    }

    public MessengerCompat(IBinder iBinder) {
        if (Build.VERSION.SDK_INT >= 21) {
            this.f1424a = new Messenger(iBinder);
        } else {
            this.b = zzb.zza.a(iBinder);
        }
    }

    public static int a(Message message) {
        return Build.VERSION.SDK_INT >= 21 ? c(message) : message.arg2;
    }

    private static int c(Message message) {
        return message.sendingUid;
    }

    public IBinder a() {
        return this.f1424a != null ? this.f1424a.getBinder() : this.b.asBinder();
    }

    public void b(Message message) throws RemoteException {
        if (this.f1424a != null) {
            this.f1424a.send(message);
        } else {
            this.b.a(message);
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
            return a().equals(((MessengerCompat) obj).a());
        } catch (ClassCastException e) {
            return false;
        }
    }

    public int hashCode() {
        return a().hashCode();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        if (this.f1424a != null) {
            parcel.writeStrongBinder(this.f1424a.getBinder());
        } else {
            parcel.writeStrongBinder(this.b.asBinder());
        }
    }
}
