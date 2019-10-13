package org.learn.threads;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by vinay on 21/9/19.
 */
public class PropertyContainer {
    List<String> properties;
    private Integer counter = 0;

    public PropertyContainer(List<String> properties) {
        this.properties = properties;
    }

    public List<String> nextBatch(int batchSize) {
        if (counter > properties.size()) {
            return Collections.emptyList();
        }
        int endIndex = counter.intValue() + batchSize < properties.size() ? counter.intValue() + batchSize : properties.size();
        List<String> batch = properties.subList(counter.intValue(), endIndex);
        synchronized (counter) {
            counter = counter.intValue() + batchSize;
        }
        return  batch;
    }
}
