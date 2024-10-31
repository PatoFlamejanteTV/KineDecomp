package com.nexstreaming.app.kinemasterfree;

import android.databinding.ViewDataBinding;
import android.databinding.d;
import android.util.SparseIntArray;
import android.view.View;
import com.nexstreaming.app.kinemasterfree.a.f;
import com.nexstreaming.app.kinemasterfree.a.h;
import com.nexstreaming.app.kinemasterfree.a.j;
import com.nexstreaming.app.kinemasterfree.a.l;
import com.nexstreaming.app.kinemasterfree.a.n;
import com.nexstreaming.app.kinemasterfree.a.p;
import com.nexstreaming.app.kinemasterfree.a.r;
import com.nexstreaming.app.kinemasterfree.a.t;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public class DataBinderMapperImpl extends android.databinding.c {

    /* renamed from: a, reason: collision with root package name */
    private static final SparseIntArray f19910a = new SparseIntArray(10);

    static {
        f19910a.put(R.layout.activity_asset_update, 1);
        f19910a.put(R.layout.activity_permission_rationale, 2);
        f19910a.put(R.layout.audio_level_meter_fragment, 3);
        f19910a.put(R.layout.camcorder_main_activity, 4);
        f19910a.put(R.layout.clip_info_popup, 5);
        f19910a.put(R.layout.device_capability_profile_importer, 6);
        f19910a.put(R.layout.fragment_adview_admob, 7);
        f19910a.put(R.layout.fragment_track_option, 8);
        f19910a.put(R.layout.item_db_profile_list, 9);
        f19910a.put(R.layout.item_file_profile_list, 10);
    }

    @Override // android.databinding.c
    public ViewDataBinding a(d dVar, View view, int i) {
        int i2 = f19910a.get(i);
        if (i2 <= 0) {
            return null;
        }
        Object tag = view.getTag();
        if (tag != null) {
            switch (i2) {
                case 1:
                    if ("layout/activity_asset_update_0".equals(tag)) {
                        return new com.nexstreaming.app.kinemasterfree.a.b(dVar, view);
                    }
                    throw new IllegalArgumentException("The tag for activity_asset_update is invalid. Received: " + tag);
                case 2:
                    if ("layout/activity_permission_rationale_0".equals(tag)) {
                        return new com.nexstreaming.app.kinemasterfree.a.d(dVar, view);
                    }
                    throw new IllegalArgumentException("The tag for activity_permission_rationale is invalid. Received: " + tag);
                case 3:
                    if ("layout/audio_level_meter_fragment_0".equals(tag)) {
                        return new f(dVar, view);
                    }
                    throw new IllegalArgumentException("The tag for audio_level_meter_fragment is invalid. Received: " + tag);
                case 4:
                    if ("layout/camcorder_main_activity_0".equals(tag)) {
                        return new h(dVar, view);
                    }
                    throw new IllegalArgumentException("The tag for camcorder_main_activity is invalid. Received: " + tag);
                case 5:
                    if ("layout/clip_info_popup_0".equals(tag)) {
                        return new j(dVar, view);
                    }
                    throw new IllegalArgumentException("The tag for clip_info_popup is invalid. Received: " + tag);
                case 6:
                    if ("layout/device_capability_profile_importer_0".equals(tag)) {
                        return new l(dVar, view);
                    }
                    throw new IllegalArgumentException("The tag for device_capability_profile_importer is invalid. Received: " + tag);
                case 7:
                    if ("layout/fragment_adview_admob_0".equals(tag)) {
                        return new n(dVar, view);
                    }
                    throw new IllegalArgumentException("The tag for fragment_adview_admob is invalid. Received: " + tag);
                case 8:
                    if ("layout/fragment_track_option_0".equals(tag)) {
                        return new p(dVar, view);
                    }
                    throw new IllegalArgumentException("The tag for fragment_track_option is invalid. Received: " + tag);
                case 9:
                    if ("layout/item_db_profile_list_0".equals(tag)) {
                        return new r(dVar, view);
                    }
                    throw new IllegalArgumentException("The tag for item_db_profile_list is invalid. Received: " + tag);
                case 10:
                    if ("layout/item_file_profile_list_0".equals(tag)) {
                        return new t(dVar, view);
                    }
                    throw new IllegalArgumentException("The tag for item_file_profile_list is invalid. Received: " + tag);
                default:
                    return null;
            }
        }
        throw new RuntimeException("view must have a tag");
    }

    @Override // android.databinding.c
    public ViewDataBinding a(d dVar, View[] viewArr, int i) {
        if (viewArr == null || viewArr.length == 0 || f19910a.get(i) <= 0 || viewArr[0].getTag() != null) {
            return null;
        }
        throw new RuntimeException("view must have a tag");
    }

    @Override // android.databinding.c
    public List<android.databinding.c> a() {
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(new com.android.databinding.library.baseAdapters.DataBinderMapperImpl());
        return arrayList;
    }
}
