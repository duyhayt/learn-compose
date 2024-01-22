package com.example.countermvvm.counter

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.countermvvm.counter.CounterRepository

class CounterViewModel() : ViewModel() {
    private val repository: CounterRepository = CounterRepository();
    private val _count = mutableStateOf(repository.getCount().count)

    val count: MutableState<Int> = _count;

    fun increment() {
        repository.increment();
        _count.value = repository.getCount().count
    }

    fun decrement() {
        repository.decrement();
        _count.value = repository.getCount().count
    }
}