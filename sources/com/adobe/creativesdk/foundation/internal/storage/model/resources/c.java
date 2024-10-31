package com.adobe.creativesdk.foundation.internal.storage.model.resources;

import android.os.Parcel;
import android.os.Parcelable;
import com.adobe.creativesdk.foundation.storage.AdobeCollaborationRoleType;
import com.adobe.creativesdk.foundation.storage.AdobeCollaborationType;
import java.net.URI;

/* compiled from: AdobeStorageResourceCollection.java */
/* loaded from: classes.dex */
class c implements Parcelable.Creator<e> {
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.Creator
    public e createFromParcel(Parcel parcel) {
        e eVar = new e();
        eVar.f6609a = parcel.readString();
        if (eVar.f6609a.equals("-")) {
            eVar.f6609a = null;
        }
        eVar.f6610b = (URI) parcel.readSerializable();
        eVar.f6613e = parcel.readString();
        if (eVar.f6613e.equals("-")) {
            eVar.f6613e = null;
        }
        eVar.f6611c = parcel.readString();
        eVar.f6614f = parcel.readString();
        if (eVar.f6614f.equals("-")) {
            eVar.f6614f = null;
        }
        eVar.f6615g = parcel.readString();
        if (eVar.f6615g.equals("-")) {
            eVar.f6615g = null;
        }
        eVar.f6612d = parcel.readString();
        if (eVar.f6612d.equals("-")) {
            eVar.f6612d = null;
        }
        eVar.k = (AdobeCollaborationType) parcel.readSerializable();
        eVar.l = (AdobeCollaborationRoleType) parcel.readSerializable();
        eVar.s = parcel.readInt();
        return eVar;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.Creator
    public e[] newArray(int i) {
        return new e[i];
    }
}
