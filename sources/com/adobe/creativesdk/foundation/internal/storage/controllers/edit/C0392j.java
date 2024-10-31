package com.adobe.creativesdk.foundation.internal.storage.controllers.edit;

import android.app.Activity;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.adobe.creativesdk.foundation.adobeinternal.cloud.AdobeCloud;
import com.adobe.creativesdk.foundation.adobeinternal.cloud.AdobeCloudServiceType;
import com.adobe.creativesdk.foundation.internal.storage.a.b.ra;
import com.adobe.creativesdk.foundation.internal.storage.controllers.C0358a;
import com.adobe.creativesdk.foundation.internal.storage.controllers.commands.AdobeAssetViewBrowserCommandName;
import com.adobe.creativesdk.foundation.storage.C0533a;
import java.util.Observer;

/* compiled from: AdobeAssetViewEditRenameDialogFragment.java */
/* renamed from: com.adobe.creativesdk.foundation.internal.storage.controllers.edit.j, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0392j extends com.adobe.creativesdk.foundation.internal.utils.j {
    private C0533a n;
    private Observer o;
    private boolean p;
    private I q;
    private AdobeCloud r;

    private void K() {
        B();
        dismissAllowingStateLoss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L() {
        this.o.update(null, AdobeCCFilesEditRenameOperationStatus.ADOBE_CC_FILES_EDIT_RENAME_OPERATION_STATUS_COMPLETED);
        K();
    }

    private void M() {
        K();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void N() {
        C();
        if (this.p) {
            d(m(c.a.a.a.b.i.adobe_csdk_asset_view_edit_rename_dialog_error_message));
        }
        this.o.update(null, AdobeCCFilesEditRenameOperationStatus.ADOBE_CC_FILES_EDIT_RENAME_OPERATION_STATUS_FAILED);
    }

    private void O() {
        C0394l.b(true);
        C0394l.c(true);
        C0358a.a().a(AdobeAssetViewBrowserCommandName.ACTION_ASSETVIEW_EDIT_STARTED);
    }

    private void P() {
        String trim = E() != null ? E().trim() : E();
        if (trim.length() > 0) {
            ra raVar = (ra) this.r.getSessionForService(AdobeCloudServiceType.AdobeCloudServiceTypeStorage);
            A();
            z();
            O();
            raVar.a(this.n, trim, new C0391i(this));
        }
    }

    private String m(int i) {
        return getResources().getString(i);
    }

    @Override // com.adobe.creativesdk.foundation.internal.utils.j
    public void F() {
        M();
    }

    @Override // com.adobe.creativesdk.foundation.internal.utils.j
    public void G() {
        P();
    }

    @Override // com.adobe.creativesdk.foundation.internal.utils.j
    public void H() {
        if (E() != null && E().trim().length() > 0) {
            D();
        } else {
            A();
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.p = true;
    }

    @Override // com.adobe.creativesdk.foundation.internal.utils.j, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        f(m(c.a.a.a.b.i.adobe_csdk_asset_view_edit_rename_dialog_title));
        h(m(c.a.a.a.b.i.adobe_csdk_asset_view_edit_rename_dialog_hint_text));
        i(m(c.a.a.a.b.i.adobe_csdk_asset_view_edit_rename_dialog_negative_button));
        j(m(c.a.a.a.b.i.adobe_csdk_asset_view_edit_rename_dialog_positive_button));
        C0533a c0533a = this.n;
        if (c0533a != null && c0533a.getName() != null) {
            int lastIndexOf = this.n.getName().lastIndexOf(".");
            g(lastIndexOf == -1 ? this.n.getName() : this.n.getName().substring(0, lastIndexOf));
        }
        return super.onCreateView(layoutInflater, viewGroup, bundle);
    }

    @Override // android.support.v4.app.DialogFragment, android.support.v4.app.Fragment
    public void onDetach() {
        super.onDetach();
        this.p = false;
    }

    @Override // android.support.v4.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        super.onDismiss(dialogInterface);
        this.q.a();
    }

    public void a(I i) {
        this.q = i;
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

    public void a(C0533a c0533a, Observer observer, AdobeCloud adobeCloud) {
        this.n = c0533a;
        this.o = observer;
        this.r = adobeCloud;
    }
}
