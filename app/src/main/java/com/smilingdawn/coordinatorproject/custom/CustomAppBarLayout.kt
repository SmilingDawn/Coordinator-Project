package com.smilingdawn.coordinatorproject.custom

import android.content.Context
import android.util.AttributeSet
import androidx.coordinatorlayout.widget.CoordinatorLayout
import com.google.android.material.appbar.AppBarLayout

/**
 * CollapsingToolbarLayout과 ViewPager2를 함께 사용할 경우
 * ViewPager의 page 변경 시 AppBarLayout에 스크롤이 동작하지 않는 이슈가 발생.
 * 스크롤 이슈를 해결하기 위해 CustomAppBarLayout를 적용.
 */
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