package com.park9eon.compose

import androidx.compose.runtime.*
import com.park9eon.compose.material.MaterialButton
import com.park9eon.compose.router.Link
import com.park9eon.compose.router.Router
import com.park9eon.compose.vaadin.VaadinButton
import com.park9eon.compose.vaadin.VaadinDateTimePicker
import com.park9eon.compose.vaadin.VaadinDialog
import org.jetbrains.compose.web.dom.Button
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Text
import org.jetbrains.compose.web.renderComposableInBody

@Composable
fun Navigation() {
    Div {
        Link("/user") {
            Text("/user")
        }
        Link("/user/kim") {
            Text("/user/kim")
        }
        Link("/about") {
            Text("/user")
        }
        Link("/") {
            Text("/home")
        }
    }
}

fun main() {
    val message = "Hello, Kotlin World!"

    console.log(message)

    renderComposableInBody {
        var count: Int by remember { mutableStateOf(0) }
        var opened: Boolean by remember { mutableStateOf(false) }

        Button(attrs = {
            onClick {
                count += 1
                opened = !opened
            }
        }) {
            Text("Open! $count $opened")
        }

        VaadinDialog(opened, draggable = false, theme = "no-padding", onOpened =  {
//            opened = it
        }) {
            Div {
                P {
                    Text("$count")
                }
                Button(attrs = {
                    onClick {
                        count += 1
                    }
                }) {
                    Text("Click Me!")
                }
            }
        }
        VaadinButton("Button") {

        }
        VaadinButton("button2", theme = "primary") {

        }
        VaadinDateTimePicker()

        MaterialButton()

        Router {
            Route(path = "/user") {
                Navigation()
                Div {
                    Text("User")
                }
            }
            Route(path = "/user/:username") {
                val params = it.params

                Navigation()
                Div {
                    Text("User : ${params["username"]}")
                }
            }
            Route(path = "/about") {
                Navigation()

                Div {
                    Text("About")
                }
            }
            Route(path = "/") {
                Navigation()

                Div {
                    Text("Hello")
                }
            }
        }
    }
}
