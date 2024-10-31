package com.adobe.creativesdk.foundation.internal.storage.controllers.upload;

import android.os.Bundle;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.adobe.creativesdk.foundation.auth.AdobeAuthException;
import com.adobe.creativesdk.foundation.internal.storage.controllers.C0358a;
import com.adobe.creativesdk.foundation.internal.storage.controllers.commands.AdobeAssetViewBrowserCommandName;
import com.adobe.creativesdk.foundation.internal.utils.AdobeCSDKException;
import com.adobe.creativesdk.foundation.storage.AdobeAssetErrorCode;
import com.adobe.creativesdk.foundation.storage.AdobeAssetException;
import com.adobe.creativesdk.foundation.storage.C0614ub;
import com.adobe.creativesdk.foundation.storage.Gb;

/* compiled from: AdobeUploadCreateNewLibraryDialogFragment.java */
/* loaded from: classes.dex */
public class m extends com.adobe.creativesdk.foundation.internal.utils.j {
    private boolean n;
    private y o;

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

    private void k(String str) {
        I();
        com.adobe.creativesdk.foundation.internal.storage.controllers.libraryedit.a.d(true);
        C0358a.a().a(AdobeAssetViewBrowserCommandName.ACTION_ASSETVIEW_LIBRARY_CREATED, str);
        L();
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
        if (E() != null && E().trim().length() > 0) {
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
            z();
            A();
            k(Gb.f().a(trim).k());
        }
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

    @Override // com.adobe.creativesdk.foundation.internal.utils.j, android.support.v4.app.DialogFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // com.adobe.creativesdk.foundation.internal.utils.j, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        f(getResources().getString(c.a.a.a.b.i.adobe_csdk_CREATE_NEW_LIBRARY_DIALOG_TITLE));
        j(getResources().getString(c.a.a.a.b.i.adobe_csdk_CREATE_NEW_FOLDER_BUTTON_CREATE));
        i(getResources().getString(c.a.a.a.b.i.adobe_csdk_CREATE_NEW_FOLDER_BUTTON_CANCEL));
        h(getResources().getString(c.a.a.a.b.i.adobe_csdk_CREATE_NEW_LIBRARY_EDIT_TEXT_HINT));
        return super.onCreateView(layoutInflater, viewGroup, bundle);
    }

    @Override // com.adobe.creativesdk.foundation.internal.utils.j, android.support.v4.app.DialogFragment, android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        this.n = false;
        y yVar = this.o;
        if (yVar != null) {
            C0614ub c0614ub = yVar.f6485b;
            if (c0614ub != null) {
                k(c0614ub.k());
                return;
            }
            AdobeCSDKException adobeCSDKException = yVar.f6484a;
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

    private void a(AdobeCSDKException adobeCSDKException) {
        C();
        b(adobeCSDKException);
    }
}
