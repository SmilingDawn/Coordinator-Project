# Coordinator-Project
Coordinator + TabLayout + ViewPager2를 이용한 UI Project

### 1. 문제점
* CollapsingToolbarLayout과 ViewPager2를 함께 사용할 경우 ViewPager2 page 변경 시 
스크롤 터치가 동작하지 않는 이슈가 있어 AppBarLayout을 커스텀하여 해결

### 2. Code
<pre>
<code>
class CustomAppBarLayout @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : AppBarLayout(context, attrs, defStyleAttr) {

    override fun getBehavior(): CoordinatorLayout.Behavior<AppBarLayout> {
        return Behavior().also {
            it.setDragCallback(object : Behavior.DragCallback() {
                override fun canDrag(appBarLayout: AppBarLayout) = true
            })
        }
    }
}
</code>
</pre>

### 3. xml
```
<layout
    xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools">

    <androidx.coordinatorlayout.widget.CoordinatorLayout
        android:layout_width="match_parent"
        android:layout_height="match_parent">

        <com.smilingdawn.coordinatorproject.custom.CustomAppBarLayout
            android:layout_width="match_parent"
            android:layout_height="wrap_content">

            <com.google.android.material.appbar.CollapsingToolbarLayout
                android:layout_width="match_parent"
                android:layout_height="250dp"
                app:contentScrim="@color/white"
                app:scrimAnimationDuration="0"
                app:scrimVisibleHeightTrigger="0dp"
                app:layout_scrollFlags="scroll|exitUntilCollapsed">

                <androidx.constraintlayout.widget.ConstraintLayout
                    android:layout_width="match_parent"
                    android:layout_height="match_parent" >

                    <ImageView
                        android:layout_width="match_parent"
                        android:layout_height="match_parent" />

                </androidx.constraintlayout.widget.ConstraintLayout>

            </com.google.android.material.appbar.CollapsingToolbarLayout>

            <com.google.android.material.tabs.TabLayout
                android:id="@+id/tablayout"
                android:layout_width="match_parent"
                android:layout_height="50dp"
                app:tabGravity="fill"
                app:tabMode="fixed"/>

        </com.smilingdawn.coordinatorproject.custom.CustomAppBarLayout>

        <androidx.viewpager2.widget.ViewPager2
            android:id="@+id/viewpager"
            android:layout_width="match_parent"
            android:layout_height="match_parent"
            app:layout_behavior="@string/appbar_scrolling_view_behavior"/>

    </androidx.coordinatorlayout.widget.CoordinatorLayout>
</layout>
```

