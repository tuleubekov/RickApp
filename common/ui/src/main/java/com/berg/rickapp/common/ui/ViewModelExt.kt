package com.berg.rickapp.common.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.launch

fun <T> ViewModel.sendEvent(channel: Channel<T>, event: T) {
    viewModelScope.launch { channel.send(event) }
}

fun <T> Channel<T>.send(vm: ViewModel, event: T) {
    vm.viewModelScope.launch { send(event) }
}