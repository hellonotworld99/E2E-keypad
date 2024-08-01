import bob.simple.spring.domain.service.CarService
import bob.simple.spring.presentation.dto.CarResponseDto
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RequestMapping("/test")
@RestController
class TestController (
    private val carservice: CarService,
){
    @GetMapping("/{id}")
    fun getCar(
        @PathVariable id: String
    ): CarResponseDto {
        return carservice.getCar(id)
    }
}