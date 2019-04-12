package com.denwehrle.boilerplate.data

import javax.inject.Inject
import javax.inject.Singleton

/**
 * The [DataManager] is the single point of communication between the different layers.
 *
 * @author Dennis Wehrle
 */
@Singleton
class DataManager @Inject constructor() {

    private val exampleData = listOf("Page0", "Page1", "Page2", "Page3", "Page4", "Page5", "Page6", "Page7", "Page8", "Page9")

    fun getExampleDataByPosition(position: Int): String {
        return exampleData[position]
    }

    fun getExampleDataSize(): Int {
        return exampleData.size
    }
}
