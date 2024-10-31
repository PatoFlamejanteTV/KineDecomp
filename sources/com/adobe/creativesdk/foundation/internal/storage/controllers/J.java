package com.adobe.creativesdk.foundation.internal.storage.controllers;

import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/* compiled from: AdobeRemoveMyselfDialogFragment.java */
/* loaded from: classes.dex */
public class J extends DialogFragment {

    /* renamed from: a */
    private TextView f5676a;

    /* renamed from: b */
    private View f5677b;

    /* renamed from: c */
    private View f5678c;

    /* renamed from: d */
    private boolean f5679d = false;

    /* renamed from: e */
    private boolean f5680e = false;

    /* renamed from: f */
    private boolean f5681f = false;

    /* renamed from: g */
    private Zc f5682g;

    private void z() {
        if (this.f5679d) {
            ((TextView) this.f5677b).setText(getResources().getString(c.a.a.a.b.i.adobe_csdk_remove_confirm_dialog_positive_button));
            this.f5676a.setText(getResources().getString(c.a.a.a.b.i.adobe_csdk_remove_confirm_dialog_message));
        } else {
            if (this.f5680e) {
                ((TextView) this.f5677b).setText(getResources().getString(c.a.a.a.b.i.adobe_csdk_revoke_confirm_dialog_positive_button));
                this.f5676a.setText(getResources().getString(c.a.a.a.b.i.adobe_csdk_revoke_confirm_dialog_message));
                return;
            }
            ((TextView) this.f5677b).setText(getResources().getString(c.a.a.a.b.i.adobe_csdk_leave_library_confirm_dialog_positive_button));
            if (this.f5681f) {
                this.f5676a.setText(getResources().getString(c.a.a.a.b.i.adobe_csdk_leave_library_confirm_dialog_message));
            } else {
                this.f5676a.setText(getResources().getString(c.a.a.a.b.i.adobe_csdk_leave_folder_confirm_dialog_message));
            }
        }
    }

    @Override // android.support.v4.app.DialogFragment
    public Dialog onCreateDialog(Bundle bundle) {
        Dialog onCreateDialog = super.onCreateDialog(bundle);
        onCreateDialog.getWindow().requestFeature(1);
        return onCreateDialog;
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(c.a.a.a.b.g.adobe_alert_dialog_view, viewGroup);
        this.f5676a = (TextView) inflate.findViewById(c.a.a.a.b.e.adobe_csdk_alert_dialog_box_title_text);
        this.f5677b = inflate.findViewById(c.a.a.a.b.e.adobe_csdk_alert_dialog_box_positive_button);
        this.f5678c = inflate.findViewById(c.a.a.a.b.e.adobe_csdk_alert_dialog_box_negative_button);
        ((TextView) this.f5678c).setText(getResources().getString(c.a.a.a.b.i.adobe_csdk_asset_view_edit_delete_dialog_negative_button));
        this.f5678c.setOnClickListener(new H(this));
        this.f5677b.setOnClickListener(new I(this));
        return inflate;
    }

    @Override // android.support.v4.app.DialogFragment, android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean("REMOVE_ALERT_IS_REMOVE", this.f5679d);
        bundle.putBoolean("REMOVE_ALERT_IS_REVOKE", this.f5680e);
        bundle.putBoolean("REMOVE_ALERT_IS_LIBRARY", this.f5681f);
    }

    @Override // android.support.v4.app.DialogFragment, android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        z();
    }

    @Override // android.support.v4.app.Fragment
    public void onViewStateRestored(Bundle bundle) {
        super.onViewStateRestored(bundle);
        if (bundle != null) {
            this.f5681f = bundle.getBoolean("REMOVE_ALERT_IS_LIBRARY");
            this.f5679d = bundle.getBoolean("REMOVE_ALERT_IS_REMOVE");
            this.f5680e = bundle.getBoolean("REMOVE_ALERT_IS_REVOKE");
        }
    }

    public void a(Zc zc) {
        this.f5682g = zc;
    }
}
