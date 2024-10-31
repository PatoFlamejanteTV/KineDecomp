package com.google.android.gms.measurement.internal;

import android.os.IInterface;
import android.os.RemoteException;
import java.util.List;

/* loaded from: classes2.dex */
public interface zzaj extends IInterface {
    List<zzfv> a(zzk zzkVar, boolean z) throws RemoteException;

    List<zzo> a(String str, String str2, zzk zzkVar) throws RemoteException;

    List<zzo> a(String str, String str2, String str3) throws RemoteException;

    List<zzfv> a(String str, String str2, String str3, boolean z) throws RemoteException;

    List<zzfv> a(String str, String str2, boolean z, zzk zzkVar) throws RemoteException;

    void a(long j, String str, String str2, String str3) throws RemoteException;

    void a(zzag zzagVar, zzk zzkVar) throws RemoteException;

    void a(zzag zzagVar, String str, String str2) throws RemoteException;

    void a(zzfv zzfvVar, zzk zzkVar) throws RemoteException;

    void a(zzk zzkVar) throws RemoteException;

    void a(zzo zzoVar) throws RemoteException;

    void a(zzo zzoVar, zzk zzkVar) throws RemoteException;

    byte[] a(zzag zzagVar, String str) throws RemoteException;

    void b(zzk zzkVar) throws RemoteException;

    void c(zzk zzkVar) throws RemoteException;

    String d(zzk zzkVar) throws RemoteException;
}
