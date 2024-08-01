package bob.simple.spring.data.repository

import bob.simple.spring.domain.model.Keypad

interface KeypadRepository {
    fun insert(keypad: Keypad)
    fun selectBy(id: String): Keypad
    fun update(keypad: Keypad)
}
