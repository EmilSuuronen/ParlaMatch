package com.example.project.adapters

import android.widget.ImageView
import android.widget.TextView
import androidx.core.net.toUri
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.example.project.R


/* Emil Suuronen - 1909931
1.10.2022
 */

// Binding abbreviations to correct names
@BindingAdapter("party")
fun TextView.partyAbbreviation(party: String) {
    text = (when (party) {
        "kd" -> "Kristillisdemokraatit"
        "kok" -> "Kokoomus"
        "kesk" -> "Keskusta"
        "liik" -> "Liike Nyt"
        "ps" -> "Perussuomalaiset"
        "sd" -> "Sosiaalidemokraatit"
        "r" -> "Ruotsalainen Kansanpuolue"
        "vihr" -> "Vihreät"
        "vas" -> "Vasemmistoliitto"
        else -> "unknown party"
    })
}

//Adapter to bind images to imageView
@BindingAdapter("mepImg")
fun imageBind(imageView: ImageView, picture: String?) {
    picture?.let {
        val mepImg =  "https://avoindata.eduskunta.fi/$picture"
        val imgUri = mepImg.toUri()
            .buildUpon()
            .scheme("https")
            .build()
        Glide
            .with(imageView.context)
            .load(imgUri)
            .placeholder(R.drawable.ic_baseline_error_24)
            .diskCacheStrategy(DiskCacheStrategy.ALL)
            .into(imageView)
    }
}

// adapter to calculate year from current year
@BindingAdapter("bornYear")
fun setAge(textView: TextView, bornYear: Int){
    textView.text = ", " + "${2022 - bornYear}"
}

//adapter to set seat number to view
@BindingAdapter("seatNumber")
fun setConstituency(textView: TextView, seatNumber: Int){
    textView.text = ", " + "${seatNumber}"
}