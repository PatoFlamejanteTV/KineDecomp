package com.adobe.creativesdk.foundation.internal.storage.controllers.upload;

import android.os.Bundle;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.adobe.creativesdk.foundation.auth.AdobeAuthException;
import com.adobe.creativesdk.foundation.internal.storage.controllers.C0358a;
import com.adobe.creativesdk.foundation.internal.storage.controllers.C0363b;
import com.adobe.creativesdk.foundation.internal.storage.controllers.C0455p;
import com.adobe.creativesdk.foundation.internal.storage.controllers.commands.AdobeAssetViewBrowserCommandName;
import com.adobe.creativesdk.foundation.internal.utils.AdobeCSDKException;
import com.adobe.creativesdk.foundation.storage.AdobeAssetErrorCode;
import com.adobe.creativesdk.foundation.storage.AdobeAssetException;
import com.adobe.creativesdk.foundation.storage.C0578la;

/* compiled from: AdobeUploadCreateNewFolderDialogFragment.java */
/* loaded from: classes.dex */
public class k extends com.adobe.creativesdk.foundation.internal.utils.j {
    C0578la n;
    private boolean o;
    private x p;
    private boolean q;

    public k() {
        this.q = false;
        this.q = false;
    }

    private void L() {
        B();
        dismiss();
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
        this.o = false;
        String trim = E.trim();
        if (trim.length() != 0) {
            this.q = true;
            z();
            A();
            C0578la.a(trim, this.n, new i(this), new j(this));
        }
    }

    @Override // com.adobe.creativesdk.foundation.internal.utils.j, android.support.v4.app.DialogFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.n = C0455p.a(getArguments().getString("parent"), false);
    }

    @Override // com.adobe.creativesdk.foundation.internal.utils.j, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        f(getResources().getString(c.a.a.a.b.i.adobe_csdk_CREATE_NEW_FOLDER_DIALOG_TITLE));
        j(getResources().getString(c.a.a.a.b.i.adobe_csdk_CREATE_NEW_FOLDER_BUTTON_CREATE));
        i(getResources().getString(c.a.a.a.b.i.adobe_csdk_CREATE_NEW_FOLDER_BUTTON_CANCEL));
        h(getResources().getString(c.a.a.a.b.i.adobe_csdk_CREATE_NEW_FOLDER_EDIT_TEXT_HINT));
        return super.onCreateView(layoutInflater, viewGroup, bundle);
    }

    @Override // com.adobe.creativesdk.foundation.internal.utils.j, android.support.v4.app.DialogFragment, android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        this.o = false;
        x xVar = this.p;
        if (xVar != null) {
            C0578la c0578la = xVar.f6483b;
            if (c0578la != null) {
                a(c0578la);
                return;
            }
            AdobeCSDKException adobeCSDKException = xVar.f6482a;
            if (adobeCSDKException != null) {
                a(adobeCSDKException);
            }
            this.p = null;
        }
    }

    @Override // android.support.v4.app.DialogFragment, android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        this.o = true;
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
    public void a(Editable editable) {
        for (int length = editable.length(); length > 0; length--) {
            int i = length - 1;
            if (editable.subSequence(i, length).toString().equals("\n")) {
                editable.replace(i, length, "");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(C0578la c0578la) {
        I();
        this.q = false;
        C0363b.a().a(this.n);
        C0358a.a().a(AdobeAssetViewBrowserCommandName.ACTION_ASSETVIEW_NEWFOLDER_CREATED, c0578la);
        L();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AdobeCSDKException adobeCSDKException) {
        this.q = false;
        C();
        b(adobeCSDKException);
    }
}
