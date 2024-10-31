package com.google.android.gms.fitness.internal.service;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.fitness.service.FitnessSensorServiceRequest;
import com.google.android.gms.internal.zznv;
import com.google.android.gms.internal.zzoj;

/* loaded from: classes.dex */
public interface zzc extends IInterface {

    /* loaded from: classes.dex */
    public static abstract class zza extends Binder implements zzc {
        public zza() {
            attachInterface(this, "com.google.android.gms.fitness.internal.service.IFitnessSensorService");
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            switch (i) {
                case 1:
                    parcel.enforceInterface("com.google.android.gms.fitness.internal.service.IFitnessSensorService");
                    a(parcel.readInt() != 0 ? FitnessDataSourcesRequest.CREATOR.createFromParcel(parcel) : null, zznv.zza.zzbv(parcel.readStrongBinder()));
                    return true;
                case 2:
                    parcel.enforceInterface("com.google.android.gms.fitness.internal.service.IFitnessSensorService");
                    a(parcel.readInt() != 0 ? FitnessSensorServiceRequest.CREATOR.createFromParcel(parcel) : null, zzoj.zza.zzbJ(parcel.readStrongBinder()));
                    return true;
                case 3:
                    parcel.enforceInterface("com.google.android.gms.fitness.internal.service.IFitnessSensorService");
                    a(parcel.readInt() != 0 ? FitnessUnregistrationRequest.CREATOR.createFromParcel(parcel) : null, zzoj.zza.zzbJ(parcel.readStrongBinder()));
                    return true;
                case 1598968902:
                    parcel2.writeString("com.google.android.gms.fitness.internal.service.IFitnessSensorService");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    void a(FitnessDataSourcesRequest fitnessDataSourcesRequest, zznv zznvVar) throws RemoteException;

    void a(FitnessUnregistrationRequest fitnessUnregistrationRequest, zzoj zzojVar) throws RemoteException;

    void a(FitnessSensorServiceRequest fitnessSensorServiceRequest, zzoj zzojVar) throws RemoteException;
}
