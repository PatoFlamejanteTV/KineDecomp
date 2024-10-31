package com.nexstreaming.kinemaster.ui.projectedit;

import android.app.Activity;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.text.TextUtils;
import com.nexstreaming.app.general.iab.IABManager;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.kinemaster.layer.AssetLayer;
import com.nexstreaming.kinemaster.ui.projectedit.audioeffect.AudioViewType;
import com.nexstreaming.kinemaster.ui.projectedit.timeline.InterfaceC2025f;
import com.nexstreaming.kinemaster.ui.store.controller.StoreActivity;
import com.nexstreaming.kinemaster.usage.AssetStoreEntry;
import com.nextreaming.nexeditorui.ColorEffect;
import com.nextreaming.nexeditorui.NexAudioClipItem;
import com.nextreaming.nexeditorui.NexTimelineItem;
import com.nextreaming.nexeditorui.NexTransitionItem;
import com.nextreaming.nexvideoeditor.NexEditor;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ProjectEditActivity.java */
/* renamed from: com.nexstreaming.kinemaster.ui.projectedit.eg, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class RunnableC1885eg implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ NexTimelineItem f22328a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ C1947lg f22329b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC1885eg(C1947lg c1947lg, NexTimelineItem nexTimelineItem) {
        this.f22329b = c1947lg;
        this.f22328a = nexTimelineItem;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.lang.Runnable
    public void run() {
        boolean E;
        InterfaceC2025f interfaceC2025f;
        String equalizer;
        InterfaceC2025f interfaceC2025f2;
        boolean z;
        boolean z2;
        NexTimelineItem nexTimelineItem;
        InterfaceC2025f interfaceC2025f3;
        com.nexstreaming.app.general.nexasset.assetpackage.b c2;
        Activity u;
        NexEditor z3;
        InterfaceC2025f interfaceC2025f4;
        E = this.f22329b.f22438a.E();
        if (E) {
            this.f22329b.f22438a.ca = true;
            NexTimelineItem nexTimelineItem2 = this.f22328a;
            int i = R.id.optionPanelHolder;
            if (nexTimelineItem2 != null) {
                if (nexTimelineItem2 instanceof NexTransitionItem) {
                    if (this.f22329b.f22438a.pa()) {
                        return;
                    }
                } else if (nexTimelineItem2 instanceof NexAudioClipItem) {
                    String assetPackageId = ((NexAudioClipItem) nexTimelineItem2).getAssetPackageId();
                    if (!TextUtils.isEmpty(assetPackageId) && (c2 = com.nexstreaming.app.general.nexasset.assetpackage.h.e().c(assetPackageId)) != null && !TextUtils.isEmpty(c2.getPriceType()) && !this.f22329b.f22438a.y().t() && c2.getPriceType().equalsIgnoreCase("Premium")) {
                        this.f22329b.f22438a.getSupportFragmentManager().beginTransaction().replace(android.R.id.content, com.nexstreaming.kinemaster.ui.settings.tb.a(this.f22329b.f22438a.y(), 0, "timelineSelect", "Audio Asset"), com.nexstreaming.kinemaster.ui.settings.tb.f23200a).addToBackStack(com.nexstreaming.kinemaster.ui.settings.tb.f23200a).commitAllowingStateLoss();
                        this.f22329b.f22438a.ca = false;
                        return;
                    }
                }
                NexTimelineItem nexTimelineItem3 = this.f22328a;
                Class cls = null;
                if ((nexTimelineItem3 instanceof AssetLayer) && !((AssetLayer) nexTimelineItem3).isAvailableAsset(this.f22329b.f22438a.B(), this.f22329b.f22438a)) {
                    com.nexstreaming.app.general.nexasset.assetpackage.b assetPackage = com.nexstreaming.app.general.nexasset.assetpackage.h.e().a(((AssetLayer) this.f22328a).getEffectItemID()).getAssetPackage();
                    if (assetPackage.getPriceType() != null) {
                        if (assetPackage.getPriceType().equalsIgnoreCase("Premium")) {
                            if (this.f22329b.f22438a.y().q() == null) {
                                this.f22329b.f22438a.getSupportFragmentManager().beginTransaction().replace(android.R.id.content, com.nexstreaming.kinemaster.ui.settings.tb.a(this.f22329b.f22438a.y(), 0, "timelineSelect", "Layer Asset"), com.nexstreaming.kinemaster.ui.settings.tb.f23200a).addToBackStack(com.nexstreaming.kinemaster.ui.settings.tb.f23200a).commitAllowingStateLoss();
                                this.f22329b.f22438a.ca = false;
                                return;
                            }
                            return;
                        }
                        if (!assetPackage.getPriceType().equalsIgnoreCase("Paid") || c.d.b.m.b.a(assetPackage, this.f22329b.f22438a)) {
                            return;
                        }
                        int assetIdx = assetPackage.getAssetIdx();
                        String thumbUrl = assetPackage.getThumbUrl();
                        u = this.f22329b.f22438a.u();
                        Intent intent = new Intent(u, (Class<?>) StoreActivity.class);
                        z3 = this.f22329b.f22438a.z();
                        if (z3 != null && this.f22329b.f22438a.ja().t() != null) {
                            intent.putExtra("SELECTED_PROJECT", this.f22329b.f22438a.ja().t().getAbsolutePath());
                            intent.putExtra("IS_DIRECT_ASSET_DETAIL_FRAGMENT", true);
                            intent.putExtra("DIRECT_ASSET_DETAIL_FRAGMENT_ASSET_INDEX", assetIdx);
                            intent.putExtra("DIRECT_ASSET_DETAIL_FRAGMENT_ASSET_THUMBNAIL_URL", thumbUrl);
                            intent.putExtra("fromActivity", AssetStoreEntry.EDITING);
                            this.f22329b.f22438a.startActivity(intent);
                        }
                        this.f22329b.f22438a.ca = false;
                        this.f22329b.f22438a.ta = null;
                        interfaceC2025f4 = this.f22329b.f22438a.T;
                        interfaceC2025f4.d();
                        return;
                    }
                }
                if (!this.f22328a.isClipReady()) {
                    cls = Ad.class;
                } else if (!this.f22328a.checkResourceState(this.f22329b.f22438a)) {
                    cls = C1972oe.class;
                } else {
                    NexTimelineItem nexTimelineItem4 = this.f22328a;
                    if ((nexTimelineItem4 instanceof NexTransitionItem) && ((NexTransitionItem) nexTimelineItem4).getSideItemMinDuration() < 200) {
                        cls = C1981pe.class;
                    }
                }
                if (cls != null) {
                    this.f22329b.f22438a.pa();
                    this.f22329b.f22438a.f(true);
                    Bg bg = (Bg) Fragment.instantiate(this.f22329b.f22438a, cls.getCanonicalName());
                    bg.a((Bg) this.f22328a);
                    bg.a(new C1867cg(this));
                    FragmentTransaction a2 = ProjectEditActivity.a(this.f22329b.f22438a.getSupportFragmentManager().beginTransaction(), bg.ja());
                    if (bg.ja()) {
                        i = R.id.expandedOptionPanelHolder;
                    }
                    a2.replace(i, bg).addToBackStack("timeline_item_secondary").commit();
                    this.f22329b.f22438a.ca = false;
                    return;
                }
            }
            Fragment findFragmentById = this.f22329b.f22438a.getSupportFragmentManager().findFragmentById(R.id.expandedOptionPanelHolder);
            if (findFragmentById == null) {
                findFragmentById = this.f22329b.f22438a.getSupportFragmentManager().findFragmentById(R.id.optionPanelHolder);
            }
            if (findFragmentById instanceof Xb) {
                if (!this.f22329b.f22438a.C()) {
                    interfaceC2025f3 = this.f22329b.f22438a.T;
                    NexTimelineItem oldSelectedItem = interfaceC2025f3.getOldSelectedItem();
                    if ((oldSelectedItem instanceof NexTimelineItem.c) && this.f22329b.f22438a.ja().s().a().findItemByUniqueId(oldSelectedItem.getUniqueId()) != null) {
                        if (((NexTimelineItem.c) oldSelectedItem).getBlendMode().getPaidType() == IABManager.BillingType.PREMIUM) {
                            this.f22329b.f22438a.a("timelineSelect", "Blending");
                            z = true;
                        } else {
                            this.f22329b.f22438a.ja().J();
                            this.f22329b.f22438a.f(true);
                        }
                    } else {
                        this.f22329b.f22438a.f(true);
                    }
                } else {
                    this.f22329b.f22438a.ja().J();
                    this.f22329b.f22438a.f(true);
                }
                z = false;
            } else if (findFragmentById instanceof com.nexstreaming.kinemaster.ui.d.h) {
                if (!this.f22329b.f22438a.C()) {
                    interfaceC2025f2 = this.f22329b.f22438a.T;
                    NexTimelineItem oldSelectedItem2 = interfaceC2025f2.getOldSelectedItem();
                    if ((oldSelectedItem2 instanceof NexTimelineItem.h) && this.f22329b.f22438a.ja().s().a().findItemByUniqueId(oldSelectedItem2.getUniqueId()) != null) {
                        ColorEffect colorEffect = ((NexTimelineItem.h) oldSelectedItem2).getColorEffect();
                        if (colorEffect != null && colorEffect.getFilterType() != ColorEffect.FilterType.FILTER_TYPE_NONE && colorEffect.getFilterType() != ColorEffect.FilterType.FILTER_TYPE_BASIC) {
                            this.f22329b.f22438a.a("timelineSelect", "Color Filter");
                            z = true;
                        } else {
                            this.f22329b.f22438a.f(true);
                        }
                    } else {
                        this.f22329b.f22438a.f(true);
                    }
                } else {
                    this.f22329b.f22438a.ja().J();
                    this.f22329b.f22438a.f(true);
                }
                z = false;
            } else {
                if (findFragmentById instanceof com.nexstreaming.kinemaster.ui.projectedit.audioeffect.w) {
                    if (!this.f22329b.f22438a.C()) {
                        interfaceC2025f = this.f22329b.f22438a.T;
                        NexTimelineItem oldSelectedItem3 = interfaceC2025f.getOldSelectedItem();
                        if ((oldSelectedItem3 instanceof NexTimelineItem.b) && this.f22329b.f22438a.ja().s().a().findItemByUniqueId(oldSelectedItem3.getUniqueId()) != null) {
                            NexTimelineItem.b bVar = (NexTimelineItem.b) oldSelectedItem3;
                            if (((com.nexstreaming.kinemaster.ui.projectedit.audioeffect.w) findFragmentById).getViewType() == AudioViewType.VOICE_CHANGER) {
                                equalizer = bVar.getVoiceChanger();
                            } else {
                                equalizer = bVar.getEqualizer();
                            }
                            if (new com.nexstreaming.kinemaster.ui.projectedit.audioeffect.t().a(equalizer).d() == IABManager.BillingType.PREMIUM) {
                                this.f22329b.f22438a.a("timelineSelect", "Voice Changer");
                                z = true;
                            } else {
                                while (this.f22329b.f22438a.getSupportFragmentManager().getBackStackEntryCount() > 1) {
                                    this.f22329b.f22438a.getSupportFragmentManager().popBackStackImmediate();
                                }
                            }
                        } else {
                            while (this.f22329b.f22438a.getSupportFragmentManager().getBackStackEntryCount() > 1) {
                                this.f22329b.f22438a.getSupportFragmentManager().popBackStackImmediate();
                            }
                        }
                    } else {
                        this.f22329b.f22438a.ja().J();
                        while (this.f22329b.f22438a.getSupportFragmentManager().getBackStackEntryCount() > 1) {
                            this.f22329b.f22438a.getSupportFragmentManager().popBackStackImmediate();
                        }
                    }
                } else {
                    while (this.f22329b.f22438a.getSupportFragmentManager().getBackStackEntryCount() > 1) {
                        this.f22329b.f22438a.getSupportFragmentManager().popBackStackImmediate();
                    }
                }
                z = false;
            }
            if (this.f22329b.f22438a.getSupportFragmentManager().getBackStackEntryCount() == 1) {
                Fragment findFragmentById2 = this.f22329b.f22438a.getSupportFragmentManager().findFragmentById(R.id.optionPanelHolder);
                if (findFragmentById2 == null) {
                    findFragmentById2 = this.f22329b.f22438a.getSupportFragmentManager().findFragmentById(R.id.expandedOptionPanelHolder);
                }
                if (findFragmentById2 != null && (findFragmentById2 instanceof Bg) && (nexTimelineItem = this.f22328a) != null) {
                    Bg bg2 = (Bg) findFragmentById2;
                    if (nexTimelineItem.getClass() == bg2.Z()) {
                        bg2.a((Bg) this.f22328a);
                        if (findFragmentById2 instanceof Mb) {
                            ((Mb) findFragmentById2).za();
                        }
                        z = true;
                    }
                }
            }
            if (z) {
                this.f22329b.f22438a.a(this.f22328a, false);
                this.f22329b.f22438a.va();
                this.f22329b.f22438a.ca = false;
                this.f22329b.f22438a.Wa = false;
            }
            do {
            } while (this.f22329b.f22438a.getSupportFragmentManager().popBackStackImmediate());
            NexTimelineItem nexTimelineItem5 = this.f22328a;
            if (nexTimelineItem5 != null) {
                this.f22329b.f22438a.pa();
                Bg bg3 = (Bg) Fragment.instantiate(this.f22329b.f22438a, this.f22328a.getOptionMenuClass().getCanonicalName());
                bg3.a((Bg) this.f22328a);
                bg3.a(new C1876dg(this));
                FragmentTransaction a3 = ProjectEditActivity.a(this.f22329b.f22438a.getSupportFragmentManager().beginTransaction(), bg3.ja());
                if (bg3.ja()) {
                    i = R.id.expandedOptionPanelHolder;
                }
                a3.replace(i, bg3).addToBackStack("timeline_item_secondary").commit();
                if (bg3 instanceof Mb) {
                    ((Mb) bg3).za();
                }
                z2 = this.f22329b.f22438a.Wa;
                if (z2) {
                    FragmentTransaction a4 = ProjectEditActivity.a(this.f22329b.f22438a.getSupportFragmentManager().beginTransaction(), true);
                    com.nexstreaming.kinemaster.ui.assetbrowser.n nVar = new com.nexstreaming.kinemaster.ui.assetbrowser.n();
                    nVar.a((com.nexstreaming.kinemaster.ui.assetbrowser.n) this.f22328a);
                    a4.replace(R.id.expandedOptionPanelHolder, nVar).addToBackStack("timeline_item_sub").commit();
                }
            } else if (nexTimelineItem5 != null) {
                this.f22329b.f22438a.pa();
            }
            this.f22329b.f22438a.va();
            this.f22329b.f22438a.ca = false;
            this.f22329b.f22438a.Wa = false;
        }
    }
}
