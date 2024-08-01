package bob.simple.spring.presentation.controller

import bob.simple.spring.domain.model.Keypad
import bob.simple.spring.domain.service.KeypadService
import org.springframework.web.bind.annotation.*

@RequestMapping("/keypads")
@RestController
class KeypadController(
    private val keypadService: KeypadService
) {
    @GetMapping("/{id}")
    fun getKeypad(
        @PathVariable id: String
    ): Keypad {
        return keypadService.getKeypad(id)
    }

    @PostMapping
    fun postKeypad(
        @RequestBody keypad: Keypad
    ) {
        keypadService.createKeypad(keypad)
    }

    @PatchMapping("/{id}/input")
    fun updateInput(
        @PathVariable id: String,
        @RequestParam input: String
    ) {
        keypadService.updateInput(id, input)
    }
}
