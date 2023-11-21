package com.example.moneyway

import junit.framework.TestCase.assertTrue
import org.junit.Test

class AddSpendingActivityTest{

    @Test
    fun isDateFormatOk(){
        val date = "06.12.2023"
        var addSpendingChecks = AddSpendingChecks()
        assertTrue(addSpendingChecks.isFormatDateOk(date))
    }
}
