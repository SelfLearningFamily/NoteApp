package com.zsols.notejet

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.zsols.notejet.screen.NoteScreen
import com.zsols.notejet.screen.NoteViewModel
import com.zsols.notejet.ui.theme.NoteJetTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NoteJetTheme {
                // A surface container using the 'background' color from the theme
                val noteViewModel = viewModel<NoteViewModel>()
//                val noteViewModel: NoteViewModel by viewModels()
                NoteApp(noteViewModel = noteViewModel)
            }
        }
    }
}

@Composable
fun NoteApp(noteViewModel: NoteViewModel = viewModel()){

    val notesList = noteViewModel.getAllNotes()
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colors.background
    ) {
/*        val notes = remember {
            mutableStateListOf<NoteData>()
        }*/
        NoteScreen(notes = notesList.collectAsState().value ,
            onAddNote = { noteViewModel.addNote(it)},
            onRemoveNote = { noteViewModel.removeNote(it) })
    }
}



@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    NoteJetTheme {
        NoteApp()
    }
}