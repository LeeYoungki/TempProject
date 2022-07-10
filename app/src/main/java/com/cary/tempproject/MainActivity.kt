package com.cary.tempproject

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.cary.tempproject.databinding.ActivityMainBinding
import com.cary.tempproject.databinding.ItemBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.apply {
            // 뷰모델 객체를 바인딩시켜준다. 상황에 따라선,
            // 뷰모델 프로바이더 등을 이용해 바인딩 시켜줄 수 도 있다.
            // 여기선 예제이므로, 유저리스트만 갖고있는 클래스로 예시를 들겠다.
            vm = ViewModel()

            // RecyclerView 세팅
            val layoutManager = LinearLayoutManager(this@MainActivity) //레이아웃 매니저 설정
            layoutManager.orientation = LinearLayoutManager.VERTICAL
            rv.layoutManager = layoutManager
        }
    }

    class UserAdapter :
        RecyclerView.Adapter<UserAdapter.ViewHolder>() {
        var userList: List<User>? = listOf()

        override fun onCreateViewHolder(
            parent: ViewGroup,
            viewType: Int
        ): ViewHolder {
            val binding =
                ItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            return ViewHolder(binding)
        }

        override fun onBindViewHolder(holder: ViewHolder, i: Int) {
            holder.bind(userList?.get(i))
        }

        // 생성된 뷰 홀더에 값 지정
        class ViewHolder(private val binding: ItemBinding) :
            RecyclerView.ViewHolder(binding.root) {
            fun bind(user: User?) {
                binding.user = user
            }
        }

        override fun getItemCount(): Int = userList?.size!!

        // 깜박임 방지
        override fun getItemId(position: Int): Long = position.toLong()
    }
}