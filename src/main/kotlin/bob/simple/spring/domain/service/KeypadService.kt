package bob.simple.spring.domain.service

import bob.simple.spring.domain.model.Keypad
import bob.simple.spring.data.repository.KeypadRepository
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.stereotype.Service

@Service
class KeypadService(
    @Qualifier("keypadJdbcRepository") private val keypadRepository: KeypadRepository
) {
    fun getKeypad(id: String): Keypad {
        return keypadRepository.selectBy(id)
    }

    fun createKeypad(keypad: Keypad) {
        keypadRepository.insert(keypad)
    }

    fun updateInput(id: String, input: String) {
        val keypad = keypadRepository.selectBy(id)
        keypad.currentInput = input
        keypadRepository.update(keypad)
    }
}
