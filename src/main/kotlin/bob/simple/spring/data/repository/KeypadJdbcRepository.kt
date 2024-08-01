package bob.simple.spring.data.repository

import bob.simple.spring.domain.model.Keypad
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations
import org.springframework.context.annotation.Primary
import org.springframework.stereotype.Repository

@Repository("keypadJdbcRepository")
@Primary
class KeypadJdbcRepository(
    private val jdbcOperations: NamedParameterJdbcOperations
) : KeypadRepository {
    override fun insert(keypad: Keypad) {
        jdbcOperations.update(
            "insert into keypad (id, keys, current_input) values (:id, :keys, :currentInput)",
            MapSqlParameterSource()
                .addValue("id", keypad.id)
                .addValue("keys", keypad.keys.joinToString(","))
                .addValue("currentInput", keypad.currentInput)
        )
    }

    override fun selectBy(id: String): Keypad {
        return jdbcOperations.queryForObject(
            "select * from keypad where id = :id",
            mapOf("id" to id)
        ) { rs, _ ->
            Keypad(
                id = rs.getString("id"),
                keys = rs.getString("keys").split(","),
                currentInput = rs.getString("current_input")
            )
        }!!
    }

    override fun update(keypad: Keypad) {
        jdbcOperations.update(
            "update keypad set keys = :keys, current_input = :currentInput where id = :id",
            MapSqlParameterSource()
                .addValue("keys", keypad.keys.joinToString(","))
                .addValue("currentInput", keypad.currentInput)
                .addValue("id", keypad.id)
        )
    }
}
