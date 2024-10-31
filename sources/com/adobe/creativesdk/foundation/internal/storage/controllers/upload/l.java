package com.adobe.creativesdk.foundation.internal.storage.controllers.upload;

import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import com.adobe.creativesdk.foundation.storage.C0578la;

/* compiled from: AdobeUploadCreateNewFolderMgr.java */
/* loaded from: classes.dex */
public class l {
    public static DialogFragment a(C0578la c0578la) {
        k kVar = new k();
        Bundle bundle = new Bundle();
        bundle.putString("parent", c0578la.getHref().toString());
        kVar.setArguments(bundle);
        return kVar;
    }
}
