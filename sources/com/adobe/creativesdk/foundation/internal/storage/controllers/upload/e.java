package com.adobe.creativesdk.foundation.internal.storage.controllers.upload;

import android.os.Bundle;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.adobe.creativesdk.foundation.adobeinternal.cloud.AdobeCloud;
import com.adobe.creativesdk.foundation.auth.AdobeAuthException;
import com.adobe.creativesdk.foundation.internal.storage.controllers.C0358a;
import com.adobe.creativesdk.foundation.internal.storage.controllers.commands.AdobeAssetViewBrowserCommandName;
import com.adobe.creativesdk.foundation.internal.utils.AdobeCSDKException;
import com.adobe.creativesdk.foundation.storage.AdobeAssetErrorCode;
import com.adobe.creativesdk.foundation.storage.AdobeAssetException;
import com.adobe.creativesdk.foundation.storage.AdobePhotoCatalog;
import com.adobe.creativesdk.foundation.storage.AdobePhotoCollection;

/* compiled from: AdobeCreatePhotoCollectionDialogFragment.java */
/* loaded from: classes.dex */
public class e extends com.adobe.creativesdk.foundation.internal.utils.j {
    private boolean n;
    private w o;
    private AdobeCloud p;
    private boolean q;

    public e() {
        this.q = false;
        this.q = false;
    }

    private void L() {
        B();
        dismiss();
    }

    private void b(AdobeCSDKException adobeCSDKException) {
        int i = c.a.a.a.b.i.adobe_csdk_common_error_while_creating_folder;
        if (adobeCSDKException instanceof AdobeAssetException) {
            AdobeAssetException adobeAssetException = (AdobeAssetException) adobeCSDKException;
            if (adobeAssetException.getErrorCode() == AdobeAssetErrorCode.AdobeAssetErrorFileReadFailure) {
                i = c.a.a.a.b.i.adobe_csdk_common_error_folder_invalid_chars;
            } else if (adobeAssetException.getHttpStatusCode().intValue() == 409) {
                i = c.a.a.a.b.i.adobe_csdk_storage_create_folder_already_exists_error;
            }
        } else if (adobeCSDKException instanceof AdobeAuthException) {
            i = c.a.a.a.b.i.adobe_csdk_storage_create_folder_authention_requires_error;
        }
        d(getResources().getString(i));
    }

    @Override // com.adobe.creativesdk.foundation.internal.utils.j
    public void F() {
        J();
    }

    @Override // com.adobe.creativesdk.foundation.internal.utils.j
    public void G() {
        K();
    }

    @Override // com.adobe.creativesdk.foundation.internal.utils.j
    public void H() {
        I();
        if (E() != null && E().trim().length() > 0 && !this.q) {
            D();
        } else {
            A();
        }
    }

    public void J() {
        B();
        dismiss();
    }

    public void K() {
        String E = E();
        this.n = false;
        String trim = E.trim();
        if (trim.length() != 0) {
            this.q = true;
            z();
            A();
            AdobePhotoCatalog.listCatalogOfType(AdobePhotoCatalog.AdobePhotoCatalogType.AdobePhotoCatalogTypeLightroom, this.p, new c(this, trim, new C0483a(this), new C0484b(this)), new d(this));
        }
    }

    @Override // com.adobe.creativesdk.foundation.internal.utils.j, android.support.v4.app.DialogFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // com.adobe.creativesdk.foundation.internal.utils.j, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        f(getResources().getString(c.a.a.a.b.i.adobe_csdk_CREATE_NEW_PHOTO_COLLECTION_DIALOG_TITLE));
        j(getResources().getString(c.a.a.a.b.i.adobe_csdk_CREATE_NEW_FOLDER_BUTTON_CREATE));
        i(getResources().getString(c.a.a.a.b.i.adobe_csdk_CREATE_NEW_FOLDER_BUTTON_CANCEL));
        h(getResources().getString(c.a.a.a.b.i.adobe_csdk_CREATE_NEW_PHOTO_COLLECTION_EDIT_TEXT_HINT));
        return super.onCreateView(layoutInflater, viewGroup, bundle);
    }

    @Override // com.adobe.creativesdk.foundation.internal.utils.j, android.support.v4.app.DialogFragment, android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        this.n = false;
        w wVar = this.o;
        if (wVar != null) {
            AdobePhotoCollection adobePhotoCollection = wVar.f6481b;
            if (adobePhotoCollection != null) {
                a(adobePhotoCollection);
                return;
            }
            AdobeCSDKException adobeCSDKException = wVar.f6480a;
            if (adobeCSDKException != null) {
                a(adobeCSDKException);
            }
            this.o = null;
        }
    }

    @Override // android.support.v4.app.DialogFragment, android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        this.n = true;
    }

    public void a(AdobeCloud adobeCloud) {
        this.p = adobeCloud;
    }

    @Override // com.adobe.creativesdk.foundation.internal.utils.j
    public void a(Editable editable) {
        for (int length = editable.length(); length > 0; length--) {
            int i = length - 1;
            if (editable.subSequence(i, length).toString().equals("\n")) {
                editable.replace(i, length, "");
            }
        }
    }

    public void a(AdobePhotoCollection adobePhotoCollection) {
        I();
        this.q = false;
        C0358a.a().a(AdobeAssetViewBrowserCommandName.ACTION_ASSETVIEW_PHOTOCOLLECTION_CREATED, adobePhotoCollection);
        L();
    }

    public void a(AdobeCSDKException adobeCSDKException) {
        this.q = false;
        C();
        b(adobeCSDKException);
    }
}
