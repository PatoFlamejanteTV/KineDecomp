package com.facebook.internal;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;

/* loaded from: classes.dex */
public class FragmentWrapper {
    private Fragment nativeFragment;
    private android.support.v4.app.Fragment supportFragment;

    public FragmentWrapper(android.support.v4.app.Fragment fragment) {
        Validate.notNull(fragment, "fragment");
        this.supportFragment = fragment;
    }

    public final Activity getActivity() {
        android.support.v4.app.Fragment fragment = this.supportFragment;
        if (fragment != null) {
            return fragment.getActivity();
        }
        return this.nativeFragment.getActivity();
    }

    public Fragment getNativeFragment() {
        return this.nativeFragment;
    }

    public android.support.v4.app.Fragment getSupportFragment() {
        return this.supportFragment;
    }

    public void startActivityForResult(Intent intent, int i) {
        android.support.v4.app.Fragment fragment = this.supportFragment;
        if (fragment != null) {
            fragment.startActivityForResult(intent, i);
        } else {
            this.nativeFragment.startActivityForResult(intent, i);
        }
    }

    public FragmentWrapper(Fragment fragment) {
        Validate.notNull(fragment, "fragment");
        this.nativeFragment = fragment;
    }
}
