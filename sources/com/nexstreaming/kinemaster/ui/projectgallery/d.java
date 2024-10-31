package com.nexstreaming.kinemaster.ui.projectgallery;

import android.content.Context;
import com.google.protos.datapol.SemanticAnnotations;
import com.nexstreaming.app.general.task.ResultTask;
import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.kinemaster.editorwrapper.C1780za;
import com.nextreaming.nexeditorui.NexAudioClipItem;
import com.nextreaming.nexeditorui.NexSecondaryTimelineItem;
import com.nextreaming.nexeditorui.NexTimeline;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DependencyChecker.java */
/* loaded from: classes2.dex */
public class D extends com.nexstreaming.kinemaster.editorwrapper.Aa {
    final /* synthetic */ ResultTask i;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public D(Context context, InputStream inputStream, boolean z, ResultTask resultTask) {
        super(context, inputStream, z);
        this.i = resultTask;
    }

    @Override // com.nexstreaming.kinemaster.editorwrapper.Aa
    protected void a(Task.TaskError taskError) {
        this.i.sendFailure(taskError);
    }

    @Override // com.nexstreaming.kinemaster.editorwrapper.Aa
    protected void a(NexTimeline nexTimeline) {
    }

    @Override // com.nexstreaming.kinemaster.editorwrapper.Aa
    protected void b(C1780za c1780za) {
        com.nexstreaming.app.general.nexasset.assetpackage.r a2;
        com.nexstreaming.app.general.nexasset.assetpackage.p assetSubCategory;
        if (c1780za != null && c1780za.a() != null) {
            ArrayList<NexSecondaryTimelineItem> arrayList = new ArrayList();
            arrayList.addAll(c1780za.a().getSecondaryItems());
            ArrayList arrayList2 = new ArrayList();
            for (NexSecondaryTimelineItem nexSecondaryTimelineItem : arrayList) {
                if (nexSecondaryTimelineItem instanceof NexAudioClipItem) {
                    arrayList2.add((NexAudioClipItem) nexSecondaryTimelineItem);
                }
            }
            int totalTime = c1780za.a().getTotalTime();
            boolean z = false;
            Iterator it = arrayList2.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                NexAudioClipItem nexAudioClipItem = (NexAudioClipItem) it.next();
                String musicAssetId = nexAudioClipItem.getMusicAssetId();
                if (musicAssetId != null && (a2 = com.nexstreaming.app.general.nexasset.assetpackage.h.e().a(musicAssetId.substring(musicAssetId.indexOf(47) + 1))) != null && a2.getAssetPackage() != null && (assetSubCategory = a2.getAssetPackage().getAssetSubCategory()) != null && assetSubCategory.getSubCategoryId() == 16 && nexAudioClipItem.getRelativeStartTime() + SemanticAnnotations.SemanticType.ST_THIRD_PARTY_DATA_VALUE <= totalTime) {
                    z = true;
                    break;
                }
            }
            this.i.sendResult(Boolean.valueOf(z));
            return;
        }
        this.i.sendFailure(new C(this));
    }
}
