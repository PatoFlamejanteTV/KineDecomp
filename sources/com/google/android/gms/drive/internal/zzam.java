package com.google.android.gms.drive.internal;

import android.content.IntentSender;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.drive.RealtimeDocumentSyncRequest;
import com.google.android.gms.drive.internal.zzan;
import com.google.android.gms.drive.internal.zzao;

/* loaded from: classes2.dex */
public interface zzam extends IInterface {

    /* loaded from: classes2.dex */
    public static abstract class zza extends Binder implements zzam {

        /* loaded from: classes2.dex */
        public static class a implements zzam {

            /* renamed from: a */
            private IBinder f1132a;

            a(IBinder iBinder) {
                this.f1132a = iBinder;
            }

            @Override // com.google.android.gms.drive.internal.zzam
            public IntentSender a(CreateFileIntentSenderRequest createFileIntentSenderRequest) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (createFileIntentSenderRequest != null) {
                        obtain.writeInt(1);
                        createFileIntentSenderRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f1132a.transact(11, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? (IntentSender) IntentSender.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.drive.internal.zzam
            public IntentSender a(OpenFileIntentSenderRequest openFileIntentSenderRequest) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (openFileIntentSenderRequest != null) {
                        obtain.writeInt(1);
                        openFileIntentSenderRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f1132a.transact(10, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? (IntentSender) IntentSender.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.drive.internal.zzam
            public DriveServiceResponse a(OpenContentsRequest openContentsRequest, zzan zzanVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (openContentsRequest != null) {
                        obtain.writeInt(1);
                        openContentsRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(zzanVar != null ? zzanVar.asBinder() : null);
                    this.f1132a.transact(7, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? DriveServiceResponse.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.drive.internal.zzam
            public DriveServiceResponse a(StreamContentsRequest streamContentsRequest, zzan zzanVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (streamContentsRequest != null) {
                        obtain.writeInt(1);
                        streamContentsRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(zzanVar != null ? zzanVar.asBinder() : null);
                    this.f1132a.transact(56, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? DriveServiceResponse.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.drive.internal.zzam
            public void a(RealtimeDocumentSyncRequest realtimeDocumentSyncRequest, zzan zzanVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (realtimeDocumentSyncRequest != null) {
                        obtain.writeInt(1);
                        realtimeDocumentSyncRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(zzanVar != null ? zzanVar.asBinder() : null);
                    this.f1132a.transact(34, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.drive.internal.zzam
            public void a(AddEventListenerRequest addEventListenerRequest, zzao zzaoVar, String str, zzan zzanVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (addEventListenerRequest != null) {
                        obtain.writeInt(1);
                        addEventListenerRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(zzaoVar != null ? zzaoVar.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeStrongBinder(zzanVar != null ? zzanVar.asBinder() : null);
                    this.f1132a.transact(14, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.drive.internal.zzam
            public void a(AddPermissionRequest addPermissionRequest, zzan zzanVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (addPermissionRequest != null) {
                        obtain.writeInt(1);
                        addPermissionRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(zzanVar != null ? zzanVar.asBinder() : null);
                    this.f1132a.transact(48, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.drive.internal.zzam
            public void a(AuthorizeAccessRequest authorizeAccessRequest, zzan zzanVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (authorizeAccessRequest != null) {
                        obtain.writeInt(1);
                        authorizeAccessRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(zzanVar != null ? zzanVar.asBinder() : null);
                    this.f1132a.transact(12, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.drive.internal.zzam
            public void a(CancelPendingActionsRequest cancelPendingActionsRequest, zzan zzanVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (cancelPendingActionsRequest != null) {
                        obtain.writeInt(1);
                        cancelPendingActionsRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(zzanVar != null ? zzanVar.asBinder() : null);
                    this.f1132a.transact(37, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.drive.internal.zzam
            public void a(ChangeResourceParentsRequest changeResourceParentsRequest, zzan zzanVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (changeResourceParentsRequest != null) {
                        obtain.writeInt(1);
                        changeResourceParentsRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(zzanVar != null ? zzanVar.asBinder() : null);
                    this.f1132a.transact(55, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.drive.internal.zzam
            public void a(CheckResourceIdsExistRequest checkResourceIdsExistRequest, zzan zzanVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (checkResourceIdsExistRequest != null) {
                        obtain.writeInt(1);
                        checkResourceIdsExistRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(zzanVar != null ? zzanVar.asBinder() : null);
                    this.f1132a.transact(30, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.drive.internal.zzam
            public void a(CloseContentsAndUpdateMetadataRequest closeContentsAndUpdateMetadataRequest, zzan zzanVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (closeContentsAndUpdateMetadataRequest != null) {
                        obtain.writeInt(1);
                        closeContentsAndUpdateMetadataRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(zzanVar != null ? zzanVar.asBinder() : null);
                    this.f1132a.transact(18, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.drive.internal.zzam
            public void a(CloseContentsRequest closeContentsRequest, zzan zzanVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (closeContentsRequest != null) {
                        obtain.writeInt(1);
                        closeContentsRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(zzanVar != null ? zzanVar.asBinder() : null);
                    this.f1132a.transact(8, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.drive.internal.zzam
            public void a(ControlProgressRequest controlProgressRequest, zzan zzanVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (controlProgressRequest != null) {
                        obtain.writeInt(1);
                        controlProgressRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(zzanVar != null ? zzanVar.asBinder() : null);
                    this.f1132a.transact(53, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.drive.internal.zzam
            public void a(CreateContentsRequest createContentsRequest, zzan zzanVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (createContentsRequest != null) {
                        obtain.writeInt(1);
                        createContentsRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(zzanVar != null ? zzanVar.asBinder() : null);
                    this.f1132a.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.drive.internal.zzam
            public void a(CreateFileRequest createFileRequest, zzan zzanVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (createFileRequest != null) {
                        obtain.writeInt(1);
                        createFileRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(zzanVar != null ? zzanVar.asBinder() : null);
                    this.f1132a.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.drive.internal.zzam
            public void a(CreateFolderRequest createFolderRequest, zzan zzanVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (createFolderRequest != null) {
                        obtain.writeInt(1);
                        createFolderRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(zzanVar != null ? zzanVar.asBinder() : null);
                    this.f1132a.transact(6, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.drive.internal.zzam
            public void a(DeleteResourceRequest deleteResourceRequest, zzan zzanVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (deleteResourceRequest != null) {
                        obtain.writeInt(1);
                        deleteResourceRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(zzanVar != null ? zzanVar.asBinder() : null);
                    this.f1132a.transact(24, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.drive.internal.zzam
            public void a(DisconnectRequest disconnectRequest) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (disconnectRequest != null) {
                        obtain.writeInt(1);
                        disconnectRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f1132a.transact(16, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.drive.internal.zzam
            public void a(FetchThumbnailRequest fetchThumbnailRequest, zzan zzanVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (fetchThumbnailRequest != null) {
                        obtain.writeInt(1);
                        fetchThumbnailRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(zzanVar != null ? zzanVar.asBinder() : null);
                    this.f1132a.transact(42, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.drive.internal.zzam
            public void a(GetChangesRequest getChangesRequest, zzan zzanVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (getChangesRequest != null) {
                        obtain.writeInt(1);
                        getChangesRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(zzanVar != null ? zzanVar.asBinder() : null);
                    this.f1132a.transact(44, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.drive.internal.zzam
            public void a(GetDriveIdFromUniqueIdentifierRequest getDriveIdFromUniqueIdentifierRequest, zzan zzanVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (getDriveIdFromUniqueIdentifierRequest != null) {
                        obtain.writeInt(1);
                        getDriveIdFromUniqueIdentifierRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(zzanVar != null ? zzanVar.asBinder() : null);
                    this.f1132a.transact(29, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.drive.internal.zzam
            public void a(GetMetadataRequest getMetadataRequest, zzan zzanVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (getMetadataRequest != null) {
                        obtain.writeInt(1);
                        getMetadataRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(zzanVar != null ? zzanVar.asBinder() : null);
                    this.f1132a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.drive.internal.zzam
            public void a(GetPermissionsRequest getPermissionsRequest, zzan zzanVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (getPermissionsRequest != null) {
                        obtain.writeInt(1);
                        getPermissionsRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(zzanVar != null ? zzanVar.asBinder() : null);
                    this.f1132a.transact(47, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.drive.internal.zzam
            public void a(ListParentsRequest listParentsRequest, zzan zzanVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (listParentsRequest != null) {
                        obtain.writeInt(1);
                        listParentsRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(zzanVar != null ? zzanVar.asBinder() : null);
                    this.f1132a.transact(13, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.drive.internal.zzam
            public void a(LoadRealtimeRequest loadRealtimeRequest, zzan zzanVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (loadRealtimeRequest != null) {
                        obtain.writeInt(1);
                        loadRealtimeRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(zzanVar != null ? zzanVar.asBinder() : null);
                    this.f1132a.transact(27, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.drive.internal.zzam
            public void a(QueryRequest queryRequest, zzan zzanVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (queryRequest != null) {
                        obtain.writeInt(1);
                        queryRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(zzanVar != null ? zzanVar.asBinder() : null);
                    this.f1132a.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.drive.internal.zzam
            public void a(QueryRequest queryRequest, zzao zzaoVar, zzan zzanVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (queryRequest != null) {
                        obtain.writeInt(1);
                        queryRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(zzaoVar != null ? zzaoVar.asBinder() : null);
                    obtain.writeStrongBinder(zzanVar != null ? zzanVar.asBinder() : null);
                    this.f1132a.transact(51, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.drive.internal.zzam
            public void a(RemoveEventListenerRequest removeEventListenerRequest, zzao zzaoVar, String str, zzan zzanVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (removeEventListenerRequest != null) {
                        obtain.writeInt(1);
                        removeEventListenerRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(zzaoVar != null ? zzaoVar.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeStrongBinder(zzanVar != null ? zzanVar.asBinder() : null);
                    this.f1132a.transact(15, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.drive.internal.zzam
            public void a(RemovePermissionRequest removePermissionRequest, zzan zzanVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (removePermissionRequest != null) {
                        obtain.writeInt(1);
                        removePermissionRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(zzanVar != null ? zzanVar.asBinder() : null);
                    this.f1132a.transact(50, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.drive.internal.zzam
            public void a(SetDrivePreferencesRequest setDrivePreferencesRequest, zzan zzanVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (setDrivePreferencesRequest != null) {
                        obtain.writeInt(1);
                        setDrivePreferencesRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(zzanVar != null ? zzanVar.asBinder() : null);
                    this.f1132a.transact(33, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.drive.internal.zzam
            public void a(SetFileUploadPreferencesRequest setFileUploadPreferencesRequest, zzan zzanVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (setFileUploadPreferencesRequest != null) {
                        obtain.writeInt(1);
                        setFileUploadPreferencesRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(zzanVar != null ? zzanVar.asBinder() : null);
                    this.f1132a.transact(36, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.drive.internal.zzam
            public void a(SetResourceParentsRequest setResourceParentsRequest, zzan zzanVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (setResourceParentsRequest != null) {
                        obtain.writeInt(1);
                        setResourceParentsRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(zzanVar != null ? zzanVar.asBinder() : null);
                    this.f1132a.transact(28, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.drive.internal.zzam
            public void a(TrashResourceRequest trashResourceRequest, zzan zzanVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (trashResourceRequest != null) {
                        obtain.writeInt(1);
                        trashResourceRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(zzanVar != null ? zzanVar.asBinder() : null);
                    this.f1132a.transact(17, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.drive.internal.zzam
            public void a(UnsubscribeResourceRequest unsubscribeResourceRequest, zzan zzanVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (unsubscribeResourceRequest != null) {
                        obtain.writeInt(1);
                        unsubscribeResourceRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(zzanVar != null ? zzanVar.asBinder() : null);
                    this.f1132a.transact(46, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.drive.internal.zzam
            public void a(UntrashResourceRequest untrashResourceRequest, zzan zzanVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (untrashResourceRequest != null) {
                        obtain.writeInt(1);
                        untrashResourceRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(zzanVar != null ? zzanVar.asBinder() : null);
                    this.f1132a.transact(38, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.drive.internal.zzam
            public void a(UpdateMetadataRequest updateMetadataRequest, zzan zzanVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (updateMetadataRequest != null) {
                        obtain.writeInt(1);
                        updateMetadataRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(zzanVar != null ? zzanVar.asBinder() : null);
                    this.f1132a.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.drive.internal.zzam
            public void a(UpdatePermissionRequest updatePermissionRequest, zzan zzanVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (updatePermissionRequest != null) {
                        obtain.writeInt(1);
                        updatePermissionRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(zzanVar != null ? zzanVar.asBinder() : null);
                    this.f1132a.transact(49, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.drive.internal.zzam
            public void a(zzan zzanVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    obtain.writeStrongBinder(zzanVar != null ? zzanVar.asBinder() : null);
                    this.f1132a.transact(9, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.drive.internal.zzam
            public void a(zzao zzaoVar, zzan zzanVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    obtain.writeStrongBinder(zzaoVar != null ? zzaoVar.asBinder() : null);
                    obtain.writeStrongBinder(zzanVar != null ? zzanVar.asBinder() : null);
                    this.f1132a.transact(52, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f1132a;
            }

            @Override // com.google.android.gms.drive.internal.zzam
            public void b(QueryRequest queryRequest, zzan zzanVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (queryRequest != null) {
                        obtain.writeInt(1);
                        queryRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(zzanVar != null ? zzanVar.asBinder() : null);
                    this.f1132a.transact(19, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.drive.internal.zzam
            public void b(zzan zzanVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    obtain.writeStrongBinder(zzanVar != null ? zzanVar.asBinder() : null);
                    this.f1132a.transact(31, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.drive.internal.zzam
            public void c(zzan zzanVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    obtain.writeStrongBinder(zzanVar != null ? zzanVar.asBinder() : null);
                    this.f1132a.transact(32, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.drive.internal.zzam
            public void d(zzan zzanVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    obtain.writeStrongBinder(zzanVar != null ? zzanVar.asBinder() : null);
                    this.f1132a.transact(35, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.drive.internal.zzam
            public void e(zzan zzanVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    obtain.writeStrongBinder(zzanVar != null ? zzanVar.asBinder() : null);
                    this.f1132a.transact(41, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.drive.internal.zzam
            public void f(zzan zzanVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    obtain.writeStrongBinder(zzanVar != null ? zzanVar.asBinder() : null);
                    this.f1132a.transact(43, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.android.gms.drive.internal.zzam
            public void g(zzan zzanVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    obtain.writeStrongBinder(zzanVar != null ? zzanVar.asBinder() : null);
                    this.f1132a.transact(54, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static zzam a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.drive.internal.IDriveService");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zzam)) ? new a(iBinder) : (zzam) queryLocalInterface;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            switch (i) {
                case 1:
                    parcel.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
                    a(parcel.readInt() != 0 ? GetMetadataRequest.CREATOR.createFromParcel(parcel) : null, zzan.zza.a(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 2:
                    parcel.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
                    a(parcel.readInt() != 0 ? QueryRequest.CREATOR.createFromParcel(parcel) : null, zzan.zza.a(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 3:
                    parcel.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
                    a(parcel.readInt() != 0 ? UpdateMetadataRequest.CREATOR.createFromParcel(parcel) : null, zzan.zza.a(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 4:
                    parcel.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
                    a(parcel.readInt() != 0 ? CreateContentsRequest.CREATOR.createFromParcel(parcel) : null, zzan.zza.a(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 5:
                    parcel.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
                    a(parcel.readInt() != 0 ? CreateFileRequest.CREATOR.createFromParcel(parcel) : null, zzan.zza.a(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 6:
                    parcel.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
                    a(parcel.readInt() != 0 ? CreateFolderRequest.CREATOR.createFromParcel(parcel) : null, zzan.zza.a(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 7:
                    parcel.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
                    DriveServiceResponse a2 = a(parcel.readInt() != 0 ? OpenContentsRequest.CREATOR.createFromParcel(parcel) : null, zzan.zza.a(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    if (a2 != null) {
                        parcel2.writeInt(1);
                        a2.writeToParcel(parcel2, 1);
                    } else {
                        parcel2.writeInt(0);
                    }
                    return true;
                case 8:
                    parcel.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
                    a(parcel.readInt() != 0 ? CloseContentsRequest.CREATOR.createFromParcel(parcel) : null, zzan.zza.a(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 9:
                    parcel.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
                    a(zzan.zza.a(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 10:
                    parcel.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
                    IntentSender a3 = a(parcel.readInt() != 0 ? OpenFileIntentSenderRequest.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    if (a3 != null) {
                        parcel2.writeInt(1);
                        a3.writeToParcel(parcel2, 1);
                    } else {
                        parcel2.writeInt(0);
                    }
                    return true;
                case 11:
                    parcel.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
                    IntentSender a4 = a(parcel.readInt() != 0 ? CreateFileIntentSenderRequest.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    if (a4 != null) {
                        parcel2.writeInt(1);
                        a4.writeToParcel(parcel2, 1);
                    } else {
                        parcel2.writeInt(0);
                    }
                    return true;
                case 12:
                    parcel.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
                    a(parcel.readInt() != 0 ? AuthorizeAccessRequest.CREATOR.createFromParcel(parcel) : null, zzan.zza.a(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 13:
                    parcel.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
                    a(parcel.readInt() != 0 ? ListParentsRequest.CREATOR.createFromParcel(parcel) : null, zzan.zza.a(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 14:
                    parcel.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
                    a(parcel.readInt() != 0 ? AddEventListenerRequest.CREATOR.createFromParcel(parcel) : null, zzao.zza.a(parcel.readStrongBinder()), parcel.readString(), zzan.zza.a(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 15:
                    parcel.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
                    a(parcel.readInt() != 0 ? RemoveEventListenerRequest.CREATOR.createFromParcel(parcel) : null, zzao.zza.a(parcel.readStrongBinder()), parcel.readString(), zzan.zza.a(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 16:
                    parcel.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
                    a(parcel.readInt() != 0 ? DisconnectRequest.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    return true;
                case 17:
                    parcel.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
                    a(parcel.readInt() != 0 ? TrashResourceRequest.CREATOR.createFromParcel(parcel) : null, zzan.zza.a(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 18:
                    parcel.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
                    a(parcel.readInt() != 0 ? CloseContentsAndUpdateMetadataRequest.CREATOR.createFromParcel(parcel) : null, zzan.zza.a(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 19:
                    parcel.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
                    b(parcel.readInt() != 0 ? QueryRequest.CREATOR.createFromParcel(parcel) : null, zzan.zza.a(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 24:
                    parcel.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
                    a(parcel.readInt() != 0 ? DeleteResourceRequest.CREATOR.createFromParcel(parcel) : null, zzan.zza.a(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 27:
                    parcel.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
                    a(parcel.readInt() != 0 ? LoadRealtimeRequest.CREATOR.createFromParcel(parcel) : null, zzan.zza.a(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 28:
                    parcel.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
                    a(parcel.readInt() != 0 ? SetResourceParentsRequest.CREATOR.createFromParcel(parcel) : null, zzan.zza.a(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 29:
                    parcel.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
                    a(parcel.readInt() != 0 ? GetDriveIdFromUniqueIdentifierRequest.CREATOR.createFromParcel(parcel) : null, zzan.zza.a(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 30:
                    parcel.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
                    a(parcel.readInt() != 0 ? CheckResourceIdsExistRequest.CREATOR.createFromParcel(parcel) : null, zzan.zza.a(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 31:
                    parcel.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
                    b(zzan.zza.a(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 32:
                    parcel.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
                    c(zzan.zza.a(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 33:
                    parcel.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
                    a(parcel.readInt() != 0 ? SetDrivePreferencesRequest.CREATOR.createFromParcel(parcel) : null, zzan.zza.a(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 34:
                    parcel.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
                    a(parcel.readInt() != 0 ? RealtimeDocumentSyncRequest.CREATOR.createFromParcel(parcel) : null, zzan.zza.a(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 35:
                    parcel.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
                    d(zzan.zza.a(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 36:
                    parcel.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
                    a(parcel.readInt() != 0 ? SetFileUploadPreferencesRequest.CREATOR.createFromParcel(parcel) : null, zzan.zza.a(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 37:
                    parcel.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
                    a(parcel.readInt() != 0 ? CancelPendingActionsRequest.CREATOR.createFromParcel(parcel) : null, zzan.zza.a(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 38:
                    parcel.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
                    a(parcel.readInt() != 0 ? UntrashResourceRequest.CREATOR.createFromParcel(parcel) : null, zzan.zza.a(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 41:
                    parcel.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
                    e(zzan.zza.a(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 42:
                    parcel.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
                    a(parcel.readInt() != 0 ? FetchThumbnailRequest.CREATOR.createFromParcel(parcel) : null, zzan.zza.a(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 43:
                    parcel.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
                    f(zzan.zza.a(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 44:
                    parcel.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
                    a(parcel.readInt() != 0 ? GetChangesRequest.CREATOR.createFromParcel(parcel) : null, zzan.zza.a(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 46:
                    parcel.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
                    a(parcel.readInt() != 0 ? UnsubscribeResourceRequest.CREATOR.createFromParcel(parcel) : null, zzan.zza.a(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 47:
                    parcel.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
                    a(parcel.readInt() != 0 ? GetPermissionsRequest.CREATOR.createFromParcel(parcel) : null, zzan.zza.a(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 48:
                    parcel.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
                    a(parcel.readInt() != 0 ? AddPermissionRequest.CREATOR.createFromParcel(parcel) : null, zzan.zza.a(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 49:
                    parcel.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
                    a(parcel.readInt() != 0 ? UpdatePermissionRequest.CREATOR.createFromParcel(parcel) : null, zzan.zza.a(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 50:
                    parcel.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
                    a(parcel.readInt() != 0 ? RemovePermissionRequest.CREATOR.createFromParcel(parcel) : null, zzan.zza.a(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 51:
                    parcel.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
                    a(parcel.readInt() != 0 ? QueryRequest.CREATOR.createFromParcel(parcel) : null, zzao.zza.a(parcel.readStrongBinder()), zzan.zza.a(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 52:
                    parcel.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
                    a(zzao.zza.a(parcel.readStrongBinder()), zzan.zza.a(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 53:
                    parcel.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
                    a(parcel.readInt() != 0 ? ControlProgressRequest.CREATOR.createFromParcel(parcel) : null, zzan.zza.a(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 54:
                    parcel.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
                    g(zzan.zza.a(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 55:
                    parcel.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
                    a(parcel.readInt() != 0 ? ChangeResourceParentsRequest.CREATOR.createFromParcel(parcel) : null, zzan.zza.a(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 56:
                    parcel.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
                    DriveServiceResponse a5 = a(parcel.readInt() != 0 ? StreamContentsRequest.CREATOR.createFromParcel(parcel) : null, zzan.zza.a(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    if (a5 != null) {
                        parcel2.writeInt(1);
                        a5.writeToParcel(parcel2, 1);
                    } else {
                        parcel2.writeInt(0);
                    }
                    return true;
                case 1598968902:
                    parcel2.writeString("com.google.android.gms.drive.internal.IDriveService");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    IntentSender a(CreateFileIntentSenderRequest createFileIntentSenderRequest) throws RemoteException;

    IntentSender a(OpenFileIntentSenderRequest openFileIntentSenderRequest) throws RemoteException;

    DriveServiceResponse a(OpenContentsRequest openContentsRequest, zzan zzanVar) throws RemoteException;

    DriveServiceResponse a(StreamContentsRequest streamContentsRequest, zzan zzanVar) throws RemoteException;

    void a(RealtimeDocumentSyncRequest realtimeDocumentSyncRequest, zzan zzanVar) throws RemoteException;

    void a(AddEventListenerRequest addEventListenerRequest, zzao zzaoVar, String str, zzan zzanVar) throws RemoteException;

    void a(AddPermissionRequest addPermissionRequest, zzan zzanVar) throws RemoteException;

    void a(AuthorizeAccessRequest authorizeAccessRequest, zzan zzanVar) throws RemoteException;

    void a(CancelPendingActionsRequest cancelPendingActionsRequest, zzan zzanVar) throws RemoteException;

    void a(ChangeResourceParentsRequest changeResourceParentsRequest, zzan zzanVar) throws RemoteException;

    void a(CheckResourceIdsExistRequest checkResourceIdsExistRequest, zzan zzanVar) throws RemoteException;

    void a(CloseContentsAndUpdateMetadataRequest closeContentsAndUpdateMetadataRequest, zzan zzanVar) throws RemoteException;

    void a(CloseContentsRequest closeContentsRequest, zzan zzanVar) throws RemoteException;

    void a(ControlProgressRequest controlProgressRequest, zzan zzanVar) throws RemoteException;

    void a(CreateContentsRequest createContentsRequest, zzan zzanVar) throws RemoteException;

    void a(CreateFileRequest createFileRequest, zzan zzanVar) throws RemoteException;

    void a(CreateFolderRequest createFolderRequest, zzan zzanVar) throws RemoteException;

    void a(DeleteResourceRequest deleteResourceRequest, zzan zzanVar) throws RemoteException;

    void a(DisconnectRequest disconnectRequest) throws RemoteException;

    void a(FetchThumbnailRequest fetchThumbnailRequest, zzan zzanVar) throws RemoteException;

    void a(GetChangesRequest getChangesRequest, zzan zzanVar) throws RemoteException;

    void a(GetDriveIdFromUniqueIdentifierRequest getDriveIdFromUniqueIdentifierRequest, zzan zzanVar) throws RemoteException;

    void a(GetMetadataRequest getMetadataRequest, zzan zzanVar) throws RemoteException;

    void a(GetPermissionsRequest getPermissionsRequest, zzan zzanVar) throws RemoteException;

    void a(ListParentsRequest listParentsRequest, zzan zzanVar) throws RemoteException;

    void a(LoadRealtimeRequest loadRealtimeRequest, zzan zzanVar) throws RemoteException;

    void a(QueryRequest queryRequest, zzan zzanVar) throws RemoteException;

    void a(QueryRequest queryRequest, zzao zzaoVar, zzan zzanVar) throws RemoteException;

    void a(RemoveEventListenerRequest removeEventListenerRequest, zzao zzaoVar, String str, zzan zzanVar) throws RemoteException;

    void a(RemovePermissionRequest removePermissionRequest, zzan zzanVar) throws RemoteException;

    void a(SetDrivePreferencesRequest setDrivePreferencesRequest, zzan zzanVar) throws RemoteException;

    void a(SetFileUploadPreferencesRequest setFileUploadPreferencesRequest, zzan zzanVar) throws RemoteException;

    void a(SetResourceParentsRequest setResourceParentsRequest, zzan zzanVar) throws RemoteException;

    void a(TrashResourceRequest trashResourceRequest, zzan zzanVar) throws RemoteException;

    void a(UnsubscribeResourceRequest unsubscribeResourceRequest, zzan zzanVar) throws RemoteException;

    void a(UntrashResourceRequest untrashResourceRequest, zzan zzanVar) throws RemoteException;

    void a(UpdateMetadataRequest updateMetadataRequest, zzan zzanVar) throws RemoteException;

    void a(UpdatePermissionRequest updatePermissionRequest, zzan zzanVar) throws RemoteException;

    void a(zzan zzanVar) throws RemoteException;

    void a(zzao zzaoVar, zzan zzanVar) throws RemoteException;

    void b(QueryRequest queryRequest, zzan zzanVar) throws RemoteException;

    void b(zzan zzanVar) throws RemoteException;

    void c(zzan zzanVar) throws RemoteException;

    void d(zzan zzanVar) throws RemoteException;

    void e(zzan zzanVar) throws RemoteException;

    void f(zzan zzanVar) throws RemoteException;

    void g(zzan zzanVar) throws RemoteException;
}
