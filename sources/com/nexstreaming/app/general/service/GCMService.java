package com.nexstreaming.app.general.service;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.facebook.share.internal.ShareConstants;
import com.google.android.gms.gcm.GcmListenerService;
import com.nexstreaming.app.general.service.notification.NotificationData;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.kinemaster.ui.projectgallery.ProjectGalleryActivity;

/* loaded from: classes.dex */
public class GCMService extends GcmListenerService {
    @Override // com.google.android.gms.gcm.GcmListenerService
    public void a(String str, Bundle bundle) {
        super.a(str, bundle);
        if (bundle != null) {
            String string = bundle.getString(ShareConstants.WEB_DIALOG_PARAM_ID);
            String string2 = bundle.getString(ShareConstants.WEB_DIALOG_PARAM_TITLE);
            String string3 = bundle.getString(ShareConstants.WEB_DIALOG_PARAM_MESSAGE);
            String string4 = bundle.getString("mp_message");
            String string5 = bundle.getString("image");
            String string6 = bundle.getString("uri");
            boolean parseBoolean = Boolean.parseBoolean(bundle.getString("large"));
            int i = 85;
            try {
                i = Integer.parseInt(string.trim());
            } catch (Exception e) {
                e.printStackTrace();
            }
            Log.i("GCMService", "onMessageReceived pushId : " + i);
            Log.i("GCMService", "onMessageReceived title : " + string2);
            Log.i("GCMService", "onMessageReceived message : " + string3);
            Log.i("GCMService", "onMessageReceived image: " + string5);
            Log.i("GCMService", "onMessageReceived uri : " + string6);
            Log.i("GCMService", "onMessageReceived large : " + parseBoolean);
            NotificationData notificationData = new NotificationData();
            notificationData.id = i;
            notificationData.message = TextUtils.isEmpty(string4) ? string3 : string4;
            notificationData.targetClass = ProjectGalleryActivity.class.getName();
            notificationData.title = TextUtils.isEmpty(string2) ? getString(R.string.app_name) : string2;
            notificationData.hasLarge = parseBoolean;
            notificationData.uri = string6;
            NexNotificationService.a(this, notificationData);
        }
    }
}
