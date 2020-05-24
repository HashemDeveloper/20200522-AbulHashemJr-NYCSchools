package com.project.java.core.utils

import android.content.Context
import android.graphics.Color
import android.graphics.Typeface
import android.text.Spannable
import android.text.SpannableString
import android.text.SpannableStringBuilder
import android.text.style.RelativeSizeSpan
import android.text.style.StyleSpan
import androidx.appcompat.widget.AppCompatTextView
import androidx.swiperefreshlayout.widget.CircularProgressDrawable

class Constants {
    companion object {
        fun glideCircularAnim(context: Context): CircularProgressDrawable {
            val circularProgressDrawable = CircularProgressDrawable(context)
            circularProgressDrawable.strokeWidth = 5f
            circularProgressDrawable.centerRadius = 30f
            circularProgressDrawable.setColorSchemeColors(Color.GRAY)
            return circularProgressDrawable
        }
        fun getFirstWord(input: String): String {
            for (i in input.indices) {
                if (input[i] == ' ') {
                    return input.substring(0, i)
                }
            }
            return input
        }
        fun boldFirstWord(end: Int, sentence: String, textView: AppCompatTextView) {
            val fancySentence = SpannableStringBuilder(sentence)
            fancySentence.setSpan(
                StyleSpan(Typeface.BOLD),
                0,
                end,
                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
            )
            fancySentence.setSpan(RelativeSizeSpan(1.5f), 0, end, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
            textView.text = fancySentence
        }
    }
}