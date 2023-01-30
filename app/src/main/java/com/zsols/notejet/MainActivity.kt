package com.zsols.notejet

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.zsols.notejet.data.NoteDataSource
import com.zsols.notejet.model.NoteData
import com.zsols.notejet.screen.NoteScreen
import com.zsols.notejet.screen.NoteViewModel
import com.zsols.notejet.ui.theme.NoteJetTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NoteJetTheme {
                // A surface container using the 'background' color from the theme
                NoteApp()
            }
        }
    }
}

@Composable
fun NoteApp(noteViewModel: NoteViewModel = viewModel()){
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colors.background
    ) {
        val notes = remember {
            mutableStateListOf<NoteData>()
        }
        NoteScreen(notes = notes , onAddNote = {
            notes.add(it)}, onRemoveNote = {
                notes.remove(it)
        })
    }
}



@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    NoteJetTheme {
        NoteApp()
    }
}