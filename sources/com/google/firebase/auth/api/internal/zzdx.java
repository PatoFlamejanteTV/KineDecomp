package com.google.firebase.auth.api.internal;

import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.firebase_auth.zzcg;
import com.google.android.gms.internal.firebase_auth.zzcj;
import com.google.android.gms.internal.firebase_auth.zzct;
import com.google.android.gms.internal.firebase_auth.zzcz;
import com.google.android.gms.internal.firebase_auth.zzdg;
import com.google.firebase.auth.PhoneAuthCredential;

/* loaded from: classes2.dex */
public interface zzdx extends IInterface {
    void a(Status status, PhoneAuthCredential phoneAuthCredential) throws RemoteException;

    void a(zzcg zzcgVar) throws RemoteException;

    void a(zzcj zzcjVar) throws RemoteException;

    void a(zzcz zzczVar) throws RemoteException;

    void a(zzcz zzczVar, zzct zzctVar) throws RemoteException;

    void a(zzdg zzdgVar) throws RemoteException;

    void a(PhoneAuthCredential phoneAuthCredential) throws RemoteException;

    void c(String str) throws RemoteException;

    void d(String str) throws RemoteException;

    void e(String str) throws RemoteException;

    void o() throws RemoteException;

    void onFailure(Status status) throws RemoteException;

    void p() throws RemoteException;

    void zzde() throws RemoteException;
}
