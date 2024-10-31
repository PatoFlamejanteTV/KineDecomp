package com.mixpanel.android.mpmetrics;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import com.mixpanel.android.mpmetrics.UpdateDisplayState;

/* compiled from: InAppFragment.java */
/* loaded from: classes.dex */
class k implements GestureDetector.OnGestureListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ g f3035a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(g gVar) {
        this.f3035a = gVar;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onDown(MotionEvent motionEvent) {
        return true;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        if (f2 > 0.0f) {
            this.f3035a.b();
            return true;
        }
        return true;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public void onLongPress(MotionEvent motionEvent) {
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public void onShowPress(MotionEvent motionEvent) {
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onSingleTapUp(MotionEvent motionEvent) {
        UpdateDisplayState.DisplayState.InAppNotificationState inAppNotificationState;
        Activity activity;
        n nVar;
        inAppNotificationState = this.f3035a.f;
        InAppNotification c = inAppNotificationState.c();
        String k = c.k();
        if (k != null && k.length() > 0) {
            try {
                Uri parse = Uri.parse(k);
                try {
                    Intent intent = new Intent("android.intent.action.VIEW", parse);
                    activity = this.f3035a.b;
                    activity.startActivity(intent);
                    nVar = this.f3035a.f3030a;
                    nVar.c().a("$campaign_open", c);
                } catch (ActivityNotFoundException e) {
                    Log.i("MixpanelAPI.InAppFrag", "User doesn't have an activity for notification URI " + parse);
                }
            } catch (IllegalArgumentException e2) {
                Log.i("MixpanelAPI.InAppFrag", "Can't parse notification URI, will not take any action", e2);
            }
        }
        this.f3035a.b();
        return true;
    }
}
