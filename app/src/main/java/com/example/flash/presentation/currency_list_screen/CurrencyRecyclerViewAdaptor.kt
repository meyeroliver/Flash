package com.example.flash.presentation.currency_list_screen

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.flash.R
import com.example.flash.domain.models.Currency

class CurrencyRecyclerViewAdaptor : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var items: List<Currency> = ArrayList();

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return CurrencyViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.currency_list_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(holder){
            is CurrencyViewHolder ->{
                holder.bind(items[position])
            }
        }
    }

    fun setList(currencyList: List<Currency>){
        items = currencyList
    }

    override fun getItemCount(): Int {
        return items.size;
    }

    class CurrencyViewHolder constructor(
        itemView: View
    ): RecyclerView.ViewHolder(itemView){
        private val currencyValue: TextView = itemView.findViewById(R.id.currency_value)
        private val currencySymbol: TextView = itemView.findViewById(R.id.currency_symbol)

        fun bind(currency: Currency){
            currencyValue.text = currency.value.toString()
            currencySymbol.text = currency.symbol
        }
    }
}