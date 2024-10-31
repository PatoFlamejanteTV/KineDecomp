package org.keyczar;

import java.util.concurrent.ConcurrentLinkedQueue;
import org.keyczar.interfaces.Stream;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class StreamQueue<T extends Stream> extends ConcurrentLinkedQueue<T> {
    private static final long serialVersionUID = 4914617278167817144L;
}
