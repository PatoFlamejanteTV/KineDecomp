package com.google.android.gms.location.places.ui;

import android.content.Intent;
import com.google.android.gms.common.GoogleApiAvailability;

/* loaded from: classes.dex */
public class PlacePicker {

    /* loaded from: classes.dex */
    public static class IntentBuilder {

        /* renamed from: a, reason: collision with root package name */
        private final Intent f1903a = new Intent("com.google.android.gms.location.places.ui.PICK_PLACE");

        public IntentBuilder() {
            this.f1903a.setPackage("com.google.android.gms");
            this.f1903a.putExtra("gmscore_client_jar_version", GoogleApiAvailability.f862a);
        }
    }
}
