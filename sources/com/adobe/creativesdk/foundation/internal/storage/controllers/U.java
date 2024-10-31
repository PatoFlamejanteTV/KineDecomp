package com.adobe.creativesdk.foundation.internal.storage.controllers;

import android.R;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.adobe.creativesdk.foundation.adobeinternal.cloud.AdobeCloud;
import com.adobe.creativesdk.foundation.adobeinternal.cloud.AdobeCloudServiceType;
import com.adobe.creativesdk.foundation.auth.AdobeAuthUserProfile;

/* compiled from: AdobeStorageSettingsFragment.java */
/* loaded from: classes.dex */
public class U extends Fragment {

    /* renamed from: a */
    private LinearLayout f5849a;

    /* renamed from: b */
    private LinearLayout f5850b;

    /* renamed from: c */
    private boolean f5851c;

    @Override // android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setHasOptionsMenu(false);
    }

    @Override // android.support.v4.app.Fragment
    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        super.onCreateOptionsMenu(menu, menuInflater);
        menu.clear();
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        com.adobe.creativesdk.foundation.internal.storage.controllers.actionbar.a.a(getResources().getString(c.a.a.a.b.i.adobe_csdk_uxassetbrowser_myacount));
        View inflate = layoutInflater.inflate(c.a.a.a.b.g.adobe_storage_settings_fragment, viewGroup, false);
        setHasOptionsMenu(true);
        this.f5850b = (LinearLayout) inflate.findViewById(c.a.a.a.b.e.adobe_csdk_storage_settings_switchAccounts);
        this.f5850b.setOnClickListener(new Q(this));
        this.f5849a = (LinearLayout) inflate.findViewById(c.a.a.a.b.e.adobe_csdk_storage_settings_editCCSettings);
        this.f5849a.setOnClickListener(new S(this));
        a(inflate);
        return inflate;
    }

    @Override // android.support.v4.app.Fragment
    public void onPrepareOptionsMenu(Menu menu) {
        super.onPrepareOptionsMenu(menu);
        com.adobe.creativesdk.foundation.internal.utils.b.a(getActivity().findViewById(R.id.content), getString(c.a.a.a.b.i.adobe_csdk_uxassetbrowser_sdk_myaccount));
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        this.f5851c = false;
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        this.f5851c = true;
    }

    private void a(View view) {
        AdobeAuthUserProfile b2 = com.adobe.creativesdk.foundation.auth.k.a().b();
        ((TextView) view.findViewById(c.a.a.a.b.e.adobe_csdk_storage_settings_userName)).setText(b2.getDisplayName());
        ((TextView) view.findViewById(c.a.a.a.b.e.adobe_csdk_storage_settings_userEmailId)).setText(b2.getEmail());
        AdobeCloud adobeCloud = (AdobeCloud) getArguments().getSerializable("ADOBE_CLOUD");
        if (adobeCloud.isQuotaEnabled()) {
            ((com.adobe.creativesdk.foundation.internal.storage.a.b.ra) adobeCloud.getSessionForService(AdobeCloudServiceType.AdobeCloudServiceTypeStorage)).a(new T(this, view), new Handler());
        }
    }

    public void a(View view, String str) {
        try {
            startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
        } catch (ActivityNotFoundException unused) {
        }
    }
}
