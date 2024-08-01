package bob.simple.spring.data.repository

import bob.simple.spring.domain.model.Keypad
import org.springframework.stereotype.Repository

@Repository
class KeypadRedisRepository : KeypadRepository {
    override fun insert(keypad: Keypad) {
        // Redis에 데이터 저장 로직 구현
    }

    override fun selectBy(id: String): Keypad {
        // Redis에서 데이터 조회 로직 구현
        return Keypad(id, listOf("1", "2", "3", "4", "5", "6", "7", "8", "9", "0"), "")
    }

    override fun update(keypad: Keypad) {
        // Redis에서 데이터 업데이트 로직 구현
    }
}
