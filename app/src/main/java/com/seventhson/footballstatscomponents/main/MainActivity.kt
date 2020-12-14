package com.seventhson.footballstatscomponents.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.seventhson.footballstatscomponents.R
import com.seventhson.footballstatscomponents.mainComponent.MainComponent
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainComponent.setTheme(MainComponent.COMPETITION_A)
        mainComponent.setProgress(25, 75)
        mainComponent.setLabel("Posesión")

        secondaryComponent.setTheme(MainComponent.COMPETITION_A)
        secondaryComponent.setProgress(80, 83)
        secondaryComponent.setLabel("Acierto pases")

        defaultComponent.setTheme(MainComponent.COMPETITION_A)
        defaultComponent.setProgress(500, 250)
        defaultComponent.setLabel("Prueba")

    }
}