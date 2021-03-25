package com.example.viewpager2

import android.app.SearchManager
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.EditText
import android.widget.SearchView
import androidx.core.content.ContextCompat
import androidx.core.view.MenuItemCompat
import androidx.databinding.DataBindingUtil
import com.example.viewpager2.databinding.ActivityMainBinding
import com.example.viewpager2.databinding.ActivitySearchBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.create

class SearchActivity : AppCompatActivity() {
    private var datas = mutableListOf<ResponseSearchVideo.Documents>()
    private lateinit var binding: ActivitySearchBinding
    private lateinit var adapter: SearchItemAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySearchBinding.inflate(layoutInflater)
        setContentView(binding.root)
        getSearchResult("hello")
        initRecyclerView()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
       menuInflater.inflate(R.menu.menu, menu)

        val searchItem = menu.findItem(R.id.action_search)
        val searchView = searchItem.actionView as SearchView
        searchView.queryHint = "search video"
        searchView.setOnQueryTextListener( object :SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(p0: String?): Boolean {
                getSearchResult(p0!!)

                return false
            }

            override fun onQueryTextChange(p0: String?): Boolean {
                getSearchResult(p0!!)
                return false
            }
        })
        return true
    }

    private fun initRecyclerView() {
        adapter = SearchItemAdapter(this)
        binding.recyclerviewSearchList.adapter = adapter
    }

    fun getSearchResult(query: String) {
        val token = "KakaoAK 16e0712b975f711e3445351c19d98c91"
      val retrofit = RetrofitService.getInstance().create(KaKaoRetrofit::class.java)
        retrofit.getVideoResult(
            token,
            query
        ).enqueue(object : Callback<ResponseSearchVideo> {
            override fun onResponse(
                call: Call<ResponseSearchVideo>,
                response: Response<ResponseSearchVideo>
            ) {
                if (response.isSuccessful){
                    Log.d("success", response.body().toString())
                    datas = response.body()!!.documents
                    adapter.datas = datas
                    adapter.notifyDataSetChanged()
                }
            }

            override fun onFailure(call: Call<ResponseSearchVideo>, t: Throwable) {
                Log.e("error", "$t")
            }
        })
    }
}