package com.testData

import com.dataCaches.DataCache

/**
 * Created by dtadin on 05/09/19.
 */

class DataWarehouse {

    public DataWarehouse() {
    }

    private static Map<String, Map<String, DataCache>> dataCaches = ["DummyData": [:]]

    public static Map getDataCacheMap(String dataCacheType) {
        return dataCaches[dataCacheType]
    }

    public static DataCache getDataCache(String dataCacheType, String dataCacheId) {
        if (dataCaches[dataCacheType].containsKey(dataCacheId)) {
            return dataCaches[dataCacheType].get(dataCacheId)
        } else {
            println("dataCacheType: " + dataCacheType)
            println("dataCacheId: " + dataCacheId)
            println("Invalid dataSource")
        }
    }

    public static void updateDataSources(String dataCacheType, String dataCacheId, DataCache dataCache) {
        if (dataCaches.containsKey(dataCacheType)) {
            ((Map) dataCaches.getAt(dataCacheType)).put(dataCacheId, dataCache)
        }
        Map c = [:]
        c.put(dataCacheId, dataCache)

        dataCaches[dataCacheType].putAll(c)
    }
}