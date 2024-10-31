package com.adobe.creativesdk.foundation.internal.storage.controllers.libraryedit;

import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.adobe.creativesdk.foundation.storage.AdobeCollaborationType;
import com.adobe.creativesdk.foundation.storage.C0614ub;

/* compiled from: AdobeLibraryDeleteAlert.java */
/* loaded from: classes.dex */
public class t extends DialogFragment {

    /* renamed from: a */
    private TextView f6245a;

    /* renamed from: b */
    private View f6246b;

    /* renamed from: c */
    private View f6247c;

    /* renamed from: d */
    private boolean f6248d;

    /* renamed from: e */
    private C0614ub f6249e;

    @Override // android.support.v4.app.DialogFragment
    public Dialog onCreateDialog(Bundle bundle) {
        Dialog onCreateDialog = super.onCreateDialog(bundle);
        onCreateDialog.getWindow().requestFeature(1);
        return onCreateDialog;
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(c.a.a.a.b.g.adobe_alert_dialog_view, viewGroup);
        this.f6245a = (TextView) inflate.findViewById(c.a.a.a.b.e.adobe_csdk_alert_dialog_box_title_text);
        this.f6246b = inflate.findViewById(c.a.a.a.b.e.adobe_csdk_alert_dialog_box_positive_button);
        this.f6247c = inflate.findViewById(c.a.a.a.b.e.adobe_csdk_alert_dialog_box_negative_button);
        this.f6247c.setOnClickListener(new o(this));
        if (this.f6248d) {
            this.f6245a.setText(getResources().getString(c.a.a.a.b.i.adobe_csdk_asset_view_edit_unsuscribe_dialog_message));
            ((TextView) this.f6247c).setText(getResources().getString(c.a.a.a.b.i.adobe_csdk_unsuscribe_confirm_dialog_negative_button));
            ((TextView) this.f6246b).setText(getResources().getString(c.a.a.a.b.i.adobe_csdk_unsuscribe_confirm_dialog_positive_button));
            this.f6246b.setOnClickListener(new q(this));
        } else {
            ((TextView) this.f6247c).setText(getResources().getString(c.a.a.a.b.i.adobe_csdk_asset_view_edit_delete_dialog_negative_button));
            AdobeCollaborationType f2 = this.f6249e.f();
            if (!this.f6249e.q() && !f2.equals(AdobeCollaborationType.ADOBE_COLLABORATION_TYPE_SHAREDWITHUSER)) {
                ((TextView) this.f6246b).setText(getResources().getString(c.a.a.a.b.i.adobe_csdk_asset_view_edit_delete_dialog_positive_button));
                this.f6245a.setText(getResources().getString(c.a.a.a.b.i.adobe_csdk_asset_view_library_composite_edit_delete_dialog_message));
            } else {
                ((TextView) this.f6246b).setText(getResources().getString(c.a.a.a.b.i.adobe_csdk_leave_library_confirm_dialog_positive_button));
                this.f6245a.setText(getResources().getString(c.a.a.a.b.i.adobe_csdk_leave_library_confirm_dialog_message));
            }
            this.f6246b.setOnClickListener(new s(this));
        }
        return inflate;
    }

    public void a(C0614ub c0614ub) {
        this.f6249e = c0614ub;
        this.f6248d = this.f6249e.p();
    }
}
