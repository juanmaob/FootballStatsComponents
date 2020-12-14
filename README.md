# FootballStatsComponents

**Are there any specific API/Data concerns to mention?**

There is no data from API for this test and actually it't not necesary to this test that it's about to create UI components.

**Please explain the UI/API contract to follow in case another developer**

There are three types of components to display the data in different ways and they work the same:

## Add to XML
```
<com.seventhson.footballstatscomponents.mainComponent.MainComponent
        android:id="@+id/mainComponent"
        android:layout_width="match_parent"
        android:layout_height="wrap_content">


<com.seventhson.footballstatscomponents.secondaryComponent.SecondaryComponent
        android:id="@+id/secondaryComponent"
        android:layout_width="match_parent"
        android:layout_height="wrap_content">
        
<com.seventhson.footballstatscomponents.mainComponent.MainComponent
        android:id="@+id/defaultComponent"
        android:layout_width="match_parent"
        android:layout_height="wrap_content">
        
```

## Use in Activity/Fragment
```
mainComponent.setTheme(MainComponent.COMPETITION_A)
mainComponent.setProgress(homeProgress = 40,visitorProgress =  60)
mainComponent.setLabel("Posession")

secondaryComponent.setTheme(MainComponent.COMPETITION_A)
secondaryComponent.setProgress(homeProgress = 80, visitorProgress =  83)
secondaryComponent.setLabel("Passing accuracy")

defaultComponent.setTheme(MainComponent.COMPETITION_A)
defaultComponent.setProgress(homeData = 619 , visitorData =  439)
defaultComponent.setLabel("Passes completed")
        
```

**Would you split this ticket into more granular pieces? How would you do it
if so?**

It could bbe separated by each of the different components, just because when you finish one of them, the rest of the team can use it without having to wait the others to finish

**What’s the unit test coverage followed on this PR?**

