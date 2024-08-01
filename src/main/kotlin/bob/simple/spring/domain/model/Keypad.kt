package bob.simple.spring.domain.model

data class Keypad(
    val id: String,
    var keys: List<String>, // 키패드의 버튼 목록
    var currentInput: String // 현재 입력된 값
)
