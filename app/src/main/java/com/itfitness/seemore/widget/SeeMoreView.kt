package com.itfitness.seemore.widget

import android.content.Context
import android.util.AttributeSet
import android.util.Log
import android.view.View
import android.widget.FrameLayout
import com.itfitness.seemore.R
import kotlinx.android.synthetic.main.view_seemore.view.*

class SeeMoreView:FrameLayout {
    private var mIsShowAll:Boolean = false
    constructor(context: Context) : this(context,null)
    constructor(context: Context, attrs: AttributeSet?) : this(context, attrs,0)
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    ){
        View.inflate(context, R.layout.view_seemore,this)
        initListener()
    }
    private fun initListener() {
        view_seemore_tv_seemore.setOnClickListener {
            if(mIsShowAll){
                view_seemore_tvcontent.maxLines = 2
                view_seemore_tv_seemore.text = "查看更多"
            }else{
                view_seemore_tvcontent.maxLines = 20
                view_seemore_tv_seemore.text = "收起"
            }
            mIsShowAll = !mIsShowAll
        }
        //attachedToWindow之后执行操作
        post {
            Log.e("测试","OnLayout${view_seemore_tvlinecount.lineCount}")
            if(view_seemore_tvlinecount.lineCount>2){
                view_seemore_tv_seemore.visibility = View.VISIBLE
            }else{
                view_seemore_tv_seemore.visibility = View.GONE
            }
        }

    }
    /**
     * 设置文字
     */
    fun setText(text:String){
        view_seemore_tvcontent.text = text
        view_seemore_tvlinecount.text = text
        view_seemore_tv_seemore.text = "查看更多"
        view_seemore_tvcontent.maxLines = 2
        mIsShowAll = false
        if(view_seemore_tvlinecount.lineCount>2){
            view_seemore_tv_seemore.visibility = View.VISIBLE
        }else{
            view_seemore_tv_seemore.visibility = View.GONE
        }
    }
}