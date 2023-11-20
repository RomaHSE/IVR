package com.example.moneyway

class AddSpendingChecks {
    fun isFormatDateOk(date: String) : Boolean{
        return (date[1] == '.' || date[2] == '.') && (date[4] == '.' || date[5] == '.')
    }
}