package com.google.firebase.auth.api.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.firebase_auth.zzaq;
import com.google.android.gms.internal.firebase_auth.zzas;
import com.google.android.gms.internal.firebase_auth.zzau;
import com.google.android.gms.internal.firebase_auth.zzaw;
import com.google.android.gms.internal.firebase_auth.zzay;
import com.google.android.gms.internal.firebase_auth.zzba;
import com.google.android.gms.internal.firebase_auth.zzbc;
import com.google.android.gms.internal.firebase_auth.zzbi;
import com.google.android.gms.internal.firebase_auth.zzbq;
import com.google.android.gms.internal.firebase_auth.zzbu;
import com.google.android.gms.internal.firebase_auth.zzbw;
import com.google.android.gms.internal.firebase_auth.zzby;
import com.google.android.gms.internal.firebase_auth.zzc;
import com.google.android.gms.internal.firebase_auth.zzce;
import com.google.firebase.auth.ActionCodeSettings;
import com.google.firebase.auth.EmailAuthCredential;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.UserProfileChangeRequest;

/* loaded from: classes2.dex */
public final class zzec extends com.google.android.gms.internal.firebase_auth.zza implements zzea {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzec(IBinder iBinder) {
        super(iBinder, "com.google.firebase.auth.api.internal.IFirebaseAuthService");
    }

    @Override // com.google.firebase.auth.api.internal.zzea
    public final void a(com.google.android.gms.internal.firebase_auth.zzdr zzdrVar, zzdx zzdxVar) throws RemoteException {
        Parcel zza = zza();
        zzc.zza(zza, zzdrVar);
        zzc.zza(zza, zzdxVar);
        zza(3, zza);
    }

    @Override // com.google.firebase.auth.api.internal.zzea
    public final void b(String str, String str2, zzdx zzdxVar) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zza.writeString(str2);
        zzc.zza(zza, zzdxVar);
        zza(8, zza);
    }

    @Override // com.google.firebase.auth.api.internal.zzea
    public final void c(String str, zzdx zzdxVar) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zzc.zza(zza, zzdxVar);
        zza(17, zza);
    }

    @Override // com.google.firebase.auth.api.internal.zzea
    public final void e(String str, String str2, zzdx zzdxVar) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zza.writeString(str2);
        zzc.zza(zza, zzdxVar);
        zza(7, zza);
    }

    @Override // com.google.firebase.auth.api.internal.zzea
    public final void g(String str, zzdx zzdxVar) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zzc.zza(zza, zzdxVar);
        zza(1, zza);
    }

    @Override // com.google.firebase.auth.api.internal.zzea
    public final void a(String str, UserProfileChangeRequest userProfileChangeRequest, zzdx zzdxVar) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zzc.zza(zza, userProfileChangeRequest);
        zzc.zza(zza, zzdxVar);
        zza(4, zza);
    }

    @Override // com.google.firebase.auth.api.internal.zzea
    public final void e(String str, zzdx zzdxVar) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zzc.zza(zza, zzdxVar);
        zza(9, zza);
    }

    @Override // com.google.firebase.auth.api.internal.zzea
    public final void a(String str, String str2, String str3, zzdx zzdxVar) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zza.writeString(str2);
        zza.writeString(str3);
        zzc.zza(zza, zzdxVar);
        zza(11, zza);
    }

    @Override // com.google.firebase.auth.api.internal.zzea
    public final void a(String str, com.google.android.gms.internal.firebase_auth.zzdr zzdrVar, zzdx zzdxVar) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zzc.zza(zza, zzdrVar);
        zzc.zza(zza, zzdxVar);
        zza(12, zza);
    }

    @Override // com.google.firebase.auth.api.internal.zzea
    public final void a(PhoneAuthCredential phoneAuthCredential, zzdx zzdxVar) throws RemoteException {
        Parcel zza = zza();
        zzc.zza(zza, phoneAuthCredential);
        zzc.zza(zza, zzdxVar);
        zza(23, zza);
    }

    @Override // com.google.firebase.auth.api.internal.zzea
    public final void a(String str, PhoneAuthCredential phoneAuthCredential, zzdx zzdxVar) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zzc.zza(zza, phoneAuthCredential);
        zzc.zza(zza, zzdxVar);
        zza(24, zza);
    }

    @Override // com.google.firebase.auth.api.internal.zzea
    public final void a(String str, ActionCodeSettings actionCodeSettings, zzdx zzdxVar) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zzc.zza(zza, actionCodeSettings);
        zzc.zza(zza, zzdxVar);
        zza(28, zza);
    }

    @Override // com.google.firebase.auth.api.internal.zzea
    public final void a(EmailAuthCredential emailAuthCredential, zzdx zzdxVar) throws RemoteException {
        Parcel zza = zza();
        zzc.zza(zza, emailAuthCredential);
        zzc.zza(zza, zzdxVar);
        zza(29, zza);
    }

    @Override // com.google.firebase.auth.api.internal.zzea
    public final void a(zzau zzauVar, zzdx zzdxVar) throws RemoteException {
        Parcel zza = zza();
        zzc.zza(zza, zzauVar);
        zzc.zza(zza, zzdxVar);
        zza(101, zza);
    }

    @Override // com.google.firebase.auth.api.internal.zzea
    public final void a(zzbq zzbqVar, zzdx zzdxVar) throws RemoteException {
        Parcel zza = zza();
        zzc.zza(zza, zzbqVar);
        zzc.zza(zza, zzdxVar);
        zza(103, zza);
    }

    @Override // com.google.firebase.auth.api.internal.zzea
    public final void a(zzce zzceVar, zzdx zzdxVar) throws RemoteException {
        Parcel zza = zza();
        zzc.zza(zza, zzceVar);
        zzc.zza(zza, zzdxVar);
        zza(104, zza);
    }

    @Override // com.google.firebase.auth.api.internal.zzea
    public final void a(zzaq zzaqVar, zzdx zzdxVar) throws RemoteException {
        Parcel zza = zza();
        zzc.zza(zza, zzaqVar);
        zzc.zza(zza, zzdxVar);
        zza(107, zza);
    }

    @Override // com.google.firebase.auth.api.internal.zzea
    public final void a(zzbu zzbuVar, zzdx zzdxVar) throws RemoteException {
        Parcel zza = zza();
        zzc.zza(zza, zzbuVar);
        zzc.zza(zza, zzdxVar);
        zza(108, zza);
    }

    @Override // com.google.firebase.auth.api.internal.zzea
    public final void a(zzaw zzawVar, zzdx zzdxVar) throws RemoteException {
        Parcel zza = zza();
        zzc.zza(zza, zzawVar);
        zzc.zza(zza, zzdxVar);
        zza(109, zza);
    }

    @Override // com.google.firebase.auth.api.internal.zzea
    public final void a(zzay zzayVar, zzdx zzdxVar) throws RemoteException {
        Parcel zza = zza();
        zzc.zza(zza, zzayVar);
        zzc.zza(zza, zzdxVar);
        zza(111, zza);
    }

    @Override // com.google.firebase.auth.api.internal.zzea
    public final void a(zzba zzbaVar, zzdx zzdxVar) throws RemoteException {
        Parcel zza = zza();
        zzc.zza(zza, zzbaVar);
        zzc.zza(zza, zzdxVar);
        zza(112, zza);
    }

    @Override // com.google.firebase.auth.api.internal.zzea
    public final void a(zzas zzasVar, zzdx zzdxVar) throws RemoteException {
        Parcel zza = zza();
        zzc.zza(zza, zzasVar);
        zzc.zza(zza, zzdxVar);
        zza(117, zza);
    }

    @Override // com.google.firebase.auth.api.internal.zzea
    public final void a(zzby zzbyVar, zzdx zzdxVar) throws RemoteException {
        Parcel zza = zza();
        zzc.zza(zza, zzbyVar);
        zzc.zza(zza, zzdxVar);
        zza(123, zza);
    }

    @Override // com.google.firebase.auth.api.internal.zzea
    public final void a(zzbc zzbcVar, zzdx zzdxVar) throws RemoteException {
        Parcel zza = zza();
        zzc.zza(zza, zzbcVar);
        zzc.zza(zza, zzdxVar);
        zza(124, zza);
    }

    @Override // com.google.firebase.auth.api.internal.zzea
    public final void a(zzbi zzbiVar, zzdx zzdxVar) throws RemoteException {
        Parcel zza = zza();
        zzc.zza(zza, zzbiVar);
        zzc.zza(zza, zzdxVar);
        zza(128, zza);
    }

    @Override // com.google.firebase.auth.api.internal.zzea
    public final void a(zzbw zzbwVar, zzdx zzdxVar) throws RemoteException {
        Parcel zza = zza();
        zzc.zza(zza, zzbwVar);
        zzc.zza(zza, zzdxVar);
        zza(129, zza);
    }
}
