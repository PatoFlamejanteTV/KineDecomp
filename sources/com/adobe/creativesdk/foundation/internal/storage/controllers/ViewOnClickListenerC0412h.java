package com.adobe.creativesdk.foundation.internal.storage.controllers;

import android.app.AlertDialog;
import android.content.Intent;
import android.view.View;
import com.adobe.creativesdk.foundation.adobeinternal.cloud.AdobeEntitlementServices;
import com.adobe.creativesdk.foundation.internal.storage.AdobeAssetFileInternal;

/* compiled from: AdobeAssetOneUpSinglePageCellView.java */
/* renamed from: com.adobe.creativesdk.foundation.internal.storage.controllers.h */
/* loaded from: classes.dex */
public class ViewOnClickListenerC0412h implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ C0417i f6101a;

    public ViewOnClickListenerC0412h(C0417i c0417i) {
        this.f6101a = c0417i;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int i;
        String e2;
        String e3;
        int i2;
        C0417i c0417i = this.f6101a;
        if (c0417i.f6084a == null) {
            return;
        }
        C0469s a2 = c0417i.i.a();
        i = this.f6101a.m;
        AdobeAssetFileInternal adobeAssetFileInternal = (AdobeAssetFileInternal) a2.a(i);
        if (adobeAssetFileInternal.canStreamVideo()) {
            Intent intent = new Intent();
            intent.setClass(this.f6101a.f6084a, AdobeUXAssetVideoActivity.class);
            intent.putExtra("current_asset_name", adobeAssetFileInternal.getName());
            intent.putExtra("current_asset_guid", adobeAssetFileInternal.getGUID());
            i2 = this.f6101a.m;
            intent.putExtra("current_asset_position", i2);
            intent.putExtra("one_up_controller_code", this.f6101a.g());
            this.f6101a.f6084a.startActivity(intent);
            return;
        }
        if (!AdobeEntitlementServices.b().a("ccv", adobeAssetFileInternal.getCloud())) {
            this.f6101a.b(c.a.a.a.b.i.adobe_csdk_error_not_entitled_to_video);
            return;
        }
        AlertDialog.Builder title = new AlertDialog.Builder(this.f6101a.f6084a).setTitle("");
        e2 = this.f6101a.e(c.a.a.a.b.i.adobe_csdk_asset_one_up_view_video_alert_message);
        AlertDialog.Builder cancelable = title.setMessage(e2).setCancelable(false);
        e3 = this.f6101a.e(c.a.a.a.b.i.adobe_csdk_asset_one_up_view_video_alert_button);
        cancelable.setPositiveButton(e3, new DialogInterfaceOnClickListenerC0407g(this)).create().show();
    }
}
