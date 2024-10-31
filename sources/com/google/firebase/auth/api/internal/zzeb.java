package com.google.firebase.auth.api.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.firebase_auth.zzag;
import com.google.android.gms.internal.firebase_auth.zzai;
import com.google.android.gms.internal.firebase_auth.zzak;
import com.google.android.gms.internal.firebase_auth.zzaq;
import com.google.android.gms.internal.firebase_auth.zzas;
import com.google.android.gms.internal.firebase_auth.zzau;
import com.google.android.gms.internal.firebase_auth.zzaw;
import com.google.android.gms.internal.firebase_auth.zzay;
import com.google.android.gms.internal.firebase_auth.zzb;
import com.google.android.gms.internal.firebase_auth.zzba;
import com.google.android.gms.internal.firebase_auth.zzbc;
import com.google.android.gms.internal.firebase_auth.zzbe;
import com.google.android.gms.internal.firebase_auth.zzbg;
import com.google.android.gms.internal.firebase_auth.zzbi;
import com.google.android.gms.internal.firebase_auth.zzbk;
import com.google.android.gms.internal.firebase_auth.zzbm;
import com.google.android.gms.internal.firebase_auth.zzbo;
import com.google.android.gms.internal.firebase_auth.zzbq;
import com.google.android.gms.internal.firebase_auth.zzbs;
import com.google.android.gms.internal.firebase_auth.zzbu;
import com.google.android.gms.internal.firebase_auth.zzbw;
import com.google.android.gms.internal.firebase_auth.zzby;
import com.google.android.gms.internal.firebase_auth.zzc;
import com.google.android.gms.internal.firebase_auth.zzca;
import com.google.android.gms.internal.firebase_auth.zzcc;
import com.google.android.gms.internal.firebase_auth.zzce;
import com.google.android.gms.internal.firebase_auth.zzdj;
import com.google.firebase.auth.ActionCodeSettings;
import com.google.firebase.auth.EmailAuthCredential;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.UserProfileChangeRequest;

/* loaded from: classes2.dex */
public abstract class zzeb extends zzb implements zzea {
    public zzeb() {
        super("com.google.firebase.auth.api.internal.IFirebaseAuthService");
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:2:0x0003. Please report as an issue. */
    /* JADX WARN: Failed to find 'out' block for switch in B:3:0x0006. Please report as an issue. */
    /* JADX WARN: Failed to find 'out' block for switch in B:4:0x0009. Please report as an issue. */
    /* JADX WARN: Failed to find 'out' block for switch in B:5:0x000c. Please report as an issue. */
    /* JADX WARN: Failed to find 'out' block for switch in B:6:0x000f. Please report as an issue. */
    @Override // com.google.android.gms.internal.firebase_auth.zzb
    protected final boolean dispatchTransaction(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        zzdx zzdxVar = null;
        switch (i) {
            case 1:
                String readString = parcel.readString();
                IBinder readStrongBinder = parcel.readStrongBinder();
                if (readStrongBinder != null) {
                    IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks");
                    if (queryLocalInterface instanceof zzdx) {
                        zzdxVar = (zzdx) queryLocalInterface;
                    } else {
                        zzdxVar = new zzdz(readStrongBinder);
                    }
                }
                g(readString, zzdxVar);
                parcel2.writeNoException();
                return true;
            case 2:
                String readString2 = parcel.readString();
                IBinder readStrongBinder2 = parcel.readStrongBinder();
                if (readStrongBinder2 != null) {
                    IInterface queryLocalInterface2 = readStrongBinder2.queryLocalInterface("com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks");
                    if (queryLocalInterface2 instanceof zzdx) {
                        zzdxVar = (zzdx) queryLocalInterface2;
                    } else {
                        zzdxVar = new zzdz(readStrongBinder2);
                    }
                }
                f(readString2, zzdxVar);
                parcel2.writeNoException();
                return true;
            case 3:
                com.google.android.gms.internal.firebase_auth.zzdr zzdrVar = (com.google.android.gms.internal.firebase_auth.zzdr) zzc.zza(parcel, com.google.android.gms.internal.firebase_auth.zzdr.CREATOR);
                IBinder readStrongBinder3 = parcel.readStrongBinder();
                if (readStrongBinder3 != null) {
                    IInterface queryLocalInterface3 = readStrongBinder3.queryLocalInterface("com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks");
                    if (queryLocalInterface3 instanceof zzdx) {
                        zzdxVar = (zzdx) queryLocalInterface3;
                    } else {
                        zzdxVar = new zzdz(readStrongBinder3);
                    }
                }
                a(zzdrVar, zzdxVar);
                parcel2.writeNoException();
                return true;
            case 4:
                String readString3 = parcel.readString();
                UserProfileChangeRequest userProfileChangeRequest = (UserProfileChangeRequest) zzc.zza(parcel, UserProfileChangeRequest.CREATOR);
                IBinder readStrongBinder4 = parcel.readStrongBinder();
                if (readStrongBinder4 != null) {
                    IInterface queryLocalInterface4 = readStrongBinder4.queryLocalInterface("com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks");
                    if (queryLocalInterface4 instanceof zzdx) {
                        zzdxVar = (zzdx) queryLocalInterface4;
                    } else {
                        zzdxVar = new zzdz(readStrongBinder4);
                    }
                }
                a(readString3, userProfileChangeRequest, zzdxVar);
                parcel2.writeNoException();
                return true;
            case 5:
                String readString4 = parcel.readString();
                String readString5 = parcel.readString();
                IBinder readStrongBinder5 = parcel.readStrongBinder();
                if (readStrongBinder5 != null) {
                    IInterface queryLocalInterface5 = readStrongBinder5.queryLocalInterface("com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks");
                    if (queryLocalInterface5 instanceof zzdx) {
                        zzdxVar = (zzdx) queryLocalInterface5;
                    } else {
                        zzdxVar = new zzdz(readStrongBinder5);
                    }
                }
                a(readString4, readString5, zzdxVar);
                parcel2.writeNoException();
                return true;
            case 6:
                String readString6 = parcel.readString();
                String readString7 = parcel.readString();
                IBinder readStrongBinder6 = parcel.readStrongBinder();
                if (readStrongBinder6 != null) {
                    IInterface queryLocalInterface6 = readStrongBinder6.queryLocalInterface("com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks");
                    if (queryLocalInterface6 instanceof zzdx) {
                        zzdxVar = (zzdx) queryLocalInterface6;
                    } else {
                        zzdxVar = new zzdz(readStrongBinder6);
                    }
                }
                d(readString6, readString7, zzdxVar);
                parcel2.writeNoException();
                return true;
            case 7:
                String readString8 = parcel.readString();
                String readString9 = parcel.readString();
                IBinder readStrongBinder7 = parcel.readStrongBinder();
                if (readStrongBinder7 != null) {
                    IInterface queryLocalInterface7 = readStrongBinder7.queryLocalInterface("com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks");
                    if (queryLocalInterface7 instanceof zzdx) {
                        zzdxVar = (zzdx) queryLocalInterface7;
                    } else {
                        zzdxVar = new zzdz(readStrongBinder7);
                    }
                }
                e(readString8, readString9, zzdxVar);
                parcel2.writeNoException();
                return true;
            case 8:
                String readString10 = parcel.readString();
                String readString11 = parcel.readString();
                IBinder readStrongBinder8 = parcel.readStrongBinder();
                if (readStrongBinder8 != null) {
                    IInterface queryLocalInterface8 = readStrongBinder8.queryLocalInterface("com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks");
                    if (queryLocalInterface8 instanceof zzdx) {
                        zzdxVar = (zzdx) queryLocalInterface8;
                    } else {
                        zzdxVar = new zzdz(readStrongBinder8);
                    }
                }
                b(readString10, readString11, zzdxVar);
                parcel2.writeNoException();
                return true;
            case 9:
                String readString12 = parcel.readString();
                IBinder readStrongBinder9 = parcel.readStrongBinder();
                if (readStrongBinder9 != null) {
                    IInterface queryLocalInterface9 = readStrongBinder9.queryLocalInterface("com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks");
                    if (queryLocalInterface9 instanceof zzdx) {
                        zzdxVar = (zzdx) queryLocalInterface9;
                    } else {
                        zzdxVar = new zzdz(readStrongBinder9);
                    }
                }
                e(readString12, zzdxVar);
                parcel2.writeNoException();
                return true;
            case 10:
                String readString13 = parcel.readString();
                IBinder readStrongBinder10 = parcel.readStrongBinder();
                if (readStrongBinder10 != null) {
                    IInterface queryLocalInterface10 = readStrongBinder10.queryLocalInterface("com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks");
                    if (queryLocalInterface10 instanceof zzdx) {
                        zzdxVar = (zzdx) queryLocalInterface10;
                    } else {
                        zzdxVar = new zzdz(readStrongBinder10);
                    }
                }
                b(readString13, zzdxVar);
                parcel2.writeNoException();
                return true;
            case 11:
                String readString14 = parcel.readString();
                String readString15 = parcel.readString();
                String readString16 = parcel.readString();
                IBinder readStrongBinder11 = parcel.readStrongBinder();
                if (readStrongBinder11 != null) {
                    IInterface queryLocalInterface11 = readStrongBinder11.queryLocalInterface("com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks");
                    if (queryLocalInterface11 instanceof zzdx) {
                        zzdxVar = (zzdx) queryLocalInterface11;
                    } else {
                        zzdxVar = new zzdz(readStrongBinder11);
                    }
                }
                a(readString14, readString15, readString16, zzdxVar);
                parcel2.writeNoException();
                return true;
            case 12:
                String readString17 = parcel.readString();
                com.google.android.gms.internal.firebase_auth.zzdr zzdrVar2 = (com.google.android.gms.internal.firebase_auth.zzdr) zzc.zza(parcel, com.google.android.gms.internal.firebase_auth.zzdr.CREATOR);
                IBinder readStrongBinder12 = parcel.readStrongBinder();
                if (readStrongBinder12 != null) {
                    IInterface queryLocalInterface12 = readStrongBinder12.queryLocalInterface("com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks");
                    if (queryLocalInterface12 instanceof zzdx) {
                        zzdxVar = (zzdx) queryLocalInterface12;
                    } else {
                        zzdxVar = new zzdz(readStrongBinder12);
                    }
                }
                a(readString17, zzdrVar2, zzdxVar);
                parcel2.writeNoException();
                return true;
            case 13:
                String readString18 = parcel.readString();
                IBinder readStrongBinder13 = parcel.readStrongBinder();
                if (readStrongBinder13 != null) {
                    IInterface queryLocalInterface13 = readStrongBinder13.queryLocalInterface("com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks");
                    if (queryLocalInterface13 instanceof zzdx) {
                        zzdxVar = (zzdx) queryLocalInterface13;
                    } else {
                        zzdxVar = new zzdz(readStrongBinder13);
                    }
                }
                a(readString18, zzdxVar);
                parcel2.writeNoException();
                return true;
            case 14:
                String readString19 = parcel.readString();
                String readString20 = parcel.readString();
                IBinder readStrongBinder14 = parcel.readStrongBinder();
                if (readStrongBinder14 != null) {
                    IInterface queryLocalInterface14 = readStrongBinder14.queryLocalInterface("com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks");
                    if (queryLocalInterface14 instanceof zzdx) {
                        zzdxVar = (zzdx) queryLocalInterface14;
                    } else {
                        zzdxVar = new zzdz(readStrongBinder14);
                    }
                }
                c(readString19, readString20, zzdxVar);
                parcel2.writeNoException();
                return true;
            case 15:
                String readString21 = parcel.readString();
                IBinder readStrongBinder15 = parcel.readStrongBinder();
                if (readStrongBinder15 != null) {
                    IInterface queryLocalInterface15 = readStrongBinder15.queryLocalInterface("com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks");
                    if (queryLocalInterface15 instanceof zzdx) {
                        zzdxVar = (zzdx) queryLocalInterface15;
                    } else {
                        zzdxVar = new zzdz(readStrongBinder15);
                    }
                }
                d(readString21, zzdxVar);
                parcel2.writeNoException();
                return true;
            case 16:
                IBinder readStrongBinder16 = parcel.readStrongBinder();
                if (readStrongBinder16 != null) {
                    IInterface queryLocalInterface16 = readStrongBinder16.queryLocalInterface("com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks");
                    if (queryLocalInterface16 instanceof zzdx) {
                        zzdxVar = (zzdx) queryLocalInterface16;
                    } else {
                        zzdxVar = new zzdz(readStrongBinder16);
                    }
                }
                a(zzdxVar);
                parcel2.writeNoException();
                return true;
            case 17:
                String readString22 = parcel.readString();
                IBinder readStrongBinder17 = parcel.readStrongBinder();
                if (readStrongBinder17 != null) {
                    IInterface queryLocalInterface17 = readStrongBinder17.queryLocalInterface("com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks");
                    if (queryLocalInterface17 instanceof zzdx) {
                        zzdxVar = (zzdx) queryLocalInterface17;
                    } else {
                        zzdxVar = new zzdz(readStrongBinder17);
                    }
                }
                c(readString22, zzdxVar);
                parcel2.writeNoException();
                return true;
            case 18:
                String readString23 = parcel.readString();
                IBinder readStrongBinder18 = parcel.readStrongBinder();
                if (readStrongBinder18 != null) {
                    IInterface queryLocalInterface18 = readStrongBinder18.queryLocalInterface("com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks");
                    if (queryLocalInterface18 instanceof zzdx) {
                        zzdxVar = (zzdx) queryLocalInterface18;
                    } else {
                        zzdxVar = new zzdz(readStrongBinder18);
                    }
                }
                i(readString23, zzdxVar);
                parcel2.writeNoException();
                return true;
            case 19:
                String readString24 = parcel.readString();
                IBinder readStrongBinder19 = parcel.readStrongBinder();
                if (readStrongBinder19 != null) {
                    IInterface queryLocalInterface19 = readStrongBinder19.queryLocalInterface("com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks");
                    if (queryLocalInterface19 instanceof zzdx) {
                        zzdxVar = (zzdx) queryLocalInterface19;
                    } else {
                        zzdxVar = new zzdz(readStrongBinder19);
                    }
                }
                h(readString24, zzdxVar);
                parcel2.writeNoException();
                return true;
            case 20:
                String readString25 = parcel.readString();
                IBinder readStrongBinder20 = parcel.readStrongBinder();
                if (readStrongBinder20 != null) {
                    IInterface queryLocalInterface20 = readStrongBinder20.queryLocalInterface("com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks");
                    if (queryLocalInterface20 instanceof zzdx) {
                        zzdxVar = (zzdx) queryLocalInterface20;
                    } else {
                        zzdxVar = new zzdz(readStrongBinder20);
                    }
                }
                k(readString25, zzdxVar);
                parcel2.writeNoException();
                return true;
            case 21:
                String readString26 = parcel.readString();
                String readString27 = parcel.readString();
                IBinder readStrongBinder21 = parcel.readStrongBinder();
                if (readStrongBinder21 != null) {
                    IInterface queryLocalInterface21 = readStrongBinder21.queryLocalInterface("com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks");
                    if (queryLocalInterface21 instanceof zzdx) {
                        zzdxVar = (zzdx) queryLocalInterface21;
                    } else {
                        zzdxVar = new zzdz(readStrongBinder21);
                    }
                }
                f(readString26, readString27, zzdxVar);
                parcel2.writeNoException();
                return true;
            case 22:
                zzdj zzdjVar = (zzdj) zzc.zza(parcel, zzdj.CREATOR);
                IBinder readStrongBinder22 = parcel.readStrongBinder();
                if (readStrongBinder22 != null) {
                    IInterface queryLocalInterface22 = readStrongBinder22.queryLocalInterface("com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks");
                    if (queryLocalInterface22 instanceof zzdx) {
                        zzdxVar = (zzdx) queryLocalInterface22;
                    } else {
                        zzdxVar = new zzdz(readStrongBinder22);
                    }
                }
                a(zzdjVar, zzdxVar);
                parcel2.writeNoException();
                return true;
            case 23:
                PhoneAuthCredential phoneAuthCredential = (PhoneAuthCredential) zzc.zza(parcel, PhoneAuthCredential.CREATOR);
                IBinder readStrongBinder23 = parcel.readStrongBinder();
                if (readStrongBinder23 != null) {
                    IInterface queryLocalInterface23 = readStrongBinder23.queryLocalInterface("com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks");
                    if (queryLocalInterface23 instanceof zzdx) {
                        zzdxVar = (zzdx) queryLocalInterface23;
                    } else {
                        zzdxVar = new zzdz(readStrongBinder23);
                    }
                }
                a(phoneAuthCredential, zzdxVar);
                parcel2.writeNoException();
                return true;
            case 24:
                String readString28 = parcel.readString();
                PhoneAuthCredential phoneAuthCredential2 = (PhoneAuthCredential) zzc.zza(parcel, PhoneAuthCredential.CREATOR);
                IBinder readStrongBinder24 = parcel.readStrongBinder();
                if (readStrongBinder24 != null) {
                    IInterface queryLocalInterface24 = readStrongBinder24.queryLocalInterface("com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks");
                    if (queryLocalInterface24 instanceof zzdx) {
                        zzdxVar = (zzdx) queryLocalInterface24;
                    } else {
                        zzdxVar = new zzdz(readStrongBinder24);
                    }
                }
                a(readString28, phoneAuthCredential2, zzdxVar);
                parcel2.writeNoException();
                return true;
            case 25:
                String readString29 = parcel.readString();
                ActionCodeSettings actionCodeSettings = (ActionCodeSettings) zzc.zza(parcel, ActionCodeSettings.CREATOR);
                IBinder readStrongBinder25 = parcel.readStrongBinder();
                if (readStrongBinder25 != null) {
                    IInterface queryLocalInterface25 = readStrongBinder25.queryLocalInterface("com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks");
                    if (queryLocalInterface25 instanceof zzdx) {
                        zzdxVar = (zzdx) queryLocalInterface25;
                    } else {
                        zzdxVar = new zzdz(readStrongBinder25);
                    }
                }
                c(readString29, actionCodeSettings, zzdxVar);
                parcel2.writeNoException();
                return true;
            case 26:
                String readString30 = parcel.readString();
                ActionCodeSettings actionCodeSettings2 = (ActionCodeSettings) zzc.zza(parcel, ActionCodeSettings.CREATOR);
                IBinder readStrongBinder26 = parcel.readStrongBinder();
                if (readStrongBinder26 != null) {
                    IInterface queryLocalInterface26 = readStrongBinder26.queryLocalInterface("com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks");
                    if (queryLocalInterface26 instanceof zzdx) {
                        zzdxVar = (zzdx) queryLocalInterface26;
                    } else {
                        zzdxVar = new zzdz(readStrongBinder26);
                    }
                }
                b(readString30, actionCodeSettings2, zzdxVar);
                parcel2.writeNoException();
                return true;
            case 27:
                String readString31 = parcel.readString();
                IBinder readStrongBinder27 = parcel.readStrongBinder();
                if (readStrongBinder27 != null) {
                    IInterface queryLocalInterface27 = readStrongBinder27.queryLocalInterface("com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks");
                    if (queryLocalInterface27 instanceof zzdx) {
                        zzdxVar = (zzdx) queryLocalInterface27;
                    } else {
                        zzdxVar = new zzdz(readStrongBinder27);
                    }
                }
                j(readString31, zzdxVar);
                parcel2.writeNoException();
                return true;
            case 28:
                String readString32 = parcel.readString();
                ActionCodeSettings actionCodeSettings3 = (ActionCodeSettings) zzc.zza(parcel, ActionCodeSettings.CREATOR);
                IBinder readStrongBinder28 = parcel.readStrongBinder();
                if (readStrongBinder28 != null) {
                    IInterface queryLocalInterface28 = readStrongBinder28.queryLocalInterface("com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks");
                    if (queryLocalInterface28 instanceof zzdx) {
                        zzdxVar = (zzdx) queryLocalInterface28;
                    } else {
                        zzdxVar = new zzdz(readStrongBinder28);
                    }
                }
                a(readString32, actionCodeSettings3, zzdxVar);
                parcel2.writeNoException();
                return true;
            case 29:
                EmailAuthCredential emailAuthCredential = (EmailAuthCredential) zzc.zza(parcel, EmailAuthCredential.CREATOR);
                IBinder readStrongBinder29 = parcel.readStrongBinder();
                if (readStrongBinder29 != null) {
                    IInterface queryLocalInterface29 = readStrongBinder29.queryLocalInterface("com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks");
                    if (queryLocalInterface29 instanceof zzdx) {
                        zzdxVar = (zzdx) queryLocalInterface29;
                    } else {
                        zzdxVar = new zzdz(readStrongBinder29);
                    }
                }
                a(emailAuthCredential, zzdxVar);
                parcel2.writeNoException();
                return true;
            default:
                switch (i) {
                    case 101:
                        zzau zzauVar = (zzau) zzc.zza(parcel, zzau.CREATOR);
                        IBinder readStrongBinder30 = parcel.readStrongBinder();
                        if (readStrongBinder30 != null) {
                            IInterface queryLocalInterface30 = readStrongBinder30.queryLocalInterface("com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks");
                            if (queryLocalInterface30 instanceof zzdx) {
                                zzdxVar = (zzdx) queryLocalInterface30;
                            } else {
                                zzdxVar = new zzdz(readStrongBinder30);
                            }
                        }
                        a(zzauVar, zzdxVar);
                        parcel2.writeNoException();
                        return true;
                    case 102:
                        zzbs zzbsVar = (zzbs) zzc.zza(parcel, zzbs.CREATOR);
                        IBinder readStrongBinder31 = parcel.readStrongBinder();
                        if (readStrongBinder31 != null) {
                            IInterface queryLocalInterface31 = readStrongBinder31.queryLocalInterface("com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks");
                            if (queryLocalInterface31 instanceof zzdx) {
                                zzdxVar = (zzdx) queryLocalInterface31;
                            } else {
                                zzdxVar = new zzdz(readStrongBinder31);
                            }
                        }
                        a(zzbsVar, zzdxVar);
                        parcel2.writeNoException();
                        return true;
                    case 103:
                        zzbq zzbqVar = (zzbq) zzc.zza(parcel, zzbq.CREATOR);
                        IBinder readStrongBinder32 = parcel.readStrongBinder();
                        if (readStrongBinder32 != null) {
                            IInterface queryLocalInterface32 = readStrongBinder32.queryLocalInterface("com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks");
                            if (queryLocalInterface32 instanceof zzdx) {
                                zzdxVar = (zzdx) queryLocalInterface32;
                            } else {
                                zzdxVar = new zzdz(readStrongBinder32);
                            }
                        }
                        a(zzbqVar, zzdxVar);
                        parcel2.writeNoException();
                        return true;
                    case 104:
                        zzce zzceVar = (zzce) zzc.zza(parcel, zzce.CREATOR);
                        IBinder readStrongBinder33 = parcel.readStrongBinder();
                        if (readStrongBinder33 != null) {
                            IInterface queryLocalInterface33 = readStrongBinder33.queryLocalInterface("com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks");
                            if (queryLocalInterface33 instanceof zzdx) {
                                zzdxVar = (zzdx) queryLocalInterface33;
                            } else {
                                zzdxVar = new zzdz(readStrongBinder33);
                            }
                        }
                        a(zzceVar, zzdxVar);
                        parcel2.writeNoException();
                        return true;
                    case 105:
                        zzai zzaiVar = (zzai) zzc.zza(parcel, zzai.CREATOR);
                        IBinder readStrongBinder34 = parcel.readStrongBinder();
                        if (readStrongBinder34 != null) {
                            IInterface queryLocalInterface34 = readStrongBinder34.queryLocalInterface("com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks");
                            if (queryLocalInterface34 instanceof zzdx) {
                                zzdxVar = (zzdx) queryLocalInterface34;
                            } else {
                                zzdxVar = new zzdz(readStrongBinder34);
                            }
                        }
                        a(zzaiVar, zzdxVar);
                        parcel2.writeNoException();
                        return true;
                    case 106:
                        zzak zzakVar = (zzak) zzc.zza(parcel, zzak.CREATOR);
                        IBinder readStrongBinder35 = parcel.readStrongBinder();
                        if (readStrongBinder35 != null) {
                            IInterface queryLocalInterface35 = readStrongBinder35.queryLocalInterface("com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks");
                            if (queryLocalInterface35 instanceof zzdx) {
                                zzdxVar = (zzdx) queryLocalInterface35;
                            } else {
                                zzdxVar = new zzdz(readStrongBinder35);
                            }
                        }
                        a(zzakVar, zzdxVar);
                        parcel2.writeNoException();
                        return true;
                    case 107:
                        zzaq zzaqVar = (zzaq) zzc.zza(parcel, zzaq.CREATOR);
                        IBinder readStrongBinder36 = parcel.readStrongBinder();
                        if (readStrongBinder36 != null) {
                            IInterface queryLocalInterface36 = readStrongBinder36.queryLocalInterface("com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks");
                            if (queryLocalInterface36 instanceof zzdx) {
                                zzdxVar = (zzdx) queryLocalInterface36;
                            } else {
                                zzdxVar = new zzdz(readStrongBinder36);
                            }
                        }
                        a(zzaqVar, zzdxVar);
                        parcel2.writeNoException();
                        return true;
                    case 108:
                        zzbu zzbuVar = (zzbu) zzc.zza(parcel, zzbu.CREATOR);
                        IBinder readStrongBinder37 = parcel.readStrongBinder();
                        if (readStrongBinder37 != null) {
                            IInterface queryLocalInterface37 = readStrongBinder37.queryLocalInterface("com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks");
                            if (queryLocalInterface37 instanceof zzdx) {
                                zzdxVar = (zzdx) queryLocalInterface37;
                            } else {
                                zzdxVar = new zzdz(readStrongBinder37);
                            }
                        }
                        a(zzbuVar, zzdxVar);
                        parcel2.writeNoException();
                        return true;
                    case 109:
                        zzaw zzawVar = (zzaw) zzc.zza(parcel, zzaw.CREATOR);
                        IBinder readStrongBinder38 = parcel.readStrongBinder();
                        if (readStrongBinder38 != null) {
                            IInterface queryLocalInterface38 = readStrongBinder38.queryLocalInterface("com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks");
                            if (queryLocalInterface38 instanceof zzdx) {
                                zzdxVar = (zzdx) queryLocalInterface38;
                            } else {
                                zzdxVar = new zzdz(readStrongBinder38);
                            }
                        }
                        a(zzawVar, zzdxVar);
                        parcel2.writeNoException();
                        return true;
                    default:
                        switch (i) {
                            case 111:
                                zzay zzayVar = (zzay) zzc.zza(parcel, zzay.CREATOR);
                                IBinder readStrongBinder39 = parcel.readStrongBinder();
                                if (readStrongBinder39 != null) {
                                    IInterface queryLocalInterface39 = readStrongBinder39.queryLocalInterface("com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks");
                                    if (queryLocalInterface39 instanceof zzdx) {
                                        zzdxVar = (zzdx) queryLocalInterface39;
                                    } else {
                                        zzdxVar = new zzdz(readStrongBinder39);
                                    }
                                }
                                a(zzayVar, zzdxVar);
                                parcel2.writeNoException();
                                return true;
                            case 112:
                                zzba zzbaVar = (zzba) zzc.zza(parcel, zzba.CREATOR);
                                IBinder readStrongBinder40 = parcel.readStrongBinder();
                                if (readStrongBinder40 != null) {
                                    IInterface queryLocalInterface40 = readStrongBinder40.queryLocalInterface("com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks");
                                    if (queryLocalInterface40 instanceof zzdx) {
                                        zzdxVar = (zzdx) queryLocalInterface40;
                                    } else {
                                        zzdxVar = new zzdz(readStrongBinder40);
                                    }
                                }
                                a(zzbaVar, zzdxVar);
                                parcel2.writeNoException();
                                return true;
                            case 113:
                                zzca zzcaVar = (zzca) zzc.zza(parcel, zzca.CREATOR);
                                IBinder readStrongBinder41 = parcel.readStrongBinder();
                                if (readStrongBinder41 != null) {
                                    IInterface queryLocalInterface41 = readStrongBinder41.queryLocalInterface("com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks");
                                    if (queryLocalInterface41 instanceof zzdx) {
                                        zzdxVar = (zzdx) queryLocalInterface41;
                                    } else {
                                        zzdxVar = new zzdz(readStrongBinder41);
                                    }
                                }
                                a(zzcaVar, zzdxVar);
                                parcel2.writeNoException();
                                return true;
                            case 114:
                                zzcc zzccVar = (zzcc) zzc.zza(parcel, zzcc.CREATOR);
                                IBinder readStrongBinder42 = parcel.readStrongBinder();
                                if (readStrongBinder42 != null) {
                                    IInterface queryLocalInterface42 = readStrongBinder42.queryLocalInterface("com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks");
                                    if (queryLocalInterface42 instanceof zzdx) {
                                        zzdxVar = (zzdx) queryLocalInterface42;
                                    } else {
                                        zzdxVar = new zzdz(readStrongBinder42);
                                    }
                                }
                                a(zzccVar, zzdxVar);
                                parcel2.writeNoException();
                                return true;
                            case 115:
                                zzbe zzbeVar = (zzbe) zzc.zza(parcel, zzbe.CREATOR);
                                IBinder readStrongBinder43 = parcel.readStrongBinder();
                                if (readStrongBinder43 != null) {
                                    IInterface queryLocalInterface43 = readStrongBinder43.queryLocalInterface("com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks");
                                    if (queryLocalInterface43 instanceof zzdx) {
                                        zzdxVar = (zzdx) queryLocalInterface43;
                                    } else {
                                        zzdxVar = new zzdz(readStrongBinder43);
                                    }
                                }
                                a(zzbeVar, zzdxVar);
                                parcel2.writeNoException();
                                return true;
                            case 116:
                                zzbo zzboVar = (zzbo) zzc.zza(parcel, zzbo.CREATOR);
                                IBinder readStrongBinder44 = parcel.readStrongBinder();
                                if (readStrongBinder44 != null) {
                                    IInterface queryLocalInterface44 = readStrongBinder44.queryLocalInterface("com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks");
                                    if (queryLocalInterface44 instanceof zzdx) {
                                        zzdxVar = (zzdx) queryLocalInterface44;
                                    } else {
                                        zzdxVar = new zzdz(readStrongBinder44);
                                    }
                                }
                                a(zzboVar, zzdxVar);
                                parcel2.writeNoException();
                                return true;
                            case 117:
                                zzas zzasVar = (zzas) zzc.zza(parcel, zzas.CREATOR);
                                IBinder readStrongBinder45 = parcel.readStrongBinder();
                                if (readStrongBinder45 != null) {
                                    IInterface queryLocalInterface45 = readStrongBinder45.queryLocalInterface("com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks");
                                    if (queryLocalInterface45 instanceof zzdx) {
                                        zzdxVar = (zzdx) queryLocalInterface45;
                                    } else {
                                        zzdxVar = new zzdz(readStrongBinder45);
                                    }
                                }
                                a(zzasVar, zzdxVar);
                                parcel2.writeNoException();
                                return true;
                            default:
                                switch (i) {
                                    case 119:
                                        com.google.android.gms.internal.firebase_auth.zzam zzamVar = (com.google.android.gms.internal.firebase_auth.zzam) zzc.zza(parcel, com.google.android.gms.internal.firebase_auth.zzam.CREATOR);
                                        IBinder readStrongBinder46 = parcel.readStrongBinder();
                                        if (readStrongBinder46 != null) {
                                            IInterface queryLocalInterface46 = readStrongBinder46.queryLocalInterface("com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks");
                                            if (queryLocalInterface46 instanceof zzdx) {
                                                zzdxVar = (zzdx) queryLocalInterface46;
                                            } else {
                                                zzdxVar = new zzdz(readStrongBinder46);
                                            }
                                        }
                                        a(zzamVar, zzdxVar);
                                        parcel2.writeNoException();
                                        return true;
                                    case 120:
                                        zzag zzagVar = (zzag) zzc.zza(parcel, zzag.CREATOR);
                                        IBinder readStrongBinder47 = parcel.readStrongBinder();
                                        if (readStrongBinder47 != null) {
                                            IInterface queryLocalInterface47 = readStrongBinder47.queryLocalInterface("com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks");
                                            if (queryLocalInterface47 instanceof zzdx) {
                                                zzdxVar = (zzdx) queryLocalInterface47;
                                            } else {
                                                zzdxVar = new zzdz(readStrongBinder47);
                                            }
                                        }
                                        a(zzagVar, zzdxVar);
                                        parcel2.writeNoException();
                                        return true;
                                    case 121:
                                        com.google.android.gms.internal.firebase_auth.zzao zzaoVar = (com.google.android.gms.internal.firebase_auth.zzao) zzc.zza(parcel, com.google.android.gms.internal.firebase_auth.zzao.CREATOR);
                                        IBinder readStrongBinder48 = parcel.readStrongBinder();
                                        if (readStrongBinder48 != null) {
                                            IInterface queryLocalInterface48 = readStrongBinder48.queryLocalInterface("com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks");
                                            if (queryLocalInterface48 instanceof zzdx) {
                                                zzdxVar = (zzdx) queryLocalInterface48;
                                            } else {
                                                zzdxVar = new zzdz(readStrongBinder48);
                                            }
                                        }
                                        a(zzaoVar, zzdxVar);
                                        parcel2.writeNoException();
                                        return true;
                                    case 122:
                                        zzbk zzbkVar = (zzbk) zzc.zza(parcel, zzbk.CREATOR);
                                        IBinder readStrongBinder49 = parcel.readStrongBinder();
                                        if (readStrongBinder49 != null) {
                                            IInterface queryLocalInterface49 = readStrongBinder49.queryLocalInterface("com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks");
                                            if (queryLocalInterface49 instanceof zzdx) {
                                                zzdxVar = (zzdx) queryLocalInterface49;
                                            } else {
                                                zzdxVar = new zzdz(readStrongBinder49);
                                            }
                                        }
                                        a(zzbkVar, zzdxVar);
                                        parcel2.writeNoException();
                                        return true;
                                    case 123:
                                        zzby zzbyVar = (zzby) zzc.zza(parcel, zzby.CREATOR);
                                        IBinder readStrongBinder50 = parcel.readStrongBinder();
                                        if (readStrongBinder50 != null) {
                                            IInterface queryLocalInterface50 = readStrongBinder50.queryLocalInterface("com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks");
                                            if (queryLocalInterface50 instanceof zzdx) {
                                                zzdxVar = (zzdx) queryLocalInterface50;
                                            } else {
                                                zzdxVar = new zzdz(readStrongBinder50);
                                            }
                                        }
                                        a(zzbyVar, zzdxVar);
                                        parcel2.writeNoException();
                                        return true;
                                    case 124:
                                        zzbc zzbcVar = (zzbc) zzc.zza(parcel, zzbc.CREATOR);
                                        IBinder readStrongBinder51 = parcel.readStrongBinder();
                                        if (readStrongBinder51 != null) {
                                            IInterface queryLocalInterface51 = readStrongBinder51.queryLocalInterface("com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks");
                                            if (queryLocalInterface51 instanceof zzdx) {
                                                zzdxVar = (zzdx) queryLocalInterface51;
                                            } else {
                                                zzdxVar = new zzdz(readStrongBinder51);
                                            }
                                        }
                                        a(zzbcVar, zzdxVar);
                                        parcel2.writeNoException();
                                        return true;
                                    default:
                                        switch (i) {
                                            case 126:
                                                zzbg zzbgVar = (zzbg) zzc.zza(parcel, zzbg.CREATOR);
                                                IBinder readStrongBinder52 = parcel.readStrongBinder();
                                                if (readStrongBinder52 != null) {
                                                    IInterface queryLocalInterface52 = readStrongBinder52.queryLocalInterface("com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks");
                                                    if (queryLocalInterface52 instanceof zzdx) {
                                                        zzdxVar = (zzdx) queryLocalInterface52;
                                                    } else {
                                                        zzdxVar = new zzdz(readStrongBinder52);
                                                    }
                                                }
                                                a(zzbgVar, zzdxVar);
                                                parcel2.writeNoException();
                                                return true;
                                            case 127:
                                                zzbm zzbmVar = (zzbm) zzc.zza(parcel, zzbm.CREATOR);
                                                IBinder readStrongBinder53 = parcel.readStrongBinder();
                                                if (readStrongBinder53 != null) {
                                                    IInterface queryLocalInterface53 = readStrongBinder53.queryLocalInterface("com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks");
                                                    if (queryLocalInterface53 instanceof zzdx) {
                                                        zzdxVar = (zzdx) queryLocalInterface53;
                                                    } else {
                                                        zzdxVar = new zzdz(readStrongBinder53);
                                                    }
                                                }
                                                a(zzbmVar, zzdxVar);
                                                parcel2.writeNoException();
                                                return true;
                                            case 128:
                                                zzbi zzbiVar = (zzbi) zzc.zza(parcel, zzbi.CREATOR);
                                                IBinder readStrongBinder54 = parcel.readStrongBinder();
                                                if (readStrongBinder54 != null) {
                                                    IInterface queryLocalInterface54 = readStrongBinder54.queryLocalInterface("com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks");
                                                    if (queryLocalInterface54 instanceof zzdx) {
                                                        zzdxVar = (zzdx) queryLocalInterface54;
                                                    } else {
                                                        zzdxVar = new zzdz(readStrongBinder54);
                                                    }
                                                }
                                                a(zzbiVar, zzdxVar);
                                                parcel2.writeNoException();
                                                return true;
                                            case 129:
                                                zzbw zzbwVar = (zzbw) zzc.zza(parcel, zzbw.CREATOR);
                                                IBinder readStrongBinder55 = parcel.readStrongBinder();
                                                if (readStrongBinder55 != null) {
                                                    IInterface queryLocalInterface55 = readStrongBinder55.queryLocalInterface("com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks");
                                                    if (queryLocalInterface55 instanceof zzdx) {
                                                        zzdxVar = (zzdx) queryLocalInterface55;
                                                    } else {
                                                        zzdxVar = new zzdz(readStrongBinder55);
                                                    }
                                                }
                                                a(zzbwVar, zzdxVar);
                                                parcel2.writeNoException();
                                                return true;
                                            default:
                                                return false;
                                        }
                                }
                        }
                }
        }
    }
}
