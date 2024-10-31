package com.google.android.gms.dynamic;

import android.content.Intent;
import android.os.Bundle;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.common.zzb;
import com.google.android.gms.internal.common.zzc;

/* loaded from: classes.dex */
public interface IFragmentWrapper extends IInterface {

    /* loaded from: classes.dex */
    public static abstract class Stub extends zzb implements IFragmentWrapper {

        /* loaded from: classes.dex */
        public static class zza extends com.google.android.gms.internal.common.zza implements IFragmentWrapper {
        }

        public Stub() {
            super("com.google.android.gms.dynamic.IFragmentWrapper");
        }

        @Override // com.google.android.gms.internal.common.zzb
        protected final boolean zza(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            switch (i) {
                case 2:
                    IObjectWrapper c2 = c();
                    parcel2.writeNoException();
                    zzc.zza(parcel2, c2);
                    return true;
                case 3:
                    Bundle t = t();
                    parcel2.writeNoException();
                    zzc.zzb(parcel2, t);
                    return true;
                case 4:
                    int id = getId();
                    parcel2.writeNoException();
                    parcel2.writeInt(id);
                    return true;
                case 5:
                    IFragmentWrapper g2 = g();
                    parcel2.writeNoException();
                    zzc.zza(parcel2, g2);
                    return true;
                case 6:
                    IObjectWrapper e2 = e();
                    parcel2.writeNoException();
                    zzc.zza(parcel2, e2);
                    return true;
                case 7:
                    boolean n = n();
                    parcel2.writeNoException();
                    zzc.writeBoolean(parcel2, n);
                    return true;
                case 8:
                    String tag = getTag();
                    parcel2.writeNoException();
                    parcel2.writeString(tag);
                    return true;
                case 9:
                    IFragmentWrapper f2 = f();
                    parcel2.writeNoException();
                    zzc.zza(parcel2, f2);
                    return true;
                case 10:
                    int i3 = i();
                    parcel2.writeNoException();
                    parcel2.writeInt(i3);
                    return true;
                case 11:
                    boolean d2 = d();
                    parcel2.writeNoException();
                    zzc.writeBoolean(parcel2, d2);
                    return true;
                case 12:
                    IObjectWrapper k = k();
                    parcel2.writeNoException();
                    zzc.zza(parcel2, k);
                    return true;
                case 13:
                    boolean h2 = h();
                    parcel2.writeNoException();
                    zzc.writeBoolean(parcel2, h2);
                    return true;
                case 14:
                    boolean m = m();
                    parcel2.writeNoException();
                    zzc.writeBoolean(parcel2, m);
                    return true;
                case 15:
                    boolean isHidden = isHidden();
                    parcel2.writeNoException();
                    zzc.writeBoolean(parcel2, isHidden);
                    return true;
                case 16:
                    boolean q = q();
                    parcel2.writeNoException();
                    zzc.writeBoolean(parcel2, q);
                    return true;
                case 17:
                    boolean r = r();
                    parcel2.writeNoException();
                    zzc.writeBoolean(parcel2, r);
                    return true;
                case 18:
                    boolean s = s();
                    parcel2.writeNoException();
                    zzc.writeBoolean(parcel2, s);
                    return true;
                case 19:
                    boolean isVisible = isVisible();
                    parcel2.writeNoException();
                    zzc.writeBoolean(parcel2, isVisible);
                    return true;
                case 20:
                    zza(IObjectWrapper.Stub.a(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 21:
                    e(zzc.zza(parcel));
                    parcel2.writeNoException();
                    return true;
                case 22:
                    c(zzc.zza(parcel));
                    parcel2.writeNoException();
                    return true;
                case 23:
                    d(zzc.zza(parcel));
                    parcel2.writeNoException();
                    return true;
                case 24:
                    b(zzc.zza(parcel));
                    parcel2.writeNoException();
                    return true;
                case 25:
                    a((Intent) zzc.zza(parcel, Intent.CREATOR));
                    parcel2.writeNoException();
                    return true;
                case 26:
                    startActivityForResult((Intent) zzc.zza(parcel, Intent.CREATOR), parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 27:
                    zzb(IObjectWrapper.Stub.a(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                default:
                    return false;
            }
        }
    }

    void a(Intent intent) throws RemoteException;

    void b(boolean z) throws RemoteException;

    IObjectWrapper c() throws RemoteException;

    void c(boolean z) throws RemoteException;

    void d(boolean z) throws RemoteException;

    boolean d() throws RemoteException;

    IObjectWrapper e() throws RemoteException;

    void e(boolean z) throws RemoteException;

    IFragmentWrapper f() throws RemoteException;

    IFragmentWrapper g() throws RemoteException;

    int getId() throws RemoteException;

    String getTag() throws RemoteException;

    boolean h() throws RemoteException;

    int i() throws RemoteException;

    boolean isHidden() throws RemoteException;

    boolean isVisible() throws RemoteException;

    IObjectWrapper k() throws RemoteException;

    boolean m() throws RemoteException;

    boolean n() throws RemoteException;

    boolean q() throws RemoteException;

    boolean r() throws RemoteException;

    boolean s() throws RemoteException;

    void startActivityForResult(Intent intent, int i) throws RemoteException;

    Bundle t() throws RemoteException;

    void zza(IObjectWrapper iObjectWrapper) throws RemoteException;

    void zzb(IObjectWrapper iObjectWrapper) throws RemoteException;
}
