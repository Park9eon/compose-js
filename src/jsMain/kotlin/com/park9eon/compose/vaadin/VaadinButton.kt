package com.park9eon.compose.vaadin

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import kotlinext.js.require
import org.jetbrains.compose.web.dom.TagElement
import org.jetbrains.compose.web.dom.Text
import org.w3c.dom.HTMLButtonElement

@Composable
fun VaadinButton(
    text: String,
    theme: String? = null,
    onClick: () -> Unit
) {
    remember { require("@vaadin/button") }

    TagElement<HTMLButtonElement>("vaadin-button", {
        if (theme != null) {
            attr("theme", theme)
        }

        onClick {
            onClick()
        }
    }) {
        Text(text)
    }
}
