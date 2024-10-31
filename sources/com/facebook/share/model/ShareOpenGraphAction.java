package com.facebook.share.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.share.model.ShareOpenGraphValueContainer;

/* loaded from: classes.dex */
public final class ShareOpenGraphAction extends ShareOpenGraphValueContainer<ShareOpenGraphAction, Builder> {
    public static final Parcelable.Creator<ShareOpenGraphAction> CREATOR = new e();

    /* synthetic */ ShareOpenGraphAction(Builder builder, e eVar) {
        this(builder);
    }

    private ShareOpenGraphAction(Builder builder) {
        super(builder);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ShareOpenGraphAction(Parcel parcel) {
        super(parcel);
    }

    public String getActionType() {
        return getString("og:type");
    }

    /* loaded from: classes.dex */
    public static final class Builder extends ShareOpenGraphValueContainer.Builder<ShareOpenGraphAction, Builder> {
        private static final String ACTION_TYPE_KEY = "og:type";

        public Builder setActionType(String str) {
            putString(ACTION_TYPE_KEY, str);
            return this;
        }

        @Override // com.facebook.share.ShareBuilder
        public ShareOpenGraphAction build() {
            return new ShareOpenGraphAction(this, null);
        }

        @Override // com.facebook.share.model.ShareOpenGraphValueContainer.Builder
        public Builder readFrom(ShareOpenGraphAction shareOpenGraphAction) {
            return shareOpenGraphAction == null ? this : ((Builder) super.readFrom((Builder) shareOpenGraphAction)).setActionType(shareOpenGraphAction.getActionType());
        }

        @Override // com.facebook.share.model.ShareModelBuilder
        public Builder readFrom(Parcel parcel) {
            return readFrom((ShareOpenGraphAction) parcel.readParcelable(ShareOpenGraphAction.class.getClassLoader()));
        }
    }
}
