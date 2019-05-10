package com.dataCache

import com.github.javafaker.Faker
import com.testData.DataCache
import com.testData.DataWarehouse

/**
 * Created by dtadin on 05/09/19.
 */

class DummyCache implements DataCache {

    public DummyCache(String cacheNameEntry) {
        this.createData()
        DataWarehouse.updateDataSources("dummyData", keyFromFeatureFile, this)
    }

    private Faker faker = new Faker()

    private Map dummyData = ["DummyId"      : '',
                             "DummyName"        : '',
                             "DummyDescription"  : '']


    void executeDataGeneration() {
        String fakerDummyId = UUID.randomUUID()
        String fakerDummyName = faker.name().title()
        this.dummyData.with {
            DummyId = fakerID
            EventCategory = 'Conference'
            DummyName = fakerTitle
            DummyDescription = 'Description'
        }
    }

    public Map getData() {
        return dummyData
    }

    public void updateData(Map updatedData) {
        for (p in updatedData) {
            this.dummyData.put(p.key, p.value)
        }
    }
}