package app.el_even.fdj.presentation.league_list

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.PopupProperties
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController

@Composable
fun LeagueListScreen(
    navController: NavController,
    viewModel: LeagueListViewModel = hiltViewModel()
) {
    val state = viewModel.state.value
    val leagues = state.leagues.map { it.name }
    val text = remember { mutableStateOf("") }
    TextFieldAutocomplete(list = leagues) {
        text.value = it
    }
}

@Composable
fun TextFieldAutocomplete(
    list: List<String>,
    setValue: (String) -> Unit
) {

    var text = remember { mutableStateOf("") }  // text in textfield
    var expanded = remember { mutableStateOf(false) } // for dropdownmenu
    var modifier: Modifier //
    var dropList = remember { mutableStateOf(listOf("")) }
    dropList.value = list.filter { it.contains(text.value, ignoreCase = true) }

    Card(
        Modifier
            .padding(10.dp)
            .fillMaxWidth(), elevation = 10.dp, border = BorderStroke(1.dp, Color.LightGray)
    ) {
        Column(
            Modifier
                .fillMaxWidth()
                .padding(15.dp), horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(modifier = Modifier.wrapContentSize(Alignment.TopStart)) {
                TextField(value = text.value,
                    modifier = Modifier
                        .fillMaxWidth(),
                    onValueChange = {
                        text.value = it

                    })
                if (dropList.value.isNotEmpty() && text.value != "") {
                    modifier = if (dropList.value.size > 7) {
                        Modifier.height(300.dp)
                    } else {
                        Modifier
                    }

                    expanded.value = !(dropList.value.size == 1 && dropList.value[0] == text.value)

                    DropdownMenu(
                        expanded = expanded.value,
                        onDismissRequest = { expanded.value = false },
                        properties = PopupProperties(focusable = false),
                        modifier = modifier.fillMaxWidth()

                    ) {
                        dropList.value.forEach {
                            DropdownMenuItem(onClick = {
                                text.value = it
                                setValue(it)
                                dropList.value = emptyList()
                                expanded.value = false

                            }) {
                                Text(text = it)
                            }
                        }
                    }
                } else {
                    expanded.value = false
                }
            }
        }
    }
}