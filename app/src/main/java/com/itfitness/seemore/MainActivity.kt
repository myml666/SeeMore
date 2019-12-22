package com.itfitness.seemore

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.itfitness.seemore.widget.SeeMoreView
import kotlinx.android.synthetic.main.activity_main.*
import java.util.ArrayList

class MainActivity : AppCompatActivity() {
    private var mAdapter:BaseQuickAdapter<String,BaseViewHolder>? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initAdapter()
    }

    private fun initAdapter() {
        val datas = ArrayList<String>()
        for (i in 0..20){
            if(i%2==0){
                datas.add("就杀谁就嗲沙嗲世界顶级撒娇的")
            }else{
                datas.add("家居打卡时间多久啊速度就撒娇嗲萨科的卡仕达酱卡视角登记卡减速电机阿" +
                        "加十九大精神的就撒娇嗲声就嗲沙嗲世界顶级撒娇的吉萨" +
                        "撒到拉萨来打卡死了大佬开始到拉萨开了打卡" +
                        "撒旦；拉伸；的；阿瑟；大；" +
                        "撒旦撒旦撒大声道撒" +
                        "阿斯顿撒打算打算加莎的阿萨德就撒娇嗲十九大精神打击撒娇的啊数据库的金卡世界顶级阿萨德")
            }
        }
        if(mAdapter==null){
            mAdapter = object : BaseQuickAdapter<String,BaseViewHolder>(R.layout.item_seemoretest,datas){
                override fun convert(helper: BaseViewHolder?, item: String?) {
                    val seeMore = helper!!.getView<SeeMoreView>(R.id.seemore)
                    seeMore.setText(item!!)
                }
            }
            rv.layoutManager = LinearLayoutManager(this)
            rv.adapter = mAdapter
        }
    }
}
