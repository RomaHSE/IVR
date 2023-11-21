package com.example.moneyway

import junit.framework.TestCase.assertFalse
import junit.framework.TestCase.assertTrue
import org.junit.Test

internal class RegisterActivityTest{

    var regActChecks = regActChecks()

    @Test
    fun arePasswordsNotIdentical(){
        val password1 = "Test1"
        val password2 = "Test2"
        assertFalse(regActChecks.checkPasswords(password1, password2))
    }

    @Test
    fun arePasswordsIdentical(){
        val password1 = "Test1"
        val password2 = "Test1"
        assertTrue(regActChecks.checkPasswords(password1, password2))
    }


}
