package com.jfalck.mooviz.feature.moviedetail.ui

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView

class GenresItemDecoration : RecyclerView.ItemDecoration() {

    //TODO enhance decoration

    private var space = 0
    private var item_count = 0
    private val ADDITIONAL_PADDING = 20

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        if (parent.getChildAdapterPosition(view) != item_count)
            outRect.bottom = space

        // Add top margin only for the first item to avoid double space between items
        if (parent.getChildAdapterPosition(view) == 0)
            outRect.right = space + ADDITIONAL_PADDING;
        if (parent.getChildAdapterPosition(view) == item_count)
            outRect.left = space + ADDITIONAL_PADDING;
    }

}
