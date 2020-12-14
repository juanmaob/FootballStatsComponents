package com.seventhson.footballstatscomponents.defaultComponent

import android.content.Context
import android.content.res.ColorStateList
import android.graphics.BlendMode
import android.graphics.BlendModeColorFilter
import android.graphics.PorterDuff
import android.graphics.drawable.LayerDrawable
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import androidx.core.content.ContextCompat.getColor
import com.seventhson.footballstatscomponents.R
import kotlinx.android.synthetic.main.default_component_layout.view.*

class DefaultComponent @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyle: Int = 0,
    defStyleRes: Int = 0
) : ConstraintLayout(context, attrs, defStyle, defStyleRes) {

    companion object {
        const val COMPETITION_A = 0
        const val COMPETITION_B = 1
    }

    init {
        LayoutInflater.from(context)
            .inflate(R.layout.default_component_layout, this, true)

        attrs?.let {
            val typedArray =
                context.obtainStyledAttributes(it, R.styleable.main_component_attributes, 0, 0)
            val label = resources.getText(
                typedArray.getResourceId(
                    R.styleable.main_component_attributes_label,
                    R.string.label_default_value
                )
            )

            tvLabel.text = label

            typedArray.recycle()

        }
    }

    fun setTheme(competition: Int) {
        when (competition) {
            COMPETITION_A -> {
                setHomeColor(R.color.purple_500)
                setVisitorColor(getColor(context, R.color.teal_200))
            }
            COMPETITION_B -> {
                setHomeColor(R.color.orange)
                setVisitorColor(getColor(context, R.color.yellow))
            }
        }
    }

    fun setLabel(label: String) {
        tvLabel.text = label
    }

    private fun setHomeData(data: String) {
        tvHomeData.text = data
    }

    private fun setVisitorData(data: String) {
        tvVisitorData.text = data
    }

    private fun setHomeColor(color: Int) {
        pbData.progressBackgroundTintList = ColorStateList.valueOf(color)
    }

    private fun setVisitorColor(color: Int) {
        pbData.progressTintList = ColorStateList.valueOf(color)
    }

    fun setProgress(homeData: Int, visitorData: Int) {
        pbData.max = homeData + visitorData
        pbData.progress = visitorData
        setHomeData("$homeData")
        setVisitorData("$visitorData")
    }

}