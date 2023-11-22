package kr.ac.kumoh.ce.s20180904.s23w12lazylist

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kr.ac.kumoh.ce.s20180904.s23w12lazylist.ui.theme.S23W12LazyListTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainScreen()
        }
    }
}

@Composable
fun MainScreen(){
    S23W12LazyListTheme {
        // A surface container using the 'background' color from the theme
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            MyList()
        }
    }
}

@Composable
fun TitleText(title: String){
    Text(title, fontSize = 30.sp)
}

@Composable
fun SingerText(title: String){
    Text(title, fontSize = 20.sp)
}

@Composable
fun SongItem(index: Int){
    Column(modifier = Modifier
        .fillMaxWidth()
        .background(Color(0xffffffcc))
        .padding(16.dp)//패딩과 백그라운드컬러 순서에 따라 결과 바뀜
    ) {
        TitleText(title = "노래 $index")
        SingerText("이 노래를 부른 가수는 $index 입니다.")
    }
}

@Composable
fun MyList(){
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(8.dp),
        contentPadding = PaddingValues(8.dp)
        ){
        items(50){SongItem(it)}
    }
}