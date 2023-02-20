package com.zsols.notejet.screen

import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Notifications
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.zsols.notejet.R
import com.zsols.notejet.component.NoteAppInputField
import com.zsols.notejet.component.NoteButton
import com.zsols.notejet.data.NoteDataSource
import com.zsols.notejet.model.UserNote
import java.time.format.DateTimeFormatter

@Composable
fun NoteScreen(
    notes: List<UserNote>,
    onAddNote: (UserNote) -> Unit,
    onRemoveNote: (UserNote) -> Unit,
) {
    var titleTxt by remember {
        mutableStateOf("")
    }
    var desc by remember {
        mutableStateOf("")
    }
    val context = LocalContext.current
    Column(modifier = Modifier.padding(6.dp)) {
        TopAppBar(
            title = {
                Text(text = stringResource(id = R.string.app_name))
            },
            actions = {
                Icon(
                    imageVector = Icons.Rounded.Notifications,
                    contentDescription = "notification"
                )
            },
            backgroundColor = Color(0XFFDADFE3)
        )
        Column(
            modifier = Modifier
                .fillMaxWidth(),
            // .background(Color.Red),

            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            NoteAppInputField(
                // modifier = Modifier.fillMaxWidth(),
                text = titleTxt,
                label = "Title",
                onTextChange = { inputString ->
                    if (inputString.all { char ->
                            char.isLetter() || char.isWhitespace()
                        }) titleTxt = inputString
                })
            NoteAppInputField(
                //   modifier = Modifier.fillMaxWidth(),
                text = desc,
                label = "Add a note",
                maxLine = 3,
                onTextChange = { inputString ->
                    if (inputString.all { char ->
                            char.isLetter() || char.isWhitespace()
                        }) desc = inputString
                })

            NoteButton(text = "Save", onClick = {
                if (titleTxt.isNotEmpty() && desc.isNotEmpty()) {
                    onAddNote(UserNote(title = titleTxt, desc = desc))
                    titleTxt = ""
                    desc = ""
                    Toast.makeText(context, "Note Added", Toast.LENGTH_SHORT).show()
                }
            })
        }

        Divider(modifier = Modifier.padding(10.dp))
        LazyColumn() {
            items(notes) { note ->
                NoteRow(note = note, onNodeCLick = {onRemoveNote(note)})
            }
        }
    }
}

@Composable
 fun NoteRow(
    modifier: Modifier = Modifier,
    note: UserNote,
    onNodeCLick: (UserNote) -> Unit
) {
    Surface(
        modifier = modifier
            .padding(4.dp)
            .clip(RoundedCornerShape(topEnd = 33.dp, bottomStart = 33.dp))
            .fillMaxWidth(),
        color = Color(0xFFDFE6EB),
        elevation = 6.dp
    ) {
        Column(
            modifier = modifier
                .clickable { onNodeCLick(note) }
                .padding(horizontal = 14.dp, vertical = 6.dp),
            horizontalAlignment = Alignment.Start
        ) {
            Text(
                text = note.title,
                style = MaterialTheme.typography.subtitle2
            )
            Text(
                text = note.desc,
                style = MaterialTheme.typography.subtitle1
            )
            Text(
                text = note.entryDate!!.format(DateTimeFormatter.ofPattern("EEE ,d MMM hh:mm:ss a")),
                style = MaterialTheme.typography.caption
            )
        }
    }
}

@Preview(
    showBackground = true
)
@Composable
fun NoteScreenPreview() {
    NoteScreen(notes = NoteDataSource().loadNotes(), onAddNote = {}, onRemoveNote = {})
}