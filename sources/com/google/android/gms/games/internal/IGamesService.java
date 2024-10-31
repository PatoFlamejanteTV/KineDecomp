package com.google.android.gms.games.internal;

import android.content.Intent;
import android.net.Uri;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.RemoteException;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.Contents;
import com.google.android.gms.games.PlayerEntity;
import com.google.android.gms.games.achievement.AchievementEntity;
import com.google.android.gms.games.internal.IGamesCallbacks;
import com.google.android.gms.games.internal.IGamesClient;
import com.google.android.gms.games.internal.multiplayer.ZInvitationCluster;
import com.google.android.gms.games.internal.request.GameRequestCluster;
import com.google.android.gms.games.multiplayer.ParticipantEntity;
import com.google.android.gms.games.multiplayer.ParticipantResult;
import com.google.android.gms.games.multiplayer.realtime.RoomEntity;
import com.google.android.gms.games.snapshot.SnapshotMetadataChangeEntity;
import com.xiaomi.gamecenter.sdk.MiErrorCode;
import com.xiaomi.licensinglibrary.LicenseErrCode;

/* loaded from: classes.dex */
public interface IGamesService extends IInterface {

    /* loaded from: classes.dex */
    public static abstract class Stub extends Binder implements IGamesService {

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes.dex */
        public static class a implements IGamesService {

            /* renamed from: a */
            private IBinder f1363a;

            a(IBinder iBinder) {
                this.f1363a = iBinder;
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public Intent A() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    this.f1363a.transact(16001, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? (Intent) Intent.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public int a(IGamesCallbacks iGamesCallbacks, byte[] bArr, String str, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeByteArray(bArr);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    this.f1363a.transact(5033, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public int a(byte[] bArr, String str, String[] strArr) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeByteArray(bArr);
                    obtain.writeString(str);
                    obtain.writeStringArray(strArr);
                    this.f1363a.transact(5034, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public Intent a(int i, int i2, boolean z) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    obtain.writeInt(z ? 1 : 0);
                    this.f1363a.transact(9008, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? (Intent) Intent.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public Intent a(int i, byte[] bArr, int i2, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeInt(i);
                    obtain.writeByteArray(bArr);
                    obtain.writeInt(i2);
                    obtain.writeString(str);
                    this.f1363a.transact(10012, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? (Intent) Intent.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public Intent a(PlayerEntity playerEntity) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    if (playerEntity != null) {
                        obtain.writeInt(1);
                        playerEntity.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f1363a.transact(15503, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? (Intent) Intent.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public Intent a(AchievementEntity achievementEntity) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    if (achievementEntity != null) {
                        obtain.writeInt(1);
                        achievementEntity.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f1363a.transact(13005, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? (Intent) Intent.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public Intent a(ZInvitationCluster zInvitationCluster, String str, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    if (zInvitationCluster != null) {
                        obtain.writeInt(1);
                        zInvitationCluster.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    this.f1363a.transact(10021, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? (Intent) Intent.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public Intent a(GameRequestCluster gameRequestCluster, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    if (gameRequestCluster != null) {
                        obtain.writeInt(1);
                        gameRequestCluster.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeString(str);
                    this.f1363a.transact(10022, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? (Intent) Intent.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public Intent a(RoomEntity roomEntity, int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    if (roomEntity != null) {
                        obtain.writeInt(1);
                        roomEntity.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeInt(i);
                    this.f1363a.transact(9011, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? (Intent) Intent.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public Intent a(String str, int i, int i2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    this.f1363a.transact(18001, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? (Intent) Intent.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public Intent a(String str, boolean z, boolean z2, int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeString(str);
                    obtain.writeInt(z ? 1 : 0);
                    obtain.writeInt(z2 ? 1 : 0);
                    obtain.writeInt(i);
                    this.f1363a.transact(12001, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? (Intent) Intent.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public Intent a(int[] iArr) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeIntArray(iArr);
                    this.f1363a.transact(12030, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? (Intent) Intent.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public Intent a(ParticipantEntity[] participantEntityArr, String str, String str2, Uri uri, Uri uri2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeTypedArray(participantEntityArr, 0);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    if (uri != null) {
                        obtain.writeInt(1);
                        uri.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (uri2 != null) {
                        obtain.writeInt(1);
                        uri2.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f1363a.transact(9031, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? (Intent) Intent.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public Intent a(ParticipantEntity[] participantEntityArr, String str, String str2, Uri uri, Uri uri2, String str3) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeTypedArray(participantEntityArr, 0);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    if (uri != null) {
                        obtain.writeInt(1);
                        uri.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (uri2 != null) {
                        obtain.writeInt(1);
                        uri2.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeString(str3);
                    this.f1363a.transact(14003, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? (Intent) Intent.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public ParcelFileDescriptor a(Uri uri) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    if (uri != null) {
                        obtain.writeInt(1);
                        uri.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f1363a.transact(6507, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? (ParcelFileDescriptor) ParcelFileDescriptor.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public String a() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    this.f1363a.transact(LicenseErrCode.ERROR_BUY_LICENSE_CREATECPCORDERERROR, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public String a(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeString(str);
                    this.f1363a.transact(5064, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public void a(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeInt(i);
                    this.f1363a.transact(5036, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public void a(long j) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeLong(j);
                    this.f1363a.transact(LicenseErrCode.ERROR_BUY_LICENSE_PARAMERROR, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public void a(long j, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeLong(j);
                    obtain.writeString(str);
                    this.f1363a.transact(8019, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public void a(IBinder iBinder, Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iBinder);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f1363a.transact(LicenseErrCode.ERROR_BUY_LICENSE_CREATECPORDER_SUCCESS, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public void a(Contents contents) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    if (contents != null) {
                        obtain.writeInt(1);
                        contents.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f1363a.transact(12019, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public void a(IGamesCallbacks iGamesCallbacks) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    this.f1363a.transact(LicenseErrCode.ERROR_BUY_LICENSE_LOGINERROR, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public void a(IGamesCallbacks iGamesCallbacks, int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeInt(i);
                    this.f1363a.transact(10016, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public void a(IGamesCallbacks iGamesCallbacks, int i, int i2, int i3) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    obtain.writeInt(i3);
                    this.f1363a.transact(10009, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public void a(IGamesCallbacks iGamesCallbacks, int i, int i2, boolean z, boolean z2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    obtain.writeInt(z ? 1 : 0);
                    obtain.writeInt(z2 ? 1 : 0);
                    this.f1363a.transact(5044, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public void a(IGamesCallbacks iGamesCallbacks, int i, int i2, String[] strArr, Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    obtain.writeStringArray(strArr);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f1363a.transact(8004, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public void a(IGamesCallbacks iGamesCallbacks, int i, String str, String[] strArr, boolean z) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    obtain.writeStringArray(strArr);
                    obtain.writeInt(z ? 1 : 0);
                    this.f1363a.transact(14002, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public void a(IGamesCallbacks iGamesCallbacks, int i, boolean z, boolean z2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeInt(i);
                    obtain.writeInt(z ? 1 : 0);
                    obtain.writeInt(z2 ? 1 : 0);
                    this.f1363a.transact(5015, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public void a(IGamesCallbacks iGamesCallbacks, int i, int[] iArr) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeInt(i);
                    obtain.writeIntArray(iArr);
                    this.f1363a.transact(10018, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public void a(IGamesCallbacks iGamesCallbacks, long j) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeLong(j);
                    this.f1363a.transact(5058, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public void a(IGamesCallbacks iGamesCallbacks, long j, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeLong(j);
                    obtain.writeString(str);
                    this.f1363a.transact(8018, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public void a(IGamesCallbacks iGamesCallbacks, Bundle bundle, int i, int i2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    this.f1363a.transact(5021, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public void a(IGamesCallbacks iGamesCallbacks, IBinder iBinder, int i, String[] strArr, Bundle bundle, boolean z, long j) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeStrongBinder(iBinder);
                    obtain.writeInt(i);
                    obtain.writeStringArray(strArr);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeInt(z ? 1 : 0);
                    obtain.writeLong(j);
                    this.f1363a.transact(5030, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public void a(IGamesCallbacks iGamesCallbacks, IBinder iBinder, String str, boolean z, long j) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeStrongBinder(iBinder);
                    obtain.writeString(str);
                    obtain.writeInt(z ? 1 : 0);
                    obtain.writeLong(j);
                    this.f1363a.transact(5031, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public void a(IGamesCallbacks iGamesCallbacks, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeString(str);
                    this.f1363a.transact(5014, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public void a(IGamesCallbacks iGamesCallbacks, String str, int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    this.f1363a.transact(10011, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public void a(IGamesCallbacks iGamesCallbacks, String str, int i, int i2, int i3, boolean z) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    obtain.writeInt(i3);
                    obtain.writeInt(z ? 1 : 0);
                    this.f1363a.transact(5019, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public void a(IGamesCallbacks iGamesCallbacks, String str, int i, IBinder iBinder, Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    obtain.writeStrongBinder(iBinder);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f1363a.transact(5025, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public void a(IGamesCallbacks iGamesCallbacks, String str, int i, boolean z) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    obtain.writeInt(z ? 1 : 0);
                    this.f1363a.transact(8023, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public void a(IGamesCallbacks iGamesCallbacks, String str, int i, boolean z, boolean z2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    obtain.writeInt(z ? 1 : 0);
                    obtain.writeInt(z2 ? 1 : 0);
                    this.f1363a.transact(5045, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public void a(IGamesCallbacks iGamesCallbacks, String str, int i, boolean z, boolean z2, boolean z3, boolean z4) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    obtain.writeInt(z ? 1 : 0);
                    obtain.writeInt(z2 ? 1 : 0);
                    obtain.writeInt(z3 ? 1 : 0);
                    obtain.writeInt(z4 ? 1 : 0);
                    this.f1363a.transact(6501, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public void a(IGamesCallbacks iGamesCallbacks, String str, int i, int[] iArr) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    obtain.writeIntArray(iArr);
                    this.f1363a.transact(10019, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public void a(IGamesCallbacks iGamesCallbacks, String str, long j) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeLong(j);
                    this.f1363a.transact(5016, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public void a(IGamesCallbacks iGamesCallbacks, String str, long j, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeLong(j);
                    obtain.writeString(str2);
                    this.f1363a.transact(7002, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public void a(IGamesCallbacks iGamesCallbacks, String str, IBinder iBinder, Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeStrongBinder(iBinder);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f1363a.transact(5023, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public void a(IGamesCallbacks iGamesCallbacks, String str, SnapshotMetadataChangeEntity snapshotMetadataChangeEntity, Contents contents) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeString(str);
                    if (snapshotMetadataChangeEntity != null) {
                        obtain.writeInt(1);
                        snapshotMetadataChangeEntity.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (contents != null) {
                        obtain.writeInt(1);
                        contents.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f1363a.transact(12007, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public void a(IGamesCallbacks iGamesCallbacks, String str, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    this.f1363a.transact(5038, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public void a(IGamesCallbacks iGamesCallbacks, String str, String str2, int i, int i2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    this.f1363a.transact(8001, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public void a(IGamesCallbacks iGamesCallbacks, String str, String str2, int i, int i2, int i3) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    obtain.writeInt(i3);
                    this.f1363a.transact(10010, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public void a(IGamesCallbacks iGamesCallbacks, String str, String str2, int i, int i2, int i3, boolean z) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    obtain.writeInt(i3);
                    obtain.writeInt(z ? 1 : 0);
                    this.f1363a.transact(5039, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public void a(IGamesCallbacks iGamesCallbacks, String str, String str2, int i, boolean z, boolean z2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeInt(i);
                    obtain.writeInt(z ? 1 : 0);
                    obtain.writeInt(z2 ? 1 : 0);
                    this.f1363a.transact(9028, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public void a(IGamesCallbacks iGamesCallbacks, String str, String str2, SnapshotMetadataChangeEntity snapshotMetadataChangeEntity, Contents contents) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    if (snapshotMetadataChangeEntity != null) {
                        obtain.writeInt(1);
                        snapshotMetadataChangeEntity.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (contents != null) {
                        obtain.writeInt(1);
                        contents.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f1363a.transact(12033, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public void a(IGamesCallbacks iGamesCallbacks, String str, String str2, boolean z) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeInt(z ? 1 : 0);
                    this.f1363a.transact(6002, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public void a(IGamesCallbacks iGamesCallbacks, String str, String str2, int[] iArr, int i, boolean z) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeIntArray(iArr);
                    obtain.writeInt(i);
                    obtain.writeInt(z ? 1 : 0);
                    this.f1363a.transact(12015, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public void a(IGamesCallbacks iGamesCallbacks, String str, String str2, String[] strArr) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeStringArray(strArr);
                    this.f1363a.transact(10008, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public void a(IGamesCallbacks iGamesCallbacks, String str, String str2, String[] strArr, boolean z) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeStringArray(strArr);
                    obtain.writeInt(z ? 1 : 0);
                    this.f1363a.transact(12028, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public void a(IGamesCallbacks iGamesCallbacks, String str, boolean z) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeInt(z ? 1 : 0);
                    this.f1363a.transact(5054, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public void a(IGamesCallbacks iGamesCallbacks, String str, boolean z, int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeInt(z ? 1 : 0);
                    obtain.writeInt(i);
                    this.f1363a.transact(15001, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public void a(IGamesCallbacks iGamesCallbacks, String str, byte[] bArr, String str2, ParticipantResult[] participantResultArr) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeByteArray(bArr);
                    obtain.writeString(str2);
                    obtain.writeTypedArray(participantResultArr, 0);
                    this.f1363a.transact(8007, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public void a(IGamesCallbacks iGamesCallbacks, String str, byte[] bArr, ParticipantResult[] participantResultArr) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeByteArray(bArr);
                    obtain.writeTypedArray(participantResultArr, 0);
                    this.f1363a.transact(8008, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public void a(IGamesCallbacks iGamesCallbacks, String str, int[] iArr) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeIntArray(iArr);
                    this.f1363a.transact(8017, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public void a(IGamesCallbacks iGamesCallbacks, String str, String[] strArr, int i, byte[] bArr, int i2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeStringArray(strArr);
                    obtain.writeInt(i);
                    obtain.writeByteArray(bArr);
                    obtain.writeInt(i2);
                    this.f1363a.transact(10005, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public void a(IGamesCallbacks iGamesCallbacks, boolean z) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeInt(z ? 1 : 0);
                    this.f1363a.transact(6001, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public void a(IGamesCallbacks iGamesCallbacks, boolean z, Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeInt(z ? 1 : 0);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f1363a.transact(5063, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public void a(IGamesCallbacks iGamesCallbacks, boolean z, String[] strArr) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeInt(z ? 1 : 0);
                    obtain.writeStringArray(strArr);
                    this.f1363a.transact(12031, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public void a(IGamesCallbacks iGamesCallbacks, int[] iArr) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeIntArray(iArr);
                    this.f1363a.transact(8003, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public void a(IGamesCallbacks iGamesCallbacks, int[] iArr, int i, boolean z) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeIntArray(iArr);
                    obtain.writeInt(i);
                    obtain.writeInt(z ? 1 : 0);
                    this.f1363a.transact(12010, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public void a(IGamesCallbacks iGamesCallbacks, String[] strArr) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeStringArray(strArr);
                    this.f1363a.transact(10006, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public void a(IGamesCallbacks iGamesCallbacks, String[] strArr, boolean z) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeStringArray(strArr);
                    obtain.writeInt(z ? 1 : 0);
                    this.f1363a.transact(12029, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public void a(IGamesClient iGamesClient, long j) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesClient != null ? iGamesClient.asBinder() : null);
                    obtain.writeLong(j);
                    this.f1363a.transact(15501, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public void a(String str, int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    this.f1363a.transact(5028, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public void a(String str, IBinder iBinder, Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeString(str);
                    obtain.writeStrongBinder(iBinder);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f1363a.transact(13002, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public void a(String str, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    this.f1363a.transact(5065, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public void a(String str, String str2, int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeInt(i);
                    this.f1363a.transact(5051, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public void a(boolean z) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeInt(z ? 1 : 0);
                    this.f1363a.transact(5068, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public void a(String[] strArr) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStringArray(strArr);
                    this.f1363a.transact(15002, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f1363a;
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public Intent b(int i, int i2, boolean z) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    obtain.writeInt(z ? 1 : 0);
                    this.f1363a.transact(9009, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? (Intent) Intent.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public Bundle b() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    this.f1363a.transact(LicenseErrCode.ERROR_BUY_LICENSE_HASBUYERERROR, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public String b(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeString(str);
                    this.f1363a.transact(5035, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public void b(long j) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeLong(j);
                    this.f1363a.transact(5059, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public void b(long j, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeLong(j);
                    obtain.writeString(str);
                    this.f1363a.transact(8021, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public void b(IGamesCallbacks iGamesCallbacks) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    this.f1363a.transact(5017, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public void b(IGamesCallbacks iGamesCallbacks, int i, boolean z, boolean z2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeInt(i);
                    obtain.writeInt(z ? 1 : 0);
                    obtain.writeInt(z2 ? 1 : 0);
                    this.f1363a.transact(5046, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public void b(IGamesCallbacks iGamesCallbacks, long j) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeLong(j);
                    this.f1363a.transact(8012, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public void b(IGamesCallbacks iGamesCallbacks, long j, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeLong(j);
                    obtain.writeString(str);
                    this.f1363a.transact(8020, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public void b(IGamesCallbacks iGamesCallbacks, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeString(str);
                    this.f1363a.transact(5018, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public void b(IGamesCallbacks iGamesCallbacks, String str, int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    this.f1363a.transact(12023, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public void b(IGamesCallbacks iGamesCallbacks, String str, int i, int i2, int i3, boolean z) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    obtain.writeInt(i3);
                    obtain.writeInt(z ? 1 : 0);
                    this.f1363a.transact(5020, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public void b(IGamesCallbacks iGamesCallbacks, String str, int i, IBinder iBinder, Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    obtain.writeStrongBinder(iBinder);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f1363a.transact(7003, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public void b(IGamesCallbacks iGamesCallbacks, String str, int i, boolean z) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    obtain.writeInt(z ? 1 : 0);
                    this.f1363a.transact(10017, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public void b(IGamesCallbacks iGamesCallbacks, String str, int i, boolean z, boolean z2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    obtain.writeInt(z ? 1 : 0);
                    obtain.writeInt(z2 ? 1 : 0);
                    this.f1363a.transact(5501, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public void b(IGamesCallbacks iGamesCallbacks, String str, IBinder iBinder, Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeStrongBinder(iBinder);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f1363a.transact(5024, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public void b(IGamesCallbacks iGamesCallbacks, String str, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    this.f1363a.transact(5041, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public void b(IGamesCallbacks iGamesCallbacks, String str, String str2, int i, int i2, int i3, boolean z) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    obtain.writeInt(i3);
                    obtain.writeInt(z ? 1 : 0);
                    this.f1363a.transact(5040, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public void b(IGamesCallbacks iGamesCallbacks, String str, String str2, int i, boolean z, boolean z2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeInt(i);
                    obtain.writeInt(z ? 1 : 0);
                    obtain.writeInt(z2 ? 1 : 0);
                    this.f1363a.transact(12018, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public void b(IGamesCallbacks iGamesCallbacks, String str, String str2, boolean z) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeInt(z ? 1 : 0);
                    this.f1363a.transact(6506, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public void b(IGamesCallbacks iGamesCallbacks, String str, boolean z) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeInt(z ? 1 : 0);
                    this.f1363a.transact(6502, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public void b(IGamesCallbacks iGamesCallbacks, boolean z) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeInt(z ? 1 : 0);
                    this.f1363a.transact(6503, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public void b(IGamesCallbacks iGamesCallbacks, String[] strArr) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeStringArray(strArr);
                    this.f1363a.transact(10007, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public void b(String str, int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    this.f1363a.transact(5029, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public void b(String str, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    this.f1363a.transact(8025, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public void b(String str, String str2, int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeInt(i);
                    this.f1363a.transact(8026, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public void b(boolean z) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeInt(z ? 1 : 0);
                    this.f1363a.transact(12026, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public void c() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    this.f1363a.transact(5006, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public void c(long j) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeLong(j);
                    this.f1363a.transact(8013, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public void c(long j, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeLong(j);
                    obtain.writeString(str);
                    this.f1363a.transact(10004, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public void c(IGamesCallbacks iGamesCallbacks) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    this.f1363a.transact(5022, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public void c(IGamesCallbacks iGamesCallbacks, int i, boolean z, boolean z2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeInt(i);
                    obtain.writeInt(z ? 1 : 0);
                    obtain.writeInt(z2 ? 1 : 0);
                    this.f1363a.transact(5048, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public void c(IGamesCallbacks iGamesCallbacks, long j) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeLong(j);
                    this.f1363a.transact(MiErrorCode.MI_XIAOMI_EXIT, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public void c(IGamesCallbacks iGamesCallbacks, long j, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeLong(j);
                    obtain.writeString(str);
                    this.f1363a.transact(10003, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public void c(IGamesCallbacks iGamesCallbacks, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeString(str);
                    this.f1363a.transact(5032, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public void c(IGamesCallbacks iGamesCallbacks, String str, int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    this.f1363a.transact(12024, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public void c(IGamesCallbacks iGamesCallbacks, String str, int i, boolean z, boolean z2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    obtain.writeInt(z ? 1 : 0);
                    obtain.writeInt(z2 ? 1 : 0);
                    this.f1363a.transact(9001, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public void c(IGamesCallbacks iGamesCallbacks, String str, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    this.f1363a.transact(8011, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public void c(IGamesCallbacks iGamesCallbacks, String str, String str2, boolean z) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeInt(z ? 1 : 0);
                    this.f1363a.transact(12003, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public void c(IGamesCallbacks iGamesCallbacks, String str, boolean z) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeInt(z ? 1 : 0);
                    this.f1363a.transact(6504, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public void c(IGamesCallbacks iGamesCallbacks, boolean z) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeInt(z ? 1 : 0);
                    this.f1363a.transact(8027, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public void c(IGamesCallbacks iGamesCallbacks, String[] strArr) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeStringArray(strArr);
                    this.f1363a.transact(10020, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public void c(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeString(str);
                    this.f1363a.transact(5050, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public void c(String str, int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    this.f1363a.transact(5055, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public void c(boolean z) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeInt(z ? 1 : 0);
                    this.f1363a.transact(13001, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public int d(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeString(str);
                    this.f1363a.transact(5060, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public String d() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    this.f1363a.transact(5007, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public void d(long j) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeLong(j);
                    this.f1363a.transact(10002, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public void d(long j, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeLong(j);
                    obtain.writeString(str);
                    this.f1363a.transact(12014, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public void d(IGamesCallbacks iGamesCallbacks) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    this.f1363a.transact(5026, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public void d(IGamesCallbacks iGamesCallbacks, int i, boolean z, boolean z2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeInt(i);
                    obtain.writeInt(z ? 1 : 0);
                    obtain.writeInt(z2 ? 1 : 0);
                    this.f1363a.transact(6003, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public void d(IGamesCallbacks iGamesCallbacks, long j) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeLong(j);
                    this.f1363a.transact(12011, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public void d(IGamesCallbacks iGamesCallbacks, long j, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeLong(j);
                    obtain.writeString(str);
                    this.f1363a.transact(12013, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public void d(IGamesCallbacks iGamesCallbacks, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeString(str);
                    this.f1363a.transact(5037, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public void d(IGamesCallbacks iGamesCallbacks, String str, int i, boolean z, boolean z2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    obtain.writeInt(z ? 1 : 0);
                    obtain.writeInt(z2 ? 1 : 0);
                    this.f1363a.transact(9020, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public void d(IGamesCallbacks iGamesCallbacks, String str, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    this.f1363a.transact(8015, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public void d(IGamesCallbacks iGamesCallbacks, String str, boolean z) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeInt(z ? 1 : 0);
                    this.f1363a.transact(6505, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public void d(IGamesCallbacks iGamesCallbacks, boolean z) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeInt(z ? 1 : 0);
                    this.f1363a.transact(12002, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public void d(String str, int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    this.f1363a.transact(10014, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public Uri e(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeString(str);
                    this.f1363a.transact(5066, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? (Uri) Uri.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public String e() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    this.f1363a.transact(5012, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public void e(long j) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeLong(j);
                    this.f1363a.transact(12012, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public void e(IGamesCallbacks iGamesCallbacks) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    this.f1363a.transact(5027, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public void e(IGamesCallbacks iGamesCallbacks, int i, boolean z, boolean z2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeInt(i);
                    obtain.writeInt(z ? 1 : 0);
                    obtain.writeInt(z2 ? 1 : 0);
                    this.f1363a.transact(6004, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public void e(IGamesCallbacks iGamesCallbacks, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeString(str);
                    this.f1363a.transact(5042, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public void e(IGamesCallbacks iGamesCallbacks, String str, int i, boolean z, boolean z2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    obtain.writeInt(z ? 1 : 0);
                    obtain.writeInt(z2 ? 1 : 0);
                    this.f1363a.transact(12021, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public void e(IGamesCallbacks iGamesCallbacks, String str, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    this.f1363a.transact(8016, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public void e(IGamesCallbacks iGamesCallbacks, String str, boolean z) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeInt(z ? 1 : 0);
                    this.f1363a.transact(12006, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public void e(IGamesCallbacks iGamesCallbacks, boolean z) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeInt(z ? 1 : 0);
                    this.f1363a.transact(12032, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public void e(String str, int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    this.f1363a.transact(12017, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public Intent f(String str, int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    this.f1363a.transact(14001, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? (Intent) Intent.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public DataHolder f() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    this.f1363a.transact(5013, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? DataHolder.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public void f(long j) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeLong(j);
                    this.f1363a.transact(15502, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public void f(IGamesCallbacks iGamesCallbacks) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    this.f1363a.transact(5047, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public void f(IGamesCallbacks iGamesCallbacks, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeString(str);
                    this.f1363a.transact(5043, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public void f(IGamesCallbacks iGamesCallbacks, String str, int i, boolean z, boolean z2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    obtain.writeInt(z ? 1 : 0);
                    obtain.writeInt(z2 ? 1 : 0);
                    this.f1363a.transact(12022, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public void f(IGamesCallbacks iGamesCallbacks, String str, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    this.f1363a.transact(12009, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public void f(IGamesCallbacks iGamesCallbacks, String str, boolean z) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeInt(z ? 1 : 0);
                    this.f1363a.transact(13006, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public void f(IGamesCallbacks iGamesCallbacks, boolean z) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeInt(z ? 1 : 0);
                    this.f1363a.transact(12016, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public void f(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeString(str);
                    this.f1363a.transact(8002, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public Intent g(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeString(str);
                    this.f1363a.transact(9004, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? (Intent) Intent.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public void g(IGamesCallbacks iGamesCallbacks) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    this.f1363a.transact(5049, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public void g(IGamesCallbacks iGamesCallbacks, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeString(str);
                    this.f1363a.transact(5052, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public void g(IGamesCallbacks iGamesCallbacks, boolean z) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeInt(z ? 1 : 0);
                    this.f1363a.transact(13003, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public boolean g() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    this.f1363a.transact(5067, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public ParcelFileDescriptor h(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeString(str);
                    this.f1363a.transact(9030, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? (ParcelFileDescriptor) ParcelFileDescriptor.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public DataHolder h() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    this.f1363a.transact(5502, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? DataHolder.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public RoomEntity h(IGamesCallbacks iGamesCallbacks, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeString(str);
                    this.f1363a.transact(5053, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? RoomEntity.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public void h(IGamesCallbacks iGamesCallbacks) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    this.f1363a.transact(5056, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public void h(IGamesCallbacks iGamesCallbacks, boolean z) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeInt(z ? 1 : 0);
                    this.f1363a.transact(13004, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public int i() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    this.f1363a.transact(8024, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public Intent i(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeString(str);
                    this.f1363a.transact(12034, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? (Intent) Intent.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public void i(IGamesCallbacks iGamesCallbacks) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    this.f1363a.transact(5062, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public void i(IGamesCallbacks iGamesCallbacks, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeString(str);
                    this.f1363a.transact(5061, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public void i(IGamesCallbacks iGamesCallbacks, boolean z) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeInt(z ? 1 : 0);
                    this.f1363a.transact(17001, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public void j() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    this.f1363a.transact(8022, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public void j(IGamesCallbacks iGamesCallbacks) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    this.f1363a.transact(11001, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public void j(IGamesCallbacks iGamesCallbacks, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeString(str);
                    this.f1363a.transact(5057, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public Intent k() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    this.f1363a.transact(9003, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? (Intent) Intent.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public void k(IGamesCallbacks iGamesCallbacks, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeString(str);
                    this.f1363a.transact(7001, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public Intent l() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    this.f1363a.transact(9005, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? (Intent) Intent.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public void l(IGamesCallbacks iGamesCallbacks, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeString(str);
                    this.f1363a.transact(8005, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public Intent m() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    this.f1363a.transact(9006, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? (Intent) Intent.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public void m(IGamesCallbacks iGamesCallbacks, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeString(str);
                    this.f1363a.transact(8006, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public Intent n() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    this.f1363a.transact(9007, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? (Intent) Intent.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public void n(IGamesCallbacks iGamesCallbacks, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeString(str);
                    this.f1363a.transact(8009, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public Intent o() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    this.f1363a.transact(9010, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? (Intent) Intent.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public void o(IGamesCallbacks iGamesCallbacks, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeString(str);
                    this.f1363a.transact(8010, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public Intent p() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    this.f1363a.transact(9012, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? (Intent) Intent.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public void p(IGamesCallbacks iGamesCallbacks, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeString(str);
                    this.f1363a.transact(8014, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public Intent q() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    this.f1363a.transact(9013, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? (Intent) Intent.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public void q(IGamesCallbacks iGamesCallbacks, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeString(str);
                    this.f1363a.transact(9002, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public int r() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    this.f1363a.transact(9019, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public void r(IGamesCallbacks iGamesCallbacks, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeString(str);
                    this.f1363a.transact(12020, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public int s() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    this.f1363a.transact(10013, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public void s(IGamesCallbacks iGamesCallbacks, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeString(str);
                    this.f1363a.transact(12005, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public int t() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    this.f1363a.transact(10023, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public void t(IGamesCallbacks iGamesCallbacks, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeString(str);
                    this.f1363a.transact(12027, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public Intent u() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    this.f1363a.transact(10015, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? (Intent) Intent.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public void u(IGamesCallbacks iGamesCallbacks, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeString(str);
                    this.f1363a.transact(12008, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public void v() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    this.f1363a.transact(11002, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public int w() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    this.f1363a.transact(12035, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public int x() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    this.f1363a.transact(12036, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public boolean y() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    this.f1363a.transact(12025, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.games.internal.IGamesService
            public void z() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    this.f1363a.transact(15504, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, "com.google.android.gms.games.internal.IGamesService");
        }

        public static IGamesService a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.games.internal.IGamesService");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof IGamesService)) ? new a(iBinder) : (IGamesService) queryLocalInterface;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            switch (i) {
                case LicenseErrCode.ERROR_BUY_LICENSE_PARAMERROR /* 5001 */:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    a(parcel.readLong());
                    parcel2.writeNoException();
                    return true;
                case LicenseErrCode.ERROR_BUY_LICENSE_LOGINERROR /* 5002 */:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    a(IGamesCallbacks.Stub.a(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case LicenseErrCode.ERROR_BUY_LICENSE_CREATECPCORDERERROR /* 5003 */:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    String a2 = a();
                    parcel2.writeNoException();
                    parcel2.writeString(a2);
                    return true;
                case LicenseErrCode.ERROR_BUY_LICENSE_HASBUYERERROR /* 5004 */:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    Bundle b = b();
                    parcel2.writeNoException();
                    if (b == null) {
                        parcel2.writeInt(0);
                        return true;
                    }
                    parcel2.writeInt(1);
                    b.writeToParcel(parcel2, 1);
                    return true;
                case LicenseErrCode.ERROR_BUY_LICENSE_CREATECPORDER_SUCCESS /* 5005 */:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    a(parcel.readStrongBinder(), parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    return true;
                case 5006:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    c();
                    parcel2.writeNoException();
                    return true;
                case 5007:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    String d = d();
                    parcel2.writeNoException();
                    parcel2.writeString(d);
                    return true;
                case 5012:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    String e = e();
                    parcel2.writeNoException();
                    parcel2.writeString(e);
                    return true;
                case 5013:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    DataHolder f = f();
                    parcel2.writeNoException();
                    if (f == null) {
                        parcel2.writeInt(0);
                        return true;
                    }
                    parcel2.writeInt(1);
                    f.writeToParcel(parcel2, 1);
                    return true;
                case 5014:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    a(IGamesCallbacks.Stub.a(parcel.readStrongBinder()), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 5015:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    a(IGamesCallbacks.Stub.a(parcel.readStrongBinder()), parcel.readInt(), parcel.readInt() != 0, parcel.readInt() != 0);
                    parcel2.writeNoException();
                    return true;
                case 5016:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    a(IGamesCallbacks.Stub.a(parcel.readStrongBinder()), parcel.readString(), parcel.readLong());
                    parcel2.writeNoException();
                    return true;
                case 5017:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    b(IGamesCallbacks.Stub.a(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 5018:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    b(IGamesCallbacks.Stub.a(parcel.readStrongBinder()), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 5019:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    a(IGamesCallbacks.Stub.a(parcel.readStrongBinder()), parcel.readString(), parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt() != 0);
                    parcel2.writeNoException();
                    return true;
                case 5020:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    b(IGamesCallbacks.Stub.a(parcel.readStrongBinder()), parcel.readString(), parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt() != 0);
                    parcel2.writeNoException();
                    return true;
                case 5021:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    a(IGamesCallbacks.Stub.a(parcel.readStrongBinder()), parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null, parcel.readInt(), parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 5022:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    c(IGamesCallbacks.Stub.a(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 5023:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    a(IGamesCallbacks.Stub.a(parcel.readStrongBinder()), parcel.readString(), parcel.readStrongBinder(), parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    return true;
                case 5024:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    b(IGamesCallbacks.Stub.a(parcel.readStrongBinder()), parcel.readString(), parcel.readStrongBinder(), parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    return true;
                case 5025:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    a(IGamesCallbacks.Stub.a(parcel.readStrongBinder()), parcel.readString(), parcel.readInt(), parcel.readStrongBinder(), parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    return true;
                case 5026:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    d(IGamesCallbacks.Stub.a(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 5027:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    e(IGamesCallbacks.Stub.a(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 5028:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    a(parcel.readString(), parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 5029:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    b(parcel.readString(), parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 5030:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    a(IGamesCallbacks.Stub.a(parcel.readStrongBinder()), parcel.readStrongBinder(), parcel.readInt(), parcel.createStringArray(), parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null, parcel.readInt() != 0, parcel.readLong());
                    parcel2.writeNoException();
                    return true;
                case 5031:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    a(IGamesCallbacks.Stub.a(parcel.readStrongBinder()), parcel.readStrongBinder(), parcel.readString(), parcel.readInt() != 0, parcel.readLong());
                    parcel2.writeNoException();
                    return true;
                case 5032:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    c(IGamesCallbacks.Stub.a(parcel.readStrongBinder()), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 5033:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    int a3 = a(IGamesCallbacks.Stub.a(parcel.readStrongBinder()), parcel.createByteArray(), parcel.readString(), parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeInt(a3);
                    return true;
                case 5034:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    int a4 = a(parcel.createByteArray(), parcel.readString(), parcel.createStringArray());
                    parcel2.writeNoException();
                    parcel2.writeInt(a4);
                    return true;
                case 5035:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    String b2 = b(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeString(b2);
                    return true;
                case 5036:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    a(parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 5037:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    d(IGamesCallbacks.Stub.a(parcel.readStrongBinder()), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 5038:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    a(IGamesCallbacks.Stub.a(parcel.readStrongBinder()), parcel.readString(), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 5039:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    a(IGamesCallbacks.Stub.a(parcel.readStrongBinder()), parcel.readString(), parcel.readString(), parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt() != 0);
                    parcel2.writeNoException();
                    return true;
                case 5040:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    b(IGamesCallbacks.Stub.a(parcel.readStrongBinder()), parcel.readString(), parcel.readString(), parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt() != 0);
                    parcel2.writeNoException();
                    return true;
                case 5041:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    b(IGamesCallbacks.Stub.a(parcel.readStrongBinder()), parcel.readString(), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 5042:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    e(IGamesCallbacks.Stub.a(parcel.readStrongBinder()), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 5043:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    f(IGamesCallbacks.Stub.a(parcel.readStrongBinder()), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 5044:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    a(IGamesCallbacks.Stub.a(parcel.readStrongBinder()), parcel.readInt(), parcel.readInt(), parcel.readInt() != 0, parcel.readInt() != 0);
                    parcel2.writeNoException();
                    return true;
                case 5045:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    a(IGamesCallbacks.Stub.a(parcel.readStrongBinder()), parcel.readString(), parcel.readInt(), parcel.readInt() != 0, parcel.readInt() != 0);
                    parcel2.writeNoException();
                    return true;
                case 5046:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    b(IGamesCallbacks.Stub.a(parcel.readStrongBinder()), parcel.readInt(), parcel.readInt() != 0, parcel.readInt() != 0);
                    parcel2.writeNoException();
                    return true;
                case 5047:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    f(IGamesCallbacks.Stub.a(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 5048:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    c(IGamesCallbacks.Stub.a(parcel.readStrongBinder()), parcel.readInt(), parcel.readInt() != 0, parcel.readInt() != 0);
                    parcel2.writeNoException();
                    return true;
                case 5049:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    g(IGamesCallbacks.Stub.a(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 5050:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    c(parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 5051:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    a(parcel.readString(), parcel.readString(), parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 5052:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    g(IGamesCallbacks.Stub.a(parcel.readStrongBinder()), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 5053:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    RoomEntity h = h(IGamesCallbacks.Stub.a(parcel.readStrongBinder()), parcel.readString());
                    parcel2.writeNoException();
                    if (h == null) {
                        parcel2.writeInt(0);
                        return true;
                    }
                    parcel2.writeInt(1);
                    h.writeToParcel(parcel2, 1);
                    return true;
                case 5054:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    a(IGamesCallbacks.Stub.a(parcel.readStrongBinder()), parcel.readString(), parcel.readInt() != 0);
                    parcel2.writeNoException();
                    return true;
                case 5055:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    c(parcel.readString(), parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 5056:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    h(IGamesCallbacks.Stub.a(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 5057:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    j(IGamesCallbacks.Stub.a(parcel.readStrongBinder()), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 5058:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    a(IGamesCallbacks.Stub.a(parcel.readStrongBinder()), parcel.readLong());
                    parcel2.writeNoException();
                    return true;
                case 5059:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    b(parcel.readLong());
                    parcel2.writeNoException();
                    return true;
                case 5060:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    int d2 = d(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeInt(d2);
                    return true;
                case 5061:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    i(IGamesCallbacks.Stub.a(parcel.readStrongBinder()), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 5062:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    i(IGamesCallbacks.Stub.a(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 5063:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    a(IGamesCallbacks.Stub.a(parcel.readStrongBinder()), parcel.readInt() != 0, parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    return true;
                case 5064:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    String a5 = a(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeString(a5);
                    return true;
                case 5065:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    a(parcel.readString(), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 5066:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    Uri e2 = e(parcel.readString());
                    parcel2.writeNoException();
                    if (e2 == null) {
                        parcel2.writeInt(0);
                        return true;
                    }
                    parcel2.writeInt(1);
                    e2.writeToParcel(parcel2, 1);
                    return true;
                case 5067:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    boolean g = g();
                    parcel2.writeNoException();
                    parcel2.writeInt(g ? 1 : 0);
                    return true;
                case 5068:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    a(parcel.readInt() != 0);
                    parcel2.writeNoException();
                    return true;
                case 5501:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    b(IGamesCallbacks.Stub.a(parcel.readStrongBinder()), parcel.readString(), parcel.readInt(), parcel.readInt() != 0, parcel.readInt() != 0);
                    parcel2.writeNoException();
                    return true;
                case 5502:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    DataHolder h2 = h();
                    parcel2.writeNoException();
                    if (h2 == null) {
                        parcel2.writeInt(0);
                        return true;
                    }
                    parcel2.writeInt(1);
                    h2.writeToParcel(parcel2, 1);
                    return true;
                case 6001:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    a(IGamesCallbacks.Stub.a(parcel.readStrongBinder()), parcel.readInt() != 0);
                    parcel2.writeNoException();
                    return true;
                case 6002:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    a(IGamesCallbacks.Stub.a(parcel.readStrongBinder()), parcel.readString(), parcel.readString(), parcel.readInt() != 0);
                    parcel2.writeNoException();
                    return true;
                case 6003:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    d(IGamesCallbacks.Stub.a(parcel.readStrongBinder()), parcel.readInt(), parcel.readInt() != 0, parcel.readInt() != 0);
                    parcel2.writeNoException();
                    return true;
                case 6004:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    e(IGamesCallbacks.Stub.a(parcel.readStrongBinder()), parcel.readInt(), parcel.readInt() != 0, parcel.readInt() != 0);
                    parcel2.writeNoException();
                    return true;
                case 6501:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    a(IGamesCallbacks.Stub.a(parcel.readStrongBinder()), parcel.readString(), parcel.readInt(), parcel.readInt() != 0, parcel.readInt() != 0, parcel.readInt() != 0, parcel.readInt() != 0);
                    parcel2.writeNoException();
                    return true;
                case 6502:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    b(IGamesCallbacks.Stub.a(parcel.readStrongBinder()), parcel.readString(), parcel.readInt() != 0);
                    parcel2.writeNoException();
                    return true;
                case 6503:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    b(IGamesCallbacks.Stub.a(parcel.readStrongBinder()), parcel.readInt() != 0);
                    parcel2.writeNoException();
                    return true;
                case 6504:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    c(IGamesCallbacks.Stub.a(parcel.readStrongBinder()), parcel.readString(), parcel.readInt() != 0);
                    parcel2.writeNoException();
                    return true;
                case 6505:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    d(IGamesCallbacks.Stub.a(parcel.readStrongBinder()), parcel.readString(), parcel.readInt() != 0);
                    parcel2.writeNoException();
                    return true;
                case 6506:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    b(IGamesCallbacks.Stub.a(parcel.readStrongBinder()), parcel.readString(), parcel.readString(), parcel.readInt() != 0);
                    parcel2.writeNoException();
                    return true;
                case 6507:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    ParcelFileDescriptor a6 = a(parcel.readInt() != 0 ? (Uri) Uri.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    if (a6 == null) {
                        parcel2.writeInt(0);
                        return true;
                    }
                    parcel2.writeInt(1);
                    a6.writeToParcel(parcel2, 1);
                    return true;
                case 7001:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    k(IGamesCallbacks.Stub.a(parcel.readStrongBinder()), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 7002:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    a(IGamesCallbacks.Stub.a(parcel.readStrongBinder()), parcel.readString(), parcel.readLong(), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 7003:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    b(IGamesCallbacks.Stub.a(parcel.readStrongBinder()), parcel.readString(), parcel.readInt(), parcel.readStrongBinder(), parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    return true;
                case 8001:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    a(IGamesCallbacks.Stub.a(parcel.readStrongBinder()), parcel.readString(), parcel.readString(), parcel.readInt(), parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 8002:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    f(parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 8003:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    a(IGamesCallbacks.Stub.a(parcel.readStrongBinder()), parcel.createIntArray());
                    parcel2.writeNoException();
                    return true;
                case 8004:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    a(IGamesCallbacks.Stub.a(parcel.readStrongBinder()), parcel.readInt(), parcel.readInt(), parcel.createStringArray(), parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    return true;
                case 8005:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    l(IGamesCallbacks.Stub.a(parcel.readStrongBinder()), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 8006:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    m(IGamesCallbacks.Stub.a(parcel.readStrongBinder()), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 8007:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    a(IGamesCallbacks.Stub.a(parcel.readStrongBinder()), parcel.readString(), parcel.createByteArray(), parcel.readString(), (ParticipantResult[]) parcel.createTypedArray(ParticipantResult.CREATOR));
                    parcel2.writeNoException();
                    return true;
                case 8008:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    a(IGamesCallbacks.Stub.a(parcel.readStrongBinder()), parcel.readString(), parcel.createByteArray(), (ParticipantResult[]) parcel.createTypedArray(ParticipantResult.CREATOR));
                    parcel2.writeNoException();
                    return true;
                case 8009:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    n(IGamesCallbacks.Stub.a(parcel.readStrongBinder()), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 8010:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    o(IGamesCallbacks.Stub.a(parcel.readStrongBinder()), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 8011:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    c(IGamesCallbacks.Stub.a(parcel.readStrongBinder()), parcel.readString(), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 8012:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    b(IGamesCallbacks.Stub.a(parcel.readStrongBinder()), parcel.readLong());
                    parcel2.writeNoException();
                    return true;
                case 8013:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    c(parcel.readLong());
                    parcel2.writeNoException();
                    return true;
                case 8014:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    p(IGamesCallbacks.Stub.a(parcel.readStrongBinder()), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 8015:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    d(IGamesCallbacks.Stub.a(parcel.readStrongBinder()), parcel.readString(), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 8016:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    e(IGamesCallbacks.Stub.a(parcel.readStrongBinder()), parcel.readString(), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 8017:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    a(IGamesCallbacks.Stub.a(parcel.readStrongBinder()), parcel.readString(), parcel.createIntArray());
                    parcel2.writeNoException();
                    return true;
                case 8018:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    a(IGamesCallbacks.Stub.a(parcel.readStrongBinder()), parcel.readLong(), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 8019:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    a(parcel.readLong(), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 8020:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    b(IGamesCallbacks.Stub.a(parcel.readStrongBinder()), parcel.readLong(), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 8021:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    b(parcel.readLong(), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 8022:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    j();
                    parcel2.writeNoException();
                    return true;
                case 8023:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    a(IGamesCallbacks.Stub.a(parcel.readStrongBinder()), parcel.readString(), parcel.readInt(), parcel.readInt() != 0);
                    parcel2.writeNoException();
                    return true;
                case 8024:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    int i3 = i();
                    parcel2.writeNoException();
                    parcel2.writeInt(i3);
                    return true;
                case 8025:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    b(parcel.readString(), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 8026:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    b(parcel.readString(), parcel.readString(), parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 8027:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    c(IGamesCallbacks.Stub.a(parcel.readStrongBinder()), parcel.readInt() != 0);
                    parcel2.writeNoException();
                    return true;
                case 9001:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    c(IGamesCallbacks.Stub.a(parcel.readStrongBinder()), parcel.readString(), parcel.readInt(), parcel.readInt() != 0, parcel.readInt() != 0);
                    parcel2.writeNoException();
                    return true;
                case 9002:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    q(IGamesCallbacks.Stub.a(parcel.readStrongBinder()), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 9003:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    Intent k = k();
                    parcel2.writeNoException();
                    if (k == null) {
                        parcel2.writeInt(0);
                        return true;
                    }
                    parcel2.writeInt(1);
                    k.writeToParcel(parcel2, 1);
                    return true;
                case 9004:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    Intent g2 = g(parcel.readString());
                    parcel2.writeNoException();
                    if (g2 == null) {
                        parcel2.writeInt(0);
                        return true;
                    }
                    parcel2.writeInt(1);
                    g2.writeToParcel(parcel2, 1);
                    return true;
                case 9005:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    Intent l = l();
                    parcel2.writeNoException();
                    if (l == null) {
                        parcel2.writeInt(0);
                        return true;
                    }
                    parcel2.writeInt(1);
                    l.writeToParcel(parcel2, 1);
                    return true;
                case 9006:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    Intent m = m();
                    parcel2.writeNoException();
                    if (m == null) {
                        parcel2.writeInt(0);
                        return true;
                    }
                    parcel2.writeInt(1);
                    m.writeToParcel(parcel2, 1);
                    return true;
                case 9007:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    Intent n = n();
                    parcel2.writeNoException();
                    if (n == null) {
                        parcel2.writeInt(0);
                        return true;
                    }
                    parcel2.writeInt(1);
                    n.writeToParcel(parcel2, 1);
                    return true;
                case 9008:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    Intent a7 = a(parcel.readInt(), parcel.readInt(), parcel.readInt() != 0);
                    parcel2.writeNoException();
                    if (a7 == null) {
                        parcel2.writeInt(0);
                        return true;
                    }
                    parcel2.writeInt(1);
                    a7.writeToParcel(parcel2, 1);
                    return true;
                case 9009:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    Intent b3 = b(parcel.readInt(), parcel.readInt(), parcel.readInt() != 0);
                    parcel2.writeNoException();
                    if (b3 == null) {
                        parcel2.writeInt(0);
                        return true;
                    }
                    parcel2.writeInt(1);
                    b3.writeToParcel(parcel2, 1);
                    return true;
                case 9010:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    Intent o = o();
                    parcel2.writeNoException();
                    if (o == null) {
                        parcel2.writeInt(0);
                        return true;
                    }
                    parcel2.writeInt(1);
                    o.writeToParcel(parcel2, 1);
                    return true;
                case 9011:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    Intent a8 = a(parcel.readInt() != 0 ? RoomEntity.CREATOR.createFromParcel(parcel) : null, parcel.readInt());
                    parcel2.writeNoException();
                    if (a8 == null) {
                        parcel2.writeInt(0);
                        return true;
                    }
                    parcel2.writeInt(1);
                    a8.writeToParcel(parcel2, 1);
                    return true;
                case 9012:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    Intent p = p();
                    parcel2.writeNoException();
                    if (p == null) {
                        parcel2.writeInt(0);
                        return true;
                    }
                    parcel2.writeInt(1);
                    p.writeToParcel(parcel2, 1);
                    return true;
                case 9013:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    Intent q = q();
                    parcel2.writeNoException();
                    if (q == null) {
                        parcel2.writeInt(0);
                        return true;
                    }
                    parcel2.writeInt(1);
                    q.writeToParcel(parcel2, 1);
                    return true;
                case 9019:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    int r = r();
                    parcel2.writeNoException();
                    parcel2.writeInt(r);
                    return true;
                case 9020:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    d(IGamesCallbacks.Stub.a(parcel.readStrongBinder()), parcel.readString(), parcel.readInt(), parcel.readInt() != 0, parcel.readInt() != 0);
                    parcel2.writeNoException();
                    return true;
                case 9028:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    a(IGamesCallbacks.Stub.a(parcel.readStrongBinder()), parcel.readString(), parcel.readString(), parcel.readInt(), parcel.readInt() != 0, parcel.readInt() != 0);
                    parcel2.writeNoException();
                    return true;
                case 9030:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    ParcelFileDescriptor h3 = h(parcel.readString());
                    parcel2.writeNoException();
                    if (h3 == null) {
                        parcel2.writeInt(0);
                        return true;
                    }
                    parcel2.writeInt(1);
                    h3.writeToParcel(parcel2, 1);
                    return true;
                case 9031:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    Intent a9 = a((ParticipantEntity[]) parcel.createTypedArray(ParticipantEntity.CREATOR), parcel.readString(), parcel.readString(), parcel.readInt() != 0 ? (Uri) Uri.CREATOR.createFromParcel(parcel) : null, parcel.readInt() != 0 ? (Uri) Uri.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    if (a9 == null) {
                        parcel2.writeInt(0);
                        return true;
                    }
                    parcel2.writeInt(1);
                    a9.writeToParcel(parcel2, 1);
                    return true;
                case MiErrorCode.MI_XIAOMI_EXIT /* 10001 */:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    c(IGamesCallbacks.Stub.a(parcel.readStrongBinder()), parcel.readLong());
                    parcel2.writeNoException();
                    return true;
                case 10002:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    d(parcel.readLong());
                    parcel2.writeNoException();
                    return true;
                case 10003:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    c(IGamesCallbacks.Stub.a(parcel.readStrongBinder()), parcel.readLong(), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 10004:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    c(parcel.readLong(), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 10005:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    a(IGamesCallbacks.Stub.a(parcel.readStrongBinder()), parcel.readString(), parcel.createStringArray(), parcel.readInt(), parcel.createByteArray(), parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 10006:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    a(IGamesCallbacks.Stub.a(parcel.readStrongBinder()), parcel.createStringArray());
                    parcel2.writeNoException();
                    return true;
                case 10007:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    b(IGamesCallbacks.Stub.a(parcel.readStrongBinder()), parcel.createStringArray());
                    parcel2.writeNoException();
                    return true;
                case 10008:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    a(IGamesCallbacks.Stub.a(parcel.readStrongBinder()), parcel.readString(), parcel.readString(), parcel.createStringArray());
                    parcel2.writeNoException();
                    return true;
                case 10009:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    a(IGamesCallbacks.Stub.a(parcel.readStrongBinder()), parcel.readInt(), parcel.readInt(), parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 10010:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    a(IGamesCallbacks.Stub.a(parcel.readStrongBinder()), parcel.readString(), parcel.readString(), parcel.readInt(), parcel.readInt(), parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 10011:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    a(IGamesCallbacks.Stub.a(parcel.readStrongBinder()), parcel.readString(), parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 10012:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    Intent a10 = a(parcel.readInt(), parcel.createByteArray(), parcel.readInt(), parcel.readString());
                    parcel2.writeNoException();
                    if (a10 == null) {
                        parcel2.writeInt(0);
                        return true;
                    }
                    parcel2.writeInt(1);
                    a10.writeToParcel(parcel2, 1);
                    return true;
                case 10013:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    int s = s();
                    parcel2.writeNoException();
                    parcel2.writeInt(s);
                    return true;
                case 10014:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    d(parcel.readString(), parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 10015:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    Intent u = u();
                    parcel2.writeNoException();
                    if (u == null) {
                        parcel2.writeInt(0);
                        return true;
                    }
                    parcel2.writeInt(1);
                    u.writeToParcel(parcel2, 1);
                    return true;
                case 10016:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    a(IGamesCallbacks.Stub.a(parcel.readStrongBinder()), parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 10017:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    b(IGamesCallbacks.Stub.a(parcel.readStrongBinder()), parcel.readString(), parcel.readInt(), parcel.readInt() != 0);
                    parcel2.writeNoException();
                    return true;
                case 10018:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    a(IGamesCallbacks.Stub.a(parcel.readStrongBinder()), parcel.readInt(), parcel.createIntArray());
                    parcel2.writeNoException();
                    return true;
                case 10019:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    a(IGamesCallbacks.Stub.a(parcel.readStrongBinder()), parcel.readString(), parcel.readInt(), parcel.createIntArray());
                    parcel2.writeNoException();
                    return true;
                case 10020:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    c(IGamesCallbacks.Stub.a(parcel.readStrongBinder()), parcel.createStringArray());
                    parcel2.writeNoException();
                    return true;
                case 10021:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    Intent a11 = a(parcel.readInt() != 0 ? ZInvitationCluster.CREATOR.createFromParcel(parcel) : null, parcel.readString(), parcel.readString());
                    parcel2.writeNoException();
                    if (a11 == null) {
                        parcel2.writeInt(0);
                        return true;
                    }
                    parcel2.writeInt(1);
                    a11.writeToParcel(parcel2, 1);
                    return true;
                case 10022:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    Intent a12 = a(parcel.readInt() != 0 ? GameRequestCluster.CREATOR.createFromParcel(parcel) : null, parcel.readString());
                    parcel2.writeNoException();
                    if (a12 == null) {
                        parcel2.writeInt(0);
                        return true;
                    }
                    parcel2.writeInt(1);
                    a12.writeToParcel(parcel2, 1);
                    return true;
                case 10023:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    int t = t();
                    parcel2.writeNoException();
                    parcel2.writeInt(t);
                    return true;
                case 11001:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    j(IGamesCallbacks.Stub.a(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 11002:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    v();
                    parcel2.writeNoException();
                    return true;
                case 12001:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    Intent a13 = a(parcel.readString(), parcel.readInt() != 0, parcel.readInt() != 0, parcel.readInt());
                    parcel2.writeNoException();
                    if (a13 == null) {
                        parcel2.writeInt(0);
                        return true;
                    }
                    parcel2.writeInt(1);
                    a13.writeToParcel(parcel2, 1);
                    return true;
                case 12002:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    d(IGamesCallbacks.Stub.a(parcel.readStrongBinder()), parcel.readInt() != 0);
                    parcel2.writeNoException();
                    return true;
                case 12003:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    c(IGamesCallbacks.Stub.a(parcel.readStrongBinder()), parcel.readString(), parcel.readString(), parcel.readInt() != 0);
                    parcel2.writeNoException();
                    return true;
                case 12005:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    s(IGamesCallbacks.Stub.a(parcel.readStrongBinder()), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 12006:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    e(IGamesCallbacks.Stub.a(parcel.readStrongBinder()), parcel.readString(), parcel.readInt() != 0);
                    parcel2.writeNoException();
                    return true;
                case 12007:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    a(IGamesCallbacks.Stub.a(parcel.readStrongBinder()), parcel.readString(), parcel.readInt() != 0 ? SnapshotMetadataChangeEntity.CREATOR.createFromParcel(parcel) : null, parcel.readInt() != 0 ? Contents.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    return true;
                case 12008:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    u(IGamesCallbacks.Stub.a(parcel.readStrongBinder()), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 12009:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    f(IGamesCallbacks.Stub.a(parcel.readStrongBinder()), parcel.readString(), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 12010:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    a(IGamesCallbacks.Stub.a(parcel.readStrongBinder()), parcel.createIntArray(), parcel.readInt(), parcel.readInt() != 0);
                    parcel2.writeNoException();
                    return true;
                case 12011:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    d(IGamesCallbacks.Stub.a(parcel.readStrongBinder()), parcel.readLong());
                    parcel2.writeNoException();
                    return true;
                case 12012:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    e(parcel.readLong());
                    parcel2.writeNoException();
                    return true;
                case 12013:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    d(IGamesCallbacks.Stub.a(parcel.readStrongBinder()), parcel.readLong(), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 12014:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    d(parcel.readLong(), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 12015:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    a(IGamesCallbacks.Stub.a(parcel.readStrongBinder()), parcel.readString(), parcel.readString(), parcel.createIntArray(), parcel.readInt(), parcel.readInt() != 0);
                    parcel2.writeNoException();
                    return true;
                case 12016:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    f(IGamesCallbacks.Stub.a(parcel.readStrongBinder()), parcel.readInt() != 0);
                    parcel2.writeNoException();
                    return true;
                case 12017:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    e(parcel.readString(), parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 12018:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    b(IGamesCallbacks.Stub.a(parcel.readStrongBinder()), parcel.readString(), parcel.readString(), parcel.readInt(), parcel.readInt() != 0, parcel.readInt() != 0);
                    parcel2.writeNoException();
                    return true;
                case 12019:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    a(parcel.readInt() != 0 ? Contents.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    return true;
                case 12020:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    r(IGamesCallbacks.Stub.a(parcel.readStrongBinder()), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 12021:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    e(IGamesCallbacks.Stub.a(parcel.readStrongBinder()), parcel.readString(), parcel.readInt(), parcel.readInt() != 0, parcel.readInt() != 0);
                    parcel2.writeNoException();
                    return true;
                case 12022:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    f(IGamesCallbacks.Stub.a(parcel.readStrongBinder()), parcel.readString(), parcel.readInt(), parcel.readInt() != 0, parcel.readInt() != 0);
                    parcel2.writeNoException();
                    return true;
                case 12023:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    b(IGamesCallbacks.Stub.a(parcel.readStrongBinder()), parcel.readString(), parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 12024:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    c(IGamesCallbacks.Stub.a(parcel.readStrongBinder()), parcel.readString(), parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 12025:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    boolean y = y();
                    parcel2.writeNoException();
                    parcel2.writeInt(y ? 1 : 0);
                    return true;
                case 12026:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    b(parcel.readInt() != 0);
                    parcel2.writeNoException();
                    return true;
                case 12027:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    t(IGamesCallbacks.Stub.a(parcel.readStrongBinder()), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 12028:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    a(IGamesCallbacks.Stub.a(parcel.readStrongBinder()), parcel.readString(), parcel.readString(), parcel.createStringArray(), parcel.readInt() != 0);
                    parcel2.writeNoException();
                    return true;
                case 12029:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    a(IGamesCallbacks.Stub.a(parcel.readStrongBinder()), parcel.createStringArray(), parcel.readInt() != 0);
                    parcel2.writeNoException();
                    return true;
                case 12030:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    Intent a14 = a(parcel.createIntArray());
                    parcel2.writeNoException();
                    if (a14 == null) {
                        parcel2.writeInt(0);
                        return true;
                    }
                    parcel2.writeInt(1);
                    a14.writeToParcel(parcel2, 1);
                    return true;
                case 12031:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    a(IGamesCallbacks.Stub.a(parcel.readStrongBinder()), parcel.readInt() != 0, parcel.createStringArray());
                    parcel2.writeNoException();
                    return true;
                case 12032:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    e(IGamesCallbacks.Stub.a(parcel.readStrongBinder()), parcel.readInt() != 0);
                    parcel2.writeNoException();
                    return true;
                case 12033:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    a(IGamesCallbacks.Stub.a(parcel.readStrongBinder()), parcel.readString(), parcel.readString(), parcel.readInt() != 0 ? SnapshotMetadataChangeEntity.CREATOR.createFromParcel(parcel) : null, parcel.readInt() != 0 ? Contents.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    return true;
                case 12034:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    Intent i4 = i(parcel.readString());
                    parcel2.writeNoException();
                    if (i4 == null) {
                        parcel2.writeInt(0);
                        return true;
                    }
                    parcel2.writeInt(1);
                    i4.writeToParcel(parcel2, 1);
                    return true;
                case 12035:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    int w = w();
                    parcel2.writeNoException();
                    parcel2.writeInt(w);
                    return true;
                case 12036:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    int x = x();
                    parcel2.writeNoException();
                    parcel2.writeInt(x);
                    return true;
                case 13001:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    c(parcel.readInt() != 0);
                    parcel2.writeNoException();
                    return true;
                case 13002:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    a(parcel.readString(), parcel.readStrongBinder(), parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    return true;
                case 13003:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    g(IGamesCallbacks.Stub.a(parcel.readStrongBinder()), parcel.readInt() != 0);
                    parcel2.writeNoException();
                    return true;
                case 13004:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    h(IGamesCallbacks.Stub.a(parcel.readStrongBinder()), parcel.readInt() != 0);
                    parcel2.writeNoException();
                    return true;
                case 13005:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    Intent a15 = a(parcel.readInt() != 0 ? AchievementEntity.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    if (a15 == null) {
                        parcel2.writeInt(0);
                        return true;
                    }
                    parcel2.writeInt(1);
                    a15.writeToParcel(parcel2, 1);
                    return true;
                case 13006:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    f(IGamesCallbacks.Stub.a(parcel.readStrongBinder()), parcel.readString(), parcel.readInt() != 0);
                    parcel2.writeNoException();
                    return true;
                case 14001:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    Intent f2 = f(parcel.readString(), parcel.readInt());
                    parcel2.writeNoException();
                    if (f2 == null) {
                        parcel2.writeInt(0);
                        return true;
                    }
                    parcel2.writeInt(1);
                    f2.writeToParcel(parcel2, 1);
                    return true;
                case 14002:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    a(IGamesCallbacks.Stub.a(parcel.readStrongBinder()), parcel.readInt(), parcel.readString(), parcel.createStringArray(), parcel.readInt() != 0);
                    parcel2.writeNoException();
                    return true;
                case 14003:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    Intent a16 = a((ParticipantEntity[]) parcel.createTypedArray(ParticipantEntity.CREATOR), parcel.readString(), parcel.readString(), parcel.readInt() != 0 ? (Uri) Uri.CREATOR.createFromParcel(parcel) : null, parcel.readInt() != 0 ? (Uri) Uri.CREATOR.createFromParcel(parcel) : null, parcel.readString());
                    parcel2.writeNoException();
                    if (a16 == null) {
                        parcel2.writeInt(0);
                        return true;
                    }
                    parcel2.writeInt(1);
                    a16.writeToParcel(parcel2, 1);
                    return true;
                case 15001:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    a(IGamesCallbacks.Stub.a(parcel.readStrongBinder()), parcel.readString(), parcel.readInt() != 0, parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 15002:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    a(parcel.createStringArray());
                    parcel2.writeNoException();
                    return true;
                case 15501:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    a(IGamesClient.Stub.a(parcel.readStrongBinder()), parcel.readLong());
                    parcel2.writeNoException();
                    return true;
                case 15502:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    f(parcel.readLong());
                    parcel2.writeNoException();
                    return true;
                case 15503:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    Intent a17 = a(parcel.readInt() != 0 ? PlayerEntity.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    if (a17 == null) {
                        parcel2.writeInt(0);
                        return true;
                    }
                    parcel2.writeInt(1);
                    a17.writeToParcel(parcel2, 1);
                    return true;
                case 15504:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    z();
                    parcel2.writeNoException();
                    return true;
                case 16001:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    Intent A = A();
                    parcel2.writeNoException();
                    if (A == null) {
                        parcel2.writeInt(0);
                        return true;
                    }
                    parcel2.writeInt(1);
                    A.writeToParcel(parcel2, 1);
                    return true;
                case 17001:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    i(IGamesCallbacks.Stub.a(parcel.readStrongBinder()), parcel.readInt() != 0);
                    parcel2.writeNoException();
                    return true;
                case 18001:
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    Intent a18 = a(parcel.readString(), parcel.readInt(), parcel.readInt());
                    parcel2.writeNoException();
                    if (a18 == null) {
                        parcel2.writeInt(0);
                        return true;
                    }
                    parcel2.writeInt(1);
                    a18.writeToParcel(parcel2, 1);
                    return true;
                case 1598968902:
                    parcel2.writeString("com.google.android.gms.games.internal.IGamesService");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    Intent A() throws RemoteException;

    int a(IGamesCallbacks iGamesCallbacks, byte[] bArr, String str, String str2) throws RemoteException;

    int a(byte[] bArr, String str, String[] strArr) throws RemoteException;

    Intent a(int i, int i2, boolean z) throws RemoteException;

    Intent a(int i, byte[] bArr, int i2, String str) throws RemoteException;

    Intent a(PlayerEntity playerEntity) throws RemoteException;

    Intent a(AchievementEntity achievementEntity) throws RemoteException;

    Intent a(ZInvitationCluster zInvitationCluster, String str, String str2) throws RemoteException;

    Intent a(GameRequestCluster gameRequestCluster, String str) throws RemoteException;

    Intent a(RoomEntity roomEntity, int i) throws RemoteException;

    Intent a(String str, int i, int i2) throws RemoteException;

    Intent a(String str, boolean z, boolean z2, int i) throws RemoteException;

    Intent a(int[] iArr) throws RemoteException;

    Intent a(ParticipantEntity[] participantEntityArr, String str, String str2, Uri uri, Uri uri2) throws RemoteException;

    Intent a(ParticipantEntity[] participantEntityArr, String str, String str2, Uri uri, Uri uri2, String str3) throws RemoteException;

    ParcelFileDescriptor a(Uri uri) throws RemoteException;

    String a() throws RemoteException;

    String a(String str) throws RemoteException;

    void a(int i) throws RemoteException;

    void a(long j) throws RemoteException;

    void a(long j, String str) throws RemoteException;

    void a(IBinder iBinder, Bundle bundle) throws RemoteException;

    void a(Contents contents) throws RemoteException;

    void a(IGamesCallbacks iGamesCallbacks) throws RemoteException;

    void a(IGamesCallbacks iGamesCallbacks, int i) throws RemoteException;

    void a(IGamesCallbacks iGamesCallbacks, int i, int i2, int i3) throws RemoteException;

    void a(IGamesCallbacks iGamesCallbacks, int i, int i2, boolean z, boolean z2) throws RemoteException;

    void a(IGamesCallbacks iGamesCallbacks, int i, int i2, String[] strArr, Bundle bundle) throws RemoteException;

    void a(IGamesCallbacks iGamesCallbacks, int i, String str, String[] strArr, boolean z) throws RemoteException;

    void a(IGamesCallbacks iGamesCallbacks, int i, boolean z, boolean z2) throws RemoteException;

    void a(IGamesCallbacks iGamesCallbacks, int i, int[] iArr) throws RemoteException;

    void a(IGamesCallbacks iGamesCallbacks, long j) throws RemoteException;

    void a(IGamesCallbacks iGamesCallbacks, long j, String str) throws RemoteException;

    void a(IGamesCallbacks iGamesCallbacks, Bundle bundle, int i, int i2) throws RemoteException;

    void a(IGamesCallbacks iGamesCallbacks, IBinder iBinder, int i, String[] strArr, Bundle bundle, boolean z, long j) throws RemoteException;

    void a(IGamesCallbacks iGamesCallbacks, IBinder iBinder, String str, boolean z, long j) throws RemoteException;

    void a(IGamesCallbacks iGamesCallbacks, String str) throws RemoteException;

    void a(IGamesCallbacks iGamesCallbacks, String str, int i) throws RemoteException;

    void a(IGamesCallbacks iGamesCallbacks, String str, int i, int i2, int i3, boolean z) throws RemoteException;

    void a(IGamesCallbacks iGamesCallbacks, String str, int i, IBinder iBinder, Bundle bundle) throws RemoteException;

    void a(IGamesCallbacks iGamesCallbacks, String str, int i, boolean z) throws RemoteException;

    void a(IGamesCallbacks iGamesCallbacks, String str, int i, boolean z, boolean z2) throws RemoteException;

    void a(IGamesCallbacks iGamesCallbacks, String str, int i, boolean z, boolean z2, boolean z3, boolean z4) throws RemoteException;

    void a(IGamesCallbacks iGamesCallbacks, String str, int i, int[] iArr) throws RemoteException;

    void a(IGamesCallbacks iGamesCallbacks, String str, long j) throws RemoteException;

    void a(IGamesCallbacks iGamesCallbacks, String str, long j, String str2) throws RemoteException;

    void a(IGamesCallbacks iGamesCallbacks, String str, IBinder iBinder, Bundle bundle) throws RemoteException;

    void a(IGamesCallbacks iGamesCallbacks, String str, SnapshotMetadataChangeEntity snapshotMetadataChangeEntity, Contents contents) throws RemoteException;

    void a(IGamesCallbacks iGamesCallbacks, String str, String str2) throws RemoteException;

    void a(IGamesCallbacks iGamesCallbacks, String str, String str2, int i, int i2) throws RemoteException;

    void a(IGamesCallbacks iGamesCallbacks, String str, String str2, int i, int i2, int i3) throws RemoteException;

    void a(IGamesCallbacks iGamesCallbacks, String str, String str2, int i, int i2, int i3, boolean z) throws RemoteException;

    void a(IGamesCallbacks iGamesCallbacks, String str, String str2, int i, boolean z, boolean z2) throws RemoteException;

    void a(IGamesCallbacks iGamesCallbacks, String str, String str2, SnapshotMetadataChangeEntity snapshotMetadataChangeEntity, Contents contents) throws RemoteException;

    void a(IGamesCallbacks iGamesCallbacks, String str, String str2, boolean z) throws RemoteException;

    void a(IGamesCallbacks iGamesCallbacks, String str, String str2, int[] iArr, int i, boolean z) throws RemoteException;

    void a(IGamesCallbacks iGamesCallbacks, String str, String str2, String[] strArr) throws RemoteException;

    void a(IGamesCallbacks iGamesCallbacks, String str, String str2, String[] strArr, boolean z) throws RemoteException;

    void a(IGamesCallbacks iGamesCallbacks, String str, boolean z) throws RemoteException;

    void a(IGamesCallbacks iGamesCallbacks, String str, boolean z, int i) throws RemoteException;

    void a(IGamesCallbacks iGamesCallbacks, String str, byte[] bArr, String str2, ParticipantResult[] participantResultArr) throws RemoteException;

    void a(IGamesCallbacks iGamesCallbacks, String str, byte[] bArr, ParticipantResult[] participantResultArr) throws RemoteException;

    void a(IGamesCallbacks iGamesCallbacks, String str, int[] iArr) throws RemoteException;

    void a(IGamesCallbacks iGamesCallbacks, String str, String[] strArr, int i, byte[] bArr, int i2) throws RemoteException;

    void a(IGamesCallbacks iGamesCallbacks, boolean z) throws RemoteException;

    void a(IGamesCallbacks iGamesCallbacks, boolean z, Bundle bundle) throws RemoteException;

    void a(IGamesCallbacks iGamesCallbacks, boolean z, String[] strArr) throws RemoteException;

    void a(IGamesCallbacks iGamesCallbacks, int[] iArr) throws RemoteException;

    void a(IGamesCallbacks iGamesCallbacks, int[] iArr, int i, boolean z) throws RemoteException;

    void a(IGamesCallbacks iGamesCallbacks, String[] strArr) throws RemoteException;

    void a(IGamesCallbacks iGamesCallbacks, String[] strArr, boolean z) throws RemoteException;

    void a(IGamesClient iGamesClient, long j) throws RemoteException;

    void a(String str, int i) throws RemoteException;

    void a(String str, IBinder iBinder, Bundle bundle) throws RemoteException;

    void a(String str, String str2) throws RemoteException;

    void a(String str, String str2, int i) throws RemoteException;

    void a(boolean z) throws RemoteException;

    void a(String[] strArr) throws RemoteException;

    Intent b(int i, int i2, boolean z) throws RemoteException;

    Bundle b() throws RemoteException;

    String b(String str) throws RemoteException;

    void b(long j) throws RemoteException;

    void b(long j, String str) throws RemoteException;

    void b(IGamesCallbacks iGamesCallbacks) throws RemoteException;

    void b(IGamesCallbacks iGamesCallbacks, int i, boolean z, boolean z2) throws RemoteException;

    void b(IGamesCallbacks iGamesCallbacks, long j) throws RemoteException;

    void b(IGamesCallbacks iGamesCallbacks, long j, String str) throws RemoteException;

    void b(IGamesCallbacks iGamesCallbacks, String str) throws RemoteException;

    void b(IGamesCallbacks iGamesCallbacks, String str, int i) throws RemoteException;

    void b(IGamesCallbacks iGamesCallbacks, String str, int i, int i2, int i3, boolean z) throws RemoteException;

    void b(IGamesCallbacks iGamesCallbacks, String str, int i, IBinder iBinder, Bundle bundle) throws RemoteException;

    void b(IGamesCallbacks iGamesCallbacks, String str, int i, boolean z) throws RemoteException;

    void b(IGamesCallbacks iGamesCallbacks, String str, int i, boolean z, boolean z2) throws RemoteException;

    void b(IGamesCallbacks iGamesCallbacks, String str, IBinder iBinder, Bundle bundle) throws RemoteException;

    void b(IGamesCallbacks iGamesCallbacks, String str, String str2) throws RemoteException;

    void b(IGamesCallbacks iGamesCallbacks, String str, String str2, int i, int i2, int i3, boolean z) throws RemoteException;

    void b(IGamesCallbacks iGamesCallbacks, String str, String str2, int i, boolean z, boolean z2) throws RemoteException;

    void b(IGamesCallbacks iGamesCallbacks, String str, String str2, boolean z) throws RemoteException;

    void b(IGamesCallbacks iGamesCallbacks, String str, boolean z) throws RemoteException;

    void b(IGamesCallbacks iGamesCallbacks, boolean z) throws RemoteException;

    void b(IGamesCallbacks iGamesCallbacks, String[] strArr) throws RemoteException;

    void b(String str, int i) throws RemoteException;

    void b(String str, String str2) throws RemoteException;

    void b(String str, String str2, int i) throws RemoteException;

    void b(boolean z) throws RemoteException;

    void c() throws RemoteException;

    void c(long j) throws RemoteException;

    void c(long j, String str) throws RemoteException;

    void c(IGamesCallbacks iGamesCallbacks) throws RemoteException;

    void c(IGamesCallbacks iGamesCallbacks, int i, boolean z, boolean z2) throws RemoteException;

    void c(IGamesCallbacks iGamesCallbacks, long j) throws RemoteException;

    void c(IGamesCallbacks iGamesCallbacks, long j, String str) throws RemoteException;

    void c(IGamesCallbacks iGamesCallbacks, String str) throws RemoteException;

    void c(IGamesCallbacks iGamesCallbacks, String str, int i) throws RemoteException;

    void c(IGamesCallbacks iGamesCallbacks, String str, int i, boolean z, boolean z2) throws RemoteException;

    void c(IGamesCallbacks iGamesCallbacks, String str, String str2) throws RemoteException;

    void c(IGamesCallbacks iGamesCallbacks, String str, String str2, boolean z) throws RemoteException;

    void c(IGamesCallbacks iGamesCallbacks, String str, boolean z) throws RemoteException;

    void c(IGamesCallbacks iGamesCallbacks, boolean z) throws RemoteException;

    void c(IGamesCallbacks iGamesCallbacks, String[] strArr) throws RemoteException;

    void c(String str) throws RemoteException;

    void c(String str, int i) throws RemoteException;

    void c(boolean z) throws RemoteException;

    int d(String str) throws RemoteException;

    String d() throws RemoteException;

    void d(long j) throws RemoteException;

    void d(long j, String str) throws RemoteException;

    void d(IGamesCallbacks iGamesCallbacks) throws RemoteException;

    void d(IGamesCallbacks iGamesCallbacks, int i, boolean z, boolean z2) throws RemoteException;

    void d(IGamesCallbacks iGamesCallbacks, long j) throws RemoteException;

    void d(IGamesCallbacks iGamesCallbacks, long j, String str) throws RemoteException;

    void d(IGamesCallbacks iGamesCallbacks, String str) throws RemoteException;

    void d(IGamesCallbacks iGamesCallbacks, String str, int i, boolean z, boolean z2) throws RemoteException;

    void d(IGamesCallbacks iGamesCallbacks, String str, String str2) throws RemoteException;

    void d(IGamesCallbacks iGamesCallbacks, String str, boolean z) throws RemoteException;

    void d(IGamesCallbacks iGamesCallbacks, boolean z) throws RemoteException;

    void d(String str, int i) throws RemoteException;

    Uri e(String str) throws RemoteException;

    String e() throws RemoteException;

    void e(long j) throws RemoteException;

    void e(IGamesCallbacks iGamesCallbacks) throws RemoteException;

    void e(IGamesCallbacks iGamesCallbacks, int i, boolean z, boolean z2) throws RemoteException;

    void e(IGamesCallbacks iGamesCallbacks, String str) throws RemoteException;

    void e(IGamesCallbacks iGamesCallbacks, String str, int i, boolean z, boolean z2) throws RemoteException;

    void e(IGamesCallbacks iGamesCallbacks, String str, String str2) throws RemoteException;

    void e(IGamesCallbacks iGamesCallbacks, String str, boolean z) throws RemoteException;

    void e(IGamesCallbacks iGamesCallbacks, boolean z) throws RemoteException;

    void e(String str, int i) throws RemoteException;

    Intent f(String str, int i) throws RemoteException;

    DataHolder f() throws RemoteException;

    void f(long j) throws RemoteException;

    void f(IGamesCallbacks iGamesCallbacks) throws RemoteException;

    void f(IGamesCallbacks iGamesCallbacks, String str) throws RemoteException;

    void f(IGamesCallbacks iGamesCallbacks, String str, int i, boolean z, boolean z2) throws RemoteException;

    void f(IGamesCallbacks iGamesCallbacks, String str, String str2) throws RemoteException;

    void f(IGamesCallbacks iGamesCallbacks, String str, boolean z) throws RemoteException;

    void f(IGamesCallbacks iGamesCallbacks, boolean z) throws RemoteException;

    void f(String str) throws RemoteException;

    Intent g(String str) throws RemoteException;

    void g(IGamesCallbacks iGamesCallbacks) throws RemoteException;

    void g(IGamesCallbacks iGamesCallbacks, String str) throws RemoteException;

    void g(IGamesCallbacks iGamesCallbacks, boolean z) throws RemoteException;

    boolean g() throws RemoteException;

    ParcelFileDescriptor h(String str) throws RemoteException;

    DataHolder h() throws RemoteException;

    RoomEntity h(IGamesCallbacks iGamesCallbacks, String str) throws RemoteException;

    void h(IGamesCallbacks iGamesCallbacks) throws RemoteException;

    void h(IGamesCallbacks iGamesCallbacks, boolean z) throws RemoteException;

    int i() throws RemoteException;

    Intent i(String str) throws RemoteException;

    void i(IGamesCallbacks iGamesCallbacks) throws RemoteException;

    void i(IGamesCallbacks iGamesCallbacks, String str) throws RemoteException;

    void i(IGamesCallbacks iGamesCallbacks, boolean z) throws RemoteException;

    void j() throws RemoteException;

    void j(IGamesCallbacks iGamesCallbacks) throws RemoteException;

    void j(IGamesCallbacks iGamesCallbacks, String str) throws RemoteException;

    Intent k() throws RemoteException;

    void k(IGamesCallbacks iGamesCallbacks, String str) throws RemoteException;

    Intent l() throws RemoteException;

    void l(IGamesCallbacks iGamesCallbacks, String str) throws RemoteException;

    Intent m() throws RemoteException;

    void m(IGamesCallbacks iGamesCallbacks, String str) throws RemoteException;

    Intent n() throws RemoteException;

    void n(IGamesCallbacks iGamesCallbacks, String str) throws RemoteException;

    Intent o() throws RemoteException;

    void o(IGamesCallbacks iGamesCallbacks, String str) throws RemoteException;

    Intent p() throws RemoteException;

    void p(IGamesCallbacks iGamesCallbacks, String str) throws RemoteException;

    Intent q() throws RemoteException;

    void q(IGamesCallbacks iGamesCallbacks, String str) throws RemoteException;

    int r() throws RemoteException;

    void r(IGamesCallbacks iGamesCallbacks, String str) throws RemoteException;

    int s() throws RemoteException;

    void s(IGamesCallbacks iGamesCallbacks, String str) throws RemoteException;

    int t() throws RemoteException;

    void t(IGamesCallbacks iGamesCallbacks, String str) throws RemoteException;

    Intent u() throws RemoteException;

    void u(IGamesCallbacks iGamesCallbacks, String str) throws RemoteException;

    void v() throws RemoteException;

    int w() throws RemoteException;

    int x() throws RemoteException;

    boolean y() throws RemoteException;

    void z() throws RemoteException;
}
