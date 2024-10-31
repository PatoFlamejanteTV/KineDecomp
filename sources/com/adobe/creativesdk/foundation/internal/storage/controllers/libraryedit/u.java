package com.adobe.creativesdk.foundation.internal.storage.controllers.libraryedit;

import android.app.Activity;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.adobe.creativesdk.foundation.adobeinternal.storage.library.F;
import com.adobe.creativesdk.foundation.internal.storage.controllers.C0358a;
import com.adobe.creativesdk.foundation.internal.storage.controllers.commands.AdobeAssetViewBrowserCommandName;
import com.adobe.creativesdk.foundation.internal.storage.controllers.edit.I;
import com.adobe.creativesdk.foundation.storage.AdobeLibraryException;
import com.adobe.creativesdk.foundation.storage.C0614ub;
import com.adobe.creativesdk.foundation.storage.C0622wb;
import java.util.Observer;

/* compiled from: AdobeLibraryElementRenameDialogFragment.java */
/* loaded from: classes.dex */
public class u extends com.adobe.creativesdk.foundation.internal.utils.j {
    private C0622wb n;
    private C0614ub o;
    private Observer p;
    private boolean q;
    private I r;

    private void K() {
        B();
        dismissAllowingStateLoss();
    }

    private void L() {
        this.p.update(null, true);
        K();
    }

    private void M() {
        K();
    }

    private void N() {
        C();
        if (this.q) {
            d(m(c.a.a.a.b.i.adobe_csdk_asset_view_edit_rename_dialog_error_message));
        }
        this.p.update(null, false);
    }

    private void O() {
        a.b(true);
        a.c(true);
        if (this.n != null) {
            C0358a.a().a(AdobeAssetViewBrowserCommandName.ACTION_LIBRARY_ITEM_EDIT_STARTED);
        } else {
            C0358a.a().a(AdobeAssetViewBrowserCommandName.ACTION_LIBRARY_COMP_EDIT_STARTED);
        }
    }

    private void P() {
        String E = E();
        A();
        z();
        O();
        C0622wb c0622wb = this.n;
        if (c0622wb != null) {
            c0622wb.d(E);
            L();
        } else {
            try {
                ((F) this.o).e(E);
                L();
            } catch (AdobeLibraryException unused) {
                N();
            }
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

    public void a(I i) {
        this.r = i;
    }

    @Override // android.support.v4.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.q = true;
    }

    @Override // com.adobe.creativesdk.foundation.internal.utils.j, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        f(m(c.a.a.a.b.i.adobe_csdk_asset_view_edit_rename_dialog_title));
        h(m(c.a.a.a.b.i.adobe_csdk_asset_view_edit_rename_dialog_hint_text));
        i(m(c.a.a.a.b.i.adobe_csdk_asset_view_edit_rename_dialog_negative_button));
        j(m(c.a.a.a.b.i.adobe_csdk_asset_view_edit_rename_dialog_positive_button));
        C0622wb c0622wb = this.n;
        if (c0622wb != null) {
            g(c0622wb.e());
        } else {
            C0614ub c0614ub = this.o;
            if (c0614ub != null) {
                g(c0614ub.m());
            }
        }
        return super.onCreateView(layoutInflater, viewGroup, bundle);
    }

    @Override // android.support.v4.app.DialogFragment, android.support.v4.app.Fragment
    public void onDetach() {
        super.onDetach();
        this.q = false;
    }

    @Override // android.support.v4.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        super.onDismiss(dialogInterface);
        this.r.a();
    }

    @Override // com.adobe.creativesdk.foundation.internal.utils.j
    public void a(Editable editable) {
        for (int length = editable.length(); length > 0; length--) {
            int i = length - 1;
            if ("\n".equals(editable.subSequence(i, length).toString())) {
                editable.replace(i, length, "");
            }
        }
    }

    public void a(C0622wb c0622wb, C0614ub c0614ub, Observer observer) {
        this.n = c0622wb;
        this.o = c0614ub;
        this.p = observer;
    }
}
