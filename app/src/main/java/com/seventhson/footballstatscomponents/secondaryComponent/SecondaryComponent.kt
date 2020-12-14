package com.seventhson.footballstatscomponents.secondaryComponent

import android.content.Context
import android.content.res.ColorStateList
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat.getColor
import com.seventhson.footballstatscomponents.R
import kotlinx.android.synthetic.main.secondary_component_layout.view.*

class SecondaryComponent @JvmOverloads constructor(
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
            .inflate(R.layout.secondary_component_layout, this, true)

        attrs?.let {
            val typedArray = context.obtainStyledAttributes(it, R.styleable.main_component_attributes, 0, 0)
            val label = resources.getText(typedArray.getResourceId(R.styleable.main_component_attributes_label, R.string.label_default_value))

            tvLabel.text = label

            typedArray.recycle()

        }
    }

    fun setTheme(competition: Int) {
        when(competition) {
            COMPETITION_A -> {
                setHomeColor(getColor(context, R.color.purple_500))
                setVisitorColor(getColor(context, R.color.teal_200))
            }
            COMPETITION_B -> {
                setHomeColor(getColor(context, R.color.orange))
                setVisitorColor(getColor(context, R.color.yellow))
            }
        }
    }

    fun setLabel(label: String) {
        tvLabel.text = label
    }

    private fun setHomePercentage(percentage: String) {
        tvHomePercentage.text = percentage
    }

    private fun setVisitorPercentage(percentage: String) {
        tvVisitorPercentage.text = percentage
    }

    private fun setHomeColor(color: Int) {
        pbHomePercentage.progressTintList = ColorStateList.valueOf(color)
        pbHomePercentage.progressBackgroundTintList = ColorStateList.valueOf(getColor(context, R.color.grey))
    }

    private fun setVisitorColor(color: Int) {
        pbVisitorPercentage.progressTintList = ColorStateList.valueOf(color)
        pbVisitorPercentage.progressBackgroundTintList = ColorStateList.valueOf(getColor(context, R.color.grey))
    }

    fun setProgress(homeProgress: Int, visitorProgress: Int) {
        pbHomePercentage.progress = visitorProgress
        pbVisitorPercentage.progress = visitorProgress
        setHomePercentage("${homeProgress}%")
        setVisitorPercentage("${visitorProgress}%")
    }

}