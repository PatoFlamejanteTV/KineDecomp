package com.facebook.share.widget;

import android.content.Context;
import android.util.AttributeSet;
import com.facebook.R;
import com.facebook.internal.AnalyticsEvents;
import com.facebook.internal.CallbackManagerImpl;
import com.facebook.internal.FacebookDialogBase;
import com.facebook.share.Sharer;
import com.facebook.share.model.ShareContent;

/* loaded from: classes.dex */
public final class ShareButton extends ShareButtonBase {
    public ShareButton(Context context) {
        super(context, null, 0, AnalyticsEvents.EVENT_SHARE_BUTTON_CREATE, AnalyticsEvents.EVENT_SHARE_BUTTON_DID_TAP);
    }

    public ShareButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0, AnalyticsEvents.EVENT_SHARE_BUTTON_CREATE, AnalyticsEvents.EVENT_SHARE_BUTTON_DID_TAP);
    }

    public ShareButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i, AnalyticsEvents.EVENT_SHARE_BUTTON_CREATE, AnalyticsEvents.EVENT_SHARE_BUTTON_DID_TAP);
    }

    @Override // com.facebook.FacebookButtonBase
    protected int getDefaultStyleResource() {
        return R.style.com_facebook_button_share;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.FacebookButtonBase
    public int getDefaultRequestCode() {
        return CallbackManagerImpl.RequestCodeOffset.Share.toRequestCode();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.share.widget.ShareButtonBase
    public FacebookDialogBase<ShareContent, Sharer.Result> getDialog() {
        if (getFragment() != null) {
            return new ShareDialog(getFragment(), getRequestCode());
        }
        return new ShareDialog(getActivity(), getRequestCode());
    }
}
