package com.facebook.share.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.internal.NativeProtocol;
import com.facebook.share.model.ShareOpenGraphValueContainer;

/* loaded from: classes.dex */
public final class ShareOpenGraphObject extends ShareOpenGraphValueContainer<ShareOpenGraphObject, Builder> {
    public static final Parcelable.Creator<ShareOpenGraphObject> CREATOR = new g();

    /* synthetic */ ShareOpenGraphObject(Builder builder, g gVar) {
        this(builder);
    }

    private ShareOpenGraphObject(Builder builder) {
        super(builder);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ShareOpenGraphObject(Parcel parcel) {
        super(parcel);
    }

    /* loaded from: classes.dex */
    public static final class Builder extends ShareOpenGraphValueContainer.Builder<ShareOpenGraphObject, Builder> {
        public Builder() {
            putBoolean(NativeProtocol.OPEN_GRAPH_CREATE_OBJECT_KEY, true);
        }

        @Override // com.facebook.share.ShareBuilder
        public ShareOpenGraphObject build() {
            return new ShareOpenGraphObject(this, null);
        }

        @Override // com.facebook.share.model.ShareModelBuilder
        public Builder readFrom(Parcel parcel) {
            return readFrom((Builder) parcel.readParcelable(ShareOpenGraphObject.class.getClassLoader()));
        }
    }
}
