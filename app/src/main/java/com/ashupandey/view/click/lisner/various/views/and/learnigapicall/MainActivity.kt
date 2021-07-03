package com.ashupandey.view.click.lisner.various.views.and.learnigapicall

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.*
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

const val BASE_URL = "https://reqres.in/api/"
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        runBlocking {
            val def = async { getMyData() }
            def.await()
        }
    }

    private suspend fun getMyData() {
        var retrofitBilder: Retrofit? = null

        withContext(Dispatchers.Default) {
            retrofitBilder = Retrofit.Builder()
                    .addConverterFactory(GsonConverterFactory.create())
                    .baseUrl(BASE_URL)
                    .build()
        }


//the comment that i am puting is very important for the progress
        val api = retrofitBilder?.create(ApiInterface::class.java)
        val list:MutableList<Data> = mutableListOf()

        coroutineScope {
          val diff = listOf(
                  async { callApi(api,list,2) },
                  async { callApi(api,list,2) },
                  async { callApi(api,list,1) },

          )
            diff.awaitAll()
        }


        retrofitRecycler.adapter = CustomAdapter(list)
        retrofitRecycler.layoutManager = LinearLayoutManager(this@MainActivity)
    }


    suspend fun callApi( api: ApiInterface?,list:MutableList<Data>,p:Int){
        var list1: List<Data>? = null
        list1 = api?.getData(p)?.body()?.data!!
        list.addAll(list1!!)
    }



}




