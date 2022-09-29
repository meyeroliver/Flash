package com.example.flash

import com.example.flash.models.Currency

class DataSource {

    companion object{
        fun createDataSet(): ArrayList<Currency>{
            val list = ArrayList<Currency>()
            list.add(Currency(1.0,"BTC"))
            list.add(Currency(19403.99,"USD"))
            list.add(Currency(349154.74,"ZAR"))
            list.add(Currency(30045.04,"AUD"))

            return list;
        }
    }
}