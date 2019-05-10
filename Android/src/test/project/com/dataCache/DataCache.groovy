package com.dataCache

/**
 * Created by dtadin on 05/09/19.
 */
interface DataCache {

    void executeDataGeneration();

    Map getData();

    void updateData(Map m);

}